package com.stepos.core.performance.data;

import a0.a;
import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.d;
import h0.e;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class GlobalVerdict {
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
    private final List<VerdictReason> reasons;
    private final BackendType recommendedBackend;
    private final Set<String> sealedFields;
    private final boolean shouldEvictAllIdle;
    private final boolean suggestCloudRouting;
    private final ThermalState thermalState;
    private final long timestampMs;

    /* JADX WARN: Multi-variable type inference failed */
    public GlobalVerdict(BackendType recommendedBackend, List<? extends BackendType> backendFallbackChain, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13, List<VerdictReason> reasons, Set<String> sealedFields, long j14) {
        g.f(recommendedBackend, "recommendedBackend");
        g.f(backendFallbackChain, "backendFallbackChain");
        g.f(backendConstraint, "backendConstraint");
        g.f(thermalState, "thermalState");
        g.f(reasons, "reasons");
        g.f(sealedFields, "sealedFields");
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
        this.reasons = reasons;
        this.sealedFields = sealedFields;
        this.timestampMs = j14;
    }

    public static /* synthetic */ GlobalVerdict copy$default(GlobalVerdict globalVerdict, BackendType backendType, List list, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13, List list2, Set set, long j14, int i15, Object obj) {
        long j15;
        List list3;
        Set set2;
        BackendType backendType2 = (i15 & 1) != 0 ? globalVerdict.recommendedBackend : backendType;
        List list4 = (i15 & 2) != 0 ? globalVerdict.backendFallbackChain : list;
        BackendConstraint backendConstraint2 = (i15 & 4) != 0 ? globalVerdict.backendConstraint : backendConstraint;
        int i16 = (i15 & 8) != 0 ? globalVerdict.maxConcurrent : i10;
        int i17 = (i15 & 16) != 0 ? globalVerdict.dspMaxConcurrent : i11;
        long j16 = (i15 & 32) != 0 ? globalVerdict.idleTimeoutMs : j10;
        long j17 = (i15 & 64) != 0 ? globalVerdict.deferredReleaseDelayMs : j11;
        int i18 = (i15 & TraceIdKeys.MAX_LENGTH) != 0 ? globalVerdict.cacheEvictionRetainMb : i12;
        boolean z12 = (i15 & 256) != 0 ? globalVerdict.shouldEvictAllIdle : z;
        boolean z13 = (i15 & VadSessionManager.FRAME_BYTES) != 0 ? globalVerdict.suggestCloudRouting : z3;
        int i19 = (i15 & 1024) != 0 ? globalVerdict.cbFailureThreshold : i13;
        BackendType backendType3 = backendType2;
        List list5 = list4;
        long j18 = (i15 & 2048) != 0 ? globalVerdict.cbResetTimeoutMs : j12;
        ThermalState thermalState2 = (i15 & 4096) != 0 ? globalVerdict.thermalState : thermalState;
        long j19 = j18;
        int i20 = (i15 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? globalVerdict.batteryLevel : i14;
        boolean z14 = (i15 & 16384) != 0 ? globalVerdict.isCharging : z10;
        boolean z15 = (i15 & 32768) != 0 ? globalVerdict.isForeground : z11;
        int i21 = i20;
        long j20 = (i15 & 65536) != 0 ? globalVerdict.backgroundDurationMs : j13;
        List list6 = (i15 & 131072) != 0 ? globalVerdict.reasons : list2;
        Set set3 = (i15 & 262144) != 0 ? globalVerdict.sealedFields : set;
        if ((i15 & 524288) != 0) {
            list3 = list6;
            set2 = set3;
            j15 = globalVerdict.timestampMs;
        } else {
            j15 = j14;
            list3 = list6;
            set2 = set3;
        }
        return globalVerdict.copy(backendType3, list5, backendConstraint2, i16, i17, j16, j17, i18, z12, z13, i19, j19, thermalState2, i21, z14, z15, j20, list3, set2, j15);
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

    public final List<VerdictReason> component18() {
        return this.reasons;
    }

    public final Set<String> component19() {
        return this.sealedFields;
    }

    public final List<BackendType> component2() {
        return this.backendFallbackChain;
    }

    public final long component20() {
        return this.timestampMs;
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

    public final GlobalVerdict copy(BackendType recommendedBackend, List<? extends BackendType> backendFallbackChain, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13, List<VerdictReason> reasons, Set<String> sealedFields, long j14) {
        g.f(recommendedBackend, "recommendedBackend");
        g.f(backendFallbackChain, "backendFallbackChain");
        g.f(backendConstraint, "backendConstraint");
        g.f(thermalState, "thermalState");
        g.f(reasons, "reasons");
        g.f(sealedFields, "sealedFields");
        return new GlobalVerdict(recommendedBackend, backendFallbackChain, backendConstraint, i10, i11, j10, j11, i12, z, z3, i13, j12, thermalState, i14, z10, z11, j13, reasons, sealedFields, j14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GlobalVerdict)) {
            return false;
        }
        GlobalVerdict globalVerdict = (GlobalVerdict) obj;
        return this.recommendedBackend == globalVerdict.recommendedBackend && g.b(this.backendFallbackChain, globalVerdict.backendFallbackChain) && this.backendConstraint == globalVerdict.backendConstraint && this.maxConcurrent == globalVerdict.maxConcurrent && this.dspMaxConcurrent == globalVerdict.dspMaxConcurrent && this.idleTimeoutMs == globalVerdict.idleTimeoutMs && this.deferredReleaseDelayMs == globalVerdict.deferredReleaseDelayMs && this.cacheEvictionRetainMb == globalVerdict.cacheEvictionRetainMb && this.shouldEvictAllIdle == globalVerdict.shouldEvictAllIdle && this.suggestCloudRouting == globalVerdict.suggestCloudRouting && this.cbFailureThreshold == globalVerdict.cbFailureThreshold && this.cbResetTimeoutMs == globalVerdict.cbResetTimeoutMs && this.thermalState == globalVerdict.thermalState && this.batteryLevel == globalVerdict.batteryLevel && this.isCharging == globalVerdict.isCharging && this.isForeground == globalVerdict.isForeground && this.backgroundDurationMs == globalVerdict.backgroundDurationMs && g.b(this.reasons, globalVerdict.reasons) && g.b(this.sealedFields, globalVerdict.sealedFields) && this.timestampMs == globalVerdict.timestampMs;
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

    public final List<VerdictReason> getReasons() {
        return this.reasons;
    }

    public final BackendType getRecommendedBackend() {
        return this.recommendedBackend;
    }

    public final Set<String> getSealedFields() {
        return this.sealedFields;
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

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public int hashCode() {
        return Long.hashCode(this.timestampMs) + ((this.sealedFields.hashCode() + e.b(this.reasons, a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.batteryLevel, (this.thermalState.hashCode() + a.c(ai.onnxruntime.a.d(this.cbFailureThreshold, ai.onnxruntime.a.f(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.cacheEvictionRetainMb, a.c(a.c(ai.onnxruntime.a.d(this.dspMaxConcurrent, ai.onnxruntime.a.d(this.maxConcurrent, (this.backendConstraint.hashCode() + e.b(this.backendFallbackChain, this.recommendedBackend.hashCode() * 31, 31)) * 31, 31), 31), this.idleTimeoutMs, 31), this.deferredReleaseDelayMs, 31), 31), 31, this.shouldEvictAllIdle), 31, this.suggestCloudRouting), 31), this.cbResetTimeoutMs, 31)) * 31, 31), 31, this.isCharging), 31, this.isForeground), this.backgroundDurationMs, 31), 31)) * 31);
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
        List<VerdictReason> list2 = this.reasons;
        Set<String> set = this.sealedFields;
        long j14 = this.timestampMs;
        StringBuilder sb2 = new StringBuilder("GlobalVerdict(recommendedBackend=");
        sb2.append(backendType);
        sb2.append(", backendFallbackChain=");
        sb2.append(list);
        sb2.append(", backendConstraint=");
        sb2.append(backendConstraint);
        sb2.append(", maxConcurrent=");
        sb2.append(i10);
        sb2.append(", dspMaxConcurrent=");
        d.s(sb2, i11, ", idleTimeoutMs=", j10);
        a.s(j11, ", deferredReleaseDelayMs=", ", cacheEvictionRetainMb=", sb2);
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
        sb2.append(j13);
        sb2.append(", reasons=");
        sb2.append(list2);
        sb2.append(", sealedFields=");
        sb2.append(set);
        sb2.append(", timestampMs=");
        return ai.onnxruntime.a.m(sb2, j14, ")");
    }

    public /* synthetic */ GlobalVerdict(BackendType backendType, List list, BackendConstraint backendConstraint, int i10, int i11, long j10, long j11, int i12, boolean z, boolean z3, int i13, long j12, ThermalState thermalState, int i14, boolean z10, boolean z11, long j13, List list2, Set set, long j14, int i15, kotlin.jvm.internal.e eVar) {
        this(backendType, list, backendConstraint, i10, i11, j10, j11, i12, z, z3, i13, j12, thermalState, i14, z10, z11, j13, list2, set, (i15 & 524288) != 0 ? System.currentTimeMillis() : j14);
    }
}
