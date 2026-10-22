package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.Handler;
import android.os.Parcel;
import android.os.SystemClock;
import android.os.VibrationEffect;
import android.util.Slog;
import com.android.internal.util.FrameworkStatsLog;
import com.android.modules.expresslog.Counter;
import com.android.modules.expresslog.Histogram;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class VibratorFrameworkStatsLogger {
    private static final String TAG = "VibratorFrameworkStatsLogger";
    private static final int VIBRATION_REPORTED_MAX_QUEUE_SIZE = 300;
    private static final int VIBRATION_REPORTED_MIN_INTERVAL_MILLIS = 10;
    private static final int VIBRATION_REPORTED_WARNING_QUEUE_SIZE = 200;
    private static final Histogram sAdaptiveHapticScaleHistogram = null;
    private static final Histogram sVibrationParamRequestLatencyHistogram = null;
    private static final Histogram sVibrationParamScaleHistogram = null;
    private static final Histogram sVibrationVendorEffectSizeHistogram = null;
    private static final Histogram sVibrationVendorSessionVibrationsHistogram = null;
    private final Runnable mConsumeVibrationStatsQueueRunnable;
    private final Handler mHandler;
    private long mLastVibrationReportedLogUptime;
    private final Object mLock;
    private final long mVibrationReportedLogIntervalMillis;
    private final long mVibrationReportedQueueMaxSize;
    private Queue<VibrationStats.StatsInfo> mVibrationStatsQueue;

    public static /* synthetic */ void $r8$lambda$3clAp4KeKtl_6LJMNjTyvIQT3s8(int r0, long r1) {
        lambda$writeVibratorStateOnAsync$1(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$6sCMCxdISmdoENm6LJ5XtEdSNaY(VibratorFrameworkStatsLogger r0) {
        r0.lambda$new$0();
    }

    public static /* synthetic */ void $r8$lambda$e1LVOLtWrkBnktoOi9j1ZkWqiNw(int r0) {
        lambda$writeVibratorStateOffAsync$2(r0);
    }

    static {
        sVibrationParamRequestLatencyHistogram = new Histogram("vibrator.value_vibration_param_request_latency", new Histogram.UniformOptions(20, 0.0f, 100.0f));
        sVibrationParamScaleHistogram = new Histogram("vibrator.value_vibration_param_scale", new Histogram.UniformOptions(20, 0.0f, 2.0f));
        sAdaptiveHapticScaleHistogram = new Histogram("vibrator.value_vibration_adaptive_haptic_scale", new Histogram.UniformOptions(20, 0.0f, 2.0f));
        sVibrationVendorEffectSizeHistogram = new Histogram("vibrator.value_vibration_vendor_effect_size", new Histogram.ScaledRangeOptions(25, 0, 1.0f, 1.4f));
        sVibrationVendorSessionVibrationsHistogram = new Histogram("vibrator.value_vibration_vendor_session_vibrations", new Histogram.ScaledRangeOptions(20, 0, 1.0f, 1.4f));
    }

    private /* synthetic */ void lambda$new$0() {
        writeVibrationReportedFromQueue();
    }

    VibratorFrameworkStatsLogger(Handler handler) {
        this(handler, 10, 300);
    }

    VibratorFrameworkStatsLogger(Handler handler, int vibrationReportedLogIntervalMillis, int vibrationReportedQueueMaxSize) {
        this.mLock = new Object();
        this.mConsumeVibrationStatsQueueRunnable = new VibratorFrameworkStatsLogger$$ExternalSyntheticLambda1(this);
        this.mVibrationStatsQueue = new ArrayDeque();
        this.mHandler = handler;
        this.mVibrationReportedLogIntervalMillis = vibrationReportedLogIntervalMillis;
        this.mVibrationReportedQueueMaxSize = vibrationReportedQueueMaxSize;
    }

    public void writeVibratorStateOnAsync(final int uid, final long duration) {
        this.mHandler.post(new VibratorFrameworkStatsLogger$$ExternalSyntheticLambda0(uid, duration));
    }

    private static /* synthetic */ void lambda$writeVibratorStateOnAsync$1(int uid, long duration) {
        FrameworkStatsLog.write_non_chained(84, uid, null, 1, duration);
    }

    public void writeVibratorStateOffAsync(final int uid) {
        this.mHandler.post(new VibratorFrameworkStatsLogger$$ExternalSyntheticLambda2(uid));
    }

    private static /* synthetic */ void lambda$writeVibratorStateOffAsync$2(int uid) {
        FrameworkStatsLog.write_non_chained(84, uid, null, 0, 0);
    }

    public void writeVibrationReportedAsync(VibrationStats.StatsInfo metrics) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int queueSize = this.mVibrationStatsQueue.size();     // Catch: Throwable -> L11
        if (queueSize != 0) goto L7;
        boolean needsScheduling = true;
    L9:
        if (queueSize >= this.mVibrationReportedQueueMaxSize) goto L13;
        this.mVibrationStatsQueue.offer(metrics);     // Catch: Throwable -> L11
    L13:
        long nextLogUptime = this.mLastVibrationReportedLogUptime + this.mVibrationReportedLogIntervalMillis;     // Catch: Throwable -> L11
        long scheduleDelayMs = Math.max(0, nextLogUptime - SystemClock.uptimeMillis());     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        if ((queueSize + 1) != 200) goto L18;
        Slog.w(TAG, " Approaching vibration metrics queue limit, events might be dropped.");
    L18:
        if (needsScheduling == false) goto L25;
        this.mHandler.postDelayed(this.mConsumeVibrationStatsQueueRunnable, scheduleDelayMs);
        return;
    L25:
        return;
    L7:
        needsScheduling = false;
    L11:
        th = move-exception;
        throw th;
    }

    private void writeVibrationReportedFromQueue() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        VibrationStats.StatsInfo stats = this.mVibrationStatsQueue.poll();     // Catch: Throwable -> L7
        boolean needsScheduling = !this.mVibrationStatsQueue.isEmpty();     // Catch: Throwable -> L7
        if (stats == null) goto L9;
        this.mLastVibrationReportedLogUptime = SystemClock.uptimeMillis();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        if (stats != null) goto L12;
        Slog.w(TAG, "Unexpected vibration metric flush with empty queue. Ignoring.");
    L13:
        if (needsScheduling == false) goto L20;
        this.mHandler.postDelayed(this.mConsumeVibrationStatsQueueRunnable, this.mVibrationReportedLogIntervalMillis);
        return;
    L20:
        return;
    L12:
        stats.writeVibrationReported();
    L7:
        th = move-exception;
        throw th;
    }

    public void logVibrationAdaptiveHapticScale(int uid, float scale) {
        if (Float.compare(scale, 1.0f) == 0) goto L6;
        sAdaptiveHapticScaleHistogram.logSampleWithUid(uid, scale);
        return;
    }

    public void logVibrationParamScale(float scale) {
        sVibrationParamScaleHistogram.logSample(scale);
    }

    public void logVibrationParamRequestLatency(int uid, long latencyMs) {
        sVibrationParamRequestLatencyHistogram.logSampleWithUid(uid, latencyMs);
    }

    public void logVibrationParamRequestTimeout(int uid) {
        Counter.logIncrementWithUid("vibrator.value_vibration_param_request_timeout", uid);
    }

    public void logVibrationParamResponseIgnored() {
        Counter.logIncrement("vibrator.value_vibration_param_response_ignored");
    }

    public static void logPerformHapticsFeedbackIfKeyboard(int uid, int hapticsFeedbackEffect) {
        switch(hapticsFeedbackEffect) {
            case 3: goto L4;
            case 7: goto L4;
            default: goto L3;
        };
    L3:
        boolean isKeyboard = false;
    L5:
        if (isKeyboard == false) goto L8;
        Counter.logIncrementWithUid("vibrator.value_perform_haptic_feedback_keyboard", uid);
        return;
    L8:
        return;
    L4:
        isKeyboard = true;
        goto L5
    }

    public void logVibrationVendorSessionStarted(int uid) {
        Counter.logIncrementWithUid("vibrator.value_vibration_vendor_session_started", uid);
    }

    public void logVibrationVendorSessionInterrupted(int uid) {
        Counter.logIncrementWithUid("vibrator.value_vibration_vendor_session_interrupted", uid);
    }

    public void logVibrationVendorSessionVibrations(int uid, int vibrationCount) {
        sVibrationVendorSessionVibrationsHistogram.logSampleWithUid(uid, vibrationCount);
    }

    public void logVibrationCountAndSizeIfVendorEffect(int uid, CombinedVibration vibration) {
        if (vibration != null) goto L4;
        return;
    L4:
        boolean hasVendorEffects = logVibrationSizeOfVendorEffects(uid, vibration);
        if (hasVendorEffects == false) goto L8;
        Counter.logIncrementWithUid("vibrator.value_vibration_vendor_effect_requests", uid);
        return;
    }

    private static boolean logVibrationSizeOfVendorEffects(int uid, CombinedVibration vibration) {
        if ((vibration instanceof CombinedVibration.Mono) == false) goto L10;
        CombinedVibration.Mono mono = (CombinedVibration.Mono) vibration;
        VibrationEffect.VendorEffect r2 = mono.getEffect();
        if ((r2 instanceof VibrationEffect.VendorEffect) == false) goto L8;
        VibrationEffect.VendorEffect effect = r2;
        logVibrationVendorEffectSize(uid, effect);
        return true;
    L8:
        return false;
    L10:
        if ((vibration instanceof CombinedVibration.Stereo) == false) goto L21;
        CombinedVibration.Stereo stereo = (CombinedVibration.Stereo) vibration;
        boolean hasVendorEffects = false;
        int i = 0;
    L13:
        if (i >= stereo.getEffects().size()) goto L19;
        Object r3 = stereo.getEffects().valueAt(i);
        if ((r3 instanceof VibrationEffect.VendorEffect) == false) goto L17;
        VibrationEffect.VendorEffect effect2 = (VibrationEffect.VendorEffect) r3;
        logVibrationVendorEffectSize(uid, effect2);
        hasVendorEffects = true;
    L17:
        i = i + 1;
        goto L13
    L19:
        return hasVendorEffects;
    L21:
        if ((vibration instanceof CombinedVibration.Sequential) == false) goto L28;
        CombinedVibration.Sequential sequential = (CombinedVibration.Sequential) vibration;
        boolean hasVendorEffects2 = false;
        int i2 = 0;
    L24:
        if (i2 >= sequential.getEffects().size()) goto L27;
        hasVendorEffects2 = hasVendorEffects2 | logVibrationSizeOfVendorEffects(uid, (CombinedVibration) sequential.getEffects().get(i2));
        i2 = i2 + 1;
        goto L24
    L27:
        return hasVendorEffects2;
    L28:
        return false;
    }

    private static void logVibrationVendorEffectSize(int uid, VibrationEffect.VendorEffect effect) {
        Parcel vendorData = Parcel.obtain();
        effect.getVendorData().writeToParcel(vendorData, 0);     // Catch: Throwable -> L6
        int dataSize = vendorData.dataSize();     // Catch: Throwable -> L6
        vendorData.recycle();
        sVibrationVendorEffectSizeHistogram.logSampleWithUid(uid, dataSize);
        return;
    L6:
        th = move-exception;
        vendorData.recycle();
        throw th;
    }
}
