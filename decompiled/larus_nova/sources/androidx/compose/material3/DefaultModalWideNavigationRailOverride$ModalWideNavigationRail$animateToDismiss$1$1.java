package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1", f = "WideNavigationRail.kt", i = {}, l = {531, 533}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ ModalWideNavigationRailState $modalState;
    final /* synthetic */ ModalWideNavigationRailOverrideScope $this_ModalWideNavigationRail;
    int label;

    public DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(ModalWideNavigationRailOverrideScope r100, ModalWideNavigationRailState r101, Continuation<? super DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1> r102) {
        this.$this_ModalWideNavigationRail = r100;
        this.$modalState = r101;
        super(1, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r100) {
        return new DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1(this.$this_ModalWideNavigationRail, this.$modalState, r100);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
        return invoke2(r100);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r100) {
        return ((DefaultModalWideNavigationRailOverride$ModalWideNavigationRail$animateToDismiss$1$1) create(r100)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L10;
        if (r102 == 1) goto L9;
        if (r102 != 2) goto L8;
        ResultKt.throwOnFailure(r100);
    L19:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r100);
    L15:
        WideNavigationRailState r103 = this.$this_ModalWideNavigationRail.getState();
        this.label = 2;
        if (r103.collapse(this) != r101) goto L19;
        return r101;
    L10:
        ResultKt.throwOnFailure(r100);
        if (this.$this_ModalWideNavigationRail.getShouldHideOnCollapse() == false) goto L15;
        ModalWideNavigationRailState r104 = this.$modalState;
        this.label = 1;
        if (r104.collapse(this) != r101) goto L15;
        return r101;
    }
}
