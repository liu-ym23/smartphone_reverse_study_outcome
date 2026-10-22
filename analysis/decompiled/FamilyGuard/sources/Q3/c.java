package Q3;

/* loaded from: classes.dex */
public class c<T> extends a<T> {

    /* renamed from: a, reason: collision with root package name */
    protected final Q4.b<? super T> f4919a;

    /* renamed from: b, reason: collision with root package name */
    protected T f4920b;

    public c(Q4.b<? super T> bVar) {
        this.f4919a = bVar;
    }

    @Override // G3.b
    public final int b(int i5) {
        if ((i5 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final void c(T t5) {
        int i5 = get();
        while (i5 != 8) {
            if ((i5 & (-3)) != 0) {
                return;
            }
            if (i5 == 2) {
                lazySet(3);
                Q4.b<? super T> bVar = this.f4919a;
                bVar.d(t5);
                if (get() != 4) {
                    bVar.a();
                    return;
                }
                return;
            }
            this.f4920b = t5;
            if (compareAndSet(0, 1)) {
                return;
            }
            i5 = get();
            if (i5 == 4) {
                this.f4920b = null;
                return;
            }
        }
        this.f4920b = t5;
        lazySet(16);
        Q4.b<? super T> bVar2 = this.f4919a;
        bVar2.d(t5);
        if (get() != 4) {
            bVar2.a();
        }
    }

    @Override // Q4.c
    public void cancel() {
        set(4);
        this.f4920b = null;
    }

    @Override // G3.f
    public final void clear() {
        lazySet(32);
        this.f4920b = null;
    }

    public final boolean g() {
        return get() == 4;
    }

    @Override // Q4.c
    public final void h(long j5) {
        T t5;
        if (g.k(j5)) {
            do {
                int i5 = get();
                if ((i5 & (-2)) != 0) {
                    return;
                }
                if (i5 == 1) {
                    if (!compareAndSet(1, 3) || (t5 = this.f4920b) == null) {
                        return;
                    }
                    this.f4920b = null;
                    Q4.b<? super T> bVar = this.f4919a;
                    bVar.d(t5);
                    if (get() != 4) {
                        bVar.a();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // G3.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // G3.f
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t5 = this.f4920b;
        this.f4920b = null;
        return t5;
    }
}
