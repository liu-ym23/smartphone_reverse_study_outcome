package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public abstract class i {
    public static int a(RecyclerView.q r10, f r11, View r12, View r13, RecyclerView.LayoutManager r14, boolean r15) {
        if (r14.H() != 0) goto L5;
        return 0;
    L5:
        if (r10.b() == 0) goto L16;
        if (r12 == null) goto L17;
        if (r13 == null) goto L18;
        if (r15 == false) goto L11;
        int r16 = r11.d(r13) - r11.g(r12);
        return Math.min(r11.m(), r16);
    L11:
        return Math.abs(r14.e0(r12) - r14.e0(r13)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    public static int b(RecyclerView.q r10, f r11, View r12, View r13, RecyclerView.LayoutManager r14, boolean r15, boolean r16) {
        if (r14.H() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r10.b() == 0) goto L17;
        if (r12 == null) goto L17;
        if (r13 == null) goto L17;
        int r17 = Math.min(r14.e0(r12), r14.e0(r13));
        int r18 = Math.max(r14.e0(r12), r14.e0(r13));
        if (r16 == false) goto L12;
        int r19 = Math.max(0, (r10.b() - r18) - 1);
    L13:
        if (r15 == true) goto L16;
        return r19;
    L16:
        return Math.round((r19 * (Math.abs(r11.d(r13) - r11.g(r12)) / (Math.abs(r14.e0(r12) - r14.e0(r13)) + 1))) + (r11.l() - r11.g(r12)));
    L12:
        r19 = Math.max(0, r17);
        goto L13
    }

    public static int c(RecyclerView.q r10, f r11, View r12, View r13, RecyclerView.LayoutManager r14, boolean r15) {
        if (r14.H() != 0) goto L5;
        return 0;
    L5:
        if (r10.b() == 0) goto L16;
        if (r12 == null) goto L17;
        if (r13 == null) goto L18;
        if (r15 == true) goto L13;
        return r10.b();
    L13:
        return (int) (((r11.d(r13) - r11.g(r12)) / (Math.abs(r14.e0(r12) - r14.e0(r13)) + 1)) * r10.b());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }
}
