package com.bytedance.android.shopping.anchorv4.voavhs.detailimages;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailMoreInfo;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends VOIdentifier {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f168307h = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f168308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f168309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DetailMoreInfo f168310d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f168311e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<ECUrlModel> f168312f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f168313g;

    public static final class a {
        public static d a(ECUrlModel r100, int r101, DetailMoreInfo r110, Integer r111, List r112, List r113) {
            Intrinsics.checkNotNullParameter(r100, "urlModel");
            return new d(r100, r101, r110, r111, r112, r113);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L18;
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f168308b, r101.f168308b) == true) goto L8;
        return false;
    L8:
        if (this.f168309c == r101.f168309c) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168310d, r101.f168310d) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168311e, r101.f168311e) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f168312f, r101.f168312f) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f168313g, r101.f168313g) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        ECUrlModel r100 = this.f168308b;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f168309c) * 31;
        DetailMoreInfo r104 = this.f168310d;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f168311e;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<ECUrlModel> r110 = this.f168312f;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<String> r113 = this.f168313g;
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
        return "AnchorV4DetailImageVO(image=" + this.f168308b + ", index=" + this.f168309c + ", moreInfo=" + this.f168310d + ", showHeight=" + this.f168311e + ", allImages=" + this.f168312f + ", picTypes=" + this.f168313g + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(ECUrlModel r100, int r101, DetailMoreInfo r102, Integer r103, List<? extends ECUrlModel> r104, List<String> r105) {
        Intrinsics.checkNotNullParameter(r100, "image");
        this.f168308b = r100;
        this.f168309c = r101;
        this.f168310d = r102;
        this.f168311e = r103;
        this.f168312f = r104;
        this.f168313g = r105;
    }
}
