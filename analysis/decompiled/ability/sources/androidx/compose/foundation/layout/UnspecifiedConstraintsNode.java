package androidx.compose.foundation.layout;

import C7.r;
import S7.k;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.e;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\u0010\u001a\u00020\r*\u00020\b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u0015\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0017\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J#\u0010\u0019\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0019\u0010\u0016J#\u0010\u001a\u001a\u00020\u0013*\u00020\u00112\u0006\u0010\n\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u0016R(\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/unit/Dp;", "minWidth", "minHeight", AppAgent.CONSTRUCT, "(FFLkotlin/jvm/internal/e;)V", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "height", "minIntrinsicWidth", "(Landroidx/compose/ui/layout/IntrinsicMeasureScope;Landroidx/compose/ui/layout/IntrinsicMeasurable;I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "F", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f7, e eVar) {
        this(f, f7);
    }

    /* renamed from: getMinHeight-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinHeight() {
        return this.minHeight;
    }

    /* renamed from: getMinWidth-D9Ej5fM, reason: not valid java name and from getter */
    public final float getMinWidth() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(i);
        int iMo375roundToPx0680j_4 = !Dp.m6849equalsimpl0(this.minHeight, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo375roundToPx0680j_4(this.minHeight) : 0;
        return iMaxIntrinsicHeight < iMo375roundToPx0680j_4 ? iMo375roundToPx0680j_4 : iMaxIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(i);
        int iMo375roundToPx0680j_4 = !Dp.m6849equalsimpl0(this.minWidth, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo375roundToPx0680j_4(this.minWidth) : 0;
        return iMaxIntrinsicWidth < iMo375roundToPx0680j_4 ? iMo375roundToPx0680j_4 : iMaxIntrinsicWidth;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        int iM6799getMinWidthimpl;
        float f = this.minWidth;
        Dp.Companion companion = Dp.INSTANCE;
        int iM6798getMinHeightimpl = 0;
        if (Dp.m6849equalsimpl0(f, companion.m6864getUnspecifiedD9Ej5fM()) || Constraints.m6799getMinWidthimpl(j5) != 0) {
            iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        } else {
            iM6799getMinWidthimpl = measureScope.mo375roundToPx0680j_4(this.minWidth);
            int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
            if (iM6799getMinWidthimpl > iM6797getMaxWidthimpl) {
                iM6799getMinWidthimpl = iM6797getMaxWidthimpl;
            }
            if (iM6799getMinWidthimpl < 0) {
                iM6799getMinWidthimpl = 0;
            }
        }
        int iM6797getMaxWidthimpl2 = Constraints.m6797getMaxWidthimpl(j5);
        if (Dp.m6849equalsimpl0(this.minHeight, companion.m6864getUnspecifiedD9Ej5fM()) || Constraints.m6798getMinHeightimpl(j5) != 0) {
            iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        } else {
            int iMo375roundToPx0680j_4 = measureScope.mo375roundToPx0680j_4(this.minHeight);
            int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
            if (iMo375roundToPx0680j_4 > iM6796getMaxHeightimpl) {
                iMo375roundToPx0680j_4 = iM6796getMaxHeightimpl;
            }
            if (iMo375roundToPx0680j_4 >= 0) {
                iM6798getMinHeightimpl = iMo375roundToPx0680j_4;
            }
        }
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(ConstraintsKt.Constraints(iM6799getMinWidthimpl, iM6797getMaxWidthimpl2, iM6798getMinHeightimpl, Constraints.m6796getMaxHeightimpl(j5)));
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
            {
                super(1);
            }

            @Override // S7.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return r.f317a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5549measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(i);
        int iMo375roundToPx0680j_4 = !Dp.m6849equalsimpl0(this.minHeight, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo375roundToPx0680j_4(this.minHeight) : 0;
        return iMinIntrinsicHeight < iMo375roundToPx0680j_4 ? iMo375roundToPx0680j_4 : iMinIntrinsicHeight;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(i);
        int iMo375roundToPx0680j_4 = !Dp.m6849equalsimpl0(this.minWidth, Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM()) ? intrinsicMeasureScope.mo375roundToPx0680j_4(this.minWidth) : 0;
        return iMinIntrinsicWidth < iMo375roundToPx0680j_4 ? iMo375roundToPx0680j_4 : iMinIntrinsicWidth;
    }

    /* renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m766setMinHeight0680j_4(float f) {
        this.minHeight = f;
    }

    /* renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m767setMinWidth0680j_4(float f) {
        this.minWidth = f;
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float f, float f7, int i, e eVar) {
        this((i & 1) != 0 ? Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM() : f, (i & 2) != 0 ? Dp.INSTANCE.m6864getUnspecifiedD9Ej5fM() : f7, null);
    }

    private UnspecifiedConstraintsNode(float f, float f7) {
        this.minWidth = f;
        this.minHeight = f7;
    }
}
