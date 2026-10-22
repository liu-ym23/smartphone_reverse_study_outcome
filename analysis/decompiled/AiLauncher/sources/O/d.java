package O;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import m.InterfaceC4887a;

/* loaded from: classes.dex */
public class d<V> implements InterfaceFutureC4095a<V> {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceFutureC4095a<V> f5107a;

    /* renamed from: b, reason: collision with root package name */
    public CallbackToFutureAdapter.a<V> f5108b;

    public class a implements CallbackToFutureAdapter.b<V> {
        public a() {
        }

        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public Object a(CallbackToFutureAdapter.a<V> aVar) {
            B0.h.i(d.this.f5108b == null, "The result can only set once!");
            d.this.f5108b = aVar;
            return "FutureChain[" + d.this + "]";
        }
    }

    public d(InterfaceFutureC4095a<V> interfaceFutureC4095a) {
        this.f5107a = (InterfaceFutureC4095a) B0.h.f(interfaceFutureC4095a);
    }

    public static <V> d<V> b(InterfaceFutureC4095a<V> interfaceFutureC4095a) {
        return interfaceFutureC4095a instanceof d ? (d) interfaceFutureC4095a : new d<>(interfaceFutureC4095a);
    }

    @Override // g3.InterfaceFutureC4095a
    public void a(Runnable runnable, Executor executor) {
        this.f5107a.a(runnable, executor);
    }

    public boolean c(V v10) {
        CallbackToFutureAdapter.a<V> aVar = this.f5108b;
        if (aVar != null) {
            return aVar.c(v10);
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return this.f5107a.cancel(z10);
    }

    public boolean d(Throwable th) {
        CallbackToFutureAdapter.a<V> aVar = this.f5108b;
        if (aVar != null) {
            return aVar.f(th);
        }
        return false;
    }

    public final <T> d<T> e(InterfaceC4887a<? super V, T> interfaceC4887a, Executor executor) {
        return (d) f.n(this, interfaceC4887a, executor);
    }

    public final <T> d<T> f(O.a<? super V, T> aVar, Executor executor) {
        return (d) f.o(this, aVar, executor);
    }

    @Override // java.util.concurrent.Future
    public V get() throws ExecutionException, InterruptedException {
        return this.f5107a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f5107a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f5107a.isDone();
    }

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f5107a.get(j10, timeUnit);
    }

    public d() {
        this.f5107a = CallbackToFutureAdapter.a(new a());
    }
}
