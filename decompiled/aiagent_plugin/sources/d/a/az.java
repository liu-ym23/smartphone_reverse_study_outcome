package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: Sets.kt */
/* JADX INFO: loaded from: classes4.dex */
class az extends ay {
    public static final <T> Set<T> b() {
        return (Set) ZeusTransformUtils.preCheckCast(ad.f38347a, Set.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> a(T... r1) {
        d.h.b.o.e(r1, "elements");
        return i.i(r1);
    }

    public static final <T> Set<T> b(T... r3) {
        d.h.b.o.e(r3, "elements");
        return (Set) ZeusTransformUtils.preCheckCast(i.b(r3, (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(ao.a(r3.length)), Collection.class, "com.obric.aiagent.plugin")), Set.class, "com.obric.aiagent.plugin");
    }

    public static final <T> HashSet<T> c(T... r3) {
        d.h.b.o.e(r3, "elements");
        return (HashSet) ZeusTransformUtils.preCheckCast(i.b(r3, (Collection) ZeusTransformUtils.preCheckCast(new HashSet(ao.a(r3.length)), Collection.class, "com.obric.aiagent.plugin")), HashSet.class, "com.obric.aiagent.plugin");
    }

    public static final <T> Set<T> b(Set<? extends T> r2) {
        Set<T> r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        int r0 = r3.size();
        if (r0 == 0) goto L9;
        if (r0 == 1) goto L10;
        return r3;
    L10:
        return ax.a(r3.iterator().next());
    L9:
        return ax.b();
    }
}
