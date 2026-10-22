package com.bytedance.retrofit2;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Retrofit.java */
/* JADX INFO: loaded from: classes.dex */
public final class ab {
    private static volatile CopyOnWriteArrayList<com.bytedance.retrofit2.d.b> k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<Method, ag<?>> f9389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<Method, Object> f9390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bytedance.retrofit2.b.a.InterfaceC0216a f9391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final k f9392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<i.a> f9393e;
    private final List<f.a> f;
    private final Executor g;
    private final boolean h;
    private final Executor i;
    private final List<com.bytedance.retrofit2.d.b> j;
    private final com.bytedance.retrofit2.a.a l;

    /* JADX INFO: compiled from: Retrofit.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f9398a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y f9399b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.bytedance.retrofit2.b.a.InterfaceC0216a f9400c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private k f9401d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final List<com.bytedance.retrofit2.d.b> f9402e;
        private final List<i.a> f;
        private final List<f.a> g;
        private Executor h;
        private Executor i;
        private boolean j;
        private com.bytedance.retrofit2.a.a k;

        static {
            f9398a = true;
        }

        a(y r2) {
            this.f9402e = new CopyOnWriteArrayList();
            this.f = new ArrayList();
            this.g = new ArrayList();
            this.f9399b = r2;
        }

        public a() {
            this(y.a());
        }

        public a a(com.bytedance.retrofit2.b.a.InterfaceC0216a r3) {
            return b((com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin"), "provider == null"), com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin"));
        }

        public a b(com.bytedance.retrofit2.b.a.InterfaceC0216a r3) {
            this.f9400c = (com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin"), "provider == null"), com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin");
            return this;
        }

        public a a(com.bytedance.retrofit2.d.b r3) {
            com.bytedance.retrofit2.d.b r4 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(an.a((com.bytedance.retrofit2.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin"), "interceptor == null"), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
            this.f9402e.add(r4);
            return this;
        }

        public a a(String r2) {
            if (r2 == null) goto L8;
            if (r2.trim().length() == 0) goto L8;
            this.f9401d = l.a(r2);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }

        public a a(i.a r4) {
            this.f.add((i.a) ZeusTransformUtils.preCheckCast(an.a(r4, "factory == null"), i.a.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public a a(f.a r4) {
            this.g.add((f.a) ZeusTransformUtils.preCheckCast(an.a(r4, "factory == null"), f.a.class, "com.obric.aiagent.plugin"));
            return this;
        }

        public a a(Executor r3) {
            this.h = (Executor) ZeusTransformUtils.preCheckCast(an.a((Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.aiagent.plugin"), "httpExecutor == null"), Executor.class, "com.obric.aiagent.plugin");
            return this;
        }

        public ab a() {
            if (this.f9401d == null) goto L32;
            if (this.f9400c == null) goto L30;
            if (this.h == null) goto L28;
            Executor r0 = this.i;
            if (r0 != null) goto L11;
            r0 = this.f9399b.c();
        L11:
            Executor r8 = r0;
            ArrayList r6 = new ArrayList(this.g);
            r6.addAll(this.f9399b.a(r8));
            ArrayList r5 = new ArrayList((this.f.size() + 1) + this.f9399b.e());
            r5.add(new d());
            r5.addAll(this.f);
            r5.addAll(this.f9399b.d());
            if (ab.f() == null) goto L20;
            Iterator r1 = ab.f().iterator();
        L15:
            if (r1.hasNext() == false) goto L20;
            com.bytedance.retrofit2.d.b r2 = (com.bytedance.retrofit2.d.b) ZeusTransformUtils.preCheckCast(r1.next(), com.bytedance.retrofit2.d.b.class, "com.obric.aiagent.plugin");
            if (this.f9402e.contains(r2) == true) goto L15;
            this.f9402e.add(r2);
        L20:
            if (f9398a == true) goto L26;
            if (r8 != null) goto L26;
            throw new AssertionError();
        L26:
            return new ab(this.f9401d, this.f9400c, this.f9402e, r5, r6, this.h, r8, this.j, this.k);
        L28:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L30:
            throw new IllegalStateException("ClientProvider may not be null.");
        L32:
            throw new IllegalStateException("Endpoint may not be null.");
        }
    }

    static /* synthetic */ CopyOnWriteArrayList f() {
        return k;
    }

