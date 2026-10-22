package com.android.server.notification;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.SmtNotificationInfo;
import android.app.SmtOpsManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ParceledListSlice;
import android.database.ContentObserver;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.DisturbModeUtils;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SilenceModeUtils;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import com.android.server.pm.pkg.AndroidPackage;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.scene.SceneUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NotificationManagerServiceSmtEx {
    public static final String ASSISTANT_PKG = "com.obric.assistant";
    private static final boolean ENABLE_BLOCKED_NOTIFICATIONS = true;
    private static final String EXTRA_SHOW_BADGE = "obric_notif_icon_badge_show";
    private static final String TAG = "NotificationService";
    private static final List<String> mNoBlockSoundAndVibratePackages = null;
    private final boolean DBG;
    private boolean mAllNotificationForbidden;
    private DisturbModeUtils mDisturbModeUtils;
    private boolean mGameModeNoDisturb;
    private String[] mNotificationWhiteList;
    final IBinder mServiceSmtEx;
    private final NotificationManagerService mServices;
    private SilenceModeUtils mSilenceModeUtils;
    private SmtOpsManager mSmtOpsManager;

    class AllNotificationForbiddenSettingsObserver extends ContentObserver {
        final /* synthetic */ NotificationManagerServiceSmtEx this$0;

        AllNotificationForbiddenSettingsObserver(NotificationManagerServiceSmtEx this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        void observe() {
            ContentResolver resolver = NotificationManagerServiceSmtEx.m6271$$Nest$fgetmServices(this.this$0).getContext().getContentResolver();
            resolver.registerContentObserver(Settings.System.getUriFor("disable_notification"), false, this);
            NotificationManagerServiceSmtEx.m6273$$Nest$fputmAllNotificationForbidden(this.this$0, update());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange) {
            boolean disableNotification = update();
            if (NotificationManagerServiceSmtEx.m6270$$Nest$fgetmAllNotificationForbidden(this.this$0) != disableNotification) goto L5;
            return;
        L5:
            NotificationManagerServiceSmtEx.m6273$$Nest$fputmAllNotificationForbidden(this.this$0, disableNotification);
            NotificationManagerServiceSmtEx.m6275$$Nest$mcancelAllNotificationIfNeeded(this.this$0);
        }

        public boolean update() {
            ContentResolver resolver = NotificationManagerServiceSmtEx.m6271$$Nest$fgetmServices(this.this$0).getContext().getContentResolver();
            return Boolean.parseBoolean(Settings.System.getString(resolver, "disable_notification"));
        }
    }

    class GameModeSettingsObserver extends ContentObserver {
        final /* synthetic */ NotificationManagerServiceSmtEx this$0;

        GameModeSettingsObserver(NotificationManagerServiceSmtEx this$0, Handler handler) {
            this.this$0 = this$0;
            super(handler);
        }

        void observe() {
            observeGameModeNoDisturb();
        }

        void observeGameModeNoDisturb() {
            NotificationManagerServiceSmtEx.m6271$$Nest$fgetmServices(this.this$0).getContext().getContentResolver().registerContentObserver(Settings.Global.getUriFor("shielded_status_bar_notification"), false, this);
            updateGameModeNoDisturb();
        }

        private void updateGameModeNoDisturb() {
            NotificationManagerServiceSmtEx r0 = this.this$0;
            boolean r3 = false;
            if (Settings.Global.getInt(NotificationManagerServiceSmtEx.m6271$$Nest$fgetmServices(this.this$0).getContext().getContentResolver(), "shielded_status_bar_notification", 0) != 1) goto L5;
            r3 = true;
        L5:
            NotificationManagerServiceSmtEx.m6274$$Nest$fputmGameModeNoDisturb(r0, r3);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            String lastpath = uri.getLastPathSegment();
            if (lastpath != null) goto L6;
            return;
        L6:
            if (lastpath.startsWith("shielded_status_bar_notification") == false) goto L9;
            updateGameModeNoDisturb();
            return;
        }
    }

    protected static class NotificationListenersSmtEx {
        static final int EXCEPTION_REBIND_SERVICE_COUNT = 20;
        int mRebindCount;
        Runnable mRebindService;

        protected NotificationListenersSmtEx() {
        }

        void rebindServiceDelay(ManagedServices.ManagedServiceInfo info, Handler handler, final Context context) {
            if (this.mRebindCount < 20) goto L5;
            return;
        L5:
            if (SceneUtils.PKG_SYS_UI.equals(info.component.getPackageName()) == false) goto L9;
            handler.removeCallbacks(this.mRebindService);
            Runnable r0 = new AnonymousClass1(this, context);
            this.mRebindService = r0;
            handler.postDelayed(r0, 300);
            return;
        }

        static long getDataSize(Parcelable obj) {
            Parcel parcel = Parcel.obtain();
            obj.writeToParcel(parcel, -1);
            long dataSize = parcel.dataSize();
            parcel.recycle();
            return dataSize;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAllNotificationForbidden, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6270$$Nest$fgetmAllNotificationForbidden(NotificationManagerServiceSmtEx r0) {
        return r0.mAllNotificationForbidden;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServices, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManagerService m6271$$Nest$fgetmServices(NotificationManagerServiceSmtEx r0) {
        return r0.mServices;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSmtOpsManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ SmtOpsManager m6272$$Nest$fgetmSmtOpsManager(NotificationManagerServiceSmtEx r0) {
        return r0.mSmtOpsManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAllNotificationForbidden, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6273$$Nest$fputmAllNotificationForbidden(NotificationManagerServiceSmtEx r0, boolean r1) {
        r0.mAllNotificationForbidden = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmGameModeNoDisturb, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6274$$Nest$fputmGameModeNoDisturb(NotificationManagerServiceSmtEx r0, boolean r1) {
        r0.mGameModeNoDisturb = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mcancelAllNotificationIfNeeded, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6275$$Nest$mcancelAllNotificationIfNeeded(NotificationManagerServiceSmtEx r0) {
        r0.cancelAllNotificationIfNeeded();
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifySmtPushNotificationInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m6276$$Nest$mnotifySmtPushNotificationInternal(NotificationManagerServiceSmtEx r0, SmtNotificationInfo r1, int r2) {
        return r0.notifySmtPushNotificationInternal(r1, r2);
    }

    static {
        mNoBlockSoundAndVibratePackages = Arrays.asList(new String[]{"com.tencent.mm", "com.ss.android.lark"});
    }

    public NotificationManagerServiceSmtEx(NotificationManagerService service) {
        this.DBG = false;
        this.mAllNotificationForbidden = false;
        this.mServiceSmtEx = new AnonymousClass1(this);
        this.mServices = service;
        this.mSmtOpsManager = (SmtOpsManager) this.mServices.getContext().getSystemService("smtops");
    }

    public boolean isGameModeNoDisturb() {
        if (this.mGameModeNoDisturb == true) goto L5;
    L7:
        return false;
    L5:
        if (inGaming() == false) goto L7;
        return true;
    }

    private boolean inGaming() {
        return false;
    }

    void onStart() {
        this.mNotificationWhiteList = this.mServices.getContext().getResources().getStringArray(R.array.cloneable_apps);
    }

    void onBootPhase(int phase, Handler handler) {
        if (phase != 600) goto L6;
        GameModeSettingsObserver gameModeObserver = new GameModeSettingsObserver(this, handler);
        gameModeObserver.observe();
        this.mDisturbModeUtils = DisturbModeUtils.getInstance(this.mServices.getContext());
        this.mSilenceModeUtils = SilenceModeUtils.getInstance(this.mServices.getContext());
        onStart();
        AllNotificationForbiddenSettingsObserver mObserver = new AllNotificationForbiddenSettingsObserver(this, handler);
        mObserver.observe();
        return;
    }

    private void cancelAllNotificationIfNeeded() {
        Object r1 = this.mServices.mNotificationLock;
        monitor-enter(r1);
        int N = this.mServices.mNotificationList.size();     // Catch: Throwable -> L11
        int i = 0;
    L5:
        if (i >= N) goto L16;
        NotificationRecord r = this.mServices.mNotificationList.get(i);     // Catch: Throwable -> L11
        if (isPackageInWhiteList(r.getSbn().getPackageName()) == true) goto L14;
        if (this.mAllNotificationForbidden == false) goto L13;
        this.mServices.cancelNotificationLocked(r, false, 8, true, null, SystemClock.elapsedRealtime());     // Catch: Throwable -> L11
        updateProcessHasOnGoingNoti(r, false);     // Catch: Throwable -> L11
        goto L14
    L13:
        showNotificationRecord(r);     // Catch: Throwable -> L11
        updateProcessHasOnGoingNoti(r, true);     // Catch: Throwable -> L11
    L14:
        i = i + 1;     // Catch: Throwable -> L11
        goto L5
    L16:
        if (this.mAllNotificationForbidden == false) goto L18;
        removeAutoGroupSummaryNotification(null, -1);     // Catch: Throwable -> L11
    L18:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    void setNotificationsEnabledForPackage(String pkg, int uid, boolean enabled) {
        if (enabled == true) goto L4;
        cancelNotificationWithoutRemove(pkg, uid);
        return;
    L4:
        showNotification(pkg);
    }

    void handleDisqualifyingFeatures(NotificationRecord r) {
    }

    private void cancelNotificationWithoutRemove(String pkg, int uid) {
        Object r1 = this.mServices.mNotificationLock;
        monitor-enter(r1);
        int N = this.mServices.mNotificationList.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L12;
        NotificationRecord r = this.mServices.mNotificationList.get(i);     // Catch: Throwable -> L9
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L11;
        this.mServices.cancelNotificationLocked(r, false, 8, true, null, SystemClock.elapsedRealtime());     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L12:
        removeAutoGroupSummaryNotification(pkg, uid);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void showNotification(String pkg) {
        Object r0 = this.mServices.mNotificationLock;
        monitor-enter(r0);
        int N = this.mServices.mNotificationList.size();     // Catch: Throwable -> L9
        int i = 0;
    L5:
        if (i >= N) goto L13;
        NotificationRecord r = this.mServices.mNotificationList.get(i);     // Catch: Throwable -> L9
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L11;
        showNotificationRecord(r);     // Catch: Throwable -> L9
    L11:
        i = i + 1;     // Catch: Throwable -> L9
        goto L5
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void showNotificationRecord(NotificationRecord r) {
        this.mServices.enqueueNotificationInternal(r.getSbn().getPackageName(), r.getSbn().getOpPkg(), r.getSbn().getUid(), r.getSbn().getInitialPid(), r.getSbn().getTag(), r.getSbn().getId(), r.getSbn().getNotification(), r.getSbn().getUserId(), false, true);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        Log.w("NotificationService", "set notification enable exception", e);
    }

    private void updateProcessHasOnGoingNoti(NotificationRecord r, boolean hasOnGoingNoti) {
        r.getFlags();
    }

    private boolean isPackageInWhiteList(String pkg) {
        if (pkg == null) goto L12;
        String[] r1 = this.mNotificationWhiteList;
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L12;
        String str = r1[r3];
        if (pkg.equals(str) == true) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    boolean isBlocked(NotificationRecord r) {
        if (this.mAllNotificationForbidden == true) goto L5;
        return false;
    L5:
        if (isPackageInWhiteList(r.getSbn().getPackageName()) == true) goto L10;
        saveNotificationWhenForbidden(r);
        return true;
    L10:
        return false;
    }

    private void saveNotificationWhenForbidden(NotificationRecord r) {
        Object r0 = this.mServices.mNotificationLock;
        monitor-enter(r0);
        int index = this.mServices.indexOfNotificationLocked(r.getKey());     // Catch: Throwable -> L8
        if (index >= 0) goto L10;
        this.mServices.mNotificationList.add(r);     // Catch: Throwable -> L8
        updateProcessHasOnGoingNoti(r, true);     // Catch: Throwable -> L8
        this.mServices.mUsageStats.registerPostedByApp(r);     // Catch: Throwable -> L8
    L11:
        this.mServices.mNotificationsByKey.put(r.getKey(), r);     // Catch: Throwable -> L8
        if ((r.getFlags() & 64) == 0) goto L14;
        r.getNotification().flags |= 34;     // Catch: Throwable -> L8
    L14:
        this.mServices.applyZenModeLocked(r);     // Catch: Throwable -> L8
        this.mServices.mRankingHelper.sort(this.mServices.mNotificationList);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        NotificationRecord old = this.mServices.mNotificationList.get(index);     // Catch: Throwable -> L8
        this.mServices.mNotificationList.set(index, r);     // Catch: Throwable -> L8
        this.mServices.mUsageStats.registerUpdatedByApp(r, old);     // Catch: Throwable -> L8
        r.getNotification().flags |= old.getFlags() & 64;     // Catch: Throwable -> L8
        r.isUpdate = true;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    boolean isBlockedSound(String packageName) {
        if (this.mDisturbModeUtils != null) goto L5;
        return false;
    L5:
        if (this.mSilenceModeUtils != null) goto L8;
        return false;
    L8:
        if (this.mDisturbModeUtils.isNotificationReductionMode(this.mServices.getContext()) == false) goto L12;
        return true;
    L12:
        return this.mDisturbModeUtils.isInDisturbModeWithPolicy(packageName);
    }

    boolean isBlockSoundAndVibrate(String packageName, Notification notification) {
        if (mNoBlockSoundAndVibratePackages.contains(packageName) == true) goto L9;
        if (notification != null) goto L6;
        return false;
    L6:
        if (hasProgressNotification(notification) == false) goto L12;
        return true;
    L12:
        return false;
    L9:
        return false;
    }

    private boolean hasProgressNotification(Notification r) {
        if (r.extras.containsKey("android.progress") == true) goto L5;
        return false;
    L5:
        if (r.extras.containsKey("android.progressMax") == true) goto L7;
        return false;
    L7:
        if (r.extras.getInt("android.progressMax") <= 0) goto L13;
        return true;
    L13:
        return false;
    }

    boolean isBlockedVibrate(String packageName) {
        if (this.mDisturbModeUtils.isNotificationReductionMode(this.mServices.getContext()) == false) goto L5;
        return true;
    L5:
        boolean globalVibration = false;
        if (this.mDisturbModeUtils != null) goto L8;
    L18:
        return false;
    L8:
        if (this.mSilenceModeUtils == null) goto L18;
        if (Settings.Global.getInt(this.mServices.getContext().getContentResolver(), "global_vibration_enabled", 0) == 0) goto L13;
        globalVibration = true;
    L13:
        if (globalVibration == true) goto L17;
        Slog.d("NotificationService", "isBlockedVibrate globalVibration disabled");
        return true;
    L17:
        return this.mDisturbModeUtils.isInDisturbModeWithPolicy(packageName);
    }

    private String ensurePushChannel(String packageName, int uid, int importance) throws RemoteException {
        String channelId = packageName + "_obric_push_" + importance;
        if (this.mServices.mPreferencesHelper.getNotificationChannel(packageName, uid, channelId, false) != null) goto L8;
        NotificationChannel channel = new NotificationChannel(channelId, "push", importance);
        channel.setShowBadge(true);
        if (importance < 3) goto L7;
        channel.enableVibration(true);
        channel.enableLights(true);
    L7:
        this.mServices.getBinderService().createNotificationChannelsForPackage(packageName, uid, new ParceledListSlice(Arrays.asList(new NotificationChannel[]{channel})));
    L8:
        return channelId;
    }

    private boolean notifySmtPushNotificationInternal(SmtNotificationInfo info, int userId) {
        if (info != null) goto L5;
        return false;
    L5:
        Binder.getCallingPid();
        int callingUid = Binder.getCallingUid();
        if (callingUid == 1000) goto L8;
        return false;
    L8:
        long origId = Binder.clearCallingIdentity();
        String realPkg = info.getPkg();     // Catch: Throwable -> L14 Exception -> L16
        ApplicationInfo appInfo = this.mServices.getContext().getPackageManager().getApplicationInfoAsUser(realPkg, 0, userId);     // Catch: Throwable -> L14 Exception -> L16
        int uid = appInfo.uid;     // Catch: Throwable -> L14 Exception -> L16
        Context ctx = this.mServices.getContext().createPackageContextAsUser(realPkg, 0, new UserHandle(userId));     // Catch: Throwable -> L14 Exception -> L16
        if (TextUtils.isEmpty(info.getTitle()) == false) goto L19;
        CharSequence label = this.mServices.getContext().getPackageManager().getApplicationLabel(appInfo);     // Catch: Throwable -> L14 Exception -> L16
        if (label == null) goto L18;
        info.setTitle(label.toString());     // Catch: Throwable -> L14 Exception -> L16
        goto L19
    L18:
        info.setTitle("");     // Catch: Throwable -> L14 Exception -> L16
    L19:
        String channelId = ensurePushChannel(realPkg, uid, info.getImportance());     // Catch: Throwable -> L14 Exception -> L16
        Notification localNotification = buildSmtLocalNotification(info, ctx, channelId, appInfo);     // Catch: Throwable -> L14 Exception -> L16
        this.mServices.getInternalService().enqueueNotification(realPkg, realPkg, uid, Process.myPid(), null, info.getNotifyId(), localNotification, userId);     // Catch: Throwable -> L14 Exception -> L16
        Binder.restoreCallingIdentity(origId);
        return true;
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L16:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(origId);
        return false;
    }

    private Notification buildSmtLocalNotification(SmtNotificationInfo info, Context context, String channelId, ApplicationInfo appInfo) {
        if (info != null) goto L5;
        return null;
    L5:
        Notification.Builder notiBuilder = new Notification.Builder(context, channelId);
        Bundle extras = info.getExtras();
        notiBuilder.setContentTitle(info.getTitle()).setContentText(info.getContentText()).setContentIntent(info.getContentIntent()).setDefaults(-1).setWhen(info.getWhen()).setShowWhen(info.showWhen()).setAutoCancel(info.isAutoCancel());
        if (extras == null) goto L9;
        notiBuilder.getExtras().putAll(extras);
    L9:
        if (info.showBadge() == false) goto L14;
        if (info.getCustomIcon() == null) goto L14;
        notiBuilder.setSmallIcon(Icon.createWithBitmap(info.getCustomIcon()));
        notiBuilder.setLargeIcon(Icon.createWithResource(appInfo.packageName, appInfo.icon));
        notiBuilder.getExtras().putBoolean(EXTRA_SHOW_BADGE, true);
    L18:
        if (info.getContentBitmap() == null) goto L20;
        notiBuilder.setStyle(new Notification.BigPictureStyle().bigPicture(info.getContentBitmap()));
    L20:
        Notification notification = notiBuilder.build();
        notification.deleteIntent = info.getDeleteIntent();
        if (info.isUseSmtPushFlag() == false) goto L23;
        notification.flags |= 536870912;
    L23:
        return notification;
    L14:
        if (info.getCustomIcon() == null) goto L16;
        notiBuilder.setSmallIcon(Icon.createWithBitmap(info.getCustomIcon()));
        goto L18
    L16:
        notiBuilder.setSmallIcon(Icon.createWithResource(appInfo.packageName, appInfo.icon));
        goto L18
    }

    boolean noteNotificationLedOp(String pkg, int uid) {
        if (this.mSmtOpsManager.noteOpNoThrow(27, uid, pkg) == 0) goto L6;
        return false;
    L6:
        return true;
    }

    static String getAutobundledSummariesKey(String pkg, String summary) {
        if (TextUtils.isEmpty(pkg) == false) goto L5;
    L9:
        return pkg;
    L5:
        if (TextUtils.isEmpty(summary) == true) goto L9;
        return pkg.concat(summary);
    }

    private void removeAutoGroupSummaryNotification(String pkg, int uid) {
        Object r0 = this.mServices.mNotificationLock;
        monitor-enter(r0);
        Iterator<NotificationRecord> iter = this.mServices.mNotificationList.iterator();     // Catch: Throwable -> L24
    L6:
        if (iter.hasNext() == false) goto L28;
        NotificationRecord r = iter.next();     // Catch: Throwable -> L24
        if (r == null) goto L6;
        if (pkg != null) goto L13;
        if (uid != (-1)) goto L13;
    L17:
        if (isPackageInWhiteList(r.getSbn().getPackageName()) == true) goto L6;
        boolean isGropSummary = r.getNotification().isGroupSummary();     // Catch: Throwable -> L24
        if (isGropSummary == false) goto L6;
        if ((r.getFlags() & 1024) <= 0) goto L6;
        iter.remove();     // Catch: Throwable -> L24
    L13:
        if (r.getSbn().getPackageName().equals(pkg) == false) goto L6;
        if (r.getSbn().getUid() != uid) goto L6;
    L28:
        monitor-exit(r0);     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        throw th;
    }

    boolean hasAutoGroupCustomSummaryLocked(StatusBarNotification sbn) {
        Object r0 = this.mServices.mNotificationLock;
        monitor-enter(r0);
        String summaryKey = getAutobundledSummariesKey(sbn.getPackageName(), "ranker_custom_group");     // Catch: Throwable -> L9
        ArrayMap<String, String> summaries = this.mServices.mAutobundledSummaries.get(Integer.valueOf(sbn.getUserId()));     // Catch: Throwable -> L9
        if (summaries != null) goto L7;
    L11:
        boolean r3 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r3;
    L7:
        if (summaries.containsKey(summaryKey) == false) goto L11;
        r3 = true;
    L9:
        th = move-exception;
        throw th;
    }

    boolean canCancelNotification(NotificationRecord r, int reason) {
        if (reason != 3) goto L5;
    L7:
        Notification n = r.getNotification();
        if (n.isGroupSummary() == true) goto L10;
        return true;
    L10:
        String pkg = r.getSbn().getPackageName();
        if (pkg != null) goto L13;
        return true;
    L13:
        Object r3 = this.mServices.mNotificationLock;
        monitor-enter(r3);
        int N = this.mServices.mNotificationList.size();     // Catch: Throwable -> L26
        int i = N - 1;     // Catch: Throwable -> L26
    L16:
        if (i < 0) goto L30;
        NotificationRecord childR = this.mServices.mNotificationList.get(i);     // Catch: Throwable -> L26
        StatusBarNotification childSbn = childR.getSbn();     // Catch: Throwable -> L26
        if (childSbn.isGroup() == false) goto L28;
        if (childR.getGroupKey().equals(r.getGroupKey()) == false) goto L28;
        if ((childR.getFlags() & 34) <= 0) goto L28;
        monitor-exit(r3);     // Catch: Throwable -> L26
        return false;
    L28:
        i = i - 1;     // Catch: Throwable -> L26
        goto L16
    L30:
        monitor-exit(r3);     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (reason == 11) goto L7;
        return true;
    }

    boolean checkCallerIsSystemApp(int uid) {
        AndroidPackage ai = this.mServices.mPackageManagerInternal.getPackage(uid);
        if (ai != null) goto L5;
        return false;
    L5:
        PackageStateInternal state = this.mServices.mPackageManagerInternal.getPackageStateInternal(ai.getPackageName());
        if (state != null) goto L8;
        return false;
    L8:
        return state.isSystem();
    }

    public boolean isAssistant(int uid) {
        AndroidPackage androidPackage = this.mServices.mPackageManagerInternal.getPackage(ASSISTANT_PKG);
        if (androidPackage != null) goto L5;
        return false;
    L5:
        if (androidPackage.getUid() != uid) goto L10;
        return true;
    L10:
        return false;
    }

    public void reportPanelShown(final boolean shown) {
        this.mServices.mHandler.post(new AnonymousClass2(this, shown));
    }
}
