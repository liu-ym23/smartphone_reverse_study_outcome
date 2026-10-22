package kotlin.comparisons;

import java.util.Comparator;

/* loaded from: classes2.dex */
public final /* synthetic */ class b implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13399a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Comparator f13400b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Comparator f13401c;

    public /* synthetic */ b(Comparator comparator, Comparator comparator2, int i4) {
        this.f13399a = i4;
        this.f13400b = comparator;
        this.f13401c = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i4 = this.f13399a;
        Comparator comparator = this.f13401c;
        Comparator comparator2 = this.f13400b;
        switch (i4) {
            case 0:
                return ComparisonsKt__ComparisonsKt.thenDescending$lambda$2$ComparisonsKt__ComparisonsKt(comparator2, comparator, obj, obj2);
            default:
                return ComparisonsKt__ComparisonsKt.then$lambda$1$ComparisonsKt__ComparisonsKt(comparator2, comparator, obj, obj2);
        }
    }
}
