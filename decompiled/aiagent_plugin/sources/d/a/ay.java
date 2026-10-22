package d.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: SetsJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
class ay {
    public static final <T> Set<T> a(T r1) {
        Set<T> r2 = Collections.singleton(r1);
        d.h.b.o.c(r2, "singleton(...)");
        return r2;
    }

    public static final <E> Set<E> a() {
        return (Set) ZeusTransformUtils.preCheckCast(new d.a.a.h(), Set.class, "com.obric.aiagent.plugin");
    }

    public static final <E> Set<E> a(Set<E> r2) {
        Set r3 = (Set) ZeusTransformUtils.wrapperContextForParams(r2, Set.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "builder");
        return ((d.a.a.h) ZeusTransformUtils.preCheckCast(r3, d.a.a.h.class, "com.obric.aiagent.plugin")).b();
    }
}
