package v;

import java.util.ArrayList;
import jb.v;
import k0.c1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements nc.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14304c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ArrayList f14305f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ c1 f14306g;

    @Override // nc.h
    public final Object emit(Object obj, nb.c cVar) {
        switch (this.f14304c) {
            case 0:
                j jVar = (j) obj;
                ArrayList arrayList = this.f14305f;
                if (jVar instanceof d) {
                    arrayList.add(jVar);
                } else if (jVar instanceof e) {
                    arrayList.remove(((e) jVar).f14303a);
                }
                this.f14306g.setValue(Boolean.valueOf(!arrayList.isEmpty()));
                break;
            case 1:
                j jVar2 = (j) obj;
                ArrayList arrayList2 = this.f14305f;
                if (jVar2 instanceof h) {
                    arrayList2.add(jVar2);
                } else if (jVar2 instanceof i) {
                    arrayList2.remove(((i) jVar2).f14311a);
                }
                this.f14306g.setValue(Boolean.valueOf(!arrayList2.isEmpty()));
                break;
            default:
                j jVar3 = (j) obj;
                ArrayList arrayList3 = this.f14305f;
                if (jVar3 instanceof m) {
                    arrayList3.add(jVar3);
                } else if (jVar3 instanceof n) {
                    arrayList3.remove(((n) jVar3).f14315a);
                } else if (jVar3 instanceof l) {
                    arrayList3.remove(((l) jVar3).f14313a);
                }
                this.f14306g.setValue(Boolean.valueOf(!arrayList3.isEmpty()));
                break;
        }
        return v.f6774a;
    }
}
