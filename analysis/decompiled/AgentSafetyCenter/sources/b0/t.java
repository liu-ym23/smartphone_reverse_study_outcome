package b0;

import android.content.Context;
import android.view.View;
import java.util.WeakHashMap;
import k0.k0;
import s.c0;
import s.e0;
import s.e1;
import s.x0;
import s.y0;
import v1.j0;
import w.z0;
import y.l0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t implements k0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1785a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f1786b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f1787c;

    public /* synthetic */ t(int i) {
        this.f1785a = i;
    }

    @Override // k0.k0
    public final void dispose() {
        switch (this.f1785a) {
            case 0:
                ((x) this.f1786b).f1797d.remove((xb.l) this.f1787c);
                break;
            case 1:
                ((androidx.lifecycle.x) this.f1786b).getLifecycle().c((k8.m) this.f1787c);
                break;
            case 2:
                ((androidx.lifecycle.x) this.f1786b).getLifecycle().c((k8.r) this.f1787c);
                break;
            case 3:
                ((androidx.lifecycle.x) this.f1786b).getLifecycle().c((k8.n) this.f1787c);
                break;
            case 4:
                ((e0) this.f1786b).f10985a.j((c0) this.f1787c);
                break;
            case 5:
                ((e1) this.f1786b).f10997j.remove((e1) this.f1787c);
                break;
            case 6:
                e1 e1Var = (e1) this.f1786b;
                x0 x0Var = (x0) ((y0) this.f1787c).f11167b.getValue();
                if (x0Var != null) {
                    e1Var.i.remove(x0Var.f11162c);
                    break;
                }
                break;
            case 7:
                ((Context) this.f1786b).getApplicationContext().unregisterComponentCallbacks((j0) this.f1787c);
                break;
            case 8:
                ((Context) this.f1786b).getApplicationContext().unregisterComponentCallbacks((v1.k0) this.f1787c);
                break;
            case 9:
                z0 z0Var = (z0) this.f1786b;
                View view = (View) this.f1787c;
                int i = z0Var.f15086s - 1;
                z0Var.f15086s = i;
                if (i == 0) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    n3.e0.b(view, null);
                    view.setWindowInsetsAnimationCallback(null);
                    view.removeOnAttachStateChangeListener(z0Var.f15087t);
                    break;
                }
                break;
            default:
                ((l0) this.f1786b).f15787g.add(this.f1787c);
                break;
        }
    }
}
