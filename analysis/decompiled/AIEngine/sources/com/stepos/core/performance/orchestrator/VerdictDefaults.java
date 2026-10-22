package com.stepos.core.performance.orchestrator;

import ai.onnxruntime.a;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.AsrFilePcmSegmentPolicy;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import com.stepos.core.performance.data.BackendConstraint;
import com.stepos.core.performance.data.SignalSnapshot;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class VerdictDefaults {
    public static final Companion Companion = new Companion(null);
    private final BackendConstraint backendConstraint;
    private final List<BackendType> backendFallbackChain;
    private final long backgroundDurationMs;
    private final int batteryLevel;
    private final int cacheEvictionRetainMb;
    private final int cbFailureThreshold;
    private final long cbResetTimeoutMs;
    private final long deferredReleaseDelayMs;
    private final int dspMaxConcurrent;
    private final long idleTimeoutMs;
    private final boolean isCharging;
    private final boolean isForeground;
    private final int maxConcurrent;
    private final BackendType recommendedBackend;
    private final boolean shouldEvictAllIdle;
    private final boolean suggestCloudRouting;
    private final ThermalState thermalState;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final VerdictDefaults from(SignalSnapshot snapshot) {
            g.f(snapshot, "snapshot");
            return new VerdictDefaults(snapshot.getHasNpu() ? BackendType.f6254d : BackendType.f6256j, m.b0(BackendType.f6254d, BackendType.h, BackendType.f6255e, BackendType.f6256j), BackendConstraint.FREE, 3, 1, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, 0L, Integer.MAX_VALUE, false, false, 5, AsrFilePcmSegmentPolicy.MAX_SEGMENT_MS, snapshot.getThermalState(), snapshot.getBatteryLevel(), snapshot.isCharging(), snapshot.isForeground(), snapshot.getBackgroundDurationMs());
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public VerdictDefaults(BackendType recommendedBackend, List<? extends BackendType> backendFallbackChain, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13) {
        g.f(recommendedBackend, "recommendedBackend");
        g.f(backendFallbackChain, "backendFallbackChain");
        g.f(backendConstraint, "backendConstraint");
        g.f(thermalState, "thermalState");
        this.recommendedBackend = recommendedBackend;
        this.backendFallbackChain = backendFallbackChain;
        this.backendConstraint = backendConstraint;
        this.maxConcurrent = i10;
        this.dspMaxConcurrent = i11;
        this.idleTimeoutMs = j10;
        this.deferredReleaseDelayMs = j11;
        this.cacheEvictionRetainMb = i12;
        this.shouldEvictAllIdle = z;
        this.suggestCloudRouting = z3;
        this.cbFailureThreshold = i13;
        this.cbResetTimeoutMs = j12;
        this.thermalState = thermalState;
        this.batteryLevel = i14;
        this.isCharging = z10;
        this.isForeground = z11;
        this.backgroundDurationMs = j13;
    }

    public static /* synthetic */ VerdictDefaults copy$default(VerdictDefaults verdictDefaults, BackendType backendType, List list, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13, int i15, Object obj) {
        long j14;
        boolean z12;
        int i16;
        BackendType backendType2 = (i15 & 1) != 0 ? verdictDefaults.recommendedBackend : backendType;
        List list2 = (i15 & 2) != 0 ? verdictDefaults.backendFallbackChain : list;
        BackendConstraint backendConstraint2 = (i15 & 4) != 0 ? verdictDefaults.backendConstraint : backendConstraint;
        int i17 = (i15 & 8) != 0 ? verdictDefaults.maxConcurrent : i10;
        int i18 = (i15 & 16) != 0 ? verdictDefaults.dspMaxConcurrent : i11;
        long j15 = (i15 & 32) != 0 ? verdictDefaults.idleTimeoutMs : j10;
        long j16 = (i15 & 64) != 0 ? verdictDefaults.deferredReleaseDelayMs : j11;
        int i19 = (i15 & TraceIdKeys.MAX_LENGTH) != 0 ? verdictDefaults.cacheEvictionRetainMb : i12;
        boolean z13 = (i15 & 256) != 0 ? verdictDefaults.shouldEvictAllIdle : z;
        boolean z14 = (i15 & VadSessionManager.FRAME_BYTES) != 0 ? verdictDefaults.suggestCloudRouting : z3;
        int i20 = (i15 & 1024) != 0 ? verdictDefaults.cbFailureThreshold : i13;
        BackendType backendType3 = backendType2;
        List list3 = list2;
        long j17 = (i15 & 2048) != 0 ? verdictDefaults.cbResetTimeoutMs : j12;
        ThermalState thermalState2 = (i15 & 4096) != 0 ? verdictDefaults.thermalState : thermalState;
        long j18 = j17;
        int i21 = (i15 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? verdictDefaults.batteryLevel : i14;
        boolean z15 = (i15 & 16384) != 0 ? verdictDefaults.isCharging : z10;
        boolean z16 = (i15 & 32768) != 0 ? verdictDefaults.isForeground : z11;
        if ((i15 & 65536) != 0) {
            i16 = i21;
            z12 = z16;
            j14 = verdictDefaults.backgroundDurationMs;
        } else {
            j14 = j13;
            z12 = z16;
            i16 = i21;
        }
        return verdictDefaults.copy(backendType3, list3, backendConstraint2, i17, i18, j15, j16, i19, z13, z14, i20, j18, thermalState2, i16, z15, z12, j14);
    }

    public final BackendType component1() {
        return this.recommendedBackend;
    }

    public final boolean component10() {
        return this.suggestCloudRouting;
    }

    public final int component11() {
        return this.cbFailureThreshold;
    }

    public final long component12() {
        return this.cbResetTimeoutMs;
    }

    public final ThermalState component13() {
        return this.thermalState;
    }

    public final int component14() {
        return this.batteryLevel;
    }

    public final boolean component15() {
        return this.isCharging;
    }

    public final boolean component16() {
        return this.isForeground;
    }

    public final long component17() {
        return this.backgroundDurationMs;
    }

    public final List<BackendType> component2() {
        return this.backendFallbackChain;
    }

    public final BackendConstraint component3() {
        return this.backendConstraint;
    }

    public final int component4() {
        return this.maxConcurrent;
    }

    public final int component5() {
        return this.dspMaxConcurrent;
    }

    public final long component6() {
        return this.idleTimeoutMs;
    }

    public final long component7() {
        return this.deferredReleaseDelayMs;
    }

    public final int component8() {
        return this.cacheEvictionRetainMb;
    }

    public final boolean component9() {
        return this.shouldEvictAllIdle;
    }

    public final VerdictDefaults copy(BackendType recommendedBackend, List<? extends BackendType> backendFallbackChain, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13) {
        g.f(recommendedBackend, "recommendedBackend");
        g.f(backendFallbackChain, "backendFallbackChain");
        g.f(backendConstraint, "backendConstraint");
        g.f(thermalState, "thermalState");
        return new VerdictDefaults(recommendedBackend, backendFallbackChain, backendConstraint, i10, i11, j10, j11, i12, z, z3, i13, j12, thermalState, i14, z10, z11, j13);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerdictDefaults)) {
            return false;
        }
        VerdictDefaults verdictDefaults = (VerdictDefaults) obj;
        return this.recommendedBackend == verdictDefaults.recommendedBackend && g.b(this.backendFallbackChain, verdictDefaults.backendFallbackChain) && this.backendConstraint == verdictDefaults.backendConstraint && this.maxConcurrent == verdictDefaults.maxConcurrent && this.dspMaxConcurrent == verdictDefaults.dspMaxConcurrent && this.idleTimeoutMs == verdictDefaults.idleTimeoutMs && this.deferredReleaseDelayMs == verdictDefaults.deferredReleaseDelayMs && this.cacheEvictionRetainMb == verdictDefaults.cacheEvictionRetainMb && this.shouldEvictAllIdle == verdictDefaults.shouldEvictAllIdle && this.suggestCloudRouting == verdictDefaults.suggestCloudRouting && this.cbFailureThreshold == verdictDefaults.cbFailureThreshold && this.cbResetTimeoutMs == verdictDefaults.cbResetTimeoutMs && this.thermalState == verdictDefaults.thermalState && this.batteryLevel == verdictDefaults.batteryLevel && this.isCharging == verdictDefaults.isCharging && this.isForeground == verdictDefaults.isForeground && this.backgroundDurationMs == verdictDefaults.backgroundDurationMs;
    }

    public final BackendConstraint getBackendConstraint() {
        return this.backendConstraint;
    }

    public final List<BackendType> getBackendFallbackChain() {
        return this.backendFallbackChain;
    }

    public final long getBackgroundDurationMs() {
        return this.backgroundDurationMs;
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    public final int getCacheEvictionRetainMb() {
        return this.cacheEvictionRetainMb;
    }

    public final int getCbFailureThreshold() {
        return this.cbFailureThreshold;
    }

    public final long getCbResetTimeoutMs() {
        return this.cbResetTimeoutMs;
    }

    public final long getDeferredReleaseDelayMs() {
        return this.deferredReleaseDelayMs;
    }

    public final int getDspMaxConcurrent() {
        return this.dspMaxConcurrent;
    }

    public final long getIdleTimeoutMs() {
        return this.idleTimeoutMs;
    }

    public final int getMaxConcurrent() {
        return this.maxConcurrent;
    }

    public final BackendType getRecommendedBackend() {
        return this.recommendedBackend;
    }

    public final boolean getShouldEvictAllIdle() {
        return this.shouldEvictAllIdle;
    }

    public final boolean getSuggestCloudRouting() {
        return this.suggestCloudRouting;
    }

    public final ThermalState getThermalState() {
        return this.thermalState;
    }

    public int hashCode() {
        return Long.hashCode(this.backgroundDurationMs) + a.f(a.f(a.d(this.batteryLevel, (this.thermalState.hashCode() + a0.a.c(a.d(this.cbFailureThreshold, a.f(a.f(a.d(this.cacheEvictionRetainMb, a0.a.c(a0.a.c(a.d(this.dspMaxConcurrent, a.d(this.maxConcurrent, (this.backendConstraint.hashCode() + h0.e.b(this.backendFallbackChain, this.recommendedBackend.hashCode() * 31, 31)) * 31, 31), 31), this.idleTimeoutMs, 31), this.deferredReleaseDelayMs, 31), 31), 31, this.shouldEvictAllIdle), 31, this.suggestCloudRouting), 31), this.cbResetTimeoutMs, 31)) * 31, 31), 31, this.isCharging), 31, this.isForeground);
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public String toString() {
        BackendType backendType = this.recommendedBackend;
        List<BackendType> list = this.backendFallbackChain;
        BackendConstraint backendConstraint = this.backendConstraint;
        int i10 = this.maxConcurrent;
        int i11 = this.dspMaxConcurrent;
        long j10 = this.idleTimeoutMs;
        long j11 = this.deferredReleaseDelayMs;
        int i12 = this.cacheEvictionRetainMb;
        boolean z = this.shouldEvictAllIdle;
        boolean z3 = this.suggestCloudRouting;
        int i13 = this.cbFailureThreshold;
        long j12 = this.cbResetTimeoutMs;
        ThermalState thermalState = this.thermalState;
        int i14 = this.batteryLevel;
        boolean z10 = this.isCharging;
        boolean z11 = this.isForeground;
        long j13 = this.backgroundDurationMs;
        StringBuilder sb2 = new StringBuilder("VerdictDefaults(recommendedBackend=");
        sb2.append(backendType);
        sb2.append(", backendFallbackChain=");
        sb2.append(list);
        sb2.append(", backendConstraint=");
        sb2.append(backendConstraint);
        sb2.append(", maxConcurrent=");
        sb2.append(i10);
        sb2.append(", dspMaxConcurrent=");
        d.s(sb2, i11, ", idleTimeoutMs=", j10);
        a0.a.s(j11, ", deferredReleaseDelayMs=", ", cacheEvictionRetainMb=", sb2);
        sb2.append(i12);
        sb2.append(", shouldEvictAllIdle=");
        sb2.append(z);
        sb2.append(", suggestCloudRouting=");
        sb2.append(z3);
        sb2.append(", cbFailureThreshold=");
        sb2.append(i13);
        sb2.append(", cbResetTimeoutMs=");
        sb2.append(j12);
        sb2.append(", thermalState=");
        sb2.append(thermalState);
        sb2.append(", batteryLevel=");
        sb2.append(i14);
        sb2.append(", isCharging=");
        sb2.append(z10);
        sb2.append(", isForeground=");
        sb2.append(z11);
        sb2.append(", backgroundDurationMs=");
        return a.m(sb2, j13, ")");
    }
}
