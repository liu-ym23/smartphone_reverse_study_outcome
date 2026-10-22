package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: DatabindContext.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    public abstract com.fasterxml.jackson.databind.a.m<?> a();

    public abstract m a(k r1, String r2, String r3);

    public abstract com.fasterxml.jackson.databind.k.o b();

    public abstract <T> T b(k r1, String r2);

    public e() {
    }

    public k a(Type r3) {
        Type r4 = (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L7;
        return null;
    L7:
        return b().a(r4);
    }

    public k a(k r6, String r7, com.fasterxml.jackson.databind.h.c r8) {
        int r0 = r7.indexOf(60);
        if (r0 > 0) goto L5;
        com.fasterxml.jackson.databind.a.m<?> r1 = a();
        com.fasterxml.jackson.databind.h.c.b r2 = r8.a(r1, r6, r7);
        if (r2 == com.fasterxml.jackson.databind.h.c.b.f12749b) goto L9;
        Class<?> r3 = b().a(r7);     // Catch: Exception -> L22 ClassNotFoundException -> L25
    L12:
        if (r6.c(r3) == false) goto L14;
        k r4 = r1.o().a(r6, r3);
        if (r2 == com.fasterxml.jackson.databind.h.c.b.f12750c) goto L18;
    L21:
        return r4;
    L18:
        if (r8.a(r1, r6, r4) == com.fasterxml.jackson.databind.h.c.b.f12748a) goto L21;
        return (k) ZeusTransformUtils.preCheckCast(c(r6, r7, r8), k.class, "com.obric.aiagent.plugin");
    L14:
        return (k) ZeusTransformUtils.preCheckCast(a(r6, r7), k.class, "com.obric.aiagent.plugin");
    L25:
        return null;
    L22:
        e = move-exception;
        throw a(r6, r7, String.format("problem: (%s) %s", new Object[]{e.getClass().getName(), com.fasterxml.jackson.databind.l.h.h(e)}));
    L9:
        return (k) ZeusTransformUtils.preCheckCast(b(r6, r7, r8), k.class, "com.obric.aiagent.plugin");
    L5:
        return a(r6, r7, r8, r0);
    }

    private k a(k r5, String r6, com.fasterxml.jackson.databind.h.c r7, int r8) {
        com.fasterxml.jackson.databind.a.m<?> r0 = a();
        com.fasterxml.jackson.databind.h.c.b r9 = r7.a(r0, r5, r6.substring(0, r8));
        if (r9 == com.fasterxml.jackson.databind.h.c.b.f12749b) goto L5;
        k r1 = b().d(r6);
        if (r1.b(r5.e()) == true) goto L11;
        return (k) ZeusTransformUtils.preCheckCast(a(r5, r6), k.class, "com.obric.aiagent.plugin");
    L11:
        if (r9 != com.fasterxml.jackson.databind.h.c.b.f12748a) goto L13;
    L16:
        return r1;
    L13:
        if (r7.a(r0, r5, r1) == com.fasterxml.jackson.databind.h.c.b.f12748a) goto L16;
        return (k) ZeusTransformUtils.preCheckCast(c(r5, r6, r7), k.class, "com.obric.aiagent.plugin");
    L5:
        return (k) ZeusTransformUtils.preCheckCast(b(r5, r6, r7), k.class, "com.obric.aiagent.plugin");
    }

    public <T> T a(k r2, String r3) {
        throw a(r2, r3, "Not a subtype");
    }

    public <T> T b(k r3, String r4, com.fasterxml.jackson.databind.h.c r5) {
        throw a(r3, r4, "Configured `PolymorphicTypeValidator` (of type " + com.fasterxml.jackson.databind.l.h.d(r5) + ") denied resolution");
    }

    public <T> T c(k r3, String r4, com.fasterxml.jackson.databind.h.c r5) {
        throw a(r3, r4, "Configured `PolymorphicTypeValidator` (of type " + com.fasterxml.jackson.databind.l.h.d(r5) + ") denied resolution");
    }

    public ObjectIdGenerator<?> a(com.fasterxml.jackson.databind.e.b r3, com.fasterxml.jackson.databind.e.ac r4) {
        Class<? extends ObjectIdGenerator<?>> r0 = r4.d();
        com.fasterxml.jackson.databind.a.m<?> r2 = a();
        com.fasterxml.jackson.databind.a.l r1 = r2.m();
        if (r1 != null) goto L5;
        ObjectIdGenerator<?> r5 = null;
    L6:
        if (r5 != null) goto L9;
        r5 = (ObjectIdGenerator) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r0, r2.g()), ObjectIdGenerator.class, "com.obric.aiagent.plugin");
    L9:
        return r5.forScope(r4.c());
    L5:
        r5 = r1.d(r2, r3, r0);
        goto L6
    }

    public ObjectIdResolver b(com.fasterxml.jackson.databind.e.b r2, com.fasterxml.jackson.databind.e.ac r3) {
        Class<? extends ObjectIdResolver> r4 = r3.e();
        com.fasterxml.jackson.databind.a.m<?> r1 = a();
        com.fasterxml.jackson.databind.a.l r0 = r1.m();
        if (r0 != null) goto L5;
        ObjectIdResolver r5 = null;
    L6:
        if (r5 == null) goto L8;
        return r5;
    L8:
        return (ObjectIdResolver) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r4, r1.g()), ObjectIdResolver.class, "com.obric.aiagent.plugin");
    L5:
        r5 = r0.e(r1, r2, r4);
        goto L6
    }

    public com.fasterxml.jackson.databind.l.j<Object, Object> a(com.fasterxml.jackson.databind.e.b r4, Object r5) {
        com.fasterxml.jackson.databind.l.j<?, ?> r0 = null;
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.l.j.class) == false) goto L10;
        return (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L29;
        Class<?> r6 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        if (r6 != com.fasterxml.jackson.databind.l.j.a.class) goto L14;
    L27:
        return null;
    L14:
        if (com.fasterxml.jackson.databind.l.h.e(r6) == true) goto L27;
        if (com.fasterxml.jackson.databind.l.j.class.isAssignableFrom(r6) == false) goto L26;
        com.fasterxml.jackson.databind.a.m<?> r3 = a();
        com.fasterxml.jackson.databind.a.l r1 = r3.m();
        if (r1 == null) goto L22;
        r0 = r1.g(r3, r4, r6);
    L22:
        if (r0 == null) goto L24;
        return r0;
    L24:
        return (com.fasterxml.jackson.databind.l.j) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r6, r3.g()), com.fasterxml.jackson.databind.l.j.class, "com.obric.aiagent.plugin");
    L26:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r6.getName() + "; expected Class<Converter>");
    L29:
        throw new IllegalStateException("AnnotationIntrospector returned Converter definition of type " + r5.getClass().getName() + "; expected type Converter or Class<Converter> instead");
    }

    public <T> T a(Class<?> r1, String r2) {
        return (T) b(a(r1), r2);
    }

    public final String a(String r1, Object... r2) {
        if (r2.length > 0) goto L5;
        return r1;
    L5:
        return String.format(r1, r2);
    }

    public final String a(String r3) {
        if (r3 != null) goto L6;
        return "";
    L6:
        if (r3.length() > 500) goto L9;
        return r3;
    L9:
        return r3.substring(0, 500) + "]...[" + r3.substring(r3.length() - 500);
    }

    public String b(String r3) {
        if (r3 != null) goto L6;
        return "[N/A]";
    L6:
        return String.format("\"%s\"", new Object[]{a(r3)});
    }

    public String a(String r1, String r2) {
        if (r2 != null) goto L5;
        return r1;
    L5:
        return r1 + ": " + r2;
    }
}
