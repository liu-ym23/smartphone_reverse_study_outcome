package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.shopping.threed.repository.dto.BuyButtonComponent;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J8\u0010\u0014\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\bHÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;", "Ljava/io/Serializable;", "buttonComponent", "", "Lcom/bytedance/android/shopping/threed/repository/dto/BuyButtonComponent;", "mpV2DiscountPrice", "", "mpV2DiscountTip", "", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "getButtonComponent", "()Ljava/util/List;", "getMpV2DiscountPrice", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMpV2DiscountTip", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/util/List;Ljava/lang/Long;Ljava/lang/String;)Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/PurchaseButtonVO;", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PurchaseButtonVO implements Serializable {
    private final List<BuyButtonComponent> buttonComponent;
    private final Long mpV2DiscountPrice;
    private final String mpV2DiscountTip;

    public PurchaseButtonVO() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PurchaseButtonVO copy$default(PurchaseButtonVO r100, List r101, Long r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.buttonComponent;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.mpV2DiscountPrice;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.mpV2DiscountTip;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final List<BuyButtonComponent> component1() {
        return this.buttonComponent;
    }

    public final Long component2() {
        return this.mpV2DiscountPrice;
    }

    public final String component3() {
        return this.mpV2DiscountTip;
    }

    public final PurchaseButtonVO copy(List<BuyButtonComponent> r100, Long r101, String r102) {
        return new PurchaseButtonVO(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PurchaseButtonVO) == false) goto L12;
        PurchaseButtonVO r101 = (PurchaseButtonVO) r100;
        if (Intrinsics.areEqual(this.buttonComponent, r101.buttonComponent) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.mpV2DiscountPrice, r101.mpV2DiscountPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mpV2DiscountTip, r101.mpV2DiscountTip) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        List<BuyButtonComponent> r100 = this.buttonComponent;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.mpV2DiscountPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mpV2DiscountTip;
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
        return "PurchaseButtonVO(buttonComponent=" + this.buttonComponent + ", mpV2DiscountPrice=" + this.mpV2DiscountPrice + ", mpV2DiscountTip=" + this.mpV2DiscountTip + ")";
    }

    public final List<BuyButtonComponent> getButtonComponent() {
        return this.buttonComponent;
    }

    public final Long getMpV2DiscountPrice() {
        return this.mpV2DiscountPrice;
    }

    public final String getMpV2DiscountTip() {
        return this.mpV2DiscountTip;
    }

    public PurchaseButtonVO(List<BuyButtonComponent> r100, Long r101, String r102) {
        this.buttonComponent = r100;
        this.mpV2DiscountPrice = r101;
        this.mpV2DiscountTip = r102;
    }

    public /* synthetic */ PurchaseButtonVO(List r100, Long r101, String r102, int r103, DefaultConstructorMarker r104) {
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
