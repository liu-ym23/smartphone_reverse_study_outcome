package l5;

import jb.v;
import xb.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i extends pb.i implements q {

    /* renamed from: c, reason: collision with root package name */
    public int f7745c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ nc.h f7746f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object[] f7747g;

    @Override // xb.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        i iVar = new i(3, (nb.c) obj3);
        iVar.f7746f = (nc.h) obj;
        iVar.f7747g = (Object[]) obj2;
        return iVar.invokeSuspend(v.f6774a);
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        c cVar;
        c cVar2;
        ob.a aVar = ob.a.f9351c;
        int i = this.f7745c;
        if (i == 0) {
            id.c.I(obj);
            nc.h hVar = this.f7746f;
            c[] cVarArr = (c[]) this.f7747g;
            int length = cVarArr.length;
            int i3 = 0;
            while (true) {
                cVar = a.f7734a;
                if (i3 >= length) {
                    cVar2 = null;
                    break;
                }
                cVar2 = cVarArr[i3];
                if (!yb.k.a(cVar2, cVar)) {
                    break;
                }
                i3++;
            }
            if (cVar2 != null) {
                cVar = cVar2;
            }
            this.f7745c = 1;
            if (hVar.emit(cVar, this) == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                od.f.e("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            id.c.I(obj);
        }
        return v.f6774a;
    }
}
