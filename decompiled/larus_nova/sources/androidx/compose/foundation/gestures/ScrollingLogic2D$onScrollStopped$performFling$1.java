package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import com.ss.ttm.player.MediaPlayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$onScrollStopped$performFling$1", f = "Scrollable2D.kt", i = {0, 1, 1, 2, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL, MediaPlayer.MEDIA_PLAYER_OPTION_RENDER_STALL_300, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500}, m = "invokeSuspend", n = {"velocity", "velocity", "available", "velocity", "velocityLeft"}, s = {"J$0", "J$0", "J$1", "J$0", "J$1"})
public final class ScrollingLogic2D$onScrollStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic2D this$0;

    public ScrollingLogic2D$onScrollStopped$performFling$1(ScrollingLogic2D r100, Continuation<? super ScrollingLogic2D$onScrollStopped$performFling$1> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        ScrollingLogic2D$onScrollStopped$performFling$1 r102 = new ScrollingLogic2D$onScrollStopped$performFling$1(this.this$0, r101);
        r102.J$0 = ((Velocity) r100).m7795unboximpl();
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity r100, Continuation<? super Velocity> r101) {
        return m526invokesFctU(r100.m7795unboximpl(), r101);
    }

    /* JADX INFO: renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m526invokesFctU(long r100, Continuation<? super Velocity> r101) {
        return ((ScrollingLogic2D$onScrollStopped$performFling$1) create(Velocity.m7777boximpl(r100), r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L12;
        if (r101 == 1) goto L11;
        if (r101 == 2) goto L10;
        if (r101 != 3) goto L9;
        long r102 = this.J$1;
        long r103 = this.J$0;
        ResultKt.throwOnFailure(r110);
        long r104 = r102;
        Object r105 = r110;
    L25:
        return Velocity.m7777boximpl(Velocity.m7789minusAH228Gc(r103, Velocity.m7789minusAH228Gc(r104, ((Velocity) r105).m7795unboximpl())));
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        long r106 = this.J$1;
        long r107 = this.J$0;
        ResultKt.throwOnFailure(r110);
        Object r108 = r110;
        long r109 = r107;
    L20:
        r104 = ((Velocity) r108).m7795unboximpl();
        NestedScrollDispatcher r111 = ScrollingLogic2D.access$getNestedScrollDispatcher$p(this.this$0);
        long r112 = Velocity.m7789minusAH228Gc(r106, r104);
        this.J$0 = r109;
        this.J$1 = r104;
        this.label = 3;
        r105 = r111.m5999dispatchPostFlingRZ2iAVY(r112, r104, this);
        if (r105 != r100) goto L23;
        return r100;
    L23:
        r103 = r109;
        goto L25
    L11:
        long r113 = this.J$0;
        ResultKt.throwOnFailure(r110);
        Object r114 = r110;
    L16:
        long r115 = Velocity.m7789minusAH228Gc(r113, ((Velocity) r114).m7795unboximpl());
        ScrollingLogic2D r116 = this.this$0;
        this.J$0 = r113;
        this.J$1 = r115;
        this.label = 2;
        r108 = r116.mo485doFlingAnimationQWom1Mo(r115, this);
        if (r108 != r100) goto L19;
        return r100;
    L19:
        r106 = r115;
        r109 = r113;
        goto L20
    L12:
        ResultKt.throwOnFailure(r110);
        long r117 = this.J$0;
        NestedScrollDispatcher r118 = ScrollingLogic2D.access$getNestedScrollDispatcher$p(this.this$0);
        this.J$0 = r117;
        this.label = 1;
        r114 = r118.m6001dispatchPreFlingQWom1Mo(r117, this);
        if (r114 != r100) goto L15;
        return r100;
    L15:
        r113 = r117;
        goto L16
    }
}
