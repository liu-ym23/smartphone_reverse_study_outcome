package com.obric.oui.indicator;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h {
    public static final a a(int r10, int r11, bg.c r12) {
        q.g(r12, "visibleRange");
        if (r12.a() != r12.b()) goto L8;
        if (r10 != r12.a()) goto L8;
        return new a(0, 0);
    L8:
        if (r10 != r12.a()) goto L11;
        return new a(0, r11);
    L11:
        if (r10 != r12.b()) goto L14;
        return new a(r11, 0);
    L14:
        return new a(r11, r11);
    }
}
