package R4;

import C4.A;
import C4.E;
import C4.G;
import C4.InterfaceC0275e;
import R4.a;
import R4.c;
import R4.f;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, v<?>> f5166a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    final InterfaceC0275e.a f5167b;

    /* renamed from: c, reason: collision with root package name */
    final C4.w f5168c;

    /* renamed from: d, reason: collision with root package name */
    final List<f.a> f5169d;

    /* renamed from: e, reason: collision with root package name */
    final List<c.a> f5170e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    final Executor f5171f;

    /* renamed from: g, reason: collision with root package name */
    final boolean f5172g;

    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final q f5173a = q.f();

        /* renamed from: b, reason: collision with root package name */
        private final Object[] f5174b = new Object[0];

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Class f5175c;

        a(Class cls) {
            this.f5175c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f5174b;
            }
            return this.f5173a.h(method) ? this.f5173a.g(method, this.f5175c, obj, objArr) : u.this.d(method).a(objArr);
        }
    }

    u(InterfaceC0275e.a aVar, C4.w wVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z5) {
        this.f5167b = aVar;
        this.f5168c = wVar;
        this.f5169d = list;
        this.f5170e = list2;
        this.f5171f = executor;
        this.f5172g = z5;
    }

    private void k(Class<?> cls) throws SecurityException {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls2.getName());
                if (cls2 != cls) {
                    sb.append(" which is an interface of ");
                    sb.append(cls.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f5172g) {
            q qVarF = q.f();
            for (Method method : cls.getDeclaredMethods()) {
                if (!qVarF.h(method) && !Modifier.isStatic(method.getModifiers())) {
                    d(method);
                }
            }
        }
    }

    public C4.w a() {
        return this.f5168c;
    }

    public c<?, ?> b(Type type, Annotation[] annotationArr) {
        return e(null, type, annotationArr);
    }

    public <T> T c(Class<T> cls) throws SecurityException {
        k(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    v<?> d(Method method) {
        v<?> vVarB;
        v<?> vVar = this.f5166a.get(method);
        if (vVar != null) {
            return vVar;
        }
        synchronized (this.f5166a) {
            try {
                vVarB = this.f5166a.get(method);
                if (vVarB == null) {
                    vVarB = v.b(this, method);
                    this.f5166a.put(method, vVarB);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return vVarB;
    }

    public c<?, ?> e(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f5170e.indexOf(aVar) + 1;
        int size = this.f5170e.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            c<?, ?> cVarA = this.f5170e.get(i5).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(this.f5170e.get(i6).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f5170e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f5170e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, E> f(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f5169d.indexOf(aVar) + 1;
        int size = this.f5169d.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            f<T, E> fVar = (f<T, E>) this.f5169d.get(i5).c(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(this.f5169d.get(i6).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f5169d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f5169d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<G, T> g(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f5169d.indexOf(aVar) + 1;
        int size = this.f5169d.size();
        for (int i5 = iIndexOf; i5 < size; i5++) {
            f<G, T> fVar = (f<G, T>) this.f5169d.get(i5).d(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i6 = 0; i6 < iIndexOf; i6++) {
                sb.append("\n   * ");
                sb.append(this.f5169d.get(i6).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.f5169d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f5169d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> f<T, E> h(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return f(null, type, annotationArr, annotationArr2);
    }

    public <T> f<G, T> i(Type type, Annotation[] annotationArr) {
        return g(null, type, annotationArr);
    }

    public <T> f<T, String> j(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f5169d.size();
        for (int i5 = 0; i5 < size; i5++) {
            f<T, String> fVar = (f<T, String>) this.f5169d.get(i5).e(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.f4997a;
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final q f5177a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        private InterfaceC0275e.a f5178b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        private C4.w f5179c;

        /* renamed from: d, reason: collision with root package name */
        private final List<f.a> f5180d;

        /* renamed from: e, reason: collision with root package name */
        private final List<c.a> f5181e;

        /* renamed from: f, reason: collision with root package name */
        @Nullable
        private Executor f5182f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f5183g;

        b(q qVar) {
            this.f5180d = new ArrayList();
            this.f5181e = new ArrayList();
            this.f5177a = qVar;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f5181e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(f.a aVar) {
            List<f.a> list = this.f5180d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(C4.w wVar) {
            Objects.requireNonNull(wVar, "baseUrl == null");
            if (BuildConfig.FLAVOR.equals(wVar.r().get(r0.size() - 1))) {
                this.f5179c = wVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + wVar);
        }

        public b d(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return c(C4.w.l(str));
        }

        public u e() {
            if (this.f5179c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            InterfaceC0275e.a a6 = this.f5178b;
            if (a6 == null) {
                a6 = new A();
            }
            InterfaceC0275e.a aVar = a6;
            Executor executorB = this.f5182f;
            if (executorB == null) {
                executorB = this.f5177a.b();
            }
            Executor executor = executorB;
            ArrayList arrayList = new ArrayList(this.f5181e);
            arrayList.addAll(this.f5177a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f5180d.size() + 1 + this.f5177a.d());
            arrayList2.add(new R4.a());
            arrayList2.addAll(this.f5180d);
            arrayList2.addAll(this.f5177a.c());
            return new u(aVar, this.f5179c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f5183g);
        }

        public b f(InterfaceC0275e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f5178b = aVar;
            return this;
        }

        public b g(A a6) {
            Objects.requireNonNull(a6, "client == null");
            return f(a6);
        }

        public b() {
            this(q.f());
        }
    }
}
