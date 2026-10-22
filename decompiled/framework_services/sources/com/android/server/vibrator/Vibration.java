package com.android.server.vibrator;

import android.media.AudioAttributes;
import android.os.CombinedVibration;
import android.os.VibrationAttributes;
import android.os.VibrationEffect;
import android.os.vibrator.PrebakedSegment;
import android.os.vibrator.PrimitiveSegment;
import android.os.vibrator.RampSegment;
import android.os.vibrator.StepSegment;
import android.os.vibrator.VibrationEffectSegment;
import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes3.dex */
abstract class Vibration {
    private static final AtomicInteger sNextVibrationId = null;
    public final VibrationSession.CallerInfo callerInfo;
    public final long id;
    private VibrationSession.Status mStatus;
    public final VibrationStats stats;

    static final class DebugInfoImpl implements VibrationSession.DebugInfo {
        private final float mAdaptiveScale;
        private final VibrationSession.CallerInfo mCallerInfo;
        private final long mCreateTime;
        private final long mCreateUptime;
        private final long mDurationMs;
        private final long mEndTime;
        private final CombinedVibration mOriginalEffect;
        private final CombinedVibration mPlayedEffect;
        private final int mScaleLevel;
        private final long mStartTime;
        private final VibrationStats.StatsInfo mStatsInfo;
        private final VibrationSession.Status mStatus;

