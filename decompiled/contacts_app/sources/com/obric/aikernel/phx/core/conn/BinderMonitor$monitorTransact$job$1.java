package com.obric.aikernel.phx.core.conn;

import com.obric.aikernel.core.log.AIKLog;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* JADX INFO: compiled from: BinderMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.phx.core.conn.BinderMonitor$monitorTransact$job$1", f = "BinderMonitor.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
final class BinderMonitor$monitorTransact$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoroutineContext $ctx;
    final /* synthetic */ Ref.ObjectRef<BinderMonitor.BinderInfo> $info;
    final /* synthetic */ Function0<Unit> $onDied;
    private /* synthetic */ Object L$0;
    int label;

    BinderMonitor$monitorTransact$job$1(Ref.ObjectRef<BinderMonitor.BinderInfo> r1, CoroutineContext r2, Function0<Unit> r3, Continuation<? super BinderMonitor$monitorTransact$job$1> r4) {
        this.$info = r1;
        this.$ctx = r2;
        this.$onDied = r3;
        super(2, r4);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        BinderMonitor$monitorTransact$job$1 r0 = new BinderMonitor$monitorTransact$job$1(this.$info, this.$ctx, this.$onDied, r5);
        r0.L$0 = r4;
        return r0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return invoke2(r1, r2);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
        return ((BinderMonitor$monitorTransact$job$1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r8);
    L16:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        final CoroutineScope r9 = (CoroutineScope) this.L$0;
        BinderMonitor.BinderInfo r2 = this.$info.element;
        if (r2 == null) goto L18;
        MutableStateFlow<Boolean> r3 = r2.getStateFlow();
        if (r3 == null) goto L18;
        AIKLog.INSTANCE.d("BinderMonitor", "monitorTransact: register onDied stateFlow: " + this.$ctx);
        final CoroutineContext r4 = this.$ctx;
        final Function0<Unit> r5 = this.$onDied;
        this.label = 1;
        if (r3.collect(new AnonymousClass2(r9, r4, r5), this) != r0) goto L16;
        return r0;
    L18:
        return Unit.INSTANCE;
    }
}
