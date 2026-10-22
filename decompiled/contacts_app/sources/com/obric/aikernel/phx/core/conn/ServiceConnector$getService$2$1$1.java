package com.obric.aikernel.phx.core.conn;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.obric.aikernel.AIKBinder;
import com.obric.aikernel.core.DataHolder;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.AIKLog;
import com.obric.aikernel.sdk.ExtsKt;
import com.obric.aikernel.sdk.data.ExtraAppInfo;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ServiceConnector.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/obric/aikernel/AIKBinder;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.ServiceConnector$getService$2$1$1", f = "ServiceConnector.kt", i = {}, l = {185}, m = "invokeSuspend", n = {}, s = {})
final class ServiceConnector$getService$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AIKBinder>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ServiceConnector this$0;

    ServiceConnector$getService$2$1$1(ServiceConnector r1, Continuation<? super ServiceConnector$getService$2$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        ServiceConnector$getService$2$1$1 r0 = new ServiceConnector$getService$2$1$1(this.this$0, r3);
        r0.L$0 = r2;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super AIKBinder> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super AIKBinder> r2) {
        return ((ServiceConnector$getService$2$1$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ServiceConnector r2 = (ServiceConnector) this.L$0;
        ResultKt.throwOnFailure(r9);
    L43:
        AIKBinder r10 = (AIKBinder) r9;
    L44:
        ServiceConnector r8 = this.this$0;
        monitor-enter(r8);
        ServiceConnector.access$setConnectTask$p(r8, null);     // Catch: Throwable -> L49
        ServiceConnector.access$setContinuation$p(r8, null);     // Catch: Throwable -> L49
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L49
        monitor-exit(r8);
        return r10;
    L49:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        Intent r12 = new Intent();
        r12.setComponent(ServiceConnector.access$getConnName$p(this.this$0));
        r12.addFlags(1);
        ExtraAppInfo r5 = ServiceConnector.access$getAiKernelConfig$p(this.this$0).getExtraBindInfo();
        if (r5 == null) goto L12;
        r12.putExtra(IdlKeys.Args_BindExtraInfo, r5);
    L12:
        if (DataHolder.INSTANCE.getUseAuthProvider() == false) goto L28;
        ContentResolver r6 = ServiceConnector.access$getContext$p(this.this$0).getContentResolver();
        Bundle r7 = new Bundle();
        r7.putParcelable(MemorySourceLinkType.INTENT, r12);
        Unit r13 = Unit.INSTANCE;
        Bundle r14 = r6.call("com.obric.aikernel.service.auth", "onBind", null, r7);
        if (r14 == null) goto L27;
        IBinder r15 = r14.getBinder("binder");
        if (r15 == null) goto L27;
        r10 = AIKBinder.Stub.asInterface(r15);
        if (r10 == null) goto L27;
        ServiceConnector r16 = this.this$0;
        ServiceConnector.access$setRemote$p(r16, r10);
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L22
        Context r18 = ServiceConnector.access$getContext$p(r16);     // Catch: Throwable -> L22
        Intent r19 = new Intent();     // Catch: Throwable -> L22
        r19.setComponent(new ComponentName(ServiceConnector.access$getConnName$p(r16).getPackageName(), "com.obric.aikernel.LifeCycleService"));     // Catch: Throwable -> L22
        Object r20 = Result.m803constructorimpl(Boxing.boxBoolean(r18.bindService(r19, ServiceConnector.access$getLifeCycleConnection$p(r16), 1)));     // Catch: Throwable -> L22
    L24:
        Throwable r21 = Result.m806exceptionOrNullimpl(r20);
        if (r21 == null) goto L44;
        AIKLog.INSTANCE.w("ServiceConnector", r21.toString());
    L22:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r20 = Result.m803constructorimpl(ResultKt.createFailure(th));
    L27:
        r10 = null;
        goto L44
    L28:
        AIKLog.INSTANCE.i("ServiceConnector", "start binding to " + ServiceConnector.access$getConnName$p(this.this$0).getClassName() + ", result = " + ServiceConnector.access$getContext$p(this.this$0).bindService(r12, ServiceConnector.access$getConnection$p(this.this$0), 1));
        ServiceConnector r23 = this.this$0;
        this.L$0 = r23;
        this.label = 1;
        ServiceConnector$getService$2$1$1 r24 = this;
        CancellableContinuationImpl r25 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(r24), 1);
        r25.initCancellability();
        CancellableContinuationImpl r26 = r25;
        ServiceConnector.access$setContinuation$p(r23, r26);
        AIKBinder r27 = ServiceConnector.access$getRemote$p(r23);
        if (r27 == null) goto L35;
        IBinder r28 = r27.asBinder();
        if (r28 == null) goto L35;
        if (r28.isBinderAlive() != true) goto L35;
    L36:
        if (r3 == false) goto L38;
        ExtsKt.resume(r26, ServiceConnector.access$getRemote$p(r23));
    L38:
        r9 = r25.getResult();
        if (r9 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L41;
        DebugProbesKt.probeCoroutineSuspended(r24);
    L41:
        if (r9 != r0) goto L43;
        return r0;
    L35:
        r3 = false;
        goto L36
    }
}
