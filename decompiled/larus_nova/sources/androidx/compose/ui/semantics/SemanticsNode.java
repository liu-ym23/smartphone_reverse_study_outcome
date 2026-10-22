package androidx.compose.ui.semantics;

import androidx.compose.runtime.collection.MutableVector;
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
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020>H\u0002J\u000e\u0010A\u001a\u00020$2\u0006\u0010B\u001a\u00020CJ\u001e\u0010F\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010J\u001a\u00020\tH\u0002J7\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000L2\u000e\b\u0002\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bOJ\"\u0010P\u001a\u00020G*\u00020\u00072\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u0006\u0010N\u001a\u00020\u0005H\u0002J1\u0010S\u001a\b\u0012\u0004\u0012\u00020\u00000L2\b\b\u0002\u0010W\u001a\u00020\u00052\b\b\u0002\u0010M\u001a\u00020\u00052\b\b\u0002\u0010N\u001a\u00020\u0005H\u0000¢\u0006\u0002\bXJ,\u0010]\u001a\b\u0012\u0004\u0012\u00020\u00000L2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000I2\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J2\u0010^\u001a\u00020G*\b\u0012\u0004\u0012\u00020\u00000I2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020G0`H\u0082\b\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0001J\u000f\u0010a\u001a\u0004\u0018\u00010bH\u0000¢\u0006\u0002\bcJ\n\u0010d\u001a\u0004\u0018\u00010eH\u0002J\u0016\u0010f\u001a\u00020G2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00000IH\u0002J0\u0010g\u001a\u00020\u00002\b\u0010h\u001a\u0004\u0018\u00010i2\u0017\u0010j\u001a\u0013\u0012\u0004\u0012\u00020k\u0012\u0004\u0012\u00020G0`¢\u0006\u0002\blH\u0002¢\u0006\u0002\bmJ\r\u0010n\u001a\u00020\u0000H\u0000¢\u0006\u0002\boR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000fR\u0011\u0010\u001b\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b0\u0010*R\u0011\u00101\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b3\u0010.R\u0011\u00104\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b5\u0010*R\u0011\u00106\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b7\u0010.R\u0011\u00108\u001a\u0002028F¢\u0006\u0006\u001a\u0004\b9\u0010.R\u0014\u0010:\u001a\u00020(8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010*R\u0014\u0010?\u001a\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b@\u0010\u000fR\u0011\u0010D\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\bE\u0010\u0013R\u0014\u0010K\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u000fR\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00000L8F¢\u0006\u0006\u001a\u0004\bS\u0010TR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00000L8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bV\u0010TR\u0011\u0010Y\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bY\u0010\u000fR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b[\u0010\\¨\u0006p"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsNode;", "", "outerSemanticsNode", "Landroidx/compose/ui/Modifier$Node;", "mergingEnabled", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "<init>", "(Landroidx/compose/ui/Modifier$Node;ZLandroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "getOuterSemanticsNode$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "getMergingEnabled", "()Z", "getLayoutNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getUnmergedConfig$ui_release", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "isFake", "isFake$ui_release", "setFake$ui_release", "(Z)V", "fakeNodeParent", "isUnmergedLeafNode", "isUnmergedLeafNode$ui_release", "layoutInfo", "Landroidx/compose/ui/layout/LayoutInfo;", "getLayoutInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", RootDescription.ROOT_ELEMENT, "Landroidx/compose/ui/node/RootForTest;", "getRoot", "()Landroidx/compose/ui/node/RootForTest;", "id", "", "getId", "()I", "touchBoundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "getTouchBoundsInRoot", "()Landroidx/compose/ui/geometry/Rect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "()J", "boundsInRoot", "getBoundsInRoot", "positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "getPositionInRoot-F1C5BW0", "boundsInWindow", "getBoundsInWindow", "positionInWindow", "getPositionInWindow-F1C5BW0", "positionOnScreen", "getPositionOnScreen-F1C5BW0", "boundsInParent", "getBoundsInParent$ui_release", "boundsInImportantForBoundsAncestor", "nodeCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "isTransparent", "isTransparent$ui_release", "getAlignmentLinePosition", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "config", "getConfig", "mergeConfig", "", "unmergedChildren", "", "mergedConfig", "isMergingSemanticsOfDescendants", "", "includeFakeNodes", "includeDeactivatedNodes", "unmergedChildren$ui_release", "fillOneLayerOfSemanticsWrappers", "list", "children", "getChildren", "()Ljava/util/List;", "replacedChildren", "getReplacedChildren$ui_release", "includeReplacedSemantics", "getChildren$ui_release", "isRoot", "parent", "getParent", "()Landroidx/compose/ui/semantics/SemanticsNode;", "findOneLayerOfMergingSemanticsNodes", "forEachUnmergedChild", "block", "Lkotlin/Function1;", "findCoordinatorToGetBounds", "Landroidx/compose/ui/node/NodeCoordinator;", "findCoordinatorToGetBounds$ui_release", "findSemanticsModifierNodeToGetBounds", "Landroidx/compose/ui/node/SemanticsModifierNode;", "emitFakeNodes", "fakeSemanticsNode", "role", "Landroidx/compose/ui/semantics/Role;", "properties", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "Lkotlin/ExtensionFunctionType;", "fakeSemanticsNode-ypyhhiA", "copyWithMergingEnabled", "copyWithMergingEnabled$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticsNode {
    public static final int $stable = 8;
    private SemanticsNode fakeNodeParent;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f15280id;
    private boolean isFake;
    private final LayoutNode layoutNode;
    private final boolean mergingEnabled;
    private final Modifier.Node outerSemanticsNode;
    private final SemanticsConfiguration unmergedConfig;

    public final List<SemanticsNode> getChildren() {
        return getChildren$ui_release$default(this, false, false, false, 7, null);
    }

    public final List<SemanticsNode> getReplacedChildren$ui_release() {
        return getChildren$ui_release$default(this, false, true, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v26 */
    /* JADX WARN: Type inference failed for: r6v27 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v13, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r7v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v19 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v23 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v12 */
    private final SemanticsModifierNode findSemanticsModifierNodeToGetBounds() {
        ?? r100 = 0;
        r100 = 0;
        r100 = 0;
        r100 = 0;
        if (this.unmergedConfig.isMergingSemanticsOfDescendants() == false) goto L51;
        NodeChain r101 = this.layoutNode.getNodes$ui_release();
        int r102 = NodeKind.m6556constructorimpl(8);
        if ((NodeChain.access$getAggregateChildKindSet(r101) & r102) == 0) goto L94;
        Modifier.Node r103 = r101.getHead$ui_release();
        ?? r104 = 0;
    L7:
        if (r103 == null) goto L50;
        if ((r103.getKindSet$ui_release() & r102) == 0) goto L48;
        ?? r105 = r103;
        MutableVector r106 = null;
    L11:
        if (r105 == 0) goto L48;
        if ((r105 instanceof SemanticsModifierNode) == true) goto L14;
        if ((r105.getKindSet$ui_release() & r102) == 0) goto L24;
        boolean r107 = true;
    L25:
        if (r107 == false) goto L46;
        if ((r105 instanceof DelegatingNode) == false) goto L46;
        Modifier.Node r108 = ((DelegatingNode) r105).getDelegate$ui_release();
        int r110 = 0;
        r105 = r105;
    L29:
        if (r108 == null) goto L44;
        if ((r108.getKindSet$ui_release() & r102) == 0) goto L33;
        boolean r111 = true;
    L34:
        if (r111 == false) goto L43;
        r110 = r110 + 1;
        if (r110 != 1) goto L38;
        r105 = r108;
        goto L43
    L38:
        if (r106 != null) goto L40;
        r106 = new MutableVector(new Modifier.Node[16], 0);
    L40:
        if (r105 == 0) goto L42;
        r106.add(r105);
        r105 = 0;
    L42:
        r106.add(r108);
    L43:
        r108 = r108.getChild$ui_release();
        r105 = r105;
        goto L29
    L33:
        r111 = false;
        goto L34
    L44:
        if (r110 == 1) goto L11;
    L46:
        r105 = DelegatableNodeKt.access$pop(r106);
        goto L11
    L24:
        r107 = false;
        goto L25
    L14:
        SemanticsModifierNode r109 = (SemanticsModifierNode) r105;
        if (r109.isImportantForBounds() == false) goto L46;
        if (r109.getShouldMergeDescendantSemantics() == true) goto L18;
        if (r104 != 0) goto L46;
        r104 = r109;
        goto L46
    L18:
        return r109;
    L48:
        if ((r103.getAggregateChildKindSet$ui_release() & r102) == 0) goto L50;
        r103 = r103.getChild$ui_release();
        r104 = r104;
    L50:
        r100 = r104;
    L94:
        return (SemanticsModifierNode) r100;
    L51:
        NodeChain r112 = this.layoutNode.getNodes$ui_release();
        int r113 = NodeKind.m6556constructorimpl(8);
        if ((NodeChain.access$getAggregateChildKindSet(r112) & r113) == 0) goto L94;
        Modifier.Node r114 = r112.getHead$ui_release();
    L54:
        if (r114 == null) goto L94;
        if ((r114.getKindSet$ui_release() & r113) == 0) goto L91;
        r104 = r114;
        MutableVector r115 = null;
    L58:
        if (r104 == 0) goto L91;
        if ((r104 instanceof SemanticsModifierNode) == true) goto L62;
        if ((r104.getKindSet$ui_release() & r113) == 0) goto L67;
        boolean r116 = true;
    L68:
        if (r116 == false) goto L89;
        if ((r104 instanceof DelegatingNode) == false) goto L89;
        Modifier.Node r117 = ((DelegatingNode) r104).getDelegate$ui_release();
        int r118 = 0;
        r104 = r104;
    L72:
        if (r117 == null) goto L87;
        if ((r117.getKindSet$ui_release() & r113) == 0) goto L76;
        boolean r119 = true;
    L77:
        if (r119 == false) goto L86;
        r118 = r118 + 1;
        if (r118 != 1) goto L81;
        r104 = r117;
        goto L86
    L81:
        if (r115 != null) goto L83;
        r115 = new MutableVector(new Modifier.Node[16], 0);
    L83:
        if (r104 == 0) goto L85;
        r115.add(r104);
        r104 = 0;
    L85:
        r115.add(r117);
    L86:
        r117 = r117.getChild$ui_release();
        r104 = r104;
        goto L72
    L76:
        r119 = false;
        goto L77
    L87:
        if (r118 == 1) goto L58;
    L89:
        r104 = DelegatableNodeKt.access$pop(r115);
        goto L58
    L67:
        r116 = false;
        goto L68
    L62:
        if (((SemanticsModifierNode) r104).isImportantForBounds() == false) goto L89;
    L91:
        if ((r114.getAggregateChildKindSet$ui_release() & r113) == 0) goto L94;
        r114 = r114.getChild$ui_release();
        goto L54
    }

    private final boolean isMergingSemanticsOfDescendants() {
        if (this.mergingEnabled == true) goto L5;
    L7:
        return false;
    L5:
        if (this.unmergedConfig.isMergingSemanticsOfDescendants() == false) goto L7;
        return true;
    }

    public final SemanticsNode copyWithMergingEnabled$ui_release() {
        return new SemanticsNode(this.outerSemanticsNode, true, this.layoutNode, this.unmergedConfig);
    }

    public final NodeCoordinator findCoordinatorToGetBounds$ui_release() {
        if (this.isFake == false) goto L9;
        SemanticsNode r100 = getParent();
        if (r100 != null) goto L15;
        return null;
    L15:
        return r100.findCoordinatorToGetBounds$ui_release();
    L9:
        SemanticsModifierNode r101 = findSemanticsModifierNodeToGetBounds();
        if (r101 == null) goto L14;
        NodeCoordinator r102 = DelegatableNodeKt.m6409requireCoordinator64DMado(r101, NodeKind.m6556constructorimpl(8));
        if (r102 == null) goto L14;
        return r102;
    L14:
        return this.layoutNode.getInnerCoordinator$ui_release();
    }

    public final SemanticsNode getParent() {
        SemanticsNode r100 = this.fakeNodeParent;
        if (r100 == null) goto L6;
        return r100;
    L6:
        if (this.mergingEnabled == false) goto L17;
        LayoutNode r101 = this.layoutNode.getParent$ui_release();
    L8:
        if (r101 == null) goto L17;
        SemanticsConfiguration r102 = r101.getSemanticsConfiguration();
        boolean r103 = false;
        if (r102 != null) goto L12;
    L14:
        if (r103 == true) goto L18;
        r101 = r101.getParent$ui_release();
    L18:
        if (r101 != null) goto L26;
        r101 = this.layoutNode.getParent$ui_release();
    L20:
        if (r101 == null) goto L25;
        if (r101.getNodes$ui_release().m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == true) goto L26;
        r101 = r101.getParent$ui_release();
        goto L20
    L25:
        r101 = null;
    L26:
        if (r101 != null) goto L29;
        return null;
    L29:
        return SemanticsNodeKt.SemanticsNode(r101, this.mergingEnabled);
    L12:
        if (r102.isMergingSemanticsOfDescendants() != true) goto L14;
        r103 = true;
    L17:
        r101 = null;
        goto L18
    }

    public final RootForTest getRoot() {
        Owner r100 = this.layoutNode.getOwner$ui_release();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRootForTest();
    }

    public final boolean isUnmergedLeafNode$ui_release() {
        if (this.isFake == false) goto L5;
        return false;
    L5:
        if (getReplacedChildren$ui_release().isEmpty() == false) goto L25;
        LayoutNode r100 = this.layoutNode.getParent$ui_release();
    L8:
        if (r100 == null) goto L18;
        SemanticsConfiguration r101 = r100.getSemanticsConfiguration();
        if (r101 != null) goto L12;
    L14:
        boolean r102 = false;
    L15:
        if (r102 == true) goto L19;
        r100 = r100.getParent$ui_release();
    L19:
        if (r100 != null) goto L26;
        return true;
    L26:
        return false;
    L12:
        if (r101.isMergingSemanticsOfDescendants() != true) goto L14;
        r102 = true;
        goto L15
    L18:
        r100 = null;
        goto L19
    L25:
        return false;
    }

    public final Rect getBoundsInParent$ui_release() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L15;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L15;
        LayoutCoordinates r101 = r100.getCoordinates();
        if (r101 == null) goto L15;
        return boundsInImportantForBoundsAncestor(r101);
    L15:
        return Rect.Companion.getZero();
    }

    public final Rect getBoundsInRoot() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L12;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        Rect r101 = LayoutCoordinatesKt.boundsInRoot(r100);
        if (r101 == null) goto L12;
        return r101;
    L12:
        return Rect.Companion.getZero();
    }

    public final Rect getBoundsInWindow() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L12;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L12;
        Rect r101 = LayoutCoordinatesKt.boundsInWindow(r100);
        if (r101 == null) goto L12;
        return r101;
    L12:
        return Rect.Companion.getZero();
    }

    public final SemanticsConfiguration getConfig() {
        if (isMergingSemanticsOfDescendants() == false) goto L7;
        SemanticsConfiguration r100 = this.unmergedConfig.copy();
        mergeConfig(new ArrayList(), r100);
        return r100;
    L7:
        return this.unmergedConfig;
    }

    /* JADX INFO: renamed from: getPositionInRoot-F1C5BW0, reason: not valid java name */
    public final long m6779getPositionInRootF1C5BW0() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L11;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        return LayoutCoordinatesKt.positionInRoot(r100);
    L11:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: getPositionInWindow-F1C5BW0, reason: not valid java name */
    public final long m6780getPositionInWindowF1C5BW0() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L11;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        return LayoutCoordinatesKt.positionInWindow(r100);
    L11:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: getPositionOnScreen-F1C5BW0, reason: not valid java name */
    public final long m6781getPositionOnScreenF1C5BW0() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L11;
        if (r100.isAttached() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L11;
        return LayoutCoordinatesKt.positionOnScreen(r100);
    L11:
        return Offset.Companion.m4598getZeroF1C5BW0();
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m6782getSizeYbymL2g() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 == null) goto L6;
        return r100.mo6258getSizeYbymL2g();
    L6:
        return IntSize.Companion.m7724getZeroYbymL2g();
    }

    public final Rect getTouchBoundsInRoot() {
        SemanticsModifierNode r100 = findSemanticsModifierNodeToGetBounds();
        if (r100 != null) goto L7;
        return this.layoutNode.getInnerCoordinator$ui_release().touchBoundsInRoot();
    L7:
        return SemanticsModifierNodeKt.touchBoundsInRoot(r100.getNode(), SemanticsModifierNodeKt.getUseMinimumTouchTarget(this.unmergedConfig));
    }

    public final boolean isRoot() {
        if (getParent() != null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isTransparent$ui_release() {
        NodeCoordinator r100 = findCoordinatorToGetBounds$ui_release();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isTransparent();
    }

    public final int getId() {
        return this.f15280id;
    }

    public final LayoutInfo getLayoutInfo() {
        return this.layoutNode;
    }

    public final LayoutNode getLayoutNode$ui_release() {
        return this.layoutNode;
    }

    public final boolean getMergingEnabled() {
        return this.mergingEnabled;
    }

    public final Modifier.Node getOuterSemanticsNode$ui_release() {
        return this.outerSemanticsNode;
    }

    public final SemanticsConfiguration getUnmergedConfig$ui_release() {
        return this.unmergedConfig;
    }

    public final boolean isFake$ui_release() {
        return this.isFake;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v9 */
    private final Rect boundsInImportantForBoundsAncestor(LayoutCoordinates r110) {
        SemanticsNode r100 = getParent();
        if (r100 == null) goto L5;
        NodeChain r101 = r100.layoutNode.getNodes$ui_release();
        int r102 = NodeKind.m6556constructorimpl(8);
        if ((NodeChain.access$getAggregateChildKindSet(r101) & r102) == 0) goto L48;
        Modifier.Node r103 = r101.getHead$ui_release();
    L9:
        if (r103 == null) goto L48;
        if ((r103.getKindSet$ui_release() & r102) == 0) goto L46;
        ?? r104 = r103;
        MutableVector r105 = null;
    L13:
        if (r104 == 0) goto L46;
        if ((r104 instanceof SemanticsModifierNode) == true) goto L17;
        if ((r104.getKindSet$ui_release() & r102) == 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L44;
        if ((r104 instanceof DelegatingNode) == false) goto L44;
        Modifier.Node r107 = ((DelegatingNode) r104).getDelegate$ui_release();
        int r111 = 0;
        r104 = r104;
    L27:
        if (r107 == null) goto L42;
        if ((r107.getKindSet$ui_release() & r102) == 0) goto L31;
        boolean r112 = true;
    L32:
        if (r112 == false) goto L41;
        r111 = r111 + 1;
        if (r111 != 1) goto L36;
        r104 = r107;
        goto L41
    L36:
        if (r105 != null) goto L38;
        r105 = new MutableVector(new Modifier.Node[16], 0);
    L38:
        if (r104 == 0) goto L40;
        r105.add(r104);
        r104 = 0;
    L40:
        r105.add(r107);
    L41:
        r107 = r107.getChild$ui_release();
        r104 = r104;
        goto L27
    L31:
        r112 = false;
        goto L32
    L42:
        if (r111 == 1) goto L13;
    L44:
        r104 = DelegatableNodeKt.access$pop(r105);
        goto L13
    L22:
        r106 = false;
        goto L23
    L17:
        if (((SemanticsModifierNode) r104).isImportantForBounds() == false) goto L44;
    L49:
        SemanticsModifierNode r108 = (SemanticsModifierNode) r104;
        if (r108 == null) goto L52;
        NodeCoordinator r109 = DelegatableNodeKt.m6409requireCoordinator64DMado(r108, NodeKind.m6556constructorimpl(8));
    L53:
        if (r109 != null) goto L57;
        return r100.boundsInImportantForBoundsAncestor(r110);
    L57:
        return LayoutCoordinates.CC.localBoundingBoxOf$default(r109, r110, false, 2, null);
    L52:
        r109 = null;
    L46:
        if ((r103.getAggregateChildKindSet$ui_release() & r102) == 0) goto L48;
        r103 = r103.getChild$ui_release();
    L48:
        r104 = 0;
        goto L49
    L5:
        return Rect.Companion.getZero();
    }

    private final void emitFakeNodes(List<SemanticsNode> r100) {
        final Role r101 = SemanticsNodeKt.access$getRole(this);
        if (r101 != null) goto L5;
    L9:
        SemanticsConfiguration r102 = this.unmergedConfig;
        SemanticsProperties r103 = SemanticsProperties.INSTANCE;
        if (r102.contains(r103.getContentDescription()) == true) goto L12;
        return;
    L12:
        if ((!r100.isEmpty()) == true) goto L14;
        return;
    L14:
        if (this.unmergedConfig.isMergingSemanticsOfDescendants() == false) goto L24;
        List r104 = (List) SemanticsConfigurationKt.getOrNull(this.unmergedConfig, r103.getContentDescription());
        if (r104 == null) goto L18;
        final String r105 = (String) CollectionsKt.firstOrNull(r104);
    L19:
        if (r105 == null) goto L25;
        ListProtector.add(r100, 0, m6778fakeSemanticsNodeypyhhiA(null, new SemanticsNode$emitFakeNodes$fakeNode$2(r105)));
        return;
    L25:
        return;
    L18:
        r105 = null;
        goto L19
    L24:
        return;
    L5:
        if (this.unmergedConfig.isMergingSemanticsOfDescendants() == false) goto L9;
        if ((!r100.isEmpty()) == false) goto L9;
        r100.add(m6778fakeSemanticsNodeypyhhiA(r101, new SemanticsNode$emitFakeNodes$fakeNode$1(r101)));
        goto L9
    }

    public final int getAlignmentLinePosition(AlignmentLine r100) {
        NodeCoordinator r101 = findCoordinatorToGetBounds$ui_release();
        if (r101 != null) goto L7;
        return Integer.MIN_VALUE;
    L7:
        return r101.get(r100);
    }

    public final void setFake$ui_release(boolean r100) {
        this.isFake = r100;
    }

    /* JADX INFO: renamed from: fakeSemanticsNode-ypyhhiA, reason: not valid java name */
    private final SemanticsNode m6778fakeSemanticsNodeypyhhiA(Role r100, Function1<? super SemanticsPropertyReceiver, Unit> r101) {
        SemanticsConfiguration r102 = new SemanticsConfiguration();
        r102.setMergingSemanticsOfDescendants(false);
        r102.setClearingSemantics(false);
        r101.invoke(r102);
        SemanticsNode$fakeSemanticsNode$fakeNode$1 r103 = new SemanticsNode$fakeSemanticsNode$fakeNode$1(r101);
        if (r100 == null) goto L5;
        int r104 = SemanticsNodeKt.access$roleFakeNodeId(this);
    L6:
        SemanticsNode r105 = new SemanticsNode(r103, false, new LayoutNode(true, r104), r102);
        r105.isFake = true;
        r105.fakeNodeParent = this;
        return r105;
    L5:
        r104 = SemanticsNodeKt.access$contentDescriptionFakeNodeId(this);
        goto L6
    }

    private final List<SemanticsNode> findOneLayerOfMergingSemanticsNodes(List<SemanticsNode> r100, List<SemanticsNode> r101) {
        int r102 = r100.size();
        unmergedChildren$ui_release$default(this, r100, false, false, 6, null);
        int r103 = r100.size();
    L3:
        if (r102 >= r103) goto L11;
        SemanticsNode r104 = (SemanticsNode) ListProtector.get(r100, r102);
        if (r104.isMergingSemanticsOfDescendants() == false) goto L8;
        r101.add(r104);
    L10:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r104.unmergedConfig.isClearingSemantics() == true) goto L10;
        r104.findOneLayerOfMergingSemanticsNodes(r100, r101);
        goto L10
    L11:
        return r101;
    }

    private final void forEachUnmergedChild(List<SemanticsNode> r100, Function1<? super SemanticsNode, Unit> r101) {
        int r102 = r100.size();
        unmergedChildren$ui_release$default(this, r100, false, false, 6, null);
        int r103 = r100.size();
    L3:
        if (r102 >= r103) goto L5;
        r101.invoke(ListProtector.get(r100, r102));
        r102 = r102 + 1;
        goto L3
    }

    private final void mergeConfig(List<SemanticsNode> r100, SemanticsConfiguration r101) {
        if (this.unmergedConfig.isClearingSemantics() == true) goto L10;
        int r102 = r100.size();
        unmergedChildren$ui_release$default(this, r100, false, false, 6, null);
        int r103 = r100.size();
    L5:
        if (r102 >= r103) goto L14;
        SemanticsNode r104 = (SemanticsNode) ListProtector.get(r100, r102);
        if (r104.isMergingSemanticsOfDescendants() == true) goto L9;
        r101.mergeChild$ui_release(r104.unmergedConfig);
        r104.mergeConfig(r100, r101);
    L9:
        r102 = r102 + 1;
        goto L5
    L14:
        return;
    }

    private final void fillOneLayerOfSemanticsWrappers(LayoutNode r100, List<SemanticsNode> r101, boolean r102) {
        MutableVector<LayoutNode> r103 = r100.getZSortedChildren();
        LayoutNode[] r104 = r103.content;
        int r105 = r103.getSize();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L14;
        LayoutNode r107 = r104[r106];
        if (r107.isAttached() == false) goto L13;
        if (r102 == true) goto L10;
        if (r107.isDeactivated() == true) goto L13;
    L10:
        if (r107.getNodes$ui_release().m6517hasH91voCI$ui_release(NodeKind.m6556constructorimpl(8)) == false) goto L12;
        r101.add(SemanticsNodeKt.SemanticsNode(r107, this.mergingEnabled));
        goto L13
    L12:
        fillOneLayerOfSemanticsWrappers(r107, r101, r102);
    L13:
        r106 = r106 + 1;
        goto L3
    }

    public final List<SemanticsNode> getChildren$ui_release(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L4;
    L7:
        ArrayList r103 = new ArrayList();
        if (isMergingSemanticsOfDescendants() == false) goto L12;
        return findOneLayerOfMergingSemanticsNodes$default(this, r103, null, 2, null);
    L12:
        return unmergedChildren$ui_release(r103, r101, r102);
    L4:
        if (this.unmergedConfig.isClearingSemantics() == false) goto L7;
        return CollectionsKt.emptyList();
    }

    public final List<SemanticsNode> unmergedChildren$ui_release(List<SemanticsNode> r100, boolean r101, boolean r102) {
        if (this.isFake == true) goto L5;
        fillOneLayerOfSemanticsWrappers(this.layoutNode, r100, r102);
        if (r101 == false) goto L9;
        emitFakeNodes(r100);
    L9:
        return r100;
    L5:
        return CollectionsKt.emptyList();
    }

    public SemanticsNode(Modifier.Node r100, boolean r101, LayoutNode r102, SemanticsConfiguration r103) {
        this.outerSemanticsNode = r100;
        this.mergingEnabled = r101;
        this.layoutNode = r102;
        this.unmergedConfig = r103;
        this.f15280id = r102.getSemanticsId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List findOneLayerOfMergingSemanticsNodes$default(SemanticsNode r100, List r101, List r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = new ArrayList();
    L6:
        return r100.findOneLayerOfMergingSemanticsNodes(r101, r102);
    }

    public static /* synthetic */ List getChildren$ui_release$default(SemanticsNode r100, boolean r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = !r100.mergingEnabled;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = false;
    L12:
        return r100.getChildren$ui_release(r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List unmergedChildren$ui_release$default(SemanticsNode r100, List r101, boolean r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = new ArrayList();
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = false;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = false;
    L12:
        return r100.unmergedChildren$ui_release(r101, r102, r103);
    }
}
