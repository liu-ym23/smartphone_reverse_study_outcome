package com.android.contacts.calllog.v2;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: Merge.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.android.contacts.calllog.v2.CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1", f = "CallLogViewModel.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
public final class CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super List<? extends CallLogItem>>, String, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ CallLogViewModel this$0;

    public CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation r1, CallLogViewModel r2) {
        this.this$0 = r2;
        super(3, r1);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super List<? extends CallLogItem>> r1, String r2, Continuation<? super Unit> r3) {
        return invoke(r1, r2, r3);
    }

    public final Object invoke(FlowCollector<? super List<? extends CallLogItem>> r2, String r3, Continuation<? super Unit> r4) {
        CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1 r0 = new CallLogViewModel$1$invokeSuspend$$inlined$flatMapLatest$1(r4, this.this$0);
        r0.L$0 = r2;
        r0.L$1 = r3;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        FlowCollector r7 = (FlowCollector) this.L$0;
        String r2 = (String) this.L$1;
        Flow<List<CallLogItem>> r3 = CallLogViewModel.access$getRepository$p(this.this$0).observeCallLogs(r2);
        this.label = 1;
        if (FlowKt.emitAll(r7, r3, this) != r0) goto L12;
        return r0;
    }
}
