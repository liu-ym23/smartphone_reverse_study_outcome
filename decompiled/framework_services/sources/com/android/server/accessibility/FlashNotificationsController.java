package com.android.server.accessibility;

import android.animation.ObjectAnimator;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.graphics.Color;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.media.AudioPlaybackConfiguration;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.provider.Settings;
import android.util.FeatureFlagUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.function.pooled.PooledLambda;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
class FlashNotificationsController {
    static final String ACTION_FLASH_NOTIFICATION_START_PREVIEW = "com.android.internal.intent.action.FLASH_NOTIFICATION_START_PREVIEW";
    static final String ACTION_FLASH_NOTIFICATION_STOP_PREVIEW = "com.android.internal.intent.action.FLASH_NOTIFICATION_STOP_PREVIEW";
    private static final boolean DEBUG = true;
    static final String EXTRA_FLASH_NOTIFICATION_PREVIEW_COLOR = "com.android.internal.intent.extra.FLASH_NOTIFICATION_PREVIEW_COLOR";
    static final String EXTRA_FLASH_NOTIFICATION_PREVIEW_TYPE = "com.android.internal.intent.extra.FLASH_NOTIFICATION_PREVIEW_TYPE";
    private static final String LOG_TAG = "FlashNotifController";
    static final int PREVIEW_TYPE_LONG = 1;
    static final int PREVIEW_TYPE_SHORT = 0;
    private static final int SCREEN_DEFAULT_ALPHA = 1711276032;
    private static final int SCREEN_DEFAULT_COLOR = 16776960;
    private static final int SCREEN_DEFAULT_COLOR_WITH_ALPHA = 1728052992;
    private static final int SCREEN_FADE_DURATION_MS = 200;
    private static final int SCREEN_FADE_OUT_TIMEOUT_MS = 10;
    static final String SETTING_KEY_CAMERA_FLASH_NOTIFICATION = "camera_flash_notification";
    static final String SETTING_KEY_SCREEN_FLASH_NOTIFICATION = "screen_flash_notification";
    static final String SETTING_KEY_SCREEN_FLASH_NOTIFICATION_COLOR = "screen_flash_notification_color_global";
    private static final String TAG_ALARM = "alarm";
    private static final String TAG_PREVIEW = "preview";
    private static final int TYPE_DEFAULT = 1;
    private static final int TYPE_DEFAULT_OFF_MS = 250;
    private static final int TYPE_DEFAULT_ON_MS = 350;
    private static final int TYPE_DEFAULT_SCREEN_DELAY_MS = 300;
    private static final int TYPE_LONG_PREVIEW = 3;
    private static final int TYPE_LONG_PREVIEW_OFF_MS = 1000;
    private static final int TYPE_LONG_PREVIEW_ON_MS = 5000;
    private static final int TYPE_SEQUENCE = 2;
    private static final int TYPE_SEQUENCE_OFF_MS = 700;
    private static final int TYPE_SEQUENCE_ON_MS = 700;
    private static final String WAKE_LOCK_TAG = "a11y:FlashNotificationsController";
    private static final long WAKE_LOCK_TIMEOUT_MS = 300000;
    private final AudioManager.AudioPlaybackCallback mAudioPlaybackCallback;
    private final Handler mCallbackHandler;
    private String mCameraId;
    private CameraManager mCameraManager;
    private final Context mContext;
    private FlashNotification mCurrentFlashNotification;
    private final DisplayManager mDisplayManager;
    private int mDisplayState;
    final FlashBroadcastReceiver mFlashBroadcastReceiver;
    private final Handler mFlashNotificationHandler;
    private final LinkedList<FlashNotification> mFlashNotifications;
    private boolean mIsAlarming;
    private boolean mIsCameraFlashNotificationEnabled;
    private boolean mIsCameraOpened;
    private boolean mIsScreenFlashNotificationEnabled;
    private boolean mIsTorchOn;
    private boolean mIsTorchTouched;
    private final Handler mMainHandler;
    private View mScreenFlashNotificationOverlayView;
    private volatile FlashNotificationThread mThread;
    final CameraManager.AvailabilityCallback mTorchAvailabilityCallback;
    private final CameraManager.TorchCallback mTorchCallback;
    private final PowerManager.WakeLock mWakeLock;

    /* JADX INFO: renamed from: com.android.server.accessibility.FlashNotificationsController$3, reason: invalid class name */
    class AnonymousClass3 extends AudioManager.AudioPlaybackCallback {
        final /* synthetic */ FlashNotificationsController this$0;

        /* JADX INFO: renamed from: $r8$lambda$6sh4VmH_JFlFTySwImzfGSFne-A, reason: not valid java name */
        public static /* synthetic */ boolean m708$r8$lambda$6sh4VmH_JFlFTySwImzfGSFneA(AudioPlaybackConfiguration r0) {
            return lambda$onPlaybackConfigChanged$0(r0);
        }

        AnonymousClass3(FlashNotificationsController this$0) {
            this.this$0 = this$0;
        }

        @Override // android.media.AudioManager.AudioPlaybackCallback
        public void onPlaybackConfigChanged(List<AudioPlaybackConfiguration> configs) {
            boolean isAlarmActive = false;
            if (configs == null) goto L6;
            isAlarmActive = configs.stream().anyMatch(new FlashNotificationsController$3$$ExternalSyntheticLambda0());
        L6:
            if (FlashNotificationsController.m684$$Nest$fgetmIsAlarming(this.this$0) == isAlarmActive) goto L13;
            Log.d(FlashNotificationsController.LOG_TAG, "alarm state changed: " + isAlarmActive);
            if (isAlarmActive == false) goto L10;
            FlashNotificationsController.m704$$Nest$mstartFlashNotificationSequenceForAlarm(this.this$0);
        L11:
            FlashNotificationsController.m692$$Nest$fputmIsAlarming(this.this$0, isAlarmActive);
            return;
        L10:
            FlashNotificationsController.m707$$Nest$mstopFlashNotificationSequenceForAlarm(this.this$0);
            goto L11
        }

