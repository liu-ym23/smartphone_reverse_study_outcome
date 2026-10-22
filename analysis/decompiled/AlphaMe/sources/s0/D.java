package s0;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class D extends H {
    @Override // s0.H
    public final I b() {
        if (!(!this.f14161b.f183q)) {
            throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
        }
        Intrinsics.checkNotNullParameter(this, "builder");
        return new E(this.f14160a, this.f14161b, this.f14162c);
    }
}
