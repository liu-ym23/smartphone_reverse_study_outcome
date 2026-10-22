package androidx.compose.foundation.content.internal;

import androidx.compose.foundation.content.ReceiveContentListener;
import androidx.compose.foundation.content.ReceiveContentNode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Landroidx/compose/foundation/content/internal/DynamicReceiveContentConfiguration;", "Landroidx/compose/foundation/content/internal/ReceiveContentConfiguration;", "receiveContentNode", "Landroidx/compose/foundation/content/ReceiveContentNode;", "<init>", "(Landroidx/compose/foundation/content/ReceiveContentNode;)V", "getReceiveContentNode", "()Landroidx/compose/foundation/content/ReceiveContentNode;", "getParentReceiveContentListener", "Landroidx/compose/foundation/content/ReceiveContentListener;", "receiveContentListener", "getReceiveContentListener", "()Landroidx/compose/foundation/content/ReceiveContentListener;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class DynamicReceiveContentConfiguration extends ReceiveContentConfiguration {
    public static final int $stable = 8;
    private final ReceiveContentListener receiveContentListener;
    private final ReceiveContentNode receiveContentNode;

    private final ReceiveContentListener getParentReceiveContentListener() {
        ReceiveContentConfiguration r100 = ReceiveContentConfigurationKt.getReceiveContentConfiguration(this.receiveContentNode);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getReceiveContentListener();
    }

    @Override // androidx.compose.foundation.content.internal.ReceiveContentConfiguration
    public ReceiveContentListener getReceiveContentListener() {
        return this.receiveContentListener;
    }

    public final ReceiveContentNode getReceiveContentNode() {
        return this.receiveContentNode;
    }

    public DynamicReceiveContentConfiguration(ReceiveContentNode r100) {
        this.receiveContentNode = r100;
        this.receiveContentListener = new DynamicReceiveContentConfiguration$receiveContentListener$1(this);
    }

    public static final /* synthetic */ ReceiveContentListener access$getParentReceiveContentListener(DynamicReceiveContentConfiguration r100) {
        return r100.getParentReceiveContentListener();
    }
}