        private static /* synthetic */ boolean lambda$onPlaybackConfigChanged$0(AudioPlaybackConfiguration config) {
            if (config.isActive() == true) goto L5;
        L7:
            return false;
        L5:
            if (config.getAudioAttributes().getUsage() != 4) goto L7;
            return true;
        }
    }

    class FlashBroadcastReceiver extends BroadcastReceiver {
        final /* synthetic */ FlashNotificationsController this$0;

        FlashBroadcastReceiver(FlashNotificationsController this$0) {
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            boolean r2 = true;
            if ("android.intent.action.BOOT_COMPLETED".equals(action) == false) goto L22;
            if (UserHandle.myUserId() == ActivityManager.getCurrentUser()) goto L7;
            return;
        L7:
            FlashNotificationsController r1 = this.this$0;
            if (Settings.System.getIntForUser(FlashNotificationsController.m681$$Nest$fgetmContext(this.this$0).getContentResolver(), FlashNotificationsController.SETTING_KEY_CAMERA_FLASH_NOTIFICATION, 0, -2) != 0) goto L11;
            r2 = false;
        L11:
            FlashNotificationsController.m693$$Nest$fputmIsCameraFlashNotificationEnabled(r1, r2);
            if (FlashNotificationsController.m685$$Nest$fgetmIsCameraFlashNotificationEnabled(this.this$0) == false) goto L15;
            FlashNotificationsController.m702$$Nest$mprepareForCameraFlashNotification(this.this$0);
        L17:
            AudioManager audioManager = (AudioManager) FlashNotificationsController.m681$$Nest$fgetmContext(this.this$0).getSystemService(AudioManager.class);
            if (audioManager == null) goto L20;
            audioManager.registerAudioPlaybackCallback(FlashNotificationsController.m677$$Nest$fgetmAudioPlaybackCallback(this.this$0), FlashNotificationsController.m678$$Nest$fgetmCallbackHandler(this.this$0));
        L20:
            FlashNotificationsController.m689$$Nest$fputmCameraManager(this.this$0, (CameraManager) FlashNotificationsController.m681$$Nest$fgetmContext(this.this$0).getSystemService(CameraManager.class));
            FlashNotificationsController.m680$$Nest$fgetmCameraManager(this.this$0).registerAvailabilityCallback(this.this$0.mTorchAvailabilityCallback, FlashNotificationsController.m678$$Nest$fgetmCallbackHandler(this.this$0));
            return;
        L15:
            if (FlashNotificationsController.m680$$Nest$fgetmCameraManager(this.this$0) == null) goto L17;
            FlashNotificationsController.m680$$Nest$fgetmCameraManager(this.this$0).unregisterTorchCallback(FlashNotificationsController.m687$$Nest$fgetmTorchCallback(this.this$0));
            goto L17
        L22:
            if (FlashNotificationsController.ACTION_FLASH_NOTIFICATION_START_PREVIEW.equals(intent.getAction()) == false) goto L30;
            Log.i(FlashNotificationsController.LOG_TAG, "ACTION_FLASH_NOTIFICATION_START_PREVIEW");
            int color = intent.getIntExtra(FlashNotificationsController.EXTRA_FLASH_NOTIFICATION_PREVIEW_COLOR, 0);
            int type = intent.getIntExtra(FlashNotificationsController.EXTRA_FLASH_NOTIFICATION_PREVIEW_TYPE, 0);
            if (type != 1) goto L26;
            FlashNotificationsController.m703$$Nest$mstartFlashNotificationLongPreview(this.this$0, color);
            return;
        L26:
            if (type != 0) goto L36;
            FlashNotificationsController.m705$$Nest$mstartFlashNotificationShortPreview(this.this$0);
            return;
        L36:
            return;
        L30:
            if (FlashNotificationsController.ACTION_FLASH_NOTIFICATION_STOP_PREVIEW.equals(intent.getAction()) == false) goto L37;
            Log.i(FlashNotificationsController.LOG_TAG, "ACTION_FLASH_NOTIFICATION_STOP_PREVIEW");
            FlashNotificationsController.m706$$Nest$mstopFlashNotificationLongPreview(this.this$0);
            return;
        }
    }

    private final class FlashContentObserver extends ContentObserver {
        private final Uri mCameraFlashNotificationUri;
        private final Uri mScreenFlashNotificationUri;
        final /* synthetic */ FlashNotificationsController this$0;

        FlashContentObserver(FlashNotificationsController r1, Handler handler) {
            this.this$0 = r1;
            super(handler);
            this.mCameraFlashNotificationUri = Settings.System.getUriFor(FlashNotificationsController.SETTING_KEY_CAMERA_FLASH_NOTIFICATION);
            this.mScreenFlashNotificationUri = Settings.System.getUriFor(FlashNotificationsController.SETTING_KEY_SCREEN_FLASH_NOTIFICATION);
        }

        void register(ContentResolver contentResolver) {
            contentResolver.registerContentObserver(this.mCameraFlashNotificationUri, false, this, -1);
            contentResolver.registerContentObserver(this.mScreenFlashNotificationUri, false, this, -1);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean selfChange, Uri uri) {
            boolean r1 = true;
            if (this.mCameraFlashNotificationUri.equals(uri) == false) goto L15;
            FlashNotificationsController r0 = this.this$0;
            if (Settings.System.getIntForUser(FlashNotificationsController.m681$$Nest$fgetmContext(this.this$0).getContentResolver(), FlashNotificationsController.SETTING_KEY_CAMERA_FLASH_NOTIFICATION, 0, -2) != 0) goto L8;
            r1 = false;
        L8:
            FlashNotificationsController.m693$$Nest$fputmIsCameraFlashNotificationEnabled(r0, r1);
            if (FlashNotificationsController.m685$$Nest$fgetmIsCameraFlashNotificationEnabled(this.this$0) == false) goto L11;
            FlashNotificationsController.m702$$Nest$mprepareForCameraFlashNotification(this.this$0);
            return;
        L11:
            FlashNotificationsController.m696$$Nest$fputmIsTorchOn(this.this$0, false);
            if (FlashNotificationsController.m680$$Nest$fgetmCameraManager(this.this$0) == null) goto L23;
            FlashNotificationsController.m680$$Nest$fgetmCameraManager(this.this$0).unregisterTorchCallback(FlashNotificationsController.m687$$Nest$fgetmTorchCallback(this.this$0));
            return;
        L23:
            return;
        L15:
            if (this.mScreenFlashNotificationUri.equals(uri) == false) goto L25;
            FlashNotificationsController r2 = this.this$0;
            if (Settings.System.getIntForUser(FlashNotificationsController.m681$$Nest$fgetmContext(this.this$0).getContentResolver(), FlashNotificationsController.SETTING_KEY_SCREEN_FLASH_NOTIFICATION, 0, -2) != 0) goto L20;
            r1 = false;
        L20:
            FlashNotificationsController.m695$$Nest$fputmIsScreenFlashNotificationEnabled(r2, r1);
            return;
        }
    }

