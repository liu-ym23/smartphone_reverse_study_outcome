package com.bytedance.android.shopping.orderlist.common.freq;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/freq/FreqActionType;", "Ljava/io/Serializable;", "view", "Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "click", "close", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;)V", "getClick", "()Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;", "setClick", "(Lcom/bytedance/android/shopping/orderlist/common/freq/FreqParam;)V", "getClose", "setClose", "getView", "setView", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FreqActionType implements Serializable {

    @SerializedName("click")
    private FreqParam click;

    @SerializedName("close")
    private FreqParam close;

    @SerializedName("view")
    private FreqParam view;

    public FreqActionType() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FreqActionType copy$default(FreqActionType r100, FreqParam r101, FreqParam r102, FreqParam r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.view;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.click;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.close;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final FreqParam component1() {
        return this.view;
    }

    public final FreqParam component2() {
        return this.click;
    }

    public final FreqParam component3() {
        return this.close;
    }

    public final FreqActionType copy(FreqParam r100, FreqParam r101, FreqParam r102) {
        return new FreqActionType(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof FreqActionType) == false) goto L12;
        FreqActionType r101 = (FreqActionType) r100;
        if (Intrinsics.areEqual(this.view, r101.view) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.click, r101.click) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.close, r101.close) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        FreqParam r100 = this.view;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        FreqParam r104 = this.click;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FreqParam r107 = this.close;
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
        return "FreqActionType(view=" + this.view + ", click=" + this.click + ", close=" + this.close + ")";
    }

    public final FreqParam getClick() {
        return this.click;
    }

    public final FreqParam getClose() {
        return this.close;
    }

    public final FreqParam getView() {
        return this.view;
    }

    public final void setClick(FreqParam r100) {
        this.click = r100;
    }

    public final void setClose(FreqParam r100) {
        this.close = r100;
    }

    public final void setView(FreqParam r100) {
        this.view = r100;
    }

    public FreqActionType(FreqParam r100, FreqParam r101, FreqParam r102) {
        this.view = r100;
        this.click = r101;
        this.close = r102;
    }

    public /* synthetic */ FreqActionType(FreqParam r100, FreqParam r101, FreqParam r102, int r103, DefaultConstructorMarker r104) {
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
