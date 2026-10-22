package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes4.dex */
public abstract class z {
    public static Object a(Object r10) {
        return r10;
    }

    public static final y b(Object r10) {
        if (r10 == d.a()) goto L7;
        kotlin.jvm.internal.q.e(r10, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (y) r10;
    L7:
        throw new IllegalStateException("Does not contain segment");
    }

    public static final boolean c(Object r10) {
        if (r10 != d.a()) goto L5;
        return true;
    L5:
        return false;
    }
}
