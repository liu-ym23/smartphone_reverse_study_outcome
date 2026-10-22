package com.stepos.core.performance.data;

import ai.onnxruntime.a;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.List;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import mb.m;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CpuTopology {
    public static final Companion Companion = new Companion(null);
    private final List<Integer> bigCoreIds;
    private final int bigCount;
    private final List<Integer> mediumCoreIds;
    private final int mediumCount;
    private final List<Integer> smallCoreIds;
    private final int smallCount;
    private final List<Integer> ultraBigCoreIds;
    private final int ultraBigCount;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final CpuTopology fallback() {
            return new CpuTopology(1, 3, 2, 2, b1.P(7), m.b0(4, 5, 6), m.b0(2, 3), m.b0(0, 1));
        }

        private Companion() {
        }
    }

    public CpuTopology(int i10, int i11, int i12, int i13, List<Integer> ultraBigCoreIds, List<Integer> bigCoreIds, List<Integer> mediumCoreIds, List<Integer> smallCoreIds) {
        g.f(ultraBigCoreIds, "ultraBigCoreIds");
        g.f(bigCoreIds, "bigCoreIds");
        g.f(mediumCoreIds, "mediumCoreIds");
        g.f(smallCoreIds, "smallCoreIds");
        this.ultraBigCount = i10;
        this.bigCount = i11;
        this.mediumCount = i12;
        this.smallCount = i13;
        this.ultraBigCoreIds = ultraBigCoreIds;
        this.bigCoreIds = bigCoreIds;
        this.mediumCoreIds = mediumCoreIds;
        this.smallCoreIds = smallCoreIds;
    }

    public static /* synthetic */ CpuTopology copy$default(CpuTopology cpuTopology, int i10, int i11, int i12, int i13, List list, List list2, List list3, List list4, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = cpuTopology.ultraBigCount;
        }
        if ((i14 & 2) != 0) {
            i11 = cpuTopology.bigCount;
        }
        if ((i14 & 4) != 0) {
            i12 = cpuTopology.mediumCount;
        }
        if ((i14 & 8) != 0) {
            i13 = cpuTopology.smallCount;
        }
        if ((i14 & 16) != 0) {
            list = cpuTopology.ultraBigCoreIds;
        }
        if ((i14 & 32) != 0) {
            list2 = cpuTopology.bigCoreIds;
        }
        if ((i14 & 64) != 0) {
            list3 = cpuTopology.mediumCoreIds;
        }
        if ((i14 & TraceIdKeys.MAX_LENGTH) != 0) {
            list4 = cpuTopology.smallCoreIds;
        }
        List list5 = list3;
        List list6 = list4;
        List list7 = list;
        List list8 = list2;
        return cpuTopology.copy(i10, i11, i12, i13, list7, list8, list5, list6);
    }

    public final int component1() {
        return this.ultraBigCount;
    }

    public final int component2() {
        return this.bigCount;
    }

    public final int component3() {
        return this.mediumCount;
    }

    public final int component4() {
        return this.smallCount;
    }

    public final List<Integer> component5() {
        return this.ultraBigCoreIds;
    }

    public final List<Integer> component6() {
        return this.bigCoreIds;
    }

    public final List<Integer> component7() {
        return this.mediumCoreIds;
    }

    public final List<Integer> component8() {
        return this.smallCoreIds;
    }

    public final CpuTopology copy(int i10, int i11, int i12, int i13, List<Integer> ultraBigCoreIds, List<Integer> bigCoreIds, List<Integer> mediumCoreIds, List<Integer> smallCoreIds) {
        g.f(ultraBigCoreIds, "ultraBigCoreIds");
        g.f(bigCoreIds, "bigCoreIds");
        g.f(mediumCoreIds, "mediumCoreIds");
        g.f(smallCoreIds, "smallCoreIds");
        return new CpuTopology(i10, i11, i12, i13, ultraBigCoreIds, bigCoreIds, mediumCoreIds, smallCoreIds);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CpuTopology)) {
            return false;
        }
        CpuTopology cpuTopology = (CpuTopology) obj;
        return this.ultraBigCount == cpuTopology.ultraBigCount && this.bigCount == cpuTopology.bigCount && this.mediumCount == cpuTopology.mediumCount && this.smallCount == cpuTopology.smallCount && g.b(this.ultraBigCoreIds, cpuTopology.ultraBigCoreIds) && g.b(this.bigCoreIds, cpuTopology.bigCoreIds) && g.b(this.mediumCoreIds, cpuTopology.mediumCoreIds) && g.b(this.smallCoreIds, cpuTopology.smallCoreIds);
    }

    public final List<Integer> getBigCoreIds() {
        return this.bigCoreIds;
    }

    public final int getBigCount() {
        return this.bigCount;
    }

    public final int getHighPerfCoreCount() {
        return this.ultraBigCount + this.bigCount;
    }

    public final List<Integer> getMediumCoreIds() {
        return this.mediumCoreIds;
    }

    public final int getMediumCount() {
        return this.mediumCount;
    }

    public final List<Integer> getSmallCoreIds() {
        return this.smallCoreIds;
    }

    public final int getSmallCount() {
        return this.smallCount;
    }

    public final int getTotalCoreCount() {
        return this.ultraBigCount + this.bigCount + this.mediumCount + this.smallCount;
    }

    public final List<Integer> getUltraBigCoreIds() {
        return this.ultraBigCoreIds;
    }

    public final int getUltraBigCount() {
        return this.ultraBigCount;
    }

    public int hashCode() {
        return this.smallCoreIds.hashCode() + h0.e.b(this.mediumCoreIds, h0.e.b(this.bigCoreIds, h0.e.b(this.ultraBigCoreIds, a.d(this.smallCount, a.d(this.mediumCount, a.d(this.bigCount, Integer.hashCode(this.ultraBigCount) * 31, 31), 31), 31), 31), 31), 31);
    }

    public String toString() {
        int i10 = this.ultraBigCount;
        int i11 = this.bigCount;
        int i12 = this.mediumCount;
        int i13 = this.smallCount;
        List<Integer> list = this.ultraBigCoreIds;
        List<Integer> list2 = this.bigCoreIds;
        List<Integer> list3 = this.mediumCoreIds;
        List<Integer> list4 = this.smallCoreIds;
        StringBuilder sbD = h0.e.d(i10, "CpuTopology(ultraBigCount=", i11, ", bigCount=", ", mediumCount=");
        h0.e.l(sbD, i12, ", smallCount=", i13, ", ultraBigCoreIds=");
        sbD.append(list);
        sbD.append(", bigCoreIds=");
        sbD.append(list2);
        sbD.append(", mediumCoreIds=");
        sbD.append(list3);
        sbD.append(", smallCoreIds=");
        sbD.append(list4);
        sbD.append(")");
        return sbD.toString();
    }
}
