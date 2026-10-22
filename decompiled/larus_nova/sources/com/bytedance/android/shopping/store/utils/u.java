package com.bytedance.android.shopping.store.utils;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f186976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f186977b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f186978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f186979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, String> f186980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Object> f186981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f186982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Object> f186983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f186984i;

    public u() {
        this(0, "", "", null, null, null, "", null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u) == false) goto L24;
        u r101 = (u) r100;
        if (this.f186976a == r101.f186976a) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f186977b, r101.f186977b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f186978c, r101.f186978c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f186979d, r101.f186979d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f186980e, r101.f186980e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f186981f, r101.f186981f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f186982g, r101.f186982g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f186983h, r101.f186983h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f186984i, r101.f186984i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        int r100 = this.f186976a * 31;
        String r101 = this.f186977b;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f186978c;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        Map<String, Object> r108 = this.f186979d;
        if (r108 == null) goto L13;
        int r109 = r108.hashCode();
    L14:
        int r110 = (r107 + r109) * 31;
        Map<String, String> r111 = this.f186980e;
        if (r111 == null) goto L17;
        int r112 = r111.hashCode();
    L18:
        int r113 = (r110 + r112) * 31;
        Map<String, Object> r114 = this.f186981f;
        if (r114 == null) goto L21;
        int r115 = r114.hashCode();
    L22:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f186982g;
        if (r117 == null) goto L25;
        int r118 = r117.hashCode();
    L26:
        int r119 = (r116 + r118) * 31;
        Map<String, Object> r120 = this.f186983h;
        if (r120 == null) goto L29;
        int r121 = r120.hashCode();
    L30:
        int r122 = (r119 + r121) * 31;
        String r123 = this.f186984i;
        if (r123 == null) goto L34;
        r102 = r123.hashCode();
    L34:
        return r122 + r102;
    L29:
        r121 = 0;
        goto L30
    L25:
        r118 = 0;
        goto L26
    L21:
        r115 = 0;
        goto L22
    L17:
        r112 = 0;
        goto L18
    L13:
        r109 = 0;
        goto L14
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "ProductActionParams(index=" + this.f186976a + ", rawBtm=" + this.f186977b + ", resolvedBtm=" + this.f186978c + ", productInfo=" + this.f186979d + ", logExtra=" + this.f186980e + ", bizExtra=" + this.f186981f + ", productId=" + this.f186982g + ", standardChainParam=" + this.f186983h + ", detailUrl=" + this.f186984i + ")";
    }

    public u(int r100, String r101, String r102, Map<String, ? extends Object> r103, Map<String, String> r104, Map<String, ? extends Object> r105, String r106, Map<String, ? extends Object> r107, String r110) {
        Intrinsics.checkNotNullParameter(r101, "rawBtm");
        Intrinsics.checkNotNullParameter(r102, "resolvedBtm");
        Intrinsics.checkNotNullParameter(r106, "productId");
        this.f186976a = r100;
        this.f186977b = r101;
        this.f186978c = r102;
        this.f186979d = r103;
        this.f186980e = r104;
        this.f186981f = r105;
        this.f186982g = r106;
        this.f186983h = r107;
        this.f186984i = r110;
    }
}
