package com.obric.oui.indicator;

import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: IndicatorViewportState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h {
    public static final f a(d.l.j r1, d.l.j r2) {
        o.e(r1, "currentRange");
        o.e(r2, "nextRange");
        int r3 = r2.a() - r1.a();
        if (r3 == (-1)) goto L9;
        if (r3 == 1) goto L11;
        return null;
    L11:
        return f.f35391a;
    L9:
        return f.f35392b;
    }

    public static final g a(int r1, int r2, int r3) {
        return new g(r1, r2, b(r1, r2, Math.min(r1, r3)));
    }

    private static final d.l.j b(int r2, int r3, int r4) {
        if (r2 <= r4) goto L5;
        int r5 = r3 - (r4 / 2);
        int r6 = n.a(r5, 0, r2 - r4);
        return n.b(r6, r4 + r6);
    L5:
        return n.b(0, r2);
    }
}
