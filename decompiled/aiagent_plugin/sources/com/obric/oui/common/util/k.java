package com.obric.oui.common.util;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: ViewExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static /* synthetic */ void lambda$LceLNLcUa1EdGJc5IbeTMGQjZHk(View[] r0, View r1, TouchDelegateComposite r2, int r3, int r4) {
        a(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: lambda$wTx_8kkx5GuMxG-5UDBM5J7gK3o, reason: not valid java name */
    public static /* synthetic */ void m999lambda$wTx_8kkx5GuMxG5UDBM5J7gK3o(View r0, int r1, int r2, boolean r3, ViewGroup r4) {
        a(r0, r1, r2, r3, r4);
    }

    public static final void a(final View r7, final int r8, final int r9, final View... r10) {
        o.e(r7, "<this>");
        o.e(r10, "views");
        final TouchDelegateComposite r4 = new TouchDelegateComposite(r7, null, 2, null);
        r7.post(new $$Lambda$k$LceLNLcUa1EdGJc5IbeTMGQjZHk(r10, r7, r4, r8, r9));
    }

    public static final void a(View r1) {
        o.e(r1, "<this>");
        r1.setVisibility(0);
    }

    public static final void b(View r1) {
        o.e(r1, "<this>");
        r1.setVisibility(8);
    }

    public static final void c(View r1) {
        o.e(r1, "<this>");
        r1.setVisibility(4);
    }

    public static final void a(View r1, boolean r2) {
        o.e(r1, "<this>");
        if (r2 == false) goto L5;
        a(r1);
        return;
    L5:
        b(r1);
    }

    public static final boolean d(View r1) {
        o.e(r1, "<this>");
        if (r1.getVisibility() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final boolean e(View r1) {
        o.e(r1, "<this>");
        if (r1.getVisibility() != 8) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void a(View r0, int r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        a(r0, r1, r2, r3);
    }

    public static final void a(final View r8, final int r9, final int r10, final boolean r11) {
        o.e(r8, "<this>");
        if (r8.getParent() == null) goto L5;
        ViewParent r0 = r8.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r1 = (ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin");
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        final ViewGroup r6 = r1;
        r1.post(new $$Lambda$k$wTx_8kkx5GuMxG5UDBM5J7gK3o(r8, r9, r10, r11, r6));
        return;
    L5:
        r1 = null;
        goto L6
    }

    private static final void a(View r2, int r3, int r4, boolean r5, ViewGroup r6) {
        o.e(r2, "$this_expandTouchArea");
        o.e(r6, "$parentView");
        Rect r0 = new Rect();
        r2.getHitRect(r0);
        int r7 = (r3 - r0.width()) / 2;
        int r8 = (r4 - r0.height()) / 2;
        if (r7 >= 0) goto L6;
        if (r5 == true) goto L6;
        r7 = 0;
    L6:
        if (r8 >= 0) goto L9;
        if (r5 == true) goto L9;
        r8 = 0;
    L9:
        r0.left -= r7;
        r0.top -= r8;
        r0.right += r7;
        r0.bottom += r8;
        r6.setTouchDelegate(new TouchDelegate(r0, r2));
    }

    public static final void a(View r7, int r8) {
        o.e(r7, "<this>");
        a(r7, r8, r8, false, 4, null);
    }

    public static final void f(View r3) {
        o.e(r3, "<this>");
        if (r3.getParent() != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r3.getParent(), ViewGroup.class) == false) goto L9;
        ViewParent r0 = r3.getParent();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView(r3);
        return;
    }

    public static final void a(ViewGroup r2, View r3) {
        o.e(r2, "<this>");
        if (r3 != null) goto L5;
        ViewParent r0 = null;
    L6:
        if (r0 != null) goto L8;
    L10:
        r2.addView(r3);
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r3.getParent(), ViewGroup.class) == false) goto L10;
        f(r3);
        goto L10
    L5:
        r0 = r3.getParent();
        goto L6
    }

    private static final void a(View[] r8, View r9, TouchDelegateComposite r10, int r11, int r12) {
        o.e(r8, "$views");
        o.e(r9, "$this_increaseHitAreaForViews");
        o.e(r10, "$touchDelegateComposite");
        int r0 = r8.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L10;
        View r3 = r8[r2];
        Rect r4 = new Rect();
        r3.getHitRect(r4);
        int r5 = (r11 - r4.width()) / 2;
        int r6 = (r12 - r4.height()) / 2;
        if (r5 >= 0) goto L7;
        r5 = 0;
    L7:
        if (r6 >= 0) goto L9;
        r6 = 0;
    L9:
        r4.left -= r5;
        r4.top -= r6;
        r4.right += r5;
        r4.bottom += r6;
        r10.addDelegate(new TouchDelegate(r4, r3));
        r2 = r2 + 1;
        goto L3
    L10:
        r9.setTouchDelegate((TouchDelegate) ZeusTransformUtils.preCheckCast(r10, TouchDelegate.class, "com.obric.aiagent.plugin"));
    }
}
