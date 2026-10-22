package c8;

import java.util.function.IntPredicate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final IntPredicate f2230a;

    /* renamed from: b, reason: collision with root package name */
    public static final IntPredicate f2231b;

    static {
        c cVar = new c(0);
        c cVar2 = new c(1);
        IntPredicate intPredicateOr = cVar.or(new c(3)).or(new c(2));
        f2230a = intPredicateOr;
        f2231b = intPredicateOr.or(cVar2);
    }
}
