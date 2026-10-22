package b8;

import h8.InterfaceC1500H;

/* loaded from: classes4.dex */
public abstract class d0 extends AbstractC0857s implements Z7.g {
    @Override // b8.AbstractC0857s
    public final AbstractC0830C e() {
        return p().g;
    }

    @Override // b8.AbstractC0857s
    public final c8.e f() {
        return null;
    }

    @Override // Z7.g
    public final boolean isExternal() {
        return ((k8.F) o()).f;
    }

    @Override // Z7.g
    public final boolean isInfix() {
        o();
        return false;
    }

    @Override // Z7.g
    public final boolean isInline() {
        return ((k8.F) o()).i;
    }

    @Override // Z7.g
    public final boolean isOperator() {
        o();
        return false;
    }

    @Override // Z7.c
    public final boolean isSuspend() {
        o();
        return false;
    }

    @Override // b8.AbstractC0857s
    public final boolean n() {
        return p().n();
    }

    public abstract InterfaceC1500H o();

    public abstract i0 p();
}
