package mb;

import java.util.Enumeration;
import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n implements Iterator<Object>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Enumeration<Object> f10560a;

    public n(Enumeration<Object> enumeration) {
        this.f10560a = enumeration;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f10560a.hasMoreElements();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return this.f10560a.nextElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
