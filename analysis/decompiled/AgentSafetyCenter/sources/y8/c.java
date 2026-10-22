package y8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends pb.i implements xb.q {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15954c;

    /* renamed from: f, reason: collision with root package name */
    public int f15955f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ w f15956g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ long f15957h;
    public final /* synthetic */ g9.b0 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(g9.b0 b0Var, nb.c cVar, int i) {
        super(3, cVar);
        this.f15954c = i;
        this.i = b0Var;
    }

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        w wVar = (w) obj;
        Number number = (Number) obj2;
        switch (this.f15954c) {
            case 0:
                long jLongValue = number.longValue();
                c cVar = new c(this.i, (nb.c) obj3, 0);
                cVar.f15956g = wVar;
                cVar.f15957h = jLongValue;
                return cVar.invokeSuspend(jb.v.f6774a);
            default:
                long jLongValue2 = number.longValue();
                c cVar2 = new c(this.i, (nb.c) obj3, 1);
                cVar2.f15956g = wVar;
                cVar2.f15957h = jLongValue2;
                return cVar2.invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE;
        Object objE2;
        switch (this.f15954c) {
            case 0:
                w wVar = this.f15956g;
                long j10 = this.f15957h;
                ob.a aVar = ob.a.f9351c;
                int i = this.f15955f;
                if (i == 0) {
                    id.c.I(obj);
                    this.f15956g = null;
                    this.f15957h = j10;
                    this.f15955f = 1;
                    objE = this.i.e(wVar, j10, this);
                    if (objE == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                    objE = ((jb.i) obj).f6762c;
                }
                return jb.i.a(objE);
            default:
                w wVar2 = this.f15956g;
                long j11 = this.f15957h;
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f15955f;
                if (i3 == 0) {
                    id.c.I(obj);
                    this.f15956g = null;
                    this.f15957h = j11;
                    this.f15955f = 1;
                    objE2 = this.i.e(wVar2, j11, this);
                    if (objE2 == aVar2) {
                        return aVar2;
                    }
                } else {
                    if (i3 != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                    objE2 = ((jb.i) obj).f6762c;
                }
                return jb.i.a(objE2);
        }
    }
}
