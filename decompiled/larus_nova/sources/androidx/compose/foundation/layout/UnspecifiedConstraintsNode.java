package androidx.compose.foundation.layout;

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
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000f\u001a\u00020\u0010*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001d\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0016J\u001c\u0010\u001e\u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016J\u001c\u0010 \u001a\u00020\u0019*\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u0019H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000b¨\u0006!"}, d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "<init>", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", FaceService.girlLabel, "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {
    private float minHeight;
    private float minWidth;

    public /* synthetic */ UnspecifiedConstraintsNode(float r100, float r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    public static /* synthetic */ Unit a(Placeable r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$0(r100, r101);
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m797getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m798getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m799setMinHeight0680j_4(float r100) {
        this.minHeight = r100;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m800setMinWidth0680j_4(float r100) {
        this.minWidth = r100;
    }

    private UnspecifiedConstraintsNode(float r100, float r101) {
        this.minWidth = r100;
        this.minHeight = r101;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r100, Placeable.PlacementScope r101) {
        Placeable.PlacementScope.placeRelative$default(r101, r100, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        int r103 = r101.maxIntrinsicHeight(r102);
        if ((!Float.isNaN(this.minHeight)) == false) goto L5;
        int r104 = r100.mo365roundToPx0680j_4(this.minHeight);
    L6:
        if (r103 < r104) goto L8;
        return r103;
    L8:
        return r104;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        int r103 = r101.maxIntrinsicWidth(r102);
        if ((!Float.isNaN(this.minWidth)) == false) goto L5;
        int r104 = r100.mo365roundToPx0680j_4(this.minWidth);
    L6:
        if (r103 < r104) goto L8;
        return r103;
    L8:
        return r104;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r110) {
        int r102 = 0;
        if ((!Float.isNaN(this.minWidth)) == true) goto L5;
    L12:
        int r103 = Constraints.m7489getMinWidthimpl(r110);
    L13:
        int r104 = Constraints.m7487getMaxWidthimpl(r110);
        if ((!Float.isNaN(this.minHeight)) == true) goto L16;
    L24:
        int r105 = Constraints.m7488getMinHeightimpl(r110);
    L25:
        final Placeable r106 = r101.mo6256measureBRTryo0(ConstraintsKt.Constraints(r103, r104, r105, Constraints.m7486getMaxHeightimpl(r110)));
        return MeasureScope.CC.layout$default(r100, r106.getWidth(), r106.getHeight(), null, new f2(r106), 4, null);
    L16:
        if (Constraints.m7488getMinHeightimpl(r110) != 0) goto L24;
        int r107 = r100.mo365roundToPx0680j_4(this.minHeight);
        r105 = Constraints.m7486getMaxHeightimpl(r110);
        if (r107 < 0) goto L21;
        r102 = r107;
    L21:
        if (r102 > r105) goto L25;
        r105 = r102;
        goto L25
    L5:
        if (Constraints.m7489getMinWidthimpl(r110) != 0) goto L12;
        int r108 = r100.mo365roundToPx0680j_4(this.minWidth);
        r103 = Constraints.m7487getMaxWidthimpl(r110);
        if (r108 >= 0) goto L9;
        r108 = 0;
    L9:
        if (r108 > r103) goto L13;
        r103 = r108;
        goto L13
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        int r103 = r101.minIntrinsicHeight(r102);
        if ((!Float.isNaN(this.minHeight)) == false) goto L5;
        int r104 = r100.mo365roundToPx0680j_4(this.minHeight);
    L6:
        if (r103 < r104) goto L8;
        return r103;
    L8:
        return r104;
    L5:
        r104 = 0;
        goto L6
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        int r103 = r101.minIntrinsicWidth(r102);
        if ((!Float.isNaN(this.minWidth)) == false) goto L5;
        int r104 = r100.mo365roundToPx0680j_4(this.minWidth);
    L6:
        if (r103 < r104) goto L8;
        return r103;
    L8:
        return r104;
    L5:
        r104 = 0;
        goto L6
    }

    public /* synthetic */ UnspecifiedConstraintsNode(float r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L8:
        this(r100, r101, null);
    }
}
