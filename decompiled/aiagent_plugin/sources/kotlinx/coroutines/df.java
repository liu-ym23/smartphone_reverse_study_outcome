package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes4.dex */
final class df<U, T extends U> extends kotlinx.coroutines.internal.ah<T> implements Runnable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f39258b;

    public df(long r3, d.c.d<? super U> r5) {
        d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        super(r6.getContext(), r6);
        this.f39258b = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
        d((Throwable) ZeusTransformUtils.preCheckCast(dg.a(this.f39258b, ax.a(getContext()), (ca) ZeusTransformUtils.preCheckCast(this, ca.class, "com.obric.aiagent.plugin")), Throwable.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.a, kotlinx.coroutines.ci
    public String d() {
        return super.d() + "(timeMillis=" + this.f39258b + ')';
    }
}
