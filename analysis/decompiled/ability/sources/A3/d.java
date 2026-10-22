package A3;

import java.util.function.IntPredicate;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final IntPredicate f95a;
    public static final IntPredicate b;

    static {
        c cVar = new c(0);
        c cVar2 = new c(1);
        IntPredicate intPredicateOr = cVar.or(new c(3)).or(new c(2));
        f95a = intPredicateOr;
        b = intPredicateOr.or(cVar2);
    }
}
