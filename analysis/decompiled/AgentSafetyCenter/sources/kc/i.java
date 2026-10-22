package kc;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends a1 {
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public g f7441j;

    public /* synthetic */ i(int i) {
        this.i = i;
    }

    @Override // kc.a1
    public final boolean k() {
        switch (this.i) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // kc.a1
    public final void l(Throwable th) {
        switch (this.i) {
            case 0:
                g gVar = this.f7441j;
                Throwable thQ = gVar.q(j());
                if (gVar.w()) {
                    pc.f fVar = (pc.f) gVar.f7437h;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = pc.f.f9955l;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(fVar);
                        pc.t tVar = pc.a.f9945c;
                        if (yb.k.a(obj, tVar)) {
                            if (atomicReferenceFieldUpdater.compareAndSet(fVar, tVar, thQ)) {
                                break;
                            }
                        } else if (obj instanceof Throwable) {
                            break;
                        } else if (atomicReferenceFieldUpdater.compareAndSet(fVar, obj, null)) {
                        }
                    }
                }
                gVar.f(thQ);
                if (!gVar.w()) {
                    gVar.o();
                    break;
                }
                break;
            default:
                this.f7441j.resumeWith(jb.v.f6774a);
                break;
        }
    }
}
