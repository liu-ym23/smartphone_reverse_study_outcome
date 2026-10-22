package com.bytedance.android.shopping.mall.homepage.tools;

import androidx.exifinterface.media.ExifInterface;
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
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.shopping.mall.homepage.tools.ECRequestManager$executeRequest$job$1", f = "ECRequestManager.kt", i = {}, l = {30}, m = "invokeSuspend", n = {}, s = {})
final class ECRequestManager$executeRequest$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CompletableDeferred $newDeferred;
    final /* synthetic */ Function1 $request;
    int label;

    public ECRequestManager$executeRequest$job$1(Function1 r100, CompletableDeferred r101, Continuation r102) {
        this.$request = r100;
        this.$newDeferred = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new ECRequestManager$executeRequest$job$1(this.$request, this.$newDeferred, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((ECRequestManager$executeRequest$job$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L11;
        if (r102 != 1) goto L10;
        ResultKt.throwOnFailure(r100);     // Catch: Exception -> L7
    L15:
        this.$newDeferred.complete(r100);     // Catch: Exception -> L7
    L19:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r100);
        Function1 r103 = this.$request;     // Catch: Exception -> L7
        this.label = 1;     // Catch: Exception -> L7
        r100 = r103.invoke(this);     // Catch: Exception -> L7
        if (r100 != r101) goto L15;
        return r101;
    L7:
        e = move-exception;
        this.$newDeferred.completeExceptionally(e);
        goto L19
    }
}
