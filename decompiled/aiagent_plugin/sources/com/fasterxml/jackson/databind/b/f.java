package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.b.a.aa;
import com.fasterxml.jackson.databind.b.a.ac;
import com.fasterxml.jackson.databind.b.b.aj;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BeanDeserializerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends b implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f12520c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class<?>[] f12521e = null;

    static {
        f12521e = new Class[]{Throwable.class};
        f12520c = new f(new com.fasterxml.jackson.databind.a.k());
    }

    public f(com.fasterxml.jackson.databind.a.k r1) {
        super(r1);
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<Object> d(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.c r6) {
        com.fasterxml.jackson.databind.g r0 = r4.c();
        com.fasterxml.jackson.databind.l<?> r1 = a(r5, r0, r6);
        if (r1 == null) goto L12;
        if (this.f12362b.b() == false) goto L10;
        Iterator<g> r3 = this.f12362b.g().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r1 = ((g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.aiagent.plugin")).a(r4.c(), r6, r1);
    L10:
        return r1;
    L12:
        if (r5.i() == false) goto L16;
        return j(r4, r5, r6);
    L16:
        if (r5.g() == true) goto L18;
    L25:
        com.fasterxml.jackson.databind.l<?> r2 = e(r4, r5, r6);
        if (r2 == null) goto L29;
        return r2;
    L29:
        if (a(r5.e()) == true) goto L32;
        return null;
    L32:
        k(r4, r5, r6);
        com.fasterxml.jackson.databind.l<Object> r7 = f(r4, r5, r6);
        if (r7 == null) goto L36;
        return r7;
    L36:
        return h(r4, r5, r6);
    L18:
        if (r5.o() == true) goto L25;
        if (r5.k() == true) goto L25;
        com.fasterxml.jackson.databind.k r8 = g(r4, r5, r6);
        if (r8 == null) goto L25;
        return h(r4, r8, r0.a(r8));
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.c r5, Class<?> r6) {
        if (r3.a(com.fasterxml.jackson.databind.r.r) == false) goto L5;
        com.fasterxml.jackson.databind.k r7 = r3.b().a(r6, r4.A());
    L7:
        return i(r3, r4, r3.c().a(r7, r5));
    L5:
        r7 = r3.b(r6);
        goto L7
    }

    public com.fasterxml.jackson.databind.l<?> e(com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.k r5, com.fasterxml.jackson.databind.c r6) {
        com.fasterxml.jackson.databind.l<?> r7 = c(r4, r5, r6);
        if (r7 != null) goto L5;
    L10:
        return r7;
    L5:
        if (this.f12362b.b() == false) goto L10;
        Iterator<g> r3 = this.f12362b.g().iterator();
    L8:
        if (r3.hasNext() == false) goto L10;
        r7 = ((g) ZeusTransformUtils.preCheckCast(r3.next(), g.class, "com.obric.aiagent.plugin")).a(r4.c(), r6, r7);
        goto L8
    }

    public com.fasterxml.jackson.databind.l<Object> f(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3) {
        String r0 = com.fasterxml.jackson.databind.l.e.b(r2);
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r1.c().j(r2.e()) == null) goto L7;
        return null;
    L7:
        return new ac(r2, r0);
    }

    public com.fasterxml.jackson.databind.k g(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.c r5) {
        Iterator<com.fasterxml.jackson.databind.a> r2 = this.f12362b.h().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.k r6 = ((com.fasterxml.jackson.databind.a) ZeusTransformUtils.preCheckCast(r2.next(), com.fasterxml.jackson.databind.a.class, "com.obric.aiagent.plugin")).a(r3.c(), r5);
        if (r6 == null) goto L4;
        return r6;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<Object> h(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.k r8, com.fasterxml.jackson.databind.c r9) {
        y r0 = a(r7, r9);     // Catch: IllegalArgumentException -> L22 NoClassDefFoundError -> L25
        e r1 = d(r7, r9);
        r1.a(r0);
        b(r7, r9, r1);
        a(r7, r9, r1);
        c(r7, r9, r1);
        d(r7, r9, r1);
        com.fasterxml.jackson.databind.g r10 = r7.c();
        if (this.f12362b.b() == false) goto L10;
        Iterator<g> r2 = this.f12362b.g().iterator();
    L7:
        if (r2.hasNext() == false) goto L10;
        r1 = ((g) ZeusTransformUtils.preCheckCast(r2.next(), g.class, "com.obric.aiagent.plugin")).a(r10, r9, r1);
    L10:
        if (r8.g() == true) goto L12;
    L14:
        com.fasterxml.jackson.databind.l<?> r11 = r1.g();
    L16:
        if (this.f12362b.b() == false) goto L21;
        Iterator<g> r6 = this.f12362b.g().iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        r11 = ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).a(r10, r9, r11);
    L21:
        return r11;
    L12:
        if (r0.c() == true) goto L14;
        r11 = r1.h();
        goto L16
    L22:
        e = move-exception;
        throw com.fasterxml.jackson.databind.c.b.a(r7.j(), com.fasterxml.jackson.databind.l.h.h(e), r9, null).a(e);
    L25:
        e = move-exception;
        return new com.fasterxml.jackson.databind.b.a.f(e);
    }

    public com.fasterxml.jackson.databind.l<Object> i(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.k r8, com.fasterxml.jackson.databind.c r9) {
        y r1 = a(r7, r9);     // Catch: IllegalArgumentException -> L26 NoClassDefFoundError -> L29
        com.fasterxml.jackson.databind.g r2 = r7.c();
        e r3 = d(r7, r9);
        r3.a(r1);
        b(r7, r9, r3);
        a(r7, r9, r3);
        c(r7, r9, r3);
        d(r7, r9, r3);
        JsonPOJOBuilder.Value r10 = r9.w();
        if (r10 != null) goto L7;
        String r4 = JsonPOJOBuilder.DEFAULT_BUILD_METHOD;
    L8:
        com.fasterxml.jackson.databind.e.k r0 = r9.a(r4, null);
        if (r0 != null) goto L11;
    L13:
        r3.a(r0, r10);
        if (this.f12362b.b() == false) goto L19;
        Iterator<g> r11 = this.f12362b.g().iterator();
    L17:
        if (r11.hasNext() == false) goto L19;
        r3 = ((g) ZeusTransformUtils.preCheckCast(r11.next(), g.class, "com.obric.aiagent.plugin")).a(r2, r9, r3);
    L19:
        com.fasterxml.jackson.databind.l<?> r12 = r3.a(r8, r4);
        if (this.f12362b.b() == false) goto L25;
        Iterator<g> r6 = this.f12362b.g().iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        r12 = ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).a(r2, r9, r12);
    L25:
        return r12;
    L11:
        if (r2.g() == false) goto L13;
        com.fasterxml.jackson.databind.l.h.a(r0.h(), r2.a(com.fasterxml.jackson.databind.r.o));
        goto L13
    L7:
        r4 = r10.buildMethodName;
        goto L8
    L26:
        e = move-exception;
        throw com.fasterxml.jackson.databind.c.b.a(r7.j(), com.fasterxml.jackson.databind.l.h.h(e), r9, null);
    L29:
        e = move-exception;
        return new com.fasterxml.jackson.databind.b.a.f(e);
    }

    public void a(com.fasterxml.jackson.databind.h r9, com.fasterxml.jackson.databind.c r10, e r11) {
        com.fasterxml.jackson.databind.e.ac r8 = r10.d();
        if (r8 != null) goto L5;
        return;
    L5:
        Class<? extends ObjectIdGenerator<?>> r0 = r8.d();
        ObjectIdResolver r7 = r9.b(r10.c(), r8);
        if (r0 != ObjectIdGenerators.PropertyGenerator.class) goto L12;
        com.fasterxml.jackson.databind.x r1 = r8.b();
        v r2 = r11.a(r1);
        if (r2 == null) goto L11;
        com.fasterxml.jackson.databind.k r12 = r2.getType();
        com.fasterxml.jackson.databind.k r3 = r12;
        ObjectIdGenerator<?> r4 = new com.fasterxml.jackson.databind.b.a.w(r8.c());
    L13:
        com.fasterxml.jackson.databind.l<Object> r5 = r9.b(r3);
        r11.a(com.fasterxml.jackson.databind.b.a.s.a(r3, r8.b(), r4, r5, r2, r7));
        return;
    L11:
        throw new IllegalArgumentException(String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r10.getType()), com.fasterxml.jackson.databind.l.h.a(r1)}));
    L12:
        com.fasterxml.jackson.databind.k r6 = r9.b().c(r9.b(r0), ObjectIdGenerator.class)[0];
        r2 = null;
        r4 = r9.a(r10.c(), r8);
        r3 = r6;
        goto L13
    }

    public com.fasterxml.jackson.databind.l<Object> j(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.k r8, com.fasterxml.jackson.databind.c r9) {
        com.fasterxml.jackson.databind.g r10 = r7.c();
        e r0 = d(r7, r9);
        r0.a(a(r7, r9));
        b(r7, r9, r0);
        Iterator<v> r1 = r0.a();
    L4:
        if (r1.hasNext() == false) goto L8;
        if ("setCause".equals(((v) ZeusTransformUtils.preCheckCast(r1.next(), v.class, "com.obric.aiagent.plugin")).d().b()) == false) goto L4;
        r1.remove();
    L8:
        com.fasterxml.jackson.databind.e.k r2 = r9.a("initCause", f12521e);
        if (r2 == null) goto L13;
        v r11 = a(r7, r9, com.fasterxml.jackson.databind.l.w.a(r7.c(), r2, new com.fasterxml.jackson.databind.x("cause")), r2.b(0));
        if (r11 == null) goto L13;
        r0.a(r11, true);
    L13:
        r0.a("localizedMessage");
        r0.a("suppressed");
        if (this.f12362b.b() == false) goto L19;
        Iterator<g> r12 = this.f12362b.g().iterator();
    L17:
        if (r12.hasNext() == false) goto L19;
        r0 = ((g) ZeusTransformUtils.preCheckCast(r12.next(), g.class, "com.obric.aiagent.plugin")).a(r10, r9, r0);
    L19:
        com.fasterxml.jackson.databind.l<?> r13 = r0.g();
        if (ZeusTransformUtils.instanceOf(r13, c.class) == false) goto L23;
        r13 = new aj((c) ZeusTransformUtils.preCheckCast(r13, c.class, "com.obric.aiagent.plugin"));
    L23:
        if (this.f12362b.b() == false) goto L28;
        Iterator<g> r6 = this.f12362b.g().iterator();
    L26:
        if (r6.hasNext() == false) goto L28;
        r13 = ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).a(r10, r9, r13);
    L28:
        return r13;
    }

    public e d(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.c r2) {
        return new e(r2, r1);
    }

    public void b(com.fasterxml.jackson.databind.h r19, com.fasterxml.jackson.databind.c r20, e r21) {
        boolean r11 = true;
        if ((!r20.getType().g()) == false) goto L5;
        v[] r13 = r21.c().a(r19.c());
    L7:
        if (r13 == null) goto L9;
        boolean r15 = true;
    L10:
        JsonIgnoreProperties.Value r0 = r19.c().b(r20.a(), r20.c());
        if (r0 == null) goto L16;
        r21.a(r0.getIgnoreUnknown());
        Set<String> r1 = r0.findIgnoredForDeserialization();
        Iterator<String> r2 = r1.iterator();
    L14:
        if (r2.hasNext() == false) goto L17;
        r21.a((String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.aiagent.plugin"));
    L17:
        Set<String> r5 = r1;
        JsonIncludeProperties.Value r3 = r19.c().c(r20.a(), r20.c());
        if (r3 == null) goto L26;
        Set<String> r4 = r3.getIncluded();
        if (r4 == null) goto L25;
        Iterator<String> r6 = r4.iterator();
    L23:
        if (r6.hasNext() == false) goto L25;
        r21.b((String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.aiagent.plugin"));
    L25:
        Set<String> r16 = r4;
    L27:
        com.fasterxml.jackson.databind.e.j r7 = r20.r();
        if (r7 == null) goto L30;
        r21.a(a(r19, r20, r7));
    L37:
        if (r19.a(com.fasterxml.jackson.databind.r.f13097b) == true) goto L39;
    L41:
        boolean r17 = false;
    L42:
        List<com.fasterxml.jackson.databind.e.t> r8 = a(r19, r20, r21, r20.g(), r5, r16);
        if (this.f12362b.b() == false) goto L48;
        Iterator<g> r9 = this.f12362b.g().iterator();
    L46:
        if (r9.hasNext() == false) goto L48;
        r8 = ((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.aiagent.plugin")).a(r19.c(), r20, r8);
    L48:
        Iterator<com.fasterxml.jackson.databind.e.t> r10 = r8.iterator();
    L50:
        if (r10.hasNext() == false) goto L103;
        com.fasterxml.jackson.databind.e.t r12 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r10.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        if (r12.k() == false) goto L55;
        v r14 = a(r19, r20, r12, r12.o().b(0));
    L72:
        if (r15 == true) goto L74;
    L96:
        boolean r18 = r11;
        if (r14 == null) goto L102;
        Class<?>[] r22 = r12.w();
        if (r22 != null) goto L101;
        r22 = r20.x();
    L101:
        r14.a(r22);
        r21.a(r14);
    L102:
        r11 = r18;
        goto L50
    L74:
        if (r12.m() == false) goto L96;
        String r23 = r12.a();
        int r24 = r13.length;
        int r25 = 0;
    L76:
        if (r25 >= r24) goto L83;
        v r26 = r13[r25];
        if (r23.equals(r26.a()) == false) goto L82;
        if (ZeusTransformUtils.instanceOf(r26, k.class) == false) goto L82;
        k r27 = (k) ZeusTransformUtils.preCheckCast(r26, k.class, "com.obric.aiagent.plugin");
    L84:
        if (r27 != null) goto L89;
        ArrayList r28 = new ArrayList();
        int r29 = r13.length;
        int r30 = 0;
    L86:
        if (r30 >= r29) goto L88;
        r28.add(r13[r30].a());
        r30 = r30 + 1;
        goto L86
    L88:
        r18 = true;
        r19.a(r20, r12, "Could not find creator property with name %s (known Creator properties: %s)", new Object[]{com.fasterxml.jackson.databind.l.h.b(r23), r28});
        goto L102
    L89:
        r18 = true;
        if (r14 == null) goto L92;
        r27.a(r14);
    L92:
        Class<?>[] r31 = r12.w();
        if (r31 != null) goto L95;
        r31 = r20.x();
    L95:
        r27.a(r31);
        r21.b(r27);
    L82:
        r25 = r25 + 1;
        goto L76
    L83:
        r27 = null;
        goto L84
    L55:
        if (r12.l() == false) goto L57;
        r14 = a(r19, r20, r12, r12.p().getType());
        goto L72
    L57:
        com.fasterxml.jackson.databind.e.k r32 = r12.n();
        if (r32 == null) goto L71;
        if (r17 == false) goto L67;
        if (b(r32.c()) == false) goto L67;
        if (r21.c(r12.a()) == true) goto L71;
        r14 = a(r19, r20, r12);
    L67:
        if (r12.m() == true) goto L71;
        if (r12.h().d() == null) goto L71;
        r14 = a(r19, r20, r12);
    L71:
        r14 = null;
        goto L72
    L103:
        return;
    L39:
        if (r19.a(com.fasterxml.jackson.databind.r.f) == false) goto L41;
        r17 = true;
        goto L42
    L30:
        Set<String> r33 = r20.h();
        if (r33 == null) goto L37;
        Iterator<String> r34 = r33.iterator();
    L34:
        if (r34.hasNext() == false) goto L37;
        r21.a((String) ZeusTransformUtils.preCheckCast(r34.next(), String.class, "com.obric.aiagent.plugin"));
        goto L34
    L26:
        r16 = null;
        goto L27
    L16:
        r1 = Collections.emptySet();
        goto L17
    L9:
        r15 = false;
        goto L10
    L5:
        r13 = null;
        goto L7
    }

    private boolean b(Class<?> r1) {
        if (Collection.class.isAssignableFrom(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Map.class.isAssignableFrom(r1) == true) goto L8;
        return false;
    }

    public List<com.fasterxml.jackson.databind.e.t> a(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.c r8, e r9, List<com.fasterxml.jackson.databind.e.t> r10, Set<String> r11, Set<String> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.aiagent.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.aiagent.plugin");
        Set r15 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.aiagent.plugin");
        ArrayList r16 = new ArrayList(Math.max(4, r13.size()));
        HashMap r1 = new HashMap();
        Iterator r17 = r13.iterator();
    L4:
        if (r17.hasNext() == false) goto L16;
        com.fasterxml.jackson.databind.e.t r2 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r17.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        String r3 = r2.a();
        if (com.fasterxml.jackson.databind.l.m.a(r3, r14, r15) == true) goto L4;
        if (r2.m() == true) goto L15;
        Class<?> r4 = r2.g();
        if (r4 == null) goto L15;
        if (a(r7.c(), r2, r4, r1) == false) goto L15;
        r9.a(r3);
    L15:
        r16.add(r2);
        goto L4
    L16:
        return r16;
    }

    public void c(com.fasterxml.jackson.databind.h r5, com.fasterxml.jackson.databind.c r6, e r7) {
        List<com.fasterxml.jackson.databind.e.t> r0 = r6.i();
        if (r0 == null) goto L8;
        Iterator<com.fasterxml.jackson.databind.e.t> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        com.fasterxml.jackson.databind.e.t r2 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r1.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        r7.a(r2.y(), a(r5, r6, r2, r2.f()));
        goto L6
    L10:
        return;
    }

    public void d(com.fasterxml.jackson.databind.h r8, com.fasterxml.jackson.databind.c r9, e r10) {
        Map<Object, com.fasterxml.jackson.databind.e.j> r7 = r9.u();
        if (r7 == null) goto L8;
        Iterator<Map.Entry<Object, com.fasterxml.jackson.databind.e.j>> r11 = r7.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry r12 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.e.j r5 = (com.fasterxml.jackson.databind.e.j) ZeusTransformUtils.preCheckCast(r12.getValue(), com.fasterxml.jackson.databind.e.j.class, "com.obric.aiagent.plugin");
        r10.a(com.fasterxml.jackson.databind.x.a(r5.b()), r5.getType(), r9.f(), r5, r12.getKey());
        goto L6
    L10:
        return;
    }

    public u a(com.fasterxml.jackson.databind.h r14, com.fasterxml.jackson.databind.c r15, com.fasterxml.jackson.databind.e.j r16) {
        if (ZeusTransformUtils.instanceOf(r16, com.fasterxml.jackson.databind.e.k.class) == false) goto L7;
        com.fasterxml.jackson.databind.e.k r2 = (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r16, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.k r10 = r2.b(0);
        com.fasterxml.jackson.databind.k r11 = a(r14, r16, r2.b(1));
        com.fasterxml.jackson.databind.d.b r12 = new com.fasterxml.jackson.databind.d.b(com.fasterxml.jackson.databind.x.a(r16.b()), r11, null, r16, com.fasterxml.jackson.databind.w.f13126b);
    L5:
        com.fasterxml.jackson.databind.k r3 = r11;
        com.fasterxml.jackson.databind.q r4 = b(r14, r16);
        if (r4 != null) goto L12;
        r4 = (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r10.D(), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
    L12:
        if (r4 != null) goto L15;
        r4 = r14.b(r10, r12);
    L17:
        com.fasterxml.jackson.databind.q r5 = r4;
        com.fasterxml.jackson.databind.l<?> r0 = c(r14, r16);
        if (r0 != null) goto L20;
        r0 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r3.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L20:
        if (r0 == null) goto L23;
        r0 = r14.a(r0, r12, r3);
    L23:
        return new u(r12, r16, r3, r5, r0, (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r3.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin"));
    L15:
        if (ZeusTransformUtils.instanceOf(r4, j.class) == false) goto L17;
        r4 = ((j) ZeusTransformUtils.preCheckCast(r4, j.class, "com.obric.aiagent.plugin")).a(r14, r12);
        goto L17
    L7:
        if (ZeusTransformUtils.instanceOf(r16, com.fasterxml.jackson.databind.e.h.class) == false) goto L25;
        com.fasterxml.jackson.databind.k r6 = a(r14, r16, ((com.fasterxml.jackson.databind.e.h) ZeusTransformUtils.preCheckCast(r16, com.fasterxml.jackson.databind.e.h.class, "com.obric.aiagent.plugin")).getType());
        r10 = r6.w();
        r11 = r6.x();
        r12 = new com.fasterxml.jackson.databind.d.b(com.fasterxml.jackson.databind.x.a(r16.b()), r6, null, r16, com.fasterxml.jackson.databind.w.f13126b);
        goto L5
    L25:
        return (u) ZeusTransformUtils.preCheckCast(r14.b(r15.getType(), String.format("Unrecognized mutator type for any setter: %s", new Object[]{r16.getClass()})), u.class, "com.obric.aiagent.plugin");
    }

    public v a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.c r12, com.fasterxml.jackson.databind.e.t r13, com.fasterxml.jackson.databind.k r14) {
        com.fasterxml.jackson.databind.e.j r0 = r13.u();
        if (r0 != null) goto L5;
        r11.a(r12, r13, "No non-constructor mutator available", new Object[0]);
    L5:
        com.fasterxml.jackson.databind.k r15 = a(r11, r0, r14);
        com.fasterxml.jackson.databind.h.e r6 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r15.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.e.k.class) == false) goto L8;
        v r1 = new com.fasterxml.jackson.databind.b.a.o(r13, r15, r6, r12.f(), (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin"));
    L9:
        com.fasterxml.jackson.databind.l<?> r10 = a(r11, r0);
        if (r10 != null) goto L12;
        r10 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r15.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L12:
        if (r10 == null) goto L14;
        r1 = r1.a(r11.a(r10, r1, r15));
    L14:
        com.fasterxml.jackson.databind.b.a r16 = r13.x();
        if (r16 != null) goto L17;
    L19:
        com.fasterxml.jackson.databind.e.ac r17 = r13.A();
        if (r17 == null) goto L22;
        r1.a(r17);
    L22:
        return r1;
    L17:
        if (r16.b() == false) goto L19;
        r1.b(r16.a());
        goto L19
    L8:
        r1 = new com.fasterxml.jackson.databind.b.a.i(r13, r15, r6, r12.f(), (com.fasterxml.jackson.databind.e.h) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.e.h.class, "com.obric.aiagent.plugin"));
        goto L9
    }

    public v a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.c r12, com.fasterxml.jackson.databind.e.t r13) {
        com.fasterxml.jackson.databind.e.k r6 = r13.n();
        com.fasterxml.jackson.databind.k r7 = a(r11, r6, r6.getType());
        aa r9 = new aa(r13, r7, (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r7.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin"), r12.f(), r6);
        com.fasterxml.jackson.databind.l<?> r10 = a(r11, r6);
        if (r10 != null) goto L5;
        r10 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r7.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L5:
        if (r10 != null) goto L7;
        return r9;
    L7:
        return r9.a(r11.a(r10, r9, r7));
    }

    public boolean a(Class<?> r6) {
        String r5 = com.fasterxml.jackson.databind.l.h.a(r6);
        if (r5 != null) goto L14;
        if (com.fasterxml.jackson.databind.l.h.c(r6) == true) goto L12;
        String r3 = com.fasterxml.jackson.databind.l.h.a(r6, true);
        if (r3 != null) goto L10;
        return true;
    L10:
        throw new IllegalArgumentException("Cannot deserialize Class " + r6.getName() + " (of type " + r3 + ") as a Bean");
    L12:
        throw new IllegalArgumentException("Cannot deserialize Proxy class " + r6.getName() + " as a Bean");
    L14:
        throw new IllegalArgumentException("Cannot deserialize Class " + r6.getName() + " (of type " + r5 + ") as a Bean");
    }

    public boolean a(com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.databind.e.t r3, Class<?> r4, Map<Class<?>, Boolean> r5) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Boolean r6 = (Boolean) ZeusTransformUtils.preCheckCast(r1.get(r4), Boolean.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L7;
        return r6.booleanValue();
    L7:
        if (r4 != String.class) goto L9;
    L16:
        Boolean r7 = Boolean.FALSE;
    L17:
        r1.put(r4, r7);
        return r7.booleanValue();
    L9:
        if (r4.isPrimitive() == true) goto L16;
        r7 = r2.d(r4).f();
        if (r7 != null) goto L17;
        com.fasterxml.jackson.databind.c r8 = r2.c(r4);
        r7 = r2.j().b(r8.c());
        if (r7 != null) goto L17;
        r7 = Boolean.FALSE;
        goto L17
    }

    public void k(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3) {
        com.fasterxml.jackson.databind.h.a.p.a().a(r1, r2, r3);
    }
}
