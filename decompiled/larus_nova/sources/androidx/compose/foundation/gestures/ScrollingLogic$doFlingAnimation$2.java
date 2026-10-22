package androidx.compose.foundation.gestures;

import com.ss.ttm.player.MediaPlayer;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_RTM_SIGNAL_TRANSPORT_CONNECTED_TIME}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollingLogic$doFlingAnimation$2 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ Ref.LongRef $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    public ScrollingLogic$doFlingAnimation$2(ScrollingLogic r100, Ref.LongRef r101, long r102, Continuation<? super ScrollingLogic$doFlingAnimation$2> r103) {
        this.this$0 = r100;
        this.$result = r101;
        this.$available = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScrollingLogic$doFlingAnimation$2 r102 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return ((ScrollingLogic$doFlingAnimation$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        long r102 = this.J$0;
        Ref.LongRef r103 = (Ref.LongRef) this.L$2;
        ScrollingLogic r104 = (ScrollingLogic) this.L$1;
        ScrollingLogic r105 = (ScrollingLogic) this.L$0;
        ResultKt.throwOnFailure(r110);
    L12:
        r103.element = ScrollingLogic.m505access$updateQWom1Mo(r104, r102, r105.reverseIfNeeded(((Number) r110).floatValue()));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        final NestedScrollScope r111 = (NestedScrollScope) this.L$0;
        final ScrollingLogic r106 = this.this$0;
        ScrollScope r107 = new ScrollingLogic$doFlingAnimation$2$reverseScope$1(r106, r111);
        r104 = this.this$0;
        Ref.LongRef r112 = this.$result;
        long r108 = this.$available;
        FlingBehavior r109 = ScrollingLogic.access$getFlingBehavior$p(r104);
        long r113 = r112.element;
        float r114 = r104.reverseIfNeeded(ScrollingLogic.m504access$toFloatTH1AsA0(r104, r108));
        this.L$0 = r104;
        this.L$1 = r104;
        this.L$2 = r112;
        this.J$0 = r113;
        this.label = 1;
        Object r115 = r109.performFling(r107, r114, this);
        if (r115 != r100) goto L11;
        return r100;
    L11:
        r103 = r112;
        r110 = r115;
        r105 = r104;
        r102 = r113;
        goto L12
    }
}
