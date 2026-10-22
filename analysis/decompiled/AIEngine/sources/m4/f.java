package m4;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HideViewOnScrollBehavior f10491a;

    public f(HideViewOnScrollBehavior hideViewOnScrollBehavior) {
        this.f10491a = hideViewOnScrollBehavior;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        HideViewOnScrollBehavior hideViewOnScrollBehavior = this.f10491a;
        a aVar = hideViewOnScrollBehavior.f4621c;
        if (aVar == null || (accessibilityManager = hideViewOnScrollBehavior.f4620b) == null) {
            return;
        }
        accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
        hideViewOnScrollBehavior.f4621c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
