package com.smt.obric.appstore.domain.app;

import com.smt.obric.appstore.domain.app.entity.AppStatus;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final boolean a(AppStatus r10) {
        q.g(r10, "<this>");
        boolean r11 = true;
        if (q.b(r10, AppStatus.l.f17990a) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == false) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == false) goto L26;
        boolean r19 = true;
    L27:
        if (r19 == false) goto L29;
        boolean r20 = true;
    L30:
        if (r20 == false) goto L33;
        return true;
    L33:
        if (q.b(r10, AppStatus.j.f17986a) == false) goto L35;
        boolean r21 = true;
    L36:
        if (r21 == true) goto L39;
        r11 = q.b(r10, AppStatus.e.f17976a);
    L39:
        if (r11 == false) goto L43;
        return false;
    L43:
        throw new NoWhenBranchMatchedException();
    L35:
        r21 = q.b(r10, AppStatus.h.f17982a);
        goto L36
    L29:
        r20 = q.b(r10, AppStatus.a.f17968a);
        goto L30
    L26:
        r19 = q.b(r10, AppStatus.m.f17992a);
        goto L27
    L23:
        r18 = q.b(r10, AppStatus.k.f17988a);
        goto L24
    L20:
        r17 = q.b(r10, AppStatus.b.f17970a);
        goto L21
    L17:
        r16 = q.b(r10, AppStatus.c.f17972a);
        goto L18
    L14:
        r15 = q.b(r10, AppStatus.d.f17974a);
        goto L15
    L11:
        r14 = q.b(r10, AppStatus.f.f17978a);
        goto L12
    L8:
        r13 = q.b(r10, AppStatus.g.f17980a);
        goto L9
    L5:
        r12 = q.b(r10, AppStatus.i.f17984a);
        goto L6
    }

    public static final boolean b(AppStatus r10) {
        q.g(r10, "<this>");
        boolean r11 = true;
        if (q.b(r10, AppStatus.l.f17990a) == false) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == false) goto L11;
        boolean r14 = true;
    L12:
        if (r14 == false) goto L14;
        boolean r15 = true;
    L15:
        if (r15 == false) goto L17;
        boolean r16 = true;
    L18:
        if (r16 == false) goto L20;
        boolean r17 = true;
    L21:
        if (r17 == false) goto L23;
        boolean r18 = true;
    L24:
        if (r18 == false) goto L27;
        return true;
    L27:
        if (q.b(r10, AppStatus.c.f17972a) == false) goto L29;
        boolean r19 = true;
    L30:
        if (r19 == false) goto L32;
        boolean r20 = true;
    L33:
        if (r20 == false) goto L35;
        boolean r21 = true;
    L36:
        if (r21 == true) goto L39;
        r11 = q.b(r10, AppStatus.j.f17986a);
    L39:
        if (r11 == false) goto L43;
        return false;
    L43:
        throw new NoWhenBranchMatchedException();
    L35:
        r21 = q.b(r10, AppStatus.h.f17982a);
        goto L36
    L32:
        r20 = q.b(r10, AppStatus.e.f17976a);
        goto L33
    L29:
        r19 = q.b(r10, AppStatus.d.f17974a);
        goto L30
    L23:
        r18 = q.b(r10, AppStatus.m.f17992a);
        goto L24
    L20:
        r17 = q.b(r10, AppStatus.b.f17970a);
        goto L21
    L17:
        r16 = q.b(r10, AppStatus.g.f17980a);
        goto L18
    L14:
        r15 = q.b(r10, AppStatus.f.f17978a);
        goto L15
    L11:
        r14 = q.b(r10, AppStatus.i.f17984a);
        goto L12
    L8:
        r13 = q.b(r10, AppStatus.k.f17988a);
        goto L9
    L5:
        r12 = q.b(r10, AppStatus.a.f17968a);
        goto L6
    }
}
