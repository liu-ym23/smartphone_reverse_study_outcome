package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.AbstractC0533m;
import androidx.lifecycle.C0541v;
import androidx.lifecycle.InterfaceC0539t;
import androidx.lifecycle.Y;
import c0.C0574d;
import c0.C0575e;
import c0.C0577g;
import c0.InterfaceC0576f;

/* loaded from: classes.dex */
public class k extends Dialog implements InterfaceC0539t, r, InterfaceC0576f {

    /* renamed from: a, reason: collision with root package name */
    private C0541v f7372a;

    /* renamed from: b, reason: collision with root package name */
    private final C0575e f7373b;

    /* renamed from: c, reason: collision with root package name */
    private final p f7374c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(Context context, int i5) {
        super(context, i5);
        j4.k.g(context, "context");
        this.f7373b = C0575e.f11943d.a(this);
        this.f7374c = new p(new Runnable() { // from class: androidx.activity.j
            @Override // java.lang.Runnable
            public final void run() {
                k.g(this.f7371a);
            }
        });
    }

    private final C0541v d() {
        C0541v c0541v = this.f7372a;
        if (c0541v != null) {
            return c0541v;
        }
        C0541v c0541v2 = new C0541v(this);
        this.f7372a = c0541v2;
        return c0541v2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(k kVar) {
        j4.k.g(kVar, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j4.k.g(view, "view");
        e();
        super.addContentView(view, layoutParams);
    }

    public void e() {
        Window window = getWindow();
        j4.k.d(window);
        View decorView = window.getDecorView();
        j4.k.f(decorView, "window!!.decorView");
        Y.a(decorView, this);
        Window window2 = getWindow();
        j4.k.d(window2);
        View decorView2 = window2.getDecorView();
        j4.k.f(decorView2, "window!!.decorView");
        u.a(decorView2, this);
        Window window3 = getWindow();
        j4.k.d(window3);
        View decorView3 = window3.getDecorView();
        j4.k.f(decorView3, "window!!.decorView");
        C0577g.a(decorView3, this);
    }

    @Override // androidx.lifecycle.InterfaceC0539t
    public AbstractC0533m getLifecycle() {
        return d();
    }

    @Override // androidx.activity.r
    public final p getOnBackPressedDispatcher() {
        return this.f7374c;
    }

    @Override // c0.InterfaceC0576f
    public C0574d getSavedStateRegistry() {
        return this.f7373b.b();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.f7374c.k();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p pVar = this.f7374c;
        OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
        j4.k.f(onBackInvokedDispatcher, "onBackInvokedDispatcher");
        pVar.n(onBackInvokedDispatcher);
        this.f7373b.d(bundle);
        d().i(AbstractC0533m.a.ON_CREATE);
    }

    @Override // android.app.Dialog
    public Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        j4.k.f(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f7373b.e(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        d().i(AbstractC0533m.a.ON_RESUME);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        d().i(AbstractC0533m.a.ON_DESTROY);
        this.f7372a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i5) {
        e();
        super.setContentView(i5);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        j4.k.g(view, "view");
        e();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        j4.k.g(view, "view");
        e();
        super.setContentView(view, layoutParams);
    }
}
