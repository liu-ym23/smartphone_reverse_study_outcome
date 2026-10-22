package v1;

import android.view.accessibility.AccessibilityManager;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements AccessibilityManager.AccessibilityStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ a0 f14579a;

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public final void onAccessibilityStateChanged(boolean z10) {
        a0 a0Var = this.f14579a;
        a0Var.f14338h = z10 ? a0Var.f14334d.getEnabledAccessibilityServiceList(-1) : kb.s.f7404c;
    }
}
