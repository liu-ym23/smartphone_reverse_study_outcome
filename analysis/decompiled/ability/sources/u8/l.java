package u8;

import D7.N;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import n8.C1743b;

/* loaded from: classes4.dex */
public final class l implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6728a;
    public final kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a b;

    public /* synthetic */ l(kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar, int i) {
        this.f6728a = i;
        this.b = aVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f6728a) {
            case 0:
                Class<?>[] declaredClasses = this.b.o.f4985a.getDeclaredClasses();
                kotlin.jvm.internal.k.e(declaredClasses, "getDeclaredClasses(...)");
                return D7.v.j1(kotlin.sequences.a.o0(kotlin.sequences.a.n0(kotlin.sequences.a.g0(D7.q.M(declaredClasses), C1743b.d), C1743b.e)));
            case 1:
                Collection collectionC = this.b.o.c();
                ArrayList arrayList = new ArrayList();
                for (Object obj : collectionC) {
                    if (((n8.n) obj).f5361a.isEnumConstant()) {
                        arrayList.add(obj);
                    }
                }
                int iP = kotlin.collections.a.P(D7.w.c0(arrayList, 10));
                if (iP < 16) {
                    iP = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iP);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    linkedHashMap.put(((n8.n) next).c(), next);
                }
                return linkedHashMap;
            default:
                kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.a aVar = this.b;
                return N.L(aVar.a(), aVar.getVariableNames());
        }
    }
}
