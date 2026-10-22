package X8;

import a9.InterfaceC0311c;
import h8.InterfaceC1507O;

/* renamed from: X8.l, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0281l extends AbstractC0282m implements InterfaceC0279j, InterfaceC0311c {
    public final A b;
    public final boolean c;

    public C0281l(A a3, boolean z10) {
        this.b = a3;
        this.c = z10;
    }

    @Override // X8.InterfaceC0279j
    public final boolean C() {
        A a3 = this.b;
        a3.Q();
        return a3.Q().d() instanceof InterfaceC1507O;
    }

    @Override // X8.AbstractC0282m
    public final AbstractC0282m D0(A a3) {
        return new C0281l(a3, this.c);
    }

    @Override // X8.AbstractC0282m, X8.w
    public final boolean W() {
        return false;
    }

    @Override // X8.InterfaceC0279j
    public final U k(w replacement) {
        kotlin.jvm.internal.k.f(replacement, "replacement");
        return AbstractC0272c.n(replacement.Z(), this.c);
    }

    @Override // X8.A
    /* renamed from: n0 */
    public final A f0(boolean z10) {
        return z10 ? this.b.f0(z10) : this;
    }

    @Override // X8.A
    /* renamed from: s0 */
    public final A m0(H newAttributes) {
        kotlin.jvm.internal.k.f(newAttributes, "newAttributes");
        return new C0281l(this.b.m0(newAttributes), this.c);
    }

    @Override // X8.A
    public final String toString() {
        return this.b + " & Any";
    }

    @Override // X8.AbstractC0282m
    public final A y0() {
        return this.b;
    }
}
