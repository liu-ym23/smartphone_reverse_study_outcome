package com.bytedance.android.window.shop.repository.dto;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/window/shop/repository/dto/b0;", "", "Lcom/bytedance/android/window/shop/repository/dto/j;", "video", "Lcom/bytedance/android/window/shop/repository/dto/j;", "e", "()Lcom/bytedance/android/window/shop/repository/dto/j;", "Lcom/bytedance/android/window/shop/repository/dto/s;", "product", "Lcom/bytedance/android/window/shop/repository/dto/s;", "c", "()Lcom/bytedance/android/window/shop/repository/dto/s;", "", ShareChannel.DOUYIN, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "showProductDetail", "Ljava/lang/Boolean;", "d", "()Ljava/lang/Boolean;", "continuePlay", "b", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 {

    @SerializedName(ShareChannel.DOUYIN)
    private final String aweme;

    @SerializedName("is_continue_play")
    private final Boolean continuePlay;

    @SerializedName("product")
    private final s product;

    @SerializedName("show_product_detail")
    private final Boolean showProductDetail;

    @SerializedName("video")
    private final j video;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b0) == false) goto L16;
        b0 r101 = (b0) r100;
        if (Intrinsics.areEqual(this.video, r101.video) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.aweme, r101.aweme) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showProductDetail, r101.showProductDetail) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.continuePlay, r101.continuePlay) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        j r100 = this.video;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        s r104 = this.product;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.aweme;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.showProductDetail;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.continuePlay;
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

    public final String toString() {
        return "WindowHangingProductVideoDTO(video=" + this.video + ", product=" + this.product + ", aweme=" + this.aweme + ", showProductDetail=" + this.showProductDetail + ", continuePlay=" + this.continuePlay + ")";
    }

    public final String a() {
        return this.aweme;
    }

    public final Boolean b() {
        return this.continuePlay;
    }

    public final s c() {
        return this.product;
    }

    public final Boolean d() {
        return this.showProductDetail;
    }

    public final j e() {
        return this.video;
    }
}
