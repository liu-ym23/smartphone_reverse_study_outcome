package u8;

import java.util.List;
import jb.v;
import kc.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14232c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.f f14233f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ List f14234g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(stepos.support.v7.app.f fVar, List list, nb.c cVar, int i) {
        super(2, cVar);
        this.f14232c = i;
        this.f14233f = fVar;
        this.f14234g = list;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f14232c) {
            case 0:
                return new m(this.f14233f, this.f14234g, cVar, 0);
            default:
                return new m(this.f14233f, this.f14234g, cVar, 1);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        t tVar = (t) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f14232c) {
        }
        return ((m) create(tVar, cVar)).invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f14232c;
        List list = this.f14234g;
        stepos.support.v7.app.f fVar = this.f14233f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                return ((w8.e) fVar.f12315f).b(list);
            default:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                return ((w8.e) fVar.f12315f).a(list);
        }
    }
}
