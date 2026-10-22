package androidx.compose.foundation.draganddrop;

import S7.k;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropModifierNode;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTarget;
import androidx.compose.ui.node.DelegatingNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B#\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\fJ)\u0010\u000e\u001a\u00020\n2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\tJ\u000f\u0010\u000f\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\fR\"\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0010R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropTargetNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "shouldStartDragAndDrop", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", TypedValues.AttributesType.S_TARGET, AppAgent.CONSTRUCT, "(LS7/k;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)V", "LC7/r;", "createAndAttachDragAndDropModifierNode", "()V", "onAttach", "update", "onDetach", "LS7/k;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "dragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DragAndDropTargetNode extends DelegatingNode {
    private DragAndDropModifierNode dragAndDropNode;
    private k shouldStartDragAndDrop;
    private DragAndDropTarget target;

    public DragAndDropTargetNode(k kVar, DragAndDropTarget dragAndDropTarget) {
        this.shouldStartDragAndDrop = kVar;
        this.target = dragAndDropTarget;
    }

    private final void createAndAttachDragAndDropModifierNode() {
        this.dragAndDropNode = (DragAndDropModifierNode) delegate(DragAndDropNodeKt.DragAndDropModifierNode(new k() { // from class: androidx.compose.foundation.draganddrop.DragAndDropTargetNode.createAndAttachDragAndDropModifierNode.1
            {
                super(1);
            }

            @Override // S7.k
            public final Boolean invoke(DragAndDropEvent dragAndDropEvent) {
                return (Boolean) DragAndDropTargetNode.this.shouldStartDragAndDrop.invoke(dragAndDropEvent);
            }
        }, this.target));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        createAndAttachDragAndDropModifierNode();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        DragAndDropModifierNode dragAndDropModifierNode = this.dragAndDropNode;
        kotlin.jvm.internal.k.c(dragAndDropModifierNode);
        undelegate(dragAndDropModifierNode);
    }

    public final void update(k shouldStartDragAndDrop, DragAndDropTarget target) {
        this.shouldStartDragAndDrop = shouldStartDragAndDrop;
        if (kotlin.jvm.internal.k.b(target, this.target)) {
            return;
        }
        DragAndDropModifierNode dragAndDropModifierNode = this.dragAndDropNode;
        if (dragAndDropModifierNode != null) {
            undelegate(dragAndDropModifierNode);
        }
        this.target = target;
        createAndAttachDragAndDropModifierNode();
    }
}
