package i9;

import java.util.LinkedHashMap;
import k0.w1;
import nc.m0;
import v3.j0;
import v3.q0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5892c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5893f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(int i, nb.c cVar, int i3) {
        super(i, cVar);
        this.f5892c = i3;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5892c) {
            case 0:
                q qVar = new q(2, cVar, 0);
                qVar.f5893f = obj;
                return qVar;
            case 1:
                q qVar2 = new q(2, cVar, 1);
                qVar2.f5893f = obj;
                return qVar2;
            case 2:
                q qVar3 = new q(2, cVar, 2);
                qVar3.f5893f = obj;
                return qVar3;
            case 3:
                q qVar4 = new q(2, cVar, 3);
                qVar4.f5893f = obj;
                return qVar4;
            case 4:
                q qVar5 = new q(2, cVar, 4);
                qVar5.f5893f = obj;
                return qVar5;
            default:
                q qVar6 = new q(2, cVar, 5);
                qVar6.f5893f = obj;
                return qVar6;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5892c) {
            case 0:
                q qVar = (q) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                qVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                q qVar2 = (q) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                qVar2.invokeSuspend(vVar2);
                return vVar2;
            case 2:
                q qVar3 = (q) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar3 = jb.v.f6774a;
                qVar3.invokeSuspend(vVar3);
                return vVar3;
            case 3:
                return ((q) create((w1) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 4:
                return ((q) create((m0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                return ((q) create((q0) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5892c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                y3.b bVar = (y3.b) this.f5893f;
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar = j.f5868a;
                bVar.d(j.f5870c, Boolean.TRUE);
                return vVar;
            case 1:
                y3.b bVar2 = (y3.b) this.f5893f;
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar2 = i.f5866a;
                bVar2.getClass();
                eVar2.getClass();
                bVar2.b();
                LinkedHashMap linkedHashMap = bVar2.f15883a;
                linkedHashMap.remove(eVar2);
                y3.e eVar3 = i.f5867b;
                eVar3.getClass();
                bVar2.b();
                linkedHashMap.remove(eVar3);
                bVar2.d(j.f5870c, Boolean.TRUE);
                return vVar;
            case 2:
                y3.b bVar3 = (y3.b) this.f5893f;
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar4 = j.f5868a;
                bVar3.d(j.f5871d, Boolean.TRUE);
                return vVar;
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                return Boolean.valueOf(((w1) this.f5893f) == w1.f7100c);
            case 4:
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                return Boolean.valueOf(((m0) this.f5893f) != m0.f8883c);
            default:
                ob.a aVar6 = ob.a.f9351c;
                id.c.I(obj);
                return Boolean.valueOf(!(((q0) this.f5893f) instanceof j0));
        }
    }
}
