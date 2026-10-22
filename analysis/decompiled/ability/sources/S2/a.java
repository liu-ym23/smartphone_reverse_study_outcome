package S2;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1170a;
    public final /* synthetic */ View b;
    public final /* synthetic */ CoordinatorLayout.Behavior c;

    public /* synthetic */ a(CoordinatorLayout.Behavior behavior, View view, int i) {
        this.f1170a = i;
        this.c = behavior;
        this.b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z10) {
        switch (this.f1170a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.c;
                if (z10 && hideBottomViewOnScrollBehavior.f2298j == 1) {
                    hideBottomViewOnScrollBehavior.c(this.b);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.c;
                if (hideViewOnScrollBehavior.d && z10 && hideViewOnScrollBehavior.k == 1) {
                    hideViewOnScrollBehavior.d(this.b);
                    break;
                }
                break;
        }
    }
}
