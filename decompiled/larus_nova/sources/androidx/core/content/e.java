package androidx.core.content;

import androidx.core.util.Predicate;

/* JADX INFO: loaded from: classes17.dex */
public final /* synthetic */ class e implements Predicate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f15343a;

    public /* synthetic */ e(String r100) {
        this.f15343a = r100;
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate and(Predicate r100) {
        return Predicate.CC.$default$and(this, r100);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate negate() {
        return Predicate.CC.$default$negate(this);
    }

    @Override // androidx.core.util.Predicate
    public final /* synthetic */ Predicate or(Predicate r100) {
        return Predicate.CC.$default$or(this, r100);
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object r100) {
        return this.f15343a.equals((String) r100);
    }
}
