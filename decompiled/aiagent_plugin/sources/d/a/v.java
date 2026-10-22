package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class v extends u {
    public static final <T extends Comparable<? super T>> void d(List<T> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (r3.size() <= 1) goto L6;
        Collections.sort(r3);
        return;
    }

    public static final <T> void a(List<T> r2, Comparator<? super T> r3) {
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r3, Comparator.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        d.h.b.o.e(r5, "comparator");
        if (r4.size() <= 1) goto L6;
        Collections.sort(r4, r5);
        return;
    }
}
