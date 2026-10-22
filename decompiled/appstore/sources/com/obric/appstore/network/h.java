package com.obric.appstore.network;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h {
    public static final g a(g r10, Function1 r11) {
        q.g(r10, "<this>");
        q.g(r11, "map");
        if ((r10 instanceof g.d) == false) goto L10;
        Object r12 = ((g.d) r10).a();
        if (r12 == null) goto L7;
        Object r13 = r11.invoke(r12);
    L17:
        return new g.d(r13);
    L7:
        r13 = null;
        goto L17
    L10:
        if ((r10 instanceof g.a) == false) goto L12;
        g.a r14 = (g.a) r10;
        return new g.a(r14.a(), r14.b());
    L12:
        g.b r15 = g.b.f10972a;
        if (q.b(r10, r15) == true) goto L22;
        g.c r16 = g.c.f10973a;
        if (q.b(r10, r16) == false) goto L19;
        return r16;
    L19:
        throw new NoWhenBranchMatchedException();
    L22:
        return r15;
    }

    public static final boolean b(g r10) {
        q.g(r10, "<this>");
        if ((r10 instanceof g.a) == true) goto L5;
    L7:
        return false;
    L5:
        if (((g.a) r10).a() != 10005) goto L7;
        return true;
    }
}
