package fc;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g<T, R, E> implements i<E> {

    /* renamed from: a, reason: collision with root package name */
    public final i<T> f8806a;

    /* renamed from: b, reason: collision with root package name */
    public final zb.l<T, R> f8807b;

    /* renamed from: c, reason: collision with root package name */
    public final com.stepos.core.common.telemetry.b f8808c;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<E>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator<T> f8809a;

        /* renamed from: b, reason: collision with root package name */
        public Iterator<? extends E> f8810b;

        /* renamed from: c, reason: collision with root package name */
        public int f8811c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g<T, R, E> f8812d;

        public a(g<T, R, E> gVar) {
            this.f8812d = gVar;
            this.f8809a = gVar.f8806a.iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it;
            Iterator<? extends E> it2 = this.f8810b;
            if (it2 != null && it2.hasNext()) {
                this.f8811c = 1;
                return true;
            }
            do {
                Iterator<T> it3 = this.f8809a;
                if (!it3.hasNext()) {
                    this.f8811c = 2;
                    this.f8810b = null;
                    return false;
                }
                T next = it3.next();
                g<T, R, E> gVar = this.f8812d;
                it = (Iterator) gVar.f8808c.invoke(gVar.f8807b.invoke(next));
            } while (!it.hasNext());
            this.f8810b = it;
            this.f8811c = 1;
            return true;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            int i10 = this.f8811c;
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
            return a();
        }

        @Override // java.util.Iterator
        public final E next() {
            int i10 = this.f8811c;
            if (i10 == 2) {
                throw new NoSuchElementException();
            }
            if (i10 == 0 && !a()) {
                throw new NoSuchElementException();
            }
            this.f8811c = 0;
            Iterator<? extends E> it = this.f8810b;
            kotlin.jvm.internal.g.c(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public g(i iVar, zb.l lVar, com.stepos.core.common.telemetry.b bVar) {
        this.f8806a = iVar;
        this.f8807b = lVar;
        this.f8808c = bVar;
    }

    @Override // fc.i
    public final Iterator<E> iterator() {
        return new a(this);
    }
}
