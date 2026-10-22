package i9;

import u.y0;
import u.z0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5884c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5885f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5886g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(long j10, nb.c cVar, int i) {
        super(2, cVar);
        this.f5884c = i;
        this.f5886g = j10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5884c) {
            case 0:
                n nVar = new n(this.f5886g, cVar, 0);
                nVar.f5885f = obj;
                return nVar;
            case 1:
                n nVar2 = new n(this.f5886g, cVar, 1);
                nVar2.f5885f = obj;
                return nVar2;
            case 2:
                n nVar3 = new n(this.f5886g, cVar, 2);
                nVar3.f5885f = obj;
                return nVar3;
            case 3:
                n nVar4 = new n(this.f5886g, cVar, 3);
                nVar4.f5885f = obj;
                return nVar4;
            default:
                n nVar5 = new n(this.f5886g, cVar, 4);
                nVar5.f5885f = obj;
                return nVar5;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5884c) {
            case 0:
                n nVar = (n) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                nVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                n nVar2 = (n) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                nVar2.invokeSuspend(vVar2);
                return vVar2;
            case 2:
                n nVar3 = (n) create((y3.b) obj, (nb.c) obj2);
                jb.v vVar3 = jb.v.f6774a;
                nVar3.invokeSuspend(vVar3);
                return vVar3;
            case 3:
                n nVar4 = (n) create((y0) obj, (nb.c) obj2);
                jb.v vVar4 = jb.v.f6774a;
                nVar4.invokeSuspend(vVar4);
                return vVar4;
            default:
                n nVar5 = (n) create((y0) obj, (nb.c) obj2);
                jb.v vVar5 = jb.v.f6774a;
                nVar5.invokeSuspend(vVar5);
                return vVar5;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5884c;
        jb.v vVar = jb.v.f6774a;
        long j10 = this.f5886g;
        switch (i) {
            case 0:
                y3.b bVar = (y3.b) this.f5885f;
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar = j.f5868a;
                bVar.d(j.f5869b, new Long(j10));
                break;
            case 1:
                y3.b bVar2 = (y3.b) this.f5885f;
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar2 = j.f5868a;
                bVar2.d(j.f5869b, new Long(j10));
                break;
            case 2:
                y3.b bVar3 = (y3.b) this.f5885f;
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVar3 = j.f5868a;
                bVar3.d(j.f5869b, new Long(j10));
                break;
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                z0 z0Var = ((y0) this.f5885f).f13619a;
                z0.a(z0Var, z0Var.f13631h, j10, 1);
                break;
            default:
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                z0 z0Var2 = ((y0) this.f5885f).f13619a;
                z0.a(z0Var2, z0Var2.f13631h, j10, 1);
                break;
        }
        return vVar;
    }
}
