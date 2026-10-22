package com.bytedance.android.anniex.detect;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/bytedance/android/anniex/detect/g;", "", "e", "", "<anonymous>"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.anniex.detect.AnnieXBlankDetector$asFlow$2", f = "AnnieXBlankDetector.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class AnnieXBlankDetector$asFlow$2 extends SuspendLambda implements Function3<FlowCollector<? super g>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $detectionStatus;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public AnnieXBlankDetector$asFlow$2(g r100, Continuation<? super AnnieXBlankDetector$asFlow$2> r101) {
        this.$detectionStatus = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super g> r100, Throwable r101, Continuation<? super Unit> r102) {
        return invoke2(r100, r101, r102);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(FlowCollector<? super g> r100, Throwable r101, Continuation<? super Unit> r102) {
        AnnieXBlankDetector$asFlow$2 r103 = new AnnieXBlankDetector$asFlow$2(this.$detectionStatus, r102);
        r103.L$0 = r100;
        r103.L$1 = r101;
        return r103.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        FlowCollector r103 = (FlowCollector) this.L$0;
        Throwable r104 = (Throwable) this.L$1;
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.i("AnnieXBlankDetect", "检测异常: " + r104.getMessage(), null, 12);
        g r106 = this.$detectionStatus;
        r106.f40680a = false;
        StringBuilder r107 = r106.f40692m;
        r107.append("Detection EXCEPTION: " + r104.getMessage());
        r107.append('\n');
        this.L$0 = null;
        this.label = 1;
        if (r103.emit(r106, this) != r101) goto L12;
        return r101;
    }
}
