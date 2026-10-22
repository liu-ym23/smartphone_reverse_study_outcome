package androidx.compose.animation;

import C7.r;
import S7.n;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001:\u0001@B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0010\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J&\u0010\u001b\u001a\u00020\u0018*\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000fR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R6\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001c\u0010.\u001a\u00020\u00038\u0002@\u0002X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\n\u0004\b.\u0010/R*\u00101\u001a\u00020\f2\u0006\u00100\u001a\u00020\f8\u0002@BX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b1\u0010/\"\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R/\u0010?\u001a\u0004\u0018\u0001072\b\u00108\u001a\u0004\u0018\u0001078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006A"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode;", "Landroidx/compose/animation/LayoutModifierNodeWithPassThroughIntrinsics;", "Landroidx/compose/animation/core/AnimationSpec;", "Landroidx/compose/ui/unit/IntSize;", "animationSpec", "Landroidx/compose/ui/Alignment;", "alignment", "Lkotlin/Function2;", "LC7/r;", "listener", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/ui/Alignment;LS7/n;)V", "Landroidx/compose/ui/unit/Constraints;", "default", "targetConstraints-ZezNO4M", "(J)J", "targetConstraints", "onReset", "()V", "onAttach", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "targetSize", "animateTo-mzRDjE0", "animateTo", "Landroidx/compose/animation/core/AnimationSpec;", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "setAnimationSpec", "(Landroidx/compose/animation/core/AnimationSpec;)V", "Landroidx/compose/ui/Alignment;", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "LS7/n;", "getListener", "()LS7/n;", "setListener", "(LS7/n;)V", "lookaheadSize", "J", "value", "lookaheadConstraints", "setLookaheadConstraints-BRTryo0", "(J)V", "", "lookaheadConstraintsAvailable", "Z", "Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "<set-?>", "animData$delegate", "Landroidx/compose/runtime/MutableState;", "getAnimData", "()Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "setAnimData", "(Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;)V", "animData", "AnimData", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SizeAnimationModifierNode extends LayoutModifierNodeWithPassThroughIntrinsics {
    private Alignment alignment;

    /* renamed from: animData$delegate, reason: from kotlin metadata */
    private final MutableState animData;
    private AnimationSpec<IntSize> animationSpec;
    private n listener;
    private long lookaheadConstraints;
    private boolean lookaheadConstraintsAvailable;
    private long lookaheadSize;

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\u00020\u0003HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\nR(\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0001ø\u0001\u0000¢\u0006\u0012\n\u0004\b\u0006\u0010\u001d\u001a\u0004\b\u001e\u0010\f\"\u0004\b\u001f\u0010 \u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006!"}, d2 = {"Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/animation/core/AnimationVector2D;", "anim", "startSize", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/core/Animatable;JLkotlin/jvm/internal/e;)V", "component1", "()Landroidx/compose/animation/core/Animatable;", "component2-YbymL2g", "()J", "component2", "copy-O0kMr_c", "(Landroidx/compose/animation/core/Animatable;J)Landroidx/compose/animation/SizeAnimationModifierNode$AnimData;", "copy", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/animation/core/Animatable;", "getAnim", "J", "getStartSize-YbymL2g", "setStartSize-ozmzZPI", "(J)V", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class AnimData {
        public static final int $stable = 8;
        private final Animatable<IntSize, AnimationVector2D> anim;
        private long startSize;

        public /* synthetic */ AnimData(Animatable animatable, long j5, e eVar) {
            this(animatable, j5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: copy-O0kMr_c$default, reason: not valid java name */
        public static /* synthetic */ AnimData m117copyO0kMr_c$default(AnimData animData, Animatable animatable, long j5, int i, Object obj) {
            if ((i & 1) != 0) {
                animatable = animData.anim;
            }
            if ((i & 2) != 0) {
                j5 = animData.startSize;
            }
            return animData.m119copyO0kMr_c(animatable, j5);
        }

        public final Animatable<IntSize, AnimationVector2D> component1() {
            return this.anim;
        }

        /* renamed from: component2-YbymL2g, reason: not valid java name and from getter */
        public final long getStartSize() {
            return this.startSize;
        }

        /* renamed from: copy-O0kMr_c, reason: not valid java name */
        public final AnimData m119copyO0kMr_c(Animatable<IntSize, AnimationVector2D> anim, long startSize) {
            return new AnimData(anim, startSize, null);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AnimData)) {
                return false;
            }
            AnimData animData = (AnimData) other;
            return k.b(this.anim, animData.anim) && IntSize.m7013equalsimpl0(this.startSize, animData.startSize);
        }

        public final Animatable<IntSize, AnimationVector2D> getAnim() {
            return this.anim;
        }

        /* renamed from: getStartSize-YbymL2g, reason: not valid java name */
        public final long m120getStartSizeYbymL2g() {
            return this.startSize;
        }

        public int hashCode() {
            return IntSize.m7016hashCodeimpl(this.startSize) + (this.anim.hashCode() * 31);
        }

        /* renamed from: setStartSize-ozmzZPI, reason: not valid java name */
        public final void m121setStartSizeozmzZPI(long j5) {
            this.startSize = j5;
        }

        public String toString() {
            return "AnimData(anim=" + this.anim + ", startSize=" + ((Object) IntSize.m7018toStringimpl(this.startSize)) + ')';
        }

        private AnimData(Animatable<IntSize, AnimationVector2D> animatable, long j5) {
            this.anim = animatable;
            this.startSize = j5;
        }
    }

    public /* synthetic */ SizeAnimationModifierNode(AnimationSpec animationSpec, Alignment alignment, n nVar, int i, e eVar) {
        this(animationSpec, (i & 2) != 0 ? Alignment.INSTANCE.getTopStart() : alignment, (i & 4) != 0 ? null : nVar);
    }

    /* renamed from: setLookaheadConstraints-BRTryo0, reason: not valid java name */
    private final void m114setLookaheadConstraintsBRTryo0(long j5) {
        this.lookaheadConstraints = j5;
        this.lookaheadConstraintsAvailable = true;
    }

    /* renamed from: targetConstraints-ZezNO4M, reason: not valid java name */
    private final long m115targetConstraintsZezNO4M(long j5) {
        return this.lookaheadConstraintsAvailable ? this.lookaheadConstraints : j5;
    }

    /* renamed from: animateTo-mzRDjE0, reason: not valid java name */
    public final long m116animateTomzRDjE0(long targetSize) {
        AnimData animData = getAnimData();
        e eVar = null;
        if (animData != null) {
            boolean z10 = (IntSize.m7013equalsimpl0(targetSize, animData.getAnim().getValue().m7019unboximpl()) || animData.getAnim().isRunning()) ? false : true;
            if (!IntSize.m7013equalsimpl0(targetSize, animData.getAnim().getTargetValue().m7019unboximpl()) || z10) {
                animData.m121setStartSizeozmzZPI(animData.getAnim().getValue().m7019unboximpl());
                AbstractC1683A.n(getCoroutineScope(), null, new SizeAnimationModifierNode$animateTo$data$1$1(animData, targetSize, this, null), 3);
            }
        } else {
            animData = new AnimData(new Animatable(IntSize.m7007boximpl(targetSize), VectorConvertersKt.getVectorConverter(IntSize.INSTANCE), IntSize.m7007boximpl(IntSizeKt.IntSize(1, 1)), null, 8, null), targetSize, eVar);
        }
        setAnimData(animData);
        return animData.getAnim().getValue().m7019unboximpl();
    }

    public final Alignment getAlignment() {
        return this.alignment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AnimData getAnimData() {
        return (AnimData) this.animData.getValue();
    }

    public final AnimationSpec<IntSize> getAnimationSpec() {
        return this.animationSpec;
    }

    public final n getListener() {
        return this.listener;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
        Placeable placeableMo5549measureBRTryo0;
        long jM6811constrain4WqzIAM;
        if (measureScope.isLookingAhead()) {
            m114setLookaheadConstraintsBRTryo0(j5);
            placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
        } else {
            placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(m115targetConstraintsZezNO4M(j5));
        }
        final Placeable placeable = placeableMo5549measureBRTryo0;
        final long jIntSize = IntSizeKt.IntSize(placeable.getWidth(), placeable.getHeight());
        if (measureScope.isLookingAhead()) {
            this.lookaheadSize = jIntSize;
            jM6811constrain4WqzIAM = jIntSize;
        } else {
            jM6811constrain4WqzIAM = ConstraintsKt.m6811constrain4WqzIAM(j5, m116animateTomzRDjE0(AnimationModifierKt.m67isValidozmzZPI(this.lookaheadSize) ? this.lookaheadSize : jIntSize));
        }
        final int iM7015getWidthimpl = IntSize.m7015getWidthimpl(jM6811constrain4WqzIAM);
        final int iM7014getHeightimpl = IntSize.m7014getHeightimpl(jM6811constrain4WqzIAM);
        return MeasureScope.layout$default(measureScope, iM7015getWidthimpl, iM7014getHeightimpl, null, new S7.k() { // from class: androidx.compose.animation.SizeAnimationModifierNode$measure$2
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
                Placeable.PlacementScope.m5618placeRelative70tqf50$default(placementScope, placeable, this.this$0.getAlignment().mo3612alignKFBX0sM(jIntSize, IntSizeKt.IntSize(iM7015getWidthimpl, iM7014getHeightimpl), measureScope.getLayoutDirection()), 0.0f, 2, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraintsAvailable = false;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        setAnimData(null);
    }

    public final void setAlignment(Alignment alignment) {
        this.alignment = alignment;
    }

    public final void setAnimData(AnimData animData) {
        this.animData.setValue(animData);
    }

    public final void setAnimationSpec(AnimationSpec<IntSize> animationSpec) {
        this.animationSpec = animationSpec;
    }

    public final void setListener(n nVar) {
        this.listener = nVar;
    }

    public SizeAnimationModifierNode(AnimationSpec<IntSize> animationSpec, Alignment alignment, n nVar) {
        this.animationSpec = animationSpec;
        this.alignment = alignment;
        this.listener = nVar;
        this.lookaheadSize = AnimationModifierKt.getInvalidSize();
        this.lookaheadConstraints = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
        this.animData = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }
}
