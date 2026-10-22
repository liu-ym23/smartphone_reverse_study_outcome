package androidx.compose.foundation.pager;

import C7.r;
import J7.c;
import S7.a;
import S7.k;
import S7.n;
import S7.p;
import Z7.q;
import androidx.compose.foundation.gestures.ForEachGestureKt;
import androidx.compose.foundation.lazy.layout.NearestRangeKeyIndexMap;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.PropertyReference0Impl;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a»\u0001\u0010%\u001a\u00020 2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!H\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a`\u0010)\u001a\b\u0012\u0004\u0012\u00020(0&2\u0006\u0010\u0003\u001a\u00020\u00022\u001d\u0010\"\u001a\u0019\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!2\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\r0&H\u0003¢\u0006\u0004\b)\u0010*\u001a\u001b\u0010+\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/foundation/pager/PagerState;", "state", "Landroidx/compose/foundation/layout/PaddingValues;", "contentPadding", "", "reverseLayout", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "flingBehavior", "userScrollEnabled", "", "beyondViewportPageCount", "Landroidx/compose/ui/unit/Dp;", "pageSpacing", "Landroidx/compose/foundation/pager/PageSize;", "pageSize", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "pageNestedScrollConnection", "Lkotlin/Function1;", "", "key", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Lkotlin/Function2;", "Landroidx/compose/foundation/pager/PagerScope;", "LC7/r;", "Landroidx/compose/runtime/Composable;", "pageContent", "Pager-uYRUAWA", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/layout/PaddingValues;ZLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/gestures/TargetedFlingBehavior;ZIFLandroidx/compose/foundation/pager/PageSize;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;LS7/k;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/foundation/gestures/snapping/SnapPosition;LS7/p;Landroidx/compose/runtime/Composer;III)V", "Pager", "Lkotlin/Function0;", "pageCount", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "rememberPagerItemProviderLambda", "(Landroidx/compose/foundation/pager/PagerState;LS7/p;LS7/k;LS7/a;Landroidx/compose/runtime/Composer;I)LS7/a;", "dragDirectionDetector", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/pager/PagerState;)Landroidx/compose/ui/Modifier;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutPagerKt {

    @c(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1", f = "LazyLayoutPager.kt", l = {284}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/PointerInputScope;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ PagerState $state;
        private /* synthetic */ Object L$0;
        int label;

        @c(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1", f = "LazyLayoutPager.kt", l = {285}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C00351 extends SuspendLambda implements n {
            final /* synthetic */ PointerInputScope $$this$pointerInput;
            final /* synthetic */ PagerState $state;
            int label;

            @c(c = "androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1", f = "LazyLayoutPager.kt", l = {287, 291}, m = "invokeSuspend")
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "LC7/r;", "<anonymous>", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;)V"}, k = 3, mv = {1, 8, 0})
            /* renamed from: androidx.compose.foundation.pager.LazyLayoutPagerKt$dragDirectionDetector$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C00361 extends RestrictedSuspendLambda implements n {
                final /* synthetic */ PagerState $state;
                private /* synthetic */ Object L$0;
                Object L$1;
                Object L$2;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C00361(PagerState pagerState, H7.c<? super C00361> cVar) {
                    super(2, cVar);
                    this.$state = pagerState;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                    C00361 c00361 = new C00361(this.$state, cVar);
                    c00361.L$0 = obj;
                    return c00361;
                }

                @Override // S7.n
                public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, H7.c<? super r> cVar) {
                    return ((C00361) create(awaitPointerEventScope, cVar)).invokeSuspend(r.f317a);
                }

                /* JADX WARN: Code restructure failed: missing block: B:11:0x003f, code lost:
                
                    if (r11 == r0) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:16:0x0063, code lost:
                
                    if (r11 == r0) goto L17;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:17:0x0065, code lost:
                
                    return r0;
                 */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0055  */
                /* JADX WARN: Removed duplicated region for block: B:25:0x008f  */
                /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0063 -> B:18:0x0066). Please report as a decompilation issue!!! */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object invokeSuspend(java.lang.Object r11) {
                    /*
                        r10 = this;
                        kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                        int r1 = r10.label
                        r2 = 2
                        r3 = 0
                        r4 = 1
                        if (r1 == 0) goto L2d
                        if (r1 == r4) goto L25
                        if (r1 != r2) goto L1d
                        java.lang.Object r1 = r10.L$2
                        androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                        java.lang.Object r4 = r10.L$1
                        androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                        java.lang.Object r5 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                        kotlin.b.b(r11)
                        goto L66
                    L1d:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L25:
                        java.lang.Object r1 = r10.L$0
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        kotlin.b.b(r11)
                        goto L42
                    L2d:
                        kotlin.b.b(r11)
                        java.lang.Object r11 = r10.L$0
                        r1 = r11
                        androidx.compose.ui.input.pointer.AwaitPointerEventScope r1 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r1
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r10.L$0 = r1
                        r10.label = r4
                        java.lang.Object r11 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r1, r3, r11, r10)
                        if (r11 != r0) goto L42
                        goto L65
                    L42:
                        androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                        androidx.compose.foundation.pager.PagerState r4 = r10.$state
                        androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.INSTANCE
                        long r5 = r5.m3911getZeroF1C5BW0()
                        r4.m952setUpDownDifferencek4lQ0M$foundation_release(r5)
                        r4 = 0
                        r5 = r1
                        r1 = r4
                        r4 = r11
                    L53:
                        if (r1 != 0) goto L8f
                        androidx.compose.ui.input.pointer.PointerEventPass r11 = androidx.compose.ui.input.pointer.PointerEventPass.Initial
                        r10.L$0 = r5
                        r10.L$1 = r4
                        r10.L$2 = r1
                        r10.label = r2
                        java.lang.Object r11 = r5.awaitPointerEvent(r11, r10)
                        if (r11 != r0) goto L66
                    L65:
                        return r0
                    L66:
                        androidx.compose.ui.input.pointer.PointerEvent r11 = (androidx.compose.ui.input.pointer.PointerEvent) r11
                        java.util.List r6 = r11.getChanges()
                        int r7 = r6.size()
                        r8 = r3
                    L71:
                        if (r8 >= r7) goto L83
                        java.lang.Object r9 = r6.get(r8)
                        androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                        boolean r9 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUp(r9)
                        if (r9 != 0) goto L80
                        goto L53
                    L80:
                        int r8 = r8 + 1
                        goto L71
                    L83:
                        java.util.List r11 = r11.getChanges()
                        java.lang.Object r11 = r11.get(r3)
                        r1 = r11
                        androidx.compose.ui.input.pointer.PointerInputChange r1 = (androidx.compose.ui.input.pointer.PointerInputChange) r1
                        goto L53
                    L8f:
                        androidx.compose.foundation.pager.PagerState r10 = r10.$state
                        long r0 = r1.getPosition()
                        long r2 = r4.getPosition()
                        long r0 = androidx.compose.ui.geometry.Offset.m3899minusMKHz9U(r0, r2)
                        r10.m952setUpDownDifferencek4lQ0M$foundation_release(r0)
                        C7.r r10 = C7.r.f317a
                        return r10
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.AnonymousClass1.C00351.C00361.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00351(PointerInputScope pointerInputScope, PagerState pagerState, H7.c<? super C00351> cVar) {
                super(2, cVar);
                this.$$this$pointerInput = pointerInputScope;
                this.$state = pagerState;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                return new C00351(this.$$this$pointerInput, this.$state, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                int i = this.label;
                if (i == 0) {
                    b.b(obj);
                    PointerInputScope pointerInputScope = this.$$this$pointerInput;
                    C00361 c00361 = new C00361(this.$state, null);
                    this.label = 1;
                    if (ForEachGestureKt.awaitEachGesture(pointerInputScope, c00361, this) == coroutineSingletons) {
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

            @Override // S7.n
            public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
                return ((C00351) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(PagerState pagerState, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$state = pagerState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$state, cVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // S7.n
        public final Object invoke(PointerInputScope pointerInputScope, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(pointerInputScope, cVar)).invokeSuspend(r.f317a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                b.b(obj);
                C00351 c00351 = new C00351((PointerInputScope) this.L$0, this.$state, null);
                this.label = 1;
                if (AbstractC1683A.f(c00351, this) == coroutineSingletons) {
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

    /* JADX WARN: Removed duplicated region for block: B:108:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0457  */
    /* JADX WARN: Removed duplicated region for block: B:250:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011c  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /* renamed from: Pager-uYRUAWA, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m935PageruYRUAWA(final androidx.compose.ui.Modifier r30, androidx.compose.foundation.pager.PagerState r31, final androidx.compose.foundation.layout.PaddingValues r32, final boolean r33, final androidx.compose.foundation.gestures.Orientation r34, final androidx.compose.foundation.gestures.TargetedFlingBehavior r35, final boolean r36, int r37, float r38, final androidx.compose.foundation.pager.PageSize r39, androidx.compose.ui.input.nestedscroll.NestedScrollConnection r40, final S7.k r41, final androidx.compose.ui.Alignment.Horizontal r42, final androidx.compose.ui.Alignment.Vertical r43, final androidx.compose.foundation.gestures.snapping.SnapPosition r44, final S7.p r45, androidx.compose.runtime.Composer r46, final int r47, final int r48, final int r49) {
        /*
            Method dump skipped, instructions count: 1129
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.LazyLayoutPagerKt.m935PageruYRUAWA(androidx.compose.ui.Modifier, androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.layout.PaddingValues, boolean, androidx.compose.foundation.gestures.Orientation, androidx.compose.foundation.gestures.TargetedFlingBehavior, boolean, int, float, androidx.compose.foundation.pager.PageSize, androidx.compose.ui.input.nestedscroll.NestedScrollConnection, S7.k, androidx.compose.ui.Alignment$Horizontal, androidx.compose.ui.Alignment$Vertical, androidx.compose.foundation.gestures.snapping.SnapPosition, S7.p, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final Modifier dragDirectionDetector(Modifier modifier, PagerState pagerState) {
        return modifier.then(Modifier.INSTANCE.then(new SuspendPointerInputElement(pagerState, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0(new AnonymousClass1(pagerState, null)), 6, null)));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    private static final a rememberPagerItemProviderLambda(final PagerState pagerState, p pVar, k kVar, final a aVar, Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1372505274, i, -1, "androidx.compose.foundation.pager.rememberPagerItemProviderLambda (LazyLayoutPager.kt:258)");
        }
        final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(pVar, composer, (i >> 3) & 14);
        final State stateRememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(kVar, composer, (i >> 6) & 14);
        boolean zChanged = ((((i & 14) ^ 6) > 4 && composer.changed(pagerState)) || (i & 6) == 4) | composer.changed(stateRememberUpdatedState) | composer.changed(stateRememberUpdatedState2) | ((((i & 7168) ^ 3072) > 2048 && composer.changed(aVar)) || (i & 3072) == 2048);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            final State stateDerivedStateOf = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new a() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$intervalContentState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @Override // S7.a
                public final PagerLayoutIntervalContent invoke() {
                    return new PagerLayoutIntervalContent(stateRememberUpdatedState.getValue(), stateRememberUpdatedState2.getValue(), ((Number) aVar.invoke()).intValue());
                }
            });
            final State stateDerivedStateOf2 = SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), new a() { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$itemProviderState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public final PagerLazyLayoutItemProvider invoke() {
                    PagerLayoutIntervalContent value = stateDerivedStateOf.getValue();
                    return new PagerLazyLayoutItemProvider(pagerState, value, new NearestRangeKeyIndexMap(pagerState.getNearestRange$foundation_release(), value));
                }
            });
            objRememberedValue = new PropertyReference0Impl(stateDerivedStateOf2) { // from class: androidx.compose.foundation.pager.LazyLayoutPagerKt$rememberPagerItemProviderLambda$1$1
                @Override // Z7.q
                public Object get() {
                    return ((State) this.receiver).getValue();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        q qVar = (q) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return qVar;
    }
}
