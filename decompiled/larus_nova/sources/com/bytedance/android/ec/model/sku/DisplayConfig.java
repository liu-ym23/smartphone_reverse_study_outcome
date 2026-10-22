package com.bytedance.android.ec.model.sku;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJJ\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\r\u0010\nR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "Ljava/io/Serializable;", "showPrice", "", "showDiscount", "showDetailEnter", "showStepper", "showDouInstallment", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getShowDetailEnter", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getShowDiscount", "getShowDouInstallment", "getShowPrice", "getShowStepper", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/bytedance/android/ec/model/sku/DisplayConfig;", "equals", "other", "", "hashCode", "", "toString", "", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class DisplayConfig implements Serializable {

    @SerializedName("show_detail_entrance")
    private final Boolean showDetailEnter;

    @SerializedName("show_discount_component")
    private final Boolean showDiscount;

    @SerializedName("show_dou_installment")
    private final Boolean showDouInstallment;

    @SerializedName("show_price_component")
    private final Boolean showPrice;

    @SerializedName("show_stepper")
    private final Boolean showStepper;

    public DisplayConfig() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ DisplayConfig copy$default(DisplayConfig r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, Boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.showPrice;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.showDiscount;
    L8:
        Boolean r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.showDetailEnter;
    L11:
        Boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.showStepper;
    L14:
        Boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.showDouInstallment;
    L17:
        Boolean r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final Boolean component1() {
        return this.showPrice;
    }

    public final Boolean component2() {
        return this.showDiscount;
    }

    public final Boolean component3() {
        return this.showDetailEnter;
    }

    public final Boolean component4() {
        return this.showStepper;
    }

    public final Boolean component5() {
        return this.showDouInstallment;
    }

    public final DisplayConfig copy(Boolean r100, Boolean r101, Boolean r110, Boolean r111, Boolean r112) {
        return new DisplayConfig(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DisplayConfig) == false) goto L16;
        DisplayConfig r101 = (DisplayConfig) r100;
        if (Intrinsics.areEqual(this.showPrice, r101.showPrice) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showDiscount, r101.showDiscount) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.showDetailEnter, r101.showDetailEnter) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showStepper, r101.showStepper) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.showDouInstallment, r101.showDouInstallment) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        Boolean r100 = this.showPrice;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.showDiscount;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.showDetailEnter;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showStepper;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.showDouInstallment;
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
        return "DisplayConfig(showPrice=" + this.showPrice + ", showDiscount=" + this.showDiscount + ", showDetailEnter=" + this.showDetailEnter + ", showStepper=" + this.showStepper + ", showDouInstallment=" + this.showDouInstallment + ")";
    }

    public final Boolean getShowDetailEnter() {
        return this.showDetailEnter;
    }

    public final Boolean getShowDiscount() {
        return this.showDiscount;
    }

    public final Boolean getShowDouInstallment() {
        return this.showDouInstallment;
    }

    public final Boolean getShowPrice() {
        return this.showPrice;
    }

    public final Boolean getShowStepper() {
        return this.showStepper;
    }

    public DisplayConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104) {
        this.showPrice = r100;
        this.showDiscount = r101;
        this.showDetailEnter = r102;
        this.showStepper = r103;
        this.showDouInstallment = r104;
    }

    public /* synthetic */ DisplayConfig(Boolean r100, Boolean r101, Boolean r102, Boolean r103, Boolean r104, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L5;
        Boolean r112 = null;
    L7:
        if ((r110 & 2) == 0) goto L9;
        Boolean r105 = null;
    L11:
        if ((r110 & 4) == 0) goto L13;
        Boolean r106 = null;
    L15:
        if ((r110 & 8) == 0) goto L17;
        Boolean r107 = null;
    L19:
        if ((r110 & 16) == 0) goto L21;
        Boolean r113 = null;
    L22:
        this(r112, r105, r106, r107, r113);
        return;
    L21:
        r113 = r104;
        goto L22
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r112 = r100;
        goto L7
    }
}
