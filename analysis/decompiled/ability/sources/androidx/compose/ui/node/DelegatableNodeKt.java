package androidx.compose.ui.node;

import androidx.compose.foundation.b;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.semantics.SemanticsInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.aiengine.data.InpaintImageAction;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u001a:\u0010\t\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\t\u0010\n\u001a\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u0006*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011\u001a)\u0010\u0013\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00060\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001a8\u0010\u0015\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u0015\u0010\n\u001a8\u0010\u0016\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\u0080\b¢\u0006\u0004\b\u0016\u0010\n\u001a0\u0010\u0017\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a:\u0010\u0017\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u0017\u0010\n\u001a0\u0010\u0019\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u0019\u0010\u0018\u001a>\u0010\u001e\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u001d\u0010\u0018\u001a>\u0010\u0017\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b\u001f\u0010\u0018\u001a>\u0010\u0019\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b \u0010\u0018\u001aH\u0010\t\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b!\u0010\n\u001aJ\u0010%\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b#\u0010$\u001a2\u0010)\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010&\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\b¢\u0006\u0004\b'\u0010(\u001a0\u0010\u000b\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u001a\u0018\u0001*\u00020**\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0080\b¢\u0006\u0004\b+\u0010,\u001aH\u0010\u0015\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b-\u0010\n\u001aH\u0010/\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b.\u0010\n\u001aH\u0010\u0016\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00030\u0005H\u0080\b¢\u0006\u0004\b0\u0010\n\u001aH\u00102\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00002\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\b1\u0010\n\u001a\u001f\u00105\u001a\u00020\u0003*\u00020\u00002\n\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0004\b3\u00104\u001a\u001f\u0010:\u001a\u000207*\u00020\u00002\n\u00106\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0000¢\u0006\u0004\b8\u00109\u001a\u0013\u0010;\u001a\u00020\r*\u00020\u0000H\u0000¢\u0006\u0004\b;\u0010<\u001a\u0013\u0010>\u001a\u00020=*\u00020\u0000H\u0000¢\u0006\u0004\b>\u0010?\u001a\u0013\u0010A\u001a\u00020@*\u00020\u0000H\u0000¢\u0006\u0004\bA\u0010B\u001a\u0011\u0010C\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\bC\u0010D\u001a\u0011\u0010F\u001a\u00020E*\u00020\u0000¢\u0006\u0004\bF\u0010G\u001a\u0011\u0010I\u001a\u00020H*\u00020\u0000¢\u0006\u0004\bI\u0010J\u001a\u0011\u0010L\u001a\u00020K*\u00020\u0000¢\u0006\u0004\bL\u0010M\u001a\u0011\u0010O\u001a\u00020N*\u00020\u0000¢\u0006\u0004\bO\u0010P\u001a\u0011\u0010Q\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0004\bQ\u0010D\u001a\u0019\u0010V\u001a\u00020\u0007*\u00020\u00002\u0006\u0010S\u001a\u00020R¢\u0006\u0004\bT\u0010U\u001a\u0015\u0010X\u001a\u0004\u0018\u00010W*\u00020\u0006H\u0000¢\u0006\u0004\bX\u0010Y\u001a>\u0010\\\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u001a\u0018\u0001*\u00020\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u001b2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\u0080\b¢\u0006\u0004\bZ\u0010[\u001a\u001d\u0010]\u001a\u0004\u0018\u00010\u0006*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH\u0002¢\u0006\u0004\b]\u0010^\"\u0018\u0010_\u001a\u00020\u0003*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`¨\u0006a"}, d2 = {"Landroidx/compose/ui/node/DelegatableNode;", "", InpaintImageAction.IMAGES_KEY_MASK, "", "includeSelf", "Lkotlin/Function1;", "Landroidx/compose/ui/Modifier$Node;", "LC7/r;", "block", "visitAncestors", "(Landroidx/compose/ui/node/DelegatableNode;IZLS7/k;)V", "nearestAncestor", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutNode;", "zOrder", "Landroidx/compose/runtime/collection/MutableVector;", "getChildren", "(Landroidx/compose/ui/node/LayoutNode;Z)Landroidx/compose/runtime/collection/MutableVector;", "node", "addLayoutNodeChildren", "(Landroidx/compose/runtime/collection/MutableVector;Landroidx/compose/ui/Modifier$Node;Z)V", "visitChildren", "visitSubtreeIf", "visitLocalDescendants", "(Landroidx/compose/ui/node/DelegatableNode;ILS7/k;)V", "visitLocalAncestors", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/NodeKind;", "type", "visitSelfAndLocalDescendants-6rFNWt0", "visitSelfAndLocalDescendants", "visitLocalDescendants-6rFNWt0", "visitLocalAncestors-6rFNWt0", "visitAncestors-Y-YKmho", "untilType", "visitSelfAndAncestors-5BbP62I", "(Landroidx/compose/ui/node/DelegatableNode;IILS7/k;)V", "visitSelfAndAncestors", "", "ancestors-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/util/List;", "ancestors", "", "nearestAncestor-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "visitChildren-Y-YKmho", "visitSelfAndChildren-Y-YKmho", "visitSelfAndChildren", "visitSubtreeIf-Y-YKmho", "visitSubtree-Y-YKmho", "visitSubtree", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "has", "kind", "Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireCoordinator", "requireLayoutNode", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/semantics/SemanticsInfo;", "requireSemanticsInfo", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/semantics/SemanticsInfo;", "Landroidx/compose/ui/node/Owner;", "requireOwner", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/Owner;", "requestAutofill", "(Landroidx/compose/ui/node/DelegatableNode;)V", "Landroidx/compose/ui/unit/Density;", "requireDensity", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/graphics/GraphicsContext;", "requireGraphicsContext", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/graphics/GraphicsContext;", "Landroidx/compose/ui/unit/LayoutDirection;", "requireLayoutDirection", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "requireLayoutCoordinates", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/layout/LayoutCoordinates;", "invalidateSubtree", "Landroidx/compose/ui/geometry/Offset;", "delta", "dispatchOnScrollChanged-Uv8p0NA", "(Landroidx/compose/ui/node/DelegatableNode;J)V", "dispatchOnScrollChanged", "Landroidx/compose/ui/node/LayoutModifierNode;", "asLayoutModifierNode", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/node/LayoutModifierNode;", "dispatchForKind-6rFNWt0", "(Landroidx/compose/ui/Modifier$Node;ILS7/k;)V", "dispatchForKind", "pop", "(Landroidx/compose/runtime/collection/MutableVector;)Landroidx/compose/ui/Modifier$Node;", "isDelegationRoot", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DelegatableNodeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node, boolean z10) {
        MutableVector<LayoutNode> children = getChildren(requireLayoutNode(node), z10);
        int size = children.getSize() - 1;
        LayoutNode[] layoutNodeArr = children.content;
        if (size < layoutNodeArr.length) {
            while (size >= 0) {
                mutableVector.add(layoutNodeArr[size].getNodes().getHead());
                size--;
            }
        }
    }

    /* renamed from: ancestors-64DMado, reason: not valid java name */
    public static final <T> List<T> m5697ancestors64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    parent$ui_release = parent$ui_release.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LayoutModifierNode asLayoutModifierNode(Modifier.Node node) {
        if ((NodeKind.m5862constructorimpl(2) & node.getKindSet()) != 0) {
            if (node instanceof LayoutModifierNode) {
                return (LayoutModifierNode) node;
            }
            if (node instanceof DelegatingNode) {
                Modifier.Node delegate$ui_release = ((DelegatingNode) node).getDelegate();
                while (delegate$ui_release != 0) {
                    if (delegate$ui_release instanceof LayoutModifierNode) {
                        return (LayoutModifierNode) delegate$ui_release;
                    }
                    delegate$ui_release = (!(delegate$ui_release instanceof DelegatingNode) || (NodeKind.m5862constructorimpl(2) & delegate$ui_release.getKindSet()) == 0) ? delegate$ui_release.getChild() : ((DelegatingNode) delegate$ui_release).getDelegate();
                }
            }
        }
        return null;
    }

    /* renamed from: dispatchForKind-6rFNWt0, reason: not valid java name */
    public static final <T> void m5698dispatchForKind6rFNWt0(Modifier.Node node, int i, S7.k kVar) {
        if (node == null) {
            return;
        }
        k.m();
        throw null;
    }

    /* renamed from: dispatchOnScrollChanged-Uv8p0NA, reason: not valid java name */
    public static final void m5699dispatchOnScrollChangedUv8p0NA(DelegatableNode delegatableNode, long j5) {
        requireOwner(delegatableNode).mo5924dispatchOnScrollChangedk4lQ0M(j5);
    }

    private static final MutableVector<LayoutNode> getChildren(LayoutNode layoutNode, boolean z10) {
        return z10 ? layoutNode.getZSortedChildren() : layoutNode.get_children$ui_release();
    }

    /* renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m5700has64DMado(DelegatableNode delegatableNode, int i) {
        return (delegatableNode.getNode().getAggregateChildKindSet() & i) != 0;
    }

    public static final void invalidateSubtree(DelegatableNode delegatableNode) {
        if (delegatableNode.getNode().getIsAttached()) {
            LayoutNode.invalidateSubtree$default(requireLayoutNode(delegatableNode), false, 1, null);
        }
    }

    public static final boolean isDelegationRoot(DelegatableNode delegatableNode) {
        return delegatableNode.getNode() == delegatableNode;
    }

    public static final Modifier.Node nearestAncestor(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("nearestAncestor called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet() & i) != 0) {
                        return parent$ui_release;
                    }
                    parent$ui_release = parent$ui_release.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final <T> T m5701nearestAncestor64DMado(DelegatableNode delegatableNode, int i) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node parent$ui_release = delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (parent$ui_release != null) {
                    if ((parent$ui_release.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    parent$ui_release = parent$ui_release.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            parent$ui_release = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier.Node pop(MutableVector<Modifier.Node> mutableVector) {
        if (mutableVector == null || mutableVector.getSize() == 0) {
            return null;
        }
        return (Modifier.Node) b.l(mutableVector, 1);
    }

    public static final void requestAutofill(DelegatableNode delegatableNode) {
        requireLayoutNode(delegatableNode).requestAutofill$ui_release();
    }

    /* renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m5702requireCoordinator64DMado(DelegatableNode delegatableNode, int i) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator();
        k.c(coordinator$ui_release);
        if (coordinator$ui_release.getTail() != delegatableNode || !NodeKindKt.m5871getIncludeSelfInTraversalH91voCI(i)) {
            return coordinator$ui_release;
        }
        NodeCoordinator wrapped$ui_release = coordinator$ui_release.getWrapped();
        k.c(wrapped$ui_release);
        return wrapped$ui_release;
    }

    public static final Density requireDensity(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getDensity();
    }

    public static final GraphicsContext requireGraphicsContext(DelegatableNode delegatableNode) {
        return requireOwner(delegatableNode).getGraphicsContext();
    }

    public static final LayoutCoordinates requireLayoutCoordinates(DelegatableNode delegatableNode) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("Cannot get LayoutCoordinates, Modifier.Node is not attached.");
        }
        LayoutCoordinates coordinates = m5702requireCoordinator64DMado(delegatableNode, NodeKind.m5862constructorimpl(2)).getCoordinates();
        if (!coordinates.isAttached()) {
            InlineClassHelperKt.throwIllegalStateException("LayoutCoordinates is not attached.");
        }
        return coordinates;
    }

    public static final LayoutDirection requireLayoutDirection(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode).getLayoutDirection();
    }

    public static final LayoutNode requireLayoutNode(DelegatableNode delegatableNode) {
        NodeCoordinator coordinator$ui_release = delegatableNode.getNode().getCoordinator();
        if (coordinator$ui_release != null) {
            return coordinator$ui_release.getLayoutNode();
        }
        throw b.x("Cannot obtain node coordinator. Is the Modifier.Node attached?");
    }

    public static final Owner requireOwner(DelegatableNode delegatableNode) {
        Owner owner = requireLayoutNode(delegatableNode).getOwner();
        if (owner != null) {
            return owner;
        }
        throw b.x("This node does not have an owner.");
    }

    public static final SemanticsInfo requireSemanticsInfo(DelegatableNode delegatableNode) {
        return requireLayoutNode(delegatableNode);
    }

    public static final void visitAncestors(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z10 ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        kVar.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static /* synthetic */ void visitAncestors$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        NodeChain nodes;
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z10 ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        kVar.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* renamed from: visitAncestors-Y-YKmho, reason: not valid java name */
    public static final <T> void m5703visitAncestorsYYKmho(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        NodeChain nodes;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z10 ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* renamed from: visitAncestors-Y-YKmho$default, reason: not valid java name */
    public static void m5704visitAncestorsYYKmho$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        NodeChain nodes;
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node = z10 ? delegatableNode.getNode() : delegatableNode.getNode().getParent();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    node = node.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    public static final void visitChildren(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child$ui_release2 = (Modifier.Node) b.l(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2, z10);
            } else {
                while (true) {
                    if (child$ui_release2 == null) {
                        break;
                    }
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        kVar.invoke(child$ui_release2);
                        break;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    /* renamed from: visitChildren-Y-YKmho, reason: not valid java name */
    public static final <T> void m5705visitChildrenYYKmho(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child$ui_release2 = (Modifier.Node) b.l(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2, z10);
            } else {
                while (child$ui_release2 != null) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    /* renamed from: visitChildren-Y-YKmho$default, reason: not valid java name */
    public static void m5706visitChildrenYYKmho$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child$ui_release2 = (Modifier.Node) b.l(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2, z10);
            } else {
                while (child$ui_release2 != null) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    public static final void visitLocalAncestors(DelegatableNode delegatableNode, int i, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            if ((parent$ui_release.getKindSet() & i) != 0) {
                kVar.invoke(parent$ui_release);
            }
        }
    }

    /* renamed from: visitLocalAncestors-6rFNWt0, reason: not valid java name */
    public static final <T> void m5707visitLocalAncestors6rFNWt0(DelegatableNode delegatableNode, int i, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalAncestors called on an unattached node");
        }
        for (Modifier.Node parent$ui_release = delegatableNode.getNode().getParent(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent()) {
            if ((parent$ui_release.getKindSet() & i) != 0) {
                k.m();
                throw null;
            }
        }
    }

    public static final void visitLocalDescendants(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z10) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                kVar.invoke(node);
            }
            node = node.getChild();
        }
    }

    public static /* synthetic */ void visitLocalDescendants$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) == 0) {
            return;
        }
        if (!z10) {
            node = node.getChild();
        }
        while (node != null) {
            if ((node.getKindSet() & i) != 0) {
                kVar.invoke(node);
            }
            node = node.getChild();
        }
    }

    /* renamed from: visitLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final <T> void m5708visitLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child$ui_release = node.getChild(); child$ui_release != null; child$ui_release = child$ui_release.getChild()) {
                if ((child$ui_release.getKindSet() & i) != 0) {
                    k.m();
                    throw null;
                }
            }
        }
    }

    /* renamed from: visitSelfAndAncestors-5BbP62I, reason: not valid java name */
    public static final <T> void m5709visitSelfAndAncestors5BbP62I(DelegatableNode delegatableNode, int i, int i6, S7.k kVar) {
        NodeChain nodes;
        Modifier.Node node = delegatableNode.getNode();
        int i10 = i | i6;
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitAncestors called on an unattached node");
        }
        Modifier.Node node2 = delegatableNode.getNode();
        LayoutNode layoutNodeRequireLayoutNode = requireLayoutNode(delegatableNode);
        while (layoutNodeRequireLayoutNode != null) {
            if ((b.g(layoutNodeRequireLayoutNode) & i10) != 0) {
                while (node2 != null) {
                    if ((node2.getKindSet() & i10) != 0) {
                        if (node2 != node && (node2.getKindSet() & i6) != 0) {
                            return;
                        }
                        if ((node2.getKindSet() & i) != 0) {
                            k.m();
                            throw null;
                        }
                    }
                    node2 = node2.getParent();
                }
            }
            layoutNodeRequireLayoutNode = layoutNodeRequireLayoutNode.getParent$ui_release();
            node2 = (layoutNodeRequireLayoutNode == null || (nodes = layoutNodeRequireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    /* renamed from: visitSelfAndChildren-Y-YKmho, reason: not valid java name */
    public static final <T> void m5710visitSelfAndChildrenYYKmho(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (delegatableNode.getNode() != null) {
            k.m();
            throw null;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child$ui_release2 = (Modifier.Node) b.l(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2, z10);
            } else {
                while (child$ui_release2 != null) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    /* renamed from: visitSelfAndChildren-Y-YKmho$default, reason: not valid java name */
    public static void m5711visitSelfAndChildrenYYKmho$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (delegatableNode.getNode() != null) {
            k.m();
            throw null;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitChildren called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node child$ui_release2 = (Modifier.Node) b.l(mutableVector, 1);
            if ((child$ui_release2.getAggregateChildKindSet() & i) == 0) {
                addLayoutNodeChildren(mutableVector, child$ui_release2, z10);
            } else {
                while (child$ui_release2 != null) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                    child$ui_release2 = child$ui_release2.getChild();
                }
            }
        }
    }

    /* renamed from: visitSelfAndLocalDescendants-6rFNWt0, reason: not valid java name */
    public static final <T> void m5712visitSelfAndLocalDescendants6rFNWt0(DelegatableNode delegatableNode, int i, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            while (node != null) {
                if ((node.getKindSet() & i) != 0) {
                    k.m();
                    throw null;
                }
                node = node.getChild();
            }
        }
    }

    /* renamed from: visitSubtree-Y-YKmho, reason: not valid java name */
    public static final <T> void m5713visitSubtreeYYKmho(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) b.l(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z10);
        }
    }

    /* renamed from: visitSubtree-Y-YKmho$default, reason: not valid java name */
    public static void m5714visitSubtreeYYKmho$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) b.l(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z10);
        }
    }

    public static final void visitSubtreeIf(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) b.l(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) == 0 || ((Boolean) kVar.invoke(child$ui_release2)).booleanValue()) {
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z10);
        }
    }

    /* renamed from: visitSubtreeIf-Y-YKmho, reason: not valid java name */
    public static final <T> void m5715visitSubtreeIfYYKmho(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) b.l(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z10);
        }
    }

    /* renamed from: visitSubtreeIf-Y-YKmho$default, reason: not valid java name */
    public static void m5716visitSubtreeIfYYKmho$default(DelegatableNode delegatableNode, int i, boolean z10, S7.k kVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z10 = false;
        }
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitSubtreeIf called on an unattached node");
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$ui_release = delegatableNode.getNode().getChild();
        if (child$ui_release == null) {
            addLayoutNodeChildren(mutableVector, delegatableNode.getNode(), z10);
        } else {
            mutableVector.add(child$ui_release);
        }
        while (mutableVector.getSize() != 0) {
            Modifier.Node node = (Modifier.Node) b.l(mutableVector, 1);
            if ((node.getAggregateChildKindSet() & i) != 0) {
                for (Modifier.Node child$ui_release2 = node; child$ui_release2 != null; child$ui_release2 = child$ui_release2.getChild()) {
                    if ((child$ui_release2.getKindSet() & i) != 0) {
                        k.m();
                        throw null;
                    }
                }
            }
            addLayoutNodeChildren(mutableVector, node, z10);
        }
    }

    public static final void visitLocalDescendants(DelegatableNode delegatableNode, int i, S7.k kVar) {
        if (!delegatableNode.getNode().getIsAttached()) {
            InlineClassHelperKt.throwIllegalStateException("visitLocalDescendants called on an unattached node");
        }
        Modifier.Node node = delegatableNode.getNode();
        if ((node.getAggregateChildKindSet() & i) != 0) {
            for (Modifier.Node child$ui_release = node.getChild(); child$ui_release != null; child$ui_release = child$ui_release.getChild()) {
                if ((child$ui_release.getKindSet() & i) != 0) {
                    kVar.invoke(child$ui_release);
                }
            }
        }
    }
}
