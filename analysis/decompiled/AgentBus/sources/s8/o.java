package s8;

import d7.i0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f9586g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ p f9587h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ o(p pVar, int i2) {
        super(0);
        this.f9586g = i2;
        this.f9587h = pVar;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f9586g) {
            case 0:
                List listB = this.f9587h.f9589o.b();
                ArrayList arrayList = new ArrayList();
                for (Object obj : listB) {
                    if (((l8.u) obj).f5884a.isEnumConstant()) {
                        arrayList.add(obj);
                    }
                }
                int iS = d7.e0.S(d7.t.A0(arrayList, 10));
                if (iS < 16) {
                    iS = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iS);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    linkedHashMap.put(((l8.u) next).c(), next);
                }
                return linkedHashMap;
            case 1:
                Class<?>[] declaredClasses = this.f9587h.f9589o.f5878a.getDeclaredClasses();
                q7.k.d(declaredClasses, "klass.declaredClasses");
                return d7.r.q1(fa.l.v0(fa.l.u0(new fa.f(d7.n.T(declaredClasses), false, l8.c.f5853j), l8.c.f5854k)));
            default:
                p pVar = this.f9587h;
                return i0.Y(pVar.c(), pVar.d());
        }
    }
}
