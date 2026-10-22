package com.android.server.vibrator;

import android.os.CombinedVibration;
import android.os.SystemClock;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.PwlePoint;
import android.os.vibrator.RampSegment;
import android.util.Slog;
import android.util.SparseBooleanArray;
import com.android.internal.util.FrameworkStatsLog;

/* JADX INFO: loaded from: classes3.dex */
final class VibrationStats {
    static final String TAG = "VibrationStats";
    private float mAdaptiveScale;
    private long mCreateTimeDebug;
    private long mCreateUptimeMillis;
    private long mEndTimeDebug;
    private long mEndUptimeMillis;
    private int mEndedByUid;
    private int mEndedByUsage;
    private int mInterruptedUsage;
    private int mRepeatCount;
    private long mStartTimeDebug;
    private long mStartUptimeMillis;
    private int mVibrationCompositionTotalSize;
    private int mVibrationPwleTotalSize;
    private int mVibratorComposeCount;
    private int mVibratorComposePwleCount;
    private SparseBooleanArray mVibratorEffectsUsed;
    private int mVibratorOffCount;
    private int mVibratorOnCount;
    private int mVibratorOnTotalDurationMillis;
    private int mVibratorPerformCount;
    private int mVibratorPerformVendorCount;
    private SparseBooleanArray mVibratorPrimitivesUsed;
    private int mVibratorSetAmplitudeCount;
    private int mVibratorSetExternalControlCount;

    public static final class StatsInfo {
        public final float adaptiveScale;
        public final int endLatencyMillis;
        public final boolean endedBySameUid;
        public final int endedByUsage;
        public final int halComposeCount;
        public final int halComposePwleCount;
        public final int halCompositionSize;
        public final int halOffCount;
        public final int halOnCount;
        public final int halPerformCount;
        public final int halPerformVendorCount;
        public final int halPwleSize;
        public final int halSetAmplitudeCount;
        public final int halSetExternalControlCount;
        public final int[] halSupportedCompositionPrimitivesUsed;
        public final int[] halSupportedEffectsUsed;
        public final int[] halUnsupportedCompositionPrimitivesUsed;
        public final int[] halUnsupportedEffectsUsed;
        public final int interruptedUsage;
        private boolean mIsWritten;
        public final int repeatCount;
        public final int startLatencyMillis;
        public final int status;
        public final int totalDurationMillis;
        public final int uid;
        public final int usage;
        public final int vibrationType;
        public final int vibratorOnMillis;

        StatsInfo(int uid, int vibrationType, int usage, VibrationSession.Status status, VibrationStats stats) {
            this.uid = uid;
            this.vibrationType = vibrationType;
            this.usage = usage;
            this.status = status.getProtoEnumValue();
            this.adaptiveScale = VibrationStats.m9295$$Nest$fgetmAdaptiveScale(stats);
            if (uid != VibrationStats.m9298$$Nest$fgetmEndedByUid(stats)) goto L5;
            boolean r1 = true;
        L6:
            this.endedBySameUid = r1;
            this.endedByUsage = VibrationStats.m9299$$Nest$fgetmEndedByUsage(stats);
            this.interruptedUsage = VibrationStats.m9300$$Nest$fgetmInterruptedUsage(stats);
            this.repeatCount = VibrationStats.m9301$$Nest$fgetmRepeatCount(stats);
            long completionUptimeMillis = SystemClock.uptimeMillis();
            this.totalDurationMillis = (int) Math.max(0, completionUptimeMillis - VibrationStats.m9296$$Nest$fgetmCreateUptimeMillis(stats));
            this.vibratorOnMillis = VibrationStats.m9310$$Nest$fgetmVibratorOnTotalDurationMillis(stats);
            if (stats.hasStarted() == false) goto L9;
            this.startLatencyMillis = (int) Math.max(0, VibrationStats.m9302$$Nest$fgetmStartUptimeMillis(stats) - VibrationStats.m9296$$Nest$fgetmCreateUptimeMillis(stats));
            this.endLatencyMillis = (int) Math.max(0, completionUptimeMillis - VibrationStats.m9297$$Nest$fgetmEndUptimeMillis(stats));
        L10:
            this.halComposeCount = VibrationStats.m9305$$Nest$fgetmVibratorComposeCount(stats);
            this.halComposePwleCount = VibrationStats.m9306$$Nest$fgetmVibratorComposePwleCount(stats);
            this.halOnCount = VibrationStats.m9309$$Nest$fgetmVibratorOnCount(stats);
            this.halOffCount = VibrationStats.m9308$$Nest$fgetmVibratorOffCount(stats);
            this.halPerformCount = VibrationStats.m9311$$Nest$fgetmVibratorPerformCount(stats);
            this.halPerformVendorCount = VibrationStats.m9312$$Nest$fgetmVibratorPerformVendorCount(stats);
            this.halSetAmplitudeCount = VibrationStats.m9314$$Nest$fgetmVibratorSetAmplitudeCount(stats);
            this.halSetExternalControlCount = VibrationStats.m9315$$Nest$fgetmVibratorSetExternalControlCount(stats);
            this.halCompositionSize = VibrationStats.m9303$$Nest$fgetmVibrationCompositionTotalSize(stats);
            this.halPwleSize = VibrationStats.m9304$$Nest$fgetmVibrationPwleTotalSize(stats);
            this.halSupportedCompositionPrimitivesUsed = filteredKeys(VibrationStats.m9313$$Nest$fgetmVibratorPrimitivesUsed(stats), true);
            this.halSupportedEffectsUsed = filteredKeys(VibrationStats.m9307$$Nest$fgetmVibratorEffectsUsed(stats), true);
            this.halUnsupportedCompositionPrimitivesUsed = filteredKeys(VibrationStats.m9313$$Nest$fgetmVibratorPrimitivesUsed(stats), false);
            this.halUnsupportedEffectsUsed = filteredKeys(VibrationStats.m9307$$Nest$fgetmVibratorEffectsUsed(stats), false);
            return;
        L9:
            this.endLatencyMillis = 0;
            this.startLatencyMillis = 0;
            goto L10
        L5:
            r1 = false;
            goto L6
        }

