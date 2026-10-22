package O;

import O.g;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.autonavi.aps.amapapi.config.Const;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import m.InterfaceC4887a;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC4887a<?, ?> f5111a = new b();

    /* JADX INFO: Add missing generic type declarations: [I, O] */
    public class a<I, O> implements O.a<I, O> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC4887a f5112a;

        public a(InterfaceC4887a interfaceC4887a) {
            this.f5112a = interfaceC4887a;
        }

        @Override // O.a
        public InterfaceFutureC4095a<O> apply(I i10) {
            return f.h(this.f5112a.apply(i10));
        }
    }

    public class b implements InterfaceC4887a<Object, Object> {
        @Override // m.InterfaceC4887a
        public Object apply(Object obj) {
            return obj;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class c<I> implements O.c<I> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5113a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC4887a f5114b;

        public c(CallbackToFutureAdapter.a aVar, InterfaceC4887a interfaceC4887a) {
            this.f5113a = aVar;
            this.f5114b = interfaceC4887a;
        }

        @Override // O.c
        public void a(I i10) {
            try {
                this.f5113a.c(this.f5114b.apply(i10));
            } catch (Throwable th) {
                this.f5113a.f(th);
            }
        }

        @Override // O.c
        public void b(Throwable th) {
            this.f5113a.f(th);
        }
    }

    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceFutureC4095a f5115a;

        public d(InterfaceFutureC4095a interfaceFutureC4095a) {
            this.f5115a = interfaceFutureC4095a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5115a.cancel(true);
        }
    }

    public static final class e<V> implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final Future<V> f5116a;

        /* renamed from: b, reason: collision with root package name */
        public final O.c<? super V> f5117b;

        public e(Future<V> future, O.c<? super V> cVar) {
            this.f5116a = future;
            this.f5117b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5117b.a(f.d(this.f5116a));
            } catch (Error | RuntimeException e10) {
                this.f5117b.b(e10);
            } catch (ExecutionException e11) {
                Throwable cause = e11.getCause();
                if (cause == null) {
                    this.f5117b.b(e11);
                } else {
                    this.f5117b.b(cause);
                }
            }
        }

        public String toString() {
            return e.class.getSimpleName() + Const.STR_MART_COMMA + this.f5117b;
        }
    }

    public static /* synthetic */ Object a(InterfaceFutureC4095a interfaceFutureC4095a, CallbackToFutureAdapter.a aVar) {
        l(false, interfaceFutureC4095a, f5111a, aVar, N.a.a());
        return "nonCancellationPropagating[" + interfaceFutureC4095a + "]";
    }

    public static <V> void b(InterfaceFutureC4095a<V> interfaceFutureC4095a, O.c<? super V> cVar, Executor executor) {
        B0.h.f(cVar);
        interfaceFutureC4095a.a(new e(interfaceFutureC4095a, cVar), executor);
    }

    public static <V> InterfaceFutureC4095a<List<V>> c(Collection<? extends InterfaceFutureC4095a<? extends V>> collection) {
        return new h(new ArrayList(collection), true, N.a.a());
    }

    public static <V> V d(Future<V> future) throws ExecutionException {
        B0.h.i(future.isDone(), "Future was expected to be done, " + future);
        return (V) e(future);
    }

    public static <V> V e(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    public static <V> InterfaceFutureC4095a<V> f(Throwable th) {
        return new g.a(th);
    }

    public static <V> ScheduledFuture<V> g(Throwable th) {
        return new g.b(th);
    }

    public static <V> InterfaceFutureC4095a<V> h(V v10) {
        return v10 == null ? g.b() : new g.c(v10);
    }

    public static <V> InterfaceFutureC4095a<V> i(final InterfaceFutureC4095a<V> interfaceFutureC4095a) {
        B0.h.f(interfaceFutureC4095a);
        return interfaceFutureC4095a.isDone() ? interfaceFutureC4095a : CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: O.e
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return f.a(interfaceFutureC4095a, aVar);
            }
        });
    }

    public static <V> void j(InterfaceFutureC4095a<V> interfaceFutureC4095a, CallbackToFutureAdapter.a<V> aVar) {
        k(interfaceFutureC4095a, f5111a, aVar, N.a.a());
    }

    public static <I, O> void k(InterfaceFutureC4095a<I> interfaceFutureC4095a, InterfaceC4887a<? super I, ? extends O> interfaceC4887a, CallbackToFutureAdapter.a<O> aVar, Executor executor) {
        l(true, interfaceFutureC4095a, interfaceC4887a, aVar, executor);
    }

    public static <I, O> void l(boolean z10, InterfaceFutureC4095a<I> interfaceFutureC4095a, InterfaceC4887a<? super I, ? extends O> interfaceC4887a, CallbackToFutureAdapter.a<O> aVar, Executor executor) {
        B0.h.f(interfaceFutureC4095a);
        B0.h.f(interfaceC4887a);
        B0.h.f(aVar);
        B0.h.f(executor);
        b(interfaceFutureC4095a, new c(aVar, interfaceC4887a), executor);
        if (z10) {
            aVar.a(new d(interfaceFutureC4095a), N.a.a());
        }
    }

    public static <V> InterfaceFutureC4095a<List<V>> m(Collection<? extends InterfaceFutureC4095a<? extends V>> collection) {
        return new h(new ArrayList(collection), false, N.a.a());
    }

    public static <I, O> InterfaceFutureC4095a<O> n(InterfaceFutureC4095a<I> interfaceFutureC4095a, InterfaceC4887a<? super I, ? extends O> interfaceC4887a, Executor executor) {
        B0.h.f(interfaceC4887a);
        return o(interfaceFutureC4095a, new a(interfaceC4887a), executor);
    }

    public static <I, O> InterfaceFutureC4095a<O> o(InterfaceFutureC4095a<I> interfaceFutureC4095a, O.a<? super I, ? extends O> aVar, Executor executor) {
        O.b bVar = new O.b(aVar, interfaceFutureC4095a);
        interfaceFutureC4095a.a(bVar, executor);
        return bVar;
    }
}
