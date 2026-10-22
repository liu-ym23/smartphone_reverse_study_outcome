package kotlin.reflect.jvm.internal.impl.resolve.constants;

import D7.v;
import L8.n;
import X8.A;
import X8.AbstractC0272c;
import X8.H;
import X8.K;
import Z8.i;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;

/* loaded from: classes4.dex */
public abstract class a {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v18, types: [X8.A] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [X8.A, X8.w, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set] */
    public static A a(ArrayList arrayList) {
        IntegerLiteralTypeConstructor$Companion$Mode[] integerLiteralTypeConstructor$Companion$ModeArr = IntegerLiteralTypeConstructor$Companion$Mode.f5117a;
        if (arrayList.isEmpty()) {
            return null;
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        ?? next = it.next();
        while (it.hasNext()) {
            A a3 = (A) it.next();
            next = (A) next;
            if (next != 0 && a3 != null) {
                K kQ = next.Q();
                K kQ2 = a3.Q();
                boolean z10 = kQ instanceof n;
                if (z10 && (kQ2 instanceof n)) {
                    n nVar = new n(v.k1(((n) kQ).f941a, ((n) kQ2).f941a));
                    H.b.getClass();
                    H attributes = H.c;
                    k.f(attributes, "attributes");
                    next = AbstractC0272c.v(i.a(ErrorScopeKind.c, true, "unknown integer literal type"), attributes, nVar, EmptyList.f4893a, false);
                } else if (z10) {
                    if (!((n) kQ).f941a.contains(a3)) {
                        a3 = null;
                    }
                    next = a3;
                } else if (!(kQ2 instanceof n) || !((n) kQ2).f941a.contains(next)) {
                }
            }
            next = 0;
        }
        return (A) next;
    }
}
