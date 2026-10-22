package C4;

import C4.C;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private Runnable f937c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ExecutorService f938d;

    /* renamed from: a, reason: collision with root package name */
    private int f935a = 64;

    /* renamed from: b, reason: collision with root package name */
    private int f936b = 5;

    /* renamed from: e, reason: collision with root package name */
    private final Deque<C.a> f939e = new ArrayDeque();

    /* renamed from: f, reason: collision with root package name */
    private final Deque<C.a> f940f = new ArrayDeque();

    /* renamed from: g, reason: collision with root package name */
    private final Deque<C> f941g = new ArrayDeque();

    @Nullable
    private C.a d(String str) {
        for (C.a aVar : this.f940f) {
            if (aVar.o().equals(str)) {
                return aVar;
            }
        }
        for (C.a aVar2 : this.f939e) {
            if (aVar2.o().equals(str)) {
                return aVar2;
            }
        }
        return null;
    }

    private <T> void g(Deque<T> deque, T t5) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t5)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f937c;
        }
        if (h() || runnable == null) {
            return;
        }
        runnable.run();
    }

    private boolean h() {
        int i5;
        boolean z5;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator<C.a> it = this.f939e.iterator();
                while (it.hasNext()) {
                    C.a next = it.next();
                    if (this.f940f.size() >= this.f935a) {
                        break;
                    }
                    if (next.l().get() < this.f936b) {
                        it.remove();
                        next.l().incrementAndGet();
                        arrayList.add(next);
                        this.f940f.add(next);
                    }
                }
                z5 = i() > 0;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i5 = 0; i5 < size; i5++) {
            ((C.a) arrayList.get(i5)).m(c());
        }
        return z5;
    }

    void a(C.a aVar) {
        C.a aVarD;
        synchronized (this) {
            try {
                this.f939e.add(aVar);
                if (!aVar.n().f674d && (aVarD = d(aVar.o())) != null) {
                    aVar.p(aVarD);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        h();
    }

    synchronized void b(C c6) {
        this.f941g.add(c6);
    }

    public synchronized ExecutorService c() {
        try {
            if (this.f938d == null) {
                this.f938d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), D4.e.H("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f938d;
    }

    void e(C.a aVar) {
        aVar.l().decrementAndGet();
        g(this.f940f, aVar);
    }

    void f(C c6) {
        g(this.f941g, c6);
    }

    public synchronized int i() {
        return this.f940f.size() + this.f941g.size();
    }
}
