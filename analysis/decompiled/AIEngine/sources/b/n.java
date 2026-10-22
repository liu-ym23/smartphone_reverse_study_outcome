package b;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.y0;
import androidx.lifecycle.Lifecycle;
import com.stepos.aiengine.R;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class n extends Dialog implements androidx.lifecycle.q, s, w1.d {

    /* renamed from: a, reason: collision with root package name */
    public androidx.lifecycle.s f3019a;

    /* renamed from: b, reason: collision with root package name */
    public final w1.c f3020b;

    /* renamed from: c, reason: collision with root package name */
    public final OnBackPressedDispatcher f3021c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Context context, int i10) {
        super(context, i10);
        kotlin.jvm.internal.g.f(context, "context");
        this.f3020b = new w1.c(new x1.a(this, new b6.g(this, 19)));
        this.f3021c = new OnBackPressedDispatcher(new y0(this, 1));
    }

    public static void a(n nVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.g.f(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        kotlin.jvm.internal.g.c(window);
        View decorView = window.getDecorView();
        kotlin.jvm.internal.g.e(decorView, "getDecorView(...)");
        a4.a.u(decorView, this);
        Window window2 = getWindow();
        kotlin.jvm.internal.g.c(window2);
        View decorView2 = window2.getDecorView();
        kotlin.jvm.internal.g.e(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        kotlin.jvm.internal.g.c(window3);
        View decorView3 = window3.getDecorView();
        kotlin.jvm.internal.g.e(decorView3, "getDecorView(...)");
        y.L(decorView3, this);
    }

    @Override // androidx.lifecycle.q
    public final Lifecycle getLifecycle() {
        androidx.lifecycle.s sVar = this.f3019a;
        if (sVar != null) {
            return sVar;
        }
        androidx.lifecycle.s sVar2 = new androidx.lifecycle.s(this);
        this.f3019a = sVar2;
        return sVar2;
    }

    @Override // b.s
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.f3021c;
    }

    @Override // w1.d
    public final w1.b getSavedStateRegistry() {
        return this.f3020b.f13554b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f3021c.c();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            kotlin.jvm.internal.g.e(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            OnBackPressedDispatcher onBackPressedDispatcher = this.f3021c;
            onBackPressedDispatcher.f204e = onBackInvokedDispatcher;
            onBackPressedDispatcher.d(onBackPressedDispatcher.f206g);
        }
        this.f3020b.a(bundle);
        androidx.lifecycle.s sVar = this.f3019a;
        if (sVar == null) {
            sVar = new androidx.lifecycle.s(this);
            this.f3019a = sVar;
        }
        sVar.f(Lifecycle.Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        kotlin.jvm.internal.g.e(bundleOnSaveInstanceState, "onSaveInstanceState(...)");
        this.f3020b.b(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        androidx.lifecycle.s sVar = this.f3019a;
        if (sVar == null) {
            sVar = new androidx.lifecycle.s(this);
            this.f3019a = sVar;
        }
        sVar.f(Lifecycle.Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        androidx.lifecycle.s sVar = this.f3019a;
        if (sVar == null) {
            sVar = new androidx.lifecycle.s(this);
            this.f3019a = sVar;
        }
        sVar.f(Lifecycle.Event.ON_DESTROY);
        this.f3019a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i10) {
        b();
        super.setContentView(i10);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        kotlin.jvm.internal.g.f(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        kotlin.jvm.internal.g.f(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
