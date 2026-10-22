package com.android.server.people.data;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.Person;
import android.app.people.ConversationChannel;
import android.app.people.ConversationStatus;
import android.app.prediction.AppTarget;
import android.app.prediction.AppTargetEvent;
import android.app.usage.UsageEvents;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.LauncherApps;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.pm.ShortcutServiceInternal;
import android.content.pm.UserInfo;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.telecom.TelecomManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import com.android.internal.content.PackageMonitor;
import com.android.internal.os.BackgroundThread;
import com.android.internal.telephony.SmsApplication;
import com.android.server.LocalServices;
import com.android.server.notification.NotificationManagerInternal;
import com.android.server.notification.ShortcutHelper;
import com.android.server.people.PeopleService;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/* JADX INFO: loaded from: classes2.dex */
public class DataManager {
    private static final boolean DEBUG = false;
    static final int MAX_CACHED_RECENT_SHORTCUTS = 30;
    private static final long QUERY_EVENTS_MAX_AGE_MS = 300000;
    private static final long RECENT_NOTIFICATIONS_MAX_AGE_MS = 864000000;
    private static final String TAG = "DataManager";
    private static final long USAGE_STATS_QUERY_INTERVAL_SEC = 120;
    private final SparseArray<BroadcastReceiver> mBroadcastReceivers;
    private ContentObserver mCallLogContentObserver;
    private final SparseArray<ContentObserver> mContactsContentObservers;
    private final Context mContext;
    private final List<PeopleService.ConversationsListener> mConversationsListeners;
    private final Handler mHandler;
    private final Injector mInjector;
    private final Object mLock;
    private ContentObserver mMmsSmsContentObserver;
    private final SparseArray<NotificationListener> mNotificationListeners;
    private NotificationManagerInternal mNotificationManagerInternal;
    private PackageManagerInternal mPackageManagerInternal;
    private final SparseArray<PackageMonitor> mPackageMonitors;
    private final ScheduledExecutorService mScheduledExecutor;
    private ShortcutServiceInternal mShortcutServiceInternal;
    private ConversationStatusExpirationBroadcastReceiver mStatusExpReceiver;
    private final SparseArray<ScheduledFuture<?>> mUsageStatsQueryFutures;
    private final SparseArray<UserData> mUserDataArray;
    private UserManager mUserManager;

    private class CallLogContentObserver extends ContentObserver implements BiConsumer<String, Event> {
        private final CallLogQueryHelper mCallLogQueryHelper;
        private long mLastCallTimestamp;
        final /* synthetic */ DataManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$A-XVhvCIW8ISB4inr1p1K7MaffE, reason: not valid java name */
        public static /* synthetic */ void m6538$r8$lambda$AXVhvCIW8ISB4inr1p1K7MaffE(String r0, Event r1, UserData r2) {
            lambda$accept$0(r0, r1, r2);
        }

        /* synthetic */ CallLogContentObserver(DataManager r1, Handler r2, DataManagerIA r3) {
            this(r1, r2);
        }

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(String r1, Event r2) {
            accept2(r1, r2);
        }

        private CallLogContentObserver(DataManager r5, Handler handler) {
            this.this$0 = r5;
            super(handler);
            this.mCallLogQueryHelper = DataManager.m6530$$Nest$fgetmInjector(r5).createCallLogQueryHelper(DataManager.m6529$$Nest$fgetmContext(r5), this);
            this.mLastCallTimestamp = System.currentTimeMillis() - 300000;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (this.mCallLogQueryHelper.querySince(this.mLastCallTimestamp) == false) goto L6;
            this.mLastCallTimestamp = this.mCallLogQueryHelper.getLastCallTimestamp();
            return;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(final String phoneNumber, final Event event) {
            DataManager.m6533$$Nest$mforAllUnlockedUsers(this.this$0, new DataManager$CallLogContentObserver$$ExternalSyntheticLambda0(phoneNumber, event));
        }

        private static /* synthetic */ void lambda$accept$0(String phoneNumber, Event event, UserData userData) {
            PackageData defaultDialer = userData.getDefaultDialer();
            if (defaultDialer != null) goto L5;
            return;
        L5:
            ConversationStore conversationStore = defaultDialer.getConversationStore();
            if (conversationStore.getConversationByPhoneNumber(phoneNumber) != null) goto L8;
            return;
        L8:
            EventStore eventStore = defaultDialer.getEventStore();
            eventStore.getOrCreateEventHistory(2, phoneNumber).addEvent(event);
        }
    }

    private class ContactsContentObserver extends ContentObserver {
        private long mLastUpdatedTimestamp;
        final /* synthetic */ DataManager this$0;

        private class ConversationSelector {
            private ConversationInfo mConversationInfo;
            private ConversationStore mConversationStore;
            private String mPackageName;

            /* JADX INFO: renamed from: -$$Nest$fgetmConversationInfo, reason: not valid java name */
            static /* bridge */ /* synthetic */ ConversationInfo m6539$$Nest$fgetmConversationInfo(ConversationSelector r0) {
                return r0.mConversationInfo;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmConversationStore, reason: not valid java name */
            static /* bridge */ /* synthetic */ ConversationStore m6540$$Nest$fgetmConversationStore(ConversationSelector r0) {
                return r0.mConversationStore;
            }

            /* JADX INFO: renamed from: -$$Nest$fgetmPackageName, reason: not valid java name */
            static /* bridge */ /* synthetic */ String m6541$$Nest$fgetmPackageName(ConversationSelector r0) {
                return r0.mPackageName;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmConversationInfo, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m6542$$Nest$fputmConversationInfo(ConversationSelector r0, ConversationInfo r1) {
                r0.mConversationInfo = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmConversationStore, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m6543$$Nest$fputmConversationStore(ConversationSelector r0, ConversationStore r1) {
                r0.mConversationStore = r1;
            }

            /* JADX INFO: renamed from: -$$Nest$fputmPackageName, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m6544$$Nest$fputmPackageName(ConversationSelector r0, String r1) {
                r0.mPackageName = r1;
            }

            /* synthetic */ ConversationSelector(ContactsContentObserver r1, DataManagerIA r2) {
                this(r1);
            }

            private ConversationSelector(ContactsContentObserver r1) {
                this.mConversationStore = null;
                this.mConversationInfo = null;
                this.mPackageName = null;
            }
        }

        public static /* synthetic */ void $r8$lambda$AZngOIwnfGkCFeQQDy9lYe3gaGg(Uri r0, ConversationSelector r1, PackageData r2) {
            lambda$onChange$0(r0, r1, r2);
        }

        /* synthetic */ ContactsContentObserver(DataManager r1, Handler r2, DataManagerIA r3) {
            this(r1, r2);
        }

        private ContactsContentObserver(DataManager r3, Handler handler) {
            this.this$0 = r3;
            super(handler);
            this.mLastUpdatedTimestamp = System.currentTimeMillis();
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri, int userId) {
            ContactsQueryHelper helper = DataManager.m6530$$Nest$fgetmInjector(this.this$0).createContactsQueryHelper(DataManager.m6529$$Nest$fgetmContext(this.this$0));
            if (helper.querySince(this.mLastUpdatedTimestamp) == true) goto L5;
            return;
        L5:
            final Uri contactUri = helper.getContactUri();
            final ConversationSelector conversationSelector = new ConversationSelector(this, null);
            UserData userData = DataManager.m6535$$Nest$mgetUnlockedUserData(this.this$0, userId);
            if (userData != null) goto L8;
            return;
        L8:
            userData.forAllPackages(new DataManager$ContactsContentObserver$$ExternalSyntheticLambda0(contactUri, conversationSelector));
            if (ConversationSelector.m6539$$Nest$fgetmConversationInfo(conversationSelector) != null) goto L11;
            return;
        L11:
            ConversationInfo.Builder builder = new ConversationInfo.Builder(ConversationSelector.m6539$$Nest$fgetmConversationInfo(conversationSelector));
            builder.setContactStarred(helper.isStarred());
            builder.setContactPhoneNumber(helper.getPhoneNumber());
            this.this$0.updateConversationStoreThenNotifyListeners(ConversationSelector.m6540$$Nest$fgetmConversationStore(conversationSelector), builder.build(), ConversationSelector.m6541$$Nest$fgetmPackageName(conversationSelector), userId);
            this.mLastUpdatedTimestamp = helper.getLastUpdatedTimestamp();
        }

        private static /* synthetic */ void lambda$onChange$0(Uri contactUri, ConversationSelector conversationSelector, PackageData packageData) {
            ConversationInfo ci = packageData.getConversationStore().getConversationByContactUri(contactUri);
            if (ci == null) goto L6;
            ConversationSelector.m6543$$Nest$fputmConversationStore(conversationSelector, packageData.getConversationStore());
            ConversationSelector.m6542$$Nest$fputmConversationInfo(conversationSelector, ci);
            ConversationSelector.m6544$$Nest$fputmPackageName(conversationSelector, packageData.getPackageName());
            return;
        }
    }

    static class Injector {
        Injector() {
        }

        ScheduledExecutorService createScheduledExecutor() {
            return Executors.newSingleThreadScheduledExecutor();
        }

        Executor getBackgroundExecutor() {
            return BackgroundThread.getExecutor();
        }

        ContactsQueryHelper createContactsQueryHelper(Context context) {
            return new ContactsQueryHelper(context);
        }

        CallLogQueryHelper createCallLogQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
            return new CallLogQueryHelper(context, eventConsumer);
        }

        MmsQueryHelper createMmsQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
            return new MmsQueryHelper(context, eventConsumer);
        }

