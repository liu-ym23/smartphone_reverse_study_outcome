package com.bytedance.android.ec.model.sku;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jb\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0007\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lcom/bytedance/android/ec/model/sku/SkuProductContext;", "Ljava/io/Serializable;", "authorId", "", "secAuthorId", "marketingChannel", "roomId", "isGroupBuy", "", "orderUrl", "itemId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorId", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getItemId", "getMarketingChannel", "getOrderUrl", "getRoomId", "getSecAuthorId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lcom/bytedance/android/ec/model/sku/SkuProductContext;", "equals", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class SkuProductContext implements Serializable {

    @SerializedName("author_id")
    private final String authorId;

    @SerializedName("is_group_buy")
    private final Boolean isGroupBuy;

    @SerializedName("item_id")
    private final String itemId;

    @SerializedName(a.KEY_MARKET_CHANNEL)
    private final String marketingChannel;

    @SerializedName("order_url")
    private final String orderUrl;

    @SerializedName("room_id")
    private final String roomId;

    @SerializedName("sec_author_id")
    private final String secAuthorId;

    public SkuProductContext() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public static /* synthetic */ SkuProductContext copy$default(SkuProductContext r100, String r101, String r102, String r103, String r104, Boolean r110, String r111, String r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.authorId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.secAuthorId;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.marketingChannel;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.roomId;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.isGroupBuy;
    L17:
        Boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.orderUrl;
    L20:
        String r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.itemId;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.authorId;
    }

    public final String component2() {
        return this.secAuthorId;
    }

    public final String component3() {
        return this.marketingChannel;
    }

    public final String component4() {
        return this.roomId;
    }

    public final Boolean component5() {
        return this.isGroupBuy;
    }

    public final String component6() {
        return this.orderUrl;
    }

    public final String component7() {
        return this.itemId;
    }

    public final SkuProductContext copy(String r110, String r111, String r112, String r113, Boolean r114, String r115, String r116) {
        return new SkuProductContext(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SkuProductContext) == false) goto L20;
        SkuProductContext r101 = (SkuProductContext) r100;
        if (Intrinsics.areEqual(this.authorId, r101.authorId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.secAuthorId, r101.secAuthorId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.marketingChannel, r101.marketingChannel) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.roomId, r101.roomId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.isGroupBuy, r101.isGroupBuy) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.orderUrl, r101.orderUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.itemId, r101.itemId) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    public int hashCode() {
        String r100 = this.authorId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.secAuthorId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.marketingChannel;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.roomId;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.isGroupBuy;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.orderUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.itemId;
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
        return "SkuProductContext(authorId=" + this.authorId + ", secAuthorId=" + this.secAuthorId + ", marketingChannel=" + this.marketingChannel + ", roomId=" + this.roomId + ", isGroupBuy=" + this.isGroupBuy + ", orderUrl=" + this.orderUrl + ", itemId=" + this.itemId + ")";
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final String getMarketingChannel() {
        return this.marketingChannel;
    }

    public final String getOrderUrl() {
        return this.orderUrl;
    }

    public final String getRoomId() {
        return this.roomId;
    }

    public final String getSecAuthorId() {
        return this.secAuthorId;
    }

    public final Boolean isGroupBuy() {
        return this.isGroupBuy;
    }

    public SkuProductContext(String r100, String r101, String r102, String r103, Boolean r104, String r105, String r106) {
        this.authorId = r100;
        this.secAuthorId = r101;
        this.marketingChannel = r102;
        this.roomId = r103;
        this.isGroupBuy = r104;
        this.orderUrl = r105;
        this.itemId = r106;
    }

    public /* synthetic */ SkuProductContext(String r100, String r101, String r102, String r110, Boolean r111, String r112, String r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        String r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r103 = null;
    L11:
        if ((r114 & 4) == 0) goto L13;
        String r104 = null;
    L15:
        if ((r114 & 8) == 0) goto L17;
        String r105 = null;
    L19:
        if ((r114 & 16) == 0) goto L21;
        Boolean r106 = null;
    L23:
        if ((r114 & 32) == 0) goto L25;
        String r107 = null;
    L27:
        if ((r114 & 64) == 0) goto L29;
        String r117 = null;
    L30:
        this(r116, r103, r104, r105, r106, r107, r117);
        return;
    L29:
        r117 = r113;
        goto L30
    L25:
        r107 = r112;
        goto L27
    L21:
        r106 = r111;
        goto L23
    L17:
        r105 = r110;
        goto L19
    L13:
        r104 = r102;
        goto L15
    L9:
        r103 = r101;
        goto L11
    L5:
        r116 = r100;
        goto L7
    }
}
