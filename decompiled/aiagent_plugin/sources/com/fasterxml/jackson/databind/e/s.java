package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: BasicClassIntrospector.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends u implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final r f12663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final r f12664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final r f12665c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final r f12666d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final r f12667e = null;
    private static final Class<?> f = null;
    private static final Class<?> g = null;
    private static final Class<?> h = null;

    @Override // com.fasterxml.jackson.databind.e.u
    public /* synthetic */ com.fasterxml.jackson.databind.c b(com.fasterxml.jackson.databind.aa r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        return a(r3, r4, (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.e.u
    public /* synthetic */ com.fasterxml.jackson.databind.c b(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4, u.a r5, com.fasterxml.jackson.databind.c r6) {
        return a(r3, r4, (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin"), r6);
    }

    @Override // com.fasterxml.jackson.databind.e.u
    public /* synthetic */ com.fasterxml.jackson.databind.c c(com.fasterxml.jackson.databind.a.m r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        return a(r3, r4, (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.e.u
    public /* synthetic */ com.fasterxml.jackson.databind.c c(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        return b(r3, r4, (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.e.u
    public /* synthetic */ com.fasterxml.jackson.databind.c d(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        return a(r3, r4, (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin"));
    }

    static {
        f = Object.class;
        g = String.class;
        h = com.fasterxml.jackson.databind.n.class;
        f12663a = r.a(null, com.fasterxml.jackson.databind.k.l.e(String.class), e.a(String.class));
        f12664b = r.a(null, com.fasterxml.jackson.databind.k.l.e(Boolean.TYPE), e.a(Boolean.TYPE));
        f12665c = r.a(null, com.fasterxml.jackson.databind.k.l.e(Integer.TYPE), e.a(Integer.TYPE));
        f12666d = r.a(null, com.fasterxml.jackson.databind.k.l.e(Long.TYPE), e.a(Long.TYPE));
        f12667e = r.a(null, com.fasterxml.jackson.databind.k.l.e(Object.class), e.a(Object.class));
    }

    public s() {
    }

    public r a(com.fasterxml.jackson.databind.aa r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        r r0 = a(r3, r4);
        if (r0 != null) goto L8;
        r r1 = b(r3, r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return r.b(a(r3, r4, r6, true));
    L8:
        return r0;
    }

    public r a(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        r r0 = a(r3, r4);
        if (r0 != null) goto L8;
        r r1 = b(r3, r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return r.a(a(r3, r4, r6, false));
    L8:
        return r0;
    }

    public r a(com.fasterxml.jackson.databind.g r7, com.fasterxml.jackson.databind.k r8, u.a r9, com.fasterxml.jackson.databind.c r10) {
        return r.a(a(r7, r8, (u.a) ZeusTransformUtils.wrapperContextForParams(r9, u.a.class, "com.obric.aiagent.plugin"), r10, false));
    }

    public r b(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        r r0 = a(r3, r4);
        if (r0 != null) goto L8;
        r r1 = b(r3, r4);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return r.a(a(r3, r4, r6, false));
    L8:
        return r0;
    }

    public r a(com.fasterxml.jackson.databind.a.m<?> r3, com.fasterxml.jackson.databind.k r4, u.a r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        r r0 = a(r3, r4);
        if (r0 == null) goto L5;
        return r0;
    L5:
        return r.a(r3, r4, b(r3, r4, r6));
    }

    public ad a(com.fasterxml.jackson.databind.a.m<?> r7, com.fasterxml.jackson.databind.k r8, u.a r9, boolean r10) {
        d r2 = b(r7, r8, (u.a) ZeusTransformUtils.wrapperContextForParams(r9, u.a.class, "com.obric.aiagent.plugin"));
        if (r8.m() == false) goto L5;
        a r11 = r7.l().b(r7, r2);
    L7:
        return a(r7, r2, r8, r10, r11);
    L5:
        r11 = r7.l().a(r7, r2);
        goto L7
    }

    public ad a(com.fasterxml.jackson.databind.a.m<?> r7, com.fasterxml.jackson.databind.k r8, u.a r9, com.fasterxml.jackson.databind.c r10, boolean r11) {
        d r2 = b(r7, r8, (u.a) ZeusTransformUtils.wrapperContextForParams(r9, u.a.class, "com.obric.aiagent.plugin"));
        return a(r7, r2, r8, r11, r7.l().a(r7, r2, r10));
    }

    public ad a(com.fasterxml.jackson.databind.a.m<?> r7, d r8, com.fasterxml.jackson.databind.k r9, boolean r10, a r11) {
        return new ad(r7, r10, r9, r8, r11);
    }

    public r a(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3) {
        Class<?> r1 = r3.e();
        if (r1.isPrimitive() == false) goto L17;
        if (r1 != Integer.TYPE) goto L9;
        return f12665c;
    L9:
        if (r1 != Long.TYPE) goto L13;
        return f12666d;
    L13:
        if (r1 == Boolean.TYPE) goto L15;
        return null;
    L15:
        return f12664b;
    L17:
        if (com.fasterxml.jackson.databind.l.h.o(r1) == false) goto L39;
        if (r1 != f) goto L23;
        return f12667e;
    L23:
        if (r1 != g) goto L27;
        return f12663a;
    L27:
        if (r1 != Integer.class) goto L31;
        return f12665c;
    L31:
        if (r1 != Long.class) goto L35;
        return f12666d;
    L35:
        if (r1 == Boolean.class) goto L37;
        return null;
    L37:
        return f12664b;
    L39:
        if (h.isAssignableFrom(r1) == true) goto L41;
        return null;
    L41:
        return r.a(r2, r3, e.a(r1));
    }

    public boolean a(com.fasterxml.jackson.databind.k r2) {
        if (r2.q() == true) goto L5;
    L15:
        return false;
    L5:
        if (r2.j() == true) goto L15;
        Class<?> r1 = r2.e();
        if (com.fasterxml.jackson.databind.l.h.o(r1) == false) goto L15;
        if (Collection.class.isAssignableFrom(r1) == false) goto L12;
        return true;
    L12:
        if (Map.class.isAssignableFrom(r1) == false) goto L15;
        return true;
    }

    public r b(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3) {
        if (a(r3) == true) goto L5;
        return null;
    L5:
        return r.a(r2, r3, b(r2, r3, r2));
    }

    public d b(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3, u.a r4) {
        return e.a(r2, r3, (u.a) ZeusTransformUtils.wrapperContextForParams(r4, u.a.class, "com.obric.aiagent.plugin"));
    }
}