        DebugInfoImpl(VibrationSession.Status status, VibrationSession.CallerInfo callerInfo, int vibrationType, VibrationStats stats, CombinedVibration playedEffect, CombinedVibration originalEffect, int scaleLevel, float adaptiveScale) {
            callerInfo.getClass();
            this.mCallerInfo = callerInfo;
            this.mStatsInfo = stats.toStatsInfo(callerInfo.uid, vibrationType, callerInfo.attrs.getUsage(), status);
            this.mPlayedEffect = playedEffect;
            this.mOriginalEffect = originalEffect;
            this.mScaleLevel = scaleLevel;
            this.mAdaptiveScale = adaptiveScale;
            this.mStatus = status;
            this.mCreateUptime = stats.getCreateUptimeMillis();
            this.mCreateTime = stats.getCreateTimeDebug();
            this.mStartTime = stats.getStartTimeDebug();
            this.mEndTime = stats.getEndTimeDebug();
            this.mDurationMs = stats.getDurationDebug();
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public VibrationSession.Status getStatus() {
            return this.mStatus;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public long getCreateUptimeMillis() {
            return this.mCreateUptime;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public VibrationSession.CallerInfo getCallerInfo() {
            return this.mCallerInfo;
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public Object getDumpAggregationKey() {
            return this.mPlayedEffect;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("createTime: ");
            r0.append(VibrationSession.DebugInfo.formatTime(this.mCreateTime, true));
            r0.append(", startTime: ");
            r0.append(VibrationSession.DebugInfo.formatTime(this.mStartTime, true));
            r0.append(", endTime: ");
            if (this.mEndTime != 0) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            r0.append(", durationMs: ");
            r0.append(this.mDurationMs);
            r0.append(", status: ");
            r0.append(this.mStatus.name().toLowerCase(Locale.ROOT));
            r0.append(", playedEffect: ");
            r0.append(this.mPlayedEffect);
            r0.append(", originalEffect: ");
            r0.append(this.mOriginalEffect);
            r0.append(", scaleLevel: ");
            r0.append(VibrationScaler.scaleLevelToString(this.mScaleLevel));
            r0.append(", adaptiveScale: ");
            r0.append(String.format(Locale.ROOT, "%.2f", new Object[]{Float.valueOf(this.mAdaptiveScale)}));
            r0.append(", callerInfo: ");
            r0.append(this.mCallerInfo);
            return r0.toString();
        L5:
            r1 = VibrationSession.DebugInfo.formatTime(this.mEndTime, true);
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void logMetrics(VibratorFrameworkStatsLogger statsLogger) {
            statsLogger.logVibrationAdaptiveHapticScale(this.mCallerInfo.uid, this.mAdaptiveScale);
            statsLogger.writeVibrationReportedAsync(this.mStatsInfo);
            int r0 = this.mCallerInfo.uid;
            if (this.mOriginalEffect == null) goto L5;
            CombinedVibration r1 = this.mOriginalEffect;
        L6:
            statsLogger.logVibrationCountAndSizeIfVendorEffect(r0, r1);
            return;
        L5:
            r1 = this.mPlayedEffect;
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dumpCompact(IndentingPrintWriter pw) {
            if (this.mPlayedEffect != null) goto L5;
            boolean isExternalVibration = true;
        L6:
            Locale r3 = Locale.ROOT;
            String r6 = VibrationSession.DebugInfo.formatTime(this.mCreateTime, true);
            if (isExternalVibration == false) goto L10;
            String r1 = "external";
        L9:
            String r7 = r1;
            String r8 = this.mStatus.name().toLowerCase(Locale.ROOT);
            Long r9 = Long.valueOf(this.mDurationMs);
            String audioUsageStr = "";
            if (this.mStartTime != 0) goto L14;
            String r2 = "";
        L16:
            if (this.mEndTime != 0) goto L18;
            String r11 = "";
        L19:
            String timingsStr = String.format(r3, "%s | %8s | %20s | duration: %5dms | start: %12s | end: %12s", new Object[]{r6, r7, r8, r9, r2, r11});
            String paramStr = String.format(Locale.ROOT, " | scale: %8s (adaptive=%.2f) | flags: %4s | usage: %s", new Object[]{VibrationScaler.scaleLevelToString(this.mScaleLevel), Float.valueOf(this.mAdaptiveScale), Long.toBinaryString(this.mCallerInfo.attrs.getFlags()), this.mCallerInfo.attrs.usageToString()});
            if (this.mCallerInfo.attrs.getOriginalAudioUsage() == 0) goto L23;
            audioUsageStr = " | audioUsage=" + AudioAttributes.usageToString(this.mCallerInfo.attrs.getOriginalAudioUsage());
        L23:
            String callerStr = String.format(Locale.ROOT, " | %s (uid=%d, deviceId=%d) | reason: %s", new Object[]{this.mCallerInfo.opPkg, Integer.valueOf(this.mCallerInfo.uid), Integer.valueOf(this.mCallerInfo.deviceId), this.mCallerInfo.reason});
            Locale r5 = Locale.ROOT;
            String r10 = null;
            if (this.mPlayedEffect != null) goto L26;
            String r12 = null;
        L28:
            if (this.mOriginalEffect == null) goto L31;
            r10 = this.mOriginalEffect.toDebugString();
        L31:
            String effectStr = String.format(r5, " | played: %s | original: %s", new Object[]{r12, r10});
            pw.println(timingsStr + paramStr + audioUsageStr + callerStr + effectStr);
            return;
        L26:
            r12 = this.mPlayedEffect.toDebugString();
            goto L28
        L18:
            r11 = VibrationSession.DebugInfo.formatTime(this.mEndTime, false);
            goto L19
        L14:
            r2 = VibrationSession.DebugInfo.formatTime(this.mStartTime, false);
            goto L16
        L10:
            r1 = "effect";
            goto L9
        L5:
            isExternalVibration = false;
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dump(IndentingPrintWriter pw) {
            pw.println("Vibration:");
            pw.increaseIndent();
            pw.println("status = " + this.mStatus.name().toLowerCase(Locale.ROOT));
            pw.println("durationMs = " + this.mDurationMs);
            pw.println("createTime = " + VibrationSession.DebugInfo.formatTime(this.mCreateTime, true));
            pw.println("startTime = " + VibrationSession.DebugInfo.formatTime(this.mStartTime, true));
            StringBuilder r0 = new StringBuilder();
            r0.append("endTime = ");
            if (this.mEndTime != 0) goto L5;
            String r1 = null;
        L6:
            r0.append(r1);
            pw.println(r0.toString());
            pw.println("playedEffect = " + this.mPlayedEffect);
            pw.println("originalEffect = " + this.mOriginalEffect);
            pw.println("scale = " + VibrationScaler.scaleLevelToString(this.mScaleLevel));
            pw.println("adaptiveScale = " + String.format(Locale.ROOT, "%.2f", new Object[]{Float.valueOf(this.mAdaptiveScale)}));
            pw.println("callerInfo = " + this.mCallerInfo);
            pw.decreaseIndent();
            return;
        L5:
            r1 = VibrationSession.DebugInfo.formatTime(this.mEndTime, true);
            goto L6
        }

        @Override // com.android.server.vibrator.VibrationSession.DebugInfo
        public void dump(ProtoOutputStream proto, long fieldId) {
            long token = proto.start(fieldId);
            proto.write(1112396529665L, this.mStartTime);
            proto.write(1112396529666L, this.mEndTime);
            proto.write(1112396529671L, this.mDurationMs);
            proto.write(1159641169928L, this.mStatus.ordinal());
            long attrsToken = proto.start(1146756268037L);
            VibrationAttributes attrs = this.mCallerInfo.attrs;
            proto.write(1120986464257L, attrs.getUsage());
            proto.write(1120986464258L, attrs.getAudioUsage());
            proto.write(1120986464259L, attrs.getFlags());
            proto.end(attrsToken);
            if (this.mPlayedEffect == null) goto L6;
            dumpEffect(proto, 1146756268035L, this.mPlayedEffect);
        L6:
            if (this.mOriginalEffect == null) goto L8;
            dumpEffect(proto, 1146756268036L, this.mOriginalEffect);
        L8:
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, CombinedVibration effect) {
            dumpEffect(proto, fieldId, (CombinedVibration.Sequential) CombinedVibration.startSequential().addNext(effect).combine());
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, CombinedVibration.Sequential effect) {
            long token = proto.start(fieldId);
            int i = 0;
        L4:
            if (i >= effect.getEffects().size()) goto L12;
            CombinedVibration nestedEffect = (CombinedVibration) effect.getEffects().get(i);
            if ((nestedEffect instanceof CombinedVibration.Mono) == false) goto L9;
            dumpEffect(proto, 2246267895809L, (CombinedVibration.Mono) nestedEffect);
        L11:
            proto.write(2220498092034L, ((Integer) effect.getDelays().get(i)).intValue());
            i = i + 1;
            goto L4
        L9:
            if ((nestedEffect instanceof CombinedVibration.Stereo) == false) goto L11;
            dumpEffect(proto, 2246267895809L, (CombinedVibration.Stereo) nestedEffect);
            goto L11
        L12:
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, CombinedVibration.Mono effect) {
            long token = proto.start(fieldId);
            dumpEffect(proto, 2246267895809L, effect.getEffect());
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, CombinedVibration.Stereo effect) {
            long token = proto.start(fieldId);
            int i = 0;
        L4:
            if (i >= effect.getEffects().size()) goto L6;
            proto.write(2220498092034L, effect.getEffects().keyAt(i));
            dumpEffect(proto, 2246267895809L, (VibrationEffect) effect.getEffects().valueAt(i));
            i = i + 1;
            goto L4
        L6:
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, VibrationEffect effect) {
            if ((effect instanceof VibrationEffect.Composed) == false) goto L11;
            VibrationEffect.Composed composed = (VibrationEffect.Composed) effect;
            long token = proto.start(fieldId);
            Iterator r3 = composed.getSegments().iterator();
        L6:
            if (r3.hasNext() == false) goto L8;
            VibrationEffectSegment segment = (VibrationEffectSegment) r3.next();
            dumpEffect(proto, 1146756268033L, segment);
            goto L6
        L8:
            proto.write(1120986464258L, composed.getRepeatIndex());
            proto.end(token);
            return;
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, VibrationEffectSegment segment) {
            long token = proto.start(fieldId);
            if ((segment instanceof StepSegment) == false) goto L6;
            dumpEffect(proto, 1146756268035L, (StepSegment) segment);
        L14:
            proto.end(token);
            return;
        L6:
            if ((segment instanceof RampSegment) == false) goto L9;
            dumpEffect(proto, 1146756268036L, (RampSegment) segment);
            goto L14
        L9:
            if ((segment instanceof PrebakedSegment) == false) goto L12;
            dumpEffect(proto, 1146756268033L, (PrebakedSegment) segment);
            goto L14
        L12:
            if ((segment instanceof PrimitiveSegment) == false) goto L14;
            dumpEffect(proto, 1146756268034L, (PrimitiveSegment) segment);
            goto L14
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, StepSegment segment) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, segment.getDuration());
            proto.write(1108101562370L, segment.getAmplitude());
            proto.write(1108101562371L, segment.getFrequencyHz());
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, RampSegment segment) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, segment.getDuration());
            proto.write(1108101562370L, segment.getStartAmplitude());
            proto.write(1108101562371L, segment.getEndAmplitude());
            proto.write(1108101562372L, segment.getStartFrequencyHz());
            proto.write(1108101562373L, segment.getEndFrequencyHz());
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, PrebakedSegment segment) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, segment.getEffectId());
            proto.write(1120986464258L, segment.getEffectStrength());
            proto.write(1120986464259L, segment.shouldFallback());
            proto.end(token);
        }

        private void dumpEffect(ProtoOutputStream proto, long fieldId, PrimitiveSegment segment) {
            long token = proto.start(fieldId);
            proto.write(1120986464257L, segment.getPrimitiveId());
            proto.write(1108101562370L, segment.getScale());
            proto.write(1120986464259L, segment.getDelay());
            proto.end(token);
        }
    }

