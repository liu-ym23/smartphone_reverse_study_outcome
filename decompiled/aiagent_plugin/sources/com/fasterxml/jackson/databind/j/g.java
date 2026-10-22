package com.fasterxml.jackson.databind.j;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.aa;
import com.fasterxml.jackson.databind.ac;
import com.fasterxml.jackson.databind.j.b.ae;
import com.fasterxml.jackson.databind.j.b.am;
import com.fasterxml.jackson.databind.j.b.u;
import com.fasterxml.jackson.databind.v;
import com.fasterxml.jackson.databind.w;
import com.fasterxml.jackson.databind.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: BeanSerializerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends b implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g f12947d = null;

    static {
        f12947d = new g(null);
    }

    public g(com.fasterxml.jackson.databind.a.p r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.j.b
    public Iterable<s> a() {
        return this.f12856c.c();
    }

    @Override // com.fasterxml.jackson.databind.j.r
    public com.fasterxml.jackson.databind.p<Object> a(ac r7, com.fasterxml.jackson.databind.k r8) {
        aa r0 = r7.c();
        com.fasterxml.jackson.databind.c r1 = r0.a(r8);
        com.fasterxml.jackson.databind.p<?> r2 = a(r7, r1.c());
        if (r2 == null) goto L5;
        return r2;
    L5:
        com.fasterxml.jackson.databind.b r3 = r0.j();
        boolean r4 = false;
        if (r3 != null) goto L32;
        com.fasterxml.jackson.databind.k r5 = r8;
    L10:
        if (r5 != r8) goto L13;
    L16:
        com.fasterxml.jackson.databind.l.j<Object, Object> r9 = r1.s();
        if (r9 == null) goto L19;
        com.fasterxml.jackson.databind.k r6 = r9.b(r7.b());
        if (r6.a(r5.e()) == true) goto L23;
        r1 = r0.a(r6);
        r2 = a(r7, r1.c());
    L23:
        if (r2 != null) goto L28;
        if (r6.t() == true) goto L28;
        r2 = d(r7, r6, r1, true);
    L28:
        return new ae(r9, r6, r2);
    L19:
        return d(r7, r5, r1, r4);
    L13:
        if (r5.a(r8.e()) == true) goto L15;
        r1 = r0.a(r5);
    L15:
        r4 = true;
        goto L16
    L32:
        r5 = r3.a(r0, r1.c(), r8);     // Catch: com.fasterxml.jackson.databind.m -> L29
    L29:
        e = move-exception;
        return (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r7.a(r1, e.getMessage(), new Object[0]), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    }

    public com.fasterxml.jackson.databind.p<?> d(ac r6, com.fasterxml.jackson.databind.k r7, com.fasterxml.jackson.databind.c r8, boolean r9) {
        aa r0 = r6.c();
        com.fasterxml.jackson.databind.p<?> r2 = null;
        if (r7.q() == false) goto L10;
        if (r9 == true) goto L6;
        r9 = a(r0, r8, null);
    L6:
        com.fasterxml.jackson.databind.p<?> r1 = c(r6, r7, r8, r9);
        if (r1 == null) goto L20;
        return r1;
    L20:
        if (r1 != null) goto L28;
        r1 = a(r7, r0, r8, r9);
        if (r1 != null) goto L28;
        r1 = a(r6, r7, r8, r9);
        if (r1 != null) goto L28;
        r1 = e(r6, r7, r8, r9);
        if (r1 != null) goto L28;
        r1 = r6.d(r8.a());
    L28:
        if (r1 != null) goto L30;
    L35:
        return r1;
    L30:
        if (this.f12856c.b() == false) goto L35;
        Iterator<h> r5 = this.f12856c.e().iterator();
    L33:
        if (r5.hasNext() == false) goto L35;
        r1 = ((h) ZeusTransformUtils.preCheckCast(r5.next(), h.class, "com.obric.aiagent.plugin")).a(r0, r8, r1);
        goto L33
    L10:
        if (r7.a() == false) goto L12;
        r1 = a(r6, (com.fasterxml.jackson.databind.k.j) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.j.class, "com.obric.aiagent.plugin"), r8, r9);
    L18:
        if (r1 != null) goto L20;
        r1 = a(r6, r7, r8);
        goto L20
    L12:
        Iterator<s> r3 = a().iterator();
    L14:
        if (r3.hasNext() == false) goto L17;
        r2 = ((s) ZeusTransformUtils.preCheckCast(r3.next(), s.class, "com.obric.aiagent.plugin")).a(r0, r7, r8);
        if (r2 == null) goto L14;
    L17:
        r1 = r2;
        goto L18
    }

    public com.fasterxml.jackson.databind.p<Object> e(ac r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.c r4, boolean r5) {
        if (b(r3.e()) == true) goto L9;
        if (com.fasterxml.jackson.databind.l.h.l(r3.e()) == true) goto L9;
        return null;
    L9:
        return f(r2, r3, r4, r5);
    }

    public com.fasterxml.jackson.databind.h.h a(com.fasterxml.jackson.databind.k r2, aa r3, com.fasterxml.jackson.databind.e.j r4) {
        com.fasterxml.jackson.databind.h.g<?> r0 = r3.j().a(r3, r4, r2);
        if (r0 != null) goto L6;
        return a(r3, r2);
    L6:
        return r0.a(r3, r2, r3.v().a(r3, r4, r2));
    }

    public com.fasterxml.jackson.databind.h.h b(com.fasterxml.jackson.databind.k r3, aa r4, com.fasterxml.jackson.databind.e.j r5) {
        com.fasterxml.jackson.databind.k r0 = r3.x();
        com.fasterxml.jackson.databind.h.g<?> r6 = r4.j().b(r4, r5, r3);
        if (r6 != null) goto L6;
        return a(r4, r0);
    L6:
        return r6.a(r4, r0, r4.v().a(r4, r5, r0));
    }

    public com.fasterxml.jackson.databind.p<Object> f(ac r18, com.fasterxml.jackson.databind.k r19, com.fasterxml.jackson.databind.c r20, boolean r21) {
        if (r20.a() == Object.class) goto L5;
        com.fasterxml.jackson.databind.p<?> r4 = b(r18, r19, r20);
        if (r4 == null) goto L10;
        return r4;
    L10:
        if (b(r18, r19) == true) goto L12;
        aa r5 = r18.c();
        f r6 = a(r20);
        r6.a(r5);
        List<d> r7 = a(r18, r20, r6);
        if (r7 != null) goto L16;
        List<d> r8 = new ArrayList();
    L17:
        r18.d().a(r5, r20.c(), r8);
        if (this.f12856c.b() == false) goto L23;
        Iterator<h> r9 = this.f12856c.e().iterator();
    L21:
        if (r9.hasNext() == false) goto L23;
        r8 = ((h) ZeusTransformUtils.preCheckCast(r9.next(), h.class, "com.obric.aiagent.plugin")).a(r5, r20, r8);
    L23:
        List<d> r10 = a(r5, r20, b(r5, r20, r8));
        if (this.f12856c.b() == false) goto L29;
        Iterator<h> r11 = this.f12856c.e().iterator();
    L27:
        if (r11.hasNext() == false) goto L29;
        r10 = ((h) ZeusTransformUtils.preCheckCast(r11.next(), h.class, "com.obric.aiagent.plugin")).b(r5, r20, r10);
    L29:
        r6.a(a(r18, r20, r10));
        r6.a(r10);
        r6.a(a(r5, r20));
        com.fasterxml.jackson.databind.e.j r12 = r20.q();
        if (r12 == null) goto L35;
        com.fasterxml.jackson.databind.k r13 = r12.getType();
        com.fasterxml.jackson.databind.k r14 = r13.x();
        com.fasterxml.jackson.databind.h.h r15 = a(r5, r14);
        com.fasterxml.jackson.databind.p<Object> r16 = a(r18, r12);
        if (r16 != null) goto L34;
        r16 = u.a((Set) ZeusTransformUtils.preCheckCast(null, Set.class, "com.obric.aiagent.plugin"), r13, r5.a(com.fasterxml.jackson.databind.r.p), r15, null, null, null);
    L34:
        r6.a(new a(new com.fasterxml.jackson.databind.d.b(x.a(r12.b()), r14, null, r12, w.f13126b), r12, r16));
    L35:
        a(r5, r6);
        if (this.f12856c.b() == false) goto L57;
        Iterator<h> r17 = this.f12856c.e().iterator();
    L39:
        if (r17.hasNext() == false) goto L57;
        r6 = ((h) ZeusTransformUtils.preCheckCast(r17.next(), h.class, "com.obric.aiagent.plugin")).a(r5, r20, r6);
    L57:
        com.fasterxml.jackson.databind.p<?> r1 = r6.g();     // Catch: RuntimeException -> L54
        if (r1 == null) goto L44;
    L53:
        return r1;
    L44:
        if (r19.m() == true) goto L46;
        r1 = a(r5, r19, r20, r21);
        if (r1 != null) goto L53;
        if (r20.e() == false) goto L53;
        return r6.h();
    L46:
        return r6.h();
    L54:
        e = move-exception;
        return (com.fasterxml.jackson.databind.p) ZeusTransformUtils.preCheckCast(r18.a(r20, "Failed to construct BeanSerializer for %s: (%s) %s", new Object[]{r20.getType(), e.getClass().getName(), e.getMessage()}), com.fasterxml.jackson.databind.p.class, "com.obric.aiagent.plugin");
    L16:
        r8 = a(r18, r20, r6, r7);
        goto L17
    L12:
        return new am(r19);
    L5:
        return r18.d(Object.class);
    }

    public com.fasterxml.jackson.databind.j.a.i a(ac r8, com.fasterxml.jackson.databind.c r9, List<d> r10) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.e.ac r11 = r9.d();
        if (r11 != null) goto L5;
        return null;
    L5:
        Class<? extends ObjectIdGenerator<?>> r2 = r11.d();
        if (r2 != ObjectIdGenerators.PropertyGenerator.class) goto L19;
        String r12 = r11.b().b();
        int r3 = r7.size();
        int r4 = 0;
    L8:
        if (r4 == r3) goto L17;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r7.get(r4), d.class, "com.obric.aiagent.plugin");
        if (r12.equals(r5.a()) == true) goto L11;
        r4 = r4 + 1;
        goto L8
    L11:
        if (r4 <= 0) goto L14;
        r7.remove(r4);
        r7.add(0, r5);
    L14:
        return com.fasterxml.jackson.databind.j.a.i.a(r5.getType(), (x) ZeusTransformUtils.preCheckCast(null, x.class, "com.obric.aiagent.plugin"), new com.fasterxml.jackson.databind.j.a.j(r11, r5), r11.f());
    L17:
        throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r9.getType()), com.fasterxml.jackson.databind.l.h.b(r12)}));
    L19:
        return com.fasterxml.jackson.databind.j.a.i.a(r8.b().c(r8.a(r2), ObjectIdGenerator.class)[0], r11.b(), r8.a(r9.c(), r11), r11.f());
    }

    public d a(d r1, Class<?>[] r2) {
        return com.fasterxml.jackson.databind.j.a.d.a(r1, r2);
    }

    public m b(aa r1, com.fasterxml.jackson.databind.c r2) {
        return new m(r1, r2);
    }

    public f a(com.fasterxml.jackson.databind.c r1) {
        return new f(r1);
    }

    public boolean b(Class<?> r1) {
        if (com.fasterxml.jackson.databind.l.h.a(r1) == null) goto L5;
    L7:
        return false;
    L5:
        if (com.fasterxml.jackson.databind.l.h.c(r1) == true) goto L7;
        return true;
    }

    public List<d> a(ac r11, com.fasterxml.jackson.databind.c r12, f r13) {
        List<com.fasterxml.jackson.databind.e.t> r0 = r12.g();
        aa r1 = r11.c();
        c(r1, r12, r0);
        if (r1.a(com.fasterxml.jackson.databind.r.i) == false) goto L6;
        d(r1, r12, r0);
    L6:
        if (r0.isEmpty() == false) goto L8;
        return null;
    L8:
        boolean r2 = a(r1, r12, null);
        m r14 = b(r1, r12);
        ArrayList r3 = new ArrayList(r0.size());
        Iterator<com.fasterxml.jackson.databind.e.t> r4 = r0.iterator();
    L10:
        if (r4.hasNext() == false) goto L24;
        com.fasterxml.jackson.databind.e.t r6 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r4.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.e.j r5 = r6.s();
        if (r6.z() == true) goto L13;
        com.fasterxml.jackson.databind.b.a r7 = r6.x();
        if (r7 == null) goto L21;
        if (r7.c() == true) goto L10;
    L21:
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.e.k.class) == true) goto L22;
        r3.add(a(r11, r6, r14, r2, (com.fasterxml.jackson.databind.e.h) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.e.h.class, "com.obric.aiagent.plugin")));
        goto L10
    L22:
        r3.add(a(r11, r6, r14, r2, (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r5, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin")));
        goto L10
    L13:
        if (r5 == null) goto L10;
        r13.a(r5);
        goto L10
    L24:
        return r3;
    }

    public List<d> a(aa r4, com.fasterxml.jackson.databind.c r5, List<d> r6) {
        List<d> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        JsonIgnoreProperties.Value r7 = r4.b(r5.a(), r5.c());
        Set<String> r1 = null;
        if (r7 == null) goto L5;
        Set<String> r8 = r7.findIgnoredForSerialization();
    L6:
        JsonIncludeProperties.Value r9 = r4.c(r5.a(), r5.c());
        if (r9 == null) goto L9;
        r1 = r9.getIncluded();
    L9:
        if (r1 != null) goto L13;
        if (r8 != null) goto L12;
    L19:
        return r3;
    L12:
        if (r8.isEmpty() == true) goto L19;
    L13:
        Iterator<d> r10 = r3.iterator();
    L15:
        if (r10.hasNext() == false) goto L19;
        if (com.fasterxml.jackson.databind.l.m.a(((d) ZeusTransformUtils.preCheckCast(r10.next(), d.class, "com.obric.aiagent.plugin")).a(), r8, r1) == false) goto L15;
        r10.remove();
        goto L15
    L5:
        r8 = null;
        goto L6
    }

    public List<d> b(aa r2, com.fasterxml.jackson.databind.c r3, List<d> r4) {
        List<d> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if (r3.getType().b(CharSequence.class) == true) goto L5;
    L13:
        return r1;
    L5:
        if (r1.size() != 1) goto L13;
        com.fasterxml.jackson.databind.e.j r5 = ((d) ZeusTransformUtils.preCheckCast(r1.get(0), d.class, "com.obric.aiagent.plugin")).d();
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.e.k.class) == false) goto L13;
        if ("isEmpty".equals(r5.b()) == false) goto L13;
        if (r5.f() != CharSequence.class) goto L13;
        r1.remove(0);
        goto L13
    }

    public void a(aa r9, f r10) {
        List<d> r0 = r10.b();
        boolean r11 = r9.a(com.fasterxml.jackson.databind.r.s);
        int r1 = r0.size();
        d[] r2 = new d[r1];
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r1) goto L13;
        d r5 = (d) ZeusTransformUtils.preCheckCast(r0.get(r3), d.class, "com.obric.aiagent.plugin");
        Class<?>[] r6 = r5.j();
        if (r6 != null) goto L7;
    L10:
        if (r11 == false) goto L12;
        r2[r3] = r5;
    L12:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r6.length == 0) goto L10;
        r4 = r4 + 1;
        r2[r3] = a(r5, r6);
        goto L12
    L13:
        if (r11 == false) goto L16;
        if (r4 != 0) goto L16;
        return;
    L16:
        r10.a(r2);
    }

    public void c(aa r5, com.fasterxml.jackson.databind.c r6, List<com.fasterxml.jackson.databind.e.t> r7) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r8 = r5.j();
        HashMap r0 = new HashMap();
        Iterator r9 = r4.iterator();
    L4:
        if (r9.hasNext() == false) goto L19;
        com.fasterxml.jackson.databind.e.t r1 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r9.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        if (r1.s() == null) goto L7;
        Class<?> r2 = r1.g();
        Boolean r3 = (Boolean) ZeusTransformUtils.preCheckCast(r0.get(r2), Boolean.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L17;
        r3 = r5.d(r2).f();
        if (r3 != null) goto L15;
        r3 = r8.b(r5.c(r2).c());
        if (r3 != null) goto L15;
        r3 = Boolean.FALSE;
    L15:
        r0.put(r2, r3);
    L17:
        if (r3.booleanValue() == false) goto L4;
        r9.remove();
        goto L4
    L7:
        r9.remove();
        goto L4
    }

    public void d(aa r1, com.fasterxml.jackson.databind.c r2, List<com.fasterxml.jackson.databind.e.t> r3) {
        Iterator r0 = ((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.e.t r4 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r0.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        if (r4.i() == true) goto L4;
        if (r4.d() == true) goto L4;
        r0.remove();
        goto L4
    }

    public List<d> a(ac r5, com.fasterxml.jackson.databind.c r6, f r7, List<d> r8) {
        List<d> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        int r9 = r4.size();
        int r10 = 0;
    L3:
        if (r10 >= r9) goto L18;
        d r11 = (d) ZeusTransformUtils.preCheckCast(r4.get(r10), d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.h r0 = r11.g();
        if (r0 == null) goto L17;
        if (r0.a() != JsonTypeInfo.As.EXTERNAL_PROPERTY) goto L17;
        x r1 = x.a(r0.b());
        Iterator<d> r2 = r4.iterator();
    L11:
        if (r2.hasNext() == false) goto L17;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r2.next(), d.class, "com.obric.aiagent.plugin");
        if (r3 == r11) goto L11;
        if (r3.b(r1) == false) goto L11;
        r11.a(null);
    L17:
        r10 = r10 + 1;
        goto L3
    L18:
        return r4;
    }

    public d a(ac r12, com.fasterxml.jackson.databind.e.t r13, m r14, boolean r15, com.fasterxml.jackson.databind.e.j r16) {
        x r3 = r13.b();
        com.fasterxml.jackson.databind.k r9 = r16.getType();
        com.fasterxml.jackson.databind.d.b r10 = new com.fasterxml.jackson.databind.d.b(r3, r9, r13.c(), r16, r13.h());
        com.fasterxml.jackson.databind.p<?> r2 = a(r12, r16);
        if (ZeusTransformUtils.instanceOf(r2, p.class) == false) goto L5;
        ((p) ZeusTransformUtils.preCheckCast(r2, p.class, "com.obric.aiagent.plugin")).a(r12);
    L5:
        com.fasterxml.jackson.databind.p<?> r4 = r12.a(r2, r10);
        com.fasterxml.jackson.databind.h.h r5 = null;
        if (r9.q() == false) goto L8;
    L9:
        r5 = b(r9, r12.c(), r16);
    L10:
        com.fasterxml.jackson.databind.h.h r6 = r5;
        return r14.a(r12, r13, r9, r4, a(r9, r12.c(), r16), r6, r16, r15);
    L8:
        if (r9.a() == false) goto L10;
        goto L9
    }

    public com.fasterxml.jackson.databind.p<?> b(ac r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3) {
        String r0 = com.fasterxml.jackson.databind.l.e.b(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r1.c().j(r2.e()) == null) goto L7;
        return null;
    L7:
        return new com.fasterxml.jackson.databind.j.a.r(r2, r0);
    }

    public boolean b(ac r1, com.fasterxml.jackson.databind.k r2) {
        Class<?> r0 = r2.e();
        if (com.fasterxml.jackson.databind.t.class.isAssignableFrom(r0) == false) goto L5;
    L18:
        return true;
    L5:
        if (com.fasterxml.jackson.databind.u.class.isAssignableFrom(r0) == true) goto L18;
        if (v.class.isAssignableFrom(r0) == true) goto L18;
        if (com.fasterxml.jackson.databind.e.class.isAssignableFrom(r0) == true) goto L18;
        if (com.fasterxml.jackson.a.t.class.isAssignableFrom(r0) == true) goto L18;
        if (com.fasterxml.jackson.a.k.class.isAssignableFrom(r0) == true) goto L18;
        if (com.fasterxml.jackson.a.h.class.isAssignableFrom(r0) == true) goto L18;
        return false;
    }
}
