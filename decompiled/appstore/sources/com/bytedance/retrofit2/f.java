package com.bytedance.retrofit2;

import android.os.SystemClock;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
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

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static volatile CopyOnWriteArrayList f8002k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f8003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Client.Provider f8004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Endpoint f8005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f8006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f8007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f8008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f8009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Executor f8010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f8011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ICacheServer f8012j;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f8013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f8014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ f f8015c;

        public a(f r10, Class r11) {
            this.f8015c = r10;
            this.f8014b = r11;
            this.f8013a = e.e();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object... r12) {
            RetrofitMetrics r13 = new RetrofitMetrics();
            r13.f7899f = System.currentTimeMillis();
            if (r11.getDeclaringClass() != Object.class) goto L7;
            return r11.invoke(this, r12);
        L7:
            if (this.f8013a.g(r11) == true) goto L9;
            r13.f7905l = SystemClock.uptimeMillis();
            g r14 = this.f8015c.j(r11);
            r13.f7906m = SystemClock.uptimeMillis();
            r14.e(r13);
            SsHttpCall r15 = new SsHttpCall(r14, r12);
            return r14.f8027b.adapt(r15);
        L9:
            return this.f8013a.f(r11, this.f8014b, r10, r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public e f8016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Client.Provider f8017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Endpoint f8018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f8019d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List f8020e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List f8021f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Executor f8022g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Executor f8023h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f8024i;

        public b(e r10) {
            this.f8019d = new CopyOnWriteArrayList();
            this.f8020e = new ArrayList();
            this.f8021f = new ArrayList();
            this.f8016a = r10;
            this.f8020e.add(new com.bytedance.retrofit2.a());
        }

        public b a(CallAdapter.a r10) {
            this.f8021f.add(f6.g.a(r10, "factory == null"));
            return this;
        }

        public b b(Converter.a r10) {
            this.f8020e.add(f6.g.a(r10, "factory == null"));
            return this;
        }

        public b c(Interceptor r10) {
            Interceptor r11 = (Interceptor) f6.g.a(r10, "interceptor == null");
            this.f8019d.add(r11);
            return this;
        }

        public f d() {
            if (this.f8018c == null) goto L26;
            if (this.f8017b == null) goto L24;
            if (this.f8022g == null) goto L22;
            Executor r10 = this.f8023h;
            if (r10 != null) goto L11;
            r10 = this.f8016a.b();
        L11:
            Executor r11 = r10;
            ArrayList r12 = new ArrayList(this.f8021f);
            r12.add(this.f8016a.a(r11));
            ArrayList r13 = new ArrayList(this.f8020e);
            if (f.a() == null) goto L20;
            Iterator r14 = f.a().iterator();
        L15:
            if (r14.hasNext() == false) goto L20;
            Interceptor r15 = (Interceptor) r14.next();
            if (this.f8019d.contains(r15) == true) goto L15;
            this.f8019d.add(r15);
        L20:
            return new f(this.f8018c, this.f8017b, this.f8019d, r13, r12, this.f8022g, r11, this.f8024i);
        L22:
            throw new IllegalStateException("HttpExecutor may not be null.");
        L24:
            throw new IllegalStateException("ClientProvider may not be null.");
        L26:
            throw new IllegalStateException("Endpoint may not be null.");
        }

        public b e(Client.Provider r10) {
            return g((Client.Provider) f6.g.a(r10, "provider == null"));
        }

        public b f(Executor r10) {
            this.f8022g = (Executor) f6.g.a(r10, "httpExecutor == null");
            return this;
        }

        public b g(Client.Provider r10) {
            this.f8017b = (Client.Provider) f6.g.a(r10, "provider == null");
            return this;
        }

        public b h(String r10) {
            if (r10 == null) goto L8;
            if (r10.trim().length() == 0) goto L8;
            this.f8018c = f6.b.a(r10);
            return this;
        L8:
            throw new NullPointerException("Endpoint may not be blank.");
        }

        public b() {
            this(e.e());
        }
    }

    public f(Endpoint r11, Client.Provider r12, List r13, List r14, List r15, Executor r16, Executor r17, boolean r18) {
        this(r11, r12, r13, r14, r15, r16, r17, r18, null);
    }

    public static /* synthetic */ CopyOnWriteArrayList a() {
        return f8002k;
    }

    public static void r(CopyOnWriteArrayList r10) {
        f8002k = r10;
    }

    public ICacheServer b() {
        return this.f8012j;
    }

    public CallAdapter c(Type r10, Annotation[] r11) {
        return k(null, r10, r11);
    }

    public Client.Provider d() {
        return this.f8004b;
    }

    public Object e(Class r10) {
        f6.g.u(r10);
        if (this.f8009g == false) goto L6;
        f(r10);
    L6:
        return Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new a(this, r10));
    }

    public final void f(Class r10) {
        e r11 = e.e();
        Method[] r12 = r10.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        if (r11.g(r15) == true) goto L7;
        j(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    }

    public Converter g(Type r10, Annotation[] r11) {
        f6.g.a(r10, "type == null");
        f6.g.a(r11, "annotations == null");
        int r12 = this.f8006d.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Converter r14 = ((Converter.a) this.f8006d.get(r13)).a(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new IllegalArgumentException("Could not locate header converter");
    }

    public Executor h() {
        return this.f8010h;
    }

    public List i() {
        return this.f8011i;
    }

    public g j(Method r10) {
        g r11 = (g) this.f8003a.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Map r12 = this.f8003a;
        monitor-enter(r12);
        g r13 = (g) this.f8003a.get(r10);     // Catch: Throwable -> L10
        if (r13 != null) goto L12;
        r13 = new g.a(this, r10).b();     // Catch: Throwable -> L10
        this.f8003a.put(r10, r13);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    }

    public CallAdapter k(CallAdapter.a r10, Type r11, Annotation[] r12) {
        f6.g.a(r11, "returnType == null");
        f6.g.a(r12, "annotations == null");
        int r13 = this.f8007e.indexOf(r10) + 1;
        int r14 = this.f8007e.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        CallAdapter r16 = ((CallAdapter.a) this.f8007e.get(r15)).a(r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate call adapter for ");
        r17.append(r11);
        r17.append(".\n");
        if (r10 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(((CallAdapter.a) this.f8007e.get(r18)).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f8007e.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(((CallAdapter.a) this.f8007e.get(r13)).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public Converter l(Converter.a r10, Type r11, Annotation[] r12, Annotation[] r13) {
        f6.g.a(r11, "type == null");
        f6.g.a(r12, "parameterAnnotations == null");
        f6.g.a(r13, "methodAnnotations == null");
        int r14 = this.f8006d.indexOf(r10) + 1;
        int r15 = this.f8006d.size();
        int r16 = r14;
    L3:
        if (r16 >= r15) goto L8;
        Converter r17 = ((Converter.a) this.f8006d.get(r16)).c(r11, r12, r13, this);
        if (r17 != null) goto L6;
        r16 = r16 + 1;
        goto L3
    L6:
        return r17;
    L8:
        StringBuilder r18 = new StringBuilder("Could not locate RequestBody converter for ");
        r18.append(r11);
        r18.append(".\n");
        if (r10 == null) goto L14;
        r18.append("  Skipped:");
        int r19 = 0;
    L11:
        if (r19 >= r14) goto L13;
        r18.append("\n   * ");
        r18.append(((Converter.a) this.f8006d.get(r19)).getClass().getName());
        r19 = r19 + 1;
        goto L11
    L13:
        r18.append('\n');
    L14:
        r18.append("  Tried:");
        int r20 = this.f8006d.size();
    L15:
        if (r14 >= r20) goto L18;
        r18.append("\n   * ");
        r18.append(((Converter.a) this.f8006d.get(r14)).getClass().getName());
        r14 = r14 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r18.toString());
    }

    public Converter m(Converter.a r10, Type r11, Annotation[] r12) {
        f6.g.a(r11, "type == null");
        f6.g.a(r12, "annotations == null");
        int r13 = this.f8006d.indexOf(r10) + 1;
        int r14 = this.f8006d.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        Converter r16 = ((Converter.a) this.f8006d.get(r15)).d(r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate TypeInput converter for ");
        r17.append(r11);
        r17.append(".\n");
        if (r10 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(((Converter.a) this.f8006d.get(r18)).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f8006d.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(((Converter.a) this.f8006d.get(r13)).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public Converter n(Type r10, Annotation[] r11) {
        f6.g.a(r10, "type == null");
        f6.g.a(r11, "annotations == null");
        int r12 = this.f8006d.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Converter r14 = ((Converter.a) this.f8006d.get(r13)).b(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        throw new IllegalArgumentException("Could not locate object converter");
    }

    public Converter o(Type r10, Annotation[] r11, Annotation[] r12) {
        return l(null, r10, r11, r12);
    }

    public Converter p(Type r10, Annotation[] r11) {
        return m(null, r10, r11);
    }

    public Endpoint q() {
        return this.f8005c;
    }

    public Converter s(Type r10, Annotation[] r11) {
        f6.g.a(r10, "type == null");
        f6.g.a(r11, "annotations == null");
        int r12 = this.f8006d.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Converter r14 = ((Converter.a) this.f8006d.get(r13)).e(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        return com.bytedance.retrofit2.a.h.f7944a;
    }

    public f(Endpoint r10, Client.Provider r11, List r12, List r13, List r14, Executor r15, Executor r16, boolean r17, ICacheServer r18) {
        this.f8003a = new ConcurrentHashMap();
        this.f8005c = r10;
        this.f8004b = r11;
        this.f8011i = r12;
        this.f8006d = Collections.unmodifiableList(r13);
        this.f8007e = Collections.unmodifiableList(r14);
        this.f8010h = r15;
        this.f8008f = r16;
        this.f8009g = r17;
        this.f8012j = r18;
    }
}
