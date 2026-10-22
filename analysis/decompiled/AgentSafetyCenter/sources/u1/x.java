package u1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x extends p0 {

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ y f13955y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(y yVar) {
        super(yVar);
        this.f13955y = yVar;
    }

    @Override // u1.o0
    public final int b0(s1.l lVar) {
        int iC = f.c(this, lVar);
        this.f13894x.h(iC, lVar);
        return iC;
    }

    @Override // s1.e0
    public final s1.o0 q(long j10) {
        U(j10);
        o2.a.a(j10);
        y yVar = this.f13955y;
        w wVar = yVar.R;
        g1 g1Var = yVar.f13811t;
        g1Var.getClass();
        p0 p0VarF0 = g1Var.F0();
        p0VarF0.getClass();
        p0.w0(this, wVar.f(this, p0VarF0, j10));
        return this;
    }
}
