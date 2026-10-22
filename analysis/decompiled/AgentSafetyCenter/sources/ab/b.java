package ab;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;
import com.stepos.agentsafetycenter.R;
import gc.m;
import java.util.Iterator;
import kc.z;
import l.c0;
import n3.n0;
import v1.a0;
import v1.g2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f378c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f379f;

    public /* synthetic */ b(int i) {
        this.f378c = i;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f378c) {
            case 0:
                view.getClass();
                break;
            case 1:
                d1.d dVar = (d1.d) this.f379f;
                Context context = view.getContext();
                if (!dVar.f2963c) {
                    context.getApplicationContext().registerComponentCallbacks(dVar.f2964d);
                    dVar.f2963c = true;
                    break;
                }
                break;
            case 2:
            case 3:
            case 4:
            case 5:
                break;
            case 6:
                a0 a0Var = (a0) this.f379f;
                AccessibilityManager accessibilityManager = a0Var.f14334d;
                a0Var.f14338h = accessibilityManager.getEnabledAccessibilityServiceList(-1);
                accessibilityManager.addAccessibilityStateChangeListener(a0Var.f14336f);
                accessibilityManager.addTouchExplorationStateChangeListener(a0Var.f14337g);
                break;
            case 7:
            case 8:
                break;
            default:
                view.getClass();
                view.removeOnAttachStateChangeListener(this);
                z9.e eVar = (z9.e) this.f379f;
                eVar.f16522f = null;
                eVar.c();
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        AccessibilityManager accessibilityManager;
        AccessibilityManager accessibilityManager2;
        boolean z10 = false;
        switch (this.f378c) {
            case 0:
                view.getClass();
                ((c) this.f379f).e();
                break;
            case 1:
                d1.d dVar = (d1.d) this.f379f;
                Context context = view.getContext();
                if (dVar.f2963c) {
                    context.getApplicationContext().unregisterComponentCallbacks(dVar.f2964d);
                    dVar.f2963c = false;
                    break;
                }
                break;
            case 2:
                l.f fVar = (l.f) this.f379f;
                ViewTreeObserver viewTreeObserver = fVar.B;
                if (viewTreeObserver != null) {
                    if (!viewTreeObserver.isAlive()) {
                        fVar.B = view.getViewTreeObserver();
                    }
                    fVar.B.removeGlobalOnLayoutListener(fVar.f7554m);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 3:
                c0 c0Var = (c0) this.f379f;
                ViewTreeObserver viewTreeObserver2 = c0Var.f7536s;
                if (viewTreeObserver2 != null) {
                    if (!viewTreeObserver2.isAlive()) {
                        c0Var.f7536s = view.getViewTreeObserver();
                    }
                    c0Var.f7536s.removeGlobalOnLayoutListener(c0Var.f7530m);
                }
                view.removeOnAttachStateChangeListener(this);
                break;
            case 4:
                HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior = (HideBottomViewOnScrollBehavior) this.f379f;
                r6.a aVar = hideBottomViewOnScrollBehavior.f2390h;
                if (aVar != null && (accessibilityManager = hideBottomViewOnScrollBehavior.f2389g) != null) {
                    accessibilityManager.removeTouchExplorationStateChangeListener(aVar);
                    hideBottomViewOnScrollBehavior.f2390h = null;
                    break;
                }
                break;
            case 5:
                HideViewOnScrollBehavior hideViewOnScrollBehavior = (HideViewOnScrollBehavior) this.f379f;
                r6.a aVar2 = hideViewOnScrollBehavior.f2395c;
                if (aVar2 != null && (accessibilityManager2 = hideViewOnScrollBehavior.f2394b) != null) {
                    accessibilityManager2.removeTouchExplorationStateChangeListener(aVar2);
                    hideViewOnScrollBehavior.f2395c = null;
                    break;
                }
                break;
            case 6:
                a0 a0Var = (a0) this.f379f;
                a0Var.i.removeCallbacks(a0Var.K);
                AccessibilityManager accessibilityManager3 = a0Var.f14334d;
                accessibilityManager3.removeAccessibilityStateChangeListener(a0Var.f14336f);
                accessibilityManager3.removeTouchExplorationStateChangeListener(a0Var.f14337g);
                break;
            case 7:
                v1.a aVar3 = (v1.a) this.f379f;
                Iterator it = m.S(aVar3.getParent(), n0.f8738m).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object obj = (ViewParent) it.next();
                        if (obj instanceof View) {
                            View view2 = (View) obj;
                            view2.getClass();
                            Object tag = view2.getTag(R.id.is_pooling_container_tag);
                            Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
                            if (bool != null ? bool.booleanValue() : false) {
                                z10 = true;
                            }
                        }
                    }
                }
                if (!z10) {
                    g2 g2Var = aVar3.f14326g;
                    if (g2Var != null) {
                        g2Var.a();
                    }
                    aVar3.f14326g = null;
                    aVar3.requestLayout();
                    break;
                }
                break;
            case 8:
                view.removeOnAttachStateChangeListener(this);
                ((z) this.f379f).e(null);
                break;
            default:
                view.getClass();
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

    private final void e(View view) {
    }

    private final void f(View view) {
    }
}
