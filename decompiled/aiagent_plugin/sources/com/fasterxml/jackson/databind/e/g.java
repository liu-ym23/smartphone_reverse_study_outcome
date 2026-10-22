package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: AnnotatedCreatorCollector.java */
/* JADX INFO: loaded from: classes2.dex */
final class g extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ag f12624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f12625e;
    private f f;

    g(com.fasterxml.jackson.databind.b r3, ag r4, boolean r5) {
        ag r6 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12624d = r6;
        this.f12625e = r5;
    }

    public static d.a a(com.fasterxml.jackson.databind.b r2, com.fasterxml.jackson.databind.k.o r3, ag r4, com.fasterxml.jackson.databind.k r5, Class<?> r6, boolean r7) {
        ag r8 = (ag) ZeusTransformUtils.wrapperContextForParams(r4, ag.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L5;
        boolean r0 = true;
    L7:
        return new g(r2, r8, r7 | r0).a(r3, r5, r6);
    L5:
        r0 = false;
        goto L7
    }

    d.a a(com.fasterxml.jackson.databind.k.o r5, com.fasterxml.jackson.databind.k r6, Class<?> r7) {
        List<f> r0 = a(r6, r7);
        List<k> r8 = b(r5, r6, r7);
        if (this.f12625e == false) goto L22;
        if (this.f != null) goto L7;
    L9:
        int r9 = r0.size();
    L10:
        r9 = r9 - 1;
        if (r9 < 0) goto L15;
        if (this.f12671c.d((j) ZeusTransformUtils.preCheckCast(r0.get(r9), j.class, "com.obric.aiagent.plugin")) == false) goto L10;
        r0.remove(r9);
        goto L10
    L15:
        int r10 = r8.size();
    L16:
        r10 = r10 - 1;
        if (r10 < 0) goto L22;
        if (this.f12671c.d((j) ZeusTransformUtils.preCheckCast(r8.get(r10), j.class, "com.obric.aiagent.plugin")) == false) goto L16;
        r8.remove(r10);
        goto L16
    L7:
        if (this.f12671c.d(this.f) == false) goto L9;
        this.f = null;
    L22:
        return new d.a(this.f, r0, r8);
    }

    private List<f> a(com.fasterxml.jackson.databind.k r18, Class<?> r19) {
        if (r18.k() == true) goto L16;
        com.fasterxml.jackson.databind.l.h.a[] r1 = com.fasterxml.jackson.databind.l.h.t(r18.e());
        int r4 = r1.length;
        com.fasterxml.jackson.databind.l.h.a r6 = null;
        ArrayList r7 = null;
        int r5 = 0;
    L5:
        if (r5 >= r4) goto L17;
        com.fasterxml.jackson.databind.l.h.a r8 = r1[r5];
        if (a(r8.a()) == false) goto L15;
        if (r8.b() != 0) goto L12;
        r6 = r8;
        goto L15
    L12:
        if (r7 != null) goto L14;
        r7 = new ArrayList();
    L14:
        r7.add(r8);
    L15:
        r5 = r5 + 1;
    L17:
        if (r7 != null) goto L22;
        List<f> r2 = Collections.emptyList();
        if (r6 != null) goto L21;
        return r2;
    L21:
        int r9 = 0;
    L27:
        if (r19 == null) goto L46;
        com.fasterxml.jackson.databind.l.h.a[] r10 = com.fasterxml.jackson.databind.l.h.t(r19);
        int r11 = r10.length;
        z[] r12 = null;
        int r13 = 0;
    L29:
        if (r13 >= r11) goto L46;
        com.fasterxml.jackson.databind.l.h.a r14 = r10[r13];
        if (r14.b() != 0) goto L34;
        if (r6 == null) goto L45;
        this.f = a(r6, r14);
        r6 = null;
    L45:
        r13 = r13 + 1;
        goto L29
    L34:
        if (r7 == null) goto L45;
        if (r12 != null) goto L39;
        r12 = new z[r9];
        int r15 = 0;
    L37:
        if (r15 >= r9) goto L39;
        r12[r15] = new z(((com.fasterxml.jackson.databind.l.h.a) ZeusTransformUtils.preCheckCast(r7.get(r15), com.fasterxml.jackson.databind.l.h.a.class, "com.obric.aiagent.plugin")).a());
        r15 = r15 + 1;
    L39:
        z r3 = new z(r14.a());
        int r16 = 0;
    L40:
        if (r16 >= r9) goto L45;
        if (r3.equals(r12[r16]) == true) goto L43;
        r16 = r16 + 1;
        goto L40
    L43:
        r2.set(r16, b((com.fasterxml.jackson.databind.l.h.a) ZeusTransformUtils.preCheckCast(r7.get(r16), com.fasterxml.jackson.databind.l.h.a.class, "com.obric.aiagent.plugin"), r14));
    L46:
        if (r6 == null) goto L48;
        this.f = a(r6, null);
    L48:
        int r17 = 0;
    L49:
        if (r17 >= r9) goto L54;
        if (((f) ZeusTransformUtils.preCheckCast(r2.get(r17), f.class, "com.obric.aiagent.plugin")) != null) goto L53;
        r2.set(r17, b((com.fasterxml.jackson.databind.l.h.a) ZeusTransformUtils.preCheckCast(r7.get(r17), com.fasterxml.jackson.databind.l.h.a.class, "com.obric.aiagent.plugin"), null));
    L53:
        r17 = r17 + 1;
        goto L49
    L54:
        return r2;
    L22:
        int r20 = r7.size();
        ArrayList r21 = new ArrayList(r20);
        int r22 = 0;
    L23:
        if (r22 >= r20) goto L25;
        r21.add(null);
        r22 = r22 + 1;
        goto L23
    L25:
        r9 = r20;
        r2 = r21;
        goto L27
    L16:
        r6 = null;
        r7 = null;
        goto L17
    }

    private List<k> b(com.fasterxml.jackson.databind.k.o r17, com.fasterxml.jackson.databind.k r18, Class<?> r19) {
        Method[] r1 = com.fasterxml.jackson.databind.l.h.s(r18.e());
        int r2 = r1.length;
        ArrayList r6 = null;
        int r5 = 0;
    L3:
        if (r5 >= r2) goto L11;
        Method r7 = r1[r5];
        if (a(r7) == false) goto L10;
        if (r6 != null) goto L9;
        r6 = new ArrayList();
    L9:
        r6.add(r7);
    L10:
        r5 = r5 + 1;
        goto L3
    L11:
        if (r6 == null) goto L13;
        ag r3 = this.f12624d;
        int r4 = r6.size();
        ArrayList r8 = new ArrayList(r4);
        int r9 = 0;
    L15:
        if (r9 >= r4) goto L18;
        r8.add(null);
        r9 = r9 + 1;
        goto L15
    L18:
        if (r19 == null) goto L35;
        Method[] r10 = r19.getDeclaredMethods();
        int r11 = r10.length;
        z[] r12 = null;
        int r13 = 0;
    L20:
        if (r13 >= r11) goto L35;
        Method r14 = r10[r13];
        if (a(r14) == false) goto L34;
        if (r12 != null) goto L28;
        r12 = new z[r4];
        int r15 = 0;
    L26:
        if (r15 >= r4) goto L28;
        r12[r15] = new z((Method) ZeusTransformUtils.preCheckCast(r6.get(r15), Method.class, "com.obric.aiagent.plugin"));
        r15 = r15 + 1;
    L28:
        z r16 = new z(r14);
        int r110 = 0;
    L29:
        if (r110 >= r4) goto L34;
        if (r16.equals(r12[r110]) == true) goto L32;
        r110 = r110 + 1;
        goto L29
    L32:
        r8.set(r110, a((Method) ZeusTransformUtils.preCheckCast(r6.get(r110), Method.class, "com.obric.aiagent.plugin"), r3, r14));
    L34:
        r13 = r13 + 1;
    L35:
        int r20 = 0;
    L36:
        if (r20 >= r4) goto L42;
        if (((k) ZeusTransformUtils.preCheckCast(r8.get(r20), k.class, "com.obric.aiagent.plugin")) != null) goto L41;
        Method r21 = (Method) ZeusTransformUtils.preCheckCast(r6.get(r20), Method.class, "com.obric.aiagent.plugin");
        r8.set(r20, a(r21, aa.a(r21, r18, r17, r3), null));
    L41:
        r20 = r20 + 1;
        goto L36
    L42:
        return r8;
    L13:
        return Collections.emptyList();
    }

    private static boolean a(Method r1) {
        if (Modifier.isStatic(r1.getModifiers()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.isSynthetic() == true) goto L7;
        return true;
    }

    public f a(com.fasterxml.jackson.databind.l.h.a r4, com.fasterxml.jackson.databind.l.h.a r5) {
        return new f(this.f12624d, r4.a(), c(r4, r5), f12669a);
    }

    public f b(com.fasterxml.jackson.databind.l.h.a r10, com.fasterxml.jackson.databind.l.h.a r11) {
        int r0 = r10.b();
        if (this.f12671c == null) goto L5;
        if (r0 == 0) goto L8;
        Annotation[][] r1 = r10.e();
        q[] r4 = null;
        if (r0 == r1.length) goto L26;
        Class<?> r2 = r10.c();
        if (com.fasterxml.jackson.databind.l.h.l(r2) == false) goto L18;
        if (r0 != (r1.length + 2)) goto L18;
        Annotation[][] r3 = new Annotation[r1.length + 2][];
        System.arraycopy(r1, 0, r3, 2, r1.length);
        r4 = a(r3, (Annotation[][]) ZeusTransformUtils.preCheckCast(null, Annotation[][].class, "com.obric.aiagent.plugin"));
    L16:
        r1 = r3;
    L22:
        if (r4 != null) goto L31;
        throw new IllegalStateException(String.format("Internal error: constructor for %s has mismatch: %d parameters; %d sets of annotations", new Object[]{r10.c().getName(), Integer.valueOf(r0), Integer.valueOf(r1.length)}));
    L31:
        return new f(this.f12624d, r10.a(), c(r10, r11), r4);
    L18:
        if (r2.isMemberClass() == false) goto L22;
        if (r0 != (r1.length + 1)) goto L22;
        r3 = new Annotation[r1.length + 1][];
        System.arraycopy(r1, 0, r3, 1, r1.length);
        r3[0] = f12670b;
        r4 = a(r3, (Annotation[][]) ZeusTransformUtils.preCheckCast(null, Annotation[][].class, "com.obric.aiagent.plugin"));
        goto L16
    L26:
        if (r11 != null) goto L28;
        Annotation[][] r5 = (Annotation[][]) ZeusTransformUtils.preCheckCast(null, Annotation[][].class, "com.obric.aiagent.plugin");
    L29:
        r4 = a(r1, r5);
        goto L31
    L28:
        r5 = r11.e();
        goto L29
    L8:
        return new f(this.f12624d, r10.a(), c(r10, r11), f12669a);
    L5:
        return new f(this.f12624d, r10.a(), a(), a(r0));
    }

    public k a(Method r6, ag r7, Method r8) {
        ag r9 = (ag) ZeusTransformUtils.wrapperContextForParams(r7, ag.class, "com.obric.aiagent.plugin");
        int r0 = r6.getParameterTypes().length;
        if (this.f12671c == null) goto L5;
        if (r0 == 0) goto L8;
        q r2 = a(r6, r8);
        Annotation[][] r3 = r6.getParameterAnnotations();
        if (r8 != null) goto L12;
        Annotation[][] r10 = (Annotation[][]) ZeusTransformUtils.preCheckCast(null, Annotation[][].class, "com.obric.aiagent.plugin");
    L14:
        return new k(r9, r6, r2, a(r3, r10));
    L12:
        r10 = r8.getParameterAnnotations();
        goto L14
    L8:
        return new k(r9, r6, a(r6, r8), f12669a);
    L5:
        return new k(r9, r6, a(), a(r0));
    }

    private q[] a(Annotation[][] r6, Annotation[][] r7) {
        if (this.f12625e == false) goto L12;
        int r0 = r6.length;
        q[] r1 = new q[r0];
        int r2 = 0;
    L5:
        if (r2 >= r0) goto L10;
        p r3 = a(p.b(), r6[r2]);
        if (r7 == null) goto L9;
        r3 = a(r3, r7[r2]);
    L9:
        r1[r2] = r3.d();
        r2 = r2 + 1;
        goto L5
    L10:
        return r1;
    L12:
        return f12669a;
    }

    private q c(com.fasterxml.jackson.databind.l.h.a r2, com.fasterxml.jackson.databind.l.h.a r3) {
        if (this.f12625e == false) goto L10;
        p r4 = a(r2.d());
        if (r3 == null) goto L8;
        r4 = a(r4, r3.d());
    L8:
        return r4.d();
    L10:
        return a();
    }

    private final q a(AnnotatedElement r3, AnnotatedElement r4) {
        AnnotatedElement r5 = (AnnotatedElement) ZeusTransformUtils.wrapperContextForParams(r3, AnnotatedElement.class, "com.obric.aiagent.plugin");
        AnnotatedElement r6 = (AnnotatedElement) ZeusTransformUtils.wrapperContextForParams(r4, AnnotatedElement.class, "com.obric.aiagent.plugin");
        p r7 = a(r5.getDeclaredAnnotations());
        if (r6 == null) goto L6;
        r7 = a(r7, r6.getDeclaredAnnotations());
    L6:
        return r7.d();
    }

    private static boolean a(Constructor<?> r0) {
        return !r0.isSynthetic();
    }
}
