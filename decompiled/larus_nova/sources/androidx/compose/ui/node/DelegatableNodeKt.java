package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a3\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u000b*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a\"\u0010\u0011\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u000b0\u000e2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0001H\u0002\u001a1\u0010\u0013\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a1\u0010\u0014\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\nH\u0080\b\u001a)\u0010\u0015\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a3\u0010\u0015\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a)\u0010\u0016\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nH\u0080\b\u001a>\u0010\u0017\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001b\u0010\u001c\u001a>\u0010\u0015\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001d\u0010\u001c\u001a>\u0010\u0016\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001e\u0010\u001c\u001aH\u0010\u0004\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\b\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b\u001f\u0010 \u001aJ\u0010!\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b#\u0010$\u001a2\u0010%\u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010&\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0080\b¢\u0006\u0004\b'\u0010(\u001a0\u0010\f\u001a\u0004\u0018\u0001H\u0018\"\n\b\u0000\u0010\u0018\u0018\u0001*\u00020)*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001aH\u0080\b¢\u0006\u0004\b*\u0010+\u001aH\u0010\u0013\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b,\u0010 \u001aH\u0010-\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b.\u0010 \u001aH\u0010\u0014\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00010\nH\u0080\b¢\u0006\u0004\b/\u0010 \u001aH\u00100\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\b\b\u0002\u0010\u0010\u001a\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\b1\u0010 \u001a\u001f\u00102\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u00105\u001a\u000206*\u00020\u00022\n\u00107\u001a\u0006\u0012\u0002\b\u00030\u001aH\u0000¢\u0006\u0004\b8\u00109\u001a\f\u0010:\u001a\u00020\u000f*\u00020\u0002H\u0000\u001a\f\u0010;\u001a\u00020<*\u00020\u0002H\u0000\u001a\f\u0010=\u001a\u00020>*\u00020\u0002H\u0000\u001a\n\u0010?\u001a\u00020\u0005*\u00020\u0002\u001a\n\u0010@\u001a\u00020A*\u00020\u0002\u001a\n\u0010B\u001a\u00020C*\u00020\u0002\u001a\n\u0010D\u001a\u00020E*\u00020\u0002\u001a\n\u0010F\u001a\u00020G*\u00020\u0002\u001a\n\u0010H\u001a\u00020\u0005*\u00020\u0002\u001a\u0019\u0010I\u001a\u00020\u0005*\u00020\u00022\u0006\u0010J\u001a\u00020K¢\u0006\u0004\bL\u0010M\u001a\u000e\u0010N\u001a\u0004\u0018\u00010O*\u00020\u000bH\u0000\u001a>\u0010P\u001a\u00020\u0005\"\u0006\b\u0000\u0010\u0018\u0018\u0001*\u00020\u000b2\f\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001a2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u00020\u00050\nH\u0080\b¢\u0006\u0004\bQ\u0010R\u001a\u0016\u0010S\u001a\u0004\u0018\u00010\u000b*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000eH\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006T"}, d2 = {"isDelegationRoot", "", "Landroidx/compose/ui/node/DelegatableNode;", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "visitAncestors", "", BuyNowCloseMethod.MASK, "", "includeSelf", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Node;", "nearestAncestor", "getChildren", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "zOrder", "addLayoutNodeChildren", "node", "visitChildren", "visitSubtreeIf", "visitLocalDescendants", "visitLocalAncestors", "visitSelfAndLocalDescendants", ExifInterface.GPS_DIRECTION_TRUE, "type", "Landroidx/compose/ui/node/NodeKind;", "visitSelfAndLocalDescendants-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitLocalDescendants-6rFNWt0", "visitLocalAncestors-6rFNWt0", "visitAncestors-Y-YKmho", "(Landroidx/compose/ui/node/DelegatableNode;IZLkotlin/jvm/functions/Function1;)V", "visitSelfAndAncestors", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILkotlin/jvm/functions/Function1;)V", "ancestors", "", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "visitChildren-Y-YKmho", "visitSelfAndChildren", "visitSelfAndChildren-Y-YKmho", "visitSubtreeIf-Y-YKmho", "visitSubtree", "visitSubtree-Y-YKmho", "has", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "requireSemanticsInfo", "Landroidx/compose/ui/semantics/SemanticsInfo;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "requestAutofill", "requireDensity", "Landroidx/compose/ui/unit/Density;", "requireGraphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invalidateSubtree", "dispatchOnScrollChanged", "delta", "Landroidx/compose/ui/geometry/Offset;", "dispatchOnScrollChanged-Uv8p0NA", "(Landroidx/compose/ui/node/DelegatableNode;J)V", "asLayoutModifierNode", "Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILkotlin/jvm/functions/Function1;)V", "pop", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class DelegatableNodeKt {
    public static final /* synthetic */ Modifier.Node access$pop(MutableVector r100) {
        return pop(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node r100) {
        if ((NodeKind.m6556constructorimpl(2) & r100.getKindSet$ui_release()) == 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        return null;
    L10:
        if ((r100 instanceof LayoutModifierNode) == false) goto L14;
        return (LayoutModifierNode) r100;
    L14:
        if ((r100 instanceof DelegatingNode) == false) goto L30;
        Modifier.Node r102 = ((DelegatingNode) r100).getDelegate$ui_release();
    L16:
        if (r102 == 0) goto L30;
        if ((r102 instanceof LayoutModifierNode) == true) goto L20;
        if ((r102 instanceof DelegatingNode) == false) goto L29;
        if ((NodeKind.m6556constructorimpl(2) & r102.getKindSet$ui_release()) == 0) goto L26;
        boolean r103 = true;
    L27:
        if (r103 == false) goto L29;
        r102 = ((DelegatingNode) r102).getDelegate$ui_release();
        goto L16
    L26:
        r103 = false;
    L29:
        r102 = r102.getChild$ui_release();
        goto L16
    L20:
        return (LayoutModifierNode) r102;
    L30:
        return null;
    L5:
        r101 = false;
        goto L7
    }

    public static final void invalidateSubtree(DelegatableNode r100) {
        if (r100.getNode().isAttached() == false) goto L6;
        LayoutNode.invalidateSubtree$default(requireLayoutNode(r100), false, 1, null);
        return;
    }

    public static final boolean isDelegationRoot(DelegatableNode r100) {
        if (r100.getNode() != r100) goto L5;
        return true;
    L5:
        return false;
    }

    private static final Modifier.Node pop(MutableVector<Modifier.Node> r100) {
        if (r100 != null) goto L4;
    L10:
        return null;
    L4:
        if (r100.getSize() != 0) goto L6;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        return r100.removeAt(r100.getSize() - 1);
    L6:
        r101 = false;
        goto L7
    }

    public static final void requestAutofill(DelegatableNode r100) {
        requireLayoutNode(r100).requestAutofill$ui_release();
    }

    public static final Density requireDensity(DelegatableNode r100) {
        return requireLayoutNode(r100).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode r100) {
        return requireOwner(r100).getGraphicsContext();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(DelegatableNode r100) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
    L5:
        LayoutCoordinates r101 = m6409requireCoordinator64DMado(r100, NodeKind.m6556constructorimpl(2)).getCoordinates();
        if (r101.isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
    L8:
        return r101;
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode r100) {
        return requireLayoutNode(r100).getLayoutDirection();
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode r100) {
        NodeCoordinator r101 = r100.getNode().getCoordinator$ui_release();
        if (r101 != null) goto L5;
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("Cannot obtain node coordinator. Is the Modifier.Node attached?");
        throw new KotlinNothingValueException();
    L5:
        return r101.getLayoutNode();
    }

    public static final Owner requireOwner(DelegatableNode r100) {
        Owner r101 = requireLayoutNode(r100).getOwner$ui_release();
        if (r101 == null) goto L5;
        return r101;
    L5:
        InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("This node does not have an owner.");
        throw new KotlinNothingValueException();
    }

    public static final SemanticsInfo requireSemanticsInfo(DelegatableNode r100) {
        return requireLayoutNode(r100);
    }

    /* JADX INFO: renamed from: ancestors-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> List<T> m6404ancestors64DMado(DelegatableNode r100, int r101) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r102 = r100.getNode().getParent$ui_release();
        LayoutNode r103 = requireLayoutNode(r100);
        ArrayList r104 = null;
    L6:
        if (r103 == null) goto L25;
        if ((r103.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L19;
    L9:
        if (r102 == null) goto L19;
        if ((r102.getKindSet$ui_release() & r101) == 0) goto L18;
        Modifier.Node r105 = r102;
    L13:
        if (r105 == null) goto L18;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (r104 != null) goto L17;
        r104 = new ArrayList();
    L17:
        r104.add(r105);
        r105 = access$pop(null);
    L18:
        r102 = r102.getParent$ui_release();
    L19:
        r103 = r103.getParent$ui_release();
        if (r103 == null) goto L24;
        NodeChain r106 = r103.getNodes$ui_release();
        if (r106 == null) goto L24;
        r102 = r106.getTail$ui_release();
    L24:
        r102 = null;
        goto L6
    L25:
        return r104;
    }

    /* JADX INFO: renamed from: dispatchOnScrollChanged-Uv8p0NA, reason: not valid java name */
    public static final void m6406dispatchOnScrollChangedUv8p0NA(DelegatableNode r100, long r101) {
        requireOwner(r100).mo6618dispatchOnScrollChangedk4lQ0M(r101);
    }

    private static final MutableVector<LayoutNode> getChildren(LayoutNode r100, boolean r101) {
        if (r101 == false) goto L5;
        return r100.getZSortedChildren();
    L5:
        return r100.get_children$ui_release();
    }

    /* JADX INFO: renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m6407has64DMado(DelegatableNode r100, int r101) {
        if ((r100.getNode().getAggregateChildKindSet$ui_release() & r101) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode r100, int r101) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
    L5:
        Modifier.Node r102 = r100.getNode().getParent$ui_release();
        LayoutNode r103 = requireLayoutNode(r100);
    L7:
        if (r103 == null) goto L21;
        if ((r103.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L15;
    L10:
        if (r102 == null) goto L15;
        if ((r102.getKindSet$ui_release() & r101) != 0) goto L13;
        r102 = r102.getParent$ui_release();
        goto L10
    L13:
        return r102;
    L15:
        r103 = r103.getParent$ui_release();
        if (r103 == null) goto L20;
        NodeChain r104 = r103.getNodes$ui_release();
        if (r104 == null) goto L20;
        r102 = r104.getTail$ui_release();
    L20:
        r102 = null;
        goto L7
    L21:
        return null;
    }

    /* JADX INFO: renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m6408nearestAncestor64DMado(DelegatableNode r100, int r101) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Object r102 = r100.getNode().getParent$ui_release();
        LayoutNode r103 = requireLayoutNode(r100);
    L7:
        if (r103 == null) goto L22;
        if ((r103.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L16;
    L10:
        if (r102 == null) goto L16;
        if ((((Modifier.Node) r102).getKindSet$ui_release() & r101) != 0) goto L13;
        r102 = (T) ((Modifier.Node) r102).getParent$ui_release();
        goto L10
    L13:
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) r102;
    L16:
        r103 = r103.getParent$ui_release();
        if (r103 == null) goto L21;
        NodeChain r104 = r103.getNodes$ui_release();
        if (r104 == null) goto L21;
        r102 = (T) r104.getTail$ui_release();
    L21:
        r102 = (T) null;
        goto L7
    L22:
        return null;
    }

    /* JADX INFO: renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m6409requireCoordinator64DMado(DelegatableNode r100, int r101) {
        NodeCoordinator r102 = r100.getNode().getCoordinator$ui_release();
        Intrinsics.checkNotNull(r102);
        if (r102.getTail() == r100) goto L6;
        return r102;
    L6:
        if (NodeKindKt.m6565getIncludeSelfInTraversalH91voCI(r101) == false) goto L9;
        NodeCoordinator r103 = r102.getWrapped$ui_release();
        Intrinsics.checkNotNull(r103);
        return r103;
    L9:
        return r102;
    }

    public static final /* synthetic */ void access$addLayoutNodeChildren(MutableVector r100, Modifier.Node r101, boolean r102) {
        addLayoutNodeChildren(r100, r101, r102);
    }

    private static final void addLayoutNodeChildren(MutableVector<Modifier.Node> r100, Modifier.Node r101, boolean r102) {
        MutableVector<LayoutNode> r103 = getChildren(requireLayoutNode(r101), r102);
        int r104 = r103.getSize() - 1;
        LayoutNode[] r105 = r103.content;
        if (r104 >= r105.length) goto L6;
    L4:
        if (r104 < 0) goto L8;
        r100.add(r105[r104].getNodes$ui_release().getHead$ui_release());
        r104 = r104 - 1;
        goto L4
    L8:
        return;
    }

    /* JADX INFO: renamed from: dispatchForKind-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m6405dispatchForKind6rFNWt0(Modifier.Node r100, int r101, Function1<? super T, Unit> r102) {
    L2:
        if (r100 == null) goto L4;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r102.invoke(r100);
        r100 = access$pop(null);
        goto L2
    }

    public static final void visitLocalAncestors(DelegatableNode r100, int r101, Function1<? super Modifier.Node, Unit> r102) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
    L5:
        Modifier.Node r103 = r100.getNode().getParent$ui_release();
    L6:
        if (r103 == null) goto L11;
        if ((r103.getKindSet$ui_release() & r101) == 0) goto L10;
        r102.invoke(r103);
    L10:
        r103 = r103.getParent$ui_release();
        goto L6
    }

    /* JADX INFO: renamed from: visitLocalAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m6414visitLocalAncestors6rFNWt0(DelegatableNode r100, int r101, Function1<? super T, Unit> r102) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
    L5:
        Modifier.Node r103 = r100.getNode().getParent$ui_release();
    L6:
        if (r103 == null) goto L13;
        if ((r103.getKindSet$ui_release() & r101) == 0) goto L12;
        Modifier.Node r104 = r103;
    L10:
        if (r104 == null) goto L12;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r102.invoke(r104);
        r104 = access$pop(null);
    L12:
        r103 = r103.getParent$ui_release();
        goto L6
    }

    public static final void visitLocalDescendants(DelegatableNode r100, int r101, Function1<? super Modifier.Node, Unit> r102) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L5:
        Modifier.Node r103 = r100.getNode();
        if ((r103.getAggregateChildKindSet$ui_release() & r101) == 0) goto L13;
        Modifier.Node r104 = r103.getChild$ui_release();
    L8:
        if (r104 == null) goto L17;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L12;
        r102.invoke(r104);
    L12:
        r104 = r104.getChild$ui_release();
        goto L8
    L17:
        return;
    }

    /* JADX INFO: renamed from: visitLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m6415visitLocalDescendants6rFNWt0(DelegatableNode r100, int r101, Function1<? super T, Unit> r102) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L5:
        Modifier.Node r103 = r100.getNode();
        if ((r103.getAggregateChildKindSet$ui_release() & r101) == 0) goto L15;
        Modifier.Node r104 = r103.getChild$ui_release();
    L8:
        if (r104 == null) goto L19;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L14;
        Modifier.Node r105 = r104;
    L12:
        if (r105 == null) goto L14;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r102.invoke(r105);
        r105 = access$pop(null);
    L14:
        r104 = r104.getChild$ui_release();
        goto L8
    L19:
        return;
    }

    /* JADX INFO: renamed from: visitSelfAndLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m6419visitSelfAndLocalDescendants6rFNWt0(DelegatableNode r100, int r101, Function1<? super T, Unit> r102) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L5:
        Modifier.Node r103 = r100.getNode();
        if ((r103.getAggregateChildKindSet$ui_release() & r101) == 0) goto L14;
    L7:
        if (r103 == null) goto L18;
        if ((r103.getKindSet$ui_release() & r101) == 0) goto L13;
        Modifier.Node r104 = r103;
    L11:
        if (r104 == null) goto L13;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r102.invoke(r104);
        r104 = access$pop(null);
    L13:
        r103 = r103.getChild$ui_release();
        goto L7
    L18:
        return;
    }

    public static final void visitAncestors(DelegatableNode r100, int r101, boolean r102, Function1<? super Modifier.Node, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        if (r102 == false) goto L7;
        Modifier.Node r104 = r100.getNode();
    L8:
        LayoutNode r105 = requireLayoutNode(r100);
    L9:
        if (r105 == null) goto L23;
        if ((r105.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L17;
    L12:
        if (r104 == null) goto L17;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L16;
        r103.invoke(r104);
    L16:
        r104 = r104.getParent$ui_release();
    L17:
        r105 = r105.getParent$ui_release();
        if (r105 == null) goto L22;
        NodeChain r106 = r105.getNodes$ui_release();
        if (r106 == null) goto L22;
        r104 = r106.getTail$ui_release();
    L22:
        r104 = null;
        goto L9
    L23:
        return;
    L7:
        r104 = r100.getNode().getParent$ui_release();
        goto L8
    }

    /* JADX INFO: renamed from: visitAncestors-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m6410visitAncestorsYYKmho(DelegatableNode r100, int r101, boolean r102, Function1<? super T, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        if (r102 == false) goto L7;
        Modifier.Node r104 = r100.getNode();
    L8:
        LayoutNode r105 = requireLayoutNode(r100);
    L9:
        if (r105 == null) goto L25;
        if ((r105.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L19;
    L12:
        if (r104 == null) goto L19;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L18;
        Modifier.Node r106 = r104;
    L16:
        if (r106 == null) goto L18;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r106);
        r106 = access$pop(null);
    L18:
        r104 = r104.getParent$ui_release();
    L19:
        r105 = r105.getParent$ui_release();
        if (r105 == null) goto L24;
        NodeChain r107 = r105.getNodes$ui_release();
        if (r107 == null) goto L24;
        r104 = r107.getTail$ui_release();
    L24:
        r104 = null;
        goto L9
    L25:
        return;
    L7:
        r104 = r100.getNode().getParent$ui_release();
        goto L8
    }

    public static final void visitChildren(DelegatableNode r100, int r101, boolean r102, Function1<? super Modifier.Node, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L5:
        MutableVector r104 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r105 = r100.getNode().getChild$ui_release();
        if (r105 != null) goto L8;
        access$addLayoutNodeChildren(r104, r100.getNode(), r102);
    L10:
        if (r104.getSize() == 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L22;
        Modifier.Node r107 = (Modifier.Node) r104.removeAt(r104.getSize() - 1);
        if ((r107.getAggregateChildKindSet$ui_release() & r101) == 0) goto L16;
    L17:
        if (r107 == null) goto L10;
        if ((r107.getKindSet$ui_release() & r101) != 0) goto L20;
        r107 = r107.getChild$ui_release();
        goto L17
    L20:
        r103.invoke(r107);
        goto L10
    L16:
        access$addLayoutNodeChildren(r104, r107, r102);
        goto L10
    L22:
        return;
    L12:
        r106 = false;
        goto L13
    L8:
        r104.add(r105);
        goto L10
    }

    /* JADX INFO: renamed from: visitChildren-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m6412visitChildrenYYKmho(DelegatableNode r100, int r101, boolean r102, Function1<? super T, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L5:
        MutableVector r104 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r105 = r100.getNode().getChild$ui_release();
        if (r105 != null) goto L8;
        access$addLayoutNodeChildren(r104, r100.getNode(), r102);
    L10:
        if (r104.getSize() == 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L23;
        Modifier.Node r107 = (Modifier.Node) r104.removeAt(r104.getSize() - 1);
        if ((r107.getAggregateChildKindSet$ui_release() & r101) == 0) goto L16;
    L17:
        if (r107 == null) goto L10;
        if ((r107.getKindSet$ui_release() & r101) != 0) goto L20;
        r107 = r107.getChild$ui_release();
    L20:
        if (r107 == null) goto L10;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r107);
        r107 = access$pop(null);
        goto L20
    L16:
        access$addLayoutNodeChildren(r104, r107, r102);
        goto L10
    L23:
        return;
    L12:
        r106 = false;
        goto L13
    L8:
        r104.add(r105);
        goto L10
    }

    public static final void visitLocalDescendants(DelegatableNode r100, int r101, boolean r102, Function1<? super Modifier.Node, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L5:
        Modifier.Node r104 = r100.getNode();
        if ((r104.getAggregateChildKindSet$ui_release() & r101) != 0) goto L8;
        return;
    L8:
        if (r102 == true) goto L11;
        r104 = r104.getChild$ui_release();
    L11:
        if (r104 == null) goto L16;
        if ((r104.getKindSet$ui_release() & r101) == 0) goto L15;
        r103.invoke(r104);
    L15:
        r104 = r104.getChild$ui_release();
        goto L11
    }

    /* JADX INFO: renamed from: visitSelfAndAncestors-5BbP62I, reason: not valid java name */
    public static final /* synthetic */ <T> void m6416visitSelfAndAncestors5BbP62I(DelegatableNode r100, int r101, int r102, Function1<? super T, Unit> r110) {
        Modifier.Node r103 = r100.getNode();
        int r104 = r101 | r102;
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L5:
        Modifier.Node r105 = r100.getNode();
        LayoutNode r106 = requireLayoutNode(r100);
    L6:
        if (r106 == null) goto L35;
        if ((r106.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r104) == 0) goto L29;
    L9:
        if (r105 == null) goto L29;
        if ((r105.getKindSet$ui_release() & r104) == 0) goto L28;
        boolean r107 = true;
        if (r105 == r103) goto L21;
        if ((r105.getKindSet$ui_release() & r102) == 0) goto L17;
        boolean r108 = true;
    L18:
        if (r108 == false) goto L21;
        return;
    L17:
        r108 = false;
    L21:
        if ((r105.getKindSet$ui_release() & r101) != 0) goto L24;
        r107 = false;
    L24:
        if (r107 == false) goto L28;
        Modifier.Node r109 = r105;
    L26:
        if (r109 == null) goto L28;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r110.invoke(r109);
        r109 = access$pop(null);
    L28:
        r105 = r105.getParent$ui_release();
    L29:
        r106 = r106.getParent$ui_release();
        if (r106 == null) goto L34;
        NodeChain r111 = r106.getNodes$ui_release();
        if (r111 == null) goto L34;
        r105 = r111.getTail$ui_release();
    L34:
        r105 = null;
        goto L6
    }

    /* JADX INFO: renamed from: visitSelfAndChildren-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m6417visitSelfAndChildrenYYKmho(DelegatableNode r100, int r101, boolean r102, Function1<? super T, Unit> r103) {
        Modifier.Node r104 = r100.getNode();
    L4:
        if (r104 == null) goto L7;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r104);
        r104 = access$pop(null);
        goto L4
    L7:
        if (r100.getNode().isAttached() == true) goto L9;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L9:
        MutableVector r105 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r106 = r100.getNode().getChild$ui_release();
        if (r106 != null) goto L12;
        access$addLayoutNodeChildren(r105, r100.getNode(), r102);
    L14:
        if (r105.getSize() == 0) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L27;
        Modifier.Node r108 = (Modifier.Node) r105.removeAt(r105.getSize() - 1);
        if ((r108.getAggregateChildKindSet$ui_release() & r101) == 0) goto L20;
    L21:
        if (r108 == null) goto L14;
        if ((r108.getKindSet$ui_release() & r101) != 0) goto L24;
        r108 = r108.getChild$ui_release();
    L24:
        if (r108 == null) goto L14;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r108);
        r108 = access$pop(null);
        goto L24
    L20:
        access$addLayoutNodeChildren(r105, r108, r102);
        goto L14
    L27:
        return;
    L16:
        r107 = false;
        goto L17
    L12:
        r105.add(r106);
        goto L14
    }

    /* JADX INFO: renamed from: visitSubtree-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m6420visitSubtreeYYKmho(DelegatableNode r100, int r101, boolean r102, Function1<? super T, Unit> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L5:
        MutableVector r104 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r105 = r100.getNode().getChild$ui_release();
        if (r105 != null) goto L8;
        access$addLayoutNodeChildren(r104, r100.getNode(), r102);
    L10:
        if (r104.getSize() == 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L25;
        Modifier.Node r107 = (Modifier.Node) r104.removeAt(r104.getSize() - 1);
        if ((r107.getAggregateChildKindSet$ui_release() & r101) == 0) goto L24;
        Modifier.Node r108 = r107;
    L17:
        if (r108 == null) goto L24;
        if ((r108.getKindSet$ui_release() & r101) == 0) goto L23;
        Modifier.Node r109 = r108;
    L21:
        if (r109 == null) goto L23;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r109);
        r109 = access$pop(null);
    L23:
        r108 = r108.getChild$ui_release();
    L24:
        access$addLayoutNodeChildren(r104, r107, r102);
        goto L10
    L25:
        return;
    L12:
        r106 = false;
        goto L13
    L8:
        r104.add(r105);
        goto L10
    }

    public static final void visitSubtreeIf(DelegatableNode r100, int r101, boolean r102, Function1<? super Modifier.Node, Boolean> r103) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L5:
        MutableVector r104 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r105 = r100.getNode().getChild$ui_release();
        if (r105 != null) goto L8;
        access$addLayoutNodeChildren(r104, r100.getNode(), r102);
    L10:
        if (r104.getSize() == 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == false) goto L24;
        Modifier.Node r107 = (Modifier.Node) r104.removeAt(r104.getSize() - 1);
        if ((r107.getAggregateChildKindSet$ui_release() & r101) == 0) goto L23;
        Modifier.Node r108 = r107;
    L17:
        if (r108 == null) goto L23;
        if ((r108.getKindSet$ui_release() & r101) == 0) goto L22;
        if (r103.invoke(r108).booleanValue() == false) goto L10;
    L22:
        r108 = r108.getChild$ui_release();
    L23:
        access$addLayoutNodeChildren(r104, r107, r102);
        goto L10
    L24:
        return;
    L12:
        r106 = false;
        goto L13
    L8:
        r104.add(r105);
        goto L10
    }

    /* JADX INFO: renamed from: visitSubtreeIf-Y-YKmho, reason: not valid java name */
    public static final /* synthetic */ <T> void m6422visitSubtreeIfYYKmho(DelegatableNode r100, int r101, boolean r102, Function1<? super T, Boolean> r110) {
        if (r100.getNode().isAttached() == true) goto L5;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L5:
        MutableVector r103 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r104 = r100.getNode().getChild$ui_release();
        if (r104 != null) goto L8;
        access$addLayoutNodeChildren(r103, r100.getNode(), r102);
    L10:
        if (r103.getSize() == 0) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L30;
        Modifier.Node r106 = (Modifier.Node) r103.removeAt(r103.getSize() - 1);
        if ((r106.getAggregateChildKindSet$ui_release() & r101) == 0) goto L29;
        Modifier.Node r107 = r106;
    L17:
        if (r107 == null) goto L29;
        if ((r107.getKindSet$ui_release() & r101) == 0) goto L28;
        Modifier.Node r108 = r107;
    L21:
        if (r108 == null) goto L26;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (r110.invoke(r108).booleanValue() == false) goto L24;
        r108 = access$pop(null);
        goto L21
    L24:
        boolean r109 = false;
    L27:
        if (r109 == false) goto L10;
    L26:
        r109 = true;
    L28:
        r107 = r107.getChild$ui_release();
    L29:
        access$addLayoutNodeChildren(r103, r106, r102);
        goto L10
    L30:
        return;
    L12:
        r105 = false;
        goto L13
    L8:
        r103.add(r104);
        goto L10
    }

    public static /* synthetic */ void visitAncestors$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L8:
        if (r102 == false) goto L10;
        Modifier.Node r106 = r100.getNode();
    L11:
        LayoutNode r107 = requireLayoutNode(r100);
    L12:
        if (r107 == null) goto L26;
        if ((r107.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L20;
    L15:
        if (r106 == null) goto L20;
        if ((r106.getKindSet$ui_release() & r101) == 0) goto L19;
        r103.invoke(r106);
    L19:
        r106 = r106.getParent$ui_release();
    L20:
        r107 = r107.getParent$ui_release();
        if (r107 == null) goto L25;
        NodeChain r108 = r107.getNodes$ui_release();
        if (r108 == null) goto L25;
        r106 = r108.getTail$ui_release();
    L25:
        r106 = null;
        goto L12
    L26:
        return;
    L10:
        r106 = r100.getNode().getParent$ui_release();
        goto L11
    }

    /* JADX INFO: renamed from: visitAncestors-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m6411visitAncestorsYYKmho$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
    L8:
        if (r102 == false) goto L10;
        Modifier.Node r106 = r100.getNode();
    L11:
        LayoutNode r107 = requireLayoutNode(r100);
    L12:
        if (r107 == null) goto L28;
        if ((r107.getNodes$ui_release().getHead$ui_release().getAggregateChildKindSet$ui_release() & r101) == 0) goto L22;
    L15:
        if (r106 == null) goto L22;
        if ((r106.getKindSet$ui_release() & r101) == 0) goto L21;
        Modifier.Node r108 = r106;
    L19:
        if (r108 == null) goto L21;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r108);
        r108 = access$pop(null);
    L21:
        r106 = r106.getParent$ui_release();
    L22:
        r107 = r107.getParent$ui_release();
        if (r107 == null) goto L27;
        NodeChain r109 = r107.getNodes$ui_release();
        if (r109 == null) goto L27;
        r106 = r109.getTail$ui_release();
    L27:
        r106 = null;
        goto L12
    L28:
        return;
    L10:
        r106 = r100.getNode().getParent$ui_release();
        goto L11
    }

    /* JADX INFO: renamed from: visitChildren-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m6413visitChildrenYYKmho$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L8:
        MutableVector r106 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r107 = r100.getNode().getChild$ui_release();
        if (r107 != null) goto L11;
        access$addLayoutNodeChildren(r106, r100.getNode(), r102);
    L13:
        if (r106.getSize() == 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L26;
        Modifier.Node r109 = (Modifier.Node) r106.removeAt(r106.getSize() - 1);
        if ((r109.getAggregateChildKindSet$ui_release() & r101) == 0) goto L19;
    L20:
        if (r109 == null) goto L13;
        if ((r109.getKindSet$ui_release() & r101) != 0) goto L23;
        r109 = r109.getChild$ui_release();
    L23:
        if (r109 == null) goto L13;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r109);
        r109 = access$pop(null);
        goto L23
    L19:
        access$addLayoutNodeChildren(r106, r109, r102);
        goto L13
    L26:
        return;
    L15:
        r108 = false;
        goto L16
    L11:
        r106.add(r107);
        goto L13
    }

    public static /* synthetic */ void visitLocalDescendants$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
    L8:
        Modifier.Node r106 = r100.getNode();
        if ((r106.getAggregateChildKindSet$ui_release() & r101) != 0) goto L11;
        return;
    L11:
        if (r102 == true) goto L14;
        r106 = r106.getChild$ui_release();
    L14:
        if (r106 == null) goto L19;
        if ((r106.getKindSet$ui_release() & r101) == 0) goto L18;
        r103.invoke(r106);
    L18:
        r106 = r106.getChild$ui_release();
        goto L14
    }

    /* JADX INFO: renamed from: visitSelfAndChildren-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m6418visitSelfAndChildrenYYKmho$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L5;
        r102 = false;
    L5:
        Modifier.Node r106 = r100.getNode();
    L7:
        if (r106 == null) goto L10;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r106);
        r106 = access$pop(null);
        goto L7
    L10:
        if (r100.getNode().isAttached() == true) goto L12;
        InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
    L12:
        MutableVector r107 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r108 = r100.getNode().getChild$ui_release();
        if (r108 != null) goto L15;
        access$addLayoutNodeChildren(r107, r100.getNode(), r102);
    L17:
        if (r107.getSize() == 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L30;
        Modifier.Node r110 = (Modifier.Node) r107.removeAt(r107.getSize() - 1);
        if ((r110.getAggregateChildKindSet$ui_release() & r101) == 0) goto L23;
    L24:
        if (r110 == null) goto L17;
        if ((r110.getKindSet$ui_release() & r101) != 0) goto L27;
        r110 = r110.getChild$ui_release();
    L27:
        if (r110 == null) goto L17;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r110);
        r110 = access$pop(null);
        goto L27
    L23:
        access$addLayoutNodeChildren(r107, r110, r102);
        goto L17
    L30:
        return;
    L19:
        r109 = false;
        goto L20
    L15:
        r107.add(r108);
        goto L17
    }

    /* JADX INFO: renamed from: visitSubtree-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m6421visitSubtreeYYKmho$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r105) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L8:
        MutableVector r106 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r107 = r100.getNode().getChild$ui_release();
        if (r107 != null) goto L11;
        access$addLayoutNodeChildren(r106, r100.getNode(), r102);
    L13:
        if (r106.getSize() == 0) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == false) goto L28;
        Modifier.Node r109 = (Modifier.Node) r106.removeAt(r106.getSize() - 1);
        if ((r109.getAggregateChildKindSet$ui_release() & r101) == 0) goto L27;
        Modifier.Node r110 = r109;
    L20:
        if (r110 == null) goto L27;
        if ((r110.getKindSet$ui_release() & r101) == 0) goto L26;
        Modifier.Node r111 = r110;
    L24:
        if (r111 == null) goto L26;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        r103.invoke(r111);
        r111 = access$pop(null);
    L26:
        r110 = r110.getChild$ui_release();
    L27:
        access$addLayoutNodeChildren(r106, r109, r102);
        goto L13
    L28:
        return;
    L15:
        r108 = false;
        goto L16
    L11:
        r106.add(r107);
        goto L13
    }

    /* JADX INFO: renamed from: visitSubtreeIf-Y-YKmho$default, reason: not valid java name */
    public static /* synthetic */ void m6423visitSubtreeIfYYKmho$default(DelegatableNode r100, int r101, boolean r102, Function1 r103, int r104, Object r110) {
        if ((r104 & 2) == 0) goto L6;
        r102 = false;
    L6:
        if (r100.getNode().isAttached() == true) goto L8;
        InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
    L8:
        MutableVector r105 = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node r106 = r100.getNode().getChild$ui_release();
        if (r106 != null) goto L11;
        access$addLayoutNodeChildren(r105, r100.getNode(), r102);
    L13:
        if (r105.getSize() == 0) goto L15;
        boolean r107 = true;
    L16:
        if (r107 == false) goto L33;
        Modifier.Node r108 = (Modifier.Node) r105.removeAt(r105.getSize() - 1);
        if ((r108.getAggregateChildKindSet$ui_release() & r101) == 0) goto L32;
        Modifier.Node r109 = r108;
    L20:
        if (r109 == null) goto L32;
        if ((r109.getKindSet$ui_release() & r101) == 0) goto L31;
        Modifier.Node r111 = r109;
    L24:
        if (r111 == null) goto L29;
        Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (((Boolean) r103.invoke(r111)).booleanValue() == false) goto L27;
        r111 = access$pop(null);
        goto L24
    L27:
        boolean r112 = false;
    L30:
        if (r112 == false) goto L13;
    L29:
        r112 = true;
    L31:
        r109 = r109.getChild$ui_release();
    L32:
        access$addLayoutNodeChildren(r105, r108, r102);
        goto L13
    L33:
        return;
    L15:
        r107 = false;
        goto L16
    L11:
        r105.add(r106);
        goto L13
    }
}
