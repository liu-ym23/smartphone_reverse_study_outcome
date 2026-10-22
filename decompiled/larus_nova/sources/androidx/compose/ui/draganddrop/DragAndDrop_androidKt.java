package androidx.compose.ui.draganddrop;

import android.content.ClipDescription;
import android.view.DragEvent;
import androidx.compose.ui.geometry.Offset;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u0002\"\u0018\u0010\u0006\u001a\u00020\u0007*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"toAndroidDragEvent", "Landroid/view/DragEvent;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "mimeTypes", "", "", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot", "(Landroidx/compose/ui/draganddrop/DragAndDropEvent;)J", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragAndDrop_androidKt {
    public static final long getPositionInRoot(DragAndDropEvent r100) {
        float r101 = r100.getDragEvent$ui_release().getX();
        float r102 = r100.getDragEvent$ui_release().getY();
        return Offset.m4574constructorimpl((Float.floatToRawIntBits(r101) << 32) | (((long) Float.floatToRawIntBits(r102)) & BodyPartID.bodyIdMax));
    }

    public static final Set<String> mimeTypes(DragAndDropEvent r100) {
        ClipDescription r101 = r100.getDragEvent$ui_release().getClipDescription();
        if (r101 == null) goto L5;
        Set r102 = SetsKt.createSetBuilder(r101.getMimeTypeCount());
        int r103 = r101.getMimeTypeCount();
        int r104 = 0;
    L7:
        if (r104 >= r103) goto L10;
        r102.add(r101.getMimeType(r104));
        r104 = r104 + 1;
        goto L7
    L10:
        return SetsKt.build(r102);
    L5:
        return SetsKt.emptySet();
    }

    public static final DragEvent toAndroidDragEvent(DragAndDropEvent r100) {
        return r100.getDragEvent$ui_release();
    }
}