    private static class FlashNotification {
        private final int mColor;
        private final IBinder.DeathRecipient mDeathRecipient;
        private final boolean mForceStartScreenFlash;
        private final int mOffDuration;
        private final int mOnDuration;
        private int mRepeat;
        private final String mTag;
        private final IBinder mToken;
        private final int mType;

        /* JADX INFO: renamed from: -$$Nest$fgetmColor, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m709$$Nest$fgetmColor(FlashNotification r0) {
            return r0.mColor;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmForceStartScreenFlash, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m710$$Nest$fgetmForceStartScreenFlash(FlashNotification r0) {
            return r0.mForceStartScreenFlash;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOffDuration, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m711$$Nest$fgetmOffDuration(FlashNotification r0) {
            return r0.mOffDuration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOnDuration, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m712$$Nest$fgetmOnDuration(FlashNotification r0) {
            return r0.mOnDuration;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmRepeat, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m713$$Nest$fgetmRepeat(FlashNotification r0) {
            return r0.mRepeat;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m714$$Nest$fgetmTag(FlashNotification r0) {
            return r0.mTag;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmType, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m715$$Nest$fgetmType(FlashNotification r0) {
            return r0.mType;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmRepeat, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m716$$Nest$fputmRepeat(FlashNotification r0, int r1) {
            r0.mRepeat = r1;
        }

        /* synthetic */ FlashNotification(String r1, int r2, int r3, IBinder r4, IBinder.DeathRecipient r5, FlashNotificationsControllerIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        /* synthetic */ FlashNotification(String r1, int r2, int r3, FlashNotificationsControllerIA r4) {
            this(r1, r2, r3);
        }

        private FlashNotification(String tag, int type, int color) {
            this(tag, type, color, null, null);
        }

        private FlashNotification(String tag, int type, int color, IBinder token, IBinder.DeathRecipient deathRecipient) {
            this.mType = type;
            this.mTag = tag;
            this.mColor = color;
            this.mToken = token;
            this.mDeathRecipient = deathRecipient;
            switch(type) {
                case 2: goto L6;
                case 3: goto L5;
                default: goto L4;
            };
        L4:
            this.mOnDuration = 350;
            this.mOffDuration = 250;
            this.mRepeat = 2;
            this.mForceStartScreenFlash = false;
            return;
        L5:
            this.mOnDuration = 5000;
            this.mOffDuration = 1000;
            this.mRepeat = 1;
            this.mForceStartScreenFlash = true;
            return;
        L6:
            this.mOnDuration = 700;
            this.mOffDuration = 700;
            this.mRepeat = 0;
            this.mForceStartScreenFlash = false;
        }

        boolean tryLinkToDeath() {
            if (this.mToken != null) goto L5;
        L13:
            return false;
        L5:
            if (this.mDeathRecipient == null) goto L13;
            this.mToken.linkToDeath(this.mDeathRecipient, 0);     // Catch: RemoteException -> L10
            return true;
        L10:
            e = move-exception;
            Log.e(FlashNotificationsController.LOG_TAG, "RemoteException", e);
            return false;
        }

        boolean tryUnlinkToDeath() {
            if (this.mToken != null) goto L5;
        L12:
            return false;
        L5:
            if (this.mDeathRecipient == null) goto L12;
            this.mToken.unlinkToDeath(this.mDeathRecipient, 0);     // Catch: Exception -> L10
            return true;
        L11:
            return false;
        }
    }

    private class FlashNotificationThread extends Thread {
        private int mColor;
        private final FlashNotification mFlashNotification;
        private boolean mForceStop;
        private boolean mShouldDoCameraFlash;
        private boolean mShouldDoScreenFlash;
        final /* synthetic */ FlashNotificationsController this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmFlashNotification, reason: not valid java name */
        static /* bridge */ /* synthetic */ FlashNotification m717$$Nest$fgetmFlashNotification(FlashNotificationThread r0) {
            return r0.mFlashNotification;
        }

        /* synthetic */ FlashNotificationThread(FlashNotificationsController r1, FlashNotification r2, FlashNotificationsControllerIA r3) {
            this(r1, r2);
        }

