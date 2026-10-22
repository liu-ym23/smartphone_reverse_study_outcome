package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$drag$2$1", f = "Scrollable.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableNode$drag$2$1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    final /* synthetic */ ScrollingLogic $this_with;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public ScrollableNode$drag$2$1(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r100, ScrollingLogic r101, Continuation<? super ScrollableNode$drag$2$1> r102) {
        this.$forEachDelta = r100;
        this.$this_with = r101;
        super(2, r102);
    }

    public static /* synthetic */ Unit a(NestedScrollScope r100, ScrollingLogic r101, DragEvent.DragDelta r102) {
        return invokeSuspend$lambda$0(r100, r101, r102);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScrollableNode$drag$2$1 r102 = new ScrollableNode$drag$2$1(this.$forEachDelta, this.$this_with, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return ((ScrollableNode$drag$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
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
        final NestedScrollScope r103 = (NestedScrollScope) this.L$0;
        Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> r104 = this.$forEachDelta;
        final ScrollingLogic r105 = this.$this_with;
        Function1<? super DragEvent.DragDelta, Unit> r106 = new i2(r103, r105);
        this.label = 1;
        if (r104.invoke(r106, this) != r101) goto L12;
        return r101;
    }

    private static final Unit invokeSuspend$lambda$0(NestedScrollScope r100, ScrollingLogic r101, DragEvent.DragDelta r102) {
        r100.mo456scrollByWithOverscrollOzD1aCk(r101.m513singleAxisOffsetMKHz9U(r102.m410getDeltaF1C5BW0()), NestedScrollSource.Companion.m6018getUserInputWNlRxjI());
        return Unit.INSTANCE;
    }
}
