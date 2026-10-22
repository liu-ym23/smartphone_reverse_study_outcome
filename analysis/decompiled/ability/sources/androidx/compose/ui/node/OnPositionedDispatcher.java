package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\bJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0004\b\u0010\u0010\bJ\r\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\u0003R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", AppAgent.CONSTRUCT, "()V", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "LC7/r;", "dispatchHierarchy", "(Landroidx/compose/ui/node/LayoutNode;)V", "", "isNotEmpty", "()Z", "node", "onNodePositioned", "remove", "rootNode", "onRootNodePositioned", "dispatch", "Landroidx/compose/runtime/collection/MutableVector;", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "", "cachedNodes", "[Landroidx/compose/ui/node/LayoutNode;", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OnPositionedDispatcher {
    private static final int MinArraySize = 16;
    private LayoutNode[] cachedNodes;
    private final MutableVector<LayoutNode> layoutNodes = new MutableVector<>(new LayoutNode[16], 0);
    public static final int $stable = 8;

    private final void dispatchHierarchy(LayoutNode layoutNode) {
        if (layoutNode.getGloballyPositionedObservers() > 0) {
            layoutNode.dispatchOnPositionedCallbacks$ui_release();
            layoutNode.setNeedsOnGloballyPositionedDispatch$ui_release(false);
            MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
            LayoutNode[] layoutNodeArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                dispatchHierarchy(layoutNodeArr[i]);
            }
        }
    }

    public final void dispatch() {
        this.layoutNodes.sortWith(Companion.DepthComparator.INSTANCE);
        int size = this.layoutNodes.getSize();
        LayoutNode[] layoutNodeArr = this.cachedNodes;
        if (layoutNodeArr == null || layoutNodeArr.length < size) {
            layoutNodeArr = new LayoutNode[Math.max(16, this.layoutNodes.getSize())];
        }
        this.cachedNodes = null;
        for (int i = 0; i < size; i++) {
            layoutNodeArr[i] = this.layoutNodes.content[i];
        }
        this.layoutNodes.clear();
        while (true) {
            size--;
            if (-1 >= size) {
                this.cachedNodes = layoutNodeArr;
                return;
            }
            LayoutNode layoutNode = layoutNodeArr[size];
            k.c(layoutNode);
            if (layoutNode.getNeedsOnGloballyPositionedDispatch()) {
                dispatchHierarchy(layoutNode);
            }
            layoutNodeArr[size] = null;
        }
    }

    public final boolean isNotEmpty() {
        return this.layoutNodes.getSize() != 0;
    }

    public final void onNodePositioned(LayoutNode node) {
        if (node.getGloballyPositionedObservers() > 0) {
            this.layoutNodes.add(node);
            node.setNeedsOnGloballyPositionedDispatch$ui_release(true);
        }
    }

    public final void onRootNodePositioned(LayoutNode rootNode) {
        if (rootNode.getGloballyPositionedObservers() > 0) {
            this.layoutNodes.clear();
            this.layoutNodes.add(rootNode);
            rootNode.setNeedsOnGloballyPositionedDispatch$ui_release(true);
        }
    }

    public final void remove(LayoutNode node) {
        this.layoutNodes.remove(node);
    }
}