    static final class EndInfo {
        public final VibrationSession.CallerInfo endedBy;
        public final VibrationSession.Status status;

        EndInfo(VibrationSession.Status status) {
            this(status, null);
        }

        EndInfo(VibrationSession.Status status, VibrationSession.CallerInfo endedBy) {
            this.status = status;
            this.endedBy = endedBy;
        }

        public boolean equals(Object o) {
            if (this != o) goto L6;
            return true;
        L6:
            if ((o instanceof EndInfo) == true) goto L8;
            return false;
        L8:
            EndInfo that = (EndInfo) o;
            if (Objects.equals(this.endedBy, that.endedBy) == false) goto L14;
            if (this.status != that.status) goto L14;
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.status, this.endedBy});
        }

        public String toString() {
            return "EndInfo{status=" + this.status + ", endedBy=" + this.endedBy + '}';
        }
    }

    abstract VibrationSession.DebugInfo getDebugInfo();

    static {
        sNextVibrationId = new AtomicInteger(1);
    }

    Vibration(VibrationSession.CallerInfo callerInfo) {
        this.stats = new VibrationStats();
        callerInfo.getClass();
        this.mStatus = VibrationSession.Status.RUNNING;
        this.id = sNextVibrationId.getAndIncrement();
        this.callerInfo = callerInfo;
    }

    VibrationSession.Status getStatus() {
        return this.mStatus;
    }

    boolean hasEnded() {
        if (this.mStatus == VibrationSession.Status.RUNNING) goto L5;
        return true;
    L5:
        return false;
    }

    void end(EndInfo endInfo) {
        if (hasEnded() == false) goto L5;
        return;
    L5:
        this.mStatus = endInfo.status;
        this.stats.reportEnded(endInfo.endedBy);
    }
}
