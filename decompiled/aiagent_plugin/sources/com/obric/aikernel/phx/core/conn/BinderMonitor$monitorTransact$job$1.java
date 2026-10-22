package com.obric.aikernel.phx.core.conn;

import com.obric.aikernel.core.log.AIKLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.c.g;
import d.h.a.a;
import d.h.a.m;
import d.h.b.z;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.i;

/* JADX INFO: compiled from: BinderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "BinderMonitor.kt", c = {39}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.conn.BinderMonitor$monitorTransact$job$1")
final class BinderMonitor$monitorTransact$job$1 extends l implements m<am, d<? super x>, Object> {
    final /* synthetic */ g $ctx;
    final /* synthetic */ z.f<BinderMonitor.BinderInfo> $info;
    final /* synthetic */ a<x> $onDied;
    private /* synthetic */ Object L$0;
    int label;

    BinderMonitor$monitorTransact$job$1(z.f<BinderMonitor.BinderInfo> r3, g r4, a<x> r5, d<? super BinderMonitor$monitorTransact$job$1> r6) {
        g r7 = (g) ZeusTransformUtils.wrapperContextForParams(r4, g.class, "com.obric.aiagent.plugin");
        a<x> r8 = (a) ZeusTransformUtils.wrapperContextForParams(r5, a.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        this.$info = r3;
        this.$ctx = r7;
        this.$onDied = r8;
        super(2, r9);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r5, d<?> r6) {
        d r7 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
        BinderMonitor$monitorTransact$job$1 r0 = new BinderMonitor$monitorTransact$job$1(this.$info, this.$ctx, this.$onDied, r7);
        r0.L$0 = r5;
        return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super x> r4) {
        return ((BinderMonitor$monitorTransact$job$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), BinderMonitor$monitorTransact$job$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r9) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        o.a(r9);
    L16:
        throw new d.d();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r9);
        final am r10 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
        BinderMonitor.BinderInfo r2 = (BinderMonitor.BinderInfo) ZeusTransformUtils.preCheckCast(this.$info.f38504a, BinderMonitor.BinderInfo.class, "com.obric.aiagent.plugin");
        if (r2 == null) goto L18;
        kotlinx.coroutines.b.x<Boolean> r3 = r2.getStateFlow();
        if (r3 == null) goto L18;
        AIKLog.INSTANCE.d("BinderMonitor", "monitorTransact: register onDied stateFlow: " + this.$ctx);
        final g r5 = this.$ctx;
        final a<x> r6 = this.$onDied;
        i<? super Boolean> r11 = (i) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10, r5, r6), i.class, "com.obric.aiagent.plugin");
        d<?> r4 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
        this.label = 1;
        if (r3.collect(r11, r4) != r0) goto L16;
        return r0;
    L18:
        return x.f38692a;
    }
}
