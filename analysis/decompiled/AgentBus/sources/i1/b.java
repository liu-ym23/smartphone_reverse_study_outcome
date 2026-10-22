package i1;

/* loaded from: classes.dex */
public final class b extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4406g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f4407h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(c cVar, int i2) {
        super(0);
        this.f4406g = i2;
        this.f4407h = cVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f4406g) {
            case 0:
                this.f4407h.n0();
                break;
            default:
                c cVar = this.f4407h;
                n0.k kVar = cVar.f4415t;
                q7.k.c(kVar, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                r.y yVar = (r.y) kVar;
                yVar.getClass();
                r.o0 o0Var = (r.o0) cVar.a(r.r0.f8937a);
                r.o0 o0Var2 = yVar.f8950a;
                yVar.f8951b.setValue(new r.t(o0Var2, o0Var));
                yVar.f8952c.setValue(new r.l0(o0Var, o0Var2));
                break;
        }
        return c7.r.f1986a;
    }
}
