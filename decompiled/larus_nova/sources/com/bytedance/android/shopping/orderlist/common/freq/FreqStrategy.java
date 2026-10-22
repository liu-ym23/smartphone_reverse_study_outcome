package com.bytedance.android.shopping.orderlist.common.freq;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "Ljava/io/Serializable;", SlcCommonAction.KEY_ACTIONS, "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "targetStatus", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "freezingPeriod", "", "lookBackPeriod", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/lang/Long;)V", "getActions", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "getFreezingPeriod", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLookBackPeriod", "getTargetStatus", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "component1", "component2", "component3", "component4", "copy", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStrategy;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqStrategy implements Serializable {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final FreqActionType actions;

    @SerializedName("freezing_period")
    private final Long freezingPeriod;

    @SerializedName("lookback_period")
    private final Long lookBackPeriod;

    @SerializedName("target_status")
    private final FreqStatus targetStatus;

    public FreqStrategy() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ FreqStrategy copy$default(FreqStrategy r100, FreqActionType r101, FreqStatus r102, Long r103, Long r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.actions;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.targetStatus;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.freezingPeriod;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.lookBackPeriod;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final FreqActionType component1() {
        return this.actions;
    }

    public final FreqStatus component2() {
        return this.targetStatus;
    }

    public final Long component3() {
        return this.freezingPeriod;
    }

    public final Long component4() {
        return this.lookBackPeriod;
    }

    public final FreqStrategy copy(FreqActionType r100, FreqStatus r101, Long r102, Long r103) {
        return new FreqStrategy(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FreqStrategy) == false) goto L14;
        FreqStrategy r101 = (FreqStrategy) r100;
        if (Intrinsics.areEqual(this.actions, r101.actions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.targetStatus, r101.targetStatus) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.freezingPeriod, r101.freezingPeriod) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lookBackPeriod, r101.lookBackPeriod) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        FreqActionType r100 = this.actions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FreqStatus r104 = this.targetStatus;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.freezingPeriod;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.lookBackPeriod;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "FreqStrategy(actions=" + this.actions + ", targetStatus=" + this.targetStatus + ", freezingPeriod=" + this.freezingPeriod + ", lookBackPeriod=" + this.lookBackPeriod + ")";
    }

    public final FreqActionType getActions() {
        return this.actions;
    }

    public final Long getFreezingPeriod() {
        return this.freezingPeriod;
    }

    public final Long getLookBackPeriod() {
        return this.lookBackPeriod;
    }

    public final FreqStatus getTargetStatus() {
        return this.targetStatus;
    }

    public FreqStrategy(FreqActionType r100, FreqStatus r101, Long r102, Long r103) {
        this.actions = r100;
        this.targetStatus = r101;
        this.freezingPeriod = r102;
        this.lookBackPeriod = r103;
    }

    public /* synthetic */ FreqStrategy(FreqActionType r100, FreqStatus r101, Long r102, Long r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
