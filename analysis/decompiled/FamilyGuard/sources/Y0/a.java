package Y0;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static final g<Object> f6394a = new C0090a();

    /* renamed from: Y0.a$a, reason: collision with other inner class name */
    class C0090a implements g<Object> {
        C0090a() {
        }

        @Override // Y0.a.g
        public void a(Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements d<List<T>> {
        b() {
        }

        @Override // Y0.a.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class c<T> implements g<List<T>> {
        c() {
        }

        @Override // Y0.a.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T a();
    }

    private static final class e<T> implements D.e<T> {

        /* renamed from: a, reason: collision with root package name */
        private final d<T> f6395a;

        /* renamed from: b, reason: collision with root package name */
        private final g<T> f6396b;

        /* renamed from: c, reason: collision with root package name */
        private final D.e<T> f6397c;

        e(D.e<T> eVar, d<T> dVar, g<T> gVar) {
            this.f6397c = eVar;
            this.f6395a = dVar;
            this.f6396b = gVar;
        }

        @Override // D.e
        public boolean a(T t5) {
            if (t5 instanceof f) {
                ((f) t5).g().b(true);
            }
            this.f6396b.a(t5);
            return this.f6397c.a(t5);
        }

        @Override // D.e
        public T b() {
            T tB = this.f6397c.b();
            if (tB == null) {
                tB = this.f6395a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + tB.getClass());
                }
            }
            if (tB instanceof f) {
                tB.g().b(false);
            }
            return (T) tB;
        }
    }

    public interface f {
        Y0.c g();
    }

    public interface g<T> {
        void a(T t5);
    }

    private static <T extends f> D.e<T> a(D.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    private static <T> D.e<T> b(D.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    private static <T> g<T> c() {
        return (g<T>) f6394a;
    }

    public static <T extends f> D.e<T> d(int i5, d<T> dVar) {
        return a(new D.g(i5), dVar);
    }

    public static <T> D.e<List<T>> e() {
        return f(20);
    }

    public static <T> D.e<List<T>> f(int i5) {
        return b(new D.g(i5), new b(), new c());
    }
}
