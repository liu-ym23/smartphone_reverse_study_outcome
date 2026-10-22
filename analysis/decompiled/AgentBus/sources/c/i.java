package c;

import android.app.PictureInPictureUiState;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.k0;
import androidx.lifecycle.l0;
import androidx.lifecycle.q;
import androidx.lifecycle.s0;
import androidx.lifecycle.t0;
import androidx.lifecycle.x;
import com.stepos.agentbus.R;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class i extends h2.a implements t0, androidx.lifecycle.k, i3.e, p, d3.c {

    /* renamed from: g, reason: collision with root package name */
    public final f.a f1685g;

    /* renamed from: h, reason: collision with root package name */
    public final a7.d f1686h;

    /* renamed from: i, reason: collision with root package name */
    public final q6.b f1687i;

    /* renamed from: j, reason: collision with root package name */
    public s0 f1688j;

    /* renamed from: k, reason: collision with root package name */
    public final g f1689k;

    /* renamed from: l, reason: collision with root package name */
    public final c7.o f1690l;

    /* renamed from: m, reason: collision with root package name */
    public final h f1691m;

    /* renamed from: n, reason: collision with root package name */
    public final CopyOnWriteArrayList f1692n;

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f1693o;

    /* renamed from: p, reason: collision with root package name */
    public final CopyOnWriteArrayList f1694p;

    /* renamed from: q, reason: collision with root package name */
    public final CopyOnWriteArrayList f1695q;

    /* renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList f1696r;

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f1697s;

    /* renamed from: t, reason: collision with root package name */
    public final CopyOnWriteArrayList f1698t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f1699u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1700v;

    /* renamed from: w, reason: collision with root package name */
    public final c7.o f1701w;

    /* renamed from: x, reason: collision with root package name */
    public final c7.o f1702x;

    public i() {
        i3.d dVar;
        f.a aVar = new f.a();
        this.f1685g = aVar;
        this.f1686h = new a7.d(28);
        k3.a aVar2 = new k3.a(this, new k0(this, 6));
        q6.b bVar = new q6.b(aVar2, 14);
        this.f1687i = bVar;
        this.f1689k = new g(this);
        this.f1690l = s7.a.H(new k0(this, 2));
        new AtomicInteger();
        this.f1691m = new h();
        this.f1692n = new CopyOnWriteArrayList();
        this.f1693o = new CopyOnWriteArrayList();
        this.f1694p = new CopyOnWriteArrayList();
        this.f1695q = new CopyOnWriteArrayList();
        this.f1696r = new CopyOnWriteArrayList();
        this.f1697s = new CopyOnWriteArrayList();
        this.f1698t = new CopyOnWriteArrayList();
        this.f1701w = s7.a.H(new k0(this, 3));
        x xVar = this.f4074f;
        if (xVar == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        xVar.a(new d(0, this));
        int i2 = 1;
        this.f4074f.a(new d(i2, this));
        this.f4074f.a(new i3.b(this, i2));
        aVar2.a();
        q qVar = this.f4074f.f1035c;
        if (qVar != q.f1021g && qVar != q.f1022h) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        k3.a aVar3 = (k3.a) ((q6.b) bVar.f8787g).f8788h;
        synchronized (aVar3.f5583c) {
            Iterator it = aVar3.f5584d.entrySet().iterator();
            do {
                dVar = null;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                i3.d dVar2 = (i3.d) entry.getValue();
                if (q7.k.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider")) {
                    dVar = dVar2;
                }
            } while (dVar == null);
        }
        if (dVar == null) {
            l0 l0Var = new l0((q6.b) bVar.f8787g, this);
            ((q6.b) bVar.f8787g).M0("androidx.lifecycle.internal.SavedStateHandlesProvider", l0Var);
            this.f4074f.a(new androidx.lifecycle.e(1, l0Var));
        }
        ((q6.b) bVar.f8787g).M0("android:support:activity-result", new a3.a(1, this));
        e eVar = new e(this);
        i iVar = aVar.f3325b;
        if (iVar != null) {
            eVar.a(iVar);
        }
        aVar.f3324a.add(eVar);
        s7.a.H(new k0(this, 4));
        this.f1702x = s7.a.H(new k0(this, 5));
    }

    public static void b(i iVar) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e10) {
            if (!q7.k.a(e10.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e10;
            }
        } catch (NullPointerException e11) {
            if (!q7.k.a(e11.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e11;
            }
        }
    }

    @Override // androidx.lifecycle.v
    public final x a() {
        return this.f4074f;
    }

    @Override // android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        View decorView = getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        this.f1689k.a(decorView);
        super.addContentView(view, layoutParams);
    }

    public final s0 c() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this.f1688j == null) {
            f fVar = (f) getLastNonConfigurationInstance();
            if (fVar != null) {
                this.f1688j = fVar.f1674a;
            }
            if (this.f1688j == null) {
                this.f1688j = new s0(0);
            }
        }
        s0 s0Var = this.f1688j;
        q7.k.b(s0Var);
        return s0Var;
    }

    public final void d() {
        View decorView = getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        q7.k.d(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        q7.k.d(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        q7.k.d(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        q7.k.d(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        q7.k.d(decorView6, "getDecorView(...)");
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // android.app.Activity
    public final void onActivityResult(int i2, int i10, Intent intent) {
        if (this.f1691m.a(i2, i10, intent)) {
            return;
        }
        super.onActivityResult(i2, i10, intent);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        ((d3.a) this.f1701w.getValue()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        q7.k.e(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator it = this.f1692n.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(configuration);
        }
    }

    @Override // h2.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        k3.a aVar = (k3.a) this.f1687i.f8788h;
        i iVar = aVar.f5581a;
        if (!aVar.f5585e) {
            aVar.a();
        }
        if (iVar.f4074f.f1035c.compareTo(q.f1023i) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + iVar.f4074f.f1035c).toString());
        }
        if (aVar.f5587g) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        Bundle bundleX = null;
        if (bundle != null && bundle.containsKey("androidx.lifecycle.BundlableSavedStateRegistry.key")) {
            bundleX = s7.a.x(bundle, "androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        aVar.f5586f = bundleX;
        aVar.f5587g = true;
        f.a aVar2 = this.f1685g;
        aVar2.getClass();
        aVar2.f3325b = this;
        Iterator it = aVar2.f3324a.iterator();
        while (it.hasNext()) {
            ((e) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i2 = f0.f993f;
        d0.b(this);
        getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i2, Menu menu) {
        q7.k.e(menu, "menu");
        if (i2 != 0) {
            return true;
        }
        super.onCreatePanelMenu(i2, menu);
        getMenuInflater();
        Iterator it = ((CopyOnWriteArrayList) this.f1686h.f411g).iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i2, MenuItem menuItem) {
        q7.k.e(menuItem, "item");
        if (super.onMenuItemSelected(i2, menuItem)) {
            return true;
        }
        if (i2 != 0) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) this.f1686h.f411g).iterator();
        if (!it.hasNext()) {
            return false;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z4) {
        if (this.f1699u) {
            return;
        }
        Iterator it = this.f1695q.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(new s9.d(24));
        }
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        q7.k.e(intent, "intent");
        super.onNewIntent(intent);
        Iterator it = this.f1694p.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onPanelClosed(int i2, Menu menu) {
        q7.k.e(menu, "menu");
        Iterator it = ((CopyOnWriteArrayList) this.f1686h.f411g).iterator();
        if (it.hasNext()) {
            it.next().getClass();
            throw new ClassCastException();
        }
        super.onPanelClosed(i2, menu);
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z4) {
        if (this.f1700v) {
            return;
        }
        Iterator it = this.f1696r.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(new s9.d(25));
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        s9.d dVar;
        q7.k.e(pictureInPictureUiState, "pipState");
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 35) {
            pictureInPictureUiState.isStashed();
            pictureInPictureUiState.isTransitioningToPip();
            dVar = new s9.d(26);
        } else if (i2 >= 31) {
            pictureInPictureUiState.isStashed();
            dVar = new s9.d(26);
        } else {
            dVar = new s9.d(26);
        }
        Iterator it = this.f1697s.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(dVar);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onPreparePanel(int i2, View view, Menu menu) {
        q7.k.e(menu, "menu");
        if (i2 != 0) {
            return true;
        }
        super.onPreparePanel(i2, view, menu);
        Iterator it = ((CopyOnWriteArrayList) this.f1686h.f411g).iterator();
        if (!it.hasNext()) {
            return true;
        }
        it.next().getClass();
        throw new ClassCastException();
    }

    @Override // android.app.Activity
    public final void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        q7.k.e(strArr, "permissions");
        q7.k.e(iArr, "grantResults");
        if (this.f1691m.a(i2, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        f fVar;
        s0 s0Var = this.f1688j;
        if (s0Var == null && (fVar = (f) getLastNonConfigurationInstance()) != null) {
            s0Var = fVar.f1674a;
        }
        if (s0Var == null) {
            return null;
        }
        f fVar2 = new f();
        fVar2.f1674a = s0Var;
        return fVar2;
    }

    @Override // h2.a, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        q7.k.e(bundle, "outState");
        x xVar = this.f4074f;
        if (xVar != null) {
            q7.k.c(xVar, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            q qVar = q.f1022h;
            xVar.c("setCurrentState");
            xVar.e(qVar);
        }
        super.onSaveInstanceState(bundle);
        q6.b bVar = this.f1687i;
        bVar.getClass();
        k3.a aVar = (k3.a) bVar.f8788h;
        Bundle bundleK = ib.k.k((c7.j[]) Arrays.copyOf(new c7.j[0], 0));
        Bundle bundle2 = aVar.f5586f;
        if (bundle2 != null) {
            bundleK.putAll(bundle2);
        }
        synchronized (aVar.f5583c) {
            for (Map.Entry entry : aVar.f5584d.entrySet()) {
                String str = (String) entry.getKey();
                Bundle bundleA = ((i3.d) entry.getValue()).a();
                q7.k.e(str, "key");
                bundleK.putBundle(str, bundleA);
            }
        }
        if (bundleK.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundleK);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public final void onTrimMemory(int i2) {
        super.onTrimMemory(i2);
        Iterator it = this.f1693o.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((n2.a) it.next()).accept(Integer.valueOf(i2));
        }
    }

    @Override // android.app.Activity
    public final void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator it = this.f1698t.iterator();
        q7.k.d(it, "iterator(...)");
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }

    @Override // android.app.Activity
    public final void reportFullyDrawn() {
        try {
            if (q3.a.a()) {
                nb.i.f("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            j jVar = (j) this.f1690l.getValue();
            synchronized (jVar.f1703a) {
                try {
                    jVar.f1704b = true;
                    Iterator it = jVar.f1705c.iterator();
                    while (it.hasNext()) {
                        ((p7.a) it.next()).c();
                    }
                    jVar.f1705c.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        } finally {
            Trace.endSection();
        }
    }

    @Override // android.app.Activity
    public final void setContentView(int i2) {
        d();
        View decorView = getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        this.f1689k.a(decorView);
        super.setContentView(i2);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i2) {
        q7.k.e(intent, "intent");
        super.startActivityForResult(intent, i2);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i10, int i11, int i12) throws IntentSender.SendIntentException {
        q7.k.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i2, intent, i10, i11, i12);
    }

    @Override // android.app.Activity
    public final void startActivityForResult(Intent intent, int i2, Bundle bundle) {
        q7.k.e(intent, "intent");
        super.startActivityForResult(intent, i2, bundle);
    }

    @Override // android.app.Activity
    public final void startIntentSenderForResult(IntentSender intentSender, int i2, Intent intent, int i10, int i11, int i12, Bundle bundle) throws IntentSender.SendIntentException {
        q7.k.e(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i2, intent, i10, i11, i12, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        d();
        View decorView = getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        this.f1689k.a(decorView);
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        q7.k.e(configuration, "newConfig");
        this.f1699u = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.f1699u = false;
            Iterator it = this.f1695q.iterator();
            q7.k.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((n2.a) it.next()).accept(new s9.d(24));
            }
        } catch (Throwable th) {
            this.f1699u = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        q7.k.e(configuration, "newConfig");
        this.f1700v = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.f1700v = false;
            Iterator it = this.f1696r.iterator();
            q7.k.d(it, "iterator(...)");
            while (it.hasNext()) {
                ((n2.a) it.next()).accept(new s9.d(25));
            }
        } catch (Throwable th) {
            this.f1700v = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        d();
        View decorView = getWindow().getDecorView();
        q7.k.d(decorView, "getDecorView(...)");
        this.f1689k.a(decorView);
        super.setContentView(view, layoutParams);
    }
}
