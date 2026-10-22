package com.stepos.cpuset;

import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuCore {
    private final int coreId;
    private final long maxFrequency;
    private final long minFrequency;
    private final CoreTier tier;

    public CpuCore(int i10, long j10, long j11, CoreTier tier) {
        g.f(tier, "tier");
        this.coreId = i10;
        this.maxFrequency = j10;
        this.minFrequency = j11;
        this.tier = tier;
    }

    public static /* synthetic */ CpuCore copy$default(CpuCore cpuCore, int i10, long j10, long j11, CoreTier coreTier, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = cpuCore.coreId;
        }
        if ((i11 & 2) != 0) {
            j10 = cpuCore.maxFrequency;
        }
        if ((i11 & 4) != 0) {
            j11 = cpuCore.minFrequency;
        }
        if ((i11 & 8) != 0) {
            coreTier = cpuCore.tier;
        }
        CoreTier coreTier2 = coreTier;
        return cpuCore.copy(i10, j10, j11, coreTier2);
    }

    public final int component1() {
        return this.coreId;
    }

    public final long component2() {
        return this.maxFrequency;
    }

    public final long component3() {
        return this.minFrequency;
    }

    public final CoreTier component4() {
        return this.tier;
    }

    public final CpuCore copy(int i10, long j10, long j11, CoreTier tier) {
        g.f(tier, "tier");
        return new CpuCore(i10, j10, j11, tier);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpuCore)) {
            return false;
        }
        CpuCore cpuCore = (CpuCore) obj;
        return this.coreId == cpuCore.coreId && this.maxFrequency == cpuCore.maxFrequency && this.minFrequency == cpuCore.minFrequency && this.tier == cpuCore.tier;
    }

    public final int getCoreId() {
        return this.coreId;
    }

    public final long getMaxFrequency() {
        return this.maxFrequency;
    }

    public final long getMinFrequency() {
        return this.minFrequency;
    }

    public final CoreTier getTier() {
        return this.tier;
    }

    public int hashCode() {
        return this.tier.hashCode() + a0.a.c(a0.a.c(Integer.hashCode(this.coreId) * 31, this.maxFrequency, 31), this.minFrequency, 31);
    }

    public String toString() {
        int i10 = this.coreId;
        long j10 = this.maxFrequency;
        long j11 = this.minFrequency;
        CoreTier coreTier = this.tier;
        StringBuilder sb2 = new StringBuilder("CpuCore(coreId=");
        sb2.append(i10);
        sb2.append(", maxFrequency=");
        sb2.append(j10);
        a0.a.s(j11, ", minFrequency=", ", tier=", sb2);
        sb2.append(coreTier);
        sb2.append(")");
        return sb2.toString();
    }
}
