package rc;

import java.util.Iterator;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class g implements Iterator<e>, ac.a {

    /* renamed from: a, reason: collision with root package name */
    public int f11797a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f11798b;

    public g(e eVar) {
        this.f11798b = eVar;
        this.f11797a = eVar.e();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11797a > 0;
    }

    @Override // java.util.Iterator
    public final e next() {
        e eVar = this.f11798b;
        int iE = eVar.e();
        int i10 = this.f11797a;
        this.f11797a = i10 - 1;
        return eVar.h(iE - i10);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
