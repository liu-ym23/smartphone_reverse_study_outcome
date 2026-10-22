package com.bytedance.android.window.shop.repository.tab.entity;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.hybrid.list.entity.dto.SSRDataDecodingFormat;
import com.bytedance.android.window.shop.repository.dto.v0;
import com.bytedance.android.window.shop.repository.dto.w0;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class v extends f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f189634n = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f189635j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f189636k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f189637l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public d f189638m;

    public static final class a {
        public static v a(v0 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "dto");
            if (r100.e() == true) goto L6;
            return null;
        L6:
            v r102 = new v(r101);
            r102.f189635j = r100.b();
            w0 r103 = r100.d();
            if (r103 == null) goto L9;
            int r104 = d.f189639a;
            Intrinsics.checkNotNullParameter(r103, "dto");
            r102.f189638m = new d(r103.c(), r103.a(), r103.b(), r103.d());
        L9:
            String r105 = r100.a();
            if (r105 == null) goto L12;
            r102.f189636k = (b) u0.b(r105, b.class);
        L12:
            return r102;
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$b;", "", "", "lynxSchema", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setLynxSchema", "(Ljava/lang/String;)V", "", "predictHeight", "I", "getPredictHeight", "()I", "setPredictHeight", "(I)V", "fixedHeight", "getFixedHeight", "setFixedHeight", "", "spanRatio", FaceService.girlLabel, "d", "()F", "setSpanRatio", "(F)V", "", "formModifiable", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setFormModifiable", "(Ljava/lang/Boolean;)V", "Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "edge", "Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "setEdge", "(Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("edge")
        private c edge;

        @SerializedName("fixed_height")
        private int fixedHeight;

        @SerializedName("form_modifiable")
        private Boolean formModifiable;

        @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
        private String lynxSchema;

        @SerializedName("predict_height")
        private int predictHeight;

        @SerializedName("span_ratio")
        private float spanRatio;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L18;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.lynxSchema, r101.lynxSchema) == true) goto L8;
            return false;
        L8:
            if (this.predictHeight == r101.predictHeight) goto L10;
            return false;
        L10:
            if (this.fixedHeight == r101.fixedHeight) goto L12;
            return false;
        L12:
            if (Float.compare(this.spanRatio, r101.spanRatio) == 0) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.formModifiable, r101.formModifiable) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.edge, r101.edge) == true) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        public final int hashCode() {
            String r100 = this.lynxSchema;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = ((((((r102 * 31) + this.predictHeight) * 31) + this.fixedHeight) * 31) + Float.floatToIntBits(this.spanRatio)) * 31;
            Boolean r104 = this.formModifiable;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            c r107 = this.edge;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "ShopLynxItemConfigVO(lynxSchema=" + this.lynxSchema + ", predictHeight=" + this.predictHeight + ", fixedHeight=" + this.fixedHeight + ", spanRatio=" + this.spanRatio + ", formModifiable=" + this.formModifiable + ", edge=" + this.edge + ")";
        }

        public b() {
            Boolean r100 = Boolean.FALSE;
            this.lynxSchema = null;
            this.predictHeight = 0;
            this.fixedHeight = 0;
            this.spanRatio = 1.0f;
            this.formModifiable = r100;
            this.edge = null;
        }

        public final c a() {
            return this.edge;
        }

        public final Boolean b() {
            return this.formModifiable;
        }

        public final String c() {
            return this.lynxSchema;
        }

        public final float d() {
            return this.spanRatio;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$c;", "", "", "left", "I", "b", "()I", "setLeft", "(I)V", "top", "d", "setTop", "right", "c", "setRight", "bottom", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setBottom", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("bottom")
        private int bottom;

        @SerializedName("left")
        private int left;

        @SerializedName("right")
        private int right;

        @SerializedName("top")
        private int top;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof c) == false) goto L14;
            c r101 = (c) r100;
            if (this.left == r101.left) goto L8;
            return false;
        L8:
            if (this.top == r101.top) goto L10;
            return false;
        L10:
            if (this.right == r101.right) goto L12;
            return false;
        L12:
            if (this.bottom == r101.bottom) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
        }

        public final String toString() {
            return "ShopLynxPadding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }

        public c() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
        }

        public final int a() {
            return this.bottom;
        }

        public final int b() {
            return this.left;
        }

        public final int c() {
            return this.right;
        }

        public final int d() {
            return this.top;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/window/shop/repository/tab/entity/v$d;", "", "", "ssrData", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "hydrateData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "hydrateUrl", "b", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ssrDataDecodingFormat", "Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "getSsrDataDecodingFormat", "()Lcom/bytedance/android/ec/hybrid/list/entity/dto/SSRDataDecodingFormat;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f189639a = 0;

        @SerializedName("hydrate_data")
        private final String hydrateData;

        @SerializedName("hydrate_url")
        private final String hydrateUrl;

        @SerializedName("ssr_data")
        private final String ssrData;

        @SerializedName("ssr_data_decoding_format")
        private final SSRDataDecodingFormat ssrDataDecodingFormat;

        public static final class a {
        }

        static {
        }

        public d() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof d) == false) goto L14;
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.ssrData, r101.ssrData) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.hydrateData, r101.hydrateData) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.hydrateUrl, r101.hydrateUrl) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ssrDataDecodingFormat, r101.ssrDataDecodingFormat) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r100 = this.ssrData;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.hydrateData;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.hydrateUrl;
            if (r107 == null) goto L13;
            int r108 = r107.hashCode();
        L14:
            int r109 = (r106 + r108) * 31;
            SSRDataDecodingFormat r110 = this.ssrDataDecodingFormat;
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

        public final String toString() {
            return "ShopLynxSsrVO(ssrData=" + this.ssrData + ", hydrateData=" + this.hydrateData + ", hydrateUrl=" + this.hydrateUrl + ", ssrDataDecodingFormat=" + this.ssrDataDecodingFormat + ")";
        }

        public final String a() {
            return this.hydrateData;
        }

        public final String b() {
            return this.hydrateUrl;
        }

        public final String c() {
            return this.ssrData;
        }

        public d(String r100, String r101, String r102, SSRDataDecodingFormat r103) {
            this.ssrData = r100;
            this.hydrateData = r101;
            this.hydrateUrl = r102;
            this.ssrDataDecodingFormat = r103;
        }
    }

    static {
    }

    public final boolean e() {
        if (com.bytedance.android.shopping.extensions.k.c(this.f189635j) == false) goto L20;
        b r100 = this.f189636k;
        if (r100 == null) goto L16;
        String r101 = r100.c();
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L16;
        boolean r103 = false;
    L17:
        if (r103 == false) goto L21;
        return true;
    L21:
        return false;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
    L16:
        r103 = true;
        goto L17
    L20:
        return false;
    }

    public v(int r100) {
        super(r100);
        this.f189637l = true;
    }
}
