package ra;

import b0.b2;
import c7.r;
import f8.x;
import ia.g2;
import ia.k0;
import ia.m;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import na.s;
import p7.o;

/* loaded from: classes.dex */
public final class c implements ia.k, g2 {

    /* renamed from: f, reason: collision with root package name */
    public final m f9114f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f9115g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ d f9116h;

    public c(d dVar, m mVar, Object obj) {
        this.f9116h = dVar;
        this.f9114f = mVar;
        this.f9115g = obj;
    }

    @Override // ia.k
    public final boolean a(Throwable th) {
        return this.f9114f.a(th);
    }

    @Override // ia.g2
    public final void b(s sVar, int i2) {
        this.f9114f.b(sVar, i2);
    }

    @Override // ia.k
    public final x f(Object obj, Object obj2) {
        return this.f9114f.F((r) obj, obj2, null);
    }

    @Override // g7.d
    public final g7.l getContext() {
        return this.f9114f.f4975j;
    }

    @Override // ia.k
    public final x h(Object obj, o oVar) {
        d dVar = this.f9116h;
        a2.a aVar = new a2.a(1, dVar, this);
        x xVarF = this.f9114f.F((r) obj, null, aVar);
        if (xVarF != null) {
            d.f9117h.set(dVar, this.f9115g);
        }
        return xVarF;
    }

    @Override // ia.k
    public final void m(Object obj, o oVar) throws k0 {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = d.f9117h;
        Object obj2 = this.f9115g;
        d dVar = this.f9116h;
        atomicReferenceFieldUpdater.set(dVar, obj2);
        b2 b2Var = new b2(8, dVar, this);
        m mVar = this.f9114f;
        mVar.C(r.f1986a, mVar.f4976h, new ia.l(0, b2Var));
    }

    @Override // g7.d
    public final void resumeWith(Object obj) {
        this.f9114f.resumeWith(obj);
    }

    @Override // ia.k
    public final void x(Object obj) throws k0 {
        this.f9114f.x(obj);
    }
}
