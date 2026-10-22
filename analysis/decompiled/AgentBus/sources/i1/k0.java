package i1;

/* loaded from: classes.dex */
public final class k0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m0 f4515g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ long f4516h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ long f4517i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ o1 f4518j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(m0 m0Var, long j2, long j4, o1 o1Var) {
        super(0);
        this.f4515g = m0Var;
        this.f4516h = j2;
        this.f4517i = j4;
        this.f4518j = o1Var;
    }

    @Override // p7.a
    public final Object c() {
        m0 m0Var = this.f4515g;
        m0Var.h0().f4509f = false;
        m0Var.h0().f4510g = this.f4516h;
        m0Var.h0().f4511h = this.f4517i;
        p7.k kVarC = this.f4518j.f4557f.c();
        if (kVarC != null) {
            kVarC.invoke(m0Var.h0());
        }
        return c7.r.f1986a;
    }
}
