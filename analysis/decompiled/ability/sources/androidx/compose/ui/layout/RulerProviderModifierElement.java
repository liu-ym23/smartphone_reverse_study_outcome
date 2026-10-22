package androidx.compose.ui.layout;

import android.annotation.SuppressLint;
import androidx.compose.ui.node.ModifierNodeElement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/layout/RulerProviderModifierElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/RulerProviderModifierNode;", "Landroidx/compose/ui/layout/InsetsListener;", "insetsListener", AppAgent.CONSTRUCT, "(Landroidx/compose/ui/layout/InsetsListener;)V", "create", "()Landroidx/compose/ui/layout/RulerProviderModifierNode;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "node", "LC7/r;", "update", "(Landroidx/compose/ui/layout/RulerProviderModifierNode;)V", "Landroidx/compose/ui/layout/InsetsListener;", "getInsetsListener", "()Landroidx/compose/ui/layout/InsetsListener;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@SuppressLint({"ModifierNodeInspectableProperties"})
/* loaded from: classes.dex */
final class RulerProviderModifierElement extends ModifierNodeElement<RulerProviderModifierNode> {
    private final InsetsListener insetsListener;

    public RulerProviderModifierElement(InsetsListener insetsListener) {
        this.insetsListener = insetsListener;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        RulerProviderModifierElement rulerProviderModifierElement = other instanceof RulerProviderModifierElement ? (RulerProviderModifierElement) other : null;
        return (rulerProviderModifierElement != null ? rulerProviderModifierElement.insetsListener : null) == this.insetsListener;
    }

    public final InsetsListener getInsetsListener() {
        return this.insetsListener;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.insetsListener.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* renamed from: create */
    public RulerProviderModifierNode getNode() {
        return new RulerProviderModifierNode(this.insetsListener);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(RulerProviderModifierNode node) {
        node.setInsetsListener(this.insetsListener);
    }
}
