package com.bytedance.ai.resource;

import android.os.ParcelFileDescriptor;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1", f = "AppletResourceTool.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $bytes;
    final /* synthetic */ ParcelFileDescriptor $capturedWriteEnd;
    private /* synthetic */ Object L$0;
    int label;

    public AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1(ParcelFileDescriptor r100, byte[] r101, Continuation<? super AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1> r102) {
        this.$capturedWriteEnd = r100;
        this.$bytes = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1 r102 = new AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1(this.$capturedWriteEnd, this.$bytes, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AppletResourceTool$getDebugResourceFileDescriptor$2$1$result$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        ParcelFileDescriptor r102 = this.$capturedWriteEnd;
        byte[] r103 = this.$bytes;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L15
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r102.getFileDescriptor());     // Catch: Throwable -> L15
        r105.write(r103);     // Catch: Throwable -> L10
        r105.flush();     // Catch: Throwable -> L10
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L15
        Object r107 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L34;
        com.bytedance.ai.utils.g.f37637a.e("AppletResourceLoader", "getDebugResourceFileDescriptor: pipe write failed: " + r108.getMessage());
    L34:
        this.$capturedWriteEnd.close();     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
