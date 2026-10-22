package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.GetPresetCardResponse.Data")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/e;", "", "", "hasSet", "Z", "d", "()Z", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "cacheImage", "getCacheImage", "cacheTitle", "getCacheTitle", "isProduct", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", ce.f26391f, "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "iconBackgroundColor", "e", "textPosterTitleColor", "h", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e implements vh7.h {

    @SerializedName("image_cache")
    protected ImageModel cacheImage;

    @SerializedName("title_cache")
    protected String cacheTitle;

    @SerializedName("has_set")
    protected boolean hasSet;

    @SerializedName("RGB")
    protected String iconBackgroundColor;

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("is_product")
    protected boolean isProduct;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("word_RGB")
    protected String textPosterTitleColor;

    @SerializedName("title")
    protected String title;

    public e(boolean r100, ImageModel r101, String r102, ImageModel r103, String r104, boolean r105, ProductInfo r106, String r107, String r108) {
        this.hasSet = r100;
        this.image = r101;
        this.title = r102;
        this.cacheImage = r103;
        this.cacheTitle = r104;
        this.isProduct = r105;
        this.productInfo = r106;
        this.iconBackgroundColor = r107;
        this.textPosterTitleColor = r108;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e) == false) goto L24;
        e r101 = (e) r100;
        if (this.hasSet == r101.hasSet) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.cacheImage, r101.cacheImage) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.cacheTitle, r101.cacheTitle) == true) goto L16;
        return false;
    L16:
        if (this.isProduct == r101.isProduct) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.iconBackgroundColor, r101.iconBackgroundColor) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.textPosterTitleColor, r101.textPosterTitleColor) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    public final int hashCode() {
        boolean r100 = this.hasSet;
        ?? r101 = 1;
        ?? r102 = r100;
        if (r100 == false) goto L5;
        r102 = 1;
    L5:
        int r103 = r102 * 31;
        ImageModel r104 = this.image;
        int r105 = 0;
        if (r104 == null) goto L8;
        int r106 = r104.hashCode();
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.title;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        ImageModel r111 = this.cacheImage;
        if (r111 == null) goto L16;
        int r112 = r111.hashCode();
    L17:
        int r113 = (r110 + r112) * 31;
        String r114 = this.cacheTitle;
        if (r114 == null) goto L20;
        int r115 = r114.hashCode();
    L21:
        int r116 = (r113 + r115) * 31;
        boolean r117 = this.isProduct;
        if (r117 == true) goto L25;
        r101 = r117;
    L25:
        int r118 = (r116 + r101) * 31;
        ProductInfo r119 = this.productInfo;
        if (r119 == null) goto L28;
        int r120 = r119.hashCode();
    L29:
        int r121 = (r118 + r120) * 31;
        String r122 = this.iconBackgroundColor;
        if (r122 == null) goto L32;
        int r123 = r122.hashCode();
    L33:
        int r124 = (r121 + r123) * 31;
        String r125 = this.textPosterTitleColor;
        if (r125 == null) goto L37;
        r105 = r125.hashCode();
    L37:
        return r124 + r105;
    L32:
        r123 = 0;
        goto L33
    L28:
        r120 = 0;
        goto L29
    L20:
        r115 = 0;
        goto L21
    L16:
        r112 = 0;
        goto L17
    L12:
        r109 = 0;
        goto L13
    L8:
        r106 = 0;
        goto L9
    }

    public final String toString() {
        return "GetPresetCardResponse(hasSet=" + this.hasSet + ", image=" + this.image + ", title=" + this.title + ", cacheImage=" + this.cacheImage + ", cacheTitle=" + this.cacheTitle + ", isProduct=" + this.isProduct + ", productInfo=" + this.productInfo + ", iconBackgroundColor=" + this.iconBackgroundColor + ", textPosterTitleColor=" + this.textPosterTitleColor + ")";
    }

    public final String b() {
        ImageModel r100 = this.cacheImage;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r101);
    L7:
        return null;
    }

    public final String c() {
        String r100 = this.title;
        String r101 = this.cacheTitle;
        if (r101 != null) goto L5;
    L11:
        if (r100 != null) goto L13;
        return null;
    L13:
        if ((!StringsKt.isBlank(r100)) == true) goto L15;
        return null;
    L15:
        return r100;
    L5:
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L11;
        r100 = r101;
        goto L11
    }

    public final String f() {
        ImageModel r100 = this.image;
        if (r100 == null) goto L7;
        List<String> r101 = r100.getUrls();
        if (r101 == null) goto L7;
        return (String) CollectionsKt.firstOrNull(r101);
    L7:
        return null;
    }

    public final boolean i() {
        ImageModel r100 = this.cacheImage;
        String r101 = null;
        if (r100 == null) goto L14;
        List<String> r102 = r100.getUrls();
        if (r102 == null) goto L14;
        String r103 = (String) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L14;
        if (r103.length() <= 0) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L14;
        r101 = r103;
        goto L14
    L11:
        r104 = false;
    L14:
        if (r101 != null) goto L18;
        return false;
    L18:
        return true;
    }

    public final boolean j() {
        String r100 = this.cacheTitle;
        if (r100 != null) goto L5;
    L7:
        r100 = null;
    L8:
        if (r100 != null) goto L12;
        return false;
    L12:
        return true;
    L5:
        if ((!StringsKt.isBlank(r100)) == false) goto L7;
        goto L7
    }

    public e() {
        this.hasSet = false;
        this.image = null;
        this.title = null;
        this.cacheImage = null;
        this.cacheTitle = null;
        this.isProduct = false;
        this.productInfo = null;
        this.iconBackgroundColor = null;
        this.textPosterTitleColor = null;
    }

    public final boolean d() {
        return this.hasSet;
    }

    public final String e() {
        return this.iconBackgroundColor;
    }

    public final ProductInfo g() {
        return this.productInfo;
    }

    public final String h() {
        return this.textPosterTitleColor;
    }

    public e(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L20;
        if (r103 != 10) goto L8;
        this.iconBackgroundColor = am3.h.c(r100);
        goto L3
    L8:
        if (r103 != 12) goto L9;
        this.textPosterTitleColor = am3.h.c(r100);
        goto L3
    L9:
        switch(r103) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            default: goto L10;
        };
    L11:
        this.productInfo = new ProductInfo(r100);
        goto L3
    L12:
        this.isProduct = am3.h.a(r100);
        r102 = r102 | 2;
        goto L3
    L13:
        this.cacheTitle = am3.h.c(r100);
        goto L3
    L14:
        this.cacheImage = x.a(r100);
        goto L3
    L15:
        this.title = am3.h.c(r100);
        goto L3
    L16:
        this.image = x.a(r100);
        goto L3
    L17:
        this.hasSet = am3.h.a(r100);
        r102 = r102 | 1;
        goto L3
    L10:
        am3.h.e(r100);
        goto L3
    L20:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L24;
        this.hasSet = false;
    L24:
        if (this.image != null) goto L27;
        this.image = null;
    L27:
        if (this.title != null) goto L30;
        this.title = null;
    L30:
        if (this.cacheImage != null) goto L33;
        this.cacheImage = null;
    L33:
        if (this.cacheTitle != null) goto L36;
        this.cacheTitle = null;
    L36:
        if ((r102 & 2) != 0) goto L39;
        this.isProduct = false;
    L39:
        if (this.productInfo != null) goto L42;
        this.productInfo = null;
    L42:
        if (this.iconBackgroundColor != null) goto L45;
        this.iconBackgroundColor = null;
    L45:
        if (this.textPosterTitleColor != null) goto L72;
        this.textPosterTitleColor = null;
        return;
    }

    public static e a(e r110, ProductInfo r111) {
        boolean r100 = r110.hasSet;
        ImageModel r101 = r110.image;
        String r102 = r110.title;
        ImageModel r103 = r110.cacheImage;
        String r104 = r110.cacheTitle;
        boolean r105 = r110.isProduct;
        String r106 = r110.iconBackgroundColor;
        String r107 = r110.textPosterTitleColor;
        r110.getClass();
        return new e(r100, r101, r102, r103, r104, r105, r111, r106, r107);
    }
}
