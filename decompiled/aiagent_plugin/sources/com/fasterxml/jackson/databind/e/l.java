package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedMethodCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u.a f12636d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f12637e;

    /* JADX INFO: compiled from: AnnotatedMethodCollector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ag f12638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f12639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f12640c;

        public a(ag r3, Method r4, p r5) {
            this.f12638a = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
            this.f12639b = r4;
            this.f12640c = r5;
        }

        public k a() {
            if (this.f12639b != null) goto L6;
            return null;
        L6:
            return new k(this.f12638a, this.f12639b, this.f12640c.d(), null);
        }
    }

    l(com.fasterxml.jackson.databind.b r3, u.a r4, boolean r5) {
        u.a r6 = (u.a) ZeusTransformUtils.wrapperContextForParams(r4, u.a.class, "com.obric.aiagent.plugin");
        super(r3);
        if (r3 != null) goto L5;
        r6 = null;
    L5:
        this.f12636d = r6;
        this.f12637e = r5;
    }

    public static m a(com.fasterxml.jackson.databind.b r8, ag r9, u.a r10, com.fasterxml.jackson.databind.k.o r11, com.fasterxml.jackson.databind.k r12, List<com.fasterxml.jackson.databind.k> r13, Class<?> r14, boolean r15) {
        ag r4 = (ag) ZeusTransformUtils.wrapperContextForParams(r9, ag.class, "com.obric.aiagent.plugin");
        u.a r16 = (u.a) ZeusTransformUtils.wrapperContextForParams(r10, u.a.class, "com.obric.aiagent.plugin");
        List<com.fasterxml.jackson.databind.k> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.aiagent.plugin");
        return new l(r8, r16, r15).a(r11, r4, r12, r6, r14);
    }

    m a(com.fasterxml.jackson.databind.k.o r6, ag r7, com.fasterxml.jackson.databind.k r8, List<com.fasterxml.jackson.databind.k> r9, Class<?> r10) {
        ag r11 = (ag) ZeusTransformUtils.wrapperContextForParams(r7, ag.class, "com.obric.aiagent.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.aiagent.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        b(r11, r8.e(), r0, r10);
        Iterator r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.k r14 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r13.next(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        u.a r2 = this.f12636d;
        if (r2 != null) goto L8;
        Class<?> r3 = null;
    L9:
        b(new ag.a(r6, r14.A()), r14.e(), r0, r3);
        goto L4
    L8:
        r3 = r2.j(r14.e());
        goto L9
    L10:
        u.a r15 = this.f12636d;
        if (r15 == null) goto L15;
        Class<?> r16 = r15.j(Object.class);
        if (r16 == null) goto L15;
        a(r11, r8.e(), r0, r16);
        boolean r17 = true;
    L16:
        if (r17 == false) goto L34;
        if (this.f12671c == null) goto L34;
        if (r0.isEmpty() == true) goto L34;
        Iterator<Map.Entry<z, a>> r18 = r0.entrySet().iterator();
    L23:
        if (r18.hasNext() == false) goto L34;
        Map.Entry r19 = (Map.Entry) ZeusTransformUtils.preCheckCast(r18.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        z r20 = (z) ZeusTransformUtils.preCheckCast(r19.getKey(), z.class, "com.obric.aiagent.plugin");
        if ("hashCode".equals(r20.a()) == false) goto L23;
        if (r20.b() != 0) goto L23;
        Method r21 = Object.class.getDeclaredMethod(r20.a(), new Class[0]);     // Catch: Exception -> L45
        if (r21 == null) goto L23;
        a r22 = (a) ZeusTransformUtils.preCheckCast(r19.getValue(), a.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L45
        r22.f12640c = b(r22.f12640c, r21.getDeclaredAnnotations());     // Catch: Exception -> L45
        r22.f12639b = r21;     // Catch: Exception -> L45
    L34:
        if (r0.isEmpty() == true) goto L36;
        LinkedHashMap r5 = new LinkedHashMap(r0.size());
        Iterator<Map.Entry<z, a>> r23 = r0.entrySet().iterator();
    L39:
        if (r23.hasNext() == false) goto L44;
        Map.Entry r24 = (Map.Entry) ZeusTransformUtils.preCheckCast(r23.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        k r25 = ((a) ZeusTransformUtils.preCheckCast(r24.getValue(), a.class, "com.obric.aiagent.plugin")).a();
        if (r25 == null) goto L39;
        r5.put(r24.getKey(), r25);
        goto L39
    L44:
        return new m(r5);
    L36:
        return new m();
    L15:
        r17 = false;
        goto L16
    }

    private void b(ag r7, Class<?> r8, Map<z, a> r9, Class<?> r10) {
        ag r11 = (ag) ZeusTransformUtils.wrapperContextForParams(r7, ag.class, "com.obric.aiagent.plugin");
        Map<z, a> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L5;
        a(r11, r8, r12, r10);
    L5:
        if (r8 != null) goto L7;
        return;
    L7:
        Method[] r13 = com.fasterxml.jackson.databind.l.h.s(r8);
        int r14 = r13.length;
        int r0 = 0;
    L8:
        if (r0 >= r14) goto L31;
        Method r2 = r13[r0];
        if (a(r2) == false) goto L30;
        z r3 = new z(r2);
        a r4 = (a) ZeusTransformUtils.preCheckCast(r12.get(r3), a.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L20;
        if (this.f12671c != null) goto L17;
        p r5 = p.b();
    L18:
        r12.put(r3, new a(r11, r2, r5));
        goto L30
    L17:
        r5 = a(r2.getDeclaredAnnotations());
        goto L18
    L20:
        if (this.f12637e == false) goto L22;
        r4.f12640c = b(r4.f12640c, r2.getDeclaredAnnotations());
    L22:
        Method r6 = r4.f12639b;
        if (r6 != null) goto L26;
        r4.f12639b = r2;
        goto L30
    L26:
        if (Modifier.isAbstract(r6.getModifiers()) == false) goto L30;
        if (Modifier.isAbstract(r2.getModifiers()) == true) goto L30;
        r4.f12639b = r2;
        r4.f12638a = r11;
    L30:
        r0 = r0 + 1;
        goto L8
    }

    public void a(ag r8, Class<?> r9, Map<z, a> r10, Class<?> r11) {
        ag r12 = (ag) ZeusTransformUtils.wrapperContextForParams(r8, ag.class, "com.obric.aiagent.plugin");
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (this.f12671c != null) goto L5;
        return;
    L5:
        Iterator<Class<?>> r14 = com.fasterxml.jackson.databind.l.h.a(r11, r9, true).iterator();
    L7:
        if (r14.hasNext() == false) goto L18;
        Method[] r15 = ((Class) ZeusTransformUtils.preCheckCast(r14.next(), Class.class, "com.obric.aiagent.plugin")).getDeclaredMethods();
        int r0 = r15.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L7;
        Method r3 = r15[r2];
        if (a(r3) == false) goto L17;
        z r4 = new z(r3);
        a r5 = (a) ZeusTransformUtils.preCheckCast(r13.get(r4), a.class, "com.obric.aiagent.plugin");
        Annotation[] r6 = r3.getDeclaredAnnotations();
        if (r5 != null) goto L16;
        r13.put(r4, new a(r12, null, a(r6)));
        goto L17
    L16:
        r5.f12640c = b(r5.f12640c, r6);
    L17:
        r2 = r2 + 1;
        goto L9
    }

    private static boolean a(Method r2) {
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L5;
        return false;
    L5:
        if (r2.isSynthetic() == false) goto L7;
        return false;
    L7:
        if (r2.isBridge() == false) goto L10;
        return false;
    L10:
        if (r2.getParameterTypes().length > 2) goto L15;
        return true;
    L15:
        return false;
    }
}
