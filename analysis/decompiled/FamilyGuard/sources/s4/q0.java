package s4;

/* loaded from: classes.dex */
public class q0 extends u0 implements InterfaceC1094w {

    /* renamed from: c, reason: collision with root package name */
    private final boolean f20368c;

    public q0(n0 n0Var) {
        super(true);
        g0(n0Var);
        this.f20368c = J0();
    }

    private final boolean J0() {
        u0 u0VarV;
        InterfaceC1089q interfaceC1089qA0 = a0();
        r rVar = interfaceC1089qA0 instanceof r ? (r) interfaceC1089qA0 : null;
        if (rVar != null && (u0VarV = rVar.v()) != null) {
            while (!u0VarV.R()) {
                InterfaceC1089q interfaceC1089qA02 = u0VarV.a0();
                r rVar2 = interfaceC1089qA02 instanceof r ? (r) interfaceC1089qA02 : null;
                if (rVar2 == null || (u0VarV = rVar2.v()) == null) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // s4.u0
    public boolean R() {
        return this.f20368c;
    }

    @Override // s4.u0
    public boolean Y() {
        return true;
    }
}
