package d.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.m;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class h implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f38423a = null;

    static {
        f38423a = new h();
    }

    @Override // d.c.g
    public <R> R fold(R r2, m<? super R, ? super g.b, ? extends R> r3) {
        o.e((m) ZeusTransformUtils.wrapperContextForParams(r3, m.class, "com.obric.aiagent.plugin"), "operation");
        return r2;
    }

    @Override // d.c.g
    public <E extends g.b> E get(g.c<E> r2) {
        o.e((g.c) ZeusTransformUtils.wrapperContextForParams(r2, g.c.class, "com.obric.aiagent.plugin"), "key");
        return null;
    }

    public int hashCode() {
        return 0;
    }

    @Override // d.c.g
    public g plus(g r2) {
        g r1 = (g) ZeusTransformUtils.wrapperContextForParams(r2, g.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        return r1;
    }

    public String toString() {
        return "EmptyCoroutineContext";
    }

    private h() {
    }

    @Override // d.c.g
    public g minusKey(g.c<?> r3) {
        o.e((g.c) ZeusTransformUtils.wrapperContextForParams(r3, g.c.class, "com.obric.aiagent.plugin"), "key");
        return (g) ZeusTransformUtils.preCheckCast(this, g.class, "com.obric.aiagent.plugin");
    }
}
