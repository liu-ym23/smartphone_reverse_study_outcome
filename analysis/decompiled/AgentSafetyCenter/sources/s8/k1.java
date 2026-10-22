package s8;

import android.content.Context;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11722c;

    /* renamed from: f, reason: collision with root package name */
    public k0.r1 f11723f;

    /* renamed from: g, reason: collision with root package name */
    public int f11724g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f11725h;
    public final /* synthetic */ Context i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ String f11726j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k1(Context context, String str, nb.c cVar, int i) {
        super(2, cVar);
        this.f11722c = i;
        this.i = context;
        this.f11726j = str;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f11722c) {
            case 0:
                k1 k1Var = new k1(this.i, this.f11726j, cVar, 0);
                k1Var.f11725h = obj;
                return k1Var;
            default:
                k1 k1Var2 = new k1(this.i, this.f11726j, cVar, 1);
                k1Var2.f11725h = obj;
                return k1Var2;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        k0.r1 r1Var = (k0.r1) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f11722c) {
        }
        return ((k1) create(r1Var, cVar)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f11722c;
        jb.v vVar = jb.v.f6774a;
        String str = this.f11726j;
        Context context = this.i;
        switch (i) {
            case 0:
                k0.r1 r1Var = (k0.r1) this.f11725h;
                ob.a aVar = ob.a.f9351c;
                int i3 = this.f11724g;
                if (i3 == 0) {
                    id.c.I(obj);
                    rc.e eVar = kc.e0.f7430a;
                    rc.d dVar = rc.d.f10552f;
                    j1 j1Var = new j1(context, str, null, 0);
                    this.f11725h = null;
                    this.f11723f = r1Var;
                    this.f11724g = 1;
                    obj = kc.w.E(dVar, j1Var, this);
                    if (obj == aVar) {
                        break;
                    }
                } else if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    r1Var = this.f11723f;
                    id.c.I(obj);
                }
                r1Var.setValue(obj);
                break;
            default:
                k0.r1 r1Var2 = (k0.r1) this.f11725h;
                ob.a aVar2 = ob.a.f9351c;
                int i10 = this.f11724g;
                if (i10 == 0) {
                    id.c.I(obj);
                    rc.e eVar2 = kc.e0.f7430a;
                    rc.d dVar2 = rc.d.f10552f;
                    j1 j1Var2 = new j1(context, str, null, 1);
                    this.f11725h = null;
                    this.f11723f = r1Var2;
                    this.f11724g = 1;
                    obj = kc.w.E(dVar2, j1Var2, this);
                    if (obj == aVar2) {
                        break;
                    }
                } else if (i10 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    r1Var2 = this.f11723f;
                    id.c.I(obj);
                }
                r1Var2.setValue(obj);
                break;
        }
        return vVar;
    }
}
