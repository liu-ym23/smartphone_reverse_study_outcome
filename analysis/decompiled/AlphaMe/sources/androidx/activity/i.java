package androidx.activity;

import android.view.View;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.E;
import androidx.lifecycle.EnumC0326x;
import androidx.lifecycle.G;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class i implements E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2392a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f2393b;

    public /* synthetic */ i(o oVar, int i4) {
        this.f2392a = i4;
        this.f2393b = oVar;
    }

    @Override // androidx.lifecycle.E
    public final void a(G g4, EnumC0326x enumC0326x) {
        switch (this.f2392a) {
            case 0:
                if (enumC0326x == EnumC0326x.ON_DESTROY) {
                    this.f2393b.mContextAwareHelper.f4460b = null;
                    if (!this.f2393b.isChangingConfigurations()) {
                        this.f2393b.getViewModelStore().a();
                    }
                    ((n) this.f2393b.mReportFullyDrawnExecutor).a();
                    break;
                }
                break;
            case 1:
                if (enumC0326x == EnumC0326x.ON_STOP) {
                    Window window = this.f2393b.getWindow();
                    View viewPeekDecorView = window != null ? window.peekDecorView() : null;
                    if (viewPeekDecorView != null) {
                        viewPeekDecorView.cancelPendingInputEvents();
                        break;
                    }
                }
                break;
            case 2:
                o oVar = this.f2393b;
                oVar.ensureViewModelStore();
                oVar.getLifecycle().b(this);
                break;
            default:
                if (enumC0326x == EnumC0326x.ON_CREATE) {
                    A a4 = this.f2393b.mOnBackPressedDispatcher;
                    OnBackInvokedDispatcher invoker = k.a((o) g4);
                    a4.getClass();
                    Intrinsics.checkNotNullParameter(invoker, "invoker");
                    a4.f2376e = invoker;
                    a4.b(a4.f2378g);
                    break;
                }
                break;
        }
    }
}
