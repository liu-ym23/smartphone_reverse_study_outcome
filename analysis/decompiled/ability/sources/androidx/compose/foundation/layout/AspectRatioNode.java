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
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J \u0010&\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J \u0010,\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J \u0010.\u001a\u00020\u0011*\u00020\u00122\b\b\u0002\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public AspectRatioNode(float f, boolean z10) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z10;
    }

    /* renamed from: findSize-ToXhtMw, reason: not valid java name */
    private final long m597findSizeToXhtMw(long j5) {
        if (this.matchHeightConstraintsFirst) {
            long jM599tryMaxHeightJN0ABg$default = m599tryMaxHeightJN0ABg$default(this, j5, false, 1, null);
            IntSize.Companion companion = IntSize.INSTANCE;
            if (!IntSize.m7013equalsimpl0(jM599tryMaxHeightJN0ABg$default, companion.m7020getZeroYbymL2g())) {
                return jM599tryMaxHeightJN0ABg$default;
            }
            long jM601tryMaxWidthJN0ABg$default = m601tryMaxWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM601tryMaxWidthJN0ABg$default, companion.m7020getZeroYbymL2g())) {
                return jM601tryMaxWidthJN0ABg$default;
            }
            long jM603tryMinHeightJN0ABg$default = m603tryMinHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM603tryMinHeightJN0ABg$default, companion.m7020getZeroYbymL2g())) {
                return jM603tryMinHeightJN0ABg$default;
            }
            long jM605tryMinWidthJN0ABg$default = m605tryMinWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM605tryMinWidthJN0ABg$default, companion.m7020getZeroYbymL2g())) {
                return jM605tryMinWidthJN0ABg$default;
            }
            long jM598tryMaxHeightJN0ABg = m598tryMaxHeightJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM598tryMaxHeightJN0ABg, companion.m7020getZeroYbymL2g())) {
                return jM598tryMaxHeightJN0ABg;
            }
            long jM600tryMaxWidthJN0ABg = m600tryMaxWidthJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM600tryMaxWidthJN0ABg, companion.m7020getZeroYbymL2g())) {
                return jM600tryMaxWidthJN0ABg;
            }
            long jM602tryMinHeightJN0ABg = m602tryMinHeightJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM602tryMinHeightJN0ABg, companion.m7020getZeroYbymL2g())) {
                return jM602tryMinHeightJN0ABg;
            }
            long jM604tryMinWidthJN0ABg = m604tryMinWidthJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM604tryMinWidthJN0ABg, companion.m7020getZeroYbymL2g())) {
                return jM604tryMinWidthJN0ABg;
            }
        } else {
            long jM601tryMaxWidthJN0ABg$default2 = m601tryMaxWidthJN0ABg$default(this, j5, false, 1, null);
            IntSize.Companion companion2 = IntSize.INSTANCE;
            if (!IntSize.m7013equalsimpl0(jM601tryMaxWidthJN0ABg$default2, companion2.m7020getZeroYbymL2g())) {
                return jM601tryMaxWidthJN0ABg$default2;
            }
            long jM599tryMaxHeightJN0ABg$default2 = m599tryMaxHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM599tryMaxHeightJN0ABg$default2, companion2.m7020getZeroYbymL2g())) {
                return jM599tryMaxHeightJN0ABg$default2;
            }
            long jM605tryMinWidthJN0ABg$default2 = m605tryMinWidthJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM605tryMinWidthJN0ABg$default2, companion2.m7020getZeroYbymL2g())) {
                return jM605tryMinWidthJN0ABg$default2;
            }
            long jM603tryMinHeightJN0ABg$default2 = m603tryMinHeightJN0ABg$default(this, j5, false, 1, null);
            if (!IntSize.m7013equalsimpl0(jM603tryMinHeightJN0ABg$default2, companion2.m7020getZeroYbymL2g())) {
                return jM603tryMinHeightJN0ABg$default2;
            }
            long jM600tryMaxWidthJN0ABg2 = m600tryMaxWidthJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM600tryMaxWidthJN0ABg2, companion2.m7020getZeroYbymL2g())) {
                return jM600tryMaxWidthJN0ABg2;
            }
            long jM598tryMaxHeightJN0ABg2 = m598tryMaxHeightJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM598tryMaxHeightJN0ABg2, companion2.m7020getZeroYbymL2g())) {
                return jM598tryMaxHeightJN0ABg2;
            }
            long jM604tryMinWidthJN0ABg2 = m604tryMinWidthJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM604tryMinWidthJN0ABg2, companion2.m7020getZeroYbymL2g())) {
                return jM604tryMinWidthJN0ABg2;
            }
            long jM602tryMinHeightJN0ABg2 = m602tryMinHeightJN0ABg(j5, false);
            if (!IntSize.m7013equalsimpl0(jM602tryMinHeightJN0ABg2, companion2.m7020getZeroYbymL2g())) {
                return jM602tryMinHeightJN0ABg2;
            }
        }
        return IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg, reason: not valid java name */
    private final long m598tryMaxHeightJN0ABg(long j5, boolean z10) {
        int iRound;
        int iM6796getMaxHeightimpl = Constraints.m6796getMaxHeightimpl(j5);
        if (iM6796getMaxHeightimpl != Integer.MAX_VALUE && (iRound = Math.round(iM6796getMaxHeightimpl * this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM6796getMaxHeightimpl);
            if (!z10 || ConstraintsKt.m6815isSatisfiedBy4WqzIAM(j5, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    /* renamed from: tryMaxHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m599tryMaxHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return aspectRatioNode.m598tryMaxHeightJN0ABg(j5, z10);
    }

    /* renamed from: tryMaxWidth-JN-0ABg, reason: not valid java name */
    private final long m600tryMaxWidthJN0ABg(long j5, boolean z10) {
        int iRound;
        int iM6797getMaxWidthimpl = Constraints.m6797getMaxWidthimpl(j5);
        if (iM6797getMaxWidthimpl != Integer.MAX_VALUE && (iRound = Math.round(iM6797getMaxWidthimpl / this.aspectRatio)) > 0) {
            long jIntSize = IntSizeKt.IntSize(iM6797getMaxWidthimpl, iRound);
            if (!z10 || ConstraintsKt.m6815isSatisfiedBy4WqzIAM(j5, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m601tryMaxWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return aspectRatioNode.m600tryMaxWidthJN0ABg(j5, z10);
    }

    /* renamed from: tryMinHeight-JN-0ABg, reason: not valid java name */
    private final long m602tryMinHeightJN0ABg(long j5, boolean z10) {
        int iM6798getMinHeightimpl = Constraints.m6798getMinHeightimpl(j5);
        int iRound = Math.round(iM6798getMinHeightimpl * this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iRound, iM6798getMinHeightimpl);
            if (!z10 || ConstraintsKt.m6815isSatisfiedBy4WqzIAM(j5, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    /* renamed from: tryMinHeight-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m603tryMinHeightJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return aspectRatioNode.m602tryMinHeightJN0ABg(j5, z10);
    }

    /* renamed from: tryMinWidth-JN-0ABg, reason: not valid java name */
    private final long m604tryMinWidthJN0ABg(long j5, boolean z10) {
        int iM6799getMinWidthimpl = Constraints.m6799getMinWidthimpl(j5);
        int iRound = Math.round(iM6799getMinWidthimpl / this.aspectRatio);
        if (iRound > 0) {
            long jIntSize = IntSizeKt.IntSize(iM6799getMinWidthimpl, iRound);
            if (!z10 || ConstraintsKt.m6815isSatisfiedBy4WqzIAM(j5, jIntSize)) {
                return jIntSize;
            }
        }
        return IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    /* renamed from: tryMinWidth-JN-0ABg$default, reason: not valid java name */
    public static /* synthetic */ long m605tryMinWidthJN0ABg$default(AspectRatioNode aspectRatioNode, long j5, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = true;
        }
        return aspectRatioNode.m604tryMinWidthJN0ABg(j5, z10);
    }

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo89measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j5) {
        long jM597findSizeToXhtMw = m597findSizeToXhtMw(j5);
        if (!IntSize.m7013equalsimpl0(jM597findSizeToXhtMw, IntSize.INSTANCE.m7020getZeroYbymL2g())) {
            j5 = Constraints.INSTANCE.m6807fixedJhjzzOo(IntSize.m7015getWidthimpl(jM597findSizeToXhtMw), IntSize.m7014getHeightimpl(jM597findSizeToXhtMw));
        }
        final Placeable placeableMo5549measureBRTryo0 = measurable.mo5549measureBRTryo0(j5);
        return MeasureScope.layout$default(measureScope, placeableMo5549measureBRTryo0.getWidth(), placeableMo5549measureBRTryo0.getHeight(), null, new k() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
        return i != Integer.MAX_VALUE ? Math.round(i / this.aspectRatio) : intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return i != Integer.MAX_VALUE ? Math.round(i * this.aspectRatio) : intrinsicMeasurable.minIntrinsicWidth(i);
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final void setMatchHeightConstraintsFirst(boolean z10) {
        this.matchHeightConstraintsFirst = z10;
    }
}
