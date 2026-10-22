package com.bytedance.android.ecom.arch.slice.render.elements.text;

import android.graphics.Typeface;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes44.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f50539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f50540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f50541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f50542d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f50543e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f50544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Typeface f50545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f50546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f50547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f50548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Object f50549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f50550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f50551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f50552n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f50553o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f50554p;

    public final int hashCode() {
        return this.f50539a;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f50539a == r101.f50539a) goto L12;
        return false;
    L12:
        if (this.f50553o == r101.f50553o) goto L15;
        return false;
    L15:
        if (this.f50541c == r101.f50541c) goto L18;
        return false;
    L18:
        if (this.f50542d == r101.f50542d) goto L21;
        return false;
    L21:
        if (this.f50543e == r101.f50543e) goto L24;
        return false;
    L24:
        if (this.f50544f == r101.f50544f) goto L27;
        return false;
    L27:
        if (this.f50551m == r101.f50551m) goto L30;
        return false;
    L30:
        if (this.f50552n == r101.f50552n) goto L33;
        return false;
    L33:
        if (this.f50554p == r101.f50554p) goto L36;
        return false;
    L36:
        if (this.f50550l == r101.f50550l) goto L39;
        return false;
    L39:
        if (this.f50545g == r101.f50545g) goto L41;
        return false;
    L41:
        CharSequence r102 = this.f50540b;
        CharSequence r103 = r101.f50540b;
        if (r102 == null) goto L58;
        if (r102.equals(r103) == true) goto L47;
        return false;
    L47:
        if (a(this.f50546h, r101.f50546h) == true) goto L50;
        return false;
    L50:
        if (a(this.f50547i, r101.f50547i) == true) goto L53;
        return false;
    L53:
        if (a(this.f50548j, r101.f50548j) == true) goto L56;
        return false;
    L56:
        return a(this.f50549k, r101.f50549k);
    L58:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
    }

    public static boolean a(Object r100, Object r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L12;
        return true;
    L12:
        return false;
    L7:
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r100.equals(r101) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public g(CharSequence r100, float r101, float r102, int r103, float r104, Typeface r105, Object r106, Object r107, Object r108, Object r110, int r111, int r112, int r113, int r114, int r115) {
        this.f50540b = r100;
        this.f50541c = r101;
        this.f50542d = r102;
        this.f50543e = r103;
        this.f50544f = r104;
        this.f50545g = r105;
        this.f50546h = r106;
        this.f50547i = r107;
        this.f50548j = r108;
        this.f50549k = r110;
        this.f50550l = r111;
        this.f50551m = r112;
        this.f50552n = r113;
        this.f50553o = r114;
        this.f50554p = r115;
        int r109 = ((((((((r100.hashCode() * 31) + Float.floatToRawIntBits(r101)) * 31) + Float.floatToRawIntBits(r102)) * 31) + r103) * 31) + Float.floatToRawIntBits(r104)) * 31;
        int r116 = 0;
        if (r105 == null) goto L5;
        int r117 = r105.hashCode();
    L6:
        int r118 = (r109 + r117) * 31;
        if (r106 == null) goto L9;
        int r119 = r106.hashCode();
    L10:
        int r120 = (r118 + r119) * 31;
        if (r107 == null) goto L13;
        int r121 = r107.hashCode();
    L14:
        int r122 = (r120 + r121) * 31;
        if (r108 == null) goto L17;
        int r123 = r108.hashCode();
    L18:
        int r124 = (r122 + r123) * 31;
        if (r110 == null) goto L21;
        r116 = r110.hashCode();
    L21:
        this.f50539a = ((((((((((r124 + r116) * 31) + r111) * 31) + r112) * 31) + r113) * 31) + r114) * 31) + r115;
        return;
    L17:
        r123 = 0;
        goto L18
    L13:
        r121 = 0;
        goto L14
    L9:
        r119 = 0;
        goto L10
    L5:
        r117 = 0;
        goto L6
    }
}
