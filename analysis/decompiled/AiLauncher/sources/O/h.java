package O;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import g3.InterfaceFutureC4095a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class h<V> implements InterfaceFutureC4095a<List<V>> {

    /* renamed from: a, reason: collision with root package name */
    public List<? extends InterfaceFutureC4095a<? extends V>> f5121a;

    /* renamed from: b, reason: collision with root package name */
    public List<V> f5122b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f5123c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f5124d;

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceFutureC4095a<List<V>> f5125e = CallbackToFutureAdapter.a(new a());

    /* renamed from: f, reason: collision with root package name */
    public CallbackToFutureAdapter.a<List<V>> f5126f;

    public class a implements CallbackToFutureAdapter.b<List<V>> {
        public a() {
        }

        @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
        public Object a(CallbackToFutureAdapter.a<List<V>> aVar) {
            B0.h.i(h.this.f5126f == null, "The result can only set once!");
            h.this.f5126f = aVar;
            return "ListFuture[" + this + "]";
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h hVar = h.this;
            hVar.f5122b = null;
            hVar.f5121a = null;
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f5129a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceFutureC4095a f5130b;

        public c(int i10, InterfaceFutureC4095a interfaceFutureC4095a) {
            this.f5129a = i10;
            this.f5130b = interfaceFutureC4095a;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.f(this.f5129a, this.f5130b);
        }
    }

    public h(List<? extends InterfaceFutureC4095a<? extends V>> list, boolean z10, Executor executor) {
        this.f5121a = (List) B0.h.f(list);
        this.f5122b = new ArrayList(list.size());
        this.f5123c = z10;
        this.f5124d = new AtomicInteger(list.size());
        e(executor);
    }

    @Override // g3.InterfaceFutureC4095a
    public void a(Runnable runnable, Executor executor) {
        this.f5125e.a(runnable, executor);
    }

    public final void b() throws InterruptedException {
        List<? extends InterfaceFutureC4095a<? extends V>> list = this.f5121a;
        if (list == null || isDone()) {
            return;
        }
        for (InterfaceFutureC4095a<? extends V> interfaceFutureC4095a : list) {
            while (!interfaceFutureC4095a.isDone()) {
                try {
                    interfaceFutureC4095a.get();
                } catch (Error e10) {
                    throw e10;
                } catch (InterruptedException e11) {
                    throw e11;
                } catch (Throwable unused) {
                    if (this.f5123c) {
                        return;
                    }
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public List<V> get() throws ExecutionException, InterruptedException {
        b();
        return this.f5125e.get();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        List<? extends InterfaceFutureC4095a<? extends V>> list = this.f5121a;
        if (list != null) {
            Iterator<? extends InterfaceFutureC4095a<? extends V>> it = list.iterator();
            while (it.hasNext()) {
                it.next().cancel(z10);
            }
        }
        return this.f5125e.cancel(z10);
    }

    @Override // java.util.concurrent.Future
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public List<V> get(long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.f5125e.get(j10, timeUnit);
    }

    public final void e(Executor executor) {
        a(new b(), N.a.a());
        if (this.f5121a.isEmpty()) {
            this.f5126f.c(new ArrayList(this.f5122b));
            return;
        }
        for (int i10 = 0; i10 < this.f5121a.size(); i10++) {
            this.f5122b.add(null);
        }
        List<? extends InterfaceFutureC4095a<? extends V>> list = this.f5121a;
        for (int i11 = 0; i11 < list.size(); i11++) {
            InterfaceFutureC4095a<? extends V> interfaceFutureC4095a = list.get(i11);
            interfaceFutureC4095a.a(new c(i11, interfaceFutureC4095a), executor);
        }
    }

    public void f(int i10, Future<? extends V> future) {
        CallbackToFutureAdapter.a<List<V>> aVar;
        ArrayList arrayList;
        List<V> list = this.f5122b;
        if (isDone() || list == null) {
            B0.h.i(this.f5123c, "Future was done before all dependencies completed");
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            B0.h.i(future.isDone(), "Tried to set value from future which is not done");
                            list.set(i10, f.e(future));
                            int iDecrementAndGet = this.f5124d.decrementAndGet();
                            B0.h.i(iDecrementAndGet >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet == 0) {
                                List<V> list2 = this.f5122b;
                                if (list2 != null) {
                                    this.f5126f.c(new ArrayList(list2));
                                } else {
                                    B0.h.h(isDone());
                                }
                            }
                        } catch (ExecutionException e10) {
                            if (this.f5123c) {
                                this.f5126f.f(e10.getCause());
                            }
                            int iDecrementAndGet2 = this.f5124d.decrementAndGet();
                            B0.h.i(iDecrementAndGet2 >= 0, "Less than 0 remaining futures");
                            if (iDecrementAndGet2 == 0) {
                                List<V> list3 = this.f5122b;
                                if (list3 != null) {
                                    aVar = this.f5126f;
                                    arrayList = new ArrayList(list3);
                                    aVar.c(arrayList);
                                    return;
                                }
                                B0.h.h(isDone());
                            }
                        }
                    } catch (CancellationException unused) {
                        if (this.f5123c) {
                            cancel(false);
                        }
                        int iDecrementAndGet3 = this.f5124d.decrementAndGet();
                        B0.h.i(iDecrementAndGet3 >= 0, "Less than 0 remaining futures");
                        if (iDecrementAndGet3 == 0) {
                            List<V> list4 = this.f5122b;
                            if (list4 != null) {
                                aVar = this.f5126f;
                                arrayList = new ArrayList(list4);
                                aVar.c(arrayList);
                                return;
                            }
                            B0.h.h(isDone());
                        }
                    }
                } catch (Error e11) {
                    this.f5126f.f(e11);
                    int iDecrementAndGet4 = this.f5124d.decrementAndGet();
                    B0.h.i(iDecrementAndGet4 >= 0, "Less than 0 remaining futures");
                    if (iDecrementAndGet4 == 0) {
                        List<V> list5 = this.f5122b;
                        if (list5 != null) {
                            aVar = this.f5126f;
                            arrayList = new ArrayList(list5);
                            aVar.c(arrayList);
                            return;
                        }
                        B0.h.h(isDone());
                    }
                }
            } catch (RuntimeException e12) {
                if (this.f5123c) {
                    this.f5126f.f(e12);
                }
                int iDecrementAndGet5 = this.f5124d.decrementAndGet();
                B0.h.i(iDecrementAndGet5 >= 0, "Less than 0 remaining futures");
                if (iDecrementAndGet5 == 0) {
                    List<V> list6 = this.f5122b;
                    if (list6 != null) {
                        aVar = this.f5126f;
                        arrayList = new ArrayList(list6);
                        aVar.c(arrayList);
                        return;
                    }
                    B0.h.h(isDone());
                }
            }
        } catch (Throwable th) {
            int iDecrementAndGet6 = this.f5124d.decrementAndGet();
            B0.h.i(iDecrementAndGet6 >= 0, "Less than 0 remaining futures");
            if (iDecrementAndGet6 == 0) {
                List<V> list7 = this.f5122b;
                if (list7 != null) {
                    this.f5126f.c(new ArrayList(list7));
                } else {
                    B0.h.h(isDone());
                }
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f5125e.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f5125e.isDone();
    }
}
