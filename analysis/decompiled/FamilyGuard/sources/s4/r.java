package s4;

/* loaded from: classes.dex */
public final class r extends p0 implements InterfaceC1089q {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC1090s f20369e;

    public r(InterfaceC1090s interfaceC1090s) {
        this.f20369e = interfaceC1090s;
    }

    @Override // s4.InterfaceC1081k0
    public void a(Throwable th) {
        this.f20369e.E(v());
    }

    @Override // s4.InterfaceC1089q
    public boolean b(Throwable th) {
        return v().B(th);
    }

    @Override // s4.InterfaceC1089q
    public n0 getParent() {
        return v();
    }
}
