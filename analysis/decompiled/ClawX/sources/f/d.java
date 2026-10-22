package f;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2419a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2420b;

    public /* synthetic */ d(int i8, Object obj) {
        this.f2419a = i8;
        this.f2420b = obj;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f2419a) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            default:
                w1.o oVar = (w1.o) this.f2420b;
                AccessibilityManager accessibilityManager = oVar.f6136u;
                if (oVar.f6137v != null && accessibilityManager != null && oVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(oVar.f6137v);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        switch (this.f2419a) {
            case 0:
                g gVar = (g) this.f2420b;
                ViewTreeObserver viewTreeObserver = gVar.y;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        gVar.y = view.getViewTreeObserver();
                    }
                    gVar.y.removeGlobalOnLayoutListener(gVar.f2433j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 1:
                s sVar = (s) this.f2420b;
                ViewTreeObserver viewTreeObserver2 = sVar.f2520p;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        sVar.f2520p = view.getViewTreeObserver();
                    }
                    sVar.f2520p.removeGlobalOnLayoutListener(sVar.f2514j);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 2:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f2420b;
                g1.a aVar = hideBottomViewOnScrollBehavior.f1212h;
                if (aVar != null && (accessibilityManager = hideBottomViewOnScrollBehavior.f1211g) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.f1212h = null;
                    break;
                }
                break;
            case 3:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f2420b;
                g1.a aVar2 = hideViewOnScrollBehavior.f1218c;
                if (aVar2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f1217b) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.f1218c = null;
                    break;
                }
                break;
            default:
                w1.o oVar = (w1.o) this.f2420b;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = oVar.f6137v;
                if (touchExplorationStateChangeListener != null && (accessibilityManager3 = oVar.f6136u) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
        }
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    private final void c(View view) {
    }

    private final void d(View view) {
    }
}
