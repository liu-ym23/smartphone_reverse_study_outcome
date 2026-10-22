package u8;

import java.util.List;
import jb.v;
import kc.e0;
import kc.t;
import kc.w;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14235c;

    /* renamed from: f, reason: collision with root package name */
    public int f14236f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.f f14237g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f14238h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(stepos.support.v7.app.f fVar, List list, nb.c cVar, int i) {
        super(2, cVar);
        this.f14235c = i;
        this.f14237g = fVar;
        this.f14238h = list;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14235c) {
            case 0:
                return new n(this.f14237g, this.f14238h, cVar, 0);
            default:
                return new n(this.f14237g, this.f14238h, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t tVar = (t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f14235c) {
        }
        return ((n) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        int i = this.f14235c;
        List list = this.f14238h;
        stepos.support.v7.app.f fVar = this.f14237g;
        int i3 = 1;
        nb.c cVar = null;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i10 = this.f14236f;
                if (i10 != 0) {
                    if (i10 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                rc.e eVar = e0.f7430a;
                rc.d dVar = rc.d.f10552f;
                m mVar = new m(fVar, list, cVar, 0);
                this.f14236f = 1;
                Object objE = w.E(dVar, mVar, this);
                return objE == aVar ? aVar : objE;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i11 = this.f14236f;
                if (i11 != 0) {
                    if (i11 == 1) {
                        id.c.I(obj);
                        return obj;
                    }
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                id.c.I(obj);
                rc.e eVar2 = e0.f7430a;
                rc.d dVar2 = rc.d.f10552f;
                m mVar2 = new m(fVar, list, cVar, i3);
                this.f14236f = 1;
                Object objE2 = w.E(dVar2, mVar2, this);
                return objE2 == aVar2 ? aVar2 : objE2;
        }
    }
}
