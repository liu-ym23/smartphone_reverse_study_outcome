package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1", f = "WideNavigationRail.kt", i = {}, l = {538, 539}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 extends SuspendLambda implements Function2<Float, Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    final /* synthetic */ ModalWideNavigationRailOverrideScope $this_ModalWideNavigationRail;
    /* synthetic */ float F$0;
    int label;

    public DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(ModalWideNavigationRailOverrideScope r100, ModalWideNavigationRailState r101, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1> r102) {
        this.$this_ModalWideNavigationRail = r100;
        this.$modalState = r101;
        super(2, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1 r102 = new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1(this.$this_ModalWideNavigationRail, this.$modalState, r101);
        r102.F$0 = ((Number) r100).floatValue();
        return r102;
    }

    public final Object invoke(float r100, Continuation<? super Unit> r101) {
        return ((DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$settleToDismiss$1$1) create(Float.valueOf(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Float r100, Continuation<? super Unit> r101) {
        return invoke(r100.floatValue(), r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L21:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L16:
        if (WideNavigationRailStateKt.isExpanded(this.$modalState.getTargetValue()) == true) goto L21;
        WideNavigationRailState r103 = this.$this_ModalWideNavigationRail.getState();
        this.label = 2;
        if (r103.collapse(this) != r101) goto L21;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        float r104 = this.F$0;
        if (this.$this_ModalWideNavigationRail.getShouldHideOnCollapse() == false) goto L21;
        ModalWideNavigationRailState r105 = this.$modalState;
        this.label = 1;
        if (r105.settle$material3(r104, this) != r101) goto L16;
        return r101;
    }
}
