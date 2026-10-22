package a2;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f148c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f149f;

    public /* synthetic */ y(int i) {
        this.f148c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = this.f148c;
        Object obj3 = this.f149f;
        switch (i) {
            case 0:
                return ((Number) ((xb.p) obj3).invoke(obj, obj2)).intValue();
            case 1:
                return ((Number) ((i9.e) obj3).invoke(obj, obj2)).intValue();
            case 2:
                return ((Number) ((i9.e) obj3).invoke(obj, obj2)).intValue();
            case 3:
                return ((Number) ((i9.e) obj3).invoke(obj, obj2)).intValue();
            default:
                for (xb.l lVar : (xb.l[]) obj3) {
                    int iJ = com.stepos.statsrpk.h.j((Comparable) lVar.invoke(obj), (Comparable) lVar.invoke(obj2));
                    if (iJ != 0) {
                        return iJ;
                    }
                }
                return 0;
        }
    }
}
