package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.contextaware.OnContextAvailableListener;
import androidx.activity.r;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.h0;
import androidx.core.app.ActivityCompat;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.o0;
import androidx.lifecycle.p0;
import androidx.savedstate.SavedStateRegistry;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle$DelegateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AppCompatDelegate f282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources f283b;

    public class a implements SavedStateRegistry.SavedStateProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f284a;

        public a(AppCompatActivity r10) {
            this.f284a = r10;
        }

        @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
        public Bundle saveState() {
            Bundle r10 = new Bundle();
            this.f284a.s().A(r10);
            return r10;
        }
    }

    public class b implements OnContextAvailableListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppCompatActivity f285a;

        public b(AppCompatActivity r10) {
            this.f285a = r10;
        }

        @Override // androidx.activity.contextaware.OnContextAvailableListener
        public void onContextAvailable(Context r10) {
            AppCompatDelegate r11 = this.f285a.s();
            r11.r();
            r11.w(this.f285a.getSavedStateRegistry().b("androidx:appcompat"));
        }
    }

    public AppCompatActivity() {
        u();
    }

    public void A() {
    }

    public boolean B() {
        Intent r10 = getSupportParentActivityIntent();
        if (r10 != null) goto L5;
        return false;
    L5:
        if (E(r10) == false) goto L10;
        TaskStackBuilder r11 = TaskStackBuilder.e(this);
        w(r11);
        z(r11);
        r11.f();
        ActivityCompat.m(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        D(r10);
        return true;
    }

    public final boolean C(KeyEvent r10) {
        return false;
    }

    public void D(Intent r10) {
        androidx.core.app.f.e(this, r10);
    }

    public boolean E(Intent r10) {
        return androidx.core.app.f.f(this, r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r10, ViewGroup.LayoutParams r11) {
        v();
        s().c(r10, r11);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r10) {
        super.attachBaseContext(s().e(r10));
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar r10 = t();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r10 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r10.a() == false) goto L7;
        return;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r10) {
        int r11 = r10.getKeyCode();
        ActionBar r12 = t();
        if (r11 != 82) goto L10;
        if (r12 == null) goto L10;
        if (r12.j(r10) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r10);
    }

    @Override // android.app.Activity
    public View findViewById(int r10) {
        return s().h(r10);
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle$DelegateProvider
    public ActionBarDrawerToggle$Delegate getDrawerToggleDelegate() {
        return s().l();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return s().o();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.f283b == null) goto L5;
    L7:
        Resources r10 = this.f283b;
        if (r10 == null) goto L10;
        return r10;
    L10:
        return super.getResources();
    L5:
        if (h0.c() == false) goto L7;
        this.f283b = new h0(this, super.getResources());
        goto L7
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.f.a(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        s().s();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r10) {
        super.onConfigurationChanged(r10);
        s().v(r10);
        if (this.f283b == null) goto L6;
        Configuration r11 = super.getResources().getConfiguration();
        DisplayMetrics r12 = super.getResources().getDisplayMetrics();
        this.f283b.updateConfiguration(r11, r12);
        return;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        A();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        s().x();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r10, KeyEvent r11) {
        if (C(r11) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r10, r11);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r10, MenuItem r11) {
        if (super.onMenuItemSelected(r10, r11) == false) goto L6;
        return true;
    L6:
        ActionBar r12 = t();
        if (r11.getItemId() != 16908332) goto L13;
        if (r12 != null) goto L10;
        return false;
    L10:
        if ((r12.d() & 4) != 0) goto L12;
        return false;
    L12:
        return B();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r10, Menu r11) {
        return super.onMenuOpened(r10, r11);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r10, Menu r11) {
        super.onPanelClosed(r10, r11);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r10) {
        super.onPostCreate(r10);
        s().y(r10);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        s().z();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        s().B();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        s().C();
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r10) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r10) {
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r10, int r11) {
        super.onTitleChanged(r10, r11);
        s().M(r10);
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r10) {
        return null;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar r10 = t();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r10 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r10.k() == false) goto L7;
        return;
    }

    public AppCompatDelegate s() {
        if (this.f282a != null) goto L6;
        this.f282a = AppCompatDelegate.f(this, this);
    L6:
        return this.f282a;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r10) {
        v();
        s().G(r10);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r10) {
        super.setTheme(r10);
        s().L(r10);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        s().s();
    }

    public ActionBar t() {
        return s().q();
    }

    public final void u() {
        getSavedStateRegistry().h("androidx:appcompat", new a(this));
        addOnContextAvailableListener(new b(this));
    }

    public final void v() {
        o0.a(getWindow().getDecorView(), this);
        p0.a(getWindow().getDecorView(), this);
        androidx.savedstate.c.a(getWindow().getDecorView(), this);
        r.a(getWindow().getDecorView(), this);
    }

    public void w(TaskStackBuilder r10) {
        r10.c(this);
    }

    public void x(androidx.core.os.e r10) {
    }

    public void y(int r10) {
    }

    public void z(TaskStackBuilder r10) {
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r10) {
        v();
        s().H(r10);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r10, ViewGroup.LayoutParams r11) {
        v();
        s().I(r10, r11);
    }
}
