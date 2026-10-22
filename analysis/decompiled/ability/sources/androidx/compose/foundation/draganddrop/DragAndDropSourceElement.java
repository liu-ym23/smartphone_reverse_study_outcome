package androidx.compose.foundation.draganddrop;

import S7.k;
import S7.n;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@ExperimentalFoundationApi
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0083\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B?\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\"\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0005*\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J,\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JL\u0010\u001a\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032$\b\u0002\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u0007HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010 \u001a\u00020\u001fHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b$\u0010%R#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0017R3\u0010\u000b\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\u00078\u0006¢\u0006\f\n\u0004\b\u000b\u0010(\u001a\u0004\b)\u0010\u0019¨\u0006*"}, d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "LC7/r;", "drawDragDecoration", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "LH7/c;", "", "dragAndDropSourceHandler", AppAgent.CONSTRUCT, "(LS7/k;LS7/n;)V", "create", "()Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "node", "update", "(Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;)V", "Landroidx/compose/ui/platform/InspectorInfo;", "inspectableProperties", "(Landroidx/compose/ui/platform/InspectorInfo;)V", "component1", "()LS7/k;", "component2", "()LS7/n;", "copy", "(LS7/k;LS7/n;)Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "LS7/k;", "getDrawDragDecoration", "LS7/n;", "getDragAndDropSourceHandler", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class DragAndDropSourceElement extends ModifierNodeElement<DragAndDropSourceNode> {
    private final n dragAndDropSourceHandler;
    private final k drawDragDecoration;

    public DragAndDropSourceElement(k kVar, n nVar) {
        this.drawDragDecoration = kVar;
        this.dragAndDropSourceHandler = nVar;
    }

    public static /* synthetic */ DragAndDropSourceElement copy$default(DragAndDropSourceElement dragAndDropSourceElement, k kVar, n nVar, int i, Object obj) {
        if ((i & 1) != 0) {
            kVar = dragAndDropSourceElement.drawDragDecoration;
        }
        if ((i & 2) != 0) {
            nVar = dragAndDropSourceElement.dragAndDropSourceHandler;
        }
        return dragAndDropSourceElement.copy(kVar, nVar);
    }

    /* renamed from: component1, reason: from getter */
    public final k getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    /* renamed from: component2, reason: from getter */
    public final n getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final DragAndDropSourceElement copy(k drawDragDecoration, n dragAndDropSourceHandler) {
        return new DragAndDropSourceElement(drawDragDecoration, dragAndDropSourceHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DragAndDropSourceElement)) {
            return false;
        }
        DragAndDropSourceElement dragAndDropSourceElement = (DragAndDropSourceElement) other;
        return kotlin.jvm.internal.k.b(this.drawDragDecoration, dragAndDropSourceElement.drawDragDecoration) && kotlin.jvm.internal.k.b(this.dragAndDropSourceHandler, dragAndDropSourceElement.dragAndDropSourceHandler);
    }

    public final n getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final k getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.dragAndDropSourceHandler.hashCode() + (this.drawDragDecoration.hashCode() * 31);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.setName("dragSource");
        inspectorInfo.getProperties().set("drawDragDecoration", this.drawDragDecoration);
        inspectorInfo.getProperties().set("dragAndDropSourceHandler", this.dragAndDropSourceHandler);
    }

    public String toString() {
        return "DragAndDropSourceElement(drawDragDecoration=" + this.drawDragDecoration + ", dragAndDropSourceHandler=" + this.dragAndDropSourceHandler + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public DragAndDropSourceNode create() {
        return new DragAndDropSourceNode(this.drawDragDecoration, this.dragAndDropSourceHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(DragAndDropSourceNode node) {
        node.setDrawDragDecoration(this.drawDragDecoration);
        node.setDragAndDropSourceHandler(this.dragAndDropSourceHandler);
    }
}
