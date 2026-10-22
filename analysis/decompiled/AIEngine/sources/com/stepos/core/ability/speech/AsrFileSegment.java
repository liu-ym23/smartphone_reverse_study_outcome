package com.stepos.core.ability.speech;

import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AsrFileSegment {
    private final boolean isLast;
    private final long offsetMs;
    private final short[] pcm;

    public AsrFileSegment(short[] pcm, long j10, boolean z) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        this.pcm = pcm;
        this.offsetMs = j10;
        this.isLast = z;
    }

    public static /* synthetic */ AsrFileSegment copy$default(AsrFileSegment asrFileSegment, short[] sArr, long j10, boolean z, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sArr = asrFileSegment.pcm;
        }
        if ((i10 & 2) != 0) {
            j10 = asrFileSegment.offsetMs;
        }
        if ((i10 & 4) != 0) {
            z = asrFileSegment.isLast;
        }
        return asrFileSegment.copy(sArr, j10, z);
    }

    public final short[] component1() {
        return this.pcm;
    }

    public final long component2() {
        return this.offsetMs;
    }

    public final boolean component3() {
        return this.isLast;
    }

    public final AsrFileSegment copy(short[] pcm, long j10, boolean z) {
        kotlin.jvm.internal.g.f(pcm, "pcm");
        return new AsrFileSegment(pcm, j10, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AsrFileSegment)) {
            return false;
        }
        AsrFileSegment asrFileSegment = (AsrFileSegment) obj;
        return kotlin.jvm.internal.g.b(this.pcm, asrFileSegment.pcm) && this.offsetMs == asrFileSegment.offsetMs && this.isLast == asrFileSegment.isLast;
    }

    public final long getOffsetMs() {
        return this.offsetMs;
    }

    public final short[] getPcm() {
        return this.pcm;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLast) + a0.a.c(Arrays.hashCode(this.pcm) * 31, this.offsetMs, 31);
    }

    public final boolean isLast() {
        return this.isLast;
    }

    public String toString() {
        String string = Arrays.toString(this.pcm);
        long j10 = this.offsetMs;
        boolean z = this.isLast;
        StringBuilder sbL = com.stepos.core.ota.d.l("AsrFileSegment(pcm=", j10, string, ", offsetMs=");
        sbL.append(", isLast=");
        sbL.append(z);
        sbL.append(")");
        return sbL.toString();
    }
}
