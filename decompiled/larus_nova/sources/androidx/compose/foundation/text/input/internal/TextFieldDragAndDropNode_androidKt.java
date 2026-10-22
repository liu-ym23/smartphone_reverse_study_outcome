package androidx.compose.foundation.text.input.internal;

import android.content.ClipDescription;
import androidx.compose.foundation.content.MediaType;
import androidx.compose.ui.draganddrop.DragAndDropEvent;
import androidx.compose.ui.draganddrop.DragAndDropNodeKt;
import androidx.compose.ui.draganddrop.DragAndDropTargetModifierNode;
import androidx.compose.ui.draganddrop.DragAndDrop_androidKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.platform.ClipEntry;
import androidx.compose.ui.platform.ClipMetadata;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aÒ\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u000326\u0010\u0006\u001a2\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\f¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u0019\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00102%\b\u0002\u0010\u001b\u001a\u001f\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0010H\u0000¨\u0006\u001c"}, d2 = {"textFieldDragAndDropNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "hintMediaTypes", "Lkotlin/Function0;", "", "Landroidx/compose/foundation/content/MediaType;", "onDrop", "Lkotlin/Function2;", "Landroidx/compose/ui/platform/ClipEntry;", "Lkotlin/ParameterName;", "name", "clipEntry", "Landroidx/compose/ui/platform/ClipMetadata;", "clipMetadata", "", "dragAndDropRequestPermission", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "", "onStarted", "event", "onEntered", "onMoved", "Landroidx/compose/ui/geometry/Offset;", "position", "onChanged", "onExited", "onEnded", "foundation_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextFieldDragAndDropNode_androidKt {
    public static /* synthetic */ boolean a(Function0 r100, DragAndDropEvent r101) {
        return textFieldDragAndDropNode$lambda$1(r100, r101);
    }

    private static final boolean textFieldDragAndDropNode$lambda$1(Function0 r100, DragAndDropEvent r101) {
        ClipDescription r102 = DragAndDrop_androidKt.toAndroidDragEvent(r101).getClipDescription();
        Iterable r103 = (Iterable) r100.invoke();
        if ((r103 instanceof Collection) == true) goto L5;
    L7:
        Iterator r104 = r103.iterator();
    L9:
        if (r104.hasNext() == false) goto L26;
        MediaType r105 = (MediaType) r104.next();
        if (Intrinsics.areEqual(r105, MediaType.Companion.getAll()) == false) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == false) goto L9;
        return true;
    L13:
        if (r102.hasMimeType(r105.getRepresentation()) == true) goto L16;
        r106 = false;
        goto L17
    L26:
        return false;
    L5:
        if (((Collection) r103).isEmpty() == false) goto L7;
        return false;
    }

    public static final DragAndDropTargetModifierNode textFieldDragAndDropNode(final Function0<? extends Set<MediaType>> r110, final Function2<? super ClipEntry, ? super ClipMetadata, Boolean> r111, final Function1<? super DragAndDropEvent, Unit> r112, final Function1<? super DragAndDropEvent, Unit> r113, final Function1<? super DragAndDropEvent, Unit> r114, final Function1<? super Offset, Unit> r115, final Function1<? super DragAndDropEvent, Unit> r116, final Function1<? super DragAndDropEvent, Unit> r117, final Function1<? super DragAndDropEvent, Unit> r118) {
        return DragAndDropNodeKt.DragAndDropTargetModifierNode(new v1(r110), new AnonymousClass2(r112, r111, r113, r114, r115, r117, r116, r118));
    }

    public static /* synthetic */ DragAndDropTargetModifierNode textFieldDragAndDropNode$default(Function0 r110, Function2 r111, Function1 r112, Function1 r113, Function1 r114, Function1 r115, Function1 r116, Function1 r117, Function1 r210, int r211, Object r212) {
        if ((r211 & 8) == 0) goto L5;
        Function1 r100 = null;
    L7:
        if ((r211 & 16) == 0) goto L9;
        Function1 r101 = null;
    L11:
        if ((r211 & 32) == 0) goto L13;
        Function1 r102 = null;
    L15:
        if ((r211 & 64) == 0) goto L17;
        Function1 r103 = null;
    L19:
        if ((r211 & 128) == 0) goto L21;
        Function1 r118 = null;
    L23:
        if ((r211 & 256) == 0) goto L25;
        Function1 r119 = null;
    L27:
        return textFieldDragAndDropNode(r110, r111, r112, r100, r101, r102, r103, r118, r119);
    L25:
        r119 = r210;
        goto L27
    L21:
        r118 = r117;
        goto L23
    L17:
        r103 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
