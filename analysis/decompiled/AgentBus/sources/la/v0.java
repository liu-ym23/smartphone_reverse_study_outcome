package la;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class v0 extends ma.d {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f6017a = new AtomicReference(null);

    @Override // ma.d
    public final boolean a(ma.b bVar) {
        AtomicReference atomicReference = this.f6017a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(k0.f5945b);
        return true;
    }

    @Override // ma.d
    public final g7.d[] b(ma.b bVar) {
        this.f6017a.set(null);
        return ma.c.f6480a;
    }
}
