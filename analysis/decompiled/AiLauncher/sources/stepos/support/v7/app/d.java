package stepos.support.v7.app;

import Ic.b;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.a0;
import androidx.core.app.t;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes5.dex */
public class d extends androidx.fragment.app.r implements e, t.a {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private f mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // b.q, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().c(view, layoutParams);
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        return (T) getDelegate().h(i10);
    }

    public f getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = f.e(this, this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        return getDelegate().j();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().k();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && a0.d()) {
            this.mResources = new a0(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    public a getSupportActionBar() {
        return getDelegate().l();
    }

    @Override // androidx.core.app.t.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.h.a(this);
    }

    public void hideBackTopButton() {
        getDelegate().m();
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().o();
    }

    @Override // b.q, android.app.Activity
    public void onBackPressed() {
        if (this.mStateSaved) {
            Log.d("AppCompatActivity", "onBackPressed after onSaveInstanceState: mStateSaved = " + Hc.e.b(getSupportFragmentManager()));
            Hc.e.c(getSupportFragmentManager(), false);
            Hc.e.c(getFragmentManager(), false);
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.e
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.e
    public boolean onBottomItemSelected(Jc.g gVar) {
        return false;
    }

    @Override // b.q, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().p(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.r, b.q, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        f delegate = getDelegate();
        delegate.n();
        delegate.q(bundle);
        if (delegate.d() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.e
    public boolean onCreateBottomMenu(Jc.f fVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.t tVar) {
        tVar.c(this);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().r();
    }

    @Override // androidx.fragment.app.r, b.q, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.h() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // stepos.support.v7.app.e
    public void onOptionsMenuCreated(Jc.f fVar) {
    }

    @Override // b.q, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().s(bundle);
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().t();
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.t tVar) {
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // b.q, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().u(bundle);
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.r, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().v();
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeFinished(Ic.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeStarted(Ic.b bVar) {
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
        androidx.core.app.t tVarF = androidx.core.app.t.f(this);
        onCreateSupportNavigateUpTaskStack(tVarF);
        onPrepareSupportNavigateUpTaskStack(tVarF);
        tVarF.i();
        try {
            androidx.core.app.a.n(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        getDelegate().D(charSequence);
    }

    @Override // stepos.support.v7.app.e
    public Ic.b onWindowStartingSupportActionMode(b.InterfaceC0060b interfaceC0060b) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        getDelegate().x(drawable);
    }

    public void setBackTopEnable(boolean z10) {
        getDelegate().y(z10);
    }

    @Override // b.q, android.app.Activity
    public void setContentView(int i10) {
        getDelegate().z(i10);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().C(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z10) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z10) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        this.mThemeId = i10;
    }

    public void setUiOptions(int i10) {
        getDelegate().E(i10);
    }

    public void showBackTopButton() {
        getDelegate().F();
    }

    public Ic.b startMultiChoiceActionMode(b.InterfaceC0060b interfaceC0060b) {
        return getDelegate().G(interfaceC0060b);
    }

    public Ic.b startSupportActionMode(b.InterfaceC0060b interfaceC0060b) {
        return getDelegate().H(interfaceC0060b);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    @Override // androidx.fragment.app.r
    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.r
    public void supportInvalidateOptionsMenu() {
        getDelegate().o();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.h.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().w(i10);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.h.f(this, intent);
    }

    @Override // b.q, android.app.Activity
    public void setContentView(View view) {
        getDelegate().A(view);
    }

    @Override // b.q, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().B(view, layoutParams);
    }

    @Override // stepos.support.v7.app.e
    public boolean onMenuItemSelected(int i10, Jc.g gVar) {
        return false;
    }
}
