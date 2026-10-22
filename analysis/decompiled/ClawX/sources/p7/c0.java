package p7;

/* loaded from: classes.dex */
public final class c0 implements w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4775a;

    public c0(int i8) {
        this.f4775a = i8;
    }

    @Override // p7.w
    public final x e(x xVar) {
        b0 b0Var = xVar instanceof b0 ? (b0) xVar : null;
        if (b0Var != null && b0Var.f4770b == this.f4775a) {
            b0Var.f4769a = 0;
            return b0Var;
        }
        b0 b0Var2 = new b0();
        b0Var2.f4769a = 0;
        b0Var2.f4770b = this.f4775a;
        if (b0Var != null) {
            b0Var2.f4771c = b0Var.f4771c;
            b0Var2.d = b0Var.d;
            b0Var2.f4772e = b0Var.f4772e;
            b0Var2.f4773f = b0Var.f4773f;
        }
        return b0Var2;
    }
}
