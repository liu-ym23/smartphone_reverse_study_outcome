package androidx.compose.ui.node;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.layout.VerticalRuler;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.FontScaling;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b!\u0018\u0000 p2\u00020\u00012\u00020\u00022\u00020\u0003:\u0002opB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0011\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0086\u0002J\u0010\u00100\u001a\u00020-2\u0006\u0010.\u001a\u00020/H&J\r\u00108\u001a\u00020 H ¢\u0006\u0002\b9J\f\u0010E\u001a\u00020 *\u00020FH\u0004J\u0016\u0010O\u001a\u00020P2\u0006\u0010Q\u001a\u00020L2\u0006\u0010R\u001a\u00020PJ\u0018\u0010S\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020LH\u0002J\u0010\u0010T\u001a\u00020\u00002\u0006\u0010Q\u001a\u00020LH\u0002J\u0014\u0010U\u001a\u00020\u0010*\u00020\u00142\u0006\u0010V\u001a\u00020\u0014H\u0002J\u0015\u0010W\u001a\u00020 2\u0006\u0010Q\u001a\u00020LH\u0000¢\u0006\u0002\bXJ`\u0010Y\u001a\u0002052\u0006\u0010Z\u001a\u00020-2\u0006\u0010[\u001a\u00020-2\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020-0]2\u0019\u0010^\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!2\u0017\u0010_\u001a\u0013\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020 0\u001e¢\u0006\u0002\b!H\u0016J\u0017\u0010`\u001a\u00020 2\b\u0010a\u001a\u0004\u0018\u000105H\u0000¢\u0006\u0002\bbJ+\u0010c\u001a\u00020 2\u0006\u0010d\u001a\u00020#2\b\b\u0002\u0010e\u001a\u00020\u00072\b\b\u0002\u0010f\u001a\u00020gH\u0002¢\u0006\u0004\bh\u0010iJ\u0010\u0010`\u001a\u00020 2\u0006\u0010d\u001a\u00020#H\u0002J\u001c\u0010j\u001a\u00020 2\u0012\u0010k\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0MH\u0002J\u0016\u0010l\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PJ\u0016\u0010n\u001a\u00020 2\u0006\u0010Q\u001a\u00020L2\u0006\u0010m\u001a\u00020PR\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u0004\u0018\u00010\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0012\u0010\u0017\u001a\u00020\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u001d\u001a\u0015\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020 \u0018\u00010\u001e¢\u0006\u0002\b!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0010X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010&R\u0018\u0010)\u001a\u00060\u001cR\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u00101\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010&R\u0012\u00104\u001a\u000205X \u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0012\u0010:\u001a\u00020;X¦\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\u00020\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0012\"\u0004\b@\u0010&R\u0011\u0010A\u001a\u00020B¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0014\u0010G\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0012R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010J\u001a\u001c\u0012\u0004\u0012\u00020L\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140N0M\u0018\u00010KX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006q"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "()V", "position", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getParent", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "_rulerScope", "Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "rulersLambda", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "", "Lkotlin/ExtensionFunctionType;", "cachedRulerPlaceableResult", "Landroidx/compose/ui/node/PlaceableResult;", "isPlacedUnderMotionFrameOfReference", "setPlacedUnderMotionFrameOfReference", "(Z)V", "updatePlacedUnderMotionFrameOfReference", "newMFR", "rulerScope", "getRulerScope", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", MonitorConstants.CONNECT_TYPE_GET, "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLine", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "replace", "replace$ui_release", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invalidateAlignmentLinesFromPositionChange", "Landroidx/compose/ui/node/NodeCoordinator;", "isLookingAhead", "rulerValues", "Landroidx/compose/ui/node/RulerTrackingMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/Ruler;", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/ui/node/WeakReference;", "findRulerValue", "", "ruler", "defaultValue", "addRulerReader", "findAncestorRulerDefiner", "isLayoutNodeAncestor", "ancestor", "invalidateChildrenOfDefiningRuler", "invalidateChildrenOfDefiningRuler$ui_release", "layout", "width", "height", "alignmentLines", "", "rulers", "placementBlock", "captureRulersIfNeeded", "result", "captureRulersIfNeeded$ui_release", "captureRulers", "placeableResult", "positionOnScreen", "size", "Landroidx/compose/ui/unit/IntSize;", "captureRulers-OSxE8f4", "(Landroidx/compose/ui/node/PlaceableResult;JJ)V", "notifyRulerValueChange", "layoutNodes", "provideRulerValue", "value", "provideRelativeRulerValue", "ResettableRulerScope", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = null;
    private ResettableRulerScope _rulerScope;
    private PlaceableResult cachedRulerPlaceableResult;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope;
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private RulerTrackingMap rulerValues;
    private Function1<? super RulerScope, Unit> rulersLambda;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$Companion;", "", "<init>", "()V", "onCommitAffectingRuler", "Lkotlin/Function1;", "Landroidx/compose/ui/node/PlaceableResult;", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004J\u0015\u0010\u001e\u001a\u00020\u001a*\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u001dH\u0096\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010 \u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable$ResettableRulerScope;", "Landroidx/compose/ui/layout/RulerScope;", "<init>", "(Landroidx/compose/ui/node/LookaheadCapablePlaceable;)V", "coordinatesAccessed", "", "getCoordinatesAccessed", "()Z", "setCoordinatesAccessed", "(Z)V", "positionOnScreen", "Landroidx/compose/ui/unit/IntOffset;", "getPositionOnScreen-nOcc-ac", "()J", "setPositionOnScreen--gyyYBs", "(J)V", "J", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "setSize-ozmzZPI", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "provides", "", "Landroidx/compose/ui/layout/Ruler;", "value", "", "providesRelative", "Landroidx/compose/ui/layout/VerticalRuler;", "density", "getDensity", "()F", "fontScale", "getFontScale", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class ResettableRulerScope implements RulerScope {
        private boolean coordinatesAccessed;
        private long positionOnScreen;
        private long size;
        final /* synthetic */ LookaheadCapablePlaceable this$0;

        @Override // androidx.compose.ui.layout.RulerScope
        public LayoutCoordinates getCoordinates() {
            this.coordinatesAccessed = true;
            LayoutCoordinates r100 = this.this$0.getCoordinates();
            if (IntOffset.m7675equalsimpl0(this.positionOnScreen, IntOffset.Companion.m7686getMaxnOccac()) == false) goto L5;
            this.positionOnScreen = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(r100));
            this.size = r100.mo6258getSizeYbymL2g();
        L5:
            this.this$0.getLayoutNode().getLayoutDelegate$ui_release().onCoordinatesUsed();
            return r100;
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx--R2X_6o */
        public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
            return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: roundToPx-0680j_4 */
        public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
            return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toDp-GaN1DYA */
        public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
            return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
            return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDp-u2uoSUM */
        public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
            return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toDpSize-k-rfVVM */
        public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
            return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx--R2X_6o */
        public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
            return Density.CC.m7513$default$toPxR2X_6o(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toPx-0680j_4 */
        public final /* synthetic */ float mo371toPx0680j_4(float r100) {
            return Density.CC.m7514$default$toPx0680j_4(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        public final /* synthetic */ Rect toRect(DpRect r100) {
            return Density.CC.$default$toRect(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSize-XkaWNTQ */
        public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
            return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* JADX INFO: renamed from: toSp-0xMU5do */
        public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
            return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
            return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        /* JADX INFO: renamed from: toSp-kPz2Gy4 */
        public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
            return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.this$0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.this$0.getFontScale();
        }

        public final boolean getCoordinatesAccessed() {
            return this.coordinatesAccessed;
        }

        /* JADX INFO: renamed from: getPositionOnScreen-nOcc-ac, reason: not valid java name */
        public final long m6486getPositionOnScreennOccac() {
            return this.positionOnScreen;
        }

        /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
        public final long m6487getSizeYbymL2g() {
            return this.size;
        }

        public ResettableRulerScope(LookaheadCapablePlaceable r100) {
            this.this$0 = r100;
            this.positionOnScreen = IntOffset.Companion.m7686getMaxnOccac();
            this.size = IntSize.Companion.m7724getZeroYbymL2g();
        }

        public final void setCoordinatesAccessed(boolean r100) {
            this.coordinatesAccessed = r100;
        }

        /* JADX INFO: renamed from: setPositionOnScreen--gyyYBs, reason: not valid java name */
        public final void m6488setPositionOnScreengyyYBs(long r100) {
            this.positionOnScreen = r100;
        }

        /* JADX INFO: renamed from: setSize-ozmzZPI, reason: not valid java name */
        public final void m6489setSizeozmzZPI(long r100) {
            this.size = r100;
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void provides(Ruler r100, float r101) {
            this.this$0.provideRulerValue(r100, r101);
        }

        @Override // androidx.compose.ui.layout.RulerScope
        public void providesRelative(VerticalRuler r100, float r101) {
            this.this$0.provideRelativeRulerValue(r100, r101);
        }
    }

    public abstract int calculateAlignmentLine(AlignmentLine r100);

    public abstract AlignmentLinesOwner getAlignmentLinesOwner();

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    /* JADX INFO: renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long mo6485getPositionnOccac();

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public final /* synthetic */ MeasureResult layout(int r100, int r101, Map r102, Function1 r103) {
        return MeasureScope.CC.$default$layout(this, r100, r101, r102, r103);
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx--R2X_6o */
    public final /* synthetic */ int mo364roundToPxR2X_6o(long r100) {
        return Density.CC.m7508$default$roundToPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: roundToPx-0680j_4 */
    public final /* synthetic */ int mo365roundToPx0680j_4(float r100) {
        return Density.CC.m7509$default$roundToPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toDp-GaN1DYA */
    public final /* synthetic */ float mo366toDpGaN1DYA(long r100) {
        return FontScaling.CC.m7653$default$toDpGaN1DYA(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo367toDpu2uoSUM(float r100) {
        return Density.CC.m7510$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDp-u2uoSUM */
    public final /* synthetic */ float mo368toDpu2uoSUM(int r100) {
        return Density.CC.m7511$default$toDpu2uoSUM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toDpSize-k-rfVVM */
    public final /* synthetic */ long mo369toDpSizekrfVVM(long r100) {
        return Density.CC.m7512$default$toDpSizekrfVVM(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx--R2X_6o */
    public final /* synthetic */ float mo370toPxR2X_6o(long r100) {
        return Density.CC.m7513$default$toPxR2X_6o(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toPx-0680j_4 */
    public final /* synthetic */ float mo371toPx0680j_4(float r100) {
        return Density.CC.m7514$default$toPx0680j_4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    public final /* synthetic */ Rect toRect(DpRect r100) {
        return Density.CC.$default$toRect(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSize-XkaWNTQ */
    public final /* synthetic */ long mo372toSizeXkaWNTQ(long r100) {
        return Density.CC.m7515$default$toSizeXkaWNTQ(this, r100);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* JADX INFO: renamed from: toSp-0xMU5do */
    public final /* synthetic */ long mo373toSp0xMU5do(float r100) {
        return FontScaling.CC.m7654$default$toSp0xMU5do(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo374toSpkPz2Gy4(float r100) {
        return Density.CC.m7516$default$toSpkPz2Gy4(this, r100);
    }

    @Override // androidx.compose.ui.unit.Density
    /* JADX INFO: renamed from: toSp-kPz2Gy4 */
    public final /* synthetic */ long mo375toSpkPz2Gy4(int r100) {
        return Density.CC.m7517$default$toSpkPz2Gy4(this, r100);
    }

    static {
        Companion = new Companion(null);
        onCommitAffectingRuler = LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1.INSTANCE;
    }

    private final ResettableRulerScope getRulerScope() {
        ResettableRulerScope r100 = this._rulerScope;
        if (r100 != null) goto L6;
        ResettableRulerScope r101 = new ResettableRulerScope(this);
        this._rulerScope = r101;
        return r101;
    L6:
        return r100;
    }

    public LookaheadCapablePlaceable() {
        this.placementScope = PlaceableKt.PlacementScope(this);
    }

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public boolean isPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    public final boolean isPlacingForAlignment$ui_release() {
        return this.isPlacingForAlignment;
    }

    public final boolean isShallowPlacing$ui_release() {
        return this.isShallowPlacing;
    }

    public static final /* synthetic */ ResettableRulerScope access$getRulerScope(LookaheadCapablePlaceable r100) {
        return r100.getRulerScope();
    }

    private final void captureRulersIfNeeded(PlaceableResult r110) {
        if (this.isPlacingForAlignment == false) goto L5;
        return;
    L5:
        Function1<RulerScope, Unit> r100 = r110.getResult().getRulers();
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r101 = this.rulerReaders;
        if (r100 != null) goto L26;
        if (r101 == null) goto L33;
        Object[] r102 = r101.values;
        long[] r103 = r101.metadata;
        int r104 = r103.length - 2;
        if (r104 < 0) goto L25;
        int r105 = 0;
    L11:
        long r106 = r103[r105];
        if (((((~r106) << 7) & r106) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L23;
        int r107 = 8 - ((~(r105 - r104)) >>> 31);
        int r111 = 0;
    L14:
        if (r111 >= r107) goto L22;
        if ((255 & r106) >= 128) goto L18;
        boolean r112 = true;
    L19:
        if (r112 == false) goto L21;
        notifyRulerValueChange((MutableScatterSet) r102[(r105 << 3) + r111]);
    L21:
        r106 = r106 >> 8;
        r111 = r111 + 1;
        goto L14
    L18:
        r112 = false;
        goto L19
    L22:
        if (r107 != 8) goto L25;
    L23:
        if (r105 == r104) goto L25;
        r105 = r105 + 1;
    L25:
        r101.clear();
        return;
    L33:
        return;
    L26:
        m6484captureRulersOSxE8f4$default(this, r110, 0, 0, 6, null);
        this.rulersLambda = r100;
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler r100) {
        LookaheadCapablePlaceable r101 = this;
    L3:
        RulerTrackingMap r102 = r101.rulerValues;
        boolean r103 = false;
        if (r102 != null) goto L6;
    L8:
        if (r103 == true) goto L9;
        LookaheadCapablePlaceable r104 = r101.getParent();
        if (r104 == null) goto L12;
        r101 = r104;
        goto L3
    L12:
        return r101;
    L9:
        return r101;
    L6:
        if (r102.contains(r100) != true) goto L8;
        r103 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> r110) {
        Object[] r100 = r110.elements;
        long[] r111 = r110.metadata;
        int r101 = r111.length - 2;
        if (r101 < 0) goto L24;
        int r102 = 0;
    L5:
        long r103 = r111[r102];
        if (((((~r103) << 7) & r103) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L22;
        int r104 = 8 - ((~(r102 - r101)) >>> 31);
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L21;
        if ((255 & r103) >= 128) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L20;
        LayoutNode r107 = (LayoutNode) ((WeakReference) r100[(r102 << 3) + r105]).get();
        if (r107 == null) goto L20;
        if (isLookingAhead() == false) goto L19;
        r107.requestLookaheadRelayout$ui_release(false);
        goto L20
    L19:
        r107.requestRelayout$ui_release(false);
    L20:
        r103 = r103 >> 8;
        r105 = r105 + 1;
        goto L8
    L12:
        r106 = false;
        goto L13
    L21:
        if (r104 == 8) goto L22;
        return;
    L22:
        if (r102 == r101) goto L33;
        r102 = r102 + 1;
        goto L5
    L33:
        return;
    }

    public final void captureRulersIfNeeded$ui_release(MeasureResult r210) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r100 = this.rulerReaders;
        long r101 = 255;
        char r102 = 7;
        if (r210 != null) goto L5;
        if (r100 == null) goto L73;
        Object[] r103 = r100.values;
        long[] r104 = r100.metadata;
        int r105 = r104.length - 2;
        if (r105 < 0) goto L73;
        int r106 = 0;
    L56:
        long r110 = r104[r106];
        if (((((~r110) << r102) & r110) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L71;
        int r107 = 8 - ((~(r106 - r105)) >>> 31);
        int r111 = 0;
    L59:
        if (r111 >= r107) goto L68;
        if ((r110 & 255) >= 128) goto L63;
        boolean r112 = true;
    L64:
        if (r112 == false) goto L66;
        notifyRulerValueChange((MutableScatterSet) r103[(r106 << 3) + r111]);
    L66:
        r110 = r110 >> 8;
        r111 = r111 + 1;
        goto L59
    L63:
        r112 = false;
        goto L64
    L68:
        if (r107 != 8) goto L73;
    L71:
        if (r106 == r105) goto L73;
        r106 = r106 + 1;
        r102 = 7;
    L73:
        if (r100 == null) goto L75;
        r100.clear();
    L75:
        RulerTrackingMap r108 = this.rulerValues;
        if (r108 == null) goto L93;
        r108.clear();
        return;
    L93:
        return;
    L5:
        if (this.isPlacingForAlignment == false) goto L7;
        return;
    L7:
        Function1<RulerScope, Unit> r113 = r210.getRulers();
        if (r113 != null) goto L29;
        if (r100 == null) goto L89;
        Object[] r109 = r100.values;
        long[] r114 = r100.metadata;
        int r115 = r114.length - 2;
        if (r115 < 0) goto L27;
        int r116 = 0;
    L13:
        long r117 = r114[r116];
        if (((((~r117) << 7) & r117) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L25;
        int r118 = 8 - ((~(r116 - r115)) >>> 31);
        int r119 = 0;
    L16:
        if (r119 >= r118) goto L24;
        if ((r117 & r101) >= 128) goto L20;
        boolean r120 = true;
    L21:
        if (r120 == false) goto L23;
        notifyRulerValueChange((MutableScatterSet) r109[(r116 << 3) + r119]);
    L23:
        r117 = r117 >> 8;
        r119 = r119 + 1;
        r101 = 255;
        goto L16
    L20:
        r120 = false;
        goto L21
    L24:
        if (r118 != 8) goto L27;
    L25:
        if (r116 == r115) goto L27;
        r116 = r116 + 1;
        r101 = 255;
    L27:
        r100.clear();
        return;
    L89:
        return;
    L29:
        if (this.rulersLambda == r113) goto L31;
        boolean r121 = true;
    L32:
        long r122 = IntOffset.Companion.m7686getMaxnOccac();
        long r123 = IntSize.Companion.m7724getZeroYbymL2g();
        if (r121 == false) goto L35;
    L44:
        long r124 = r123;
    L45:
        long r125 = r122;
        if (r121 == false) goto L91;
        PlaceableResult r126 = this.cachedRulerPlaceableResult;
        if (r126 == null) goto L50;
        r126.setResult(r210);
    L51:
        m6483captureRulersOSxE8f4(r126, r125, r124);
        this.rulersLambda = r210.getRulers();
        return;
    L50:
        r126 = new PlaceableResult(r210, this);
        this.cachedRulerPlaceableResult = r126;
        goto L51
    L91:
        return;
    L35:
        if (getRulerScope().getCoordinatesAccessed() == false) goto L44;
        LayoutCoordinates r127 = getCoordinates();
        r122 = IntOffsetKt.m7693roundk4lQ0M(LayoutCoordinatesKt.positionOnScreen(r127));
        long r128 = r127.mo6258getSizeYbymL2g();
        if (IntOffset.m7675equalsimpl0(r122, getRulerScope().m6486getPositionOnScreennOccac()) == true) goto L39;
    L42:
        boolean r129 = true;
    L43:
        r124 = r128;
        r121 = r129;
        goto L45
    L39:
        if (IntSize.m7717equalsimpl0(r128, getRulerScope().m6487getSizeYbymL2g()) == false) goto L42;
        r129 = false;
        goto L43
    L31:
        r121 = false;
        goto L32
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine r100) {
        if (getHasMeasureResult() == true) goto L5;
        return Integer.MIN_VALUE;
    L5:
        int r101 = calculateAlignmentLine(r100);
        if (r101 != Integer.MIN_VALUE) goto L9;
        return Integer.MIN_VALUE;
    L9:
        if ((r100 instanceof VerticalAlignmentLine) == false) goto L11;
        int r102 = IntOffset.m7676getXimpl(m6321getApparentToRealOffsetnOccac());
    L13:
        return r101 + r102;
    L11:
        r102 = IntOffset.m7677getYimpl(m6321getApparentToRealOffsetnOccac());
        goto L13
    }

    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator r100) {
        NodeCoordinator r101 = r100.getWrapped$ui_release();
        if (r101 == null) goto L5;
        LayoutNode r102 = r101.getLayoutNode();
    L7:
        if (Intrinsics.areEqual(r102, r100.getLayoutNode()) == true) goto L9;
        r100.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
        return;
    L9:
        AlignmentLinesOwner r103 = r100.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (r103 == null) goto L16;
        AlignmentLines r104 = r103.getAlignmentLines();
        if (r104 == null) goto L17;
        r104.onAlignmentsChanged();
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void invalidateChildrenOfDefiningRuler$ui_release(Ruler r100) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r101 = findAncestorRulerDefiner(r100).rulerReaders;
        if (r101 == null) goto L5;
        MutableScatterSet<WeakReference<LayoutNode>> r102 = r101.remove(r100);
    L6:
        if (r102 == null) goto L9;
        notifyRulerValueChange(r102);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public void setPlacedUnderMotionFrameOfReference(boolean r100) {
        this.isPlacedUnderMotionFrameOfReference = r100;
    }

    public final void setPlacingForAlignment$ui_release(boolean r100) {
        this.isPlacingForAlignment = r100;
    }

    public final void setShallowPlacing$ui_release(boolean r100) {
        this.isShallowPlacing = r100;
    }

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void updatePlacedUnderMotionFrameOfReference(boolean r100) {
        LookaheadCapablePlaceable r101 = getParent();
        LayoutNode.LayoutState r102 = null;
        if (r101 == null) goto L5;
        LayoutNode r103 = r101.getLayoutNode();
    L7:
        if (Intrinsics.areEqual(r103, getLayoutNode()) == false) goto L9;
        setPlacedUnderMotionFrameOfReference(r100);
        return;
    L9:
        if (r103 == null) goto L11;
        LayoutNode.LayoutState r104 = r103.getLayoutState$ui_release();
    L13:
        if (r104 == LayoutNode.LayoutState.LayingOut) goto L18;
        if (r103 == null) goto L17;
        r102 = r103.getLayoutState$ui_release();
    L17:
        if (r102 == LayoutNode.LayoutState.LookaheadLayingOut) goto L18;
        return;
    L18:
        setPlacedUnderMotionFrameOfReference(r100);
        return;
    L11:
        r104 = null;
        goto L13
    L5:
        r103 = null;
        goto L7
    }

    public static final /* synthetic */ void access$captureRulersIfNeeded(LookaheadCapablePlaceable r100, PlaceableResult r101) {
        r100.captureRulersIfNeeded(r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void addRulerReader(LayoutNode r310, Ruler r311) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r100 = this.rulerReaders;
        long r101 = 255;
        char r102 = 7;
        long r103 = -9187201950435737472L;
        if (r100 == null) goto L55;
        Object[] r110 = r100.values;
        long[] r104 = r100.metadata;
        int r111 = r104.length - 2;
        if (r111 < 0) goto L55;
        int r112 = 0;
    L7:
        long r113 = r104[r112];
        if (((((~r113) << r102) & r113) & r103) == r103) goto L52;
        int r105 = 8 - ((~(r112 - r111)) >>> 31);
        int r106 = 0;
    L10:
        if (r106 >= r105) goto L49;
        if ((r113 & r101) >= 128) goto L14;
        boolean r114 = true;
    L15:
        if (r114 == false) goto L46;
        MutableScatterSet r107 = (MutableScatterSet) r110[(r112 << 3) + r106];
        Object[] r108 = r107.elements;
        long[] r115 = r107.metadata;
        int r109 = r115.length - 2;
        long[] r210 = r104;
        if (r109 < 0) goto L47;
        int r116 = 0;
    L19:
        long r117 = r115[r116];
        Object[] r211 = r110;
        int r212 = r111;
        if (((((~r117) << r102) & r117) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L43;
        int r118 = 8 - ((~(r116 - r109)) >>> 31);
        int r119 = 0;
    L22:
        if (r119 >= r118) goto L40;
        if ((r117 & 255) >= 128) goto L26;
        boolean r213 = true;
    L27:
        if (r213 == false) goto L38;
        int r120 = (r116 << 3) + r119;
        LayoutNode r214 = (LayoutNode) ((WeakReference) r108[r120]).get();
        Object[] r215 = r108;
        if (r214 == null) goto L33;
        boolean r121 = r214.isAttached();
        long[] r216 = r115;
        if (r121 != true) goto L34;
        boolean r122 = true;
    L36:
        if ((!r122) == false) goto L39;
        r107.removeElementAt(r120);
    L39:
        r117 = r117 >> 8;
        r119 = r119 + 1;
        r115 = r216;
        r108 = r215;
    L34:
        r122 = false;
        goto L36
    L33:
        r216 = r115;
        goto L34
    L38:
        r215 = r108;
        r216 = r115;
        goto L39
    L26:
        r213 = false;
        goto L27
    L40:
        Object[] r217 = r108;
        long[] r218 = r115;
        if (r118 != 8) goto L48;
    L44:
        if (r116 == r109) goto L48;
        r116 = r116 + 1;
        r110 = r211;
        r111 = r212;
        r115 = r218;
        r108 = r217;
        r102 = 7;
    L48:
        r113 = r113 >> 8;
        r106 = r106 + 1;
        r104 = r210;
        r110 = r211;
        r111 = r212;
        r101 = 255;
        r102 = 7;
        goto L10
    L43:
        r217 = r108;
        r218 = r115;
    L47:
        r211 = r110;
        r212 = r111;
        goto L48
    L46:
        r210 = r104;
        goto L47
    L14:
        r114 = false;
        goto L15
    L49:
        long[] r219 = r104;
        Object[] r220 = r110;
        int r221 = r111;
        if (r105 != 8) goto L55;
        r111 = r221;
    L53:
        if (r112 == r111) goto L55;
        r112 = r112 + 1;
        r104 = r219;
        r110 = r220;
        r101 = 255;
        r102 = 7;
        r103 = -9187201950435737472L;
        goto L7
    L52:
        r219 = r104;
        r220 = r110;
    L55:
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r123 = this.rulerReaders;
        if (r123 == null) goto L79;
        long[] r124 = r123.metadata;
        int r125 = r124.length - 2;
        if (r125 < 0) goto L79;
        int r126 = 0;
    L60:
        long r127 = r124[r126];
        if (((((~r127) << 7) & r127) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L77;
        int r128 = 8 - ((~(r126 - r125)) >>> 31);
        int r129 = 0;
    L63:
        if (r129 >= r128) goto L74;
        if ((r127 & 255) >= 128) goto L67;
        boolean r130 = true;
    L68:
        if (r130 == false) goto L72;
        int r131 = (r126 << 3) + r129;
        Ruler r132 = (Ruler) r123.keys[r131];
        if (((MutableScatterSet) r123.values[r131]).isEmpty() == false) goto L72;
        r123.removeValueAt(r131);
    L72:
        r127 = r127 >> 8;
        r129 = r129 + 1;
        goto L63
    L67:
        r130 = false;
        goto L68
    L74:
        if (r128 != 8) goto L79;
    L77:
        if (r126 == r125) goto L79;
        r126 = r126 + 1;
    L79:
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r133 = this.rulerReaders;
        if (r133 != null) goto L82;
        int r134 = 0;
        int r135 = 1;
        r133 = new MutableScatterMap(0, 1, null);
        this.rulerReaders = r133;
    L83:
        MutableScatterSet<WeakReference<LayoutNode>> r136 = r133.get(r311);
        if (r136 != null) goto L86;
        r136 = new MutableScatterSet(r134, r135, null);
        r133.set(r311, r136);
    L86:
        r136.plusAssign(new WeakReference(r310));
        return;
    L82:
        r134 = 0;
        r135 = 1;
        goto L83
    }

    private final boolean isLayoutNodeAncestor(LayoutNode r100, LayoutNode r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        LayoutNode r102 = r100.getParent$ui_release();
        if (r102 != null) goto L10;
        return false;
    L10:
        return isLayoutNodeAncestor(r102, r101);
    }

    public final float findRulerValue(Ruler r100, float r101) {
        if (this.isPlacingForAlignment == false) goto L5;
        return r101;
    L5:
        LookaheadCapablePlaceable r102 = this;
    L6:
        RulerTrackingMap r103 = r102.rulerValues;
        float r104 = Float.NaN;
        if (r103 == null) goto L10;
        r104 = r103.getOrDefault(r100, Float.NaN);
    L10:
        if (Float.isNaN(r104) == false) goto L11;
        LookaheadCapablePlaceable r105 = r102.getParent();
        if (r105 == null) goto L15;
        r102 = r105;
        goto L6
    L15:
        r102.addRulerReader(getLayoutNode(), r100);
        return r101;
    L11:
        r102.addRulerReader(getLayoutNode(), r100);
        return r100.calculateCoordinate$ui_release(r104, r102.getCoordinates(), getCoordinates());
    }

    public final void provideRelativeRulerValue(Ruler r100, float r101) {
        RulerTrackingMap r102 = this.rulerValues;
        if (r102 != null) goto L6;
        r102 = new RulerTrackingMap();
        this.rulerValues = r102;
    L6:
        if (getLayoutDirection() == LayoutDirection.Ltr) goto L9;
        r101 = getWidth() - r101;
    L9:
        r102.set(r100, r101);
    }

    public final void provideRulerValue(Ruler r100, float r101) {
        RulerTrackingMap r102 = this.rulerValues;
        if (r102 != null) goto L5;
        r102 = new RulerTrackingMap();
        this.rulerValues = r102;
    L5:
        r102.set(r100, r101);
    }

    /* JADX INFO: renamed from: captureRulers-OSxE8f4, reason: not valid java name */
    private final void m6483captureRulersOSxE8f4(final PlaceableResult r110, final long r111, final long r112) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> r100 = this.rulerReaders;
        RulerTrackingMap r101 = this.rulerValues;
        if (r101 != null) goto L5;
        r101 = new RulerTrackingMap();
        this.rulerValues = r101;
    L5:
        RulerTrackingMap r102 = r101;
        Owner r103 = getLayoutNode().getOwner$ui_release();
        if (r103 == null) goto L10;
        OwnerSnapshotObserver r113 = r103.getSnapshotObserver();
        if (r113 == null) goto L10;
        r113.observeReads$ui_release(r110, onCommitAffectingRuler, new LookaheadCapablePlaceable$captureRulers$1(this, r111, r112, r110));
    L10:
        r102.notifyChanged(isLookingAhead(), this, r100);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int r100, final int r110, final Map<AlignmentLine, Integer> r111, final Function1<? super RulerScope, Unit> r112, final Function1<? super Placeable.PlacementScope, Unit> r113) {
        if ((r100 & (-16777216)) == 0) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L11;
        InlineClassHelperKt.throwIllegalStateException("Size(" + r100 + " x " + r110 + ") is out of range. Each dimension must be between 0 and 16777215.");
    L11:
        return new AnonymousClass1(r100, r110, r111, r112, r113, this);
    L5:
        if (((-16777216) & r110) != 0) goto L7;
        r101 = true;
        goto L8
    }

    /* JADX INFO: renamed from: captureRulers-OSxE8f4$default, reason: not valid java name */
    public static /* synthetic */ void m6484captureRulersOSxE8f4$default(LookaheadCapablePlaceable r100, PlaceableResult r101, long r102, long r110, int r111, Object r112) {
        if (r112 != null) goto L12;
        if ((r111 & 2) == 0) goto L6;
        r102 = IntOffset.Companion.m7686getMaxnOccac();
    L6:
        long r103 = r102;
        if ((r111 & 4) == 0) goto L9;
        r110 = IntSize.Companion.m7724getZeroYbymL2g();
    L9:
        r100.m6483captureRulersOSxE8f4(r101, r103, r110);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: captureRulers-OSxE8f4");
    }
}
