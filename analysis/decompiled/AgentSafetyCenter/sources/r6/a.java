package r6;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10463a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ View f10464b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ b3.a f10465c;

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z10) {
        switch (this.f10463a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f10465c;
                View view = this.f10464b;
                if (z10 && hideBottomViewOnScrollBehavior.f2391j == 1) {
                    hideBottomViewOnScrollBehavior.c(view);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f10465c;
                View view2 = this.f10464b;
                if (z10 && hideViewOnScrollBehavior.f2401j == 1) {
                    hideViewOnScrollBehavior.d(view2);
                    break;
                }
                break;
        }
    }
}
