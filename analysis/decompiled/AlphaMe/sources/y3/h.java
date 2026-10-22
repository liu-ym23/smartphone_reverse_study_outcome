package y3;

import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class h implements t3.b {

    /* renamed from: a, reason: collision with root package name */
    public final long f16365a;

    /* renamed from: b, reason: collision with root package name */
    public final TimeUnit f16366b;

    /* renamed from: c, reason: collision with root package name */
    public final t3.f f16367c;

    public h(long j4, TimeUnit timeUnit, A3.h hVar) {
        this.f16365a = j4;
        this.f16366b = timeUnit;
        this.f16367c = hVar;
    }

    @Override // x3.e
    public final Object call(Object obj) {
        t3.g gVar = (t3.g) obj;
        t3.e eVarB = this.f16367c.b();
        gVar.d(eVarB);
        return new g(this, gVar, eVarB, gVar);
    }
}
