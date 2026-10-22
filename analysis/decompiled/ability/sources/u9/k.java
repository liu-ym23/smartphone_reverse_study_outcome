package u9;

import m9.AbstractC1729v;
import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public final class k extends AbstractC1729v {

    /* renamed from: a, reason: collision with root package name */
    public static final k f6748a = new k();

    @Override // m9.AbstractC1729v
    public final void dispatch(H7.h hVar, Runnable runnable) {
        d.b.f6745a.c(true, false, runnable);
    }

    @Override // m9.AbstractC1729v
    public final void dispatchYield(H7.h hVar, Runnable runnable) {
        d.b.f6745a.c(true, true, runnable);
    }

    @Override // m9.AbstractC1729v
    public final AbstractC1729v limitedParallelism(int i, String str) {
        AbstractC1921a.a(i);
        return i >= j.d ? str != null ? new s9.l(this, str) : this : super.limitedParallelism(i, str);
    }

    @Override // m9.AbstractC1729v
    public final String toString() {
        return "Dispatchers.IO";
    }
}
