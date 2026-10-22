package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.WideNavigationRailKt$ModalWideNavigationRailContent$4$1", f = "WideNavigationRail.kt", i = {}, l = {1042}, m = "invokeSuspend", n = {}, s = {})
public final class WideNavigationRailKt$ModalWideNavigationRailContent$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Float, Continuation<? super Unit>, Object> $settleToDismiss;
    /* synthetic */ float F$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public WideNavigationRailKt$ModalWideNavigationRailContent$4$1(Function2<? super Float, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super WideNavigationRailKt$ModalWideNavigationRailContent$4$1> r101) {
        this.$settleToDismiss = r100;
        super(3, r101);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Float r101, Continuation<? super Unit> r102) {
        return invoke(r100, r101.floatValue(), r102);
    }

    public final Object invoke(CoroutineScope r100, float r101, Continuation<? super Unit> r102) {
        WideNavigationRailKt$ModalWideNavigationRailContent$4$1 r103 = new WideNavigationRailKt$ModalWideNavigationRailContent$4$1(this.$settleToDismiss, r102);
        r103.F$0 = r101;
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
        float r103 = this.F$0;
        Function2<Float, Continuation<? super Unit>, Object> r104 = this.$settleToDismiss;
        Float r105 = Boxing.boxFloat(r103);
        this.label = 1;
        if (r104.invoke(r105, this) != r101) goto L12;
        return r101;
    }
}
