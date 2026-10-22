package androidx.compose.ui.draganddrop;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.exifinterface.media.ExifInterface;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a3\u0010\u0000\u001a\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\nH\u0007\u001a%\u0010\u000b\u001a\u00020\f2\u001d\u0010\r\u001a\u0019\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000e¢\u0006\u0002\b\u0012\u001a1\u0010\u0013\u001a\u00020\u00142!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\t\u001a\u00020\n\u001a\u0014\u0010\u0015\u001a\u00020\u0011*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0004H\u0002\u001a\u001b\u0010\u0016\u001a\u00020\b*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a/\u0010\u001b\u001a\u00020\u0011\"\b\b\u0000\u0010\u001c*\u00020\u001d*\u0002H\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u00020\u001f0\u0003H\u0002¢\u0006\u0002\u0010 \u001a4\u0010!\u001a\u0004\u0018\u0001H\u001c\"\b\b\u0000\u0010\u001c*\u00020\u001d*\u0002H\u001c2\u0014\b\u0004\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u001c\u0012\u0004\u0012\u00020\b0\u0003H\u0082\b¢\u0006\u0002\u0010#¨\u0006$"}, d2 = {"DragAndDropModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "shouldStartDragAndDrop", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "Lkotlin/ParameterName;", "name", "event", "", PickerReporterConstants.KEY.TARGET, "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "DragAndDropSourceModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "onStartTransfer", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "", "Lkotlin/ExtensionFunctionType;", "DragAndDropTargetModifierNode", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "dispatchEntered", "contains", "Landroidx/compose/ui/draganddrop/DragAndDropNode;", "positionInRoot", "contains-Uv8p0NA", "(Landroidx/compose/ui/draganddrop/DragAndDropNode;J)Z", "traverseSelfAndDescendants", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/TraversableNode;", "block", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "firstDescendantOrNull", "predicate", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/node/TraversableNode;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DragAndDropNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use DragAndDropSourceModifierNode instead", replaceWith = @ReplaceWith(expression = "DragAndDropSourceModifierNode", imports = {}))
    public static final DragAndDropModifierNode DragAndDropModifierNode() {
        Object[] r100 = 0 == true ? 1 : 0;
        return new DragAndDropNode(null, r100, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropSourceModifierNode DragAndDropSourceModifierNode(Function2<? super DragAndDropStartTransferScope, ? super Offset, Unit> r100) {
        return new DragAndDropNode(r100, null, 2, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use DragAndDropTargetModifierNode instead", replaceWith = @ReplaceWith(expression = "DragAndDropTargetModifierNode", imports = {}))
    public static final DragAndDropModifierNode DragAndDropModifierNode(final Function1<? super DragAndDropEvent, Boolean> r100, final DragAndDropTarget r101) {
        Function2 r102 = null;
        return new DragAndDropNode(r102, new AnonymousClass1(r100, r101), 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final DragAndDropTargetModifierNode DragAndDropTargetModifierNode(final Function1<? super DragAndDropEvent, Boolean> r100, final DragAndDropTarget r101) {
        Function2 r102 = null;
        return new DragAndDropNode(r102, new C87351(r100, r101), 1, 0 == true ? 1 : 0);
    }

    /* JADX INFO: renamed from: access$contains-Uv8p0NA, reason: not valid java name */
    public static final /* synthetic */ boolean m4343access$containsUv8p0NA(DragAndDropNode r100, long r101) {
        return m4344containsUv8p0NA(r100, r101);
    }

    public static final /* synthetic */ void access$dispatchEntered(DragAndDropTarget r100, DragAndDropEvent r101) {
        dispatchEntered(r100, r101);
    }

    public static final /* synthetic */ void access$traverseSelfAndDescendants(TraversableNode r100, Function1 r101) {
        traverseSelfAndDescendants(r100, r101);
    }

    /* JADX INFO: renamed from: contains-Uv8p0NA, reason: not valid java name */
    private static final boolean m4344containsUv8p0NA(DragAndDropNode r100, long r110) {
        if (r100.getNode().isAttached() == true) goto L5;
        return false;
    L5:
        LayoutCoordinates r101 = DelegatableNodeKt.requireLayoutNode(r100).getCoordinates();
        if (r101.isAttached() == true) goto L8;
        return false;
    L8:
        long r102 = LayoutCoordinatesKt.positionInRoot(r101);
        float r103 = Float.intBitsToFloat((int) (r102 >> 32));
        float r104 = Float.intBitsToFloat((int) (r102 & BodyPartID.bodyIdMax));
        float r105 = ((int) (r100.m4338getSizeYbymL2g$ui_release() >> 32)) + r103;
        float r106 = ((int) (r100.m4338getSizeYbymL2g$ui_release() & BodyPartID.bodyIdMax)) + r104;
        float r107 = Float.intBitsToFloat((int) (r110 >> 32));
        if (r103 <= r107) goto L11;
    L13:
        boolean r108 = false;
    L14:
        if (r108 == false) goto L24;
        float r111 = Float.intBitsToFloat((int) (r110 & BodyPartID.bodyIdMax));
        if (r104 <= r111) goto L18;
    L20:
        boolean r109 = false;
    L21:
        if (r109 == false) goto L25;
        return true;
    L25:
        return false;
    L18:
        if (r111 > r106) goto L20;
        r109 = true;
        goto L21
    L24:
        return false;
    L11:
        if (r107 > r105) goto L13;
        r108 = true;
        goto L14
    }

    private static final void dispatchEntered(DragAndDropTarget r100, DragAndDropEvent r101) {
        r100.onEntered(r101);
        r100.onMoved(r101);
    }

    private static final <T extends TraversableNode> T firstDescendantOrNull(T r100, final Function1<? super T, Boolean> r101) {
        if (r100.getNode().isAttached() == true) goto L6;
        return null;
    L6:
        final Ref.ObjectRef r102 = new Ref.ObjectRef();
        TraversableNodeKt.traverseDescendants(r100, new C87361(r101, r102));
        return (T) r102.element;
    }

    private static final <T extends TraversableNode> void traverseSelfAndDescendants(T r100, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> r101) {
        if (r101.invoke(r100) == TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal) goto L5;
        return;
    L5:
        TraversableNodeKt.traverseDescendants(r100, r101);
    }
}
