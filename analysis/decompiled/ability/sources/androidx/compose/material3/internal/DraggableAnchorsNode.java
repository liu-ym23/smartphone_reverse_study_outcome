package androidx.compose.material3.internal;

import C7.r;
import S7.k;
import S7.n;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003BI\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012*\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00000\t0\u0006\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J&\u0010\u001a\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019R(\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fRF\u0010\u000b\u001a&\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0004\u0012\u00028\u00000\t0\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/material3/internal/DraggableAnchorsNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "state", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "Lkotlin/Pair;", "Landroidx/compose/material3/internal/DraggableAnchors;", "anchors", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", AppAgent.CONSTRUCT, "(Landroidx/compose/material3/internal/AnchoredDraggableState;LS7/n;Landroidx/compose/foundation/gestures/Orientation;)V", "LC7/r;", "onDetach", "()V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getState", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "setState", "(Landroidx/compose/material3/internal/AnchoredDraggableState;)V", "LS7/n;", "getAnchors", "()LS7/n;", "setAnchors", "(LS7/n;)V", "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "", "didLookahead", "Z", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DraggableAnchorsNode<T> extends Modifier.Node implements LayoutModifierNode {
    private n anchors;
    private boolean didLookahead;
    private Orientation orientation;
    private AnchoredDraggableState<T> state;

    public DraggableAnchorsNode(AnchoredDraggableState<T> anchoredDraggableState, n nVar, Orientation orientation) {
        this.state = anchoredDraggableState;
        this.anchors = nVar;
        this.orientation = orientation;
    }

    public final n getAnchors() {
        return this.anchors;
    }

    public final Orientation getOrientation() {
        return this.orientation;
    }

    public final AnchoredDraggableState<T> getState() {
        return this.state;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j5) {
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
        if (!measureScope.isLookingAhead() || !this.didLookahead) {
            Pair pair = (Pair) this.anchors.invoke(IntSize.m7007boximpl(IntSizeKt.IntSize(placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight())), Constraints.m6784boximpl(j5));
            this.state.updateAnchors((DraggableAnchors) pair.f4886a, pair.b);
        }
        this.didLookahead = measureScope.isLookingAhead() || this.didLookahead;
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.material3.internal.DraggableAnchorsNode$measure$1
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
                float fPositionOf = measureScope.isLookingAhead() ? this.getState().getAnchors().positionOf(this.getState().getTargetValue()) : this.getState().requireOffset();
                float f = this.getOrientation() == Orientation.Horizontal ? fPositionOf : 0.0f;
                if (this.getOrientation() != Orientation.Vertical) {
                    fPositionOf = 0.0f;
                }
                Placeable.PlacementScope.place$default(placementScope, placeableMo5549measureBRTryo0, U7.a.U(f), U7.a.U(fPositionOf), 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.didLookahead = false;
    }

    public final void setAnchors(n nVar) {
        this.anchors = nVar;
    }

    public final void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public final void setState(AnchoredDraggableState<T> anchoredDraggableState) {
        this.state = anchoredDraggableState;
    }
}
