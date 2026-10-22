package com.fasterxml.jackson.databind.h.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StdSubtypeResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class n extends com.fasterxml.jackson.databind.h.d implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected LinkedHashSet<com.fasterxml.jackson.databind.h.b> f12724a;

    public n() {
    }

    @Override // com.fasterxml.jackson.databind.h.d
    public Collection<com.fasterxml.jackson.databind.h.b> a(com.fasterxml.jackson.databind.a.m<?> r11, com.fasterxml.jackson.databind.e.j r12, com.fasterxml.jackson.databind.k r13) {
        com.fasterxml.jackson.databind.b r6 = r11.j();
        if (r13 == null) goto L5;
        Class<?> r14 = r13.e();
    L7:
        HashMap<com.fasterxml.jackson.databind.h.b, com.fasterxml.jackson.databind.h.b> r7 = new HashMap();
        LinkedHashSet<com.fasterxml.jackson.databind.h.b> r0 = this.f12724a;
        if (r0 == null) goto L15;
        Iterator<com.fasterxml.jackson.databind.h.b> r9 = r0.iterator();
    L11:
        if (r9.hasNext() == false) goto L15;
        com.fasterxml.jackson.databind.h.b r2 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r9.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        if (r14.isAssignableFrom(r2.getType()) == false) goto L11;
        a(com.fasterxml.jackson.databind.e.e.a(r11, r2.getType()), r2, r11, r6, r7);
    L15:
        if (r12 == null) goto L22;
        List<com.fasterxml.jackson.databind.h.b> r15 = r6.d(r12);
        if (r15 == null) goto L22;
        Iterator<com.fasterxml.jackson.databind.h.b> r16 = r15.iterator();
    L20:
        if (r16.hasNext() == false) goto L22;
        com.fasterxml.jackson.databind.h.b r3 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r16.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        a(com.fasterxml.jackson.databind.e.e.a(r11, r3.getType()), r3, r11, r6, r7);
    L22:
        com.fasterxml.jackson.databind.h.b r4 = new com.fasterxml.jackson.databind.h.b(r14, null);
        a(com.fasterxml.jackson.databind.e.e.a(r11, r14), r4, r11, r6, r7);
        return new ArrayList(r7.values());
    L5:
        if (r12 == null) goto L25;
        r14 = r12.c();
        goto L7
    L25:
        throw new IllegalArgumentException("Both property and base type are nulls");
    }

    @Override // com.fasterxml.jackson.databind.h.d
    public Collection<com.fasterxml.jackson.databind.h.b> a(com.fasterxml.jackson.databind.a.m<?> r11, com.fasterxml.jackson.databind.e.d r12) {
        com.fasterxml.jackson.databind.b r6 = r11.j();
        HashMap<com.fasterxml.jackson.databind.h.b, com.fasterxml.jackson.databind.h.b> r7 = new HashMap();
        if (this.f12724a == null) goto L10;
        Class<?> r8 = r12.c();
        Iterator<com.fasterxml.jackson.databind.h.b> r9 = this.f12724a.iterator();
    L6:
        if (r9.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.h.b r2 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r9.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        if (r8.isAssignableFrom(r2.getType()) == false) goto L6;
        a(com.fasterxml.jackson.databind.e.e.a(r11, r2.getType()), r2, r11, r6, r7);
    L10:
        a(r12, new com.fasterxml.jackson.databind.h.b(r12.c(), null), r11, r6, r7);
        return new ArrayList(r7.values());
    }

    @Override // com.fasterxml.jackson.databind.h.d
    public Collection<com.fasterxml.jackson.databind.h.b> b(com.fasterxml.jackson.databind.a.m<?> r11, com.fasterxml.jackson.databind.e.j r12, com.fasterxml.jackson.databind.k r13) {
        com.fasterxml.jackson.databind.b r0 = r11.j();
        Class<?> r14 = r13.e();
        HashSet r7 = new HashSet();
        LinkedHashMap r8 = new LinkedHashMap();
        com.fasterxml.jackson.databind.h.b r3 = new com.fasterxml.jackson.databind.h.b(r14, null);
        a(com.fasterxml.jackson.databind.e.e.a(r11, r14), r3, r11, r7, r8);
        if (r12 == null) goto L10;
        List<com.fasterxml.jackson.databind.h.b> r15 = r0.d(r12);
        if (r15 == null) goto L10;
        Iterator<com.fasterxml.jackson.databind.h.b> r16 = r15.iterator();
    L8:
        if (r16.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.h.b r4 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r16.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        a(com.fasterxml.jackson.databind.e.e.a(r11, r4.getType()), r4, r11, r7, r8);
    L10:
        LinkedHashSet<com.fasterxml.jackson.databind.h.b> r17 = this.f12724a;
        if (r17 == null) goto L19;
        Iterator<com.fasterxml.jackson.databind.h.b> r18 = r17.iterator();
    L14:
        if (r18.hasNext() == false) goto L19;
        com.fasterxml.jackson.databind.h.b r5 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r18.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        if (r14.isAssignableFrom(r5.getType()) == false) goto L14;
        a(com.fasterxml.jackson.databind.e.e.a(r11, r5.getType()), r5, r11, r7, r8);
    L19:
        return a(r14, r7, r8);
    }

    @Override // com.fasterxml.jackson.databind.h.d
    public Collection<com.fasterxml.jackson.databind.h.b> b(com.fasterxml.jackson.databind.a.m<?> r10, com.fasterxml.jackson.databind.e.d r11) {
        Class<?> r0 = r11.c();
        HashSet r7 = new HashSet();
        LinkedHashMap r8 = new LinkedHashMap();
        a(r11, new com.fasterxml.jackson.databind.h.b(r0, null), r10, r7, r8);
        LinkedHashSet<com.fasterxml.jackson.databind.h.b> r12 = this.f12724a;
        if (r12 == null) goto L11;
        Iterator<com.fasterxml.jackson.databind.h.b> r13 = r12.iterator();
    L6:
        if (r13.hasNext() == false) goto L11;
        com.fasterxml.jackson.databind.h.b r3 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r13.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        if (r0.isAssignableFrom(r3.getType()) == false) goto L6;
        a(com.fasterxml.jackson.databind.e.e.a(r10, r3.getType()), r3, r10, r7, r8);
    L11:
        return a(r0, r7, r8);
    }

    public void a(com.fasterxml.jackson.databind.e.d r10, com.fasterxml.jackson.databind.h.b r11, com.fasterxml.jackson.databind.a.m<?> r12, com.fasterxml.jackson.databind.b r13, HashMap<com.fasterxml.jackson.databind.h.b, com.fasterxml.jackson.databind.h.b> r14) {
        if (r11.b() == true) goto L7;
        String r0 = r13.d(r10);
        if (r0 == null) goto L7;
        r11 = new com.fasterxml.jackson.databind.h.b(r11.getType(), r0);
    L7:
        com.fasterxml.jackson.databind.h.b r1 = new com.fasterxml.jackson.databind.h.b(r11.getType());
        if (r14.containsKey(r1) == true) goto L10;
        r14.put(r1, r11);
        List<com.fasterxml.jackson.databind.h.b> r15 = r13.d(r10);
        if (r15 != null) goto L18;
        return;
    L18:
        if (r15.isEmpty() == true) goto L27;
        Iterator<com.fasterxml.jackson.databind.h.b> r16 = r15.iterator();
    L21:
        if (r16.hasNext() == false) goto L28;
        com.fasterxml.jackson.databind.h.b r5 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r16.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        a(com.fasterxml.jackson.databind.e.e.a(r12, r5.getType()), r5, r12, r13, r14);
        goto L21
    L28:
        return;
    L27:
        return;
    L10:
        if (r11.b() == true) goto L12;
        return;
    L12:
        if (((com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r14.get(r1), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin")).b() == true) goto L26;
        r14.put(r1, r11);
        return;
    }

    public void a(com.fasterxml.jackson.databind.e.d r9, com.fasterxml.jackson.databind.h.b r10, com.fasterxml.jackson.databind.a.m<?> r11, Set<Class<?>> r12, Map<String, com.fasterxml.jackson.databind.h.b> r13) {
        Set<Class<?>> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        Map<String, com.fasterxml.jackson.databind.h.b> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r0 = r11.j();
        if (r10.b() == true) goto L8;
        String r2 = r0.d(r9);
        if (r2 == null) goto L8;
        r10 = new com.fasterxml.jackson.databind.h.b(r10.getType(), r2);
    L8:
        if (r10.b() == false) goto L11;
        r15.put(r10.a(), r10);
    L11:
        if (r14.add(r10.getType()) == false) goto L20;
        List<com.fasterxml.jackson.databind.h.b> r16 = r0.d(r9);
        if (r16 != null) goto L15;
        return;
    L15:
        if (r16.isEmpty() == true) goto L23;
        Iterator<com.fasterxml.jackson.databind.h.b> r17 = r16.iterator();
    L18:
        if (r17.hasNext() == false) goto L24;
        com.fasterxml.jackson.databind.h.b r4 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r17.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        a(com.fasterxml.jackson.databind.e.e.a(r11, r4.getType()), r4, r11, r14, r15);
        goto L18
    L24:
        return;
    L23:
        return;
    }

    public Collection<com.fasterxml.jackson.databind.h.b> a(Class<?> r4, Set<Class<?>> r5, Map<String, com.fasterxml.jackson.databind.h.b> r6) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        ArrayList r8 = new ArrayList(r7.values());
        Iterator r9 = r7.values().iterator();
    L4:
        if (r9.hasNext() == false) goto L6;
        r3.remove(((com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r9.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin")).getType());
        goto L4
    L6:
        Iterator r10 = r3.iterator();
    L8:
        if (r10.hasNext() == false) goto L15;
        Class<?> r11 = (Class) ZeusTransformUtils.preCheckCast(r10.next(), Class.class, "com.obric.aiagent.plugin");
        if (r11 != r4) goto L14;
        if (Modifier.isAbstract(r11.getModifiers()) == true) goto L8;
    L14:
        r8.add(new com.fasterxml.jackson.databind.h.b(r11));
        goto L8
    L15:
        return r8;
    }
}
