package com.bytedance.android.ec.window.base.common.taskgraph;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "IN", "OUT", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/bytedance/android/ec/window/base/common/taskgraph/ProcessorNode$execute$2$block$1"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.window.base.common.taskgraph.ProcessorNode$execute$2$block$1", f = "ProcessorNode.kt", i = {}, l = {53}, m = "invokeSuspend", n = {}, s = {})
public final class ProcessorNode$execute$$inlined$forEach$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PipelineNode $nextNode;
    final /* synthetic */ ao.a $nodeContextMgr$inlined;
    final /* synthetic */ ProcessorNode $parentNode$inlined;
    final /* synthetic */ Object $t$inlined;
    int label;
    final /* synthetic */ ProcessorNode this$0;

    public ProcessorNode$execute$$inlined$forEach$lambda$1(PipelineNode r100, Continuation r101, ProcessorNode r102, ao.a r103, ProcessorNode r104, Object r105) {
        this.$nextNode = r100;
        this.this$0 = r102;
        this.$nodeContextMgr$inlined = r103;
        this.$parentNode$inlined = r104;
        this.$t$inlined = r105;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new ProcessorNode$execute$$inlined$forEach$lambda$1(this.$nextNode, r101, this.this$0, this.$nodeContextMgr$inlined, this.$parentNode$inlined, this.$t$inlined);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ProcessorNode$execute$$inlined$forEach$lambda$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L11:
        PipelineNode<?, ?> r103 = this.$nextNode;
        if ((r103 instanceof eo.a) == false) goto L15;
        this.$nodeContextMgr$inlined.a(this.$parentNode$inlined, r103);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        this.$nodeContextMgr$inlined.b(this.$parentNode$inlined, this.$nextNode);
        PipelineNode r104 = this.$nextNode;
        ProcessorNode r105 = this.$parentNode$inlined;
        Object r106 = this.$t$inlined;
        ao.a r107 = this.$nodeContextMgr$inlined;
        this.label = 1;
        if (r104.a(r105, r106, r107, this) != r101) goto L11;
        return r101;
    }
}
