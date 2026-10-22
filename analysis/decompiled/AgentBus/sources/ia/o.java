package ia;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class o extends k1 {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f4988j;

    /* renamed from: k, reason: collision with root package name */
    public final m f4989k;

    public /* synthetic */ o(m mVar, int i2) {
        this.f4988j = i2;
        this.f4989k = mVar;
    }

    @Override // ia.k1
    public final boolean k() {
        switch (this.f4988j) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // ia.k1
    public final void l(Throwable th) throws k0 {
        switch (this.f4988j) {
            case 0:
                o1 o1VarJ = j();
                m mVar = this.f4989k;
                Throwable thQ = mVar.q(o1VarJ);
                if (mVar.y()) {
                    na.g gVar = (na.g) mVar.f4974i;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = na.g.f6899m;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(gVar);
                        f8.x xVar = na.b.f6889c;
                        if (q7.k.a(obj, xVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(gVar, xVar, thQ)) {
                                if (atomicReferenceFieldUpdater.get(gVar) != xVar) {
                                    break;
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (!atomicReferenceFieldUpdater.compareAndSet(gVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(gVar) != obj) {
                                    break;
                                }
                            }
                        }
                    }
                }
                mVar.a(thQ);
                if (!mVar.y()) {
                    mVar.o();
                    break;
                }
                break;
            default:
                this.f4989k.resumeWith(c7.r.f1986a);
                break;
        }
    }
}
