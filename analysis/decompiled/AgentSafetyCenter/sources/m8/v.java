package m8;

import java.lang.invoke.VarHandle;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v extends pb.i implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public k0 f8505c;

    /* renamed from: f, reason: collision with root package name */
    public Iterator f8506f;

    /* renamed from: g, reason: collision with root package name */
    public int f8507g;

    /* renamed from: h, reason: collision with root package name */
    public int f8508h;
    public final /* synthetic */ List i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ k0 f8509j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(List list, k0 k0Var, nb.c cVar) {
        super(2, cVar);
        this.i = list;
        this.f8509j = k0Var;
    }

    @Override // pb.a
    public final nb.c create(Object obj, nb.c cVar) {
        return new v(this.i, this.f8509j, cVar);
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        return ((v) create((kc.t) obj, (nb.c) obj2)).invokeSuspend(jb.v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        Iterator it;
        k0 k0Var;
        int i;
        Object obj2;
        Object obj3 = ob.a.f9351c;
        int i3 = this.f8508h;
        if (i3 == 0) {
            id.c.I(obj);
            it = this.i.iterator();
            k0Var = this.f8509j;
            i = 0;
        } else {
            if (i3 != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = this.f8507g;
            it = this.f8506f;
            k0Var = this.f8505c;
            id.c.I(obj);
        }
        do {
            boolean zHasNext = it.hasNext();
            obj2 = jb.v.f6774a;
            if (!zHasNext) {
                return obj2;
            }
            String str = (String) it.next();
            q8.y yVar = (q8.y) k0Var.f8422f.getValue();
            this.f8505c = k0Var;
            this.f8506f = it;
            this.f8507g = i;
            this.f8508h = 1;
            q8.v vVar = yVar.f10197a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            str.getClass();
            q8.w wVar = new q8.w();
            wVar.f10192a = str;
            wVar.f10193b = jCurrentTimeMillis;
            VarHandle.storeStoreFence();
            androidx.room.u uVar = vVar.f10190a;
            aa.g gVar = new aa.g(10);
            gVar.f319f = vVar;
            gVar.f320g = wVar;
            VarHandle.storeStoreFence();
            Object objB = td.h.B(uVar, this, gVar, false, true);
            Object obj4 = ob.a.f9351c;
            Object obj5 = objB;
            if (objB != obj4) {
                obj5 = obj2;
            }
            if (obj5 != obj4) {
                obj5 = obj2;
            }
            if (obj5 == obj4) {
                obj2 = obj5;
            }
        } while (obj2 != obj3);
        return obj3;
    }
}
