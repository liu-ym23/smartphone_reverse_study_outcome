package kotlinx.coroutines.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes4.dex */
final class y<T> implements d.c.b.a.e, d.c.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.c.d<T> f38951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.g f38952b;

    @Override // d.c.b.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    public y(d.c.d<? super T> r3, d.c.g r4) {
        d.c.d<T> r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        this.f38951a = r5;
        this.f38952b = r6;
    }

    @Override // d.c.d
    public d.c.g getContext() {
        return this.f38952b;
    }

    @Override // d.c.b.a.e
    public d.c.b.a.e getCallerFrame() {
        d.c.d<T> r2 = this.f38951a;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // d.c.d
    public void resumeWith(Object r1) {
        this.f38951a.resumeWith(r1);
    }
}
