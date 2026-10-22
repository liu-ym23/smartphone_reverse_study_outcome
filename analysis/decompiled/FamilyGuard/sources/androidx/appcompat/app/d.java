package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.u;
import androidx.appcompat.view.b;
import androidx.appcompat.widget.g0;
import androidx.core.app.t;
import androidx.fragment.app.ActivityC0516k;
import androidx.lifecycle.Y;
import androidx.lifecycle.Z;
import c.InterfaceC0570b;
import c0.C0574d;
import c0.C0577g;

/* loaded from: classes.dex */
public class d extends ActivityC0516k implements e, t.a {

    /* renamed from: a, reason: collision with root package name */
    private g f7521a;

    /* renamed from: b, reason: collision with root package name */
    private Resources f7522b;

    class a implements C0574d.c {
        a() {
        }

        @Override // c0.C0574d.c
        public Bundle a() {
            Bundle bundle = new Bundle();
            d.this.t().z(bundle);
            return bundle;
        }
    }

    class b implements InterfaceC0570b {
        b() {
        }

        @Override // c.InterfaceC0570b
        public void a(Context context) {
            g gVarT = d.this.t();
            gVarT.r();
            gVarT.v(d.this.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public d() {
        v();
    }

    private void v() {
        getSavedStateRegistry().h("androidx:appcompat", new a());
        addOnContextAvailableListener(new b());
    }

    private void w() {
        Y.a(getWindow().getDecorView(), this);
        Z.a(getWindow().getDecorView(), this);
        C0577g.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
    }

    private boolean z(KeyEvent keyEvent) {
        return false;
    }

    @Override // androidx.appcompat.app.e
    public void a(androidx.appcompat.view.b bVar) {
    }

    @Override // androidx.activity.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        t().e(view, layoutParams);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(t().g(context));
    }

    @Override // androidx.appcompat.app.e
    public void b(androidx.appcompat.view.b bVar) {
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        androidx.appcompat.app.a aVarU = u();
        if (getWindow().hasFeature(0)) {
            if (aVarU == null || !aVarU.f()) {
                super.closeOptionsMenu();
            }
        }
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        androidx.appcompat.app.a aVarU = u();
        if (keyCode == 82 && aVarU != null && aVarU.o(keyEvent)) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.appcompat.app.e
    public androidx.appcompat.view.b f(b.a aVar) {
        return null;
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i5) {
        return (T) t().j(i5);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return t().p();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f7522b == null && g0.c()) {
            this.f7522b = new g0(this, super.getResources());
        }
        Resources resources = this.f7522b;
        return resources == null ? super.getResources() : resources;
    }

    @Override // androidx.core.app.t.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.h.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        t().s();
    }

    @Override // androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        t().u(configuration);
        if (this.f7522b != null) {
            this.f7522b.updateConfiguration(super.getResources().getConfiguration(), super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public void onCreateSupportNavigateUpTaskStack(t tVar) {
        tVar.c(this);
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        t().w();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        if (z(keyEvent)) {
            return true;
        }
        return super.onKeyDown(i5, keyEvent);
    }

    @Override // androidx.fragment.app.ActivityC0516k, androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        androidx.appcompat.app.a aVarU = u();
        if (menuItem.getItemId() != 16908332 || aVarU == null || (aVarU.i() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i5, Menu menu) {
        return super.onMenuOpened(i5, menu);
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        t().x(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        t().y();
    }

    public void onPrepareSupportNavigateUpTaskStack(t tVar) {
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        t().A();
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStop() {
        super.onStop();
        t().B();
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (!supportShouldUpRecreateTask(supportParentActivityIntent)) {
            supportNavigateUpTo(supportParentActivityIntent);
            return true;
        }
        t tVarH = t.h(this);
        onCreateSupportNavigateUpTaskStack(tVarH);
        onPrepareSupportNavigateUpTaskStack(tVarH);
        tVarH.i();
        try {
            androidx.core.app.a.m(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    protected void onTitleChanged(CharSequence charSequence, int i5) {
        super.onTitleChanged(charSequence, i5);
        t().K(charSequence);
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        androidx.appcompat.app.a aVarU = u();
        if (getWindow().hasFeature(0)) {
            if (aVarU == null || !aVarU.p()) {
                super.openOptionsMenu();
            }
        }
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(int i5) {
        w();
        t().F(i5);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        super.setTheme(i5);
        t().J(i5);
    }

    @Override // androidx.fragment.app.ActivityC0516k
    public void supportInvalidateOptionsMenu() {
        t().s();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.h.e(this, intent);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.h.f(this, intent);
    }

    public g t() {
        if (this.f7521a == null) {
            this.f7521a = g.h(this, this);
        }
        return this.f7521a;
    }

    public androidx.appcompat.app.a u() {
        return t().q();
    }

    protected void x(androidx.core.os.d dVar) {
    }

    protected void y(int i5) {
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view) {
        w();
        t().G(view);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        t().H(view, layoutParams);
    }
}
