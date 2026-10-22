package X8;

/* loaded from: classes4.dex */
public final class r extends AbstractC0285p implements T {
    public final AbstractC0285p d;
    public final w e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(AbstractC0285p origin, w enhancement) {
        super(origin.b, origin.c);
        kotlin.jvm.internal.k.f(origin, "origin");
        kotlin.jvm.internal.k.f(enhancement, "enhancement");
        this.d = origin;
        this.e = enhancement;
    }

    @Override // X8.T
    public final w A() {
        return this.e;
    }

    @Override // X8.T
    public final U G() {
        return this.d;
    }

    @Override // X8.w
    /* renamed from: Y */
    public final w j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        AbstractC0285p type = this.d;
        kotlin.jvm.internal.k.f(type, "type");
        w type2 = this.e;
        kotlin.jvm.internal.k.f(type2, "type");
        return new r(type, type2);
    }

    @Override // X8.U
    public final U f0(boolean z10) {
        return AbstractC0272c.G(this.d.f0(z10), this.e.Z().f0(z10));
    }

    @Override // X8.U
    public final U j0(Y8.f kotlinTypeRefiner) {
        kotlin.jvm.internal.k.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        AbstractC0285p type = this.d;
        kotlin.jvm.internal.k.f(type, "type");
        w type2 = this.e;
        kotlin.jvm.internal.k.f(type2, "type");
        return new r(type, type2);
    }

    @Override // X8.U
    public final U m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return AbstractC0272c.G(this.d.m0(newAttributes), this.e);
    }

    @Override // X8.AbstractC0285p
    public final A n0() {
        return this.d.n0();
    }

    @Override // X8.AbstractC0285p
    public final String s0(I8.g gVar, I8.g gVar2) {
        I8.j jVar = gVar2.f813a;
        return ((Boolean) jVar.m.getValue(jVar, I8.j.f815Y[11])).booleanValue() ? gVar.W(this.e) : this.d.s0(gVar, gVar2);
    }

    @Override // X8.AbstractC0285p
    public final String toString() {
        return "[@EnhancedForWarnings(" + this.e + ")] " + this.d;
    }
}
