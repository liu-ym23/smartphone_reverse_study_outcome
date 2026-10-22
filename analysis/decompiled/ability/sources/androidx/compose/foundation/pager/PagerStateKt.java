package androidx.compose.foundation.pager;

import C7.r;
import J7.c;
import S7.n;
import androidx.annotation.FloatRange;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import g1.AbstractC1451a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.a;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import m9.AbstractC1683A;

@Metadata(d1 = {"\u0000g\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004*\u00012\u001a1\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0003\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0003\u0010\n\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a\u0014\u0010\u000e\u001a\u00020\r*\u00020\u0006H\u0080@¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0014\u0010\u0010\u001a\u00020\r*\u00020\u0006H\u0080@¢\u0006\u0004\b\u0010\u0010\u000f\u001a\u001e\u0010\u0013\u001a\u00020\r2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0017\u001a\u00020\u0016*\u00020\u00152\u0006\u0010\u0005\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001b\u0010\u001a\u001a\u00020\u0016*\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aL\u0010$\u001a\u00020\r*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u00022\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u001f2\u0018\u0010#\u001a\u0014\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r0!H\u0082@¢\u0006\u0004\b$\u0010%\"\u001a\u0010'\u001a\u00020&8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0014\u0010+\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b+\u0010,\"\u0014\u0010-\u001a\u00020\u00008\u0000X\u0080T¢\u0006\u0006\n\u0004\b-\u0010,\"\u001a\u0010.\u001a\u00020\u00198\u0000X\u0080\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0014\u00103\u001a\u0002028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104¨\u00065"}, d2 = {"", "initialPage", "", "initialPageOffsetFraction", "Lkotlin/Function0;", "pageCount", "Landroidx/compose/foundation/pager/PagerState;", "rememberPagerState", "(IFLS7/a;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/pager/PagerState;", "currentPage", "currentPageOffsetFraction", "PagerState", "(IFLS7/a;)Landroidx/compose/foundation/pager/PagerState;", "LC7/r;", "animateToNextPage", "(Landroidx/compose/foundation/pager/PagerState;LH7/c;)Ljava/lang/Object;", "animateToPreviousPage", "", "generateMsg", "debugLog", "(LS7/a;)V", "Landroidx/compose/foundation/pager/PagerLayoutInfo;", "", "calculateNewMaxScrollOffset", "(Landroidx/compose/foundation/pager/PagerLayoutInfo;I)J", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "calculateNewMinScrollOffset", "(Landroidx/compose/foundation/pager/PagerMeasureResult;I)J", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;", "targetPage", "targetPageOffsetToSnappedPosition", "Landroidx/compose/animation/core/AnimationSpec;", "animationSpec", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/ScrollScope;", "updateTargetPage", "animateScrollToPage", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimateScrollScope;IFLandroidx/compose/animation/core/AnimationSpec;LS7/n;LH7/c;)Ljava/lang/Object;", "Landroidx/compose/ui/unit/Dp;", "DefaultPositionThreshold", "F", "getDefaultPositionThreshold", "()F", "MaxPagesForAnimateScroll", "I", "PagesToPrefetch", "EmptyLayoutInfo", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "getEmptyLayoutInfo", "()Landroidx/compose/foundation/pager/PagerMeasureResult;", "androidx/compose/foundation/pager/PagerStateKt$UnitDensity$1", "UnitDensity", "Landroidx/compose/foundation/pager/PagerStateKt$UnitDensity$1;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerStateKt {
    private static final int MaxPagesForAnimateScroll = 3;
    public static final int PagesToPrefetch = 1;
    private static final float DefaultPositionThreshold = Dp.m6844constructorimpl(56);
    private static final PagerMeasureResult EmptyLayoutInfo = new PagerMeasureResult(EmptyList.f4893a, 0, 0, 0, Orientation.Horizontal, 0, 0, false, 0, null, null, 0.0f, 0, false, SnapPosition.Start.INSTANCE, new MeasureResult() { // from class: androidx.compose.foundation.pager.PagerStateKt$EmptyLayoutInfo$1
        private final Map<AlignmentLine, Integer> alignmentLines = a.M();
        private final int height;
        private final int width;

        public static /* synthetic */ void getAlignmentLines$annotations() {
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public Map<AlignmentLine, Integer> getAlignmentLines() {
            return this.alignmentLines;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getHeight() {
            return this.height;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public int getWidth() {
            return this.width;
        }

        @Override // androidx.compose.ui.layout.MeasureResult
        public void placeChildren() {
        }
    }, false, null, null, AbstractC1683A.b(EmptyCoroutineContext.f4908a), 393216, null);
    private static final PagerStateKt$UnitDensity$1 UnitDensity = new Density() { // from class: androidx.compose.foundation.pager.PagerStateKt$UnitDensity$1
        private final float density = 1.0f;
        private final float fontScale = 1.0f;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }
    };

    @c(c = "androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2", f = "PagerState.kt", l = {953}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/foundation/gestures/ScrollScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ AnimationSpec<Float> $animationSpec;
        final /* synthetic */ int $targetPage;
        final /* synthetic */ float $targetPageOffsetToSnappedPosition;
        final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToPage;
        final /* synthetic */ n $updateTargetPage;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n nVar, int i, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, float f, AnimationSpec<Float> animationSpec, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$updateTargetPage = nVar;
            this.$targetPage = i;
            this.$this_animateScrollToPage = lazyLayoutAnimateScrollScope;
            this.$targetPageOffsetToSnappedPosition = f;
            this.$animationSpec = animationSpec;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$updateTargetPage, this.$targetPage, this.$this_animateScrollToPage, this.$targetPageOffsetToSnappedPosition, this.$animationSpec, cVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // S7.n
        public final Object invoke(ScrollScope scrollScope, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(scrollScope, cVar)).invokeSuspend(r.f317a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x007a, code lost:
        
            r1 = r3;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r12.label
                r2 = 1
                if (r1 == 0) goto L16
                if (r1 != r2) goto Le
                kotlin.b.b(r13)
                goto Lb3
            Le:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L16:
                kotlin.b.b(r13)
                java.lang.Object r13 = r12.L$0
                androidx.compose.foundation.gestures.ScrollScope r13 = (androidx.compose.foundation.gestures.ScrollScope) r13
                S7.n r1 = r12.$updateTargetPage
                int r3 = r12.$targetPage
                java.lang.Integer r4 = new java.lang.Integer
                r4.<init>(r3)
                r1.invoke(r13, r4)
                int r1 = r12.$targetPage
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r3 = r12.$this_animateScrollToPage
                int r3 = r3.getFirstVisibleItemIndex()
                r4 = 0
                if (r1 <= r3) goto L36
                r1 = r2
                goto L37
            L36:
                r1 = r4
            L37:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r3 = r12.$this_animateScrollToPage
                int r3 = r3.getLastVisibleItemIndex()
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r5 = r12.$this_animateScrollToPage
                int r5 = r5.getFirstVisibleItemIndex()
                int r3 = r3 - r5
                int r3 = r3 + r2
                if (r1 == 0) goto L51
                int r5 = r12.$targetPage
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r6 = r12.$this_animateScrollToPage
                int r6 = r6.getLastVisibleItemIndex()
                if (r5 > r6) goto L5d
            L51:
                if (r1 != 0) goto L8d
                int r5 = r12.$targetPage
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r6 = r12.$this_animateScrollToPage
                int r6 = r6.getFirstVisibleItemIndex()
                if (r5 >= r6) goto L8d
            L5d:
                int r5 = r12.$targetPage
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r6 = r12.$this_animateScrollToPage
                int r6 = r6.getFirstVisibleItemIndex()
                int r5 = r5 - r6
                int r5 = java.lang.Math.abs(r5)
                r6 = 3
                if (r5 < r6) goto L8d
                if (r1 == 0) goto L7c
                int r1 = r12.$targetPage
                int r1 = r1 - r3
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r3 = r12.$this_animateScrollToPage
                int r3 = r3.getFirstVisibleItemIndex()
                if (r1 >= r3) goto L88
            L7a:
                r1 = r3
                goto L88
            L7c:
                int r1 = r12.$targetPage
                int r1 = r1 + r3
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r3 = r12.$this_animateScrollToPage
                int r3 = r3.getFirstVisibleItemIndex()
                if (r1 <= r3) goto L88
                goto L7a
            L88:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r3 = r12.$this_animateScrollToPage
                r3.snapToItem(r13, r1, r4)
            L8d:
                androidx.compose.foundation.lazy.layout.LazyLayoutAnimateScrollScope r1 = r12.$this_animateScrollToPage
                int r3 = r12.$targetPage
                float r1 = r1.calculateDistanceTo(r3)
                float r3 = r12.$targetPageOffsetToSnappedPosition
                float r5 = r1 + r3
                kotlin.jvm.internal.Ref$FloatRef r1 = new kotlin.jvm.internal.Ref$FloatRef
                r1.<init>()
                androidx.compose.animation.core.AnimationSpec<java.lang.Float> r7 = r12.$animationSpec
                androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2$3 r8 = new androidx.compose.foundation.pager.PagerStateKt$animateScrollToPage$2$3
                r8.<init>()
                r12.label = r2
                r4 = 0
                r6 = 0
                r10 = 4
                r11 = 0
                r9 = r12
                java.lang.Object r12 = androidx.compose.animation.core.SuspendAnimationKt.animate$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r12 != r0) goto Lb3
                return r0
            Lb3:
                C7.r r12 = C7.r.f317a
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerStateKt.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final PagerState PagerState(int i, @FloatRange(from = -0.5d, to = 0.5d) float f, S7.a aVar) {
        return new DefaultPagerState(i, f, aVar);
    }

    public static /* synthetic */ PagerState PagerState$default(int i, float f, S7.a aVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = 0;
        }
        if ((i6 & 2) != 0) {
            f = 0.0f;
        }
        return PagerState(i, f, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object animateScrollToPage(LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, float f, AnimationSpec<Float> animationSpec, n nVar, H7.c<? super r> cVar) {
        Object objScroll = lazyLayoutAnimateScrollScope.scroll(new AnonymousClass2(nVar, i, lazyLayoutAnimateScrollScope, f, animationSpec, null), cVar);
        return objScroll == CoroutineSingletons.f4909a ? objScroll : r.f317a;
    }

    public static final Object animateToNextPage(PagerState pagerState, H7.c<? super r> cVar) {
        Object objAnimateScrollToPage$default;
        return (pagerState.getCurrentPage() + 1 >= pagerState.getPageCount() || (objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + 1, 0.0f, null, cVar, 6, null)) != CoroutineSingletons.f4909a) ? r.f317a : objAnimateScrollToPage$default;
    }

    public static final Object animateToPreviousPage(PagerState pagerState, H7.c<? super r> cVar) {
        Object objAnimateScrollToPage$default;
        return (pagerState.getCurrentPage() + (-1) < 0 || (objAnimateScrollToPage$default = PagerState.animateScrollToPage$default(pagerState, pagerState.getCurrentPage() + (-1), 0.0f, null, cVar, 6, null)) != CoroutineSingletons.f4909a) ? r.f317a : objAnimateScrollToPage$default;
    }

    public static final long calculateNewMaxScrollOffset(PagerLayoutInfo pagerLayoutInfo, int i) {
        long pageSize = (i * (pagerLayoutInfo.getPageSize() + pagerLayoutInfo.getPageSpacing())) + pagerLayoutInfo.getBeforeContentPadding() + pagerLayoutInfo.getAfterContentPadding();
        int iM7015getWidthimpl = pagerLayoutInfo.getOrientation() == Orientation.Horizontal ? IntSize.m7015getWidthimpl(pagerLayoutInfo.mo941getViewportSizeYbymL2g()) : IntSize.m7014getHeightimpl(pagerLayoutInfo.mo941getViewportSizeYbymL2g());
        long jU = pageSize - (iM7015getWidthimpl - AbstractC1451a.u(pagerLayoutInfo.getSnapPosition().position(iM7015getWidthimpl, pagerLayoutInfo.getPageSize(), pagerLayoutInfo.getBeforeContentPadding(), pagerLayoutInfo.getAfterContentPadding(), i - 1, i), 0, iM7015getWidthimpl));
        if (jU < 0) {
            return 0L;
        }
        return jU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long calculateNewMinScrollOffset(PagerMeasureResult pagerMeasureResult, int i) {
        int iM7015getWidthimpl = pagerMeasureResult.getOrientation() == Orientation.Horizontal ? IntSize.m7015getWidthimpl(pagerMeasureResult.mo941getViewportSizeYbymL2g()) : IntSize.m7014getHeightimpl(pagerMeasureResult.mo941getViewportSizeYbymL2g());
        return AbstractC1451a.u(pagerMeasureResult.getSnapPosition().position(iM7015getWidthimpl, pagerMeasureResult.getPageSize(), pagerMeasureResult.getBeforeContentPadding(), pagerMeasureResult.getAfterContentPadding(), 0, i), 0, iM7015getWidthimpl);
    }

    private static final void debugLog(S7.a aVar) {
    }

    public static final float getDefaultPositionThreshold() {
        return DefaultPositionThreshold;
    }

    public static final PagerMeasureResult getEmptyLayoutInfo() {
        return EmptyLayoutInfo;
    }

    @Composable
    public static final PagerState rememberPagerState(final int i, @FloatRange(from = -0.5d, to = 0.5d) final float f, final S7.a aVar, Composer composer, int i6, int i10) {
        if ((i10 & 1) != 0) {
            i = 0;
        }
        if ((i10 & 2) != 0) {
            f = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1210768637, i6, -1, "androidx.compose.foundation.pager.rememberPagerState (PagerState.kt:86)");
        }
        Object[] objArr = new Object[0];
        Saver<DefaultPagerState, ?> saver = DefaultPagerState.INSTANCE.getSaver();
        boolean z10 = ((((i6 & 14) ^ 6) > 4 && composer.changed(i)) || (i6 & 6) == 4) | ((((i6 & 112) ^ 48) > 32 && composer.changed(f)) || (i6 & 48) == 32) | ((((i6 & 896) ^ 384) > 256 && composer.changed(aVar)) || (i6 & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z10 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new S7.a() { // from class: androidx.compose.foundation.pager.PagerStateKt$rememberPagerState$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final DefaultPagerState invoke() {
                    return new DefaultPagerState(i, f, aVar);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        DefaultPagerState defaultPagerState = (DefaultPagerState) RememberSaveableKt.m3591rememberSaveable(objArr, (Saver) saver, (String) null, (S7.a) objRememberedValue, composer, 0, 4);
        defaultPagerState.getPageCountState().setValue(aVar);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultPagerState;
    }
}
