package k;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* renamed from: k.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnAttachStateChangeListenerC0652f implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13186a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f13187b;

    public /* synthetic */ ViewOnAttachStateChangeListenerC0652f(int i4, Object obj) {
        this.f13186a = i4;
        this.f13187b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        AccessibilityManager accessibilityManager;
        int i4 = this.f13186a;
        Object obj = this.f13187b;
        switch (i4) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                com.google.android.material.textfield.n nVar = (com.google.android.material.textfield.n) obj;
                int i5 = com.google.android.material.textfield.n.f11034w;
                if (nVar.f11055u != null && (accessibilityManager = nVar.f11054t) != null && nVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(nVar.f11055u);
                    break;
                }
                break;
            default:
                try {
                    view.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) obj);
                    break;
                } catch (Exception unused) {
                    return;
                }
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        int i4 = this.f13186a;
        Object obj = this.f13187b;
        switch (i4) {
            case 0:
                ViewOnKeyListenerC0655i viewOnKeyListenerC0655i = (ViewOnKeyListenerC0655i) obj;
                ViewTreeObserver viewTreeObserver = viewOnKeyListenerC0655i.f13220y;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        viewOnKeyListenerC0655i.f13220y = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0655i.f13220y.removeGlobalOnLayoutListener(viewOnKeyListenerC0655i.f13205j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                ViewOnKeyListenerC0645F viewOnKeyListenerC0645F = (ViewOnKeyListenerC0645F) obj;
                ViewTreeObserver viewTreeObserver2 = viewOnKeyListenerC0645F.f13155p;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        viewOnKeyListenerC0645F.f13155p = view.getViewTreeObserver();
                    }
                    viewOnKeyListenerC0645F.f13155p.removeGlobalOnLayoutListener(viewOnKeyListenerC0645F.f13149j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) obj;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = hideBottomViewOnScrollBehavior.f10378h;
                if (touchExplorationStateChangeListener != null && (accessibilityManager = hideBottomViewOnScrollBehavior.f10377g) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    hideBottomViewOnScrollBehavior.f10378h = null;
                    break;
                }
                break;
            case 3:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) obj;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener2 = hideViewOnScrollBehavior.f10384c;
                if (touchExplorationStateChangeListener2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f10383b) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener2);
                    hideViewOnScrollBehavior.f10384c = null;
                    break;
                }
                break;
            case 4:
                com.google.android.material.textfield.n nVar = (com.google.android.material.textfield.n) obj;
                int i5 = com.google.android.material.textfield.n.f11034w;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener3 = nVar.f11055u;
                if (touchExplorationStateChangeListener3 != null && (accessibilityManager3 = nVar.f11054t) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener3);
                    break;
                }
                break;
            default:
                try {
                    view.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener) obj);
                    break;
                } catch (Exception unused) {
                    return;
                }
        }
    }
}
