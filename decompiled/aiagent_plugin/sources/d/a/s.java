package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: Iterables.kt */
/* JADX INFO: loaded from: classes4.dex */
class s extends r {
    public static final <T> Integer b(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        if (ZeusTransformUtils.instanceOf(r3, Collection.class) == true) goto L7;
        return null;
    L7:
        return Integer.valueOf(((Collection) ZeusTransformUtils.preCheckCast(r3, Collection.class, "com.obric.aiagent.plugin")).size());
    }

    public static final <T> int a(Iterable<? extends T> r2, int r3) {
        Iterable r4 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "<this>");
        if (ZeusTransformUtils.instanceOf(r4, Collection.class) == true) goto L5;
        return r3;
    L5:
        return ((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.aiagent.plugin")).size();
    }

    public static final <T> List<T> c(Iterable<? extends Iterable<? extends T>> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r4, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r5, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L7;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r6.next(), Iterable.class, "com.obric.aiagent.plugin");
        p.a((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.aiagent.plugin"), r2);
        goto L4
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r0, List.class, "com.obric.aiagent.plugin");
    }
}
