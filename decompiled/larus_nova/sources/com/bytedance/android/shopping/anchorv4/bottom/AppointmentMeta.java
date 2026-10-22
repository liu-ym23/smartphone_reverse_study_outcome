package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005HÆ\u0003J[\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\u0010\u0010&\u001a\u00020\u00002\b\u0010'\u001a\u0004\u0018\u00010(J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0005HÖ\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f¨\u0006,"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/bottom/AppointmentMeta;", "Ljava/io/Serializable;", "isAppointment", "", "promotionId", "", "productId", "authorId", "secAuthorId", "itemId", "metaParam", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorId", "()Ljava/lang/String;", "setAuthorId", "(Ljava/lang/String;)V", "()Z", "getItemId", "setItemId", "getMetaParam", "setMetaParam", "getProductId", "setProductId", "getPromotionId", "setPromotionId", "getSecAuthorId", "setSecAuthorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "fillCommonMeta", "commonMeta", "Lcom/bytedance/android/shopping/anchorv4/dto/meta/CommonMeta;", "hashCode", "", "toString", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AppointmentMeta implements Serializable {
    private String authorId;

    @SerializedName("is_appointment")
    private final boolean isAppointment;
    private String itemId;
    private String metaParam;
    private String productId;
    private String promotionId;
    private String secAuthorId;

    public AppointmentMeta() {
        this(false, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ AppointmentMeta copy$default(AppointmentMeta r100, boolean r101, String r102, String r103, String r104, String r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.isAppointment;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.promotionId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.productId;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.authorId;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.secAuthorId;
    L17:
        String r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.itemId;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.metaParam;
    L23:
        boolean r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final boolean component1() {
        return this.isAppointment;
    }

    public final String component2() {
        return this.promotionId;
    }

    public final String component3() {
        return this.productId;
    }

    public final String component4() {
        return this.authorId;
    }

    public final String component5() {
        return this.secAuthorId;
    }

    public final String component6() {
        return this.itemId;
    }

    public final String component7() {
        return this.metaParam;
    }

    public final AppointmentMeta copy(boolean r110, String r111, String r112, String r113, String r114, String r115, String r116) {
        return new AppointmentMeta(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AppointmentMeta) == false) goto L20;
        AppointmentMeta r101 = (AppointmentMeta) r100;
        if (this.isAppointment == r101.isAppointment) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.promotionId, r101.promotionId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.metaParam, r101.metaParam) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    public int hashCode() {
        boolean r100 = this.isAppointment;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = r101 * 31;
        String r103 = this.promotionId;
        int r104 = 0;
        if (r103 == null) goto L8;
        int r105 = r103.hashCode();
    L9:
        int r106 = (r102 + r105) * 31;
        String r107 = this.productId;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.authorId;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.secAuthorId;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.itemId;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.metaParam;
        if (r119 == null) goto L29;
        r104 = r119.hashCode();
    L29:
        return r118 + r104;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L8:
        r105 = 0;
        goto L9
    }

    public String toString() {
        return "AppointmentMeta(isAppointment=" + this.isAppointment + ", promotionId=" + this.promotionId + ", productId=" + this.productId + ", authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", itemId=" + this.itemId + ", metaParam=" + this.metaParam + ")";
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getMetaParam() {
        return this.metaParam;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getPromotionId() {
        return this.promotionId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final boolean isAppointment() {
        return this.isAppointment;
    }

    public final AppointmentMeta fillCommonMeta(CommonMeta r100) {
        String r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getPromotionId();
    L6:
        this.promotionId = r102;
        if (r100 == null) goto L9;
        String r103 = r100.getProductId();
    L10:
        this.productId = r103;
        if (r100 == null) goto L13;
        String r104 = r100.getAuthorId();
    L14:
        this.authorId = r104;
        if (r100 == null) goto L17;
        String r105 = r100.getSecAuthorId();
    L18:
        this.secAuthorId = r105;
        if (r100 == null) goto L21;
        String r106 = r100.getItemId();
    L22:
        this.itemId = r106;
        if (r100 == null) goto L25;
        r101 = r100.getMetaParam();
    L25:
        this.metaParam = r101;
        return this;
    L21:
        r106 = null;
        goto L22
    L17:
        r105 = null;
        goto L18
    L13:
        r104 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public final void setAuthorId(String r100) {
        this.authorId = r100;
    }

    public final void setItemId(String r100) {
        this.itemId = r100;
    }

    public final void setMetaParam(String r100) {
        this.metaParam = r100;
    }

    public final void setProductId(String r100) {
        this.productId = r100;
    }

    public final void setPromotionId(String r100) {
        this.promotionId = r100;
    }

    public final void setSecAuthorId(String r100) {
        this.secAuthorId = r100;
    }

    public AppointmentMeta(boolean r100, String r101, String r102, String r103, String r104, String r105, String r106) {
        this.isAppointment = r100;
        this.promotionId = r101;
        this.productId = r102;
        this.authorId = r103;
        this.secAuthorId = r104;
        this.itemId = r105;
        this.metaParam = r106;
    }

    public /* synthetic */ AppointmentMeta(boolean r100, String r101, String r102, String r103, String r110, String r111, String r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = false;
    L5:
        String r104 = null;
        if ((r113 & 2) == 0) goto L8;
        String r115 = null;
    L10:
        if ((r113 & 4) == 0) goto L12;
        String r105 = null;
    L14:
        if ((r113 & 8) == 0) goto L16;
        String r106 = null;
    L18:
        if ((r113 & 16) == 0) goto L20;
        String r107 = null;
    L22:
        if ((r113 & 32) == 0) goto L24;
        String r108 = null;
    L26:
        if ((r113 & 64) != 0) goto L29;
        r104 = r112;
    L29:
        this(r100, r115, r105, r106, r107, r108, r104);
        return;
    L24:
        r108 = r111;
        goto L26
    L20:
        r107 = r110;
        goto L22
    L16:
        r106 = r103;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L8:
        r115 = r101;
        goto L10
    }
}
