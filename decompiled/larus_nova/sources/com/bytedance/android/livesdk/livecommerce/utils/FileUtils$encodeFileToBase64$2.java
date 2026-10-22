package com.bytedance.android.livesdk.livecommerce.utils;

import android.util.Base64;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.io.ByteArrayOutputStream;
import java.io.File;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.livecommerce.utils.FileUtils$encodeFileToBase64$2", f = "FileUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FileUtils$encodeFileToBase64$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ File $file;
    private /* synthetic */ Object L$0;
    int label;

    public FileUtils$encodeFileToBase64$2(File r100, Continuation r101) {
        this.$file = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        FileUtils$encodeFileToBase64$2 r102 = new FileUtils$encodeFileToBase64$2(this.$file, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return ((FileUtils$encodeFileToBase64$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r100);
        CoroutineScope r101 = (CoroutineScope) this.L$0;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L26
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(this.$file);     // Catch: Throwable -> L26
        ByteArrayOutputStream r104 = new ByteArrayOutputStream();     // Catch: Throwable -> L21
        byte[] r105 = new byte[1024];     // Catch: Throwable -> L16
    L9:
        int r106 = r103.read(r105);     // Catch: Throwable -> L16
        if (r106 == (-1)) goto L12;
        r104.write(r105, 0, r106);     // Catch: Throwable -> L16
        goto L9
    L12:
        String r107 = Base64.encodeToString(r104.toByteArray(), 0);     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r103, null);     // Catch: Throwable -> L26
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L26
    L29:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L32;
        dm.a.a("FileUtils").b("encodeFileToBase64 error", null);
    L32:
        if (Result.m9455isFailureimpl(r108) == false) goto L35;
        return null;
    L35:
        return r108;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L21
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
