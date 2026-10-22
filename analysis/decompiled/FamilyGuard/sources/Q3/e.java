package Q3;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public final class e<T> extends AtomicInteger implements G3.c<T> {

    /* renamed from: a, reason: collision with root package name */
    final T f4923a;

    /* renamed from: b, reason: collision with root package name */
    final Q4.b<? super T> f4924b;

    public e(Q4.b<? super T> bVar, T t5) {
        this.f4924b = bVar;
        this.f4923a = t5;
    }

    @Override // G3.b
    public int b(int i5) {
        return i5 & 1;
    }

    @Override // Q4.c
    public void cancel() {
        lazySet(2);
    }

    @Override // G3.f
    public void clear() {
        lazySet(1);
    }

    @Override // Q4.c
    public void h(long j5) {
        if (g.k(j5) && compareAndSet(0, 1)) {
            Q4.b<? super T> bVar = this.f4924b;
            bVar.d(this.f4923a);
            if (get() != 2) {
                bVar.a();
            }
        }
    }

    @Override // G3.f
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // G3.f
    public boolean offer(T t5) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // G3.f
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.f4923a;
    }
}
