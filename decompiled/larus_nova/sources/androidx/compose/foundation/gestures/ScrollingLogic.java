package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
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
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u00018\b\u0001\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u001b\u001a\u00020\u001c*\u00020\u001d¢\u0006\u0004\b\u001e\u0010\u001fJ\u0011\u0010 \u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b$\u0010%J\u0011\u0010&\u001a\u00020'*\u00020\u001d¢\u0006\u0004\b(\u0010\u001fJ\u0013\u0010#\u001a\u00020\u001d*\u00020'H\u0002¢\u0006\u0004\b)\u0010%J\u0013\u0010*\u001a\u00020'*\u00020'H\u0002¢\u0006\u0004\b+\u0010\"J\u001b\u0010,\u001a\u00020'*\u00020'2\u0006\u0010-\u001a\u00020\u001dH\u0002¢\u0006\u0004\b.\u0010/J\n\u00100\u001a\u00020\u001d*\u00020\u001dJ\u0011\u00100\u001a\u00020\u001c*\u00020\u001c¢\u0006\u0004\b1\u0010\"J#\u0010<\u001a\u00020\u001c*\u0002062\u0006\u0010=\u001a\u00020\u001c2\u0006\u0010>\u001a\u000203H\u0002¢\u0006\u0004\b?\u0010@J\u0017\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001cH\u0016¢\u0006\u0004\bE\u0010\"J\u0017\u0010F\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020\u001cH\u0002¢\u0006\u0004\bG\u0010\"J \u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020'2\u0006\u0010K\u001a\u00020\u000bH\u0086@¢\u0006\u0004\bL\u0010MJ\u0010\u0010N\u001a\u00020\u000b2\u0006\u0010O\u001a\u00020\u001dH\u0002J\u0018\u0010P\u001a\u00020'2\u0006\u0010Q\u001a\u00020'H\u0096@¢\u0006\u0004\bR\u0010SJ\u0006\u0010T\u001a\u00020\u000bJA\u0010D\u001a\u00020I2\b\b\u0002\u0010U\u001a\u00020V2'\u0010W\u001a#\b\u0001\u0012\u0004\u0012\u00020Y\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0Z\u0012\u0006\u0012\u0004\u0018\u00010[0X¢\u0006\u0002\b\\H\u0086@¢\u0006\u0002\u0010]J8\u0010,\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010^\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0010\u00102\u001a\u000203X\u0082\u000e¢\u0006\u0004\n\u0002\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0004\n\u0002\u00109R\u001a\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0;X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bB\u0010\u001a¨\u0006_"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "Landroidx/compose/foundation/gestures/ScrollLogic;", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseDirection", "", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "onScrollChangedDispatcher", "Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;", "isScrollableNodeAttached", "Lkotlin/Function0;", "<init>", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/foundation/gestures/OnScrollChangedDispatcher;Lkotlin/jvm/functions/Function0;)V", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "value", "isFlinging", "()Z", "toOffset", "Landroidx/compose/ui/geometry/Offset;", "", "toOffset-tuRUvjQ", "(F)J", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toVelocity", "Landroidx/compose/ui/unit/Velocity;", "toVelocity-adjELrA", "toFloat-TH1AsA0", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "update", "newValue", "update-QWom1Mo", "(JF)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "latestScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "nestedScrollScope", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "performScrollForOverscroll", "Lkotlin/Function1;", "performScroll", "delta", "source", "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "performRawScroll", GXViewKey.VIEW_TYPE_CONTAINER_SCROLL, "performRawScroll-MK-Hz9U", "dispatchRawDelta", "dispatchRawDelta-MK-Hz9U", "onScrollStopped", "", "initialVelocity", "isMouseWheel", "onScrollStopped-BMRW4eQ", "(JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldCancelFling", "pixels", "doFlingAnimation", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldScrollImmediately", "scrollPriority", "Landroidx/compose/foundation/MutatePriority;", "block", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/MutatePriority;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isVertical", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScrollingLogic implements ScrollLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private boolean isFlinging;
    private final Function0<Boolean> isScrollableNodeAttached;
    private int latestScrollSource;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope;
    private OnScrollChangedDispatcher onScrollChangedDispatcher;
    private Orientation orientation;
    private ScrollScope outerStateScope;
    private OverscrollEffect overscrollEffect;
    private final Function1<Offset, Offset> performScrollForOverscroll;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$scroll$2", f = "Scrollable.kt", i = {}, l = {TTVideoEngineInterface.PLAYER_OPTION_HW_ENABLE_DYNAMIC_FRAME_DROPPING}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<NestedScrollScope, Continuation<? super Unit>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ScrollingLogic this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(ScrollingLogic r100, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super AnonymousClass2> r102) {
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
        public final Object invoke2(ScrollScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(ScrollScope r100, Continuation<? super Unit> r101) {
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
            ScrollScope r103 = (ScrollScope) this.L$0;
            ScrollingLogic.access$setOuterStateScope$p(this.this$0, r103);
            Function2<NestedScrollScope, Continuation<? super Unit>, Object> r104 = this.$block;
            ScrollingLogic$nestedScrollScope$1 r105 = ScrollingLogic.access$getNestedScrollScope$p(this.this$0);
            this.label = 1;
            if (r104.invoke(r105, this) != r101) goto L12;
            return r101;
        }
    }

    public static /* synthetic */ Offset a(ScrollingLogic r100, Offset r101) {
        return performScrollForOverscroll$lambda$1(r100, r101);
    }

    private final boolean getShouldDispatchOverscroll() {
        if (this.scrollableState.getCanScrollForward() == false) goto L5;
    L8:
        return true;
    L5:
        if (this.scrollableState.getCanScrollBackward() == true) goto L8;
        return false;
    }

    public final boolean isVertical() {
        if (this.orientation != Orientation.Vertical) goto L5;
        return true;
    L5:
        return false;
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

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    public boolean isFlinging() {
        return this.isFlinging;
    }

    public static final /* synthetic */ FlingBehavior access$getFlingBehavior$p(ScrollingLogic r100) {
        return r100.flingBehavior;
    }

    public static final /* synthetic */ int access$getLatestScrollSource$p(ScrollingLogic r100) {
        return r100.latestScrollSource;
    }

    public static final /* synthetic */ NestedScrollDispatcher access$getNestedScrollDispatcher$p(ScrollingLogic r100) {
        return r100.nestedScrollDispatcher;
    }

    public static final /* synthetic */ ScrollingLogic$nestedScrollScope$1 access$getNestedScrollScope$p(ScrollingLogic r100) {
        return r100.nestedScrollScope;
    }

    public static final /* synthetic */ ScrollScope access$getOuterStateScope$p(ScrollingLogic r100) {
        return r100.outerStateScope;
    }

    public static final /* synthetic */ OverscrollEffect access$getOverscrollEffect$p(ScrollingLogic r100) {
        return r100.overscrollEffect;
    }

    public static final /* synthetic */ Function1 access$getPerformScrollForOverscroll$p(ScrollingLogic r100) {
        return r100.performScrollForOverscroll;
    }

    public static final /* synthetic */ boolean access$getShouldDispatchOverscroll(ScrollingLogic r100) {
        return r100.getShouldDispatchOverscroll();
    }

    public static final /* synthetic */ Function0 access$isScrollableNodeAttached$p(ScrollingLogic r100) {
        return r100.isScrollableNodeAttached;
    }

    /* JADX INFO: renamed from: dispatchRawDelta-MK-Hz9U, reason: not valid java name */
    private final long m506dispatchRawDeltaMKHz9U(long r100) {
        return m515toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m514toFloatk4lQ0M(r100)))));
    }

    private final boolean shouldCancelFling(float r100) {
        if (r100 <= 0.0f) goto L7;
        if (this.scrollableState.getCanScrollForward() == true) goto L7;
    L12:
        return true;
    L7:
        if (r100 >= 0.0f) goto L11;
        if (this.scrollableState.getCanScrollBackward() == false) goto L12;
    L11:
        if (this.isScrollableNodeAttached.invoke().booleanValue() == false) goto L12;
        return false;
    }

    /* JADX INFO: renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m508singleAxisVelocityAH228Gc(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.m7782copyOhffZ5M$default(r100, 0.0f, 0.0f, 1, null);
    L6:
        return Velocity.m7782copyOhffZ5M$default(r100, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    private final float m509toFloatTH1AsA0(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.m7786getXimpl(r100);
    L6:
        return Velocity.m7787getYimpl(r100);
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U */
    public long mo486performRawScrollMKHz9U(long r100) {
        if (this.scrollableState.isScrollInProgress() == false) goto L6;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L6:
        return m506dispatchRawDeltaMKHz9U(r100);
    }

    public final float reverseIfNeeded(float r100) {
        if (this.reverseDirection == true) goto L5;
        return r100;
    L5:
        return r100 * (-1);
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m512reverseIfNeededMKHz9U(long r100) {
        if (this.reverseDirection == true) goto L5;
        return r100;
    L5:
        return Offset.m4589timestuRUvjQ(r100, -1.0f);
    }

    public final void setScrollableState(ScrollableState r100) {
        this.scrollableState = r100;
    }

    /* JADX INFO: renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m513singleAxisOffsetMKHz9U(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Offset.m4576copydBAh8RU$default(r100, 0.0f, 0.0f, 1, null);
    L6:
        return Offset.m4576copydBAh8RU$default(r100, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m514toFloatk4lQ0M(long r100) {
        if (this.orientation != Orientation.Horizontal) goto L5;
        long r101 = r100 >> 32;
    L7:
        return Float.intBitsToFloat((int) r101);
    L5:
        r101 = r100 & BodyPartID.bodyIdMax;
        goto L7
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m515toOffsettuRUvjQ(float r100) {
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return Offset.Companion.m4598getZeroF1C5BW0();
    L9:
        if (this.orientation != Orientation.Horizontal) goto L12;
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r100) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & BodyPartID.bodyIdMax));
    L12:
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(0.0f) << 32) | (((long) Float.floatToRawIntBits(r100)) & BodyPartID.bodyIdMax));
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m516toVelocityadjELrA(float r100) {
        if (r100 != 0.0f) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return Velocity.Companion.m7797getZero9UxMQ8M();
    L9:
        if (this.orientation != Orientation.Horizontal) goto L12;
        return VelocityKt.Velocity(r100, 0.0f);
    L12:
        return VelocityKt.Velocity(0.0f, r100);
    L5:
        r101 = false;
        goto L6
    }

    public static final /* synthetic */ void access$setLatestScrollSource$p(ScrollingLogic r100, int r101) {
        r100.latestScrollSource = r101;
    }

    public static final /* synthetic */ void access$setOuterStateScope$p(ScrollingLogic r100, ScrollScope r101) {
        r100.outerStateScope = r101;
    }

    public static final /* synthetic */ boolean access$shouldCancelFling(ScrollingLogic r100, float r101) {
        return r100.shouldCancelFling(r101);
    }

    /* JADX INFO: renamed from: access$toFloat-TH1AsA0, reason: not valid java name */
    public static final /* synthetic */ float m504access$toFloatTH1AsA0(ScrollingLogic r100, long r101) {
        return r100.m509toFloatTH1AsA0(r101);
    }

    private static final Offset performScrollForOverscroll$lambda$1(ScrollingLogic r100, Offset r101) {
        return Offset.m4571boximpl(r100.m507performScroll3eAAhYA(r100.outerStateScope, r101.m4592unboximpl(), r100.latestScrollSource));
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    private final long m510updateQWom1Mo(long r100, float r110) {
        if (this.orientation != Orientation.Horizontal) goto L6;
        return Velocity.m7782copyOhffZ5M$default(r100, r110, 0.0f, 2, null);
    L6:
        return Velocity.m7782copyOhffZ5M$default(r100, 0.0f, r110, 1, null);
    }

    @Override // androidx.compose.foundation.gestures.ScrollLogic
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo */
    public Object mo485doFlingAnimationQWom1Mo(long r110, Continuation<? super Velocity> r111) {
        if ((r111 instanceof ScrollingLogic$doFlingAnimation$1) == false) goto L7;
        ScrollingLogic$doFlingAnimation$1 r100 = (ScrollingLogic$doFlingAnimation$1) r111;
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
        Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r115 = new ScrollingLogic$doFlingAnimation$2(this, r114, r110, null);     // Catch: Throwable -> L23
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
        r100 = new ScrollingLogic$doFlingAnimation$1(this, r111);
        goto L8
    }

    /* JADX INFO: renamed from: access$update-QWom1Mo, reason: not valid java name */
    public static final /* synthetic */ long m505access$updateQWom1Mo(ScrollingLogic r100, long r101, float r102) {
        return r100.m510updateQWom1Mo(r101, r102);
    }

    /* JADX INFO: renamed from: performScroll-3eAAhYA, reason: not valid java name */
    private final long m507performScroll3eAAhYA(ScrollScope r110, long r111, int r112) {
        long r100 = this.nestedScrollDispatcher.m6002dispatchPreScrollOzD1aCk(r111, r112);
        long r113 = Offset.m4586minusMKHz9U(r111, r100);
        long r101 = m512reverseIfNeededMKHz9U(m515toOffsettuRUvjQ(r110.scrollBy(m514toFloatk4lQ0M(m512reverseIfNeededMKHz9U(m513singleAxisOffsetMKHz9U(r113))))));
        if (ComposeFoundationFlags.isOnScrollChangedCallbackEnabled == false) goto L5;
        this.onScrollChangedDispatcher.mo457dispatchScrollDeltaInfok4lQ0M(r101);
    L5:
        long r102 = Offset.m4586minusMKHz9U(r113, r101);
        long r114 = this.nestedScrollDispatcher.m6000dispatchPostScrollDzOQY0M(r101, r102, r112);
        return Offset.m4587plusMKHz9U(Offset.m4587plusMKHz9U(r100, r101), r114);
    }

    /* JADX INFO: renamed from: onScrollStopped-BMRW4eQ, reason: not valid java name */
    public final Object m511onScrollStoppedBMRW4eQ(long r100, boolean r101, Continuation<? super Unit> r102) {
        if (r101 == true) goto L4;
    L7:
        long r103 = m508singleAxisVelocityAH228Gc(r100);
        ScrollingLogic$onScrollStopped$performFling$1 r104 = new ScrollingLogic$onScrollStopped$performFling$1(this, null);
        OverscrollEffect r105 = this.overscrollEffect;
        if (r105 != null) goto L10;
    L16:
        Object r106 = r104.invoke(Velocity.m7777boximpl(r103), r102);
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        return r106;
    L20:
        return Unit.INSTANCE;
    L10:
        if (getShouldDispatchOverscroll() == false) goto L16;
        Object r107 = r105.mo210applyToFlingBMRW4eQ(r103, r104, r102);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L15;
        return r107;
    L15:
        return Unit.INSTANCE;
    L4:
        if (ScrollableKt.access$getShouldBeTriggeredByMouseWheel(this.flingBehavior) == true) goto L7;
        return Unit.INSTANCE;
    }

    public final Object scroll(MutatePriority r100, Function2<? super NestedScrollScope, ? super Continuation<? super Unit>, ? extends Object> r101, Continuation<? super Unit> r102) {
        Object r103 = this.scrollableState.scroll(r100, new AnonymousClass2(this, r101, null), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: access$performScroll-3eAAhYA, reason: not valid java name */
    public static final /* synthetic */ long m503access$performScroll3eAAhYA(ScrollingLogic r100, ScrollScope r101, long r102, int r103) {
        return r100.m507performScroll3eAAhYA(r101, r102, r103);
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic r100, MutatePriority r101, Function2 r102, Continuation r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = MutatePriority.Default;
    L6:
        return r100.scroll(r101, r102, r103);
    }

    public final boolean update(ScrollableState r100, Orientation r101, OverscrollEffect r102, boolean r103, FlingBehavior r104, NestedScrollDispatcher r105) {
        boolean r106 = true;
        if (Intrinsics.areEqual(this.scrollableState, r100) == true) goto L5;
        this.scrollableState = r100;
        boolean r107 = true;
    L6:
        this.overscrollEffect = r102;
        if (this.orientation == r101) goto L10;
        this.orientation = r101;
        r107 = true;
    L10:
        if (this.reverseDirection == r103) goto L12;
        this.reverseDirection = r103;
    L13:
        this.flingBehavior = r104;
        this.nestedScrollDispatcher = r105;
        return r106;
    L12:
        r106 = r107;
        goto L13
    L5:
        r107 = false;
        goto L6
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState r100, OverscrollEffect r101, FlingBehavior r102, Orientation r103, boolean r104, NestedScrollDispatcher r105, OnScrollChangedDispatcher r106, Function0<Boolean> r107) {
        this.scrollableState = r100;
        this.overscrollEffect = r101;
        this.flingBehavior = r102;
        this.orientation = r103;
        this.reverseDirection = r104;
        this.nestedScrollDispatcher = r105;
        this.onScrollChangedDispatcher = r106;
        this.isScrollableNodeAttached = r107;
        this.latestScrollSource = NestedScrollSource.Companion.m6018getUserInputWNlRxjI();
        this.outerStateScope = ScrollableKt.access$getNoOpScrollScope$p();
        this.nestedScrollScope = new ScrollingLogic$nestedScrollScope$1(this);
        this.performScrollForOverscroll = new k2(this);
    }
}
