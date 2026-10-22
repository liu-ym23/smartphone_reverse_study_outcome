package com.bytedance.android.ec.core.arch.event;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.o;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/bytedance/android/ec/core/arch/event/d;", "I", "Lkotlinx/coroutines/CoroutineScope;", "", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.arch.event.EventFunc$collect$1", f = "EventFunc.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
final class EventFunc$collect$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1 $block;
    final /* synthetic */ com.bytedance.android.ec.core.arch.event.a $shareFlowWrapper;
    int label;

    public static final class a implements FlowCollector<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EventFunc$collect$1 f43827a;

        public a(EventFunc$collect$1 r100) {
            this.f43827a = r100;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final Object emit(Object r100, Continuation r101) {
            Function1 r102 = this.f43827a.$block;
            if (r100 == null) goto L7;
            r102.invoke((d) r100);
            return Unit.INSTANCE;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type I");
        }
    }

    public EventFunc$collect$1(com.bytedance.android.ec.core.arch.event.a r100, Function1 r101, Continuation r102) {
        this.$shareFlowWrapper = r100;
        this.$block = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new EventFunc$collect$1(this.$shareFlowWrapper, this.$block, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((EventFunc$collect$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Object r103 = this.$shareFlowWrapper.f43830c;
        if (r103 == null) goto L11;
        this.$shareFlowWrapper.f43830c = null;
        this.$block.invoke((d) r103);
    L11:
        o r104 = this.$shareFlowWrapper.f43828a;
        a r105 = new a(this);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L15;
        return r101;
    }
}
