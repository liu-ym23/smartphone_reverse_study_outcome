package m9;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* renamed from: m9.c, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1710c extends e0 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(C1710c.class, Object.class, "_disposer$volatile");
    private volatile /* synthetic */ Object _disposer$volatile;
    public final C1718k e;
    public InterfaceC1693K f;
    public final /* synthetic */ C1712e g;

    public C1710c(C1712e c1712e, C1718k c1718k) {
        this.g = c1712e;
        this.e = c1718k;
    }

    @Override // m9.e0
    public final boolean i() {
        return false;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        C1718k c1718k = this.e;
        if (th != null) {
            c1718k.getClass();
            a5.d dVarI = c1718k.I(new C1727t(th, false), null);
            if (dVarI != null) {
                c1718k.v(dVarI);
                C1711d c1711d = (C1711d) h.get(this);
                if (c1711d != null) {
                    c1711d.a();
                    return;
                }
                return;
            }
            return;
        }
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C1712e.b;
        C1712e c1712e = this.g;
        if (atomicIntegerFieldUpdater.decrementAndGet(c1712e) == 0) {
            InterfaceC1686D[] interfaceC1686DArr = c1712e.f5327a;
            ArrayList arrayList = new ArrayList(interfaceC1686DArr.length);
            for (InterfaceC1686D interfaceC1686D : interfaceC1686DArr) {
                arrayList.add(interfaceC1686D.c());
            }
            c1718k.resumeWith(arrayList);
        }
    }
}