        boolean isWritten() {
            return this.mIsWritten;
        }

        void writeVibrationReported() {
            if (this.mIsWritten == false) goto L5;
            Slog.wtf(VibrationStats.TAG, "Writing same vibration stats multiple times for uid=" + this.uid);
        L5:
            this.mIsWritten = true;
            FrameworkStatsLog.write_non_chained(FrameworkStatsLog.VIBRATION_REPORTED, this.uid, null, this.vibrationType, this.usage, this.status, this.endedBySameUid, this.endedByUsage, this.interruptedUsage, this.repeatCount, this.totalDurationMillis, this.vibratorOnMillis, this.startLatencyMillis, this.endLatencyMillis, this.halComposeCount, this.halComposePwleCount, this.halOnCount, this.halOffCount, this.halPerformCount, this.halSetAmplitudeCount, this.halSetExternalControlCount, this.halSupportedCompositionPrimitivesUsed, this.halSupportedEffectsUsed, this.halUnsupportedCompositionPrimitivesUsed, this.halUnsupportedEffectsUsed, this.halCompositionSize, this.halPwleSize, this.adaptiveScale, this.halPerformVendorCount);
        }

        private static int[] filteredKeys(SparseBooleanArray supportArray, boolean supported) {
            int count = 0;
            int i = 0;
        L4:
            if (i >= supportArray.size()) goto L10;
            if (supportArray.valueAt(i) != supported) goto L8;
            count = count + 1;
        L8:
            i = i + 1;
            goto L4
        L10:
            if (count != 0) goto L13;
            return null;
        L13:
            int pos = 0;
            int[] res = new int[count];
            int i2 = 0;
        L15:
            if (i2 >= supportArray.size()) goto L21;
            if (supportArray.valueAt(i2) != supported) goto L19;
            res[pos] = supportArray.keyAt(i2);
            pos = pos + 1;
        L19:
            i2 = i2 + 1;
            goto L15
        L21:
            return res;
        }

