package com.fasterxml.jackson.databind.b.b;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MapDeserializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class s extends i<Map<Object, Object>> implements com.fasterxml.jackson.databind.b.i, com.fasterxml.jackson.databind.b.t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.q f12454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f12455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.l<Object> f12456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.h.e f12457d;
    protected final com.fasterxml.jackson.databind.b.y i;
    protected com.fasterxml.jackson.databind.l<Object> j;
    protected com.fasterxml.jackson.databind.b.a.v k;
    protected final boolean l;
    protected Set<String> m;
    protected Set<String> n;
    protected com.fasterxml.jackson.databind.l.m.a o;

    /* JADX INFO: compiled from: MapDeserializer.java */
    static class a extends com.fasterxml.jackson.databind.b.a.z.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Object, Object> f12458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f12459b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f12460c;

        a(b r1, com.fasterxml.jackson.databind.b.w r2, Class<?> r3, Object r4) {
            super(r2, r3);
            this.f12458a = new LinkedHashMap();
            this.f12460c = r1;
            this.f12459b = r4;
        }

        @Override // com.fasterxml.jackson.databind.b.a.z.a
        public void a(Object r1, Object r2) {
            this.f12460c.b(r1, r2);
        }
    }

    /* JADX INFO: compiled from: MapDeserializer.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class<?> f12461a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<Object, Object> f12462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<a> f12463c;

        public b(Class<?> r3, Map<Object, Object> r4) {
            Map<Object, Object> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.aiagent.plugin");
            this.f12463c = new ArrayList();
            this.f12461a = r3;
            this.f12462b = r5;
        }

        public void a(Object r3, Object r4) {
            if (this.f12463c.isEmpty() == false) goto L5;
            this.f12462b.put(r3, r4);
            return;
        L5:
            List<a> r2 = this.f12463c;
            ((a) ZeusTransformUtils.preCheckCast(r2.get(r2.size() - 1), a.class, "com.obric.aiagent.plugin")).f12458a.put(r3, r4);
        }

        public com.fasterxml.jackson.databind.b.a.z.a a(com.fasterxml.jackson.databind.b.w r3, Object r4) {
            a r0 = new a(this, r3, this.f12461a, r4);
            this.f12463c.add(r0);
            return r0;
        }

        public void b(Object r5, Object r6) {
            Iterator<a> r0 = this.f12463c.iterator();
            Map<Object, Object> r4 = this.f12462b;
        L4:
            if (r0.hasNext() == false) goto L11;
            a r1 = (a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.aiagent.plugin");
            if (r1.b(r5) == true) goto L7;
            r4 = r1.f12458a;
            goto L4
        L7:
            r0.remove();
            r4.put(r1.f12459b, r6);
            r4.putAll(r1.f12458a);
            return;
        L11:
            throw new IllegalArgumentException("Trying to resolve a forward reference with id [" + r5 + "] that wasn't previously seen as unresolved.");
        }
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2) {
        return b(r1, r2);
    }

    @Override // com.fasterxml.jackson.databind.l
    public /* synthetic */ Object a(com.fasterxml.jackson.a.k r3, com.fasterxml.jackson.databind.h r4, Object r5) {
        return a(r3, r4, (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.aiagent.plugin"));
    }

    public s(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.b.y r3, com.fasterxml.jackson.databind.q r4, com.fasterxml.jackson.databind.l<Object> r5, com.fasterxml.jackson.databind.h.e r6) {
        super(r2, null, null);
        this.f12454a = r4;
        this.f12456c = r5;
        this.f12457d = r6;
        this.i = r3;
        this.l = r3.k();
        this.j = null;
        this.k = null;
        this.f12455b = a(r2, r4);
        this.o = null;
    }

    public s(s r3, com.fasterxml.jackson.databind.q r4, com.fasterxml.jackson.databind.l<Object> r5, com.fasterxml.jackson.databind.h.e r6, com.fasterxml.jackson.databind.b.s r7, Set<String> r8, Set<String> r9) {
        com.fasterxml.jackson.databind.b.s r10 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r7, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.aiagent.plugin");
        super(r3, r10, r3.h);
        this.f12454a = r4;
        this.f12456c = r5;
        this.f12457d = r6;
        this.i = r3.i;
        this.k = r3.k;
        this.j = r3.j;
        this.l = r3.l;
        this.m = r11;
        this.n = r12;
        this.o = com.fasterxml.jackson.databind.l.m.a(r11, r12);
        this.f12455b = a(this.f12422e, r4);
    }

    public s a(com.fasterxml.jackson.databind.q r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.l<?> r12, com.fasterxml.jackson.databind.b.s r13, Set<String> r14, Set<String> r15) {
        com.fasterxml.jackson.databind.b.s r5 = (com.fasterxml.jackson.databind.b.s) ZeusTransformUtils.wrapperContextForParams(r13, com.fasterxml.jackson.databind.b.s.class, "com.obric.aiagent.plugin");
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r15, Set.class, "com.obric.aiagent.plugin");
        if (this.f12454a != r10) goto L16;
        if (this.f12456c != r12) goto L16;
        if (this.f12457d != r11) goto L16;
        if (this.f != r5) goto L16;
        if (this.m != r6) goto L16;
        if (this.n != r7) goto L16;
        return this;
    L16:
        return new s(this, r10, r12, r11, r5, r6, r7);
    }

    public final boolean a(com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.q r4) {
        if (r4 != null) goto L5;
        return true;
    L5:
        com.fasterxml.jackson.databind.k r5 = r3.w();
        if (r5 != null) goto L8;
        return true;
    L8:
        Class<?> r6 = r5.e();
        if (r6 == String.class) goto L13;
        if (r6 == Object.class) goto L13;
    L15:
        return false;
    L13:
        if (a(r4) == false) goto L15;
        return true;
    }

    public void a(Set<String> r3) {
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
    L6:
        r4 = null;
    L7:
        this.m = r4;
        this.o = com.fasterxml.jackson.databind.l.m.a(r4, this.n);
        return;
    L5:
        if (r4.size() != 0) goto L7;
        goto L6
    }

    public void b(Set<String> r3) {
        Set<String> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.aiagent.plugin");
        this.n = r4;
        this.o = com.fasterxml.jackson.databind.l.m.a(this.m, r4);
    }

    @Override // com.fasterxml.jackson.databind.b.t
    public void d(com.fasterxml.jackson.databind.h r8) {
        if (this.i.l() == false) goto L9;
        com.fasterxml.jackson.databind.k r0 = this.i.b(r8.c());
        if (r0 != null) goto L7;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingDelegate()', but null for 'getDelegateType()'", new Object[]{this.f12422e, this.i.getClass().getName()}));
    L7:
        this.j = a(r8, r0, null);
    L15:
        if (this.i.n() == false) goto L17;
        this.k = com.fasterxml.jackson.databind.b.a.v.a(r8, this.i, this.i.a(r8.c()), r8.a(com.fasterxml.jackson.databind.r.v));
    L17:
        this.f12455b = a(this.f12422e, this.f12454a);
        return;
    L9:
        if (this.i.m() == false) goto L15;
        com.fasterxml.jackson.databind.k r1 = this.i.c(r8.c());
        if (r1 != null) goto L13;
        r8.b(this.f12422e, String.format("Invalid delegate-creator definition for %s: value instantiator (%s) returned true for 'canCreateUsingArrayDelegate()', but null for 'getArrayDelegateType()'", new Object[]{this.f12422e, this.i.getClass().getName()}));
    L13:
        this.j = a(r8, r1, null);
        goto L15
    }

    @Override // com.fasterxml.jackson.databind.b.i
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r13, com.fasterxml.jackson.databind.d r14) {
        com.fasterxml.jackson.databind.d r15 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r14, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r0 = this.f12454a;
        if (r0 != null) goto L6;
        r0 = r13.b(this.f12422e.w(), r15);
    L8:
        com.fasterxml.jackson.databind.q r3 = r0;
        com.fasterxml.jackson.databind.l<?> r1 = this.f12456c;
        if (r15 == null) goto L11;
        r1 = a(r13, r15, r1);
    L11:
        com.fasterxml.jackson.databind.k r2 = this.f12422e.x();
        if (r1 != null) goto L14;
        com.fasterxml.jackson.databind.l<?> r4 = r13.a(r2, r15);
    L15:
        com.fasterxml.jackson.databind.l<?> r5 = r4;
        com.fasterxml.jackson.databind.h.e r6 = this.f12457d;
        if (r6 == null) goto L18;
        r6 = r6.a(r15);
    L18:
        com.fasterxml.jackson.databind.h.e r7 = r6;
        Set<String> r8 = this.m;
        Set<String> r9 = this.n;
        com.fasterxml.jackson.databind.b r10 = r13.f();
        if (b(r10, r15) == false) goto L47;
        com.fasterxml.jackson.databind.e.j r11 = r15.d();
        if (r11 == null) goto L47;
        com.fasterxml.jackson.databind.g r12 = r13.c();
        JsonIgnoreProperties.Value r16 = r10.a(r12, r11);
        if (r16 == null) goto L33;
        Set<String> r17 = r16.findIgnoredForDeserialization();
        if (r17.isEmpty() == true) goto L33;
        if (r8 != null) goto L28;
        r8 = new HashSet();
    L29:
        Iterator<String> r18 = r17.iterator();
    L31:
        if (r18.hasNext() == false) goto L33;
        r8.add((String) ZeusTransformUtils.preCheckCast(r18.next(), String.class, "com.obric.aiagent.plugin"));
        goto L31
    L28:
        r8 = new HashSet(r8);
    L33:
        JsonIncludeProperties.Value r19 = r10.b(r12, r11);
        if (r19 == null) goto L47;
        Set<String> r20 = r19.getIncluded();
        if (r20 == null) goto L47;
        HashSet r21 = new HashSet();
        if (r9 != null) goto L40;
        r21 = new HashSet(r20);
    L46:
        Set<String> r22 = r21;
        Set<String> r23 = r8;
    L49:
        return a(r3, r7, r5, b(r13, r15, r5), r23, r22);
    L40:
        Iterator<String> r24 = r20.iterator();
    L42:
        if (r24.hasNext() == false) goto L46;
        String r25 = (String) ZeusTransformUtils.preCheckCast(r24.next(), String.class, "com.obric.aiagent.plugin");
        if (r9.contains(r25) == false) goto L42;
        r21.add(r25);
    L47:
        r23 = r8;
        r22 = r9;
        goto L49
    L14:
        r4 = r13.b(r1, r15, r2);
        goto L15
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.databind.b.j.class) == false) goto L8;
        r0 = ((com.fasterxml.jackson.databind.b.j) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.databind.b.j.class, "com.obric.aiagent.plugin")).a(r13, r15);
        goto L8
    }

    @Override // com.fasterxml.jackson.databind.b.b.i
    public com.fasterxml.jackson.databind.l<Object> h() {
        return this.f12456c;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.b.y k() {
        return this.i;
    }

    @Override // com.fasterxml.jackson.databind.l
    public boolean c() {
        if (this.f12456c == null) goto L5;
    L13:
        return false;
    L5:
        if (this.f12454a != null) goto L13;
        if (this.f12457d != null) goto L13;
        if (this.m != null) goto L13;
        if (this.n != null) goto L13;
        return true;
    }

    @Override // com.fasterxml.jackson.databind.l
    public com.fasterxml.jackson.databind.k.f b() {
        return com.fasterxml.jackson.databind.k.f.f12969c;
    }

    public Map<Object, Object> b(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10) {
        if (this.k != null) goto L5;
        com.fasterxml.jackson.databind.l<Object> r0 = this.j;
        if (r0 == null) goto L11;
        return (Map) ZeusTransformUtils.preCheckCast(this.i.a(r10, r0.a(r9, r10)), Map.class, "com.obric.aiagent.plugin");
    L11:
        if (this.l == false) goto L13;
        int r1 = r9.m();
        if (r1 != 1) goto L17;
    L30:
        Map<Object, Object> r2 = (Map) ZeusTransformUtils.preCheckCast(this.i.a(r10), Map.class, "com.obric.aiagent.plugin");
        if (this.f12455b == false) goto L34;
        c(r9, r10, r2);
        return r2;
    L34:
        b(r9, r10, r2);
        return r2;
    L17:
        if (r1 == 2) goto L30;
        if (r1 == 3) goto L29;
        if (r1 == 5) goto L30;
        if (r1 == 6) goto L27;
        return (Map) ZeusTransformUtils.preCheckCast(r10.a(f(r10), r9), Map.class, "com.obric.aiagent.plugin");
    L27:
        return (Map) ZeusTransformUtils.preCheckCast(r(r9, r10), Map.class, "com.obric.aiagent.plugin");
    L29:
        return (Map) ZeusTransformUtils.preCheckCast(e(r9, r10), Map.class, "com.obric.aiagent.plugin");
    L13:
        return (Map) ZeusTransformUtils.preCheckCast(r10.a(i(), k(), r9, "no default constructor found", new Object[0]), Map.class, "com.obric.aiagent.plugin");
    L5:
        return d(r9, r10);
    }

    public Map<Object, Object> a(com.fasterxml.jackson.a.k r4, com.fasterxml.jackson.databind.h r5, Map<Object, Object> r6) {
        Map<Object, Object> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.aiagent.plugin");
        r4.a(r7);
        com.fasterxml.jackson.a.n r0 = r4.l();
        if (r0 == com.fasterxml.jackson.a.n.f12152b) goto L9;
        if (r0 == com.fasterxml.jackson.a.n.f) goto L9;
        return (Map) ZeusTransformUtils.preCheckCast(r5.a(i(), r4), Map.class, "com.obric.aiagent.plugin");
    L9:
        if (this.f12455b == false) goto L12;
        e(r4, r5, r7);
        return r7;
    L12:
        d(r4, r5, r7);
        return r7;
    }

    @Override // com.fasterxml.jackson.databind.b.b.ab, com.fasterxml.jackson.databind.l
    public Object a(com.fasterxml.jackson.a.k r1, com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.h.e r3) {
        return r3.a(r1, r2);
    }

    public final Class<?> i() {
        return this.f12422e.e();
    }

    @Override // com.fasterxml.jackson.databind.b.b.i, com.fasterxml.jackson.databind.b.b.ab
    public com.fasterxml.jackson.databind.k j() {
        return this.f12422e;
    }

    public final void b(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11, Map<Object, Object> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r0 = this.f12454a;
        com.fasterxml.jackson.databind.l<Object> r1 = this.f12456c;
        com.fasterxml.jackson.databind.h.e r2 = this.f12457d;
        if (r1.f() == null) goto L5;
        boolean r3 = true;
    L7:
        if (r3 == false) goto L9;
        b r6 = new b(this.f12422e.x().e(), r13);
    L11:
        if (r10.r() == false) goto L13;
        String r4 = r10.i();
    L20:
        if (r4 == null) goto L44;
        Object r5 = r0.a(r4, r11);
        com.fasterxml.jackson.a.n r7 = r10.g();
        com.fasterxml.jackson.databind.l.m.a r8 = this.o;
        if (r8 != null) goto L24;
    L45:
        if (r7 == com.fasterxml.jackson.a.n.m) goto L29;
        if (r2 != null) goto L34;
        Object r9 = r1.a(r10, r11);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
    L35:
        if (r3 == false) goto L37;
        r6.a(r5, r9);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
    L43:
        r4 = r10.i();
        goto L20
    L37:
        r13.put(r5, r9);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L43
    L34:
        r9 = r1.a(r10, r11, r2);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L35
    L29:
        if (this.g == true) goto L43;
        r9 = this.f.a(r11);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L35
    L41:
        e = move-exception;
        a(r11, r6, r5, e);
    L39:
        e = move-exception;
        a(r11, e, r13, r4);
        goto L43
    L24:
        if (r8.a(r4) == false) goto L45;
        r10.k();
        goto L43
    L44:
        return;
    L13:
        com.fasterxml.jackson.a.n r14 = r10.l();
        if (r14 != com.fasterxml.jackson.a.n.f) goto L16;
    L19:
        r4 = r10.w();
        goto L20
    L16:
        if (r14 != com.fasterxml.jackson.a.n.f12153c) goto L18;
        return;
    L18:
        r11.a(this, com.fasterxml.jackson.a.n.f, null, new Object[0]);
        goto L19
    L9:
        r6 = null;
        goto L11
    L5:
        r3 = false;
        goto L7
    }

    public final void c(com.fasterxml.jackson.a.k r9, com.fasterxml.jackson.databind.h r10, Map<Object, Object> r11) {
        Map r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r11, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12456c;
        com.fasterxml.jackson.databind.h.e r1 = this.f12457d;
        if (r0.f() == null) goto L5;
        boolean r2 = true;
    L7:
        if (r2 == false) goto L9;
        b r5 = new b(this.f12422e.x().e(), r12);
    L11:
        if (r9.r() == false) goto L13;
        String r3 = r9.i();
    L20:
        if (r3 == null) goto L44;
        com.fasterxml.jackson.a.n r4 = r9.g();
        com.fasterxml.jackson.databind.l.m.a r6 = this.o;
        if (r6 != null) goto L24;
    L45:
        if (r4 == com.fasterxml.jackson.a.n.m) goto L29;
        if (r1 != null) goto L34;
        Object r7 = r0.a(r9, r10);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
    L35:
        if (r2 == false) goto L37;
        r5.a(r3, r7);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
    L43:
        r3 = r9.i();
        goto L20
    L37:
        r12.put(r3, r7);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L43
    L34:
        r7 = r0.a(r9, r10, r1);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L35
    L29:
        if (this.g == true) goto L43;
        r7 = this.f.a(r10);     // Catch: Exception -> L39 com.fasterxml.jackson.databind.b.w -> L41
        goto L35
    L41:
        e = move-exception;
        a(r10, r5, r3, e);
    L39:
        e = move-exception;
        a(r10, e, r12, r3);
        goto L43
    L24:
        if (r6.a(r3) == false) goto L45;
        r9.k();
        goto L43
    L44:
        return;
    L13:
        com.fasterxml.jackson.a.n r8 = r9.l();
        if (r8 != com.fasterxml.jackson.a.n.f12153c) goto L17;
        return;
    L17:
        if (r8 == com.fasterxml.jackson.a.n.f) goto L19;
        r10.a(this, com.fasterxml.jackson.a.n.f, null, new Object[0]);
    L19:
        r3 = r9.w();
        goto L20
    L9:
        r5 = null;
        goto L11
    L5:
        r2 = false;
        goto L7
    }

    public Map<Object, Object> d(com.fasterxml.jackson.a.k r10, com.fasterxml.jackson.databind.h r11) {
        com.fasterxml.jackson.databind.b.a.v r0 = this.k;
        com.fasterxml.jackson.databind.b.a.y r2 = r0.a(r10, r11, null);
        com.fasterxml.jackson.databind.l<Object> r3 = this.f12456c;
        com.fasterxml.jackson.databind.h.e r4 = this.f12457d;
        if (r10.r() == false) goto L6;
        String r5 = r10.i();
    L10:
        if (r5 == null) goto L51;
        com.fasterxml.jackson.a.n r7 = r10.g();
        com.fasterxml.jackson.databind.l.m.a r8 = this.o;
        if (r8 != null) goto L14;
    L16:
        com.fasterxml.jackson.databind.b.v r9 = r0.a(r5);
        if (r9 != null) goto L19;
        Object r6 = this.f12454a.a(r5, r11);
        if (r7 == com.fasterxml.jackson.a.n.m) goto L31;
        if (r4 != null) goto L36;
        Object r12 = r3.a(r10, r11);     // Catch: Exception -> L39
    L37:
        r2.a(r6, r12);
    L38:
        r5 = r10.i();
        goto L10
    L36:
        r12 = r3.a(r10, r11, r4);     // Catch: Exception -> L39
        goto L37
    L31:
        if (this.g == true) goto L38;
        r12 = this.f.a(r11);     // Catch: Exception -> L39
    L39:
        e = move-exception;
        a(r11, e, this.f12422e.e(), r5);
        return null;
    L19:
        if (r2.a(r9, r9.a(r10, r11)) == false) goto L38;
        r10.g();
        Map<Object, Object> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.a(r11, r2), Map.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L24
        b(r10, r11, r1);
        return r1;
    L24:
        e = move-exception;
        return (Map) ZeusTransformUtils.preCheckCast(a(r11, e, this.f12422e.e(), r5), Map.class, "com.obric.aiagent.plugin");
    L14:
        if (r8.a(r5) == false) goto L16;
        r10.k();
        goto L38
    L51:
        return (Map) ZeusTransformUtils.preCheckCast(r0.a(r11, r2), Map.class, "com.obric.aiagent.plugin");
    L44:
        e = move-exception;
        a(r11, e, this.f12422e.e(), r5);
        return null;
    L6:
        if (r10.a(com.fasterxml.jackson.a.n.f) == false) goto L8;
        r5 = r10.w();
        goto L10
    L8:
        r5 = null;
        goto L10
    }

    public final void d(com.fasterxml.jackson.a.k r8, com.fasterxml.jackson.databind.h r9, Map<Object, Object> r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r0 = this.f12454a;
        com.fasterxml.jackson.databind.l<Object> r1 = this.f12456c;
        com.fasterxml.jackson.databind.h.e r2 = this.f12457d;
        if (r8.r() == false) goto L5;
        String r3 = r8.i();
    L12:
        if (r3 == null) goto L38;
        Object r4 = r0.a(r3, r9);
        com.fasterxml.jackson.a.n r5 = r8.g();
        com.fasterxml.jackson.databind.l.m.a r6 = this.o;
        if (r6 != null) goto L16;
    L39:
        if (r5 == com.fasterxml.jackson.a.n.m) goto L21;
        Object r7 = r11.get(r4);     // Catch: Exception -> L35
        if (r7 == null) goto L29;
        if (r2 != null) goto L28;
        Object r12 = r1.a(r8, r9, r7);     // Catch: Exception -> L35
    L32:
        if (r12 == r7) goto L37;
        r11.put(r4, r12);     // Catch: Exception -> L35
    L37:
        r3 = r8.i();
        goto L12
    L28:
        r12 = r1.a(r8, r9, r2, r7);     // Catch: Exception -> L35
        goto L32
    L29:
        if (r2 != null) goto L31;
        r12 = r1.a(r8, r9);     // Catch: Exception -> L35
        goto L32
    L31:
        r12 = r1.a(r8, r9, r2);     // Catch: Exception -> L35
        goto L32
    L21:
        if (this.g == true) goto L37;
        r11.put(r4, this.f.a(r9));     // Catch: Exception -> L35
    L35:
        e = move-exception;
        a(r9, e, r11, r3);
        goto L37
    L16:
        if (r6.a(r3) == false) goto L39;
        r8.k();
        goto L37
    L38:
        return;
    L5:
        com.fasterxml.jackson.a.n r13 = r8.l();
        if (r13 != com.fasterxml.jackson.a.n.f12153c) goto L9;
        return;
    L9:
        if (r13 == com.fasterxml.jackson.a.n.f) goto L11;
        r9.a(this, com.fasterxml.jackson.a.n.f, null, new Object[0]);
    L11:
        r3 = r8.w();
        goto L12
    }

    public final void e(com.fasterxml.jackson.a.k r6, com.fasterxml.jackson.databind.h r7, Map<Object, Object> r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.l<Object> r0 = this.f12456c;
        com.fasterxml.jackson.databind.h.e r1 = this.f12457d;
        if (r6.r() == false) goto L5;
        String r2 = r6.i();
    L12:
        if (r2 == null) goto L38;
        com.fasterxml.jackson.a.n r3 = r6.g();
        com.fasterxml.jackson.databind.l.m.a r4 = this.o;
        if (r4 != null) goto L16;
    L39:
        if (r3 == com.fasterxml.jackson.a.n.m) goto L21;
        Object r5 = r9.get(r2);     // Catch: Exception -> L35
        if (r5 == null) goto L29;
        if (r1 != null) goto L28;
        Object r10 = r0.a(r6, r7, r5);     // Catch: Exception -> L35
    L32:
        if (r10 == r5) goto L37;
        r9.put(r2, r10);     // Catch: Exception -> L35
    L37:
        r2 = r6.i();
        goto L12
    L28:
        r10 = r0.a(r6, r7, r1, r5);     // Catch: Exception -> L35
        goto L32
    L29:
        if (r1 != null) goto L31;
        r10 = r0.a(r6, r7);     // Catch: Exception -> L35
        goto L32
    L31:
        r10 = r0.a(r6, r7, r1);     // Catch: Exception -> L35
        goto L32
    L21:
        if (this.g == true) goto L37;
        r9.put(r2, this.f.a(r7));     // Catch: Exception -> L35
    L35:
        e = move-exception;
        a(r7, e, r9, r2);
        goto L37
    L16:
        if (r4.a(r2) == false) goto L39;
        r6.k();
        goto L37
    L38:
        return;
    L5:
        com.fasterxml.jackson.a.n r11 = r6.l();
        if (r11 != com.fasterxml.jackson.a.n.f12153c) goto L9;
        return;
    L9:
        if (r11 == com.fasterxml.jackson.a.n.f) goto L11;
        r7.a(this, com.fasterxml.jackson.a.n.f, null, new Object[0]);
    L11:
        r2 = r6.w();
        goto L12
    }

    private void a(com.fasterxml.jackson.databind.h r3, b r4, Object r5, com.fasterxml.jackson.databind.b.w r6) {
        if (r4 != null) goto L4;
        r3.a(this, "Unresolved forward reference but no identity info: " + r6, new Object[0]);
    L4:
        r6.f().a(r4.a(r6, r5));
    }
}
