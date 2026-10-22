package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0006\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/PaddingNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "rtlAware", "", "<init>", "(FFFFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getStart-D9Ej5fM", "()F", "setStart-0680j_4", "(F)V", FaceService.girlLabel, "getTop-D9Ej5fM", "setTop-0680j_4", "getEnd-D9Ej5fM", "setEnd-0680j_4", "getBottom-D9Ej5fM", "setBottom-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class PaddingNode extends Modifier.Node implements LayoutModifierNode {
    private float bottom;
    private float end;
    private boolean rtlAware;
    private float start;
    private float top;

    public /* synthetic */ PaddingNode(float r100, float r101, float r102, float r103, boolean r104, DefaultConstructorMarker r105) {
        this(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit a(PaddingNode r100, Placeable r101, Placeable.PlacementScope r102) {
        return measure_3p2s80s$lambda$0(r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$maxIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$maxIntrinsicWidth(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$minIntrinsicHeight(this, r100, r101, r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public final /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return LayoutModifierNode.CC.$default$minIntrinsicWidth(this, r100, r101, r102);
    }

    /* JADX INFO: renamed from: getBottom-D9Ej5fM, reason: not valid java name */
    public final float m736getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* JADX INFO: renamed from: getEnd-D9Ej5fM, reason: not valid java name */
    public final float m737getEndD9Ej5fM() {
        return this.end;
    }

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    /* JADX INFO: renamed from: getStart-D9Ej5fM, reason: not valid java name */
    public final float m738getStartD9Ej5fM() {
        return this.start;
    }

    /* JADX INFO: renamed from: getTop-D9Ej5fM, reason: not valid java name */
    public final float m739getTopD9Ej5fM() {
        return this.top;
    }

    /* JADX INFO: renamed from: setBottom-0680j_4, reason: not valid java name */
    public final void m740setBottom0680j_4(float r100) {
        this.bottom = r100;
    }

    /* JADX INFO: renamed from: setEnd-0680j_4, reason: not valid java name */
    public final void m741setEnd0680j_4(float r100) {
        this.end = r100;
    }

    public final void setRtlAware(boolean r100) {
        this.rtlAware = r100;
    }

    /* JADX INFO: renamed from: setStart-0680j_4, reason: not valid java name */
    public final void m742setStart0680j_4(float r100) {
        this.start = r100;
    }

    /* JADX INFO: renamed from: setTop-0680j_4, reason: not valid java name */
    public final void m743setTop0680j_4(float r100) {
        this.top = r100;
    }

    private static final Unit measure_3p2s80s$lambda$0(PaddingNode r100, Placeable r101, Placeable.PlacementScope r110) {
        if (r100.rtlAware == false) goto L5;
        Placeable.PlacementScope.placeRelative$default(r110, r101, r110.mo365roundToPx0680j_4(r100.start), r110.mo365roundToPx0680j_4(r100.top), 0.0f, 4, null);
    L7:
        return Unit.INSTANCE;
    L5:
        Placeable.PlacementScope.place$default(r110, r101, r110.mo365roundToPx0680j_4(r100.start), r110.mo365roundToPx0680j_4(r100.top), 0.0f, 4, null);
        goto L7
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r110, Measurable r111, long r112) {
        int r100 = r110.mo365roundToPx0680j_4(this.start) + r110.mo365roundToPx0680j_4(this.end);
        int r101 = r110.mo365roundToPx0680j_4(this.top) + r110.mo365roundToPx0680j_4(this.bottom);
        final Placeable r113 = r111.mo6256measureBRTryo0(ConstraintsKt.m7506offsetNN6EwU(r112, -r100, -r101));
        return MeasureScope.CC.layout$default(r110, ConstraintsKt.m7504constrainWidthK40F9xA(r112, r113.getWidth() + r100), ConstraintsKt.m7503constrainHeightK40F9xA(r112, r113.getHeight() + r101), null, new s1(this, r113), 4, null);
    }

    private PaddingNode(float r100, float r101, float r102, float r103, boolean r104) {
        this.start = r100;
        this.top = r101;
        this.end = r102;
        this.bottom = r103;
        this.rtlAware = r104;
    }

    public /* synthetic */ PaddingNode(float r100, float r110, float r111, float r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        if ((r114 & 1) == 0) goto L5;
        r100 = Dp.m7544constructorimpl(0);
    L5:
        float r101 = r100;
        if ((r114 & 2) == 0) goto L8;
        r110 = Dp.m7544constructorimpl(0);
    L8:
        float r102 = r110;
        if ((r114 & 4) == 0) goto L11;
        r111 = Dp.m7544constructorimpl(0);
    L11:
        float r103 = r111;
        if ((r114 & 8) == 0) goto L14;
        r112 = Dp.m7544constructorimpl(0);
    L14:
        this(r101, r102, r103, r112, r113, null);
    }
}
