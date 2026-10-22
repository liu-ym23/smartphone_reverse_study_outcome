package androidx.compose.ui;

import androidx.appfunctions.metadata.a;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001a\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R*\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00028\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\u0005¨\u0006\u001d"}, d2 = {"Landroidx/compose/ui/SensitiveContentNode;", "Landroidx/compose/ui/Modifier$Node;", "", "_isContentSensitive", AppAgent.CONSTRUCT, "(Z)V", "component1", "()Z", "LC7/r;", "onAttach", "()V", "onDetach", "copy", "(Z)Landroidx/compose/ui/SensitiveContentNode;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "isCountedSensitive", "value", "isContentSensitive", "setContentSensitive", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final /* data */ class SensitiveContentNode extends Modifier.Node {
    private boolean _isContentSensitive;
    private boolean isContentSensitive;
    private boolean isCountedSensitive;

    public SensitiveContentNode(boolean z10) {
        this._isContentSensitive = z10;
        this.isContentSensitive = z10;
    }

    /* renamed from: component1, reason: from getter */
    private final boolean get_isContentSensitive() {
        return this._isContentSensitive;
    }

    public static /* synthetic */ SensitiveContentNode copy$default(SensitiveContentNode sensitiveContentNode, boolean z10, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = sensitiveContentNode._isContentSensitive;
        }
        return sensitiveContentNode.copy(z10);
    }

    public final SensitiveContentNode copy(boolean _isContentSensitive) {
        return new SensitiveContentNode(_isContentSensitive);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SensitiveContentNode) && this._isContentSensitive == ((SensitiveContentNode) other)._isContentSensitive;
    }

    public int hashCode() {
        return Boolean.hashCode(this._isContentSensitive);
    }

    /* renamed from: isContentSensitive, reason: from getter */
    public final boolean getIsContentSensitive() {
        return this.isContentSensitive;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        if (this.isContentSensitive) {
            if (this.isCountedSensitive) {
                InlineClassHelperKt.throwIllegalStateException("invalid sensitive content state");
            }
            DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
            this.isCountedSensitive = true;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (this.isCountedSensitive) {
            DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
            this.isCountedSensitive = false;
        }
        super.onDetach();
    }

    public final void setContentSensitive(boolean z10) {
        this.isContentSensitive = z10;
        if (z10 && !this.isCountedSensitive) {
            DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
            this.isCountedSensitive = true;
        } else {
            if (z10 || !this.isCountedSensitive) {
                return;
            }
            DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
            this.isCountedSensitive = false;
        }
    }

    public String toString() {
        return a.r(new StringBuilder("SensitiveContentNode(_isContentSensitive="), this._isContentSensitive, ')');
    }
}
