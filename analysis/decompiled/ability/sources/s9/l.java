package s9;

import m9.AbstractC1685C;
import m9.AbstractC1729v;
import m9.C1718k;
import m9.InterfaceC1688F;
import m9.InterfaceC1693K;

/* loaded from: classes4.dex */
public final class l extends AbstractC1729v implements InterfaceC1688F {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InterfaceC1688F f6004a;
    public final AbstractC1729v b;
    public final String c;

    /* JADX WARN: Multi-variable type inference failed */
    public l(AbstractC1729v abstractC1729v, String str) {
        InterfaceC1688F interfaceC1688F = abstractC1729v instanceof InterfaceC1688F ? (InterfaceC1688F) abstractC1729v : null;
        this.f6004a = interfaceC1688F == null ? AbstractC1685C.f5313a : interfaceC1688F;
        this.b = abstractC1729v;
        this.c = str;
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        this.b.dispatch(hVar, runnable);
    }

    @Override // m9.AbstractC1729v
    public final void dispatchYield(H7.h hVar, Runnable runnable) {
        this.b.dispatchYield(hVar, runnable);
    }

    @Override // m9.AbstractC1729v
    public final boolean isDispatchNeeded(H7.h hVar) {
        return this.b.isDispatchNeeded(hVar);
    }

    @Override // m9.InterfaceC1688F
    public final InterfaceC1693K l(long j5, Runnable runnable, H7.h hVar) {
        return this.f6004a.l(j5, runnable, hVar);
    }

    @Override // m9.InterfaceC1688F
    public final void s(long j5, C1718k c1718k) {
        this.f6004a.s(j5, c1718k);
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return this.c;
    }
}
