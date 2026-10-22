package com.fasterxml.jackson.databind.j.b;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: compiled from: MapSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
@JacksonStdImpl
public class u extends com.fasterxml.jackson.databind.j.i<Map<?, ?>> implements com.fasterxml.jackson.databind.j.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.k f12918a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f12919b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.d f12920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final boolean f12921d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.k f12922e;
    protected final com.fasterxml.jackson.databind.k f;
    protected com.fasterxml.jackson.databind.p<Object> g;
    protected com.fasterxml.jackson.databind.p<Object> h;
    protected final com.fasterxml.jackson.databind.h.h i;
    protected com.fasterxml.jackson.databind.j.a.k j;
    protected final Set<String> k;
    protected final Set<String> l;
    protected final Object m;
    protected final Object n;
    protected final boolean o;
    protected final com.fasterxml.jackson.databind.l.m.a p;
    protected final boolean q;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.j.b.u$1, reason: invalid class name */
    /* JADX INFO: compiled from: MapSerializer.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12923a = null;

        static {
            int[] r0 = new int[JsonInclude.Include.values().length];
            f12923a = r0;
            r0[JsonInclude.Include.NON_DEFAULT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L16:
            f12923a[JsonInclude.Include.NON_ABSENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L20:
            f12923a[JsonInclude.Include.NON_EMPTY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L26:
            f12923a[JsonInclude.Include.CUSTOM.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L18:
            f12923a[JsonInclude.Include.NON_NULL.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L22:
            f12923a[JsonInclude.Include.ALWAYS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L15
            return;
        }
    }

    @Override // com.fasterxml.jackson.databind.j.b.aj, com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ void a(Object r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        a((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // com.fasterxml.jackson.databind.p
    public /* synthetic */ boolean a(com.fasterxml.jackson.databind.ac r3, Object r4) {
        return a(r3, (Map) ZeusTransformUtils.preCheckCast(r4, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ boolean a(Map<?, ?> r3) {
        return a2((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.fasterxml.jackson.databind.j.i
    public /* synthetic */ com.fasterxml.jackson.databind.j.i b(com.fasterxml.jackson.databind.h.h r1) {
        return c(r1);
    }

    static {
        f12918a = com.fasterxml.jackson.databind.k.o.c();
        f12919b = JsonInclude.Include.NON_EMPTY;
    }

    public u(Set<String> r4, Set<String> r5, com.fasterxml.jackson.databind.k r6, com.fasterxml.jackson.databind.k r7, boolean r8, com.fasterxml.jackson.databind.h.h r9, com.fasterxml.jackson.databind.p<?> r10, com.fasterxml.jackson.databind.p<?> r11) {
        Set<String> r12 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.aiagent.plugin");
        Set<String> r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.aiagent.plugin");
        super(Map.class, false);
        if (r12 != null) goto L5;
    L6:
        r12 = null;
    L7:
        this.k = r12;
        this.l = r13;
        this.f12922e = r6;
        this.f = r7;
        this.f12921d = r8;
        this.i = r9;
        this.g = r10;
        this.h = r11;
        this.j = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12920c = null;
        this.m = null;
        this.q = false;
        this.n = null;
        this.o = false;
        this.p = com.fasterxml.jackson.databind.l.m.a(r12, r13);
        return;
    L5:
        if (r12.isEmpty() == false) goto L7;
        goto L6
    }

    public u(u r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.p<?> r5, com.fasterxml.jackson.databind.p<?> r6, Set<String> r7, Set<String> r8) {
        com.fasterxml.jackson.databind.d r9 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Set<String> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        Set<String> r11 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin");
        super(Map.class, false);
        if (r10 != null) goto L5;
    L6:
        r10 = null;
    L7:
        this.k = r10;
        this.l = r11;
        this.f12922e = r3.f12922e;
        this.f = r3.f;
        this.f12921d = r3.f12921d;
        this.i = r3.i;
        this.g = r5;
        this.h = r6;
        this.j = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12920c = r9;
        this.m = r3.m;
        this.q = r3.q;
        this.n = r3.n;
        this.o = r3.o;
        this.p = com.fasterxml.jackson.databind.l.m.a(r10, r11);
        return;
    L5:
        if (r10.isEmpty() == false) goto L7;
        goto L6
    }

    public u(u r3, com.fasterxml.jackson.databind.h.h r4, Object r5, boolean r6) {
        super(Map.class, false);
        this.k = r3.k;
        this.l = r3.l;
        this.f12922e = r3.f12922e;
        this.f = r3.f;
        this.f12921d = r3.f12921d;
        this.i = r4;
        this.g = r3.g;
        this.h = r3.h;
        this.j = r3.j;
        this.f12920c = r3.f12920c;
        this.m = r3.m;
        this.q = r3.q;
        this.n = r5;
        this.o = r6;
        this.p = r3.p;
    }

    public u(u r3, Object r4, boolean r5) {
        super(Map.class, false);
        this.k = r3.k;
        this.l = r3.l;
        this.f12922e = r3.f12922e;
        this.f = r3.f;
        this.f12921d = r3.f12921d;
        this.i = r3.i;
        this.g = r3.g;
        this.h = r3.h;
        this.j = com.fasterxml.jackson.databind.j.a.k.a();
        this.f12920c = r3.f12920c;
        this.m = r4;
        this.q = r5;
        this.n = r3.n;
        this.o = r3.o;
        this.p = r3.p;
    }

    public u c(com.fasterxml.jackson.databind.h.h r4) {
        if (this.i != r4) goto L5;
        return this;
    L5:
        a("_withValueTypeSerializer");
        return new u(this, r4, this.n, this.o);
    }

    public u a(com.fasterxml.jackson.databind.d r10, com.fasterxml.jackson.databind.p<?> r11, com.fasterxml.jackson.databind.p<?> r12, Set<String> r13, Set<String> r14, boolean r15) {
        com.fasterxml.jackson.databind.d r4 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r10, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        a("withResolved");
        u r16 = new u(this, r4, r11, r12, r7, r8);
        if (r15 != r16.q) goto L5;
        return r16;
    L5:
        return new u(r16, this.m, r15);
    }

    public u b(Object r3) {
        if (this.m != r3) goto L5;
        return this;
    L5:
        a("withFilterId");
        return new u(this, r3, this.q);
    }

    public u a(Object r3, boolean r4) {
        if (r3 == this.n) goto L5;
    L7:
        a("withContentInclusion");
        return new u(this, this.i, r3, r4);
    L5:
        if (r4 != this.o) goto L7;
        return this;
    }

    public static u a(Set<String> r13, Set<String> r14, com.fasterxml.jackson.databind.k r15, boolean r16, com.fasterxml.jackson.databind.h.h r17, com.fasterxml.jackson.databind.p<Object> r18, com.fasterxml.jackson.databind.p<Object> r19, Object r20) {
        Set r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r13, Set.class, "com.obric.aiagent.plugin");
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r14, Set.class, "com.obric.aiagent.plugin");
        if (r15 != null) goto L5;
        com.fasterxml.jackson.databind.k r7 = f12918a;
        com.fasterxml.jackson.databind.k r8 = r7;
    L10:
        boolean r0 = false;
        if (r16 == true) goto L17;
        if (r8 != null) goto L14;
    L18:
        boolean r9 = r0;
    L20:
        u r1 = new u(r5, r6, r7, r8, r9, r17, r18, r19);
        if (r20 != null) goto L23;
        return r1;
    L23:
        return r1.b(r20);
    L14:
        if (r8.p() == false) goto L18;
        r0 = true;
        goto L18
    L17:
        if (r8.e() == Object.class) goto L18;
        r9 = r16;
        goto L20
    L5:
        com.fasterxml.jackson.databind.k r2 = r15.w();
        if (r15.a(Properties.class) == false) goto L8;
        com.fasterxml.jackson.databind.k r3 = com.fasterxml.jackson.databind.k.o.c();
    L9:
        r8 = r3;
        r7 = r2;
        goto L10
    L8:
        r3 = r15.x();
        goto L9
    }

    public static u a(Set<String> r8, com.fasterxml.jackson.databind.k r9, boolean r10, com.fasterxml.jackson.databind.h.h r11, com.fasterxml.jackson.databind.p<Object> r12, com.fasterxml.jackson.databind.p<Object> r13, Object r14) {
        return a((Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.aiagent.plugin"), null, r9, r10, r11, r12, r13, r14);
    }

    public void a(String r2) {
        com.fasterxml.jackson.databind.l.h.a(u.class, this, r2);
    }

    @Override // com.fasterxml.jackson.databind.j.j
    public com.fasterxml.jackson.databind.p<?> a(com.fasterxml.jackson.databind.ac r14, com.fasterxml.jackson.databind.d r15) {
        com.fasterxml.jackson.databind.d r16 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r15, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r0 = r14.d();
        Object r9 = null;
        if (r16 != null) goto L5;
        com.fasterxml.jackson.databind.e.j r10 = null;
    L7:
        if (a(r10, r0) == false) goto L16;
        Object r2 = r0.n(r10);
        if (r2 == null) goto L11;
        com.fasterxml.jackson.databind.p<?> r3 = r14.b(r10, r2);
    L12:
        Object r4 = r0.o(r10);
        if (r4 == null) goto L15;
        com.fasterxml.jackson.databind.p<Object> r5 = r14.b(r10, r4);
    L17:
        if (r5 != null) goto L19;
        r5 = this.h;
    L19:
        com.fasterxml.jackson.databind.p<?> r6 = a(r14, r16, r5);
        if (r6 == null) goto L22;
    L26:
        com.fasterxml.jackson.databind.p<?> r7 = r6;
        if (r3 != null) goto L29;
        r3 = this.g;
    L29:
        if (r3 != null) goto L31;
        com.fasterxml.jackson.databind.p<?> r8 = r14.d(this.f12922e, r16);
    L32:
        com.fasterxml.jackson.databind.p<?> r11 = r8;
        Set<String> r12 = this.k;
        Set<String> r13 = this.l;
        boolean r17 = false;
        if (a(r10, r0) == false) goto L53;
        com.fasterxml.jackson.databind.aa r18 = r14.c();
        Set<String> r19 = r0.a(r18, r10).findIgnoredForSerialization();
        if (b(r19) == false) goto L43;
        if (r12 != null) goto L38;
        r12 = new HashSet();
    L39:
        Iterator<String> r20 = r19.iterator();
    L41:
        if (r20.hasNext() == false) goto L43;
        r12.add((String) ZeusTransformUtils.preCheckCast(r20.next(), String.class, "com.obric.aiagent.plugin"));
        goto L41
    L38:
        r12 = new HashSet(r12);
    L43:
        Set<String> r21 = r0.b(r18, r10).getIncluded();
        if (r21 == null) goto L52;
        if (r13 != null) goto L47;
        r13 = new HashSet();
    L48:
        Iterator<String> r22 = r21.iterator();
    L50:
        if (r22.hasNext() == false) goto L52;
        r13.add((String) ZeusTransformUtils.preCheckCast(r22.next(), String.class, "com.obric.aiagent.plugin"));
        goto L50
    L47:
        r13 = new HashSet(r13);
    L52:
        boolean r1 = Boolean.TRUE.equals(r0.t(r10));
        Set<String> r23 = r12;
        Set<String> r24 = r13;
    L54:
        JsonFormat.Value r25 = a(r14, r16, Map.class);
        if (r25 == null) goto L59;
        Boolean r26 = r25.getFeature(JsonFormat.Feature.WRITE_SORTED_MAP_ENTRIES);
        if (r26 == null) goto L59;
        r1 = r26.booleanValue();
    L59:
        u r27 = a(r16, r11, r7, r23, r24, r1);
        if (r10 == null) goto L64;
        Object r28 = r0.b(r10);
        if (r28 == null) goto L64;
        r27 = r27.b(r28);
    L64:
        JsonInclude.Value r110 = b(r14, r16, Map.class);
        if (r110 == null) goto L97;
        JsonInclude.Include r29 = r110.getContentInclusion();
        if (r29 == JsonInclude.Include.USE_DEFAULTS) goto L98;
        int r30 = AnonymousClass1.f12923a[r29.ordinal()];
        if (r30 != 1) goto L71;
        r9 = com.fasterxml.jackson.databind.l.e.a(this.f);
        if (r9 != null) goto L90;
    L92:
        r17 = true;
    L94:
        return r27.a(r9, r17);
    L90:
        if (r9.getClass().isArray() == false) goto L92;
        r9 = com.fasterxml.jackson.databind.l.c.a(r9);
        goto L92
    L71:
        if (r30 == 2) goto L85;
        if (r30 != 3) goto L75;
        r9 = f12919b;
        goto L92
    L75:
        if (r30 != 4) goto L77;
        r9 = r14.a(null, r110.getContentFilter());
        if (r9 == null) goto L92;
        r17 = r14.b(r9);
        goto L94
    L77:
        if (r30 == 5) goto L92;
    L85:
        if (this.f.a() == false) goto L92;
        r9 = f12919b;
        goto L92
    L98:
        return r27;
    L97:
        return r27;
    L53:
        r23 = r12;
        r24 = r13;
        r1 = false;
        goto L54
    L31:
        r8 = r14.b(r3, r16);
        goto L32
    L22:
        if (this.f12921d == false) goto L26;
        if (this.f.t() == true) goto L26;
        r6 = r14.c(this.f, r16);
        goto L26
    L15:
        r5 = null;
        goto L17
    L11:
        r3 = null;
        goto L12
    L16:
        r3 = null;
        r5 = null;
        goto L17
    L5:
        r10 = r16.d();
        goto L7
    }

    public com.fasterxml.jackson.databind.k d() {
        return this.f;
    }

    public boolean a(com.fasterxml.jackson.databind.ac r8, Map<?, ?> r9) {
        Map r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == false) goto L5;
        return true;
    L5:
        Object r0 = this.n;
        if (r0 == null) goto L8;
    L10:
        com.fasterxml.jackson.databind.p<Object> r3 = this.h;
        if (f12919b != r0) goto L13;
        boolean r4 = true;
    L14:
        if (r3 == null) goto L33;
        Iterator r5 = r10.values().iterator();
    L17:
        if (r5.hasNext() == false) goto L32;
        Object r6 = r5.next();
        if (r6 == null) goto L21;
        if (r4 == true) goto L26;
        if (r0 == null) goto L31;
        if (r0.equals(r10) == true) goto L17;
    L31:
        return false;
    L26:
        if (r3.a(r8, r6) == true) goto L17;
        return false;
    L21:
        if (this.o == true) goto L17;
        return false;
    L32:
        return true;
    L33:
        Iterator r7 = r10.values().iterator();
    L35:
        if (r7.hasNext() == false) goto L51;
        Object r11 = r7.next();
        if (r11 == null) goto L39;
        com.fasterxml.jackson.databind.p<Object> r12 = b(r8, r11);     // Catch: com.fasterxml.jackson.databind.f -> L52
        if (r4 == true) goto L45;
        if (r0 == null) goto L50;
        if (r0.equals(r10) == true) goto L35;
    L45:
        if (r12.a(r8, r11) == true) goto L35;
        return false;
    L50:
        return false;
    L39:
        if (this.o == true) goto L35;
        return false;
    L51:
        return true;
    L13:
        r4 = false;
        goto L14
    L8:
        if (this.o == true) goto L10;
        return false;
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public boolean a2(Map<?, ?> r2) {
        if (((Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin")).size() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public void a(Map<?, ?> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5) {
        Map<?, ?> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        r4.c(r6);
        b(r6, r4, r5);
        r4.k();
    }

    public void a(Map<?, ?> r3, com.fasterxml.jackson.a.h r4, com.fasterxml.jackson.databind.ac r5, com.fasterxml.jackson.databind.h.h r6) {
        Map<?, ?> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
        r4.a(r7);
        com.fasterxml.jackson.a.g.b r0 = r6.a(r4, r6.a(r7, com.fasterxml.jackson.a.n.f12152b));
        b(r7, r4, r5);
        r6.b(r4, r0);
    }

    public void b(Map<?, ?> r7, com.fasterxml.jackson.a.h r8, com.fasterxml.jackson.databind.ac r9) {
        Map<?, ?> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.q == false) goto L7;
    L8:
        r10 = d(r10, r8, r9);
    L9:
        Map<?, ?> r1 = r10;
        Object r11 = this.m;
        if (r11 == null) goto L14;
        com.fasterxml.jackson.databind.j.n r4 = a(r9, r11, r1);
        if (r4 == null) goto L14;
        a(r1, r8, r9, r4, this.n);
        return;
    L14:
        Object r12 = this.n;
        if (r12 == null) goto L17;
    L23:
        a(r1, r8, r9, r12);
        return;
    L17:
        if (this.o == true) goto L23;
        com.fasterxml.jackson.databind.p<Object> r13 = this.h;
        if (r13 == null) goto L22;
        a(r1, r8, r9, r13);
        return;
    L22:
        c(r1, r8, r9);
        return;
    L7:
        if (r9.a(com.fasterxml.jackson.databind.ab.x) == false) goto L9;
        goto L8
    }

    public void c(Map<?, ?> r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11) {
        Map<?, ?> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        Object r2 = null;
        if (this.i == null) goto L6;
        b(r12, r10, r11, null);
        return;
    L6:
        com.fasterxml.jackson.databind.p<Object> r0 = this.g;
        Iterator<Map.Entry<?, ?>> r3 = r12.entrySet().iterator();     // Catch: Exception -> L29
        Object r4 = null;
    L34:
        if (r3.hasNext() == false) goto L47;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");     // Catch: Exception -> L27
        Object r6 = r5.getValue();     // Catch: Exception -> L27
        r4 = r5.getKey();     // Catch: Exception -> L27
        if (r4 == null) goto L13;
        com.fasterxml.jackson.databind.l.m.a r7 = this.p;     // Catch: Exception -> L27
        if (r7 == null) goto L19;
        if (r7.a(r4) == true) goto L34;
    L19:
        r0.a(r4, r10, r11);     // Catch: Exception -> L27
    L20:
        if (r6 == null) goto L21;
        com.fasterxml.jackson.databind.p<Object> r8 = this.h;     // Catch: Exception -> L27
        if (r8 != null) goto L25;
        r8 = b(r11, r6);     // Catch: Exception -> L27
    L25:
        r8.a(r6, r10, r11);     // Catch: Exception -> L27
        goto L34
    L21:
        r11.a(r10);     // Catch: Exception -> L27
        goto L34
    L13:
        r11.e(this.f12922e, this.f12920c).a(null, r10, r11);     // Catch: Exception -> L27
        goto L20
    L47:
        return;
    L27:
        e = e;
        r2 = r4;
    L30:
        a(r11, e, r12, String.valueOf(r2));
        return;
    L29:
        e = e;
        goto L30
    }

    public void a(Map<?, ?> r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11, Object r12) {
        Map<?, ?> r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (this.i == null) goto L7;
        b(r13, r10, r11, r12);
        return;
    L7:
        if (f12919b != r12) goto L9;
        boolean r0 = true;
    L10:
        Iterator<Map.Entry<?, ?>> r2 = r13.entrySet().iterator();
    L12:
        if (r2.hasNext() == false) goto L43;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r4 = r3.getKey();
        if (r4 == null) goto L15;
        com.fasterxml.jackson.databind.l.m.a r5 = this.p;
        if (r5 == null) goto L21;
        if (r5.a(r4) == true) goto L12;
    L21:
        com.fasterxml.jackson.databind.p<Object> r6 = this.g;
    L22:
        Object r7 = r3.getValue();
        if (r7 == null) goto L25;
        com.fasterxml.jackson.databind.p<Object> r8 = this.h;
        if (r8 != null) goto L31;
        r8 = b(r11, r7);
    L31:
        if (r0 == true) goto L33;
        if (r12 != null) goto L37;
    L44:
        r6.a(r4, r10, r11);     // Catch: Exception -> L41
        r8.a(r7, r10, r11);     // Catch: Exception -> L41
    L41:
        e = move-exception;
        a(r11, e, r13, String.valueOf(r4));
        goto L12
    L37:
        if (r12.equals(r7) == false) goto L44;
    L33:
        if (r8.a(r11, r7) == false) goto L44;
    L25:
        if (this.o == true) goto L12;
        r8 = r11.k();
        goto L44
    L15:
        r6 = r11.e(this.f12922e, this.f12920c);
        goto L22
    L43:
        return;
    L9:
        r0 = false;
        goto L10
    }

    public void a(Map<?, ?> r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11, com.fasterxml.jackson.databind.p<Object> r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.p<Object> r0 = this.g;
        com.fasterxml.jackson.databind.h.h r2 = this.i;
        Iterator r3 = r13.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L22;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r5 = r4.getKey();
        com.fasterxml.jackson.databind.l.m.a r6 = this.p;
        if (r6 == null) goto L10;
        if (r6.a(r5) == true) goto L4;
    L10:
        if (r5 != null) goto L12;
        r11.e(this.f12922e, this.f12920c).a(null, r10, r11);
    L13:
        Object r7 = r4.getValue();
        if (r7 == null) goto L15;
        if (r2 != null) goto L18;
        r12.a(r7, r10, r11);     // Catch: Exception -> L20
    L20:
        e = move-exception;
        a(r11, e, r13, String.valueOf(r5));
        goto L4
    L18:
        r12.a(r7, r10, r11, r2);     // Catch: Exception -> L20
        goto L4
    L15:
        r11.a(r10);
        goto L4
    L12:
        r0.a(r5, r10, r11);
        goto L13
    }

    public void a(Map<?, ?> r10, com.fasterxml.jackson.a.h r11, com.fasterxml.jackson.databind.ac r12, com.fasterxml.jackson.databind.j.n r13, Object r14) {
        Map r15 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.j.n r16 = (com.fasterxml.jackson.databind.j.n) ZeusTransformUtils.wrapperContextForParams(r13, com.fasterxml.jackson.databind.j.n.class, "com.obric.aiagent.plugin");
        t r0 = new t(this.i, this.f12920c);
        if (f12919b != r14) goto L5;
        boolean r2 = true;
    L6:
        Iterator r3 = r15.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L39;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r5 = r4.getKey();
        com.fasterxml.jackson.databind.l.m.a r6 = this.p;
        if (r6 == null) goto L14;
        if (r6.a(r5) == true) goto L8;
    L14:
        if (r5 != null) goto L16;
        com.fasterxml.jackson.databind.p<Object> r7 = r12.e(this.f12922e, this.f12920c);
    L17:
        Object r8 = r4.getValue();
        if (r8 == null) goto L20;
        com.fasterxml.jackson.databind.p<Object> r9 = this.h;
        if (r9 != null) goto L26;
        r9 = b(r12, r8);
    L26:
        if (r2 == true) goto L28;
        if (r14 == null) goto L34;
        if (r14.equals(r8) == true) goto L8;
    L34:
        r0.a(r5, r8, r7, r9);
        r16.a(r15, r11, r12, r0);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        a(r12, e, r15, String.valueOf(r5));
        goto L8
    L28:
        if (r9.a(r12, r8) == false) goto L34;
    L20:
        if (this.o == true) goto L8;
        r9 = r12.k();
        goto L34
    L16:
        r7 = this.g;
        goto L17
    L39:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public void b(Map<?, ?> r9, com.fasterxml.jackson.a.h r10, com.fasterxml.jackson.databind.ac r11, Object r12) {
        Map r13 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.aiagent.plugin");
        if (f12919b != r12) goto L5;
        boolean r0 = true;
    L6:
        Iterator r2 = r13.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L40;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r4 = r3.getKey();
        if (r4 == null) goto L11;
        com.fasterxml.jackson.databind.l.m.a r5 = this.p;
        if (r5 == null) goto L17;
        if (r5.a(r4) == true) goto L8;
    L17:
        com.fasterxml.jackson.databind.p<Object> r6 = this.g;
    L18:
        Object r7 = r3.getValue();
        if (r7 == null) goto L21;
        com.fasterxml.jackson.databind.p<Object> r8 = this.h;
        if (r8 != null) goto L27;
        r8 = b(r11, r7);
    L27:
        if (r0 == true) goto L29;
        if (r12 == null) goto L35;
        if (r12.equals(r7) == true) goto L8;
    L35:
        r6.a(r4, r10, r11);
        r8.a(r7, r10, r11, this.i);     // Catch: Exception -> L38
    L38:
        e = move-exception;
        a(r11, e, r13, String.valueOf(r4));
        goto L8
    L29:
        if (r8.a(r11, r7) == false) goto L35;
    L21:
        if (this.o == true) goto L8;
        r8 = r11.k();
        goto L35
    L11:
        r6 = r11.e(this.f12922e, this.f12920c);
        goto L18
    L40:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public void a(com.fasterxml.jackson.databind.ac r10, com.fasterxml.jackson.a.h r11, Object r12, Map<?, ?> r13, com.fasterxml.jackson.databind.j.n r14, Object r15) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r13, Map.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.j.n r17 = (com.fasterxml.jackson.databind.j.n) ZeusTransformUtils.wrapperContextForParams(r14, com.fasterxml.jackson.databind.j.n.class, "com.obric.aiagent.plugin");
        t r0 = new t(this.i, this.f12920c);
        if (f12919b != r15) goto L5;
        boolean r2 = true;
    L6:
        Iterator r3 = r16.entrySet().iterator();
    L8:
        if (r3.hasNext() == false) goto L39;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r5 = r4.getKey();
        com.fasterxml.jackson.databind.l.m.a r6 = this.p;
        if (r6 == null) goto L14;
        if (r6.a(r5) == true) goto L8;
    L14:
        if (r5 != null) goto L16;
        com.fasterxml.jackson.databind.p<Object> r7 = r10.e(this.f12922e, this.f12920c);
    L17:
        Object r8 = r4.getValue();
        if (r8 == null) goto L20;
        com.fasterxml.jackson.databind.p<Object> r9 = this.h;
        if (r9 != null) goto L26;
        r9 = b(r10, r8);
    L26:
        if (r2 == true) goto L28;
        if (r15 == null) goto L34;
        if (r15.equals(r8) == true) goto L8;
    L34:
        r0.a(r5, r8, r7, r9);
        r17.a(r12, r11, r10, r0);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        a(r10, e, r16, String.valueOf(r5));
        goto L8
    L28:
        if (r9.a(r10, r8) == false) goto L34;
    L20:
        if (this.o == true) goto L8;
        r9 = r10.k();
        goto L34
    L16:
        r7 = this.g;
        goto L17
    L39:
        return;
    L5:
        r2 = false;
        goto L6
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, Class<?> r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12920c);
        if (r2 == r5.f12828b) goto L6;
        this.j = r5.f12828b;
    L6:
        return r5.f12827a;
    }

    public final com.fasterxml.jackson.databind.p<Object> a(com.fasterxml.jackson.databind.j.a.k r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.ac r4) {
        com.fasterxml.jackson.databind.j.a.k.d r5 = r2.b(r3, r4, this.f12920c);
        if (r2 == r5.f12828b) goto L6;
        this.j = r5.f12828b;
    L6:
        return r5.f12827a;
    }

    public Map<?, ?> d(Map<?, ?> r5, com.fasterxml.jackson.a.h r6, com.fasterxml.jackson.databind.ac r7) {
        Map<?, ?> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r8, SortedMap.class) == false) goto L6;
        return r8;
    L6:
        if (b(r8) == false) goto L16;
        TreeMap r0 = new TreeMap();
        Iterator<Map.Entry<?, ?>> r9 = r8.entrySet().iterator();
    L9:
        if (r9.hasNext() == false) goto L14;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.aiagent.plugin");
        Object r3 = r2.getKey();
        if (r3 == null) goto L12;
        r0.put(r3, r2.getValue());
        goto L9
    L12:
        a(r6, r7, r2.getValue());
        goto L9
    L14:
        return r0;
    L16:
        return new TreeMap(r8);
    }

    public boolean b(Map<?, ?> r2) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, HashMap.class) == true) goto L5;
    L7:
        return false;
    L5:
        if (r1.containsKey(null) == false) goto L7;
        return true;
    }

    public void a(com.fasterxml.jackson.a.h r5, com.fasterxml.jackson.databind.ac r6, Object r7) {
        com.fasterxml.jackson.databind.p<Object> r0 = r6.e(this.f12922e, this.f12920c);
        if (r7 == null) goto L5;
        com.fasterxml.jackson.databind.p<Object> r1 = this.h;
        if (r1 != null) goto L11;
        r1 = b(r6, r7);
    L11:
        Object r2 = this.n;
        if (r2 == f12919b) goto L14;
        if (r2 != null) goto L18;
    L26:
        r0.a(null, r5, r6);     // Catch: Exception -> L23
        r1.a(r7, r5, r6);     // Catch: Exception -> L23
        return;
    L23:
        e = move-exception;
        a(r6, e, r7, "");
        return;
    L18:
        if (r2.equals(r7) == false) goto L26;
        return;
    L14:
        if (r1.a(r6, r7) == false) goto L26;
        return;
    L5:
        if (this.o == false) goto L7;
        return;
    L7:
        r1 = r6.k();
        goto L26
    }

    private final com.fasterxml.jackson.databind.p<Object> b(com.fasterxml.jackson.databind.ac r3, Object r4) {
        Class<?> r5 = r4.getClass();
        com.fasterxml.jackson.databind.p<Object> r0 = this.j.a(r5);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f.v() == false) goto L10;
        return a(this.j, r3.a(this.f, r5), r3);
    L10:
        return a(this.j, r5, r3);
    }
}
