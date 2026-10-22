package C1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Type, A1.f<?>> f526a;

    /* renamed from: b, reason: collision with root package name */
    private final F1.b f527b = F1.b.a();

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements C1.i<T> {
        a() {
        }

        @Override // C1.i
        public T a() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements C1.i<T> {
        b() {
        }

        @Override // C1.i
        public T a() {
            return (T) new TreeMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* renamed from: C1.c$c, reason: collision with other inner class name */
    class C0014c<T> implements C1.i<T> {
        C0014c() {
        }

        @Override // C1.i
        public T a() {
            return (T) new LinkedHashMap();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class d<T> implements C1.i<T> {
        d() {
        }

        @Override // C1.i
        public T a() {
            return (T) new C1.h();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class e<T> implements C1.i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final C1.m f532a = C1.m.b();

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f533b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Type f534c;

        e(Class cls, Type type) {
            this.f533b = cls;
            this.f534c = type;
        }

        @Override // C1.i
        public T a() {
            try {
                return (T) this.f532a.c(this.f533b);
            } catch (Exception e6) {
                throw new RuntimeException("Unable to invoke no-args constructor for " + this.f534c + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e6);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class f<T> implements C1.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ A1.f f536a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f537b;

        f(A1.f fVar, Type type) {
            this.f536a = fVar;
            this.f537b = type;
        }

        @Override // C1.i
        public T a() {
            return (T) this.f536a.a(this.f537b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class g<T> implements C1.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ A1.f f539a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Type f540b;

        g(A1.f fVar, Type type) {
            this.f539a = fVar;
            this.f540b = type;
        }

        @Override // C1.i
        public T a() {
            return (T) this.f539a.a(this.f540b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class h<T> implements C1.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Constructor f542a;

        h(Constructor constructor) {
            this.f542a = constructor;
        }

        @Override // C1.i
        public T a() {
            try {
                return (T) this.f542a.newInstance(null);
            } catch (IllegalAccessException e6) {
                throw new AssertionError(e6);
            } catch (InstantiationException e7) {
                throw new RuntimeException("Failed to invoke " + this.f542a + " with no args", e7);
            } catch (InvocationTargetException e8) {
                throw new RuntimeException("Failed to invoke " + this.f542a + " with no args", e8.getTargetException());
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class i<T> implements C1.i<T> {
        i() {
        }

        @Override // C1.i
        public T a() {
            return (T) new TreeSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class j<T> implements C1.i<T> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Type f545a;

        j(Type type) {
            this.f545a = type;
        }

        @Override // C1.i
        public T a() {
            Type type = this.f545a;
            if (!(type instanceof ParameterizedType)) {
                throw new A1.k("Invalid EnumSet type: " + this.f545a.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new A1.k("Invalid EnumSet type: " + this.f545a.toString());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class k<T> implements C1.i<T> {
        k() {
        }

        @Override // C1.i
        public T a() {
            return (T) new LinkedHashSet();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class l<T> implements C1.i<T> {
        l() {
        }

        @Override // C1.i
        public T a() {
            return (T) new ArrayDeque();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class m<T> implements C1.i<T> {
        m() {
        }

        @Override // C1.i
        public T a() {
            return (T) new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class n<T> implements C1.i<T> {
        n() {
        }

        @Override // C1.i
        public T a() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    public c(Map<Type, A1.f<?>> map) {
        this.f526a = map;
    }

    private <T> C1.i<T> b(Class<? super T> cls) throws NoSuchMethodException, SecurityException {
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            if (!declaredConstructor.isAccessible()) {
                this.f527b.b(declaredConstructor);
            }
            return new h(declaredConstructor);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private <T> C1.i<T> c(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new i() : EnumSet.class.isAssignableFrom(cls) ? new j(type) : Set.class.isAssignableFrom(cls) ? new k() : Queue.class.isAssignableFrom(cls) ? new l() : new m();
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new n() : ConcurrentMap.class.isAssignableFrom(cls) ? new a() : SortedMap.class.isAssignableFrom(cls) ? new b() : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(com.google.gson.reflect.a.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new d() : new C0014c();
        }
        return null;
    }

    private <T> C1.i<T> d(Type type, Class<? super T> cls) {
        return new e(cls, type);
    }

    public <T> C1.i<T> a(com.google.gson.reflect.a<T> aVar) throws NoSuchMethodException, SecurityException {
        Type type = aVar.getType();
        Class<? super T> rawType = aVar.getRawType();
        A1.f<?> fVar = this.f526a.get(type);
        if (fVar != null) {
            return new f(fVar, type);
        }
        A1.f<?> fVar2 = this.f526a.get(rawType);
        if (fVar2 != null) {
            return new g(fVar2, type);
        }
        C1.i<T> iVarB = b(rawType);
        if (iVarB != null) {
            return iVarB;
        }
        C1.i<T> iVarC = c(type, rawType);
        return iVarC != null ? iVarC : d(type, rawType);
    }

    public String toString() {
        return this.f526a.toString();
    }
}
