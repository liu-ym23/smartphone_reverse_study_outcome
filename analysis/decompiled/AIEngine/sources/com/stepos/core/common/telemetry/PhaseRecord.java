package com.stepos.core.common.telemetry;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PhaseRecord {
    private final long beginMs;
    private final int durationMs;
    private final Hardware hardware;
    private final String phase;

    public PhaseRecord(String phase, Hardware hardware, int i10, long j10) {
        kotlin.jvm.internal.g.f(phase, "phase");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        this.phase = phase;
        this.hardware = hardware;
        this.durationMs = i10;
        this.beginMs = j10;
    }

    public static /* synthetic */ PhaseRecord copy$default(PhaseRecord phaseRecord, String str, Hardware hardware, int i10, long j10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = phaseRecord.phase;
        }
        if ((i11 & 2) != 0) {
            hardware = phaseRecord.hardware;
        }
        if ((i11 & 4) != 0) {
            i10 = phaseRecord.durationMs;
        }
        if ((i11 & 8) != 0) {
            j10 = phaseRecord.beginMs;
        }
        int i12 = i10;
        return phaseRecord.copy(str, hardware, i12, j10);
    }

    public final String component1() {
        return this.phase;
    }

    public final Hardware component2() {
        return this.hardware;
    }

    public final int component3() {
        return this.durationMs;
    }

    public final long component4() {
        return this.beginMs;
    }

    public final PhaseRecord copy(String phase, Hardware hardware, int i10, long j10) {
        kotlin.jvm.internal.g.f(phase, "phase");
        kotlin.jvm.internal.g.f(hardware, "hardware");
        return new PhaseRecord(phase, hardware, i10, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PhaseRecord)) {
            return false;
        }
        PhaseRecord phaseRecord = (PhaseRecord) obj;
        return kotlin.jvm.internal.g.b(this.phase, phaseRecord.phase) && this.hardware == phaseRecord.hardware && this.durationMs == phaseRecord.durationMs && this.beginMs == phaseRecord.beginMs;
    }

    public final long getBeginMs() {
        return this.beginMs;
    }

    public final int getDurationMs() {
        return this.durationMs;
    }

    public final Hardware getHardware() {
        return this.hardware;
    }

    public final String getPhase() {
        return this.phase;
    }

    public int hashCode() {
        return Long.hashCode(this.beginMs) + ai.onnxruntime.a.d(this.durationMs, (this.hardware.hashCode() + (this.phase.hashCode() * 31)) * 31, 31);
    }

    public String toString() {
        String str = this.phase;
        Hardware hardware = this.hardware;
        int i10 = this.durationMs;
        long j10 = this.beginMs;
        StringBuilder sb2 = new StringBuilder("PhaseRecord(phase=");
        sb2.append(str);
        sb2.append(", hardware=");
        sb2.append(hardware);
        sb2.append(", durationMs=");
        com.stepos.core.ota.d.s(sb2, i10, ", beginMs=", j10);
        sb2.append(")");
        return sb2.toString();
    }

    public /* synthetic */ PhaseRecord(String str, Hardware hardware, int i10, long j10, int i11, kotlin.jvm.internal.e eVar) {
        this(str, (i11 & 2) != 0 ? Hardware.NONE : hardware, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? -1L : j10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PhaseRecord(String phase, Hardware hardware, int i10) {
        this(phase, hardware, i10, -1L);
        kotlin.jvm.internal.g.f(phase, "phase");
        kotlin.jvm.internal.g.f(hardware, "hardware");
    }
}
