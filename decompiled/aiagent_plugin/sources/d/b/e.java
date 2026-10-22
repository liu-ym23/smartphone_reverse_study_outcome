package d.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes4.dex */
final class e implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f38394a = null;

    static {
        f38394a = new e();
    }

    private e() {
    }

    @Override // java.util.Comparator
    public /* synthetic */ int compare(Comparable<? super Object> r3, Comparable<? super Object> r4) {
        return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.aiagent.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(r4, Comparable.class, "com.obric.aiagent.plugin"));
    }

    public int a(Comparable<Object> r2, Comparable<Object> r3) {
        Comparable r1 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r2, Comparable.class, "com.obric.aiagent.plugin");
        Comparable r4 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r3, Comparable.class, "com.obric.aiagent.plugin");
        o.e(r1, "a");
        o.e(r4, "b");
        return r1.compareTo(r4);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return (Comparator) ZeusTransformUtils.preCheckCast(f.f38395a, Comparator.class, "com.obric.aiagent.plugin");
    }
}
