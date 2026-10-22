package y;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15816c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ w f15817f;

    public /* synthetic */ r(int i) {
        this.f15816c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f15816c) {
            case 0:
                w wVar = this.f15817f;
                return com.stepos.statsrpk.h.j(Integer.valueOf(wVar.b(((x.n) obj).f15461g)), Integer.valueOf(wVar.b(((x.n) obj2).f15461g)));
            default:
                w wVar2 = this.f15817f;
                return com.stepos.statsrpk.h.j(Integer.valueOf(wVar2.b(((x.n) obj2).f15461g)), Integer.valueOf(wVar2.b(((x.n) obj).f15461g)));
        }
    }
}
