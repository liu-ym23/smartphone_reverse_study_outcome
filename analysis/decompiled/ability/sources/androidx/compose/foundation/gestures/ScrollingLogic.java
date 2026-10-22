package androidx.compose.foundation.gestures;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001M\b\u0000\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0014\u001a\u00020\u0011*\u00020\u0010ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0014\u0010\u0017\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u001a\u001a\u00020\u0010*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001b\u001a\u00020\u0010*\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001b\u001a\u00020\u0011*\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u0016J\u0018\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u0011ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010\u0016J\u001b\u0010&\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b$\u0010%J\u001b\u0010)\u001a\u00020!2\u0006\u0010'\u001a\u00020!H\u0086@ø\u0001\u0001¢\u0006\u0004\b(\u0010%J\r\u0010*\u001a\u00020\n¢\u0006\u0004\b*\u0010+J>\u0010\u001e\u001a\u00020#2\b\b\u0002\u0010-\u001a\u00020,2\"\u00101\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020/\u0012\n\u0012\b\u0012\u0004\u0012\u00020#00\u0012\u0006\u0012\u0004\u0018\u00010\u00010.H\u0086@¢\u0006\u0004\b\u001e\u00102J?\u00103\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b3\u00104J\r\u00105\u001a\u00020\n¢\u0006\u0004\b5\u0010+J\u0016\u0010\u001a\u001a\u00020\u0010*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b6\u0010\u0019J\u0016\u00108\u001a\u00020!*\u00020!H\u0002ø\u0001\u0001¢\u0006\u0004\b7\u0010\u0016J\u001e\u00103\u001a\u00020!*\u00020!2\u0006\u00109\u001a\u00020\u0010H\u0002ø\u0001\u0001¢\u0006\u0004\b:\u0010;J&\u0010B\u001a\u00020\u0011*\u00020<2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010?\u001a\u00020>H\u0002ø\u0001\u0001¢\u0006\u0004\b@\u0010AR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010CR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010DR\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010ER\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010FR\u0016\u0010\u000b\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010GR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010HR\u001c\u0010I\u001a\u00020>8\u0002@\u0002X\u0082\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010K\u001a\u00020<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010N\u001a\u00020M8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR \u0010Q\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010T\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bS\u0010+\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006U"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "Landroidx/compose/foundation/gestures/ScrollableState;", "scrollableState", "Landroidx/compose/foundation/OverscrollEffect;", "overscrollEffect", "Landroidx/compose/foundation/gestures/FlingBehavior;", "flingBehavior", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "", "reverseDirection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "nestedScrollDispatcher", AppAgent.CONSTRUCT, "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/OverscrollEffect;Landroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "", "Landroidx/compose/ui/geometry/Offset;", "toOffset-tuRUvjQ", "(F)J", "toOffset", "singleAxisOffset-MK-Hz9U", "(J)J", "singleAxisOffset", "toFloat-k-4lQ0M", "(J)F", "toFloat", "reverseIfNeeded", "(F)F", "reverseIfNeeded-MK-Hz9U", "scroll", "performRawScroll-MK-Hz9U", "performRawScroll", "Landroidx/compose/ui/unit/Velocity;", "initialVelocity", "LC7/r;", "onDragStopped-sF-c-tU", "(JLH7/c;)Ljava/lang/Object;", "onDragStopped", "available", "doFlingAnimation-QWom1Mo", "doFlingAnimation", "shouldScrollImmediately", "()Z", "Landroidx/compose/foundation/MutatePriority;", "scrollPriority", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/NestedScrollScope;", "LH7/c;", "block", "(Landroidx/compose/foundation/MutatePriority;LS7/n;LH7/c;)Ljava/lang/Object;", "update", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)Z", "isVertical", "toFloat-TH1AsA0", "singleAxisVelocity-AH228Gc", "singleAxisVelocity", "newValue", "update-QWom1Mo", "(JF)J", "Landroidx/compose/foundation/gestures/ScrollScope;", "delta", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", AgentBusWakeContract.EXTRA_SOURCE, "performScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "performScroll", "Landroidx/compose/foundation/gestures/ScrollableState;", "Landroidx/compose/foundation/OverscrollEffect;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/foundation/gestures/Orientation;", "Z", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "latestScrollSource", "I", "outerStateScope", "Landroidx/compose/foundation/gestures/ScrollScope;", "androidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1", "nestedScrollScope", "Landroidx/compose/foundation/gestures/ScrollingLogic$nestedScrollScope$1;", "Lkotlin/Function1;", "performScrollForOverscroll", "LS7/k;", "getShouldDispatchOverscroll", "shouldDispatchOverscroll", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollingLogic {
    public static final int $stable = 8;
    private FlingBehavior flingBehavior;
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;
    private int latestScrollSource = NestedScrollSource.INSTANCE.m5312getUserInputWNlRxjI();
    private ScrollScope outerStateScope = ScrollableKt.NoOpScrollScope;
    private final ScrollingLogic$nestedScrollScope$1 nestedScrollScope = new NestedScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1
        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollBy-OzD1aCk */
        public long mo472scrollByOzD1aCk(long offset, int source) {
            return this.this$0.m508performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
        }

        @Override // androidx.compose.foundation.gestures.NestedScrollScope
        /* renamed from: scrollByWithOverscroll-OzD1aCk */
        public long mo473scrollByWithOverscrollOzD1aCk(long offset, int source) {
            this.this$0.latestScrollSource = source;
            OverscrollEffect overscrollEffect = this.this$0.overscrollEffect;
            if (overscrollEffect != null && this.this$0.getShouldDispatchOverscroll()) {
                return overscrollEffect.mo221applyToScrollRhakbz0(offset, this.this$0.latestScrollSource, this.this$0.performScrollForOverscroll);
            }
            return this.this$0.m508performScroll3eAAhYA(this.this$0.outerStateScope, offset, source);
        }
    };
    private final k performScrollForOverscroll = new k() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$performScrollForOverscroll$1
        {
            super(1);
        }

        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m3884boximpl(m520invokeMKHz9U(((Offset) obj).m3905unboximpl()));
        }

        /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
        public final long m520invokeMKHz9U(long j5) {
            ScrollScope scrollScope = this.this$0.outerStateScope;
            ScrollingLogic scrollingLogic = this.this$0;
            return scrollingLogic.m508performScroll3eAAhYA(scrollScope, j5, scrollingLogic.latestScrollSource);
        }
    };

    @c(c = "androidx.compose.foundation.gestures.ScrollingLogic$scroll$2", f = "Scrollable.kt", l = {804}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/ScrollScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.gestures.ScrollingLogic$scroll$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ n $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$block = nVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = ScrollingLogic.this.new AnonymousClass2(this.$block, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(ScrollScope scrollScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(scrollScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                ScrollingLogic.this.outerStateScope = (ScrollScope) this.L$0;
                n nVar = this.$block;
                ScrollingLogic$nestedScrollScope$1 scrollingLogic$nestedScrollScope$1 = ScrollingLogic.this.nestedScrollScope;
                this.label = 1;
                if (nVar.invoke(scrollingLogic$nestedScrollScope$1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                b.b(obj);
            }
            return r.f317a;
        }
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [androidx.compose.foundation.gestures.ScrollingLogic$nestedScrollScope$1] */
    public ScrollingLogic(ScrollableState scrollableState, OverscrollEffect overscrollEffect, FlingBehavior flingBehavior, Orientation orientation, boolean z10, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.overscrollEffect = overscrollEffect;
        this.flingBehavior = flingBehavior;
        this.orientation = orientation;
        this.reverseDirection = z10;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: performScroll-3eAAhYA, reason: not valid java name */
    public final long m508performScroll3eAAhYA(ScrollScope scrollScope, long j5, int i) {
        long jM5296dispatchPreScrollOzD1aCk = this.nestedScrollDispatcher.m5296dispatchPreScrollOzD1aCk(j5, i);
        long jM3899minusMKHz9U = Offset.m3899minusMKHz9U(j5, jM5296dispatchPreScrollOzD1aCk);
        long jM515reverseIfNeededMKHz9U = m515reverseIfNeededMKHz9U(m518toOffsettuRUvjQ(scrollScope.scrollBy(m517toFloatk4lQ0M(m515reverseIfNeededMKHz9U(m516singleAxisOffsetMKHz9U(jM3899minusMKHz9U))))));
        return Offset.m3900plusMKHz9U(Offset.m3900plusMKHz9U(jM5296dispatchPreScrollOzD1aCk, jM515reverseIfNeededMKHz9U), this.nestedScrollDispatcher.m5294dispatchPostScrollDzOQY0M(jM515reverseIfNeededMKHz9U, Offset.m3899minusMKHz9U(jM3899minusMKHz9U, jM515reverseIfNeededMKHz9U), i));
    }

    public static /* synthetic */ Object scroll$default(ScrollingLogic scrollingLogic, MutatePriority mutatePriority, n nVar, H7.c cVar, int i, Object obj) {
        if ((i & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return scrollingLogic.scroll(mutatePriority, nVar, cVar);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    private final long m509singleAxisVelocityAH228Gc(long j5) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7078copyOhffZ5M$default(j5, 0.0f, 0.0f, 1, null) : Velocity.m7078copyOhffZ5M$default(j5, 0.0f, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m510toFloatTH1AsA0(long j5) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7082getXimpl(j5) : Velocity.m7083getYimpl(j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m511updateQWom1Mo(long j5, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m7078copyOhffZ5M$default(j5, f, 0.0f, 2, null) : Velocity.m7078copyOhffZ5M$default(j5, 0.0f, f, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m512doFlingAnimationQWom1Mo(long r11, H7.c<? super androidx.compose.ui.unit.Velocity> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r13
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.internal.Ref$LongRef r10 = (kotlin.jvm.internal.Ref$LongRef) r10
            kotlin.b.b(r13)
            goto L53
        L2b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L33:
            kotlin.b.b(r13)
            kotlin.jvm.internal.Ref$LongRef r6 = new kotlin.jvm.internal.Ref$LongRef
            r6.<init>()
            r6.f4919a = r11
            androidx.compose.foundation.MutatePriority r13 = androidx.compose.foundation.MutatePriority.Default
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r4 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r9 = 0
            r5 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r9)
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r10 = r5.scroll(r13, r4, r0)
            if (r10 != r1) goto L52
            return r1
        L52:
            r10 = r6
        L53:
            long r10 = r10.f4919a
            androidx.compose.ui.unit.Velocity r10 = androidx.compose.ui.unit.Velocity.m7073boximpl(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m512doFlingAnimationQWom1Mo(long, H7.c):java.lang.Object");
    }

    public final boolean isVertical() {
        return this.orientation == Orientation.Vertical;
    }

    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    public final Object m513onDragStoppedsFctU(long j5, H7.c<? super r> cVar) {
        long jM509singleAxisVelocityAH228Gc = m509singleAxisVelocityAH228Gc(j5);
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        r rVar = r.f317a;
        if (overscrollEffect == null || !getShouldDispatchOverscroll()) {
            Object objInvoke = scrollingLogic$onDragStopped$performFling$1.invoke(Velocity.m7073boximpl(jM509singleAxisVelocityAH228Gc), cVar);
            return objInvoke == CoroutineSingletons.f4909a ? objInvoke : rVar;
        }
        Object objMo220applyToFlingBMRW4eQ = overscrollEffect.mo220applyToFlingBMRW4eQ(jM509singleAxisVelocityAH228Gc, scrollingLogic$onDragStopped$performFling$1, cVar);
        return objMo220applyToFlingBMRW4eQ == CoroutineSingletons.f4909a ? objMo220applyToFlingBMRW4eQ : rVar;
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m514performRawScrollMKHz9U(long scroll) {
        return this.scrollableState.isScrollInProgress() ? Offset.INSTANCE.m3911getZeroF1C5BW0() : m518toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m517toFloatk4lQ0M(scroll)))));
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m515reverseIfNeededMKHz9U(long j5) {
        return this.reverseDirection ? Offset.m3902timestuRUvjQ(j5, -1.0f) : j5;
    }

    public final Object scroll(MutatePriority mutatePriority, n nVar, H7.c<? super r> cVar) {
        Object objScroll = this.scrollableState.scroll(mutatePriority, new AnonymousClass2(nVar, null), cVar);
        return objScroll == CoroutineSingletons.f4909a ? objScroll : r.f317a;
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m516singleAxisOffsetMKHz9U(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m3889copydBAh8RU$default(j5, 0.0f, 0.0f, 1, null) : Offset.m3889copydBAh8RU$default(j5, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m517toFloatk4lQ0M(long j5) {
        return this.orientation == Orientation.Horizontal ? Offset.m3895getXimpl(j5) : Offset.m3896getYimpl(j5);
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m518toOffsettuRUvjQ(float f) {
        return f == 0.0f ? Offset.INSTANCE.m3911getZeroF1C5BW0() : this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    public final boolean update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        boolean z10;
        boolean z11 = true;
        if (kotlin.jvm.internal.k.b(this.scrollableState, scrollableState)) {
            z10 = false;
        } else {
            this.scrollableState = scrollableState;
            z10 = true;
        }
        this.overscrollEffect = overscrollEffect;
        if (this.orientation != orientation) {
            this.orientation = orientation;
            z10 = true;
        }
        if (this.reverseDirection != reverseDirection) {
            this.reverseDirection = reverseDirection;
        } else {
            z11 = z10;
        }
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        return z11;
    }
}