        public static int findVibrationType(CombinedVibration effect) {
            if (effect != null) goto L6;
            return 1;
        L6:
            if (effect.hasVendorEffects() == false) goto L10;
            return 4;
        L10:
            if (effect.getDuration() != Long.MAX_VALUE) goto L13;
            return 2;
        L13:
            return 1;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAdaptiveScale, reason: not valid java name */
    static /* bridge */ /* synthetic */ float m9295$$Nest$fgetmAdaptiveScale(VibrationStats r0) {
        return r0.mAdaptiveScale;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCreateUptimeMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9296$$Nest$fgetmCreateUptimeMillis(VibrationStats r2) {
        return r2.mCreateUptimeMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEndUptimeMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9297$$Nest$fgetmEndUptimeMillis(VibrationStats r2) {
        return r2.mEndUptimeMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEndedByUid, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9298$$Nest$fgetmEndedByUid(VibrationStats r0) {
        return r0.mEndedByUid;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmEndedByUsage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9299$$Nest$fgetmEndedByUsage(VibrationStats r0) {
        return r0.mEndedByUsage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmInterruptedUsage, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9300$$Nest$fgetmInterruptedUsage(VibrationStats r0) {
        return r0.mInterruptedUsage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmRepeatCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9301$$Nest$fgetmRepeatCount(VibrationStats r0) {
        return r0.mRepeatCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmStartUptimeMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m9302$$Nest$fgetmStartUptimeMillis(VibrationStats r2) {
        return r2.mStartUptimeMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibrationCompositionTotalSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9303$$Nest$fgetmVibrationCompositionTotalSize(VibrationStats r0) {
        return r0.mVibrationCompositionTotalSize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibrationPwleTotalSize, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9304$$Nest$fgetmVibrationPwleTotalSize(VibrationStats r0) {
        return r0.mVibrationPwleTotalSize;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorComposeCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9305$$Nest$fgetmVibratorComposeCount(VibrationStats r0) {
        return r0.mVibratorComposeCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorComposePwleCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9306$$Nest$fgetmVibratorComposePwleCount(VibrationStats r0) {
        return r0.mVibratorComposePwleCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorEffectsUsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m9307$$Nest$fgetmVibratorEffectsUsed(VibrationStats r0) {
        return r0.mVibratorEffectsUsed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorOffCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9308$$Nest$fgetmVibratorOffCount(VibrationStats r0) {
        return r0.mVibratorOffCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorOnCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9309$$Nest$fgetmVibratorOnCount(VibrationStats r0) {
        return r0.mVibratorOnCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorOnTotalDurationMillis, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9310$$Nest$fgetmVibratorOnTotalDurationMillis(VibrationStats r0) {
        return r0.mVibratorOnTotalDurationMillis;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorPerformCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9311$$Nest$fgetmVibratorPerformCount(VibrationStats r0) {
        return r0.mVibratorPerformCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorPerformVendorCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9312$$Nest$fgetmVibratorPerformVendorCount(VibrationStats r0) {
        return r0.mVibratorPerformVendorCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorPrimitivesUsed, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseBooleanArray m9313$$Nest$fgetmVibratorPrimitivesUsed(VibrationStats r0) {
        return r0.mVibratorPrimitivesUsed;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorSetAmplitudeCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9314$$Nest$fgetmVibratorSetAmplitudeCount(VibrationStats r0) {
        return r0.mVibratorSetAmplitudeCount;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmVibratorSetExternalControlCount, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m9315$$Nest$fgetmVibratorSetExternalControlCount(VibrationStats r0) {
        return r0.mVibratorSetExternalControlCount;
    }

    VibrationStats() {
        this.mVibratorEffectsUsed = new SparseBooleanArray();
        this.mVibratorPrimitivesUsed = new SparseBooleanArray();
        this.mCreateUptimeMillis = SystemClock.uptimeMillis();
        this.mCreateTimeDebug = System.currentTimeMillis();
        this.mEndedByUid = -1;
        this.mEndedByUsage = -1;
        this.mInterruptedUsage = -1;
    }

    StatsInfo toStatsInfo(int uid, int vibrationType, int usage, VibrationSession.Status status) {
        return new StatsInfo(uid, vibrationType, usage, status, this);
    }

    long getCreateUptimeMillis() {
        return this.mCreateUptimeMillis;
    }

    long getStartUptimeMillis() {
        return this.mStartUptimeMillis;
    }

    long getEndUptimeMillis() {
        return this.mEndUptimeMillis;
    }

    long getCreateTimeDebug() {
        return this.mCreateTimeDebug;
    }

    long getStartTimeDebug() {
        return this.mStartTimeDebug;
    }

    long getEndTimeDebug() {
        return this.mEndTimeDebug;
    }

    long getDurationDebug() {
        if (hasEnded() == true) goto L7;
        return -1;
    L7:
        return this.mEndUptimeMillis - this.mCreateUptimeMillis;
    }

    boolean hasEnded() {
        if (this.mEndUptimeMillis <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    boolean hasStarted() {
        if (this.mStartUptimeMillis <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    void reportStarted() {
        if (hasEnded() == false) goto L5;
        return;
    L5:
        if (this.mStartUptimeMillis != 0) goto L10;
        this.mStartUptimeMillis = SystemClock.uptimeMillis();
        this.mStartTimeDebug = System.currentTimeMillis();
        return;
    }

    boolean reportEnded(VibrationSession.CallerInfo endedBy) {
        if (hasEnded() == false) goto L6;
        return false;
    L6:
        if (endedBy == null) goto L8;
        this.mEndedByUid = endedBy.uid;
        this.mEndedByUsage = endedBy.attrs.getUsage();
    L8:
        this.mEndUptimeMillis = SystemClock.uptimeMillis();
        this.mEndTimeDebug = System.currentTimeMillis();
        return true;
    }

    void reportInterruptedAnotherVibration(VibrationSession.CallerInfo callerInfo) {
        if (this.mInterruptedUsage >= 0) goto L6;
        this.mInterruptedUsage = callerInfo.attrs.getUsage();
        return;
    }

    void reportAdaptiveScale(float scale) {
        if (Float.compare(scale, 1.0f) == 0) goto L6;
        this.mAdaptiveScale = scale;
        return;
    }

    void reportRepetition(int loops) {
        this.mRepeatCount += loops;
    }

    void reportVibratorOn(long halResult) {
        this.mVibratorOnCount++;
        if (halResult <= 0) goto L6;
        this.mVibratorOnTotalDurationMillis += (int) halResult;
        return;
    }

    void reportVibratorOff() {
        this.mVibratorOffCount++;
    }

    void reportSetAmplitude() {
        this.mVibratorSetAmplitudeCount++;
    }

    void reportPerformEffect(long halResult, PrebakedSegment prebaked) {
        this.mVibratorPerformCount++;
        if (halResult <= 0) goto L5;
        this.mVibratorEffectsUsed.put(prebaked.getEffectId(), true);
        this.mVibratorOnTotalDurationMillis += (int) halResult;
        return;
    L5:
        this.mVibratorEffectsUsed.put(prebaked.getEffectId(), false);
    }

    void reportPerformVendorEffect(long halResult) {
        this.mVibratorPerformVendorCount++;
    }

    void reportComposePrimitives(long halResult, PrimitiveSegment[] primitives) {
        this.mVibratorComposeCount++;
        this.mVibrationCompositionTotalSize += primitives.length;
        int r4 = 0;
        if (halResult <= 0) goto L10;
        int r0 = primitives.length;
    L5:
        if (r4 >= r0) goto L8;
        PrimitiveSegment primitive = primitives[r4];
        halResult = halResult - ((long) primitive.getDelay());
        this.mVibratorPrimitivesUsed.put(primitive.getPrimitiveId(), true);
        r4 = r4 + 1;
        goto L5
    L8:
        if (halResult <= 0) goto L14;
        this.mVibratorOnTotalDurationMillis += (int) halResult;
        return;
    L14:
        return;
    L10:
        int r1 = primitives.length;
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L18;
        this.mVibratorPrimitivesUsed.put(primitives[r2].getPrimitiveId(), false);
        r2 = r2 + 1;
        goto L12
    }

    void reportComposePwle(long halResult, RampSegment[] segments) {
        this.mVibratorComposePwleCount++;
        this.mVibrationPwleTotalSize += segments.length;
        if (halResult <= 0) goto L20;
        int r2 = segments.length;
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L13;
        RampSegment ramp = segments[r3];
        if (ramp.getStartAmplitude() != 0.0f) goto L11;
        if (ramp.getEndAmplitude() != 0.0f) goto L11;
        halResult = halResult - ramp.getDuration();
    L11:
        r3 = r3 + 1;
        goto L5
    L13:
        if (halResult <= 0) goto L21;
        this.mVibratorOnTotalDurationMillis += (int) halResult;
        return;
    L21:
        return;
    }

    void reportComposePwle(long halResult, PwlePoint[] pwlePoints) {
        this.mVibratorComposePwleCount++;
        this.mVibrationPwleTotalSize += pwlePoints.length;
        if (halResult <= 0) goto L21;
        int i = 0;
    L6:
        if (i >= (pwlePoints.length - 1)) goto L14;
        PwlePoint current = pwlePoints[i];
        PwlePoint next = pwlePoints[i + 1];
        if (current.getAmplitude() != 0.0f) goto L12;
        if (next.getAmplitude() != 0.0f) goto L12;
        halResult = halResult - ((long) next.getTimeMillis());
    L12:
        i = i + 1;
        goto L6
    L14:
        if (halResult <= 0) goto L22;
        this.mVibratorOnTotalDurationMillis += (int) halResult;
        return;
    L22:
        return;
    }

    void reportSetExternalControl() {
        this.mVibratorSetExternalControlCount++;
    }
}
