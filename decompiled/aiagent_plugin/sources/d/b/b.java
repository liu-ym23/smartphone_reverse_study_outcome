package d.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes4.dex */
class b {
    /* JADX INFO: renamed from: lambda$Uy8tiFqdmMxTClQsOtW-kmz1SnY, reason: not valid java name */
    public static /* synthetic */ int m1250lambda$Uy8tiFqdmMxTClQsOtWkmz1SnY(d.h.a.b[] r0, Object r1, Object r2) {
        return a(r0, r1, r2);
    }

    private static final <T> int a(T r7, T r8, d.h.a.b<? super T, ? extends Comparable<?>>[] r9) {
        int r0 = r9.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L8;
        d.h.a.b<? super T, ? extends Comparable<?>> r3 = r9[r2];
        int r4 = a.a((Comparable) ZeusTransformUtils.preCheckCast(r3.invoke(r7), Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r3.invoke(r8), Comparable.class, "com.obric.aiagent.plugin"));
        if (r4 != 0) goto L6;
        r2 = r2 + 1;
        goto L3
    L6:
        return r4;
    L8:
        return 0;
    }

    public static final <T extends Comparable<?>> int a(T r2, T r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
        if (r4 != r5) goto L6;
        return 0;
    L6:
        if (r4 != null) goto L9;
        return -1;
    L9:
        if (r5 != null) goto L13;
        return 1;
    L13:
        return r4.compareTo(r5);
    }

    public static final <T> Comparator<T> a(final d.h.a.b<? super T, ? extends Comparable<?>>... r1) {
        o.e(r1, "selectors");
        if (r1.length <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return new $$Lambda$b$Uy8tiFqdmMxTClQsOtWkmz1SnY(r1);
    L10:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r0 = false;
        goto L6
    }

    private static final int a(d.h.a.b[] r0, Object r1, Object r2) {
        return a(r1, r2, r0);
    }

    public static final <T extends Comparable<? super T>> Comparator<T> a() {
        e r0 = e.f38394a;
        o.a(r0, "null cannot be cast to non-null type java.util.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder>{ kotlin.TypeAliasesKt.Comparator<T of kotlin.comparisons.ComparisonsKt__ComparisonsKt.naturalOrder> }");
        return (Comparator) ZeusTransformUtils.preCheckCast(r0, Comparator.class, "com.obric.aiagent.plugin");
    }
}
