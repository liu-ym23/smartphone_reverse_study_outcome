package u;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class x0 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public z0 f13607c;

    /* renamed from: f, reason: collision with root package name */
    public yb.t f13608f;

    /* renamed from: g, reason: collision with root package name */
    public long f13609g;

    /* renamed from: h, reason: collision with root package name */
    public int f13610h;
    public /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ z0 f13611j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ yb.t f13612k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f13613l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(z0 z0Var, yb.t tVar, long j10, nb.c cVar) {
        super(2, cVar);
        this.f13611j = z0Var;
        this.f13612k = tVar;
        this.f13613l = j10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        x0 x0Var = new x0(this.f13611j, this.f13612k, this.f13613l, cVar);
        x0Var.i = obj;
        return x0Var;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((x0) create((y0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        z0 z0Var;
        z0 z0Var2;
        yb.t tVar;
        long j10;
        ob.a aVar = ob.a.f9351c;
        int i = this.f13610h;
        f0 f0Var = f0.f13454f;
        if (i == 0) {
            id.c.I(obj);
            y0 y0Var = (y0) this.i;
            w0 w0Var = new w0();
            z0Var = this.f13611j;
            w0Var.f13601a = z0Var;
            w0Var.f13602b = y0Var;
            VarHandle.storeStoreFence();
            k kVar = z0Var.f13626c;
            yb.t tVar2 = this.f13612k;
            long j11 = tVar2.f16097c;
            f0 f0Var2 = z0Var.f13627d;
            long j12 = this.f13613l;
            float fC = z0Var.c(f0Var2 == f0Var ? o2.p.c(j12) : o2.p.d(j12));
            this.i = z0Var;
            this.f13607c = z0Var;
            this.f13608f = tVar2;
            this.f13609g = j11;
            this.f13610h = 1;
            kVar.getClass();
            obj = kc.w.E(kVar.f13514b, new j(fC, kVar, w0Var, null), this);
            if (obj == aVar) {
                return aVar;
            }
            z0Var2 = z0Var;
            tVar = tVar2;
            j10 = j11;
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j10 = this.f13609g;
            tVar = this.f13608f;
            z0Var = this.f13607c;
            z0Var2 = (z0) this.i;
            id.c.I(obj);
        }
        float fC2 = z0Var2.c(((Number) obj).floatValue());
        tVar.f16097c = z0Var.f13627d == f0Var ? o2.p.b(j10, fC2, 0.0f, 2) : o2.p.b(j10, 0.0f, fC2, 1);
        return jb.v.f6774a;
    }
}
