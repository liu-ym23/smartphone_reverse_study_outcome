package com.bytedance.ai.bridge.method.media.recorder;

import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.media.recorder.RecorderManager$startWithMediaRecorder$6", f = "RecorderManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class RecorderManager$startWithMediaRecorder$6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $tempFile;
    private /* synthetic */ Object L$0;
    int label;

    public RecorderManager$startWithMediaRecorder$6(File r100, Continuation<? super RecorderManager$startWithMediaRecorder$6> r101) {
        this.$tempFile = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        RecorderManager$startWithMediaRecorder$6 r102 = new RecorderManager$startWithMediaRecorder$6(this.$tempFile, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((RecorderManager$startWithMediaRecorder$6) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        File r102 = this.$tempFile;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L7
        Result.m9449constructorimpl(Boxing.boxBoolean(r102.delete()));     // Catch: Throwable -> L7
    L10:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
