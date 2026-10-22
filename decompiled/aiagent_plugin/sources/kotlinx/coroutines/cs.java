package kotlinx.coroutines;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes4.dex */
final class cs<T> extends ch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o<T> f39211a;

    /* JADX WARN: Multi-variable type inference failed */
    public cs(o<? super T> r1) {
        this.f39211a = r1;
    }

    @Override // kotlinx.coroutines.bw
    public void a(Throwable r3) {
        Object r4 = c().n();
        if (aq.a() == false) goto L10;
        if ((!ZeusTransformUtils.instanceOf(r4, bu.class)) == true) goto L10;
        throw new AssertionError();
    L10:
        if (ZeusTransformUtils.instanceOf(r4, ab.class) == false) goto L12;
        d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f39211a, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r0 = d.n.f38560a;
        r2.resumeWith(d.n.f(d.o.a(((ab) ZeusTransformUtils.preCheckCast(r4, ab.class, "com.obric.aiagent.plugin")).f38830a)));
        return;
    L12:
        d.c.d r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f39211a, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r1 = d.n.f38560a;
        r5.resumeWith(d.n.f(cj.b(r4)));
    }
}
