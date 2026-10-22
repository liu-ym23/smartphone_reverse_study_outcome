package K;

import K.p0;
import g3.InterfaceFutureC4095a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class A0<T> implements p0<T> {

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference<Object> f3854b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3853a = new Object();

    /* renamed from: c, reason: collision with root package name */
    public int f3855c = 0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3856d = false;

    /* renamed from: e, reason: collision with root package name */
    public final Map<p0.a<? super T>, b<T>> f3857e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArraySet<b<T>> f3858f = new CopyOnWriteArraySet<>();

    public static abstract class a {
        public static a b(Throwable th) {
            return new C0887j(th);
        }

        public abstract Throwable a();
    }

    public static final class b<T> implements Runnable {

        /* renamed from: h, reason: collision with root package name */
        public static final Object f3859h = new Object();

        /* renamed from: a, reason: collision with root package name */
        public final Executor f3860a;

        /* renamed from: b, reason: collision with root package name */
        public final p0.a<? super T> f3861b;

        /* renamed from: d, reason: collision with root package name */
        public final AtomicReference<Object> f3863d;

        /* renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f3862c = new AtomicBoolean(true);

        /* renamed from: e, reason: collision with root package name */
        public Object f3864e = f3859h;

        /* renamed from: f, reason: collision with root package name */
        public int f3865f = -1;

        /* renamed from: g, reason: collision with root package name */
        public boolean f3866g = false;

        public b(AtomicReference<Object> atomicReference, Executor executor, p0.a<? super T> aVar) {
            this.f3863d = atomicReference;
            this.f3860a = executor;
            this.f3861b = aVar;
        }

        public void a() {
            this.f3862c.set(false);
        }

        public void b(int i10) {
            synchronized (this) {
                try {
                    if (this.f3862c.get()) {
                        if (i10 <= this.f3865f) {
                            return;
                        }
                        this.f3865f = i10;
                        if (this.f3866g) {
                            return;
                        }
                        this.f3866g = true;
                        try {
                            this.f3860a.execute(this);
                        } catch (Throwable unused) {
                            synchronized (this) {
                                this.f3866g = false;
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (!this.f3862c.get()) {
                        this.f3866g = false;
                        return;
                    }
                    Object obj = this.f3863d.get();
                    int i10 = this.f3865f;
                    while (true) {
                        if (!Objects.equals(this.f3864e, obj)) {
                            this.f3864e = obj;
                            if (obj instanceof a) {
                                this.f3861b.onError(((a) obj).a());
                            } else {
                                this.f3861b.a(obj);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (i10 == this.f3865f || !this.f3862c.get()) {
                                    break;
                                }
                                obj = this.f3863d.get();
                                i10 = this.f3865f;
                            } finally {
                            }
                        }
                    }
                    this.f3866g = false;
                } finally {
                }
            }
        }
    }

    public A0(Object obj, boolean z10) {
        if (!z10) {
            this.f3854b = new AtomicReference<>(obj);
        } else {
            B0.h.b(obj instanceof Throwable, "Initial errors must be Throwable");
            this.f3854b = new AtomicReference<>(a.b((Throwable) obj));
        }
    }

    @Override // K.p0
    public void a(Executor executor, p0.a<? super T> aVar) {
        b<T> bVar;
        synchronized (this.f3853a) {
            d(aVar);
            bVar = new b<>(this.f3854b, executor, aVar);
            this.f3857e.put(aVar, bVar);
            this.f3858f.add(bVar);
        }
        bVar.b(0);
    }

    @Override // K.p0
    public InterfaceFutureC4095a<T> b() {
        Object obj = this.f3854b.get();
        return obj instanceof a ? O.f.f(((a) obj).a()) : O.f.h(obj);
    }

    @Override // K.p0
    public void c(p0.a<? super T> aVar) {
        synchronized (this.f3853a) {
            d(aVar);
        }
    }

    public final void d(p0.a<? super T> aVar) {
        b<T> bVarRemove = this.f3857e.remove(aVar);
        if (bVarRemove != null) {
            bVarRemove.a();
            this.f3858f.remove(bVarRemove);
        }
    }

    public void e(T t10) {
        f(t10);
    }

    public final void f(Object obj) {
        Iterator<b<T>> it;
        int i10;
        synchronized (this.f3853a) {
            try {
                if (Objects.equals(this.f3854b.getAndSet(obj), obj)) {
                    return;
                }
                int i11 = this.f3855c + 1;
                this.f3855c = i11;
                if (this.f3856d) {
                    return;
                }
                this.f3856d = true;
                Iterator<b<T>> it2 = this.f3858f.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        it2.next().b(i11);
                    } else {
                        synchronized (this.f3853a) {
                            try {
                                if (this.f3855c == i11) {
                                    this.f3856d = false;
                                    return;
                                } else {
                                    it = this.f3858f.iterator();
                                    i10 = this.f3855c;
                                }
                            } finally {
                            }
                        }
                        it2 = it;
                        i11 = i10;
                    }
                }
            } finally {
            }
        }
    }
}
