package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.g.b;
import d.h.b.o;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b<B extends g.b, E extends B> implements g.c<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.h.a.b<g.b, E> f38407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g.c<?> f38408b;

    public b(g.c<B> r4, d.h.a.b<? super g.b, ? extends E> r5) {
        g.c<?> r6 = (g.c) ZeusTransformUtils.wrapperContextForParams(r4, g.c.class, "com.obric.aiagent.plugin");
        d.h.a.b<g.b, E> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r6, "baseKey");
        o.e(r7, "safeCast");
        this.f38407a = r7;
        if (ZeusTransformUtils.instanceOf(r6, b.class) == false) goto L5;
        r6 = ((b) ZeusTransformUtils.preCheckCast(r6, b.class, "com.obric.aiagent.plugin")).f38408b;
    L5:
        this.f38408b = r6;
    }

    /* JADX WARN: Incorrect return type in method signature: (Ld/c/g$b;)TE; */
    public final g.b a(g.b r3) {
        g.b r4 = (g.b) ZeusTransformUtils.wrapperContextForParams(r3, g.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "element");
        return (g.b) ZeusTransformUtils.preCheckCast(this.f38407a.invoke(r4), g.b.class, "com.obric.aiagent.plugin");
    }

    public final boolean a(g.c<?> r3) {
        g.c<?> r4 = (g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        if (r4 != this) goto L5;
    L8:
        return true;
    L5:
        if (this.f38408b == r4) goto L8;
        return false;
    }
}