        SmsQueryHelper createSmsQueryHelper(Context context, BiConsumer<String, Event> eventConsumer) {
            return new SmsQueryHelper(context, eventConsumer);
        }

        UsageStatsQueryHelper createUsageStatsQueryHelper(int userId, Function<String, PackageData> packageDataGetter, UsageStatsQueryHelper.EventListener eventListener) {
            return new UsageStatsQueryHelper(userId, packageDataGetter, eventListener);
        }
    }

    private class MmsSmsContentObserver extends ContentObserver implements BiConsumer<String, Event> {
        private long mLastMmsTimestamp;
        private long mLastSmsTimestamp;
        private final MmsQueryHelper mMmsQueryHelper;
        private final SmsQueryHelper mSmsQueryHelper;
        final /* synthetic */ DataManager this$0;

        public static /* synthetic */ void $r8$lambda$gPCsaa6UyBV5WGttQd4CMd8gHVk(String r0, Event r1, UserData r2) {
            lambda$accept$0(r0, r1, r2);
        }

        /* synthetic */ MmsSmsContentObserver(DataManager r1, Handler r2, DataManagerIA r3) {
            this(r1, r2);
        }

        @Override // java.util.function.BiConsumer
        public /* bridge */ /* synthetic */ void accept(String r1, Event r2) {
            accept2(r1, r2);
        }

        private MmsSmsContentObserver(DataManager r5, Handler handler) {
            this.this$0 = r5;
            super(handler);
            this.mMmsQueryHelper = DataManager.m6530$$Nest$fgetmInjector(r5).createMmsQueryHelper(DataManager.m6529$$Nest$fgetmContext(r5), this);
            this.mSmsQueryHelper = DataManager.m6530$$Nest$fgetmInjector(r5).createSmsQueryHelper(DataManager.m6529$$Nest$fgetmContext(r5), this);
            long r0 = System.currentTimeMillis() - 300000;
            this.mLastMmsTimestamp = r0;
            this.mLastSmsTimestamp = r0;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            if (this.mMmsQueryHelper.querySince(this.mLastMmsTimestamp) == false) goto L6;
            this.mLastMmsTimestamp = this.mMmsQueryHelper.getLastMessageTimestamp();
        L6:
            if (this.mSmsQueryHelper.querySince(this.mLastSmsTimestamp) == false) goto L9;
            this.mLastSmsTimestamp = this.mSmsQueryHelper.getLastMessageTimestamp();
            return;
        }

        /* JADX INFO: renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(final String phoneNumber, final Event event) {
            DataManager.m6533$$Nest$mforAllUnlockedUsers(this.this$0, new DataManager$MmsSmsContentObserver$$ExternalSyntheticLambda0(phoneNumber, event));
        }

        private static /* synthetic */ void lambda$accept$0(String phoneNumber, Event event, UserData userData) {
            PackageData defaultSmsApp = userData.getDefaultSmsApp();
            if (defaultSmsApp != null) goto L5;
            return;
        L5:
            ConversationStore conversationStore = defaultSmsApp.getConversationStore();
            if (conversationStore.getConversationByPhoneNumber(phoneNumber) != null) goto L8;
            return;
        L8:
            EventStore eventStore = defaultSmsApp.getEventStore();
            eventStore.getOrCreateEventHistory(3, phoneNumber).addEvent(event);
        }
    }

