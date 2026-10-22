package com.obric.oui.orecyclerview.widget;

import android.view.View;

/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes4.dex */
class w {
    static int a(RecyclerView.s r4, t r5, View r6, View r7, RecyclerView.h r8, boolean r9, boolean r10) {
        if (r8.y() != 0) goto L5;
    L17:
        return 0;
    L5:
        if (r4.e() == 0) goto L17;
        if (r6 == null) goto L17;
        if (r7 == null) goto L17;
        int r0 = Math.min(r8.d(r6), r8.d(r7));
        int r2 = Math.max(r8.d(r6), r8.d(r7));
        if (r10 == false) goto L12;
        int r11 = Math.max(0, (r4.e() - r2) - 1);
    L13:
        if (r9 == true) goto L16;
        return r11;
    L16:
        return Math.round((r11 * (Math.abs(r5.b(r7) - r5.a(r6)) / (Math.abs(r8.d(r6) - r8.d(r7)) + 1))) + (r5.c() - r5.a(r6)));
    L12:
        r11 = Math.max(0, r0);
        goto L13
    }

    static int a(RecyclerView.s r1, t r2, View r3, View r4, RecyclerView.h r5, boolean r6) {
        if (r5.y() != 0) goto L5;
        return 0;
    L5:
        if (r1.e() == 0) goto L16;
        if (r3 == null) goto L17;
        if (r4 == null) goto L18;
        if (r6 == false) goto L11;
        int r7 = r2.b(r4) - r2.a(r3);
        return Math.min(r2.f(), r7);
    L11:
        return Math.abs(r5.d(r3) - r5.d(r4)) + 1;
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }

    static int b(RecyclerView.s r1, t r2, View r3, View r4, RecyclerView.h r5, boolean r6) {
        if (r5.y() != 0) goto L5;
        return 0;
    L5:
        if (r1.e() == 0) goto L16;
        if (r3 == null) goto L17;
        if (r4 == null) goto L18;
        if (r6 == true) goto L13;
        return r1.e();
    L13:
        return (int) (((r2.b(r4) - r2.a(r3)) / (Math.abs(r5.d(r3) - r5.d(r4)) + 1)) * r1.e());
    L18:
        return 0;
    L17:
        return 0;
    L16:
        return 0;
    }
}
