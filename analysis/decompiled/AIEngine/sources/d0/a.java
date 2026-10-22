package d0;

import androidx.concurrent.futures.AbstractResolvableFuture;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a<V> extends AbstractResolvableFuture<V> {
    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public final boolean i(Throwable th) {
        throw null;
    }

    public final boolean j(V v3) {
        if (v3 == null) {
            v3 = (V) AbstractResolvableFuture.f1002j;
        }
        if (!AbstractResolvableFuture.h.b(this, null, v3)) {
            return false;
        }
        AbstractResolvableFuture.c(this);
        return true;
    }
}
