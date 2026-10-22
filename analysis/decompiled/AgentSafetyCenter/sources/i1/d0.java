package i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5634c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ e0 f5635f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(e0 e0Var, int i) {
        super(1);
        this.f5634c = i;
        this.f5635f = e0Var;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [xb.a, yb.l] */
    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f5634c) {
            case 0:
                e0 e0Var = this.f5635f;
                e0Var.f5648d = true;
                e0Var.f5650f.invoke();
                return jb.v.f6774a;
            default:
                f1.d dVar = (f1.d) obj;
                e0 e0Var2 = this.f5635f;
                c cVar = e0Var2.f5646b;
                float f5 = e0Var2.f5654k;
                float f10 = e0Var2.f5655l;
                p5.m mVarA0 = dVar.a0();
                long jD = mVarA0.D();
                mVarA0.y().i();
                try {
                    ((a1.g) mVarA0.f9741f).y(f5, f10, 0L);
                    cVar.a(dVar);
                    mVarA0.y().o();
                    mVarA0.R(jD);
                    return jb.v.f6774a;
                } catch (Throwable th) {
                    mVarA0.y().o();
                    mVarA0.R(jD);
                    throw th;
                }
        }
    }
}
