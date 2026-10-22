package h3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: h3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4127c<T> {

    /* renamed from: a, reason: collision with root package name */
    public final Set<Class<? super T>> f32894a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<C4139o> f32895b;

    /* renamed from: c, reason: collision with root package name */
    public final int f32896c;

    /* renamed from: d, reason: collision with root package name */
    public final int f32897d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC4131g<T> f32898e;

    /* renamed from: f, reason: collision with root package name */
    public final Set<Class<?>> f32899f;

    /* renamed from: h3.c$b */
    public static class b<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Set<Class<? super T>> f32900a;

        /* renamed from: b, reason: collision with root package name */
        public final Set<C4139o> f32901b;

        /* renamed from: c, reason: collision with root package name */
        public int f32902c;

        /* renamed from: d, reason: collision with root package name */
        public int f32903d;

        /* renamed from: e, reason: collision with root package name */
        public InterfaceC4131g<T> f32904e;

        /* renamed from: f, reason: collision with root package name */
        public Set<Class<?>> f32905f;

        public b<T> b(C4139o c4139o) {
            w.c(c4139o, "Null dependency");
            f(c4139o.b());
            this.f32901b.add(c4139o);
            return this;
        }

        public C4127c<T> c() {
            w.d(this.f32904e != null, "Missing required property: factory.");
            return new C4127c<>(new HashSet(this.f32900a), new HashSet(this.f32901b), this.f32902c, this.f32903d, this.f32904e, this.f32905f);
        }

        public b<T> d(InterfaceC4131g<T> interfaceC4131g) {
            this.f32904e = (InterfaceC4131g) w.c(interfaceC4131g, "Null factory");
            return this;
        }

        public final b<T> e() {
            this.f32903d = 1;
            return this;
        }

        public final void f(Class<?> cls) {
            w.a(!this.f32900a.contains(cls), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        @SafeVarargs
        public b(Class<T> cls, Class<? super T>... clsArr) {
            HashSet hashSet = new HashSet();
            this.f32900a = hashSet;
            this.f32901b = new HashSet();
            this.f32902c = 0;
            this.f32903d = 0;
            this.f32905f = new HashSet();
            w.c(cls, "Null interface");
            hashSet.add(cls);
            for (Class<? super T> cls2 : clsArr) {
                w.c(cls2, "Null interface");
            }
            Collections.addAll(this.f32900a, clsArr);
        }
    }

    public static <T> b<T> a(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> b(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> g(Class<T> cls) {
        return a(cls).e();
    }

    public static /* synthetic */ Object k(Object obj, InterfaceC4128d interfaceC4128d) {
        return obj;
    }

    @SafeVarargs
    public static <T> C4127c<T> l(T t10, Class<T> cls, Class<? super T>... clsArr) {
        return b(cls, clsArr).d(C4126b.b(t10)).c();
    }

    public Set<C4139o> c() {
        return this.f32895b;
    }

    public InterfaceC4131g<T> d() {
        return this.f32898e;
    }

    public Set<Class<? super T>> e() {
        return this.f32894a;
    }

    public Set<Class<?>> f() {
        return this.f32899f;
    }

    public boolean h() {
        return this.f32896c == 1;
    }

    public boolean i() {
        return this.f32896c == 2;
    }

    public boolean j() {
        return this.f32897d == 0;
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f32894a.toArray()) + ">{" + this.f32896c + ", type=" + this.f32897d + ", deps=" + Arrays.toString(this.f32895b.toArray()) + "}";
    }

    public C4127c(Set<Class<? super T>> set, Set<C4139o> set2, int i10, int i11, InterfaceC4131g<T> interfaceC4131g, Set<Class<?>> set3) {
        this.f32894a = Collections.unmodifiableSet(set);
        this.f32895b = Collections.unmodifiableSet(set2);
        this.f32896c = i10;
        this.f32897d = i11;
        this.f32898e = interfaceC4131g;
        this.f32899f = Collections.unmodifiableSet(set3);
    }
}
