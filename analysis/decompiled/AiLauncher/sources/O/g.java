package O;

import D.C0761b0;
import g3.InterfaceFutureC4095a;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class g<V> implements InterfaceFutureC4095a<V> {

    public static class a<V> extends g<V> {

        /* renamed from: a, reason: collision with root package name */
        public final Throwable f5118a;

        public a(Throwable th) {
            this.f5118a = th;
        }

        @Override // O.g, java.util.concurrent.Future
        public V get() throws ExecutionException {
            throw new ExecutionException(this.f5118a);
        }

        public String toString() {
            return super.toString() + "[status=FAILURE, cause=[" + this.f5118a + "]]";
        }
    }

    public static final class b<V> extends a<V> implements ScheduledFuture<V> {
        public b(Throwable th) {
            super(th);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(Delayed delayed) {
            return -1;
        }

        @Override // java.util.concurrent.Delayed
        public long getDelay(TimeUnit timeUnit) {
            return 0L;
        }
    }

    public static final class c<V> extends g<V> {

        /* renamed from: b, reason: collision with root package name */
        public static final g<Object> f5119b = new c(null);

        /* renamed from: a, reason: collision with root package name */
        public final V f5120a;

        public c(V v10) {
            this.f5120a = v10;
        }

        @Override // O.g, java.util.concurrent.Future
        public V get() {
            return this.f5120a;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f5120a + "]]";
        }
    }

    public static <V> InterfaceFutureC4095a<V> b() {
        return c.f5119b;
    }

    @Override // g3.InterfaceFutureC4095a
    public void a(Runnable runnable, Executor executor) {
        B0.h.f(runnable);
        B0.h.f(executor);
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            C0761b0.d("ImmediateFuture", "Experienced RuntimeException while attempting to notify " + runnable + " on Executor " + executor, e10);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j10, TimeUnit timeUnit) throws ExecutionException {
        B0.h.f(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
