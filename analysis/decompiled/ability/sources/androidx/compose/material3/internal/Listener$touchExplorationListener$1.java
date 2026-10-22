package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R+\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0006¨\u0006\r"}, d2 = {"androidx/compose/material3/internal/Listener$touchExplorationListener$1", "Landroid/view/accessibility/AccessibilityManager$TouchExplorationStateChangeListener;", "", "enabled", "LC7/r;", "onTouchExplorationStateChanged", "(Z)V", "<set-?>", "enabled$delegate", "Landroidx/compose/runtime/MutableState;", "getEnabled", "()Z", "setEnabled", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Listener$touchExplorationListener$1 implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean enabled) {
        setEnabled(enabled);
    }

    public final void setEnabled(boolean z10) {
        this.enabled.setValue(Boolean.valueOf(z10));
    }
}
