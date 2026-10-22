package androidx.compose.ui.semantics;

import C7.r;
import D7.v;
import S7.k;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.EmptyList;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0016\u0010\u0017J3\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u00042\b\b\u0002\u0010\u0013\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0000H\u0000¢\u0006\u0004\b \u0010!J\u0017\u0010&\u001a\u00020%2\u0006\u0010$\u001a\u00020#H\u0002¢\u0006\u0004\b&\u0010'J%\u0010*\u001a\u00020)2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\u0006\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b*\u0010+J)\u0010-\u001a\u00020)*\u00020\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010.J3\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00000\u00152\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u00112\u000e\b\u0002\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b/\u00100J9\u00103\u001a\u00020)*\b\u0012\u0004\u0012\u00020\u00000\u00112\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020)01H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001¢\u0006\u0004\b3\u00104J\u0011\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b6\u00107J\u001d\u00108\u001a\u00020)2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0002¢\u0006\u0004\b8\u00109J-\u0010@\u001a\u00020\u00002\b\u0010;\u001a\u0004\u0018\u00010:2\u0012\u0010=\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020)01H\u0002¢\u0006\u0004\b>\u0010?R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010A\u001a\u0004\bB\u0010CR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010D\u001a\u0004\bE\u0010FR\u001a\u0010\u0007\u001a\u00020\u00068\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010\t\u001a\u00020\b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010J\u001a\u0004\bK\u0010LR\"\u0010M\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010D\u001a\u0004\bN\u0010F\"\u0004\bO\u0010PR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010RR\u0017\u0010S\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\bS\u0010T\u001a\u0004\bU\u0010VR\u0014\u0010X\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bW\u0010FR\u0011\u0010\\\u001a\u00020Y8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0013\u0010`\u001a\u0004\u0018\u00010]8F¢\u0006\u0006\u001a\u0004\b^\u0010_R\u0011\u0010c\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\ba\u0010bR\u0011\u0010g\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\be\u0010fR\u0011\u0010i\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bh\u0010bR\u0011\u0010l\u001a\u00020j8F¢\u0006\u0006\u001a\u0004\bk\u0010fR\u0011\u0010n\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\bm\u0010bR\u0011\u0010p\u001a\u00020j8F¢\u0006\u0006\u001a\u0004\bo\u0010fR\u0011\u0010r\u001a\u00020j8F¢\u0006\u0006\u001a\u0004\bq\u0010fR\u0014\u0010t\u001a\u00020%8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bs\u0010bR\u0014\u0010v\u001a\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bu\u0010FR\u0011\u0010x\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bw\u0010LR\u0017\u0010z\u001a\b\u0012\u0004\u0012\u00020\u00000\u00158F¢\u0006\u0006\u001a\u0004\b\u001b\u0010yR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u00000\u00158@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b{\u0010yR\u0011\u0010}\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b}\u0010FR\u0013\u0010\u007f\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b~\u0010!R\u0016\u0010\u0080\u0001\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010F¨\u0006\u0081\u0001"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "Landroidx/compose/ui/Modifier$Node;", "outerSemanticsNode", "", "mergingEnabled", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "unmergedConfig", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "", "getAlignmentLinePosition", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "", "unmergedChildren", "includeFakeNodes", "includeDeactivatedNodes", "", "unmergedChildren$ui_release", "(Ljava/util/List;ZZ)Ljava/util/List;", "includeReplacedSemantics", "getChildren$ui_release", "(ZZZ)Ljava/util/List;", "getChildren", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds", "copyWithMergingEnabled$ui_release", "()Landroidx/compose/ui/semantics/SemanticsNode;", "copyWithMergingEnabled", "Landroidx/compose/ui/layout/LayoutCoordinates;", "nodeCoordinates", "Landroidx/compose/ui/geometry/Rect;", "boundsInImportantForBoundsAncestor", "(Landroidx/compose/ui/layout/LayoutCoordinates;)Landroidx/compose/ui/geometry/Rect;", "mergedConfig", "LC7/r;", "mergeConfig", "(Ljava/util/List;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "list", "fillOneLayerOfSemanticsWrappers", "(Landroidx/compose/ui/node/LayoutNode;Ljava/util/List;Z)V", "findOneLayerOfMergingSemanticsNodes", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lkotlin/Function1;", "block", "forEachUnmergedChild", "(Ljava/util/List;LS7/k;)V", "Landroidx/compose/ui/node/SemanticsModifierNode;", "findSemanticsModifierNodeToGetBounds", "()Landroidx/compose/ui/node/SemanticsModifierNode;", "emitFakeNodes", "(Ljava/util/List;)V", "Landroidx/compose/ui/semantics/Role;", "role", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "properties", "fakeSemanticsNode-ypyhhiA", "(Landroidx/compose/ui/semantics/Role;LS7/k;)Landroidx/compose/ui/semantics/SemanticsNode;", "fakeSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "Z", "getMergingEnabled", "()Z", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isFake", "isFake$ui_release", "setFake$ui_release", "(Z)V", "fakeNodeParent", "Landroidx/compose/ui/semantics/SemanticsNode;", "id", "I", "getId", "()I", "isUnmergedLeafNode$ui_release", "isUnmergedLeafNode", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "layoutInfo", "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "root", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "size", "getBoundsInRoot", "boundsInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "positionInRoot", "getBoundsInWindow", "boundsInWindow", "getPositionInWindow-F1C5BW0", "positionInWindow", "getPositionOnScreen-F1C5BW0", "positionOnScreen", "getBoundsInParent$ui_release", "boundsInParent", "isTransparent$ui_release", "isTransparent", "getConfig", "config", "()Ljava/util/List;", "children", "getReplacedChildren$ui_release", "replacedChildren", "isRoot", "getParent", "parent", "isMergingSemanticsOfDescendants", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;
    private final int id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public SemanticsNode(Modifier.Node node, boolean z10, LayoutNode layoutNode, SemanticsConfiguration semanticsConfiguration) {
        this.outerSemanticsNode = node;
        this.mergingEnabled = z10;
        this.layoutNode = layoutNode;
        this.unmergedConfig = semanticsConfiguration;
        this.id = layoutNode.getSemanticsId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private final Rect boundsInImportantForBoundsAncestor(LayoutCoordinates nodeCoordinates) {
        DelegatingNode delegatingNodePop;
        SemanticsNode parent = getParent();
        if (parent == null) {
            return Rect.INSTANCE.getZero();
        }
        NodeChain nodes = parent.layoutNode.getNodes();
        int iM5862constructorimpl = NodeKind.m5862constructorimpl(8);
        if ((nodes.getAggregateChildKindSet() & iM5862constructorimpl) != 0) {
            loop0: for (Modifier.Node head = nodes.getHead(); head != null; head = head.getChild()) {
                if ((head.getKindSet() & iM5862constructorimpl) != 0) {
                    delegatingNodePop = head;
                    MutableVector mutableVector = null;
                    while (delegatingNodePop != 0) {
                        if (delegatingNodePop instanceof SemanticsModifierNode) {
                            if (delegatingNodePop.isImportantForBounds()) {
                                break loop0;
                            }
                        } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                            Modifier.Node delegate = delegatingNodePop.getDelegate();
                            int i = 0;
                            delegatingNodePop = delegatingNodePop;
                            while (delegate != null) {
                                if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                    i++;
                                    if (i == 1) {
                                        delegatingNodePop = delegate;
                                    } else {
                                        if (mutableVector == null) {
                                            mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                        }
                                        if (delegatingNodePop != 0) {
                                            mutableVector.add(delegatingNodePop);
                                            delegatingNodePop = 0;
                                        }
                                        mutableVector.add(delegate);
                                    }
                                }
                                delegate = delegate.getChild();
                                delegatingNodePop = delegatingNodePop;
                            }
                            if (i == 1) {
                            }
                        }
                        delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                    }
                }
                if ((head.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                    break;
                }
            }
            delegatingNodePop = 0;
        } else {
            delegatingNodePop = 0;
        }
        SemanticsModifierNode semanticsModifierNode = (SemanticsModifierNode) delegatingNodePop;
        NodeCoordinator nodeCoordinatorM5702requireCoordinator64DMado = semanticsModifierNode != null ? DelegatableNodeKt.m5702requireCoordinator64DMado(semanticsModifierNode, NodeKind.m5862constructorimpl(8)) : null;
        return nodeCoordinatorM5702requireCoordinator64DMado == null ? parent.boundsInImportantForBoundsAncestor(nodeCoordinates) : LayoutCoordinates.localBoundingBoxOf$default(nodeCoordinatorM5702requireCoordinator64DMado, nodeCoordinates, false, 2, null);
    }

    private final void emitFakeNodes(List<SemanticsNode> unmergedChildren) {
        final Role role = SemanticsNodeKt.getRole(this);
        if (role != null && this.unmergedConfig.getIsMergingSemanticsOfDescendants() && !unmergedChildren.isEmpty()) {
            unmergedChildren.add(m6090fakeSemanticsNodeypyhhiA(role, new k() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$1
                {
                    super(1);
                }

                @Override // S7.k
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((SemanticsPropertyReceiver) obj);
                    return r.f317a;
                }

                public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                    SemanticsPropertiesKt.m6100setRolekuIjeqM(semanticsPropertyReceiver, role.getValue());
                }
            }));
        }
        SemanticsConfiguration semanticsConfiguration = this.unmergedConfig;
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (semanticsConfiguration.contains(semanticsProperties.getContentDescription()) && !unmergedChildren.isEmpty() && this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, semanticsProperties.getContentDescription());
            final String str = list != null ? (String) v.C0(list) : null;
            if (str != null) {
                unmergedChildren.add(0, m6090fakeSemanticsNodeypyhhiA(null, new k() { // from class: androidx.compose.ui.semantics.SemanticsNode$emitFakeNodes$fakeNode$2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // S7.k
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((SemanticsPropertyReceiver) obj);
                        return r.f317a;
                    }

                    public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                        SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, str);
                    }
                }));
            }
        }
    }

    /* renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m6090fakeSemanticsNodeypyhhiA(Role role, k properties) {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.setMergingSemanticsOfDescendants(false);
        semanticsConfiguration.setClearingSemantics(false);
        properties.invoke(semanticsConfiguration);
        SemanticsNode semanticsNode = new SemanticsNode(new SemanticsNode$fakeSemanticsNode$fakeNode$1(properties), false, new LayoutNode(true, role != null ? SemanticsNodeKt.roleFakeNodeId(this) : SemanticsNodeKt.contentDescriptionFakeNodeId(this)), semanticsConfiguration);
        semanticsNode.isFake = true;
        semanticsNode.fakeNodeParent = this;
        return semanticsNode;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode layoutNode, List<SemanticsNode> list, boolean z10) {
        MutableVector<LayoutNode> zSortedChildren = layoutNode.getZSortedChildren();
        LayoutNode[] layoutNodeArr = zSortedChildren.content;
        int size = zSortedChildren.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            if (layoutNode2.isAttached() && (z10 || !layoutNode2.getIsDeactivated())) {
                if (layoutNode2.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(8))) {
                    list.add(SemanticsNodeKt.SemanticsNode(layoutNode2, this.mergingEnabled));
                } else {
                    fillOneLayerOfSemanticsWrappers(layoutNode2, list, z10);
                }
            }
        }
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> unmergedChildren, List<SemanticsNode> list) {
        unmergedChildren$ui_release$default(this, unmergedChildren, false, false, 6, null);
        int size = unmergedChildren.size();
        for (int size2 = unmergedChildren.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = unmergedChildren.get(size2);
            if (semanticsNode.isMergingSemanticsOfDescendants()) {
                list.add(semanticsNode);
            } else if (!semanticsNode.unmergedConfig.getIsClearingSemantics()) {
                semanticsNode.findOneLayerOfMergingSemanticsNodes(unmergedChildren, list);
            }
        }
        return list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode semanticsNode, List list, List list2, int i, Object obj) {
        if ((i & 2) != 0) {
            list2 = new ArrayList();
        }
        return semanticsNode.findOneLayerOfMergingSemanticsNodes(list, list2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v14, types: [androidx.compose.ui.node.SemanticsModifierNode] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    private final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        Modifier.Node nodePop;
        Object obj = null;
        if (this.unmergedConfig.getIsMergingSemanticsOfDescendants()) {
            NodeChain nodes = this.layoutNode.getNodes();
            int iM5862constructorimpl = NodeKind.m5862constructorimpl(8);
            if ((nodes.getAggregateChildKindSet() & iM5862constructorimpl) != 0) {
                nodePop = null;
                for (Modifier.Node head = nodes.getHead(); head != null; head = head.getChild()) {
                    if ((head.getKindSet() & iM5862constructorimpl) != 0) {
                        DelegatingNode delegatingNodePop = head;
                        MutableVector mutableVector = null;
                        while (delegatingNodePop != 0) {
                            if (delegatingNodePop instanceof SemanticsModifierNode) {
                                ?? r6 = (SemanticsModifierNode) delegatingNodePop;
                                if (r6.isImportantForBounds()) {
                                    if (r6.getShouldMergeDescendantSemantics()) {
                                        return r6;
                                    }
                                    if (nodePop == null) {
                                        nodePop = r6;
                                    }
                                }
                            } else if ((delegatingNodePop.getKindSet() & iM5862constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                                Modifier.Node delegate = delegatingNodePop.getDelegate();
                                int i = 0;
                                delegatingNodePop = delegatingNodePop;
                                while (delegate != null) {
                                    if ((delegate.getKindSet() & iM5862constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            delegatingNodePop = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (delegatingNodePop != 0) {
                                                mutableVector.add(delegatingNodePop);
                                                delegatingNodePop = 0;
                                            }
                                            mutableVector.add(delegate);
                                        }
                                    }
                                    delegate = delegate.getChild();
                                    delegatingNodePop = delegatingNodePop;
                                }
                                if (i == 1) {
                                }
                            }
                            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    if ((head.getAggregateChildKindSet() & iM5862constructorimpl) == 0) {
                        break;
                    }
                }
                obj = nodePop;
            }
        } else {
            NodeChain nodes2 = this.layoutNode.getNodes();
            int iM5862constructorimpl2 = NodeKind.m5862constructorimpl(8);
            if ((nodes2.getAggregateChildKindSet() & iM5862constructorimpl2) != 0) {
                loop3: for (Modifier.Node head2 = nodes2.getHead(); head2 != null; head2 = head2.getChild()) {
                    if ((head2.getKindSet() & iM5862constructorimpl2) != 0) {
                        nodePop = head2;
                        MutableVector mutableVector2 = null;
                        while (nodePop != null) {
                            if (nodePop instanceof SemanticsModifierNode) {
                                if (((SemanticsModifierNode) nodePop).isImportantForBounds()) {
                                    obj = nodePop;
                                }
                            } else if ((nodePop.getKindSet() & iM5862constructorimpl2) != 0 && (nodePop instanceof DelegatingNode)) {
                                int i6 = 0;
                                for (Modifier.Node delegate2 = ((DelegatingNode) nodePop).getDelegate(); delegate2 != null; delegate2 = delegate2.getChild()) {
                                    if ((delegate2.getKindSet() & iM5862constructorimpl2) != 0) {
                                        i6++;
                                        if (i6 == 1) {
                                            nodePop = delegate2;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (nodePop != null) {
                                                mutableVector2.add(nodePop);
                                                nodePop = null;
                                            }
                                            mutableVector2.add(delegate2);
                                        }
                                    }
                                }
                                if (i6 == 1) {
                                }
                            }
                            nodePop = DelegatableNodeKt.pop(mutableVector2);
                        }
                    }
                    if ((head2.getAggregateChildKindSet() & iM5862constructorimpl2) == 0) {
                        break;
                    }
                }
            }
        }
        return (SemanticsModifierNode) obj;
    }

    private final void forEachUnmergedChild(List<SemanticsNode> list, k kVar) {
        unmergedChildren$ui_release$default(this, list, false, false, 6, null);
        int size = list.size();
        for (int size2 = list.size(); size2 < size; size2++) {
            kVar.invoke(list.get(size2));
        }
    }

    public static /* synthetic */ List getChildren$ui_release$default(SemanticsNode semanticsNode, boolean z10, boolean z11, boolean z12, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = !semanticsNode.mergingEnabled;
        }
        if ((i & 2) != 0) {
            z11 = false;
        }
        if ((i & 4) != 0) {
            z12 = false;
        }
        return semanticsNode.getChildren$ui_release(z10, z11, z12);
    }

    private final boolean isMergingSemanticsOfDescendants() {
        return this.mergingEnabled && this.unmergedConfig.getIsMergingSemanticsOfDescendants();
    }

    private final void mergeConfig(List<SemanticsNode> unmergedChildren, SemanticsConfiguration mergedConfig) {
        if (this.unmergedConfig.getIsClearingSemantics()) {
            return;
        }
        unmergedChildren$ui_release$default(this, unmergedChildren, false, false, 6, null);
        int size = unmergedChildren.size();
        for (int size2 = unmergedChildren.size(); size2 < size; size2++) {
            SemanticsNode semanticsNode = unmergedChildren.get(size2);
            if (!semanticsNode.isMergingSemanticsOfDescendants()) {
                mergedConfig.mergeChild$ui_release(semanticsNode.unmergedConfig);
                semanticsNode.mergeConfig(unmergedChildren, mergedConfig);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode semanticsNode, List list, boolean z10, boolean z11, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        if ((i & 2) != 0) {
            z10 = false;
        }
        if ((i & 4) != 0) {
            z11 = false;
        }
        return semanticsNode.unmergedChildren$ui_release(list, z10, z11);
    }

    public final SemanticsNode copyWithMergingEnabled$ui_release() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        NodeCoordinator nodeCoordinatorM5702requireCoordinator64DMado;
        if (!this.isFake) {
            SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
            return (semanticsModifierNodeFindSemanticsModifierNodeToGetBounds == null || (nodeCoordinatorM5702requireCoordinator64DMado = DelegatableNodeKt.m5702requireCoordinator64DMado(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds, NodeKind.m5862constructorimpl(8))) == null) ? this.layoutNode.getInnerCoordinator$ui_release() : nodeCoordinatorM5702requireCoordinator64DMado;
        }
        SemanticsNode parent = getParent();
        if (parent != null) {
            return parent.findCoordinatorToGetBounds$ui_release();
        }
        return null;
    }

    public final int getAlignmentLinePosition(AlignmentLine alignmentLine) {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            return nodeCoordinatorFindCoordinatorToGetBounds$ui_release.get(alignmentLine);
        }
        return Integer.MIN_VALUE;
    }

    public final Rect getBoundsInParent$ui_release() {
        LayoutCoordinates coordinates;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null && (coordinates = nodeCoordinatorFindCoordinatorToGetBounds$ui_release.getCoordinates()) != null) {
                return boundsInImportantForBoundsAncestor(coordinates);
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final Rect getBoundsInRoot() {
        Rect rectBoundsInRoot;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null && (rectBoundsInRoot = LayoutCoordinatesKt.boundsInRoot(nodeCoordinatorFindCoordinatorToGetBounds$ui_release)) != null) {
                return rectBoundsInRoot;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final Rect getBoundsInWindow() {
        Rect rectBoundsInWindow;
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null && (rectBoundsInWindow = LayoutCoordinatesKt.boundsInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui_release)) != null) {
                return rectBoundsInWindow;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public final List<SemanticsNode> getChildren() {
        return getChildren$ui_release$default(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> getChildren$ui_release(boolean includeReplacedSemantics, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (!includeReplacedSemantics && this.unmergedConfig.getIsClearingSemantics()) {
            return EmptyList.f4893a;
        }
        ArrayList arrayList = new ArrayList();
        return isMergingSemanticsOfDescendants() ? findOneLayerOfMergingSemanticsNodes$default(this, arrayList, null, 2, null) : unmergedChildren$ui_release(arrayList, includeFakeNodes, includeDeactivatedNodes);
    }

    public final SemanticsConfiguration getConfig() {
        if (!isMergingSemanticsOfDescendants()) {
            return this.unmergedConfig;
        }
        SemanticsConfiguration semanticsConfigurationCopy = this.unmergedConfig.copy();
        mergeConfig(new ArrayList(), semanticsConfigurationCopy);
        return semanticsConfigurationCopy;
    }

    public final int getId() {
        return this.id;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    /* renamed from: getLayoutNode$ui_release, reason: from getter */
    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    /* renamed from: getOuterSemanticsNode$ui_release, reason: from getter */
    public final Modifier.Node getOuterSemanticsNode() {
        return this.outerSemanticsNode;
    }

    public final SemanticsNode getParent() {
        LayoutNode parent$ui_release;
        SemanticsNode semanticsNode = this.fakeNodeParent;
        if (semanticsNode != null) {
            return semanticsNode;
        }
        if (this.mergingEnabled) {
            parent$ui_release = this.layoutNode.getParent$ui_release();
            while (parent$ui_release != null) {
                SemanticsConfiguration semanticsConfiguration = parent$ui_release.getSemanticsConfiguration();
                if (semanticsConfiguration != null && semanticsConfiguration.getIsMergingSemanticsOfDescendants()) {
                    break;
                }
                parent$ui_release = parent$ui_release.getParent$ui_release();
            }
            parent$ui_release = null;
        } else {
            parent$ui_release = null;
        }
        if (parent$ui_release == null) {
            parent$ui_release = this.layoutNode.getParent$ui_release();
            while (true) {
                if (parent$ui_release == null) {
                    parent$ui_release = null;
                    break;
                }
                if (parent$ui_release.getNodes().m5818hasH91voCI$ui_release(NodeKind.m5862constructorimpl(8))) {
                    break;
                }
                parent$ui_release = parent$ui_release.getParent$ui_release();
            }
        }
        if (parent$ui_release == null) {
            return null;
        }
        return SemanticsNodeKt.SemanticsNode(parent$ui_release, this.mergingEnabled);
    }

    /* renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m6091getPositionInRootF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionInRoot(nodeCoordinatorFindCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    /* renamed from: getPositionInWindow-F1C5BW0, reason: not valid java name */
    public final long m6092getPositionInWindowF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionInWindow(nodeCoordinatorFindCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    /* renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m6093getPositionOnScreenF1C5BW0() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            if (!nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isAttached()) {
                nodeCoordinatorFindCoordinatorToGetBounds$ui_release = null;
            }
            if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
                return LayoutCoordinatesKt.positionOnScreen(nodeCoordinatorFindCoordinatorToGetBounds$ui_release);
            }
        }
        return Offset.INSTANCE.m3911getZeroF1C5BW0();
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren$ui_release$default(this, false, true, false, 4, null);
    }

    public final RootForTest getRoot() {
        Owner owner = this.layoutNode.getOwner();
        if (owner != null) {
            return owner.getRootForTest();
        }
        return null;
    }

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m6094getSizeYbymL2g() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        return nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null ? nodeCoordinatorFindCoordinatorToGetBounds$ui_release.mo5557getSizeYbymL2g() : IntSize.INSTANCE.m7020getZeroYbymL2g();
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode semanticsModifierNodeFindSemanticsModifierNodeToGetBounds = findSemanticsModifierNodeToGetBounds();
        return semanticsModifierNodeFindSemanticsModifierNodeToGetBounds == null ? this.layoutNode.getInnerCoordinator$ui_release().touchBoundsInRoot() : SemanticsModifierNodeKt.touchBoundsInRoot(semanticsModifierNodeFindSemanticsModifierNodeToGetBounds.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    /* renamed from: getUnmergedConfig$ui_release, reason: from getter */
    public final SemanticsConfiguration getUnmergedConfig() {
        return this.unmergedConfig;
    }

    /* renamed from: isFake$ui_release, reason: from getter */
    public final boolean getIsFake() {
        return this.isFake;
    }

    public final boolean isRoot() {
        return getParent() == null;
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator nodeCoordinatorFindCoordinatorToGetBounds$ui_release = findCoordinatorToGetBounds$ui_release();
        if (nodeCoordinatorFindCoordinatorToGetBounds$ui_release != null) {
            return nodeCoordinatorFindCoordinatorToGetBounds$ui_release.isTransparent();
        }
        return false;
    }

    public final boolean isUnmergedLeafNode$ui_release() {
        if (this.isFake || !getReplacedChildren$ui_release().isEmpty()) {
            return false;
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        while (true) {
            if (parent$ui_release == null) {
                parent$ui_release = null;
                break;
            }
            SemanticsConfiguration semanticsConfiguration = parent$ui_release.getSemanticsConfiguration();
            if (semanticsConfiguration != null && semanticsConfiguration.getIsMergingSemanticsOfDescendants()) {
                break;
            }
            parent$ui_release = parent$ui_release.getParent$ui_release();
        }
        return parent$ui_release == null;
    }

    public final void setFake$ui_release(boolean z10) {
        this.isFake = z10;
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(List<SemanticsNode> unmergedChildren, boolean includeFakeNodes, boolean includeDeactivatedNodes) {
        if (this.isFake) {
            return EmptyList.f4893a;
        }
        fillOneLayerOfSemanticsWrappers(this.layoutNode, unmergedChildren, includeDeactivatedNodes);
        if (includeFakeNodes) {
            emitFakeNodes(unmergedChildren);
        }
        return unmergedChildren;
    }
}
