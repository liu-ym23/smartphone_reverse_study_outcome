package androidx.compose.ui.platform;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.platform.WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1", f = "WindowRecomposer.android.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
public final class WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ i1<Float> $durationScaleStateFlow;
    final /* synthetic */ MotionDurationScaleImpl $it;
    int label;

    public WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1(i1<Float> r100, MotionDurationScaleImpl r101, Continuation<? super WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1> r102) {
        this.$durationScaleStateFlow = r100;
        this.$it = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1(this.$durationScaleStateFlow, this.$it, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((WindowRecomposer_androidKt$createLifecycleAwareWindowRecomposer$3$onStateChanged$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L6;
        ResultKt.throwOnFailure(r100);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        i1<Float> r103 = this.$durationScaleStateFlow;
        final MotionDurationScaleImpl r104 = this.$it;
        FlowCollector<? super Float> r105 = new AnonymousClass1(r104);
        this.label = 1;
        if (r103.collect(r105, this) != r101) goto L12;
        return r101;
    }
}
