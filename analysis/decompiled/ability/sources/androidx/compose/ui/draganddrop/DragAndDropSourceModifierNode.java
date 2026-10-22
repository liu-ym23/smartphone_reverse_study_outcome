package androidx.compose.ui.draganddrop;

import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0082\u0001\u0001\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/geometry/Offset;", TypedValues.CycleType.S_WAVE_OFFSET, "LC7/r;", "requestDragAndDropTransfer-k-4lQ0M", "(J)V", "requestDragAndDropTransfer", "", "isRequestDragAndDropTransferRequired", "()Z", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DragAndDropSourceModifierNode extends LayoutAwareModifierNode {
    boolean isRequestDragAndDropTransferRequired();

    /* renamed from: requestDragAndDropTransfer-k-4lQ0M */
    void mo3646requestDragAndDropTransferk4lQ0M(long offset);
}
