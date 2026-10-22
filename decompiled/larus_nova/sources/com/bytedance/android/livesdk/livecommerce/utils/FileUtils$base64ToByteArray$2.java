package com.bytedance.android.livesdk.livecommerce.utils;

import android.util.Base64;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.FileUtils$base64ToByteArray$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileUtils$base64ToByteArray$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    final /* synthetic */ String $base64Str;
    final /* synthetic */ int $flags;
    private /* synthetic */ Object L$0;
    int label;

    public FileUtils$base64ToByteArray$2(String r100, int r101, Continuation r102) {
        this.$base64Str = r100;
        this.$flags = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        FileUtils$base64ToByteArray$2 r102 = new FileUtils$base64ToByteArray$2(this.$base64Str, this.$flags, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super byte[]> r101) {
        return ((FileUtils$base64ToByteArray$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl(Base64.decode(this.$base64Str, this.$flags));     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r103) == null) goto L13;
        dm.a.a("FileUtils").b("base64ToByteArray error", null);
    L13:
        if (Result.m9455isFailureimpl(r103) == true) goto L15;
        return r103;
    L15:
        return null;
    L7:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
