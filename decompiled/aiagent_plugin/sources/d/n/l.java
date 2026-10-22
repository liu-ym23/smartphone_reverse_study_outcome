package d.n;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class l<T> {
    public abstract Object a(T r1, d.c.d<? super x> r2);

    public abstract Object a(Iterator<? extends T> r1, d.c.d<? super x> r2);

    public l() {
    }

    public final Object a(Iterable<? extends T> r3, d.c.d<? super x> r4) {
        Iterable r5 = (Iterable) ZeusTransformUtils.wrapperContextForParams(r3, Iterable.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, Collection.class) == true) goto L5;
    L8:
        Object r2 = a(r5.iterator(), r6);
        if (r2 != d.c.a.b.a()) goto L12;
        return r2;
    L12:
        return x.f38692a;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L8;
        return x.f38692a;
    }

    public final Object a(j<? extends T> r3, d.c.d<? super x> r4) {
        j r5 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.aiagent.plugin");
        d.c.d<? super x> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        Object r2 = a(r5.a(), r6);
        if (r2 != d.c.a.b.a()) goto L6;
        return r2;
    L6:
        return x.f38692a;
    }
}
