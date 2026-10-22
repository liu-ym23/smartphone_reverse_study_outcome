package androidx.compose.ui.draganddrop;

import C7.c;
import S7.k;
import S7.n;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0001\u0010\u0002\u001a+\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0001\u0010\t\u001a'\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001b\u0010\u0016\u001a\u00020\r*\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u001b\u0010\u001c\u001a\u00020\u0005*\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010!\u001a\u00020\r\"\b\b\u0000\u0010\u001e*\u00020\u001d*\u00028\u00002\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001f0\u0003H\u0002¢\u0006\u0004\b!\u0010\"\u001a6\u0010$\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001e*\u00020\u001d*\u00028\u00002\u0014\b\u0004\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0003H\u0082\b¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "DragAndDropModifierNode", "()Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "shouldStartDragAndDrop", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", TypedValues.AttributesType.S_TARGET, "(LS7/k;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "LC7/r;", "onStartTransfer", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "DragAndDropSourceModifierNode", "(LS7/n;)Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "DragAndDropTargetModifierNode", "(LS7/k;Landroidx/compose/ui/draganddrop/DragAndDropTarget;)Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", NotificationCompat.CATEGORY_EVENT, "dispatchEntered", "(Landroidx/compose/ui/draganddrop/DragAndDropTarget;Landroidx/compose/ui/draganddrop/DragAndDropEvent;)V", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "positionInRoot", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;J)Z", "contains", "Landroidx/compose/ui/node/TraversableNode;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "block", "traverseSelfAndDescendants", "(Landroidx/compose/ui/node/TraversableNode;LS7/k;)V", "predicate", "firstDescendantOrNull", "(Landroidx/compose/ui/node/TraversableNode;LS7/k;)Landroidx/compose/ui/node/TraversableNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDropNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    @c
    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        return new DragAndDropNode(null, 0 == true ? 1 : 0, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropSourceModifierNode DragAndDropSourceModifierNode(n nVar) {
        return new DragAndDropNode(nVar, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropTargetModifierNode DragAndDropTargetModifierNode(final k kVar, final DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(null, new k() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropTargetModifierNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
                if (((Boolean) kVar.invoke(dragAndDropEvent)).booleanValue()) {
                    return dragAndDropTarget;
                }
                return null;
            }
        }, 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: contains-Uv8p0NA, reason: not valid java name */
    public static final boolean m3651containsUv8p0NA(DragAndDropNode dragAndDropNode, long j5) {
        if (!dragAndDropNode.getNode().getIsAttached()) {
            return false;
        }
        LayoutCoordinates coordinates = DelegatableNodeKt.requireLayoutNode(dragAndDropNode).getCoordinates();
        if (!coordinates.isAttached()) {
            return false;
        }
        long jPositionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jPositionInRoot >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jPositionInRoot & 4294967295L));
        float size = ((int) (dragAndDropNode.getSize() >> 32)) + fIntBitsToFloat;
        float size2 = ((int) (dragAndDropNode.getSize() & 4294967295L)) + fIntBitsToFloat2;
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (j5 >> 32));
        if (fIntBitsToFloat <= fIntBitsToFloat3 && fIntBitsToFloat3 <= size) {
            float fIntBitsToFloat4 = Float.intBitsToFloat((int) (j5 & 4294967295L));
            if (fIntBitsToFloat2 <= fIntBitsToFloat4 && fIntBitsToFloat4 <= size2) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void dispatchEntered(DragAndDropTarget dragAndDropTarget, DragAndDropEvent dragAndDropEvent) {
        dragAndDropTarget.onEntered(dragAndDropEvent);
        dragAndDropTarget.onMoved(dragAndDropEvent);
    }

    private static final <T extends TraversableNode> T firstDescendantOrNull(T t9, final k kVar) {
        if (!t9.getNode().getIsAttached()) {
            return null;
        }
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        TraversableNodeKt.traverseDescendants(t9, new k() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.firstDescendantOrNull.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction; */
            @Override // S7.k
            public final TraversableNode.Companion.TraverseDescendantsAction invoke(TraversableNode traversableNode) {
                if (!((Boolean) kVar.invoke(traversableNode)).booleanValue()) {
                    return TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
                }
                ref$ObjectRef.f4920a = traversableNode;
                return TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal;
            }
        });
        return (T) ref$ObjectRef.f4920a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T extends TraversableNode> void traverseSelfAndDescendants(T t9, k kVar) {
        if (kVar.invoke(t9) != TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal) {
            return;
        }
        TraversableNodeKt.traverseDescendants(t9, kVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @c
    public static final DragAndDropModifierNode DragAndDropModifierNode(final k kVar, final DragAndDropTarget dragAndDropTarget) {
        return new DragAndDropNode(null, new k() { // from class: androidx.compose.ui.draganddrop.DragAndDropNodeKt.DragAndDropModifierNode.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // S7.k
            public final DragAndDropTarget invoke(DragAndDropEvent dragAndDropEvent) {
                if (((Boolean) kVar.invoke(dragAndDropEvent)).booleanValue()) {
                    return dragAndDropTarget;
                }
                return null;
            }
        }, 1, 0 == true ? 1 : 0);
    }
}
