package d5;

/* loaded from: classes.dex */
public final class a0 implements la.k {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f2848f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ d0 f2849g;

    public /* synthetic */ a0(d0 d0Var, int i2) {
        this.f2848f = i2;
        this.f2849g = d0Var;
    }

    @Override // la.k
    public final Object emit(Object obj, g7.d dVar) throws Throwable {
        switch (this.f2848f) {
            case 0:
                String str = (String) obj;
                c7.r rVar = c7.r.f1986a;
                d0 d0Var = this.f2849g;
                String str2 = d0Var.f2863a;
                try {
                    c5.b bVarA = ((c5.d) d0Var.f2867e).a(str);
                    d0Var.f2868f.getClass();
                    c5.e eVarQ = s9.d.q(bVarA);
                    if (eVarQ != null) {
                        k5.s.warn$default(d0Var.f2869g, "ServerConn", a1.a.x(str2, " invalid frame: ", eVarQ.f1900a), null, 4, null);
                        return rVar;
                    }
                    Object objEmit = d0Var.f2873k.emit(bVarA, dVar);
                    return objEmit == h7.a.f4212f ? objEmit : rVar;
                } catch (Throwable th) {
                    ((k5.g) d0Var.f2869g).c("ServerConn", a1.a.x(str2, " decode failed: ", th.getMessage()), th);
                    return rVar;
                }
            default:
                c6.a aVar = (c6.a) obj;
                String str3 = aVar.f1903b;
                if (str3 == null) {
                    str3 = "remote closed";
                }
                this.f2849g.k(new p(str3, aVar.f1904c));
                return c7.r.f1986a;
        }
    }
}
