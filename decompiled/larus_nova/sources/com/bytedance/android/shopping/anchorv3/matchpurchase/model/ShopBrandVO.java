package com.bytedance.android.shopping.anchorv3.matchpurchase.model;

import com.bytedance.android.ec.model.ECUrlModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003JE\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/matchpurchase/model/ShopBrandVO;", "Ljava/io/Serializable;", "shopIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "shopName", "", "arrowIcon", "jumpHint", "schema", "(Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;Ljava/lang/String;Ljava/lang/String;)V", "getArrowIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "getJumpHint", "()Ljava/lang/String;", "getSchema", "getShopIcon", "getShopName", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShopBrandVO implements Serializable {
    private final ECUrlModel arrowIcon;
    private final String jumpHint;
    private final String schema;
    private final ECUrlModel shopIcon;
    private final String shopName;

    public static /* synthetic */ ShopBrandVO copy$default(ShopBrandVO r100, ECUrlModel r101, String r102, ECUrlModel r103, String r104, String r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.shopIcon;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.shopName;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.arrowIcon;
    L11:
        ECUrlModel r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.jumpHint;
    L14:
        String r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.schema;
    L17:
        ECUrlModel r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final ECUrlModel component1() {
        return this.shopIcon;
    }

    public final String component2() {
        return this.shopName;
    }

    public final ECUrlModel component3() {
        return this.arrowIcon;
    }

    public final String component4() {
        return this.jumpHint;
    }

    public final String component5() {
        return this.schema;
    }

    public final ShopBrandVO copy(ECUrlModel r100, String r101, ECUrlModel r110, String r111, String r112) {
        return new ShopBrandVO(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ShopBrandVO) == false) goto L16;
        ShopBrandVO r101 = (ShopBrandVO) r100;
        if (Intrinsics.areEqual(this.shopIcon, r101.shopIcon) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shopName, r101.shopName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.arrowIcon, r101.arrowIcon) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.jumpHint, r101.jumpHint) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        ECUrlModel r100 = this.shopIcon;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.shopName;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.arrowIcon;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.jumpHint;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.schema;
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
        return "ShopBrandVO(shopIcon=" + this.shopIcon + ", shopName=" + this.shopName + ", arrowIcon=" + this.arrowIcon + ", jumpHint=" + this.jumpHint + ", schema=" + this.schema + ")";
    }

    public final ECUrlModel getArrowIcon() {
        return this.arrowIcon;
    }

    public final String getJumpHint() {
        return this.jumpHint;
    }

    public final String getSchema() {
        return this.schema;
    }

    public final ECUrlModel getShopIcon() {
        return this.shopIcon;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public ShopBrandVO(ECUrlModel r100, String r101, ECUrlModel r102, String r103, String r104) {
        this.shopIcon = r100;
        this.shopName = r101;
        this.arrowIcon = r102;
        this.jumpHint = r103;
        this.schema = r104;
    }

    public /* synthetic */ ShopBrandVO(ECUrlModel r100, String r101, ECUrlModel r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        ECUrlModel r102 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        ECUrlModel r104 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r105 = null;
    L18:
        this(r102, r103, r104, r105, r112);
        return;
    L17:
        r105 = r111;
        goto L18
    L13:
        r104 = r110;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r102 = r100;
        goto L7
    }
}
