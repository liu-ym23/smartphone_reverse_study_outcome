package androidx.compose.ui;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/SensitiveContentNode;", "Landroidx/compose/ui/Modifier$Node;", "_isContentSensitive", "", "<init>", "(Z)V", "isCountedSensitive", "value", "isContentSensitive", "()Z", "setContentSensitive", "onAttach", "", "onDetach", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class SensitiveContentNode extends Modifier.Node {
    private boolean _isContentSensitive;
    private boolean isContentSensitive;
    private boolean isCountedSensitive;

    private final boolean component1() {
        return this._isContentSensitive;
    }

    public static /* synthetic */ SensitiveContentNode copy$default(SensitiveContentNode r100, boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100._isContentSensitive;
    L6:
        return r100.copy(r101);
    }

    public final SensitiveContentNode copy(boolean r100) {
        return new SensitiveContentNode(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof SensitiveContentNode) == true) goto L9;
        return false;
    L9:
        if (this._isContentSensitive == ((SensitiveContentNode) r100)._isContentSensitive) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        if (this._isContentSensitive == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public String toString() {
        return "SensitiveContentNode(_isContentSensitive=" + this._isContentSensitive + ')';
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        if (this.isCountedSensitive == false) goto L5;
        DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
        this.isCountedSensitive = false;
    L5:
        super.onDetach();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        if (this.isContentSensitive == true) goto L5;
        return;
    L5:
        if ((!this.isCountedSensitive) == true) goto L7;
        InlineClassHelperKt.throwIllegalStateException("invalid sensitive content state");
    L7:
        DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
        this.isCountedSensitive = true;
    }

    public final boolean isContentSensitive() {
        return this.isContentSensitive;
    }

    public SensitiveContentNode(boolean r100) {
        this._isContentSensitive = r100;
        this.isContentSensitive = r100;
    }

    public final void setContentSensitive(boolean r100) {
        this.isContentSensitive = r100;
        if (r100 == true) goto L5;
    L7:
        if (r100 == false) goto L9;
        return;
    L9:
        if (this.isCountedSensitive == false) goto L14;
        DelegatableNodeKt.requireOwner(this).decrementSensitiveComponentCount();
        this.isCountedSensitive = false;
        return;
    L14:
        return;
    L5:
        if (this.isCountedSensitive == true) goto L7;
        DelegatableNodeKt.requireOwner(this).incrementSensitiveComponentCount();
        this.isCountedSensitive = true;
    }
}
