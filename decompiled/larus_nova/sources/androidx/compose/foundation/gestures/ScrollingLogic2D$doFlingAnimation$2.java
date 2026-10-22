package androidx.compose.foundation.gestures;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/NestedScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$doFlingAnimation$2", f = "Scrollable2D.kt", i = {}, l = {473}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollingLogic2D$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    public ScrollingLogic2D$doFlingAnimation$2(ScrollingLogic2D r100, long r101, Ref.LongRef r102, Continuation<? super ScrollingLogic2D$doFlingAnimation$2> r103) {
        this.this$0 = r100;
        this.$available = r101;
        this.$result = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScrollingLogic2D$doFlingAnimation$2 r102 = new ScrollingLogic2D$doFlingAnimation$2(this.this$0, this.$available, this.$result, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return ((ScrollingLogic2D$doFlingAnimation$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        long r103 = this.J$0;
        Ref.LongRef r104 = (Ref.LongRef) this.L$0;
        ResultKt.throwOnFailure(r100);
    L12:
        r104.element = ScrollingLogic2D.access$doFlingAnimation_QWom1Mo$toDecomposedVelocity(((Number) r100).floatValue(), r103);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        final NestedScrollScope r105 = (NestedScrollScope) this.L$0;
        final ScrollingLogic2D r106 = this.this$0;
        final long r107 = this.$available;
        ScrollScope r108 = new ScrollingLogic2D$doFlingAnimation$2$flingScope$1(r106, r105, r107);
        ScrollingLogic2D r109 = this.this$0;
        long r110 = this.$available;
        Ref.LongRef r111 = this.$result;
        FlingBehavior r112 = ScrollingLogic2D.access$getFlingBehavior$p(r109);
        float r113 = Scrollable2DKt.m488access$getMagnitudeTH1AsA0(r110);
        this.L$0 = r111;
        this.J$0 = r110;
        this.label = 1;
        r100 = r112.performFling(r108, r113, this);
        if (r100 != r101) goto L11;
        return r101;
    L11:
        r103 = r110;
        r104 = r111;
        goto L12
    }
}
