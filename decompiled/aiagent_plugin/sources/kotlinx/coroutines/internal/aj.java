package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.internal.ai;

/* JADX INFO: compiled from: ConcurrentLinkedList.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class aj<S extends ai<S>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f39365a;

    public static boolean a(Object r3, Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, aj.class) == true) goto L6;
        return false;
    L6:
        if (d.h.b.o.a(r3, ((aj) ZeusTransformUtils.preCheckCast(r4, aj.class, "com.obric.aiagent.plugin")).a()) == true) goto L8;
        return false;
    L8:
        return true;
    }

    public static String c(Object r2) {
        return "SegmentOrClosed(value=" + r2 + ')';
    }

    public static int d(Object r0) {
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.hashCode();
    }

    public static <S extends ai<S>> Object e(Object r0) {
        return r0;
    }

    public final /* synthetic */ Object a() {
        return this.f39365a;
    }

    public boolean equals(Object r1) {
        return a(this.f39365a, r1);
    }

    public int hashCode() {
        return d(this.f39365a);
    }

    public String toString() {
        return c(this.f39365a);
    }

    public static final boolean a(Object r1) {
        if (r1 != e.a()) goto L5;
        return true;
    L5:
        return false;
    }

    public static final S b(Object r2) {
        if (r2 == e.a()) goto L7;
        d.h.b.o.a(r2, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
        return (S) ZeusTransformUtils.preCheckCast(r2, ai.class, "com.obric.aiagent.plugin");
    L7:
        throw new IllegalStateException("Does not contain segment".toString());
    }
}
