package androidx.compose.ui.draganddrop;

import D7.N;
import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.ui.geometry.Offset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.collections.builders.MapBuilder;
import kotlin.collections.builders.SetBuilder;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"toAndroidDragEvent", "Landroid/view/DragEvent;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "mimeTypes", "", "", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DragAndDrop_androidKt {
    public static final long getPositionInRoot(DragAndDropEvent dragAndDropEvent) {
        float x10 = dragAndDropEvent.getDragEvent().getX();
        float y = dragAndDropEvent.getDragEvent().getY();
        return Offset.m3887constructorimpl((Float.floatToRawIntBits(x10) << 32) | (Float.floatToRawIntBits(y) & 4294967295L));
    }

    public static final Set<String> mimeTypes(DragAndDropEvent dragAndDropEvent) {
        ClipDescription clipDescription = dragAndDropEvent.getDragEvent().getClipDescription();
        if (clipDescription == null) {
            return EmptySet.f4895a;
        }
        SetBuilder setBuilder = new SetBuilder(new MapBuilder(clipDescription.getMimeTypeCount()));
        int mimeTypeCount = clipDescription.getMimeTypeCount();
        for (int i = 0; i < mimeTypeCount; i++) {
            setBuilder.add(clipDescription.getMimeType(i));
        }
        return N.m(setBuilder);
    }

    public static final DragEvent toAndroidDragEvent(DragAndDropEvent dragAndDropEvent) {
        return dragAndDropEvent.getDragEvent();
    }
}
