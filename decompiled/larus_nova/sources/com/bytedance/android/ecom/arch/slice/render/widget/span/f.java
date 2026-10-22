package com.bytedance.android.ecom.arch.slice.render.widget.span;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class f implements LineHeightSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f50998c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f50999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f51000b;

    public static final class a {
        @JvmStatic
        public static void a(Paint.FontMetricsInt r100, float r101, float r102) {
            int r103 = (int) Math.ceil(r101 * r102);
            int r104 = r100.descent;
            int r105 = r100.ascent;
            int r106 = r104 - r105;
            int r107 = (r103 - r106) / 2;
            int r108 = (r103 - r107) - r106;
            int r109 = r100.bottom;
            int r110 = r100.top;
            int r111 = r109 - r110;
            int r112 = (r103 - r111) / 2;
            int r113 = r105 - r107;
            r100.ascent = r113;
            int r114 = r104 + r108;
            r100.descent = r114;
            int r115 = r110 - r112;
            r100.top = r115;
            int r116 = r109 + ((r103 - r112) - r111);
            r100.bottom = r116;
            if (r114 >= 0) goto L5;
            r100.ascent = r113 - r114;
            r100.descent = 0;
        L5:
            int r117 = r100.ascent;
            if (r117 <= 0) goto L8;
            r100.descent -= r117;
            r100.ascent = 0;
        L8:
            if (r116 >= 0) goto L10;
            r100.top = r115 - r116;
            r100.bottom = 0;
        L10:
            int r118 = r100.top;
            if (r118 <= 0) goto L14;
            r100.bottom -= r118;
            r100.top = 0;
            return;
        }
    }

    static {
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.f50999a) + 31) * 31) + Float.floatToIntBits(this.f51000b);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if ((!Intrinsics.areEqual(f.class, r100.getClass())) == true) goto L17;
        f r101 = (f) r100;
        if (this.f50999a == r101.f50999a) goto L13;
    L15:
        return false;
    L13:
        if (this.f51000b != r101.f51000b) goto L15;
        return true;
    }

    public f(float r100, float r101) {
        this.f50999a = r100;
        this.f51000b = r101;
    }

    @Override // android.text.style.LineHeightSpan
    public final void chooseHeight(CharSequence r100, int r101, int r102, int r103, int r104, Paint.FontMetricsInt r105) {
        a.a(r105, this.f50999a, this.f51000b);
    }
}