    private class NotificationListener extends NotificationListenerService {
        private final Map<Pair<String, String>, Set<String>> mActiveNotifKeys;
        private final int mUserId;
        final /* synthetic */ DataManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$3G6nixFPnZ81J-cMKuokQBY2Mcs, reason: not valid java name */
        public static /* synthetic */ Set m6545$r8$lambda$3G6nixFPnZ81JcMKuokQBY2Mcs(Pair r0) {
            return lambda$onNotificationPosted$0(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$7D5AeDCRS6ZN41YsjeXOE-bx8Ns, reason: not valid java name */
        public static /* synthetic */ void m6546$r8$lambda$7D5AeDCRS6ZN41YsjeXOEbx8Ns(NotificationListener r0, StatusBarNotification r1, String r2, ConversationInfo r3) {
            r0.lambda$onNotificationPosted$1(r1, r2, r3);
        }

        public static /* synthetic */ void $r8$lambda$V7k_renfdny63TPT3C4if1bQJ3g(NotificationListener r0, StatusBarNotification r1, String r2, ConversationInfo r3) {
            r0.lambda$onNotificationRemoved$3(r1, r2, r3);
        }

        public static /* synthetic */ Set $r8$lambda$psScrNjnnxNB2lVHyJhLVsTQzBU(Pair r0) {
            return lambda$onNotificationRemoved$2(r0);
        }

        /* synthetic */ NotificationListener(DataManager r1, int r2, DataManagerIA r3) {
            this(r1, r2);
        }

        private NotificationListener(DataManager r1, int userId) {
            this.this$0 = r1;
            this.mActiveNotifKeys = new ArrayMap();
            this.mUserId = userId;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationPosted(final StatusBarNotification sbn, NotificationListenerService.RankingMap map) {
            if (sbn.getUser().getIdentifier() == this.mUserId) goto L5;
            return;
        L5:
            final String shortcutId = sbn.getNotification().getShortcutId();
            PackageData packageData = DataManager.m6534$$Nest$mgetPackageIfConversationExists(this.this$0, sbn, new DataManager$NotificationListener$$ExternalSyntheticLambda3(this, sbn, shortcutId));
            if (packageData == null) goto L16;
            NotificationListenerService.Ranking rank = new NotificationListenerService.Ranking();
            map.getRanking(sbn.getKey(), rank);
            ConversationInfo conversationInfo = packageData.getConversationInfo(shortcutId);
            if (conversationInfo != null) goto L10;
            return;
        L10:
            ConversationInfo.Builder updated = new ConversationInfo.Builder(conversationInfo).setLastEventTimestamp(sbn.getPostTime()).setNotificationChannelId(rank.getChannel().getId());
            if (TextUtils.isEmpty(rank.getChannel().getParentChannelId()) == true) goto L13;
            updated.setParentNotificationChannelId(rank.getChannel().getParentChannelId());
        L14:
            packageData.getConversationStore().addOrUpdate(updated.build());
            EventHistoryImpl eventHistory = packageData.getEventStore().getOrCreateEventHistory(0, shortcutId);
            eventHistory.addEvent(new Event(sbn.getPostTime(), 2));
            return;
        L13:
            updated.setParentNotificationChannelId(sbn.getNotification().getChannelId());
            goto L14
        }

        private /* synthetic */ void lambda$onNotificationPosted$1(StatusBarNotification sbn, String shortcutId, ConversationInfo conversationInfo) {
            monitor-enter(this);
            Set<String> notificationKeys = this.mActiveNotifKeys.computeIfAbsent(Pair.create(sbn.getPackageName(), shortcutId), new DataManager$NotificationListener$$ExternalSyntheticLambda1());     // Catch: Throwable -> L6
            notificationKeys.add(sbn.getKey());     // Catch: Throwable -> L6
            monitor-exit(this);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ Set lambda$onNotificationPosted$0(Pair unusedKey) {
            return new HashSet();
        }

        @Override // android.service.notification.NotificationListenerService
        public synchronized void onNotificationRemoved(final StatusBarNotification sbn, NotificationListenerService.RankingMap rankingMap, int reason) {
            monitor-enter(this);
        L18:
            th = move-exception;
            throw th;
        L4:
            if (sbn.getUser().getIdentifier() == this.mUserId) goto L7;
            monitor-exit(this);
            return;
        L7:
            final String shortcutId = sbn.getNotification().getShortcutId();     // Catch: Throwable -> L18
            PackageData packageData = DataManager.m6534$$Nest$mgetPackageIfConversationExists(this.this$0, sbn, new DataManager$NotificationListener$$ExternalSyntheticLambda2(this, sbn, shortcutId));     // Catch: Throwable -> L18
            if (reason != 1) goto L20;
            if (packageData == null) goto L20;
            long currentTime = System.currentTimeMillis();     // Catch: Throwable -> L18
            ConversationInfo conversationInfo = packageData.getConversationInfo(shortcutId);     // Catch: Throwable -> L18
            if (conversationInfo != null) goto L15;
            monitor-exit(this);
            return;
        L15:
            ConversationInfo updated = new ConversationInfo.Builder(conversationInfo).setLastEventTimestamp(currentTime).build();     // Catch: Throwable -> L18
            packageData.getConversationStore().addOrUpdate(updated);     // Catch: Throwable -> L18
            EventHistoryImpl eventHistory = packageData.getEventStore().getOrCreateEventHistory(0, shortcutId);     // Catch: Throwable -> L18
            eventHistory.addEvent(new Event(currentTime, 3));     // Catch: Throwable -> L18
            monitor-exit(this);
            return;
        L20:
            monitor-exit(this);
        }

        private /* synthetic */ void lambda$onNotificationRemoved$3(StatusBarNotification sbn, String shortcutId, ConversationInfo conversationInfo) {
            Pair<String, String> conversationKey = Pair.create(sbn.getPackageName(), shortcutId);
            monitor-enter(this);
            Set<String> notificationKeys = this.mActiveNotifKeys.computeIfAbsent(conversationKey, new DataManager$NotificationListener$$ExternalSyntheticLambda0());     // Catch: Throwable -> L7
            notificationKeys.remove(sbn.getKey());     // Catch: Throwable -> L7
            if (notificationKeys.isEmpty() == false) goto L9;
            this.mActiveNotifKeys.remove(conversationKey);     // Catch: Throwable -> L7
            DataManager.m6532$$Nest$mcleanupCachedShortcuts(this.this$0, this.mUserId, 30);     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private static /* synthetic */ Set lambda$onNotificationRemoved$2(Pair unusedKey) {
            return new HashSet();
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationChannelModified(String pkg, UserHandle user, NotificationChannel channel, int modificationType) {
            if (user.getIdentifier() == this.mUserId) goto L5;
            return;
        L5:
            PackageData packageData = this.this$0.getPackage(pkg, user.getIdentifier());
            String shortcutId = channel.getConversationId();
            if (packageData == null) goto L22;
            if (shortcutId == null) goto L23;
            ConversationStore conversationStore = packageData.getConversationStore();
            ConversationInfo conversationInfo = conversationStore.getConversation(shortcutId);
            if (conversationInfo != null) goto L12;
            return;
        L12:
            ConversationInfo.Builder builder = new ConversationInfo.Builder(conversationInfo);
            boolean r5 = false;
            switch(modificationType) {
                case 1: goto L16;
                case 2: goto L16;
                case 3: goto L15;
                default: goto L20;
            };
        L15:
            builder.setNotificationChannelId(null);
            builder.setImportant(false);
            builder.setDemoted(false);
            builder.setNotificationSilenced(false);
            builder.setBubbled(false);
            goto L20
        L16:
            builder.setNotificationChannelId(channel.getId());
            builder.setImportant(channel.isImportantConversation());
            builder.setDemoted(channel.isDemoted());
            if (channel.getImportance() > 2) goto L19;
            r5 = true;
        L19:
            builder.setNotificationSilenced(r5);
            builder.setBubbled(channel.canBubble());
        L20:
            this.this$0.updateConversationStoreThenNotifyListeners(conversationStore, builder.build(), pkg, packageData.getUserId());
            return;
        L23:
            return;
        }

        synchronized boolean hasActiveNotifications(String packageName, String shortcutId) {
            monitor-enter(this);
            boolean r0 = this.mActiveNotifKeys.containsKey(Pair.create(packageName, shortcutId));     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    private class PerUserBroadcastReceiver extends BroadcastReceiver {
        private final int mUserId;
        final /* synthetic */ DataManager this$0;

        /* synthetic */ PerUserBroadcastReceiver(DataManager r1, int r2, DataManagerIA r3) {
            this(r1, r2);
        }

        private PerUserBroadcastReceiver(DataManager r1, int userId) {
            this.this$0 = r1;
            this.mUserId = userId;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            UserData userData = DataManager.m6535$$Nest$mgetUnlockedUserData(this.this$0, this.mUserId);
            if (userData != null) goto L6;
            return;
        L6:
            if ("android.telecom.action.DEFAULT_DIALER_CHANGED".equals(intent.getAction()) == false) goto L10;
            String defaultDialer = intent.getStringExtra("android.telecom.extra.CHANGE_DEFAULT_DIALER_PACKAGE_NAME");
            userData.setDefaultDialer(defaultDialer);
            return;
        L10:
            if ("android.provider.action.DEFAULT_SMS_PACKAGE_CHANGED_INTERNAL".equals(intent.getAction()) == false) goto L14;
            DataManager.m6537$$Nest$mupdateDefaultSmsApp(this.this$0, userData);
            return;
        }
    }

    private class PerUserPackageMonitor extends PackageMonitor {
        final /* synthetic */ DataManager this$0;

        /* synthetic */ PerUserPackageMonitor(DataManager r1, DataManagerIA r2) {
            this(r1);
        }

        private PerUserPackageMonitor(DataManager r1) {
            this.this$0 = r1;
        }

        public void onPackageRemoved(String packageName, int uid) {
            super.onPackageRemoved(packageName, uid);
            int userId = getChangingUserId();
            UserData userData = DataManager.m6535$$Nest$mgetUnlockedUserData(this.this$0, userId);
            if (userData == null) goto L6;
            userData.deletePackageData(packageName);
            return;
        }
    }

    private class ShortcutServiceCallback implements LauncherApps.ShortcutChangeCallback {
        final /* synthetic */ DataManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$-aMfwUelU8zPSeBXJ9u_ih884sQ, reason: not valid java name */
        public static /* synthetic */ void m6547$r8$lambda$aMfwUelU8zPSeBXJ9u_ih884sQ(ShortcutServiceCallback r0, List r1, String r2, UserHandle r3) {
            r0.lambda$onShortcutsRemoved$1(r1, r2, r3);
        }

        /* JADX INFO: renamed from: $r8$lambda$iSIw2pH_GOO-0Rk0stmldUt6NpY, reason: not valid java name */
        public static /* synthetic */ void m6548$r8$lambda$iSIw2pH_GOO0Rk0stmldUt6NpY(ShortcutServiceCallback r0, String r1, UserHandle r2, List r3) {
            r0.lambda$onShortcutsAddedOrUpdated$0(r1, r2, r3);
        }

        /* synthetic */ ShortcutServiceCallback(DataManager r1, DataManagerIA r2) {
            this(r1);
        }

        private ShortcutServiceCallback(DataManager r1) {
            this.this$0 = r1;
        }

        public void onShortcutsAddedOrUpdated(final String packageName, final List<ShortcutInfo> shortcuts, final UserHandle user) {
            DataManager.m6530$$Nest$fgetmInjector(this.this$0).getBackgroundExecutor().execute(new DataManager$ShortcutServiceCallback$$ExternalSyntheticLambda1(this, packageName, user, shortcuts));
        }

        private /* synthetic */ void lambda$onShortcutsAddedOrUpdated$0(String packageName, UserHandle user, List shortcuts) {
            PackageData packageData = this.this$0.getPackage(packageName, user.getIdentifier());
            boolean hasCachedShortcut = false;
            Iterator r2 = shortcuts.iterator();
        L4:
            if (r2.hasNext() == false) goto L18;
            ShortcutInfo shortcut = (ShortcutInfo) r2.next();
            if (ShortcutHelper.isConversationShortcut(shortcut, DataManager.m6531$$Nest$fgetmShortcutServiceInternal(this.this$0), user.getIdentifier()) == false) goto L4;
            if (shortcut.isCached() == false) goto L16;
            if (packageData == null) goto L11;
            ConversationInfo conversationInfo = packageData.getConversationInfo(shortcut.getId());
        L12:
            if (conversationInfo != null) goto L14;
        L15:
            hasCachedShortcut = true;
            goto L16
        L14:
            if (conversationInfo.isShortcutCachedForNotification() == true) goto L16;
        L11:
            conversationInfo = null;
        L16:
            this.this$0.addOrUpdateConversationInfo(shortcut);
            goto L4
        L18:
            if (hasCachedShortcut == false) goto L26;
            DataManager.m6532$$Nest$mcleanupCachedShortcuts(this.this$0, user.getIdentifier(), 30);
            return;
        }

        public void onShortcutsRemoved(final String packageName, final List<ShortcutInfo> shortcuts, final UserHandle user) {
            DataManager.m6530$$Nest$fgetmInjector(this.this$0).getBackgroundExecutor().execute(new DataManager$ShortcutServiceCallback$$ExternalSyntheticLambda0(this, shortcuts, packageName, user));
        }

        private /* synthetic */ void lambda$onShortcutsRemoved$1(List shortcuts, String packageName, UserHandle user) {
            HashSet<String> shortcutIds = new HashSet();
            Iterator r1 = shortcuts.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            ShortcutInfo shortcutInfo = (ShortcutInfo) r1.next();
            shortcutIds.add(shortcutInfo.getId());
            goto L4
        L6:
            DataManager.m6536$$Nest$mremoveConversations(this.this$0, packageName, user.getIdentifier(), shortcutIds);
        }
    }

    private class ShutdownBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ DataManager this$0;

        /* JADX INFO: renamed from: $r8$lambda$5V6plyA6C-3AnAMR5bVJ9tSNq4A, reason: not valid java name */
        public static /* synthetic */ void m6549$r8$lambda$5V6plyA6C3AnAMR5bVJ9tSNq4A(UserData r0) {
            lambda$onReceive$0(r0);
        }

        /* synthetic */ ShutdownBroadcastReceiver(DataManager r1, DataManagerIA r2) {
            this(r1);
        }

        private ShutdownBroadcastReceiver(DataManager r1) {
            this.this$0 = r1;
        }

        private static /* synthetic */ void lambda$onReceive$0(UserData userData) {
            userData.forAllPackages(new DataManager$ShutdownBroadcastReceiver$$ExternalSyntheticLambda1());
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            DataManager.m6533$$Nest$mforAllUnlockedUsers(this.this$0, new DataManager$ShutdownBroadcastReceiver$$ExternalSyntheticLambda0());
        }
    }

    private class UsageStatsQueryRunnable implements Runnable, UsageStatsQueryHelper.EventListener {
        private long mLastEventTimestamp;
        private final UsageStatsQueryHelper mUsageStatsQueryHelper;
        final /* synthetic */ DataManager this$0;

        public static /* synthetic */ PackageData $r8$lambda$cVW9hPliqF0sjWNbpn4Xp9GLrWc(UsageStatsQueryRunnable r0, int r1, String r2) {
            return r0.lambda$new$0(r1, r2);
        }

        /* synthetic */ UsageStatsQueryRunnable(DataManager r1, int r2, DataManagerIA r3) {
            this(r1, r2);
        }

        private UsageStatsQueryRunnable(DataManager r5, final int userId) {
            this.this$0 = r5;
            this.mUsageStatsQueryHelper = DataManager.m6530$$Nest$fgetmInjector(r5).createUsageStatsQueryHelper(userId, new DataManager$UsageStatsQueryRunnable$$ExternalSyntheticLambda0(this, userId), this);
            this.mLastEventTimestamp = System.currentTimeMillis() - 300000;
        }

        private /* synthetic */ PackageData lambda$new$0(int userId, String packageName) {
            return this.this$0.getPackage(packageName, userId);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mUsageStatsQueryHelper.querySince(this.mLastEventTimestamp) == false) goto L6;
            this.mLastEventTimestamp = this.mUsageStatsQueryHelper.getLastEventTimestamp();
            return;
        }

        @Override // com.android.server.people.data.UsageStatsQueryHelper.EventListener
        public void onEvent(PackageData packageData, ConversationInfo conversationInfo, Event event) {
            if (event.getType() != 13) goto L6;
            ConversationInfo updated = new ConversationInfo.Builder(conversationInfo).setLastEventTimestamp(event.getTimestamp()).build();
            this.this$0.updateConversationStoreThenNotifyListeners(packageData.getConversationStore(), updated, packageData.getPackageName(), packageData.getUserId());
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$1-ISRhLNWfPETJJig6xBTzQCJ7w, reason: not valid java name */
    public static /* synthetic */ void m6521$r8$lambda$1ISRhLNWfPETJJig6xBTzQCJ7w(DataManager r0, int r1) {
        r0.lambda$onUserUnlocked$0(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$50U2EH-s8iZu7BM0Qn-b_Ox46bU, reason: not valid java name */
    public static /* synthetic */ void m6522$r8$lambda$50U2EHs8iZu7BM0Qnb_Ox46bU(DataManager r0, List r1, PackageData r2) {
        r0.lambda$cleanupCachedShortcuts$13(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$5Rrsn37Uj-5u5bPHXiPJgrt5rkk, reason: not valid java name */
    public static /* synthetic */ void m6523$r8$lambda$5Rrsn37Uj5u5bPHXiPJgrt5rkk(DataManager r0, long r1, ConversationStore r3, PackageData r4, ConversationInfo r5) {
        r0.lambda$pruneExpiredConversationStatuses$7(r1, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$80pACHGd-Bm_hZXZ_YrwPqmqqB8, reason: not valid java name */
    public static /* synthetic */ void m6524$r8$lambda$80pACHGdBm_hZXZ_YrwPqmqqB8(DataManager r0, List r1, PackageData r2, ConversationInfo r3) {
        r0.lambda$cleanupCachedShortcuts$12(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$BYQDJatsZqbAgogmBPNFOJBOIdM(DataManager r0, long r1, String r3, int r4, List r5, ConversationInfo r6) {
        r0.lambda$pruneOldRecentConversations$5(r1, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$EVqduJbCMR3-ZFO_TnLyLJGxtVQ, reason: not valid java name */
    public static /* synthetic */ void m6525$r8$lambda$EVqduJbCMR3ZFO_TnLyLJGxtVQ(Set r0, List r1, PackageData r2) {
        lambda$pruneUninstalledPackageData$11(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$IBbToOR-yHgR5RCOqgHMvPxxhck, reason: not valid java name */
    public static /* synthetic */ void m6526$r8$lambda$IBbToORyHgR5RCOqgHMvPxxhck(DataManager r0, int r1) {
        r0.lambda$onUserStopping$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$ImVSQVX0YEAdeOsUa54_N7KuFdI(DataManager r0, List r1) {
        r0.lambda$notifyConversationsListeners$15(r1);
    }

    public static /* synthetic */ void $r8$lambda$SNvskFY2Vy5RPvgEjhqtKWOYpeQ(DataManager r0, long r1, PackageData r3) {
        r0.lambda$pruneExpiredConversationStatuses$8(r1, r3);
    }

    public static /* synthetic */ void $r8$lambda$VTORBzaZWae_orHMsasEBBxq1Lg(DataManager r0, PackageData r1, List r2, ConversationInfo r3) {
        r0.lambda$getRecentConversations$3(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZRn2OModScldoOi5-yf5r6EJQ_E, reason: not valid java name */
    public static /* synthetic */ long m6527$r8$lambda$ZRn2OModScldoOi5yf5r6EJQ_E(Pair r2) {
        return lambda$cleanupCachedShortcuts$14(r2);
    }

    public static /* synthetic */ void $r8$lambda$cwBk8h5GCzUvdFxql8hfHwtEohg(Set r0, AndroidPackage r1) {
        lambda$pruneUninstalledPackageData$10(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$f1a9zfzo82BOEtI8ghvlGWtMDcs(DataManager r0, List r1, PackageData r2) {
        r0.lambda$getRecentConversations$4(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$uJG2kF-S1-kguuAxI_f2R6U_sYQ, reason: not valid java name */
    public static /* synthetic */ void m6528$r8$lambda$uJG2kFS1kguuAxI_f2R6U_sYQ(DataManager r0, long r1, int r3, PackageData r4) {
        r0.lambda$pruneOldRecentConversations$6(r1, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$uiQuM1wyV4SoCLWldrHbtfnW_qE(DataManager r0, CancellationSignal r1, int r2, PackageData r3) {
        r0.lambda$pruneDataForUser$9(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ullRNU1GaOln7WacmM2ghVTdkao(DataManager r0, String r1, int r2, String r3) {
        r0.lambda$getConversationChannel$2(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m6529$$Nest$fgetmContext(DataManager r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInjector, reason: not valid java name */
    static /* bridge */ /* synthetic */ Injector m6530$$Nest$fgetmInjector(DataManager r0) {
        return r0.mInjector;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmShortcutServiceInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ ShortcutServiceInternal m6531$$Nest$fgetmShortcutServiceInternal(DataManager r0) {
        return r0.mShortcutServiceInternal;
    }

    /* JADX INFO: renamed from: -$$Nest$mcleanupCachedShortcuts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6532$$Nest$mcleanupCachedShortcuts(DataManager r0, int r1, int r2) {
        r0.cleanupCachedShortcuts(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mforAllUnlockedUsers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6533$$Nest$mforAllUnlockedUsers(DataManager r0, Consumer r1) {
        r0.forAllUnlockedUsers(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPackageIfConversationExists, reason: not valid java name */
    static /* bridge */ /* synthetic */ PackageData m6534$$Nest$mgetPackageIfConversationExists(DataManager r0, StatusBarNotification r1, Consumer r2) {
        return r0.getPackageIfConversationExists(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetUnlockedUserData, reason: not valid java name */
    static /* bridge */ /* synthetic */ UserData m6535$$Nest$mgetUnlockedUserData(DataManager r0, int r1) {
        return r0.getUnlockedUserData(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveConversations, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6536$$Nest$mremoveConversations(DataManager r0, String r1, int r2, Set r3) {
        r0.removeConversations(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateDefaultSmsApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6537$$Nest$mupdateDefaultSmsApp(DataManager r0, UserData r1) {
        r0.updateDefaultSmsApp(r1);
    }

    public DataManager(Context context) {
        this(context, new Injector(), BackgroundThread.get().getLooper());
    }

    DataManager(Context context, Injector injector, Looper looper) {
        this.mLock = new Object();
        this.mUserDataArray = new SparseArray();
        this.mBroadcastReceivers = new SparseArray();
        this.mContactsContentObservers = new SparseArray();
        this.mUsageStatsQueryFutures = new SparseArray();
        this.mNotificationListeners = new SparseArray();
        this.mPackageMonitors = new SparseArray();
        this.mConversationsListeners = new ArrayList(1);
        this.mContext = context;
        this.mInjector = injector;
        this.mScheduledExecutor = this.mInjector.createScheduledExecutor();
        this.mHandler = new Handler(looper);
    }

    public void initialize() {
        this.mShortcutServiceInternal = (ShortcutServiceInternal) LocalServices.getService(ShortcutServiceInternal.class);
        this.mPackageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        this.mNotificationManagerInternal = (NotificationManagerInternal) LocalServices.getService(NotificationManagerInternal.class);
        this.mUserManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        DataManagerIA r2 = null;
        this.mShortcutServiceInternal.addShortcutChangeCallback(new ShortcutServiceCallback(this, r2));
        this.mStatusExpReceiver = new ConversationStatusExpirationBroadcastReceiver();
        this.mContext.registerReceiver(this.mStatusExpReceiver, ConversationStatusExpirationBroadcastReceiver.getFilter(), 4);
        IntentFilter shutdownIntentFilter = new IntentFilter("android.intent.action.ACTION_SHUTDOWN");
        BroadcastReceiver shutdownBroadcastReceiver = new ShutdownBroadcastReceiver(this, r2);
        this.mContext.registerReceiver(shutdownBroadcastReceiver, shutdownIntentFilter);
    }

    public void onUserUnlocked(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserData userData = this.mUserDataArray.get(userId);     // Catch: Throwable -> L7
        if (userData != null) goto L9;
        userData = new UserData(userId, this.mScheduledExecutor);     // Catch: Throwable -> L7
        this.mUserDataArray.put(userId, userData);     // Catch: Throwable -> L7
    L9:
        userData.setUserUnlocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mScheduledExecutor.execute(new DataManager$$ExternalSyntheticLambda7(this, userId));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onUserUnlocked$0(int userId) {
        setupUser(userId);
    }

    public void onUserStopping(final int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserData userData = this.mUserDataArray.get(userId);     // Catch: Throwable -> L7
        if (userData == null) goto L9;
        userData.setUserStopped();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mScheduledExecutor.execute(new DataManager$$ExternalSyntheticLambda5(this, userId));
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$onUserStopping$1(int userId) {
        cleanupUser(userId);
    }

    void forPackagesInProfile(int callingUserId, Consumer<PackageData> consumer) {
        List<UserInfo> users = this.mUserManager.getEnabledProfiles(callingUserId);
        Iterator<UserInfo> r1 = users.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        UserInfo userInfo = r1.next();
        UserData userData = getUnlockedUserData(userInfo.id);
        if (userData == null) goto L4;
        userData.forAllPackages(consumer);
        goto L4
    }

    public PackageData getPackage(String packageName, int userId) {
        UserData userData = getUnlockedUserData(userId);
        if (userData != null) goto L7;
        return null;
    L7:
        return userData.getPackageData(packageName);
    }

    public ShortcutInfo getShortcut(String packageName, int userId, String shortcutId) {
        List<ShortcutInfo> shortcuts = getShortcuts(packageName, userId, Collections.singletonList(shortcutId));
        if (shortcuts != null) goto L5;
        return null;
    L5:
        if (shortcuts.isEmpty() == false) goto L7;
        return null;
    L7:
        return shortcuts.get(0);
    }

    public List<ShortcutManager.ShareShortcutInfo> getShareShortcuts(IntentFilter intentFilter, int callingUserId) {
        return this.mShortcutServiceInternal.getShareTargets(this.mContext.getPackageName(), intentFilter, callingUserId);
    }

    public ConversationChannel getConversation(String packageName, int userId, String shortcutId) {
        UserData userData = getUnlockedUserData(userId);
        if (userData == null) goto L8;
        PackageData packageData = userData.getPackageData(packageName);
        if (packageData == null) goto L10;
        ConversationInfo conversationInfo = packageData.getConversationInfo(shortcutId);
        return getConversationChannel(packageName, userId, shortcutId, conversationInfo);
    L10:
        return null;
    L8:
        return null;
    }

    ConversationInfo getConversationInfo(String packageName, int userId, String shortcutId) {
        UserData userData = getUnlockedUserData(userId);
        if (userData == null) goto L8;
        PackageData packageData = userData.getPackageData(packageName);
        if (packageData != null) goto L7;
        return null;
    L7:
        return packageData.getConversationInfo(shortcutId);
    L8:
        return null;
    }

    private ConversationChannel getConversationChannel(String packageName, int userId, String shortcutId, ConversationInfo conversationInfo) {
        ShortcutInfo shortcutInfo = getShortcut(packageName, userId, shortcutId);
        return getConversationChannel(shortcutInfo, conversationInfo, packageName, userId, shortcutId);
    }

    private ConversationChannel getConversationChannel(ShortcutInfo shortcutInfo, ConversationInfo conversationInfo, final String packageName, final int userId, final String shortcutId) {
        if (conversationInfo != null) goto L5;
    L16:
        return null;
    L5:
        if (conversationInfo.isDemoted() == true) goto L16;
        if (shortcutInfo != null) goto L10;
        Slog.e(TAG, "Shortcut no longer found");
        this.mInjector.getBackgroundExecutor().execute(new DataManager$$ExternalSyntheticLambda6(this, packageName, userId, shortcutId));
        return null;
    L10:
        int uid = this.mPackageManagerInternal.getPackageUid(packageName, 0, userId);
        NotificationChannel parentChannel = this.mNotificationManagerInternal.getNotificationChannel(packageName, uid, conversationInfo.getNotificationChannelId());
        if (parentChannel == null) goto L13;
        NotificationChannelGroup parentChannelGroup = this.mNotificationManagerInternal.getNotificationChannelGroup(packageName, uid, parentChannel.getId());
        NotificationChannelGroup parentChannelGroup2 = parentChannelGroup;
    L15:
        return new ConversationChannel(shortcutInfo, uid, parentChannel, parentChannelGroup2, conversationInfo.getLastEventTimestamp(), hasActiveNotifications(packageName, userId, shortcutId), false, getStatuses(conversationInfo));
    L13:
        parentChannelGroup2 = null;
        goto L15
    }

    private /* synthetic */ void lambda$getConversationChannel$2(String packageName, int userId, String shortcutId) {
        removeConversations(packageName, userId, Set.of(shortcutId));
    }

    public List<ConversationChannel> getRecentConversations(int callingUserId) {
        final List<ConversationChannel> conversationChannels = new ArrayList();
        forPackagesInProfile(callingUserId, new DataManager$$ExternalSyntheticLambda2(this, conversationChannels));
        return conversationChannels;
    }

    private /* synthetic */ void lambda$getRecentConversations$4(final List conversationChannels, final PackageData packageData) {
        packageData.forAllConversations(new DataManager$$ExternalSyntheticLambda3(this, packageData, conversationChannels));
    }

    private /* synthetic */ void lambda$getRecentConversations$3(PackageData packageData, List conversationChannels, ConversationInfo conversationInfo) {
        if (isCachedRecentConversation(conversationInfo) == true) goto L5;
        return;
    L5:
        String shortcutId = conversationInfo.getShortcutId();
        ConversationChannel channel = getConversationChannel(packageData.getPackageName(), packageData.getUserId(), shortcutId, conversationInfo);
        if (channel != null) goto L8;
        return;
    L8:
        if (channel.getNotificationChannel() == null) goto L13;
        conversationChannels.add(channel);
        return;
    }

    public void removeRecentConversation(String packageName, int userId, String shortcutId, int callingUserId) {
        if (hasActiveNotifications(packageName, userId, shortcutId) == true) goto L6;
        this.mShortcutServiceInternal.uncacheShortcuts(callingUserId, this.mContext.getPackageName(), packageName, Collections.singletonList(shortcutId), userId, 16384);
        return;
    }

    public void removeAllRecentConversations(int callingUserId) {
        pruneOldRecentConversations(callingUserId, Long.MAX_VALUE);
    }

    public void pruneOldRecentConversations(final int callingUserId, final long currentTimeMs) {
        forPackagesInProfile(callingUserId, new DataManager$$ExternalSyntheticLambda4(this, currentTimeMs, callingUserId));
    }

    private /* synthetic */ void lambda$pruneOldRecentConversations$6(final long currentTimeMs, int callingUserId, PackageData packageData) {
        final String packageName = packageData.getPackageName();
        final int userId = packageData.getUserId();
        final List<String> idsToUncache = new ArrayList();
        packageData.forAllConversations(new DataManager$$ExternalSyntheticLambda15(this, currentTimeMs, packageName, userId, idsToUncache));
        if (idsToUncache.isEmpty() == true) goto L6;
        this.mShortcutServiceInternal.uncacheShortcuts(callingUserId, this.mContext.getPackageName(), packageName, idsToUncache, userId, 16384);
        return;
    }

    private /* synthetic */ void lambda$pruneOldRecentConversations$5(long currentTimeMs, String packageName, int userId, List idsToUncache, ConversationInfo conversationInfo) {
        String shortcutId = conversationInfo.getShortcutId();
        if (isCachedRecentConversation(conversationInfo) == true) goto L5;
        return;
    L5:
        if ((currentTimeMs - conversationInfo.getLastEventTimestamp()) > RECENT_NOTIFICATIONS_MAX_AGE_MS) goto L7;
        return;
    L7:
        if (hasActiveNotifications(packageName, userId, shortcutId) == true) goto L12;
        idsToUncache.add(shortcutId);
        return;
    }

    public void pruneExpiredConversationStatuses(int callingUserId, final long currentTimeMs) {
        forPackagesInProfile(callingUserId, new DataManager$$ExternalSyntheticLambda1(this, currentTimeMs));
    }

    private /* synthetic */ void lambda$pruneExpiredConversationStatuses$8(final long currentTimeMs, final PackageData packageData) {
        final ConversationStore cs = packageData.getConversationStore();
        packageData.forAllConversations(new DataManager$$ExternalSyntheticLambda8(this, currentTimeMs, cs, packageData));
    }

    private /* synthetic */ void lambda$pruneExpiredConversationStatuses$7(long currentTimeMs, ConversationStore cs, PackageData packageData, ConversationInfo conversationInfo) {
        ConversationInfo.Builder builder = new ConversationInfo.Builder(conversationInfo);
        List<ConversationStatus> newStatuses = new ArrayList();
        Iterator<ConversationStatus> r2 = conversationInfo.getStatuses().iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        ConversationStatus status = r2.next();
        if (status.getEndTimeMillis() < 0) goto L9;
        if (currentTimeMs >= status.getEndTimeMillis()) goto L4;
    L9:
        newStatuses.add(status);
        goto L4
    L11:
        builder.setStatuses(newStatuses);
        updateConversationStoreThenNotifyListeners(cs, builder.build(), packageData.getPackageName(), packageData.getUserId());
    }

    public boolean isConversation(String packageName, int userId, String shortcutId) {
        ConversationChannel channel = getConversation(packageName, userId, shortcutId);
        if (channel != null) goto L5;
    L9:
        return false;
    L5:
        if (channel.getShortcutInfo() == null) goto L9;
        if (TextUtils.isEmpty(channel.getShortcutInfo().getLabel()) == true) goto L9;
        return true;
    }

    public long getLastInteraction(String packageName, int userId, String shortcutId) {
        PackageData packageData = getPackage(packageName, userId);
        if (packageData == null) goto L8;
        ConversationInfo conversationInfo = packageData.getConversationInfo(shortcutId);
        if (conversationInfo != null) goto L7;
        return 0;
    L7:
        return conversationInfo.getLastEventTimestamp();
    L8:
        return 0;
    }

    public void addOrUpdateStatus(String packageName, int userId, String conversationId, ConversationStatus status) {
        ConversationStore cs = getConversationStoreOrThrow(packageName, userId);
        ConversationInfo convToModify = getConversationInfoOrThrow(cs, conversationId);
        ConversationInfo.Builder builder = new ConversationInfo.Builder(convToModify);
        builder.addOrUpdateStatus(status);
        updateConversationStoreThenNotifyListeners(cs, builder.build(), packageName, userId);
        if (status.getEndTimeMillis() < 0) goto L6;
        this.mStatusExpReceiver.scheduleExpiration(this.mContext, userId, packageName, conversationId, status);
        return;
    }

    public void clearStatus(String packageName, int userId, String conversationId, String statusId) {
        ConversationStore cs = getConversationStoreOrThrow(packageName, userId);
        ConversationInfo convToModify = getConversationInfoOrThrow(cs, conversationId);
        ConversationInfo.Builder builder = new ConversationInfo.Builder(convToModify);
        builder.clearStatus(statusId);
        updateConversationStoreThenNotifyListeners(cs, builder.build(), packageName, userId);
    }

    public void clearStatuses(String packageName, int userId, String conversationId) {
        ConversationStore cs = getConversationStoreOrThrow(packageName, userId);
        ConversationInfo convToModify = getConversationInfoOrThrow(cs, conversationId);
        ConversationInfo.Builder builder = new ConversationInfo.Builder(convToModify);
        builder.setStatuses(null);
        updateConversationStoreThenNotifyListeners(cs, builder.build(), packageName, userId);
    }

    public List<ConversationStatus> getStatuses(String packageName, int userId, String conversationId) {
        ConversationStore cs = getConversationStoreOrThrow(packageName, userId);
        ConversationInfo conversationInfo = getConversationInfoOrThrow(cs, conversationId);
        return getStatuses(conversationInfo);
    }

    private List<ConversationStatus> getStatuses(ConversationInfo conversationInfo) {
        Collection<? extends ConversationStatus> statuses = conversationInfo.getStatuses();
        if (statuses == null) goto L7;
        ArrayList<ConversationStatus> list = new ArrayList(statuses.size());
        list.addAll(statuses);
        return list;
    L7:
        return new ArrayList();
    }

    private ConversationStore getConversationStoreOrThrow(String packageName, int userId) {
        PackageData packageData = getPackage(packageName, userId);
        if (packageData == null) goto L10;
        ConversationStore cs = packageData.getConversationStore();
        if (cs == null) goto L8;
        return cs;
    L8:
        throw new IllegalArgumentException("No conversations exist for package " + packageName);
    L10:
        throw new IllegalArgumentException("No settings exist for package " + packageName);
    }

    private ConversationInfo getConversationInfoOrThrow(ConversationStore cs, String conversationId) {
        ConversationInfo ci = cs.getConversation(conversationId);
        if (ci == null) goto L6;
        return ci;
    L6:
        throw new IllegalArgumentException("Conversation does not exist");
    }

    public void reportShareTargetEvent(AppTargetEvent event, IntentFilter intentFilter) {
        AppTarget appTarget = event.getTarget();
        if (appTarget != null) goto L5;
        return;
    L5:
        if (event.getAction() != 1) goto L26;
        UserData userData = getUnlockedUserData(appTarget.getUser().getIdentifier());
        if (userData != null) goto L10;
        return;
    L10:
        PackageData packageData = userData.getOrCreatePackageData(appTarget.getPackageName());
        int eventType = mimeTypeToShareEventType(intentFilter.getDataType(0));
        if ("direct_share".equals(event.getLaunchLocation()) == true) goto L13;
        EventHistoryImpl eventHistory = packageData.getEventStore().getOrCreateEventHistory(4, appTarget.getClassName());
    L23:
        eventHistory.addEvent(new Event(System.currentTimeMillis(), eventType));
        return;
    L13:
        if (appTarget.getShortcutInfo() != null) goto L15;
        return;
    L15:
        String shortcutId = appTarget.getShortcutInfo().getId();
        if ("chooser_target".equals(shortcutId) == false) goto L19;
        return;
    L19:
        if (packageData.getConversationStore().getConversation(shortcutId) != null) goto L21;
        addOrUpdateConversationInfo(appTarget.getShortcutInfo());
    L21:
        eventHistory = packageData.getEventStore().getOrCreateEventHistory(0, shortcutId);
        goto L23
    }

    public List<UsageEvents.Event> queryAppMovingToForegroundEvents(int callingUserId, long startTime, long endTime) {
        return UsageStatsQueryHelper.queryAppMovingToForegroundEvents(callingUserId, startTime, endTime);
    }

    public Map<String, AppUsageStatsData> queryAppUsageStats(int callingUserId, long startTime, long endTime, Set<String> packageNameFilter) {
        return UsageStatsQueryHelper.queryAppUsageStats(callingUserId, startTime, endTime, packageNameFilter);
    }

    public void pruneDataForUser(final int userId, final CancellationSignal signal) {
        UserData userData = getUnlockedUserData(userId);
        if (userData != null) goto L5;
        return;
    L5:
        if (signal.isCanceled() == true) goto L10;
        pruneUninstalledPackageData(userData);
        userData.forAllPackages(new DataManager$$ExternalSyntheticLambda9(this, signal, userId));
        return;
    }

    private /* synthetic */ void lambda$pruneDataForUser$9(CancellationSignal signal, int userId, PackageData packageData) {
        if (signal.isCanceled() == false) goto L5;
        return;
    L5:
        packageData.getEventStore().pruneOldEvents();
        if (packageData.isDefaultDialer() == true) goto L9;
        packageData.getEventStore().deleteEventHistories(2);
    L9:
        if (packageData.isDefaultSmsApp() == true) goto L11;
        packageData.getEventStore().deleteEventHistories(3);
    L11:
        packageData.pruneOrphanEvents();
        pruneExpiredConversationStatuses(userId, System.currentTimeMillis());
        pruneOldRecentConversations(userId, System.currentTimeMillis());
        cleanupCachedShortcuts(userId, 30);
    }

    public byte[] getBackupPayload(int userId) {
        UserData userData = getUnlockedUserData(userId);
        if (userData != null) goto L7;
        return null;
    L7:
        return userData.getBackupPayload();
    }

    public void restore(int userId, byte[] payload) {
        UserData userData = getUnlockedUserData(userId);
        if (userData != null) goto L5;
        return;
    L5:
        userData.restore(payload);
    }

    private void setupUser(int userId) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        UserData userData = getUnlockedUserData(userId);     // Catch: Throwable -> L8
        if (userData != null) goto L10;
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L10:
        userData.loadUserData();     // Catch: Throwable -> L8
        updateDefaultDialer(userData);     // Catch: Throwable -> L8
        updateDefaultSmsApp(userData);     // Catch: Throwable -> L8
        DataManagerIA r10 = null;
        ScheduledFuture<?> scheduledFuture = this.mScheduledExecutor.scheduleAtFixedRate(new UsageStatsQueryRunnable(this, userId, r10), 1, 120, TimeUnit.SECONDS);     // Catch: Throwable -> L8
        this.mUsageStatsQueryFutures.put(userId, scheduledFuture);     // Catch: Throwable -> L8
        IntentFilter intentFilter = new IntentFilter();     // Catch: Throwable -> L8
        intentFilter.addAction("android.telecom.action.DEFAULT_DIALER_CHANGED");     // Catch: Throwable -> L8
        intentFilter.addAction("android.provider.action.DEFAULT_SMS_PACKAGE_CHANGED_INTERNAL");     // Catch: Throwable -> L8
        if (this.mBroadcastReceivers.get(userId) != null) goto L13;
        BroadcastReceiver broadcastReceiver = new PerUserBroadcastReceiver(this, userId, r10);     // Catch: Throwable -> L8
        this.mBroadcastReceivers.put(userId, broadcastReceiver);     // Catch: Throwable -> L8
        this.mContext.registerReceiverAsUser(broadcastReceiver, UserHandle.of(userId), intentFilter, null, null);     // Catch: Throwable -> L8
    L13:
        ContentObserver contactsContentObserver = new ContactsContentObserver(this, BackgroundThread.getHandler(), r10);     // Catch: Throwable -> L8
        this.mContactsContentObservers.put(userId, contactsContentObserver);     // Catch: Throwable -> L8
        this.mContext.getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, contactsContentObserver, userId);     // Catch: Throwable -> L8
        NotificationListener notificationListener = new NotificationListener(this, userId, r10);     // Catch: Throwable -> L8
        this.mNotificationListeners.put(userId, notificationListener);     // Catch: Throwable -> L8
        notificationListener.registerAsSystemService(this.mContext, new ComponentName(this.mContext, getClass()), userId);     // Catch: Throwable -> L8 RemoteException -> L16
    L18:
        if (this.mPackageMonitors.get(userId) != null) goto L20;
        PackageMonitor packageMonitor = new PerUserPackageMonitor(this, r10);     // Catch: Throwable -> L8
        packageMonitor.register(this.mContext, null, UserHandle.of(userId), true);     // Catch: Throwable -> L8
        this.mPackageMonitors.put(userId, packageMonitor);     // Catch: Throwable -> L8
    L20:
        if (userId != 0) goto L22;
        this.mCallLogContentObserver = new CallLogContentObserver(this, BackgroundThread.getHandler(), r10);     // Catch: Throwable -> L8
        this.mContext.getContentResolver().registerContentObserver(CallLog.CONTENT_URI, true, this.mCallLogContentObserver, 0);     // Catch: Throwable -> L8
        this.mMmsSmsContentObserver = new MmsSmsContentObserver(this, BackgroundThread.getHandler(), r10);     // Catch: Throwable -> L8
        this.mContext.getContentResolver().registerContentObserver(Telephony.MmsSms.CONTENT_URI, false, this.mMmsSmsContentObserver, 0);     // Catch: Throwable -> L8
    L22:
        DataMaintenanceService.scheduleJob(this.mContext, userId);     // Catch: Throwable -> L8
        monitor-exit(r1);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void cleanupUser(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserData userData = this.mUserDataArray.get(userId);     // Catch: Throwable -> L12
        if (userData == null) goto L38;
        if (userData.isUnlocked() == true) goto L38;
        ContentResolver contentResolver = this.mContext.getContentResolver();     // Catch: Throwable -> L12
        if (this.mUsageStatsQueryFutures.indexOfKey(userId) < 0) goto L15;
        this.mUsageStatsQueryFutures.get(userId).cancel(true);     // Catch: Throwable -> L12
    L15:
        if (this.mBroadcastReceivers.indexOfKey(userId) < 0) goto L18;
        this.mContext.unregisterReceiver(this.mBroadcastReceivers.get(userId));     // Catch: Throwable -> L12
    L18:
        if (this.mContactsContentObservers.indexOfKey(userId) < 0) goto L21;
        contentResolver.unregisterContentObserver(this.mContactsContentObservers.get(userId));     // Catch: Throwable -> L12
    L21:
        if (this.mNotificationListeners.indexOfKey(userId) < 0) goto L26;
        this.mNotificationListeners.get(userId).unregisterAsSystemService();     // Catch: Throwable -> L12 RemoteException -> L24
    L26:
        if (this.mPackageMonitors.indexOfKey(userId) < 0) goto L28;
        this.mPackageMonitors.get(userId).unregister();     // Catch: Throwable -> L12
    L28:
        if (userId == 0) goto L30;
    L35:
        DataMaintenanceService.cancelJob(this.mContext, userId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L30:
        if (this.mCallLogContentObserver == null) goto L33;
        contentResolver.unregisterContentObserver(this.mCallLogContentObserver);     // Catch: Throwable -> L12
        this.mCallLogContentObserver = null;     // Catch: Throwable -> L12
    L33:
        if (this.mMmsSmsContentObserver == null) goto L35;
        contentResolver.unregisterContentObserver(this.mMmsSmsContentObserver);     // Catch: Throwable -> L12
        this.mCallLogContentObserver = null;     // Catch: Throwable -> L12
    L38:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public int mimeTypeToShareEventType(String mimeType) {
        if (mimeType != null) goto L6;
        return 7;
    L6:
        if (mimeType.startsWith("text/") == false) goto L10;
        return 4;
    L10:
        if (mimeType.startsWith("image/") == false) goto L14;
        return 5;
    L14:
        if (mimeType.startsWith("video/") == false) goto L17;
        return 6;
    L17:
        return 7;
    }

    private void pruneUninstalledPackageData(UserData userData) {
        final Set<String> installApps = new ArraySet();
        this.mPackageManagerInternal.forEachInstalledPackage(new DataManager$$ExternalSyntheticLambda13(installApps), userData.getUserId());
        final List<String> packagesToDelete = new ArrayList();
        userData.forAllPackages(new DataManager$$ExternalSyntheticLambda14(installApps, packagesToDelete));
        Iterator<String> r2 = packagesToDelete.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        String packageName = r2.next();
        userData.deletePackageData(packageName);
        goto L4
    }

    private static /* synthetic */ void lambda$pruneUninstalledPackageData$10(Set installApps, AndroidPackage pkg) {
        installApps.add(pkg.getPackageName());
    }

    private static /* synthetic */ void lambda$pruneUninstalledPackageData$11(Set installApps, List packagesToDelete, PackageData packageData) {
        if (installApps.contains(packageData.getPackageName()) == true) goto L6;
        packagesToDelete.add(packageData.getPackageName());
        return;
    }

    private List<ShortcutInfo> getShortcuts(String packageName, int userId, List<String> shortcutIds) {
        return this.mShortcutServiceInternal.getShortcuts(0, this.mContext.getPackageName(), 0, packageName, shortcutIds, null, null, 3091, userId, Process.myPid(), Process.myUid());
    }

    private void forAllUnlockedUsers(Consumer<UserData> consumer) {
        int i = 0;
    L4:
        if (i >= this.mUserDataArray.size()) goto L10;
        int userId = this.mUserDataArray.keyAt(i);
        UserData userData = this.mUserDataArray.get(userId);
        if (userData.isUnlocked() == false) goto L8;
        consumer.accept(userData);
    L8:
        i = i + 1;
        goto L4
    }

    private UserData getUnlockedUserData(int userId) {
        UserData userData = this.mUserDataArray.get(userId);
        if (userData != null) goto L5;
    L7:
        return null;
    L5:
        if (userData.isUnlocked() == false) goto L7;
        return userData;
    }

    private void updateDefaultDialer(UserData userData) {
        TelecomManager telecomManager = (TelecomManager) this.mContext.getSystemService(TelecomManager.class);
        if (telecomManager == null) goto L5;
        String defaultDialer = telecomManager.getDefaultDialerPackage(new UserHandle(userData.getUserId()));
    L6:
        userData.setDefaultDialer(defaultDialer);
        return;
    L5:
        defaultDialer = null;
        goto L6
    }

    private void updateDefaultSmsApp(UserData userData) {
        ComponentName component = SmsApplication.getDefaultSmsApplicationAsUser(this.mContext, false, UserHandle.of(userData.getUserId()));
        if (component == null) goto L5;
        String defaultSmsApp = component.getPackageName();
    L6:
        userData.setDefaultSmsApp(defaultSmsApp);
        return;
    L5:
        defaultSmsApp = null;
        goto L6
    }

    private PackageData getPackageIfConversationExists(StatusBarNotification sbn, Consumer<ConversationInfo> conversationConsumer) {
        Notification notification = sbn.getNotification();
        String shortcutId = notification.getShortcutId();
        if (shortcutId != null) goto L5;
        return null;
    L5:
        PackageData packageData = getPackage(sbn.getPackageName(), sbn.getUser().getIdentifier());
        if (packageData != null) goto L8;
        return null;
    L8:
        ConversationInfo conversationInfo = packageData.getConversationStore().getConversation(shortcutId);
        if (conversationInfo != null) goto L11;
        return null;
    L11:
        conversationConsumer.accept(conversationInfo);
        return packageData;
    }

    private boolean isCachedRecentConversation(ConversationInfo conversationInfo) {
        if (isEligibleForCleanUp(conversationInfo) == true) goto L5;
    L7:
        return false;
    L5:
        if (conversationInfo.getLastEventTimestamp() <= 0) goto L7;
        return true;
    }

    private boolean isEligibleForCleanUp(ConversationInfo conversationInfo) {
        if (conversationInfo.isShortcutCachedForNotification() == true) goto L5;
    L7:
        return false;
    L5:
        if (Objects.equals(conversationInfo.getNotificationChannelId(), conversationInfo.getParentNotificationChannelId()) == false) goto L7;
        return true;
    }

    private boolean hasActiveNotifications(String packageName, int userId, String shortcutId) {
        NotificationListener notificationListener = this.mNotificationListeners.get(userId);
        if (notificationListener != null) goto L5;
    L7:
        return false;
    L5:
        if (notificationListener.hasActiveNotifications(packageName, shortcutId) == false) goto L7;
        return true;
    }

    private void cleanupCachedShortcuts(int userId, int targetCachedCount) {
        UserData userData = getUnlockedUserData(userId);
        if (userData != null) goto L5;
        return;
    L5:
        final List<Pair<String, ConversationInfo>> cachedConvos = new ArrayList();
        userData.forAllPackages(new DataManager$$ExternalSyntheticLambda11(this, cachedConvos));
        if (cachedConvos.size() > targetCachedCount) goto L8;
        return;
    L8:
        int numToUncache = cachedConvos.size() - targetCachedCount;
        PriorityQueue<Pair<String, ConversationInfo>> maxHeap = new PriorityQueue(numToUncache + 1, Comparator.comparingLong(new DataManager$$ExternalSyntheticLambda12()).reversed());
        Iterator<Pair<String, ConversationInfo>> r4 = cachedConvos.iterator();
    L10:
        if (r4.hasNext() == false) goto L19;
        Pair<String, ConversationInfo> cached = r4.next();
        if (hasActiveNotifications((String) cached.first, userId, ((ConversationInfo) cached.second).getShortcutId()) == true) goto L10;
        maxHeap.offer(cached);
        if (maxHeap.size() <= numToUncache) goto L10;
        maxHeap.poll();
    L19:
        if (maxHeap.isEmpty() == true) goto L21;
        Pair<String, ConversationInfo> toUncache = maxHeap.poll();
        this.mShortcutServiceInternal.uncacheShortcuts(userId, this.mContext.getPackageName(), (String) toUncache.first, Collections.singletonList(((ConversationInfo) toUncache.second).getShortcutId()), userId, 16384);
        goto L19
    }

    private /* synthetic */ void lambda$cleanupCachedShortcuts$13(final List cachedConvos, final PackageData packageData) {
        packageData.forAllConversations(new DataManager$$ExternalSyntheticLambda0(this, cachedConvos, packageData));
    }

    private /* synthetic */ void lambda$cleanupCachedShortcuts$12(List cachedConvos, PackageData packageData, ConversationInfo conversationInfo) {
        if (isEligibleForCleanUp(conversationInfo) == false) goto L6;
        cachedConvos.add(Pair.create(packageData.getPackageName(), conversationInfo));
        return;
    }

    private static /* synthetic */ long lambda$cleanupCachedShortcuts$14(Pair pair) {
        return Math.max(((ConversationInfo) pair.second).getLastEventTimestamp(), ((ConversationInfo) pair.second).getCreationTimestamp());
    }

    void addOrUpdateConversationInfo(ShortcutInfo shortcutInfo) {
        UserData userData = getUnlockedUserData(shortcutInfo.getUserId());
        if (userData != null) goto L5;
        return;
    L5:
        PackageData packageData = userData.getOrCreatePackageData(shortcutInfo.getPackage());
        ConversationStore conversationStore = packageData.getConversationStore();
        ConversationInfo oldConversationInfo = conversationStore.getConversation(shortcutInfo.getId());
        if (oldConversationInfo == null) goto L8;
        ConversationInfo.Builder builder = new ConversationInfo.Builder(oldConversationInfo);
    L9:
        builder.setShortcutId(shortcutInfo.getId());
        builder.setLocusId(shortcutInfo.getLocusId());
        builder.setShortcutFlags(shortcutInfo.getFlags());
        builder.setContactUri(null);
        builder.setContactPhoneNumber(null);
        builder.setContactStarred(false);
        if (shortcutInfo.getPersons() != null) goto L12;
    L18:
        updateConversationStoreThenNotifyListeners(conversationStore, builder.build(), shortcutInfo);
        return;
    L12:
        if (shortcutInfo.getPersons().length == 0) goto L18;
        Person person = shortcutInfo.getPersons()[0];
        builder.setPersonImportant(person.isImportant());
        builder.setPersonBot(person.isBot());
        String contactUri = person.getUri();
        if (contactUri == null) goto L18;
        ContactsQueryHelper helper = this.mInjector.createContactsQueryHelper(this.mContext);
        if (helper.query(contactUri) == false) goto L18;
        builder.setContactUri(helper.getContactUri());
        builder.setContactStarred(helper.isStarred());
        builder.setContactPhoneNumber(helper.getPhoneNumber());
        goto L18
    L8:
        builder = new ConversationInfo.Builder().setCreationTimestamp(System.currentTimeMillis());
        goto L9
    }

    ContentObserver getContactsContentObserverForTesting(int userId) {
        return this.mContactsContentObservers.get(userId);
    }

    ContentObserver getCallLogContentObserverForTesting() {
        return this.mCallLogContentObserver;
    }

    ContentObserver getMmsSmsContentObserverForTesting() {
        return this.mMmsSmsContentObserver;
    }

    NotificationListener getNotificationListenerServiceForTesting(int userId) {
        return this.mNotificationListeners.get(userId);
    }

    PackageMonitor getPackageMonitorForTesting(int userId) {
        return this.mPackageMonitors.get(userId);
    }

    UserData getUserDataForTesting(int userId) {
        return this.mUserDataArray.get(userId);
    }

    private void removeConversations(String packageName, int userId, Set<String> shortcutIds) {
        PackageData packageData = getPackage(packageName, userId);
        if (packageData == null) goto L13;
        Iterator<String> r1 = shortcutIds.iterator();
    L6:
        if (r1.hasNext() == false) goto L13;
        String shortcutId = r1.next();
        packageData.deleteDataForConversation(shortcutId);
    L13:
        int uid = this.mContext.getPackageManager().getPackageUidAsUser(packageName, userId);     // Catch: PackageManager.NameNotFoundException -> L10
        this.mNotificationManagerInternal.onConversationRemoved(packageName, uid, shortcutIds);     // Catch: PackageManager.NameNotFoundException -> L10
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Package not found when removing conversation: " + packageName, e);
    }

    public void addConversationsListener(PeopleService.ConversationsListener listener) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<PeopleService.ConversationsListener> r1 = this.mConversationsListeners;     // Catch: Throwable -> L7
        listener.getClass();     // Catch: Throwable -> L7
        r1.add(listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void updateConversationStoreThenNotifyListeners(ConversationStore cs, ConversationInfo modifiedConv, String packageName, int userId) {
        cs.addOrUpdate(modifiedConv);
        ConversationChannel channel = getConversationChannel(packageName, userId, modifiedConv.getShortcutId(), modifiedConv);
        if (channel == null) goto L6;
        notifyConversationsListeners(Arrays.asList(new ConversationChannel[]{channel}));
        return;
    }

    private void updateConversationStoreThenNotifyListeners(ConversationStore cs, ConversationInfo modifiedConv, ShortcutInfo shortcutInfo) {
        cs.addOrUpdate(modifiedConv);
        ConversationChannel channel = getConversationChannel(shortcutInfo, modifiedConv, shortcutInfo.getPackage(), shortcutInfo.getUserId(), shortcutInfo.getId());
        if (channel == null) goto L6;
        notifyConversationsListeners(Arrays.asList(new ConversationChannel[]{channel}));
        return;
    }

    void notifyConversationsListeners(final List<ConversationChannel> changedConversations) {
        this.mHandler.post(new DataManager$$ExternalSyntheticLambda10(this, changedConversations));
    }

    private /* synthetic */ void lambda$notifyConversationsListeners$15(List changedConversations) {
        Object r0 = this.mLock;     // Catch: Exception -> L11
        monitor-enter(r0);     // Catch: Exception -> L11
        List<PeopleService.ConversationsListener> copy = new ArrayList(this.mConversationsListeners);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        Iterator<PeopleService.ConversationsListener> r1 = copy.iterator();     // Catch: Exception -> L11
    L8:
        if (r1.hasNext() == false) goto L22;
        PeopleService.ConversationsListener listener = r1.next();     // Catch: Exception -> L11
        listener.onConversationsUpdate(changedConversations);     // Catch: Exception -> L11
        goto L8
    L22:
        return;
    L14:
        th = move-exception;
        throw th;     // Catch: Exception -> L11
    }
}
