package com.bytedance.android.ec.core.cps;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getLibCSoHash$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getLibCSoHash$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    int label;

    public CyberProtectionCollectorKt$getLibCSoHash$2(Continuation r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CyberProtectionCollectorKt$getLibCSoHash$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super String> r101) {
        return ((CyberProtectionCollectorKt$getLibCSoHash$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L23;
        ResultKt.throwOnFailure(r110);
        MessageDigest r100 = MessageDigest.getInstance("SHA-256");     // Catch: Exception -> L19
        PolarisFileInputStreamWrapper r101 = new PolarisFileInputStreamWrapper("/system/lib/libc.so");     // Catch: Exception -> L19
        byte[] r102 = new byte[8192];     // Catch: Throwable -> L14
    L8:
        int r103 = r101.read(r102);     // Catch: Throwable -> L14
        if (r103 == (-1)) goto L11;
        r100.update(r102, 0, r103);     // Catch: Throwable -> L14
        goto L8
    L11:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r101, null);     // Catch: Exception -> L19
        return ArraysKt.joinToString$default(r100.digest(), "", null, null, 0, null, AnonymousClass2.INSTANCE, 30, null);
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Exception -> L19
        throw th;     // Catch: Exception -> L19
    L19:
        e = move-exception;
        e.printStackTrace();
        return null;
    L23:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
