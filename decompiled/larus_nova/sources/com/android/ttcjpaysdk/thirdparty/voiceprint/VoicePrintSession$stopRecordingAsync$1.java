package com.android.ttcjpaysdk.thirdparty.voiceprint;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "com.android.ttcjpaysdk.thirdparty.voiceprint.VoicePrintSession$stopRecordingAsync$1", f = "VoicePrintSession.kt", i = {}, l = {162}, m = "invokeSuspend", n = {}, s = {})
public final class VoicePrintSession$stopRecordingAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<String, Unit> $onFinished;
    Object L$0;
    int label;
    final /* synthetic */ VoicePrintSession this$0;

    /* JADX WARN: Multi-variable type inference failed */
    public VoicePrintSession$stopRecordingAsync$1(Function1<? super String, Unit> r100, VoicePrintSession r101, Continuation<? super VoicePrintSession$stopRecordingAsync$1> r102) {
        this.$onFinished = r100;
        this.this$0 = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new VoicePrintSession$stopRecordingAsync$1(this.$onFinished, this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((VoicePrintSession$stopRecordingAsync$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        Function1 r103 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r103.invoke(r100);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        Function1<String, Unit> r104 = this.$onFinished;
        VoicePrintSession r105 = this.this$0;
        this.L$0 = r104;
        this.label = 1;
        Object r106 = VoicePrintSession.access$stopRecordingInternal(r105, this);
        if (r106 != r101) goto L11;
        return r101;
    L11:
        r103 = r104;
        r100 = r106;
        goto L12
    }
}
