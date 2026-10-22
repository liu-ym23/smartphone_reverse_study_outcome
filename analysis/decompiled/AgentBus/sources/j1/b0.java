package j1;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import com.stepos.agentbus.R;
import java.util.Iterator;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class b0 implements View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f5104f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Object f5105g;

    public /* synthetic */ b0(int i2, Object obj) {
        this.f5104f = i2;
        this.f5105g = obj;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        switch (this.f5104f) {
            case 0:
                f0 f0Var = (f0) this.f5105g;
                AccessibilityManager accessibilityManager = f0Var.f5141g;
                f0Var.f5145k = accessibilityManager.getEnabledAccessibilityServiceList(-1);
                accessibilityManager.addAccessibilityStateChangeListener(f0Var.f5143i);
                accessibilityManager.addTouchExplorationStateChangeListener(f0Var.f5144j);
                break;
            case 1:
            case 2:
                break;
            default:
                b0.x0 x0Var = (b0.x0) this.f5105g;
                Context context = view.getContext();
                if (!x0Var.f1415b) {
                    context.getApplicationContext().registerComponentCallbacks((u0.c) x0Var.f1417d);
                    x0Var.f1415b = true;
                    break;
                }
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        boolean z4;
        switch (this.f5104f) {
            case 0:
                f0 f0Var = (f0) this.f5105g;
                f0Var.f5146l.removeCallbacks(f0Var.N);
                AccessibilityManager accessibilityManager = f0Var.f5141g;
                accessibilityManager.removeAccessibilityStateChangeListener(f0Var.f5143i);
                accessibilityManager.removeTouchExplorationStateChangeListener(f0Var.f5144j);
                break;
            case 1:
                b bVar = (b) this.f5105g;
                Iterator it = fa.l.s0(bVar.getParent(), o2.n.f7238n).iterator();
                while (true) {
                    if (it.hasNext()) {
                        Object obj = (ViewParent) it.next();
                        if (obj instanceof View) {
                            View view2 = (View) obj;
                            q7.k.e(view2, "<this>");
                            Object tag = view2.getTag(R.id.is_pooling_container_tag);
                            Boolean bool = tag instanceof Boolean ? (Boolean) tag : null;
                            if (bool != null ? bool.booleanValue() : false) {
                                z4 = true;
                            }
                        }
                    }
                }
                if (!z4) {
                    n2 n2Var = bVar.f5098h;
                    if (n2Var != null) {
                        n2Var.c();
                    }
                    bVar.f5098h = null;
                    bVar.requestLayout();
                    break;
                }
                break;
            case 2:
                view.removeOnAttachStateChangeListener(this);
                ia.f1.cancel$default((ia.g1) this.f5105g, (CancellationException) null, 1, (Object) null);
                break;
            default:
                b0.x0 x0Var = (b0.x0) this.f5105g;
                Context context = view.getContext();
                if (x0Var.f1415b) {
                    context.getApplicationContext().unregisterComponentCallbacks((u0.c) x0Var.f1417d);
                    x0Var.f1415b = false;
                    break;
                }
                break;
        }
    }
}