        private FlashNotificationThread(FlashNotificationsController r1, FlashNotification flashNotification) {
            this.this$0 = r1;
            this.mColor = 0;
            this.mShouldDoScreenFlash = false;
            this.mShouldDoCameraFlash = false;
            this.mFlashNotification = flashNotification;
            this.mForceStop = false;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Log.d(FlashNotificationsController.LOG_TAG, "run started: " + FlashNotification.m714$$Nest$fgetmTag(this.mFlashNotification));
            Process.setThreadPriority(-8);
            this.mColor = FlashNotification.m709$$Nest$fgetmColor(this.mFlashNotification);
            boolean r1 = true;
            if (Color.alpha(this.mColor) == 0) goto L5;
        L8:
            boolean r0 = true;
        L9:
            this.mShouldDoScreenFlash = r0;
            if (FlashNotification.m715$$Nest$fgetmType(this.mFlashNotification) != 3) goto L13;
            r1 = false;
        L13:
            this.mShouldDoCameraFlash = r1;
            monitor-enter(this);
            FlashNotificationsController.m688$$Nest$fgetmWakeLock(this.this$0).acquire(300000);     // Catch: Throwable -> L20
            startFlashNotification();     // Catch: Throwable -> L40
            FlashNotificationsController.m700$$Nest$mdoScreenFlashNotificationOff(this.this$0);     // Catch: Throwable -> L20
            FlashNotificationsController.m698$$Nest$mdoCameraFlashNotificationOff(this.this$0);     // Catch: Throwable -> L20
            FlashNotificationsController.m688$$Nest$fgetmWakeLock(this.this$0).release();     // Catch: Throwable -> L20 RuntimeException -> L22
        L24:
            monitor-exit(this);     // Catch: Throwable -> L20
            LinkedList r2 = FlashNotificationsController.m683$$Nest$fgetmFlashNotifications(this.this$0);
            monitor-enter(r2);
        L30:
            th = move-exception;
            throw th;
        L28:
            if (FlashNotificationsController.m686$$Nest$fgetmThread(this.this$0) != this) goto L33;
            FlashNotificationsController.m697$$Nest$fputmThread(this.this$0, null);     // Catch: Throwable -> L30
        L33:
            if (this.mForceStop == true) goto L35;
            this.mFlashNotification.tryUnlinkToDeath();     // Catch: Throwable -> L30
            FlashNotificationsController.m690$$Nest$fputmCurrentFlashNotification(this.this$0, null);     // Catch: Throwable -> L30
        L35:
            monitor-exit(r2);     // Catch: Throwable -> L30
            Log.d(FlashNotificationsController.LOG_TAG, "run finished: " + FlashNotification.m714$$Nest$fgetmTag(this.mFlashNotification));
            return;
        L23:
            Log.e(FlashNotificationsController.LOG_TAG, "Error while releasing FlashNotificationsController wakelock (already released by the system?)");     // Catch: Throwable -> L20
            goto L24
        L40:
            th = move-exception;
            FlashNotificationsController.m700$$Nest$mdoScreenFlashNotificationOff(this.this$0);     // Catch: Throwable -> L20
            FlashNotificationsController.m698$$Nest$mdoCameraFlashNotificationOff(this.this$0);     // Catch: Throwable -> L20
            FlashNotificationsController.m688$$Nest$fgetmWakeLock(this.this$0).release();     // Catch: Throwable -> L20 RuntimeException -> L44
        L47:
            throw th;     // Catch: Throwable -> L20
        L45:
            Log.e(FlashNotificationsController.LOG_TAG, "Error while releasing FlashNotificationsController wakelock (already released by the system?)");     // Catch: Throwable -> L20
        L20:
            th = move-exception;
            throw th;
        L5:
            if (FlashNotification.m710$$Nest$fgetmForceStartScreenFlash(this.mFlashNotification) == true) goto L8;
            r0 = false;
            goto L9
        }

        private void startFlashNotification() {
            monitor-enter(this);
        L28:
        L12:
            th = move-exception;
            throw th;
        L4:
            if (this.mForceStop == true) goto L24;
            if (FlashNotification.m715$$Nest$fgetmType(this.mFlashNotification) == 2) goto L15;
            if (FlashNotification.m713$$Nest$fgetmRepeat(this.mFlashNotification) < 0) goto L15;
            FlashNotification r0 = this.mFlashNotification;     // Catch: Throwable -> L12
            int r1 = FlashNotification.m713$$Nest$fgetmRepeat(r0);     // Catch: Throwable -> L12
            FlashNotification.m716$$Nest$fputmRepeat(r0, r1 - 1);     // Catch: Throwable -> L12
            if (r1 == 0) goto L24;
        L15:
            if (this.mShouldDoScreenFlash == false) goto L18;
            FlashNotificationsController.m701$$Nest$mdoScreenFlashNotificationOn(this.this$0, this.mColor, FlashNotification.m710$$Nest$fgetmForceStartScreenFlash(this.mFlashNotification));     // Catch: Throwable -> L12
        L18:
            if (this.mShouldDoCameraFlash == false) goto L20;
            FlashNotificationsController.m699$$Nest$mdoCameraFlashNotificationOn(this.this$0);     // Catch: Throwable -> L12
        L20:
            delay(FlashNotification.m712$$Nest$fgetmOnDuration(this.mFlashNotification));     // Catch: Throwable -> L12
            FlashNotificationsController.m700$$Nest$mdoScreenFlashNotificationOff(this.this$0);     // Catch: Throwable -> L12
            FlashNotificationsController.m698$$Nest$mdoCameraFlashNotificationOff(this.this$0);     // Catch: Throwable -> L12
            if (this.mForceStop == true) goto L24;
            delay(FlashNotification.m711$$Nest$fgetmOffDuration(this.mFlashNotification));     // Catch: Throwable -> L12
        L24:
            monitor-exit(this);     // Catch: Throwable -> L12
        }

