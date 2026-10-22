package androidx.compose.animation;

import C7.r;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0012\u001a\u00020\u000f*\u00020\n2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R*\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R/\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u00038F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR7\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b\u0007\u0010!\"\u0004\b\"\u0010#\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006$"}, d2 = {"Landroidx/compose/animation/SkipToLookaheadNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/animation/ScaleToBoundsImpl;", "scaleToBounds", "Lkotlin/Function0;", "", "isEnabled", AppAgent.CONSTRUCT, "(Landroidx/compose/animation/ScaleToBoundsImpl;LS7/a;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM", "(Landroidx/compose/ui/unit/Constraints;)V", "<set-?>", "scaleToBounds$delegate", "Landroidx/compose/runtime/MutableState;", "getScaleToBounds", "()Landroidx/compose/animation/ScaleToBoundsImpl;", "setScaleToBounds", "(Landroidx/compose/animation/ScaleToBoundsImpl;)V", "isEnabled$delegate", "()LS7/a;", "setEnabled", "(LS7/a;)V", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {

    /* renamed from: isEnabled$delegate, reason: from kotlin metadata */
    private final MutableState isEnabled;
    private Constraints lookaheadConstraints;

    /* renamed from: scaleToBounds$delegate, reason: from kotlin metadata */
    private final MutableState scaleToBounds;

    public SkipToLookaheadNode(ScaleToBoundsImpl scaleToBoundsImpl, S7.a aVar) {
        this.scaleToBounds = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(scaleToBoundsImpl, null, 2, null);
        this.isEnabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(aVar, null, 2, null);
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ScaleToBoundsImpl getScaleToBounds() {
        return (ScaleToBoundsImpl) this.scaleToBounds.getValue();
    }

    public final S7.a isEnabled() {
        return (S7.a) this.isEnabled.getValue();
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
        if (measureScope.isLookingAhead()) {
            this.lookaheadConstraints = Constraints.m6784boximpl(j5);
        }
        Constraints constraints = this.lookaheadConstraints;
        k.c(constraints);
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(constraints.getValue());
        final long jIntSize = IntSizeKt.IntSize(placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight());
        final long jM6811constrain4WqzIAM = ConstraintsKt.m6811constrain4WqzIAM(j5, jIntSize);
        return MeasureScope.layout$default(measureScope, IntSize.m7015getWidthimpl(jM6811constrain4WqzIAM), IntSize.m7014getHeightimpl(jM6811constrain4WqzIAM), null, new S7.k() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1
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
                ScaleToBoundsImpl scaleToBounds = this.this$0.getScaleToBounds();
                if (!((Boolean) this.this$0.isEnabled().invoke()).booleanValue() || scaleToBounds == null) {
                    Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
                    return;
                }
                final long jScaleFactor = (IntSize.m7015getWidthimpl(jIntSize) == 0 || IntSize.m7014getHeightimpl(jIntSize) == 0) ? ScaleFactorKt.ScaleFactor(1.0f, 1.0f) : scaleToBounds.getContentScale().mo5542computeScaleFactorH7hwNQA(IntSizeKt.m7027toSizeozmzZPI(jIntSize), IntSizeKt.m7027toSizeozmzZPI(jM6811constrain4WqzIAM));
                long jMo3612alignKFBX0sM = scaleToBounds.getAlignment().mo3612alignKFBX0sM(IntSizeKt.IntSize(U7.a.U(ScaleFactor.m5642getScaleXimpl(jScaleFactor) * IntSize.m7015getWidthimpl(jIntSize)), U7.a.U(ScaleFactor.m5643getScaleYimpl(jScaleFactor) * IntSize.m7014getHeightimpl(jIntSize))), jM6811constrain4WqzIAM, measureScope.getLayoutDirection());
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeableMo5549measureBRTryo0, IntOffset.m6972getXimpl(jMo3612alignKFBX0sM), IntOffset.m6973getYimpl(jMo3612alignKFBX0sM), 0.0f, new S7.k() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return r.f317a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.setScaleX(ScaleFactor.m5642getScaleXimpl(jScaleFactor));
                        graphicsLayerScope.setScaleY(ScaleFactor.m5643getScaleYimpl(jScaleFactor));
                        graphicsLayerScope.mo4340setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
                    }
                }, 4, (Object) null);
            }
        }, 4, null);
    }

    public final void setEnabled(S7.a aVar) {
        this.isEnabled.setValue(aVar);
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM, reason: not valid java name */
    public final void m124setLookaheadConstraints_Sx5XlM(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    public final void setScaleToBounds(ScaleToBoundsImpl scaleToBoundsImpl) {
        this.scaleToBounds.setValue(scaleToBoundsImpl);
    }
}
