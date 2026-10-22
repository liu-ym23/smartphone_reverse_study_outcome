package m4;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10487a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f10488b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.c f10489c;

    public /* synthetic */ a(CoordinatorLayout.c cVar, View view, int i10) {
        this.f10487a = i10;
        this.f10489c = cVar;
        this.f10488b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        switch (this.f10487a) {
            case 0:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f10489c;
                if (z && hideBottomViewOnScrollBehavior.f4617m == 1) {
                    hideBottomViewOnScrollBehavior.g(this.f10488b);
                    break;
                }
                break;
            default:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f10489c;
                if (hideViewOnScrollBehavior.f4622d && z && hideViewOnScrollBehavior.f4628n == 1) {
                    hideViewOnScrollBehavior.h(this.f10488b);
                    break;
                }
                break;
        }
    }
}
