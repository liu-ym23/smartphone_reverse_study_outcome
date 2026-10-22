package y3;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import jb.v;
import pb.i;
import xb.p;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends i implements p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15885c;

    /* renamed from: f, reason: collision with root package name */
    public int f15886f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f15887g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f15888h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public c(p pVar, nb.c cVar, int i) {
        super(2, cVar);
        this.f15885c = i;
        switch (i) {
            case 1:
                this.f15888h = (i) pVar;
                super(2, cVar);
                break;
            default:
                this.f15888h = (i) pVar;
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [pb.i, xb.p] */
    /* JADX WARN: Type inference failed for: r2v2, types: [pb.i, xb.p] */
    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f15885c) {
            case 0:
                c cVar2 = new c(this.f15888h, cVar, 0);
                cVar2.f15887g = obj;
                return cVar2;
            default:
                c cVar3 = new c(this.f15888h, cVar, 1);
                cVar3.f15887g = obj;
                return cVar3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        b bVar = (b) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f15885c) {
        }
        return ((c) create(bVar, cVar)).invokeSuspend(v.f6774a);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [pb.i, xb.p] */
    /* JADX WARN: Type inference failed for: r5v9, types: [pb.i, xb.p] */
    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f15885c) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                int i = this.f15886f;
                if (i == 0) {
                    id.c.I(obj);
                    b bVar = (b) this.f15887g;
                    this.f15886f = 1;
                    obj = this.f15888h.invoke(bVar, this);
                    if (obj == aVar) {
                        return aVar;
                    }
                } else {
                    if (i != 1) {
                        od.f.e("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    id.c.I(obj);
                }
                b bVar2 = (b) obj;
                bVar2.getClass();
                ((AtomicBoolean) bVar2.f15884b.f12170f).set(true);
                return bVar2;
            default:
                ob.a aVar2 = ob.a.f9351c;
                int i3 = this.f15886f;
                if (i3 == 0) {
                    id.c.I(obj);
                    b bVar3 = new b(new LinkedHashMap(((b) this.f15887g).a()), false);
                    this.f15887g = bVar3;
                    this.f15886f = 1;
                    return this.f15888h.invoke(bVar3, this) == aVar2 ? aVar2 : bVar3;
                }
                if (i3 != 1) {
                    od.f.e("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                b bVar4 = (b) this.f15887g;
                id.c.I(obj);
                return bVar4;
        }
    }
}
