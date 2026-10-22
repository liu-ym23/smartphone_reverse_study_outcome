package d.l;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes4.dex */
class o {
    public static final <T extends Comparable<? super T>> f<T> a(T r2, T r3) {
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        Comparable r5 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "that");
        return (f) ZeusTransformUtils.preCheckCast(new g(r4, r5), f.class, "com.obric.aiagent.plugin");
    }

    public static final e<Double> a(double r1, double r3) {
        return (e) ZeusTransformUtils.preCheckCast(new d(r1, r3), e.class, "com.obric.aiagent.plugin");
    }

    public static final void a(boolean r2, Number r3) {
        d.h.b.o.e(r3, "step");
        if (r2 == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("Step must be positive, was: " + r3 + '.');
    }
}
