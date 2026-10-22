package Z3;

import Z3.i;
import j4.k;

/* loaded from: classes.dex */
public interface f extends i.b {

    /* renamed from: N, reason: collision with root package name */
    public static final b f6654N = b.f6655a;

    public static final class a {
        public static <E extends i.b> E a(f fVar, i.c<E> cVar) {
            E e6;
            k.g(cVar, "key");
            if (!(cVar instanceof Z3.b)) {
                if (f.f6654N != cVar) {
                    return null;
                }
                k.e(fVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return fVar;
            }
            Z3.b bVar = (Z3.b) cVar;
            if (!bVar.a(fVar.getKey()) || (e6 = (E) bVar.b(fVar)) == null) {
                return null;
            }
            return e6;
        }

        public static i b(f fVar, i.c<?> cVar) {
            k.g(cVar, "key");
            if (!(cVar instanceof Z3.b)) {
                return f.f6654N == cVar ? j.f6656a : fVar;
            }
            Z3.b bVar = (Z3.b) cVar;
            return (!bVar.a(fVar.getKey()) || bVar.b(fVar) == null) ? fVar : j.f6656a;
        }
    }

    public static final class b implements i.c<f> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f6655a = new b();

        private b() {
        }
    }

    void D(e<?> eVar);

    <T> e<T> S(e<? super T> eVar);
}
