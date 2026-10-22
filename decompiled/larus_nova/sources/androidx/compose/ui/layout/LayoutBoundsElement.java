package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\u00020\u000b*\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0004HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Landroidx/compose/ui/layout/LayoutBoundsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutBoundsNode;", "holder", "Landroidx/compose/ui/layout/LayoutBoundsHolder;", "<init>", "(Landroidx/compose/ui/layout/LayoutBoundsHolder;)V", "getHolder", "()Landroidx/compose/ui/layout/LayoutBoundsHolder;", "create", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LayoutBoundsElement extends ModifierNodeElement<LayoutBoundsNode> {
    public static final int $stable = 0;
    private final LayoutBoundsHolder holder;

    public static /* synthetic */ LayoutBoundsElement copy$default(LayoutBoundsElement r100, LayoutBoundsHolder r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.holder;
    L6:
        return r100.copy(r101);
    }

    public final LayoutBoundsHolder component1() {
        return this.holder;
    }

    public final LayoutBoundsElement copy(LayoutBoundsHolder r100) {
        return new LayoutBoundsElement(r100);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LayoutBoundsElement) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.holder, ((LayoutBoundsElement) r100).holder) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.holder.hashCode();
    }

    public String toString() {
        return "LayoutBoundsElement(holder=" + this.holder + ')';
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public LayoutBoundsNode create() {
        return new LayoutBoundsNode(this.holder);
    }

    public final LayoutBoundsHolder getHolder() {
        return this.holder;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    public LayoutBoundsElement(LayoutBoundsHolder r100) {
        this.holder = r100;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("layoutBounds");
        r100.getProperties().set("holder", this.holder);
    }

    public void update(LayoutBoundsNode r100) {
        r100.setHolder(this.holder);
        r100.forceUpdate();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((LayoutBoundsNode) r100);
    }
}
