package yc;

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
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import tb.AbstractC5529B;
import tb.AbstractC5531D;
import tb.InterfaceC5538e;
import yc.b;
import yc.e;
import yc.h;

/* loaded from: classes5.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<Method, Object> f44473a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC5538e.a f44474b;

    /* renamed from: c, reason: collision with root package name */
    public final tb.v f44475c;

    /* renamed from: d, reason: collision with root package name */
    public final List<h.a> f44476d;

    /* renamed from: e, reason: collision with root package name */
    public final int f44477e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e.a> f44478f;

    /* renamed from: g, reason: collision with root package name */
    public final int f44479g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f44480h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f44481i;

    public class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final Object[] f44482a = new Object[0];

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Class f44483b;

        public a(Class cls) {
            this.f44483b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f44482a;
            }
            s sVar = r.f44415b;
            return sVar.c(method) ? sVar.b(method, this.f44483b, obj, objArr) : w.this.d(this.f44483b, method).a(obj, objArr);
        }
    }

    public w(InterfaceC5538e.a aVar, tb.v vVar, List<h.a> list, int i10, List<e.a> list2, int i11, Executor executor, boolean z10) {
        this.f44474b = aVar;
        this.f44475c = vVar;
        this.f44476d = list;
        this.f44477e = i10;
        this.f44478f = list2;
        this.f44479g = i11;
        this.f44480h = executor;
        this.f44481i = z10;
    }

    public tb.v a() {
        return this.f44475c;
    }

    public e<?, ?> b(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public <T> T c(Class<T> cls) throws SecurityException {
        l(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public x<?> d(Class<?> cls, Method method) {
        while (true) {
            Object objPutIfAbsent = this.f44473a.get(method);
            if (objPutIfAbsent instanceof x) {
                return (x) objPutIfAbsent;
            }
            if (objPutIfAbsent == null) {
                Object obj = new Object();
                synchronized (obj) {
                    try {
                        objPutIfAbsent = this.f44473a.putIfAbsent(method, obj);
                        if (objPutIfAbsent == null) {
                            try {
                                x<?> xVarB = x.b(this, cls, method);
                                this.f44473a.put(method, xVarB);
                                return xVarB;
                            } catch (Throwable th) {
                                this.f44473a.remove(method);
                                throw th;
                            }
                        }
                    } finally {
                    }
                }
            }
            synchronized (objPutIfAbsent) {
                try {
                    Object obj2 = this.f44473a.get(method);
                    if (obj2 != null) {
                        return (x) obj2;
                    }
                } finally {
                }
            }
        }
    }

    public b e() {
        return new b(this);
    }

    public e<?, ?> f(e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f44478f.indexOf(aVar) + 1;
        int size = this.f44478f.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            e<?, ?> eVarA = this.f44478f.get(i10).a(type, annotationArr, this);
            if (eVarA != null) {
                return eVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f44478f.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f44478f.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f44478f.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> h<T, AbstractC5529B> g(h.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f44476d.indexOf(aVar) + 1;
        int size = this.f44476d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            h<T, AbstractC5529B> hVar = (h<T, AbstractC5529B>) this.f44476d.get(i10).c(type, annotationArr, annotationArr2, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f44476d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f44476d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f44476d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> h<AbstractC5531D, T> h(h.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f44476d.indexOf(aVar) + 1;
        int size = this.f44476d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            h<AbstractC5531D, T> hVar = (h<AbstractC5531D, T>) this.f44476d.get(i10).d(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f44476d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f44476d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f44476d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> h<T, AbstractC5529B> i(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return g(null, type, annotationArr, annotationArr2);
    }

    public <T> h<AbstractC5531D, T> j(Type type, Annotation[] annotationArr) {
        return h(null, type, annotationArr);
    }

    public <T> h<T, String> k(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f44476d.size();
        for (int i10 = 0; i10 < size; i10++) {
            h<T, String> hVar = (h<T, String>) this.f44476d.get(i10).e(type, annotationArr, this);
            if (hVar != null) {
                return hVar;
            }
        }
        return b.d.f44312a;
    }

    public final void l(Class<?> cls) throws SecurityException {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls2.getName());
                if (cls2 != cls) {
                    sb2.append(" which is an interface of ");
                    sb2.append(cls.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f44481i) {
            s sVar = r.f44415b;
            for (Method method : cls.getDeclaredMethods()) {
                if (!sVar.c(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                    d(cls, method);
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public InterfaceC5538e.a f44485a;

        /* renamed from: b, reason: collision with root package name */
        public tb.v f44486b;

        /* renamed from: c, reason: collision with root package name */
        public final List<h.a> f44487c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        public final List<e.a> f44488d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public Executor f44489e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f44490f;

        public b() {
        }

        public b a(h.a aVar) {
            List<h.a> list = this.f44487c;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return c(tb.v.g(str));
        }

        public b c(tb.v vVar) {
            Objects.requireNonNull(vVar, "baseUrl == null");
            if ("".equals(vVar.l().get(r0.size() - 1))) {
                this.f44486b = vVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + vVar);
        }

        public w d() {
            if (this.f44486b == null) {
                throw new IllegalStateException("Base URL required.");
            }
            InterfaceC5538e.a zVar = this.f44485a;
            if (zVar == null) {
                zVar = new tb.z();
            }
            InterfaceC5538e.a aVar = zVar;
            Executor executor = this.f44489e;
            if (executor == null) {
                executor = r.f44414a;
            }
            Executor executor2 = executor;
            c cVar = r.f44416c;
            ArrayList arrayList = new ArrayList(this.f44488d);
            List<? extends e.a> listA = cVar.a(executor2);
            arrayList.addAll(listA);
            List<? extends h.a> listB = cVar.b();
            int size = listB.size();
            ArrayList arrayList2 = new ArrayList(this.f44487c.size() + 1 + size);
            arrayList2.add(new yc.b());
            arrayList2.addAll(this.f44487c);
            arrayList2.addAll(listB);
            return new w(aVar, this.f44486b, Collections.unmodifiableList(arrayList2), size, Collections.unmodifiableList(arrayList), listA.size(), executor2, this.f44490f);
        }

        public b e(InterfaceC5538e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f44485a = aVar;
            return this;
        }

        public b f(tb.z zVar) {
            Objects.requireNonNull(zVar, "client == null");
            return e(zVar);
        }

        public b(w wVar) {
            this.f44485a = wVar.f44474b;
            this.f44486b = wVar.f44475c;
            int size = wVar.f44476d.size() - wVar.f44477e;
            for (int i10 = 1; i10 < size; i10++) {
                this.f44487c.add(wVar.f44476d.get(i10));
            }
            int size2 = wVar.f44478f.size() - wVar.f44479g;
            for (int i11 = 0; i11 < size2; i11++) {
                this.f44488d.add(wVar.f44478f.get(i11));
            }
            this.f44489e = wVar.f44480h;
            this.f44490f = wVar.f44481i;
        }
    }
}
