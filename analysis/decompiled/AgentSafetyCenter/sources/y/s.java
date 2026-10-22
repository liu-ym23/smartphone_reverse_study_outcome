package y;

import java.util.Comparator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class s implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15818c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ b2.a f15819f;

    public /* synthetic */ s(int i) {
        this.f15818c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f15818c) {
            case 0:
                b2.a aVar = this.f15819f;
                return com.stepos.statsrpk.h.j(Integer.valueOf(aVar.b(((x.n) obj).f15461g)), Integer.valueOf(aVar.b(((x.n) obj2).f15461g)));
            default:
                b2.a aVar2 = this.f15819f;
                return com.stepos.statsrpk.h.j(Integer.valueOf(aVar2.b(((x.n) obj2).f15461g)), Integer.valueOf(aVar2.b(((x.n) obj).f15461g)));
        }
    }
}
