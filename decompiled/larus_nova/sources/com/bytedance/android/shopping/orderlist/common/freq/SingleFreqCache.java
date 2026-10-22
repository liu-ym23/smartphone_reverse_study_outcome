package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0003J\\\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R&\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "Ljava/io/Serializable;", "status", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "unfreezeDate", "", "view", "", "click", "close", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getClick", "()Ljava/util/List;", "setClick", "(Ljava/util/List;)V", "getClose", "setClose", "getStatus", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;", "setStatus", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;)V", "getUnfreezeDate", "()Ljava/lang/Long;", "setUnfreezeDate", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getView", "setView", "clearActionIfNeeded", "", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqStatus;Ljava/lang/Long;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/bytedance/android/shopping/orderlist/common/freq/SingleFreqCache;", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SingleFreqCache implements Serializable {

    @SerializedName("click")
    private List<Long> click;

    @SerializedName("close")
    private List<Long> close;

    @SerializedName("status")
    private FreqStatus status;

    @SerializedName("unfreeze_date")
    private Long unfreezeDate;

    @SerializedName("view")
    private List<Long> view;

    public SingleFreqCache() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SingleFreqCache copy$default(SingleFreqCache r100, FreqStatus r101, Long r102, List r103, List r104, List r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.status;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.unfreezeDate;
    L8:
        Long r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.view;
    L11:
        List r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.click;
    L14:
        List r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.close;
    L17:
        FreqStatus r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final FreqStatus component1() {
        return this.status;
    }

    public final Long component2() {
        return this.unfreezeDate;
    }

    public final List<Long> component3() {
        return this.view;
    }

    public final List<Long> component4() {
        return this.click;
    }

    public final List<Long> component5() {
        return this.close;
    }

    public final SingleFreqCache copy(FreqStatus r100, Long r101, List<Long> r110, List<Long> r111, List<Long> r112) {
        return new SingleFreqCache(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SingleFreqCache) == false) goto L16;
        SingleFreqCache r101 = (SingleFreqCache) r100;
        if (Intrinsics.areEqual(this.status, r101.status) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.unfreezeDate, r101.unfreezeDate) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.click, r101.click) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.close, r101.close) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        FreqStatus r100 = this.status;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.unfreezeDate;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<Long> r107 = this.view;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<Long> r110 = this.click;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<Long> r113 = this.close;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "SingleFreqCache(status=" + this.status + ", unfreezeDate=" + this.unfreezeDate + ", view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final void clearActionIfNeeded() {
        List<Long> r100 = this.view;
        if (r100 != null) goto L5;
    L7:
        List<Long> r101 = this.click;
        if (r101 != null) goto L10;
    L12:
        List<Long> r102 = this.close;
        if (r102 != null) goto L15;
        return;
    L15:
        if ((!r102.isEmpty()) != true) goto L19;
        this.close = new LinkedList();
        return;
    L19:
        return;
    L10:
        if ((!r101.isEmpty()) != true) goto L12;
        this.click = new LinkedList();
        goto L12
    L5:
        if ((!r100.isEmpty()) != true) goto L7;
        this.view = new LinkedList();
        goto L7
    }

    public final List<Long> getClick() {
        return this.click;
    }

    public final List<Long> getClose() {
        return this.close;
    }

    public final FreqStatus getStatus() {
        return this.status;
    }

    public final Long getUnfreezeDate() {
        return this.unfreezeDate;
    }

    public final List<Long> getView() {
        return this.view;
    }

    public final void setClick(List<Long> r100) {
        this.click = r100;
    }

    public final void setClose(List<Long> r100) {
        this.close = r100;
    }

    public final void setStatus(FreqStatus r100) {
        this.status = r100;
    }

    public final void setUnfreezeDate(Long r100) {
        this.unfreezeDate = r100;
    }

    public final void setView(List<Long> r100) {
        this.view = r100;
    }

    public SingleFreqCache(FreqStatus r100, Long r101, List<Long> r102, List<Long> r103, List<Long> r104) {
        this.status = r100;
        this.unfreezeDate = r101;
        this.view = r102;
        this.click = r103;
        this.close = r104;
    }

    public /* synthetic */ SingleFreqCache(FreqStatus r100, Long r101, List r102, List r103, List r104, int r105, DefaultConstructorMarker r110) {
        Long r106 = null;
        if ((r105 & 1) == 0) goto L5;
        FreqStatus r111 = null;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        r102 = new LinkedList();
    L13:
        List r107 = r102;
        if ((r105 & 8) == 0) goto L16;
        r103 = new LinkedList();
    L16:
        List r108 = r103;
        if ((r105 & 16) == 0) goto L19;
        r104 = new LinkedList();
    L19:
        this(r111, r106, r107, r108, r104);
        return;
    L5:
        r111 = r100;
        goto L7
    }
}
