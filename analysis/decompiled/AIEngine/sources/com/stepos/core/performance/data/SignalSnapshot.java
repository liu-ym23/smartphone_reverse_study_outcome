package com.stepos.core.performance.data;

import com.stepos.base.awareness.data.ThermalState;
import com.stepos.base.inference.data.BackendType;
import com.stepos.core.ability.speech.PcmDumpBudget;
import com.stepos.core.ability.speech.VadSessionManager;
import com.stepos.core.common.util.TraceIdKeys;
import com.stepos.core.ota.crypto.CryptoHeaderParser;
import h0.e;
import java.util.Map;
import kotlin.jvm.internal.g;
import v1.d;
import x6.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SignalSnapshot {
    private final int activeInferCount;
    private final int aicgroupAvailKb;
    private final boolean aicgroupAvailable;
    private final AicGroupPressureLevel aicgroupPressureLevel;
    private final long aicgroupSnapshotMonoNs;
    private final long availRamMb;
    private final long avgInitMemoryMb;
    private final long avgInitTimeMs;
    private final long avgInvokeTimeMs;
    private final long avgTtftMs;
    private final Map<BackendType, a> backendPerf;
    private final long backgroundDurationMs;
    private final int batteryLevel;
    private final float cpuTemperatureCelsius;
    private final CpuTopology cpuTopology;
    private final String currentModelId;
    private final long failedInferCount;
    private final boolean hasGpuCompute;
    private final boolean hasNpu;
    private final int healthScore;
    private final boolean isCharging;
    private final boolean isForeground;
    private final boolean isLowMemory;
    private final long selfProcessMemMb;
    private final String socModel;
    private final float thermalHeadroom;
    private final ThermalState thermalState;
    private final long timestampMs;
    private final long totalInferCount;
    private final long totalRamMb;
    private final Integer trimMemoryLevel;

    public SignalSnapshot(float f8, float f9, ThermalState thermalState, int i10, boolean z, long j10, long j11, long j12, boolean z3, boolean z10, long j13, Integer num, String socModel, boolean z11, boolean z12, CpuTopology cpuTopology, int i11, long j14, long j15, int i12, String str, long j16, long j17, long j18, long j19, Map<BackendType, a> backendPerf, AicGroupPressureLevel aicgroupPressureLevel, int i13, long j20, boolean z13, long j21) {
        g.f(thermalState, "thermalState");
        g.f(socModel, "socModel");
        g.f(cpuTopology, "cpuTopology");
        g.f(backendPerf, "backendPerf");
        g.f(aicgroupPressureLevel, "aicgroupPressureLevel");
        this.cpuTemperatureCelsius = f8;
        this.thermalHeadroom = f9;
        this.thermalState = thermalState;
        this.batteryLevel = i10;
        this.isCharging = z;
        this.availRamMb = j10;
        this.totalRamMb = j11;
        this.selfProcessMemMb = j12;
        this.isLowMemory = z3;
        this.isForeground = z10;
        this.backgroundDurationMs = j13;
        this.trimMemoryLevel = num;
        this.socModel = socModel;
        this.hasNpu = z11;
        this.hasGpuCompute = z12;
        this.cpuTopology = cpuTopology;
        this.activeInferCount = i11;
        this.totalInferCount = j14;
        this.failedInferCount = j15;
        this.healthScore = i12;
        this.currentModelId = str;
        this.avgInitTimeMs = j16;
        this.avgInitMemoryMb = j17;
        this.avgInvokeTimeMs = j18;
        this.avgTtftMs = j19;
        this.backendPerf = backendPerf;
        this.aicgroupPressureLevel = aicgroupPressureLevel;
        this.aicgroupAvailKb = i13;
        this.aicgroupSnapshotMonoNs = j20;
        this.aicgroupAvailable = z13;
        this.timestampMs = j21;
    }

    public static /* synthetic */ SignalSnapshot copy$default(SignalSnapshot signalSnapshot, float f8, float f9, ThermalState thermalState, int i10, boolean z, long j10, long j11, long j12, boolean z3, boolean z10, long j13, Integer num, String str, boolean z11, boolean z12, CpuTopology cpuTopology, int i11, long j14, long j15, int i12, String str2, long j16, long j17, long j18, long j19, Map map, AicGroupPressureLevel aicGroupPressureLevel, int i13, long j20, boolean z13, long j21, int i14, Object obj) {
        long j22;
        boolean z14;
        String str3;
        long j23;
        long j24;
        long j25;
        long j26;
        Map map2;
        AicGroupPressureLevel aicGroupPressureLevel2;
        int i15;
        long j27;
        boolean z15;
        boolean z16;
        Integer num2;
        long j28;
        String str4;
        CpuTopology cpuTopology2;
        boolean z17;
        int i16;
        long j29;
        long j30;
        int i17;
        ThermalState thermalState2;
        int i18;
        boolean z18;
        long j31;
        long j32;
        long j33;
        boolean z19;
        float f10 = (i14 & 1) != 0 ? signalSnapshot.cpuTemperatureCelsius : f8;
        float f11 = (i14 & 2) != 0 ? signalSnapshot.thermalHeadroom : f9;
        ThermalState thermalState3 = (i14 & 4) != 0 ? signalSnapshot.thermalState : thermalState;
        int i19 = (i14 & 8) != 0 ? signalSnapshot.batteryLevel : i10;
        boolean z20 = (i14 & 16) != 0 ? signalSnapshot.isCharging : z;
        long j34 = (i14 & 32) != 0 ? signalSnapshot.availRamMb : j10;
        long j35 = (i14 & 64) != 0 ? signalSnapshot.totalRamMb : j11;
        long j36 = (i14 & TraceIdKeys.MAX_LENGTH) != 0 ? signalSnapshot.selfProcessMemMb : j12;
        boolean z21 = (i14 & 256) != 0 ? signalSnapshot.isLowMemory : z3;
        boolean z22 = (i14 & VadSessionManager.FRAME_BYTES) != 0 ? signalSnapshot.isForeground : z10;
        float f12 = f10;
        float f13 = f11;
        long j37 = (i14 & 1024) != 0 ? signalSnapshot.backgroundDurationMs : j13;
        Integer num3 = (i14 & 2048) != 0 ? signalSnapshot.trimMemoryLevel : num;
        long j38 = j37;
        String str5 = (i14 & 4096) != 0 ? signalSnapshot.socModel : str;
        boolean z23 = (i14 & PcmDumpBudget.HARD_MAX_DIR_MB) != 0 ? signalSnapshot.hasNpu : z11;
        String str6 = str5;
        boolean z24 = (i14 & 16384) != 0 ? signalSnapshot.hasGpuCompute : z12;
        CpuTopology cpuTopology3 = (i14 & 32768) != 0 ? signalSnapshot.cpuTopology : cpuTopology;
        int i20 = (i14 & 65536) != 0 ? signalSnapshot.activeInferCount : i11;
        boolean z25 = z24;
        long j39 = (i14 & 131072) != 0 ? signalSnapshot.totalInferCount : j14;
        long j40 = (i14 & 262144) != 0 ? signalSnapshot.failedInferCount : j15;
        int i21 = (i14 & 524288) != 0 ? signalSnapshot.healthScore : i12;
        String str7 = (i14 & CryptoHeaderParser.MAX_BLOCK_SIZE) != 0 ? signalSnapshot.currentModelId : str2;
        long j41 = (i14 & 2097152) != 0 ? signalSnapshot.avgInitTimeMs : j16;
        long j42 = (i14 & 4194304) != 0 ? signalSnapshot.avgInitMemoryMb : j17;
        long j43 = (i14 & 8388608) != 0 ? signalSnapshot.avgInvokeTimeMs : j18;
        long j44 = (i14 & 16777216) != 0 ? signalSnapshot.avgTtftMs : j19;
        Map map3 = (i14 & 33554432) != 0 ? signalSnapshot.backendPerf : map;
        AicGroupPressureLevel aicGroupPressureLevel3 = (i14 & 67108864) != 0 ? signalSnapshot.aicgroupPressureLevel : aicGroupPressureLevel;
        Map map4 = map3;
        int i22 = (i14 & 134217728) != 0 ? signalSnapshot.aicgroupAvailKb : i13;
        AicGroupPressureLevel aicGroupPressureLevel4 = aicGroupPressureLevel3;
        long j45 = (i14 & 268435456) != 0 ? signalSnapshot.aicgroupSnapshotMonoNs : j20;
        boolean z26 = (i14 & 536870912) != 0 ? signalSnapshot.aicgroupAvailable : z13;
        if ((i14 & 1073741824) != 0) {
            z14 = z26;
            j22 = signalSnapshot.timestampMs;
            j23 = j41;
            j24 = j42;
            j25 = j43;
            j26 = j44;
            map2 = map4;
            aicGroupPressureLevel2 = aicGroupPressureLevel4;
            i15 = i22;
            j27 = j45;
            z15 = z23;
            num2 = num3;
            j28 = j38;
            str4 = str6;
            cpuTopology2 = cpuTopology3;
            z17 = z25;
            i16 = i20;
            j29 = j39;
            j30 = j40;
            i17 = i21;
            str3 = str7;
            thermalState2 = thermalState3;
            i18 = i19;
            z18 = z20;
            j31 = j34;
            j32 = j35;
            j33 = j36;
            z19 = z21;
            z16 = z22;
        } else {
            j22 = j21;
            z14 = z26;
            str3 = str7;
            j23 = j41;
            j24 = j42;
            j25 = j43;
            j26 = j44;
            map2 = map4;
            aicGroupPressureLevel2 = aicGroupPressureLevel4;
            i15 = i22;
            j27 = j45;
            z15 = z23;
            z16 = z22;
            num2 = num3;
            j28 = j38;
            str4 = str6;
            cpuTopology2 = cpuTopology3;
            z17 = z25;
            i16 = i20;
            j29 = j39;
            j30 = j40;
            i17 = i21;
            thermalState2 = thermalState3;
            i18 = i19;
            z18 = z20;
            j31 = j34;
            j32 = j35;
            j33 = j36;
            z19 = z21;
        }
        return signalSnapshot.copy(f12, f13, thermalState2, i18, z18, j31, j32, j33, z19, z16, j28, num2, str4, z15, z17, cpuTopology2, i16, j29, j30, i17, str3, j23, j24, j25, j26, map2, aicGroupPressureLevel2, i15, j27, z14, j22);
    }

    public final float component1() {
        return this.cpuTemperatureCelsius;
    }

    public final boolean component10() {
        return this.isForeground;
    }

    public final long component11() {
        return this.backgroundDurationMs;
    }

    public final Integer component12() {
        return this.trimMemoryLevel;
    }

    public final String component13() {
        return this.socModel;
    }

    public final boolean component14() {
        return this.hasNpu;
    }

    public final boolean component15() {
        return this.hasGpuCompute;
    }

    public final CpuTopology component16() {
        return this.cpuTopology;
    }

    public final int component17() {
        return this.activeInferCount;
    }

    public final long component18() {
        return this.totalInferCount;
    }

    public final long component19() {
        return this.failedInferCount;
    }

    public final float component2() {
        return this.thermalHeadroom;
    }

    public final int component20() {
        return this.healthScore;
    }

    public final String component21() {
        return this.currentModelId;
    }

    public final long component22() {
        return this.avgInitTimeMs;
    }

    public final long component23() {
        return this.avgInitMemoryMb;
    }

    public final long component24() {
        return this.avgInvokeTimeMs;
    }

    public final long component25() {
        return this.avgTtftMs;
    }

    public final Map<BackendType, a> component26() {
        return this.backendPerf;
    }

    public final AicGroupPressureLevel component27() {
        return this.aicgroupPressureLevel;
    }

    public final int component28() {
        return this.aicgroupAvailKb;
    }

    public final long component29() {
        return this.aicgroupSnapshotMonoNs;
    }

    public final ThermalState component3() {
        return this.thermalState;
    }

    public final boolean component30() {
        return this.aicgroupAvailable;
    }

    public final long component31() {
        return this.timestampMs;
    }

    public final int component4() {
        return this.batteryLevel;
    }

    public final boolean component5() {
        return this.isCharging;
    }

    public final long component6() {
        return this.availRamMb;
    }

    public final long component7() {
        return this.totalRamMb;
    }

    public final long component8() {
        return this.selfProcessMemMb;
    }

    public final boolean component9() {
        return this.isLowMemory;
    }

    public final SignalSnapshot copy(float f8, float f9, ThermalState thermalState, int i10, boolean z, long j10, long j11, long j12, boolean z3, boolean z10, long j13, Integer num, String socModel, boolean z11, boolean z12, CpuTopology cpuTopology, int i11, long j14, long j15, int i12, String str, long j16, long j17, long j18, long j19, Map<BackendType, a> backendPerf, AicGroupPressureLevel aicgroupPressureLevel, int i13, long j20, boolean z13, long j21) {
        g.f(thermalState, "thermalState");
        g.f(socModel, "socModel");
        g.f(cpuTopology, "cpuTopology");
        g.f(backendPerf, "backendPerf");
        g.f(aicgroupPressureLevel, "aicgroupPressureLevel");
        return new SignalSnapshot(f8, f9, thermalState, i10, z, j10, j11, j12, z3, z10, j13, num, socModel, z11, z12, cpuTopology, i11, j14, j15, i12, str, j16, j17, j18, j19, backendPerf, aicgroupPressureLevel, i13, j20, z13, j21);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SignalSnapshot)) {
            return false;
        }
        SignalSnapshot signalSnapshot = (SignalSnapshot) obj;
        return Float.compare(this.cpuTemperatureCelsius, signalSnapshot.cpuTemperatureCelsius) == 0 && Float.compare(this.thermalHeadroom, signalSnapshot.thermalHeadroom) == 0 && this.thermalState == signalSnapshot.thermalState && this.batteryLevel == signalSnapshot.batteryLevel && this.isCharging == signalSnapshot.isCharging && this.availRamMb == signalSnapshot.availRamMb && this.totalRamMb == signalSnapshot.totalRamMb && this.selfProcessMemMb == signalSnapshot.selfProcessMemMb && this.isLowMemory == signalSnapshot.isLowMemory && this.isForeground == signalSnapshot.isForeground && this.backgroundDurationMs == signalSnapshot.backgroundDurationMs && g.b(this.trimMemoryLevel, signalSnapshot.trimMemoryLevel) && g.b(this.socModel, signalSnapshot.socModel) && this.hasNpu == signalSnapshot.hasNpu && this.hasGpuCompute == signalSnapshot.hasGpuCompute && g.b(this.cpuTopology, signalSnapshot.cpuTopology) && this.activeInferCount == signalSnapshot.activeInferCount && this.totalInferCount == signalSnapshot.totalInferCount && this.failedInferCount == signalSnapshot.failedInferCount && this.healthScore == signalSnapshot.healthScore && g.b(this.currentModelId, signalSnapshot.currentModelId) && this.avgInitTimeMs == signalSnapshot.avgInitTimeMs && this.avgInitMemoryMb == signalSnapshot.avgInitMemoryMb && this.avgInvokeTimeMs == signalSnapshot.avgInvokeTimeMs && this.avgTtftMs == signalSnapshot.avgTtftMs && g.b(this.backendPerf, signalSnapshot.backendPerf) && this.aicgroupPressureLevel == signalSnapshot.aicgroupPressureLevel && this.aicgroupAvailKb == signalSnapshot.aicgroupAvailKb && this.aicgroupSnapshotMonoNs == signalSnapshot.aicgroupSnapshotMonoNs && this.aicgroupAvailable == signalSnapshot.aicgroupAvailable && this.timestampMs == signalSnapshot.timestampMs;
    }

    public final int getActiveInferCount() {
        return this.activeInferCount;
    }

    public final int getAicgroupAvailKb() {
        return this.aicgroupAvailKb;
    }

    public final boolean getAicgroupAvailable() {
        return this.aicgroupAvailable;
    }

    public final AicGroupPressureLevel getAicgroupPressureLevel() {
        return this.aicgroupPressureLevel;
    }

    public final long getAicgroupSnapshotMonoNs() {
        return this.aicgroupSnapshotMonoNs;
    }

    public final long getAvailRamMb() {
        return this.availRamMb;
    }

    public final long getAvgInitMemoryMb() {
        return this.avgInitMemoryMb;
    }

    public final long getAvgInitTimeMs() {
        return this.avgInitTimeMs;
    }

    public final long getAvgInvokeTimeMs() {
        return this.avgInvokeTimeMs;
    }

    public final long getAvgTtftMs() {
        return this.avgTtftMs;
    }

    public final Map<BackendType, a> getBackendPerf() {
        return this.backendPerf;
    }

    public final long getBackgroundDurationMs() {
        return this.backgroundDurationMs;
    }

    public final int getBatteryLevel() {
        return this.batteryLevel;
    }

    public final float getCpuTemperatureCelsius() {
        return this.cpuTemperatureCelsius;
    }

    public final CpuTopology getCpuTopology() {
        return this.cpuTopology;
    }

    public final String getCurrentModelId() {
        return this.currentModelId;
    }

    public final long getFailedInferCount() {
        return this.failedInferCount;
    }

    public final boolean getHasGpuCompute() {
        return this.hasGpuCompute;
    }

    public final boolean getHasNpu() {
        return this.hasNpu;
    }

    public final int getHealthScore() {
        return this.healthScore;
    }

    public final long getSelfProcessMemMb() {
        return this.selfProcessMemMb;
    }

    public final String getSocModel() {
        return this.socModel;
    }

    public final float getThermalHeadroom() {
        return this.thermalHeadroom;
    }

    public final ThermalState getThermalState() {
        return this.thermalState;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final long getTotalInferCount() {
        return this.totalInferCount;
    }

    public final long getTotalRamMb() {
        return this.totalRamMb;
    }

    public final Integer getTrimMemoryLevel() {
        return this.trimMemoryLevel;
    }

    public int hashCode() {
        int iC = a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.f(a0.a.c(a0.a.c(a0.a.c(ai.onnxruntime.a.f(ai.onnxruntime.a.d(this.batteryLevel, (this.thermalState.hashCode() + a0.a.a(this.thermalHeadroom, Float.hashCode(this.cpuTemperatureCelsius) * 31, 31)) * 31, 31), 31, this.isCharging), this.availRamMb, 31), this.totalRamMb, 31), this.selfProcessMemMb, 31), 31, this.isLowMemory), 31, this.isForeground), this.backgroundDurationMs, 31);
        Integer num = this.trimMemoryLevel;
        int iD = ai.onnxruntime.a.d(this.healthScore, a0.a.c(a0.a.c(ai.onnxruntime.a.d(this.activeInferCount, (this.cpuTopology.hashCode() + ai.onnxruntime.a.f(ai.onnxruntime.a.f(d.a((iC + (num == null ? 0 : num.hashCode())) * 31, 31, this.socModel), 31, this.hasNpu), 31, this.hasGpuCompute)) * 31, 31), this.totalInferCount, 31), this.failedInferCount, 31), 31);
        String str = this.currentModelId;
        return Long.hashCode(this.timestampMs) + ai.onnxruntime.a.f(a0.a.c(ai.onnxruntime.a.d(this.aicgroupAvailKb, (this.aicgroupPressureLevel.hashCode() + ((this.backendPerf.hashCode() + a0.a.c(a0.a.c(a0.a.c(a0.a.c((iD + (str != null ? str.hashCode() : 0)) * 31, this.avgInitTimeMs, 31), this.avgInitMemoryMb, 31), this.avgInvokeTimeMs, 31), this.avgTtftMs, 31)) * 31)) * 31, 31), this.aicgroupSnapshotMonoNs, 31), 31, this.aicgroupAvailable);
    }

    public final boolean isCharging() {
        return this.isCharging;
    }

    public final boolean isForeground() {
        return this.isForeground;
    }

    public final boolean isLowMemory() {
        return this.isLowMemory;
    }

    public String toString() {
        float f8 = this.cpuTemperatureCelsius;
        float f9 = this.thermalHeadroom;
        ThermalState thermalState = this.thermalState;
        int i10 = this.batteryLevel;
        boolean z = this.isCharging;
        long j10 = this.availRamMb;
        long j11 = this.totalRamMb;
        long j12 = this.selfProcessMemMb;
        boolean z3 = this.isLowMemory;
        boolean z10 = this.isForeground;
        long j13 = this.backgroundDurationMs;
        Integer num = this.trimMemoryLevel;
        String str = this.socModel;
        boolean z11 = this.hasNpu;
        boolean z12 = this.hasGpuCompute;
        CpuTopology cpuTopology = this.cpuTopology;
        int i11 = this.activeInferCount;
        long j14 = this.totalInferCount;
        long j15 = this.failedInferCount;
        int i12 = this.healthScore;
        String str2 = this.currentModelId;
        long j16 = this.avgInitTimeMs;
        long j17 = this.avgInitMemoryMb;
        long j18 = this.avgInvokeTimeMs;
        long j19 = this.avgTtftMs;
        Map<BackendType, a> map = this.backendPerf;
        AicGroupPressureLevel aicGroupPressureLevel = this.aicgroupPressureLevel;
        int i13 = this.aicgroupAvailKb;
        long j20 = this.aicgroupSnapshotMonoNs;
        boolean z13 = this.aicgroupAvailable;
        long j21 = this.timestampMs;
        StringBuilder sb2 = new StringBuilder("SignalSnapshot(cpuTemperatureCelsius=");
        sb2.append(f8);
        sb2.append(", thermalHeadroom=");
        sb2.append(f9);
        sb2.append(", thermalState=");
        sb2.append(thermalState);
        sb2.append(", batteryLevel=");
        sb2.append(i10);
        sb2.append(", isCharging=");
        sb2.append(z);
        sb2.append(", availRamMb=");
        sb2.append(j10);
        a0.a.s(j11, ", totalRamMb=", ", selfProcessMemMb=", sb2);
        sb2.append(j12);
        sb2.append(", isLowMemory=");
        sb2.append(z3);
        sb2.append(", isForeground=");
        sb2.append(z10);
        sb2.append(", backgroundDurationMs=");
        sb2.append(j13);
        sb2.append(", trimMemoryLevel=");
        sb2.append(num);
        sb2.append(", socModel=");
        sb2.append(str);
        sb2.append(", hasNpu=");
        sb2.append(z11);
        sb2.append(", hasGpuCompute=");
        sb2.append(z12);
        sb2.append(", cpuTopology=");
        sb2.append(cpuTopology);
        sb2.append(", activeInferCount=");
        sb2.append(i11);
        sb2.append(", totalInferCount=");
        sb2.append(j14);
        a0.a.s(j15, ", failedInferCount=", ", healthScore=", sb2);
        e.h(i12, ", currentModelId=", str2, ", avgInitTimeMs=", sb2);
        sb2.append(j16);
        a0.a.s(j17, ", avgInitMemoryMb=", ", avgInvokeTimeMs=", sb2);
        sb2.append(j18);
        a0.a.s(j19, ", avgTtftMs=", ", backendPerf=", sb2);
        sb2.append(map);
        sb2.append(", aicgroupPressureLevel=");
        sb2.append(aicGroupPressureLevel);
        sb2.append(", aicgroupAvailKb=");
        com.stepos.core.ota.d.s(sb2, i13, ", aicgroupSnapshotMonoNs=", j20);
        sb2.append(", aicgroupAvailable=");
        sb2.append(z13);
        sb2.append(", timestampMs=");
        return ai.onnxruntime.a.m(sb2, j21, ")");
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getPhiList()" because "resultVar" is null
        	at jadx.core.dex.visitors.InitCodeVariables.collectConnectedVars(InitCodeVariables.java:119)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:82)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:74)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:48)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:29)
        */
    public /* synthetic */ SignalSnapshot(float r46, float r47, com.stepos.base.awareness.data.ThermalState r48, int r49, boolean r50, long r51, long r53, long r55, boolean r57, boolean r58, long r59, java.lang.Integer r61, java.lang.String r62, boolean r63, boolean r64, com.stepos.core.performance.data.CpuTopology r65, int r66, long r67, long r69, int r71, java.lang.String r72, long r73, long r75, long r77, long r79, java.util.Map r81, com.stepos.core.performance.data.AicGroupPressureLevel r82, int r83, long r84, boolean r86, long r87, int r89, kotlin.jvm.internal.e r90) {
        /*
            r45 = this;
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r0 = r89 & r0
            if (r0 == 0) goto Lb
            com.stepos.core.performance.data.AicGroupPressureLevel r0 = com.stepos.core.performance.data.AicGroupPressureLevel.NORMAL
            r38 = r0
            goto Ld
        Lb:
            r38 = r82
        Ld:
            r0 = 134217728(0x8000000, float:3.85186E-34)
            r0 = r89 & r0
            r1 = 0
            if (r0 == 0) goto L17
            r39 = r1
            goto L19
        L17:
            r39 = r83
        L19:
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r0 = r89 & r0
            if (r0 == 0) goto L24
            r2 = 0
            r40 = r2
            goto L26
        L24:
            r40 = r84
        L26:
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r89 & r0
            if (r0 == 0) goto L2f
            r42 = r1
            goto L31
        L2f:
            r42 = r86
        L31:
            r0 = 1073741824(0x40000000, float:2.0)
            r0 = r89 & r0
            if (r0 == 0) goto L74
            long r0 = java.lang.System.currentTimeMillis()
            r43 = r0
            r2 = r46
            r3 = r47
            r4 = r48
            r5 = r49
            r6 = r50
            r7 = r51
            r9 = r53
            r11 = r55
            r13 = r57
            r14 = r58
            r15 = r59
            r17 = r61
            r18 = r62
            r19 = r63
            r20 = r64
            r21 = r65
            r22 = r66
            r23 = r67
            r25 = r69
            r27 = r71
            r28 = r72
            r29 = r73
            r31 = r75
            r33 = r77
            r35 = r79
            r37 = r81
            r1 = r45
            goto Lac
        L74:
            r43 = r87
            r1 = r45
            r2 = r46
            r3 = r47
            r4 = r48
            r5 = r49
            r6 = r50
            r7 = r51
            r9 = r53
            r11 = r55
            r13 = r57
            r14 = r58
            r15 = r59
            r17 = r61
            r18 = r62
            r19 = r63
            r20 = r64
            r21 = r65
            r22 = r66
            r23 = r67
            r25 = r69
            r27 = r71
            r28 = r72
            r29 = r73
            r31 = r75
            r33 = r77
            r35 = r79
            r37 = r81
        Lac:
            r1.<init>(r2, r3, r4, r5, r6, r7, r9, r11, r13, r14, r15, r17, r18, r19, r20, r21, r22, r23, r25, r27, r28, r29, r31, r33, r35, r37, r38, r39, r40, r42, r43)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.core.performance.data.SignalSnapshot.<init>(float, float, com.stepos.base.awareness.data.ThermalState, int, boolean, long, long, long, boolean, boolean, long, java.lang.Integer, java.lang.String, boolean, boolean, com.stepos.core.performance.data.CpuTopology, int, long, long, int, java.lang.String, long, long, long, long, java.util.Map, com.stepos.core.performance.data.AicGroupPressureLevel, int, long, boolean, long, int, kotlin.jvm.internal.e):void");
    }
}
