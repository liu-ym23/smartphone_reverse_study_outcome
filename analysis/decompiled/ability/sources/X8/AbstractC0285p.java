package X8;

import a9.InterfaceC0310b;
import java.util.List;

/* renamed from: X8.p, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0285p extends U implements InterfaceC0310b {
    public final A b;
    public final A c;

    public AbstractC0285p(A lowerBound, A upperBound) {
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
        this.b = lowerBound;
        this.c = upperBound;
    }

    @Override // X8.w
    public final List L() {
        return n0().L();
    }

    @Override // X8.w
    public final H M() {
        return n0().M();
    }

    @Override // X8.w
    public final K Q() {
        return n0().Q();
    }

    @Override // X8.w
    public final boolean W() {
        return n0().W();
    }

    public abstract A n0();

    public abstract String s0(I8.g gVar, I8.g gVar2);

    public String toString() {
        return I8.g.e.W(this);
    }

    @Override // X8.w
    public Q8.o w() {
        return n0().w();
    }
}
