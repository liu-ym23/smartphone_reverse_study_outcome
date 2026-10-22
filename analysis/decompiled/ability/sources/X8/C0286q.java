package X8;

import h8.InterfaceC1507O;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: X8.q, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0286q extends AbstractC0285p implements InterfaceC0279j {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0286q(A lowerBound, A upperBound) {
        super(lowerBound, upperBound);
        kotlin.jvm.internal.k.f(lowerBound, "lowerBound");
        kotlin.jvm.internal.k.f(upperBound, "upperBound");
    }

    @Override // X8.InterfaceC0279j
    public final boolean C() {
        A a3 = this.b;
        return (a3.Q().d() instanceof InterfaceC1507O) && kotlin.jvm.internal.k.b(a3.Q(), this.c.Q());
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        kotlin.jvm.internal.k.f(type, "type");
        A type2 = this.c;
        kotlin.jvm.internal.k.f(type2, "type");
        return new C0286q(type, type2);
    }

    @Override // X8.U
    public final U f0(boolean z10) {
        return AbstractC0272c.f(this.b.f0(z10), this.c.f0(z10));
    }

    @Override // X8.U
    public final U j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        A type = this.b;
        kotlin.jvm.internal.k.f(type, "type");
        A type2 = this.c;
        kotlin.jvm.internal.k.f(type2, "type");
        return new C0286q(type, type2);
    }

    @Override // X8.InterfaceC0279j
    public final U k(w replacement) {
        U uF;
        kotlin.jvm.internal.k.f(replacement, "replacement");
        U uZ = replacement.Z();
        if (uZ instanceof AbstractC0285p) {
            uF = uZ;
        } else {
            if (!(uZ instanceof A)) {
                throw new NoWhenBranchMatchedException();
            }
            A a3 = (A) uZ;
            uF = AbstractC0272c.f(a3, a3.f0(true));
        }
        return AbstractC0272c.i(uF, uZ);
    }

    @Override // X8.U
    public final U m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return AbstractC0272c.f(this.b.m0(newAttributes), this.c.m0(newAttributes));
    }

    @Override // X8.AbstractC0285p
    public final A n0() {
        return this.b;
    }

    @Override // X8.AbstractC0285p
    public final String s0(I8.g gVar, I8.g gVar2) {
        boolean zL = gVar2.f813a.l();
        A a3 = this.c;
        A a4 = this.b;
        if (!zL) {
            return gVar.D(gVar.W(a4), gVar.W(a3), U7.a.x(this));
        }
        return "(" + gVar.W(a4) + ".." + gVar.W(a3) + ')';
    }

    @Override // X8.AbstractC0285p
    public final String toString() {
        return "(" + this.b + ".." + this.c + ')';
    }
}
