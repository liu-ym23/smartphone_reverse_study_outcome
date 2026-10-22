package h0;

import android.view.Choreographer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n1 extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5087c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n1(int i, nb.c cVar, int i3) {
        super(i, cVar);
        this.f5087c = i3;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        switch (this.f5087c) {
            case 0:
                return new n1(2, cVar, 0);
            case 1:
                return new n1(2, cVar, 1);
            case 2:
                return new n1(2, cVar, 2);
            case 3:
                return new n1(2, cVar, 3);
            case 4:
                return new n1(2, cVar, 4);
            case 5:
                return new n1(2, cVar, 5);
            case 6:
                return new n1(2, cVar, 6);
            default:
                return new n1(2, cVar, 7);
        }
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f5087c) {
            case 0:
                n1 n1Var = (n1) create((o1.w) obj, (nb.c) obj2);
                jb.v vVar = jb.v.f6774a;
                n1Var.invokeSuspend(vVar);
                return vVar;
            case 1:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 2:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 3:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 4:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 5:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            case 6:
                return ((n1) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
            default:
                n1 n1Var2 = (n1) create((nc.h) obj, (nb.c) obj2);
                jb.v vVar2 = jb.v.f6774a;
                n1Var2.invokeSuspend(vVar2);
                return vVar2;
        }
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5087c;
        jb.v vVar = jb.v.f6774a;
        switch (i) {
            case 0:
                ob.a aVar = ob.a.f9351c;
                id.c.I(obj);
                return vVar;
            case 1:
                ob.a aVar2 = ob.a.f9351c;
                id.c.I(obj);
                l8.b bVar = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 2:
                ob.a aVar3 = ob.a.f9351c;
                id.c.I(obj);
                l8.b bVar2 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 3:
                ob.a aVar4 = ob.a.f9351c;
                id.c.I(obj);
                l8.b bVar3 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 4:
                ob.a aVar5 = ob.a.f9351c;
                id.c.I(obj);
                l8.b bVar4 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 5:
                ob.a aVar6 = ob.a.f9351c;
                id.c.I(obj);
                l8.b bVar5 = l8.b.f7755a;
                return Boolean.valueOf(l8.b.c());
            case 6:
                ob.a aVar7 = ob.a.f9351c;
                id.c.I(obj);
                return Choreographer.getInstance();
            default:
                ob.a aVar8 = ob.a.f9351c;
                id.c.I(obj);
                return vVar;
        }
    }
}
