package androidx.compose.ui.semantics;

import androidx.collection.IntObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.node.LayoutNode;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B'\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000b\u001a\u00020\nH\u0080\u0002¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0019R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010#\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0011\u0010%\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010(\u001a\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u0006)"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "Landroidx/compose/ui/node/LayoutNode;", "rootNode", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "outerSemanticsNode", "Landroidx/collection/IntObjectMap;", "nodes", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/semantics/EmptySemanticsModifier;Landroidx/collection/IntObjectMap;)V", "", "semanticsId", "Landroidx/compose/ui/semantics/SemanticsInfo;", "get$ui_release", "(I)Landroidx/compose/ui/semantics/SemanticsInfo;", "get", "semanticsInfo", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "previousSemanticsConfiguration", "LC7/r;", "notifySemanticsChange$ui_release", "(Landroidx/compose/ui/semantics/SemanticsInfo;Landroidx/compose/ui/semantics/SemanticsConfiguration;)V", "notifySemanticsChange", "Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/semantics/EmptySemanticsModifier;", "Landroidx/collection/IntObjectMap;", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/semantics/SemanticsListener;", "listeners", "Landroidx/collection/MutableObjectList;", "getListeners$ui_release", "()Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "rootSemanticsNode", "getUnmergedRootSemanticsNode", "unmergedRootSemanticsNode", "getRootInfo$ui_release", "()Landroidx/compose/ui/semantics/SemanticsInfo;", "rootInfo", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SemanticsOwner {
    public static final int $stable = 8;
    private final MutableObjectList<SemanticsListener> listeners = new MutableObjectList<>(2);
    private final IntObjectMap<LayoutNode> nodes;
    private final EmptySemanticsModifier outerSemanticsNode;
    private final LayoutNode rootNode;

    public SemanticsOwner(LayoutNode layoutNode, EmptySemanticsModifier emptySemanticsModifier, IntObjectMap<LayoutNode> intObjectMap) {
        this.rootNode = layoutNode;
        this.outerSemanticsNode = emptySemanticsModifier;
        this.nodes = intObjectMap;
    }

    public final SemanticsInfo get$ui_release(int semanticsId) {
        return this.nodes.get(semanticsId);
    }

    public final MutableObjectList<SemanticsListener> getListeners$ui_release() {
        return this.listeners;
    }

    public final SemanticsInfo getRootInfo$ui_release() {
        return this.rootNode;
    }

    public final SemanticsNode getRootSemanticsNode() {
        return SemanticsNodeKt.SemanticsNode(this.rootNode, true);
    }

    public final SemanticsNode getUnmergedRootSemanticsNode() {
        return new SemanticsNode(this.outerSemanticsNode, false, this.rootNode, new SemanticsConfiguration());
    }

    public final void notifySemanticsChange$ui_release(SemanticsInfo semanticsInfo, SemanticsConfiguration previousSemanticsConfiguration) {
        MutableObjectList<SemanticsListener> mutableObjectList = this.listeners;
        Object[] objArr = mutableObjectList.content;
        int i = mutableObjectList._size;
        for (int i6 = 0; i6 < i; i6++) {
            ((SemanticsListener) objArr[i6]).onSemanticsChanged(semanticsInfo, previousSemanticsConfiguration);
        }
    }
}
