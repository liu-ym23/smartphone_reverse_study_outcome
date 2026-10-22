package s;

import java.lang.invoke.VarHandle;
import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends pb.i implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public i f10927c;

    /* renamed from: f, reason: collision with root package name */
    public yb.q f10928f;

    /* renamed from: g, reason: collision with root package name */
    public int f10929g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f10930h;
    public final /* synthetic */ Object i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ w0 f10931j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ long f10932k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ xb.l f10933l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, Object obj, w0 w0Var, long j10, xb.l lVar, nb.c cVar2) {
        super(1, cVar2);
        this.f10930h = cVar;
        this.i = obj;
        this.f10931j = w0Var;
        this.f10932k = j10;
        this.f10933l = lVar;
    }

    @Override // pb.a
    public final nb.c create(nb.c cVar) {
        return new a(this.f10930h, this.i, this.f10931j, this.f10932k, this.f10933l, cVar);
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        return ((a) create((nb.c) obj)).invokeSuspend(jb.v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [xb.l, yb.l] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        i iVar;
        yb.q qVar;
        w0 w0Var = this.f10931j;
        ob.a aVar = ob.a.f9351c;
        int i = this.f10929g;
        int i3 = 1;
        c cVar = this.f10930h;
        try {
            if (i == 0) {
                id.c.I(obj);
                cVar.f10959c.f11022g = (n) ((yb.l) cVar.f10957a.f8776c).invoke(this.i);
                cVar.f10961e.setValue(w0Var.f11156c);
                cVar.f10960d.setValue(Boolean.TRUE);
                i iVar2 = cVar.f10959c;
                i iVar3 = new i(iVar2.f11020c, iVar2.f11021f.getValue(), d.h(iVar2.f11022g), iVar2.f11023h, Long.MIN_VALUE, iVar2.f11024j);
                yb.q qVar2 = new yb.q();
                long j10 = this.f10932k;
                b0.r rVar = new b0.r(cVar, iVar3, this.f10933l, qVar2, 1);
                this.f10927c = iVar3;
                this.f10928f = qVar2;
                this.f10929g = 1;
                if (d.c(iVar3, w0Var, j10, rVar, this) == aVar) {
                    return aVar;
                }
                iVar = iVar3;
                qVar = qVar2;
            } else {
                if (i != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                qVar = this.f10928f;
                iVar = this.f10927c;
                id.c.I(obj);
            }
            if (!qVar.f16094c) {
                i3 = 2;
            }
            c.b(cVar);
            wd.a aVar2 = new wd.a(7);
            aVar2.f15390g = iVar;
            aVar2.f15389f = i3;
            VarHandle.storeStoreFence();
            return aVar2;
        } catch (CancellationException e10) {
            c.b(cVar);
            throw e10;
        }
    }
}
