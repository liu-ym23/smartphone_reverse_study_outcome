package com.bytedance.android.shopping.anchorv4.voavhs.car;

import com.bytedance.android.ec.core.utils.d1;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.business.VO;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.google.gson.JsonObject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class b extends VOIdentifier {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f168080f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnchorV4CarAddressDisplay f168081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnchorV4CarAddressMeta f168082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ComponentDTO f168083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.dto.business.a f168084e;

    public static final class a {
        public static b a(ComponentDTO r100) {
            Intrinsics.checkNotNullParameter(r100, "componentDTO");
            Object r101 = null;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L23
            b r103 = new b(0);     // Catch: Throwable -> L23
            VO r104 = r100.getVo();     // Catch: Throwable -> L23
            if (r104 == null) goto L6;
            JsonObject r105 = r104.getDisplay();     // Catch: Throwable -> L23
        L7:
            r103.f168081b = (AnchorV4CarAddressDisplay) u0.a(r105, AnchorV4CarAddressDisplay.class);     // Catch: Throwable -> L23
            VO r106 = r100.getVo();     // Catch: Throwable -> L23
            if (r106 == null) goto L10;
            JsonObject r107 = r106.getMeta();     // Catch: Throwable -> L23
        L11:
            r103.f168082c = (AnchorV4CarAddressMeta) u0.a(r107, AnchorV4CarAddressMeta.class);     // Catch: Throwable -> L23
            r103.f168083d = r100;     // Catch: Throwable -> L23
            UI r108 = r100.getUi();     // Catch: Throwable -> L23
            if (r108 == null) goto L14;
            com.bytedance.android.shopping.anchorv4.dto.business.a r109 = r108.getStyle();     // Catch: Throwable -> L23
        L15:
            r103.f168084e = r109;     // Catch: Throwable -> L23
            ProductSelectPoiInfo r110 = d1.f45575a;     // Catch: Throwable -> L23
            AnchorV4CarAddressMeta r111 = r103.f168082c;     // Catch: Throwable -> L23
            if (r111 == null) goto L20;
            AnchorV4CarAddressBusinessMeta r112 = r111.getBusinessMeta();     // Catch: Throwable -> L23
            if (r112 == null) goto L20;
            SkuPoiInfo r113 = r112.getPoiInfo();     // Catch: Throwable -> L23
        L21:
            d1.f45576b = r113;     // Catch: Throwable -> L23
            Object r114 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L23
        L26:
            if (Result.m9455isFailureimpl(r114) == true) goto L30;
            r101 = r114;
        L30:
            return (b) r101;
        L20:
            r113 = null;
            goto L21
        L14:
            r109 = null;
            goto L15
        L10:
            r107 = null;
            goto L11
        L6:
            r105 = null;
        L23:
            th = move-exception;
            Result.Companion r115 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        }
    }

    static {
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == false) goto L14;
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f168081b, r101.f168081b) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168082c, r101.f168082c) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168083d, r101.f168083d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168084e, r101.f168084e) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        AnchorV4CarAddressDisplay r100 = this.f168081b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        AnchorV4CarAddressMeta r104 = this.f168082c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ComponentDTO r107 = this.f168083d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.a r110 = this.f168084e;
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
        return "AnchorV4CarAddressVO(display=" + this.f168081b + ", meta=" + this.f168082c + ", component=" + this.f168083d + ", style=" + this.f168084e + ")";
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier
    public final String identifier() {
        ComponentDTO r100 = this.f168083d;
        if (r100 == null) goto L5;
        String r101 = r100.getComponentId();
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    public b(int r100) {
        this.f168081b = null;
        this.f168082c = null;
        this.f168083d = null;
        this.f168084e = null;
    }
}
