package f3;

import Z2.A;
import kotlin.coroutines.CoroutineContext;

/* loaded from: classes2.dex */
public final class k extends A {

    /* renamed from: a, reason: collision with root package name */
    public static final k f12581a = new k();

    @Override // Z2.A
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        d dVar = d.f12567b;
        dVar.f12569a.b(runnable, j.f12580h, false);
    }

    @Override // Z2.A
    public final void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        d dVar = d.f12567b;
        dVar.f12569a.b(runnable, j.f12580h, true);
    }
}
