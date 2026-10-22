package kotlinx.coroutines.internal;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bf;
import kotlinx.coroutines.cm;

/* JADX INFO: compiled from: MainDispatchers.kt */
/* JADX INFO: loaded from: classes4.dex */
final class ac extends cm implements aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Throwable f39356a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f39357d;

    @Override // kotlinx.coroutines.aw
    public /* synthetic */ void a(long r3, kotlinx.coroutines.n r5) {
        b(r3, (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin"));
    }

    @Override // kotlinx.coroutines.ai
    public /* synthetic */ void a(d.c.g r3, Runnable r4) {
        c((d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin"), (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin"));
    }

    public ac(Throwable r1, String r2) {
        this.f39356a = r1;
        this.f39357d = r2;
    }

    @Override // kotlinx.coroutines.cm
    public cm a() {
        return (cm) ZeusTransformUtils.preCheckCast(this, cm.class, "com.obric.aiagent.plugin");
    }

    @Override // kotlinx.coroutines.ai
    public boolean a(d.c.g r3) {
        d.c.g r4 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        c();
        throw new d.d();
    }

    @Override // kotlinx.coroutines.cm, kotlinx.coroutines.ai
    public kotlinx.coroutines.ai a(int r1) {
        c();
        throw new d.d();
    }

    @Override // kotlinx.coroutines.aw
    public bf a(long r1, Runnable r3, d.c.g r4) {
        Runnable r2 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.aiagent.plugin");
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r4, d.c.g.class, "com.obric.aiagent.plugin");
        c();
        throw new d.d();
    }

    public Void c(d.c.g r3, Runnable r4) {
        d.c.g r5 = (d.c.g) ZeusTransformUtils.wrapperContextForParams(r3, d.c.g.class, "com.obric.aiagent.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.aiagent.plugin");
        c();
        throw new d.d();
    }

    public Void b(long r1, kotlinx.coroutines.n<? super d.x> r3) {
        kotlinx.coroutines.n r2 = (kotlinx.coroutines.n) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        c();
        throw new d.d();
    }

    private final Void c() {
        if (this.f39356a == null) goto L11;
        StringBuilder r0 = new StringBuilder().append("Module with the Main dispatcher had failed to initialize");
        String r1 = this.f39357d;
        if (r1 == null) goto L8;
        String r2 = ". " + r1;
        if (r2 == null) goto L8;
    L10:
        throw new IllegalStateException(r0.append(r2).toString(), this.f39356a);
    L8:
        r2 = "";
        goto L10
    L11:
        ab.a();
        throw new d.d();
    }

    @Override // kotlinx.coroutines.cm, kotlinx.coroutines.ai
    public String toString() {
        StringBuilder r0 = new StringBuilder().append("Dispatchers.Main[missing");
        if (this.f39356a == null) goto L5;
        String r3 = ", cause=" + this.f39356a;
    L7:
        return r0.append(r3).append(']').toString();
    L5:
        r3 = "";
        goto L7
    }
}
