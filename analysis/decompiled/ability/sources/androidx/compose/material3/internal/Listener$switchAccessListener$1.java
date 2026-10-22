package androidx.compose.material3.internal;

import android.view.accessibility.AccessibilityManager;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R+\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00078F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"androidx/compose/material3/internal/Listener$switchAccessListener$1", "Landroid/view/accessibility/AccessibilityManager$AccessibilityServicesStateChangeListener;", "Landroid/view/accessibility/AccessibilityManager;", "am", "LC7/r;", "onAccessibilityServicesStateChanged", "(Landroid/view/accessibility/AccessibilityManager;)V", "", "<set-?>", "enabled$delegate", "Landroidx/compose/runtime/MutableState;", "getEnabled", "()Z", "setEnabled", "(Z)V", "enabled", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Listener$switchAccessListener$1 implements AccessibilityManager.AccessibilityServicesStateChangeListener {

    /* renamed from: enabled$delegate, reason: from kotlin metadata */
    private final MutableState enabled = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    final /* synthetic */ Listener this$0;

    public Listener$switchAccessListener$1(Listener listener) {
        this.this$0 = listener;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getEnabled() {
        return ((Boolean) this.enabled.getValue()).booleanValue();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityServicesStateChangeListener
    public void onAccessibilityServicesStateChanged(AccessibilityManager am) {
        setEnabled(this.this$0.getSwitchAccessEnabled(am));
    }

    public final void setEnabled(boolean z10) {
        this.enabled.setValue(Boolean.valueOf(z10));
    }
}
