package fc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    public final i<T> f8800a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.l<T, Boolean> f8801b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<T>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f8802a;

        /* renamed from: b, reason: collision with root package name */
        public int f8803b = -1;

        /* renamed from: c, reason: collision with root package name */
        public T f8804c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f<T> f8805d;

        public a(f<T> fVar) {
            this.f8805d = fVar;
            this.f8802a = fVar.f8800a.iterator();
        }

        public final void a() {
            T next;
            boolean zBooleanValue;
            do {
                Iterator<T> it = this.f8802a;
                if (!it.hasNext()) {
                    this.f8803b = 0;
                    return;
                }
                next = it.next();
                f<T> fVar = this.f8805d;
                zBooleanValue = fVar.f8801b.invoke(next).booleanValue();
                fVar.getClass();
            } while (!zBooleanValue);
            this.f8804c = next;
            this.f8803b = 1;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f8803b == -1) {
                a();
            }
            return this.f8803b == 1;
        }

        @Override // java.util.Iterator
        public final T next() {
            if (this.f8803b == -1) {
                a();
            }
            if (this.f8803b == 0) {
                throw new NoSuchElementException();
            }
            T t8 = this.f8804c;
            this.f8804c = null;
            this.f8803b = -1;
            return t8;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public f(i iVar, zb.l lVar) {
        this.f8800a = iVar;
        this.f8801b = lVar;
    }

    @Override // fc.i
    public final Iterator<T> iterator() {
        return new a(this);
    }
}
