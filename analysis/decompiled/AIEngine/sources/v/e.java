package v;

import java.util.ConcurrentModificationException;
import u.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e<E> extends d<E> {

    /* renamed from: d, reason: collision with root package name */
    public final c<E> f13248d;

    /* renamed from: e, reason: collision with root package name */
    public E f13249e;
    public boolean h;

    /* renamed from: j, reason: collision with root package name */
    public int f13250j;

    /* JADX WARN: Illegal instructions before constructor call */
    public e(c<E> cVar) {
        Object obj = cVar.f13242b;
        f<E, a> fVar = cVar.f13244d;
        super(obj, fVar);
        this.f13248d = cVar;
        this.f13250j = fVar.f13115e;
    }

    @Override // v.d, java.util.Iterator
    public final E next() {
        if (this.f13248d.f13244d.f13115e != this.f13250j) {
            throw new ConcurrentModificationException();
        }
        E e10 = (E) super.next();
        this.f13249e = e10;
        this.h = true;
        return e10;
    }

    @Override // v.d, java.util.Iterator
    public final void remove() {
        if (!this.h) {
            throw new IllegalStateException();
        }
        E e10 = this.f13249e;
        c<E> cVar = this.f13248d;
        cVar.remove(e10);
        this.f13249e = null;
        this.h = false;
        this.f13250j = cVar.f13244d.f13115e;
        this.f13247c--;
    }
}
