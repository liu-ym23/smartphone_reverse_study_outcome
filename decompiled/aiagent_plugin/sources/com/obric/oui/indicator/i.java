package com.obric.oui.indicator;

import d.h.b.o;

/* JADX INFO: compiled from: OBaseIndicator.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i {
    public static final a a(int r3, int r4, d.l.j r5) {
        o.e(r5, "visibleRange");
        if (r5.a() != r5.b()) goto L8;
        if (r3 != r5.a()) goto L8;
        return new a(0, 0);
    L8:
        if (r3 != r5.a()) goto L11;
        return new a(0, r4);
    L11:
        if (r3 != r5.b()) goto L14;
        return new a(r4, 0);
    L14:
        return new a(r4, r4);
    }
}
