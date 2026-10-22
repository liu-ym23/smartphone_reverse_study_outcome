package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CollectionsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class q {
    public static final <T> List<T> a(T r1) {
        List<T> r2 = Collections.singletonList(r1);
        d.h.b.o.c(r2, "singletonList(...)");
        return r2;
    }

    public static final <E> List<E> a() {
        return (List) ZeusTransformUtils.preCheckCast(new d.a.a.b(0, 1, null), List.class, "com.obric.aiagent.plugin");
    }

    public static final <E> List<E> a(int r2) {
        return (List) ZeusTransformUtils.preCheckCast(new d.a.a.b(r2), List.class, "com.obric.aiagent.plugin");
    }

    public static final <E> List<E> a(List<E> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "builder");
        return ((d.a.a.b) ZeusTransformUtils.preCheckCast(r3, d.a.a.b.class, "com.obric.aiagent.plugin")).b();
    }

    public static final <T> List<T> a(Iterable<? extends T> r2) {
        Iterable r3 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r2, Iterable.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "<this>");
        List<T> r4 = p.p(r3);
        Collections.shuffle(r4);
        return r4;
    }

    public static final <T> T[] a(int r1, T[] r2) {
        d.h.b.o.e(r2, "array");
        if (r1 >= r2.length) goto L5;
        r2[r1] = null;
    L5:
        return r2;
    }

    public static final <T> Object[] a(T[] r1, boolean r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == true) goto L5;
    L7:
        Object[] r3 = Arrays.copyOf(r1, r1.length, Object[].class);
        d.h.b.o.c(r3, "copyOf(...)");
        return r3;
    L5:
        if (d.h.b.o.a(r1.getClass(), Object[].class) == false) goto L7;
        return r1;
    }
}
