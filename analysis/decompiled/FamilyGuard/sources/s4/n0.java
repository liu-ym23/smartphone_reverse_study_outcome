package s4;

import Z3.i;
import i4.InterfaceC0772l;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public interface n0 extends i.b {

    /* renamed from: P, reason: collision with root package name */
    public static final b f20363P = b.f20364a;

    public static final class a {
        public static /* synthetic */ void a(n0 n0Var, CancellationException cancellationException, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i5 & 1) != 0) {
                cancellationException = null;
            }
            n0Var.X(cancellationException);
        }

        public static <R> R b(n0 n0Var, R r5, i4.p<? super R, ? super i.b, ? extends R> pVar) {
            return (R) i.b.a.a(n0Var, r5, pVar);
        }

        public static <E extends i.b> E c(n0 n0Var, i.c<E> cVar) {
            return (E) i.b.a.b(n0Var, cVar);
        }

        public static Z3.i d(n0 n0Var, i.c<?> cVar) {
            return i.b.a.c(n0Var, cVar);
        }

        public static Z3.i e(n0 n0Var, Z3.i iVar) {
            return i.b.a.d(n0Var, iVar);
        }
    }

    public static final class b implements i.c<n0> {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f20364a = new b();

        private b() {
        }
    }

    void X(CancellationException cancellationException);

    boolean c();

    n0 getParent();

    InterfaceC1089q m(InterfaceC1090s interfaceC1090s);

    boolean start();

    X u(InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l);

    CancellationException w();

    X x(boolean z5, boolean z6, InterfaceC0772l<? super Throwable, V3.v> interfaceC0772l);
}
