package ce;

import java.lang.invoke.VarHandle;
import java.util.LinkedList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2265a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f2266b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ f f2267c;

    public /* synthetic */ c(int i) {
        this.f2265a = i;
    }

    @Override // ce.g
    public final zd.g a() {
        int i = 1;
        switch (this.f2265a) {
            case 0:
                LinkedList linkedList = this.f2266b;
                f fVar = this.f2267c;
                boolean zC = fVar.f2275a.c(22);
                fe.b bVar = fVar.f2275a;
                if (zC) {
                    linkedList.add((ge.e) bVar.k());
                    return a();
                }
                if (!bVar.d(15, 20, 3)) {
                    if (!linkedList.isEmpty()) {
                        return f.b(fVar, (ge.e) linkedList.remove(0));
                    }
                    fVar.f2277c.g(new b(fVar, i));
                    return fVar.c(true, true);
                }
                c cVar = new c(i);
                cVar.f2267c = fVar;
                cVar.f2266b = linkedList;
                VarHandle.storeStoreFence();
                fVar.f2279e = cVar;
                return f.a(fVar, bVar.m().f4744a);
            default:
                LinkedList linkedList2 = this.f2266b;
                boolean zIsEmpty = linkedList2.isEmpty();
                f fVar2 = this.f2267c;
                return !zIsEmpty ? f.b(fVar2, (ge.e) linkedList2.remove(0)) : new b(fVar2, i).a();
        }
    }
}
