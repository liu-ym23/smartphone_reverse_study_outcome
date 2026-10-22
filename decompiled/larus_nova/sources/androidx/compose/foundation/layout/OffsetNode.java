package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Dp;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ%\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u001c*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001c\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0007X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012¨\u0006$"}, d2 = {"Landroidx/compose/foundation/layout/OffsetNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "<init>", "(FFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getX-D9Ej5fM", "()F", "setX-0680j_4", "(F)V", FaceService.girlLabel, "getY-D9Ej5fM", "setY-0680j_4", "getRtlAware", "()Z", "setRtlAware", "(Z)V", "shouldAutoInvalidate", "getShouldAutoInvalidate", "update", "", "update-Md-fbLM", "(FFZ)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OffsetNode extends Modifier.Node implements LayoutModifierNode {
    private boolean rtlAware;
    private final boolean shouldAutoInvalidate;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f5977x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f5978y;

    public /* synthetic */ OffsetNode(float r100, float r101, boolean r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public static /* synthetic */ Unit a(OffsetNode r100, Placeable r101, Placeable.PlacementScope r102) {
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

    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    /* JADX INFO: renamed from: getX-D9Ej5fM, reason: not valid java name */
    public final float m692getXD9Ej5fM() {
        return this.f5977x;
    }

    /* JADX INFO: renamed from: getY-D9Ej5fM, reason: not valid java name */
    public final float m693getYD9Ej5fM() {
        return this.f5978y;
    }

    public final void setRtlAware(boolean r100) {
        this.rtlAware = r100;
    }

    /* JADX INFO: renamed from: setX-0680j_4, reason: not valid java name */
    public final void m694setX0680j_4(float r100) {
        this.f5977x = r100;
    }

    /* JADX INFO: renamed from: setY-0680j_4, reason: not valid java name */
    public final void m695setY0680j_4(float r100) {
        this.f5978y = r100;
    }

    private OffsetNode(float r100, float r101, boolean r102) {
        this.f5977x = r100;
        this.f5978y = r101;
        this.rtlAware = r102;
    }

    private static final Unit measure_3p2s80s$lambda$0(OffsetNode r100, Placeable r101, Placeable.PlacementScope r110) {
        if (r100.rtlAware == false) goto L5;
        Placeable.PlacementScope.placeRelative$default(r110, r101, r110.mo365roundToPx0680j_4(r100.f5977x), r110.mo365roundToPx0680j_4(r100.f5978y), 0.0f, 4, null);
    L7:
        return Unit.INSTANCE;
    L5:
        Placeable.PlacementScope.place$default(r110, r101, r110.mo365roundToPx0680j_4(r100.f5977x), r110.mo365roundToPx0680j_4(r100.f5978y), 0.0f, 4, null);
        goto L7
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, Measurable r101, long r110) {
        final Placeable r102 = r101.mo6256measureBRTryo0(r110);
        return MeasureScope.CC.layout$default(r100, r102.getWidth(), r102.getHeight(), null, new l1(this, r102), 4, null);
    }

    /* JADX INFO: renamed from: update-Md-fbLM, reason: not valid java name */
    public final void m696updateMdfbLM(float r100, float r101, boolean r102) {
        if (Dp.m7549equalsimpl0(this.f5977x, r100) == true) goto L5;
    L8:
        LayoutModifierNodeKt.invalidatePlacement(this);
    L9:
        this.f5977x = r100;
        this.f5978y = r101;
        this.rtlAware = r102;
        return;
    L5:
        if (Dp.m7549equalsimpl0(this.f5978y, r101) == false) goto L8;
        if (this.rtlAware == r102) goto L9;
        goto L8
    }
}
