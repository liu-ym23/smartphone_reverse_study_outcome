package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\rHÆ\u0003Ji\u0010%\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020+HÖ\u0001J\t\u0010,\u001a\u00020\u000bHÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010¨\u0006-"}, d2 = {"Lcom/bytedance/android/shopping/store/home/entity/ECShopToolsInfo;", "Ljava/io/Serializable;", "customServiceEntry", "Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "shareEntry", "cartEntry", "orderEntry", "memberEntry", "couponRedPackEntry", "Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;", "lynxUrl", "", "couponIcon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "(Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;Ljava/lang/String;Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getCartEntry", "()Lcom/bytedance/android/shopping/store/home/entity/ToolEntryInfo;", "getCouponIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "setCouponIcon", "(Lcom/bytedance/android/ec/model/ECUrlModel;)V", "getCouponRedPackEntry", "()Lcom/bytedance/android/shopping/store/home/entity/CouponRedPackEntryInfo;", "getCustomServiceEntry", "getLynxUrl", "()Ljava/lang/String;", "getMemberEntry", "getOrderEntry", "getShareEntry", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopToolsInfo implements Serializable {

    @SerializedName("cart_entry_info")
    private final ToolEntryInfo cartEntry;

    @SerializedName("coupon_icon")
    private ECUrlModel couponIcon;

    @SerializedName("coupon_red_pack_entry_info")
    private final CouponRedPackEntryInfo couponRedPackEntry;

    @SerializedName("service_entry_info")
    private final ToolEntryInfo customServiceEntry;

    @SerializedName("render_lynx_url")
    private final String lynxUrl;

    @SerializedName("member_entry_info")
    private final ToolEntryInfo memberEntry;

    @SerializedName("order_entry_info")
    private final ToolEntryInfo orderEntry;

    @SerializedName("share_entry_info")
    private final ToolEntryInfo shareEntry;

    public ECShopToolsInfo() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ECShopToolsInfo copy$default(ECShopToolsInfo r100, ToolEntryInfo r110, ToolEntryInfo r111, ToolEntryInfo r112, ToolEntryInfo r113, ToolEntryInfo r114, CouponRedPackEntryInfo r115, String r116, ECUrlModel r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        ToolEntryInfo r101 = r100.customServiceEntry;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ToolEntryInfo r102 = r100.shareEntry;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ToolEntryInfo r103 = r100.cartEntry;
    L15:
        if ((r118 & 8) == 0) goto L17;
        ToolEntryInfo r104 = r100.orderEntry;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ToolEntryInfo r105 = r100.memberEntry;
    L23:
        if ((r118 & 32) == 0) goto L25;
        CouponRedPackEntryInfo r106 = r100.couponRedPackEntry;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = r100.lynxUrl;
    L31:
        if ((r118 & 128) == 0) goto L33;
        ECUrlModel r108 = r100.couponIcon;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final ToolEntryInfo component1() {
        return this.customServiceEntry;
    }

    public final ToolEntryInfo component2() {
        return this.shareEntry;
    }

    public final ToolEntryInfo component3() {
        return this.cartEntry;
    }

    public final ToolEntryInfo component4() {
        return this.orderEntry;
    }

    public final ToolEntryInfo component5() {
        return this.memberEntry;
    }

    public final CouponRedPackEntryInfo component6() {
        return this.couponRedPackEntry;
    }

    public final String component7() {
        return this.lynxUrl;
    }

    public final ECUrlModel component8() {
        return this.couponIcon;
    }

    public final ECShopToolsInfo copy(ToolEntryInfo r110, ToolEntryInfo r111, ToolEntryInfo r112, ToolEntryInfo r113, ToolEntryInfo r114, CouponRedPackEntryInfo r115, String r116, ECUrlModel r117) {
        return new ECShopToolsInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECShopToolsInfo) == false) goto L22;
        ECShopToolsInfo r101 = (ECShopToolsInfo) r100;
        if (Intrinsics.areEqual(this.customServiceEntry, r101.customServiceEntry) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.shareEntry, r101.shareEntry) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.cartEntry, r101.cartEntry) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.orderEntry, r101.orderEntry) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.memberEntry, r101.memberEntry) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.couponRedPackEntry, r101.couponRedPackEntry) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.lynxUrl, r101.lynxUrl) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.couponIcon, r101.couponIcon) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        ToolEntryInfo r100 = this.customServiceEntry;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ToolEntryInfo r104 = this.shareEntry;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ToolEntryInfo r107 = this.cartEntry;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ToolEntryInfo r110 = this.orderEntry;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        ToolEntryInfo r113 = this.memberEntry;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        CouponRedPackEntryInfo r116 = this.couponRedPackEntry;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.lynxUrl;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.couponIcon;
        if (r122 == null) goto L34;
        r101 = r122.hashCode();
    L34:
        return r121 + r101;
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
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
        return "ECShopToolsInfo(customServiceEntry=" + this.customServiceEntry + ", shareEntry=" + this.shareEntry + ", cartEntry=" + this.cartEntry + ", orderEntry=" + this.orderEntry + ", memberEntry=" + this.memberEntry + ", couponRedPackEntry=" + this.couponRedPackEntry + ", lynxUrl=" + this.lynxUrl + ", couponIcon=" + this.couponIcon + ")";
    }

    public final ToolEntryInfo getCartEntry() {
        return this.cartEntry;
    }

    public final ECUrlModel getCouponIcon() {
        return this.couponIcon;
    }

    public final CouponRedPackEntryInfo getCouponRedPackEntry() {
        return this.couponRedPackEntry;
    }

    public final ToolEntryInfo getCustomServiceEntry() {
        return this.customServiceEntry;
    }

    public final String getLynxUrl() {
        return this.lynxUrl;
    }

    public final ToolEntryInfo getMemberEntry() {
        return this.memberEntry;
    }

    public final ToolEntryInfo getOrderEntry() {
        return this.orderEntry;
    }

    public final ToolEntryInfo getShareEntry() {
        return this.shareEntry;
    }

    public final void setCouponIcon(ECUrlModel r100) {
        this.couponIcon = r100;
    }

    public ECShopToolsInfo(ToolEntryInfo r100, ToolEntryInfo r101, ToolEntryInfo r102, ToolEntryInfo r103, ToolEntryInfo r104, CouponRedPackEntryInfo r105, String r106, ECUrlModel r107) {
        this.customServiceEntry = r100;
        this.shareEntry = r101;
        this.cartEntry = r102;
        this.orderEntry = r103;
        this.memberEntry = r104;
        this.couponRedPackEntry = r105;
        this.lynxUrl = r106;
        this.couponIcon = r107;
    }

    public /* synthetic */ ECShopToolsInfo(ToolEntryInfo r110, ToolEntryInfo r111, ToolEntryInfo r112, ToolEntryInfo r113, ToolEntryInfo r114, CouponRedPackEntryInfo r115, String r116, ECUrlModel r117, int r118, DefaultConstructorMarker r119) {
        ECUrlModel r100 = null;
        if ((r118 & 1) == 0) goto L5;
        ToolEntryInfo r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        ToolEntryInfo r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ToolEntryInfo r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        ToolEntryInfo r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        ToolEntryInfo r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        CouponRedPackEntryInfo r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        String r107 = null;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r100 = r117;
    L34:
        this(r101, r102, r103, r104, r105, r106, r107, r100);
        return;
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }
}
