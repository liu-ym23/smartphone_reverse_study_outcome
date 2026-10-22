package com.bytedance.android.window.shop.repository.dto;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/t;", "", "", "mainTitleDouble", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "subTitleDouble", "h", "mainTitleSingle", "f", "subTitleSingle", RXScreenCaptureService.KEY_INDEX, "jumpUrl", "d", "Lcom/bytedance/android/window/shop/repository/dto/f;", "image0", "Lcom/bytedance/android/window/shop/repository/dto/f;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/window/shop/repository/dto/f;", "image1", "b", "image2", "c", "Lcom/bytedance/android/window/shop/repository/dto/j;", "video", "Lcom/bytedance/android/window/shop/repository/dto/j;", ce.f26395j, "()Lcom/bytedance/android/window/shop/repository/dto/j;", "Lcom/bytedance/android/window/shop/repository/dto/s;", "product", "Lcom/bytedance/android/window/shop/repository/dto/s;", ce.f26391f, "()Lcom/bytedance/android/window/shop/repository/dto/s;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("image0")
    private final f image0;

    @SerializedName("image1")
    private final f image1;

    @SerializedName("image2")
    private final f image2;

    @SerializedName("jump_url")
    private final String jumpUrl;

    @SerializedName("sl_main_title")
    private final String mainTitleDouble;

    @SerializedName("dl_main_title")
    private final String mainTitleSingle;

    @SerializedName("product")
    private final s product;

    @SerializedName("sl_subtitle")
    private final String subTitleDouble;

    @SerializedName("dl_subtitle")
    private final String subTitleSingle;

    @SerializedName("video")
    private final j video;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof t) == false) goto L26;
        t r101 = (t) r100;
        if (Intrinsics.areEqual(this.mainTitleDouble, r101.mainTitleDouble) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.subTitleDouble, r101.subTitleDouble) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.mainTitleSingle, r101.mainTitleSingle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.subTitleSingle, r101.subTitleSingle) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.jumpUrl, r101.jumpUrl) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.image0, r101.image0) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.image1, r101.image1) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.image2, r101.image2) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        String r100 = this.mainTitleDouble;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.subTitleDouble;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.mainTitleSingle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.subTitleSingle;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.jumpUrl;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        f r116 = this.image0;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        f r119 = this.image1;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        f r122 = this.image2;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        j r125 = this.video;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        s r128 = this.product;
        if (r128 == null) goto L42;
        r101 = r128.hashCode();
    L42:
        return r127 + r101;
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
        return "WindowExplainProductVideoDTO(mainTitleDouble=" + this.mainTitleDouble + ", subTitleDouble=" + this.subTitleDouble + ", mainTitleSingle=" + this.mainTitleSingle + ", subTitleSingle=" + this.subTitleSingle + ", jumpUrl=" + this.jumpUrl + ", image0=" + this.image0 + ", image1=" + this.image1 + ", image2=" + this.image2 + ", video=" + this.video + ", product=" + this.product + ")";
    }

    public final f a() {
        return this.image0;
    }

    public final f b() {
        return this.image1;
    }

    public final f c() {
        return this.image2;
    }

    public final String d() {
        return this.jumpUrl;
    }

    public final String e() {
        return this.mainTitleDouble;
    }

    public final String f() {
        return this.mainTitleSingle;
    }

    public final s g() {
        return this.product;
    }

    public final String h() {
        return this.subTitleDouble;
    }

    public final String i() {
        return this.subTitleSingle;
    }

    public final j j() {
        return this.video;
    }
}
