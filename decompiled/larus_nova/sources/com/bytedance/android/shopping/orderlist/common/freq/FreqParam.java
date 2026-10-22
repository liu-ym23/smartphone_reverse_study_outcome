package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "Ljava/io/Serializable;", BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, "", BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, "lookBackPeriod", "", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "getLookBackPeriod", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMax", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMin", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqParam implements Serializable {

    @SerializedName("lookback_period")
    private final Long lookBackPeriod;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX)
    private final Integer max;

    @SerializedName(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN)
    private final Integer min;

    public FreqParam() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FreqParam copy$default(FreqParam r100, Integer r101, Integer r102, Long r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.min;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.max;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.lookBackPeriod;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.min;
    }

    public final Integer component2() {
        return this.max;
    }

    public final Long component3() {
        return this.lookBackPeriod;
    }

    public final FreqParam copy(Integer r100, Integer r101, Long r102) {
        return new FreqParam(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FreqParam) == false) goto L12;
        FreqParam r101 = (FreqParam) r100;
        if (Intrinsics.areEqual(this.min, r101.min) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.max, r101.max) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lookBackPeriod, r101.lookBackPeriod) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        Integer r100 = this.min;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.max;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.lookBackPeriod;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FreqParam(min=" + this.min + ", max=" + this.max + ", lookBackPeriod=" + this.lookBackPeriod + ")";
    }

    public final Long getLookBackPeriod() {
        return this.lookBackPeriod;
    }

    public final Integer getMax() {
        return this.max;
    }

    public final Integer getMin() {
        return this.min;
    }

    public FreqParam(Integer r100, Integer r101, Long r102) {
        this.min = r100;
        this.max = r101;
        this.lookBackPeriod = r102;
    }

    public /* synthetic */ FreqParam(Integer r100, Integer r101, Long r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
