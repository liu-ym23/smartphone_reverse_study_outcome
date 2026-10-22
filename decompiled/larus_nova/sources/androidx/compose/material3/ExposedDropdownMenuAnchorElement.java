package androidx.compose.material3;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0002H\u0016J\f\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0016J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/ExposedDropdownMenuAnchorElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ExposedDropdownMenuAnchorNode;", "updateStateOnAttach", "Lkotlin/Function0;", "", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "getUpdateStateOnAttach", "()Lkotlin/jvm/functions/Function0;", "create", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "equals", "", "other", "", "hashCode", "", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class ExposedDropdownMenuAnchorElement extends ModifierNodeElement<ExposedDropdownMenuAnchorNode> {
    private final Function0<Unit> updateStateOnAttach;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public ExposedDropdownMenuAnchorNode create() {
        return new ExposedDropdownMenuAnchorNode(this.updateStateOnAttach);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.updateStateOnAttach.hashCode();
    }

    public final Function0<Unit> getUpdateStateOnAttach() {
        return this.updateStateOnAttach;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    public ExposedDropdownMenuAnchorElement(Function0<Unit> r100) {
        this.updateStateOnAttach = r100;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ExposedDropdownMenuAnchorElement) == true) goto L9;
        return false;
    L9:
        if (this.updateStateOnAttach == ((ExposedDropdownMenuAnchorElement) r100).updateStateOnAttach) goto L13;
        return false;
    L13:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("exposedDropdownMenuAnchorType");
        r100.getProperties().set("updateStateOnAttach", this.updateStateOnAttach);
    }

    public void update(ExposedDropdownMenuAnchorNode r100) {
        r100.setUpdateStateOnAttach(this.updateStateOnAttach);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((ExposedDropdownMenuAnchorNode) r100);
    }
}
