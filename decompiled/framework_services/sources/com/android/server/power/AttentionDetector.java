package com.android.server.power;

import android.R;
import android.app.ActivityManager;
import android.app.SynchronousUserSwitchObserver;
import android.attention.AttentionManagerInternal;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.job.controllers.JobStatus;
import com.android.server.wm.WindowManagerInternal;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public class AttentionDetector {
    private static final boolean DEBUG = false;
    static final long DEFAULT_POST_DIM_CHECK_DURATION_MILLIS = 0;
    static final long DEFAULT_PRE_DIM_CHECK_DURATION_MILLIS = 2000;
    static final String KEY_MAX_EXTENSION_MILLIS = "max_extension_millis";
    static final String KEY_POST_DIM_CHECK_DURATION_MILLIS = "post_dim_check_duration_millis";
    static final String KEY_PRE_DIM_CHECK_DURATION_MILLIS = "pre_dim_check_duration_millis";
    private static final String TAG = "AttentionDetector";
    protected AttentionManagerInternal mAttentionManager;
    AttentionCallbackInternalImpl mCallback;
    private AtomicLong mConsecutiveTimeoutExtendedCount;
    protected ContentResolver mContentResolver;
    private Context mContext;
    protected long mDefaultMaximumExtensionMillis;
    private long mEffectivePostDimTimeoutMillis;
    private boolean mIsSettingEnabled;
    private long mLastActedOnNextScreenDimming;
    private long mLastUserActivityTime;
    private final Object mLock;
    private long mMaximumExtensionMillis;
    private final Runnable mOnUserAttention;
    protected long mPreDimCheckDurationMillis;
    protected int mRequestId;
    private final AtomicBoolean mRequested;
    private long mRequestedPostDimTimeoutMillis;
    private int mWakefulness;
    protected WindowManagerInternal mWindowManager;

    final class AttentionCallbackInternalImpl extends AttentionManagerInternal.AttentionCallbackInternal {
        private final int mId;
        final /* synthetic */ AttentionDetector this$0;

        AttentionCallbackInternalImpl(AttentionDetector this$0, int id) {
            this.this$0 = this$0;
            this.mId = id;
        }

        public void onSuccess(int result, long timestamp) {
            Slog.v(AttentionDetector.TAG, "onSuccess: " + result + ", ID: " + this.mId);
            if (this.mId == this.this$0.mRequestId) goto L5;
            return;
        L5:
            if (AttentionDetector.m7312$$Nest$fgetmRequested(this.this$0).getAndSet(false) == false) goto L23;
            Object r0 = AttentionDetector.m7310$$Nest$fgetmLock(this.this$0);
            monitor-enter(r0);
        L12:
            th = move-exception;
            throw th;
        L9:
            if (AttentionDetector.m7313$$Nest$fgetmWakefulness(this.this$0) == 1) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L14:
            if (result != 1) goto L16;
            AttentionDetector.m7311$$Nest$fgetmOnUserAttention(this.this$0).run();     // Catch: Throwable -> L12
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L16:
            AttentionDetector.m7314$$Nest$mresetConsecutiveExtensionCount(this.this$0);     // Catch: Throwable -> L12
            goto L17
        }

        public void onFailure(int error) {
            Slog.i(AttentionDetector.TAG, "Failed to check attention: " + error + ", ID: " + this.mId);
            AttentionDetector.m7312$$Nest$fgetmRequested(this.this$0).set(false);
        }
    }

    private final class UserSwitchObserver extends SynchronousUserSwitchObserver {
        final /* synthetic */ AttentionDetector this$0;

        /* synthetic */ UserSwitchObserver(AttentionDetector r1, AttentionDetectorIA r2) {
            this(r1);
        }

        private UserSwitchObserver(AttentionDetector r1) {
            this.this$0 = r1;
        }

        public void onUserSwitching(int newUserId) throws RemoteException {
            this.this$0.updateEnabledFromSettings(AttentionDetector.m7309$$Nest$fgetmContext(this.this$0));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$uFRGMJyNR8UGi8bf-BOCXe9GAkc, reason: not valid java name */
    public static /* synthetic */ void m7308$r8$lambda$uFRGMJyNR8UGi8bfBOCXe9GAkc(AttentionDetector r0, DeviceConfig.Properties r1) {
        r0.lambda$systemReady$0(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7309$$Nest$fgetmContext(AttentionDetector r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m7310$$Nest$fgetmLock(AttentionDetector r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmOnUserAttention, reason: not valid java name */
    static /* bridge */ /* synthetic */ Runnable m7311$$Nest$fgetmOnUserAttention(AttentionDetector r0) {
        return r0.mOnUserAttention;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRequested, reason: not valid java name */
    static /* bridge */ /* synthetic */ AtomicBoolean m7312$$Nest$fgetmRequested(AttentionDetector r0) {
        return r0.mRequested;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWakefulness, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m7313$$Nest$fgetmWakefulness(AttentionDetector r0) {
        return r0.mWakefulness;
    }

    /* JADX INFO: renamed from: -$$Nest$mresetConsecutiveExtensionCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7314$$Nest$mresetConsecutiveExtensionCount(AttentionDetector r0) {
        r0.resetConsecutiveExtensionCount();
    }

    public AttentionDetector(Runnable onUserAttention, Object lock) {
        this.mConsecutiveTimeoutExtendedCount = new AtomicLong(0);
        this.mOnUserAttention = onUserAttention;
        this.mLock = lock;
        this.mRequested = new AtomicBoolean(false);
        this.mRequestId = 0;
        this.mWakefulness = 1;
    }

    void updateEnabledFromSettings(Context context) {
        boolean r3 = false;
        if (Settings.Secure.getIntForUser(context.getContentResolver(), "adaptive_sleep", 0, -2) != 1) goto L5;
        r3 = true;
    L5:
        this.mIsSettingEnabled = r3;
    }

    public void systemReady(final Context context) {
        this.mContext = context;
        updateEnabledFromSettings(context);
        this.mContentResolver = context.getContentResolver();
        this.mAttentionManager = (AttentionManagerInternal) LocalServices.getService(AttentionManagerInternal.class);
        this.mWindowManager = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mDefaultMaximumExtensionMillis = context.getResources().getInteger(R.integer.config_attentiveWarningDuration);
        UserSwitchObserver observer = new UserSwitchObserver(this, null);     // Catch: RemoteException -> L5
        ActivityManager.getService().registerUserSwitchObserver(observer, TAG);     // Catch: RemoteException -> L5
    L6:
        ContentResolver r0 = context.getContentResolver();
        Uri r1 = Settings.Secure.getUriFor("adaptive_sleep");
        final Handler r3 = new Handler(context.getMainLooper());
        r0.registerContentObserver(r1, false, new AnonymousClass1(this, r3, context), -1);
        readValuesFromDeviceConfig();
        DeviceConfig.addOnPropertiesChangedListener("attention_manager_service", context.getMainExecutor(), new AttentionDetector$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$systemReady$0(DeviceConfig.Properties properties) {
        onDeviceConfigChange(properties.getKeyset());
    }

    public long updateUserActivity(long nextScreenDimming, long dimDurationMillis) {
        if (nextScreenDimming != this.mLastActedOnNextScreenDimming) goto L5;
    L24:
        return nextScreenDimming;
    L5:
        if (this.mIsSettingEnabled == false) goto L24;
        if (isAttentionServiceSupported() == false) goto L24;
        if (this.mWindowManager.isKeyguardShowingAndNotOccluded() == true) goto L24;
        long now = SystemClock.uptimeMillis();
        long whenToCheck = nextScreenDimming - this.mPreDimCheckDurationMillis;
        long whenToStopExtending = this.mLastUserActivityTime + this.mMaximumExtensionMillis;
        if (now >= whenToCheck) goto L15;
        return whenToCheck;
    L15:
        if (whenToStopExtending >= whenToCheck) goto L18;
        return nextScreenDimming;
    L18:
        if (this.mRequested.get() == false) goto L20;
        return whenToCheck;
    L20:
        this.mRequested.set(true);
        this.mRequestId++;
        this.mLastActedOnNextScreenDimming = nextScreenDimming;
        this.mCallback = new AttentionCallbackInternalImpl(this, this.mRequestId);
        this.mEffectivePostDimTimeoutMillis = Math.min(this.mRequestedPostDimTimeoutMillis, dimDurationMillis);
        Slog.v(TAG, "Checking user attention, ID: " + this.mRequestId);
        boolean sent = this.mAttentionManager.checkAttention(this.mPreDimCheckDurationMillis + this.mEffectivePostDimTimeoutMillis, this.mCallback);
        if (sent == true) goto L23;
        this.mRequested.set(false);
    L23:
        return whenToCheck;
    }

    public int onUserActivity(long eventTime, int event) {
        switch(event) {
            case 0: goto L7;
            case 1: goto L7;
            case 2: goto L7;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return -1;
    L5:
        this.mConsecutiveTimeoutExtendedCount.incrementAndGet();
        return 0;
    L7:
        cancelCurrentRequestIfAny();
        this.mLastUserActivityTime = eventTime;
        resetConsecutiveExtensionCount();
        return 1;
    }

    public void onWakefulnessChangeStarted(int wakefulness) {
        this.mWakefulness = wakefulness;
        if (wakefulness == 1) goto L6;
        cancelCurrentRequestIfAny();
        resetConsecutiveExtensionCount();
        return;
    }

    private void cancelCurrentRequestIfAny() {
        if (this.mRequested.get() == false) goto L6;
        this.mAttentionManager.cancelAttentionCheck(this.mCallback);
        this.mRequested.set(false);
        return;
    }

    private void resetConsecutiveExtensionCount() {
        long previousCount = this.mConsecutiveTimeoutExtendedCount.getAndSet(0);
        if (previousCount <= 0) goto L6;
        FrameworkStatsLog.write(168, previousCount);
        return;
    }

    boolean isAttentionServiceSupported() {
        if (this.mAttentionManager != null) goto L5;
    L7:
        return false;
    L5:
        if (this.mAttentionManager.isAttentionServiceSupported() == false) goto L7;
        return true;
    }

    public void dump(PrintWriter pw) {
        pw.println("AttentionDetector:");
        pw.println(" mIsSettingEnabled=" + this.mIsSettingEnabled);
        pw.println(" mMaxExtensionMillis=" + this.mMaximumExtensionMillis);
        pw.println(" mPreDimCheckDurationMillis=" + this.mPreDimCheckDurationMillis);
        pw.println(" mEffectivePostDimTimeout=" + this.mEffectivePostDimTimeoutMillis);
        pw.println(" mLastUserActivityTime(excludingAttention)=" + this.mLastUserActivityTime);
        pw.println(" mAttentionServiceSupported=" + isAttentionServiceSupported());
        pw.println(" mRequested=" + this.mRequested);
    }

    protected long getPreDimCheckDurationMillis() {
        long millis = DeviceConfig.getLong("attention_manager_service", KEY_PRE_DIM_CHECK_DURATION_MILLIS, 2000);
        if (millis >= 0) goto L5;
    L8:
        Slog.w(TAG, "Bad flag value supplied for: pre_dim_check_duration_millis");
        return 2000;
    L5:
        if (millis > 13000) goto L8;
        return millis;
    }

    protected long getPostDimCheckDurationMillis() {
        long millis = DeviceConfig.getLong("attention_manager_service", KEY_POST_DIM_CHECK_DURATION_MILLIS, 0);
        if (millis >= 0) goto L5;
    L8:
        Slog.w(TAG, "Bad flag value supplied for: post_dim_check_duration_millis");
        return 0;
    L5:
        if (millis > JobStatus.DEFAULT_TRIGGER_UPDATE_DELAY) goto L8;
        return millis;
    }

    protected long getMaxExtensionMillis() {
        long millis = DeviceConfig.getLong("attention_manager_service", KEY_MAX_EXTENSION_MILLIS, this.mDefaultMaximumExtensionMillis);
        if (millis >= 0) goto L5;
    L8:
        Slog.w(TAG, "Bad flag value supplied for: max_extension_millis");
        return this.mDefaultMaximumExtensionMillis;
    L5:
        if (millis > 3600000) goto L8;
        return millis;
    }

    private void onDeviceConfigChange(Set<String> keys) {
        Iterator<String> r0 = keys.iterator();
    L4:
        if (r0.hasNext() == false) goto L22;
        String key = r0.next();
        switch(key.hashCode()) {
            case -2018189628: goto L15;
            case -511526975: goto L12;
            case 417901319: goto L9;
            default: goto L17;
        };
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L20;
            case 1: goto L20;
            case 2: goto L20;
            default: goto L19;
        };
    L19:
        Slog.i(TAG, "Ignoring change on " + key);
        goto L4
    L20:
        readValuesFromDeviceConfig();
        return;
    L9:
        if (key.equals(KEY_PRE_DIM_CHECK_DURATION_MILLIS) == false) goto L17;
        r2 = 2;
        goto L18
    L12:
        if (key.equals(KEY_MAX_EXTENSION_MILLIS) == false) goto L17;
        r2 = 0;
        goto L18
    L15:
        if (key.equals(KEY_POST_DIM_CHECK_DURATION_MILLIS) == false) goto L17;
        r2 = 1;
        goto L18
    }

    private void readValuesFromDeviceConfig() {
        this.mMaximumExtensionMillis = getMaxExtensionMillis();
        this.mPreDimCheckDurationMillis = getPreDimCheckDurationMillis();
        this.mRequestedPostDimTimeoutMillis = getPostDimCheckDurationMillis();
        Slog.i(TAG, "readValuesFromDeviceConfig():\nmMaximumExtensionMillis=" + this.mMaximumExtensionMillis + "\nmPreDimCheckDurationMillis=" + this.mPreDimCheckDurationMillis + "\nmRequestedPostDimTimeoutMillis=" + this.mRequestedPostDimTimeoutMillis);
    }
}
