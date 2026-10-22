package v;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class d<E> implements Iterator<E>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public Object f13245a;

    /* renamed from: b, reason: collision with root package name */
    public final Map<E, a> f13246b;

    /* renamed from: c, reason: collision with root package name */
    public int f13247c;

    public d(Object obj, Map<E, a> map) {
        this.f13245a = obj;
        this.f13246b = map;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f13247c < this.f13246b.size();
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E e10 = (E) this.f13245a;
        this.f13247c++;
        a aVar = this.f13246b.get(e10);
        if (aVar != null) {
            this.f13245a = aVar.f13236b;
            return e10;
        }
        throw new ConcurrentModificationException("Hash code of an element (" + e10 + ") has changed after it was added to the persistent set.");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
