package m9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s9.AbstractC1921a;
import s9.C1925e;

/* renamed from: m9.m, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1720m extends e0 {
    public final /* synthetic */ int e;
    public final C1718k f;

    public /* synthetic */ C1720m(C1718k c1718k, int i) {
        this.e = i;
        this.f = c1718k;
    }

    @Override // m9.e0
    public final boolean i() {
        switch (this.e) {
            case 0:
                return true;
            default:
                return false;
        }
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                kotlinx.coroutines.c cVarH = h();
                C1718k c1718k = this.f;
                Throwable thW = c1718k.w(cVarH);
                if (c1718k.B()) {
                    C1925e c1925e = (C1925e) c1718k.d;
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C1925e.h;
                    while (true) {
                        Object obj = atomicReferenceFieldUpdater.get(c1925e);
                        a5.d dVar = AbstractC1921a.c;
                        if (kotlin.jvm.internal.k.b(obj, dVar)) {
                            if (atomicReferenceFieldUpdater.compareAndSet(c1925e, dVar, thW)) {
                                break;
                            }
                        } else if (obj instanceof Throwable) {
                            break;
                        } else if (atomicReferenceFieldUpdater.compareAndSet(c1925e, obj, null)) {
                        }
                    }
                }
                c1718k.l(thW);
                if (!c1718k.B()) {
                    c1718k.t();
                    break;
                }
                break;
            default:
                this.f.resumeWith(C7.r.f317a);
                break;
        }
    }
}
