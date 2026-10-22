package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import com.alibaba.gaiax.render.view.GXViewKey;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u001c\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010!\u001a\u00020 *\u00020\u001a2\u0006\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\u0017H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020 ¢\u0006\u0004\b(\u0010)J\u0015\u0010&\u001a\u00020\f2\u0006\u0010*\u001a\u00020+¢\u0006\u0004\b,\u0010)J\u0017\u0010-\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0016¢\u0006\u0004\b/\u00100J\u0017\u00101\u001a\u00020 2\u0006\u0010.\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00100J\u0018\u00103\u001a\u0002042\u0006\u00105\u001a\u00020+H\u0086@¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020 H\u0002¢\u0006\u0004\b:\u0010)J\u0018\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020+H\u0096@¢\u0006\u0004\b=\u00107J\u0006\u0010>\u001a\u00020\fJA\u0010.\u001a\u0002042\b\b\u0002\u0010?\u001a\u00020@2'\u0010A\u001a#\b\u0001\u0012\u0004\u0012\u00020C\u0012\n\u0012\b\u0012\u0004\u0012\u0002040D\u0012\u0006\u0012\u0004\u0018\u00010E0B¢\u0006\u0002\bFH\u0086@¢\u0006\u0002\u0010GJ(\u0010H\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001dR\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic2D;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/Scrollable2DState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "", "<init>", "(Landroidx/compose/foundation/gestures/Scrollable2DState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/Scrollable2DState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/Scrollable2DState;)V", "value", "isFlinging", "()Z", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/Scroll2DScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic2D$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/Scroll2DScope;JI)J", "shouldDispatchOverscroll", "offset", "shouldDispatchOverscroll-k-4lQ0M", "(J)Z", "velocity", "Landroidx/compose/ui/unit/Velocity;", "shouldDispatchOverscroll-TH1AsA0", "performRawScroll", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "performRawScroll-MK-Hz9U", "(J)J", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "onScrollStopped-sF-c-tU", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelFling", "pixels", "shouldCancelFling-k-4lQ0M", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ScrollingLogic2D implements ScrollLogic {
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic2D$nestedScrollScope$1 nestedScrollScope;
    private Scroll2DScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private Scrollable2DState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/Scroll2DScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic2D$scroll$2", f = "Scrollable2D.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_ENABLE_OPEN_TIMEOUT}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Scroll2DScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ScrollingLogic2D this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ScrollingLogic2D r100, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$block = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            AnonymousClass2 r102 = new AnonymousClass2(this.this$0, this.$block, r101);
            r102.L$0 = r100;
            return r102;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Scroll2DScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Scroll2DScope r100, Continuation<? super Unit> r101) {
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
            Scroll2DScope r103 = (Scroll2DScope) this.L$0;
            ScrollingLogic2D.access$setOuterStateScope$p(this.this$0, r103);
            Function2<NestedScrollScope, Continuation<? super Unit>, Object> r104 = this.$block;
            ScrollingLogic2D$nestedScrollScope$1 r105 = ScrollingLogic2D.access$getNestedScrollScope$p(this.this$0);
            this.label = 1;
            if (r104.invoke(r105, this) != r101) goto L12;
            return r101;
        }
    }

    public static /* synthetic */ Offset a(ScrollingLogic2D r100, Offset r101) {
        return performScrollForOverscroll$lambda$1(r100, r101);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress() == true) goto L9;
        OverscrollEffect r100 = this.overscrollEffect;
        if (r100 == null) goto L7;
        boolean r101 = r100.isInProgress();
    L8:
        if (r101 == true) goto L9;
        return false;
    L7:
        r101 = false;
    L9:
        return true;
    }

    public final Scrollable2DState getScrollableState() {
        return this.scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    public static final /* synthetic */ float access$doFlingAnimation_QWom1Mo$toMagnitudeFloat(long r100) {
        return doFlingAnimation_QWom1Mo$toMagnitudeFloat(r100);
    }

    public static final /* synthetic */ FlingBehavior access$getFlingBehavior$p(ScrollingLogic2D r100) {
        return r100.flingBehavior;
    }

    public static final /* synthetic */ int access$getLatestScrollSource$p(ScrollingLogic2D r100) {
        return r100.latestScrollSource;
    }

    public static final /* synthetic */ NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic2D r100) {
        return r100.nestedScrollDispatcher;
    }

    public static final /* synthetic */ ScrollingLogic2D$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic2D r100) {
        return r100.nestedScrollScope;
    }

    public static final /* synthetic */ Scroll2DScope access$getOuterStateScope$p(ScrollingLogic2D r100) {
        return r100.outerStateScope;
    }

    public static final /* synthetic */ OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic2D r100) {
        return r100.overscrollEffect;
    }

    public static final /* synthetic */ Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic2D r100) {
        return r100.performScrollForOverscroll;
    }

    public static final /* synthetic */ Function0 access$isScrollableNodeAttached$p(ScrollingLogic2D r100) {
        return r100.isScrollableNodeAttached;
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m520dispatchRawDeltaMKHz9U(long r100) {
        return this.scrollableState.mo407dispatchRawDeltaMKHz9U(r100);
    }

    private static final float doFlingAnimation_QWom1Mo$toMagnitudeFloat(long r100) {
        double r101 = 2;
        return (float) Math.sqrt(((float) Math.pow(Float.intBitsToFloat((int) (r100 >> 32)), r101)) + ((float) Math.pow(Float.intBitsToFloat((int) (r100 & BodyPartID.bodyIdMax)), r101)));
    }

    /* JADX INFO: renamed from: shouldCancelFling-k-4lQ0M, reason: not valid java name */
    private final boolean m522shouldCancelFlingk4lQ0M(long r100) {
        if (this.scrollableState.mo406canScrollk4lQ0M(r100) == true) goto L5;
    L8:
        return true;
    L5:
        if (this.isScrollableNodeAttached.invoke().booleanValue() == false) goto L8;
        return false;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo486performRawScrollMKHz9U(long r100) {
        if (this.scrollableState.isScrollInProgress() == false) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        return m520dispatchRawDeltaMKHz9U(r100);
    }

    public final void setScrollableState(Scrollable2DState r100) {
        this.scrollableState = r100;
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-TH1AsA0, reason: not valid java name */
    public final boolean m524shouldDispatchOverscrollTH1AsA0(long r100) {
        Scrollable2DState r101 = this.scrollableState;
        float r102 = Velocity.m7786getXimpl(r100);
        float r103 = Velocity.m7787getYimpl(r100);
        long r104 = Float.floatToRawIntBits(r102);
        return r101.mo406canScrollk4lQ0M(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r103)) & BodyPartID.bodyIdMax) | (r104 << 32)));
    }

    /* JADX INFO: renamed from: shouldDispatchOverscroll-k-4lQ0M, reason: not valid java name */
    public final boolean m525shouldDispatchOverscrollk4lQ0M(long r100) {
        return this.scrollableState.mo406canScrollk4lQ0M(r100);
    }

    public static final /* synthetic */ long access$doFlingAnimation_QWom1Mo$toDecomposedOffset(float r100, long r101) {
        return doFlingAnimation_QWom1Mo$toDecomposedOffset(r100, r101);
    }

    public static final /* synthetic */ long access$doFlingAnimation_QWom1Mo$toDecomposedVelocity(float r100, long r101) {
        return doFlingAnimation_QWom1Mo$toDecomposedVelocity(r100, r101);
    }

    public static final /* synthetic */ void access$setLatestScrollSource$p(ScrollingLogic2D r100, int r101) {
        r100.latestScrollSource = r101;
    }

    public static final /* synthetic */ void access$setOuterStateScope$p(ScrollingLogic2D r100, Scroll2DScope r101) {
        r100.outerStateScope = r101;
    }

    /* JADX INFO: renamed from: access$shouldCancelFling-k-4lQ0M, reason: not valid java name */
    public static final /* synthetic */ boolean m519access$shouldCancelFlingk4lQ0M(ScrollingLogic2D r100, long r101) {
        return r100.m522shouldCancelFlingk4lQ0M(r101);
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedOffset(float r100, long r101) {
        if (Float.isNaN(Scrollable2DKt.m487access$getAngleTH1AsA0(r101)) == true) goto L7;
        float r102 = Math.abs(((float) Math.cos(Scrollable2DKt.m487access$getAngleTH1AsA0(r101))) * r100) * Math.signum(Velocity.m7786getXimpl(r101));
        float r103 = Math.abs(((float) Math.sin(Scrollable2DKt.m487access$getAngleTH1AsA0(r101))) * r100) * Math.signum(Velocity.m7787getYimpl(r101));
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r102) << 32) | (Float.floatToRawIntBits(r103) & BodyPartID.bodyIdMax));
    L7:
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (Float.floatToRawIntBits(r100) & BodyPartID.bodyIdMax));
    }

    private static final long doFlingAnimation_QWom1Mo$toDecomposedVelocity(float r100, long r101) {
        if (Float.isNaN(Scrollable2DKt.m487access$getAngleTH1AsA0(r101)) == false) goto L6;
        return VelocityKt.Velocity(0.0f, r100);
    L6:
        return VelocityKt.Velocity(Math.abs(((float) Math.cos(Scrollable2DKt.m487access$getAngleTH1AsA0(r101))) * r100) * Math.signum(Velocity.m7786getXimpl(r101)), Math.abs(((float) Math.sin(Scrollable2DKt.m487access$getAngleTH1AsA0(r101))) * r100) * Math.signum(Velocity.m7787getYimpl(r101)));
    }

    private static final Offset performScrollForOverscroll$lambda$1(ScrollingLogic2D r100, Offset r101) {
        return Offset.m4571boximpl(r100.m521performScroll3eAAhYA(r100.outerStateScope, r101.m4592unboximpl(), r100.latestScrollSource));
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo485doFlingAnimationQWom1Mo(long r110, Continuation<? super Velocity> r111) {
        if ((r111 instanceof ScrollingLogic2D$doFlingAnimation$1) == false) goto L7;
        ScrollingLogic2D$doFlingAnimation$1 r100 = (ScrollingLogic2D$doFlingAnimation$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 != 1) goto L15;
        Ref.LongRef r113 = (Ref.LongRef) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L23
    L21:
        this.isFlinging = false;
        return Velocity.m7777boximpl(r113.element);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r112);
        Ref.LongRef r114 = new Ref.LongRef();
        r114.element = r110;
        this.isFlinging = true;
        MutatePriority r104 = MutatePriority.Default;     // Catch: Throwable -> L23
        Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r115 = new ScrollingLogic2D$doFlingAnimation$2(this, r110, r114, null);     // Catch: Throwable -> L23
        r100.L$0 = r114;     // Catch: Throwable -> L23
        r100.label = 1;     // Catch: Throwable -> L23
        if (scroll(r104, r115, r100) != r102) goto L20;
        return r102;
    L20:
        r113 = r114;
    L23:
        th = move-exception;
        this.isFlinging = false;
        throw th;
    L7:
        r100 = new ScrollingLogic2D$doFlingAnimation$1(this, r111);
        goto L8
    }

    /* JADX INFO: renamed from: onScrollStopped-sF-c-tU, reason: not valid java name */
    public final Object m523onScrollStoppedsFctU(long r100, Continuation<? super Unit> r101) {
        ScrollingLogic2D$onScrollStopped$performFling$1 r102 = new ScrollingLogic2D$onScrollStopped$performFling$1(this, null);
        OverscrollEffect r103 = this.overscrollEffect;
        if (r103 != null) goto L5;
    L11:
        Object r104 = r102.invoke(Velocity.m7777boximpl(r100), r101);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r104;
    L15:
        return Unit.INSTANCE;
    L5:
        if (m524shouldDispatchOverscrollTH1AsA0(r100) == false) goto L11;
        Object r105 = r103.mo210applyToFlingBMRW4eQ(r100, r102, r101);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r105;
    L10:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    private final long m521performScroll3eAAhYA(Scroll2DScope r110, long r111, int r112) {
        long r100 = this.nestedScrollDispatcher.m6002dispatchPreScrollOzD1aCk(r111, r112);
        long r113 = Offset.m4586minusMKHz9U(r111, r100);
        long r101 = r110.mo408scrollByMKHz9U(r113);
        long r102 = Offset.m4586minusMKHz9U(r113, r101);
        long r114 = this.nestedScrollDispatcher.m6000dispatchPostScrollDzOQY0M(r101, r102, r112);
        return Offset.m4587plusMKHz9U(Offset.m4587plusMKHz9U(r100, r101), r114);
    }

    public final Object scroll(MutatePriority r100, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        Object r103 = this.scrollableState.scroll(r100, new AnonymousClass2(this, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$performScroll-3eAAhYA, reason: not valid java name */
    public static final /* synthetic */ long m518access$performScroll3eAAhYA(ScrollingLogic2D r100, Scroll2DScope r101, long r102, int r103) {
        return r100.m521performScroll3eAAhYA(r101, r102, r103);
    }

    public final boolean update(Scrollable2DState r100, OverscrollEffect r101, FlingBehavior r102, NestedScrollDispatcher r103) {
        if (Intrinsics.areEqual(this.scrollableState, r100) == true) goto L5;
        this.scrollableState = r100;
        boolean r104 = true;
    L6:
        this.overscrollEffect = r101;
        this.flingBehavior = r102;
        this.nestedScrollDispatcher = r103;
        return r104;
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic2D$nestedScrollScope$1] */
    public ScrollingLogic2D(Scrollable2DState r100, OverscrollEffect r101, FlingBehavior r102, NestedScrollDispatcher r103, Function0<Boolean> r104) {
        this.scrollableState = r100;
        this.overscrollEffect = r101;
        this.flingBehavior = r102;
        this.nestedScrollDispatcher = r103;
        this.isScrollableNodeAttached = r104;
        this.latestScrollSource = NestedScrollSource.Companion.m6018getUserInputWNlRxjI();
        this.outerStateScope = Scrollable2DKt.access$getNoOpScrollScope$p();
        this.nestedScrollScope = new ScrollingLogic2D$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new l2(this);
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic2D r100, MutatePriority r101, Function2 r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = MutatePriority.Default;
    L6:
        return r100.scroll(r101, r102, r103);
    }
}
