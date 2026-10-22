package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Unconfined.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class dh extends ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dh f39264a = null;

    static {
        f39264a = new dh();
    }

    @Override // kotlinx.coroutines.ai
    public boolean a(d.c.g r2) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        return false;
    }

    @Override // kotlinx.coroutines.ai
    public String toString() {
        return "Dispatchers.Unconfined";
    }

    private dh() {
    }

    @Override // kotlinx.coroutines.ai
    public ai a(int r1) {
        throw new UnsupportedOperationException("limitedParallelism is not supported for Dispatchers.Unconfined");
    }

    @Override // kotlinx.coroutines.ai
    public void a(d.c.g r2, Runnable r3) {
        d.c.g r1 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r2, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        dl r5 = (dl) ZeusTransformUtils.preCheckCast(r1.get((d.c.g.c) ZeusTransformUtils.preCheckCast(dl.f39267a, d.c.g.c.class, "com.obric.aiagent.plugin")), dl.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L7;
        r5.f39268b = true;
        return;
    L7:
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
}