    ab(k r3, com.bytedance.retrofit2.b.a.InterfaceC0216a r4, List<com.bytedance.retrofit2.d.b> r5, List<i.a> r6, List<f.a> r7, Executor r8, Executor r9, boolean r10, com.bytedance.retrofit2.a.a r11) {
        k r12 = (k) ZeusTransformUtils.wrapperContextForParams(r3, k.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.b.a.InterfaceC0216a r13 = (com.bytedance.retrofit2.b.a.InterfaceC0216a) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.retrofit2.b.a.InterfaceC0216a.class, "com.obric.aiagent.plugin");
        List<com.bytedance.retrofit2.d.b> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.aiagent.plugin");
        List r16 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.aiagent.plugin");
        Executor r17 = (Executor) ZeusTransformUtils.wrapperContextForParams(r8, Executor.class, "com.obric.aiagent.plugin");
        Executor r18 = (Executor) ZeusTransformUtils.wrapperContextForParams(r9, Executor.class, "com.obric.aiagent.plugin");
        com.bytedance.retrofit2.a.a r19 = (com.bytedance.retrofit2.a.a) ZeusTransformUtils.wrapperContextForParams(r11, com.bytedance.retrofit2.a.a.class, "com.obric.aiagent.plugin");
        this.f9389a = new ConcurrentHashMap();
        this.f9390b = new ConcurrentHashMap();
        this.f9392d = r12;
        this.f9391c = r13;
        this.j = r14;
        this.f9393e = Collections.unmodifiableList(r15);
        this.f = Collections.unmodifiableList(r16);
        this.i = r17;
        this.g = r18;
        this.h = r10;
        this.l = r19;
    }

    public static void a(CopyOnWriteArrayList<com.bytedance.retrofit2.d.b> r0) {
        k = r0;
    }

    public <T> T a(final Class<T> r4) {
        an.a(r4);
        if (this.h == false) goto L6;
        b(r4);
    L6:
        return (T) Proxy.newProxyInstance(r4.getClassLoader(), new Class[]{r4}, new AnonymousClass1(this, r4));
    }

    private void b(Class<?> r6) {
        y r0 = y.a();
        Method[] r7 = r6.getDeclaredMethods();
        int r1 = r7.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L10;
        Method r3 = r7[r2];
        if (r0.a(r3) == true) goto L9;
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L9;
        a(r3);
    L9:
        r2 = r2 + 1;
        goto L3
    }

