package u9;

import java.util.concurrent.Executor;
import m9.AbstractC1702U;

/* loaded from: classes4.dex */
public abstract class g extends AbstractC1702U {

    /* renamed from: a, reason: collision with root package name */
    public b f6745a;

    @Override // m9.AbstractC1702U
    public final Executor E() {
        return this.f6745a;
    }

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        b.f(this.f6745a, runnable, 6);
    }

    @Override // m9.AbstractC1729v
    public final void dispatchYield(H7.h hVar, Runnable runnable) {
        b.f(this.f6745a, runnable, 2);
    }
}
