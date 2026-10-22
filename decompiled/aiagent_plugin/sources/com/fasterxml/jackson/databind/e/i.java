package com.fasterxml.jackson.databind.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: AnnotatedFieldCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public class i extends v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.fasterxml.jackson.databind.k.o f12627d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u.a f12628e;
    private final boolean f;

    /* JADX INFO: compiled from: AnnotatedFieldCollector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ag f12629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Field f12630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public p f12631c;

        public a(ag r3, Field r4) {
            this.f12629a = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
            this.f12630b = r4;
            this.f12631c = p.b();
        }

        public h a() {
            return new h(this.f12629a, this.f12630b, this.f12631c.d());
        }
    }

    i(com.fasterxml.jackson.databind.b r3, com.fasterxml.jackson.databind.k.o r4, u.a r5, boolean r6) {
        u.a r7 = (u.a) ZeusTransformUtils.wrapperContextForParams(r5, u.a.class, "com.obric.aiagent.plugin");
        super(r3);
        this.f12627d = r4;
        if (r3 != null) goto L5;
        r7 = null;
    L5:
        this.f12628e = r7;
        this.f = r6;
    }

    public static List<h> a(com.fasterxml.jackson.databind.b r2, ag r3, u.a r4, com.fasterxml.jackson.databind.k.o r5, com.fasterxml.jackson.databind.k r6, boolean r7) {
        ag r8 = (ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin");
        return new i(r2, r5, (u.a) ZeusTransformUtils.wrapperContextForParams(r4, u.a.class, "com.obric.aiagent.plugin"), r7).a(r8, r6);
    }

    List<h> a(ag r3, com.fasterxml.jackson.databind.k r4) {
        Map<String, a> r2 = a((ag) ZeusTransformUtils.wrapperContextForParams(r3, ag.class, "com.obric.aiagent.plugin"), r4, null);
        if (r2 == null) goto L5;
        ArrayList r5 = new ArrayList(r2.size());
        Iterator<a> r6 = r2.values().iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        r5.add(((a) ZeusTransformUtils.preCheckCast(r6.next(), a.class, "com.obric.aiagent.plugin")).a());
        goto L8
    L10:
        return r5;
    L5:
        return Collections.emptyList();
    }

    private Map<String, a> a(ag r8, com.fasterxml.jackson.databind.k r9, Map<String, a> r10) {
        ag r11 = (ag) ZeusTransformUtils.wrapperContextForParams(r8, ag.class, "com.obric.aiagent.plugin");
        Map<String, a> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.k r0 = r9.B();
        if (r0 != null) goto L5;
        return r12;
    L5:
        Class<?> r13 = r9.e();
        Map<String, a> r14 = a(new ag.a(this.f12627d, r0.A()), r0, r12);
        Field[] r1 = r13.getDeclaredFields();
        int r2 = r1.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L17;
        Field r4 = r1[r3];
        if (a(r4) == false) goto L16;
        if (r14 != null) goto L12;
        r14 = new LinkedHashMap();
    L12:
        a r5 = new a(r11, r4);
        if (this.f == false) goto L15;
        r5.f12631c = a(r5.f12631c, r4.getDeclaredAnnotations());
    L15:
        r14.put(r4.getName(), r5);
    L16:
        r3 = r3 + 1;
        goto L6
    L17:
        if (r14 == null) goto L23;
        u.a r15 = this.f12628e;
        if (r15 == null) goto L23;
        Class<?> r16 = r15.j(r13);
        if (r16 == null) goto L23;
        a(r16, r13, r14);
    L23:
        return r14;
    }

    private void a(Class<?> r7, Class<?> r8, Map<String, a> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Iterator<Class<?>> r11 = com.fasterxml.jackson.databind.l.h.b(r7, r8, true).iterator();
    L4:
        if (r11.hasNext() == false) goto L14;
        Field[] r12 = ((Class) ZeusTransformUtils.preCheckCast(r11.next(), Class.class, "com.obric.aiagent.plugin")).getDeclaredFields();
        int r0 = r12.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L4;
        Field r3 = r12[r2];
        if (a(r3) == false) goto L13;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r10.get(r3.getName()), a.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L13;
        r4.f12631c = a(r4.f12631c, r3.getDeclaredAnnotations());
    L13:
        r2 = r2 + 1;
        goto L6
    }

    private boolean a(Field r2) {
        if (r2.isSynthetic() == false) goto L6;
        return false;
    L6:
        if (Modifier.isStatic(r2.getModifiers()) == false) goto L8;
        return false;
    L8:
        return true;
    }
}
