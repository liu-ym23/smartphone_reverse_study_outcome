package androidx.lifecycle;

import l.C0744b;

/* loaded from: classes.dex */
public class U extends P {
    @Override // androidx.lifecycle.P
    public final void g(Object obj) {
        P.a("setValue");
        this.f3895g++;
        this.f3893e = obj;
        c(null);
    }

    public final void h(Object obj) {
        boolean z4;
        synchronized (this.f3889a) {
            z4 = this.f3894f == P.f3888k;
            this.f3894f = obj;
        }
        if (z4) {
            C0744b.g0().i0(this.f3898j);
        }
    }
}
