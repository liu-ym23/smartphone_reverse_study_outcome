package com.obric.oui.indicator;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    public static final d a(int r10, int r11, int r12) {
        return new d(r10, r11, b(r10, r11, Math.min(r10, r12)));
    }

    public static final bg.c b(int r10, int r11, int r12) {
        if (r10 <= r12) goto L5;
        int r13 = r11 - (r12 / 2);
        int r14 = bg.h.k(r13, 0, r10 - r12);
        return bg.h.p(r14, r12 + r14);
    L5:
        return bg.h.p(0, r10);
    }

    public static final IndicatorViewportShiftDirection c(bg.c r10, bg.c r11) {
        q.g(r10, "currentRange");
        q.g(r11, "nextRange");
        int r12 = r11.a() - r10.a();
        if (r12 == (-1)) goto L9;
        if (r12 == 1) goto L11;
        return null;
    L11:
        return IndicatorViewportShiftDirection.FORWARD;
    L9:
        return IndicatorViewportShiftDirection.BACKWARD;
    }
}
