package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.window.base.repository.dto.WindowV2ProductItemDTO;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010!8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010&\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001c\u0010(\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014R\u001c\u0010*\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b*\u0010\u000b\u001a\u0004\b+\u0010\r¨\u0006,"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/d1;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "cover", "Lcom/bytedance/android/ec/model/ECUrlModel;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/model/ECUrlModel;", "subIcon", "getSubIcon", "", "createTime", "Ljava/lang/Long;", "getCreateTime", "()Ljava/lang/Long;", "duration", "c", "", "subTitle", "Ljava/lang/String;", "getSubTitle", "()Ljava/lang/String;", "jumpUrl", "d", "videoId", "h", "", "Lcom/bytedance/android/ec/window/base/repository/dto/WindowV2ProductItemDTO;", "products", "Ljava/util/List;", "f", "()Ljava/util/List;", "descriptions", "b", "", "buyShareId", "Ljava/lang/Integer;", "getBuyShareId", "()Ljava/lang/Integer;", "title", ce.f26391f, "content", "getContent", "jumpVideoId", "e", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d1 {

    @SerializedName("buy_share_id")
    private final Integer buyShareId;

    @SerializedName("content")
    private final String content;

    @SerializedName("cover")
    private final ECUrlModel cover;

    @SerializedName("createTime")
    private final Long createTime;

    @SerializedName("description")
    private final List<String> descriptions;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("video_id")
    private final Long jumpVideoId;

    @SerializedName("products")
    private final List<WindowV2ProductItemDTO> products;

    @SerializedName("sub_icon")
    private final ECUrlModel subIcon;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private final String subTitle;

    @SerializedName("title")
    private final String title;

    @SerializedName("item_id")
    private final String videoId;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d1) == false) goto L32;
        d1 r101 = (d1) r100;
        if (Intrinsics.areEqual(this.cover, r101.cover) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subIcon, r101.subIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.createTime, r101.createTime) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.duration, r101.duration) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.subTitle, r101.subTitle) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoId, r101.videoId) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.products, r101.products) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.descriptions, r101.descriptions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.buyShareId, r101.buyShareId) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.jumpVideoId, r101.jumpVideoId) == true) goto L49;
        return false;
    L49:
        return true;
    L32:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.cover;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.subIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.createTime;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Long r110 = this.duration;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.subTitle;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.jumpUrl;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.videoId;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<WindowV2ProductItemDTO> r122 = this.products;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<String> r125 = this.descriptions;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        Integer r128 = this.buyShareId;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        String r131 = this.title;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.content;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        Long r137 = this.jumpVideoId;
        if (r137 == null) goto L54;
        r101 = r137.hashCode();
    L54:
        return r136 + r101;
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
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

    public final String toString() {
        return "WindowVideoItemDTO(cover=" + this.cover + ", subIcon=" + this.subIcon + ", createTime=" + this.createTime + ", duration=" + this.duration + ", subTitle=" + this.subTitle + ", jumpUrl=" + this.jumpUrl + ", videoId=" + this.videoId + ", products=" + this.products + ", descriptions=" + this.descriptions + ", buyShareId=" + this.buyShareId + ", title=" + this.title + ", content=" + this.content + ", jumpVideoId=" + this.jumpVideoId + ")";
    }

    public d1() {
        this.cover = null;
        this.subIcon = null;
        this.createTime = null;
        this.duration = null;
        this.subTitle = null;
        this.jumpUrl = null;
        this.videoId = null;
        this.products = null;
        this.descriptions = null;
        this.buyShareId = null;
        this.title = null;
        this.content = null;
        this.jumpVideoId = null;
    }

    public final ECUrlModel a() {
        return this.cover;
    }

    public final List<String> b() {
        return this.descriptions;
    }

    public final Long c() {
        return this.duration;
    }

    public final String d() {
        return this.jumpUrl;
    }

    public final Long e() {
        return this.jumpVideoId;
    }

    public final List<WindowV2ProductItemDTO> f() {
        return this.products;
    }

    public final String g() {
        return this.title;
    }

    public final String h() {
        return this.videoId;
    }
}
