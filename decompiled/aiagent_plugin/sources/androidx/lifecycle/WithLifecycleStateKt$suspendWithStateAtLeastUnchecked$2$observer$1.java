package androidx.lifecycle;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ i.b f1962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ i f1963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ kotlinx.coroutines.n<R> f1964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ d.h.a.a<R> f1965d;

    @Override // androidx.lifecycle.m
    public void onStateChanged(p r3, i.a r4) {
        d.h.b.o.e((p) ZeusTransformUtils.wrapperContextForParams(r3, p.class, "com.obric.aiagent.plugin"), DBHelper.BATTERY_COL_SOURCE);
        d.h.b.o.e(r4, "event");
        if (r4 != i.a.Companion.c(this.f1962a)) goto L11;
        this.f1963b.b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        d.c.d r5 = this.f1964c;
        d.h.a.a<R> r2 = this.f1965d;
        d.n.a r6 = d.n.f38560a;     // Catch: Throwable -> L7
        Object r7 = d.n.f(r2.invoke());     // Catch: Throwable -> L7
    L9:
        r5.resumeWith(r7);
        return;
    L7:
        th = move-exception;
        d.n.a r8 = d.n.f38560a;
        r7 = d.n.f(d.o.a(th));
        goto L9
    L11:
        if (r4 != i.a.ON_DESTROY) goto L17;
        this.f1963b.b((o) ZeusTransformUtils.preCheckCast(this, o.class, "com.obric.aiagent.plugin"));
        d.c.d r9 = (d.c.d) ZeusTransformUtils.preCheckCast(this.f1964c, d.c.d.class, "com.obric.aiagent.plugin");
        d.n.a r10 = d.n.f38560a;
        r9.resumeWith(d.n.f(d.o.a((Throwable) ZeusTransformUtils.preCheckCast(new l(), Throwable.class, "com.obric.aiagent.plugin"))));
        return;
    }
}
