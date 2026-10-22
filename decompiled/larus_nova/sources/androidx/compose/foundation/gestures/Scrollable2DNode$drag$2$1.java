package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import com.ss.ttm.player.MediaPlayer;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.Scrollable2DNode$drag$2$1", f = "Scrollable2D.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY}, m = "invokeSuspend", n = {}, s = {})
public final class Scrollable2DNode$drag$2$1 extends SuspendLambda implements Function2<NestedScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Function1<? super DragEvent.DragDelta, Unit>, Continuation<? super Unit>, Object> $forEachDelta;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public Scrollable2DNode$drag$2$1(Function2<? super Function1<? super DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> r100, Continuation<? super Scrollable2DNode$drag$2$1> r101) {
        this.$forEachDelta = r100;
        super(2, r101);
    }

    public static /* synthetic */ Unit a(NestedScrollScope r100, DragEvent.DragDelta r101) {
        return invokeSuspend$lambda$0(r100, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        Scrollable2DNode$drag$2$1 r102 = new Scrollable2DNode$drag$2$1(this.$forEachDelta, r101);
        r102.L$0 = r100;
        return r102;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(NestedScrollScope r100, Continuation<? super Unit> r101) {
        return ((Scrollable2DNode$drag$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        Function1<? super DragEvent.DragDelta, Unit> r105 = new b2(r103);
        this.label = 1;
        if (r104.invoke(r105, this) != r101) goto L12;
        return r101;
    }

    private static final Unit invokeSuspend$lambda$0(NestedScrollScope r100, DragEvent.DragDelta r101) {
        r100.mo456scrollByWithOverscrollOzD1aCk(r101.m410getDeltaF1C5BW0(), NestedScrollSource.Companion.m6018getUserInputWNlRxjI());
        return Unit.INSTANCE;
    }
}
