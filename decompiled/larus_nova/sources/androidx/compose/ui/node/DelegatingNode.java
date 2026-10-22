package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0010¢\u0006\u0002\b\rJ!\u0010\u0013\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u001bJ\u0015\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001eJ\u001f\u0010\u000e\u001a\u0002H\u0014\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u0014H\u0004¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0015H\u0004J\u0018\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u0001H\u0002J\u0018\u0010#\u001a\u00020\n2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&H\u0002J\"\u0010'\u001a\u00020\n2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0)H\u0080\b¢\u0006\u0002\b*J\r\u0010+\u001a\u00020\nH\u0010¢\u0006\u0002\b,J\r\u0010-\u001a\u00020\nH\u0010¢\u0006\u0002\b.J\r\u0010/\u001a\u00020\nH\u0010¢\u0006\u0002\b0J\r\u00101\u001a\u00020\nH\u0010¢\u0006\u0002\b2J\r\u00103\u001a\u00020\nH\u0010¢\u0006\u0002\b4R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0001X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u00065"}, d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "<init>", "()V", "selfKindSet", "", "getSelfKindSet$ui_release$annotations", "getSelfKindSet$ui_release", "()I", "updateCoordinator", "", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "delegate", "getDelegate$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "setDelegate$ui_release", "(Landroidx/compose/ui/Modifier$Node;)V", "delegateUnprotected", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/ui/node/DelegatableNode;", "delegatableNode", "delegateUnprotected$ui_release", "(Landroidx/compose/ui/node/DelegatableNode;)Landroidx/compose/ui/node/DelegatableNode;", "undelegateUnprotected", "instance", "undelegateUnprotected$ui_release", "setAsDelegateTo", "owner", "setAsDelegateTo$ui_release", "undelegate", "validateDelegateKindSet", "delegateKindSet", "delegateNode", "updateNodeKindSet", "newKindSet", "recalculateOwner", "", "forEachImmediateDelegate", "block", "Lkotlin/Function1;", "forEachImmediateDelegate$ui_release", "markAsAttached", "markAsAttached$ui_release", "runAttachLifecycle", "runAttachLifecycle$ui_release", "runDetachLifecycle", "runDetachLifecycle$ui_release", "markAsDetached", "markAsDetached$ui_release", BasicTestActionHandler.TEST_ACTION_RESET, "reset$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;
    private final int selfKindSet;

    public static /* synthetic */ void getSelfKindSet$ui_release$annotations() {
    }

    public DelegatingNode() {
        this.selfKindSet = NodeKindKt.calculateNodeKindSetFrom(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsAttached$ui_release() {
        super.markAsAttached$ui_release();
        Modifier.Node r100 = getDelegate$ui_release();
    L3:
        if (r100 == null) goto L8;
        r100.updateCoordinator$ui_release(getCoordinator$ui_release());
        if (r100.isAttached() == true) goto L7;
        r100.markAsAttached$ui_release();
    L7:
        r100 = r100.getChild$ui_release();
        goto L3
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void markAsDetached$ui_release() {
        Modifier.Node r100 = getDelegate$ui_release();
    L3:
        if (r100 == null) goto L5;
        r100.markAsDetached$ui_release();
        r100 = r100.getChild$ui_release();
        goto L3
    L5:
        super.markAsDetached$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void reset$ui_release() {
        super.reset$ui_release();
        Modifier.Node r100 = getDelegate$ui_release();
    L3:
        if (r100 == null) goto L5;
        r100.reset$ui_release();
        r100 = r100.getChild$ui_release();
        goto L3
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runAttachLifecycle$ui_release() {
        Modifier.Node r100 = getDelegate$ui_release();
    L3:
        if (r100 == null) goto L5;
        r100.runAttachLifecycle$ui_release();
        r100 = r100.getChild$ui_release();
        goto L3
    L5:
        super.runAttachLifecycle$ui_release();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void runDetachLifecycle$ui_release() {
        super.runDetachLifecycle$ui_release();
        Modifier.Node r100 = getDelegate$ui_release();
    L3:
        if (r100 == null) goto L5;
        r100.runDetachLifecycle$ui_release();
        r100 = r100.getChild$ui_release();
        goto L3
    }

    public final Modifier.Node getDelegate$ui_release() {
        return this.delegate;
    }

    public final int getSelfKindSet$ui_release() {
        return this.selfKindSet;
    }

    public final <T extends DelegatableNode> T delegate(T r100) {
        Modifier.Node r101 = r100.getNode();
        boolean r102 = true;
        if (r101 == r100) goto L5;
        boolean r103 = true;
    L6:
        Modifier.Node r104 = null;
        if (r103 == false) goto L25;
        if ((r100 instanceof Modifier.Node) == false) goto L11;
        Modifier.Node r105 = (Modifier.Node) r100;
    L12:
        if (r105 == null) goto L15;
        r104 = r105.getParent$ui_release();
    L15:
        if (r101 == getNode()) goto L17;
    L19:
        r102 = false;
    L20:
        if (r102 == false) goto L23;
        return r100;
    L23:
        throw new IllegalStateException("Cannot delegate to an already delegated node".toString());
    L17:
        if (Intrinsics.areEqual(r104, this) == false) goto L19;
    L11:
        r105 = null;
        goto L12
    L25:
        if ((!r101.isAttached()) == true) goto L27;
        InlineClassHelperKt.throwIllegalStateException("Cannot delegate to an already attached node");
    L27:
        r101.setAsDelegateTo$ui_release(getNode());
        int r106 = getKindSet$ui_release();
        int r107 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(r101);
        r101.setKindSet$ui_release(r107);
        validateDelegateKindSet(r107, r101);
        r101.setChild$ui_release(this.delegate);
        this.delegate = r101;
        r101.setParent$ui_release(this);
        updateNodeKindSet(getKindSet$ui_release() | r107, false);
        if (isAttached() == true) goto L30;
    L42:
        return r100;
    L30:
        if ((r107 & NodeKind.m6556constructorimpl(2)) == 0) goto L32;
        boolean r108 = true;
    L33:
        if (r108 == true) goto L35;
    L40:
        updateCoordinator$ui_release(getCoordinator$ui_release());
    L41:
        r101.markAsAttached$ui_release();
        r101.runAttachLifecycle$ui_release();
        NodeKindKt.autoInvalidateInsertedNode(r101);
        goto L42
    L35:
        if ((r106 & NodeKind.m6556constructorimpl(2)) != 0) goto L38;
        r102 = false;
    L38:
        if (r102 == true) goto L40;
        NodeChain r109 = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
        getNode().updateCoordinator$ui_release(null);
        r109.syncCoordinators();
        goto L41
    L32:
        r108 = false;
        goto L33
    L5:
        r103 = false;
        goto L6
    }

    public final <T extends DelegatableNode> T delegateUnprotected$ui_release(T r100) {
        return (T) delegate(r100);
    }

    public final void forEachImmediateDelegate$ui_release(Function1<? super Modifier.Node, Unit> r100) {
        Modifier.Node r101 = getDelegate$ui_release();
    L3:
        if (r101 == null) goto L5;
        r100.invoke(r101);
        r101 = r101.getChild$ui_release();
        goto L3
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void setAsDelegateTo$ui_release(Modifier.Node r100) {
        super.setAsDelegateTo$ui_release(r100);
        Modifier.Node r101 = getDelegate$ui_release();
    L3:
        if (r101 == null) goto L5;
        r101.setAsDelegateTo$ui_release(r100);
        r101 = r101.getChild$ui_release();
        goto L3
    }

    public final void setDelegate$ui_release(Modifier.Node r100) {
        this.delegate = r100;
    }

    public final void undelegate(DelegatableNode r100) {
        Modifier.Node r101 = this.delegate;
        Modifier.Node r102 = null;
    L3:
        boolean r103 = true;
        if (r101 == null) goto L15;
        if (r101 == r100) goto L7;
        r102 = r101;
        r101 = r101.getChild$ui_release();
        goto L3
    L7:
        if (r101.isAttached() == false) goto L9;
        NodeKindKt.autoInvalidateRemovedNode(r101);
        r101.runDetachLifecycle$ui_release();
        r101.markAsDetached$ui_release();
    L9:
        r101.setAsDelegateTo$ui_release(r101);
        r101.setAggregateChildKindSet$ui_release(0);
        if (r102 != null) goto L12;
        this.delegate = r101.getChild$ui_release();
    L13:
        r101.setChild$ui_release(null);
        r101.setParent$ui_release(null);
        boolean r104 = true;
    L16:
        if (r104 == false) goto L32;
        int r105 = getKindSet$ui_release();
        int r106 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(this);
        updateNodeKindSet(r106, true);
        if (isAttached() == true) goto L20;
        return;
    L20:
        if ((r105 & NodeKind.m6556constructorimpl(2)) == 0) goto L22;
        boolean r107 = true;
    L23:
        if (r107 == true) goto L25;
        return;
    L25:
        if ((NodeKind.m6556constructorimpl(2) & r106) != 0) goto L28;
        r103 = false;
    L28:
        if (r103 == true) goto L37;
        NodeChain r108 = DelegatableNodeKt.requireLayoutNode(this).getNodes$ui_release();
        getNode().updateCoordinator$ui_release(null);
        r108.syncCoordinators();
        return;
    L37:
        return;
    L22:
        r107 = false;
        goto L23
    L32:
        throw new IllegalStateException(("Could not find delegate: " + r100).toString());
    L12:
        r102.setChild$ui_release(r101.getChild$ui_release());
        goto L13
    L15:
        r104 = false;
        goto L16
    }

    public final void undelegateUnprotected$ui_release(DelegatableNode r100) {
        undelegate(r100);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator r100) {
        super.updateCoordinator$ui_release(r100);
        Modifier.Node r101 = getDelegate$ui_release();
    L3:
        if (r101 == null) goto L5;
        r101.updateCoordinator$ui_release(r100);
        r101 = r101.getChild$ui_release();
        goto L3
    }

    private final void updateNodeKindSet(int r100, boolean r101) {
        int r102 = getKindSet$ui_release();
        setKindSet$ui_release(r100);
        if (r102 != r100) goto L5;
        return;
    L5:
        if (DelegatableNodeKt.isDelegationRoot(this) == false) goto L8;
        setAggregateChildKindSet$ui_release(r100);
    L8:
        if (isAttached() == false) goto L29;
        Modifier.Node r103 = getNode();
        Modifier.Node r104 = this;
    L10:
        if (r104 == null) goto L14;
        r100 = r100 | r104.getKindSet$ui_release();
        r104.setKindSet$ui_release(r100);
        if (r104 == r103) goto L14;
        r104 = r104.getParent$ui_release();
    L14:
        if (r101 == false) goto L17;
        if (r104 != r103) goto L17;
        r100 = NodeKindKt.calculateNodeKindSetFromIncludingDelegates(r103);
        r103.setKindSet$ui_release(r100);
    L17:
        if (r104 == null) goto L21;
        Modifier.Node r105 = r104.getChild$ui_release();
        if (r105 == null) goto L21;
        int r106 = r105.getAggregateChildKindSet$ui_release();
    L22:
        int r107 = r100 | r106;
    L23:
        if (r104 == null) goto L30;
        r107 = r107 | r104.getKindSet$ui_release();
        r104.setAggregateChildKindSet$ui_release(r107);
        r104 = r104.getParent$ui_release();
        goto L23
    L30:
        return;
    L21:
        r106 = 0;
        goto L22
    }

    private final void validateDelegateKindSet(int r100, Modifier.Node r101) {
        int r102 = getKindSet$ui_release();
        boolean r103 = true;
        if ((r100 & NodeKind.m6556constructorimpl(2)) == 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L8;
        return;
    L8:
        if ((NodeKind.m6556constructorimpl(2) & r102) != 0) goto L11;
        r103 = false;
    L11:
        if (r103 == true) goto L13;
        return;
    L13:
        if ((this instanceof LayoutModifierNode) == true) goto L18;
        InlineClassHelperKt.throwIllegalStateException("Delegating to multiple LayoutModifierNodes without the delegating node implementing LayoutModifierNode itself is not allowed.\nDelegating Node: " + this + "\nDelegate Node: " + r101);
        return;
    L18:
        return;
    L5:
        r104 = false;
        goto L6
    }
}
