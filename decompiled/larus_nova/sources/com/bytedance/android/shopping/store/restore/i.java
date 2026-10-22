package com.bytedance.android.shopping.store.restore;

import com.bytedance.android.shopping.store.hybridproduct.ECShopHybridProductReqParams;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f185801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECShopHybridProductReqParams f185802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ej3.a f185803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f185804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f185805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f185806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f185807g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f185808h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Boolean f185809i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L24;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f185801a, r101.f185801a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f185802b, r101.f185802b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f185803c, r101.f185803c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f185804d, r101.f185804d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f185805e, r101.f185805e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f185806f, r101.f185806f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f185807g, r101.f185807g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f185808h, r101.f185808h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f185809i, r101.f185809i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.f185801a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECShopHybridProductReqParams r104 = this.f185802b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ej3.a r107 = this.f185803c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.f185804d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f185805e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<String> r116 = this.f185806f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Integer r119 = this.f185807g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f185808h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Boolean r125 = this.f185809i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
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
        return "ProductRequestState(layoutType=" + this.f185801a + ", reqParams=" + this.f185802b + ", updateProduct=" + this.f185803c + ", allIdRecords=" + this.f185804d + ", currentProductId=" + this.f185805e + ", skuProductIdRecords=" + this.f185806f + ", productViewsNum=" + this.f185807g + ", totalProductNum=" + this.f185808h + ", hasNextPage=" + this.f185809i + ")";
    }

    public i(Integer r100, ECShopHybridProductReqParams r101, ej3.a r102, List<String> r103, String r104, List<String> r105, Integer r106, Integer r107, Boolean r108) {
        this.f185801a = r100;
        this.f185802b = r101;
        this.f185803c = r102;
        this.f185804d = r103;
        this.f185805e = r104;
        this.f185806f = r105;
        this.f185807g = r106;
        this.f185808h = r107;
        this.f185809i = r108;
    }
}
