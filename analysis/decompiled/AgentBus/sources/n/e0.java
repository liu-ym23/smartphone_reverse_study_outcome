package n;

/* loaded from: classes.dex */
public final class e0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Number f6601g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ a0 f6602h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Number f6603i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z f6604j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(Number number, a0 a0Var, Number number2, z zVar) {
        super(0);
        this.f6601g = number;
        this.f6602h = a0Var;
        this.f6603i = number2;
        this.f6604j = zVar;
    }

    @Override // p7.a
    public final Object c() {
        a0 a0Var = this.f6602h;
        Number number = a0Var.f6527f;
        Number number2 = this.f6601g;
        boolean zEquals = number2.equals(number);
        Number number3 = this.f6603i;
        if (!zEquals || !number3.equals(a0Var.f6528g)) {
            a0Var.f6527f = number2;
            a0Var.f6528g = number3;
            a0Var.f6531j = new s0(this.f6604j, a0Var.f6529h, number2, number3, null);
            a0Var.f6535n.f6597b.setValue(Boolean.TRUE);
            a0Var.f6532k = false;
            a0Var.f6533l = true;
        }
        return c7.r.f1986a;
    }
}
