package androidx.activity;

import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j implements androidx.lifecycle.v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f684c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ p f685f;

    public /* synthetic */ j(int i) {
        this.f684c = i;
    }

    @Override // androidx.lifecycle.v
    public final void e(androidx.lifecycle.x xVar, androidx.lifecycle.o oVar) {
        switch (this.f684c) {
            case 0:
                if (oVar == androidx.lifecycle.o.ON_DESTROY) {
                    this.f685f.mContextAwareHelper.f2092b = null;
                    if (!this.f685f.isChangingConfigurations()) {
                        this.f685f.getViewModelStore().a();
                    }
                    o oVar2 = (o) this.f685f.mReportFullyDrawnExecutor;
                    p pVar = oVar2.f692h;
                    pVar.getWindow().getDecorView().removeCallbacks(oVar2);
                    pVar.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(oVar2);
                    break;
                }
                break;
            case 1:
                if (oVar == androidx.lifecycle.o.ON_STOP) {
                    Window window = this.f685f.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                        break;
                    }
                }
                break;
            case 2:
                p pVar2 = this.f685f;
                pVar2.ensureViewModelStore();
                pVar2.getLifecycle().c(this);
                break;
            default:
                if (oVar == androidx.lifecycle.o.ON_CREATE) {
                    e0 e0Var = this.f685f.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher onBackInvokedDispatcherA = l.a((p) xVar);
                    e0Var.getClass();
                    onBackInvokedDispatcherA.getClass();
                    e0Var.f668e = onBackInvokedDispatcherA;
                    e0Var.c(e0Var.f670g);
                    break;
                }
                break;
        }
    }
}
