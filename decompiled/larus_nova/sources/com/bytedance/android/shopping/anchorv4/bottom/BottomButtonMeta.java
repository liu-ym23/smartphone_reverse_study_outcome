package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.model.response.ECPromotion;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ji\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u000203HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00064"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/BottomButtonMeta;", "Ljava/io/Serializable;", "skuMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "buyMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/BuyMeta;", "addCartMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "imMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/IMMeta;", "enterShopMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/EnterShopMeta;", "enterCartMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/EnterCartMeta;", "tipMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/BottomTipMeta;", "appointMeta", "Lcom/bytedance/android/shopping/anchorv4/bottom/AppointmentMeta;", "(Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/BuyMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/IMMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/EnterShopMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/EnterCartMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/BottomTipMeta;Lcom/bytedance/android/shopping/anchorv4/bottom/AppointmentMeta;)V", "getAddCartMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/AddCartMeta;", "getAppointMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/AppointmentMeta;", "getBuyMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BuyMeta;", "getEnterCartMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/EnterCartMeta;", "getEnterShopMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/EnterShopMeta;", "getImMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/IMMeta;", "getSkuMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/SkuMeta;", "getTipMeta", "()Lcom/bytedance/android/shopping/anchorv4/bottom/BottomTipMeta;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomButtonMeta implements Serializable {

    @SerializedName("add_cart")
    private final AddCartMeta addCartMeta;

    @SerializedName("appointment_meta")
    private final AppointmentMeta appointMeta;

    @SerializedName("buy")
    private final BuyMeta buyMeta;

    @SerializedName("enter_cart")
    private final EnterCartMeta enterCartMeta;

    @SerializedName("enter_shop")
    private final EnterShopMeta enterShopMeta;

    @SerializedName("im")
    private final IMMeta imMeta;

    @SerializedName(ECPromotion.SKU)
    private final SkuMeta skuMeta;

    @SerializedName("tip_meta")
    private final BottomTipMeta tipMeta;

    public BottomButtonMeta() {
        this(null, null, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ BottomButtonMeta copy$default(BottomButtonMeta r100, SkuMeta r110, BuyMeta r111, AddCartMeta r112, IMMeta r113, EnterShopMeta r114, EnterCartMeta r115, BottomTipMeta r116, AppointmentMeta r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        SkuMeta r101 = r100.skuMeta;
    L7:
        if ((r118 & 2) == 0) goto L9;
        BuyMeta r102 = r100.buyMeta;
    L11:
        if ((r118 & 4) == 0) goto L13;
        AddCartMeta r103 = r100.addCartMeta;
    L15:
        if ((r118 & 8) == 0) goto L17;
        IMMeta r104 = r100.imMeta;
    L19:
        if ((r118 & 16) == 0) goto L21;
        EnterShopMeta r105 = r100.enterShopMeta;
    L23:
        if ((r118 & 32) == 0) goto L25;
        EnterCartMeta r106 = r100.enterCartMeta;
    L27:
        if ((r118 & 64) == 0) goto L29;
        BottomTipMeta r107 = r100.tipMeta;
    L31:
        if ((r118 & 128) == 0) goto L33;
        AppointmentMeta r108 = r100.appointMeta;
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

    public final SkuMeta component1() {
        return this.skuMeta;
    }

    public final BuyMeta component2() {
        return this.buyMeta;
    }

    public final AddCartMeta component3() {
        return this.addCartMeta;
    }

    public final IMMeta component4() {
        return this.imMeta;
    }

    public final EnterShopMeta component5() {
        return this.enterShopMeta;
    }

    public final EnterCartMeta component6() {
        return this.enterCartMeta;
    }

    public final BottomTipMeta component7() {
        return this.tipMeta;
    }

    public final AppointmentMeta component8() {
        return this.appointMeta;
    }

    public final BottomButtonMeta copy(SkuMeta r110, BuyMeta r111, AddCartMeta r112, IMMeta r113, EnterShopMeta r114, EnterCartMeta r115, BottomTipMeta r116, AppointmentMeta r117) {
        return new BottomButtonMeta(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BottomButtonMeta) == false) goto L22;
        BottomButtonMeta r101 = (BottomButtonMeta) r100;
        if (Intrinsics.areEqual(this.skuMeta, r101.skuMeta) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.buyMeta, r101.buyMeta) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.addCartMeta, r101.addCartMeta) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imMeta, r101.imMeta) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.enterShopMeta, r101.enterShopMeta) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.enterCartMeta, r101.enterCartMeta) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.tipMeta, r101.tipMeta) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.appointMeta, r101.appointMeta) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        SkuMeta r100 = this.skuMeta;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        BuyMeta r104 = this.buyMeta;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        AddCartMeta r107 = this.addCartMeta;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        IMMeta r110 = this.imMeta;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        EnterShopMeta r113 = this.enterShopMeta;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        EnterCartMeta r116 = this.enterCartMeta;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        BottomTipMeta r119 = this.tipMeta;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        AppointmentMeta r122 = this.appointMeta;
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
        return "BottomButtonMeta(skuMeta=" + this.skuMeta + ", buyMeta=" + this.buyMeta + ", addCartMeta=" + this.addCartMeta + ", imMeta=" + this.imMeta + ", enterShopMeta=" + this.enterShopMeta + ", enterCartMeta=" + this.enterCartMeta + ", tipMeta=" + this.tipMeta + ", appointMeta=" + this.appointMeta + ")";
    }

    public final AddCartMeta getAddCartMeta() {
        return this.addCartMeta;
    }

    public final AppointmentMeta getAppointMeta() {
        return this.appointMeta;
    }

    public final BuyMeta getBuyMeta() {
        return this.buyMeta;
    }

    public final EnterCartMeta getEnterCartMeta() {
        return this.enterCartMeta;
    }

    public final EnterShopMeta getEnterShopMeta() {
        return this.enterShopMeta;
    }

    public final IMMeta getImMeta() {
        return this.imMeta;
    }

    public final SkuMeta getSkuMeta() {
        return this.skuMeta;
    }

    public final BottomTipMeta getTipMeta() {
        return this.tipMeta;
    }

    public BottomButtonMeta(SkuMeta r100, BuyMeta r101, AddCartMeta r102, IMMeta r103, EnterShopMeta r104, EnterCartMeta r105, BottomTipMeta r106, AppointmentMeta r107) {
        this.skuMeta = r100;
        this.buyMeta = r101;
        this.addCartMeta = r102;
        this.imMeta = r103;
        this.enterShopMeta = r104;
        this.enterCartMeta = r105;
        this.tipMeta = r106;
        this.appointMeta = r107;
    }

    public /* synthetic */ BottomButtonMeta(SkuMeta r110, BuyMeta r111, AddCartMeta r112, IMMeta r113, EnterShopMeta r114, EnterCartMeta r115, BottomTipMeta r116, AppointmentMeta r117, int r118, DefaultConstructorMarker r119) {
        AppointmentMeta r100 = null;
        if ((r118 & 1) == 0) goto L5;
        SkuMeta r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        BuyMeta r102 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        AddCartMeta r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        IMMeta r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        EnterShopMeta r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        EnterCartMeta r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        BottomTipMeta r107 = null;
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
