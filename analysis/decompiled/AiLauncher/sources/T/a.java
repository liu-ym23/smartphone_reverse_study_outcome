package T;

import java.util.ArrayDeque;

/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f5819a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque<T> f5820b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f5821c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public final b<T> f5822d;

    public a(int i10, b<T> bVar) {
        this.f5819a = i10;
        this.f5820b = new ArrayDeque<>(i10);
        this.f5822d = bVar;
    }

    public T a() {
        T tRemoveLast;
        synchronized (this.f5821c) {
            tRemoveLast = this.f5820b.removeLast();
        }
        return tRemoveLast;
    }

    public void b(T t10) {
        T tA;
        synchronized (this.f5821c) {
            try {
                tA = this.f5820b.size() >= this.f5819a ? a() : null;
                this.f5820b.addFirst(t10);
            } catch (Throwable th) {
                throw th;
            }
        }
        b<T> bVar = this.f5822d;
        if (bVar == null || tA == null) {
            return;
        }
        bVar.a(tA);
    }

    public boolean c() {
        boolean zIsEmpty;
        synchronized (this.f5821c) {
            zIsEmpty = this.f5820b.isEmpty();
        }
        return zIsEmpty;
    }
}
