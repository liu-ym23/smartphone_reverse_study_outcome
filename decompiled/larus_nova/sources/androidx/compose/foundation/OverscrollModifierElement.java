package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\f\u0010\u0011\u001a\u00020\t*\u00020\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/OverscrollModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/OverscrollModifierNode;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "<init>", "(Landroidx/compose/foundation/OverscrollEffect;)V", "create", "update", "", "node", "equals", "", "other", "", "hashCode", "", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class OverscrollModifierElement extends ModifierNodeElement<OverscrollModifierNode> {
    private final OverscrollEffect overscrollEffect;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public OverscrollModifierNode create() {
        OverscrollEffect r100 = this.overscrollEffect;
        if (r100 == null) goto L5;
        DelegatableNode r101 = r100.getNode();
    L7:
        return new OverscrollModifierNode(r101);
    L5:
        r101 = null;
        goto L7
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        OverscrollEffect r100 = this.overscrollEffect;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    public OverscrollModifierElement(OverscrollEffect r100) {
        this.overscrollEffect = r100;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof OverscrollModifierElement) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.overscrollEffect, ((OverscrollModifierElement) r100).overscrollEffect) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo r100) {
        r100.setName("overscroll");
        r100.getProperties().set("overscrollEffect", this.overscrollEffect);
    }

    public void update(OverscrollModifierNode r100) {
        OverscrollEffect r101 = this.overscrollEffect;
        if (r101 == null) goto L5;
        DelegatableNode r102 = r101.getNode();
    L6:
        r100.update(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((OverscrollModifierNode) r100);
    }
}
