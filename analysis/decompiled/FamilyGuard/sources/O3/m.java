package O3;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes.dex */
public final class m extends AtomicReferenceArray<Object> implements Runnable, Callable<Object>, A3.c {

    /* renamed from: b, reason: collision with root package name */
    static final Object f4417b = new Object();

    /* renamed from: c, reason: collision with root package name */
    static final Object f4418c = new Object();

    /* renamed from: d, reason: collision with root package name */
    static final Object f4419d = new Object();

    /* renamed from: e, reason: collision with root package name */
    static final Object f4420e = new Object();

    /* renamed from: a, reason: collision with root package name */
    final Runnable f4421a;

    public m(Runnable runnable, E3.a aVar) {
        super(3);
        this.f4421a = runnable;
        lazySet(0, aVar);
    }

    public void a(Future<?> future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == f4420e) {
                return;
            }
            if (obj == f4418c) {
                future.cancel(false);
                return;
            } else if (obj == f4419d) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // java.util.concurrent.Callable
    public Object call() {
        run();
        return null;
    }

    @Override // A3.c
    public void dispose() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        while (true) {
            Object obj5 = get(1);
            if (obj5 == f4420e || obj5 == (obj3 = f4418c) || obj5 == (obj4 = f4419d)) {
                break;
            }
            boolean z5 = get(2) != Thread.currentThread();
            if (z5) {
                obj3 = obj4;
            }
            if (compareAndSet(1, obj5, obj3)) {
                if (obj5 != null) {
                    ((Future) obj5).cancel(z5);
                }
            }
        }
        do {
            obj = get(0);
            if (obj == f4420e || obj == (obj2 = f4417b) || obj == null) {
                return;
            }
        } while (!compareAndSet(0, obj, obj2));
        ((E3.a) obj).b(this);
    }

    @Override // A3.c
    public boolean g() {
        Object obj = get(0);
        return obj == f4417b || obj == f4420e;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        boolean zCompareAndSet;
        Object obj4;
        Object obj5;
        lazySet(2, Thread.currentThread());
        try {
            this.f4421a.run();
        } finally {
            try {
                lazySet(2, null);
                obj4 = get(0);
                if (obj4 != f4417b) {
                    ((E3.a) obj4).b(this);
                }
                do {
                    obj5 = get(1);
                    if (obj5 != f4418c) {
                        return;
                    } else {
                        return;
                    }
                } while (!compareAndSet(1, obj5, f4420e));
            } catch (Throwable th) {
                do {
                    if (obj == obj2) {
                        break;
                    } else if (obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        obj4 = get(0);
        if (obj4 != f4417b && compareAndSet(0, obj4, f4420e) && obj4 != null) {
            ((E3.a) obj4).b(this);
        }
        do {
            obj5 = get(1);
            if (obj5 != f4418c || obj5 == f4419d) {
                return;
            }
        } while (!compareAndSet(1, obj5, f4420e));
    }
}
