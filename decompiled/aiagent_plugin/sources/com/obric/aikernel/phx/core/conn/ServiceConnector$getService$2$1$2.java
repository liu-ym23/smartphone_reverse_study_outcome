package com.obric.aikernel.phx.core.conn;

import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ax;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "ServiceConnector.kt", c = {165}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$2")
final class ServiceConnector$getService$2$1$2 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ au<AIKBinder> $task;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;

    ServiceConnector$getService$2$1$2(au<? extends AIKBinder> r3, d<? super ServiceConnector$getService$2$1$2> r4) {
        au<AIKBinder> r5 = (au) ZeusTransformUtils.wrapperContextForParams(r3, au.class, "com.obric.aiagent.plugin");
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.$task = r5;
        super(2, r6);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        ServiceConnector$getService$2$1$2 r0 = new ServiceConnector$getService$2$1$2(this.$task, r5);
        r0.L$0 = r3;
        return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((ServiceConnector$getService$2$1$2) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), ServiceConnector$getService$2$1$2.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r7) {
        Object r0 = b.a();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        am r4 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
        o.a(r7);
    L12:
        au<AIKBinder> r8 = this.$task;
        if (r8 != null) goto L15;
    L17:
        r3 = false;
    L18:
        au<AIKBinder> r9 = this.$task;
        n.a r5 = n.f38560a;     // Catch: Throwable -> L25
        if (r3 == false) goto L23;
        if (r9 == null) goto L23;
        r9.a(new CancellationException("connectTask timeout by " + r2));     // Catch: Throwable -> L25
    L23:
        Object r10 = n.f(x.f38692a);     // Catch: Throwable -> L25
    L27:
        AIKLog.INSTANCE.i("ServiceConnector", "cancel active:" + r3 + ' ' + this.$task + " success:" + n.a(r10) + " exception:" + n.c(r10));
        return x.f38692a;
    L25:
        th = move-exception;
        n.a r6 = n.f38560a;
        r10 = n.f(o.a(th));
        goto L27
    L15:
        if (r8.b() != true) goto L17;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r7);
        am r11 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
        d r12 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.L$0 = r11;
        this.J$0 = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.label = 1;
        if (ax.a(OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS, r12) != r0) goto L11;
        return r0;
    L11:
        r2 = 30000;
        goto L12
    }
}
