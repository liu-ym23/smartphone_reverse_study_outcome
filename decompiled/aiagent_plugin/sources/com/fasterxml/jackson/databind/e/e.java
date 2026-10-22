package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedClassResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.fasterxml.jackson.databind.l.b f12618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Class<?> f12619b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f12620c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Class<?> f12621d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class<?> f12622e = null;
    private final com.fasterxml.jackson.databind.a.m<?> f;
    private final com.fasterxml.jackson.databind.b g;
    private final u.a h;
    private final com.fasterxml.jackson.databind.k.n i;
    private final com.fasterxml.jackson.databind.k j;
    private final Class<?> k;
    private final Class<?> l;
    private final boolean m;

    static {
        f12618a = p.a();
        f12619b = Object.class;
        f12620c = Enum.class;
        f12621d = List.class;
        f12622e = Map.class;
    }

    e(com.fasterxml.jackson.databind.a.m<?> r4, com.fasterxml.jackson.databind.k r5, u.a r6) {
        u.a r7 = (u.a) ZeusTransformUtils.wrapperContextForParams(r6, u.a.class, "com.obric.aiagent.plugin");
        this.f = r4;
        this.j = r5;
        Class<?> r0 = r5.e();
        this.k = r0;
        this.h = r7;
        this.i = r5.A();
        Class<?> r2 = null;
        if (r4.f() == false) goto L5;
        com.fasterxml.jackson.databind.b r8 = r4.j();
    L6:
        this.g = r8;
        if (r7 == null) goto L10;
        r2 = r7.j(r0);
    L10:
        this.l = r2;
        if (r8 != null) goto L13;
    L17:
        boolean r9 = false;
    L18:
        this.m = r9;
        return;
    L13:
        if (com.fasterxml.jackson.databind.l.h.o(r0) == true) goto L15;
    L16:
        r9 = true;
        goto L18
    L15:
        if (r5.q() == true) goto L17;
    L5:
        r8 = null;
        goto L6
    }

    e(com.fasterxml.jackson.databind.a.m<?> r3, Class<?> r4, u.a r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        this.f = r3;
        Class<?> r0 = null;
        this.j = null;
        this.k = r4;
        this.h = r6;
        this.i = com.fasterxml.jackson.databind.k.n.a();
        if (r3 != null) goto L6;
        this.g = null;
        this.l = null;
    L15:
        if (this.g == null) goto L17;
        boolean r7 = true;
    L18:
        this.m = r7;
        return;
    L17:
        r7 = false;
        goto L18
    L6:
        if (r3.f() == false) goto L8;
        com.fasterxml.jackson.databind.b r8 = r3.j();
    L9:
        this.g = r8;
        if (r6 == null) goto L13;
        r0 = r6.j(r4);
    L13:
        this.l = r0;
        goto L15
    L8:
        r8 = null;
        goto L9
    }

    public static d a(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3, u.a r4) {
        u.a r5 = (u.a) ZeusTransformUtils.wrapperContextForParams(r4, u.a.class, "com.obric.aiagent.plugin");
        if (r3.j() == false) goto L9;
        if (c(r2, r3.e()) == false) goto L9;
        return b(r2, r3.e());
    L9:
        return new e(r2, r3, r5).a();
    }

    public static d a(com.fasterxml.jackson.databind.a.m<?> r0, Class<?> r1) {
        return a(r0, r1, r0);
    }

    public static d a(com.fasterxml.jackson.databind.a.m<?> r2, Class<?> r3, u.a r4) {
        u.a r5 = (u.a) ZeusTransformUtils.wrapperContextForParams(r4, u.a.class, "com.obric.aiagent.plugin");
        if (r3.isArray() == false) goto L9;
        if (c(r2, r3) == false) goto L9;
        return b(r2, r3);
    L9:
        return new e(r2, r3, r5).b();
    }

    private static boolean c(com.fasterxml.jackson.databind.a.m<?> r0, Class<?> r1) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.j(r1) == null) goto L7;
        return false;
    }

    static d a(Class<?> r1) {
        return new d(r1);
    }

    static d b(com.fasterxml.jackson.databind.a.m<?> r0, Class<?> r1) {
        return new d(r1);
    }

    d a() {
        ArrayList r3 = new ArrayList(8);
        if (this.j.a(Object.class) == true) goto L9;
        if (this.j.n() == false) goto L7;
        b(this.j, r3, false);
        goto L9
    L7:
        a(this.j, r3, false);
    L9:
        return new d(this.j, this.k, r3, this.l, a(r3), this.i, this.g, this.h, this.f.o(), this.m);
    }

    d b() {
        List<com.fasterxml.jackson.databind.k> r3 = Collections.emptyList();
        return new d(null, this.k, r3, this.l, a(r3), this.i, this.g, this.h, this.f.o(), this.m);
    }

    private static void a(com.fasterxml.jackson.databind.k r4, List<com.fasterxml.jackson.databind.k> r5, boolean r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        Class<?> r0 = r4.e();
        if (r0 != f12619b) goto L5;
        return;
    L5:
        if (r0 == f12620c) goto L23;
        if (r6 == true) goto L9;
    L12:
        Iterator<com.fasterxml.jackson.databind.k> r8 = r4.C().iterator();
    L14:
        if (r8.hasNext() == false) goto L16;
        b((com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r8.next(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin"), r7, true);
        goto L14
    L16:
        com.fasterxml.jackson.databind.k r9 = r4.B();
        if (r9 == null) goto L22;
        a(r9, r7, true);
        return;
    L22:
        return;
    L9:
        if (a(r7, r0) == false) goto L11;
        return;
    L11:
        r7.add(r4);
        goto L12
    }

    private static void b(com.fasterxml.jackson.databind.k r2, List<com.fasterxml.jackson.databind.k> r3, boolean r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        Class<?> r0 = r2.e();
        if (r4 == true) goto L5;
    L12:
        Iterator<com.fasterxml.jackson.databind.k> r6 = r2.C().iterator();
    L14:
        if (r6.hasNext() == false) goto L16;
        b((com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r6.next(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin"), r5, true);
        goto L14
    L16:
        return;
    L5:
        if (a(r5, r0) == false) goto L7;
        return;
    L7:
        r5.add(r2);
        if (r0 != f12621d) goto L10;
        return;
    L10:
        if (r0 != f12622e) goto L12;
    }

    private static boolean a(List<com.fasterxml.jackson.databind.k> r6, Class<?> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        int r0 = r8.size();
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L9;
        if (((com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r8.get(r3), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin")).e() == r7) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    private com.fasterxml.jackson.databind.l.b a(List<com.fasterxml.jackson.databind.k> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        if (this.g == null) goto L5;
        u.a r0 = this.h;
        if (r0 != null) goto L9;
    L13:
        boolean r1 = false;
    L14:
        if (r1 == false) goto L16;
    L19:
        p r2 = p.b();
        Class<?> r3 = this.l;
        if (r3 == null) goto L23;
        r2 = a(r2, this.k, r3);
    L23:
        if (this.m == false) goto L25;
        r2 = a(r2, com.fasterxml.jackson.databind.l.h.r(this.k));
    L25:
        Iterator r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L34;
        com.fasterxml.jackson.databind.k r4 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r9.next(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        if (r1 == false) goto L32;
        Class<?> r5 = r4.e();
        r2 = a(r2, r5, this.h.j(r5));
    L32:
        if (this.m == false) goto L27;
        r2 = a(r2, com.fasterxml.jackson.databind.l.h.r(r4.e()));
        goto L27
    L34:
        if (r1 == false) goto L37;
        r2 = a(r2, Object.class, this.h.j(Object.class));
    L37:
        return r2.c();
    L16:
        if (this.m == true) goto L19;
        return f12618a;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, af.class) == true) goto L11;
    L12:
        r1 = true;
        goto L14
    L11:
        if (((af) ZeusTransformUtils.preCheckCast(this.h, af.class, "com.obric.aiagent.plugin")).a() == false) goto L13;
    L5:
        return f12618a;
    }

    private p a(p r3, Class<?> r4, Class<?> r5) {
        if (r5 == null) goto L7;
        r3 = a(r3, com.fasterxml.jackson.databind.l.h.r(r5));
        Iterator<Class<?>> r6 = com.fasterxml.jackson.databind.l.h.b(r5, r4, false).iterator();
    L5:
        if (r6.hasNext() == false) goto L7;
        r3 = a(r3, com.fasterxml.jackson.databind.l.h.r((Class) ZeusTransformUtils.preCheckCast(r6.next(), Class.class, "com.obric.aiagent.plugin")));
    L7:
        return r3;
    }

    private p a(p r5, Annotation[] r6) {
        if (r6 == null) goto L11;
        int r0 = r6.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L11;
        Annotation r2 = r6[r1];
        if (r5.a(r2) == true) goto L10;
        r5 = r5.b(r2);
        if (this.g.a(r2) == false) goto L10;
        r5 = a(r5, r2);
    L10:
        r1 = r1 + 1;
    L11:
        return r5;
    }

    private p a(p r5, Annotation r6) {
        Annotation[] r7 = com.fasterxml.jackson.databind.l.h.r(((Annotation) ZeusTransformUtils.wrapperContextForParams(r6, Annotation.class, "com.obric.aiagent.plugin")).annotationType());
        int r0 = r7.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        Annotation r2 = r7[r1];
        if (ZeusTransformUtils.instanceOf(r2, Target.class) == true) goto L14;
        if (ZeusTransformUtils.instanceOf(r2, Retention.class) == true) goto L14;
        if (r5.a(r2) == true) goto L14;
        r5 = r5.b(r2);
        if (this.g.a(r2) == false) goto L14;
        r5 = a(r5, r2);
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        return r5;
    }
}
