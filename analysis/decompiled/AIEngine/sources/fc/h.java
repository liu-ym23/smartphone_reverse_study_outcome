package fc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    public final zb.a<T> f8813a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.l<T, T> f8814b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<T>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public T f8815a;

        /* renamed from: b, reason: collision with root package name */
        public int f8816b = -2;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h<T> f8817c;

        public a(h<T> hVar) {
            this.f8817c = hVar;
        }

        public final void a() {
            T tInvoke;
            int i10 = this.f8816b;
            h<T> hVar = this.f8817c;
            if (i10 == -2) {
                tInvoke = hVar.f8813a.invoke();
            } else {
                zb.l<T, T> lVar = hVar.f8814b;
                T t8 = this.f8815a;
                kotlin.jvm.internal.g.c(t8);
                tInvoke = lVar.invoke(t8);
            }
            this.f8815a = tInvoke;
            this.f8816b = tInvoke == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f8816b < 0) {
                a();
            }
            return this.f8816b == 1;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f8816b < 0) {
                a();
            }
            if (this.f8816b == 0) {
                throw new NoSuchElementException();
            }
            T t8 = this.f8815a;
            kotlin.jvm.internal.g.d(t8, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f8816b = -1;
            return t8;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public h(zb.l lVar, zb.a aVar) {
        this.f8813a = aVar;
        this.f8814b = lVar;
    }

    @Override // fc.i
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
