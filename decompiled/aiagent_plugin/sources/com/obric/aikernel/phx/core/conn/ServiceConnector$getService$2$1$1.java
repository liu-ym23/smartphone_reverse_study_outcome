package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.a;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.a.b;
import d.c.b.a.f;
import d.c.b.a.h;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.n;
import d.o;
import d.x;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.br;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes3.dex */
@f(b = "ServiceConnector.kt", c = {200}, d = "invokeSuspend", e = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$1")
final class ServiceConnector$getService$2$1$1 extends l implements m<am, d<? super AIKBinder>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getService$2$1$1(ServiceConnector r3, d<? super ServiceConnector$getService$2$1$1> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // d.c.b.a.a
    public final d<x> create(Object r3, d<?> r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
        ServiceConnector$getService$2$1$1 r0 = new ServiceConnector$getService$2$1$1(this.this$0, r5);
        r0.L$0 = r3;
        return (d) ZeusTransformUtils.preCheckCast(r0, d.class, "com.obric.aiagent.plugin");
    }

    @Override // d.h.a.m
    public /* synthetic */ Object invoke(am r3, d<? super AIKBinder> r4) {
        return invoke2((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(am r3, d<? super AIKBinder> r4) {
        return ((ServiceConnector$getService$2$1$1) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), ServiceConnector$getService$2$1$1.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
    }

    @Override // d.c.b.a.a
    public final Object invokeSuspend(Object r12) {
        Object r0 = b.a();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ServiceConnector r2 = (ServiceConnector) ZeusTransformUtils.preCheckCast(this.L$0, ServiceConnector.class, "com.obric.aiagent.plugin");
        o.a(r12);
    L47:
        AIKBinder r13 = (AIKBinder) ZeusTransformUtils.preCheckCast(r12, AIKBinder.class, "com.obric.aiagent.plugin");
    L48:
        ServiceConnector r11 = this.this$0;
        monitor-enter(r11);
        ServiceConnector.access$setConnectTask$p(r11, null);     // Catch: Throwable -> L53
        ServiceConnector.access$setContinuation$p(r11, null);     // Catch: Throwable -> L53
        x r4 = x.f38692a;     // Catch: Throwable -> L53
        monitor-exit(r11);
        return r13;
    L53:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        o.a(r12);
        am r14 = (am) ZeusTransformUtils.preCheckCast(this.L$0, am.class, "com.obric.aiagent.plugin");
        Intent r15 = new Intent();
        r15.setComponent(ServiceConnector.access$getConnName$p(this.this$0));
        r15.addFlags(1);
        ExtraAppInfo r5 = ServiceConnector.access$getAiKernelConfig$p(this.this$0).getExtraBindInfo();
        if (r5 == null) goto L12;
        r15.putExtra(IdlKeys.Args_BindExtraInfo, (Parcelable) ZeusTransformUtils.preCheckCast(r5, Parcelable.class, "com.obric.aiagent.plugin"));
    L12:
        if (a.f22349a.c() == false) goto L32;
        ContentResolver r6 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServiceConnector.access$getContext$p(this.this$0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getContentResolver();
        Bundle r9 = new Bundle();
        r9.putParcelable(MemorySourceLinkType.INTENT, (Parcelable) ZeusTransformUtils.preCheckCast(r15, Parcelable.class, "com.obric.aiagent.plugin"));
        x r16 = x.f38692a;
        Bundle r17 = ZeusProviderTransform.call(r6, "com.obric.aikernel.service.auth", "onBind", null, r9, "com.obric.aiagent.plugin");
        if (r17 == null) goto L31;
        IBinder r18 = r17.getBinder("binder");
        if (r18 == null) goto L31;
        r13 = AIKBinder.Stub.asInterface(r18);
        if (r13 == null) goto L31;
        ServiceConnector r7 = this.this$0;
        ServiceConnector.access$setRemote$p(r7, r13);
        n.a r8 = n.f38560a;     // Catch: Throwable -> L26
        Context r10 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServiceConnector.access$getContext$p(r7), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L26
        Intent r19 = new Intent();     // Catch: Throwable -> L26
        r19.setComponent(new ComponentName(ServiceConnector.access$getConnName$p(r7).getPackageName(), "com.obric.aikernel.LifeCycleService"));     // Catch: Throwable -> L26
        boolean r20 = ProcessPriorityBindingKt.bindAutoCreate(r10, r19, br.a(bd.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(ServiceConnector.access$getLifeCycleConnection$p(r7), ServiceConnection.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L26
        AIKLog r21 = AIKLog.INSTANCE;     // Catch: Throwable -> L26
        StringBuilder r22 = new StringBuilder().append("bind lifecycle service result=");     // Catch: Throwable -> L26
        if (r20 == true) goto L24;
        r3 = false;
    L24:
        r21.i("ServiceConnector", r22.append(r3).toString());     // Catch: Throwable -> L26
        Object r23 = n.f(x.f38692a);     // Catch: Throwable -> L26
    L28:
        Throwable r24 = n.c(r23);
        if (r24 == null) goto L48;
        AIKLog.INSTANCE.w("ServiceConnector", r24.toString());
    L26:
        th = move-exception;
        n.a r25 = n.f38560a;
        r23 = n.f(o.a(th));
    L31:
        r13 = null;
        goto L48
    L32:
        AIKLog.INSTANCE.i("ServiceConnector", "start binding to " + ServiceConnector.access$getConnName$p(this.this$0) + ", result = " + ProcessPriorityBindingKt.bindAutoCreate((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ServiceConnector.access$getContext$p(this.this$0), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r15, br.a(bd.c()), (ServiceConnection) ZeusTransformUtils.preCheckCast(ServiceConnector.access$getConnection$p(this.this$0), ServiceConnection.class, "com.obric.aiagent.plugin")));
        ServiceConnector r110 = this.this$0;
        this.L$0 = r110;
        this.label = 1;
        kotlinx.coroutines.o r26 = new kotlinx.coroutines.o(b.a((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin")), 1);
        r26.e();
        kotlinx.coroutines.n r27 = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(r26, kotlinx.coroutines.n.class, "com.obric.aiagent.plugin");
        ServiceConnector.access$setContinuation$p(r110, r27);
        AIKBinder r28 = ServiceConnector.access$getRemote$p(r110);
        if (r28 == null) goto L39;
        IBinder r29 = r28.asBinder();
        if (r29 == null) goto L39;
        if (r29.isBinderAlive() != true) goto L39;
    L40:
        if (r3 == false) goto L42;
        ExtsKt.resume((d) ZeusTransformUtils.preCheckCast(r27, d.class, "com.obric.aiagent.plugin"), ServiceConnector.access$getRemote$p(r110));
    L42:
        r12 = r26.h();
        if (r12 != b.a()) goto L45;
        h.c((d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin"));
    L45:
        if (r12 != r0) goto L47;
        return r0;
    L39:
        r3 = false;
        goto L40
    }
}
