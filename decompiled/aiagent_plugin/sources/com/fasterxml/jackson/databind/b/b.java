package com.fasterxml.jackson.databind.b;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.b.b.ad;
import com.fasterxml.jackson.databind.b.b.ag;
import com.fasterxml.jackson.databind.b.b.ah;
import com.fasterxml.jackson.databind.b.b.ak;
import com.fasterxml.jackson.databind.b.b.am;
import com.fasterxml.jackson.databind.e.ae;
import com.fasterxml.jackson.databind.e.ai;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: BasicDeserializerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends p implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.databind.x f12359a = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class<?> f12360c = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Class<?> f12361e = null;
    private static final Class<?> f = null;
    private static final Class<?> g = null;
    private static final Class<?> h = null;
    private static final Class<?> i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.a.k f12362b;

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b$1, reason: invalid class name */
    /* JADX INFO: compiled from: BasicDeserializerFactory.java */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12363a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f12364b = null;

        static {
            int[] r0 = new int[com.fasterxml.jackson.databind.a.i.a.values().length];
            f12364b = r0;
            r0[com.fasterxml.jackson.databind.a.i.a.f12219a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L21:
            f12364b[com.fasterxml.jackson.databind.a.i.a.f12220b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            f12364b[com.fasterxml.jackson.databind.a.i.a.f12222d.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L33:
            f12364b[com.fasterxml.jackson.databind.a.i.a.f12221c.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L9:
            int[] r3 = new int[JsonCreator.Mode.values().length];
            f12363a = r3;
            r3[JsonCreator.Mode.DELEGATING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L23:
            f12363a[JsonCreator.Mode.PROPERTIES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L25:
            f12363a[JsonCreator.Mode.DEFAULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    /* JADX INFO: compiled from: BasicDeserializerFactory.java */
    protected static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Class<? extends Collection>> f12365a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final HashMap<String, Class<? extends Map>> f12366b = null;

        static {
            HashMap<String, Class<? extends Collection>> r0 = new HashMap();
            r0.put(Collection.class.getName(), ArrayList.class);
            r0.put(List.class.getName(), ArrayList.class);
            r0.put(Set.class.getName(), HashSet.class);
            r0.put(SortedSet.class.getName(), TreeSet.class);
            r0.put(Queue.class.getName(), LinkedList.class);
            r0.put(AbstractList.class.getName(), ArrayList.class);
            r0.put(AbstractSet.class.getName(), HashSet.class);
            r0.put(Deque.class.getName(), LinkedList.class);
            r0.put(NavigableSet.class.getName(), TreeSet.class);
            f12365a = r0;
            HashMap<String, Class<? extends Map>> r1 = new HashMap();
            r1.put(Map.class.getName(), LinkedHashMap.class);
            r1.put(AbstractMap.class.getName(), LinkedHashMap.class);
            r1.put(ConcurrentMap.class.getName(), ConcurrentHashMap.class);
            r1.put(SortedMap.class.getName(), TreeMap.class);
            r1.put(NavigableMap.class.getName(), TreeMap.class);
            r1.put(ConcurrentNavigableMap.class.getName(), ConcurrentSkipListMap.class);
            f12366b = r1;
        }

        public static Class<?> a(com.fasterxml.jackson.databind.k r2) {
            return (Class) ZeusTransformUtils.preCheckCast(f12365a.get(r2.e().getName()), Class.class, "com.obric.aiagent.plugin");
        }

        public static Class<?> b(com.fasterxml.jackson.databind.k r2) {
            return (Class) ZeusTransformUtils.preCheckCast(f12366b.get(r2.e().getName()), Class.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: renamed from: com.fasterxml.jackson.databind.b.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BasicDeserializerFactory.java */
    protected static class C0270b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.h f12367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.c f12368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ai<?> f12369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.b.a.e f12370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> f12371e;
        private List<com.fasterxml.jackson.databind.b.a.d> f;
        private int g;
        private List<com.fasterxml.jackson.databind.b.a.d> h;
        private int i;

        public C0270b(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.c r4, ai<?> r5, com.fasterxml.jackson.databind.b.a.e r6, Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r7) {
            ai<?> r8 = (ai) ZeusTransformUtils.wrapperContextForParams(r5, ai.class, "com.obric.aiagent.plugin");
            Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
            this.f12367a = r3;
            this.f12368b = r4;
            this.f12369c = r8;
            this.f12370d = r6;
            this.f12371e = r9;
        }

        public com.fasterxml.jackson.databind.b a() {
            return this.f12367a.f();
        }

        public void a(com.fasterxml.jackson.databind.b.a.d r2) {
            if (this.f != null) goto L5;
            this.f = new LinkedList();
        L5:
            this.f.add(r2);
        }

        public void b() {
            this.g++;
        }

        public boolean c() {
            if (this.g <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean d() {
            if (this.f == null) goto L5;
            return true;
        L5:
            return false;
        }

        public List<com.fasterxml.jackson.databind.b.a.d> e() {
            return this.f;
        }

        public void b(com.fasterxml.jackson.databind.b.a.d r2) {
            if (this.h != null) goto L5;
            this.h = new LinkedList();
        L5:
            this.h.add(r2);
        }

        public void f() {
            this.i++;
        }

        public boolean g() {
            if (this.i <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean h() {
            if (this.h == null) goto L5;
            return true;
        L5:
            return false;
        }

        public List<com.fasterxml.jackson.databind.b.a.d> i() {
            return this.h;
        }
    }

    static {
        f12360c = Object.class;
        f12361e = String.class;
        f = CharSequence.class;
        g = Iterable.class;
        h = Map.Entry.class;
        i = Serializable.class;
        f12359a = new com.fasterxml.jackson.databind.x("@JsonUnwrapped");
    }

    public b(com.fasterxml.jackson.databind.a.k r1) {
        this.f12362b = r1;
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.g r4, com.fasterxml.jackson.databind.k r5) {
    L2:
        com.fasterxml.jackson.databind.k r0 = c(r4, r5);
        if (r0 == null) goto L4;
        Class<?> r1 = r5.e();
        Class<?> r2 = r0.e();
        if (r1 == r2) goto L11;
        if (r1.isAssignableFrom(r2) == false) goto L11;
        r5 = r0;
    L11:
        throw new IllegalArgumentException("Invalid abstract type resolution from " + r5 + " to " + r0 + ": latter is not a subtype of former");
    L4:
        return r5;
    }

    private com.fasterxml.jackson.databind.k c(com.fasterxml.jackson.databind.g r5, com.fasterxml.jackson.databind.k r6) {
        Class<?> r0 = r6.e();
        if (this.f12362b.c() == false) goto L12;
        Iterator<com.fasterxml.jackson.databind.a> r4 = this.f12362b.h().iterator();
    L6:
        if (r4.hasNext() == false) goto L20;
        com.fasterxml.jackson.databind.k r1 = ((com.fasterxml.jackson.databind.a) ZeusTransformUtils.preCheckCast(r4.next(), com.fasterxml.jackson.databind.a.class, "com.obric.aiagent.plugin")).a(r5, r6);
        if (r1 == null) goto L6;
        if (r1.a(r0) == true) goto L6;
        return r1;
    L20:
        return null;
    L12:
        return null;
    }

    public y a(com.fasterxml.jackson.databind.h r6, com.fasterxml.jackson.databind.c r7) {
        com.fasterxml.jackson.databind.g r0 = r6.c();
        com.fasterxml.jackson.databind.e.d r1 = r7.c();
        Object r2 = r6.f().f(r1);
        if (r2 == null) goto L5;
        y r3 = a(r0, r1, r2);
    L6:
        if (r3 != null) goto L11;
        r3 = com.fasterxml.jackson.databind.b.a.k.a(r0, r7.a());
        if (r3 != null) goto L11;
        r3 = b(r6, r7);
    L11:
        if (this.f12362b.d() == false) goto L18;
        Iterator<z> r5 = this.f12362b.i().iterator();
    L14:
        if (r5.hasNext() == false) goto L18;
        z r4 = (z) ZeusTransformUtils.preCheckCast(r5.next(), z.class, "com.obric.aiagent.plugin");
        r3 = r4.a(r0, r7, r3);
        if (r3 != null) goto L14;
        r6.a(r7, "Broken registered ValueInstantiators (of type %s): returned null ValueInstantiator", new Object[]{r4.getClass().getName()});
    L18:
        if (r3 != null) goto L20;
        return r3;
    L20:
        return r3.a(r6, r7);
    L5:
        r3 = null;
        goto L6
    }

    public y b(com.fasterxml.jackson.databind.h r10, com.fasterxml.jackson.databind.c r11) {
        com.fasterxml.jackson.databind.g r0 = r10.c();
        ai<?> r6 = r0.a(r11.a(), r11.c());
        com.fasterxml.jackson.databind.a.i r1 = r0.e();
        C0270b r2 = new C0270b(r10, r11, r6, new com.fasterxml.jackson.databind.b.a.e(r11, r0), c(r10, r11));
        b(r10, r2, !r1.b());
        if (r11.getType().h() == false) goto L19;
        if (r11.getType().m() == false) goto L11;
        ArrayList r3 = new ArrayList();
        com.fasterxml.jackson.databind.e.f r4 = com.fasterxml.jackson.databind.f.a.a(r10, r11, r3);
        if (r4 == null) goto L11;
        a(r10, r2, r4, r3);
        return r2.f12370d.a(r10);
    L11:
        if (r11.b() == true) goto L19;
        a(r10, r2, r1.a(r11.a()));
        if (r2.h() == false) goto L19;
        if (r2.g() == true) goto L19;
        a(r10, r2, r2.i());
    L19:
        if (r2.d() == false) goto L26;
        if (r2.c() == true) goto L26;
        if (r2.g() == true) goto L26;
        b(r10, r2, r2.e());
    L26:
        return r2.f12370d.a(r10);
    }

    public Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> c(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.c r12) {
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r10 = Collections.emptyMap();
        Iterator<com.fasterxml.jackson.databind.e.t> r0 = r12.g().iterator();
    L4:
        if (r0.hasNext() == false) goto L18;
        com.fasterxml.jackson.databind.e.t r1 = (com.fasterxml.jackson.databind.e.t) ZeusTransformUtils.preCheckCast(r0.next(), com.fasterxml.jackson.databind.e.t.class, "com.obric.aiagent.plugin");
        Iterator<com.fasterxml.jackson.databind.e.n> r2 = r1.r();
    L7:
        if (r2.hasNext() == false) goto L4;
        com.fasterxml.jackson.databind.e.n r4 = (com.fasterxml.jackson.databind.e.n) ZeusTransformUtils.preCheckCast(r2.next(), com.fasterxml.jackson.databind.e.n.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.e.o r5 = r4.d();
        com.fasterxml.jackson.databind.e.t[] r6 = (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r10.get(r5), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin");
        int r7 = r4.e();
        if (r6 != null) goto L15;
        if (r10.isEmpty() == false) goto L13;
        r10 = new LinkedHashMap();
    L13:
        r6 = new com.fasterxml.jackson.databind.e.t[r5.e()];
        r10.put(r5, r6);
    L17:
        r6[r7] = r1;
        goto L7
    L15:
        if (r6[r7] == null) goto L17;
        r11.a(r12, "Conflict: parameter #%d of %s bound to more than one property; %s vs %s", new Object[]{Integer.valueOf(r7), r5, r6[r7], r1});
        goto L17
    L18:
        return r10;
    }

    public y a(com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.e.b r4, Object r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, y.class) == false) goto L10;
        return (y) ZeusTransformUtils.preCheckCast(r5, y.class, "com.obric.aiagent.plugin");
    L10:
        if (ZeusTransformUtils.instanceOf(r5, Class.class) == false) goto L26;
        Class<?> r6 = (Class) ZeusTransformUtils.preCheckCast(r5, Class.class, "com.obric.aiagent.plugin");
        if (com.fasterxml.jackson.databind.l.h.e(r6) == false) goto L15;
        return null;
    L15:
        if (y.class.isAssignableFrom(r6) == false) goto L24;
        com.fasterxml.jackson.databind.a.l r2 = r3.m();
        if (r2 == null) goto L22;
        y r7 = r2.c(r3, r4, r6);
        if (r7 == null) goto L22;
        return r7;
    L22:
        return (y) ZeusTransformUtils.preCheckCast(com.fasterxml.jackson.databind.l.h.b(r6, r3.g()), y.class, "com.obric.aiagent.plugin");
    L24:
        throw new IllegalStateException("AnnotationIntrospector returned Class " + r6.getName() + "; expected Class<ValueInstantiator>");
    L26:
        throw new IllegalStateException("AnnotationIntrospector returned key deserializer definition of type " + r5.getClass().getName() + "; expected type KeyDeserializer or Class<KeyDeserializer> instead");
    }

    public void a(com.fasterxml.jackson.databind.h r17, C0270b r18, com.fasterxml.jackson.databind.e.f r19, List<String> r20) {
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r20, List.class, "com.obric.aiagent.plugin");
        int r4 = r19.e();
        com.fasterxml.jackson.databind.b r5 = r17.f();
        v[] r6 = new v[r4];
        int r15 = 0;
    L3:
        if (r15 >= r4) goto L10;
        com.fasterxml.jackson.databind.e.n r13 = r19.d(r15);
        JacksonInject.Value r14 = r5.e(r13);
        com.fasterxml.jackson.databind.x r8 = r5.B(r13);
        if (r8 != null) goto L7;
    L8:
        r8 = com.fasterxml.jackson.databind.x.a((String) ZeusTransformUtils.preCheckCast(r2.get(r15), String.class, "com.obric.aiagent.plugin"));
    L9:
        r6[r15] = a(r17, r18.f12368b, r8, r15, r13, r14);
        r15 = r15 + 1;
        goto L3
    L7:
        if (r8.e() == false) goto L9;
    L10:
        r18.f12370d.a(r19, false, r6);
    }

    public void a(com.fasterxml.jackson.databind.h r13, C0270b r14, boolean r15) {
        com.fasterxml.jackson.databind.c r6 = r14.f12368b;
        com.fasterxml.jackson.databind.b.a.e r7 = r14.f12370d;
        com.fasterxml.jackson.databind.b r8 = r14.a();
        ai<?> r9 = r14.f12369c;
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r10 = r14.f12371e;
        com.fasterxml.jackson.databind.e.f r0 = r6.n();
        if (r0 != null) goto L5;
    L9:
        Iterator<com.fasterxml.jackson.databind.e.f> r11 = r6.j().iterator();
    L11:
        if (r11.hasNext() == false) goto L28;
        com.fasterxml.jackson.databind.e.f r1 = (com.fasterxml.jackson.databind.e.f) ZeusTransformUtils.preCheckCast(r11.next(), com.fasterxml.jackson.databind.e.f.class, "com.obric.aiagent.plugin");
        JsonCreator.Mode r2 = r8.d(r13.c(), r1);
        if (JsonCreator.Mode.DISABLED == r2) goto L11;
        if (r2 == null) goto L16;
        int r3 = AnonymousClass1.f12363a[r2.ordinal()];
        if (r3 != 1) goto L23;
        a(r13, r6, r7, com.fasterxml.jackson.databind.b.a.d.a(r8, r1, null));
    L27:
        r14.f();
        goto L11
    L23:
        if (r3 == 2) goto L25;
        a(r13, r6, r7, com.fasterxml.jackson.databind.b.a.d.a(r8, r1, (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r10.get(r1), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin")), r13.c().e());
        goto L27
    L25:
        b(r13, r6, r7, com.fasterxml.jackson.databind.b.a.d.a(r8, r1, (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r10.get(r1), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin")));
        goto L27
    L16:
        if (r15 == false) goto L11;
        if (r9.a(r1) == false) goto L11;
        r14.b(com.fasterxml.jackson.databind.b.a.d.a(r8, r1, (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r10.get(r1), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin")));
        goto L11
    L28:
        return;
    L5:
        if (r7.a() == true) goto L7;
    L8:
        r7.a(r0);
        goto L9
    L7:
        if (d(r13, r0) == false) goto L9;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(com.fasterxml.jackson.databind.h r29, C0270b r30, List<com.fasterxml.jackson.databind.b.a.d> r31) {
        String r9 = "com.obric.aiagent.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.g r2 = r29.c();
        com.fasterxml.jackson.databind.c r10 = r30.f12368b;
        com.fasterxml.jackson.databind.b.a.e r11 = r30.f12370d;
        com.fasterxml.jackson.databind.b r12 = r30.a();
        ai<?> r13 = r30.f12369c;
        boolean r14 = r2.e().d();
        Iterator r15 = r1.iterator();
        LinkedList r17 = null;
    L4:
        if (r15.hasNext() == false) goto L69;
        com.fasterxml.jackson.databind.b.a.d r6 = (com.fasterxml.jackson.databind.b.a.d) ZeusTransformUtils.preCheckCast(r15.next(), com.fasterxml.jackson.databind.b.a.d.class, r9);
        int r5 = r6.b();
        com.fasterxml.jackson.databind.e.o r4 = r6.a();
        boolean r3 = true;
        if (r5 != 1) goto L27;
        com.fasterxml.jackson.databind.e.t r0 = r6.c(0);
        if (r14 == false) goto L10;
    L13:
        Object[] r7 = true;
    L14:
        if (r7 == false) goto L22;
        v[] r8 = new v[1];
        JacksonInject.Value r18 = r6.a(0);
        com.fasterxml.jackson.databind.x r16 = r6.d(0);
        if (r16 != null) goto L21;
        r16 = r6.f(0);
        if (r16 != null) goto L21;
        if (r18 != null) goto L21;
        boolean r32 = r14;
    L26:
        Iterator r24 = r15;
    L58:
        r14 = r32;
        r9 = r9;
        r15 = r24;
        r13 = r13;
    L21:
        r32 = r14;
        r8[0] = a(r29, r10, r16, 0, r6.b(0), r18);
        r11.a(r4, false, r8);
        goto L26
    L22:
        r32 = r14;
        a(r11, r4, false, r13.a(r4));
        if (r0 == null) goto L26;
        ((ae) ZeusTransformUtils.preCheckCast(r0, ae.class, r9)).K();
        goto L26
    L10:
        if (a(r12, r4, r0) == true) goto L13;
        r7 = false;
        goto L14
    L27:
        r32 = r14;
        boolean r19 = false;
        v[] r20 = new v[r5];
        int r21 = -1;
        int r22 = 0;
        int r110 = 0;
        int r111 = 0;
    L28:
        if (r22 >= r5) goto L47;
        int r33 = r5;
        com.fasterxml.jackson.databind.e.n r23 = r4.d(r22);
        com.fasterxml.jackson.databind.e.t r25 = r6.c(r22);
        JacksonInject.Value r26 = r12.e(r23);
        if (r25 != null) goto L32;
        com.fasterxml.jackson.databind.x r27 = null;
    L33:
        if (r25 != null) goto L35;
    L37:
        int r28 = r22;
        boolean r210 = r3;
        com.fasterxml.jackson.databind.b.a.d r211 = r6;
        String r212 = r9;
        ai<?> r213 = r13;
        Iterator r214 = r15;
        int r112 = r33;
        int r34 = r21;
        v[] r113 = r20;
        if (r26 == null) goto L42;
        r111 = r111 + 1;
        r113[r28] = a(r29, r10, r27, r28, r23, r26);
    L40:
        r21 = r34;
    L46:
        r22 = r28 + 1;
        r5 = r112;
        r20 = r113;
        r9 = r212;
        r15 = r214;
        r3 = r210;
        r13 = r213;
        r6 = r211;
        r19 = false;
        goto L28
    L42:
        if (r12.c(r23) == null) goto L44;
        a(r29, r10, r23);
        goto L40
    L44:
        if (r34 >= 0) goto L40;
        r21 = r28;
        goto L46
    L35:
        if (r25.e() == false) goto L37;
        r110 = r110 + 1;
        r28 = r22;
        r212 = r9;
        r34 = r21;
        r214 = r15;
        r113 = r20;
        r210 = r3;
        r213 = r13;
        r112 = r33;
        r211 = r6;
        r113[r28] = a(r29, r10, r27, r28, r23, r26);
        goto L40
    L32:
        r27 = r25.b();
        goto L33
    L47:
        boolean r215 = r3;
        com.fasterxml.jackson.databind.b.a.d r216 = r6;
        r9 = r9;
        r13 = r13;
        r24 = r15;
        int r35 = r21;
        v[] r114 = r20;
        int r115 = r5;
        int r36 = r110 + 0;
        if (r110 > 0) goto L51;
        if (r111 > 0) goto L51;
    L65:
        if (r11.a() == true) goto L58;
        if (r17 != null) goto L68;
        r17 = new LinkedList();
    L68:
        LinkedList r37 = r17;
        r37.add(r4);
        r17 = r37;
    L51:
        if ((r36 + r111) != r115) goto L54;
        r11.a(r4, false, r114);
        goto L58
    L54:
        if (r110 == 0) goto L56;
    L59:
        com.fasterxml.jackson.databind.x r38 = r216.f(r35);
        if (r38 != null) goto L62;
    L63:
        Object[] r39 = new Object[2];
        r39[0] = Integer.valueOf(r35);
        r39[r215 ? 1 : 0] = r4;
        r29.a(r10, "Argument #%d of constructor %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", r39);
        goto L65
    L62:
        if (r38.e() == false) goto L65;
    L56:
        if ((r111 + 1) != r115) goto L59;
        r11.a(r4, false, r114, 0);
        goto L58
    L69:
        ai<?> r217 = r13;
        if (r17 != null) goto L72;
        return;
    L72:
        if (r11.b() == false) goto L74;
        return;
    L74:
        if (r11.c() == true) goto L88;
        a(r29, r10, r217, r12, r11, r17);
        return;
    }

    public void b(com.fasterxml.jackson.databind.h r17, C0270b r18, boolean r19) {
        com.fasterxml.jackson.databind.c r9 = r18.f12368b;
        com.fasterxml.jackson.databind.b.a.e r10 = r18.f12370d;
        com.fasterxml.jackson.databind.b r11 = r18.a();
        ai<?> r12 = r18.f12369c;
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r13 = r18.f12371e;
        Iterator<com.fasterxml.jackson.databind.e.k> r14 = r9.l().iterator();
    L4:
        if (r14.hasNext() == false) goto L25;
        com.fasterxml.jackson.databind.e.k r0 = (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r14.next(), com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
        JsonCreator.Mode r1 = r11.d(r17.c(), r0);
        int r3 = r0.e();
        if (r1 == null) goto L7;
        if (r1 == JsonCreator.Mode.DISABLED) goto L4;
        if (r3 == 0) goto L16;
        int r2 = AnonymousClass1.f12363a[r1.ordinal()];
        if (r2 != 1) goto L20;
        a(r17, r9, r10, com.fasterxml.jackson.databind.b.a.d.a(r11, r0, null));
    L24:
        r18.b();
        goto L4
    L20:
        if (r2 == 2) goto L22;
        a(r17, r9, r10, com.fasterxml.jackson.databind.b.a.d.a(r11, r0, (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r13.get(r0), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin")), com.fasterxml.jackson.databind.a.i.f12214a);
        goto L24
    L22:
        b(r17, r9, r10, com.fasterxml.jackson.databind.b.a.d.a(r11, r0, (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r13.get(r0), com.fasterxml.jackson.databind.e.t[].class, "com.obric.aiagent.plugin")));
        goto L24
    L16:
        r10.a(r0);
        goto L4
    L7:
        if (r19 == false) goto L4;
        if (r3 != 1) goto L4;
        if (r12.a(r0) == false) goto L4;
        r18.a(com.fasterxml.jackson.databind.b.a.d.a(r11, r0, null));
        goto L4
    }

    public void b(com.fasterxml.jackson.databind.h r28, C0270b r29, List<com.fasterxml.jackson.databind.b.a.d> r30) {
        String r9 = "com.obric.aiagent.plugin";
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.c r10 = r29.f12368b;
        com.fasterxml.jackson.databind.b.a.e r11 = r29.f12370d;
        com.fasterxml.jackson.databind.b r12 = r29.a();
        ai<?> r13 = r29.f12369c;
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r14 = r29.f12371e;
        Iterator r15 = r1.iterator();
    L4:
        if (r15.hasNext() == false) goto L53;
        com.fasterxml.jackson.databind.b.a.d r0 = (com.fasterxml.jackson.databind.b.a.d) ZeusTransformUtils.preCheckCast(r15.next(), com.fasterxml.jackson.databind.b.a.d.class, r9);
        int r6 = r0.b();
        com.fasterxml.jackson.databind.e.o r5 = r0.a();
        com.fasterxml.jackson.databind.e.t[] r16 = (com.fasterxml.jackson.databind.e.t[]) ZeusTransformUtils.preCheckCast(r14.get(r5), com.fasterxml.jackson.databind.e.t[].class, r9);
        boolean r4 = true;
        if (r6 != 1) goto L4;
        boolean r3 = false;
        com.fasterxml.jackson.databind.e.t r2 = r0.c(0);
        if (a(r12, r5, r2) == false) goto L10;
        v[] r7 = new v[r6];
        int r8 = 0;
        int r18 = 0;
        int r19 = 0;
        com.fasterxml.jackson.databind.e.n r20 = null;
    L14:
        if (r8 >= r6) goto L36;
        com.fasterxml.jackson.databind.e.n r17 = r5.d(r8);
        if (r16 != null) goto L18;
        com.fasterxml.jackson.databind.e.t r21 = null;
    L19:
        JacksonInject.Value r22 = r12.e(r17);
        if (r21 != null) goto L22;
        com.fasterxml.jackson.databind.x r23 = null;
    L23:
        if (r21 != null) goto L25;
    L27:
        int r24 = r8;
        boolean r25 = r4;
        String r26 = r9;
        ai<?> r31 = r13;
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r27 = r14;
        v[] r32 = r7;
        com.fasterxml.jackson.databind.e.o r110 = r5;
        int r111 = r6;
        if (r22 == null) goto L31;
        r19 = r19 + 1;
        r32[r24] = a(r28, r10, r23, r24, r17, r22);
    L35:
        r8 = r24 + 1;
        r7 = r32;
        r5 = r110;
        r6 = r111;
        r9 = r26;
        r4 = r25;
        r14 = r27;
        r3 = false;
        r13 = r31;
        goto L14
    L31:
        if (r12.c(r17) == null) goto L33;
        a(r28, r10, r17);
        goto L35
    L33:
        if (r20 != null) goto L35;
        r20 = r17;
        goto L35
    L25:
        if (r21.e() == false) goto L27;
        r18 = r18 + 1;
        r24 = r8;
        r26 = r9;
        r32 = r7;
        r31 = r13;
        r25 = r4;
        r110 = r5;
        r27 = r14;
        r111 = r6;
        r32[r24] = a(r28, r10, r23, r24, r17, r22);
        goto L35
    L22:
        r23 = r21.b();
        goto L23
    L18:
        r21 = r16[r8];
        goto L19
    L36:
        boolean r210 = r4;
        String r211 = r9;
        ai<?> r33 = r13;
        Map<com.fasterxml.jackson.databind.e.o, com.fasterxml.jackson.databind.e.t[]> r212 = r14;
        v[] r34 = r7;
        com.fasterxml.jackson.databind.e.o r112 = r5;
        int r113 = r6;
        int r35 = r18 + 0;
        if (r18 > 0) goto L40;
        if (r19 > 0) goto L40;
    L52:
        r13 = r33;
        r9 = r211;
        r14 = r212;
    L40:
        if ((r35 + r19) != r113) goto L43;
        r11.a(r112, false, r34);
        goto L52
    L43:
        if (r18 == 0) goto L45;
    L47:
        Object[] r36 = new Object[2];
        if (r20 != null) goto L50;
        int r37 = -1;
    L51:
        r36[0] = Integer.valueOf(r37);
        r36[r210 ? 1 : 0] = r112;
        r28.a(r10, "Argument #%d of factory method %s has no property name annotation; must have name when multiple-parameter constructor annotated as Creator", r36);
        goto L52
    L50:
        r37 = r20.e();
        goto L51
    L45:
        if ((r19 + 1) != r113) goto L47;
        r11.a(r112, false, r34, 0);
        goto L52
    L10:
        a(r11, r5, false, r13.a(r5));
        if (r2 == null) goto L4;
        ((ae) ZeusTransformUtils.preCheckCast(r2, ae.class, r9)).K();
        goto L4
    }

    public void a(com.fasterxml.jackson.databind.h r17, com.fasterxml.jackson.databind.c r18, com.fasterxml.jackson.databind.b.a.e r19, com.fasterxml.jackson.databind.b.a.d r20) {
        int r11 = r20.b();
        v[] r12 = new v[r11];
        int r14 = -1;
        int r15 = 0;
    L4:
        if (r15 >= r11) goto L12;
        com.fasterxml.jackson.databind.e.n r5 = r20.b(r15);
        JacksonInject.Value r6 = r20.a(r15);
        if (r6 == null) goto L8;
        r12[r15] = a(r17, r18, null, r15, r5, r6);
    L11:
        r15 = r15 + 1;
        goto L4
    L8:
        if (r14 >= 0) goto L10;
        r14 = r15;
        goto L11
    L10:
        r17.a(r18, "More than one argument (#%d and #%d) left as delegating for Creator %s: only one allowed", new Object[]{Integer.valueOf(r14), Integer.valueOf(r15), r20});
        goto L11
    L12:
        if (r14 >= 0) goto L14;
        r17.a(r18, "No argument left as delegating for Creator %s: exactly one required", new Object[]{r20});
    L14:
        if (r11 != 1) goto L19;
        a(r19, r20.a(), true, true);
        com.fasterxml.jackson.databind.e.t r0 = r20.c(0);
        if (r0 == null) goto L25;
        ((ae) ZeusTransformUtils.preCheckCast(r0, ae.class, "com.obric.aiagent.plugin")).K();
        return;
    L25:
        return;
    L19:
        r19.a(r20.a(), true, r12, r14);
    }

    public void b(com.fasterxml.jackson.databind.h r18, com.fasterxml.jackson.databind.c r19, com.fasterxml.jackson.databind.b.a.e r20, com.fasterxml.jackson.databind.b.a.d r21) {
        int r8 = r21.b();
        v[] r9 = new v[r8];
        int r15 = 0;
    L3:
        if (r15 >= r8) goto L12;
        JacksonInject.Value r16 = r21.a(r15);
        com.fasterxml.jackson.databind.e.n r14 = r21.b(r15);
        com.fasterxml.jackson.databind.x r0 = r21.d(r15);
        if (r0 != null) goto L11;
        if (r18.f().c(r14) == null) goto L9;
        a(r18, r19, r14);
    L9:
        com.fasterxml.jackson.databind.x r10 = r21.f(r15);
        a(r18, r19, r21, r15, r10, r16);
        r0 = r10;
    L11:
        int r1 = r15;
        r9[r1] = a(r18, r19, r0, r15, r14, r16);
        r15 = r1 + 1;
        goto L3
    L12:
        r20.a(r21.a(), true, r9);
    }

    public void a(com.fasterxml.jackson.databind.h r17, com.fasterxml.jackson.databind.c r18, com.fasterxml.jackson.databind.b.a.e r19, com.fasterxml.jackson.databind.b.a.d r20, com.fasterxml.jackson.databind.a.i r21) {
        if (1 != r20.b()) goto L5;
        com.fasterxml.jackson.databind.e.n r11 = r20.b(0);
        JacksonInject.Value r12 = r20.a(0);
        int r2 = AnonymousClass1.f12364b[r21.a().ordinal()];
        if (r2 != 1) goto L19;
        com.fasterxml.jackson.databind.x r4 = null;
        boolean r3 = false;
    L44:
        if (r3 == false) goto L47;
        r19.a(r20.a(), true, new v[]{a(r17, r18, r4, 0, r11, r12)});
        return;
    L47:
        a(r19, r20.a(), true, true);
        com.fasterxml.jackson.databind.e.t r0 = r20.c(0);
        if (r0 == null) goto L51;
        ((ae) ZeusTransformUtils.preCheckCast(r0, ae.class, "com.obric.aiagent.plugin")).K();
        return;
    L51:
        return;
    L19:
        if (r2 != 2) goto L21;
        com.fasterxml.jackson.databind.x r15 = r20.d(0);
        if (r15 != null) goto L42;
        a(r17, r18, r20, 0, r15, r12);
    L42:
        r3 = true;
        r4 = r15;
        goto L44
    L21:
        if (r2 == 3) goto L37;
        com.fasterxml.jackson.databind.e.t r1 = r20.c(0);
        com.fasterxml.jackson.databind.x r5 = r20.e(0);
        if (r5 != null) goto L27;
        if (r12 != null) goto L27;
        r3 = false;
    L28:
        if (r3 == true) goto L36;
        if (r1 == null) goto L36;
        r5 = r20.d(0);
        if (r5 != null) goto L33;
    L35:
        r3 = false;
        goto L36
    L33:
        if (r1.j() == false) goto L35;
        r3 = true;
    L36:
        r4 = r5;
    L27:
        r3 = true;
        goto L28
    L37:
        r17.a(r18, "Single-argument constructor (%s) is annotated but no 'mode' defined; `CreatorDetector`configured with `SingleArgConstructor.REQUIRE_MODE`", new Object[]{r20.a()});
        return;
    L5:
        if (r21.d() == true) goto L14;
        int r6 = r20.c();
        if (r6 < 0) goto L14;
        if (r21.c() == false) goto L11;
    L12:
        a(r17, r18, r19, r20);
        return;
    L11:
        if (r20.d(r6) == null) goto L12;
    L14:
        b(r17, r18, r19, r20);
    }

    private boolean a(com.fasterxml.jackson.databind.b r2, com.fasterxml.jackson.databind.e.o r3, com.fasterxml.jackson.databind.e.t r4) {
        if (r4 == null) goto L7;
        if (r4.e() == false) goto L7;
    L8:
        return true;
    L7:
        if (r2.e(r3.d(0)) != null) goto L8;
        if (r4 == null) goto L17;
        String r5 = r4.a();
        if (r5 == null) goto L17;
        if (r5.isEmpty() == true) goto L17;
        if (r4.j() == false) goto L17;
        return true;
    L17:
        return false;
    }

    private void a(com.fasterxml.jackson.databind.h r20, com.fasterxml.jackson.databind.c r21, ai<?> r22, com.fasterxml.jackson.databind.b r23, com.fasterxml.jackson.databind.b.a.e r24, List<com.fasterxml.jackson.databind.e.o> r25) {
        ai r0 = (ai) ZeusTransformUtils.wrapperContextForParams(r22, ai.class, "com.obric.aiagent.plugin");
        Iterator r2 = ((List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.aiagent.plugin")).iterator();
        com.fasterxml.jackson.databind.e.o r3 = null;
        com.fasterxml.jackson.databind.e.o r4 = null;
        v[] r5 = null;
    L3:
        int r7 = 0;
        if (r2.hasNext() == false) goto L19;
        com.fasterxml.jackson.databind.e.o r6 = (com.fasterxml.jackson.databind.e.o) ZeusTransformUtils.preCheckCast(r2.next(), com.fasterxml.jackson.databind.e.o.class, "com.obric.aiagent.plugin");
        if (r0.a(r6) == false) goto L3;
        int r8 = r6.e();
        v[] r9 = new v[r8];
        int r10 = 0;
    L9:
        if (r10 >= r8) goto L16;
        com.fasterxml.jackson.databind.e.n r15 = r6.d(r10);
        com.fasterxml.jackson.databind.x r16 = a(r15, r23);
        if (r16 == null) goto L3;
        if (r16.e() == true) goto L3;
        r9[r10] = a(r20, r21, r16, r15.e(), r15, null);
        r10 = r10 + 1;
        goto L9
    L16:
        if (r4 != null) goto L20;
        r4 = r6;
        r5 = r9;
    L20:
        if (r3 == null) goto L27;
        r24.a(r3, false, r5);
        com.fasterxml.jackson.databind.e.r r1 = (com.fasterxml.jackson.databind.e.r) ZeusTransformUtils.preCheckCast(r21, com.fasterxml.jackson.databind.e.r.class, "com.obric.aiagent.plugin");
        int r11 = r5.length;
    L22:
        if (r7 >= r11) goto L40;
        v r12 = r5[r7];
        com.fasterxml.jackson.databind.x r13 = r12.b();
        if (r1.a(r13) == true) goto L26;
        r1.a(com.fasterxml.jackson.databind.l.w.a(r20.c(), r12.d(), r13));
    L26:
        r7 = r7 + 1;
        goto L22
    L40:
        return;
    L27:
        return;
    L19:
        r3 = r4;
        goto L20
    }

    public boolean a(com.fasterxml.jackson.databind.b.a.e r4, com.fasterxml.jackson.databind.e.o r5, boolean r6, boolean r7) {
        Class<?> r0 = r5.a(0);
        if (r0 != String.class) goto L5;
    L57:
        if (r6 == true) goto L59;
        if (r7 == true) goto L59;
    L60:
        return true;
    L59:
        r4.a(r5, r6);
        goto L60
    L5:
        if (r0 == f) goto L57;
        if (r0 != Integer.TYPE) goto L10;
    L53:
        if (r6 == true) goto L55;
        if (r7 == true) goto L55;
    L56:
        return true;
    L55:
        r4.b(r5, r6);
        goto L56
    L10:
        if (r0 == Integer.class) goto L53;
        if (r0 != Long.TYPE) goto L15;
    L49:
        if (r6 == true) goto L51;
        if (r7 == true) goto L51;
    L52:
        return true;
    L51:
        r4.c(r5, r6);
        goto L52
    L15:
        if (r0 == Long.class) goto L49;
        if (r0 != Double.TYPE) goto L20;
    L45:
        if (r6 == true) goto L47;
        if (r7 == true) goto L47;
    L48:
        return true;
    L47:
        r4.e(r5, r6);
        goto L48
    L20:
        if (r0 == Double.class) goto L45;
        if (r0 != Boolean.TYPE) goto L25;
    L41:
        if (r6 == true) goto L43;
        if (r7 == true) goto L43;
    L44:
        return true;
    L43:
        r4.g(r5, r6);
        goto L44
    L25:
        if (r0 == Boolean.class) goto L41;
        if (r0 != BigInteger.class) goto L33;
        if (r6 == true) goto L31;
        if (r7 == false) goto L33;
    L31:
        r4.d(r5, r6);
    L33:
        if (r0 != BigDecimal.class) goto L37;
        if (r6 == true) goto L36;
        if (r7 == false) goto L37;
    L36:
        r4.f(r5, r6);
    L37:
        if (r6 == false) goto L40;
        r4.a(r5, r6, null, 0);
        return true;
    L40:
        return false;
    }

    public void a(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.c r2, com.fasterxml.jackson.databind.b.a.d r3, int r4, com.fasterxml.jackson.databind.x r5, JacksonInject.Value r6) {
        if (r5 != null) goto L6;
        if (r6 != null) goto L7;
        r1.a(r2, "Argument #%d of constructor %s has no property name (and is not Injectable): can not use as property-based Creator", new Object[]{Integer.valueOf(r4), r3});
        return;
    L7:
        return;
    }

    public void a(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.c r3, com.fasterxml.jackson.databind.e.n r4) {
        r2.a(r3, "Cannot define Creator parameter %d as `@JsonUnwrapped`: combination not yet supported", new Object[]{Integer.valueOf(r4.e())});
    }

    public v a(com.fasterxml.jackson.databind.h r16, com.fasterxml.jackson.databind.c r17, com.fasterxml.jackson.databind.x r18, int r19, com.fasterxml.jackson.databind.e.n r20, JacksonInject.Value r21) {
        com.fasterxml.jackson.databind.g r8 = r16.c();
        com.fasterxml.jackson.databind.b r2 = r16.f();
        if (r2 != null) goto L5;
        com.fasterxml.jackson.databind.w r9 = com.fasterxml.jackson.databind.w.f13127c;
        com.fasterxml.jackson.databind.x r5 = null;
    L6:
        com.fasterxml.jackson.databind.k r12 = a(r16, r20, r20.getType());
        com.fasterxml.jackson.databind.d.b r10 = new com.fasterxml.jackson.databind.d.b(r18, r12, r5, r20, r9);
        com.fasterxml.jackson.databind.h.e r3 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r12.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L9;
        r3 = b(r8, r12);
    L9:
        com.fasterxml.jackson.databind.w r14 = a(r16, r10, r9);
        k r4 = k.a(r18, r12, r10.e(), r3, r17.f(), r20, r19, r21, r14);
        com.fasterxml.jackson.databind.l<?> r0 = a(r16, r20);
        if (r0 != null) goto L12;
        r0 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r12.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
    L12:
        if (r0 != null) goto L14;
        return r4;
    L14:
        return r4.a(r16.a(r0, r4, r12));
    L5:
        com.fasterxml.jackson.databind.w r6 = com.fasterxml.jackson.databind.w.a(r2.f(r20), r2.i(r20), r2.j(r20), r2.h(r20));
        r5 = r2.g(r20);
        r9 = r6;
        goto L6
    }

    private com.fasterxml.jackson.databind.x a(com.fasterxml.jackson.databind.e.n r2, com.fasterxml.jackson.databind.b r3) {
        if (r3 == null) goto L14;
        com.fasterxml.jackson.databind.x r1 = r3.B(r2);
        if (r1 != null) goto L6;
    L8:
        String r4 = r3.g(r2);
        if (r4 != null) goto L11;
        return null;
    L11:
        if (r4.isEmpty() == false) goto L13;
        return null;
    L13:
        return com.fasterxml.jackson.databind.x.a(r4);
    L6:
        if (r1.e() == true) goto L8;
        return r1;
    L14:
        return null;
    }

    public com.fasterxml.jackson.databind.w a(com.fasterxml.jackson.databind.h r3, com.fasterxml.jackson.databind.d r4, com.fasterxml.jackson.databind.w r5) {
        com.fasterxml.jackson.databind.d r2 = (com.fasterxml.jackson.databind.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.databind.d.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.b r6 = r3.f();
        com.fasterxml.jackson.databind.g r7 = r3.c();
        com.fasterxml.jackson.databind.e.j r0 = r2.d();
        Nulls r1 = null;
        if (r0 == null) goto L15;
        if (r6 == null) goto L8;
        JsonSetter.Value r8 = r6.D(r0);
        if (r8 == null) goto L8;
        r1 = r8.nonDefaultValueNulls();
        Nulls r9 = r8.nonDefaultContentNulls();
    L9:
        JsonSetter.Value r10 = r7.d(r2.getType().e()).g();
        if (r10 == null) goto L16;
        if (r1 != null) goto L13;
        r1 = r10.nonDefaultValueNulls();
    L13:
        if (r9 != null) goto L16;
        r9 = r10.nonDefaultContentNulls();
    L16:
        JsonSetter.Value r11 = r7.p();
        if (r1 != null) goto L19;
        r1 = r11.nonDefaultValueNulls();
    L19:
        if (r9 != null) goto L21;
        r9 = r11.nonDefaultContentNulls();
    L21:
        if (r1 != null) goto L24;
        if (r9 != null) goto L24;
        return r5;
    L24:
        return r5.a(r1, r9);
    L8:
        r9 = null;
        goto L9
    L15:
        r9 = null;
        goto L16
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.k.a r12, com.fasterxml.jackson.databind.c r13) {
        com.fasterxml.jackson.databind.g r14 = r11.c();
        com.fasterxml.jackson.databind.k r6 = r12.x();
        com.fasterxml.jackson.databind.l<?> r8 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r6.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.e r0 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r6.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
        r0 = b(r14, r6);
    L5:
        com.fasterxml.jackson.databind.h.e r9 = r0;
        com.fasterxml.jackson.databind.l<?> r1 = a(r12, r14, r13, r9, r8);
        if (r1 != null) goto L18;
        if (r8 != null) goto L16;
        Class<?> r2 = r6.e();
        if (r6.o() == false) goto L13;
        return com.fasterxml.jackson.databind.b.b.x.a(r2);
    L13:
        if (r2 != String.class) goto L16;
        return ag.f12392a;
    L16:
        r1 = new com.fasterxml.jackson.databind.b.b.w(r12, r8, r9);
    L18:
        if (this.f12362b.b() == false) goto L23;
        Iterator<g> r10 = this.f12362b.g().iterator();
    L21:
        if (r10.hasNext() == false) goto L23;
        r1 = ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.aiagent.plugin")).a(r14, r12, r13, r1);
    L23:
        return r1;
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r12, com.fasterxml.jackson.databind.k.e r13, com.fasterxml.jackson.databind.c r14) {
        com.fasterxml.jackson.databind.k r0 = r13.x();
        com.fasterxml.jackson.databind.l<?> r1 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.g r2 = r12.c();
        com.fasterxml.jackson.databind.h.e r4 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r0.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = b(r2, r0);
    L5:
        com.fasterxml.jackson.databind.h.e r10 = r4;
        com.fasterxml.jackson.databind.l<?> r5 = a(r13, r2, r14, r10, r1);
        if (r5 != null) goto L12;
        Class<?> r6 = r13.e();
        if (r1 != null) goto L12;
        if (EnumSet.class.isAssignableFrom(r6) == false) goto L12;
        r5 = new com.fasterxml.jackson.databind.b.b.m(r0, null);
    L12:
        if (r5 != null) goto L41;
        if (r13.n() == false) goto L16;
    L17:
        com.fasterxml.jackson.databind.k.e r7 = a(r13, r2);
        if (r7 == null) goto L20;
        r14 = r2.b(r7);
        r13 = r7;
    L25:
        if (r5 != null) goto L41;
        y r8 = a(r12, r14);
        if (r8.k() == true) goto L36;
        if (r13.a(ArrayBlockingQueue.class) == true) goto L31;
        com.fasterxml.jackson.databind.l<?> r15 = com.fasterxml.jackson.databind.b.a.l.a(r12, r13);
        if (r15 == null) goto L36;
        return r15;
    L31:
        return new com.fasterxml.jackson.databind.b.b.a(r13, r1, r10, r8);
    L36:
        if (r0.a(String.class) == false) goto L38;
        com.fasterxml.jackson.databind.l<?> r16 = new ah(r13, r1, r8);
    L39:
        r5 = r16;
        goto L41
    L38:
        r16 = new com.fasterxml.jackson.databind.b.b.h(r13, r1, r10, r8);
        goto L39
    L20:
        if (r13.E() == null) goto L23;
        r5 = com.fasterxml.jackson.databind.b.a.a(r14);
        goto L25
    L23:
        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Collection type " + r13);
    L16:
        if (r13.g() == false) goto L25;
    L41:
        if (this.f12362b.b() == false) goto L46;
        Iterator<g> r11 = this.f12362b.g().iterator();
    L44:
        if (r11.hasNext() == false) goto L46;
        r5 = ((g) ZeusTransformUtils.preCheckCast(r11.next(), g.class, "com.obric.aiagent.plugin")).a(r2, r13, r14, r5);
    L46:
        return r5;
    }

    public com.fasterxml.jackson.databind.k.e a(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.g r3) {
        Class<?> r1 = a.a(r2);
        if (r1 != null) goto L5;
        return null;
    L5:
        return (com.fasterxml.jackson.databind.k.e) ZeusTransformUtils.preCheckCast(r3.o().a(r2, r1, true), com.fasterxml.jackson.databind.k.e.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.k.d r12, com.fasterxml.jackson.databind.c r13) {
        com.fasterxml.jackson.databind.k r0 = r12.x();
        com.fasterxml.jackson.databind.l<?> r9 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.g r14 = r11.c();
        com.fasterxml.jackson.databind.h.e r1 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r0.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.h.e r8 = b(r14, r0);
    L6:
        com.fasterxml.jackson.databind.l<?> r2 = a(r12, r14, r13, r8, r9);
        if (r2 != null) goto L9;
    L14:
        return r2;
    L9:
        if (this.f12362b.b() == false) goto L14;
        Iterator<g> r10 = this.f12362b.g().iterator();
    L12:
        if (r10.hasNext() == false) goto L14;
        r2 = ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.aiagent.plugin")).a(r14, r12, r13, r2);
        goto L12
    L5:
        r8 = r1;
        goto L6
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r21, com.fasterxml.jackson.databind.k.h r22, com.fasterxml.jackson.databind.c r23) {
        com.fasterxml.jackson.databind.g r10 = r21.c();
        com.fasterxml.jackson.databind.k r11 = r22.w();
        com.fasterxml.jackson.databind.k r0 = r22.x();
        com.fasterxml.jackson.databind.l<?> r17 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r16 = (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r11.D(), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.e r1 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r0.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L5;
        com.fasterxml.jackson.databind.h.e r18 = b(r10, r0);
    L6:
        com.fasterxml.jackson.databind.l<?> r2 = a(r22, r10, r23, r16, r18, r17);
        if (r2 != null) goto L51;
        Class<?> r3 = r22.e();
        Set<String> r19 = null;
        if (EnumMap.class.isAssignableFrom(r3) == true) goto L11;
        com.fasterxml.jackson.databind.c r13 = r23;
        r2 = r2;
    L20:
        if (r2 == null) goto L22;
    L52:
        com.fasterxml.jackson.databind.k.h r4 = r22;
        com.fasterxml.jackson.databind.l<?> r5 = r2;
    L54:
        if (this.f12362b.b() == false) goto L59;
        Iterator<g> r6 = this.f12362b.g().iterator();
        r5 = r5;
    L57:
        if (r6.hasNext() == false) goto L59;
        r5 = ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).a(r10, r4, r13, r5);
    L59:
        return r5;
    L22:
        if (r22.n() == false) goto L24;
    L31:
        r4 = b(r22, r10);
        if (r4 == null) goto L35;
        r4.e();
        r13 = r10.b(r4);
        com.fasterxml.jackson.databind.l<?> r7 = r2;
    L37:
        com.fasterxml.jackson.databind.l<?> r8 = r7;
    L30:
        com.fasterxml.jackson.databind.c r9 = r13;
        com.fasterxml.jackson.databind.l<?> r12 = r8;
        if (r8 != null) goto L48;
        com.fasterxml.jackson.databind.b.b.s r14 = new com.fasterxml.jackson.databind.b.b.s(r4, a(r21, r9), r16, r17, r18);
        JsonIgnoreProperties.Value r15 = r10.b(Map.class, r9.c());
        if (r15 != null) goto L42;
        Set<String> r20 = null;
    L43:
        r14.a(r20);
        JsonIncludeProperties.Value r24 = r10.c(Map.class, r9.c());
        if (r24 == null) goto L47;
        r19 = r24.getIncluded();
    L47:
        r14.b(r19);
        r12 = r14;
        goto L48
    L42:
        r20 = r15.findIgnoredForDeserialization();
    L48:
        r13 = r9;
        r5 = r12;
        goto L54
    L35:
        if (r22.E() == null) goto L50;
        r4 = r22;
        r7 = com.fasterxml.jackson.databind.b.a.a(r23);
        goto L37
    L50:
        throw new IllegalArgumentException("Cannot find a deserializer for non-concrete Map type " + r22);
    L24:
        if (r22.g() == true) goto L31;
        com.fasterxml.jackson.databind.l<?> r25 = com.fasterxml.jackson.databind.b.a.l.b(r21, r22);
        if (r25 == null) goto L29;
        return r25;
    L29:
        r8 = r25;
        r4 = r22;
        goto L30
    L11:
        if (r3 != EnumMap.class) goto L13;
        r13 = r23;
        y r26 = null;
    L15:
        if (r11.l() == false) goto L18;
        r2 = new com.fasterxml.jackson.databind.b.b.l(r22, r26, null, r17, r18, null);
        goto L20
    L18:
        throw new IllegalArgumentException("Cannot construct EnumMap; generic (key) type not available");
    L13:
        r13 = r23;
        r26 = a(r21, r13);
        goto L15
    L51:
        r13 = r23;
        goto L52
    L5:
        r18 = r1;
        goto L6
    }

    public com.fasterxml.jackson.databind.k.h b(com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.g r3) {
        Class<?> r1 = a.b(r2);
        if (r1 != null) goto L5;
        return null;
    L5:
        return (com.fasterxml.jackson.databind.k.h) ZeusTransformUtils.preCheckCast(r3.o().a(r2, r1, true), com.fasterxml.jackson.databind.k.h.class, "com.obric.aiagent.plugin");
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.k.g r12, com.fasterxml.jackson.databind.c r13) {
        com.fasterxml.jackson.databind.k r0 = r12.w();
        com.fasterxml.jackson.databind.k r1 = r12.x();
        com.fasterxml.jackson.databind.g r14 = r11.c();
        com.fasterxml.jackson.databind.l<?> r8 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r1.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.q r6 = (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.h.e r2 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r1.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L5;
        r2 = b(r14, r1);
    L5:
        com.fasterxml.jackson.databind.l<?> r3 = a(r12, r14, r13, r6, r2, r8);
        if (r3 != null) goto L8;
    L13:
        return r3;
    L8:
        if (this.f12362b.b() == false) goto L13;
        Iterator<g> r10 = this.f12362b.g().iterator();
    L11:
        if (r10.hasNext() == false) goto L13;
        r3 = ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.aiagent.plugin")).a(r14, r12, r13, r3);
        goto L11
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r10, com.fasterxml.jackson.databind.k r11, com.fasterxml.jackson.databind.c r12) {
        com.fasterxml.jackson.databind.g r0 = r10.c();
        Class<?> r1 = r11.e();
        com.fasterxml.jackson.databind.l<?> r2 = b(r1, r0, r12);
        if (r2 != null) goto L28;
        if (r1 == Enum.class) goto L7;
        y r4 = b(r10, r12);
        if (r4 != null) goto L11;
        v[] r5 = null;
    L12:
        Iterator<com.fasterxml.jackson.databind.e.k> r6 = r12.l().iterator();
    L14:
        if (r6.hasNext() == false) goto L25;
        com.fasterxml.jackson.databind.e.k r7 = (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r6.next(), com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
        if (d(r10, r7) == false) goto L14;
        if (r7.e() != 0) goto L22;
        com.fasterxml.jackson.databind.l<?> r13 = com.fasterxml.jackson.databind.b.b.k.a(r0, r1, r7);
    L20:
        r2 = r13;
        goto L25
    L22:
        if (r7.l().isAssignableFrom(r1) == true) goto L24;
        r10.b(r11, String.format("Invalid `@JsonCreator` annotated Enum factory method [%s]: needs to return compatible type", new Object[]{r7.toString()}));
    L24:
        r13 = com.fasterxml.jackson.databind.b.b.k.a(r0, r1, r7, r4, r5);
    L25:
        if (r2 != null) goto L28;
        r2 = new com.fasterxml.jackson.databind.b.b.k(a(r1, r0, r12.p()), Boolean.valueOf(r0.a(com.fasterxml.jackson.databind.r.w)));
        goto L28
    L11:
        r5 = r4.a(r10.c());
        goto L12
    L7:
        return com.fasterxml.jackson.databind.b.a.a(r12);
    L28:
        if (this.f12362b.b() == false) goto L33;
        Iterator<g> r9 = this.f12362b.g().iterator();
    L31:
        if (r9.hasNext() == false) goto L33;
        r2 = ((g) ZeusTransformUtils.preCheckCast(r9.next(), g.class, "com.obric.aiagent.plugin")).a(r0, r11, r12, r2);
    L33:
        return r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.g r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3) {
        Class<?> r4 = r2.e();
        com.fasterxml.jackson.databind.l<?> r0 = a(r4, r1, r3);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return com.fasterxml.jackson.databind.b.b.r.a(r4);
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.h r11, com.fasterxml.jackson.databind.k.j r12, com.fasterxml.jackson.databind.c r13) {
        com.fasterxml.jackson.databind.k r0 = r12.x();
        com.fasterxml.jackson.databind.l<?> r1 = (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r0.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin");
        com.fasterxml.jackson.databind.g r2 = r11.c();
        com.fasterxml.jackson.databind.h.e r4 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r0.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r4 != null) goto L5;
        r4 = b(r2, r0);
    L5:
        com.fasterxml.jackson.databind.h.e r3 = r4;
        com.fasterxml.jackson.databind.l<?> r5 = a(r12, r2, r13, r3, r1);
        if (r5 == null) goto L8;
    L15:
        if (r5 != null) goto L17;
    L22:
        return r5;
    L17:
        if (this.f12362b.b() == false) goto L22;
        Iterator<g> r10 = this.f12362b.g().iterator();
    L20:
        if (r10.hasNext() == false) goto L22;
        r5 = ((g) ZeusTransformUtils.preCheckCast(r10.next(), g.class, "com.obric.aiagent.plugin")).a(r2, r12, r13, r5);
        goto L20
    L8:
        if (r12.b(AtomicReference.class) == false) goto L15;
        if (r12.e() != AtomicReference.class) goto L12;
        y r14 = null;
    L14:
        return new com.fasterxml.jackson.databind.b.b.e(r12, r14, r3, r1);
    L12:
        r14 = a(r11, r13);
        goto L14
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.h.e b(com.fasterxml.jackson.databind.g r5, com.fasterxml.jackson.databind.k r6) {
        com.fasterxml.jackson.databind.e.d r0 = r5.c(r6.e()).c();
        com.fasterxml.jackson.databind.h.g<?> r1 = r5.j().a(r5, r0, r6);
        if (r1 != null) goto L8;
        r1 = r5.d(r6);
        if (r1 != null) goto L7;
        return null;
    L7:
        Collection<com.fasterxml.jackson.databind.h.b> r2 = null;
    L10:
        if (r1.a() == null) goto L12;
    L23:
        return r1.a(r5, r6, r2);
    L20:
        e = move-exception;
        throw com.fasterxml.jackson.databind.c.b.a((com.fasterxml.jackson.a.k) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.a.k.class, "com.obric.aiagent.plugin"), com.fasterxml.jackson.databind.l.h.h(e), r6).a(e);
    L12:
        if (r6.g() == false) goto L23;
        com.fasterxml.jackson.databind.k r4 = a(r5, r6);
        if (r4 == null) goto L23;
        if (r4.a(r6.e()) == true) goto L23;
        r1 = r1.b(r4.e());
        goto L23
    L8:
        r2 = r5.v().b(r5, r0);
        goto L10
    }

    public com.fasterxml.jackson.databind.l<?> b(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.k r2, com.fasterxml.jackson.databind.c r3) {
        return com.fasterxml.jackson.databind.d.c.f12564a.a(r2, r1.c(), r3);
    }

    @Override // com.fasterxml.jackson.databind.b.p
    public com.fasterxml.jackson.databind.q a(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.k r8) {
        com.fasterxml.jackson.databind.g r0 = r7.c();
        com.fasterxml.jackson.databind.q r3 = null;
        if (this.f12362b.a() == false) goto L10;
        com.fasterxml.jackson.databind.c r1 = r0.e(r8);
        Iterator<r> r4 = this.f12362b.f().iterator();
    L6:
        if (r4.hasNext() == false) goto L11;
        r3 = ((r) ZeusTransformUtils.preCheckCast(r4.next(), r.class, "com.obric.aiagent.plugin")).a(r8, r0, r1);
        if (r3 == null) goto L6;
    L11:
        if (r3 != null) goto L20;
        if (r1 != null) goto L14;
        r1 = r0.c(r8.e());
    L14:
        r3 = b(r7, r1.c());
        if (r3 != null) goto L20;
        if (r8.k() == false) goto L19;
        r3 = b(r7, r8);
        goto L20
    L19:
        r3 = ad.a(r0, r8);
    L20:
        if (r3 != null) goto L22;
    L27:
        return r3;
    L22:
        if (this.f12362b.b() == false) goto L27;
        Iterator<g> r6 = this.f12362b.g().iterator();
    L25:
        if (r6.hasNext() == false) goto L27;
        r3 = ((g) ZeusTransformUtils.preCheckCast(r6.next(), g.class, "com.obric.aiagent.plugin")).a(r0, r8, r3);
        goto L25
    L10:
        r1 = null;
        goto L11
    }

    private com.fasterxml.jackson.databind.q b(com.fasterxml.jackson.databind.h r7, com.fasterxml.jackson.databind.k r8) {
        com.fasterxml.jackson.databind.g r0 = r7.c();
        Class<?> r1 = r8.e();
        com.fasterxml.jackson.databind.c r2 = r0.a(r8);
        com.fasterxml.jackson.databind.q r3 = b(r7, r2.c());
        if (r3 == null) goto L5;
        return r3;
    L5:
        com.fasterxml.jackson.databind.l<?> r4 = b(r1, r0, r2);
        if (r4 != null) goto L8;
        com.fasterxml.jackson.databind.l<Object> r5 = a(r7, r2.c());
        if (r5 != null) goto L12;
        com.fasterxml.jackson.databind.l.k r9 = a(r1, r0, r2.p());
        Iterator<com.fasterxml.jackson.databind.e.k> r6 = r2.l().iterator();
    L15:
        if (r6.hasNext() == false) goto L33;
        com.fasterxml.jackson.databind.e.k r10 = (com.fasterxml.jackson.databind.e.k) ZeusTransformUtils.preCheckCast(r6.next(), com.fasterxml.jackson.databind.e.k.class, "com.obric.aiagent.plugin");
        if (d(r7, r10) == false) goto L15;
        if (r10.e() != 1) goto L31;
        if (r10.l().isAssignableFrom(r1) == false) goto L31;
        if (r10.a(0) != String.class) goto L15;
        if (r0.g() == false) goto L29;
        com.fasterxml.jackson.databind.l.h.a(r10.h(), r7.a(com.fasterxml.jackson.databind.r.o));
    L29:
        return ad.a(r9, r10);
    L31:
        throw new IllegalArgumentException("Unsuitable method (" + r10 + ") decorated with @JsonCreator (for Enum type " + r1.getName() + ")");
    L33:
        return ad.a(r9);
    L12:
        return ad.a(r0, r8, r5);
    L8:
        return ad.a(r0, r8, r4);
    }

    public com.fasterxml.jackson.databind.h.e a(com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.e.j r4) {
        com.fasterxml.jackson.databind.h.g<?> r0 = r2.j().a(r2, r4, r3);
        if (r0 != null) goto L12;
        return b(r2, r3);
    L12:
        return r0.a(r2, r3, r2.v().b(r2, r4, r3));
    L9:
        e = move-exception;
        throw com.fasterxml.jackson.databind.c.b.a((com.fasterxml.jackson.a.k) ZeusTransformUtils.preCheckCast(null, com.fasterxml.jackson.a.k.class, "com.obric.aiagent.plugin"), com.fasterxml.jackson.databind.l.h.h(e), r3).a(e);
    }

    public com.fasterxml.jackson.databind.h.e b(com.fasterxml.jackson.databind.g r2, com.fasterxml.jackson.databind.k r3, com.fasterxml.jackson.databind.e.j r4) {
        com.fasterxml.jackson.databind.h.g<?> r0 = r2.j().b(r2, r4, r3);
        com.fasterxml.jackson.databind.k r5 = r3.x();
        if (r0 != null) goto L7;
        return b(r2, r5);
    L7:
        return r0.a(r2, r5, r2.v().b(r2, r4, r5));
    }

    public com.fasterxml.jackson.databind.l<?> c(com.fasterxml.jackson.databind.h r5, com.fasterxml.jackson.databind.k r6, com.fasterxml.jackson.databind.c r7) {
        Class<?> r0 = r6.e();
        if (r0 != f12360c) goto L5;
    L50:
        com.fasterxml.jackson.databind.g r8 = r5.c();
        if (this.f12362b.c() == false) goto L53;
        com.fasterxml.jackson.databind.k r9 = a(r8, List.class);
        com.fasterxml.jackson.databind.k r4 = a(r8, Map.class);
    L55:
        return new am(r9, r4);
    L53:
        r9 = null;
        r4 = null;
        goto L55
    L5:
        if (r0 == i) goto L50;
        if (r0 == f12361e) goto L49;
        if (r0 == f) goto L49;
        Class<?> r1 = g;
        if (r0 != r1) goto L24;
        com.fasterxml.jackson.databind.k.o r2 = r5.b();
        com.fasterxml.jackson.databind.k[] r10 = r2.c(r6, r1);
        if (r10 != null) goto L17;
    L20:
        com.fasterxml.jackson.databind.k r11 = com.fasterxml.jackson.databind.k.o.c();
    L22:
        return a(r5, r2.a(Collection.class, r11), r7);
    L17:
        if (r10.length != 1) goto L20;
        r11 = r10[0];
        goto L22
    L24:
        if (r0 != h) goto L30;
        com.fasterxml.jackson.databind.k r12 = r6.b(0);
        com.fasterxml.jackson.databind.k r3 = r6.b(1);
        com.fasterxml.jackson.databind.h.e r13 = (com.fasterxml.jackson.databind.h.e) ZeusTransformUtils.preCheckCast(r3.E(), com.fasterxml.jackson.databind.h.e.class, "com.obric.aiagent.plugin");
        if (r13 != null) goto L29;
        r13 = b(r5.c(), r3);
    L29:
        return new com.fasterxml.jackson.databind.b.b.t(r6, (com.fasterxml.jackson.databind.q) ZeusTransformUtils.preCheckCast(r12.D(), com.fasterxml.jackson.databind.q.class, "com.obric.aiagent.plugin"), (com.fasterxml.jackson.databind.l) ZeusTransformUtils.preCheckCast(r3.D(), com.fasterxml.jackson.databind.l.class, "com.obric.aiagent.plugin"), r13);
    L30:
        String r14 = r0.getName();
        if (r0.isPrimitive() == false) goto L33;
    L34:
        com.fasterxml.jackson.databind.l<?> r15 = com.fasterxml.jackson.databind.b.b.v.a(r0, r14);
        if (r15 != null) goto L37;
        r15 = com.fasterxml.jackson.databind.b.b.j.a(r0, r14);
    L37:
        if (r15 == null) goto L40;
        return r15;
    L40:
        if (r0 == com.fasterxml.jackson.databind.l.y.class) goto L42;
        com.fasterxml.jackson.databind.l<?> r16 = b(r5, r6, r7);
        if (r16 == null) goto L47;
        return r16;
    L47:
        return com.fasterxml.jackson.databind.b.b.p.a(r0, r14);
    L42:
        return new ak();
    L33:
        if (r14.startsWith("java.") == false) goto L40;
    L49:
        return com.fasterxml.jackson.databind.b.b.ai.f12400a;
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.g r2, Class<?> r3) {
        com.fasterxml.jackson.databind.k r1 = a(r2, r2.b(r3));
        if (r1 != null) goto L5;
    L6:
        return null;
    L5:
        if (r1.a(r3) == true) goto L6;
        return r1;
    }

    public com.fasterxml.jackson.databind.l<?> a(Class<? extends com.fasterxml.jackson.databind.n> r4, com.fasterxml.jackson.databind.g r5, com.fasterxml.jackson.databind.c r6) {
        Iterator<q> r3 = this.f12362b.e().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin")).b(r4, r5, r6);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.j r8, com.fasterxml.jackson.databind.g r9, com.fasterxml.jackson.databind.c r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.l<?> r12) {
        Iterator<q> r7 = this.f12362b.e().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r7.next(), q.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.k r4, com.fasterxml.jackson.databind.g r5, com.fasterxml.jackson.databind.c r6) {
        Iterator<q> r3 = this.f12362b.e().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin")).a(r4, r5, r6);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.a r8, com.fasterxml.jackson.databind.g r9, com.fasterxml.jackson.databind.c r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.l<?> r12) {
        Iterator<q> r7 = this.f12362b.e().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r7.next(), q.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.e r8, com.fasterxml.jackson.databind.g r9, com.fasterxml.jackson.databind.c r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.l<?> r12) {
        Iterator<q> r7 = this.f12362b.e().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r7.next(), q.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.d r8, com.fasterxml.jackson.databind.g r9, com.fasterxml.jackson.databind.c r10, com.fasterxml.jackson.databind.h.e r11, com.fasterxml.jackson.databind.l<?> r12) {
        Iterator<q> r7 = this.f12362b.e().iterator();
    L4:
        if (r7.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r7.next(), q.class, "com.obric.aiagent.plugin")).a(r8, r9, r10, r11, r12);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> b(Class<?> r4, com.fasterxml.jackson.databind.g r5, com.fasterxml.jackson.databind.c r6) {
        Iterator<q> r3 = this.f12362b.e().iterator();
    L4:
        if (r3.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r3.next(), q.class, "com.obric.aiagent.plugin")).a(r4, r5, r6);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.h r9, com.fasterxml.jackson.databind.g r10, com.fasterxml.jackson.databind.c r11, com.fasterxml.jackson.databind.q r12, com.fasterxml.jackson.databind.h.e r13, com.fasterxml.jackson.databind.l<?> r14) {
        Iterator<q> r8 = this.f12362b.e().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r8.next(), q.class, "com.obric.aiagent.plugin")).a(r9, r10, r11, r12, r13, r14);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<?> a(com.fasterxml.jackson.databind.k.g r9, com.fasterxml.jackson.databind.g r10, com.fasterxml.jackson.databind.c r11, com.fasterxml.jackson.databind.q r12, com.fasterxml.jackson.databind.h.e r13, com.fasterxml.jackson.databind.l<?> r14) {
        Iterator<q> r8 = this.f12362b.e().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        com.fasterxml.jackson.databind.l<?> r0 = ((q) ZeusTransformUtils.preCheckCast(r8.next(), q.class, "com.obric.aiagent.plugin")).a(r9, r10, r11, r12, r13, r14);
        if (r0 == null) goto L4;
        return r0;
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<Object> a(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.e.b r2) {
        com.fasterxml.jackson.databind.b r0 = r1.f();
        if (r0 == null) goto L8;
        Object r3 = r0.x(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r1.b(r2, r3);
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.q b(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.e.b r2) {
        com.fasterxml.jackson.databind.b r0 = r1.f();
        if (r0 == null) goto L8;
        Object r3 = r0.y(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r1.c(r2, r3);
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.l<Object> c(com.fasterxml.jackson.databind.h r1, com.fasterxml.jackson.databind.e.b r2) {
        com.fasterxml.jackson.databind.b r0 = r1.f();
        if (r0 == null) goto L8;
        Object r3 = r0.z(r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return r1.b(r2, r3);
    L8:
        return null;
    }

    public com.fasterxml.jackson.databind.k a(com.fasterxml.jackson.databind.h r5, com.fasterxml.jackson.databind.e.j r6, com.fasterxml.jackson.databind.k r7) {
        com.fasterxml.jackson.databind.b r0 = r5.f();
        if (r0 != null) goto L6;
        return r7;
    L6:
        if (r7.s() == false) goto L13;
        if (r7.w() == null) goto L13;
        com.fasterxml.jackson.databind.q r1 = r5.c(r6, r0.y(r6));
        if (r1 == null) goto L13;
        r7 = ((com.fasterxml.jackson.databind.k.g) ZeusTransformUtils.preCheckCast(r7, com.fasterxml.jackson.databind.k.g.class, "com.obric.aiagent.plugin")).i(r1);
        r7.w();
    L13:
        if (r7.f() == false) goto L20;
        com.fasterxml.jackson.databind.l<Object> r2 = r5.b(r6, r0.z(r6));
        if (r2 == null) goto L17;
        r7 = r7.d(r2);
    L17:
        com.fasterxml.jackson.databind.h.e r3 = b(r5.c(), r7, r6);
        if (r3 == null) goto L20;
        r7 = r7.b(r3);
    L20:
        com.fasterxml.jackson.databind.h.e r4 = a(r5.c(), r7, r6);
        if (r4 == null) goto L24;
        r7 = r7.a(r4);
    L24:
        return r0.b(r5.c(), r6, r7);
    }

    public com.fasterxml.jackson.databind.l.k a(Class<?> r2, com.fasterxml.jackson.databind.g r3, com.fasterxml.jackson.databind.e.j r4) {
        if (r4 == null) goto L9;
        if (r3.g() == false) goto L7;
        com.fasterxml.jackson.databind.l.h.a(r4.g(), r3.a(com.fasterxml.jackson.databind.r.o));
    L7:
        return com.fasterxml.jackson.databind.l.k.a(r3, r2, r4);
    L9:
        return com.fasterxml.jackson.databind.l.k.a(r3, r2);
    }

    public boolean d(com.fasterxml.jackson.databind.h r2, com.fasterxml.jackson.databind.e.b r3) {
        com.fasterxml.jackson.databind.b r1 = r2.f();
        if (r1 == null) goto L10;
        JsonCreator.Mode r4 = r1.d(r2.c(), r3);
        if (r4 != null) goto L7;
        return false;
    L7:
        if (r4 == JsonCreator.Mode.DISABLED) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }
}
