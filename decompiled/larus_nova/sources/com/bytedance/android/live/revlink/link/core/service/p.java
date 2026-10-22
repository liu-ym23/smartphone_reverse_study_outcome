package com.bytedance.android.live.revlink.link.core.service;

import android.graphics.Matrix;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, n> f98361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<n> f98362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n f98363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t51.c f98364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f98365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o51.e f98366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Matrix f98367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final g f98368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Integer f98369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Integer f98370j;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof p) == false) goto L26;
        p r101 = (p) r100;
        if (Intrinsics.areEqual(this.f98361a, r101.f98361a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f98362b, r101.f98362b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f98363c, r101.f98363c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f98364d, r101.f98364d) == true) goto L14;
        return false;
    L14:
        if (this.f98365e == r101.f98365e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f98366f, r101.f98366f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f98367g, r101.f98367g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f98368h, r101.f98368h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f98369i, r101.f98369i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f98370j, r101.f98370j) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    public final int hashCode() {
        Map<String, n> r100 = this.f98361a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<n> r104 = this.f98362b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        n r107 = this.f98363c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        t51.c r110 = this.f98364d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (((r109 + r111) * 31) + this.f98365e) * 31;
        o51.e r113 = this.f98366f;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Matrix r116 = this.f98367g;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        g r119 = this.f98368h;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.f98369i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Integer r125 = this.f98370j;
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
        return "LayoutFrame(layoutConfigFrames=" + this.f98361a + ", audienceConfigFrames=" + this.f98362b + ", gameConfigFrame=" + this.f98363c + ", canvasTransform=" + this.f98364d + ", count=" + this.f98365e + ", uiLayout=" + this.f98366f + ", gridMatrix=" + this.f98367g + ", containerMargin=" + this.f98368h + ", realContainerHeight=" + this.f98369i + ", realContainerWidth=" + this.f98370j + ")";
    }

    public p(Map<String, n> r100, List<n> r101, n r102, t51.c r103, int r104, o51.e r105, Matrix r106, g r107, Integer r110, Integer r111) {
        Intrinsics.checkNotNullParameter(r100, "layoutConfigFrames");
        Intrinsics.checkNotNullParameter(r101, "audienceConfigFrames");
        Intrinsics.checkNotNullParameter(r103, "canvasTransform");
        Intrinsics.checkNotNullParameter(r105, "uiLayout");
        Intrinsics.checkNotNullParameter(r106, "gridMatrix");
        this.f98361a = r100;
        this.f98362b = r101;
        this.f98363c = r102;
        this.f98364d = r103;
        this.f98365e = r104;
        this.f98366f = r105;
        this.f98367g = r106;
        this.f98368h = r107;
        this.f98369i = r110;
        this.f98370j = r111;
    }
}
