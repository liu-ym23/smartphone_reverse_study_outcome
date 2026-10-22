package androidx.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import com.stepos.agentsafetycenter.R;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q extends Dialog implements androidx.lifecycle.x, g0, t4.f {

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.z f693c;

    /* renamed from: f, reason: collision with root package name */
    public final t4.e f694f;

    /* renamed from: g, reason: collision with root package name */
    public final e0 f695g;

    public q(ContextThemeWrapper contextThemeWrapper, int i) {
        super(contextThemeWrapper, i);
        ab.e eVar = new ab.e(16);
        eVar.f393f = this;
        VarHandle.storeStoreFence();
        v4.b bVar = new v4.b();
        bVar.f14764a = this;
        bVar.f14765b = eVar;
        bVar.f14766c = new r2.i(22);
        bVar.f14767d = new LinkedHashMap();
        bVar.f14771h = true;
        VarHandle.storeStoreFence();
        t4.e eVar2 = new t4.e();
        eVar2.f13169a = bVar;
        t4.d dVar = new t4.d();
        dVar.f13167a = bVar;
        VarHandle.storeStoreFence();
        eVar2.f13170b = dVar;
        VarHandle.storeStoreFence();
        this.f694f = eVar2;
        a4.t tVar = new a4.t(6);
        tVar.f200f = this;
        VarHandle.storeStoreFence();
        this.f695g = new e0(tVar);
    }

    public static void a(q qVar) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        c();
        super.addContentView(view, layoutParams);
    }

    public final androidx.lifecycle.z b() {
        androidx.lifecycle.z zVar = this.f693c;
        if (zVar != null) {
            return zVar;
        }
        androidx.lifecycle.z zVar2 = new androidx.lifecycle.z(this, true);
        this.f693c = zVar2;
        return zVar2;
    }

    public final void c() {
        Window window = getWindow();
        window.getClass();
        View decorView = window.getDecorView();
        decorView.getClass();
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        window2.getClass();
        View decorView2 = window2.getDecorView();
        decorView2.getClass();
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        window3.getClass();
        View decorView3 = window3.getDecorView();
        decorView3.getClass();
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    @Override // androidx.lifecycle.x
    public final androidx.lifecycle.q getLifecycle() {
        return b();
    }

    @Override // androidx.activity.g0
    public final e0 getOnBackPressedDispatcher() {
        return this.f695g;
    }

    @Override // t4.f
    public final t4.d getSavedStateRegistry() {
        return this.f694f.f13170b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f695g.b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
        onBackInvokedDispatcher.getClass();
        e0 e0Var = this.f695g;
        e0Var.getClass();
        e0Var.f668e = onBackInvokedDispatcher;
        e0Var.c(e0Var.f670g);
        this.f694f.a(bundle);
        b().f(androidx.lifecycle.o.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        bundleOnSaveInstanceState.getClass();
        this.f694f.b(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        b().f(androidx.lifecycle.o.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        b().f(androidx.lifecycle.o.ON_DESTROY);
        this.f693c = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.getClass();
        c();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        c();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        view.getClass();
        c();
        super.setContentView(view, layoutParams);
    }
}
