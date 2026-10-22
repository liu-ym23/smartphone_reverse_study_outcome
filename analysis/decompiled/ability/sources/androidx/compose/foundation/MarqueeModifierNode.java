package androidx.compose.foundation;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.flow.d;
import m9.AbstractC1683A;
import m9.InterfaceC1733z;
import m9.c0;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B7\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J@\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ&\u0010$\u001a\u00020!*\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fH\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J#\u0010(\u001a\u00020\u0005*\u00020%2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b(\u0010)J#\u0010*\u001a\u00020\u0005*\u00020%2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005H\u0016¢\u0006\u0004\b*\u0010)J#\u0010,\u001a\u00020\u0005*\u00020%2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b,\u0010)J#\u0010-\u001a\u00020\u0005*\u00020%2\u0006\u0010\u001e\u001a\u00020&2\u0006\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010)J\u0013\u0010/\u001a\u00020\u0011*\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\u0011H\u0002¢\u0006\u0004\b1\u0010\u0013J\u0010\u00102\u001a\u00020\u0011H\u0082@¢\u0006\u0004\b2\u00103R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u00104R\u0016\u0010\t\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00104R\u0016\u0010\n\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u00104R\u001c\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b\u000e\u00105R+\u0010=\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R+\u0010A\u001a\u00020\u00052\u0006\u00106\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b>\u00108\u001a\u0004\b?\u0010:\"\u0004\b@\u0010<R+\u0010I\u001a\u00020B2\u0006\u00106\u001a\u00020B8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR+\u0010\f\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bM\u0010D\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR1\u0010\b\u001a\u00020\u00072\u0006\u00106\u001a\u00020\u00078F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\bR\u0010D\u001a\u0004\bS\u0010:\"\u0004\bT\u0010<R \u0010X\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020W0U8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010YR\u001b\u0010]\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010:R\u0014\u0010`\u001a\u00020V8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b^\u0010_\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006a"}, d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "", "iterations", "Landroidx/compose/foundation/MarqueeAnimationMode;", "animationMode", "delayMillis", "initialDelayMillis", "Landroidx/compose/foundation/MarqueeSpacing;", "spacing", "Landroidx/compose/ui/unit/Dp;", "velocity", AppAgent.CONSTRUCT, "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/e;)V", "LC7/r;", "onAttach", "()V", "onDetach", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "update", "Landroidx/compose/ui/focus/FocusState;", "focusState", "onFocusEvent", "(Landroidx/compose/ui/focus/FocusState;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "restartAnimation", "runAnimation", "(LH7/c;)Ljava/lang/Object;", "I", "F", "<set-?>", "contentWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "getContentWidth", "()I", "setContentWidth", "(I)V", "contentWidth", "containerWidth$delegate", "getContainerWidth", "setContainerWidth", "containerWidth", "", "hasFocus$delegate", "Landroidx/compose/runtime/MutableState;", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus", "Lm9/c0;", "animationJob", "Lm9/c0;", "spacing$delegate", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "animationMode$delegate", "getAnimationMode-ZbEOnfQ", "setAnimationMode-97h66l8", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/animation/core/Animatable;", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "getSpacingPx", "spacingPx", "getDirection", "()F", "direction", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {
    private c0 animationJob;

    /* renamed from: animationMode$delegate, reason: from kotlin metadata */
    private final MutableState animationMode;

    /* renamed from: containerWidth$delegate, reason: from kotlin metadata */
    private final MutableIntState containerWidth;

    /* renamed from: contentWidth$delegate, reason: from kotlin metadata */
    private final MutableIntState contentWidth;
    private int delayMillis;

    /* renamed from: hasFocus$delegate, reason: from kotlin metadata */
    private final MutableState hasFocus;
    private int initialDelayMillis;
    private int iterations;
    private final Animatable<Float, AnimationVector1D> offset;

    /* renamed from: spacing$delegate, reason: from kotlin metadata */
    private final MutableState spacing;

    /* renamed from: spacingPx$delegate, reason: from kotlin metadata */
    private final State spacingPx;
    private float velocity;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @c(c = "androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1", f = "BasicMarquee.kt", l = {348, 349}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.MarqueeModifierNode$restartAnimation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements n {
        final /* synthetic */ c0 $oldJob;
        int label;
        final /* synthetic */ MarqueeModifierNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(c0 c0Var, MarqueeModifierNode marqueeModifierNode, H7.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$oldJob = c0Var;
            this.this$0 = marqueeModifierNode;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass1(this.$oldJob, this.this$0, cVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        
            if (r5.runAnimation(r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r4.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L18
                if (r1 != r2) goto L10
                kotlin.b.b(r5)
                goto L37
            L10:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L18:
                kotlin.b.b(r5)
                goto L2c
            L1c:
                kotlin.b.b(r5)
                m9.c0 r5 = r4.$oldJob
                if (r5 == 0) goto L2c
                r4.label = r3
                java.lang.Object r5 = r5.g(r4)
                if (r5 != r0) goto L2c
                goto L36
            L2c:
                androidx.compose.foundation.MarqueeModifierNode r5 = r4.this$0
                r4.label = r2
                java.lang.Object r4 = androidx.compose.foundation.MarqueeModifierNode.access$runAnimation(r5, r4)
                if (r4 != r0) goto L37
            L36:
                return r0
            L37:
                C7.r r4 = C7.r.f317a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2", f = "BasicMarquee.kt", l = {370}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {1, 8, 0})
    /* renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        int label;

        @c(c = "androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2", f = "BasicMarquee.kt", l = {383, 385, 389, 389}, m = "invokeSuspend")
        @Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"", "contentWithSpacingWidth", "LC7/r;", "<anonymous>", "(F)V"}, k = 3, mv = {1, 8, 0})
        /* renamed from: androidx.compose.foundation.MarqueeModifierNode$runAnimation$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C00122 extends SuspendLambda implements n {
            /* synthetic */ Object L$0;
            Object L$1;
            int label;
            final /* synthetic */ MarqueeModifierNode this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00122(MarqueeModifierNode marqueeModifierNode, H7.c<? super C00122> cVar) {
                super(2, cVar);
                this.this$0 = marqueeModifierNode;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                C00122 c00122 = new C00122(this.this$0, cVar);
                c00122.L$0 = obj;
                return c00122;
            }

            @Override // S7.n
            public final Object invoke(Float f, H7.c<? super r> cVar) {
                return ((C00122) create(f, cVar)).invokeSuspend(r.f317a);
            }

            /* JADX WARN: Removed duplicated region for block: B:30:0x00be A[RETURN] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r22) throws java.lang.Throwable {
                /*
                    r21 = this;
                    r5 = r21
                    kotlin.coroutines.intrinsics.CoroutineSingletons r8 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                    int r0 = r5.label
                    C7.r r9 = C7.r.f317a
                    r10 = 4
                    r11 = 3
                    r1 = 2
                    r2 = 1
                    r12 = 0
                    r13 = 0
                    if (r0 == 0) goto L47
                    if (r0 == r2) goto L36
                    if (r0 == r1) goto L2e
                    if (r0 == r11) goto L29
                    if (r0 == r10) goto L20
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r1)
                    throw r0
                L20:
                    java.lang.Object r0 = r5.L$0
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    kotlin.b.b(r22)
                    goto Ld7
                L29:
                    kotlin.b.b(r22)
                    goto Lbe
                L2e:
                    kotlin.b.b(r22)     // Catch: java.lang.Throwable -> L33
                    goto Laa
                L33:
                    r0 = move-exception
                    goto Lbf
                L36:
                    java.lang.Object r0 = r5.L$1
                    androidx.compose.animation.core.AnimationSpec r0 = (androidx.compose.animation.core.AnimationSpec) r0
                    java.lang.Object r2 = r5.L$0
                    java.lang.Float r2 = (java.lang.Float) r2
                    kotlin.b.b(r22)
                    r20 = r2
                    r2 = r0
                    r0 = r20
                    goto L90
                L47:
                    kotlin.b.b(r22)
                    java.lang.Object r0 = r5.L$0
                    java.lang.Float r0 = (java.lang.Float) r0
                    if (r0 != 0) goto L51
                    return r9
                L51:
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0
                    int r14 = androidx.compose.foundation.MarqueeModifierNode.access$getIterations$p(r3)
                    float r15 = r0.floatValue()
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0
                    int r16 = androidx.compose.foundation.MarqueeModifierNode.access$getInitialDelayMillis$p(r3)
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0
                    int r17 = androidx.compose.foundation.MarqueeModifierNode.access$getDelayMillis$p(r3)
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0
                    float r18 = androidx.compose.foundation.MarqueeModifierNode.access$getVelocity$p(r3)
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0
                    androidx.compose.ui.unit.Density r19 = androidx.compose.ui.node.DelegatableNodeKt.requireDensity(r3)
                    androidx.compose.animation.core.AnimationSpec r3 = androidx.compose.foundation.BasicMarqueeKt.m244access$createMarqueeAnimationSpecZ4HSEVQ(r14, r15, r16, r17, r18, r19)
                    androidx.compose.foundation.MarqueeModifierNode r4 = r5.this$0
                    androidx.compose.animation.core.Animatable r4 = androidx.compose.foundation.MarqueeModifierNode.access$getOffset$p(r4)
                    java.lang.Float r6 = new java.lang.Float
                    r6.<init>(r13)
                    r5.L$0 = r0
                    r5.L$1 = r3
                    r5.label = r2
                    java.lang.Object r2 = r4.snapTo(r6, r5)
                    if (r2 != r8) goto L8f
                    goto Ld6
                L8f:
                    r2 = r3
                L90:
                    androidx.compose.foundation.MarqueeModifierNode r3 = r5.this$0     // Catch: java.lang.Throwable -> L33
                    androidx.compose.animation.core.Animatable r3 = androidx.compose.foundation.MarqueeModifierNode.access$getOffset$p(r3)     // Catch: java.lang.Throwable -> L33
                    r5.L$0 = r12     // Catch: java.lang.Throwable -> L33
                    r5.L$1 = r12     // Catch: java.lang.Throwable -> L33
                    r5.label = r1     // Catch: java.lang.Throwable -> L33
                    r1 = r0
                    r0 = r3
                    r3 = 0
                    r4 = 0
                    r6 = 12
                    r7 = 0
                    java.lang.Object r0 = androidx.compose.animation.core.Animatable.animateTo$default(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L33
                    if (r0 != r8) goto Laa
                    goto Ld6
                Laa:
                    androidx.compose.foundation.MarqueeModifierNode r0 = r5.this$0
                    androidx.compose.animation.core.Animatable r0 = androidx.compose.foundation.MarqueeModifierNode.access$getOffset$p(r0)
                    java.lang.Float r1 = new java.lang.Float
                    r1.<init>(r13)
                    r5.label = r11
                    java.lang.Object r0 = r0.snapTo(r1, r5)
                    if (r0 != r8) goto Lbe
                    goto Ld6
                Lbe:
                    return r9
                Lbf:
                    androidx.compose.foundation.MarqueeModifierNode r1 = r5.this$0
                    androidx.compose.animation.core.Animatable r1 = androidx.compose.foundation.MarqueeModifierNode.access$getOffset$p(r1)
                    java.lang.Float r2 = new java.lang.Float
                    r2.<init>(r13)
                    r5.L$0 = r0
                    r5.L$1 = r12
                    r5.label = r10
                    java.lang.Object r1 = r1.snapTo(r2, r5)
                    if (r1 != r8) goto Ld7
                Ld6:
                    return r8
                Ld7:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.MarqueeModifierNode.AnonymousClass2.C00122.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return MarqueeModifierNode.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                final MarqueeModifierNode marqueeModifierNode = MarqueeModifierNode.this;
                p9.c cVarSnapshotFlow = SnapshotStateKt.snapshotFlow(new S7.a() { // from class: androidx.compose.foundation.MarqueeModifierNode.runAnimation.2.1
                    {
                        super(0);
                    }

                    @Override // S7.a
                    public final Float invoke() {
                        if (marqueeModifierNode.getContentWidth() <= marqueeModifierNode.getContainerWidth()) {
                            return null;
                        }
                        if (!MarqueeAnimationMode.m317equalsimpl0(marqueeModifierNode.m328getAnimationModeZbEOnfQ(), MarqueeAnimationMode.INSTANCE.m322getWhileFocusedZbEOnfQ()) || marqueeModifierNode.getHasFocus()) {
                            return Float.valueOf(marqueeModifierNode.getContentWidth() + marqueeModifierNode.getSpacingPx());
                        }
                        return null;
                    }
                });
                C00122 c00122 = new C00122(MarqueeModifierNode.this, null);
                this.label = 1;
                if (d.d(cVarSnapshotFlow, c00122, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    public /* synthetic */ MarqueeModifierNode(int i, int i6, int i10, int i11, MarqueeSpacing marqueeSpacing, float f, e eVar) {
        this(i, i6, i10, i11, marqueeSpacing, f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContainerWidth() {
        return this.containerWidth.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getContentWidth() {
        return this.contentWidth.getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getDirection() {
        float fSignum = Math.signum(this.velocity);
        int i = WhenMappings.$EnumSwitchMapping$0[DelegatableNodeKt.requireLayoutDirection(this).ordinal()];
        int i6 = 1;
        if (i != 1) {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            i6 = -1;
        }
        return fSignum * i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getHasFocus() {
        return ((Boolean) this.hasFocus.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getSpacingPx() {
        return ((Number) this.spacingPx.getValue()).intValue();
    }

    private final void restartAnimation() {
        c0 c0Var = this.animationJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        if (getIsAttached()) {
            this.animationJob = AbstractC1683A.n(getCoroutineScope(), null, new AnonymousClass1(c0Var, this, null), 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object runAnimation(H7.c<? super r> cVar) {
        Object objW;
        int i = this.iterations;
        r rVar = r.f317a;
        return (i > 0 && (objW = AbstractC1683A.w(FixedMotionDurationScale.INSTANCE, new AnonymousClass2(null), cVar)) == CoroutineSingletons.f4909a) ? objW : rVar;
    }

    private final void setContainerWidth(int i) {
        this.containerWidth.setIntValue(i);
    }

    private final void setContentWidth(int i) {
        this.contentWidth.setIntValue(i);
    }

    private final void setHasFocus(boolean z10) {
        this.hasFocus.setValue(Boolean.valueOf(z10));
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        float fFloatValue = this.offset.getValue().floatValue() * getDirection();
        boolean z10 = getDirection() != 1.0f ? this.offset.getValue().floatValue() < ((float) getContainerWidth()) : this.offset.getValue().floatValue() < ((float) getContentWidth());
        boolean z11 = getDirection() != 1.0f ? this.offset.getValue().floatValue() > ((float) getSpacingPx()) : this.offset.getValue().floatValue() > ((float) ((getContentWidth() + getSpacingPx()) - getContainerWidth()));
        float contentWidth = getDirection() == 1.0f ? getContentWidth() + getSpacingPx() : (-getContentWidth()) - getSpacingPx();
        float containerWidth = fFloatValue + getContainerWidth();
        float fM3961getHeightimpl = Size.m3961getHeightimpl(contentDrawScope.mo4707getSizeNHjbRc());
        int iM4128getIntersectrtfAjoo = ClipOp.INSTANCE.m4128getIntersectrtfAjoo();
        DrawContext drawContext = contentDrawScope.getDrawContext();
        long jMo4628getSizeNHjbRc = drawContext.mo4628getSizeNHjbRc();
        drawContext.getCanvas().save();
        try {
            drawContext.getTransform().mo4631clipRectN_I0leg(fFloatValue, 0.0f, containerWidth, fM3961getHeightimpl, iM4128getIntersectrtfAjoo);
            if (z10) {
                contentDrawScope.drawContent();
            }
            if (z11) {
                contentDrawScope.getDrawContext().getTransform().translate(contentWidth, 0.0f);
                try {
                    contentDrawScope.drawContent();
                    contentDrawScope.getDrawContext().getTransform().translate(-contentWidth, -0.0f);
                } catch (Throwable th) {
                    contentDrawScope.getDrawContext().getTransform().translate(-contentWidth, -0.0f);
                    throw th;
                }
            }
            androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
        } catch (Throwable th2) {
            androidx.appfunctions.metadata.a.A(drawContext, jMo4628getSizeNHjbRc);
            throw th2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getAnimationMode-ZbEOnfQ, reason: not valid java name */
    public final int m328getAnimationModeZbEOnfQ() {
        return ((MarqueeAnimationMode) this.animationMode.getValue()).getValue();
    }

    public final MarqueeSpacing getSpacing() {
        return (MarqueeSpacing) this.spacing.getValue();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(Constraints.m6787copyZbe2FdA$default(j5, 0, Integer.MAX_VALUE, 0, 0, 13, null));
        setContainerWidth(ConstraintsKt.m6814constrainWidthK40F9xA(j5, placeableMo5549measureBRTryo0.getWidth()));
        setContentWidth(placeableMo5549measureBRTryo0.getWidth());
        return MeasureScope.layout$default(measureScope, getContainerWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.foundation.MarqueeModifierNode$measure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo5549measureBRTryo0, U7.a.U((-((Number) this.offset.getValue()).floatValue()) * this.getDirection()), 0, 0.0f, (k) null, 12, (Object) null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        restartAnimation();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        c0 c0Var = this.animationJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.animationJob = null;
    }

    @Override // androidx.compose.ui.focus.FocusEventModifierNode
    public void onFocusEvent(FocusState focusState) {
        setHasFocus(focusState.getHasFocus());
    }

    /* renamed from: setAnimationMode-97h66l8, reason: not valid java name */
    public final void m329setAnimationMode97h66l8(int i) {
        this.animationMode.setValue(MarqueeAnimationMode.m314boximpl(i));
    }

    public final void setSpacing(MarqueeSpacing marqueeSpacing) {
        this.spacing.setValue(marqueeSpacing);
    }

    /* renamed from: update-lWfNwf4, reason: not valid java name */
    public final void m330updatelWfNwf4(int iterations, int animationMode, int delayMillis, int initialDelayMillis, MarqueeSpacing spacing, float velocity) {
        setSpacing(spacing);
        m329setAnimationMode97h66l8(animationMode);
        if (this.iterations == iterations && this.delayMillis == delayMillis && this.initialDelayMillis == initialDelayMillis && Dp.m6849equalsimpl0(this.velocity, velocity)) {
            return;
        }
        this.iterations = iterations;
        this.delayMillis = delayMillis;
        this.initialDelayMillis = initialDelayMillis;
        this.velocity = velocity;
        restartAnimation();
    }

    private MarqueeModifierNode(int i, int i6, int i10, int i11, final MarqueeSpacing marqueeSpacing, float f) {
        this.iterations = i;
        this.delayMillis = i10;
        this.initialDelayMillis = i11;
        this.velocity = f;
        this.contentWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.containerWidth = SnapshotIntStateKt.mutableIntStateOf(0);
        this.hasFocus = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.spacing = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(marqueeSpacing, null, 2, null);
        this.animationMode = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.m314boximpl(i6), null, 2, null);
        this.offset = AnimatableKt.Animatable$default(0.0f, 0.0f, 2, null);
        this.spacingPx = SnapshotStateKt.derivedStateOf(new S7.a() { // from class: androidx.compose.foundation.MarqueeModifierNode$spacingPx$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // S7.a
            public final Integer invoke() {
                MarqueeSpacing marqueeSpacing2 = marqueeSpacing;
                MarqueeModifierNode marqueeModifierNode = this;
                return Integer.valueOf(marqueeSpacing2.calculateSpacing(DelegatableNodeKt.requireDensity(marqueeModifierNode), marqueeModifierNode.getContentWidth(), marqueeModifierNode.getContainerWidth()));
            }
        });
    }
}
