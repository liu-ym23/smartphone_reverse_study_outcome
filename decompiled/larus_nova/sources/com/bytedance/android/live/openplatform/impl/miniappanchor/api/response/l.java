package com.bytedance.android.live.openplatform.impl.miniappanchor.api.response;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.x;
import com.bytedance.android.live.openplatform.api.model.shelf.ProductInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@ProtoMessage("webcast.api.stamp.PresetCard")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/miniappanchor/api/response/l;", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "image", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImage", "()Lcom/bytedance/android/live/base/model/ImageModel;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "schema", "getSchema", "sourcePath", "getSourcePath", "", "isProduct", "Z", "()Z", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "productInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "getProductInfo", "()Lcom/bytedance/android/live/openplatform/api/model/shelf/ProductInfo;", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class l implements vh7.h {

    @SerializedName("image")
    protected ImageModel image;

    @SerializedName("is_product")
    protected boolean isProduct;

    @SerializedName("product_info")
    protected ProductInfo productInfo;

    @SerializedName("schema")
    protected String schema;

    @SerializedName("source_path")
    protected String sourcePath;

    @SerializedName("title")
    protected String title;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof l) == false) goto L18;
        l r101 = (l) r100;
        if (Intrinsics.areEqual(this.image, r101.image) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.schema, r101.schema) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourcePath, r101.sourcePath) == true) goto L14;
        return false;
    L14:
        if (this.isProduct == r101.isProduct) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.productInfo, r101.productInfo) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v16 */
    public final int hashCode() {
        ImageModel r100 = this.image;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.title;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.schema;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sourcePath;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        boolean r113 = this.isProduct;
        ?? r114 = r113;
        if (r113 == false) goto L21;
        r114 = 1;
    L21:
        int r115 = (r112 + r114) * 31;
        ProductInfo r116 = this.productInfo;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        return r115 + r101;
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
        return "PresetCard(image=" + this.image + ", title=" + this.title + ", schema=" + this.schema + ", sourcePath=" + this.sourcePath + ", isProduct=" + this.isProduct + ", productInfo=" + this.productInfo + ")";
    }

    public l() {
        this.image = null;
        this.title = null;
        this.schema = null;
        this.sourcePath = null;
        this.isProduct = false;
        this.productInfo = null;
    }

    public l(am3.g r100) {
        long r101 = r100.c();
        boolean r102 = false;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.productInfo = new ProductInfo(r100);
        goto L3
    L8:
        this.isProduct = am3.h.a(r100);
        r102 = r102 | true;
        goto L3
    L9:
        this.sourcePath = am3.h.c(r100);
        goto L3
    L10:
        this.schema = am3.h.c(r100);
        goto L3
    L11:
        this.title = am3.h.c(r100);
        goto L3
    L12:
        this.image = x.a(r100);
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if (this.image != null) goto L17;
        this.image = null;
    L17:
        if (this.title != null) goto L20;
        this.title = null;
    L20:
        if (this.schema != null) goto L23;
        this.schema = null;
    L23:
        if (this.sourcePath != null) goto L26;
        this.sourcePath = null;
    L26:
        if ((r102 & true) == true) goto L29;
        this.isProduct = false;
    L29:
        if (this.productInfo != null) goto L48;
        this.productInfo = null;
        return;
    }
}
