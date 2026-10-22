package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002Be\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b7\u00108J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jg\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\u0013\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010#R\u001a\u0010\u0013\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010*\u001a\u0004\b-\u0010,R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010.\u001a\u0004\b/\u00100R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u00101\u001a\u0004\b2\u00103R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00104\u001a\u0004\b5\u00106¨\u00069"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECPromotionCheckResponse;", "Lcom/bytedance/android/ec/model/g;", "Ljava/io/Serializable;", "", "component1", "", "component2", "Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "component3", "Lsl/g;", "component4", "component5", "Lcom/bytedance/android/ec/model/response/n;", "component6", "Lcom/bytedance/android/ec/model/response/ECEditCartParams;", "component7", "Lcom/bytedance/android/ec/model/response/UltimateBuy;", "component8", "orderUrl", "skip", "jumpDestination", "action", "diffAction", "addCartParams", "editCartParams", "ultimateBuy", "copy", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getOrderUrl", "()Ljava/lang/String;", "I", "getSkip", "()I", "Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "getJumpDestination", "()Lcom/bytedance/android/ec/model/response/ECJumpDestination;", "Lsl/g;", "getAction", "()Lsl/g;", "getDiffAction", "Lcom/bytedance/android/ec/model/response/n;", "getAddCartParams", "()Lcom/bytedance/android/ec/model/response/n;", "Lcom/bytedance/android/ec/model/response/ECEditCartParams;", "getEditCartParams", "()Lcom/bytedance/android/ec/model/response/ECEditCartParams;", "Lcom/bytedance/android/ec/model/response/UltimateBuy;", "getUltimateBuy", "()Lcom/bytedance/android/ec/model/response/UltimateBuy;", "<init>", "(Ljava/lang/String;ILcom/bytedance/android/ec/model/response/ECJumpDestination;Lsl/g;Lsl/g;Lcom/bytedance/android/ec/model/response/n;Lcom/bytedance/android/ec/model/response/ECEditCartParams;Lcom/bytedance/android/ec/model/response/UltimateBuy;)V", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECPromotionCheckResponse extends com.bytedance.android.ec.model.g implements Serializable {

    @SerializedName("action")
    private final sl.g action;

    @SerializedName("add_cart_param")
    private final n addCartParams;

    @SerializedName("diff_action")
    private final sl.g diffAction;

    @SerializedName("edit_cart_param")
    private final ECEditCartParams editCartParams;

    @SerializedName("jump_destination")
    private final ECJumpDestination jumpDestination;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("skip_style")
    private final int skip;

    @SerializedName("ultimate_buy")
    private final UltimateBuy ultimateBuy;

    public ECPromotionCheckResponse() {
        this(null, 0, null, null, null, null, null, null, 255, null);
    }

    public static /* synthetic */ ECPromotionCheckResponse copy$default(ECPromotionCheckResponse r100, String r110, int r111, ECJumpDestination r112, sl.g r113, sl.g r114, n r115, ECEditCartParams r116, UltimateBuy r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.orderUrl;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = r100.skip;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ECJumpDestination r103 = r100.jumpDestination;
    L15:
        if ((r118 & 8) == 0) goto L17;
        sl.g r104 = r100.action;
    L19:
        if ((r118 & 16) == 0) goto L21;
        sl.g r105 = r100.diffAction;
    L23:
        if ((r118 & 32) == 0) goto L25;
        n r106 = r100.addCartParams;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ECEditCartParams r107 = r100.editCartParams;
    L31:
        if ((r118 & 128) == 0) goto L33;
        UltimateBuy r108 = r100.ultimateBuy;
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

    public final String component1() {
        return this.orderUrl;
    }

    public final int component2() {
        return this.skip;
    }

    public final ECJumpDestination component3() {
        return this.jumpDestination;
    }

    public final sl.g component4() {
        return this.action;
    }

    public final sl.g component5() {
        return this.diffAction;
    }

    public final n component6() {
        return this.addCartParams;
    }

    public final ECEditCartParams component7() {
        return this.editCartParams;
    }

    public final UltimateBuy component8() {
        return this.ultimateBuy;
    }

    public final ECPromotionCheckResponse copy(String r110, int r111, ECJumpDestination r112, sl.g r113, sl.g r114, n r115, ECEditCartParams r116, UltimateBuy r117) {
        return new ECPromotionCheckResponse(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECPromotionCheckResponse) == false) goto L22;
        ECPromotionCheckResponse r101 = (ECPromotionCheckResponse) r100;
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L8;
        return false;
    L8:
        if (this.skip == r101.skip) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.jumpDestination, r101.jumpDestination) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.diffAction, r101.diffAction) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.addCartParams, r101.addCartParams) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.editCartParams, r101.editCartParams) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.ultimateBuy, r101.ultimateBuy) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        String r100 = this.orderUrl;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.skip) * 31;
        ECJumpDestination r104 = this.jumpDestination;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        sl.g r107 = this.action;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        sl.g r110 = this.diffAction;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        n r113 = this.addCartParams;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        ECEditCartParams r116 = this.editCartParams;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        UltimateBuy r119 = this.ultimateBuy;
        if (r119 == null) goto L30;
        r101 = r119.hashCode();
    L30:
        return r118 + r101;
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
        return "ECPromotionCheckResponse(orderUrl=" + this.orderUrl + ", skip=" + this.skip + ", jumpDestination=" + this.jumpDestination + ", action=" + this.action + ", diffAction=" + this.diffAction + ", addCartParams=" + this.addCartParams + ", editCartParams=" + this.editCartParams + ", ultimateBuy=" + this.ultimateBuy + ")";
    }

    public final sl.g getAction() {
        return this.action;
    }

    public final n getAddCartParams() {
        return this.addCartParams;
    }

    public final sl.g getDiffAction() {
        return this.diffAction;
    }

    public final ECEditCartParams getEditCartParams() {
        return this.editCartParams;
    }

    public final ECJumpDestination getJumpDestination() {
        return this.jumpDestination;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final int getSkip() {
        return this.skip;
    }

    public final UltimateBuy getUltimateBuy() {
        return this.ultimateBuy;
    }

    public ECPromotionCheckResponse(String r100, int r101, ECJumpDestination r102, sl.g r103, sl.g r104, n r105, ECEditCartParams r106, UltimateBuy r107) {
        this.orderUrl = r100;
        this.skip = r101;
        this.jumpDestination = r102;
        this.action = r103;
        this.diffAction = r104;
        this.addCartParams = r105;
        this.editCartParams = r106;
        this.ultimateBuy = r107;
    }

    public /* synthetic */ ECPromotionCheckResponse(String r110, int r111, ECJumpDestination r112, sl.g r113, sl.g r114, n r115, ECEditCartParams r116, UltimateBuy r117, int r118, DefaultConstructorMarker r119) {
        UltimateBuy r100 = null;
        if ((r118 & 1) == 0) goto L5;
        String r101 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        int r102 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        ECJumpDestination r103 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        sl.g r104 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        sl.g r105 = null;
    L23:
        if ((r118 & 32) == 0) goto L25;
        n r106 = null;
    L27:
        if ((r118 & 64) == 0) goto L29;
        ECEditCartParams r107 = null;
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
