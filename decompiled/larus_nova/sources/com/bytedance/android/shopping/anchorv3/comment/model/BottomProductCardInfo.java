package com.bytedance.android.shopping.anchorv3.comment.model;

import com.bytedance.android.ec.model.response.LynxCellDataConfig;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J+\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/comment/model/BottomProductCardInfo;", "Ljava/io/Serializable;", "showProductCard", "", "productCardInfo", "", "lynxConfig", "Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;", "(ZLjava/lang/String;Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;)V", "getLynxConfig", "()Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;", "setLynxConfig", "(Lcom/bytedance/android/ec/model/response/LynxCellDataConfig;)V", "getProductCardInfo", "()Ljava/lang/String;", "setProductCardInfo", "(Ljava/lang/String;)V", "getShowProductCard", "()Z", "setShowProductCard", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomProductCardInfo implements Serializable {

    @SerializedName("config")
    private LynxCellDataConfig lynxConfig;

    @SerializedName("product_card_info")
    private String productCardInfo;

    @SerializedName("show_product_card")
    private boolean showProductCard;

    public BottomProductCardInfo() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ BottomProductCardInfo copy$default(BottomProductCardInfo r100, boolean r101, String r102, LynxCellDataConfig r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.showProductCard;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.productCardInfo;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.lynxConfig;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final boolean component1() {
        return this.showProductCard;
    }

    public final String component2() {
        return this.productCardInfo;
    }

    public final LynxCellDataConfig component3() {
        return this.lynxConfig;
    }

    public final BottomProductCardInfo copy(boolean r100, String r101, LynxCellDataConfig r102) {
        return new BottomProductCardInfo(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomProductCardInfo) == false) goto L12;
        BottomProductCardInfo r101 = (BottomProductCardInfo) r100;
        if (this.showProductCard == r101.showProductCard) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.productCardInfo, r101.productCardInfo) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lynxConfig, r101.lynxConfig) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r100 = this.showProductCard;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.productCardInfo;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        LynxCellDataConfig r107 = this.lynxConfig;
        if (r107 == null) goto L13;
        r104 = r107.hashCode();
    L13:
        return r106 + r104;
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "BottomProductCardInfo(showProductCard=" + this.showProductCard + ", productCardInfo=" + this.productCardInfo + ", lynxConfig=" + this.lynxConfig + ")";
    }

    public final LynxCellDataConfig getLynxConfig() {
        return this.lynxConfig;
    }

    public final String getProductCardInfo() {
        return this.productCardInfo;
    }

    public final boolean getShowProductCard() {
        return this.showProductCard;
    }

    public final void setLynxConfig(LynxCellDataConfig r100) {
        this.lynxConfig = r100;
    }

    public final void setProductCardInfo(String r100) {
        this.productCardInfo = r100;
    }

    public final void setShowProductCard(boolean r100) {
        this.showProductCard = r100;
    }

    public BottomProductCardInfo(boolean r100, String r101, LynxCellDataConfig r102) {
        this.showProductCard = r100;
        this.productCardInfo = r101;
        this.lynxConfig = r102;
    }

    public /* synthetic */ BottomProductCardInfo(boolean r100, String r101, LynxCellDataConfig r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
