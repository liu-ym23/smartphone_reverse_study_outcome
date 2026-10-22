package com.obric.aikernel.sdk.autotest;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.AIKListener;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.d;
import d.h.a.a;
import d.h.a.m;
import d.o;
import d.x;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.am;
import kotlinx.coroutines.n;

/* JADX INFO: compiled from: AutoTestManager.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "AutoTestManager.kt", c = {105}, d = "invokeSuspend", e = "com.obric.aikernel.sdk.autotest.AutoTestManager$callAutoTestAsResponse$responseBundle$1")
final class AutoTestManager$callAutoTestAsResponse$responseBundle$1 extends l implements m<am, d<? super Bundle>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ AIKBinder $binder;
    final /* synthetic */ long $timeoutMs;
    Object L$0;
    Object L$1;
    int label;

    AutoTestManager$callAutoTestAsResponse$responseBundle$1(Bundle r3, long r4, AIKBinder r6, d<? super AutoTestManager$callAutoTestAsResponse$responseBundle$1> r7) {
        AIKBinder r8 = (AIKBinder) ZeusTransformUtils.wrapperContextForParams(r6, AIKBinder.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        this.$args = r3;
        this.$timeoutMs = r4;
        this.$binder = r8;
        super(2, r9);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r8, d<?> r9) {
        d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
        return (d) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1(this.$args, this.$timeoutMs, this.$binder, r6), d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super Bundle> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super Bundle> r4) {
        return ((AutoTestManager$callAutoTestAsResponse$responseBundle$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), AutoTestManager$callAutoTestAsResponse$responseBundle$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r11) {
        Object r0 = b.a();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        Bundle r2 = (Bundle) ZeusTransformUtils.preCheckCast(this.L$1, Bundle.class, "com.obric.aiagent.plugin");
        AIKBinder r10 = (AIKBinder) ZeusTransformUtils.preCheckCast(this.L$0, AIKBinder.class, "com.obric.aiagent.plugin");
        o.a(r11);     // Catch: CancellationException -> L31
    L38:
        return (Bundle) ZeusTransformUtils.preCheckCast(r11, Bundle.class, "com.obric.aiagent.plugin");
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        o.a(r11);
        AIKLog.INSTANCE.v("AutoTestManager", "start callAutoTestlAsResponse " + this.$args.getString(IdlKeys.MethodName) + ", timeoutMs = " + this.$timeoutMs + ", traceid=" + this.$args.getString(IdlKeys.Args_TraceId));
        AIKBinder r12 = this.$binder;     // Catch: CancellationException -> L31
        Bundle r3 = this.$args;     // Catch: CancellationException -> L31
        this.L$0 = r12;     // Catch: CancellationException -> L31
        this.L$1 = r3;     // Catch: CancellationException -> L31
        this.label = 1;     // Catch: CancellationException -> L31
        kotlinx.coroutines.o r6 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")), 1);     // Catch: CancellationException -> L31
        r6.e();     // Catch: CancellationException -> L31
        final n r4 = (n) ZeusTransformUtils.preCheckCast(r6, n.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L31
        final a r5 = (a) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$deathRecipient$1(r4), a.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L31
        r12.asBinder().linkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: CancellationException -> L31
        r12.autoTest(r3, (AIKListener) ZeusTransformUtils.preCheckCast(new AutoTestManager$callAutoTestAsResponse$responseBundle$1$1$1(r4), AIKListener.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L16 RemoteException -> L18
        IBinder r13 = r12.asBinder();     // Catch: CancellationException -> L31
        IBinder.DeathRecipient r7 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L31
    L14:
        r13.unlinkToDeath(r7, 0);     // Catch: CancellationException -> L31
        r11 = r6.h();     // Catch: CancellationException -> L31
        if (r11 != b.a()) goto L26;
        h.c((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));     // Catch: CancellationException -> L31
    L26:
        if (r11 != r0) goto L38;
        return r0;
    L18:
        e = move-exception;
        if (r4.a() == false) goto L22;
        d r8 = (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L16
        d.n.a r9 = d.n.f38560a;     // Catch: Throwable -> L16
        r8.resumeWith(d.n.f(BundleExtKt.setErr(new Bundle(), 102, e.getMessage())));     // Catch: Throwable -> L16
    L22:
        r13 = r12.asBinder();     // Catch: CancellationException -> L31
        r7 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin");     // Catch: CancellationException -> L31
    L16:
        th = move-exception;
        r12.asBinder().unlinkToDeath((IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(new AutoTestManager$sam$android_os_IBinder_DeathRecipient$0(r5), IBinder.DeathRecipient.class, "com.obric.aiagent.plugin"), 0);     // Catch: CancellationException -> L31
        throw th;     // Catch: CancellationException -> L31
    L31:
        e = move-exception;
        AIKLog.INSTANCE.d("AutoTestManager", "callAutoTestlAsResponse error: " + e.getMessage());
        return (Bundle) ZeusTransformUtils.preCheckCast(null, Bundle.class, "com.obric.aiagent.plugin");
    }
}