        void cancel() {
            Log.d(FlashNotificationsController.LOG_TAG, "run canceled: " + FlashNotification.m714$$Nest$fgetmTag(this.mFlashNotification));
            monitor-enter(this);
            FlashNotificationsController.m686$$Nest$fgetmThread(this.this$0).mForceStop = true;     // Catch: Throwable -> L7
            FlashNotificationsController.m686$$Nest$fgetmThread(this.this$0).notify();     // Catch: Throwable -> L7
            monitor-exit(this);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        private void delay(long duration) {
            if (duration <= 0) goto L13;
            long bedtime = SystemClock.uptimeMillis() + duration;
        L14:
            wait(duration);     // Catch: InterruptedException -> L7
        L9:
            if (this.mForceStop == true) goto L19;
            duration = bedtime - SystemClock.uptimeMillis();
            if (duration > 0) goto L14;
            return;
        L19:
            return;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @interface FlashNotificationType {
    }

    public static /* synthetic */ void $r8$lambda$5mFsdLGHYnwASjELIFuZP7HfFb0(FlashNotificationsController r0) {
        r0.fadeOutScreenNotificationOverlayViewMainThread();
    }

    public static /* synthetic */ void $r8$lambda$RHNwJQ_YYjN63noLxJ3Is4adkhU(FlashNotificationsController r0, int r1) {
        r0.showScreenNotificationOverlayViewMainThread(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$dKwpLHiqWVLGSIVewpYylLEeS-A, reason: not valid java name */
    public static /* synthetic */ void m675$r8$lambda$dKwpLHiqWVLGSIVewpYylLEeSA(FlashNotificationsController r0, FlashNotification r1) {
        r0.startFlashNotification(r1);
    }

    public static /* synthetic */ void $r8$lambda$lLgKpDcfS6pQ6YdeW07NMkD75nc(FlashNotificationsController r0) {
        r0.hideScreenNotificationOverlayViewMainThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$ylyUb5RdxmoWiL86NHOUU-9BSxk, reason: not valid java name */
    public static /* synthetic */ void m676$r8$lambda$ylyUb5RdxmoWiL86NHOUU9BSxk(FlashNotificationsController r0, String r1) {
        r0.lambda$startFlashNotificationSequence$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAudioPlaybackCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ AudioManager.AudioPlaybackCallback m677$$Nest$fgetmAudioPlaybackCallback(FlashNotificationsController r0) {
        return r0.mAudioPlaybackCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallbackHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m678$$Nest$fgetmCallbackHandler(FlashNotificationsController r0) {
        return r0.mCallbackHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraId, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m679$$Nest$fgetmCameraId(FlashNotificationsController r0) {
        return r0.mCameraId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCameraManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ CameraManager m680$$Nest$fgetmCameraManager(FlashNotificationsController r0) {
        return r0.mCameraManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m681$$Nest$fgetmContext(FlashNotificationsController r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDisplayManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ DisplayManager m682$$Nest$fgetmDisplayManager(FlashNotificationsController r0) {
        return r0.mDisplayManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFlashNotifications, reason: not valid java name */
    static /* bridge */ /* synthetic */ LinkedList m683$$Nest$fgetmFlashNotifications(FlashNotificationsController r0) {
        return r0.mFlashNotifications;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsAlarming, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m684$$Nest$fgetmIsAlarming(FlashNotificationsController r0) {
        return r0.mIsAlarming;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmIsCameraFlashNotificationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m685$$Nest$fgetmIsCameraFlashNotificationEnabled(FlashNotificationsController r0) {
        return r0.mIsCameraFlashNotificationEnabled;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ FlashNotificationThread m686$$Nest$fgetmThread(FlashNotificationsController r0) {
        return r0.mThread;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTorchCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ CameraManager.TorchCallback m687$$Nest$fgetmTorchCallback(FlashNotificationsController r0) {
        return r0.mTorchCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakeLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManager.WakeLock m688$$Nest$fgetmWakeLock(FlashNotificationsController r0) {
        return r0.mWakeLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCameraManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m689$$Nest$fputmCameraManager(FlashNotificationsController r0, CameraManager r1) {
        r0.mCameraManager = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmCurrentFlashNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m690$$Nest$fputmCurrentFlashNotification(FlashNotificationsController r0, FlashNotification r1) {
        r0.mCurrentFlashNotification = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayState, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m691$$Nest$fputmDisplayState(FlashNotificationsController r0, int r1) {
        r0.mDisplayState = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsAlarming, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m692$$Nest$fputmIsAlarming(FlashNotificationsController r0, boolean r1) {
        r0.mIsAlarming = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCameraFlashNotificationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m693$$Nest$fputmIsCameraFlashNotificationEnabled(FlashNotificationsController r0, boolean r1) {
        r0.mIsCameraFlashNotificationEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsCameraOpened, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m694$$Nest$fputmIsCameraOpened(FlashNotificationsController r0, boolean r1) {
        r0.mIsCameraOpened = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsScreenFlashNotificationEnabled, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m695$$Nest$fputmIsScreenFlashNotificationEnabled(FlashNotificationsController r0, boolean r1) {
        r0.mIsScreenFlashNotificationEnabled = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmIsTorchOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m696$$Nest$fputmIsTorchOn(FlashNotificationsController r0, boolean r1) {
        r0.mIsTorchOn = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmThread, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m697$$Nest$fputmThread(FlashNotificationsController r0, FlashNotificationThread r1) {
        r0.mThread = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$mdoCameraFlashNotificationOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m698$$Nest$mdoCameraFlashNotificationOff(FlashNotificationsController r0) {
        r0.doCameraFlashNotificationOff();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoCameraFlashNotificationOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m699$$Nest$mdoCameraFlashNotificationOn(FlashNotificationsController r0) {
        r0.doCameraFlashNotificationOn();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoScreenFlashNotificationOff, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m700$$Nest$mdoScreenFlashNotificationOff(FlashNotificationsController r0) {
        r0.doScreenFlashNotificationOff();
    }

    /* JADX INFO: renamed from: -$$Nest$mdoScreenFlashNotificationOn, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m701$$Nest$mdoScreenFlashNotificationOn(FlashNotificationsController r0, int r1, boolean r2) {
        r0.doScreenFlashNotificationOn(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mprepareForCameraFlashNotification, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m702$$Nest$mprepareForCameraFlashNotification(FlashNotificationsController r0) {
        r0.prepareForCameraFlashNotification();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartFlashNotificationLongPreview, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m703$$Nest$mstartFlashNotificationLongPreview(FlashNotificationsController r0, int r1) {
        r0.startFlashNotificationLongPreview(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mstartFlashNotificationSequenceForAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m704$$Nest$mstartFlashNotificationSequenceForAlarm(FlashNotificationsController r0) {
        r0.startFlashNotificationSequenceForAlarm();
    }

    /* JADX INFO: renamed from: -$$Nest$mstartFlashNotificationShortPreview, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m705$$Nest$mstartFlashNotificationShortPreview(FlashNotificationsController r0) {
        r0.startFlashNotificationShortPreview();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopFlashNotificationLongPreview, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m706$$Nest$mstopFlashNotificationLongPreview(FlashNotificationsController r0) {
        r0.stopFlashNotificationLongPreview();
    }

    /* JADX INFO: renamed from: -$$Nest$mstopFlashNotificationSequenceForAlarm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m707$$Nest$mstopFlashNotificationSequenceForAlarm(FlashNotificationsController r0) {
        r0.stopFlashNotificationSequenceForAlarm();
    }

    FlashNotificationsController(Context context) {
        this(context, getStartedHandler("FlashNotificationThread"), getStartedHandler(LOG_TAG));
    }

    FlashNotificationsController(Context context, Handler flashNotificationHandler, Handler callbackHandler) {
        this.mFlashNotifications = new LinkedList();
        this.mIsTorchTouched = false;
        this.mIsTorchOn = false;
        this.mIsCameraFlashNotificationEnabled = false;
        this.mIsScreenFlashNotificationEnabled = false;
        this.mIsAlarming = false;
        this.mDisplayState = 1;
        this.mIsCameraOpened = false;
        this.mCameraId = null;
        this.mTorchCallback = new AnonymousClass1(this);
        this.mTorchAvailabilityCallback = new AnonymousClass2(this);
        this.mAudioPlaybackCallback = new AnonymousClass3(this);
        this.mContext = context;
        this.mMainHandler = new Handler(this.mContext.getMainLooper());
        this.mFlashNotificationHandler = flashNotificationHandler;
        this.mCallbackHandler = callbackHandler;
        new FlashContentObserver(this, this.mMainHandler).register(this.mContext.getContentResolver());
        IntentFilter broadcastFilter = new IntentFilter();
        broadcastFilter.addAction("android.intent.action.BOOT_COMPLETED");
        broadcastFilter.addAction(ACTION_FLASH_NOTIFICATION_START_PREVIEW);
        broadcastFilter.addAction(ACTION_FLASH_NOTIFICATION_STOP_PREVIEW);
        this.mFlashBroadcastReceiver = new FlashBroadcastReceiver(this);
        this.mContext.registerReceiver(this.mFlashBroadcastReceiver, broadcastFilter, 4);
        PowerManager powerManager = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        this.mWakeLock = powerManager.newWakeLock(1, WAKE_LOCK_TAG);
        this.mDisplayManager = (DisplayManager) this.mContext.getSystemService(DisplayManager.class);
        DisplayManager.DisplayListener displayListener = new AnonymousClass4(this);
        if (this.mDisplayManager == null) goto L6;
        this.mDisplayManager.registerDisplayListener(displayListener, null);
        return;
    }

    private static Handler getStartedHandler(String tag) {
        HandlerThread handlerThread = new HandlerThread(tag);
        handlerThread.start();
        return handlerThread.getThreadHandler();
    }

    boolean startFlashNotificationSequence(final String opPkg, int reason, IBinder token) {
        int r2 = 2;
        FlashNotification flashNotification = new FlashNotification(opPkg, r2, getScreenFlashColorPreference(reason), token, new FlashNotificationsController$$ExternalSyntheticLambda2(this, opPkg), null);
        if (flashNotification.tryLinkToDeath() == true) goto L6;
        return false;
    L6:
        requestStartFlashNotification(flashNotification);
        return true;
    }

    private /* synthetic */ void lambda$startFlashNotificationSequence$0(String opPkg) {
        stopFlashNotification(opPkg);
    }

    boolean stopFlashNotificationSequence(String opPkg) {
        stopFlashNotification(opPkg);
        return true;
    }

    boolean startFlashNotificationEvent(String opPkg, int reason, String reasonPkg) {
        int r3 = 1;
        requestStartFlashNotification(new FlashNotification(opPkg, r3, getScreenFlashColorPreference(reason, reasonPkg), null));
        return true;
    }

    private void startFlashNotificationShortPreview() {
        String r3 = TAG_PREVIEW;
        int r4 = 1;
        requestStartFlashNotification(new FlashNotification(r3, r4, getScreenFlashColorPreference(4), null));
    }

    private void startFlashNotificationLongPreview(int color) {
        String r3 = TAG_PREVIEW;
        requestStartFlashNotification(new FlashNotification(r3, 3, color, null));
    }

    private void stopFlashNotificationLongPreview() {
        stopFlashNotification(TAG_PREVIEW);
    }

    private void startFlashNotificationSequenceForAlarm() {
        String r4 = "alarm";
        requestStartFlashNotification(new FlashNotification(r4, 2, getScreenFlashColorPreference(2), null));
    }

    private void stopFlashNotificationSequenceForAlarm() {
        stopFlashNotification("alarm");
    }

    private void requestStartFlashNotification(FlashNotification flashNotification) {
        Log.d(LOG_TAG, "requestStartFlashNotification");
        boolean isFeatureOn = FeatureFlagUtils.isEnabled(this.mContext, "settings_flash_notifications");
        boolean r4 = false;
        if (isFeatureOn == true) goto L5;
    L7:
        boolean r5 = false;
    L8:
        this.mIsCameraFlashNotificationEnabled = r5;
        if (isFeatureOn == true) goto L11;
    L13:
        this.mIsScreenFlashNotificationEnabled = r4;
        if (FlashNotification.m715$$Nest$fgetmType(flashNotification) == 1) goto L16;
    L18:
        startFlashNotification(flashNotification);
        return;
    L16:
        if (this.mIsScreenFlashNotificationEnabled == false) goto L18;
        this.mMainHandler.sendMessageDelayed(PooledLambda.obtainMessage(new FlashNotificationsController$$ExternalSyntheticLambda4(), this, flashNotification), 300);
        Log.i(LOG_TAG, "give some delay for flash notification");
        return;
    L11:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), SETTING_KEY_SCREEN_FLASH_NOTIFICATION, 0, -2) == 0) goto L13;
        r4 = true;
        goto L13
    L5:
        if (Settings.System.getIntForUser(this.mContext.getContentResolver(), SETTING_KEY_CAMERA_FLASH_NOTIFICATION, 0, -2) == 0) goto L7;
        r5 = true;
        goto L8
    }

    private void stopFlashNotification(String tag) {
        Log.i(LOG_TAG, "stopFlashNotification: tag=" + tag);
        LinkedList<FlashNotification> r0 = this.mFlashNotifications;
        monitor-enter(r0);
        FlashNotification notification = removeFlashNotificationLocked(tag);     // Catch: Throwable -> L9
        if (this.mCurrentFlashNotification != null) goto L7;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L7:
        if (notification != this.mCurrentFlashNotification) goto L11;
        stopFlashNotificationLocked();     // Catch: Throwable -> L9
        startNextFlashNotificationLocked();     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void prepareForCameraFlashNotification() {
        this.mCameraManager = (CameraManager) this.mContext.getSystemService(CameraManager.class);
        if (this.mCameraManager == null) goto L12;
        this.mCameraId = getCameraId();     // Catch: CameraAccessException -> L6
    L8:
        this.mCameraManager.registerTorchCallback(this.mTorchCallback, null);
        return;
    L6:
        e = move-exception;
        Log.e(LOG_TAG, "CameraAccessException", e);
        goto L8
    }

    private String getCameraId() throws CameraAccessException {
        String[] ids = this.mCameraManager.getCameraIdList();
        int r1 = ids.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L14;
        String id = ids[r2];
        CameraCharacteristics c = this.mCameraManager.getCameraCharacteristics(id);
        Boolean flashAvailable = (Boolean) c.get(CameraCharacteristics.FLASH_INFO_AVAILABLE);
        Integer lensFacing = (Integer) c.get(CameraCharacteristics.LENS_FACING);
        if (flashAvailable == null) goto L13;
        if (lensFacing == null) goto L13;
        if (flashAvailable.booleanValue() == false) goto L13;
        if (lensFacing.intValue() != 1) goto L13;
        Log.d(LOG_TAG, "Found valid camera, cameraId=" + id);
        return id;
    L13:
        r2 = r2 + 1;
        goto L3
    L14:
        return null;
    }

    private void showScreenNotificationOverlayView(int color) {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new FlashNotificationsController$$ExternalSyntheticLambda3(), this, Integer.valueOf(color)));
    }

    private void hideScreenNotificationOverlayView() {
        this.mMainHandler.sendMessage(PooledLambda.obtainMessage(new FlashNotificationsController$$ExternalSyntheticLambda0(), this));
        this.mMainHandler.sendMessageDelayed(PooledLambda.obtainMessage(new FlashNotificationsController$$ExternalSyntheticLambda1(), this), 210);
    }

    private void showScreenNotificationOverlayViewMainThread(int color) {
        Log.d(LOG_TAG, "showScreenNotificationOverlayViewMainThread");
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(-1, -1, 2015, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_LOCATION_PROVIDER, -3);
        params.privateFlags |= 16;
        params.layoutInDisplayCutoutMode = 1;
        params.inputFeatures |= 1;
        if (this.mScreenFlashNotificationOverlayView != null) goto L6;
        this.mScreenFlashNotificationOverlayView = getScreenNotificationOverlayView(color);
        ((WindowManager) this.mContext.getSystemService(WindowManager.class)).addView(this.mScreenFlashNotificationOverlayView, params);
        fadeScreenNotificationOverlayViewMainThread(this.mScreenFlashNotificationOverlayView, true);
        return;
    }

    private void fadeOutScreenNotificationOverlayViewMainThread() {
        Log.d(LOG_TAG, "fadeOutScreenNotificationOverlayViewMainThread");
        if (this.mScreenFlashNotificationOverlayView == null) goto L6;
        fadeScreenNotificationOverlayViewMainThread(this.mScreenFlashNotificationOverlayView, false);
        return;
    }

    private void fadeScreenNotificationOverlayViewMainThread(View view, boolean in) {
        float r1 = 1.0f;
        if (in == false) goto L5;
        float r3 = 0.0f;
    L6:
        if (in == true) goto L9;
        r1 = 0.0f;
    L9:
        ObjectAnimator fade = ObjectAnimator.ofFloat(view, "alpha", new float[]{r3, r1});
        fade.setInterpolator(new AccelerateInterpolator());
        fade.setAutoCancel(true);
        fade.setDuration(200);
        fade.start();
        return;
    L5:
        r3 = 1.0f;
        goto L6
    }

    private void hideScreenNotificationOverlayViewMainThread() {
        Log.d(LOG_TAG, "hideScreenNotificationOverlayViewMainThread");
        if (this.mScreenFlashNotificationOverlayView == null) goto L6;
        this.mScreenFlashNotificationOverlayView.setVisibility(8);
        ((WindowManager) this.mContext.getSystemService(WindowManager.class)).removeView(this.mScreenFlashNotificationOverlayView);
        this.mScreenFlashNotificationOverlayView = null;
        return;
    }

    private View getScreenNotificationOverlayView(int color) {
        View screenNotificationOverlayView = new FrameLayout(this.mContext);
        screenNotificationOverlayView.setBackgroundColor(color);
        screenNotificationOverlayView.setAlpha(0.0f);
        return screenNotificationOverlayView;
    }

    private int getScreenFlashColorPreference(int reason, String reasonPkg) {
        return getScreenFlashColorPreference();
    }

    private int getScreenFlashColorPreference(int reason) {
        return getScreenFlashColorPreference();
    }

    private int getScreenFlashColorPreference() {
        return Settings.System.getIntForUser(this.mContext.getContentResolver(), SETTING_KEY_SCREEN_FLASH_NOTIFICATION_COLOR, SCREEN_DEFAULT_COLOR_WITH_ALPHA, -2);
    }

    private void startFlashNotification(FlashNotification flashNotification) {
        int type = FlashNotification.m715$$Nest$fgetmType(flashNotification);
        String tag = FlashNotification.m714$$Nest$fgetmTag(flashNotification);
        Log.i(LOG_TAG, "startFlashNotification: type=" + type + ", tag=" + tag);
        if (this.mIsCameraFlashNotificationEnabled == true) goto L11;
        if (this.mIsScreenFlashNotificationEnabled == true) goto L11;
        if (FlashNotification.m710$$Nest$fgetmForceStartScreenFlash(flashNotification) == true) goto L11;
        Log.d(LOG_TAG, "Flash notification is disabled");
        return;
    L11:
        if (this.mIsCameraOpened == false) goto L15;
        Log.d(LOG_TAG, "Since camera for torch is opened, block notification.");
        return;
    L15:
        if (this.mIsCameraFlashNotificationEnabled == true) goto L17;
    L19:
        long identity = Binder.clearCallingIdentity();
        LinkedList<FlashNotification> r4 = this.mFlashNotifications;     // Catch: Throwable -> L45
        monitor-enter(r4);     // Catch: Throwable -> L45
        if (type == 1) goto L37;
        if (type == 3) goto L37;
        if (type == 2) goto L30;
        Log.e(LOG_TAG, "Unavailable flash notification type");     // Catch: Throwable -> L32
    L40:
        monitor-exit(r4);     // Catch: Throwable -> L32
        Binder.restoreCallingIdentity(identity);
        return;
    L30:
        if (this.mCurrentFlashNotification == null) goto L34;
        removeFlashNotificationLocked(tag);     // Catch: Throwable -> L32
        stopFlashNotificationLocked();     // Catch: Throwable -> L32
    L34:
        this.mFlashNotifications.addFirst(flashNotification);     // Catch: Throwable -> L32
        startNextFlashNotificationLocked();     // Catch: Throwable -> L32
    L37:
        if (this.mCurrentFlashNotification == null) goto L39;
        Log.i(LOG_TAG, "Default type of flash notification can not work because previous flash notification is working");     // Catch: Throwable -> L32
        goto L40
    L39:
        startFlashNotificationLocked(flashNotification);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L17:
        if (this.mCameraId != null) goto L19;
        prepareForCameraFlashNotification();
        goto L19
    }

    private FlashNotification removeFlashNotificationLocked(String tag) {
        ListIterator<FlashNotification> iterator = this.mFlashNotifications.listIterator(0);
    L4:
        if (iterator.hasNext() == false) goto L13;
        FlashNotification notification = iterator.next();
        if (notification == null) goto L4;
        if (FlashNotification.m714$$Nest$fgetmTag(notification).equals(tag) == false) goto L4;
        iterator.remove();
        notification.tryUnlinkToDeath();
        Log.i(LOG_TAG, "removeFlashNotificationLocked: tag=" + FlashNotification.m714$$Nest$fgetmTag(notification));
        return notification;
    L13:
        if (this.mCurrentFlashNotification != null) goto L15;
        return null;
    L15:
        if (FlashNotification.m714$$Nest$fgetmTag(this.mCurrentFlashNotification).equals(tag) == false) goto L26;
        this.mCurrentFlashNotification.tryUnlinkToDeath();
        return this.mCurrentFlashNotification;
    L26:
        return null;
    }

    private void stopFlashNotificationLocked() {
        if (this.mThread == null) goto L5;
        Log.i(LOG_TAG, "stopFlashNotificationLocked: tag=" + FlashNotification.m714$$Nest$fgetmTag(FlashNotificationThread.m717$$Nest$fgetmFlashNotification(this.mThread)));
        this.mThread.cancel();
        this.mThread = null;
    L5:
        doCameraFlashNotificationOff();
        doScreenFlashNotificationOff();
    }

    private void startNextFlashNotificationLocked() {
        Log.i(LOG_TAG, "startNextFlashNotificationLocked");
        if (this.mFlashNotifications.size() > 0) goto L6;
        this.mCurrentFlashNotification = null;
        return;
    L6:
        startFlashNotificationLocked(this.mFlashNotifications.getFirst());
    }

    private void startFlashNotificationLocked(FlashNotification notification) {
        Log.i(LOG_TAG, "startFlashNotificationLocked: type=" + FlashNotification.m715$$Nest$fgetmType(notification) + ", tag=" + FlashNotification.m714$$Nest$fgetmTag(notification));
        this.mCurrentFlashNotification = notification;
        this.mThread = new FlashNotificationThread(this, notification, null);
        this.mFlashNotificationHandler.post(this.mThread);
    }

    private boolean isDozeMode() {
        if (this.mDisplayState != 3) goto L5;
    L8:
        return true;
    L5:
        if (this.mDisplayState == 4) goto L8;
        return false;
    }

    private void doCameraFlashNotificationOn() {
        if (this.mIsCameraFlashNotificationEnabled == true) goto L5;
    L7:
        Log.i(LOG_TAG, "doCameraFlashNotificationOn: isCameraFlashNotificationEnabled=" + this.mIsCameraFlashNotificationEnabled + ", isTorchOn=" + this.mIsTorchOn + ", isTorchTouched=" + this.mIsTorchTouched);
        return;
    L5:
        if (this.mIsTorchOn == true) goto L7;
        doCameraFlashNotification(true);
        goto L7
    }

    private void doCameraFlashNotificationOff() {
        if (this.mIsTorchTouched == false) goto L5;
        doCameraFlashNotification(false);
    L5:
        Log.i(LOG_TAG, "doCameraFlashNotificationOff: isCameraFlashNotificationEnabled=" + this.mIsCameraFlashNotificationEnabled + ", isTorchOn=" + this.mIsTorchOn + ", isTorchTouched=" + this.mIsTorchTouched);
    }

    private void doScreenFlashNotificationOn(int color, boolean forceStartScreenFlash) {
        boolean isDoze = isDozeMode();
        if (this.mIsScreenFlashNotificationEnabled == true) goto L5;
        if (forceStartScreenFlash == true) goto L5;
    L7:
        Log.i(LOG_TAG, "doScreenFlashNotificationOn: isScreenFlashNotificationEnabled=" + this.mIsScreenFlashNotificationEnabled + ", isDozeMode=" + isDoze + ", color=" + Integer.toHexString(color));
        return;
    L5:
        if (isDoze == true) goto L7;
        showScreenNotificationOverlayView(color);
        goto L7
    }

    private void doScreenFlashNotificationOff() {
        hideScreenNotificationOverlayView();
        Log.i(LOG_TAG, "doScreenFlashNotificationOff: isScreenFlashNotificationEnabled=" + this.mIsScreenFlashNotificationEnabled);
    }

    private void doCameraFlashNotification(boolean on) {
        Log.d(LOG_TAG, "doCameraFlashNotification: " + on + " mCameraId : " + this.mCameraId);
        if (this.mCameraManager != null) goto L5;
    L14:
        Log.e(LOG_TAG, "Can not use camera flash notification, please check CameraManager!");
        return;
    L5:
        if (this.mCameraId == null) goto L14;
        this.mCameraManager.setTorchMode(this.mCameraId, on);     // Catch: IllegalArgumentException -> L8 CameraAccessException -> L10
        this.mIsTorchTouched = on;     // Catch: IllegalArgumentException -> L8 CameraAccessException -> L10
    L18:
        return;
    L10:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to setTorchMode: " + e);
        return;
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to setTorchMode: " + e);
    }
}
