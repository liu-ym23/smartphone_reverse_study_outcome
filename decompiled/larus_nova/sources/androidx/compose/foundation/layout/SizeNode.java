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
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001cH\u0016¢\u0006\u0004\b&\u0010'J\u001c\u0010(\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u0010-\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016J\u001c\u0010/\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010,\u001a\u00020)H\u0016J\u001c\u00100\u001a\u00020)*\u00020*2\u0006\u0010#\u001a\u00020+2\u0006\u0010.\u001a\u00020)H\u0016R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001b\u001a\u00020\u001c*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u00061"}, d2 = {"Landroidx/compose/foundation/layout/SizeNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinWidth-D9Ej5fM", "()F", "setMinWidth-0680j_4", "(F)V", FaceService.girlLabel, "getMinHeight-D9Ej5fM", "setMinHeight-0680j_4", "getMaxWidth-D9Ej5fM", "setMaxWidth-0680j_4", "getMaxHeight-D9Ej5fM", "setMaxHeight-0680j_4", "getEnforceIncoming", "()Z", "setEnforceIncoming", "(Z)V", "targetConstraints", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/unit/Density;", "getTargetConstraints-OenEA2s", "(Landroidx/compose/ui/unit/Density;)J", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicWidth", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "height", "minIntrinsicHeight", "width", "maxIntrinsicWidth", "maxIntrinsicHeight", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SizeNode extends Modifier.Node implements LayoutModifierNode {
    private boolean enforceIncoming;
    private float maxHeight;
    private float maxWidth;
    private float minHeight;
    private float minWidth;

    public /* synthetic */ SizeNode(float r100, float r101, float r102, float r103, boolean r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit a(Placeable r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$3(r100, r101);
    }

    public final boolean getEnforceIncoming() {
        return this.enforceIncoming;
    }

    /* JADX INFO: renamed from: getMaxHeight-D9Ej5fM, reason: not valid java name */
    public final float m787getMaxHeightD9Ej5fM() {
        return this.maxHeight;
    }

    /* JADX INFO: renamed from: getMaxWidth-D9Ej5fM, reason: not valid java name */
    public final float m788getMaxWidthD9Ej5fM() {
        return this.maxWidth;
    }

    /* JADX INFO: renamed from: getMinHeight-D9Ej5fM, reason: not valid java name */
    public final float m789getMinHeightD9Ej5fM() {
        return this.minHeight;
    }

    /* JADX INFO: renamed from: getMinWidth-D9Ej5fM, reason: not valid java name */
    public final float m790getMinWidthD9Ej5fM() {
        return this.minWidth;
    }

    /* JADX INFO: renamed from: getTargetConstraints-OenEA2s, reason: not valid java name */
    private final long m786getTargetConstraintsOenEA2s(Density r100) {
        int r101 = 0;
        if ((!Float.isNaN(this.maxWidth)) == false) goto L7;
        int r102 = r100.mo365roundToPx0680j_4(this.maxWidth);
        if (r102 >= 0) goto L9;
        r102 = 0;
    L9:
        if ((!Float.isNaN(this.maxHeight)) == false) goto L13;
        int r103 = r100.mo365roundToPx0680j_4(this.maxHeight);
        if (r103 >= 0) goto L15;
        r103 = 0;
    L15:
        if ((!Float.isNaN(this.minWidth)) == false) goto L23;
        int r104 = r100.mo365roundToPx0680j_4(this.minWidth);
        if (r104 >= 0) goto L19;
        r104 = 0;
    L19:
        if (r104 <= r102) goto L21;
        r104 = r102;
    L21:
        if (r104 == Integer.MAX_VALUE) goto L23;
    L25:
        if ((!Float.isNaN(this.minHeight)) == false) goto L34;
        int r105 = r100.mo365roundToPx0680j_4(this.minHeight);
        if (r105 >= 0) goto L29;
        r105 = 0;
    L29:
        if (r105 <= r103) goto L31;
        r105 = r103;
    L31:
        if (r105 == Integer.MAX_VALUE) goto L34;
        r101 = r105;
    L34:
        return ConstraintsKt.Constraints(r104, r102, r101, r103);
    L23:
        r104 = 0;
        goto L25
    L13:
        r103 = Integer.MAX_VALUE;
        goto L15
    L7:
        r102 = Integer.MAX_VALUE;
        goto L9
    }

    public final void setEnforceIncoming(boolean r100) {
        this.enforceIncoming = r100;
    }

    /* JADX INFO: renamed from: setMaxHeight-0680j_4, reason: not valid java name */
    public final void m791setMaxHeight0680j_4(float r100) {
        this.maxHeight = r100;
    }

    /* JADX INFO: renamed from: setMaxWidth-0680j_4, reason: not valid java name */
    public final void m792setMaxWidth0680j_4(float r100) {
        this.maxWidth = r100;
    }

    /* JADX INFO: renamed from: setMinHeight-0680j_4, reason: not valid java name */
    public final void m793setMinHeight0680j_4(float r100) {
        this.minHeight = r100;
    }

    /* JADX INFO: renamed from: setMinWidth-0680j_4, reason: not valid java name */
    public final void m794setMinWidth0680j_4(float r100) {
        this.minWidth = r100;
    }

    private static final Unit measure_3p2s80s$lambda$3(Placeable r100, Placeable.PlacementScope r101) {
        Placeable.PlacementScope.placeRelative$default(r101, r100, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        long r103 = m786getTargetConstraintsOenEA2s(r100);
        if (Constraints.m7484getHasFixedHeightimpl(r103) == false) goto L6;
        return Constraints.m7486getMaxHeightimpl(r103);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r102 = ConstraintsKt.m7504constrainWidthK40F9xA(r103, r102);
    L10:
        return ConstraintsKt.m7503constrainHeightK40F9xA(r103, r101.maxIntrinsicHeight(r102));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        long r103 = m786getTargetConstraintsOenEA2s(r100);
        if (Constraints.m7485getHasFixedWidthimpl(r103) == false) goto L6;
        return Constraints.m7487getMaxWidthimpl(r103);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r102 = ConstraintsKt.m7503constrainHeightK40F9xA(r103, r102);
    L10:
        return ConstraintsKt.m7504constrainWidthK40F9xA(r103, r101.maxIntrinsicWidth(r102));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r110) {
        long r102 = m786getTargetConstraintsOenEA2s(r100);
        if (this.enforceIncoming == false) goto L6;
        long r111 = ConstraintsKt.m7502constrainN9IONVI(r110, r102);
    L30:
        final Placeable r103 = r101.mo6256measureBRTryo0(r111);
        return MeasureScope.CC.layout$default(r100, r103.getWidth(), r103.getHeight(), null, new d2(r103), 4, null);
    L6:
        if ((!Float.isNaN(this.minWidth)) == false) goto L8;
        int r104 = Constraints.m7489getMinWidthimpl(r102);
    L12:
        if ((!Float.isNaN(this.maxWidth)) == false) goto L14;
        int r105 = Constraints.m7487getMaxWidthimpl(r102);
    L18:
        if ((!Float.isNaN(this.minHeight)) == false) goto L20;
        int r106 = Constraints.m7488getMinHeightimpl(r102);
    L24:
        if ((!Float.isNaN(this.maxHeight)) == false) goto L26;
        int r112 = Constraints.m7486getMaxHeightimpl(r102);
    L29:
        r111 = ConstraintsKt.Constraints(r104, r105, r106, r112);
        goto L30
    L26:
        r112 = Constraints.m7486getMaxHeightimpl(r110);
        int r113 = Constraints.m7488getMinHeightimpl(r102);
        if (r112 >= r113) goto L29;
        r112 = r113;
        goto L29
    L20:
        r106 = Constraints.m7488getMinHeightimpl(r110);
        int r107 = Constraints.m7486getMaxHeightimpl(r102);
        if (r106 <= r107) goto L24;
        r106 = r107;
        goto L24
    L14:
        r105 = Constraints.m7487getMaxWidthimpl(r110);
        int r108 = Constraints.m7489getMinWidthimpl(r102);
        if (r105 >= r108) goto L18;
        r105 = r108;
        goto L18
    L8:
        r104 = Constraints.m7489getMinWidthimpl(r110);
        int r109 = Constraints.m7487getMaxWidthimpl(r102);
        if (r104 <= r109) goto L12;
        r104 = r109;
        goto L12
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        long r103 = m786getTargetConstraintsOenEA2s(r100);
        if (Constraints.m7484getHasFixedHeightimpl(r103) == false) goto L6;
        return Constraints.m7486getMaxHeightimpl(r103);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r102 = ConstraintsKt.m7504constrainWidthK40F9xA(r103, r102);
    L10:
        return ConstraintsKt.m7503constrainHeightK40F9xA(r103, r101.minIntrinsicHeight(r102));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        long r103 = m786getTargetConstraintsOenEA2s(r100);
        if (Constraints.m7485getHasFixedWidthimpl(r103) == false) goto L6;
        return Constraints.m7487getMaxWidthimpl(r103);
    L6:
        if (this.enforceIncoming == true) goto L10;
        r102 = ConstraintsKt.m7503constrainHeightK40F9xA(r103, r102);
    L10:
        return ConstraintsKt.m7504constrainWidthK40F9xA(r103, r101.minIntrinsicWidth(r102));
    }

    private SizeNode(float r100, float r101, float r102, float r103, boolean r104) {
        this.minWidth = r100;
        this.minHeight = r101;
        this.maxWidth = r102;
        this.maxHeight = r103;
        this.enforceIncoming = r104;
    }

    public /* synthetic */ SizeNode(float r100, float r101, float r110, float r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        if ((r113 & 1) == 0) goto L5;
        r100 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L5:
        float r102 = r100;
        if ((r113 & 2) == 0) goto L8;
        r101 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L8:
        float r103 = r101;
        if ((r113 & 4) == 0) goto L11;
        r110 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L11:
        float r104 = r110;
        if ((r113 & 8) == 0) goto L14;
        r111 = Dp.Companion.m7564getUnspecifiedD9Ej5fM();
    L14:
        this(r102, r103, r104, r111, r112, null);
    }
}
