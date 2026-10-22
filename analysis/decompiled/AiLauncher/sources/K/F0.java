package K;

import androidx.camera.core.k;

/* loaded from: classes.dex */
public final class F0 implements androidx.camera.core.k {

    /* renamed from: d, reason: collision with root package name */
    public final long f3883d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.camera.core.k f3884e;

    public F0(long j10, androidx.camera.core.k kVar) {
        B0.h.b(j10 >= 0, "Timeout must be non-negative.");
        this.f3883d = j10;
        this.f3884e = kVar;
    }

    @Override // androidx.camera.core.k
    public long a() {
        return this.f3883d;
    }

    @Override // androidx.camera.core.k
    public k.c b(k.b bVar) {
        k.c cVarB = this.f3884e.b(bVar);
        return (a() <= 0 || bVar.b() < a() - cVarB.b()) ? cVarB : k.c.f11622d;
    }
}
