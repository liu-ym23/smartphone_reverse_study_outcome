package androidx.compose.ui.draganddrop;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "", "onDrop", "", "event", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "onStarted", "", "onEntered", "onMoved", "onExited", "onChanged", "onEnded", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface DragAndDropTarget {

    /* JADX INFO: renamed from: androidx.compose.ui.draganddrop.DragAndDropTarget$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onChanged(DragAndDropTarget r100, DragAndDropEvent r101) {
        }

        public static void $default$onEnded(DragAndDropTarget r100, DragAndDropEvent r101) {
        }

        public static void $default$onEntered(DragAndDropTarget r100, DragAndDropEvent r101) {
        }

        public static void $default$onExited(DragAndDropTarget r100, DragAndDropEvent r101) {
        }

        public static void $default$onMoved(DragAndDropTarget r100, DragAndDropEvent r101) {
        }

        public static void $default$onStarted(DragAndDropTarget r100, DragAndDropEvent r101) {
        }
    }

    void onChanged(DragAndDropEvent r100);

    boolean onDrop(DragAndDropEvent r100);

    void onEnded(DragAndDropEvent r100);

    void onEntered(DragAndDropEvent r100);

    void onExited(DragAndDropEvent r100);

    void onMoved(DragAndDropEvent r100);

    void onStarted(DragAndDropEvent r100);
}
