package androidx.compose.ui.layout;

import S7.k;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.unit.IntSize;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096D¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/compose/ui/layout/OnSizeChangedNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "LC7/r;", "onSizeChanged", AppAgent.CONSTRUCT, "(LS7/k;)V", "update", "size", "onRemeasured-ozmzZPI", "(J)V", "onRemeasured", "LS7/k;", "", "shouldAutoInvalidate", "Z", "getShouldAutoInvalidate", "()Z", "previousSize", "J", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class OnSizeChangedNode extends Modifier.Node implements LayoutAwareModifierNode {
    private k onSizeChanged;
    private long previousSize;
    private final boolean shouldAutoInvalidate = true;

    public OnSizeChangedNode(k kVar) {
        this.onSizeChanged = kVar;
        long j5 = Integer.MIN_VALUE;
        this.previousSize = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI */
    public void mo371onRemeasuredozmzZPI(long size) {
        if (IntSize.m7013equalsimpl0(this.previousSize, size)) {
            return;
        }
        this.onSizeChanged.invoke(IntSize.m7007boximpl(size));
        this.previousSize = size;
    }

    public final void update(k onSizeChanged) {
        this.onSizeChanged = onSizeChanged;
        long j5 = Integer.MIN_VALUE;
        this.previousSize = IntSize.m7010constructorimpl((j5 & 4294967295L) | (j5 << 32));
    }
}
