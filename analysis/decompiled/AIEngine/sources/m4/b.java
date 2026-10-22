package m4;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HideBottomViewOnScrollBehavior f10490a;

    public b(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.f10490a = hideBottomViewOnScrollBehavior;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = this.f10490a;
        a aVar = hideBottomViewOnScrollBehavior.f4615k;
        if (aVar == null || (accessibilityManager = hideBottomViewOnScrollBehavior.f4614j) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
        hideBottomViewOnScrollBehavior.f4615k = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
