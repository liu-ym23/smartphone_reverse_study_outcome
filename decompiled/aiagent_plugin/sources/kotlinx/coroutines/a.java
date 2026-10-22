package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbstractCoroutine.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> extends ci implements d.c.d<T>, am, ca {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.c.g f38770b;

    public void a(T r1) {
    }

    public void a(Throwable r1, boolean r2) {
    }

    public a(d.c.g r3, boolean r4, boolean r5) {
        d.c.g r6 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        super(r5);
        if (r4 == false) goto L5;
        a((ca) ZeusTransformUtils.preCheckCast(r6.get((d.c.g.c) ZeusTransformUtils.preCheckCast(ca.f39180a, d.c.g.c.class, "com.obric.aiagent.plugin")), ca.class, "com.obric.aiagent.plugin"));
    L5:
        this.f38770b = r6.plus((d.c.g) ZeusTransformUtils.preCheckCast(this, d.c.g.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.c.d
    public final d.c.g getContext() {
        return this.f38770b;
    }

    @Override // kotlinx.coroutines.am
    public d.c.g a() {
        return this.f38770b;
    }

    @Override // kotlinx.coroutines.ci, kotlinx.coroutines.ca
    public boolean b() {
        return super.b();
    }

    @Override // kotlinx.coroutines.ci
    public String c() {
        return ar.b(this) + " was cancelled";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.ci
    public final void b(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, ab.class) == false) goto L5;
        a(((ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.aiagent.plugin")).f38830a, ((ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.aiagent.plugin")).b());
        return;
    L5:
        a(r4);
    }

    @Override // d.c.d
    public final void resumeWith(Object r3) {
        Object r4 = g(ae.a(r3, null, 1, null));
        if (r4 != cj.f39202a) goto L5;
        return;
    L5:
        c(r4);
    }

    public void c(Object r1) {
        d(r1);
    }

    @Override // kotlinx.coroutines.ci
    public final void a_(Throwable r1) {
        aj.a(this.f38770b, r1);
    }

    @Override // kotlinx.coroutines.ci
    public String d() {
        String r0 = ah.a(this.f38770b);
        if (r0 != null) goto L7;
        return super.d();
    L7:
        return '\"' + r0 + "\":" + super.d();
    }

    public final <R> void a(ao r3, R r4, d.h.a.m<? super R, ? super d.c.d<? super T>, ? extends Object> r5) {
        r3.a((d.h.a.m) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.m.class, "com.obric.aiagent.plugin"), r4, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
    }
}
