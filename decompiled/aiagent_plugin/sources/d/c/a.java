package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements g.b {
    private final g.c<?> key;

    public a(g.c<?> r3) {
        g.c<?> r4 = (g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin");
        o.e(r4, "key");
        this.key = r4;
    }

    @Override // d.c.g
    public <R> R fold(R r3, m<? super R, ? super g.b, ? extends R> r4) {
        return (R) g.b.a.a(this, r3, (m) ZeusTransformUtils.wrapperContextForParams(r4, m.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b, d.c.g
    public <E extends g.b> E get(g.c<E> r3) {
        return (E) g.b.a.a(this, (g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public g minusKey(g.c<?> r3) {
        return g.b.a.b(this, (g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g
    public g plus(g r3) {
        return g.b.a.a(this, (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.g.b
    public g.c<?> getKey() {
        return this.key;
    }
}
