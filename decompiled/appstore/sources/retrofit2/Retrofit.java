package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/* JADX INFO: loaded from: classes4.dex */
public final class Retrofit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f23964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.Call.Factory f23965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HttpUrl f23966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f23967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f23968e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f23969f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f23970g;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f23971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f23972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Retrofit f23973c;

        public a(Retrofit r10, Class r11) {
            this.f23973c = r10;
            this.f23972b = r11;
            this.f23971a = f.d();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object r10, Method r11, Object[] r12) {
            if (r11.getDeclaringClass() != Object.class) goto L7;
            return r11.invoke(this, r12);
        L7:
            if (this.f23971a.f(r11) == true) goto L9;
            h r13 = this.f23973c.f(r11);
            d r14 = new d(r13, r12);
            return r13.f24084b.adapt(r14);
        L9:
            return this.f23971a.e(r11, this.f23972b, r10, r12);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f23974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public okhttp3.Call.Factory f23975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public HttpUrl f23976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f23977d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f23978e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Executor f23979f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f23980g;

        public b(f r10) {
            ArrayList r11 = new ArrayList();
            this.f23977d = r11;
            this.f23978e = new ArrayList();
            this.f23974a = r10;
            r11.add(new retrofit2.a());
        }

        public b a(CallAdapter.a r10) {
            this.f23978e.add(i.b(r10, "factory == null"));
            return this;
        }

        public b b(Converter.a r10) {
            this.f23977d.add(i.b(r10, "factory == null"));
            return this;
        }

        public b c(String r10) {
            i.b(r10, "baseUrl == null");
            HttpUrl r11 = HttpUrl.r(r10);
            if (r11 == null) goto L7;
            return d(r11);
        L7:
            throw new IllegalArgumentException("Illegal URL: " + r10);
        }

        public b d(HttpUrl r10) {
            i.b(r10, "baseUrl == null");
            List r11 = r10.s();
            if ("".equals(r11.get(r11.size() - 1)) == false) goto L7;
            this.f23976c = r10;
            return this;
        L7:
            throw new IllegalArgumentException("baseUrl must end in /: " + r10);
        }

        public Retrofit e() {
            if (this.f23976c == null) goto L13;
            okhttp3.Call.Factory r10 = this.f23975b;
            if (r10 != null) goto L7;
            r10 = new OkHttpClient();
        L7:
            okhttp3.Call.Factory r11 = r10;
            Executor r12 = this.f23979f;
            if (r12 != null) goto L10;
            r12 = this.f23974a.b();
        L10:
            Executor r13 = r12;
            ArrayList r14 = new ArrayList(this.f23978e);
            r14.add(this.f23974a.a(r13));
            ArrayList r15 = new ArrayList(this.f23977d);
            return new Retrofit(r11, this.f23976c, r15, r14, r13, this.f23980g);
        L13:
            throw new IllegalStateException("Base URL required.");
        }

        public b f(okhttp3.Call.Factory r10) {
            this.f23975b = (okhttp3.Call.Factory) i.b(r10, "factory == null");
            return this;
        }

        public b g(OkHttpClient r10) {
            return f((okhttp3.Call.Factory) i.b(r10, "client == null"));
        }

        public b() {
            this(f.d());
        }
    }

    public Retrofit(okhttp3.Call.Factory r10, HttpUrl r11, List r12, List r13, Executor r14, boolean r15) {
        this.f23964a = new ConcurrentHashMap();
        this.f23965b = r10;
        this.f23966c = r11;
        this.f23967d = Collections.unmodifiableList(r12);
        this.f23968e = Collections.unmodifiableList(r13);
        this.f23969f = r14;
        this.f23970g = r15;
    }

    public HttpUrl a() {
        return this.f23966c;
    }

    public CallAdapter b(Type r10, Annotation[] r11) {
        return g(null, r10, r11);
    }

    public okhttp3.Call.Factory c() {
        return this.f23965b;
    }

    public Object d(Class r10) {
        i.s(r10);
        if (this.f23970g == false) goto L6;
        e(r10);
    L6:
        return Proxy.newProxyInstance(r10.getClassLoader(), new Class[]{r10}, new a(this, r10));
    }

    public final void e(Class r10) {
        f r11 = f.d();
        Method[] r12 = r10.getDeclaredMethods();
        int r13 = r12.length;
        int r14 = 0;
    L3:
        if (r14 >= r13) goto L8;
        Method r15 = r12[r14];
        if (r11.f(r15) == true) goto L7;
        f(r15);
    L7:
        r14 = r14 + 1;
        goto L3
    }

    public h f(Method r10) {
        h r11 = (h) this.f23964a.get(r10);
        if (r11 == null) goto L5;
        return r11;
    L5:
        Map r12 = this.f23964a;
        monitor-enter(r12);
        h r13 = (h) this.f23964a.get(r10);     // Catch: Throwable -> L10
        if (r13 != null) goto L12;
        r13 = new h.a(this, r10).a();     // Catch: Throwable -> L10
        this.f23964a.put(r10, r13);     // Catch: Throwable -> L10
    L12:
        monitor-exit(r12);     // Catch: Throwable -> L10
        return r13;
    L10:
        th = move-exception;
        throw th;
    }

    public CallAdapter g(CallAdapter.a r10, Type r11, Annotation[] r12) {
        i.b(r11, "returnType == null");
        i.b(r12, "annotations == null");
        int r13 = this.f23968e.indexOf(r10) + 1;
        int r14 = this.f23968e.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        CallAdapter r16 = ((CallAdapter.a) this.f23968e.get(r15)).a(r11, r12, this);
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
        r17.append(((CallAdapter.a) this.f23968e.get(r18)).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f23968e.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(((CallAdapter.a) this.f23968e.get(r13)).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public Converter h(Converter.a r10, Type r11, Annotation[] r12, Annotation[] r13) {
        i.b(r11, "type == null");
        i.b(r12, "parameterAnnotations == null");
        i.b(r13, "methodAnnotations == null");
        int r14 = this.f23967d.indexOf(r10) + 1;
        int r15 = this.f23967d.size();
        int r16 = r14;
    L3:
        if (r16 >= r15) goto L8;
        Converter r17 = ((Converter.a) this.f23967d.get(r16)).a(r11, r12, r13, this);
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
        r18.append(((Converter.a) this.f23967d.get(r19)).getClass().getName());
        r19 = r19 + 1;
        goto L11
    L13:
        r18.append('\n');
    L14:
        r18.append("  Tried:");
        int r20 = this.f23967d.size();
    L15:
        if (r14 >= r20) goto L18;
        r18.append("\n   * ");
        r18.append(((Converter.a) this.f23967d.get(r14)).getClass().getName());
        r14 = r14 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r18.toString());
    }

    public Converter i(Converter.a r10, Type r11, Annotation[] r12) {
        i.b(r11, "type == null");
        i.b(r12, "annotations == null");
        int r13 = this.f23967d.indexOf(r10) + 1;
        int r14 = this.f23967d.size();
        int r15 = r13;
    L3:
        if (r15 >= r14) goto L8;
        Converter r16 = ((Converter.a) this.f23967d.get(r15)).b(r11, r12, this);
        if (r16 != null) goto L6;
        r15 = r15 + 1;
        goto L3
    L6:
        return r16;
    L8:
        StringBuilder r17 = new StringBuilder("Could not locate ResponseBody converter for ");
        r17.append(r11);
        r17.append(".\n");
        if (r10 == null) goto L14;
        r17.append("  Skipped:");
        int r18 = 0;
    L11:
        if (r18 >= r13) goto L13;
        r17.append("\n   * ");
        r17.append(((Converter.a) this.f23967d.get(r18)).getClass().getName());
        r18 = r18 + 1;
        goto L11
    L13:
        r17.append('\n');
    L14:
        r17.append("  Tried:");
        int r19 = this.f23967d.size();
    L15:
        if (r13 >= r19) goto L18;
        r17.append("\n   * ");
        r17.append(((Converter.a) this.f23967d.get(r13)).getClass().getName());
        r13 = r13 + 1;
        goto L15
    L18:
        throw new IllegalArgumentException(r17.toString());
    }

    public Converter j(Type r10, Annotation[] r11, Annotation[] r12) {
        return h(null, r10, r11, r12);
    }

    public Converter k(Type r10, Annotation[] r11) {
        return i(null, r10, r11);
    }

    public Converter l(Type r10, Annotation[] r11) {
        i.b(r10, "type == null");
        i.b(r11, "annotations == null");
        int r12 = this.f23967d.size();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L9;
        Converter r14 = ((Converter.a) this.f23967d.get(r13)).c(r10, r11, this);
        if (r14 != null) goto L6;
        r13 = r13 + 1;
        goto L3
    L6:
        return r14;
    L9:
        return retrofit2.a.d.f23984a;
    }
}
