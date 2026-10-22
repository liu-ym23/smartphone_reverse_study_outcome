package androidx.compose.ui.node;

import C7.r;
import S7.a;
import S7.k;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Map;
import kotlin.Metadata;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000 \u0081\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0082\u0001\u0081\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\bH ¢\u0006\u0004\b\u0011\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\b*\u00020\u0013H\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ]\u0010)\u001a\u00020(2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\r2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\r0!2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b\u0018\u00010#2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\b0#H\u0016¢\u0006\u0004\b)\u0010*J\u0019\u0010.\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0004\b,\u0010-J\u001d\u00100\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0018¢\u0006\u0004\b0\u00101J\u001d\u00102\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u0018¢\u0006\u0004\b2\u00101J\u001f\u00105\u001a\u00020\b2\u0006\u00104\u001a\u0002032\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b7\u00108J\u001b\u0010:\u001a\u00020\u0006*\u0002032\u0006\u00109\u001a\u000203H\u0002¢\u0006\u0004\b:\u0010;J+\u0010D\u001a\u00020\b2\u0006\u0010=\u001a\u00020<2\b\b\u0002\u0010?\u001a\u00020>2\b\b\u0002\u0010A\u001a\u00020@H\u0002¢\u0006\u0004\bB\u0010CJ\u0017\u0010.\u001a\u00020\b2\u0006\u0010=\u001a\u00020<H\u0002¢\u0006\u0004\b.\u0010EJ#\u0010I\u001a\u00020\b2\u0012\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030G0FH\u0002¢\u0006\u0004\bI\u0010JR\u001c\u0010L\u001a\b\u0018\u00010KR\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR$\u0010N\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\"\u0010R\u001a\u00020\u00068\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bR\u0010T\"\u0004\bU\u0010\nR\"\u0010V\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bV\u0010S\u001a\u0004\bW\u0010T\"\u0004\bX\u0010\nR\"\u0010Y\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bY\u0010S\u001a\u0004\bZ\u0010T\"\u0004\b[\u0010\nR\u0017\u0010\\\u001a\u00020&8\u0006¢\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0018\u0010a\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR0\u0010d\u001a\u001c\u0012\u0004\u0012\u00020\u0016\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002030G0F\u0018\u00010c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010h\u001a\u00020>8&X¦\u0004¢\u0006\u0006\u001a\u0004\bf\u0010gR\u0016\u0010k\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010jR\u0016\u0010m\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bl\u0010jR\u0014\u0010o\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\bn\u0010TR\u0014\u00104\u001a\u0002038&X¦\u0004¢\u0006\u0006\u001a\u0004\bp\u0010qR\u0014\u0010u\u001a\u00020r8&X¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020(8 X \u0004¢\u0006\u0006\u001a\u0004\bv\u0010wR\u0014\u0010|\u001a\u00020y8&X¦\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b}\u0010TR\u0019\u0010\u0080\u0001\u001a\u00060KR\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007f¨\u0006\u0083\u0001"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", AppAgent.CONSTRUCT, "()V", "", "newMFR", "LC7/r;", "updatePlacedUnderMotionFrameOfReference", "(Z)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "calculateAlignmentLine", "replace$ui_release", "replace", "Landroidx/compose/ui/node/NodeCoordinator;", "invalidateAlignmentLinesFromPositionChange", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "Landroidx/compose/ui/layout/Ruler;", "ruler", "", "defaultValue", "findRulerValue", "(Landroidx/compose/ui/layout/Ruler;F)F", "invalidateChildrenOfDefiningRuler$ui_release", "(Landroidx/compose/ui/layout/Ruler;)V", "invalidateChildrenOfDefiningRuler", "width", "height", "", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;LS7/k;LS7/k;)Landroidx/compose/ui/layout/MeasureResult;", "result", "captureRulersIfNeeded$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "captureRulersIfNeeded", "value", "provideRulerValue", "(Landroidx/compose/ui/layout/Ruler;F)V", "provideRelativeRulerValue", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "addRulerReader", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/Ruler;)V", "findAncestorRulerDefiner", "(Landroidx/compose/ui/layout/Ruler;)Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "ancestor", "isLayoutNodeAncestor", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNode;)Z", "Landroidx/compose/ui/node/PlaceableResult;", "placeableResult", "Landroidx/compose/ui/unit/IntOffset;", "positionOnScreen", "Landroidx/compose/ui/unit/IntSize;", "size", "captureRulers-OSxE8f4", "(Landroidx/compose/ui/node/PlaceableResult;JJ)V", "captureRulers", "(Landroidx/compose/ui/node/PlaceableResult;)V", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "layoutNodes", "notifyRulerValueChange", "(Landroidx/collection/MutableScatterSet;)V", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "_rulerScope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulersLambda", "LS7/k;", "cachedRulerPlaceableResult", "Landroidx/compose/ui/node/PlaceableResult;", "isPlacedUnderMotionFrameOfReference", "Z", "()Z", "setPlacedUnderMotionFrameOfReference", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/node/RulerTrackingMap;", "rulerValues", "Landroidx/compose/ui/node/RulerTrackingMap;", "Landroidx/collection/MutableScatterMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "getPosition-nOcc-ac", "()J", "position", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "child", "getParent", "parent", "getHasMeasureResult", "hasMeasureResult", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "isLookingAhead", "getRulerScope", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulerScope", "Companion", "ResettableRulerScope", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    private static final k onCommitAffectingRuler = new k() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // S7.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((PlaceableResult) obj);
            return r.f317a;
        }

        public final void invoke(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulersIfNeeded(placeableResult);
            }
        }
    };
    private ResettableRulerScope _rulerScope;
    private PlaceableResult cachedRulerPlaceableResult;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private RulerTrackingMap rulerValues;
    private k rulersLambda;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\b\u001a\u00020\u0007*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0004¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u000b\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0004¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u0014\u0010\"\u001a\u00020\u001f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010%\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010$¨\u0006("}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "Landroidx/compose/ui/layout/RulerScope;", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "Landroidx/compose/ui/layout/Ruler;", "", "value", "LC7/r;", "provides", "(Landroidx/compose/ui/layout/Ruler;F)V", "Landroidx/compose/ui/layout/VerticalRuler;", "providesRelative", "(Landroidx/compose/ui/layout/VerticalRuler;F)V", "", "coordinatesAccessed", "Z", "getCoordinatesAccessed", "()Z", "setCoordinatesAccessed", "(Z)V", "Landroidx/compose/ui/unit/IntOffset;", "positionOnScreen", "J", "getPositionOnScreen-nOcc-ac", "()J", "setPositionOnScreen--gyyYBs", "(J)V", "Landroidx/compose/ui/unit/IntSize;", "size", "getSize-YbymL2g", "setSize-ozmzZPI", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getDensity", "()F", "density", "getFontScale", "fontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ResettableRulerScope implements RulerScope {
        private boolean coordinatesAccessed;
        private long positionOnScreen = IntOffset.INSTANCE.m6982getMaxnOccac();
        private long size = IntSize.INSTANCE.m7020getZeroYbymL2g();

        public ResettableRulerScope() {
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LayoutCoordinates coordinates = LookaheadCapablePlaceable.this.getCoordinates();
            if (IntOffset.m6971equalsimpl0(this.positionOnScreen, IntOffset.INSTANCE.m6982getMaxnOccac())) {
                this.positionOnScreen = IntOffsetKt.m6989roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(coordinates));
                this.size = coordinates.mo5557getSizeYbymL2g();
            }
            LookaheadCapablePlaceable.this.getLayoutNode().getLayoutDelegate().onCoordinatesUsed();
            return coordinates;
        }

        public final boolean getCoordinatesAccessed() {
            return this.coordinatesAccessed;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return LookaheadCapablePlaceable.this.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return LookaheadCapablePlaceable.this.getFontScale();
        }

        /* renamed from: getPositionOnScreen-nOcc-ac, reason: not valid java name and from getter */
        public final long getPositionOnScreen() {
            return this.positionOnScreen;
        }

        /* renamed from: getSize-YbymL2g, reason: not valid java name and from getter */
        public final long getSize() {
            return this.size;
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void provides(Ruler ruler, float f) {
            LookaheadCapablePlaceable.this.provideRulerValue(ruler, f);
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void providesRelative(VerticalRuler verticalRuler, float f) {
            LookaheadCapablePlaceable.this.provideRelativeRulerValue(verticalRuler, f);
        }

        public final void setCoordinatesAccessed(boolean z10) {
            this.coordinatesAccessed = z10;
        }

        /* renamed from: setPositionOnScreen--gyyYBs, reason: not valid java name */
        public final void m5782setPositionOnScreengyyYBs(long j5) {
            this.positionOnScreen = j5;
        }

        /* renamed from: setSize-ozmzZPI, reason: not valid java name */
        public final void m5783setSizeozmzZPI(long j5) {
            this.size = j5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x009f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addRulerReader(androidx.compose.ui.node.LayoutNode r32, androidx.compose.ui.layout.Ruler r33) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.addRulerReader(androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.Ruler):void");
    }

    /* renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    private final void m5777captureRulersOSxE8f4(final PlaceableResult placeableResult, final long positionOnScreen, final long size) {
        OwnerSnapshotObserver snapshotObserver;
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new a() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // S7.a
                public /* bridge */ /* synthetic */ Object invoke() {
                    m5784invoke();
                    return r.f317a;
                }

                /* renamed from: invoke, reason: collision with other method in class */
                public final void m5784invoke() {
                    this.this$0.getRulerScope().setCoordinatesAccessed(false);
                    this.this$0.getRulerScope().m5782setPositionOnScreengyyYBs(positionOnScreen);
                    this.this$0.getRulerScope().m5783setSizeozmzZPI(size);
                    k kVar = placeableResult.getResult().get$rulers();
                    if (kVar != null) {
                        kVar.invoke(this.this$0.getRulerScope());
                    }
                }
            });
        }
        rulerTrackingMap.notifyChanged(isLookingAhead(), this, mutableScatterMap);
    }

    /* renamed from: captureRulers-OSxE8f4$default, reason: not valid java name */
    public static /* synthetic */ void m5778captureRulersOSxE8f4$default(LookaheadCapablePlaceable lookaheadCapablePlaceable, PlaceableResult placeableResult, long j5, long j6, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureRulers-OSxE8f4");
        }
        if ((i & 2) != 0) {
            j5 = IntOffset.INSTANCE.m6982getMaxnOccac();
        }
        long j10 = j5;
        if ((i & 4) != 0) {
            j6 = IntSize.INSTANCE.m7020getZeroYbymL2g();
        }
        lookaheadCapablePlaceable.m5777captureRulersOSxE8f4(placeableResult, j10, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureRulersIfNeeded(androidx.compose.ui.node.PlaceableResult r15) {
        /*
            r14 = this;
            boolean r0 = r14.isPlacingForAlignment
            if (r0 == 0) goto L5
            goto L5b
        L5:
            androidx.compose.ui.layout.MeasureResult r0 = r15.getResult()
            S7.k r0 = r0.get$rulers()
            androidx.collection.MutableScatterMap<androidx.compose.ui.layout.Ruler, androidx.collection.MutableScatterSet<androidx.compose.ui.node.WeakReference<androidx.compose.ui.node.LayoutNode>>> r1 = r14.rulerReaders
            if (r0 != 0) goto L5c
            if (r1 == 0) goto L5b
            java.lang.Object[] r15 = r1.values
            long[] r0 = r1.metadata
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L58
            r3 = 0
            r4 = r3
        L1e:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L53
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L38:
            if (r9 >= r7) goto L51
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r15[r10]
            androidx.collection.MutableScatterSet r10 = (androidx.collection.MutableScatterSet) r10
            r14.notifyRulerValueChange(r10)
        L4d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L38
        L51:
            if (r7 != r8) goto L58
        L53:
            if (r4 == r2) goto L58
            int r4 = r4 + 1
            goto L1e
        L58:
            r1.clear()
        L5b:
            return
        L5c:
            r11 = 6
            r12 = 0
            r7 = 0
            r9 = 0
            r5 = r14
            r6 = r15
            m5778captureRulersOSxE8f4$default(r5, r6, r7, r9, r11, r12)
            r5.rulersLambda = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulersIfNeeded(androidx.compose.ui.node.PlaceableResult):void");
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        while (true) {
            RulerTrackingMap rulerTrackingMap = this.rulerValues;
            if ((rulerTrackingMap != null && rulerTrackingMap.contains(ruler)) || (parent = this.getParent()) == null) {
                return this;
            }
            this = parent;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ResettableRulerScope getRulerScope() {
        ResettableRulerScope resettableRulerScope = this._rulerScope;
        if (resettableRulerScope != null) {
            return resettableRulerScope;
        }
        ResettableRulerScope resettableRulerScope2 = new ResettableRulerScope();
        this._rulerScope = resettableRulerScope2;
        return resettableRulerScope2;
    }

    private final boolean isLayoutNodeAncestor(LayoutNode layoutNode, LayoutNode layoutNode2) {
        if (layoutNode == layoutNode2) {
            return true;
        }
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            return isLayoutNodeAncestor(parent$ui_release, layoutNode2);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        LayoutNode layoutNode;
        Object[] objArr = layoutNodes.elements;
        long[] jArr = layoutNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j5 = jArr[i];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i - length)) >>> 31);
                for (int i10 = 0; i10 < i6; i10++) {
                    if ((255 & j5) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i << 3) + i10]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    /* JADX WARN: Removed duplicated region for block: B:66:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void captureRulersIfNeeded$ui_release(androidx.compose.ui.layout.MeasureResult r24) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.captureRulersIfNeeded$ui_release(androidx.compose.ui.layout.MeasureResult):void");
    }

    public final float findRulerValue(Ruler ruler, float defaultValue) {
        if (this.isPlacingForAlignment) {
            return defaultValue;
        }
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            RulerTrackingMap rulerTrackingMap = lookaheadCapablePlaceable.rulerValues;
            float orDefault = rulerTrackingMap != null ? rulerTrackingMap.getOrDefault(ruler, Float.NaN) : Float.NaN;
            if (!Float.isNaN(orDefault)) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return ruler.calculateCoordinate$ui_release(orDefault, lookaheadCapablePlaceable.getCoordinates(), getCoordinates());
            }
            LookaheadCapablePlaceable parent = lookaheadCapablePlaceable.getParent();
            if (parent == null) {
                lookaheadCapablePlaceable.addRulerReader(getLayoutNode(), ruler);
                return defaultValue;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int iCalculateAlignmentLine;
        if (getHasMeasureResult() && (iCalculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return iCalculateAlignmentLine + (alignmentLine instanceof VerticalAlignmentLine ? IntOffset.m6972getXimpl(getApparentToRealOffset()) : IntOffset.m6973getYimpl(getApparentToRealOffset()));
        }
        return Integer.MIN_VALUE;
    }

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = nodeCoordinator.getWrapped();
        if (!kotlin.jvm.internal.k.b(wrapped != null ? wrapped.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    public final void invalidateChildrenOfDefiningRuler$ui_release(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> mutableScatterSetRemove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (mutableScatterSetRemove != null) {
            notifyRulerValueChange(mutableScatterSetRemove);
        }
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    /* renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    /* renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final k rulers, final k placementBlock) {
        if (!((width & ViewCompat.MEASURED_STATE_MASK) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable.layout.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getHeight, reason: from getter */
            public int get$h() {
                return height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getRulers, reason: from getter */
            public k get$rulers() {
                return rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getWidth, reason: from getter */
            public int get$w() {
                return width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }

    public final void provideRelativeRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        if (getLayoutDirection() != LayoutDirection.Ltr) {
            value = getWidth() - value;
        }
        rulerTrackingMap.set(ruler, value);
    }

    public final void provideRulerValue(Ruler ruler, float value) {
        RulerTrackingMap rulerTrackingMap = this.rulerValues;
        if (rulerTrackingMap == null) {
            rulerTrackingMap = new RulerTrackingMap();
            this.rulerValues = rulerTrackingMap;
        }
        rulerTrackingMap.set(ruler, value);
    }

    public abstract void replace$ui_release();

    public void setPlacedUnderMotionFrameOfReference(boolean z10) {
        this.isPlacedUnderMotionFrameOfReference = z10;
    }

    public final void setPlacingForAlignment$ui_release(boolean z10) {
        this.isPlacingForAlignment = z10;
    }

    public final void setShallowPlacing$ui_release(boolean z10) {
        this.isShallowPlacing = z10;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean newMFR) {
        LookaheadCapablePlaceable parent = getParent();
        LayoutNode layoutNode = parent != null ? parent.getLayoutNode() : null;
        if (kotlin.jvm.internal.k.b(layoutNode, getLayoutNode())) {
            setPlacedUnderMotionFrameOfReference(newMFR);
            return;
        }
        if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LayingOut) {
            if ((layoutNode != null ? layoutNode.getLayoutState$ui_release() : null) != LayoutNode.LayoutState.LookaheadLayingOut) {
                return;
            }
        }
        setPlacedUnderMotionFrameOfReference(newMFR);
    }
}
