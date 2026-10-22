package androidx.compose.ui;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0004\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/FrameRateModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "frameRate", "", "<init>", "(F)V", "getFrameRate", "()F", "setFrameRate", "shouldUpdateFrameRates", "", "getShouldUpdateFrameRates", "()Z", "setShouldUpdateFrameRates", "(Z)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/String;", "onAttach", "", "onDetach", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "setChildrenLayerFrameRate", "nodeCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class FrameRateModifierNode extends Modifier.Node implements TraversableNode, DrawModifierNode {
    public static final int $stable = 8;
    private float frameRate;
    private boolean shouldUpdateFrameRates;
    private final String traverseKey;

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.shouldUpdateFrameRates = true;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public final /* synthetic */ void onMeasureResultChanged() {
        DrawModifierNode.CC.$default$onMeasureResultChanged(this);
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public /* bridge */ /* synthetic */ Object getTraverseKey() {
        return getTraverseKey();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FrameRateModifierNode r100 = (FrameRateModifierNode) TraversableNodeKt.findNearestAncestor(this);
        NodeCoordinator r101 = null;
        if (r100 == null) goto L8;
        NodeCoordinator r102 = getCoordinator$ui_release();
        if (r102 == null) goto L7;
        r101 = r102.getWrapped$ui_release();
    L7:
        setChildrenLayerFrameRate(r101, r100.frameRate);
        return;
    L8:
        NodeCoordinator r103 = getCoordinator$ui_release();
        if (r103 == null) goto L11;
        r101 = r103.getWrapped$ui_release();
    L11:
        setChildrenLayerFrameRate(r101, 0.0f);
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final boolean getShouldUpdateFrameRates() {
        return this.shouldUpdateFrameRates;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public String getTraverseKey() {
        return this.traverseKey;
    }

    public FrameRateModifierNode(float r100) {
        this.frameRate = r100;
        this.shouldUpdateFrameRates = true;
        this.traverseKey = "TRAVERSAL_NODE_KEY_FRAME_RATE_MODIFIER_NODE";
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope r100) {
        if (this.shouldUpdateFrameRates == false) goto L14;
        NodeCoordinator r101 = getCoordinator$ui_release();
        if (r101 == null) goto L9;
        OwnedLayer r102 = r101.getLayer();
        if (r102 == null) goto L9;
        r102.setFrameRate(this.frameRate);
    L9:
        NodeCoordinator r103 = getCoordinator$ui_release();
        if (r103 == null) goto L12;
        NodeCoordinator r104 = r103.getWrapped$ui_release();
    L13:
        setChildrenLayerFrameRate(r104, this.frameRate);
        this.shouldUpdateFrameRates = false;
        goto L14
    L12:
        r104 = null;
    L14:
        r100.drawContent();
    }

    public final void setFrameRate(float r100) {
        this.frameRate = r100;
    }

    public final void setShouldUpdateFrameRates(boolean r100) {
        this.shouldUpdateFrameRates = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setChildrenLayerFrameRate(NodeCoordinator r100, float r101) {
        NodeCoordinator r102 = r100;
    L3:
        int r103 = 0;
        if (r102 == null) goto L22;
        if (r100 == null) goto L21;
        OwnedLayer r104 = r100.getLayer();
        if (r104 == null) goto L21;
        if (r104.getFrameRate() != 0.0f) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == false) goto L14;
    L17:
        r104.setFrameRate(r101);
        if (r101 != 0.0f) goto L20;
        r103 = 1;
    L20:
        r104.setFrameRateFromParent(r103 ^ 1);
        goto L21
    L14:
        if (r104.isFrameRateFromParent() == true) goto L17;
        return;
    L11:
        r105 = false;
    L21:
        r102 = r102.getWrapped$ui_release();
        goto L3
    L22:
        if (r100 != null) goto L24;
        r100 = getCoordinator$ui_release();
    L24:
        if (r100 == null) goto L32;
        LayoutNode r106 = r100.getLayoutNode();
        if (r106 == null) goto L39;
        List<LayoutNode> r107 = r106.getChildren$ui_release();
        if (r107 == null) goto L40;
        int r108 = r107.size();
    L30:
        if (r103 >= r108) goto L41;
        setChildrenLayerFrameRate(((LayoutNode) ListProtector.get(r107, r103)).getOuterCoordinator$ui_release(), r101);
        r103 = r103 + 1;
        goto L30
    L41:
        return;
    L40:
        return;
    L39:
        return;
    }
}
