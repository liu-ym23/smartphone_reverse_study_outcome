package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrPcmSegmentParams {
    private final double absSilenceRms;
    private final long endpointSilenceMs;
    private final long maxSegmentMs;
    private final long minSegmentMs;
    private final double silenceRmsRatio;
    private final long windowMs;

    public AsrPcmSegmentParams(long j10, long j11, long j12, double d8, double d10, long j13) {
        this.maxSegmentMs = j10;
        this.minSegmentMs = j11;
        this.endpointSilenceMs = j12;
        this.silenceRmsRatio = d8;
        this.absSilenceRms = d10;
        this.windowMs = j13;
    }

    public static /* synthetic */ AsrPcmSegmentParams copy$default(AsrPcmSegmentParams asrPcmSegmentParams, long j10, long j11, long j12, double d8, double d10, long j13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = asrPcmSegmentParams.maxSegmentMs;
        }
        return asrPcmSegmentParams.copy(j10, (i10 & 2) != 0 ? asrPcmSegmentParams.minSegmentMs : j11, (i10 & 4) != 0 ? asrPcmSegmentParams.endpointSilenceMs : j12, (i10 & 8) != 0 ? asrPcmSegmentParams.silenceRmsRatio : d8, (i10 & 16) != 0 ? asrPcmSegmentParams.absSilenceRms : d10, (i10 & 32) != 0 ? asrPcmSegmentParams.windowMs : j13);
    }

    public final long component1() {
        return this.maxSegmentMs;
    }

    public final long component2() {
        return this.minSegmentMs;
    }

    public final long component3() {
        return this.endpointSilenceMs;
    }

    public final double component4() {
        return this.silenceRmsRatio;
    }

    public final double component5() {
        return this.absSilenceRms;
    }

    public final long component6() {
        return this.windowMs;
    }

    public final AsrPcmSegmentParams copy(long j10, long j11, long j12, double d8, double d10, long j13) {
        return new AsrPcmSegmentParams(j10, j11, j12, d8, d10, j13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrPcmSegmentParams)) {
            return false;
        }
        AsrPcmSegmentParams asrPcmSegmentParams = (AsrPcmSegmentParams) obj;
        return this.maxSegmentMs == asrPcmSegmentParams.maxSegmentMs && this.minSegmentMs == asrPcmSegmentParams.minSegmentMs && this.endpointSilenceMs == asrPcmSegmentParams.endpointSilenceMs && Double.compare(this.silenceRmsRatio, asrPcmSegmentParams.silenceRmsRatio) == 0 && Double.compare(this.absSilenceRms, asrPcmSegmentParams.absSilenceRms) == 0 && this.windowMs == asrPcmSegmentParams.windowMs;
    }

    public final double getAbsSilenceRms() {
        return this.absSilenceRms;
    }

    public final long getEndpointSilenceMs() {
        return this.endpointSilenceMs;
    }

    public final long getMaxSegmentMs() {
        return this.maxSegmentMs;
    }

    public final long getMinSegmentMs() {
        return this.minSegmentMs;
    }

    public final double getSilenceRmsRatio() {
        return this.silenceRmsRatio;
    }

    public final long getWindowMs() {
        return this.windowMs;
    }

    public int hashCode() {
        return Long.hashCode(this.windowMs) + ((Double.hashCode(this.absSilenceRms) + ((Double.hashCode(this.silenceRmsRatio) + a0.a.c(a0.a.c(Long.hashCode(this.maxSegmentMs) * 31, this.minSegmentMs, 31), this.endpointSilenceMs, 31)) * 31)) * 31);
    }

    public String toString() {
        long j10 = this.maxSegmentMs;
        long j11 = this.minSegmentMs;
        long j12 = this.endpointSilenceMs;
        double d8 = this.silenceRmsRatio;
        double d10 = this.absSilenceRms;
        long j13 = this.windowMs;
        StringBuilder sbQ = ai.onnxruntime.a.q(j10, "AsrPcmSegmentParams(maxSegmentMs=", ", minSegmentMs=");
        sbQ.append(j11);
        a0.a.s(j12, ", endpointSilenceMs=", ", silenceRmsRatio=", sbQ);
        sbQ.append(d8);
        sbQ.append(", absSilenceRms=");
        sbQ.append(d10);
        sbQ.append(", windowMs=");
        return ai.onnxruntime.a.m(sbQ, j13, ")");
    }
}
