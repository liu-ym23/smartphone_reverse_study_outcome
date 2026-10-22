package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_jvmKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u0001H\u0005\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u0005¢\u0006\u0002\u0010\u0006\u001a(\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\u0007\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\r\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000b0\n\u001a-\u0010\r\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\f\u001a(\u0010\u000e\u001a\u00020\b*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000f0\n\u001a-\u0010\u000e\u001a\u00020\b\"\b\b\u0000\u0010\u0005*\u00020\u0001*\u0002H\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u000f0\n¢\u0006\u0002\u0010\f¨\u0006\u0010"}, d2 = {"findNearestAncestor", "Landroidx/compose/ui/node/TraversableNode;", "Landroidx/compose/ui/node/DelegatableNode;", "key", "", ExifInterface.GPS_DIRECTION_TRUE, "(Landroidx/compose/ui/node/TraversableNode;)Landroidx/compose/ui/node/TraversableNode;", "traverseAncestors", "", "block", "Lkotlin/Function1;", "", "(Landroidx/compose/ui/node/TraversableNode;Lkotlin/jvm/functions/Function1;)V", "traverseChildren", "traverseDescendants", "Landroidx/compose/ui/node/TraversableNode$Companion$TraverseDescendantsAction;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TraversableNodeKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v12 */
    public static final <T extends TraversableNode> T findNearestAncestor(T r110) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r101 = r110.getNode().getParent$ui_release();
        LayoutNode r102 = DelegatableNodeKt.requireLayoutNode(r110);
    L7:
        if (r102 == null) goto L55;
        if ((r102.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r100) == 0) goto L49;
    L10:
        if (r101 == null) goto L49;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L48;
        Modifier.Node r103 = r101;
        MutableVector r104 = null;
    L14:
        if (r103 == 0) goto L48;
        if ((r103 instanceof TraversableNode) == true) goto L17;
        if ((r103.getKindSet$ui_release() & r100) == 0) goto L25;
        boolean r105 = true;
    L26:
        if (r105 == false) goto L47;
        if ((r103 instanceof DelegatingNode) == false) goto L47;
        Modifier.Node r106 = ((DelegatingNode) r103).getDelegate$ui_release();
        int r107 = 0;
        r103 = r103;
    L30:
        if (r106 == null) goto L45;
        if ((r106.getKindSet$ui_release() & r100) == 0) goto L34;
        boolean r111 = true;
    L35:
        if (r111 == false) goto L44;
        r107 = r107 + 1;
        if (r107 != 1) goto L39;
        r103 = r106;
        goto L44
    L39:
        if (r104 != null) goto L41;
        r104 = new MutableVector(new Modifier.Node[16], 0);
    L41:
        if (r103 == 0) goto L43;
        r104.add(r103);
        r103 = 0;
    L43:
        r104.add(r106);
    L44:
        r106 = r106.getChild$ui_release();
        r103 = r103;
        goto L30
    L34:
        r111 = false;
        goto L35
    L45:
        if (r107 == 1) goto L14;
    L47:
        r103 = DelegatableNodeKt.access$pop(r104);
        goto L14
    L25:
        r105 = false;
        goto L26
    L17:
        T r108 = (T) r103;
        if (Intrinsics.areEqual(r110.getTraverseKey(), r108.getTraverseKey()) == false) goto L47;
        if (Actual_jvmKt.areObjectsOfSameType(r110, r108) == false) goto L47;
        return r108;
    L48:
        r101 = r101.getParent$ui_release();
    L49:
        r102 = r102.getParent$ui_release();
        if (r102 == null) goto L54;
        NodeChain r109 = r102.getNodes$ui_release();
        if (r109 == null) goto L54;
        r101 = r109.getTail$ui_release();
    L54:
        r101 = null;
        goto L7
    L55:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12 */
    public static final TraversableNode findNearestAncestor(DelegatableNode r110, Object r111) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r101 = r110.getNode().getParent$ui_release();
        LayoutNode r112 = DelegatableNodeKt.requireLayoutNode(r110);
    L7:
        if (r112 == null) goto L53;
        if ((r112.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r100) == 0) goto L47;
    L10:
        if (r101 == null) goto L47;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L46;
        Modifier.Node r102 = r101;
        MutableVector r103 = null;
    L14:
        if (r102 == 0) goto L46;
        if ((r102 instanceof TraversableNode) == true) goto L17;
        if ((r102.getKindSet$ui_release() & r100) == 0) goto L23;
        boolean r104 = true;
    L24:
        if (r104 == false) goto L45;
        if ((r102 instanceof DelegatingNode) == false) goto L45;
        Modifier.Node r105 = ((DelegatingNode) r102).getDelegate$ui_release();
        int r106 = 0;
        r102 = r102;
    L28:
        if (r105 == null) goto L43;
        if ((r105.getKindSet$ui_release() & r100) == 0) goto L32;
        boolean r107 = true;
    L33:
        if (r107 == false) goto L42;
        r106 = r106 + 1;
        if (r106 != 1) goto L37;
        r102 = r105;
        goto L42
    L37:
        if (r103 != null) goto L39;
        r103 = new MutableVector(new Modifier.Node[16], 0);
    L39:
        if (r102 == 0) goto L41;
        r103.add(r102);
        r102 = 0;
    L41:
        r103.add(r105);
    L42:
        r105 = r105.getChild$ui_release();
        r102 = r102;
        goto L28
    L32:
        r107 = false;
        goto L33
    L43:
        if (r106 == 1) goto L14;
    L45:
        r102 = DelegatableNodeKt.access$pop(r103);
        goto L14
    L23:
        r104 = false;
        goto L24
    L17:
        TraversableNode r108 = (TraversableNode) r102;
        if (Intrinsics.areEqual(r111, r108.getTraverseKey()) == false) goto L45;
        return r108;
    L46:
        r101 = r101.getParent$ui_release();
    L47:
        r112 = r112.getParent$ui_release();
        if (r112 == null) goto L52;
        NodeChain r109 = r112.getNodes$ui_release();
        if (r109 == null) goto L52;
        r101 = r109.getTail$ui_release();
    L52:
        r101 = null;
        goto L7
    L53:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v14 */
    public static final <T extends TraversableNode> void traverseAncestors(T r110, Function1<? super T, Boolean> r111) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r101 = r110.getNode().getParent$ui_release();
        LayoutNode r102 = DelegatableNodeKt.requireLayoutNode(r110);
    L6:
        if (r102 == null) goto L56;
        if ((r102.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r100) == 0) goto L50;
    L9:
        if (r101 == null) goto L50;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L49;
        Modifier.Node r103 = r101;
        MutableVector r104 = null;
    L13:
        if (r103 == 0) goto L49;
        boolean r105 = true;
        if ((r103 instanceof TraversableNode) == true) goto L16;
        if ((r103.getKindSet$ui_release() & r100) == 0) goto L26;
        boolean r106 = true;
    L27:
        if (r106 == false) goto L48;
        if ((r103 instanceof DelegatingNode) == false) goto L48;
        Modifier.Node r107 = ((DelegatingNode) r103).getDelegate$ui_release();
        int r108 = 0;
        r103 = r103;
    L31:
        if (r107 == null) goto L46;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L35;
        boolean r112 = true;
    L36:
        if (r112 == false) goto L45;
        r108 = r108 + 1;
        if (r108 != 1) goto L40;
        r103 = r107;
        goto L45
    L40:
        if (r104 != null) goto L42;
        r104 = new MutableVector(new Modifier.Node[16], 0);
    L42:
        if (r103 == 0) goto L44;
        r104.add(r103);
        r103 = 0;
    L44:
        r104.add(r107);
    L45:
        r107 = r107.getChild$ui_release();
        r103 = r103;
        goto L31
    L35:
        r112 = false;
        goto L36
    L46:
        if (r108 == 1) goto L13;
    L48:
        r103 = DelegatableNodeKt.access$pop(r104);
        goto L13
    L26:
        r106 = false;
        goto L27
    L16:
        TraversableNode r109 = (TraversableNode) r103;
        if (Intrinsics.areEqual(r110.getTraverseKey(), r109.getTraverseKey()) == true) goto L19;
    L21:
        if (r105 == true) goto L48;
        return;
    L19:
        if (Actual_jvmKt.areObjectsOfSameType(r110, r109) == false) goto L21;
        r105 = r111.invoke(r109).booleanValue();
    L49:
        r101 = r101.getParent$ui_release();
    L50:
        r102 = r102.getParent$ui_release();
        if (r102 == null) goto L55;
        NodeChain r113 = r102.getNodes$ui_release();
        if (r113 == null) goto L55;
        r101 = r113.getTail$ui_release();
    L55:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v21 */
    public static final <T extends TraversableNode> void traverseChildren(T r110, Function1<? super T, Boolean> r111) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L5:
        MutableVector r101 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r102 = r110.getNode().getChild$ui_release();
        if (r102 != null) goto L8;
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r110.getNode(), false);
    L10:
        if (r101.getSize() == 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L59;
        Modifier.Node r104 = (Modifier.Node) r101.removeAt(r101.getSize() - 1);
        if ((r104.getAggregateChildKindSet$ui_release() & r100) == 0) goto L16;
    L17:
        if (r104 == 0) goto L10;
        if ((r104.getKindSet$ui_release() & r100) != 0) goto L20;
        r104 = r104.getChild$ui_release();
        goto L17
    L20:
        MutableVector r105 = null;
    L21:
        if (r104 == 0) goto L10;
        if ((r104 instanceof TraversableNode) == true) goto L24;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L35;
        boolean r106 = true;
    L36:
        if (r106 == false) goto L57;
        if ((r104 instanceof DelegatingNode) == false) goto L57;
        Modifier.Node r107 = ((DelegatingNode) r104).getDelegate$ui_release();
        int r108 = 0;
        r104 = r104;
    L40:
        if (r107 == null) goto L55;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L44;
        boolean r112 = true;
    L45:
        if (r112 == false) goto L54;
        r108 = r108 + 1;
        if (r108 != 1) goto L49;
        r104 = r107;
        goto L54
    L49:
        if (r105 != null) goto L51;
        r105 = new MutableVector(new Modifier.Node[16], 0);
    L51:
        if (r104 == 0) goto L53;
        r105.add(r104);
        r104 = 0;
    L53:
        r105.add(r107);
    L54:
        r107 = r107.getChild$ui_release();
        r104 = r104;
        goto L40
    L44:
        r112 = false;
        goto L45
    L55:
        if (r108 == 1) goto L21;
    L57:
        r104 = DelegatableNodeKt.access$pop(r105);
        goto L21
    L35:
        r106 = false;
        goto L36
    L24:
        TraversableNode r109 = (TraversableNode) r104;
        if (Intrinsics.areEqual(r110.getTraverseKey(), r109.getTraverseKey()) == true) goto L27;
    L29:
        boolean r113 = true;
    L30:
        if (r113 == true) goto L57;
        return;
    L27:
        if (Actual_jvmKt.areObjectsOfSameType(r110, r109) == false) goto L29;
        r113 = r111.invoke(r109).booleanValue();
        goto L30
    L16:
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r104, false);
        goto L10
    L59:
        return;
    L12:
        r103 = false;
        goto L13
    L8:
        r101.add(r102);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v13 */
    public static final <T extends TraversableNode> void traverseDescendants(T r110, Function1<? super T, ? extends TraversableNode.Companion.TraverseDescendantsAction> r111) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L5:
        MutableVector r101 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r102 = r110.getNode().getChild$ui_release();
        if (r102 != null) goto L8;
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r110.getNode(), false);
    L10:
        if (r101.getSize() == 0) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == false) goto L69;
        Modifier.Node r104 = (Modifier.Node) r101.removeAt(r101.getSize() - 1);
        if ((r104.getAggregateChildKindSet$ui_release() & r100) == 0) goto L68;
        Modifier.Node r105 = r104;
    L17:
        if (r105 == null) goto L68;
        if ((r105.getKindSet$ui_release() & r100) == 0) goto L67;
        Modifier.Node r106 = r105;
        MutableVector r107 = null;
    L21:
        if (r106 == 0) goto L65;
        if ((r106 instanceof TraversableNode) == true) goto L24;
        if ((r106.getKindSet$ui_release() & r100) == 0) goto L42;
        boolean r112 = true;
    L43:
        if (r112 == false) goto L64;
        if ((r106 instanceof DelegatingNode) == false) goto L64;
        Modifier.Node r113 = ((DelegatingNode) r106).getDelegate$ui_release();
        int r114 = 0;
        r106 = r106;
    L47:
        if (r113 == null) goto L62;
        if ((r113.getKindSet$ui_release() & r100) == 0) goto L51;
        boolean r115 = true;
    L52:
        if (r115 == false) goto L61;
        r114 = r114 + 1;
        if (r114 != 1) goto L56;
        r106 = r113;
        goto L61
    L56:
        if (r107 != null) goto L58;
        r107 = new MutableVector(new Modifier.Node[16], 0);
    L58:
        if (r106 == 0) goto L60;
        r107.add(r106);
        r106 = 0;
    L60:
        r107.add(r113);
    L61:
        r113 = r113.getChild$ui_release();
        r106 = r106;
        goto L47
    L51:
        r115 = false;
        goto L52
    L62:
        if (r114 == 1) goto L21;
    L64:
        r106 = DelegatableNodeKt.access$pop(r107);
        goto L21
    L42:
        r112 = false;
        goto L43
    L24:
        TraversableNode r108 = (TraversableNode) r106;
        if (Intrinsics.areEqual(r110.getTraverseKey(), r108.getTraverseKey()) == true) goto L27;
    L29:
        TraversableNode.Companion.TraverseDescendantsAction r109 = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
    L31:
        if (r109 == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) goto L32;
        if (r109 == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) goto L36;
        boolean r116 = true;
    L37:
        if (r116 == true) goto L64;
        boolean r117 = false;
    L66:
        if (r117 == false) goto L10;
    L36:
        r116 = false;
        goto L37
    L32:
        return;
    L27:
        if (Actual_jvmKt.areObjectsOfSameType(r110, r108) == false) goto L29;
        r109 = r111.invoke(r108);
        goto L31
    L65:
        r117 = true;
    L67:
        r105 = r105.getChild$ui_release();
    L68:
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r104, false);
        goto L10
    L69:
        return;
    L12:
        r103 = false;
        goto L13
    L8:
        r101.add(r102);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v14 */
    public static final void traverseAncestors(DelegatableNode r110, Object r111, Function1<? super TraversableNode, Boolean> r112) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r101 = r110.getNode().getParent$ui_release();
        LayoutNode r113 = DelegatableNodeKt.requireLayoutNode(r110);
    L6:
        if (r113 == null) goto L54;
        if ((r113.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r100) == 0) goto L48;
    L9:
        if (r101 == null) goto L48;
        if ((r101.getKindSet$ui_release() & r100) == 0) goto L47;
        Modifier.Node r102 = r101;
        MutableVector r103 = null;
    L13:
        if (r102 == 0) goto L47;
        boolean r104 = true;
        if ((r102 instanceof TraversableNode) == true) goto L16;
        if ((r102.getKindSet$ui_release() & r100) == 0) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L46;
        if ((r102 instanceof DelegatingNode) == false) goto L46;
        Modifier.Node r106 = ((DelegatingNode) r102).getDelegate$ui_release();
        int r107 = 0;
        r102 = r102;
    L29:
        if (r106 == null) goto L44;
        if ((r106.getKindSet$ui_release() & r100) == 0) goto L33;
        boolean r108 = true;
    L34:
        if (r108 == false) goto L43;
        r107 = r107 + 1;
        if (r107 != 1) goto L38;
        r102 = r106;
        goto L43
    L38:
        if (r103 != null) goto L40;
        r103 = new MutableVector(new Modifier.Node[16], 0);
    L40:
        if (r102 == 0) goto L42;
        r103.add(r102);
        r102 = 0;
    L42:
        r103.add(r106);
    L43:
        r106 = r106.getChild$ui_release();
        r102 = r102;
        goto L29
    L33:
        r108 = false;
        goto L34
    L44:
        if (r107 == 1) goto L13;
    L46:
        r102 = DelegatableNodeKt.access$pop(r103);
        goto L13
    L24:
        r105 = false;
        goto L25
    L16:
        TraversableNode r109 = (TraversableNode) r102;
        if (Intrinsics.areEqual(r111, r109.getTraverseKey()) == false) goto L19;
        r104 = r112.invoke(r109).booleanValue();
    L19:
        if (r104 == true) goto L46;
        return;
    L47:
        r101 = r101.getParent$ui_release();
    L48:
        r113 = r113.getParent$ui_release();
        if (r113 == null) goto L53;
        NodeChain r114 = r113.getNodes$ui_release();
        if (r114 == null) goto L53;
        r101 = r114.getTail$ui_release();
    L53:
        r101 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v19 */
    public static final void traverseChildren(DelegatableNode r110, Object r111, Function1<? super TraversableNode, Boolean> r112) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L5:
        MutableVector r101 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r102 = r110.getNode().getChild$ui_release();
        if (r102 != null) goto L8;
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r110.getNode(), false);
    L10:
        if (r101.getSize() == 0) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L57;
        Modifier.Node r114 = (Modifier.Node) r101.removeAt(r101.getSize() - 1);
        if ((r114.getAggregateChildKindSet$ui_release() & r100) == 0) goto L16;
    L17:
        if (r114 == 0) goto L10;
        if ((r114.getKindSet$ui_release() & r100) != 0) goto L20;
        r114 = r114.getChild$ui_release();
        goto L17
    L20:
        MutableVector r103 = null;
    L21:
        if (r114 == 0) goto L10;
        if ((r114 instanceof TraversableNode) == true) goto L24;
        if ((r114.getKindSet$ui_release() & r100) == 0) goto L33;
        boolean r104 = true;
    L34:
        if (r104 == false) goto L55;
        if ((r114 instanceof DelegatingNode) == false) goto L55;
        Modifier.Node r105 = ((DelegatingNode) r114).getDelegate$ui_release();
        int r106 = 0;
        r114 = r114;
    L38:
        if (r105 == null) goto L53;
        if ((r105.getKindSet$ui_release() & r100) == 0) goto L42;
        boolean r107 = true;
    L43:
        if (r107 == false) goto L52;
        r106 = r106 + 1;
        if (r106 != 1) goto L47;
        r114 = r105;
        goto L52
    L47:
        if (r103 != null) goto L49;
        r103 = new MutableVector(new Modifier.Node[16], 0);
    L49:
        if (r114 == 0) goto L51;
        r103.add(r114);
        r114 = 0;
    L51:
        r103.add(r105);
    L52:
        r105 = r105.getChild$ui_release();
        r114 = r114;
        goto L38
    L42:
        r107 = false;
        goto L43
    L53:
        if (r106 == 1) goto L21;
    L55:
        r114 = DelegatableNodeKt.access$pop(r103);
        goto L21
    L33:
        r104 = false;
        goto L34
    L24:
        TraversableNode r115 = (TraversableNode) r114;
        if (Intrinsics.areEqual(r111, r115.getTraverseKey()) == false) goto L27;
        boolean r116 = r112.invoke(r115).booleanValue();
    L28:
        if (r116 == true) goto L55;
        return;
    L27:
        r116 = true;
        goto L28
    L16:
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r114, false);
        goto L10
    L57:
        return;
    L12:
        r113 = false;
        goto L13
    L8:
        r101.add(r102);
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v13 */
    public static final void traverseDescendants(DelegatableNode r110, Object r111, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> r112) {
        int r100 = NodeKind.m6556constructorimpl(262144);
        if (r110.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L5:
        MutableVector r101 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r102 = r110.getNode().getChild$ui_release();
        if (r102 != null) goto L8;
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r110.getNode(), false);
    L10:
        if (r101.getSize() == 0) goto L12;
        boolean r113 = true;
    L13:
        if (r113 == false) goto L67;
        Modifier.Node r114 = (Modifier.Node) r101.removeAt(r101.getSize() - 1);
        if ((r114.getAggregateChildKindSet$ui_release() & r100) == 0) goto L66;
        Modifier.Node r103 = r114;
    L17:
        if (r103 == null) goto L66;
        if ((r103.getKindSet$ui_release() & r100) == 0) goto L65;
        Modifier.Node r104 = r103;
        MutableVector r105 = null;
    L21:
        if (r104 == 0) goto L63;
        if ((r104 instanceof TraversableNode) == true) goto L24;
        if ((r104.getKindSet$ui_release() & r100) == 0) goto L40;
        boolean r106 = true;
    L41:
        if (r106 == false) goto L62;
        if ((r104 instanceof DelegatingNode) == false) goto L62;
        Modifier.Node r107 = ((DelegatingNode) r104).getDelegate$ui_release();
        int r115 = 0;
        r104 = r104;
    L45:
        if (r107 == null) goto L60;
        if ((r107.getKindSet$ui_release() & r100) == 0) goto L49;
        boolean r116 = true;
    L50:
        if (r116 == false) goto L59;
        r115 = r115 + 1;
        if (r115 != 1) goto L54;
        r104 = r107;
        goto L59
    L54:
        if (r105 != null) goto L56;
        r105 = new MutableVector(new Modifier.Node[16], 0);
    L56:
        if (r104 == 0) goto L58;
        r105.add(r104);
        r104 = 0;
    L58:
        r105.add(r107);
    L59:
        r107 = r107.getChild$ui_release();
        r104 = r104;
        goto L45
    L49:
        r116 = false;
        goto L50
    L60:
        if (r115 == 1) goto L21;
    L62:
        r104 = DelegatableNodeKt.access$pop(r105);
        goto L21
    L40:
        r106 = false;
        goto L41
    L24:
        TraversableNode r108 = (TraversableNode) r104;
        if (Intrinsics.areEqual(r111, r108.getTraverseKey()) == false) goto L27;
        TraversableNode.Companion.TraverseDescendantsAction r109 = r112.invoke(r108);
    L29:
        if (r109 == TraversableNode.Companion.TraverseDescendantsAction.CancelTraversal) goto L30;
        if (r109 == TraversableNode.Companion.TraverseDescendantsAction.SkipSubtreeAndContinueTraversal) goto L34;
        boolean r117 = true;
    L35:
        if (r117 == true) goto L62;
        boolean r118 = false;
    L64:
        if (r118 == false) goto L10;
    L34:
        r117 = false;
        goto L35
    L30:
        return;
    L27:
        r109 = TraversableNode.Companion.TraverseDescendantsAction.ContinueTraversal;
        goto L29
    L63:
        r118 = true;
    L65:
        r103 = r103.getChild$ui_release();
    L66:
        DelegatableNodeKt.access$addLayoutNodeChildren(r101, r114, false);
        goto L10
    L67:
        return;
    L12:
        r113 = false;
        goto L13
    L8:
        r101.add(r102);
        goto L10
    }
}
