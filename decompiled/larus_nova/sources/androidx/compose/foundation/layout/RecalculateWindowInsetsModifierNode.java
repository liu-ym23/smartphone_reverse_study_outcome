package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocal;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010(\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u001c\u0010*\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010+\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "<init>", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "oldPosition", "Landroidx/compose/ui/unit/IntOffset;", "getOldPosition-nOcc-ac", "()J", "setOldPosition--gyyYBs", "(J)V", "J", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RecalculateWindowInsetsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutModifierNode, GlobalPositionAwareModifierNode {
    private final ValueInsets insets;
    private long oldPosition;
    private final ModifierLocalMap providedValues;

    public static /* synthetic */ Unit a(Placeable r100, Placeable.PlacementScope r101) {
        return measure_3p2s80s$lambda$0(r100, r101);
    }

    public static /* synthetic */ Unit b(RecalculateWindowInsetsModifierNode r100, Measurable r101, int r102, int r103, Placeable.PlacementScope r104) {
        return measure_3p2s80s$lambda$2(r100, r101, r102, r103, r104);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode, androidx.compose.ui.modifier.ModifierLocalReadScope
    public final /* synthetic */ Object getCurrent(ModifierLocal r100) {
        return ModifierLocalModifierNode.CC.$default$getCurrent(this, r100);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public final /* synthetic */ void provide(ModifierLocal r100, Object r101) {
        ModifierLocalModifierNode.CC.$default$provide(this, r100, r101);
    }

    public RecalculateWindowInsetsModifierNode() {
        ValueInsets r100 = new ValueInsets(new InsetsValues(0, 0, 0, 0), BasicTestActionHandler.TEST_ACTION_RESET);
        this.insets = r100;
        this.oldPosition = IntOffset.Companion.m7687getZeronOccac();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), r100));
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    /* JADX INFO: renamed from: getOldPosition-nOcc-ac, reason: not valid java name */
    public final long m756getOldPositionnOccac() {
        return this.oldPosition;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates r100) {
        long r101 = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(r100));
        boolean r102 = !IntOffset.m7675equalsimpl0(this.oldPosition, r101);
        this.oldPosition = r101;
        if (r102 == false) goto L6;
        LayoutModifierNodeKt.invalidatePlacement(this);
        return;
    }

    /* JADX INFO: renamed from: setOldPosition--gyyYBs, reason: not valid java name */
    public final void m757setOldPositiongyyYBs(long r100) {
        this.oldPosition = r100;
    }

    private static final Unit measure_3p2s80s$lambda$0(Placeable r100, Placeable.PlacementScope r101) {
        Placeable.PlacementScope.place$default(r101, r100, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return r101.maxIntrinsicHeight(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return r101.maxIntrinsicWidth(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo61measure3p2s80s(MeasureScope r100, final Measurable r110, long r111) {
        if (Constraints.m7485getHasFixedWidthimpl(r111) == true) goto L5;
    L8:
        ModifierLocalModifierNode.CC.$default$provide(this, WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), ModifierLocalModifierNode.CC.$default$getCurrent(this, WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets()));
        final Placeable r112 = r110.mo6256measureBRTryo0(r111);
        return MeasureScope.CC.layout$default(r100, r112.getWidth(), r112.getHeight(), null, new u1(r112), 4, null);
    L5:
        if (Constraints.m7484getHasFixedHeightimpl(r111) == false) goto L8;
        final int r101 = Constraints.m7487getMaxWidthimpl(r111);
        final int r102 = Constraints.m7486getMaxHeightimpl(r111);
        return MeasureScope.CC.layout$default(r100, r101, r102, null, new v1(this, r110, r101, r102), 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return r101.minIntrinsicHeight(r102);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope r100, IntrinsicMeasurable r101, int r102) {
        return r101.minIntrinsicWidth(r102);
    }

    private static final Unit measure_3p2s80s$lambda$2(RecalculateWindowInsetsModifierNode r110, Measurable r111, int r112, int r113, Placeable.PlacementScope r114) {
        LayoutCoordinates r100 = r114.getCoordinates();
        if (r100 == null) goto L5;
        r110.oldPosition = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(r100));
    L5:
        if (r100 != null) goto L7;
        ProvidableModifierLocal<WindowInsets> r101 = WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
        r110.getClass();
        Object r102 = (WindowInsets) ModifierLocalModifierNode.CC.$default$getCurrent(r110, r101);
    L17:
        ProvidableModifierLocal<WindowInsets> r103 = WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
        r110.getClass();
        ModifierLocalModifierNode.CC.$default$provide(r110, r103, r102);
        Placeable.PlacementScope.place$default(r114, r111.mo6256measureBRTryo0(Constraints.Companion.m7497fixedJhjzzOo(r112, r113)), 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    L7:
        long r104 = LayoutCoordinatesKt.positionInRoot(r100);
        long r105 = r100.mo6258getSizeYbymL2g();
        float r106 = (int) (r105 >> 32);
        float r107 = (int) (r105 & BodyPartID.bodyIdMax);
        long r115 = Float.floatToRawIntBits(r106);
        long r108 = r100.mo6261localToRootMKHz9U(Offset.m4574constructorimpl((((long) Float.floatToRawIntBits(r107)) & BodyPartID.bodyIdMax) | (r115 << 32)));
        long r116 = LayoutCoordinatesKt.findRootCoordinates(r100).mo6258getSizeYbymL2g();
        int r109 = Math.round(Float.intBitsToFloat((int) (r104 >> 32)));
        int r117 = Math.round(Float.intBitsToFloat((int) (r104 & BodyPartID.bodyIdMax)));
        int r118 = ((int) (r116 >> 32)) - Math.round(Float.intBitsToFloat((int) (r108 >> 32)));
        int r119 = ((int) (r116 & BodyPartID.bodyIdMax)) - Math.round(Float.intBitsToFloat((int) (r108 & BodyPartID.bodyIdMax)));
        InsetsValues r120 = r110.insets.getValue$foundation_layout();
        if (r120.getLeft() == r109) goto L10;
    L15:
        r110.insets.setValue$foundation_layout(new InsetsValues(r109, r117, r118, r119));
    L16:
        r102 = r110.insets;
        goto L17
    L10:
        if (r120.getTop() != r117) goto L15;
        if (r120.getRight() != r118) goto L15;
        if (r120.getBottom() == r119) goto L16;
        goto L15
    }
}
