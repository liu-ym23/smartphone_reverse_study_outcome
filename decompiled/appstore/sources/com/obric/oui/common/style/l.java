package com.obric.oui.common.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.obric.common.oea.foundation.graphics.smoothcorner.SmoothCornerHelper;
import com.obric.oui.utils.log.L;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f13087a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SmoothCornerHelper f13088b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SmoothCornerHelper f13089c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final SmoothCornerHelper f13090d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final SmoothCornerHelper f13091e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f13092f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f13093g;

    static {
        f13087a = new l();
        f13088b = new SmoothCornerHelper();
        SmoothCornerHelper r10 = new SmoothCornerHelper();
        r10.g(SmoothCornerHelper.Companion.CurveType.BASIC);
        f13089c = r10;
        SmoothCornerHelper r11 = new SmoothCornerHelper();
        r11.g(SmoothCornerHelper.Companion.CurveType.SKETCH);
        f13090d = r11;
        SmoothCornerHelper r12 = new SmoothCornerHelper();
        r12.g(SmoothCornerHelper.Companion.CurveType.QUADRATIC_CAPSULE);
        f13091e = r12;
        f13092f = !TextUtils.equals("HUAWEI", Build.BRAND);
        f13093g = true;
    }

    public l() {
    }

    public static final void h(Canvas r10, float r11, float r12, float r13, float r14, float r15, Paint r16) {
        q.g(r10, "canvas");
        q.g(r16, "paint");
        l r17 = f13087a;
        float r18 = r17.f(r15, r11, r12, r13, r14);
        r17.e(r18, r17.j(r11, r12, r13, r14)).d(r10, r16, r11, r12, r13, r14, r18);
    }

    public static final void i(Canvas r10, RectF r11, float r12, Paint r13) {
        q.g(r10, "canvas");
        q.g(r11, "rectF");
        q.g(r13, "paint");
        l r14 = f13087a;
        float r15 = r14.g(r12, r11);
        r14.e(r15, r14.k(r11)).e(r10, r11, r15, r13);
    }

    public final void a(Path r10, RectF r11, float r12) {
        q.g(r10, "path");
        q.g(r11, "rect");
        r10.addPath(d(r11, r12));
    }

    public final void b(Path r10, RectF r11, float[] r12, Path.Direction r13) {
        q.g(r10, "path");
        q.g(r11, "rect");
        q.g(r12, "radii");
        q.g(r13, "dir");
        if (m.a(r12) == false) goto L5;
        r10.addPath(d(r11, r12[0]));
        return;
    L5:
        r10.addRoundRect(r11, r12, r13);
    }

    public final Path c(float r10, float r11, float r12, float r13, float r14) {
        float r15 = f(r14, r10, r11, r12, r13);
        return e(r15, j(r10, r11, r12, r13)).a(r10, r11, r12, r13, r15);
    }

    public final Path d(RectF r10, float r11) {
        q.g(r10, "rect");
        float r12 = g(r11, r10);
        SmoothCornerHelper r13 = e(r12, k(r10));
        Rect r14 = new Rect();
        r10.roundOut(r14);
        return r13.b(r14, r12);
    }

    public final SmoothCornerHelper e(float r10, float r11) {
        if (f13093g == true) goto L5;
        SmoothCornerHelper r12 = f13088b;
        if (r12.c(r10, r11) == true) goto L14;
        SmoothCornerHelper r13 = f13090d;
        if (r13.c(r10, r11) == false) goto L13;
        return r13;
    L13:
        return f13091e;
    L14:
        return r12;
    L5:
        return f13089c;
    }

    public final float f(float r10, float r11, float r12, float r13, float r14) {
        return bg.h.c(Math.min(r10, j(r11, r12, r13, r14) / 2.0f), 0.0f);
    }

    public final float g(float r10, RectF r11) {
        if (r11.isEmpty() == false) goto L7;
        L.b("SmoothCornerH", "decideValidCornerRadius: rectF is empty");
        return 0.0f;
    L7:
        return bg.h.c(Math.min(r10, k(r11) / 2.0f), 0.0f);
    }

    public final float j(float r10, float r11, float r12, float r13) {
        return Math.min(Math.abs(r12 - r10), Math.abs(r13 - r11));
    }

    public final float k(RectF r10) {
        return Math.min(r10.width(), r10.height());
    }
}
