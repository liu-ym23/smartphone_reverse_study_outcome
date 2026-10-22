package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes4.dex */
public class ah<T> extends kotlinx.coroutines.a<T> implements d.c.b.a.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d.c.d<T> f39362c;

    @Override // kotlinx.coroutines.ci
    public final boolean e() {
        return true;
    }

    @Override // d.c.b.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    public ah(d.c.g r3, d.c.d<? super T> r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        d.c.d<T> r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
        super(r5, true, true);
        this.f39362c = r6;
    }

    @Override // d.c.b.a.e
    public final d.c.b.a.e getCallerFrame() {
        d.c.d<T> r2 = this.f39362c;
        if (ZeusTransformUtils.instanceOf(r2, d.c.b.a.e.class) == true) goto L7;
        return null;
    L7:
        return (d.c.b.a.e) ZeusTransformUtils.preCheckCast(r2, d.c.b.a.e.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ci
    public void d(Object r3) {
        n.a(d.c.a.b.a(this.f39362c), kotlinx.coroutines.ae.a(r3, this.f39362c), null, 2, null);
    }

    @Override // kotlinx.coroutines.a
    public void c(Object r1) {
        d.c.d<T> r0 = this.f39362c;
        r0.resumeWith(kotlinx.coroutines.ae.a(r1, r0));
    }
}
