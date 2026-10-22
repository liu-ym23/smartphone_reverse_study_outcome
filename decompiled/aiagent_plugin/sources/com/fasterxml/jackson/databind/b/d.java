package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.annotation.ObjectIdResolver;
import com.fasterxml.jackson.databind.b.a.ad;
import com.fasterxml.jackson.databind.b.a.ae;
import com.fasterxml.jackson.databind.b.b.aa;
import com.fasterxml.jackson.databind.b.b.ab;
import com.fasterxml.jackson.databind.e.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: BeanDeserializerBase.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends ab<Object> implements i, t, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.x f12511b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JsonFormat.Shape f12513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final y f12514e;
    protected com.fasterxml.jackson.databind.l<Object> f;
    protected com.fasterxml.jackson.databind.l<Object> g;
    protected com.fasterxml.jackson.databind.b.a.v h;
    protected boolean i;
    protected boolean j;
    protected final com.fasterxml.jackson.databind.b.a.c k;
    protected final ae[] l;
    protected u m;
    protected final Set<String> n;
    protected final Set<String> o;
    protected final boolean p;
    protected final boolean q;
    protected final Map<String, v> r;
    protected transient HashMap<com.fasterxml.jackson.databind.k.b, com.fasterxml.jackson.databind.l<Object>> s;
    protected ad t;
    protected com.fasterxml.jackson.databind.b.a.g u;
    protected final com.fasterxml.jackson.databind.b.a.s v;

    public abstract d a(boolean r1);

    @Override // com.fasterxml.jackson.databind.l
    public abstract com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.l.q r1);

    public abstract d b(com.fasterxml.jackson.databind.b.a.s r1);

    public abstract d b(Set<String> r1, Set<String> r2);

    public abstract Object b(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2);

    public abstract Object c(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2);

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        return true;
    }

    public abstract d h();

    static {
        f12511b = new com.fasterxml.jackson.databind.x("#temporary-name");
    }

    public d(e r4, com.fasterxml.jackson.databind.c r5, com.fasterxml.jackson.databind.b.a.c r6, Map<String, v> r7, Set<String> r8, boolean r9, Set<String> r10, boolean r11) {
        Map<String, v> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        Set<String> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r10, Set.class, "com.obric.aiagent.plugin");
        super(r5.getType());
        this.f12512c = r5.getType();
        y r0 = r4.c();
        this.f12514e = r0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.k = r6;
        this.r = r12;
        this.n = r13;
        this.p = r9;
        this.o = r14;
        this.m = r4.b();
        List<ae> r15 = r4.d();
        if (r15 != null) goto L5;
    L8:
        ae[] r16 = null;
    L9:
        this.l = r16;
        com.fasterxml.jackson.databind.b.a.s r17 = r4.e();
        this.v = r17;
        boolean r18 = false;
        if (this.t == null) goto L12;
    L19:
        boolean r19 = true;
    L20:
        this.i = r19;
        this.f12513d = r5.a(null).getShape();
        this.q = r11;
        if (this.i == true) goto L26;
        if (r16 != null) goto L26;
        if (r11 == true) goto L26;
        if (r17 != null) goto L26;
        r18 = true;
    L26:
        this.j = r18;
        return;
    L12:
        if (r0.l() == true) goto L19;
        if (r0.n() == true) goto L19;
        if (r0.k() == false) goto L19;
        r19 = false;
        goto L20
    L5:
        if (r15.isEmpty() == true) goto L8;
        r16 = (ae[]) ZeusTransformUtils.preCheckCast(r15.toArray(new ae[r15.size()]), ae[].class, "com.obric.aiagent.plugin");
        goto L9
    }

    public d(d r2) {
        this(r2, r2.p);
    }

    public d(d r2, boolean r3) {
        super(r2.f12512c);
        this.f12512c = r2.f12512c;
        this.f12514e = r2.f12514e;
        this.f = r2.f;
        this.g = r2.g;
        this.h = r2.h;
        this.k = r2.k;
        this.r = r2.r;
        this.n = r2.n;
        this.p = r3;
        this.o = r2.o;
        this.m = r2.m;
        this.l = r2.l;
        this.v = r2.v;
        this.i = r2.i;
        this.t = r2.t;
        this.q = r2.q;
        this.f12513d = r2.f12513d;
        this.j = r2.j;
    }

    public d(d r4, com.fasterxml.jackson.databind.l.q r5) {
        super(r4.f12512c);
        this.f12512c = r4.f12512c;
        this.f12514e = r4.f12514e;
        this.f = r4.f;
        this.g = r4.g;
        this.h = r4.h;
        this.r = r4.r;
        this.n = r4.n;
        if (r5 == null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        this.p = r1;
        this.o = r4.o;
        this.m = r4.m;
        this.l = r4.l;
        this.v = r4.v;
        this.i = r4.i;
        ad r2 = r4.t;
        if (r5 == null) goto L14;
        if (r2 == null) goto L13;
        r2 = r2.a(r5);
    L13:
        this.k = r4.k.a(r5);
    L15:
        this.t = r2;
        this.q = r4.q;
        this.f12513d = r4.f12513d;
        this.j = false;
        return;
    L14:
        this.k = r4.k;
        goto L15
    L5:
        if (r4.p == true) goto L8;
        r1 = false;
        goto L9
    }

    public d(d r3, com.fasterxml.jackson.databind.b.a.s r4) {
        super(r3.f12512c);
        this.f12512c = r3.f12512c;
        this.f12514e = r3.f12514e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.r = r3.r;
        this.n = r3.n;
        this.p = r3.p;
        this.o = r3.o;
        this.m = r3.m;
        this.l = r3.l;
        this.i = r3.i;
        this.t = r3.t;
        this.q = r3.q;
        this.f12513d = r3.f12513d;
        this.v = r4;
        if (r4 != null) goto L5;
        this.k = r3.k;
        this.j = r3.j;
        return;
    L5:
        com.fasterxml.jackson.databind.b.a.u r0 = new com.fasterxml.jackson.databind.b.a.u(r4, com.fasterxml.jackson.databind.w.f13125a);
        this.k = r3.k.a(r0);
        this.j = false;
    }

    public d(d r3, Set<String> r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        super(r3.f12512c);
        this.f12512c = r3.f12512c;
        this.f12514e = r3.f12514e;
        this.f = r3.f;
        this.g = r3.g;
        this.h = r3.h;
        this.r = r3.r;
        this.n = r6;
        this.p = r3.p;
        this.o = r7;
        this.m = r3.m;
        this.l = r3.l;
        this.i = r3.i;
        this.t = r3.t;
        this.q = r3.q;
        this.f12513d = r3.f12513d;
        this.j = r3.j;
        this.v = r3.v;
        this.k = r3.k.a(r6, r7);
    }

    public d(d r2, com.fasterxml.jackson.databind.b.a.c r3) {
        super(r2.f12512c);
        this.f12512c = r2.f12512c;
        this.f12514e = r2.f12514e;
        this.f = r2.f;
        this.g = r2.g;
        this.h = r2.h;
        this.k = r3;
        this.r = r2.r;
        this.n = r2.n;
        this.p = r2.p;
        this.o = r2.o;
        this.m = r2.m;
        this.l = r2.l;
        this.v = r2.v;
        this.i = r2.i;
        this.t = r2.t;
        this.q = r2.q;
        this.f12513d = r2.f12513d;
        this.j = r2.j;
    }

    public d a(com.fasterxml.jackson.databind.b.a.c r3) {
        throw new UnsupportedOperationException("Class " + getClass().getName() + " does not override `withBeanProperties()`, needs to");
    }

    @Override // com.fasterxml.jackson.databind.b.t
    public void d(com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.b.a.g.a r1 = null;
        boolean r2 = false;
        if (this.f12514e.n() == false) goto L14;
        v[] r0 = this.f12514e.a(r11.c());
        if (this.n == null) goto L7;
    L8:
        int r3 = r0.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L15;
        if (com.fasterxml.jackson.databind.l.m.a(r0[r4].a(), this.n, this.o) == false) goto L13;
        r0[r4].e();
    L13:
        r4 = r4 + 1;
    L15:
        Iterator<v> r5 = this.k.iterator();
    L17:
        if (r5.hasNext() == false) goto L24;
        v r6 = (v) ZeusTransformUtils.preCheckCast(r5.next(), v.class, "com.obric.aiagent.plugin");
        if (r6.m() == true) goto L17;
        com.fasterxml.jackson.databind.l<Object> r7 = a(r11, r6);
        if (r7 != null) goto L23;
        r7 = r11.a(r6.getType());
    L23:
        a(this.k, r0, r6, r6.a(r7));
        goto L17
    L24:
        Iterator<v> r8 = this.k.iterator();
        ad r9 = null;
    L26:
        if (r8.hasNext() == false) goto L49;
        v r10 = (v) ZeusTransformUtils.preCheckCast(r8.next(), v.class, "com.obric.aiagent.plugin");
        v r12 = b(r11, r10.a(r11.a(r10.o(), r10, r10.getType())));
        if (ZeusTransformUtils.instanceOf(r12, com.fasterxml.jackson.databind.b.a.m.class) == true) goto L30;
        r12 = c(r11, r12);
    L30:
        com.fasterxml.jackson.databind.l.q r13 = d(r11, r12);
        if (r13 == null) goto L39;
        com.fasterxml.jackson.databind.l<Object> r14 = r12.o();
        com.fasterxml.jackson.databind.l<Object> r15 = r14.a(r13);
        if (r15 == r14) goto L39;
        if (r15 == null) goto L39;
        v r16 = r12.a(r15);
        if (r9 != null) goto L38;
        r9 = new ad();
    L38:
        r9.a(r16);
        this.k.b(r16);
    L39:
        v r17 = e(r11, a(r11, r12, r12.c()));
        if (r17 == r10) goto L43;
        a(this.k, r0, r10, r17);
    L43:
        if (r17.n() == false) goto L26;
        com.fasterxml.jackson.databind.h.e r18 = r17.p();
        if (r18.a() != JsonTypeInfo.As.EXTERNAL_PROPERTY) goto L26;
        if (r1 != null) goto L48;
        r1 = com.fasterxml.jackson.databind.b.a.g.a(this.f12512c);
    L48:
        r1.a(r17, r18);
        this.k.b(r17);
        goto L26
    L49:
        u r19 = this.m;
        if (r19 == null) goto L55;
        if (r19.b() == true) goto L55;
        u r20 = this.m;
        this.m = r20.a(a(r11, r20.getType(), this.m.a()));
    L55:
        if (this.f12514e.l() == false) goto L61;
        com.fasterxml.jackson.databind.k r21 = this.f12514e.b(r11.c());
        if (r21 != null) goto L59;
        com.fasterxml.jackson.databind.k r22 = this.f12512c;
        r11.b(r22, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{com.fasterxml.jackson.databind.l.h.b(r22), com.fasterxml.jackson.databind.l.h.d(this.f12514e)}));
    L59:
        this.f = a(r11, r21, this.f12514e.p());
    L61:
        if (this.f12514e.m() == false) goto L66;
        com.fasterxml.jackson.databind.k r23 = this.f12514e.c(r11.c());
        if (r23 != null) goto L65;
        com.fasterxml.jackson.databind.k r24 = this.f12512c;
        r11.b(r24, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{com.fasterxml.jackson.databind.l.h.b(r24), com.fasterxml.jackson.databind.l.h.d(this.f12514e)}));
    L65:
        this.g = a(r11, r23, this.f12514e.q());
    L66:
        if (r0 == null) goto L68;
        this.h = com.fasterxml.jackson.databind.b.a.v.a(r11, this.f12514e, r0, this.k);
    L68:
        if (r1 == null) goto L70;
        this.u = r1.a(this.k);
        this.i = true;
    L70:
        this.t = r9;
        if (r9 == null) goto L74;
        this.i = true;
    L74:
        if (this.j == true) goto L76;
    L78:
        this.j = r2;
        return;
    L76:
        if (this.i == true) goto L78;
        r2 = true;
        goto L78
    L7:
        if (this.o == null) goto L15;
    L14:
        r0 = null;
        goto L15
    }

    public void a(com.fasterxml.jackson.databind.b.a.c r2, v[] r3, v r4, v r5) {
        r2.a(r4, r5);
        if (r3 == null) goto L11;
        int r1 = 0;
        int r6 = r3.length;
    L5:
        if (r1 >= r6) goto L14;
        if (r3[r1] == r4) goto L8;
        r1 = r1 + 1;
        goto L5
    L8:
        r3[r1] = r5;
        return;
    L14:
        return;
    }

    private com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r8, com.fasterxml.jackson.databind.k r9, com.fasterxml.jackson.databind.e.o r10) {
        com.fasterxml.jackson.databind.d.b r6 = new com.fasterxml.jackson.databind.d.b(f12511b, r9, null, r10, com.fasterxml.jackson.databind.w.f13126b);
        com.fasterxml.jackson.databind.h.e r11 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r9.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r11 != null) goto L5;
        r11 = r8.c().c(r9);
    L5:
        com.fasterxml.jackson.databind.l<?> r0 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r9.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L8;
        com.fasterxml.jackson.databind.l<?> r7 = a(r8, r9, r6);
    L9:
        if (r11 != null) goto L11;
        return r7;
    L11:
        return new com.fasterxml.jackson.databind.b.a.ab(r11.a(r6), r7);
    L8:
        r7 = r8.b(r0, r6, r9);
        goto L9
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r2, v r3) {
        com.fasterxml.jackson.databind.b r1 = r2.f();
        if (r1 == null) goto L8;
        Object r4 = r1.A(r3.d());
        if (r4 == null) goto L10;
        com.fasterxml.jackson.databind.l.j<Object, Object> r5 = r2.a(r3.d(), r4);
        com.fasterxml.jackson.databind.k r6 = r5.a(r2.b());
        return new aa(r5, r6, r2.a(r6));
    L10:
        return null;
    L8:
        return null;
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r13, com.fasterxml.jackson.databind.d r14) {
        com.fasterxml.jackson.databind.d r15 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r14, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b.a.s r0 = this.v;
        com.fasterxml.jackson.databind.b r2 = r13.f();
        JsonFormat.Shape r4 = null;
        if (b(r15, r2) == false) goto L5;
        com.fasterxml.jackson.databind.e.j r3 = r15.d();
    L6:
        if (r3 == null) goto L18;
        ac r5 = r2.a(r3);
        if (r5 == null) goto L18;
        ac r1 = r2.a(r3, r5);
        Class<? extends ObjectIdGenerator<?>> r6 = r1.d();
        ObjectIdResolver r11 = r13.b(r3, r1);
        if (r6 != ObjectIdGenerators.PropertyGenerator.class) goto L16;
        com.fasterxml.jackson.databind.x r7 = r1.b();
        v r8 = a(r7);
        if (r8 == null) goto L14;
        com.fasterxml.jackson.databind.k r9 = r8.getType();
        ObjectIdGenerator<?> r10 = new com.fasterxml.jackson.databind.b.a.w(r1.c());
        v r12 = r8;
        com.fasterxml.jackson.databind.k r16 = r9;
    L17:
        r0 = com.fasterxml.jackson.databind.b.a.s.a(r16, r1.b(), r10, r13.b(r16), r12, r11);
        goto L18
    L14:
        return (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r13.b(this.f12512c, String.format("Invalid Object Id definition for %s: cannot find property with name %s", new Object[]{com.fasterxml.jackson.databind.l.h.h(a()), com.fasterxml.jackson.databind.l.h.a(r7)})), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L16:
        r16 = r13.b().c(r13.b(r6), ObjectIdGenerator.class)[0];
        r12 = null;
        r10 = r13.a(r3, r1);
    L18:
        if (r0 != null) goto L20;
    L22:
        d r17 = this;
    L23:
        if (r3 == null) goto L25;
        r17 = a(r13, r2, r17, r3);
    L25:
        JsonFormat.Value r18 = a(r13, r15, a());
        if (r18 != null) goto L28;
    L35:
        if (r4 != null) goto L38;
        r4 = this.f12513d;
    L38:
        if (r4 == JsonFormat.Shape.ARRAY) goto L40;
        return r17;
    L40:
        return r17.h();
    L28:
        if (r18.hasShape() == false) goto L30;
        r4 = r18.getShape();
    L30:
        Boolean r19 = r18.getFeature(JsonFormat.Feature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
        if (r19 == null) goto L35;
        com.fasterxml.jackson.databind.b.a.c r110 = this.k;
        com.fasterxml.jackson.databind.b.a.c r111 = r110.a(r19.booleanValue());
        if (r111 == r110) goto L35;
        r17 = r17.a(r111);
        goto L35
    L20:
        if (r0 == this.v) goto L22;
        r17 = b(r0);
        goto L23
    L5:
        r3 = null;
        goto L6
    }

    public d a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.b r4, d r5, com.fasterxml.jackson.databind.e.j r6) {
        com.fasterxml.jackson.databind.g r7 = r3.c();
        JsonIgnoreProperties.Value r0 = r4.a(r7, r6);
        if (r0.getIgnoreUnknown() == true) goto L5;
    L7:
        Set<String> r2 = r0.findIgnoredForDeserialization();
        Set<String> r1 = r5.n;
        if (r2.isEmpty() == false) goto L10;
        r2 = r1;
    L15:
        Set<String> r8 = r5.o;
        Set<String> r9 = com.fasterxml.jackson.databind.l.m.b(r8, r4.b(r7, r6).getIncluded());
        if (r2 != r1) goto L19;
        if (r9 != r8) goto L19;
        return r5;
    L19:
        return r5.b(r2, r9);
    L10:
        if (r1 == null) goto L15;
        if (r1.isEmpty() == true) goto L15;
        HashSet r10 = new HashSet(r1);
        r10.addAll(r2);
        r2 = r10;
        goto L15
    L5:
        if (this.p == true) goto L7;
        r5 = r5.a(true);
        goto L7
    }

    public v b(com.fasterxml.jackson.databind.h r11, v r12) {
        String r0 = r12.k();
        if (r0 != null) goto L5;
        return r12;
    L5:
        v r1 = r12.o().a(r0);
        if (r1 == null) goto L8;
        com.fasterxml.jackson.databind.k r5 = this.f12512c;
        com.fasterxml.jackson.databind.k r6 = r1.getType();
        boolean r7 = r12.getType().q();
        if (r6.e().isAssignableFrom(r5.e()) == true) goto L13;
        r11.b(this.f12512c, String.format("Cannot handle managed/back reference %s: back reference type (%s) not compatible with managed type (%s)", new Object[]{com.fasterxml.jackson.databind.l.h.b(r0), com.fasterxml.jackson.databind.l.h.b(r6), r5.e().getName()}));
    L13:
        return new com.fasterxml.jackson.databind.b.a.m(r12, r0, r1, r7);
    L8:
        return (v) ZeusTransformUtils.preCheckCast(r11.b(this.f12512c, String.format("Cannot handle managed/back reference %s: no back reference property found from type %s", new Object[]{com.fasterxml.jackson.databind.l.h.b(r0), com.fasterxml.jackson.databind.l.h.b(r12.getType())})), v.class, "com.obric.aiagent.plugin");
    }

    public v c(com.fasterxml.jackson.databind.h r1, v r2) {
        ac r0 = r2.l();
        com.fasterxml.jackson.databind.l<Object> r3 = r2.o();
        if (r3 != null) goto L5;
        com.fasterxml.jackson.databind.b.a.s r4 = null;
    L6:
        if (r0 != null) goto L10;
        if (r4 != null) goto L10;
        return r2;
    L10:
        return new com.fasterxml.jackson.databind.b.a.t(r2, r0);
    L5:
        r4 = r3.f();
        goto L6
    }

    public com.fasterxml.jackson.databind.l.q d(com.fasterxml.jackson.databind.h r4, v r5) {
        com.fasterxml.jackson.databind.e.j r0 = r5.d();
        if (r0 == null) goto L10;
        com.fasterxml.jackson.databind.l.q r1 = r4.f().c(r0);
        if (r1 != null) goto L7;
        return null;
    L7:
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L9;
        r4.b(j(), String.format("Cannot define Creator property \"%s\" as `@JsonUnwrapped`: combination not yet supported", new Object[]{r5.a()}));
    L9:
        return r1;
    L10:
        return null;
    }

    public v e(com.fasterxml.jackson.databind.h r9, v r10) {
        com.fasterxml.jackson.databind.l<Object> r1 = r10.o();
        if (ZeusTransformUtils.instanceOf(r1, d.class) == true) goto L5;
    L22:
        return r10;
    L5:
        if (((d) ZeusTransformUtils.preCheckCast(r1, d.class, "com.obric.aiagent.plugin")).k().k() == true) goto L22;
        Class<?> r0 = r10.getType().e();
        Class<?> r2 = com.fasterxml.jackson.databind.l.h.b(r0);
        if (r2 == null) goto L22;
        if (r2 != this.f12512c.e()) goto L22;
        Constructor<?>[] r8 = r0.getConstructors();
        int r3 = r8.length;
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L22;
        Constructor<?> r5 = r8[r4];
        Class<?>[] r6 = r5.getParameterTypes();
        if (r6.length != 1) goto L21;
        if (r2.equals(r6[0]) == false) goto L21;
        if (r9.e() == false) goto L20;
        com.fasterxml.jackson.databind.l.h.a(r5, r9.a(com.fasterxml.jackson.databind.r.o));
    L20:
        return new com.fasterxml.jackson.databind.b.a.j(r10, r5);
    L21:
        r4 = r4 + 1;
        goto L11
    }

    public v a(com.fasterxml.jackson.databind.h r4, v r5, com.fasterxml.jackson.databind.w r6) {
        com.fasterxml.jackson.databind.w.a r0 = r6.d();
        if (r0 == null) goto L18;
        com.fasterxml.jackson.databind.l<Object> r1 = r5.o();
        Boolean r2 = r1.a(r4.c());
        if (r2 != null) goto L10;
        if (r0.f13131b == false) goto L15;
        return r5;
    L15:
        com.fasterxml.jackson.databind.e.j r3 = r0.f13130a;
        r3.a(r4.a(com.fasterxml.jackson.databind.r.o));
        if (ZeusTransformUtils.instanceOf(r5, com.fasterxml.jackson.databind.b.a.aa.class) == true) goto L18;
        r5 = com.fasterxml.jackson.databind.b.a.n.a(r5, r3);
        goto L18
    L10:
        if (r2.booleanValue() == true) goto L15;
        if (r0.f13131b == true) goto L14;
        r4.a(r1);
    L14:
        return r5;
    L18:
        s r7 = b(r4, r5, r6);
        if (r7 != null) goto L21;
        return r5;
    L21:
        return r5.a(r7);
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.l.a e() {
        return com.fasterxml.jackson.databind.l.a.f12996c;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Object c(com.fasterxml.jackson.databind.h r1) {
        return this.f12514e.a(r1);
    L4:
        e = move-exception;
        return com.fasterxml.jackson.databind.l.h.a(r1, e);
    }

    @Override // com.fasterxml.jackson.databind.l
    public Boolean a(com.fasterxml.jackson.databind.g r1) {
        return Boolean.TRUE;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Class<?> a() {
        return this.f12512c.e();
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.b.a.s f() {
        return this.v;
    }

    @Override // com.fasterxml.jackson.databind.l
    public Collection<Object> d() {
        ArrayList r0 = new ArrayList();
        Iterator<v> r4 = this.k.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(((v) ZeusTransformUtils.preCheckCast(r4.next(), v.class, "com.obric.aiagent.plugin")).a());
        goto L4
    L6:
        return r0;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.k j() {
        return this.f12512c;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12970d;
    }

    public v a(com.fasterxml.jackson.databind.x r1) {
        return b(r1.b());
    }

    public v b(String r2) {
        com.fasterxml.jackson.databind.b.a.c r0 = this.k;
        if (r0 != null) goto L5;
        v r1 = null;
    L6:
        if (r1 != null) goto L11;
        com.fasterxml.jackson.databind.b.a.v r3 = this.h;
        if (r3 != null) goto L10;
        return r1;
    L10:
        return r3.a(r2);
    L11:
        return r1;
    L5:
        r1 = r0.a(r2);
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.l
    public v a(String r2) {
        Map<String, v> r1 = this.r;
        if (r1 != null) goto L7;
        return null;
    L7:
        return (v) ZeusTransformUtils.preCheckCast(r1.get(r2), v.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public y k() {
        return this.f12514e;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, com.fasterxml.jackson.databind.h.e r5) {
        if (this.v == null) goto L28;
        if (r3.S() == false) goto L10;
        Object r0 = r3.U();
        if (r0 == null) goto L10;
        return a(r3, r4, r5.a(r3, r4), r0);
    L10:
        com.fasterxml.jackson.a.n r1 = r3.l();
        if (r1 == null) goto L28;
        if (r1.g() == false) goto L17;
        return k(r3, r4);
    L17:
        if (r1 != com.fasterxml.jackson.a.n.f12152b) goto L20;
        r1 = r3.g();
    L20:
        if (r1 != com.fasterxml.jackson.a.n.f) goto L28;
        if (this.v.c() == false) goto L28;
        if (this.v.a(r3.w(), r3) == false) goto L28;
        return k(r3, r4);
    L28:
        return r5.a(r3, r4);
    }

    public Object a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Object r6, Object r7) {
        com.fasterxml.jackson.databind.l<Object> r0 = this.v.a();
        if (r0.a() == r7.getClass()) goto L6;
        r7 = a(r4, r5, r7, r0);
    L6:
        r5.a(r7, this.v.f12330c, this.v.f12331d).a(r6);
        v r3 = this.v.f;
        if (r3 != null) goto L9;
        return r6;
    L9:
        return r3.b(r6, r7);
    }

    public Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5, com.fasterxml.jackson.databind.l<Object> r6) {
        com.fasterxml.jackson.databind.l.y r2 = r4.a(r3);
        if (ZeusTransformUtils.instanceOf(r5, String.class) == false) goto L6;
        r2.b((String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin"));
    L12:
        com.fasterxml.jackson.a.k r7 = r2.o();
        r7.g();
        return r6.a(r7, r4);
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Long.class) == false) goto L9;
        r2.b(((Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.aiagent.plugin")).longValue());
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Integer.class) == false) goto L11;
        r2.d(((Integer) ZeusTransformUtils.preCheckCast(r5, Integer.class, "com.obric.aiagent.plugin")).intValue());
        goto L12
    L11:
        r2.h(r5);
        goto L12
    }

    public Object j(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    public Object k(com.fasterxml.jackson.a.k r5, com.fasterxml.jackson.databind.h r6) {
        Object r0 = this.v.a(r5, r6);
        com.fasterxml.jackson.databind.b.a.z r7 = r6.a(r0, this.v.f12330c, this.v.f12331d);
        Object r1 = r7.b();
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new w(r5, "Could not resolve Object Id [" + r0 + "] (for " + this.f12512c + ").", r5.e(), r7);
    }

    public Object l(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9) {
        com.fasterxml.jackson.databind.l<Object> r0 = l();
        if (r0 == null) goto L9;
        Object r10 = this.f12514e.a(r9, r0.a(r8, r9));
        if (this.l == null) goto L7;
        a(r9, r10);
    L7:
        return r10;
    L9:
        if (this.h != null) goto L11;
        Class<?> r2 = this.f12512c.e();
        if (com.fasterxml.jackson.databind.l.h.p(r2) == false) goto L17;
        return r9.a(r2, null, r8, "non-static inner classes like this can only by instantiated using default, no-argument constructor", new Object[0]);
    L17:
        return r9.a(r2, k(), r8, "cannot deserialize from Object value (no delegate- or property-based Creator)", new Object[0]);
    L11:
        return c(r8, r9);
    }

    public Object m(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        if (this.v != null) goto L5;
        com.fasterxml.jackson.databind.l<Object> r0 = l();
        com.fasterxml.jackson.a.k.b r1 = r7.E();
        if (r1 != com.fasterxml.jackson.a.k.b.f12143a) goto L18;
        if (r0 == null) goto L16;
        if (this.f12514e.e() == true) goto L16;
        Object r9 = this.f12514e.a(r8, r0.a(r7, r8));
        if (this.l == null) goto L14;
        a(r8, r9);
    L14:
        return r9;
    L16:
        return this.f12514e.a(r8, r7.H());
    L18:
        if (r1 != com.fasterxml.jackson.a.k.b.f12144b) goto L29;
        if (r0 == null) goto L27;
        if (this.f12514e.e() == true) goto L27;
        Object r10 = this.f12514e.a(r8, r0.a(r7, r8));
        if (this.l == null) goto L25;
        a(r8, r10);
    L25:
        return r10;
    L27:
        return this.f12514e.a(r8, r7.I());
    L29:
        if (r1 != com.fasterxml.jackson.a.k.b.f12145c) goto L40;
        if (r0 == null) goto L38;
        if (this.f12514e.g() == true) goto L38;
        Object r11 = this.f12514e.a(r8, r0.a(r7, r8));
        if (this.l == null) goto L36;
        a(r8, r11);
    L36:
        return r11;
    L38:
        return this.f12514e.a(r8, r7.J());
    L40:
        return r8.a(a(), k(), r7, "no suitable creator method found to deserialize from Number value (%s)", new Object[]{r7.C()});
    L5:
        return k(r7, r8);
    }

    public Object n(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        if (this.v != null) goto L5;
        com.fasterxml.jackson.databind.l<Object> r0 = l();
        if (r0 == null) goto L15;
        if (this.f12514e.d() == true) goto L15;
        Object r5 = this.f12514e.a(r4, r0.a(r3, r4));
        if (this.l == null) goto L13;
        a(r4, r5);
    L13:
        return r5;
    L15:
        return r(r3, r4);
    L5:
        return k(r3, r4);
    }

    public Object o(com.fasterxml.jackson.a.k r7, com.fasterxml.jackson.databind.h r8) {
        com.fasterxml.jackson.a.k.b r0 = r7.E();
        if (r0 != com.fasterxml.jackson.a.k.b.f12147e) goto L5;
    L21:
        com.fasterxml.jackson.databind.l<Object> r1 = l();
        if (r1 == null) goto L30;
        if (this.f12514e.h() == true) goto L30;
        Object r9 = this.f12514e.a(r8, r1.a(r7, r8));
        if (this.l == null) goto L28;
        a(r8, r9);
    L28:
        return r9;
    L30:
        return this.f12514e.a(r8, r7.L());
    L5:
        if (r0 == com.fasterxml.jackson.a.k.b.f12146d) goto L21;
        if (r0 != com.fasterxml.jackson.a.k.b.f) goto L20;
        com.fasterxml.jackson.databind.l<Object> r2 = l();
        if (r2 == null) goto L18;
        if (this.f12514e.i() == true) goto L18;
        Object r10 = this.f12514e.a(r8, r2.a(r7, r8));
        if (this.l == null) goto L16;
        a(r8, r10);
    L16:
        return r10;
    L18:
        return this.f12514e.a(r8, r7.M());
    L20:
        return r8.a(a(), k(), r7, "no suitable creator method found to deserialize from Number value (%s)", new Object[]{r7.C()});
    }

    public Object p(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4) {
        com.fasterxml.jackson.databind.l<Object> r0 = l();
        if (r0 == null) goto L11;
        if (this.f12514e.j() == true) goto L11;
        Object r5 = this.f12514e.a(r4, r0.a(r3, r4));
        if (this.l == null) goto L9;
        a(r4, r5);
    L9:
        return r5;
    L11:
        if (r3.l() != com.fasterxml.jackson.a.n.k) goto L13;
        boolean r6 = true;
    L15:
        return this.f12514e.a(r4, r6);
    L13:
        r6 = false;
        goto L15
    }

    public Object q(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5) {
        if (this.v != null) goto L5;
        com.fasterxml.jackson.databind.l<Object> r0 = l();
        if (r0 != null) goto L9;
    L14:
        Object r1 = r4.N();
        if (r1 != null) goto L17;
        return r1;
    L17:
        if (this.f12512c.c(r1.getClass()) == false) goto L19;
        return r1;
    L19:
        return r5.a(this.f12512c, r1, r4);
    L9:
        if (this.f12514e.d() == true) goto L14;
        Object r6 = this.f12514e.a(r5, r0.a(r4, r5));
        if (this.l == null) goto L13;
        a(r5, r6);
    L13:
        return r6;
    L5:
        return k(r4, r5);
    }

    public final com.fasterxml.jackson.databind.l<Object> l() {
        com.fasterxml.jackson.databind.l<Object> r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.g;
    }

    public void a(com.fasterxml.jackson.databind.h r4, Object r5) {
        ae[] r3 = this.l;
        int r0 = r3.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        r3[r1].b(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    public Object a(com.fasterxml.jackson.databind.h r3, Object r4, com.fasterxml.jackson.databind.l.y r5) {
        r5.k();
        com.fasterxml.jackson.a.k r6 = r5.o();
    L4:
        if (r6.g() == com.fasterxml.jackson.a.n.f12153c) goto L6;
        String r0 = r6.w();
        r6.g();
        b(r6, r3, r4, r0);
        goto L4
    L6:
        return r4;
    }

    public void a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5, String r6) {
        if (com.fasterxml.jackson.databind.l.m.a(r6, this.n, this.o) == false) goto L5;
        c(r3, r4, r5, r6);
        return;
    L5:
        u r0 = this.m;
        if (r0 != null) goto L13;
        b(r3, r4, r5, r6);
        return;
    L13:
        r0.a(r3, r4, r5, r6);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        a(e, r5, r6, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public void b(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5, String r6) {
        if (this.p == false) goto L7;
        r3.k();
        return;
    L7:
        if (com.fasterxml.jackson.databind.l.m.a(r6, this.n, this.o) == false) goto L9;
        c(r3, r4, r5, r6);
    L9:
        super.b(r3, r4, r5, r6);
    }

    public void c(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4, String r5) {
        if (r3.a(com.fasterxml.jackson.databind.i.j) == true) goto L7;
        r2.k();
        return;
    L7:
        throw com.fasterxml.jackson.databind.c.a.a(r2, r4, r5, d());
    }

    public Object a(com.fasterxml.jackson.a.k r2, com.fasterxml.jackson.databind.h r3, Object r4, com.fasterxml.jackson.databind.l.y r5) {
        com.fasterxml.jackson.databind.l<Object> r0 = b(r3, r4, r5);
        if (r0 == null) goto L9;
        if (r5 == null) goto L6;
        r5.k();
        com.fasterxml.jackson.a.k r1 = r5.o();
        r1.g();
        r4 = r0.a(r1, r3, r4);
    L6:
        if (r2 != null) goto L8;
        return r4;
    L8:
        return r0.a(r2, r3, r4);
    L9:
        if (r5 == null) goto L11;
        r4 = a(r3, r4, r5);
    L11:
        if (r2 != null) goto L13;
        return r4;
    L13:
        return a(r2, r3, r4);
    }

    public com.fasterxml.jackson.databind.l<Object> b(com.fasterxml.jackson.databind.h r3, Object r4, com.fasterxml.jackson.databind.l.y r5) {
        monitor-enter(this);
        HashMap<com.fasterxml.jackson.databind.k.b, com.fasterxml.jackson.databind.l<Object>> r6 = this.s;     // Catch: Throwable -> L23
        if (r6 != null) goto L6;
        com.fasterxml.jackson.databind.l<Object> r7 = null;
    L7:
        monitor-exit(this);     // Catch: Throwable -> L23
        if (r7 == null) goto L10;
        return r7;
    L10:
        com.fasterxml.jackson.databind.l<Object> r8 = r3.b(r3.b(r4.getClass()));
        if (r8 == null) goto L22;
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (this.s != null) goto L16;
        this.s = new HashMap();     // Catch: Throwable -> L19
    L16:
        this.s.put(new com.fasterxml.jackson.databind.k.b(r4.getClass()), r8);     // Catch: Throwable -> L19
        monitor-exit(this);     // Catch: Throwable -> L19
    L22:
        return r8;
    L6:
        r7 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r6.get(new com.fasterxml.jackson.databind.k.b(r4.getClass())), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public void a(Throwable r1, Object r2, String r3, com.fasterxml.jackson.databind.h r4) {
        throw com.fasterxml.jackson.databind.m.a(b(r1, r4), r2, r3);
    }

    private Throwable b(Throwable r1, com.fasterxml.jackson.databind.h r2) {
    L3:
        if (ZeusTransformUtils.instanceOf(r1, InvocationTargetException.class) == false) goto L7;
        if (r1.getCause() == null) goto L7;
        r1 = r1.getCause();
    L7:
        com.fasterxml.jackson.databind.l.h.a(r1);
        if (r2 != null) goto L10;
    L13:
        boolean r0 = true;
    L15:
        if (ZeusTransformUtils.instanceOf(r1, IOException.class) == false) goto L22;
        if (r0 == false) goto L21;
        if (ZeusTransformUtils.instanceOf(r1, com.fasterxml.jackson.a.e.class) == false) goto L21;
    L24:
        return r1;
    L21:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r1, IOException.class, "com.obric.aiagent.plugin"));
    L22:
        if (r0 == true) goto L24;
        com.fasterxml.jackson.databind.l.h.b(r1);
        goto L24
    L10:
        if (r2.a(com.fasterxml.jackson.databind.i.p) == true) goto L13;
        r0 = false;
        goto L15
    }

    public Object a(Throwable r2, com.fasterxml.jackson.databind.h r3) {
    L3:
        if (ZeusTransformUtils.instanceOf(r2, InvocationTargetException.class) == false) goto L7;
        if (r2.getCause() == null) goto L7;
        r2 = r2.getCause();
    L7:
        com.fasterxml.jackson.databind.l.h.a(r2);
        if (ZeusTransformUtils.instanceOf(r2, IOException.class) == true) goto L18;
        if (r3 == null) goto L16;
        if (r3.a(com.fasterxml.jackson.databind.i.p) == true) goto L14;
        com.fasterxml.jackson.databind.l.h.b(r2);
    L14:
        return r3.a(this.f12512c.e(), null, r2);
    L16:
        throw new IllegalArgumentException(r2.getMessage(), r2);
    L18:
        throw ((IOException) ZeusTransformUtils.preCheckCast(r2, IOException.class, "com.obric.aiagent.plugin"));
    }
}
