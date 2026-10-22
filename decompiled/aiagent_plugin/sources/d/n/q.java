package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: _SequencesJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class q extends p {
    public static final <T extends Comparable<? super T>> SortedSet<T> b(j<? extends T> r3) {
        j r4 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        return (SortedSet) ZeusTransformUtils.preCheckCast(m.a(r4, (Collection) ZeusTransformUtils.preCheckCast(new TreeSet(), Collection.class, "com.obric.aiagent.plugin")), SortedSet.class, "com.obric.aiagent.plugin");
    }
}
