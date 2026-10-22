package com.stepos.aicgroup.memory;

import ai.onnxruntime.a;
import kotlin.jvm.internal.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MemorySnapshot {
    public static final Companion Companion = new Companion(null);
    private static final MemorySnapshot EMPTY = new MemorySnapshot(0, 0, 0, false, 0, 0, 0, 64, null);
    private final int availableKb;
    private final boolean isLowMemory;
    private final int memoryUsageRate;
    private final int swapFreeKb;
    private final int swapTotalKb;
    private final long timestampMs;
    private final int totalKb;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final MemorySnapshot getEMPTY() {
            return MemorySnapshot.EMPTY;
        }

        private Companion() {
        }
    }

    public MemorySnapshot(int i10, int i11, int i12, boolean z, int i13, int i14, long j10) {
        this.memoryUsageRate = i10;
        this.availableKb = i11;
        this.totalKb = i12;
        this.isLowMemory = z;
        this.swapTotalKb = i13;
        this.swapFreeKb = i14;
        this.timestampMs = j10;
    }

    public static /* synthetic */ MemorySnapshot copy$default(MemorySnapshot memorySnapshot, int i10, int i11, int i12, boolean z, int i13, int i14, long j10, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i10 = memorySnapshot.memoryUsageRate;
        }
        if ((i15 & 2) != 0) {
            i11 = memorySnapshot.availableKb;
        }
        if ((i15 & 4) != 0) {
            i12 = memorySnapshot.totalKb;
        }
        if ((i15 & 8) != 0) {
            z = memorySnapshot.isLowMemory;
        }
        if ((i15 & 16) != 0) {
            i13 = memorySnapshot.swapTotalKb;
        }
        if ((i15 & 32) != 0) {
            i14 = memorySnapshot.swapFreeKb;
        }
        if ((i15 & 64) != 0) {
            j10 = memorySnapshot.timestampMs;
        }
        long j11 = j10;
        int i16 = i13;
        int i17 = i14;
        return memorySnapshot.copy(i10, i11, i12, z, i16, i17, j11);
    }

    public final int component1() {
        return this.memoryUsageRate;
    }

    public final int component2() {
        return this.availableKb;
    }

    public final int component3() {
        return this.totalKb;
    }

    public final boolean component4() {
        return this.isLowMemory;
    }

    public final int component5() {
        return this.swapTotalKb;
    }

    public final int component6() {
        return this.swapFreeKb;
    }

    public final long component7() {
        return this.timestampMs;
    }

    public final MemorySnapshot copy(int i10, int i11, int i12, boolean z, int i13, int i14, long j10) {
        return new MemorySnapshot(i10, i11, i12, z, i13, i14, j10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MemorySnapshot)) {
            return false;
        }
        MemorySnapshot memorySnapshot = (MemorySnapshot) obj;
        return this.memoryUsageRate == memorySnapshot.memoryUsageRate && this.availableKb == memorySnapshot.availableKb && this.totalKb == memorySnapshot.totalKb && this.isLowMemory == memorySnapshot.isLowMemory && this.swapTotalKb == memorySnapshot.swapTotalKb && this.swapFreeKb == memorySnapshot.swapFreeKb && this.timestampMs == memorySnapshot.timestampMs;
    }

    public final int getAvailableKb() {
        return this.availableKb;
    }

    public final int getMemoryUsageRate() {
        return this.memoryUsageRate;
    }

    public final int getSwapFreeKb() {
        return this.swapFreeKb;
    }

    public final int getSwapTotalKb() {
        return this.swapTotalKb;
    }

    public final int getSwapUsageRate() {
        int i10 = this.swapTotalKb;
        if (i10 > 0) {
            return (int) (((i10 - this.swapFreeKb) * 100) / i10);
        }
        return 0;
    }

    public final long getTimestampMs() {
        return this.timestampMs;
    }

    public final int getTotalKb() {
        return this.totalKb;
    }

    public int hashCode() {
        return Long.hashCode(this.timestampMs) + a.d(this.swapFreeKb, a.d(this.swapTotalKb, a.f(a.d(this.totalKb, a.d(this.availableKb, Integer.hashCode(this.memoryUsageRate) * 31, 31), 31), 31, this.isLowMemory), 31), 31);
    }

    public final boolean isLowMemory() {
        return this.isLowMemory;
    }

    public String toString() {
        int i10 = this.memoryUsageRate;
        int i11 = this.availableKb;
        int i12 = this.totalKb;
        boolean z = this.isLowMemory;
        int i13 = this.swapTotalKb;
        int i14 = this.swapFreeKb;
        long j10 = this.timestampMs;
        StringBuilder sbD = h0.e.d(i10, "MemorySnapshot(memoryUsageRate=", i11, ", availableKb=", ", totalKb=");
        sbD.append(i12);
        sbD.append(", isLowMemory=");
        sbD.append(z);
        sbD.append(", swapTotalKb=");
        h0.e.l(sbD, i13, ", swapFreeKb=", i14, ", timestampMs=");
        return a.m(sbD, j10, ")");
    }

    public /* synthetic */ MemorySnapshot(int i10, int i11, int i12, boolean z, int i13, int i14, long j10, int i15, e eVar) {
        this(i10, i11, i12, z, i13, i14, (i15 & 64) != 0 ? System.currentTimeMillis() : j10);
    }
}
