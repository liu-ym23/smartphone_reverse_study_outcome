package com.obric.autogui.common;

import d.h.b.o;

/* JADX INFO: compiled from: ActionExecStatusMessage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static /* synthetic */ a a(e r1, String r2, String r3, boolean r4, a.b r5, int r6, int r7, Object r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = true;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = a.b.f28963a;
    L15:
        if ((r7 & 16) == 0) goto L18;
        r6 = Integer.MIN_VALUE;
    L18:
        return a(r1, r2, r3, r4, r5, r6);
    }

    public static final a a(e r9, String r10, String r11, boolean r12, a.b r13, int r14) {
        o.e(r9, "<this>");
        o.e(r13, "postExecAction");
        return new a(r9.g(), r9, r10, r11, r13, r12, r14);
    }
}
