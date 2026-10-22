package com.obric.oui.material;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.obric.oui.common.style.IOUILayout;
import com.obric.oui.common.style.Shadow;

/* JADX INFO: loaded from: classes4.dex */
public abstract class o {
    public static final void a(View r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        OMaterialHelper.a(r10, r11);
    }

    public static final void b(View r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        OMaterialHelper.c(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(View r10, b r11) {
        if ((r10 instanceof IOUILayout) == false) goto L18;
        IOUILayout r12 = (IOUILayout) r10;
        if (r12.isEnableShadowWidthRadius() == false) goto L21;
        com.obric.oui.shadow.a[] r13 = r11.i();
        if (r13 != null) goto L12;
        r12.setShadow(null, null);
        return;
    L12:
        if (r13.length <= 1) goto L15;
        float r14 = r10.getResources().getDisplayMetrics().density;
        Shadow.a r15 = Shadow.f13060h;
        ((IOUILayout) r10).setShadow(r15.b(r13[0], r14), r15.b(r13[1], r14));
        return;
    L15:
        if (r13.length != 1) goto L20;
        float r16 = r10.getResources().getDisplayMetrics().density;
        ((IOUILayout) r10).setShadow(Shadow.f13060h.b(r13[0], r16), null);
        return;
    L20:
        return;
    L21:
        return;
    }

    public static final int d(View r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return OMaterialHelper.q(r10.getContext());
    }

    public static final boolean e(Context r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return OMaterialHelper.u(r10);
    }

    public static final boolean f(View r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return OMaterialHelper.u(r10.getContext());
    }

    public static final void g(View r10, b r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "material");
        m(r10, r11, r12, r13);
    }

    public static /* synthetic */ void h(View r10, b r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = 2;
    L8:
        g(r10, r11, r12, r13);
    }

    public static final void i(View r10, b[] r11, boolean r12, int r13, Integer r14) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "materials");
        if (r14 == null) goto L5;
        m(r10, r11[r14.intValue() - 1], r12, r13);     // Catch: Exception -> L11
        return;
    L11:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materials: error level=" + r14 + ", " + e);
        return;
    L5:
        if (r11.length != 1) goto L8;
        g(r10, r11[0], r12, r13);
        return;
    L8:
        o(r10, r11, r12, r13);
        c(r10, r11[Math.min(r11.length - 1, Math.max(0, d(r10) - 1))]);
    }

    public static /* synthetic */ void j(View r10, b[] r11, boolean r12, int r13, Integer r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = 2;
    L9:
        if ((r15 & 8) == 0) goto L11;
        r14 = null;
    L11:
        i(r10, r11, r12, r13, r14);
    }

    public static final void k(View r10, b[] r11, boolean r12, Integer r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "materials");
        if (r13 == null) goto L5;
        g(r10, r11[r13.intValue() - 1], r12, 3);     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        Log.e("OUIMaterial", "error!! View.materialsFromWindow: error level=" + r13 + ", " + e);
        return;
    L5:
        if (r11.length != 0) goto L7;
        return;
    L7:
        j(r10, r11, r12, 3, null, 8, null);
    }

    public static /* synthetic */ void l(View r10, b[] r11, boolean r12, Integer r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        k(r10, r11, r12, r13);
    }

    public static final void m(View r10, b r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "material");
        c(r10, r11);
        if (OMaterialHelper.v() == true) goto L5;
        return;
    L5:
        if (r12 == false) goto L7;
        r10.setBackgroundColor(0);
    L7:
        OMaterialHelper.L(r10, r13, r11);
    }

    public static final void n(View r10, View r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        OMaterialHelper.I(r10, r11);
    }

    public static final void o(View r10, b[] r11, boolean r12, int r13) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        kotlin.jvm.internal.q.g(r11, "materials");
        if (r12 == false) goto L5;
        r10.setBackgroundColor(0);
    L5:
        OMaterialHelper.P(r10, r13, r11);
    }

    public static final void p(View r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 == (-1)) goto L6;
        OMaterialHelper.F(r10, r11);
        return;
    }

    public static final void q(View r10, boolean r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        if (r11 == false) goto L5;
        OMaterialHelper.F(r10, 2);
        return;
    L5:
        OMaterialHelper.F(r10, 3);
    }
}
