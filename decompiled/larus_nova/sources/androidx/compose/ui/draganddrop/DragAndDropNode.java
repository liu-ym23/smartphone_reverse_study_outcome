package androidx.compose.ui.draganddrop;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u0000 E2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001EBD\u0012!\b\u0002\u0010\u0007\u001a\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\b\f\u0012\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010&\u001a\u00020\u000bH\u0016J\u0017\u0010'\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b(\u0010$J\u0017\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020\nH\u0016¢\u0006\u0004\b,\u0010$J'\u0010-\u001a\u00020\u000b*\u00020\t2\u0006\u0010+\u001a\u00020\n2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001d0/¢\u0006\u0004\b0\u00101J8\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0017\u00107\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000b0\u000e¢\u0006\u0002\b\fH\u0017¢\u0006\u0004\b9\u0010:J\u0010\u0010;\u001a\u00020\u001d2\u0006\u0010<\u001a\u00020\u000fH\u0016J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010?\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010@\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010A\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010B\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010C\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0010\u0010D\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000fH\u0016R'\u0010\u0007\u001a\u001b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\u0002\b\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001c\u001a\u00020\u001d8G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001eR\u001c\u0010\u001f\u001a\u00020 X\u0080\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020\u001d8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001e¨\u0006F"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/draganddrop/DragAndDropModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropSourceModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTargetModifierNode;", "Landroidx/compose/ui/draganddrop/DragAndDropTarget;", "onStartTransfer", "Lkotlin/Function2;", "Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;", "Landroidx/compose/ui/geometry/Offset;", "", "Lkotlin/ExtensionFunctionType;", "onDropTargetValidate", "Lkotlin/Function1;", "Landroidx/compose/ui/draganddrop/DragAndDropEvent;", "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;)V", "traverseKey", "", "getTraverseKey", "()Ljava/lang/Object;", "dragAndDropManager", "Landroidx/compose/ui/draganddrop/DragAndDropManager;", "getDragAndDropManager", "()Landroidx/compose/ui/draganddrop/DragAndDropManager;", "lastChildDragAndDropModifierNode", "thisDragAndDropTarget", "hasEligibleDropTarget", "", "()Z", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g$ui_release", "()J", "setSize-ozmzZPI$ui_release", "(J)V", "J", "onDetach", "onRemeasured", "onRemeasured-ozmzZPI", "isRequestDragAndDropTransferRequired", "requestDragAndDropTransfer", "offset", "requestDragAndDropTransfer-k-4lQ0M", "startDragAndDropTransfer", "isTransferStarted", "Lkotlin/Function0;", "startDragAndDropTransfer-d-4ec7I", "(Landroidx/compose/ui/draganddrop/DragAndDropStartTransferScope;JLkotlin/jvm/functions/Function0;)V", BitableAnalytic.ProgressInputType.DRAG, "transferData", "Landroidx/compose/ui/draganddrop/DragAndDropTransferData;", "decorationSize", "Landroidx/compose/ui/geometry/Size;", "drawDragDecoration", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "drag-12SF9DM", "(Landroidx/compose/ui/draganddrop/DragAndDropTransferData;JLkotlin/jvm/functions/Function1;)V", "acceptDragAndDropTransfer", "startEvent", "onStarted", "event", "onEntered", "onMoved", "onChanged", "onExited", "onDrop", "onEnded", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DragAndDropNode extends Modifier.Node implements TraversableNode, DragAndDropModifierNode, DragAndDropSourceModifierNode, DragAndDropTargetModifierNode, DragAndDropTarget {
    public static final int $stable = 0;
    private static final Companion Companion = null;
    private DragAndDropNode lastChildDragAndDropModifierNode;
    private final Function1<DragAndDropEvent, DragAndDropTarget> onDropTargetValidate;
    private Function2<? super DragAndDropStartTransferScope, ? super Offset, Unit> onStartTransfer;
    private long size;
    private DragAndDropTarget thisDragAndDropTarget;
    private final Object traverseKey;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion;", "", "<init>", "()V", "DragAndDropTraversableKey", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/draganddrop/DragAndDropNode$Companion$DragAndDropTraversableKey;", "", "<init>", "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class DragAndDropTraversableKey {
            public static final DragAndDropTraversableKey INSTANCE = null;

            static {
                INSTANCE = new DragAndDropTraversableKey();
            }

            private DragAndDropTraversableKey() {
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.thisDragAndDropTarget = null;
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    public final /* synthetic */ void onPlaced(LayoutCoordinates r100) {
        LayoutAwareModifierNode.CC.$default$onPlaced(this, r100);
    }

    public final boolean hasEligibleDropTarget() {
        if (this.lastChildDragAndDropModifierNode == null) goto L5;
    L8:
        return true;
    L5:
        if (this.thisDragAndDropTarget != null) goto L8;
        return false;
    }

    private final DragAndDropManager getDragAndDropManager() {
        return DelegatableNodeKt.requireOwner(this).getDragAndDropManager();
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    public boolean isRequestDragAndDropTransferRequired() {
        return getDragAndDropManager().isRequestDragAndDropTransferRequired();
    }

    /* JADX INFO: renamed from: getSize-YbymL2g$ui_release, reason: not valid java name */
    public final long m4338getSizeYbymL2g$ui_release() {
        return this.size;
    }

    @Override // androidx.compose.ui.node.TraversableNode
    public Object getTraverseKey() {
        return this.traverseKey;
    }

    public static final /* synthetic */ DragAndDropManager access$getDragAndDropManager(DragAndDropNode r100) {
        return r100.getDragAndDropManager();
    }

    public static final /* synthetic */ Function1 access$getOnDropTargetValidate$p(DragAndDropNode r100) {
        return r100.onDropTargetValidate;
    }

    public static final /* synthetic */ Function2 access$getOnStartTransfer$p(DragAndDropNode r100) {
        return r100.onStartTransfer;
    }

    public static final /* synthetic */ DragAndDropTarget access$getThisDragAndDropTarget$p(DragAndDropNode r100) {
        return r100.thisDragAndDropTarget;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    public boolean acceptDragAndDropTransfer(final DragAndDropEvent r100) {
        final Ref.BooleanRef r101 = new Ref.BooleanRef();
        DragAndDropNodeKt.access$traverseSelfAndDescendants(this, new AnonymousClass1(r100, this, r101));
        return r101.element;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onChanged(DragAndDropEvent r100) {
        DragAndDropTarget r101 = this.thisDragAndDropTarget;
        if (r101 != null) goto L7;
        DragAndDropNode r102 = this.lastChildDragAndDropModifierNode;
        if (r102 == null) goto L9;
        r102.onChanged(r100);
        return;
    L9:
        return;
    L7:
        r101.onChanged(r100);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public boolean onDrop(DragAndDropEvent r100) {
        DragAndDropNode r101 = this.lastChildDragAndDropModifierNode;
        if (r101 != null) goto L9;
        DragAndDropTarget r102 = this.thisDragAndDropTarget;
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.onDrop(r100);
    L9:
        return r101.onDrop(r100);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEnded(final DragAndDropEvent r100) {
        DragAndDropNodeKt.access$traverseSelfAndDescendants(this, new C87341(r100));
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onEntered(DragAndDropEvent r100) {
        DragAndDropTarget r101 = this.thisDragAndDropTarget;
        if (r101 != null) goto L7;
        DragAndDropNode r102 = this.lastChildDragAndDropModifierNode;
        if (r102 == null) goto L9;
        r102.onEntered(r100);
        return;
    L9:
        return;
    L7:
        r101.onEntered(r100);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onExited(DragAndDropEvent r100) {
        DragAndDropTarget r101 = this.thisDragAndDropTarget;
        if (r101 == null) goto L5;
        r101.onExited(r100);
    L5:
        DragAndDropNode r102 = this.lastChildDragAndDropModifierNode;
        if (r102 == null) goto L8;
        r102.onExited(r100);
    L8:
        this.lastChildDragAndDropModifierNode = null;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onMoved(final DragAndDropEvent r100) {
        DragAndDropNode r101 = this.lastChildDragAndDropModifierNode;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        if (r102 == false) goto L10;
        DragAndDropNode r103 = r101;
    L14:
        if (r103 == null) goto L19;
        if (r101 != null) goto L19;
        DragAndDropNodeKt.access$dispatchEntered(r103, r100);
        DragAndDropTarget r104 = this.thisDragAndDropTarget;
        if (r104 == null) goto L36;
        r104.onExited(r100);
    L36:
        this.lastChildDragAndDropModifierNode = r103;
        return;
    L19:
        if (r103 != null) goto L26;
        if (r101 == null) goto L26;
        DragAndDropTarget r105 = this.thisDragAndDropTarget;
        if (r105 == null) goto L24;
        DragAndDropNodeKt.access$dispatchEntered(r105, r100);
    L24:
        r101.onExited(r100);
    L26:
        if (Intrinsics.areEqual(r103, r101) == true) goto L31;
        if (r103 == null) goto L29;
        DragAndDropNodeKt.access$dispatchEntered(r103, r100);
    L29:
        if (r101 == null) goto L36;
        r101.onExited(r100);
        goto L36
    L31:
        if (r103 == null) goto L33;
        r103.onMoved(r100);
        goto L36
    L33:
        DragAndDropTarget r106 = this.thisDragAndDropTarget;
        if (r106 == null) goto L36;
        r106.onMoved(r100);
        goto L36
    L10:
        if (getNode().isAttached() == true) goto L12;
        TraversableNode r107 = null;
    L13:
        r103 = (DragAndDropNode) r107;
        goto L14
    L12:
        final Ref.ObjectRef r108 = new Ref.ObjectRef();
        TraversableNodeKt.traverseDescendants(this, new DragAndDropNode$onMoved$$inlined$firstDescendantOrNull$1(r108, this, r100));
        r107 = (TraversableNode) r108.element;
        goto L13
    L5:
        if (DragAndDropNodeKt.m4343access$containsUv8p0NA(r101, DragAndDrop_androidKt.getPositionInRoot(r100)) != true) goto L7;
        r102 = true;
        goto L7
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* JADX INFO: renamed from: onRemeasured-ozmzZPI */
    public void mo360onRemeasuredozmzZPI(long r100) {
        this.size = r100;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropTarget
    public void onStarted(DragAndDropEvent r100) {
        DragAndDropTarget r101 = this.thisDragAndDropTarget;
        if (r101 != null) goto L7;
        DragAndDropNode r102 = this.lastChildDragAndDropModifierNode;
        if (r102 == null) goto L9;
        r102.onStarted(r100);
        return;
    L9:
        return;
    L7:
        r101.onStarted(r100);
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropSourceModifierNode
    /* JADX INFO: renamed from: requestDragAndDropTransfer-k-4lQ0M, reason: not valid java name */
    public void mo4339requestDragAndDropTransferk4lQ0M(long r100) {
        if (this.onStartTransfer == null) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("Check failed.");
    L8:
        getDragAndDropManager().mo4335requestDragAndDropTransferUv8p0NA(this, r100);
        return;
    L5:
        r101 = false;
        goto L6
    }

    /* JADX INFO: renamed from: setSize-ozmzZPI$ui_release, reason: not valid java name */
    public final void m4340setSizeozmzZPI$ui_release(long r100) {
        this.size = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DragAndDropNode(Function2<? super DragAndDropStartTransferScope, ? super Offset, Unit> r100, Function1<? super DragAndDropEvent, ? extends DragAndDropTarget> r101) {
        this.onStartTransfer = r100;
        this.onDropTargetValidate = r101;
        this.traverseKey = Companion.DragAndDropTraversableKey.INSTANCE;
        this.size = IntSize.Companion.m7724getZeroYbymL2g();
    }

    public static final /* synthetic */ void access$setLastChildDragAndDropModifierNode$p(DragAndDropNode r100, DragAndDropNode r101) {
        r100.lastChildDragAndDropModifierNode = r101;
    }

    public static final /* synthetic */ void access$setThisDragAndDropTarget$p(DragAndDropNode r100, DragAndDropTarget r101) {
        r100.thisDragAndDropTarget = r101;
    }

    @Override // androidx.compose.ui.draganddrop.DragAndDropModifierNode
    @Deprecated(message = "Use DragAndDropSourceModifierNode.requestDragAndDropTransfer instead")
    /* JADX INFO: renamed from: drag-12SF9DM */
    public void mo4337drag12SF9DM(final DragAndDropTransferData r100, final long r101, final Function1<? super DrawScope, Unit> r102) {
        if (this.onStartTransfer != null) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("Check failed.");
    L8:
        this.onStartTransfer = new DragAndDropNode$drag$1(r100, r101, r102);
        getDragAndDropManager().mo4335requestDragAndDropTransferUv8p0NA(this, Offset.Companion.m4597getUnspecifiedF1C5BW0());
        this.onStartTransfer = null;
        return;
    L5:
        r103 = false;
        goto L6
    }

    /* JADX INFO: renamed from: startDragAndDropTransfer-d-4ec7I, reason: not valid java name */
    public final void m4341startDragAndDropTransferd4ec7I(final DragAndDropStartTransferScope r100, final long r101, final Function0<Boolean> r110) {
        final LayoutCoordinates r102 = DelegatableNodeKt.requireLayoutNode(this).getCoordinates();
        DragAndDropNodeKt.access$traverseSelfAndDescendants(this, new DragAndDropNode$startDragAndDropTransfer$1(r101, r102, r100, r110));
    }

    public /* synthetic */ DragAndDropNode(Function2 r100, Function1 r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
