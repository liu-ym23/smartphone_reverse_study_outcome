package a6;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o extends l1 {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f199e;

    /* renamed from: f, reason: collision with root package name */
    public final m f200f;

    public /* synthetic */ o(m mVar, int i8) {
        this.f199e = i8;
        this.f200f = mVar;
    }

    @Override // a6.l1
    public final boolean k() {
        switch (this.f199e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // a6.l1
    public final void l(Throwable th) throws o0 {
        switch (this.f199e) {
            case 0:
                p1 p1VarJ = j();
                m mVar = this.f200f;
                Throwable thR = mVar.r(p1VarJ);
                if (mVar.x()) {
                    f6.e eVar = (f6.e) mVar.d;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6.e.f2637h;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(eVar);
                        androidx.emoji2.text.r rVar = f6.a.f2629c;
                        if (kotlin.jvm.internal.p.a(obj, rVar)) {
                            while (!atomicReferenceFieldUpdater.compareAndSet(eVar, rVar, thR)) {
                                if (atomicReferenceFieldUpdater.get(eVar) != rVar) {
                                    break;
                                }
                            }
                            break;
                        } else if (obj instanceof Throwable) {
                            break;
                        } else {
                            while (!atomicReferenceFieldUpdater.compareAndSet(eVar, obj, null)) {
                                if (atomicReferenceFieldUpdater.get(eVar) != obj) {
                                    break;
                                }
                            }
                        }
                    }
                }
                mVar.n(thR);
                if (!mVar.x()) {
                    mVar.o();
                    break;
                }
                break;
            default:
                this.f200f.resumeWith(b5.a0.f883a);
                break;
        }
    }
}
