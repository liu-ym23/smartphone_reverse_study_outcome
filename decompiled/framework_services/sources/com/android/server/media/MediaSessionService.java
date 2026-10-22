package com.android.server.media;

import android.R;
import android.app.ActivityManager;
import android.app.ActivityManagerInternal;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.usage.UsageStatsManagerInternal;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.media.AudioSystem;
import android.media.IRemoteSessionCallback;
import android.media.MediaCommunicationManager;
import android.media.Session2Token;
import android.media.session.IActiveSessionsListener;
import android.media.session.IOnMediaKeyEventDispatchedListener;
import android.media.session.IOnMediaKeyEventSessionChangedListener;
import android.media.session.IOnMediaKeyListener;
import android.media.session.IOnVolumeKeyLongPressListener;
import android.media.session.ISession;
import android.media.session.ISession2TokensListener;
import android.media.session.ISessionCallback;
import android.media.session.ISessionManager;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.PowerExemptionManager;
import android.os.PowerManager;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.service.notification.NotificationListenerService;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.SystemService;
import com.android.server.Watchdog;
import com.android.server.am.IApplicationFreezer;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MediaSessionService extends SystemService implements Watchdog.Monitor {
    static final boolean DEBUG = false;
    static final boolean DEBUG_KEY_EVENT = true;
    private static final int LONG_PRESS_TIMEOUT = 0;
    private static final String MEDIA_BUTTON_RECEIVER = "media_button_receiver";
    private static final int MEDIA_KEY_LISTENER_TIMEOUT = 1000;
    private static final int MULTI_TAP_TIMEOUT = 0;
    private static final int SESSION_CREATION_LIMIT_PER_UID = 100;
    private static final String TAG = "MediaSessionService";
    private static final String USAGE_STATS_ACTION_START = "start";
    private static final String USAGE_STATS_ACTION_STOP = "stop";
    private static final String USAGE_STATS_CATEGORY = "android.media";
    private static final int WAKELOCK_TIMEOUT = 5000;
    private ActivityManagerInternal mActivityManagerInternal;
    private AudioManager mAudioManager;
    private AudioPlayerStateMonitor mAudioPlayerStateMonitor;
    private MediaCommunicationManager mCommunicationManager;
    private final Context mContext;
    private FullUserRecord mCurrentFullUserRecord;
    private MediaKeyDispatcher mCustomMediaKeyDispatcher;
    private MediaSessionPolicyProvider mCustomMediaSessionPolicyProvider;
    private IMediaSessionServiceExtProxy mExt;
    private final SparseIntArray mFullUserIds;
    private MediaSessionRecord mGlobalPrioritySession;
    private final MessageHandler mHandler;
    private boolean mHasFeatureLeanback;
    private KeyguardManager mKeyguardManager;
    private final Object mLock;
    private final PowerManager.WakeLock mMediaEventWakeLock;
    private final Map<Integer, Map<String, StatusBarNotification>> mMediaNotifications;
    private NotificationListener mNotificationListener;
    private final BroadcastReceiver mNotificationListenerEnabledChangedReceiver;
    private final NotificationManager mNotificationManager;
    private final HandlerThread mRecordThread;
    final RemoteCallbackList<IRemoteSessionCallback> mRemoteVolumeControllers;
    private final MediaCommunicationManager.SessionCallback mSession2TokenCallback;
    private final List<Session2TokensListenerRecord> mSession2TokensListenerRecords;
    private final SessionManagerImpl mSessionManagerImpl;
    private final ArrayList<SessionsListenerRecord> mSessionsListeners;
    private UsageStatsManagerInternal mUsageStatsManagerInternal;
    private final Map<Integer, Set<MediaSessionRecordImpl>> mUserEngagedSessionsForFgs;
    private final SparseArray<Set<MediaSessionRecordImpl>> mUserEngagedSessionsForUsageLogging;
    private final SparseArray<FullUserRecord> mUserRecords;

    final class FullUserRecord implements MediaSessionStack.OnMediaButtonSessionChangedListener {
        private final ContentResolver mContentResolver;
        private final int mFullUserId;
        private MediaButtonReceiverHolder mLastMediaButtonReceiverHolder;
        private final HashMap<IBinder, OnMediaKeyEventDispatchedListenerRecord> mOnMediaKeyEventDispatchedListeners;
        private final HashMap<IBinder, OnMediaKeyEventSessionChangedListenerRecord> mOnMediaKeyEventSessionChangedListeners;
        private IOnMediaKeyListener mOnMediaKeyListener;
        private int mOnMediaKeyListenerUid;
        private IOnVolumeKeyLongPressListener mOnVolumeKeyLongPressListener;
        private int mOnVolumeKeyLongPressListenerUid;
        private final MediaSessionStack mPriorityStack;
        private final SparseIntArray mUidToSessionCount;
        final /* synthetic */ MediaSessionService this$0;

        final class OnMediaKeyEventDispatchedListenerRecord implements IBinder.DeathRecipient {
            public final IOnMediaKeyEventDispatchedListener callback;
            final /* synthetic */ FullUserRecord this$1;
            public final int uid;

            OnMediaKeyEventDispatchedListenerRecord(FullUserRecord this$1, IOnMediaKeyEventDispatchedListener callback, int uid) {
                this.this$1 = this$1;
                this.callback = callback;
                this.uid = uid;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
                FullUserRecord.m5732$$Nest$fgetmOnMediaKeyEventDispatchedListeners(this.this$1).remove(this.callback.asBinder());     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        final class OnMediaKeyEventSessionChangedListenerRecord implements IBinder.DeathRecipient {
            public final IOnMediaKeyEventSessionChangedListener callback;
            final /* synthetic */ FullUserRecord this$1;
            public final int uid;

            OnMediaKeyEventSessionChangedListenerRecord(FullUserRecord this$1, IOnMediaKeyEventSessionChangedListener callback, int uid) {
                this.this$1 = this$1;
                this.callback = callback;
                this.uid = uid;
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
                FullUserRecord.m5733$$Nest$fgetmOnMediaKeyEventSessionChangedListeners(this.this$1).remove(this.callback.asBinder());     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return;
            L7:
                th = move-exception;
                throw th;
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFullUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5730$$Nest$fgetmFullUserId(FullUserRecord r0) {
            return r0.mFullUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLastMediaButtonReceiverHolder, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaButtonReceiverHolder m5731$$Nest$fgetmLastMediaButtonReceiverHolder(FullUserRecord r0) {
            return r0.mLastMediaButtonReceiverHolder;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnMediaKeyEventDispatchedListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m5732$$Nest$fgetmOnMediaKeyEventDispatchedListeners(FullUserRecord r0) {
            return r0.mOnMediaKeyEventDispatchedListeners;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnMediaKeyEventSessionChangedListeners, reason: not valid java name */
        static /* bridge */ /* synthetic */ HashMap m5733$$Nest$fgetmOnMediaKeyEventSessionChangedListeners(FullUserRecord r0) {
            return r0.mOnMediaKeyEventSessionChangedListeners;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnMediaKeyListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IOnMediaKeyListener m5734$$Nest$fgetmOnMediaKeyListener(FullUserRecord r0) {
            return r0.mOnMediaKeyListener;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnMediaKeyListenerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5735$$Nest$fgetmOnMediaKeyListenerUid(FullUserRecord r0) {
            return r0.mOnMediaKeyListenerUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnVolumeKeyLongPressListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ IOnVolumeKeyLongPressListener m5736$$Nest$fgetmOnVolumeKeyLongPressListener(FullUserRecord r0) {
            return r0.mOnVolumeKeyLongPressListener;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnVolumeKeyLongPressListenerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5737$$Nest$fgetmOnVolumeKeyLongPressListenerUid(FullUserRecord r0) {
            return r0.mOnVolumeKeyLongPressListenerUid;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPriorityStack, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaSessionStack m5738$$Nest$fgetmPriorityStack(FullUserRecord r0) {
            return r0.mPriorityStack;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUidToSessionCount, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseIntArray m5739$$Nest$fgetmUidToSessionCount(FullUserRecord r0) {
            return r0.mUidToSessionCount;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmOnMediaKeyListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5740$$Nest$fputmOnMediaKeyListener(FullUserRecord r0, IOnMediaKeyListener r1) {
            r0.mOnMediaKeyListener = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmOnMediaKeyListenerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5741$$Nest$fputmOnMediaKeyListenerUid(FullUserRecord r0, int r1) {
            r0.mOnMediaKeyListenerUid = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmOnVolumeKeyLongPressListener, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5742$$Nest$fputmOnVolumeKeyLongPressListener(FullUserRecord r0, IOnVolumeKeyLongPressListener r1) {
            r0.mOnVolumeKeyLongPressListener = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmOnVolumeKeyLongPressListenerUid, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5743$$Nest$fputmOnVolumeKeyLongPressListenerUid(FullUserRecord r0, int r1) {
            r0.mOnVolumeKeyLongPressListenerUid = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetMediaButtonSessionLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ MediaSessionRecordImpl m5744$$Nest$mgetMediaButtonSessionLocked(FullUserRecord r0) {
            return r0.getMediaButtonSessionLocked();
        }

        /* JADX INFO: renamed from: -$$Nest$mpushAddressedPlayerChangedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5745$$Nest$mpushAddressedPlayerChangedLocked(FullUserRecord r0) {
            r0.pushAddressedPlayerChangedLocked();
        }

        FullUserRecord(MediaSessionService this$0, int fullUserId) {
            this.this$0 = this$0;
            this.mOnMediaKeyEventDispatchedListeners = new HashMap();
            this.mOnMediaKeyEventSessionChangedListeners = new HashMap();
            this.mUidToSessionCount = new SparseIntArray();
            this.mFullUserId = fullUserId;
            this.mContentResolver = MediaSessionService.m5690$$Nest$fgetmContext(this$0).createContextAsUser(UserHandle.of(this.mFullUserId), 0).getContentResolver();
            this.mPriorityStack = new MediaSessionStack(MediaSessionService.m5689$$Nest$fgetmAudioPlayerStateMonitor(this$0), this);
            String mediaButtonReceiverInfo = Settings.Secure.getString(this.mContentResolver, MediaSessionService.MEDIA_BUTTON_RECEIVER);
            this.mLastMediaButtonReceiverHolder = MediaButtonReceiverHolder.unflattenFromString(MediaSessionService.m5690$$Nest$fgetmContext(this$0), mediaButtonReceiverInfo);
        }

        public void destroySessionsForUserLocked(int userId) {
            List<MediaSessionRecord> sessions = this.mPriorityStack.getPriorityList(false, userId);
            Iterator<MediaSessionRecord> r1 = sessions.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            MediaSessionRecord session = r1.next();
            MediaSessionService.m5710$$Nest$mdestroySessionLocked(this.this$0, session);
            goto L4
        }

        public void addOnMediaKeyEventDispatchedListenerLocked(IOnMediaKeyEventDispatchedListener listener, int uid) {
            IBinder cbBinder = listener.asBinder();
            OnMediaKeyEventDispatchedListenerRecord cr = new OnMediaKeyEventDispatchedListenerRecord(this, listener, uid);
            this.mOnMediaKeyEventDispatchedListeners.put(cbBinder, cr);
            cbBinder.linkToDeath(cr, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "Failed to add listener", e);
            this.mOnMediaKeyEventDispatchedListeners.remove(cbBinder);
        }

        public void removeOnMediaKeyEventDispatchedListenerLocked(IOnMediaKeyEventDispatchedListener listener) {
            IBinder cbBinder = listener.asBinder();
            OnMediaKeyEventDispatchedListenerRecord cr = this.mOnMediaKeyEventDispatchedListeners.remove(cbBinder);
            cbBinder.unlinkToDeath(cr, 0);
        }

        public void addOnMediaKeyEventSessionChangedListenerLocked(IOnMediaKeyEventSessionChangedListener listener, int uid) {
            IBinder cbBinder = listener.asBinder();
            OnMediaKeyEventSessionChangedListenerRecord cr = new OnMediaKeyEventSessionChangedListenerRecord(this, listener, uid);
            this.mOnMediaKeyEventSessionChangedListeners.put(cbBinder, cr);
            cbBinder.linkToDeath(cr, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "Failed to add listener", e);
            this.mOnMediaKeyEventSessionChangedListeners.remove(cbBinder);
        }

        public void removeOnMediaKeyEventSessionChangedListener(IOnMediaKeyEventSessionChangedListener listener) {
            IBinder cbBinder = listener.asBinder();
            OnMediaKeyEventSessionChangedListenerRecord cr = this.mOnMediaKeyEventSessionChangedListeners.remove(cbBinder);
            cbBinder.unlinkToDeath(cr, 0);
        }

        public void dumpLocked(PrintWriter pw, String prefix) {
            pw.print(prefix + "Record for full_user=" + this.mFullUserId);
            int size = MediaSessionService.m5695$$Nest$fgetmFullUserIds(this.this$0).size();
            int i = 0;
        L3:
            if (i >= size) goto L10;
            if (MediaSessionService.m5695$$Nest$fgetmFullUserIds(this.this$0).keyAt(i) == MediaSessionService.m5695$$Nest$fgetmFullUserIds(this.this$0).valueAt(i)) goto L9;
            if (MediaSessionService.m5695$$Nest$fgetmFullUserIds(this.this$0).valueAt(i) != this.mFullUserId) goto L9;
            pw.print(", profile_user=" + MediaSessionService.m5695$$Nest$fgetmFullUserIds(this.this$0).keyAt(i));
        L9:
            i = i + 1;
            goto L3
        L10:
            pw.println();
            String indent = prefix + "  ";
            pw.println(indent + "Volume key long-press listener: " + this.mOnVolumeKeyLongPressListener);
            pw.println(indent + "Volume key long-press listener package: " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, this.mOnVolumeKeyLongPressListenerUid));
            pw.println(indent + "Media key listener: " + this.mOnMediaKeyListener);
            pw.println(indent + "Media key listener package: " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, this.mOnMediaKeyListenerUid));
            pw.println(indent + "OnMediaKeyEventDispatchedListener: added " + this.mOnMediaKeyEventDispatchedListeners.size() + " listener(s)");
            Iterator<OnMediaKeyEventDispatchedListenerRecord> r2 = this.mOnMediaKeyEventDispatchedListeners.values().iterator();
        L12:
            if (r2.hasNext() == false) goto L14;
            OnMediaKeyEventDispatchedListenerRecord cr = r2.next();
            pw.println(indent + "  from " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, cr.uid));
            goto L12
        L14:
            pw.println(indent + "OnMediaKeyEventSessionChangedListener: added " + this.mOnMediaKeyEventSessionChangedListeners.size() + " listener(s)");
            Iterator<OnMediaKeyEventSessionChangedListenerRecord> r3 = this.mOnMediaKeyEventSessionChangedListeners.values().iterator();
        L16:
            if (r3.hasNext() == false) goto L18;
            OnMediaKeyEventSessionChangedListenerRecord cr2 = r3.next();
            pw.println(indent + "  from " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, cr2.uid));
            goto L16
        L18:
            pw.println(indent + "Last MediaButtonReceiver: " + this.mLastMediaButtonReceiverHolder);
            this.mPriorityStack.dump(pw, indent);
        }

        @Override // com.android.server.media.MediaSessionStack.OnMediaButtonSessionChangedListener
        public void onMediaButtonSessionChanged(MediaSessionRecordImpl oldMediaButtonSession, MediaSessionRecordImpl newMediaButtonSession) {
            Log.d(MediaSessionService.TAG, "Media button session is changed to " + newMediaButtonSession);
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            if (oldMediaButtonSession != null) goto L15;
        L8:
            if (newMediaButtonSession == null) goto L10;
            rememberMediaButtonReceiverLocked(newMediaButtonSession);     // Catch: Throwable -> L6
            MediaSessionService.m5697$$Nest$fgetmHandler(this.this$0).postSessionsChanged(newMediaButtonSession);     // Catch: Throwable -> L6
        L10:
            pushAddressedPlayerChangedLocked();     // Catch: Throwable -> L6
            monitor-exit(r0);     // Catch: Throwable -> L6
            return;
        L6:
            th = move-exception;
            throw th;
        L15:
            MediaSessionService.m5697$$Nest$fgetmHandler(this.this$0).postSessionsChanged(oldMediaButtonSession);     // Catch: Throwable -> L6
            goto L8
        }

        public void rememberMediaButtonReceiverLocked(MediaSessionRecordImpl record) {
            if ((record instanceof MediaSession2Record) == false) goto L5;
            return;
        L5:
            MediaSessionRecord sessionRecord = (MediaSessionRecord) record;
            this.mLastMediaButtonReceiverHolder = sessionRecord.getMediaButtonReceiver();
            if (this.mLastMediaButtonReceiverHolder != null) goto L8;
            String mediaButtonReceiverInfo = "";
        L9:
            Settings.Secure.putString(this.mContentResolver, MediaSessionService.MEDIA_BUTTON_RECEIVER, mediaButtonReceiverInfo);
            return;
        L8:
            mediaButtonReceiverInfo = this.mLastMediaButtonReceiverHolder.flattenToString();
            goto L9
        }

        private void pushAddressedPlayerChangedLocked(IOnMediaKeyEventSessionChangedListener callback) {
            MediaSessionRecordImpl mediaButtonSession = getMediaButtonSessionLocked();     // Catch: RemoteException -> L7
            if (mediaButtonSession == null) goto L10;
            if ((mediaButtonSession instanceof MediaSessionRecord) == false) goto L16;
            MediaSessionRecord session1 = (MediaSessionRecord) mediaButtonSession;     // Catch: RemoteException -> L7
            callback.onMediaKeyEventSessionChanged(session1.getPackageName(), session1.getSessionToken());     // Catch: RemoteException -> L7
        L16:
            return;
        L10:
            if (MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0).mLastMediaButtonReceiverHolder == null) goto L12;
            String packageName = MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0).mLastMediaButtonReceiverHolder.getPackageName();     // Catch: RemoteException -> L7
            callback.onMediaKeyEventSessionChanged(packageName, null);     // Catch: RemoteException -> L7
            goto L16
        L12:
            callback.onMediaKeyEventSessionChanged("", null);     // Catch: RemoteException -> L7
        L7:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "Failed to pushAddressedPlayerChangedLocked", e);
        }

        private void pushAddressedPlayerChangedLocked() {
            Iterator<OnMediaKeyEventSessionChangedListenerRecord> r0 = this.mOnMediaKeyEventSessionChangedListeners.values().iterator();
        L4:
            if (r0.hasNext() == false) goto L6;
            OnMediaKeyEventSessionChangedListenerRecord cr = r0.next();
            pushAddressedPlayerChangedLocked(cr.callback);
            goto L4
        }

        private MediaSessionRecordImpl getMediaButtonSessionLocked() {
            if (MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$0) == false) goto L6;
            return MediaSessionService.m5696$$Nest$fgetmGlobalPrioritySession(this.this$0);
        L6:
            return this.mPriorityStack.getMediaButtonSession();
        }
    }

    final class MessageHandler extends Handler {
        private static final int MSG_SESSIONS_1_CHANGED = 1;
        private static final int MSG_SESSIONS_2_CHANGED = 2;
        private final SparseArray<Integer> mIntegerCache;
        final /* synthetic */ MediaSessionService this$0;

        MessageHandler(MediaSessionService this$0) {
            this.this$0 = this$0;
            this.mIntegerCache = new SparseArray();
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            switch(msg.what) {
                case 1: goto L6;
                case 2: goto L5;
                default: goto L9;
            };
        L5:
            this.this$0.pushSession2Changed(((Integer) msg.obj).intValue());
            return;
        L6:
            MediaSessionService.m5724$$Nest$mpushSession1Changed(this.this$0, ((Integer) msg.obj).intValue());
            return;
        }

        public void postSessionsChanged(MediaSessionRecordImpl record) {
            Integer userIdInteger = this.mIntegerCache.get(record.getUserId());
            if (userIdInteger != null) goto L6;
            userIdInteger = Integer.valueOf(record.getUserId());
            this.mIntegerCache.put(record.getUserId(), userIdInteger);
        L6:
            if ((record instanceof MediaSessionRecord) == false) goto L8;
            int msg = 1;
        L9:
            removeMessages(msg, userIdInteger);
            obtainMessage(msg, userIdInteger).sendToTarget();
            return;
        L8:
            msg = 2;
            goto L9
        }
    }

    private final class NotificationListener extends NotificationListenerService {
        final /* synthetic */ MediaSessionService this$0;

        /* synthetic */ NotificationListener(MediaSessionService r1, MediaSessionServiceIA r2) {
            this(r1);
        }

        private NotificationListener(MediaSessionService r1) {
            this.this$0 = r1;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationPosted(StatusBarNotification sbn) {
            super.onNotificationPosted(sbn);
            int uid = sbn.getUid();
            int userId = sbn.getUser().getIdentifier();
            Notification postedNotification = sbn.getNotification();
            if (postedNotification.isMediaNotification() == true) goto L6;
            return;
        L6:
            if ((postedNotification.flags & 64) != 0) goto L8;
            return;
        L8:
            Object r3 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r3);
            Map<String, StatusBarNotification> notifications = (Map) MediaSessionService.m5702$$Nest$fgetmMediaNotifications(this.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L13
            if (notifications != null) goto L15;
            notifications = new HashMap();     // Catch: Throwable -> L13
            MediaSessionService.m5702$$Nest$fgetmMediaNotifications(this.this$0).put(Integer.valueOf(uid), notifications);     // Catch: Throwable -> L13
        L15:
            StatusBarNotification previousSbn = notifications.put(sbn.getKey(), sbn);     // Catch: Throwable -> L13
            if (previousSbn == null) goto L19;
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L19:
            MediaSessionRecordImpl userEngagedRecord = getUserEngagedMediaSessionRecordForNotification(uid, postedNotification);     // Catch: Throwable -> L13
            if (userEngagedRecord == null) goto L24;
            MediaSessionService.m5725$$Nest$msetFgsActiveLocked(this.this$0, userEngagedRecord, sbn);     // Catch: Throwable -> L13
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L24:
            MediaSessionRecordImpl notificationRecord = getAnyMediaSessionRecordForNotification(uid, userId, postedNotification);     // Catch: Throwable -> L13
            if (notificationRecord == null) goto L27;
            MediaSessionService.m5726$$Nest$msetFgsInactiveIfNoSessionIsLinkedToNotification(this.this$0, notificationRecord);     // Catch: Throwable -> L13
        L27:
            monitor-exit(r3);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.service.notification.NotificationListenerService
        public void onNotificationRemoved(StatusBarNotification sbn) {
            super.onNotificationRemoved(sbn);
            Notification removedNotification = sbn.getNotification();
            int uid = sbn.getUid();
            if (removedNotification.isMediaNotification() == true) goto L5;
            return;
        L5:
            Object r2 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r2);
            Map<String, StatusBarNotification> notifications = (Map) MediaSessionService.m5702$$Nest$fgetmMediaNotifications(this.this$0).get(Integer.valueOf(uid));     // Catch: Throwable -> L12
            if (notifications == null) goto L14;
            notifications.remove(sbn.getKey());     // Catch: Throwable -> L12
            if (notifications.isEmpty() == false) goto L14;
            MediaSessionService.m5702$$Nest$fgetmMediaNotifications(this.this$0).remove(Integer.valueOf(uid));     // Catch: Throwable -> L12
        L14:
            MediaSessionRecordImpl notificationRecord = getUserEngagedMediaSessionRecordForNotification(uid, removedNotification);     // Catch: Throwable -> L12
            if (notificationRecord != null) goto L18;
            monitor-exit(r2);     // Catch: Throwable -> L12
            return;
        L18:
            MediaSessionService.m5726$$Nest$msetFgsInactiveIfNoSessionIsLinkedToNotification(this.this$0, notificationRecord);     // Catch: Throwable -> L12
            monitor-exit(r2);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        private MediaSessionRecordImpl getUserEngagedMediaSessionRecordForNotification(int uid, Notification notification) {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            Iterator r1 = ((Set) MediaSessionService.m5707$$Nest$fgetmUserEngagedSessionsForFgs(this.this$0).getOrDefault(Integer.valueOf(uid), Set.of())).iterator();     // Catch: Throwable -> L11
        L6:
            if (r1.hasNext() == false) goto L14;
            MediaSessionRecordImpl mediaSessionRecord = (MediaSessionRecordImpl) r1.next();     // Catch: Throwable -> L11
            if (mediaSessionRecord.isLinkedToNotification(notification) == false) goto L6;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return mediaSessionRecord;
        L14:
            monitor-exit(r0);     // Catch: Throwable -> L11
            return null;
        L11:
            th = move-exception;
            throw th;
        }

        private MediaSessionRecordImpl getAnyMediaSessionRecordForNotification(int uid, int userId, Notification notification) {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            FullUserRecord userRecord = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L8
            if (userRecord != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L10:
            List<MediaSessionRecord> allUserSessions = FullUserRecord.m5738$$Nest$fgetmPriorityStack(userRecord).getPriorityList(false, userId);     // Catch: Throwable -> L8
            Iterator<MediaSessionRecord> r4 = allUserSessions.iterator();     // Catch: Throwable -> L8
        L12:
            if (r4.hasNext() == false) goto L20;
            MediaSessionRecordImpl mediaSessionRecord = r4.next();     // Catch: Throwable -> L8
            if (mediaSessionRecord.getUid() != uid) goto L12;
            if (mediaSessionRecord.isLinkedToNotification(notification) == false) goto L12;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return mediaSessionRecord;
        L20:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return null;
        L8:
            th = move-exception;
            throw th;
        }
    }

    final class Session2TokensListenerRecord implements IBinder.DeathRecipient {
        public final ISession2TokensListener listener;
        final /* synthetic */ MediaSessionService this$0;
        public final int userId;

        Session2TokensListenerRecord(MediaSessionService this$0, ISession2TokensListener listener, int userId) {
            this.this$0 = this$0;
            this.listener = listener;
            this.userId = userId;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionService.m5705$$Nest$fgetmSession2TokensListenerRecords(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    class SessionManagerImpl extends ISessionManager.Stub {
        private static final String EXTRA_WAKELOCK_ACQUIRED = "android.media.AudioService.WAKELOCK_ACQUIRED";
        private static final int WAKELOCK_RELEASE_ON_FINISHED = 1980;
        private KeyEventWakeLockReceiver mKeyEventReceiver;
        private KeyEventHandler mMediaKeyEventHandler;
        private KeyEventHandler mVolumeKeyEventHandler;
        final /* synthetic */ MediaSessionService this$0;

        class KeyEventHandler {
            private static final int KEY_TYPE_MEDIA = 0;
            private static final int KEY_TYPE_VOLUME = 1;
            private boolean mIsLongPressing;
            private int mKeyType;
            private Runnable mLongPressTimeoutRunnable;
            private int mMultiTapCount;
            private int mMultiTapKeyCode;
            private Runnable mMultiTapTimeoutRunnable;
            private KeyEvent mTrackingFirstDownKeyEvent;
            final /* synthetic */ SessionManagerImpl this$1;

            /* JADX INFO: renamed from: -$$Nest$mcreateCanceledKeyEvent, reason: not valid java name */
            static /* bridge */ /* synthetic */ KeyEvent m5751$$Nest$mcreateCanceledKeyEvent(KeyEventHandler r0, KeyEvent r1) {
                return r0.createCanceledKeyEvent(r1);
            }

            /* JADX INFO: renamed from: -$$Nest$mdispatchDownAndUpKeyEventsLocked, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m5752$$Nest$mdispatchDownAndUpKeyEventsLocked(KeyEventHandler r0, String r1, int r2, int r3, boolean r4, KeyEvent r5, boolean r6, String r7, int r8, boolean r9) {
                r0.dispatchDownAndUpKeyEventsLocked(r1, r2, r3, r4, r5, r6, r7, r8, r9);
            }

            /* JADX INFO: renamed from: -$$Nest$mresetLongPressTracking, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m5753$$Nest$mresetLongPressTracking(KeyEventHandler r0) {
                r0.resetLongPressTracking();
            }

            /* JADX INFO: renamed from: -$$Nest$mresetMultiTapTrackingLocked, reason: not valid java name */
            static /* bridge */ /* synthetic */ void m5754$$Nest$mresetMultiTapTrackingLocked(KeyEventHandler r0) {
                r0.resetMultiTapTrackingLocked();
            }

            KeyEventHandler(SessionManagerImpl this$1, int keyType) {
                this.this$1 = this$1;
                this.mKeyType = keyType;
            }

            void handleMediaKeyEventLocked(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock) {
                handleKeyEventLocked(packageName, pid, uid, asSystemService, keyEvent, needWakeLock, null, 0, false);
            }

            void handleVolumeKeyEventLocked(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, String opPackageName, int stream, boolean musicOnly) {
                handleKeyEventLocked(packageName, pid, uid, asSystemService, keyEvent, false, opPackageName, stream, musicOnly);
            }

            void handleKeyEventLocked(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock, String opPackageName, int stream, boolean musicOnly) {
                if (keyEvent.isCanceled() == false) goto L6;
                return;
            L6:
                if (MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0) != null) goto L8;
            L10:
                int overriddenKeyEvents = 0;
            L11:
                cancelTrackingIfNeeded(packageName, pid, uid, asSystemService, keyEvent, needWakeLock, opPackageName, stream, musicOnly, overriddenKeyEvents);
                int overriddenKeyEvents2 = overriddenKeyEvents;
                if (needTracking(keyEvent, overriddenKeyEvents2) == true) goto L19;
                if (this.mKeyType != 1) goto L16;
                SessionManagerImpl.m5748$$Nest$mdispatchVolumeKeyEventLocked(this.this$1, packageName, opPackageName, pid, uid, asSystemService, keyEvent, stream, musicOnly);
                return;
            L16:
                SessionManagerImpl.m5747$$Nest$mdispatchMediaKeyEventLocked(this.this$1, packageName, pid, uid, asSystemService, keyEvent, needWakeLock);
                return;
            L19:
                if (isFirstDownKeyEvent(keyEvent) == false) goto L23;
                this.mTrackingFirstDownKeyEvent = keyEvent;
                this.mIsLongPressing = false;
                return;
            L23:
                if (isFirstLongPressKeyEvent(keyEvent) == false) goto L26;
                this.mIsLongPressing = true;
            L26:
                if (this.mIsLongPressing == false) goto L30;
                handleLongPressLocked(keyEvent, needWakeLock, overriddenKeyEvents2);
                return;
            L30:
                if (keyEvent.getAction() != 1) goto L55;
                this.mTrackingFirstDownKeyEvent = null;
                if (shouldTrackForMultipleTapsLocked(overriddenKeyEvents2) == true) goto L34;
                dispatchDownAndUpKeyEventsLocked(packageName, pid, uid, asSystemService, keyEvent, needWakeLock, opPackageName, stream, musicOnly);
                return;
            L34:
                if (this.mMultiTapCount != 0) goto L44;
                this.mMultiTapTimeoutRunnable = createSingleTapRunnable(packageName, pid, uid, asSystemService, keyEvent, needWakeLock, opPackageName, stream, musicOnly, MediaKeyDispatcher.isSingleTapOverridden(overriddenKeyEvents2));
                if (MediaKeyDispatcher.isSingleTapOverridden(overriddenKeyEvents2) == true) goto L38;
            L42:
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).postDelayed(this.mMultiTapTimeoutRunnable, MediaSessionService.m5729$$Nest$sfgetMULTI_TAP_TIMEOUT());
                this.mMultiTapCount = 1;
                this.mMultiTapKeyCode = keyEvent.getKeyCode();
                return;
            L38:
                if (MediaKeyDispatcher.isDoubleTapOverridden(overriddenKeyEvents2) == true) goto L42;
                if (MediaKeyDispatcher.isTripleTapOverridden(overriddenKeyEvents2) == true) goto L42;
                this.mMultiTapTimeoutRunnable.run();
                return;
            L44:
                if (this.mMultiTapCount != 1) goto L50;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this.mMultiTapTimeoutRunnable);
                this.mMultiTapTimeoutRunnable = createDoubleTapRunnable(packageName, pid, uid, asSystemService, keyEvent, needWakeLock, opPackageName, stream, musicOnly, MediaKeyDispatcher.isSingleTapOverridden(overriddenKeyEvents2), MediaKeyDispatcher.isDoubleTapOverridden(overriddenKeyEvents2));
                if (MediaKeyDispatcher.isTripleTapOverridden(overriddenKeyEvents2) == false) goto L48;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).postDelayed(this.mMultiTapTimeoutRunnable, MediaSessionService.m5729$$Nest$sfgetMULTI_TAP_TIMEOUT());
                this.mMultiTapCount = 2;
                return;
            L48:
                this.mMultiTapTimeoutRunnable.run();
                return;
            L50:
                if (this.mMultiTapCount != 2) goto L60;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this.mMultiTapTimeoutRunnable);
                onTripleTap(keyEvent);
                return;
            L60:
                return;
            L55:
                return;
            L8:
                if (MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0).getOverriddenKeyEvents() == null) goto L10;
                int overriddenKeyEvents3 = MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0).getOverriddenKeyEvents().get(Integer.valueOf(keyEvent.getKeyCode())).intValue();
                overriddenKeyEvents = overriddenKeyEvents3;
                goto L11
            }

            private boolean shouldTrackForMultipleTapsLocked(int overriddenKeyEvents) {
                if (MediaKeyDispatcher.isSingleTapOverridden(overriddenKeyEvents) == false) goto L5;
            L10:
                return true;
            L5:
                if (MediaKeyDispatcher.isDoubleTapOverridden(overriddenKeyEvents) == true) goto L10;
                if (MediaKeyDispatcher.isTripleTapOverridden(overriddenKeyEvents) == true) goto L10;
                return false;
            }

            private void cancelTrackingIfNeeded(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock, String opPackageName, int stream, boolean musicOnly, int overriddenKeyEvents) {
                if (this.mTrackingFirstDownKeyEvent != null) goto L8;
                if (this.mMultiTapTimeoutRunnable != null) goto L8;
                return;
            L8:
                if (isFirstDownKeyEvent(keyEvent) == false) goto L20;
                if (this.mLongPressTimeoutRunnable == null) goto L13;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this.mLongPressTimeoutRunnable);
                this.mLongPressTimeoutRunnable.run();
            L13:
                if (this.mMultiTapTimeoutRunnable != null) goto L15;
            L17:
                resetLongPressTracking();
                return;
            L15:
                if (keyEvent.getKeyCode() == this.mMultiTapKeyCode) goto L17;
                runExistingMultiTapRunnableLocked();
                goto L17
            L20:
                if (this.mTrackingFirstDownKeyEvent != null) goto L22;
                return;
            L22:
                if (this.mTrackingFirstDownKeyEvent.getDownTime() == keyEvent.getDownTime()) goto L24;
                return;
            L24:
                if (this.mTrackingFirstDownKeyEvent.getKeyCode() == keyEvent.getKeyCode()) goto L26;
                return;
            L26:
                if (keyEvent.getAction() == 0) goto L28;
                return;
            L28:
                if (isFirstLongPressKeyEvent(keyEvent) == false) goto L43;
                if (this.mMultiTapTimeoutRunnable == null) goto L33;
                runExistingMultiTapRunnableLocked();
            L33:
                if ((overriddenKeyEvents & 8) == 0) goto L35;
                return;
            L35:
                if (this.mKeyType != 1) goto L40;
                if (FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$1.this$0)) != null) goto L53;
                SessionManagerImpl.m5748$$Nest$mdispatchVolumeKeyEventLocked(this.this$1, packageName, opPackageName, pid, uid, asSystemService, keyEvent, stream, musicOnly);
                this.mTrackingFirstDownKeyEvent = null;
                return;
            L53:
                return;
            L40:
                if (SessionManagerImpl.m5749$$Nest$misVoiceKey(this.this$1, keyEvent.getKeyCode()) == true) goto L55;
                SessionManagerImpl.m5747$$Nest$mdispatchMediaKeyEventLocked(this.this$1, packageName, pid, uid, asSystemService, keyEvent, needWakeLock);
                this.mTrackingFirstDownKeyEvent = null;
                return;
            L55:
                return;
            L43:
                if (keyEvent.getRepeatCount() > 1) goto L45;
                return;
            L45:
                if (this.mIsLongPressing == true) goto L58;
                resetLongPressTracking();
                return;
            }

            private boolean needTracking(KeyEvent keyEvent, int overriddenKeyEvents) {
                if (isFirstDownKeyEvent(keyEvent) == true) goto L13;
                if (this.mTrackingFirstDownKeyEvent != null) goto L8;
                return false;
            L8:
                if (this.mTrackingFirstDownKeyEvent.getDownTime() == keyEvent.getDownTime()) goto L10;
            L11:
                return false;
            L10:
                if (this.mTrackingFirstDownKeyEvent.getKeyCode() != keyEvent.getKeyCode()) goto L11;
            L13:
                if (overriddenKeyEvents == 0) goto L15;
            L22:
                return true;
            L15:
                if (this.mKeyType != 1) goto L20;
                if (FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$1.this$0)) != null) goto L22;
                return false;
            L20:
                if (SessionManagerImpl.m5749$$Nest$misVoiceKey(this.this$1, keyEvent.getKeyCode()) == true) goto L22;
                return false;
            }

            private void runExistingMultiTapRunnableLocked() {
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this.mMultiTapTimeoutRunnable);
                this.mMultiTapTimeoutRunnable.run();
            }

            private void resetMultiTapTrackingLocked() {
                this.mMultiTapCount = 0;
                this.mMultiTapTimeoutRunnable = null;
                this.mMultiTapKeyCode = 0;
            }

            private void handleLongPressLocked(KeyEvent keyEvent, boolean needWakeLock, int overriddenKeyEvents) {
                if (MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0) == null) goto L17;
                if (MediaKeyDispatcher.isLongPressOverridden(overriddenKeyEvents) == false) goto L17;
                MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0).onLongPress(keyEvent);
                if (this.mLongPressTimeoutRunnable == null) goto L10;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this.mLongPressTimeoutRunnable);
            L10:
                if (keyEvent.getAction() == 0) goto L12;
                resetLongPressTracking();
                return;
            L12:
                if (this.mLongPressTimeoutRunnable != null) goto L14;
                this.mLongPressTimeoutRunnable = createLongPressTimeoutRunnable(keyEvent);
            L14:
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).postDelayed(this.mLongPressTimeoutRunnable, MediaSessionService.m5728$$Nest$sfgetLONG_PRESS_TIMEOUT());
                return;
            L17:
                if (this.mKeyType != 1) goto L23;
                if (isFirstLongPressKeyEvent(keyEvent) == false) goto L21;
                MediaSessionService.m5711$$Nest$mdispatchVolumeKeyLongPressLocked(this.this$1.this$0, this.mTrackingFirstDownKeyEvent);
            L21:
                MediaSessionService.m5711$$Nest$mdispatchVolumeKeyLongPressLocked(this.this$1.this$0, keyEvent);
                return;
            L23:
                if (isFirstLongPressKeyEvent(keyEvent) == true) goto L25;
                return;
            L25:
                if (SessionManagerImpl.m5749$$Nest$misVoiceKey(this.this$1, keyEvent.getKeyCode()) == false) goto L32;
                SessionManagerImpl.m5750$$Nest$mstartVoiceInput(this.this$1, needWakeLock);
                resetLongPressTracking();
                return;
            }

            private Runnable createLongPressTimeoutRunnable(final KeyEvent keyEvent) {
                return new AnonymousClass1(this, keyEvent);
            }

            private void resetLongPressTracking() {
                this.mTrackingFirstDownKeyEvent = null;
                this.mIsLongPressing = false;
                this.mLongPressTimeoutRunnable = null;
            }

            private KeyEvent createCanceledKeyEvent(KeyEvent keyEvent) {
                KeyEvent upEvent = KeyEvent.changeAction(keyEvent, 1);
                return KeyEvent.changeTimeRepeat(upEvent, System.currentTimeMillis(), 0, 32);
            }

            private boolean isFirstLongPressKeyEvent(KeyEvent keyEvent) {
                if ((keyEvent.getFlags() & 128) != 0) goto L5;
            L7:
                return false;
            L5:
                if (keyEvent.getRepeatCount() != 1) goto L7;
                return true;
            }

            private boolean isFirstDownKeyEvent(KeyEvent keyEvent) {
                if (keyEvent.getAction() == 0) goto L5;
            L7:
                return false;
            L5:
                if (keyEvent.getRepeatCount() != 0) goto L7;
                return true;
            }

            private void dispatchDownAndUpKeyEventsLocked(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock, String opPackageName, int stream, boolean musicOnly) {
                KeyEvent downEvent = KeyEvent.changeAction(keyEvent, 0);
                if (this.mKeyType != 1) goto L5;
                SessionManagerImpl.m5748$$Nest$mdispatchVolumeKeyEventLocked(this.this$1, packageName, opPackageName, pid, uid, asSystemService, downEvent, stream, musicOnly);
                SessionManagerImpl.m5748$$Nest$mdispatchVolumeKeyEventLocked(this.this$1, packageName, opPackageName, pid, uid, asSystemService, keyEvent, stream, musicOnly);
                return;
            L5:
                SessionManagerImpl.m5747$$Nest$mdispatchMediaKeyEventLocked(this.this$1, packageName, pid, uid, asSystemService, downEvent, needWakeLock);
                SessionManagerImpl.m5747$$Nest$mdispatchMediaKeyEventLocked(this.this$1, packageName, pid, uid, asSystemService, keyEvent, needWakeLock);
            }

            Runnable createSingleTapRunnable(final String packageName, final int pid, final int uid, final boolean asSystemService, final KeyEvent keyEvent, final boolean needWakeLock, final String opPackageName, final int stream, final boolean musicOnly, final boolean overridden) {
                return new AnonymousClass2(this, overridden, keyEvent, packageName, pid, uid, asSystemService, needWakeLock, opPackageName, stream, musicOnly);
            }

            Runnable createDoubleTapRunnable(final String packageName, final int pid, final int uid, final boolean asSystemService, final KeyEvent keyEvent, final boolean needWakeLock, final String opPackageName, final int stream, final boolean musicOnly, final boolean singleTapOverridden, final boolean doubleTapOverridden) {
                return new AnonymousClass3(this, doubleTapOverridden, keyEvent, singleTapOverridden, packageName, pid, uid, asSystemService, needWakeLock, opPackageName, stream, musicOnly);
            }

            private void onTripleTap(KeyEvent keyEvent) {
                resetMultiTapTrackingLocked();
                MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$1.this$0).onTripleTap(keyEvent);
            }
        }

        class KeyEventWakeLockReceiver extends ResultReceiver implements Runnable, PendingIntent.OnFinished {
            private final Handler mHandler;
            private int mLastTimeoutId;
            private int mRefCount;
            final /* synthetic */ SessionManagerImpl this$1;

            /* JADX INFO: renamed from: -$$Nest$fgetmLastTimeoutId, reason: not valid java name */
            static /* bridge */ /* synthetic */ int m5755$$Nest$fgetmLastTimeoutId(KeyEventWakeLockReceiver r0) {
                return r0.mLastTimeoutId;
            }

            KeyEventWakeLockReceiver(SessionManagerImpl this$1, Handler handler) {
                this.this$1 = this$1;
                super(handler);
                this.mRefCount = 0;
                this.mLastTimeoutId = 0;
                this.mHandler = handler;
            }

            public void onTimeout() {
                Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
            L8:
                th = move-exception;
                throw th;
            L5:
                if (this.mRefCount != 0) goto L10;
                monitor-exit(r0);     // Catch: Throwable -> L8
                return;
            L10:
                this.mLastTimeoutId++;     // Catch: Throwable -> L8
                this.mRefCount = 0;     // Catch: Throwable -> L8
                releaseWakeLockLocked();     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
            }

            public void acquireWakeLockLocked() {
                if (this.mRefCount != 0) goto L5;
                MediaSessionService.m5701$$Nest$fgetmMediaEventWakeLock(this.this$1.this$0).acquire();
            L5:
                this.mRefCount++;
                this.mHandler.removeCallbacks(this);
                this.mHandler.postDelayed(this, 5000);
            }

            @Override // java.lang.Runnable
            public void run() {
                onTimeout();
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode >= this.mLastTimeoutId) goto L5;
                return;
            L5:
                Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r0);
            L12:
                th = move-exception;
                throw th;
            L8:
                if (this.mRefCount <= 0) goto L14;
                this.mRefCount--;     // Catch: Throwable -> L12
                if (this.mRefCount != 0) goto L14;
                releaseWakeLockLocked();     // Catch: Throwable -> L12
            L14:
                monitor-exit(r0);     // Catch: Throwable -> L12
            }

            private void releaseWakeLockLocked() {
                MediaSessionService.m5701$$Nest$fgetmMediaEventWakeLock(this.this$1.this$0).release();
                this.mHandler.removeCallbacks(this);
            }

            @Override // android.app.PendingIntent.OnFinished
            public void onSendFinished(PendingIntent pendingIntent, Intent intent, int resultCode, String resultData, Bundle resultExtras) {
                onReceiveResult(resultCode, null);
            }
        }

        private class MediaKeyListenerResultReceiver extends ResultReceiver implements Runnable {
            private final boolean mAsSystemService;
            private boolean mHandled;
            private final KeyEvent mKeyEvent;
            private final boolean mNeedWakeLock;
            private final String mPackageName;
            private final int mPid;
            private final int mUid;
            final /* synthetic */ SessionManagerImpl this$1;

            /* synthetic */ MediaKeyListenerResultReceiver(SessionManagerImpl r1, String r2, int r3, int r4, boolean r5, KeyEvent r6, boolean r7, MediaSessionServiceIA r8) {
                this(r1, r2, r3, r4, r5, r6, r7);
            }

            private MediaKeyListenerResultReceiver(SessionManagerImpl r3, String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock) {
                this.this$1 = r3;
                super(MediaSessionService.m5697$$Nest$fgetmHandler(r3.this$0));
                MediaSessionService.m5697$$Nest$fgetmHandler(r3.this$0).postDelayed(this, 1000);
                this.mPackageName = packageName;
                this.mPid = pid;
                this.mUid = uid;
                this.mAsSystemService = asSystemService;
                this.mKeyEvent = keyEvent;
                this.mNeedWakeLock = needWakeLock;
            }

            @Override // java.lang.Runnable
            public void run() {
                Log.d(MediaSessionService.TAG, "The media key listener is timed-out for " + this.mKeyEvent);
                dispatchMediaKeyEvent();
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int resultCode, Bundle resultData) {
                if (resultCode != 1) goto L6;
                this.mHandled = true;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this);
                return;
            L6:
                dispatchMediaKeyEvent();
            }

            private void dispatchMediaKeyEvent() {
                if (this.mHandled == false) goto L5;
                return;
            L5:
                this.mHandled = true;
                MediaSessionService.m5697$$Nest$fgetmHandler(this.this$1.this$0).removeCallbacks(this);
                Object r1 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$1.this$0);
                monitor-enter(r1);
            L10:
                th = move-exception;
                throw th;
            L8:
                if (MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$1.this$0) == false) goto L12;
                SessionManagerImpl.m5747$$Nest$mdispatchMediaKeyEventLocked(this.this$1, this.mPackageName, this.mPid, this.mUid, this.mAsSystemService, this.mKeyEvent, this.mNeedWakeLock);     // Catch: Throwable -> L10
            L13:
                monitor-exit(r1);     // Catch: Throwable -> L10
                return;
            L12:
                SessionManagerImpl.m5746$$Nest$fgetmMediaKeyEventHandler(this.this$1).handleMediaKeyEventLocked(this.mPackageName, this.mPid, this.mUid, this.mAsSystemService, this.mKeyEvent, this.mNeedWakeLock);     // Catch: Throwable -> L10
                goto L13
            }
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmMediaKeyEventHandler, reason: not valid java name */
        static /* bridge */ /* synthetic */ KeyEventHandler m5746$$Nest$fgetmMediaKeyEventHandler(SessionManagerImpl r0) {
            return r0.mMediaKeyEventHandler;
        }

        /* JADX INFO: renamed from: -$$Nest$mdispatchMediaKeyEventLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5747$$Nest$mdispatchMediaKeyEventLocked(SessionManagerImpl r0, String r1, int r2, int r3, boolean r4, KeyEvent r5, boolean r6) {
            r0.dispatchMediaKeyEventLocked(r1, r2, r3, r4, r5, r6);
        }

        /* JADX INFO: renamed from: -$$Nest$mdispatchVolumeKeyEventLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5748$$Nest$mdispatchVolumeKeyEventLocked(SessionManagerImpl r0, String r1, String r2, int r3, int r4, boolean r5, KeyEvent r6, int r7, boolean r8) {
            r0.dispatchVolumeKeyEventLocked(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        /* JADX INFO: renamed from: -$$Nest$misVoiceKey, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m5749$$Nest$misVoiceKey(SessionManagerImpl r0, int r1) {
            return r0.isVoiceKey(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$mstartVoiceInput, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5750$$Nest$mstartVoiceInput(SessionManagerImpl r0, boolean r1) {
            r0.startVoiceInput(r1);
        }

        SessionManagerImpl(MediaSessionService this$0) {
            this.this$0 = this$0;
            this.mMediaKeyEventHandler = new KeyEventHandler(this, 0);
            this.mVolumeKeyEventHandler = new KeyEventHandler(this, 1);
            this.mKeyEventReceiver = new KeyEventWakeLockReceiver(this, MediaSessionService.m5697$$Nest$fgetmHandler(this.this$0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            String[] packageNames = MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).getPackageManager().getPackagesForUid(Binder.getCallingUid());
            if (packageNames != null) goto L5;
        L7:
            String packageName = "com.android.shell";
        L8:
            new MediaShellCommand(packageName).exec(this, in, out, err, args, callback, resultReceiver);
            return;
        L5:
            if (packageNames.length <= 0) goto L7;
            packageName = packageNames[0];
            goto L8
        }

        public ISession createSession(String packageName, ISessionCallback cb, String tag, Bundle sessionInfo, int userId) throws RemoteException {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            MediaServerUtils.enforcePackageName(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), packageName, uid);     // Catch: Throwable -> L22 Exception -> L24
            int resolvedUserId = handleIncomingUser(pid, uid, userId, packageName);     // Catch: Throwable -> L22 Exception -> L24
            if (cb == null) goto L27;
        L7:
            MediaSessionRecord session = MediaSessionService.m5709$$Nest$mcreateSessionInternal(this.this$0, pid, uid, resolvedUserId, packageName, cb, tag, sessionInfo);     // Catch: Throwable -> L14 Exception -> L16
            if (session == null) goto L21;
            ISession sessionBinder = session.getSessionBinder();     // Catch: Throwable -> L14 Exception -> L16
            if (sessionBinder == null) goto L19;
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).createSession_onSuccess(session);     // Catch: Throwable -> L14 Exception -> L16
            Binder.restoreCallingIdentity(token);
            return sessionBinder;
        L19:
            throw new IllegalStateException("Invalid session record");     // Catch: Throwable -> L14 Exception -> L16
        L21:
            throw new IllegalStateException("Failed to create a new session record");     // Catch: Throwable -> L14 Exception -> L16
        L27:
            throw new IllegalArgumentException("Controller callback cannot be null");     // Catch: Throwable -> L14 Exception -> L16
        L16:
            e = move-exception;
            Exception e = e;
        L29:
            Log.w(MediaSessionService.TAG, "Exception in creating a new session", e);     // Catch: Throwable -> L14
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).createSession_onException(uid, packageName, tag, e);     // Catch: Throwable -> L14
            throw e;     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            Exception e2 = th;
        L31:
            Binder.restoreCallingIdentity(token);
            throw e2;
        L24:
            e = move-exception;
            e = e;
        L22:
            th = move-exception;
            e2 = th;
            goto L31
        }

        public List<MediaSession.Token> getSessions(ComponentName componentName, int userId) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            int resolvedUserId = verifySessionsRequest(componentName, userId, pid, uid);     // Catch: Throwable -> L16
            ArrayList<MediaSession.Token> tokens = new ArrayList();     // Catch: Throwable -> L16
            Object r6 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L16
            monitor-enter(r6);     // Catch: Throwable -> L16
            List<MediaSessionRecord> records = MediaSessionService.m5716$$Nest$mgetActiveSessionsLocked(this.this$0, resolvedUserId);     // Catch: Throwable -> L9
            Iterator<MediaSessionRecord> r8 = records.iterator();     // Catch: Throwable -> L9
        L7:
            if (r8.hasNext() == false) goto L11;
            MediaSessionRecord record = r8.next();     // Catch: Throwable -> L9
            tokens.add(record.getSessionToken());     // Catch: Throwable -> L9
            goto L7
        L11:
            monitor-exit(r6);     // Catch: Throwable -> L9
            Binder.restoreCallingIdentity(token);
            return tokens;
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public MediaSession.Token getMediaKeyEventSession(String packageName) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            UserHandle userHandle = UserHandle.getUserHandleForUid(uid);
            int userId = userHandle.getIdentifier();
            long token = Binder.clearCallingIdentity();
            MediaServerUtils.enforcePackageName(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), packageName, uid);     // Catch: Throwable -> L20
            MediaSessionService.m5712$$Nest$menforceMediaPermissions(this.this$0, packageName, pid, uid, userId);     // Catch: Throwable -> L20
            Object r6 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L20
            monitor-enter(r6);     // Catch: Throwable -> L20
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L11
            if (user != null) goto L13;
            Log.w(MediaSessionService.TAG, "No matching user record to get the media key event session, userId=" + userId);     // Catch: Throwable -> L11
            monitor-exit(r6);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return null;
        L13:
            MediaSessionRecordImpl record = FullUserRecord.m5744$$Nest$mgetMediaButtonSessionLocked(user);     // Catch: Throwable -> L11
            monitor-exit(r6);     // Catch: Throwable -> L11
            if ((record instanceof MediaSessionRecord) == false) goto L22;
            MediaSession.Token r7 = ((MediaSessionRecord) record).getSessionToken();     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return r7;
        L22:
            Binder.restoreCallingIdentity(token);
            return null;
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public String getMediaKeyEventSessionPackageName(String packageName) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            UserHandle userHandle = UserHandle.getUserHandleForUid(uid);
            int userId = userHandle.getIdentifier();
            long token = Binder.clearCallingIdentity();
            MediaServerUtils.enforcePackageName(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), packageName, uid);     // Catch: Throwable -> L30
            MediaSessionService.m5712$$Nest$menforceMediaPermissions(this.this$0, packageName, pid, uid, userId);     // Catch: Throwable -> L30
            Object r6 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L30
            monitor-enter(r6);     // Catch: Throwable -> L30
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L11
            if (user != null) goto L13;
            Log.w(MediaSessionService.TAG, "No matching user record to get the media key event session package , userId=" + userId);     // Catch: Throwable -> L11
            monitor-exit(r6);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return "";
        L13:
            MediaSessionRecordImpl record = FullUserRecord.m5744$$Nest$mgetMediaButtonSessionLocked(user);     // Catch: Throwable -> L11
            if ((record instanceof MediaSessionRecord) == false) goto L20;
            String r9 = record.getPackageName();     // Catch: Throwable -> L11
            monitor-exit(r6);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r9;
        L20:
            if (FullUserRecord.m5731$$Nest$fgetmLastMediaButtonReceiverHolder(user) == null) goto L26;
            String r10 = FullUserRecord.m5731$$Nest$fgetmLastMediaButtonReceiverHolder(user).getPackageName();     // Catch: Throwable -> L11
            monitor-exit(r6);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return r10;
        L26:
            monitor-exit(r6);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(token);
            return "";
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L30
        L30:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void addSessionsListener(IActiveSessionsListener listener, ComponentName componentName, int userId) throws RemoteException {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "addSessionsListener: listener is null, ignoring");
            return;
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            int resolvedUserId = verifySessionsRequest(componentName, userId, pid, uid);     // Catch: Throwable -> L39
            Object r1 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L39
            monitor-enter(r1);     // Catch: Throwable -> L39
            int index = MediaSessionService.m5715$$Nest$mfindIndexOfSessionsListenerLocked(this.this$0, listener);     // Catch: Throwable -> L33
            if (index != (-1)) goto L49;
            SessionsListenerRecord record = new SessionsListenerRecord(this.this$0, listener, componentName, resolvedUserId, pid, uid);     // Catch: Throwable -> L25
            listener.asBinder().linkToDeath(record, 0);     // Catch: Throwable -> L25 RemoteException -> L27
            MediaSessionService.m5706$$Nest$fgetmSessionsListeners(this.this$0).add(record);     // Catch: Throwable -> L25
            monitor-exit(r1);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(token);
            return;
        L27:
            e = move-exception;
            Log.e(MediaSessionService.TAG, "ActiveSessionsListener is dead, ignoring it", e);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(token);
            return;
        L25:
            th = th;
        L35:
            monitor-exit(r1);     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            Throwable r13 = th;
        L41:
            Binder.restoreCallingIdentity(token);
            throw r13;
        L49:
            Log.w(MediaSessionService.TAG, "ActiveSessionsListener is already added, ignoring");     // Catch: Throwable -> L15
            monitor-exit(r1);     // Catch: Throwable -> L15
            Binder.restoreCallingIdentity(token);
            return;
        L15:
            th = th;
        L33:
            th = th;
        L39:
            th = move-exception;
            r13 = th;
            goto L41
        }

        public void removeSessionsListener(IActiveSessionsListener listener) throws RemoteException {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            int index = MediaSessionService.m5715$$Nest$mfindIndexOfSessionsListenerLocked(this.this$0, listener);     // Catch: Throwable -> L9
            if (index == (-1)) goto L12;
            SessionsListenerRecord record = (SessionsListenerRecord) MediaSessionService.m5706$$Nest$fgetmSessionsListeners(this.this$0).remove(index);     // Catch: Throwable -> L9
            record.listener.asBinder().unlinkToDeath(record, 0);     // Catch: Throwable -> L9 Exception -> L11
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }

        public void addSession2TokensListener(ISession2TokensListener listener, int userId) {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "addSession2TokensListener: listener is null, ignoring");
            return;
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            int resolvedUserId = handleIncomingUser(pid, uid, userId, null);     // Catch: Throwable -> L22
            Object r5 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L22
            monitor-enter(r5);     // Catch: Throwable -> L22
            int index = MediaSessionService.m5714$$Nest$mfindIndexOfSession2TokensListenerLocked(this.this$0, listener);     // Catch: Throwable -> L14
            if (index < 0) goto L16;
            Log.w(MediaSessionService.TAG, "addSession2TokensListener: listener is already added, ignoring");     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L16:
            MediaSessionService.m5705$$Nest$fgetmSession2TokensListenerRecords(this.this$0).add(new Session2TokensListenerRecord(this.this$0, listener, resolvedUserId));     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L14:
            th = move-exception;
            throw th;     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void removeSession2TokensListener(ISession2TokensListener listener) {
            Binder.getCallingPid();
            Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r4 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L18
            monitor-enter(r4);     // Catch: Throwable -> L18
            int index = MediaSessionService.m5714$$Nest$mfindIndexOfSession2TokensListenerLocked(this.this$0, listener);     // Catch: Throwable -> L10
            if (index < 0) goto L13;
            Session2TokensListenerRecord listenerRecord = (Session2TokensListenerRecord) MediaSessionService.m5705$$Nest$fgetmSession2TokensListenerRecords(this.this$0).remove(index);     // Catch: Throwable -> L10
            listenerRecord.listener.asBinder().unlinkToDeath(listenerRecord, 0);     // Catch: Throwable -> L10 Exception -> L12
        L13:
            monitor-exit(r4);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L18
        L18:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void dispatchMediaKeyEvent(String packageName, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock) {
            if (keyEvent != null) goto L5;
        L61:
            Log.w(MediaSessionService.TAG, "Attempted to dispatch null or non-media key event.");
            return;
        L5:
            if (KeyEvent.isMediaSessionKey(keyEvent.getKeyCode()) == false) goto L61;
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
        L13:
            th = th;
        L59:
            Binder.restoreCallingIdentity(token);
            throw th;
        L9:
            if (MediaSessionService.DEBUG == true) goto L69;
            boolean r5 = asSystemService;
        L19:
            if (isUserSetupComplete() == true) goto L23;
            Log.i(MediaSessionService.TAG, "Not dispatching media key event because user setup is in progress.");     // Catch: Throwable -> L13
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).dispatchMediaKeyEvent_onBeforeHandle(uid, packageName, keyEvent, "USER_SETUP_NOT_COMPLETE");     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return;
        L23:
            Object r11 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L13
            monitor-enter(r11);     // Catch: Throwable -> L13
            boolean isGlobalPriorityActive = MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$0);     // Catch: Throwable -> L33
            if (isGlobalPriorityActive == true) goto L28;
        L35:
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).dispatchMediaKeyEvent_onBeforeHandle(uid, packageName, keyEvent, null);     // Catch: Throwable -> L33
            if (isGlobalPriorityActive == false) goto L38;
        L46:
            if (isGlobalPriorityActive == false) goto L67;
            dispatchMediaKeyEventLocked(packageName, pid, uid, asSystemService, keyEvent, needWakeLock);     // Catch: Throwable -> L33
        L52:
            monitor-exit(r11);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(token);
            return;
        L67:
            this.mMediaKeyEventHandler.handleMediaKeyEventLocked(packageName, pid, uid, asSystemService, keyEvent, needWakeLock);     // Catch: Throwable -> L55
        L55:
            th = th;
        L57:
            monitor-exit(r11);     // Catch: Throwable -> L33
            throw th;     // Catch: Throwable -> L13
        L38:
            if (FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)) == null) goto L46;
            Log.d(MediaSessionService.TAG, "Send " + keyEvent + " to the media key listener");     // Catch: Throwable -> L33
            FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)).onMediaKey(keyEvent, new MediaKeyListenerResultReceiver(this, packageName, pid, uid, r5, keyEvent, needWakeLock, null));     // Catch: Throwable -> L33 RemoteException -> L44
            monitor-exit(r11);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(token);
            return;
        L45:
            Log.w(MediaSessionService.TAG, "Failed to send " + keyEvent + " to the media key listener");     // Catch: Throwable -> L33
            goto L46
        L28:
            if (uid == 1000) goto L35;
            Log.i(MediaSessionService.TAG, "Only the system can dispatch media key event to the global priority session.");     // Catch: Throwable -> L33
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).dispatchMediaKeyEvent_onBeforeHandle(uid, packageName, keyEvent, IMediaRouterServiceExt.ERROR_PERMISSION_DENIED);     // Catch: Throwable -> L33
            monitor-exit(r11);     // Catch: Throwable -> L33
            Binder.restoreCallingIdentity(token);
            return;
        L33:
            th = th;
            goto L57
        L69:
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L15
            r1.append("dispatchMediaKeyEvent, pkg=");     // Catch: Throwable -> L15
            r1.append(packageName);     // Catch: Throwable -> L15
            r1.append(" pid=");     // Catch: Throwable -> L15
            r1.append(pid);     // Catch: Throwable -> L15
            r1.append(", uid=");     // Catch: Throwable -> L15
            r1.append(uid);     // Catch: Throwable -> L15
            r1.append(", asSystem=");     // Catch: Throwable -> L15
            r5 = asSystemService;
            r1.append(r5);     // Catch: Throwable -> L13
            r1.append(", event=");     // Catch: Throwable -> L13
            r1.append(keyEvent);     // Catch: Throwable -> L13
            Log.d(MediaSessionService.TAG, r1.toString());     // Catch: Throwable -> L13
        L15:
            th = th;
            goto L59
        }

        public boolean dispatchMediaKeyEventToSessionAsSystemService(String packageName, KeyEvent keyEvent, MediaSession.Token sessionToken) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r11 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L31
            monitor-enter(r11);     // Catch: Throwable -> L31
            MediaSessionRecord record = MediaSessionService.m5719$$Nest$mgetMediaSessionRecordLocked(this.this$0, sessionToken);     // Catch: Throwable -> L15
            Log.d(MediaSessionService.TAG, "dispatchMediaKeyEventToSessionAsSystemService, pkg=" + packageName + ", pid=" + pid + ", uid=" + uid + ", sessionToken=" + sessionToken + ", event=" + keyEvent + ", session=" + record);     // Catch: Throwable -> L15
            if (record != null) goto L18;
            Log.w(MediaSessionService.TAG, "Failed to find session to dispatch key event.");     // Catch: Throwable -> L15
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).dispatchMediaKeyEventToSessionAsSystemService_onBeforeDispatch(uid, packageName, keyEvent, null, IMediaSessionServiceExt.ERROR_SESSION_NOT_FOUND);     // Catch: Throwable -> L13
            monitor-exit(r11);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return false;
        L18:
            MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).dispatchMediaKeyEventToSessionAsSystemService_onBeforeDispatch(uid, packageName, keyEvent, record, null);     // Catch: Throwable -> L13
            boolean r13 = record.sendMediaButton(packageName, pid, uid, true, keyEvent, 0, null);     // Catch: Throwable -> L25
            monitor-exit(r11);     // Catch: Throwable -> L13
            Binder.restoreCallingIdentity(token);
            return r13;
        L25:
            th = move-exception;
            Throwable r14 = th;
        L27:
            monitor-exit(r11);     // Catch: Throwable -> L13
            throw r14;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Throwable r15 = th;
        L33:
            Binder.restoreCallingIdentity(token);
            throw r15;
        L15:
            th = move-exception;
            r14 = th;
        L13:
            th = move-exception;
            r14 = th;
        L31:
            th = move-exception;
            r15 = th;
            goto L33
        }

        public void addOnMediaKeyEventDispatchedListener(IOnMediaKeyEventDispatchedListener listener) {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "addOnMediaKeyEventDispatchedListener: listener is null, ignoring");
            return;
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
            long token = Binder.clearCallingIdentity();
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (MediaSessionService.m5720$$Nest$mhasMediaControlPermission(this.this$0, pid, uid) == false) goto L30;
            Object r5 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r5);     // Catch: Throwable -> L27
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L19
            if (user == null) goto L21;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L21;
            user.addOnMediaKeyEventDispatchedListenerLocked(listener, uid);     // Catch: Throwable -> L19
            Log.d(MediaSessionService.TAG, "The MediaKeyEventDispatchedListener (" + listener.asBinder() + ") is added by " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, uid));     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L21:
            Log.w(MediaSessionService.TAG, "Only the full user can add the listener, userId=" + userId);     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L30:
            throw new SecurityException("MEDIA_CONTENT_CONTROL permission is required to  add MediaKeyEventDispatchedListener");     // Catch: Throwable -> L27
        }

        public void removeOnMediaKeyEventDispatchedListener(IOnMediaKeyEventDispatchedListener listener) {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "removeOnMediaKeyEventDispatchedListener: listener is null, ignoring");
            return;
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
            long token = Binder.clearCallingIdentity();
        L27:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (MediaSessionService.m5720$$Nest$mhasMediaControlPermission(this.this$0, pid, uid) == false) goto L30;
            Object r5 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L27
            monitor-enter(r5);     // Catch: Throwable -> L27
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L19
            if (user == null) goto L21;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L21;
            user.removeOnMediaKeyEventDispatchedListenerLocked(listener);     // Catch: Throwable -> L19
            Log.d(MediaSessionService.TAG, "The MediaKeyEventDispatchedListener (" + listener.asBinder() + ") is removed by " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, uid));     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L21:
            Log.w(MediaSessionService.TAG, "Only the full user can remove the listener, userId=" + userId);     // Catch: Throwable -> L19
            monitor-exit(r5);     // Catch: Throwable -> L19
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            th = move-exception;
            throw th;     // Catch: Throwable -> L27
        L30:
            throw new SecurityException("MEDIA_CONTENT_CONTROL permission is required to  remove MediaKeyEventDispatchedListener");     // Catch: Throwable -> L27
        }

        public void addOnMediaKeyEventSessionChangedListener(IOnMediaKeyEventSessionChangedListener listener, String packageName) {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "addOnMediaKeyEventSessionChangedListener: listener is null, ignoring");
            return;
        L5:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            UserHandle userHandle = UserHandle.getUserHandleForUid(uid);
            int userId = userHandle.getIdentifier();
            long token = Binder.clearCallingIdentity();
            MediaServerUtils.enforcePackageName(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), packageName, uid);     // Catch: Throwable -> L25
            MediaSessionService.m5712$$Nest$menforceMediaPermissions(this.this$0, packageName, pid, uid, userId);     // Catch: Throwable -> L25
            Object r6 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r6);     // Catch: Throwable -> L25
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L17
            if (user == null) goto L19;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L19;
            user.addOnMediaKeyEventSessionChangedListenerLocked(listener, uid);     // Catch: Throwable -> L17
            Log.d(MediaSessionService.TAG, "The MediaKeyEventSessionChangedListener (" + listener.asBinder() + ") is added by " + packageName);     // Catch: Throwable -> L17
            monitor-exit(r6);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            Log.w(MediaSessionService.TAG, "Only the full user can add the listener, userId=" + userId);     // Catch: Throwable -> L17
            monitor-exit(r6);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(token);
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void removeOnMediaKeyEventSessionChangedListener(IOnMediaKeyEventSessionChangedListener listener) {
            if (listener != null) goto L5;
            Log.w(MediaSessionService.TAG, "removeOnMediaKeyEventSessionChangedListener: listener is null, ignoring");
            return;
        L5:
            Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
            long token = Binder.clearCallingIdentity();
            Object r5 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L25
            monitor-enter(r5);     // Catch: Throwable -> L25
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L17
            if (user == null) goto L19;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L19;
            user.removeOnMediaKeyEventSessionChangedListener(listener);     // Catch: Throwable -> L17
            Log.d(MediaSessionService.TAG, "The MediaKeyEventSessionChangedListener (" + listener.asBinder() + ") is removed by " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, uid));     // Catch: Throwable -> L17
            monitor-exit(r5);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(token);
            return;
        L19:
            Log.w(MediaSessionService.TAG, "Only the full user can remove the listener, userId=" + userId);     // Catch: Throwable -> L17
            monitor-exit(r5);     // Catch: Throwable -> L17
            Binder.restoreCallingIdentity(token);
            return;
        L17:
            th = move-exception;
            throw th;     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void setOnVolumeKeyLongPressListener(IOnVolumeKeyLongPressListener listener) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
        L37:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L4:
            if (MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).checkPermission("android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER", pid, uid) != 0) goto L40;
            Object r4 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L37
            monitor-enter(r4);     // Catch: Throwable -> L37
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();     // Catch: Throwable -> L20
            final FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L20
            if (user == null) goto L31;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L31;
            if (FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(user) != null) goto L15;
        L22:
            FullUserRecord.m5742$$Nest$fputmOnVolumeKeyLongPressListener(user, listener);     // Catch: Throwable -> L20
            FullUserRecord.m5743$$Nest$fputmOnVolumeKeyLongPressListenerUid(user, uid);     // Catch: Throwable -> L20
            Log.d(MediaSessionService.TAG, "The volume key long-press listener " + listener + " is set by " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, uid));     // Catch: Throwable -> L20
            if (FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(user) != null) goto L43;
        L28:
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L43:
            FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(user).asBinder().linkToDeath(new AnonymousClass1(this, user), 0);     // Catch: Throwable -> L20 RemoteException -> L26
        L27:
            Log.w(MediaSessionService.TAG, "Failed to set death recipient " + FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(user));     // Catch: Throwable -> L20
            FullUserRecord.m5742$$Nest$fputmOnVolumeKeyLongPressListener(user, null);     // Catch: Throwable -> L20
            goto L28
        L15:
            if (FullUserRecord.m5737$$Nest$fgetmOnVolumeKeyLongPressListenerUid(user) == uid) goto L22;
            Log.w(MediaSessionService.TAG, "The volume key long-press listener cannot be reset by another app , mOnVolumeKeyLongPressListener=" + FullUserRecord.m5737$$Nest$fgetmOnVolumeKeyLongPressListenerUid(user) + ", uid=" + uid);     // Catch: Throwable -> L20
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L31:
            Log.w(MediaSessionService.TAG, "Only the full user can set the volume key long-press listener, userId=" + userId);     // Catch: Throwable -> L20
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L40:
            throw new SecurityException("Must hold the SET_VOLUME_KEY_LONG_PRESS_LISTENER permission.");     // Catch: Throwable -> L37
        }

        public void setOnMediaKeyListener(IOnMediaKeyListener listener) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
        L37:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L4:
            if (MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).checkPermission("android.permission.SET_MEDIA_KEY_LISTENER", pid, uid) != 0) goto L40;
            Object r4 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L37
            monitor-enter(r4);     // Catch: Throwable -> L37
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();     // Catch: Throwable -> L20
            final FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, userId);     // Catch: Throwable -> L20
            if (user == null) goto L31;
            if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L31;
            if (FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(user) != null) goto L15;
        L22:
            FullUserRecord.m5740$$Nest$fputmOnMediaKeyListener(user, listener);     // Catch: Throwable -> L20
            FullUserRecord.m5741$$Nest$fputmOnMediaKeyListenerUid(user, uid);     // Catch: Throwable -> L20
            Log.d(MediaSessionService.TAG, "The media key listener " + FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(user) + " is set by " + MediaSessionService.m5717$$Nest$mgetCallingPackageName(this.this$0, uid));     // Catch: Throwable -> L20
            if (FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(user) != null) goto L44;
        L28:
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L44:
            FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(user).asBinder().linkToDeath(new AnonymousClass2(this, user), 0);     // Catch: Throwable -> L20 RemoteException -> L26
        L27:
            Log.w(MediaSessionService.TAG, "Failed to set death recipient " + FullUserRecord.m5734$$Nest$fgetmOnMediaKeyListener(user));     // Catch: Throwable -> L20
            FullUserRecord.m5740$$Nest$fputmOnMediaKeyListener(user, null);     // Catch: Throwable -> L20
            goto L28
        L15:
            if (FullUserRecord.m5735$$Nest$fgetmOnMediaKeyListenerUid(user) == uid) goto L22;
            Log.w(MediaSessionService.TAG, "The media key listener cannot be reset by another app. , mOnMediaKeyListenerUid=" + FullUserRecord.m5735$$Nest$fgetmOnMediaKeyListenerUid(user) + ", uid=" + uid);     // Catch: Throwable -> L20
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L31:
            Log.w(MediaSessionService.TAG, "Only the full user can set the media key listener, userId=" + userId);     // Catch: Throwable -> L20
            monitor-exit(r4);     // Catch: Throwable -> L20
            Binder.restoreCallingIdentity(token);
            return;
        L20:
            th = move-exception;
            throw th;     // Catch: Throwable -> L37
        L40:
            throw new SecurityException("Must hold the SET_MEDIA_KEY_LISTENER permission.");     // Catch: Throwable -> L37
        }

        public void dispatchVolumeKeyEvent(String packageName, String opPackageName, boolean asSystemService, KeyEvent keyEvent, int stream, boolean musicOnly) {
            if (keyEvent != null) goto L5;
        L31:
            Log.w(MediaSessionService.TAG, "Attempted to dispatch null or non-volume key event.");
            return;
        L5:
            if (keyEvent.getKeyCode() != 24) goto L7;
        L11:
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Log.d(MediaSessionService.TAG, "dispatchVolumeKeyEvent, pkg=" + packageName + ", opPkg=" + opPackageName + ", pid=" + pid + ", uid=" + uid + ", asSystem=" + asSystemService + ", event=" + keyEvent + ", stream=" + stream + ", musicOnly=" + musicOnly);
            Object r12 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L28
            monitor-enter(r12);     // Catch: Throwable -> L28
        L25:
            th = th;
        L26:
            monitor-exit(r12);     // Catch: Throwable -> L25
            throw th;     // Catch: Throwable -> L28
        L15:
            if (MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$0) == true) goto L36;
            this.mVolumeKeyEventHandler.handleVolumeKeyEventLocked(packageName, pid, uid, asSystemService, keyEvent, opPackageName, stream, musicOnly);     // Catch: Throwable -> L25
        L22:
            monitor-exit(r12);     // Catch: Throwable -> L25
            Binder.restoreCallingIdentity(token);
            return;
        L36:
            dispatchVolumeKeyEventLocked(packageName, opPackageName, pid, uid, asSystemService, keyEvent, stream, musicOnly);     // Catch: Throwable -> L19
        L19:
            th = th;
        L28:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (keyEvent.getKeyCode() == 25) goto L11;
            if (keyEvent.getKeyCode() == 164) goto L11;
            goto L11
        }

        private void dispatchVolumeKeyEventLocked(String packageName, String opPackageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, int stream, boolean musicOnly) {
            boolean up = false;
            if (keyEvent.getAction() != 0) goto L5;
            boolean down = true;
        L7:
            if (keyEvent.getAction() != 1) goto L9;
            up = true;
        L9:
            int direction = 0;
            boolean isMute = false;
            switch(keyEvent.getKeyCode()) {
                case 24: goto L14;
                case 25: goto L13;
                case 164: goto L12;
                default: goto L15;
            };
        L12:
            isMute = true;
            goto L15
        L13:
            direction = -1;
            goto L15
        L14:
            direction = 1;
        L15:
            if (down == true) goto L18;
            if (up == true) goto L18;
            return;
        L18:
            if (musicOnly == true) goto L22;
            if (up == false) goto L21;
            int flags = 4096 | 20;
            int flags2 = flags;
        L23:
            if (direction == 0) goto L28;
            if (up == false) goto L26;
            int direction2 = 0;
        L27:
            dispatchAdjustVolumeLocked(packageName, opPackageName, pid, uid, asSystemService, stream, direction2, flags2, musicOnly);
            return;
        L26:
            direction2 = direction;
            goto L27
        L28:
            if (isMute == false) goto L36;
            if (down == true) goto L31;
            return;
        L31:
            if (keyEvent.getRepeatCount() != 0) goto L38;
            dispatchAdjustVolumeLocked(packageName, opPackageName, pid, uid, asSystemService, stream, 101, flags2, musicOnly);
            return;
        L38:
            return;
        L36:
            return;
        L21:
            int flags3 = 4096 | 17;
            flags2 = flags3;
            goto L23
        L22:
            flags2 = 4096;
            goto L23
        L5:
            down = false;
            goto L7
        }

        public void dispatchVolumeKeyEventToSessionAsSystemService(String packageName, String opPackageName, KeyEvent keyEvent, MediaSession.Token sessionToken) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r13 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L44
            monitor-enter(r13);     // Catch: Throwable -> L44
            MediaSessionRecord record = MediaSessionService.m5719$$Nest$mgetMediaSessionRecordLocked(this.this$0, sessionToken);     // Catch: Throwable -> L14
            Log.d(MediaSessionService.TAG, "dispatchVolumeKeyEventToSessionAsSystemService, pkg=" + packageName + ", opPkg=" + opPackageName + ", pid=" + pid + ", uid=" + uid + ", sessionToken=" + sessionToken + ", event=" + keyEvent + ", session=" + record);     // Catch: Throwable -> L14
            if (record != null) goto L20;
            Log.w(MediaSessionService.TAG, "Failed to find session to dispatch key event, token=" + sessionToken + ". Fallbacks to the default handling.");     // Catch: Throwable -> L14
            dispatchVolumeKeyEventLocked(packageName, opPackageName, pid, uid, true, keyEvent, Integer.MIN_VALUE, false);     // Catch: Throwable -> L16
            monitor-exit(r13);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L20:
            if (record.canHandleVolumeKey() == true) goto L29;
            Log.d(MediaSessionService.TAG, "Session with packageName=" + record.getPackageName() + " doesn't support volume adjustment. Fallbacks to the default handling.");     // Catch: Throwable -> L14
            dispatchVolumeKeyEventLocked(packageName, opPackageName, pid, uid, true, keyEvent, Integer.MIN_VALUE, false);     // Catch: Throwable -> L16
            monitor-exit(r13);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L29:
            switch(keyEvent.getAction()) {
                case 0: goto L33;
                case 1: goto L31;
                default: goto L39;
            };     // Catch: Throwable -> L14
        L31:
            record.adjustVolume(packageName, opPackageName, pid, uid, true, 0, 4116, false);     // Catch: Throwable -> L14
        L39:
            monitor-exit(r13);     // Catch: Throwable -> L14
            Binder.restoreCallingIdentity(token);
            return;
        L33:
            switch(keyEvent.getKeyCode()) {
                case 24: goto L37;
                case 25: goto L36;
                case 164: goto L35;
                default: goto L34;
            };     // Catch: Throwable -> L14
        L34:
            int direction = 0;
        L38:
            record.adjustVolume(packageName, opPackageName, pid, uid, true, direction, 1, false);     // Catch: Throwable -> L14
            goto L39
        L35:
            direction = 101;
            goto L38
        L36:
            direction = -1;
            goto L38
        L37:
            direction = 1;
        L16:
            th = th;
        L42:
            monitor-exit(r13);     // Catch: Throwable -> L14
            throw th;     // Catch: Throwable -> L44
        L14:
            th = th;
        L44:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void dispatchAdjustVolume(String packageName, String opPackageName, int suggestedStream, int delta, int flags) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r13 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L13
            monitor-enter(r13);     // Catch: Throwable -> L13
            dispatchAdjustVolumeLocked(packageName, opPackageName, pid, uid, false, suggestedStream, delta, flags, false);     // Catch: Throwable -> L10
            monitor-exit(r13);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);
            return;
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        }

        public void registerRemoteSessionCallback(IRemoteSessionCallback rvc) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r4 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
            MediaSessionService.m5713$$Nest$menforceStatusBarServicePermission(this.this$0, "listen for volume changes", pid, uid);     // Catch: Throwable -> L10
            this.this$0.mRemoteVolumeControllers.register(rvc);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
            monitor-exit(r4);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public void unregisterRemoteSessionCallback(IRemoteSessionCallback rvc) {
            int pid = Binder.getCallingPid();
            int uid = Binder.getCallingUid();
            long token = Binder.clearCallingIdentity();
            Object r4 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r4);
            MediaSessionService.m5713$$Nest$menforceStatusBarServicePermission(this.this$0, "listen for volume changes", pid, uid);     // Catch: Throwable -> L10
            this.this$0.mRemoteVolumeControllers.unregister(rvc);     // Catch: Throwable -> L10
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
            monitor-exit(r4);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L10:
            th = move-exception;
            Binder.restoreCallingIdentity(token);     // Catch: Throwable -> L8
            throw th;     // Catch: Throwable -> L8
        }

        public boolean isGlobalPriorityActive() {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            boolean r1 = MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$0);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (MediaServerUtils.checkDumpPermission(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), MediaSessionService.TAG, pw) == true) goto L5;
            return;
        L5:
            pw.println("MEDIA SESSION SERVICE (dumpsys media_session)");
            pw.println();
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            pw.println(MediaSessionService.m5706$$Nest$fgetmSessionsListeners(this.this$0).size() + " sessions listeners.");     // Catch: Throwable -> L10
            pw.println("Global priority session is " + MediaSessionService.m5696$$Nest$fgetmGlobalPrioritySession(this.this$0));     // Catch: Throwable -> L10
            if (MediaSessionService.m5696$$Nest$fgetmGlobalPrioritySession(this.this$0) == null) goto L12;
            MediaSessionService.m5696$$Nest$fgetmGlobalPrioritySession(this.this$0).dump(pw, "  ");     // Catch: Throwable -> L10
        L12:
            pw.println("User Records:");     // Catch: Throwable -> L10
            int count = MediaSessionService.m5708$$Nest$fgetmUserRecords(this.this$0).size();     // Catch: Throwable -> L10
            int i = 0;
        L13:
            if (i >= count) goto L15;
            ((FullUserRecord) MediaSessionService.m5708$$Nest$fgetmUserRecords(this.this$0).valueAt(i)).dumpLocked(pw, "");     // Catch: Throwable -> L10
            i = i + 1;     // Catch: Throwable -> L10
            goto L13
        L15:
            MediaSessionService.m5689$$Nest$fgetmAudioPlayerStateMonitor(this.this$0).dump(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), pw, "");     // Catch: Throwable -> L10
            monitor-exit(r0);     // Catch: Throwable -> L10
            MediaSessionDeviceConfig.dump(pw, "");
            return;
        L10:
            th = move-exception;
            throw th;
        }

        public boolean isTrusted(String controllerPackageName, int controllerPid, int controllerUid) {
            int uid = Binder.getCallingUid();
            int userId = UserHandle.getUserHandleForUid(uid).getIdentifier();
            boolean r3 = false;
            if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).filterAppAccess(controllerPackageName, uid, userId) == false) goto L5;
            return false;
        L5:
            long token = Binder.clearCallingIdentity();
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(token);
            throw th;
        L7:
            if (MediaSessionService.m5720$$Nest$mhasMediaControlPermission(this.this$0, controllerPid, controllerUid) == true) goto L13;
            if (hasEnabledNotificationListener(userId, controllerPackageName, controllerUid) == true) goto L13;
        L14:
            Binder.restoreCallingIdentity(token);
            return r3;
        L13:
            r3 = true;
            goto L14
        }

        public void setCustomMediaKeyDispatcher(String name) {
            MediaSessionService.m5721$$Nest$minstantiateCustomDispatcher(this.this$0, name);
        }

        public void setCustomMediaSessionPolicyProvider(String name) {
            MediaSessionService.m5722$$Nest$minstantiateCustomProvider(this.this$0, name);
        }

        public boolean hasCustomMediaKeyDispatcher(String componentName) {
            if (MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$0) != null) goto L6;
            return false;
        L6:
            return TextUtils.equals(componentName, MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$0).getClass().getName());
        }

        public boolean hasCustomMediaSessionPolicyProvider(String componentName) {
            if (MediaSessionService.m5693$$Nest$fgetmCustomMediaSessionPolicyProvider(this.this$0) != null) goto L6;
            return false;
        L6:
            return TextUtils.equals(componentName, MediaSessionService.m5693$$Nest$fgetmCustomMediaSessionPolicyProvider(this.this$0).getClass().getName());
        }

        public int getSessionPolicies(MediaSession.Token token) {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionRecord record = MediaSessionService.m5719$$Nest$mgetMediaSessionRecordLocked(this.this$0, token);     // Catch: Throwable -> L9
            if (record == null) goto L12;
            int r2 = record.getSessionPolicies();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r2;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return 0;
        L9:
            th = move-exception;
            throw th;
        }

        public void setSessionPolicies(MediaSession.Token token, int policies) {
            long callingIdentityToken = Binder.clearCallingIdentity();
            Object r2 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);     // Catch: Throwable -> L15
            monitor-enter(r2);     // Catch: Throwable -> L15
            MediaSessionRecord record = MediaSessionService.m5719$$Nest$mgetMediaSessionRecordLocked(this.this$0, token);     // Catch: Throwable -> L8
            FullUserRecord user = MediaSessionService.m5718$$Nest$mgetFullUserRecordLocked(this.this$0, record.getUserId());     // Catch: Throwable -> L8
            if (user == null) goto L10;
            record.setSessionPolicies(policies);     // Catch: Throwable -> L8
            FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).updateMediaButtonSessionBySessionPolicyChange(record);     // Catch: Throwable -> L8
        L10:
            monitor-exit(r2);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(callingIdentityToken);
            return;
        L8:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            Binder.restoreCallingIdentity(callingIdentityToken);
            throw th;
        }

        private int verifySessionsRequest(ComponentName componentName, int userId, int pid, int uid) {
            String packageName = null;
            if (componentName == null) goto L5;
            packageName = componentName.getPackageName();
            MediaServerUtils.enforcePackageName(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0), packageName, uid);
        L5:
            int resolvedUserId = handleIncomingUser(pid, uid, userId, packageName);
            MediaSessionService.m5712$$Nest$menforceMediaPermissions(this.this$0, packageName, pid, uid, resolvedUserId);
            return resolvedUserId;
        }

        private int handleIncomingUser(int pid, int uid, int userId, String packageName) {
            int callingUserId = UserHandle.getUserHandleForUid(uid).getIdentifier();
            if (userId != callingUserId) goto L6;
            return userId;
        L6:
            if (MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).checkPermission("android.permission.INTERACT_ACROSS_USERS_FULL", pid, uid) != 0) goto L8;
            boolean canInteractAcrossUsersFull = true;
        L9:
            if (canInteractAcrossUsersFull == false) goto L16;
            if (userId == UserHandle.CURRENT.getIdentifier()) goto L13;
            return userId;
        L13:
            return ActivityManager.getCurrentUser();
        L16:
            throw new SecurityException("Permission denied while calling from " + packageName + " with user id: " + userId + "; Need to run as either the calling user id (" + callingUserId + "), or with android.permission.INTERACT_ACROSS_USERS_FULL permission");
        L8:
            canInteractAcrossUsersFull = false;
            goto L9
        }

        private boolean hasEnabledNotificationListener(int callingUserId, String controllerPackageName, int controllerUid) {
            int controllerUserId = UserHandle.getUserHandleForUid(controllerUid).getIdentifier();
            if (callingUserId == controllerUserId) goto L21;
            return false;
        L21:
            int actualControllerUid = MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).getPackageManager().getPackageUidAsUser(controllerPackageName, UserHandle.getUserId(controllerUid));     // Catch: PackageManager.NameNotFoundException -> L9
            if (controllerUid == actualControllerUid) goto L12;
            Log.w(MediaSessionService.TAG, "Failed to check enabled notification listener. Package name and UID doesn't match");     // Catch: PackageManager.NameNotFoundException -> L9
            return false;
        L12:
            if (MediaSessionService.m5703$$Nest$fgetmNotificationManager(this.this$0).hasEnabledNotificationListener(controllerPackageName, UserHandle.getUserHandleForUid(controllerUid)) == false) goto L16;
            return true;
        L16:
            if (MediaSessionService.DEBUG == false) goto L18;
            Log.d(MediaSessionService.TAG, controllerPackageName + " (uid=" + controllerUid + ") doesn't have an enabled notification listener");
        L18:
            return false;
        L19:
            Log.w(MediaSessionService.TAG, "Failed to check enabled notification listener. Package name doesn't exist");
            return false;
        }

        private void dispatchAdjustVolumeLocked(final String packageName, final String opPackageName, final int pid, final int uid, final boolean asSystemService, final int suggestedStream, final int direction, final int flags, boolean musicOnly) {
            boolean r2 = true;
            MediaSessionRecordImpl topSession = MediaSessionService.m5694$$Nest$fgetmExt(this.this$0).getTopPriorityVolumeSession(FullUserRecord.m5738$$Nest$fgetmPriorityStack(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)).getPriorityList(true, -1));
            if (MediaSessionService.m5723$$Nest$misGlobalPriorityActiveLocked(this.this$0) == false) goto L5;
            MediaSessionRecordImpl session = MediaSessionService.m5696$$Nest$fgetmGlobalPrioritySession(this.this$0);
        L9:
            if (isValidLocalStreamType(suggestedStream) == true) goto L11;
        L13:
            r2 = false;
        L14:
            boolean preferSuggestedStream = r2;
            if (session == null) goto L22;
            if (session.getUid() == uid) goto L22;
            if (MediaSessionService.m5689$$Nest$fgetmAudioPlayerStateMonitor(this.this$0).hasUidPlayedAudioLast(uid) == false) goto L22;
            Log.d(MediaSessionService.TAG, "Ignoring session=" + session + " and adjusting suggestedStream=" + suggestedStream + " instead");
            session = null;
        L22:
            if (session == null) goto L27;
            if (preferSuggestedStream == true) goto L27;
            Log.d(MediaSessionService.TAG, "Adjusting " + session + " by " + direction + ". flags=" + flags + ", suggestedStream=" + suggestedStream + ", preferSuggestedStream=" + preferSuggestedStream);
            session.adjustVolume(packageName, opPackageName, pid, uid, asSystemService, direction, flags, true);
            return;
        L27:
            Log.d(MediaSessionService.TAG, "Adjusting suggestedStream=" + suggestedStream + " by " + direction + ". flags=" + flags + ", preferSuggestedStream=" + preferSuggestedStream + ", session=" + session);
            if (musicOnly == true) goto L30;
        L33:
            MediaSessionService.m5697$$Nest$fgetmHandler(this.this$0).post(new AnonymousClass3(this, asSystemService, opPackageName, uid, pid, suggestedStream, direction, flags, packageName));
            return;
        L30:
            if (AudioSystem.isStreamActive(3, 0) == true) goto L33;
            Log.d(MediaSessionService.TAG, "Nothing is playing on the music stream. Skipping volume event, flags=" + flags);
            return;
        L11:
            if (AudioSystem.isStreamActive(suggestedStream, 0) == false) goto L13;
        L5:
            if (topSession == null) goto L7;
            session = topSession;
            goto L9
        L7:
            session = FullUserRecord.m5738$$Nest$fgetmPriorityStack(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)).getDefaultVolumeSession();
            goto L9
        }

        private void dispatchMediaKeyEventLocked(String packageName, int pid, int uid, boolean asSystemService, KeyEvent keyEvent, boolean needWakeLock) {
            if ((FullUserRecord.m5744$$Nest$mgetMediaButtonSessionLocked(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)) instanceof MediaSession2Record) == false) goto L5;
            return;
        L5:
            MediaSessionRecord session = null;
            MediaButtonReceiverHolder mediaButtonReceiverHolder = null;
            if (MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$0) == null) goto L14;
            MediaSession.Token token = MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$0).getMediaSession(keyEvent, uid, asSystemService);
            if (token == null) goto L10;
            session = MediaSessionService.m5719$$Nest$mgetMediaSessionRecordLocked(this.this$0, token);
        L10:
            if (session != null) goto L14;
            PendingIntent pi = MediaSessionService.m5692$$Nest$fgetmCustomMediaKeyDispatcher(this.this$0).getMediaButtonReceiver(keyEvent, uid, asSystemService);
            if (pi == null) goto L14;
            mediaButtonReceiverHolder = MediaButtonReceiverHolder.create(FullUserRecord.m5730$$Nest$fgetmFullUserId(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)), pi, "");
        L14:
            if (session != null) goto L20;
            if (mediaButtonReceiverHolder != null) goto L20;
            MediaSessionRecord session2 = (MediaSessionRecord) FullUserRecord.m5744$$Nest$mgetMediaButtonSessionLocked(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0));
            if (session2 != null) goto L19;
            MediaButtonReceiverHolder mediaButtonReceiverHolder2 = FullUserRecord.m5731$$Nest$fgetmLastMediaButtonReceiverHolder(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0));
            MediaSessionRecord session3 = session2;
        L21:
            int r0 = -1;
            if (session3 == null) goto L40;
            Log.d(MediaSessionService.TAG, "Sending " + keyEvent + " to " + session3);
            if (needWakeLock == false) goto L27;
            this.mKeyEventReceiver.acquireWakeLockLocked();
        L27:
            if (needWakeLock == false) goto L29;
            r0 = KeyEventWakeLockReceiver.m5755$$Nest$fgetmLastTimeoutId(this.mKeyEventReceiver);
        L29:
            session3.sendMediaButton(packageName, pid, uid, asSystemService, keyEvent, r0, this.mKeyEventReceiver);
            MediaSessionRecord session4 = session3;
            Iterator r1 = FullUserRecord.m5732$$Nest$fgetmOnMediaKeyEventDispatchedListeners(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)).values().iterator();     // Catch: RemoteException -> L35
        L32:
            if (r1.hasNext() == false) goto L72;
            ((FullUserRecord.OnMediaKeyEventDispatchedListenerRecord) r1.next()).callback.onMediaKeyEventDispatched(keyEvent, session4.getPackageName(), session4.getSessionToken());     // Catch: RemoteException -> L35
        L72:
            return;
        L35:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "Failed to send callback", e);
            goto L72
        L40:
            if (mediaButtonReceiverHolder2 == null) goto L61;
            if (needWakeLock == false) goto L43;
            this.mKeyEventReceiver.acquireWakeLockLocked();
        L43:
            if (asSystemService == false) goto L45;
            String reportedPackageName = MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).getPackageName();
        L46:
            Context r2 = MediaSessionService.m5690$$Nest$fgetmContext(this.this$0);
            MediaSessionService r4 = this.this$0;
            if (needWakeLock == false) goto L49;
            r0 = KeyEventWakeLockReceiver.m5755$$Nest$fgetmLastTimeoutId(this.mKeyEventReceiver);
        L49:
            MediaButtonReceiverHolder mediaButtonReceiverHolder3 = mediaButtonReceiverHolder2;
            boolean sent = mediaButtonReceiverHolder3.send(r2, keyEvent, r4, packageName, pid, uid, reportedPackageName, r0, this.mKeyEventReceiver, MediaSessionService.m5697$$Nest$fgetmHandler(this.this$0));
            if (sent == false) goto L73;
            String pkgName = mediaButtonReceiverHolder3.getPackageName();
            Iterator r5 = FullUserRecord.m5732$$Nest$fgetmOnMediaKeyEventDispatchedListeners(MediaSessionService.m5691$$Nest$fgetmCurrentFullUserRecord(this.this$0)).values().iterator();
        L53:
            if (r5.hasNext() == false) goto L74;
            FullUserRecord.OnMediaKeyEventDispatchedListenerRecord cr = (FullUserRecord.OnMediaKeyEventDispatchedListenerRecord) r5.next();
            cr.callback.onMediaKeyEventDispatched(keyEvent, pkgName, null);     // Catch: RemoteException -> L57
        L57:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "Failed notify key event dispatch, uid=" + cr.uid, e);
            goto L53
        L74:
            return;
        L73:
            return;
        L45:
            reportedPackageName = packageName;
            goto L46
        L61:
            return;
        L19:
            mediaButtonReceiverHolder2 = mediaButtonReceiverHolder;
            session3 = session2;
        L20:
            mediaButtonReceiverHolder2 = mediaButtonReceiverHolder;
            session3 = session;
            goto L21
        }

        private void startVoiceInput(boolean needWakeLock) {
            PowerManager pm = (PowerManager) MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).getSystemService("power");
            boolean r3 = false;
            if (MediaSessionService.m5699$$Nest$fgetmKeyguardManager(this.this$0) != null) goto L5;
        L7:
            boolean isLocked = false;
        L9:
            if (isLocked == false) goto L11;
        L13:
            Intent voiceIntent = new Intent("android.speech.action.VOICE_SEARCH_HANDS_FREE");
            if (isLocked == true) goto L16;
        L19:
            voiceIntent.putExtra("android.speech.extras.EXTRA_SECURE", r3);
            Log.i(MediaSessionService.TAG, "voice-based interactions: about to use ACTION_VOICE_SEARCH_HANDS_FREE");
            Intent voiceIntent2 = voiceIntent;
        L20:
            if (needWakeLock == false) goto L41;
            MediaSessionService.m5701$$Nest$fgetmMediaEventWakeLock(this.this$0).acquire();
        L41:
            voiceIntent2.setFlags(276824064);     // Catch: Throwable -> L26 ActivityNotFoundException -> L28
            if (MediaSessionService.DEBUG == false) goto L30;
            Log.d(MediaSessionService.TAG, "voiceIntent: " + voiceIntent2);     // Catch: Throwable -> L26 ActivityNotFoundException -> L28
        L30:
            MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).startActivityAsUser(voiceIntent2, UserHandle.CURRENT);     // Catch: Throwable -> L26 ActivityNotFoundException -> L28
            if (needWakeLock == false) goto L37;
        L32:
            MediaSessionService.m5701$$Nest$fgetmMediaEventWakeLock(this.this$0).release();
            return;
        L37:
            return;
        L28:
            e = move-exception;
            Log.w(MediaSessionService.TAG, "No activity for search: " + e);     // Catch: Throwable -> L26
            if (needWakeLock == true) goto L32;
            return;
        L26:
            th = move-exception;
            if (needWakeLock == false) goto L40;
            MediaSessionService.m5701$$Nest$fgetmMediaEventWakeLock(this.this$0).release();
        L40:
            throw th;
        L16:
            if (MediaSessionService.m5699$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardSecure() == false) goto L19;
            r3 = true;
            goto L19
        L11:
            if (pm.isScreenOn() == false) goto L13;
            voiceIntent2 = new Intent("android.speech.action.WEB_SEARCH");
            Log.i(MediaSessionService.TAG, "voice-based interactions: about to use ACTION_WEB_SEARCH");
            goto L20
        L5:
            if (MediaSessionService.m5699$$Nest$fgetmKeyguardManager(this.this$0).isKeyguardLocked() == false) goto L7;
            isLocked = true;
            goto L9
        }

        private boolean isVoiceKey(int keyCode) {
            if (keyCode != 79) goto L5;
        L10:
            return true;
        L5:
            if (MediaSessionService.m5698$$Nest$fgetmHasFeatureLeanback(this.this$0) == false) goto L7;
        L9:
            return false;
        L7:
            if (keyCode != 85) goto L9;
            goto L9
        }

        private boolean isUserSetupComplete() {
            if (Settings.Secure.getIntForUser(MediaSessionService.m5690$$Nest$fgetmContext(this.this$0).getContentResolver(), "user_setup_complete", 0, UserHandle.CURRENT.getIdentifier()) == 0) goto L6;
            return true;
        L6:
            return false;
        }

        private boolean isValidLocalStreamType(int streamType) {
            if (streamType >= 0) goto L4;
        L6:
            return false;
        L4:
            if (streamType > 5) goto L6;
            return true;
        }

        public void expireTempEngagedSessions() {
        }
    }

    final class SessionsListenerRecord implements IBinder.DeathRecipient {
        public final ComponentName componentName;
        public final IActiveSessionsListener listener;
        public final int pid;
        final /* synthetic */ MediaSessionService this$0;
        public final int uid;
        public final int userId;

        SessionsListenerRecord(MediaSessionService this$0, IActiveSessionsListener listener, ComponentName componentName, int userId, int pid, int uid) {
            this.this$0 = this$0;
            this.listener = listener;
            this.componentName = componentName;
            this.userId = userId;
            this.pid = pid;
            this.uid = uid;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Object r0 = MediaSessionService.m5700$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
            MediaSessionService.m5706$$Nest$fgetmSessionsListeners(this.this$0).remove(this);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$dlVeOBNx_uSHjGzXxTVqSiM_-dE, reason: not valid java name */
    public static /* synthetic */ void m5686$r8$lambda$dlVeOBNx_uSHjGzXxTVqSiM_dE(MediaSessionService r0) {
        r0.notifyGlobalPrioritySessionActiveChanged();
    }

    /* JADX INFO: renamed from: $r8$lambda$wQ-E073jQXHvlDPn3vDMgSXs45g, reason: not valid java name */
    public static /* synthetic */ void m5687$r8$lambda$wQE073jQXHvlDPn3vDMgSXs45g(MediaSessionService r0, AudioPlaybackConfiguration r1, boolean r2) {
        r0.lambda$onStart$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager m5688$$Nest$fgetmAudioManager(MediaSessionService r0) {
        return r0.mAudioManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioPlayerStateMonitor, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioPlayerStateMonitor m5689$$Nest$fgetmAudioPlayerStateMonitor(MediaSessionService r0) {
        return r0.mAudioPlayerStateMonitor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m5690$$Nest$fgetmContext(MediaSessionService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCurrentFullUserRecord, reason: not valid java name */
    static /* bridge */ /* synthetic */ FullUserRecord m5691$$Nest$fgetmCurrentFullUserRecord(MediaSessionService r0) {
        return r0.mCurrentFullUserRecord;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCustomMediaKeyDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaKeyDispatcher m5692$$Nest$fgetmCustomMediaKeyDispatcher(MediaSessionService r0) {
        return r0.mCustomMediaKeyDispatcher;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCustomMediaSessionPolicyProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionPolicyProvider m5693$$Nest$fgetmCustomMediaSessionPolicyProvider(MediaSessionService r0) {
        return r0.mCustomMediaSessionPolicyProvider;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IMediaSessionServiceExtProxy m5694$$Nest$fgetmExt(MediaSessionService r0) {
        return r0.mExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFullUserIds, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseIntArray m5695$$Nest$fgetmFullUserIds(MediaSessionService r0) {
        return r0.mFullUserIds;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmGlobalPrioritySession, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionRecord m5696$$Nest$fgetmGlobalPrioritySession(MediaSessionService r0) {
        return r0.mGlobalPrioritySession;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ MessageHandler m5697$$Nest$fgetmHandler(MediaSessionService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHasFeatureLeanback, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5698$$Nest$fgetmHasFeatureLeanback(MediaSessionService r0) {
        return r0.mHasFeatureLeanback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmKeyguardManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ KeyguardManager m5699$$Nest$fgetmKeyguardManager(MediaSessionService r0) {
        return r0.mKeyguardManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5700$$Nest$fgetmLock(MediaSessionService r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaEventWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m5701$$Nest$fgetmMediaEventWakeLock(MediaSessionService r0) {
        return r0.mMediaEventWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMediaNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5702$$Nest$fgetmMediaNotifications(MediaSessionService r0) {
        return r0.mMediaNotifications;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmNotificationManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ NotificationManager m5703$$Nest$fgetmNotificationManager(MediaSessionService r0) {
        return r0.mNotificationManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRecordThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ HandlerThread m5704$$Nest$fgetmRecordThread(MediaSessionService r0) {
        return r0.mRecordThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSession2TokensListenerRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5705$$Nest$fgetmSession2TokensListenerRecords(MediaSessionService r0) {
        return r0.mSession2TokensListenerRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSessionsListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ ArrayList m5706$$Nest$fgetmSessionsListeners(MediaSessionService r0) {
        return r0.mSessionsListeners;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserEngagedSessionsForFgs, reason: not valid java name */
    static /* bridge */ /* synthetic */ Map m5707$$Nest$fgetmUserEngagedSessionsForFgs(MediaSessionService r0) {
        return r0.mUserEngagedSessionsForFgs;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserRecords, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArray m5708$$Nest$fgetmUserRecords(MediaSessionService r0) {
        return r0.mUserRecords;
    }

    /* JADX INFO: renamed from: -$$Nest$mcreateSessionInternal, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionRecord m5709$$Nest$mcreateSessionInternal(MediaSessionService r0, int r1, int r2, int r3, String r4, ISessionCallback r5, String r6, Bundle r7) {
        return r0.createSessionInternal(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mdestroySessionLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5710$$Nest$mdestroySessionLocked(MediaSessionService r0, MediaSessionRecordImpl r1) {
        r0.destroySessionLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mdispatchVolumeKeyLongPressLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5711$$Nest$mdispatchVolumeKeyLongPressLocked(MediaSessionService r0, KeyEvent r1) {
        r0.dispatchVolumeKeyLongPressLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceMediaPermissions, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5712$$Nest$menforceMediaPermissions(MediaSessionService r0, String r1, int r2, int r3, int r4) {
        r0.enforceMediaPermissions(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$menforceStatusBarServicePermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5713$$Nest$menforceStatusBarServicePermission(MediaSessionService r0, String r1, int r2, int r3) {
        r0.enforceStatusBarServicePermission(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mfindIndexOfSession2TokensListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5714$$Nest$mfindIndexOfSession2TokensListenerLocked(MediaSessionService r0, ISession2TokensListener r1) {
        return r0.findIndexOfSession2TokensListenerLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mfindIndexOfSessionsListenerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5715$$Nest$mfindIndexOfSessionsListenerLocked(MediaSessionService r0, IActiveSessionsListener r1) {
        return r0.findIndexOfSessionsListenerLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetActiveSessionsLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ List m5716$$Nest$mgetActiveSessionsLocked(MediaSessionService r0, int r1) {
        return r0.getActiveSessionsLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetCallingPackageName, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5717$$Nest$mgetCallingPackageName(MediaSessionService r0, int r1) {
        return r0.getCallingPackageName(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetFullUserRecordLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ FullUserRecord m5718$$Nest$mgetFullUserRecordLocked(MediaSessionService r0, int r1) {
        return r0.getFullUserRecordLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetMediaSessionRecordLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ MediaSessionRecord m5719$$Nest$mgetMediaSessionRecordLocked(MediaSessionService r0, MediaSession.Token r1) {
        return r0.getMediaSessionRecordLocked(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mhasMediaControlPermission, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5720$$Nest$mhasMediaControlPermission(MediaSessionService r0, int r1, int r2) {
        return r0.hasMediaControlPermission(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$minstantiateCustomDispatcher, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5721$$Nest$minstantiateCustomDispatcher(MediaSessionService r0, String r1) {
        r0.instantiateCustomDispatcher(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$minstantiateCustomProvider, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5722$$Nest$minstantiateCustomProvider(MediaSessionService r0, String r1) {
        r0.instantiateCustomProvider(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misGlobalPriorityActiveLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5723$$Nest$misGlobalPriorityActiveLocked(MediaSessionService r0) {
        return r0.isGlobalPriorityActiveLocked();
    }

    /* JADX INFO: renamed from: -$$Nest$mpushSession1Changed, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5724$$Nest$mpushSession1Changed(MediaSessionService r0, int r1) {
        r0.pushSession1Changed(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetFgsActiveLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5725$$Nest$msetFgsActiveLocked(MediaSessionService r0, MediaSessionRecordImpl r1, StatusBarNotification r2) {
        r0.setFgsActiveLocked(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$msetFgsInactiveIfNoSessionIsLinkedToNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5726$$Nest$msetFgsInactiveIfNoSessionIsLinkedToNotification(MediaSessionService r0, MediaSessionRecordImpl r1) {
        r0.setFgsInactiveIfNoSessionIsLinkedToNotification(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateActiveSessionListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5727$$Nest$mupdateActiveSessionListeners(MediaSessionService r0) {
        r0.updateActiveSessionListeners();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetLONG_PRESS_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5728$$Nest$sfgetLONG_PRESS_TIMEOUT() {
        return LONG_PRESS_TIMEOUT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetMULTI_TAP_TIMEOUT, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m5729$$Nest$sfgetMULTI_TAP_TIMEOUT() {
        return MULTI_TAP_TIMEOUT;
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
        LONG_PRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout() + 50;
        MULTI_TAP_TIMEOUT = ViewConfiguration.getMultiPressTimeout();
    }

    public MediaSessionService(Context context) {
        super(context);
        this.mHandler = new MessageHandler(this);
        this.mLock = new Object();
        this.mRecordThread = new HandlerThread("SessionRecordThread");
        this.mFullUserIds = new SparseIntArray();
        this.mUserRecords = new SparseArray();
        this.mSessionsListeners = new ArrayList();
        this.mSession2TokensListenerRecords = new ArrayList();
        this.mUserEngagedSessionsForUsageLogging = new SparseArray();
        this.mUserEngagedSessionsForFgs = new HashMap();
        this.mMediaNotifications = new HashMap();
        this.mRemoteVolumeControllers = new RemoteCallbackList();
        this.mSession2TokenCallback = new AnonymousClass1(this);
        this.mNotificationListenerEnabledChangedReceiver = new AnonymousClass2(this);
        this.mContext = context;
        this.mSessionManagerImpl = new SessionManagerImpl(this);
        PowerManager pm = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mMediaEventWakeLock = pm.newWakeLock(1, "handleMediaEvent");
        this.mNotificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        this.mAudioManager = (AudioManager) this.mContext.getSystemService(AudioManager.class);
        this.mNotificationListener = new NotificationListener(this, null);
        this.mExt = IMediaSessionServiceExtProxy.get(this);
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("media_session", this.mSessionManagerImpl);
        Watchdog.getInstance().addMonitor(this);
        this.mKeyguardManager = (KeyguardManager) this.mContext.getSystemService("keyguard");
        this.mAudioPlayerStateMonitor = AudioPlayerStateMonitor.getInstance(this.mContext);
        this.mAudioPlayerStateMonitor.registerListener(new MediaSessionService$$ExternalSyntheticLambda1(this), null);
        this.mHasFeatureLeanback = this.mContext.getPackageManager().hasSystemFeature("android.software.leanback");
        updateUser();
        instantiateCustomProvider(this.mContext.getResources().getString(R.string.config_customMediaSessionPolicyProvider));
        instantiateCustomDispatcher(this.mContext.getResources().getString(R.string.config_customMediaKeyDispatcher));
        this.mRecordThread.start();
        IntentFilter filter = new IntentFilter("android.app.action.NOTIFICATION_LISTENER_ENABLED_CHANGED");
        this.mContext.registerReceiver(this.mNotificationListenerEnabledChangedReceiver, filter);
        this.mActivityManagerInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mUsageStatsManagerInternal = (UsageStatsManagerInternal) LocalServices.getService(UsageStatsManagerInternal.class);
    }

    private /* synthetic */ void lambda$onStart$0(AudioPlaybackConfiguration config, boolean isRemoved) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "Audio playback is changed, config=" + config + ", removed=" + isRemoved);
    L6:
        if (config.getPlayerType() != 3) goto L8;
        return;
    L8:
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(UserHandle.getUserHandleForUid(config.getClientUid()).getIdentifier());     // Catch: Throwable -> L13
        if (user == null) goto L15;
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).updateMediaButtonSessionIfNeeded();     // Catch: Throwable -> L13
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        super.onBootPhase(phase);
        switch(phase) {
            case 550: goto L6;
            case 1000: goto L5;
            default: goto L9;
        };
    L5:
        this.mCommunicationManager = (MediaCommunicationManager) this.mContext.getSystemService(MediaCommunicationManager.class);
        this.mCommunicationManager.registerSessionCallback(new HandlerExecutor(this.mHandler), this.mSession2TokenCallback);
        return;
    L6:
        MediaSessionDeviceConfig.initialize(this.mContext);
        return;
    }

    private boolean isGlobalPriorityActiveLocked() {
        if (this.mGlobalPrioritySession != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mGlobalPrioritySession.isActive() == false) goto L7;
        return true;
    }

    void onSessionActiveStateChanged(MediaSessionRecordImpl record, PlaybackState playbackState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(record.getUserId());     // Catch: Throwable -> L9
        if (user != null) goto L12;
        Log.w(TAG, "Unknown session updated. Ignoring.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L12:
        if (record.isSystemPriority() == false) goto L15;
        Log.d(TAG, "Global priority session updated - user id=" + record.getUserId() + " package=" + record.getPackageName() + " active=" + record.isActive());     // Catch: Throwable -> L9
        FullUserRecord.m5745$$Nest$mpushAddressedPlayerChangedLocked(user);     // Catch: Throwable -> L9
        this.mHandler.post(new MediaSessionService$$ExternalSyntheticLambda0(this));     // Catch: Throwable -> L9
    L20:
        boolean isUserEngaged = isUserEngaged(record, playbackState);     // Catch: Throwable -> L9
        Log.d(TAG, "onSessionActiveStateChanged: record=" + record + " playbackState=" + playbackState);     // Catch: Throwable -> L9
        this.mExt.onSessionActiveStateChanged_onEnd(record, isUserEngaged, playbackState);     // Catch: Throwable -> L9
        reportMediaInteractionEvent(record, isUserEngaged);     // Catch: Throwable -> L9
        this.mHandler.postSessionsChanged(record);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        if (FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).contains(record) == true) goto L19;
        Log.w(TAG, "Unknown session updated. Ignoring.");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L19:
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).onSessionActiveStateChanged(record);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private boolean isUserEngaged(MediaSessionRecordImpl record, PlaybackState playbackState) {
        if (playbackState != null) goto L7;
        return record.checkPlaybackActiveState(true);
    L7:
        if (playbackState.isActive() == true) goto L9;
    L11:
        return false;
    L9:
        if (record.isActive() == false) goto L11;
        return true;
    }

    void setGlobalPrioritySession(MediaSessionRecord record) {
        boolean globalPrioritySessionActiveChanged = false;
        Object r1 = this.mLock;
        monitor-enter(r1);
        FullUserRecord user = getFullUserRecordLocked(record.getUserId());     // Catch: Throwable -> L11
        if (this.mGlobalPrioritySession == record) goto L25;
        Log.d(TAG, "Global priority session is changed from " + this.mGlobalPrioritySession + " to " + record);     // Catch: Throwable -> L11
        if (this.mGlobalPrioritySession != null) goto L14;
        if (record.isActive() == false) goto L14;
    L17:
        boolean r3 = true;
    L19:
        globalPrioritySessionActiveChanged = r3;
        this.mGlobalPrioritySession = record;     // Catch: Throwable -> L11
        if (user != null) goto L22;
    L24:
        this.mExt.setGlobalPrioritySession_onEnd(record);     // Catch: Throwable -> L11
        goto L25
    L22:
        if (FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).contains(record) == false) goto L24;
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).removeSession(record);     // Catch: Throwable -> L11
    L14:
        if (this.mGlobalPrioritySession != null) goto L16;
    L18:
        r3 = false;
        goto L19
    L16:
        if (this.mGlobalPrioritySession.isActive() == record.isActive()) goto L18;
    L25:
        monitor-exit(r1);     // Catch: Throwable -> L11
        if (globalPrioritySessionActiveChanged == false) goto L33;
        this.mHandler.post(new MediaSessionService$$ExternalSyntheticLambda0(this));
        return;
    L33:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    boolean isGlobalPrioritySessionActive() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        boolean r1 = isGlobalPriorityActiveLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private void notifyGlobalPrioritySessionActiveChanged() {
    }

    private List<MediaSessionRecord> getActiveSessionsLocked(int userId) {
        List<MediaSessionRecord> records = new ArrayList();
        if (userId != UserHandle.ALL.getIdentifier()) goto L8;
        int size = this.mUserRecords.size();
        int i = 0;
    L5:
        if (i >= size) goto L14;
        records.addAll(FullUserRecord.m5738$$Nest$fgetmPriorityStack(this.mUserRecords.valueAt(i)).getActiveSessions(userId));
        i = i + 1;
    L14:
        if (isGlobalPriorityActiveLocked() == true) goto L16;
    L20:
        return records;
    L16:
        if (userId != UserHandle.ALL.getIdentifier()) goto L18;
    L19:
        records.add(0, this.mGlobalPrioritySession);
        goto L20
    L18:
        if (userId != this.mGlobalPrioritySession.getUserId()) goto L20;
    L8:
        FullUserRecord user = getFullUserRecordLocked(userId);
        if (user != null) goto L12;
        Log.w(TAG, "getSessions failed. Unknown user " + userId);
        return records;
    L12:
        records.addAll(FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).getActiveSessions(userId));
        goto L14
    }

    List<Session2Token> getSession2TokensLocked(int userId) {
        List<Session2Token> list = new ArrayList();
        if (userId != UserHandle.ALL.getIdentifier()) goto L8;
        int size = this.mUserRecords.size();
        int i = 0;
    L5:
        if (i >= size) goto L9;
        list.addAll(FullUserRecord.m5738$$Nest$fgetmPriorityStack(this.mUserRecords.valueAt(i)).getSession2Tokens(userId));
        i = i + 1;
    L9:
        return list;
    L8:
        FullUserRecord user = getFullUserRecordLocked(userId);
        list.addAll(FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).getSession2Tokens(userId));
        goto L9
    }

    public void notifyRemoteVolumeChanged(int flags, MediaSessionRecord session) {
        if (session.isActive() == true) goto L5;
        return;
    L5:
        Object r0 = this.mLock;
        monitor-enter(r0);
        int size = this.mRemoteVolumeControllers.beginBroadcast();     // Catch: Throwable -> L12
        MediaSession.Token token = session.getSessionToken();     // Catch: Throwable -> L12
        int i = size - 1;
    L9:
        if (i < 0) goto L17;
        IRemoteSessionCallback cb = this.mRemoteVolumeControllers.getBroadcastItem(i);     // Catch: Throwable -> L12 Exception -> L14
        cb.onVolumeChanged(token, flags);     // Catch: Throwable -> L12 Exception -> L14
    L16:
        i = i - 1;     // Catch: Throwable -> L12
    L14:
        e = move-exception;
        Log.w(TAG, "Error sending volume change.", e);     // Catch: Throwable -> L12
        goto L16
    L17:
        this.mRemoteVolumeControllers.finishBroadcast();     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void onSessionPlaybackStateChanged(MediaSessionRecordImpl record, boolean shouldUpdatePriority, PlaybackState playbackState) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(record.getUserId());     // Catch: Throwable -> L12
        if (user == null) goto L14;
        if (FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).contains(record) == false) goto L14;
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).onPlaybackStateChanged(record, shouldUpdatePriority);     // Catch: Throwable -> L12
        boolean isUserEngaged = isUserEngaged(record, playbackState);     // Catch: Throwable -> L12
        Log.d(TAG, "onSessionPlaybackStateChanged: record=" + record + " playbackState=" + playbackState);     // Catch: Throwable -> L12
        reportMediaInteractionEvent(record, isUserEngaged);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        Log.d(TAG, "Unknown session changed playback state. Ignoring.");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    void onSessionPlaybackTypeChanged(MediaSessionRecord record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(record.getUserId());     // Catch: Throwable -> L12
        if (user == null) goto L14;
        if (FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).contains(record) == false) goto L14;
        pushRemoteVolumeUpdateLocked(record.getUserId());     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L14:
        Log.d(TAG, "Unknown session changed playback type. Ignoring.");     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.SystemService
    public void onUserStarting(SystemService.TargetUser user) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onStartUser: " + user);
    L5:
        updateUser();
    }

    @Override // com.android.server.SystemService
    public void onUserSwitching(SystemService.TargetUser from, SystemService.TargetUser to) {
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onSwitchUser: " + to);
    L5:
        updateUser();
    }

    @Override // com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser targetUser) {
        int userId = targetUser.getUserIdentifier();
        if (DEBUG == false) goto L5;
        Log.d(TAG, "onCleanupUser: " + userId);
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        FullUserRecord user = getFullUserRecordLocked(userId);     // Catch: Throwable -> L12
        if (user != null) goto L10;
    L15:
        updateUser();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L10:
        if (FullUserRecord.m5730$$Nest$fgetmFullUserId(user) != userId) goto L14;
        user.destroySessionsForUserLocked(UserHandle.ALL.getIdentifier());     // Catch: Throwable -> L12
        this.mUserRecords.remove(userId);     // Catch: Throwable -> L12
        goto L15
    L14:
        user.destroySessionsForUserLocked(userId);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.Watchdog.Monitor
    public void monitor() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        monitor-exit(r0);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    protected void enforcePhoneStatePermission(int pid, int uid) {
        if (this.mContext.checkPermission("android.permission.MODIFY_PHONE_STATE", pid, uid) != 0) goto L6;
        return;
    L6:
        throw new SecurityException("Must hold the MODIFY_PHONE_STATE permission.");
    }

    void onSessionDied(MediaSessionRecordImpl session) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        destroySessionLocked(session);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateUser() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        UserManager manager = (UserManager) this.mContext.getSystemService("user");     // Catch: Throwable -> L12
        this.mFullUserIds.clear();     // Catch: Throwable -> L12
        List<UserHandle> allUsers = manager.getUserHandles(false);     // Catch: Throwable -> L12
        if (allUsers == null) goto L18;
        Iterator<UserHandle> r3 = allUsers.iterator();     // Catch: Throwable -> L12
    L8:
        if (r3.hasNext() == false) goto L18;
        UserHandle user = r3.next();     // Catch: Throwable -> L12
        UserHandle parent = manager.getProfileParent(user);     // Catch: Throwable -> L12
        if (parent == null) goto L14;
        this.mFullUserIds.put(user.getIdentifier(), parent.getIdentifier());     // Catch: Throwable -> L12
        goto L8
    L14:
        this.mFullUserIds.put(user.getIdentifier(), user.getIdentifier());     // Catch: Throwable -> L12
        if (this.mUserRecords.get(user.getIdentifier()) != null) goto L8;
        this.mUserRecords.put(user.getIdentifier(), new FullUserRecord(this, user.getIdentifier()));     // Catch: Throwable -> L12
    L18:
        int currentFullUserId = ActivityManager.getCurrentUser();     // Catch: Throwable -> L12
        this.mCurrentFullUserRecord = this.mUserRecords.get(currentFullUserId);     // Catch: Throwable -> L12
        if (this.mCurrentFullUserRecord != null) goto L21;
        Log.w(TAG, "Cannot find FullUserInfo for the current user " + currentFullUserId);     // Catch: Throwable -> L12
        this.mCurrentFullUserRecord = new FullUserRecord(this, currentFullUserId);     // Catch: Throwable -> L12
        this.mUserRecords.put(currentFullUserId, this.mCurrentFullUserRecord);     // Catch: Throwable -> L12
    L21:
        this.mFullUserIds.put(currentFullUserId, currentFullUserId);     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private void updateActiveSessionListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mSessionsListeners.size() - 1;     // Catch: Throwable -> L13
    L5:
        if (i < 0) goto L22;
        SessionsListenerRecord listener = this.mSessionsListeners.get(i);     // Catch: Throwable -> L13
        if (listener.componentName != null) goto L10;
        String packageName = null;
    L11:
        enforceMediaPermissions(packageName, listener.pid, listener.uid, listener.userId);     // Catch: Throwable -> L13 SecurityException -> L15
    L20:
        i = i - 1;
        goto L5
    L10:
        packageName = listener.componentName.getPackageName();     // Catch: Throwable -> L13 SecurityException -> L15
        goto L11
    L16:
        Log.i(TAG, "ActiveSessionsListener " + listener.componentName + " is no longer authorized. Disconnecting.");     // Catch: Throwable -> L13
        this.mSessionsListeners.remove(i);     // Catch: Throwable -> L13
        listener.listener.onActiveSessionsChanged(new ArrayList());     // Catch: Throwable -> L13 Exception -> L19
        goto L20
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void destroySessionLocked(MediaSessionRecordImpl session) {
        if (DEBUG == false) goto L6;
        Log.d(TAG, "Destroying " + session);
    L6:
        if (session.isClosed() == false) goto L9;
        Log.w(TAG, "Destroying already destroyed session. Ignoring.");
        this.mExt.destroySessionLocked_onStart(session);
        return;
    L9:
        this.mExt.destroySessionLocked_onStart(session);
        FullUserRecord user = getFullUserRecordLocked(session.getUserId());
        if (user == null) goto L18;
        if ((session instanceof MediaSessionRecord) == false) goto L18;
        int uid = session.getUid();
        int sessionCount = FullUserRecord.m5739$$Nest$fgetmUidToSessionCount(user).get(uid, 0);
        if (sessionCount > 0) goto L16;
        Log.w(TAG, "destroySessionLocked: sessionCount should be positive. sessionCount=" + sessionCount);
        goto L18
    L16:
        FullUserRecord.m5739$$Nest$fgetmUidToSessionCount(user).put(uid, sessionCount - 1);
    L18:
        if (this.mGlobalPrioritySession != session) goto L24;
        this.mGlobalPrioritySession = null;
        if (session.isActive() == false) goto L26;
        if (user == null) goto L23;
        FullUserRecord.m5745$$Nest$mpushAddressedPlayerChangedLocked(user);
    L23:
        this.mHandler.post(new MediaSessionService$$ExternalSyntheticLambda0(this));
    L26:
        session.close();
        Log.d(TAG, "destroySessionLocked: record=" + session);
        reportMediaInteractionEvent(session, false);
        this.mHandler.postSessionsChanged(session);
        return;
    L24:
        if (user == null) goto L26;
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).removeSession(session);
        goto L26
    }

    void onSessionUserEngagementStateChange(MediaSessionRecordImpl mediaSessionRecord, boolean isUserEngaged) {
        if (isUserEngaged == false) goto L4;
        addUserEngagedSession(mediaSessionRecord);
        setFgsActiveIfSessionIsLinkedToNotification(mediaSessionRecord);
        return;
    L4:
        removeUserEngagedSession(mediaSessionRecord);
        setFgsInactiveIfNoSessionIsLinkedToNotification(mediaSessionRecord);
    }

    private void addUserEngagedSession(MediaSessionRecordImpl mediaSessionRecord) {
    }

    private void removeUserEngagedSession(MediaSessionRecordImpl mediaSessionRecord) {
    }

    private void setFgsActiveIfSessionIsLinkedToNotification(MediaSessionRecordImpl mediaSessionRecord) {
        Log.d(TAG, "setFgsIfSessionIsLinkedToNotification: record=" + mediaSessionRecord);
    }

    private void setFgsActiveLocked(MediaSessionRecordImpl mediaSessionRecord, StatusBarNotification sbn) {
        long token = Binder.clearCallingIdentity();
        String packageName = sbn.getPackageName();     // Catch: Throwable -> L6
        int uid = sbn.getUid();     // Catch: Throwable -> L6
        int notificationId = sbn.getId();     // Catch: Throwable -> L6
        Log.i(TAG, TextUtils.formatSimple("setFgsActiveLocked: pkg=%s uid=%d notification=%d", new Object[]{packageName, Integer.valueOf(uid), Integer.valueOf(notificationId)}));     // Catch: Throwable -> L6
        this.mActivityManagerInternal.notifyActiveMediaForegroundService(packageName, sbn.getUser().getIdentifier(), notificationId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private StatusBarNotification getLinkedNotification(int uid, MediaSessionRecordImpl record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<StatusBarNotification> r1 = this.mMediaNotifications.getOrDefault(Integer.valueOf(uid), Map.of()).values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r1.hasNext() == false) goto L14;
        StatusBarNotification sbn = r1.next();     // Catch: Throwable -> L11
        if (record.isLinkedToNotification(sbn.getNotification()) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return sbn;
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return null;
    L11:
        th = move-exception;
        throw th;
    }

    private void setFgsInactiveIfNoSessionIsLinkedToNotification(MediaSessionRecordImpl mediaSessionRecord) {
        Log.d(TAG, "setFgsIfNoSessionIsLinkedToNotification: record=" + mediaSessionRecord);
    }

    private void setFgsInactiveLocked(MediaSessionRecordImpl mediaSessionRecord, StatusBarNotification sbn) {
        long token = Binder.clearCallingIdentity();
        String packageName = sbn.getPackageName();     // Catch: Throwable -> L6
        int userId = sbn.getUser().getIdentifier();     // Catch: Throwable -> L6
        int uid = sbn.getUid();     // Catch: Throwable -> L6
        int notificationId = sbn.getId();     // Catch: Throwable -> L6
        Log.i(TAG, TextUtils.formatSimple("setFgsInactiveLocked: pkg=%s uid=%d notification=%d", new Object[]{packageName, Integer.valueOf(uid), Integer.valueOf(notificationId)}));     // Catch: Throwable -> L6
        this.mActivityManagerInternal.notifyInactiveMediaForegroundService(packageName, userId, notificationId);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void reportMediaInteractionEvent(MediaSessionRecordImpl record, boolean userEngaged) {
        String packageName = record.getPackageName();
        int sessionUid = record.getUid();
        if (userEngaged == false) goto L9;
        if (this.mUserEngagedSessionsForUsageLogging.contains(sessionUid) == true) goto L7;
        this.mUserEngagedSessionsForUsageLogging.put(sessionUid, new HashSet());
        reportUserInteractionEvent("start", record.getUserId(), packageName);
    L7:
        this.mUserEngagedSessionsForUsageLogging.get(sessionUid).add(record);
        return;
    L9:
        if (this.mUserEngagedSessionsForUsageLogging.contains(sessionUid) == false) goto L15;
        this.mUserEngagedSessionsForUsageLogging.get(sessionUid).remove(record);
        if (this.mUserEngagedSessionsForUsageLogging.get(sessionUid).isEmpty() == false) goto L16;
        reportUserInteractionEvent("stop", record.getUserId(), packageName);
        this.mUserEngagedSessionsForUsageLogging.remove(sessionUid);
        return;
    L16:
        return;
    }

    private void reportUserInteractionEvent(String action, int userId, String packageName) {
        PersistableBundle extras = new PersistableBundle();
        extras.putString("android.app.usage.extra.EVENT_CATEGORY", USAGE_STATS_CATEGORY);
        extras.putString("android.app.usage.extra.EVENT_ACTION", action);
        this.mUsageStatsManagerInternal.reportUserInteractionEvent(packageName, userId, extras);
    }

    void tempAllowlistTargetPkgIfPossible(int targetUid, String targetPackage, int callingPid, int callingUid, String callingPackage, String reason) {
        long token = Binder.clearCallingIdentity();
        SysOptBridge.getFactory().getApplicationFreezer().unfreezeAppIfNeededAsync(null, targetPackage, targetUid, IApplicationFreezer.UnfreezeReason.NEED_MEDIA, null, null);
        MediaServerUtils.enforcePackageName(this.mContext, callingPackage, callingUid);     // Catch: Throwable -> L11
        if (targetUid == callingUid) goto L28;
        boolean canAllowWhileInUse = this.mActivityManagerInternal.canAllowWhileInUsePermissionInFgs(callingPid, callingUid, callingPackage);     // Catch: Throwable -> L11
        if (canAllowWhileInUse == false) goto L8;
    L13:
        boolean canStartFgs = true;
    L14:
        StringBuilder r6 = new StringBuilder();     // Catch: Throwable -> L11
        r6.append("tempAllowlistTargetPkgIfPossible callingPackage:");     // Catch: Throwable -> L11
        r6.append(callingPackage);     // Catch: Throwable -> L11
        r6.append(" targetPackage:");     // Catch: Throwable -> L11
        r6.append(targetPackage);     // Catch: Throwable -> L11
        r6.append(" reason:");     // Catch: Throwable -> L11
        r6.append(reason);     // Catch: Throwable -> L11
        String r8 = "";
        if (canAllowWhileInUse == false) goto L18;
        String r14 = " [WIU]";
    L19:
        r6.append(r14);     // Catch: Throwable -> L11
        if (canStartFgs == false) goto L22;
        r8 = " [FGS]";
    L22:
        r6.append(r8);     // Catch: Throwable -> L11
        Log.i(TAG, r6.toString());     // Catch: Throwable -> L11
        if (canAllowWhileInUse == false) goto L26;
        this.mActivityManagerInternal.tempAllowWhileInUsePermissionInFgs(targetUid, MediaSessionDeviceConfig.getMediaSessionCallbackFgsWhileInUseTempAllowDurationMs());     // Catch: Throwable -> L11
    L26:
        if (canStartFgs == false) goto L28;
        Context userContext = this.mContext.createContextAsUser(UserHandle.of(UserHandle.getUserId(targetUid)), 0);     // Catch: Throwable -> L11
        PowerExemptionManager powerExemptionManager = (PowerExemptionManager) userContext.getSystemService(PowerExemptionManager.class);     // Catch: Throwable -> L11
        powerExemptionManager.addToTemporaryAllowList(targetPackage, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_MEDIA_SESSION_CALLBACK, reason, MediaSessionDeviceConfig.getMediaSessionCallbackFgsAllowlistDurationMs());     // Catch: Throwable -> L11
        goto L28
    L18:
        r14 = "";
        goto L19
    L8:
        if (this.mActivityManagerInternal.canStartForegroundService(callingPid, callingUid, callingPackage) == true) goto L13;
        canStartFgs = false;
    L28:
        Binder.restoreCallingIdentity(token);
        return;
    L11:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private void enforceMediaPermissions(String packageName, int pid, int uid, int resolvedUserId) {
        if (hasStatusBarServicePermission(pid, uid) == false) goto L6;
        return;
    L6:
        if (hasMediaControlPermission(pid, uid) == false) goto L8;
        return;
    L8:
        if (packageName == null) goto L13;
        if (hasEnabledNotificationListener(packageName, UserHandle.getUserHandleForUid(uid), resolvedUserId) == false) goto L13;
        return;
    L13:
        throw new SecurityException("Missing permission to control media.");
    }

    private boolean hasStatusBarServicePermission(int pid, int uid) {
        if (this.mContext.checkPermission("android.permission.STATUS_BAR_SERVICE", pid, uid) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    private void enforceStatusBarServicePermission(String action, int pid, int uid) {
        if (hasStatusBarServicePermission(pid, uid) == false) goto L6;
        return;
    L6:
        throw new SecurityException("Only System UI and Settings may " + action);
    }

    private boolean hasMediaControlPermission(int pid, int uid) {
        if (uid != 1000) goto L5;
        return true;
    L5:
        if (this.mContext.checkPermission("android.permission.MEDIA_CONTENT_CONTROL", pid, uid) != 0) goto L8;
        return true;
    L8:
        if (DEBUG == false) goto L14;
        Log.d(TAG, "uid(" + uid + ") hasn't granted MEDIA_CONTENT_CONTROL");
        return false;
    L14:
        return false;
    }

    private boolean hasEnabledNotificationListener(String packageName, UserHandle userHandle, int forUserId) {
        if (userHandle.getIdentifier() == forUserId) goto L7;
        return false;
    L7:
        if (DEBUG == false) goto L10;
        Log.d(TAG, "Checking whether the package " + packageName + " has an enabled notification listener.");
    L10:
        return this.mNotificationManager.hasEnabledNotificationListener(packageName, userHandle);
    }

    private MediaSessionRecord createSessionInternal(int callerPid, int callerUid, int userId, String callerPackageName, ISessionCallback cb, String tag, Bundle sessionInfo) {
        Object r11 = this.mLock;
        monitor-enter(r11);
    L28:
        th = th;
    L41:
        monitor-exit(r11);     // Catch: Throwable -> L28
        throw th;
    L8:
        th = th;
        goto L41
    L6:
        if (this.mCustomMediaSessionPolicyProvider == null) goto L10;
        int policies = this.mCustomMediaSessionPolicyProvider.getSessionPoliciesForApplication(callerUid, callerPackageName);     // Catch: Throwable -> L8
        int policies2 = policies;
    L11:
        FullUserRecord user = getFullUserRecordLocked(userId);     // Catch: Throwable -> L8
        if (user == null) goto L39;
        int sessionCount = FullUserRecord.m5739$$Nest$fgetmUidToSessionCount(user).get(callerUid, 0);     // Catch: Throwable -> L8
        if (sessionCount >= 100) goto L16;
    L46:
        MediaSessionRecord session = new MediaSessionRecord(callerPid, callerUid, userId, callerPackageName, cb, tag, sessionInfo, this, this.mRecordThread.getLooper(), policies2);     // Catch: Throwable -> L28 RemoteException -> L33
        FullUserRecord.m5739$$Nest$fgetmUidToSessionCount(user).put(callerUid, sessionCount + 1);     // Catch: Throwable -> L8
        FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).addSession(session);     // Catch: Throwable -> L8
        this.mHandler.postSessionsChanged(session);     // Catch: Throwable -> L8
        if (DEBUG == false) goto L31;
        StringBuilder r5 = new StringBuilder();     // Catch: Throwable -> L8
        r5.append("Created session for ");     // Catch: Throwable -> L8
        r5.append(callerPackageName);     // Catch: Throwable -> L8
        r5.append(" with tag ");     // Catch: Throwable -> L8
        r5.append(tag);     // Catch: Throwable -> L28
        Log.d(TAG, r5.toString());     // Catch: Throwable -> L28
    L31:
        monitor-exit(r11);     // Catch: Throwable -> L28
        return session;
    L33:
        e = e;
    L38:
        throw new RuntimeException("Media Session owner died prematurely.", e);     // Catch: Throwable -> L28
    L35:
        e = e;
        goto L38
    L16:
        if (hasMediaControlPermission(callerPid, callerUid) == true) goto L46;
        throw new RuntimeException("Created too many sessions. count=" + sessionCount + ")");     // Catch: Throwable -> L8
    L39:
        Log.w(TAG, "Request from invalid user: " + userId + ", pkg=" + callerPackageName);     // Catch: Throwable -> L28
        throw new RuntimeException("Session request from invalid user.");     // Catch: Throwable -> L28
    L10:
        policies2 = 0;
        goto L11
    }

    private int findIndexOfSessionsListenerLocked(IActiveSessionsListener listener) {
        int i = this.mSessionsListeners.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mSessionsListeners.get(i).listener.asBinder() == listener.asBinder()) goto L6;
        i = i - 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private int findIndexOfSession2TokensListenerLocked(ISession2TokensListener listener) {
        int i = this.mSession2TokensListenerRecords.size() - 1;
    L3:
        if (i < 0) goto L8;
        if (this.mSession2TokensListenerRecords.get(i).listener.asBinder() == listener.asBinder()) goto L6;
        i = i - 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    private void pushSession1Changed(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(userId);     // Catch: Throwable -> L9
        if (user != null) goto L11;
        Log.w(TAG, "pushSession1ChangedOnHandler failed. No user with id=" + userId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        List<MediaSessionRecord> records = getActiveSessionsLocked(userId);     // Catch: Throwable -> L9
        int size = records.size();     // Catch: Throwable -> L9
        ArrayList<MediaSession.Token> tokens = new ArrayList();     // Catch: Throwable -> L9
        int i = 0;
    L12:
        if (i >= size) goto L14;
        tokens.add(records.get(i).getSessionToken());     // Catch: Throwable -> L9
        i = i + 1;     // Catch: Throwable -> L9
        goto L12
    L14:
        pushRemoteVolumeUpdateLocked(userId);     // Catch: Throwable -> L9
        int i2 = this.mSessionsListeners.size() - 1;     // Catch: Throwable -> L9
    L15:
        if (i2 < 0) goto L26;
        SessionsListenerRecord record = this.mSessionsListeners.get(i2);     // Catch: Throwable -> L9
        if (record.userId != UserHandle.ALL.getIdentifier()) goto L19;
    L31:
        record.listener.onActiveSessionsChanged(tokens);     // Catch: Throwable -> L9 RemoteException -> L22
    L24:
        i2 = i2 - 1;     // Catch: Throwable -> L9
    L22:
        e = move-exception;
        Log.w(TAG, "Dead ActiveSessionsListener in pushSessionsChanged, removing", e);     // Catch: Throwable -> L9
        this.mSessionsListeners.remove(i2);     // Catch: Throwable -> L9
        goto L24
    L19:
        if (record.userId != userId) goto L24;
    L26:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    void pushSession2Changed(int userId) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        List<Session2Token> allSession2Tokens = getSession2TokensLocked(UserHandle.ALL.getIdentifier());     // Catch: Throwable -> L10
        List<Session2Token> session2Tokens = getSession2TokensLocked(userId);     // Catch: Throwable -> L10
        int i = this.mSession2TokensListenerRecords.size() - 1;     // Catch: Throwable -> L10
    L5:
        if (i < 0) goto L22;
        Session2TokensListenerRecord listenerRecord = this.mSession2TokensListenerRecords.get(i);     // Catch: Throwable -> L10
        if (listenerRecord.userId != UserHandle.ALL.getIdentifier()) goto L15;
        listenerRecord.listener.onSession2TokensChanged(allSession2Tokens);     // Catch: Throwable -> L10 RemoteException -> L12
    L20:
        i = i - 1;     // Catch: Throwable -> L10
        goto L5
    L15:
        if (listenerRecord.userId != userId) goto L20;
        listenerRecord.listener.onSession2TokensChanged(session2Tokens);     // Catch: Throwable -> L10 RemoteException -> L12
        goto L20
    L12:
        e = move-exception;
        Log.w(TAG, "Failed to notify Session2Token change. Removing listener.", e);     // Catch: Throwable -> L10
        this.mSession2TokensListenerRecords.remove(i);     // Catch: Throwable -> L10
        goto L20
    L22:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    private void pushRemoteVolumeUpdateLocked(int userId) {
        FullUserRecord user = getFullUserRecordLocked(userId);
        if (user != null) goto L6;
        Log.w(TAG, "pushRemoteVolumeUpdateLocked failed. No user with id=" + userId);
        return;
    L6:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int size = this.mRemoteVolumeControllers.beginBroadcast();     // Catch: Throwable -> L12
        MediaSessionRecordImpl record = FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).getDefaultRemoteSession(userId);     // Catch: Throwable -> L12
        if ((record instanceof MediaSession2Record) == false) goto L14;
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L14:
        if (record != null) goto L16;
        MediaSession.Token token = null;
    L17:
        int i = size - 1;
    L18:
        if (i < 0) goto L24;
        IRemoteSessionCallback cb = this.mRemoteVolumeControllers.getBroadcastItem(i);     // Catch: Throwable -> L12 Exception -> L21
        cb.onSessionChanged(token);     // Catch: Throwable -> L12 Exception -> L21
    L23:
        i = i - 1;     // Catch: Throwable -> L12
    L21:
        e = move-exception;
        Log.w(TAG, "Error sending default remote volume.", e);     // Catch: Throwable -> L12
        goto L23
    L24:
        this.mRemoteVolumeControllers.finishBroadcast();     // Catch: Throwable -> L12
        monitor-exit(r1);     // Catch: Throwable -> L12
        return;
    L16:
        token = ((MediaSessionRecord) record).getSessionToken();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public void onMediaButtonReceiverChanged(MediaSessionRecordImpl record) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        FullUserRecord user = getFullUserRecordLocked(record.getUserId());     // Catch: Throwable -> L7
        MediaSessionRecordImpl mediaButtonSession = FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).getMediaButtonSession();     // Catch: Throwable -> L7
        if (record != mediaButtonSession) goto L9;
        user.rememberMediaButtonReceiverLocked(mediaButtonSession);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private String getCallingPackageName(int uid) {
        String[] packages = this.mContext.getPackageManager().getPackagesForUid(uid);
        if (packages != null) goto L5;
        return "";
    L5:
        if (packages.length > 0) goto L7;
        return "";
    L7:
        return packages[0];
    }

    private void dispatchVolumeKeyLongPressLocked(KeyEvent keyEvent) {
        if (FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(this.mCurrentFullUserRecord) != null) goto L10;
        return;
    L10:
        FullUserRecord.m5736$$Nest$fgetmOnVolumeKeyLongPressListener(this.mCurrentFullUserRecord).onVolumeKeyLongPress(keyEvent);     // Catch: RemoteException -> L7
        return;
    L8:
        Log.w(TAG, "Failed to send " + keyEvent + " to volume key long-press listener");
    }

    private FullUserRecord getFullUserRecordLocked(int userId) {
        int fullUserId = this.mFullUserIds.get(userId, -1);
        if (fullUserId >= 0) goto L7;
        return null;
    L7:
        return this.mUserRecords.get(fullUserId);
    }

    private MediaSessionRecord getMediaSessionRecordLocked(MediaSession.Token sessionToken) {
        FullUserRecord user = getFullUserRecordLocked(UserHandle.getUserHandleForUid(sessionToken.getUid()).getIdentifier());
        if (user != null) goto L5;
        return null;
    L5:
        return FullUserRecord.m5738$$Nest$fgetmPriorityStack(user).getMediaSessionRecord(sessionToken);
    }

    private void instantiateCustomDispatcher(String componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCustomMediaKeyDispatcher = null;     // Catch: Throwable -> L11
        if (componentName != null) goto L20;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L20:
    L13:
        e = move-exception;
        this.mCustomMediaKeyDispatcher = null;     // Catch: Throwable -> L11
        Log.w(TAG, "Encountered problem while using reflection", e);     // Catch: Throwable -> L11
        goto L16
    L8:
        if (TextUtils.isEmpty(componentName) == true) goto L16;
        this.mCustomMediaKeyDispatcher = (MediaKeyDispatcher) Class.forName(componentName).getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});     // Catch: Throwable -> L11 Throwable -> L13
    L11:
        th = move-exception;
        throw th;
    }

    private void instantiateCustomProvider(String componentName) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mCustomMediaSessionPolicyProvider = null;     // Catch: Throwable -> L11
        if (componentName != null) goto L20;
    L16:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L20:
    L13:
        e = move-exception;
        Log.w(TAG, "Encountered problem while using reflection", e);     // Catch: Throwable -> L11
        goto L16
    L8:
        if (TextUtils.isEmpty(componentName) == true) goto L16;
        this.mCustomMediaSessionPolicyProvider = (MediaSessionPolicyProvider) Class.forName(componentName).getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.mContext});     // Catch: Throwable -> L11 Throwable -> L13
    L11:
        th = move-exception;
        throw th;
    }
}
