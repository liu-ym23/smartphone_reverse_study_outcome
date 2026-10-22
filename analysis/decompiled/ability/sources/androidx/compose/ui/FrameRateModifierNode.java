package androidx.compose.ui;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.List;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u0013\u0010\r\u001a\u00020\b*\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0007R\"\u0010\u0018\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"Landroidx/compose/ui/FrameRateModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "", "frameRate", AppAgent.CONSTRUCT, "(F)V", "LC7/r;", "onAttach", "()V", "onDetach", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "draw", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;)V", "Landroidx/compose/ui/node/NodeCoordinator;", "nodeCoordinator", "setChildrenLayerFrameRate", "(Landroidx/compose/ui/node/NodeCoordinator;F)V", "F", "getFrameRate", "()F", "setFrameRate", "", "shouldUpdateFrameRates", "Z", "getShouldUpdateFrameRates", "()Z", "setShouldUpdateFrameRates", "(Z)V", "", "traverseKey", "Ljava/lang/String;", "getTraverseKey", "()Ljava/lang/String;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FrameRateModifierNode extends Modifier.Node implements TraversableNode, DrawModifierNode {
    public static final int $stable = 8;
    private float frameRate;
    private boolean shouldUpdateFrameRates = true;
    private final String traverseKey = "TRAVERSAL_NODE_KEY_FRAME_RATE_MODIFIER_NODE";

    public FrameRateModifierNode(float f) {
        this.frameRate = f;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        OwnedLayer layer;
        if (this.shouldUpdateFrameRates) {
            NodeCoordinator coordinator = getCoordinator();
            if (coordinator != null && (layer = coordinator.getLayer()) != null) {
                layer.setFrameRate(this.frameRate);
            }
            NodeCoordinator coordinator2 = getCoordinator();
            setChildrenLayerFrameRate(coordinator2 != null ? coordinator2.getWrapped() : null, this.frameRate);
            this.shouldUpdateFrameRates = false;
        }
        contentDrawScope.drawContent();
    }

    public final float getFrameRate() {
        return this.frameRate;
    }

    public final boolean getShouldUpdateFrameRates() {
        return this.shouldUpdateFrameRates;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.shouldUpdateFrameRates = true;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        FrameRateModifierNode frameRateModifierNode = (FrameRateModifierNode) TraversableNodeKt.findNearestAncestor(this);
        if (frameRateModifierNode != null) {
            NodeCoordinator coordinator = getCoordinator();
            setChildrenLayerFrameRate(coordinator != null ? coordinator.getWrapped() : null, frameRateModifierNode.frameRate);
        } else {
            NodeCoordinator coordinator2 = getCoordinator();
            setChildrenLayerFrameRate(coordinator2 != null ? coordinator2.getWrapped() : null, 0.0f);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setChildrenLayerFrameRate(NodeCoordinator nodeCoordinator, float frameRate) {
        LayoutNode layoutNode;
        List<LayoutNode> children$ui_release;
        OwnedLayer layer;
        NodeCoordinator wrapped = nodeCoordinator;
        while (true) {
            if (wrapped == null) {
                if (nodeCoordinator == null) {
                    nodeCoordinator = getCoordinator();
                }
                if (nodeCoordinator == null || (layoutNode = nodeCoordinator.getLayoutNode()) == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
                    return;
                }
                int size = children$ui_release.size();
                while (i < size) {
                    setChildrenLayerFrameRate(children$ui_release.get(i).getOuterCoordinator$ui_release(), frameRate);
                    i++;
                }
                return;
            }
            if (nodeCoordinator != null && (layer = nodeCoordinator.getLayer()) != null) {
                if (layer.getFrameRate() != 0.0f && !layer.getIsFrameRateFromParent()) {
                    return;
                }
                layer.setFrameRate(frameRate);
                layer.setFrameRateFromParent((frameRate == 0.0f ? 1 : 0) ^ 1);
            }
            wrapped = wrapped.getWrapped();
        }
    }

    public final void setFrameRate(float f) {
        this.frameRate = f;
    }

    public final void setShouldUpdateFrameRates(boolean z10) {
        this.shouldUpdateFrameRates = z10;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public String getTraverseKey() {
        return this.traverseKey;
    }
}
