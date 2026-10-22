package i9;

import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5905c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f5906f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f5907g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f5908h;
    public final /* synthetic */ Object i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(int i, long j10, Object obj, Object obj2, nb.c cVar) {
        super(2, cVar);
        this.f5905c = i;
        this.f5908h = obj;
        this.i = obj2;
        this.f5907g = j10;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5905c) {
            case 0:
                int i = 0;
                t tVar = new t(i, this.f5907g, (b0) this.f5908h, (Set) this.i, cVar);
                tVar.f5906f = obj;
                return tVar;
            case 1:
                int i3 = 1;
                t tVar2 = new t(i3, this.f5907g, (qa.b) this.f5908h, (y8.w) this.i, cVar);
                tVar2.f5906f = obj;
                return tVar2;
            default:
                int i10 = 2;
                t tVar3 = new t(i10, this.f5907g, (qa.b) this.f5908h, (y8.y) this.i, cVar);
                tVar3.f5906f = obj;
                return tVar3;
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        y3.b bVar = (y3.b) obj;
        nb.c cVar = (nb.c) obj2;
        switch (this.f5905c) {
            case 0:
                t tVar = (t) create(bVar, cVar);
                jb.v vVar = jb.v.f6774a;
                tVar.invokeSuspend(vVar);
                return vVar;
            case 1:
                t tVar2 = (t) create(bVar, cVar);
                jb.v vVar2 = jb.v.f6774a;
                tVar2.invokeSuspend(vVar2);
                return vVar2;
            default:
                t tVar3 = (t) create(bVar, cVar);
                jb.v vVar3 = jb.v.f6774a;
                tVar3.invokeSuspend(vVar3);
                return vVar3;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5905c;
        jb.v vVar = jb.v.f6774a;
        long j10 = this.f5907g;
        Object obj2 = this.i;
        y3.b bVar = (y3.b) this.f5906f;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                bVar.d(j.f5868a, kb.l.B0((Set) obj2, "\u001e", null, null, null, 62));
                bVar.d(j.f5869b, new Long(j10));
                break;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                y3.e eVarC = qa.b.c((y8.w) obj2);
                Long l2 = new Long(j10);
                bVar.getClass();
                bVar.e(eVarC, l2);
                break;
            default:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                y8.y yVar = (y8.y) obj2;
                y8.w wVar = yVar.f16020a;
                y3.e eVarN = t.o.n(wVar.f16016c.concat("_json"));
                String str = yVar.f16022c;
                bVar.getClass();
                bVar.e(eVarN, str);
                bVar.e(qa.b.d(wVar), new Long(yVar.f16021b));
                bVar.e(qa.b.c(wVar), new Long(j10));
                bVar.e(t.o.k(wVar.f16016c.concat("_updated_at_ms")), new Long(j10));
                break;
        }
        return vVar;
    }
}
