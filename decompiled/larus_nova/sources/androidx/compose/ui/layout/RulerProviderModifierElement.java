package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.ModifierNodeElement;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/layout/RulerProviderModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/RulerProviderModifierNode;", "insetsListener", "Landroidx/compose/ui/layout/InsetsListener;", "<init>", "(Landroidx/compose/ui/layout/InsetsListener;)V", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "create", "hashCode", "", "equals", "", "other", "", "update", "", "node", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class RulerProviderModifierElement extends ModifierNodeElement<RulerProviderModifierNode> {
    private final InsetsListener insetsListener;

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public RulerProviderModifierNode create() {
        return new RulerProviderModifierNode(this.insetsListener);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.insetsListener.hashCode();
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ Modifier.Node create() {
        return create();
    }

    public RulerProviderModifierElement(InsetsListener r100) {
        this.insetsListener = r100;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object r100) {
        if (r100 != this) goto L5;
        return true;
    L5:
        InsetsListener r101 = null;
        if ((r100 instanceof RulerProviderModifierElement) == false) goto L8;
        RulerProviderModifierElement r102 = (RulerProviderModifierElement) r100;
    L9:
        if (r102 == null) goto L12;
        r101 = r102.insetsListener;
    L12:
        if (r101 == this.insetsListener) goto L16;
        return false;
    L16:
        return true;
    L8:
        r102 = null;
        goto L9
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public /* bridge */ /* synthetic */ void update(Modifier.Node r100) {
        update((RulerProviderModifierNode) r100);
    }

    public void update(RulerProviderModifierNode r100) {
        r100.setInsetsListener(this.insetsListener);
    }
}
