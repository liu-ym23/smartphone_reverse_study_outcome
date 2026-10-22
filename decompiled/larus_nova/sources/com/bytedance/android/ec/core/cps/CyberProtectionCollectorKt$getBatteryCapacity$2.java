package com.bytedance.android.ec.core.cps;

import android.content.Context;
import android.os.BatteryManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", AbsMethodDelegate.TAG_INVOKE, "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.ec.core.cps.CyberProtectionCollectorKt$getBatteryCapacity$2", f = "CyberProtectionCollector.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CyberProtectionCollectorKt$getBatteryCapacity$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    int label;

    public CyberProtectionCollectorKt$getBatteryCapacity$2(Continuation r100) {
        super(2, r100);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Intrinsics.checkNotNullParameter(r101, "completion");
        return new CyberProtectionCollectorKt$getBatteryCapacity$2(r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope r100, Continuation<? super Integer> r101) {
        return ((CyberProtectionCollectorKt$getBatteryCapacity$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r100);
        Context r101 = b.m();
        if (r101 == null) goto L7;
        Object r102 = r101.getSystemService("batterymanager");
    L9:
        if ((r102 instanceof BatteryManager) == true) goto L11;
        r102 = null;
    L11:
        BatteryManager r103 = (BatteryManager) r102;
        if (r103 == null) goto L14;
        float r104 = r103.getIntProperty(4) / 100.0f;
    L16:
        if (r103 == null) goto L18;
        int r105 = r103.getIntProperty(1);
    L20:
        if (r104 <= 0) goto L26;
        if (r105 > 0) goto L23;
        return null;
    L23:
        return Boxing.boxInt((int) (r105 / r104));
    L26:
        return null;
    L18:
        r105 = 0;
        goto L20
    L14:
        r104 = 0.0f;
        goto L16
    L7:
        r102 = null;
        goto L9
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
