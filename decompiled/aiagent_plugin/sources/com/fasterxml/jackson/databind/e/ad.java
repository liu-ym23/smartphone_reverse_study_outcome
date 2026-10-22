package com.fasterxml.jackson.databind.e;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: POJOPropertiesCollector.java */
/* JADX INFO: loaded from: classes2.dex */
public class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.m<?> f12575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final a f12576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final boolean f12577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final d f12579e;
    protected final ai<?> f;
    protected final com.fasterxml.jackson.databind.b g;
    protected final boolean h;
    protected boolean i;
    protected LinkedHashMap<String, ae> j;
    protected LinkedList<ae> k;
    protected Map<com.fasterxml.jackson.databind.x, com.fasterxml.jackson.databind.x> l;
    protected LinkedList<j> m;
    protected LinkedList<j> n;
    protected LinkedList<k> o;
    protected LinkedList<j> p;
    protected LinkedList<j> q;
    protected LinkedList<j> r;
    protected HashSet<String> s;
    protected LinkedHashMap<Object, j> t;

    @Deprecated
    protected final boolean u;

    @Deprecated
    protected String v;

    public ad(com.fasterxml.jackson.databind.a.m<?> r2, boolean r3, com.fasterxml.jackson.databind.k r4, d r5, a r6) {
        this.v = "set";
        this.f12575a = r2;
        this.f12577c = r3;
        this.f12578d = r4;
        this.f12579e = r5;
        if (r2.f() == false) goto L5;
        this.h = true;
        this.g = r2.j();
    L6:
        this.f = r2.a(r4.e(), r5);
        this.f12576b = r6;
        this.u = r2.a(com.fasterxml.jackson.databind.r.z);
        return;
    L5:
        this.h = false;
        this.g = com.fasterxml.jackson.databind.b.a();
        goto L6
    }

    public com.fasterxml.jackson.databind.a.m<?> a() {
        return this.f12575a;
    }

    public com.fasterxml.jackson.databind.k getType() {
        return this.f12578d;
    }

    public d b() {
        return this.f12579e;
    }

    public List<t> c() {
        return new ArrayList(m().values());
    }

    public Map<Object, j> d() {
        if (this.i == true) goto L6;
        n();
    L6:
        return this.t;
    }

    public j e() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<j> r0 = this.q;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'as-key' properties defined (%s vs %s)", new Object[]{this.q.get(0), this.q.get(1)});
    L11:
        return (j) ZeusTransformUtils.preCheckCast(this.q.get(0), j.class, "com.obric.aiagent.plugin");
    }

    public j f() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<j> r0 = this.r;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'as-value' properties defined (%s vs %s)", new Object[]{this.r.get(0), this.r.get(1)});
    L11:
        return (j) ZeusTransformUtils.preCheckCast(this.r.get(0), j.class, "com.obric.aiagent.plugin");
    }

    public j g() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<j> r0 = this.n;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'any-getter' fields defined (%s vs %s)", new Object[]{this.n.get(0), this.n.get(1)});
    L11:
        return (j) ZeusTransformUtils.preCheckCast(this.n.getFirst(), j.class, "com.obric.aiagent.plugin");
    }

    public j h() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<j> r0 = this.m;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'any-getter' methods defined (%s vs %s)", new Object[]{this.m.get(0), this.m.get(1)});
    L11:
        return (j) ZeusTransformUtils.preCheckCast(this.m.getFirst(), j.class, "com.obric.aiagent.plugin");
    }

    public j i() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<j> r0 = this.p;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'any-setter' fields defined (%s vs %s)", new Object[]{this.p.get(0), this.p.get(1)});
    L11:
        return (j) ZeusTransformUtils.preCheckCast(this.p.getFirst(), j.class, "com.obric.aiagent.plugin");
    }

    public k j() {
        if (this.i == true) goto L5;
        n();
    L5:
        LinkedList<k> r0 = this.o;
        if (r0 != null) goto L8;
        return null;
    L8:
        if (r0.size() <= 1) goto L11;
        a("Multiple 'any-setter' methods defined (%s vs %s)", new Object[]{this.o.get(0), this.o.get(1)});
    L11:
        return (k) ZeusTransformUtils.preCheckCast(this.o.getFirst(), k.class, "com.obric.aiagent.plugin");
    }

    public Set<String> k() {
        return this.s;
    }

    public ac l() {
        ac r0 = this.g.a(this.f12579e);
        if (r0 != null) goto L5;
        return r0;
    L5:
        return this.g.a(this.f12579e, r0);
    }

    public Map<String, ae> m() {
        if (this.i == true) goto L6;
        n();
    L6:
        return this.j;
    }

    public void n() {
        LinkedHashMap<String, ae> r0 = new LinkedHashMap();
        a(r0);
        c(r0);
        if (this.f12579e.l() == true) goto L5;
        b(r0);
    L5:
        e(r0);
        f(r0);
        g(r0);
        d(r0);
        Iterator<ae> r1 = r0.values().iterator();
    L7:
        if (r1.hasNext() == false) goto L9;
        ((ae) ZeusTransformUtils.preCheckCast(r1.next(), ae.class, "com.obric.aiagent.plugin")).a(this.f12577c);
        goto L7
    L9:
        com.fasterxml.jackson.databind.y r2 = o();
        if (r2 == null) goto L12;
        a(r0, r2);
    L12:
        Iterator<ae> r3 = r0.values().iterator();
    L14:
        if (r3.hasNext() == false) goto L17;
        ((ae) ZeusTransformUtils.preCheckCast(r3.next(), ae.class, "com.obric.aiagent.plugin")).L();
        goto L14
    L17:
        if (this.f12575a.a(com.fasterxml.jackson.databind.r.y) == false) goto L19;
        h(r0);
    L19:
        i(r0);
        this.j = r0;
        this.i = true;
    }

    public void a(Map<String, ae> r18) {
        Map<String, ae> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r18, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r3 = this.g;
        if (this.f12577c == false) goto L5;
    L7:
        boolean r4 = false;
    L8:
        boolean r7 = this.f12575a.a(com.fasterxml.jackson.databind.r.f13098c);
        Iterator<h> r8 = this.f12579e.k().iterator();
    L10:
        if (r8.hasNext() == false) goto L83;
        h r11 = (h) ZeusTransformUtils.preCheckCast(r8.next(), h.class, "com.obric.aiagent.plugin");
        if (Boolean.TRUE.equals(r3.c(this.f12575a, r11)) == false) goto L18;
        if (this.q != null) goto L16;
        this.q = new LinkedList();
    L16:
        this.q.add(r11);
    L18:
        if (Boolean.TRUE.equals(r3.v(r11)) == true) goto L20;
        boolean r9 = Boolean.TRUE.equals(r3.w(r11));
        boolean r10 = Boolean.TRUE.equals(r3.C(r11));
        if (r9 == true) goto L73;
        if (r10 == true) goto L73;
        String r12 = r3.g(r11);
        if (r12 != null) goto L30;
        r12 = r11.b();
    L30:
        String r13 = this.f12576b.a(r11, r12);
        if (r13 == null) goto L10;
        com.fasterxml.jackson.databind.x r14 = b(r13);
        com.fasterxml.jackson.databind.x r15 = r3.a(this.f12575a, r11, r14);
        if (r15 == null) goto L42;
        if (r15.equals(r14) == true) goto L42;
        if (this.l != null) goto L40;
        this.l = new HashMap();
    L40:
        this.l.put(r15, r14);
    L42:
        if (this.f12577c == false) goto L44;
        com.fasterxml.jackson.databind.x r16 = r3.u(r11);
    L45:
        if (r16 == null) goto L47;
        boolean r17 = true;
    L48:
        if (r17 == true) goto L50;
    L52:
        com.fasterxml.jackson.databind.x r19 = r16;
        boolean r110 = r17;
    L53:
        if (r19 == null) goto L55;
        boolean r111 = true;
    L56:
        if (r111 == true) goto L58;
        r111 = this.f.a(r11);
    L58:
        boolean r112 = r3.d(r11);
        if (r11.h() == false) goto L65;
        if (r17 == true) goto L65;
        if (r7 == false) goto L63;
        boolean r113 = true;
    L64:
        boolean r114 = false;
    L66:
        if (r4 == false) goto L72;
        if (r19 != null) goto L72;
        if (r113 == true) goto L72;
        if (Modifier.isFinal(r11.e()) == true) goto L10;
    L72:
        a(r1, r13).a(r11, r19, r110, r114, r113);
        goto L10
    L63:
        r113 = r112;
    L65:
        r113 = r112;
        r114 = r111;
        goto L66
    L55:
        r111 = false;
        goto L56
    L50:
        if (r16.e() == false) goto L52;
        r110 = false;
        r19 = b(r13);
        goto L53
    L47:
        r17 = false;
        goto L48
    L44:
        r16 = r3.B(r11);
    L73:
        if (r9 == true) goto L75;
    L78:
        if (r10 == false) goto L10;
        if (this.p != null) goto L82;
        this.p = new LinkedList();
    L82:
        this.p.add(r11);
        goto L10
    L75:
        if (this.n != null) goto L77;
        this.n = new LinkedList();
    L77:
        this.n.add(r11);
        goto L78
    L20:
        if (this.r != null) goto L22;
        this.r = new LinkedList();
    L22:
        this.r.add(r11);
        goto L10
    L83:
        return;
    L5:
        if (this.f12575a.a(com.fasterxml.jackson.databind.r.j) == true) goto L7;
        r4 = true;
        goto L8
    }

    public void b(Map<String, ae> r8) {
        Map<String, ae> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        if (this.h == true) goto L5;
        return;
    L5:
        Iterator<f> r0 = this.f12579e.h().iterator();
    L6:
        int r3 = 0;
        if (r0.hasNext() == false) goto L14;
        f r2 = (f) ZeusTransformUtils.preCheckCast(r0.next(), f.class, "com.obric.aiagent.plugin");
        if (this.k != null) goto L11;
        this.k = new LinkedList();
    L11:
        int r4 = r2.e();
    L12:
        if (r3 >= r4) goto L6;
        a(r9, r2.d(r3));
        r3 = r3 + 1;
        goto L12
    L14:
        Iterator<k> r1 = this.f12579e.i().iterator();
    L16:
        if (r1.hasNext() == false) goto L23;
        k r5 = (k) ZeusTransformUtils.preCheckCast(r1.next(), k.class, "com.obric.aiagent.plugin");
        if (this.k != null) goto L20;
        this.k = new LinkedList();
    L20:
        int r6 = r5.e();
        int r7 = 0;
    L21:
        if (r7 >= r6) goto L16;
        a(r9, r5.d(r7));
        r7 = r7 + 1;
        goto L21
    }

    public void a(Map<String, ae> r10, n r11) {
        Map<String, ae> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        String r0 = this.g.g(r11);
        if (r0 != null) goto L5;
        r0 = "";
    L5:
        com.fasterxml.jackson.databind.x r1 = this.g.B(r11);
        if (r1 != null) goto L8;
    L10:
        boolean r2 = false;
    L11:
        boolean r6 = r2;
        if (r6 == false) goto L14;
    L23:
        com.fasterxml.jackson.databind.x r5 = r1;
        String r3 = c(r0);
        if (r6 == true) goto L26;
    L28:
        ae r13 = a(r12, r3);
    L29:
        r13.a(r11, r5, r6, true, false);
        this.k.add(r13);
        return;
    L26:
        if (r3.isEmpty() == false) goto L28;
        r13 = a(r12, r5);
        goto L29
    L14:
        if (r0.isEmpty() == false) goto L16;
        return;
    L16:
        JsonCreator.Mode r4 = this.g.d(this.f12575a, r11.d());
        if (r4 != null) goto L19;
        return;
    L19:
        if (r4 == JsonCreator.Mode.DISABLED) goto L31;
        r1 = com.fasterxml.jackson.databind.x.a(r0);
        goto L23
    L31:
        return;
    L8:
        if (r1.e() == true) goto L10;
        r2 = true;
        goto L11
    }

    public void c(Map<String, ae> r6) {
        Map<String, ae> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        Iterator<k> r0 = this.f12579e.j().iterator();
    L4:
        if (r0.hasNext() == false) goto L19;
        k r2 = (k) ZeusTransformUtils.preCheckCast(r0.next(), k.class, "com.obric.aiagent.plugin");
        int r3 = r2.e();
        if (r3 == 0) goto L7;
        if (r3 == 1) goto L10;
        if (r3 != 2) goto L4;
        if (Boolean.TRUE.equals(this.g.C(r2)) == false) goto L4;
        if (this.o != null) goto L18;
        this.o = new LinkedList();
    L18:
        this.o.add(r2);
        goto L4
    L10:
        b(r7, r2, this.g);
        goto L4
    L7:
        a(r7, r2, this.g);
        goto L4
    }

    public void a(Map<String, ae> r12, k r13, com.fasterxml.jackson.databind.b r14) {
        Map<String, ae> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        Class<?> r0 = r13.l();
        if (r0 != Void.TYPE) goto L5;
        return;
    L5:
        if (r0 != Void.class) goto L10;
        if (this.f12575a.a(com.fasterxml.jackson.databind.r.m) == true) goto L10;
        return;
    L10:
        if (Boolean.TRUE.equals(r14.w(r13)) == false) goto L17;
        if (this.m != null) goto L14;
        this.m = new LinkedList();
    L14:
        this.m.add(r13);
        return;
    L17:
        if (Boolean.TRUE.equals(r14.c(this.f12575a, r13)) == false) goto L24;
        if (this.q != null) goto L21;
        this.q = new LinkedList();
    L21:
        this.q.add(r13);
        return;
    L24:
        if (Boolean.TRUE.equals(r14.v(r13)) == true) goto L26;
        com.fasterxml.jackson.databind.x r1 = r14.u(r13);
        boolean r2 = false;
        if (r1 == null) goto L33;
        boolean r3 = true;
    L34:
        if (r3 == true) goto L45;
        String r4 = r14.g(r13);
        if (r4 != null) goto L38;
        r4 = this.f12576b.b(r13, r13.b());
    L38:
        if (r4 != null) goto L43;
        r4 = this.f12576b.a(r13, r13.b());
        if (r4 != null) goto L42;
        return;
    L42:
        boolean r5 = this.f.b(r13);
    L44:
        com.fasterxml.jackson.databind.x r7 = r1;
        boolean r9 = r5;
        boolean r8 = r3;
    L57:
        String r6 = c(r4);
        a(r15, r6).a(r13, r7, r8, r9, r14.d(r13));
        return;
    L43:
        r5 = this.f.a(r13);
        goto L44
    L45:
        String r10 = r14.g(r13);
        if (r10 != null) goto L50;
        r10 = this.f12576b.b(r13, r13.b());
        if (r10 != null) goto L50;
        r10 = this.f12576b.a(r13, r13.b());
    L50:
        if (r10 != null) goto L53;
        r10 = r13.b();
    L53:
        if (r1.e() == false) goto L55;
        r1 = b(r10);
    L56:
        r7 = r1;
        r9 = true;
        r8 = r2;
        r4 = r10;
        goto L57
    L55:
        r2 = r3;
        goto L56
    L33:
        r3 = false;
        goto L34
    L26:
        if (this.r != null) goto L28;
        this.r = new LinkedList();
    L28:
        this.r.add(r13);
    }

    public void b(Map<String, ae> r12, k r13, com.fasterxml.jackson.databind.b r14) {
        Map<String, ae> r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.x r0 = r14.B(r13);
        boolean r2 = false;
        if (r0 == null) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L13;
        String r1 = r14.g(r13);
        if (r1 != null) goto L10;
        r1 = this.f12576b.c(r13, r13.b());
    L10:
        if (r1 != null) goto L12;
        return;
    L12:
        com.fasterxml.jackson.databind.x r7 = r0;
        boolean r9 = this.f.c(r13);
        boolean r8 = r3;
    L23:
        String r4 = c(r1);
        a(r15, r4).b(r13, r7, r8, r9, r14.d(r13));
        return;
    L13:
        String r5 = r14.g(r13);
        if (r5 != null) goto L16;
        r5 = this.f12576b.c(r13, r13.b());
    L16:
        if (r5 != null) goto L19;
        r5 = r13.b();
    L19:
        if (r0.e() == false) goto L21;
        r0 = b(r5);
    L22:
        r7 = r0;
        r9 = true;
        r8 = r2;
        r1 = r5;
        goto L23
    L21:
        r2 = r3;
        goto L22
    L5:
        r3 = false;
        goto L6
    }

    public void d(Map<String, ae> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        Iterator<h> r7 = this.f12579e.k().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        j r0 = (h) ZeusTransformUtils.preCheckCast(r7.next(), h.class, "com.obric.aiagent.plugin");
        a(this.g.e(r0), r0);
        goto L4
    L6:
        Iterator<k> r8 = this.f12579e.j().iterator();
    L8:
        if (r8.hasNext() == false) goto L13;
        k r1 = (k) ZeusTransformUtils.preCheckCast(r8.next(), k.class, "com.obric.aiagent.plugin");
        if (r1.e() != 1) goto L8;
        a(this.g.e(r1), r1);
        goto L8
    }

    public void a(JacksonInject.Value r3, j r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Object r5 = r3.getId();
        if (this.t != null) goto L7;
        this.t = new LinkedHashMap();
    L7:
        j r2 = (j) ZeusTransformUtils.preCheckCast(this.t.put(r5, r4), j.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L10;
        return;
    L10:
        if (r2.getClass() == r4.getClass()) goto L13;
        return;
    L13:
        throw new IllegalArgumentException("Duplicate injectable value with id '" + r5 + "' (of type " + r5.getClass().getName() + ")");
    }

    private com.fasterxml.jackson.databind.x b(String r1) {
        return com.fasterxml.jackson.databind.x.a(r1, null);
    }

    private String c(String r3) {
        Map<com.fasterxml.jackson.databind.x, com.fasterxml.jackson.databind.x> r0 = this.l;
        if (r0 == null) goto L8;
        com.fasterxml.jackson.databind.x r2 = (com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(r0.get(b(r3)), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L8;
        return r2.b();
    L8:
        return r3;
    }

    public void e(Map<String, ae> r4) {
        Iterator r5 = ((Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin")).values().iterator();
    L4:
        if (r5.hasNext() == false) goto L16;
        ae r0 = (ae) ZeusTransformUtils.preCheckCast(r5.next(), ae.class, "com.obric.aiagent.plugin");
        if (r0.M() == false) goto L7;
        if (r0.N() == false) goto L4;
        if (r0.d() == false) goto L12;
        r0.J();
        if (r0.i() == true) goto L4;
        a(r0.a());
        goto L4
    L12:
        r5.remove();
        a(r0.a());
        goto L4
    L7:
        r5.remove();
        goto L4
    }

    public void f(Map<String, ae> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        boolean r0 = this.f12575a.a(com.fasterxml.jackson.databind.r.k);
        Iterator r7 = r6.values().iterator();
    L4:
        if (r7.hasNext() == false) goto L10;
        ae r2 = (ae) ZeusTransformUtils.preCheckCast(r7.next(), ae.class, "com.obric.aiagent.plugin");
        if (this.f12577c == false) goto L8;
        ad r3 = null;
    L9:
        r2.a(r0, r3);
        goto L4
    L8:
        r3 = this;
        goto L9
    }

    public void a(String r2) {
        if (this.f12577c == true) goto L10;
        if (r2 != null) goto L6;
        return;
    L6:
        if (this.s != null) goto L8;
        this.s = new HashSet();
    L8:
        this.s.add(r2);
        return;
    }

    public void g(Map<String, ae> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        Iterator r0 = r9.entrySet().iterator();
        LinkedList r2 = null;
    L4:
        if (r0.hasNext() == false) goto L15;
        ae r3 = (ae) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), ae.class, "com.obric.aiagent.plugin");
        Set<com.fasterxml.jackson.databind.x> r4 = r3.O();
        if (r4.isEmpty() == true) goto L4;
        r0.remove();
        if (r2 != null) goto L12;
        r2 = new LinkedList();
    L12:
        if (r4.size() == 1) goto L13;
        r2.addAll(r3.a(r4));
        goto L4
    L13:
        r2.add(r3.b((com.fasterxml.jackson.databind.x) ZeusTransformUtils.preCheckCast(r4.iterator().next(), com.fasterxml.jackson.databind.x.class, "com.obric.aiagent.plugin")));
        goto L4
    L15:
        if (r2 == null) goto L28;
        Iterator r1 = r2.iterator();
    L18:
        if (r1.hasNext() == false) goto L44;
        ae r5 = (ae) ZeusTransformUtils.preCheckCast(r1.next(), ae.class, "com.obric.aiagent.plugin");
        String r6 = r5.a();
        ae r7 = (ae) ZeusTransformUtils.preCheckCast(r9.get(r6), ae.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L22;
        r9.put(r6, r5);
    L24:
        if (a(r5, this.k) == false) goto L18;
        HashSet<String> r10 = this.s;
        if (r10 == null) goto L18;
        r10.remove(r6);
        goto L18
    L22:
        r7.b(r5);
        goto L24
    L44:
        return;
    }

    public void a(Map<String, ae> r10, com.fasterxml.jackson.databind.y r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        ae[] r0 = (ae[]) ZeusTransformUtils.preCheckCast(r12.values().toArray(new ae[r12.size()]), ae[].class, "com.obric.aiagent.plugin");
        r12.clear();
        int r2 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L38;
        ae r4 = r0[r3];
        com.fasterxml.jackson.databind.x r5 = r4.b();
        String r6 = null;
        if (r4.e() == false) goto L9;
        if (this.f12575a.a(com.fasterxml.jackson.databind.r.A) == true) goto L9;
    L28:
        if (r6 != null) goto L30;
    L32:
        r6 = r5.b();
    L33:
        ae r7 = (ae) ZeusTransformUtils.preCheckCast(r12.get(r6), ae.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L36;
        r12.put(r6, r4);
    L37:
        a(r4, this.k);
        r3 = r3 + 1;
        goto L3
    L36:
        r7.b(r4);
        goto L37
    L30:
        if (r5.c(r6) == true) goto L32;
        r4 = r4.a(r6);
    L9:
        if (this.f12577c == false) goto L17;
        if (r4.D() == false) goto L14;
        r6 = r11.a(this.f12575a, r4.n(), r5.b());
        goto L28
    L14:
        if (r4.l() == false) goto L28;
        r6 = r11.a(this.f12575a, r4.p(), r5.b());
        goto L28
    L17:
        if (r4.k() == false) goto L20;
        r6 = r11.b(this.f12575a, r4.F(), r5.b());
        goto L28
    L20:
        if (r4.m() == false) goto L23;
        r6 = r11.a(this.f12575a, r4.q(), r5.b());
        goto L28
    L23:
        if (r4.l() == false) goto L26;
        r6 = r11.a(this.f12575a, r4.G(), r5.b());
        goto L28
    L26:
        if (r4.D() == false) goto L28;
        r6 = r11.a(this.f12575a, r4.E(), r5.b());
        goto L28
    }

    public void h(Map<String, ae> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        Iterator r0 = r8.entrySet().iterator();
        LinkedList r2 = null;
    L4:
        if (r0.hasNext() == false) goto L18;
        ae r3 = (ae) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), ae.class, "com.obric.aiagent.plugin");
        j r4 = r3.v();
        if (r4 == null) goto L4;
        com.fasterxml.jackson.databind.x r5 = this.g.g(r4);
        if (r5 == null) goto L4;
        if (r5.c() == false) goto L4;
        if (r5.equals(r3.b()) == true) goto L4;
        if (r2 != null) goto L17;
        r2 = new LinkedList();
    L17:
        r2.add(r3.b(r5));
        r0.remove();
        goto L4
    L18:
        if (r2 == null) goto L26;
        Iterator r6 = r2.iterator();
    L21:
        if (r6.hasNext() == false) goto L44;
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(r6.next(), ae.class, "com.obric.aiagent.plugin");
        String r9 = r1.a();
        ae r10 = (ae) ZeusTransformUtils.preCheckCast(r8.get(r9), ae.class, "com.obric.aiagent.plugin");
        if (r10 == null) goto L24;
        r10.b(r1);
        goto L21
    L24:
        r8.put(r9, r1);
        goto L21
    L44:
        return;
    }

    public void i(Map<String, ae> r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r0 = this.g;
        Boolean r2 = r0.t(this.f12579e);
        if (r2 != null) goto L5;
        boolean r3 = this.f12575a.h();
    L6:
        boolean r4 = a(r15.values());
        String[] r1 = r0.e(this.f12579e);
        if (r3 == true) goto L13;
        if (r4 == true) goto L13;
        if (this.k != null) goto L13;
        if (r1 != null) goto L13;
        return;
    L13:
        int r5 = r15.size();
        if (r3 == false) goto L16;
        Map r6 = new TreeMap();
    L17:
        Iterator r7 = r15.values().iterator();
    L19:
        if (r7.hasNext() == false) goto L21;
        ae r8 = (ae) ZeusTransformUtils.preCheckCast(r7.next(), ae.class, "com.obric.aiagent.plugin");
        r6.put(r8.a(), r8);
        goto L19
    L21:
        LinkedHashMap r9 = new LinkedHashMap(r5 + r5);
        if (r1 == null) goto L36;
        int r10 = r1.length;
        int r11 = 0;
    L24:
        if (r11 >= r10) goto L36;
        String r12 = r1[r11];
        ae r13 = (ae) ZeusTransformUtils.preCheckCast(r6.remove(r12), ae.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L33;
        Iterator r16 = r15.values().iterator();
    L29:
        if (r16.hasNext() == false) goto L33;
        ae r17 = (ae) ZeusTransformUtils.preCheckCast(r16.next(), ae.class, "com.obric.aiagent.plugin");
        if (r12.equals(r17.C()) == false) goto L29;
        r12 = r17.a();
        r13 = r17;
    L33:
        if (r13 == null) goto L35;
        r9.put(r12, r13);
    L35:
        r11 = r11 + 1;
    L36:
        if (r4 == false) goto L48;
        TreeMap r18 = new TreeMap();
        Iterator r19 = r6.entrySet().iterator();
    L39:
        if (r19.hasNext() == false) goto L43;
        ae r20 = (ae) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r19.next(), Map.Entry.class, "com.obric.aiagent.plugin")).getValue(), ae.class, "com.obric.aiagent.plugin");
        Integer r21 = r20.h().b();
        if (r21 == null) goto L39;
        r18.put(r21, r20);
        r19.remove();
        goto L39
    L43:
        Iterator r22 = r18.values().iterator();
    L45:
        if (r22.hasNext() == false) goto L48;
        ae r23 = (ae) ZeusTransformUtils.preCheckCast(r22.next(), ae.class, "com.obric.aiagent.plugin");
        r9.put(r23.a(), r23);
    L48:
        if (this.k == null) goto L65;
        if (r3 == true) goto L51;
    L52:
        if (r3 == false) goto L58;
        TreeMap r24 = new TreeMap();
        Iterator<ae> r110 = this.k.iterator();
    L55:
        if (r110.hasNext() == false) goto L57;
        ae r25 = (ae) ZeusTransformUtils.preCheckCast(r110.next(), ae.class, "com.obric.aiagent.plugin");
        r24.put(r25.a(), r25);
        goto L55
    L57:
        Collection r111 = r24.values();
    L59:
        Iterator r112 = r111.iterator();
    L61:
        if (r112.hasNext() == false) goto L65;
        ae r26 = (ae) ZeusTransformUtils.preCheckCast(r112.next(), ae.class, "com.obric.aiagent.plugin");
        String r27 = r26.a();
        if (r6.containsKey(r27) == false) goto L61;
        r9.put(r27, r26);
        goto L61
    L58:
        r111 = this.k;
        goto L59
    L51:
        if (this.f12575a.a(com.fasterxml.jackson.databind.r.u) == true) goto L52;
    L65:
        r9.putAll(r6);
        r15.clear();
        r15.putAll(r9);
        return;
    L16:
        r6 = new LinkedHashMap(r5 + r5);
        goto L17
    L5:
        r3 = r2.booleanValue();
        goto L6
    }

    private boolean a(Collection<ae> r3) {
        Iterator r2 = ((Collection) ZeusTransformUtils.wrapperContextForParams(r3, Collection.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        if (((ae) ZeusTransformUtils.preCheckCast(r2.next(), ae.class, "com.obric.aiagent.plugin")).h().c() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public void a(String r3, Object... r4) {
        if (r4.length <= 0) goto L6;
        r3 = String.format(r3, r4);
    L6:
        throw new IllegalArgumentException("Problem with definition of " + this.f12579e + ": " + r3);
    }

    public ae a(Map<String, ae> r5, com.fasterxml.jackson.databind.x r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        String r0 = r6.b();
        ae r1 = (ae) ZeusTransformUtils.preCheckCast(r7.get(r0), ae.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L6;
        ae r2 = new ae(this.f12575a, this.g, this.f12577c, r6);
        r7.put(r0, r2);
        return r2;
    L6:
        return r1;
    }

    public ae a(Map<String, ae> r5, String r6) {
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        ae r0 = (ae) ZeusTransformUtils.preCheckCast(r7.get(r6), ae.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        ae r1 = new ae(this.f12575a, this.g, this.f12577c, com.fasterxml.jackson.databind.x.a(r6));
        r7.put(r6, r1);
        return r1;
    L6:
        return r0;
    }

    private com.fasterxml.jackson.databind.y o() {
        Object r0 = this.g.c(this.f12579e);
        if (r0 != null) goto L7;
        return this.f12575a.k();
    L7:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.y.class) == false) goto L11;
        return (com.fasterxml.jackson.databind.y) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.y.class, "com.obric.aiagent.plugin");
    L11:
        if (ZeusTransformUtils.instanceOf(r0, Class.class) == false) goto L28;
        Class<?> r1 = (Class) ZeusTransformUtils.preCheckCast(r0, Class.class, "com.obric.aiagent.plugin");
        if (r1 != com.fasterxml.jackson.databind.y.class) goto L17;
        return null;
    L17:
        if (com.fasterxml.jackson.databind.y.class.isAssignableFrom(r1) == false) goto L26;
        com.fasterxml.jackson.databind.a.l r2 = this.f12575a.m();
        if (r2 == null) goto L24;
        com.fasterxml.jackson.databind.y r3 = r2.f(this.f12575a, this.f12579e, r1);
        if (r3 == null) goto L24;
        return r3;
    L24:
        return (com.fasterxml.jackson.databind.y) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r1, this.f12575a.g()), com.fasterxml.jackson.databind.y.class, "com.obric.aiagent.plugin");
    L26:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r1.getName() + "; expected Class<PropertyNamingStrategy>");
    L28:
        throw new IllegalStateException("AnnotationIntrospector returned PropertyNamingStrategy definition of type " + r0.getClass().getName() + "; expected type PropertyNamingStrategy or Class<PropertyNamingStrategy> instead");
    }

    public boolean a(ae r7, List<ae> r8) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r6 == null) goto L11;
        String r1 = r7.C();
        int r2 = r6.size();
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L11;
        if (((ae) ZeusTransformUtils.preCheckCast(r6.get(r3), ae.class, "com.obric.aiagent.plugin")).C().equals(r1) == true) goto L8;
        r3 = r3 + 1;
        goto L5
    L8:
        r6.set(r3, r7);
        return true;
    L11:
        return false;
    }
}
