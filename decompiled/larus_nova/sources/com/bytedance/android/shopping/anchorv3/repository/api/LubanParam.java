package com.bytedance.android.shopping.anchorv3.repository.api;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\t\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\fR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/repository/api/LubanParam;", "Ljava/io/Serializable;", "productId", "", "pageId", "lubanStyle", "qianchuanAB", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLubanStyle", "()Ljava/lang/String;", "getPageId", "setPageId", "(Ljava/lang/String;)V", "getProductId", "setProductId", "getQianchuanAB", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class LubanParam implements Serializable {

    @SerializedName("luban_order_style")
    private final String lubanStyle;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PAGE_ID)
    private String pageId;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("qianchuan_ab")
    private final String qianchuanAB;

    public LubanParam() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ LubanParam copy$default(LubanParam r100, String r101, String r102, String r103, String r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.productId;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.pageId;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.lubanStyle;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.qianchuanAB;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.pageId;
    }

    public final String component3() {
        return this.lubanStyle;
    }

    public final String component4() {
        return this.qianchuanAB;
    }

    public final LubanParam copy(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "pageId");
        return new LubanParam(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LubanParam) == false) goto L14;
        LubanParam r101 = (LubanParam) r100;
        if (Intrinsics.areEqual(this.productId, r101.productId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.pageId, r101.pageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.lubanStyle, r101.lubanStyle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.qianchuanAB, r101.qianchuanAB) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r100 = this.productId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.pageId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.lubanStyle;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.qianchuanAB;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
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
        return "LubanParam(productId=" + this.productId + ", pageId=" + this.pageId + ", lubanStyle=" + this.lubanStyle + ", qianchuanAB=" + this.qianchuanAB + ")";
    }

    public final String getLubanStyle() {
        return this.lubanStyle;
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public final String getQianchuanAB() {
        return this.qianchuanAB;
    }

    public final void setPageId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.pageId = r100;
    }

    public final void setProductId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.productId = r100;
    }

    public LubanParam(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter(r100, "productId");
        Intrinsics.checkNotNullParameter(r101, "pageId");
        this.productId = r100;
        this.pageId = r101;
        this.lubanStyle = r102;
        this.qianchuanAB = r103;
    }

    public /* synthetic */ LubanParam(String r100, String r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = "";
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = "";
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
