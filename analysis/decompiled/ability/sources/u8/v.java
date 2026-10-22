package u8;

import java.util.LinkedHashSet;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;

/* loaded from: classes4.dex */
public final class v implements S7.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6735a;
    public final z b;

    public /* synthetic */ v(z zVar, int i) {
        this.f6735a = i;
        this.b = zVar;
    }

    @Override // S7.a
    public final Object invoke() {
        switch (this.f6735a) {
            case 0:
                Q8.f kindFilter = Q8.f.m;
                Q8.o.f1129a.getClass();
                Q8.l lVar = Q8.l.b;
                kotlin.jvm.internal.k.f(kindFilter, "kindFilter");
                List list = kindFilter.f1125a;
                NoLookupLocation noLookupLocation = NoLookupLocation.d;
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                boolean zA = kindFilter.a(Q8.f.l);
                z zVar = this.b;
                if (zA) {
                    for (G8.f fVar : zVar.g(kindFilter, lVar)) {
                        lVar.invoke(fVar);
                        g9.l.b(linkedHashSet, zVar.b(fVar, noLookupLocation));
                    }
                }
                if (kindFilter.a(Q8.f.i) && !list.contains(Q8.b.f1118a)) {
                    for (G8.f fVar2 : zVar.h(kindFilter, lVar)) {
                        lVar.invoke(fVar2);
                        linkedHashSet.addAll(zVar.f(fVar2, noLookupLocation));
                    }
                }
                if (kindFilter.a(Q8.f.f1121j) && !list.contains(Q8.b.f1118a)) {
                    for (G8.f fVar3 : zVar.n(kindFilter)) {
                        lVar.invoke(fVar3);
                        linkedHashSet.addAll(zVar.d(fVar3, noLookupLocation));
                    }
                }
                return D7.v.f1(linkedHashSet);
            case 1:
                return this.b.j();
            case 2:
                return this.b.h(Q8.f.p, null);
            case 3:
                return this.b.n(Q8.f.f1122q);
            default:
                return this.b.g(Q8.f.o, null);
        }
    }
}
