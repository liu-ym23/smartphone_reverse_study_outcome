package D6;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* loaded from: classes3.dex */
public final class e implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f382a;
    public final /* synthetic */ Object b;

    public /* synthetic */ e(Object obj, int i) {
        this.f382a = i;
        this.b = obj;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View v10) {
        switch (this.f382a) {
            case 0:
                kotlin.jvm.internal.k.f(v10, "v");
                break;
            case 1:
                kotlin.jvm.internal.k.f(v10, "v");
                break;
            case 2:
                kotlin.jvm.internal.k.f(v10, "v");
                v10.removeOnAttachStateChangeListener(this);
                ((com.stepos.ability.voicewakeup.training.motionkit.a) this.b).g();
                break;
            case 3:
            case 4:
                break;
            default:
                com.google.android.material.textfield.m mVar = (com.google.android.material.textfield.m) this.b;
                AccessibilityManager accessibilityManager = mVar.f2680t;
                if (mVar.u != null && accessibilityManager != null && mVar.isAttachedToWindow()) {
                    accessibilityManager.addTouchExplorationStateChangeListener(mVar.u);
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View v10) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        AccessibilityManager accessibilityManager3;
        switch (this.f382a) {
            case 0:
                kotlin.jvm.internal.k.f(v10, "v");
                ((f) this.b).d();
                break;
            case 1:
                kotlin.jvm.internal.k.f(v10, "v");
                ((com.stepos.ability.voicewakeup.training.b) this.b).c.f();
                break;
            case 2:
                kotlin.jvm.internal.k.f(v10, "v");
                break;
            case 3:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.b;
                S2.a aVar = hideBottomViewOnScrollBehavior.h;
                if (aVar != null && (accessibilityManager = hideBottomViewOnScrollBehavior.g) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.h = null;
                    break;
                }
                break;
            case 4:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.b;
                S2.a aVar2 = hideViewOnScrollBehavior.c;
                if (aVar2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.b) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.c = null;
                    break;
                }
                break;
            default:
                com.google.android.material.textfield.m mVar = (com.google.android.material.textfield.m) this.b;
                AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = mVar.u;
                if (touchExplorationStateChangeListener != null && (accessibilityManager3 = mVar.f2680t) != null) {
                    accessibilityManager3.removeTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
                    break;
                }
                break;
        }
    }
}
