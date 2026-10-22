package stepos.support.v7.app;

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
import androidx.appcompat.widget.g0;
import androidx.core.app.t;
import androidx.fragment.app.ActivityC0516k;
import b5.b;
import stepos.support.v7.widget.Toolbar;

/* loaded from: classes.dex */
public class d extends ActivityC0516k implements e, t.a {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private f mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // androidx.activity.h, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().a(view, layoutParams);
    }

    @Override // androidx.core.app.f, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i5) {
        return (T) getDelegate().h(i5);
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
        if (this.mResources == null && g0.c()) {
            this.mResources = new g0(this, super.getResources());
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

    @Override // androidx.activity.h, android.app.Activity
    public void onBackPressed() {
        if (this.mStateSaved) {
            Log.d("AppCompatActivity", "onBackPressed after onSaveInstanceState: mStateSaved = " + a5.f.b(getSupportFragmentManager()));
            a5.f.c(getSupportFragmentManager(), false);
            a5.f.c(getFragmentManager(), false);
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.e
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.e
    public boolean onBottomItemSelected(c5.f fVar) {
        return false;
    }

    @Override // androidx.activity.h, android.app.Activity, android.content.ComponentCallbacks
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

    @Override // androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        f delegate = getDelegate();
        delegate.n();
        delegate.q(bundle);
        if (delegate.b() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.e
    public boolean onCreateBottomMenu(c5.e eVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.t tVar) {
        tVar.c(this);
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        getDelegate().r();
    }

    @Override // androidx.fragment.app.ActivityC0516k, androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.m() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i5, Menu menu) {
        return super.onMenuOpened(i5, menu);
    }

    @Override // stepos.support.v7.app.e
    public void onOptionsMenuCreated(c5.e eVar) {
    }

    @Override // androidx.activity.h, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().s(bundle);
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onPostResume() {
        super.onPostResume();
        getDelegate().t();
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.t tVar) {
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().u(bundle);
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStop() {
        super.onStop();
        getDelegate().v();
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeFinished(b5.b bVar) {
    }

    @Override // stepos.support.v7.app.e
    public void onSupportActionModeStarted(b5.b bVar) {
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
        androidx.core.app.t tVarH = androidx.core.app.t.h(this);
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
        getDelegate().D(charSequence);
    }

    @Override // stepos.support.v7.app.e
    public b5.b onWindowStartingSupportActionMode(b.InterfaceC0154b interfaceC0154b) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        getDelegate().x(drawable);
    }

    public void setBackTopEnable(boolean z5) {
        getDelegate().y(z5);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(int i5) {
        getDelegate().z(i5);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().C(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z5) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z5) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z5) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        super.setTheme(i5);
        this.mThemeId = i5;
    }

    public void setUiOptions(int i5) {
        getDelegate().E(i5);
    }

    public void showBackTopButton() {
        getDelegate().F();
    }

    public b5.b startMultiChoiceActionMode(b.InterfaceC0154b interfaceC0154b) {
        return getDelegate().G(interfaceC0154b);
    }

    public b5.b startSupportActionMode(b.InterfaceC0154b interfaceC0154b) {
        return getDelegate().H(interfaceC0154b);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    @Override // androidx.fragment.app.ActivityC0516k
    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.ActivityC0516k
    public void supportInvalidateOptionsMenu() {
        getDelegate().o();
    }

    public void supportNavigateUpTo(Intent intent) {
        androidx.core.app.h.e(this, intent);
    }

    public boolean supportRequestWindowFeature(int i5) {
        return getDelegate().w(i5);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return androidx.core.app.h.f(this, intent);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view) {
        getDelegate().A(view);
    }

    @Override // androidx.activity.h, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        getDelegate().B(view, layoutParams);
    }

    @Override // stepos.support.v7.app.e
    public boolean onMenuItemSelected(int i5, c5.f fVar) {
        return false;
    }
}
