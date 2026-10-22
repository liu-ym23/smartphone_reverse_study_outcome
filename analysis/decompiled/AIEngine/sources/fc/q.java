package fc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class q<T, R> implements i<R> {

    /* renamed from: a, reason: collision with root package name */
    public final i<T> f8828a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.l<T, R> f8829b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<R>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f8830a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q<T, R> f8831b;

        public a(q<T, R> qVar) {
            this.f8831b = qVar;
            this.f8830a = qVar.f8828a.iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f8830a.hasNext();
        }

        @Override // java.util.Iterator
        public final R next() {
            return (R) this.f8831b.f8829b.invoke(this.f8830a.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q(i<? extends T> iVar, zb.l<? super T, ? extends R> lVar) {
        this.f8828a = iVar;
        this.f8829b = lVar;
    }

    @Override // fc.i
    public final Iterator<R> iterator() {
        return new a(this);
    }
}
