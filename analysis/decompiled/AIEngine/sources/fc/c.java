package fc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c<T> implements i<T>, d<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i<T> f8795a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8796b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<T>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f8797a;

        /* renamed from: b, reason: collision with root package name */
        public int f8798b;

        public a(c<T> cVar) {
            this.f8797a = cVar.f8795a.iterator();
            this.f8798b = cVar.f8796b;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            Iterator<T> it;
            while (true) {
                int i10 = this.f8798b;
                it = this.f8797a;
                if (i10 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f8798b--;
            }
            return it.hasNext();
        }

        @Override // java.util.Iterator
        public final T next() {
            Iterator<T> it;
            while (true) {
                int i10 = this.f8798b;
                it = this.f8797a;
                if (i10 <= 0 || !it.hasNext()) {
                    break;
                }
                it.next();
                this.f8798b--;
            }
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(i<? extends T> sequence, int i10) {
        kotlin.jvm.internal.g.f(sequence, "sequence");
        this.f8795a = sequence;
        this.f8796b = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // fc.d
    public final i<T> a(int i10) {
        int i11 = this.f8796b + i10;
        return i11 < 0 ? new c(this, i10) : new c(this.f8795a, i11);
    }

    @Override // fc.i
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
