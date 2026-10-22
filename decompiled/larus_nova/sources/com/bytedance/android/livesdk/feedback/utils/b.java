package com.bytedance.android.livesdk.feedback.utils;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<Matrix> f124869a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal<RectF> f124870b = null;

    static {
        f124869a = new ThreadLocal();
        f124870b = new ThreadLocal();
    }

    public static void a(ViewGroup r100, View r101, Rect r102) {
        r102.set(0, 0, r101.getWidth(), r101.getHeight());
        ThreadLocal<Matrix> r103 = f124869a;
        Matrix r104 = r103.get();
        if (r104 != null) goto L5;
        r104 = new Matrix();
        r103.set(r104);
    L6:
        b(r100, r101, r104);
        ThreadLocal<RectF> r105 = f124870b;
        RectF r106 = r105.get();
        if (r106 != null) goto L9;
        r106 = new RectF();
        r105.set(r106);
    L9:
        r106.set(r102);
        r104.mapRect(r106);
        r102.set((int) (r106.left + 0.5f), (int) (r106.top + 0.5f), (int) (r106.right + 0.5f), (int) (r106.bottom + 0.5f));
        return;
    L5:
        r104.reset();
        goto L6
    }

    public static void b(ViewParent r100, View r101, Matrix r102) {
        Object r103 = r101.getParent();
        if ((r103 instanceof View) == false) goto L6;
        if (r103 == r100) goto L6;
        View r104 = (View) r103;
        b(r100, r104, r102);
        r102.preTranslate(-r104.getScrollX(), -r104.getScrollY());
    L6:
        r102.preTranslate(r101.getLeft(), r101.getTop());
        if (r101.getMatrix().isIdentity() == true) goto L10;
        r102.preConcat(r101.getMatrix());
        return;
    }
}
