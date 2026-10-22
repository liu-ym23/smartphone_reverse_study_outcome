package androidx.concurrent.futures;

import g3.InterfaceFutureC4095a;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import k0.C4797a;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public static final class FutureGarbageCollectedException extends Throwable {
        public FutureGarbageCollectedException(String str) {
            super(str);
        }

        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public Object f11829a;

        /* renamed from: b, reason: collision with root package name */
        public c<T> f11830b;

        /* renamed from: c, reason: collision with root package name */
        public C4797a<Void> f11831c = C4797a.s();

        /* renamed from: d, reason: collision with root package name */
        public boolean f11832d;

        public void a(Runnable runnable, Executor executor) {
            C4797a<Void> c4797a = this.f11831c;
            if (c4797a != null) {
                c4797a.a(runnable, executor);
            }
        }

        public void b() {
            this.f11829a = null;
            this.f11830b = null;
            this.f11831c.p(null);
        }

        public boolean c(T t10) {
            this.f11832d = true;
            c<T> cVar = this.f11830b;
            boolean z10 = cVar != null && cVar.c(t10);
            if (z10) {
                e();
            }
            return z10;
        }

        public boolean d() {
            this.f11832d = true;
            c<T> cVar = this.f11830b;
            boolean z10 = cVar != null && cVar.b(true);
            if (z10) {
                e();
            }
            return z10;
        }

        public final void e() {
            this.f11829a = null;
            this.f11830b = null;
            this.f11831c = null;
        }

        public boolean f(Throwable th) {
            this.f11832d = true;
            c<T> cVar = this.f11830b;
            boolean z10 = cVar != null && cVar.d(th);
            if (z10) {
                e();
            }
            return z10;
        }

        public void finalize() {
            C4797a<Void> c4797a;
            c<T> cVar = this.f11830b;
            if (cVar != null && !cVar.isDone()) {
                cVar.d(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f11829a));
            }
            if (this.f11832d || (c4797a = this.f11831c) == null) {
                return;
            }
            c4797a.p(null);
        }
    }

    public interface b<T> {
        Object a(a<T> aVar) throws Exception;
    }

    public static final class c<T> implements InterfaceFutureC4095a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<a<T>> f11833a;

        /* renamed from: b, reason: collision with root package name */
        public final AbstractResolvableFuture<T> f11834b = new a();

        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public String m() {
                a<T> aVar = c.this.f11833a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f11829a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f11833a = new WeakReference<>(aVar);
        }

        @Override // g3.InterfaceFutureC4095a
        public void a(Runnable runnable, Executor executor) {
            this.f11834b.a(runnable, executor);
        }

        public boolean b(boolean z10) {
            return this.f11834b.cancel(z10);
        }

        public boolean c(T t10) {
            return this.f11834b.p(t10);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            a<T> aVar = this.f11833a.get();
            boolean zCancel = this.f11834b.cancel(z10);
            if (zCancel && aVar != null) {
                aVar.b();
            }
            return zCancel;
        }

        public boolean d(Throwable th) {
            return this.f11834b.q(th);
        }

        @Override // java.util.concurrent.Future
        public T get() throws ExecutionException, InterruptedException {
            return this.f11834b.get();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f11834b.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f11834b.isDone();
        }

        public String toString() {
            return this.f11834b.toString();
        }

        @Override // java.util.concurrent.Future
        public T get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return this.f11834b.get(j10, timeUnit);
        }
    }

    public static <T> InterfaceFutureC4095a<T> a(b<T> bVar) {
        a<T> aVar = new a<>();
        c<T> cVar = new c<>(aVar);
        aVar.f11830b = cVar;
        aVar.f11829a = bVar.getClass();
        try {
            Object objA = bVar.a(aVar);
            if (objA == null) {
                return cVar;
            }
            aVar.f11829a = objA;
            return cVar;
        } catch (Exception e10) {
            cVar.d(e10);
            return cVar;
        }
    }
}
