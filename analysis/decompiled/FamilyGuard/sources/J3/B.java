package J3;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class B {

    static final class a<T, R> extends x3.f<R> {

        /* renamed from: b, reason: collision with root package name */
        final T f3232b;

        /* renamed from: c, reason: collision with root package name */
        final D3.h<? super T, ? extends Q4.a<? extends R>> f3233c;

        a(T t5, D3.h<? super T, ? extends Q4.a<? extends R>> hVar) {
            this.f3232b = t5;
            this.f3233c = hVar;
        }

        @Override // x3.f
        public void W(Q4.b<? super R> bVar) {
            try {
                Q4.a aVar = (Q4.a) F3.b.d(this.f3233c.apply(this.f3232b), "The mapper returned a null Publisher");
                if (!(aVar instanceof Callable)) {
                    aVar.c(bVar);
                    return;
                }
                try {
                    Object objCall = ((Callable) aVar).call();
                    if (objCall == null) {
                        Q3.d.d(bVar);
                    } else {
                        bVar.e(new Q3.e(bVar, objCall));
                    }
                } catch (Throwable th) {
                    B3.b.b(th);
                    Q3.d.e(th, bVar);
                }
            } catch (Throwable th2) {
                Q3.d.e(th2, bVar);
            }
        }
    }

    public static <T, U> x3.f<U> a(T t5, D3.h<? super T, ? extends Q4.a<? extends U>> hVar) {
        return S3.a.l(new a(t5, hVar));
    }

    public static <T, R> boolean b(Q4.a<T> aVar, Q4.b<? super R> bVar, D3.h<? super T, ? extends Q4.a<? extends R>> hVar) {
        if (!(aVar instanceof Callable)) {
            return false;
        }
        try {
            A0.e eVar = (Object) ((Callable) aVar).call();
            if (eVar == null) {
                Q3.d.d(bVar);
                return true;
            }
            try {
                Q4.a aVar2 = (Q4.a) F3.b.d(hVar.apply(eVar), "The mapper returned a null Publisher");
                if (aVar2 instanceof Callable) {
                    try {
                        Object objCall = ((Callable) aVar2).call();
                        if (objCall == null) {
                            Q3.d.d(bVar);
                            return true;
                        }
                        bVar.e(new Q3.e(bVar, objCall));
                    } catch (Throwable th) {
                        B3.b.b(th);
                        Q3.d.e(th, bVar);
                        return true;
                    }
                } else {
                    aVar2.c(bVar);
                }
                return true;
            } catch (Throwable th2) {
                B3.b.b(th2);
                Q3.d.e(th2, bVar);
                return true;
            }
        } catch (Throwable th3) {
            B3.b.b(th3);
            Q3.d.e(th3, bVar);
            return true;
        }
    }
}