    ag<?> a(Method r5) {
        if (ac.a() == true) goto L5;
        ag<?> r0 = (ag) ZeusTransformUtils.preCheckCast(this.f9389a.get(r5), ag.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
        Map<Method, ag<?>> r1 = this.f9389a;
        monitor-enter(r1);
        ag<?> r2 = (ag) ZeusTransformUtils.preCheckCast(this.f9389a.get(r5), ag.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L19
        if (r2 != null) goto L17;
        af r3 = new af();     // Catch: Throwable -> L19
        r3.a(false);     // Catch: Throwable -> L19
        r2 = ag.a(this, r5, r3);     // Catch: Throwable -> L19
        this.f9389a.put(r5, r2);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r2;
    L19:
        th = move-exception;
        throw th;
    L9:
        if (ZeusTransformUtils.instanceOf(r0, p.class) == false) goto L11;
        af r4 = new af();
        r4.a(true);
        ((p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.aiagent.plugin")).f9575a.a(r4);
    L11:
        return r0;
    L5:
        return b(r5);
    }

    ag<?> b(Method r4) {
        Object r0 = this.f9390b.get(r4);
        if (ZeusTransformUtils.instanceOf(r0, ag.class) == true) goto L5;
        if (r0 != null) goto L22;
        Object r1 = new Object();
        monitor-enter(r1);
        r0 = this.f9390b.putIfAbsent(r4, r1);     // Catch: Throwable -> L19
        if (r0 != null) goto L17;
        af r2 = new af();     // Catch: Throwable -> L19
        r2.a(false);     // Catch: Throwable -> L19
        ag<?> r3 = ag.a(this, r4, r2);     // Catch: Throwable -> L19
        this.f9390b.put(r4, r3);     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        return r3;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    L22:
        monitor-enter(r0);
        ag<?> r5 = (ag) ZeusTransformUtils.preCheckCast(this.f9390b.get(r4), ag.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return r5;
    L26:
        th = move-exception;
        throw th;
    L5:
        if (ZeusTransformUtils.instanceOf(r0, p.class) == false) goto L8;
        af r6 = new af();
        r6.a(true);
        ((p) ZeusTransformUtils.preCheckCast(r0, p.class, "com.obric.aiagent.plugin")).f9575a.a(r6);
    L8:
        return (ag) ZeusTransformUtils.preCheckCast(r0, ag.class, "com.obric.aiagent.plugin");
    }

    public com.bytedance.retrofit2.b.a.InterfaceC0216a a() {
        return this.f9391c;
    }

    public Executor b() {
        return this.i;
    }

    public List<com.bytedance.retrofit2.d.b> c() {
        return this.j;
    }

    public com.bytedance.retrofit2.a.a d() {
        return this.l;
    }

    public k e() {
        return this.f9392d;
    }

    public f<?, ?> a(Type r3, Annotation[] r4) {
        return a(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin"), r4);
    }

    public f<?, ?> a(f.a r7, Type r8, Annotation[] r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        an.a(r10, "returnType == null");
        an.a(r9, "annotations == null");
        int r0 = this.f.indexOf(r7) + 1;
        int r2 = this.f.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        f<?, ?> r4 = ((f.a) ZeusTransformUtils.preCheckCast(this.f.get(r3), f.a.class, "com.obric.aiagent.plugin")).a(r10, r9, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r11 = new StringBuilder("Could not locate call adapter for ").append(r10).append(".\n");
        if (r7 == null) goto L14;
        r11.append("  Skipped:");
        int r12 = 0;
    L11:
        if (r12 >= r0) goto L13;
        r11.append("\n   * ").append(((f.a) ZeusTransformUtils.preCheckCast(this.f.get(r12), f.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r12 = r12 + 1;
        goto L11
    L13:
        r11.append('\n');
    L14:
        r11.append("  Tried:");
        int r13 = this.f.size();
    L15:
        if (r0 >= r13) goto L18;
        r11.append("\n   * ").append(((f.a) ZeusTransformUtils.preCheckCast(this.f.get(r0), f.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r11.toString());
    }

    public <T> i<T, com.bytedance.retrofit2.e.j> a(Type r3, Annotation[] r4, Annotation[] r5) {
        return a(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    public <T> i<T, com.bytedance.retrofit2.e.j> a(i.a r7, Type r8, Annotation[] r9, Annotation[] r10) {
        Type r11 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        an.a(r11, "type == null");
        an.a(r9, "parameterAnnotations == null");
        an.a(r10, "methodAnnotations == null");
        int r0 = this.f9393e.indexOf(r7) + 1;
        int r2 = this.f9393e.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        i<T, com.bytedance.retrofit2.e.j> r4 = (i<T, com.bytedance.retrofit2.e.j>) ((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r3), i.a.class, "com.obric.aiagent.plugin")).a(r11, r9, r10, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r12 = new StringBuilder("Could not locate RequestBody converter for ").append(r11).append(".\n");
        if (r7 == null) goto L14;
        r12.append("  Skipped:");
        int r13 = 0;
    L11:
        if (r13 >= r0) goto L13;
        r12.append("\n   * ").append(((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r13), i.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r13 = r13 + 1;
        goto L11
    L13:
        r12.append('\n');
    L14:
        r12.append("  Tried:");
        int r14 = this.f9393e.size();
    L15:
        if (r0 >= r14) goto L18;
        r12.append("\n   * ").append(((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r0), i.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r12.toString());
    }

    public <T> i<com.bytedance.retrofit2.e.i, T> b(Type r3, Annotation[] r4) {
        return a(null, (Type) ZeusTransformUtils.wrapperContextForParams(r3, Type.class, "com.obric.aiagent.plugin"), r4);
    }

    public <T> i<com.bytedance.retrofit2.e.i, T> a(i.a r7, Type r8, Annotation[] r9) {
        Type r10 = (Type) ZeusTransformUtils.wrapperContextForParams(r8, Type.class, "com.obric.aiagent.plugin");
        an.a(r10, "type == null");
        an.a(r9, "annotations == null");
        int r0 = this.f9393e.indexOf(r7) + 1;
        int r2 = this.f9393e.size();
        int r3 = r0;
    L3:
        if (r3 >= r2) goto L8;
        i<com.bytedance.retrofit2.e.i, T> r4 = (i<com.bytedance.retrofit2.e.i, T>) ((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r3), i.a.class, "com.obric.aiagent.plugin")).a(r10, r9, this);
        if (r4 != null) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return r4;
    L8:
        StringBuilder r11 = new StringBuilder("Could not locate TypedInput converter for ").append(r10).append(".\n");
        if (r7 == null) goto L14;
        r11.append("  Skipped:");
        int r12 = 0;
    L11:
        if (r12 >= r0) goto L13;
        r11.append("\n   * ").append(((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r12), i.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r12 = r12 + 1;
        goto L11
    L13:
        r11.append('\n');
    L14:
        r11.append("  Tried:");
        int r13 = this.f9393e.size();
    L15:
        if (r0 >= r13) goto L18;
        r11.append("\n   * ").append(((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r0), i.a.class, "com.obric.aiagent.plugin")).getClass().getName());
        r0 = r0 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r11.toString());
    }

    public <T> i<T, Object> c(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        an.a(r8, "type == null");
        an.a(r7, "annotations == null");
        int r0 = this.f9393e.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        i<T, Object> r3 = (i<T, Object>) ((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r2), i.a.class, "com.obric.aiagent.plugin")).b(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public <T> i<T, String> d(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        an.a(r8, "type == null");
        an.a(r7, "annotations == null");
        int r0 = this.f9393e.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        i<T, String> r3 = (i<T, String>) ((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r2), i.a.class, "com.obric.aiagent.plugin")).c(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        return d.h.f9498a;
    }

    public <T> i<T, com.bytedance.retrofit2.b.b> e(Type r6, Annotation[] r7) {
        Type r8 = (Type) ZeusTransformUtils.wrapperContextForParams(r6, Type.class, "com.obric.aiagent.plugin");
        an.a(r8, "type == null");
        an.a(r7, "annotations == null");
        int r0 = this.f9393e.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        i<T, com.bytedance.retrofit2.b.b> r3 = (i<T, com.bytedance.retrofit2.b.b>) ((i.a) ZeusTransformUtils.preCheckCast(this.f9393e.get(r2), i.a.class, "com.obric.aiagent.plugin")).d(r8, r7, this);
        if (r3 != null) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r3;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }
}
