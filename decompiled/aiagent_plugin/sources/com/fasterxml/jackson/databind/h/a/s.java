package com.fasterxml.jackson.databind.h.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: TypeNameIdResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.m<?> f12740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final ConcurrentHashMap<String, String> f12741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final Map<String, com.fasterxml.jackson.databind.k> f12742c;
    protected final boolean f;

    public s(com.fasterxml.jackson.databind.a.m<?> r2, com.fasterxml.jackson.databind.k r3, ConcurrentHashMap<String, String> r4, HashMap<String, com.fasterxml.jackson.databind.k> r5) {
        super(r3, r2.o());
        this.f12740a = r2;
        this.f12741b = r4;
        this.f12742c = r5;
        this.f = r2.a(com.fasterxml.jackson.databind.r.x);
    }

    public static s a(com.fasterxml.jackson.databind.a.m<?> r8, com.fasterxml.jackson.databind.k r9, Collection<com.fasterxml.jackson.databind.h.b> r10, boolean r11, boolean r12) {
        Collection r13 = (Collection) ZeusTransformUtils.wrapperContextForParams(r10, Collection.class, "com.obric.aiagent.plugin");
        if (r11 == r12) goto L30;
        if (r11 == false) goto L6;
        ConcurrentHashMap r0 = new ConcurrentHashMap();
        HashMap r2 = null;
    L7:
        boolean r3 = r8.a(com.fasterxml.jackson.databind.r.x);
        if (r13 == null) goto L28;
        Iterator r14 = r13.iterator();
    L11:
        if (r14.hasNext() == false) goto L28;
        com.fasterxml.jackson.databind.h.b r4 = (com.fasterxml.jackson.databind.h.b) ZeusTransformUtils.preCheckCast(r14.next(), com.fasterxml.jackson.databind.h.b.class, "com.obric.aiagent.plugin");
        Class<?> r5 = r4.getType();
        if (r4.b() == false) goto L15;
        String r6 = r4.a();
    L16:
        if (r11 == false) goto L18;
        r0.put(r5.getName(), r6);
    L18:
        if (r12 == false) goto L11;
        if (r3 == false) goto L21;
        r6 = r6.toLowerCase();
    L21:
        com.fasterxml.jackson.databind.k r7 = (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r2.get(r6), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L26;
        if (r5.isAssignableFrom(r7.e()) == true) goto L11;
    L26:
        r2.put(r6, r8.b(r5));
        goto L11
    L15:
        r6 = b(r5);
    L28:
        return new s(r8, r9, r0, r2);
    L6:
        r2 = new HashMap();
        r0 = new ConcurrentHashMap(4);
        goto L7
    L30:
        throw new IllegalArgumentException();
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String a(Object r1) {
        return a(r1.getClass());
    }

    public String a(Class<?> r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        String r0 = r5.getName();
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f12741b.get(r0), String.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        Class<?> r6 = this.f12738d.a(r5).e();
        if (this.f12740a.f() == false) goto L10;
        com.fasterxml.jackson.databind.c r2 = this.f12740a.c(r6);
        r1 = this.f12740a.j().d(r2.c());
    L10:
        if (r1 != null) goto L12;
        r1 = b(r6);
    L12:
        this.f12741b.put(r0, r1);
    L13:
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.h.f
    public String a(Object r1, Class<?> r2) {
        if (r1 != null) goto L6;
        return a(r2);
    L6:
        return a(r1);
    }

    @Override // com.fasterxml.jackson.databind.h.a.r, com.fasterxml.jackson.databind.h.f
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.e r1, String r2) {
        return a(r2);
    }

    public com.fasterxml.jackson.databind.k a(String r2) {
        if (this.f == false) goto L6;
        r2 = r2.toLowerCase();
    L6:
        return (com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(this.f12742c.get(r2), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.h.a.r, com.fasterxml.jackson.databind.h.f
    public String b() {
        TreeSet r0 = new TreeSet();
        Iterator<Map.Entry<String, com.fasterxml.jackson.databind.k>> r5 = this.f12742c.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L9;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        if (((com.fasterxml.jackson.databind.k) ZeusTransformUtils.preCheckCast(r1.getValue(), com.fasterxml.jackson.databind.k.class, "com.obric.aiagent.plugin")).h() == false) goto L4;
        r0.add(r1.getKey());
        goto L4
    L9:
        return r0.toString();
    }

    public String toString() {
        return String.format("[%s; id-to-type=%s]", new Object[]{getClass().getName(), this.f12742c});
    }

    public static String b(Class<?> r1) {
        String r2 = r1.getName();
        int r0 = r2.lastIndexOf(46);
        if (r0 >= 0) goto L6;
        return r2;
    L6:
        return r2.substring(r0 + 1);
    }
}
