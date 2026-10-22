package com.bytedance.android.ec.core.cps;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.facebook.common.statfs.StatFsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getAvailableStorageTotal$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getAvailableStorageTotal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Long>, Object> {
    int label;

    public CyberProtectionCollectorKt$getAvailableStorageTotal$2(Continuation r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CyberProtectionCollectorKt$getAvailableStorageTotal$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Long> r101) {
        return ((CyberProtectionCollectorKt$getAvailableStorageTotal$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r100);
        long r101 = StatFsHelper.getInstance().getAvailableStorageSpace(StatFsHelper.StorageType.EXTERNAL);
        long r102 = StatFsHelper.getInstance().getAvailableStorageSpace(StatFsHelper.StorageType.INTERNAL);
        if (r101 <= 0) goto L7;
        long r103 = r101 + 0;
    L9:
        if (r102 <= 0) goto L12;
        r103 = r103 + r102;
    L12:
        if (r103 > 0) goto L18;
        return null;
    L18:
        return Boxing.boxLong(r103);
    L7:
        r103 = 0;
        goto L9
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
