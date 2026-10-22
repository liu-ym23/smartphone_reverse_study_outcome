package fc;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<T> implements i<T> {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference<i<T>> f8791a;

    public a(i<? extends T> iVar) {
        this.f8791a = new AtomicReference<>(iVar);
    }

    @Override // fc.i
    public final Iterator<T> iterator() {
        i<T> andSet = this.f8791a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
