package androidx.concurrent.futures;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class FutureGarbageCollectedException extends Throwable {
        @Override // java.lang.Throwable
        public final synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        public Object f1022a;

        /* renamed from: b, reason: collision with root package name */
        public c<T> f1023b;

        /* renamed from: c, reason: collision with root package name */
        public d0.a<Void> f1024c = new d0.a<>();

        /* renamed from: d, reason: collision with root package name */
        public boolean f1025d;

        public final void a(Object obj) {
            this.f1025d = true;
            c<T> cVar = this.f1023b;
            if (cVar != null) {
                c.a aVar = cVar.f1027b;
                aVar.getClass();
                if (obj == null) {
                    obj = AbstractResolvableFuture.f1002j;
                }
                if (AbstractResolvableFuture.h.b(aVar, null, obj)) {
                    AbstractResolvableFuture.c(aVar);
                    this.f1022a = null;
                    this.f1023b = null;
                    this.f1024c = null;
                }
            }
        }

        public final void b(Throwable th) {
            this.f1025d = true;
            c<T> cVar = this.f1023b;
            if (cVar == null || !cVar.f1027b.i(th)) {
                return;
            }
            this.f1022a = null;
            this.f1023b = null;
            this.f1024c = null;
        }

        public final void finalize() {
            d0.a<Void> aVar;
            c<T> cVar = this.f1023b;
            if (cVar != null) {
                c.a aVar2 = cVar.f1027b;
                if (!aVar2.isDone()) {
                    aVar2.i(new FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.f1022a));
                }
            }
            if (this.f1025d || (aVar = this.f1024c) == null) {
                return;
            }
            aVar.j(null);
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface b<T> {
        Object c(a<T> aVar);
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class c<T> implements c5.a<T> {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<a<T>> f1026a;

        /* renamed from: b, reason: collision with root package name */
        public final a f1027b = new a();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        public class a extends AbstractResolvableFuture<T> {
            public a() {
            }

            @Override // androidx.concurrent.futures.AbstractResolvableFuture
            public final String g() {
                a<T> aVar = c.this.f1026a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.f1022a + "]";
            }
        }

        public c(a<T> aVar) {
            this.f1026a = new WeakReference<>(aVar);
        }

        @Override // c5.a
        public final void a(Runnable runnable, Executor executor) {
            this.f1027b.a(runnable, executor);
        }

        @Override // java.util.concurrent.Future
        public final boolean cancel(boolean z) {
            a<T> aVar = this.f1026a.get();
            boolean zCancel = this.f1027b.cancel(z);
            if (zCancel && aVar != null) {
                aVar.f1022a = null;
                aVar.f1023b = null;
                aVar.f1024c.j(null);
            }
            return zCancel;
        }

        @Override // java.util.concurrent.Future
        public final T get() {
            return this.f1027b.get();
        }

        @Override // java.util.concurrent.Future
        public final boolean isCancelled() {
            return this.f1027b.f1003a instanceof AbstractResolvableFuture.b;
        }

        @Override // java.util.concurrent.Future
        public final boolean isDone() {
            return this.f1027b.isDone();
        }

        public final String toString() {
            return this.f1027b.toString();
        }

        @Override // java.util.concurrent.Future
        public final T get(long j10, TimeUnit timeUnit) {
            return this.f1027b.get(j10, timeUnit);
        }
    }

    public static c a(b bVar) {
        a aVar = new a();
        c<T> cVar = new c<>(aVar);
        aVar.f1023b = cVar;
        aVar.f1022a = bVar.getClass();
        try {
            Object objC = bVar.c(aVar);
            if (objC == null) {
                return cVar;
            }
            aVar.f1022a = objC;
            return cVar;
        } catch (Exception e10) {
            cVar.f1027b.i(e10);
            return cVar;
        }
    }
}
