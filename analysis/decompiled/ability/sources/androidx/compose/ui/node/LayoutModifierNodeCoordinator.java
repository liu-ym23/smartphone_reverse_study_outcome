package androidx.compose.ui.node;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.mdisdk.capability.model.WindowStateInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 1)
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0001\u0018\u0000 N2\u00020\u0001:\u0002ONB\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0019\u0010\u0015J'\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0014¢\u0006\u0004\b \u0010!J5\u0010\"\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0014\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b\u0018\u00010#H\u0014¢\u0006\u0004\b \u0010&J\u0017\u0010)\u001a\u00020\u00122\u0006\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J!\u0010.\u001a\u00020\b2\u0006\u0010,\u001a\u00020+2\b\u0010-\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b.\u0010/R*\u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u00048\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R.\u0010>\u001a\u0004\u0018\u00010=2\b\u00100\u001a\u0004\u0018\u00010=8\u0016@TX\u0096\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u0018\u0010E\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020G8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010M\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006P"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "measureNode", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "LC7/r;", "onAfterPlaceAt", "()V", "ensureLookaheadDelegateCreated", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/Placeable;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "measure", "", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "Landroidx/compose/ui/unit/IntOffset;", "position", "", "zIndex", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", WindowStateInfo.KEY_LAYER, "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "placeAt", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "(JFLS7/k;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "calculateAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "Landroidx/compose/ui/graphics/Canvas;", "canvas", "graphicsLayer", "performDraw", "(Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "value", "layoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui_release", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "wrappedNonNull", "Companion", "LookaheadDelegateForLayoutModifierNode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint modifierBoundsPaint;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", AppAgent.CONSTRUCT, "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int iCalculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().set(alignmentLine, iCalculateAlignmentAndPlaceChildAsNeeded);
            return iCalculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            k.c(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            k.c(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo5549measureBRTryo0(long constraints) {
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            m5616setMeasurementConstraintsBRTryo0(constraints);
            layoutModifierNodeCoordinator.m5749setLookaheadConstraints_Sx5XlM$ui_release(Constraints.m6784boximpl(constraints));
            LayoutModifierNode layoutModifierNode = layoutModifierNodeCoordinator.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            k.c(lookaheadDelegate);
            set_measureResult(layoutModifierNode.mo89measure3p2s80s(this, lookaheadDelegate, constraints));
            return this;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            k.c(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            k.c(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, height);
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo4016setColor8_81llA(Color.INSTANCE.m4166getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo4020setStylek9PVt8s(PaintingStyle.INSTANCE.m4418getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        this.approachMeasureScope = (layoutModifierNode.getNode().getKindSet() & NodeKind.m5862constructorimpl(512)) != 0 ? new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode) : null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onAfterPlaceAt() {
        /*
            r7 = this;
            boolean r0 = r7.getIsShallowPlacing()
            if (r0 == 0) goto L7
            return
        L7:
            r7.onPlaced()
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = r7.approachMeasureScope
            r1 = 0
            if (r0 == 0) goto L73
            androidx.compose.ui.layout.ApproachLayoutModifierNode r2 = r0.getApproachNode()
            androidx.compose.ui.layout.Placeable$PlacementScope r3 = r7.getPlacementScope()
            androidx.compose.ui.node.LookaheadDelegate r4 = r7.getLookaheadDelegate()
            kotlin.jvm.internal.k.c(r4)
            androidx.compose.ui.layout.LookaheadLayoutCoordinates r4 = r4.getLookaheadLayoutCoordinates()
            boolean r2 = r2.isPlacementApproachInProgress(r3, r4)
            if (r2 != 0) goto L6b
            boolean r0 = r0.getApproachMeasureRequired()
            if (r0 != 0) goto L6b
            long r2 = r7.mo5557getSizeYbymL2g()
            androidx.compose.ui.node.LookaheadDelegate r0 = r7.getLookaheadDelegate()
            r4 = 0
            if (r0 == 0) goto L42
            long r5 = r0.m5788getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.m7007boximpl(r5)
            goto L43
        L42:
            r0 = r4
        L43:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7012equalsimpl(r2, r0)
            if (r0 == 0) goto L6b
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            long r2 = r0.mo5557getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto L63
            long r4 = r0.m5788getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r4 = androidx.compose.ui.unit.IntSize.m7007boximpl(r4)
        L63:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7012equalsimpl(r2, r4)
            if (r0 == 0) goto L6b
            r0 = 1
            goto L6c
        L6b:
            r0 = r1
        L6c:
            androidx.compose.ui.node.NodeCoordinator r2 = r7.getWrappedNonNull()
            r2.setForcePlaceWithLookaheadOffset$ui_release(r0)
        L73:
            androidx.compose.ui.layout.MeasureResult r0 = r7.getMeasureResult$ui_release()
            r0.placeChildren()
            androidx.compose.ui.node.NodeCoordinator r7 = r7.getWrappedNonNull()
            r7.setForcePlaceWithLookaheadOffset$ui_release(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.onAfterPlaceAt():void");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        return lookaheadDelegate != null ? lookaheadDelegate.getCachedAlignmentLine$ui_release(alignmentLine) : LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw$ui_release, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped = getWrapped();
        k.c(wrapped);
        return wrapped;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width) : this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height) : this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0080  */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.Placeable mo5549measureBRTryo0(long r7) {
        /*
            r6 = this;
            boolean r0 = r6.getForceMeasureWithLookaheadConstraints()
            if (r0 == 0) goto L17
            androidx.compose.ui.unit.Constraints r7 = r6.lookaheadConstraints
            if (r7 == 0) goto Lf
            long r7 = r7.getValue()
            goto L17
        Lf:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "Lookahead constraints cannot be null in approach pass."
            r6.<init>(r7)
            throw r6
        L17:
            androidx.compose.ui.node.NodeCoordinator.m5824access$setMeasurementConstraintsBRTryo0(r6, r7)
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = access$getApproachMeasureScope$p(r6)
            if (r0 == 0) goto Lb2
            androidx.compose.ui.layout.ApproachLayoutModifierNode r1 = r0.getApproachNode()
            long r2 = r0.mo5527getLookaheadSizeYbymL2g()
            boolean r2 = r1.mo102isMeasurementApproachInProgressozmzZPI(r2)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L3d
            androidx.compose.ui.unit.Constraints r2 = r6.getLookaheadConstraints()
            boolean r2 = androidx.compose.ui.unit.Constraints.m6789equalsimpl(r7, r2)
            if (r2 != 0) goto L3b
            goto L3d
        L3b:
            r2 = r4
            goto L3e
        L3d:
            r2 = r3
        L3e:
            r0.setApproachMeasureRequired$ui_release(r2)
            boolean r2 = r0.getApproachMeasureRequired()
            if (r2 != 0) goto L4e
            androidx.compose.ui.node.NodeCoordinator r2 = r6.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r3)
        L4e:
            androidx.compose.ui.node.NodeCoordinator r2 = r6.getWrappedNonNull()
            androidx.compose.ui.layout.MeasureResult r7 = r1.mo101approachMeasure3p2s80s(r0, r2, r7)
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            r8.setForceMeasureWithLookaheadConstraints$ui_release(r4)
            int r8 = r7.getWidth()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.getLookaheadDelegate()
            kotlin.jvm.internal.k.c(r1)
            int r1 = r1.getWidth()
            if (r8 != r1) goto L80
            int r8 = r7.getHeight()
            androidx.compose.ui.node.LookaheadDelegate r1 = r6.getLookaheadDelegate()
            kotlin.jvm.internal.k.c(r1)
            int r1 = r1.getHeight()
            if (r8 != r1) goto L80
            goto L81
        L80:
            r3 = r4
        L81:
            boolean r8 = r0.getApproachMeasureRequired()
            if (r8 != 0) goto Lbe
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            long r0 = r8.mo5557getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r8 = r6.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r8 = r8.getLookaheadDelegate()
            if (r8 == 0) goto La2
            long r4 = r8.m5788getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r8 = androidx.compose.ui.unit.IntSize.m7007boximpl(r4)
            goto La3
        La2:
            r8 = 0
        La3:
            boolean r8 = androidx.compose.ui.unit.IntSize.m7012equalsimpl(r0, r8)
            if (r8 == 0) goto Lbe
            if (r3 != 0) goto Lbe
            androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1 r8 = new androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
            r8.<init>(r6)
            r7 = r8
            goto Lbe
        Lb2:
            androidx.compose.ui.node.LayoutModifierNode r0 = r6.getLayoutModifierNode()
            androidx.compose.ui.node.NodeCoordinator r1 = r6.getWrappedNonNull()
            androidx.compose.ui.layout.MeasureResult r7 = r0.mo89measure3p2s80s(r6, r1, r7)
        Lbe:
            r6.setMeasureResult$ui_release(r7)
            r6.onMeasured()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.mo5549measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width) : this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        return approachMeasureScopeImpl != null ? approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height) : this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator wrapped;
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (!LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds() || (wrapped = getWrapped()) == null) {
            return;
        }
        if (IntSize.m7013equalsimpl0(mo5557getSizeYbymL2g(), wrapped.mo5557getSizeYbymL2g()) && IntOffset.m6971equalsimpl0(wrapped.getPosition(), IntOffset.INSTANCE.m6983getZeronOccac())) {
            return;
        }
        drawBorder(canvas, modifierBoundsPaint);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5614placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.mo5614placeAtf8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode) {
        if (!k.b(layoutModifierNode, this.layoutModifierNode)) {
            Modifier.Node node = layoutModifierNode.getNode();
            if ((node.getKindSet() & NodeKind.m5862constructorimpl(512)) != 0) {
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.setApproachNode(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.approachMeasureScope = approachMeasureScopeImpl;
            } else {
                this.approachMeasureScope = null;
            }
        }
        this.layoutModifierNode = layoutModifierNode;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM$ui_release, reason: not valid java name */
    public final void m5749setLookaheadConstraints_Sx5XlM$ui_release(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo5550placeAtf8xVGno(long position, float zIndex, S7.k layerBlock) {
        super.mo5550placeAtf8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }
}
