package stepos.support.v7.app;

import android.R;
import android.app.Activity;
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
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.d1;
import androidx.core.app.p;
import androidx.fragment.app.FragmentManager;
import fe.b;
import java.util.Objects;
import stepos.support.v7.app.i;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class f extends androidx.fragment.app.o implements g, p.a {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private h mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // b.k, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ((ViewGroup) appCompatDelegateImplV7.z.findViewById(R.id.content)).addView(view, layoutParams);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    @Override // androidx.core.app.c, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i10) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        return (T) appCompatDelegateImplV7.f12126b.findViewById(i10);
    }

    public h getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new l(this, getWindow(), this);
        }
        return this.mDelegate;
    }

    public androidx.appcompat.app.b getDrawerToggleDelegate() {
        ((i) getDelegate()).getClass();
        return new i.a();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        i iVar = (i) getDelegate();
        if (iVar.f12131g == null) {
            iVar.l();
            a aVar = iVar.f12130f;
            iVar.f12131g = new fe.i(aVar != null ? aVar.d() : iVar.f12125a);
        }
        return iVar.f12131g;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i10 = d1.f791a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public a getSupportActionBar() {
        i iVar = (i) getDelegate();
        iVar.l();
        return iVar.f12130f;
    }

    @Override // androidx.core.app.p.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.e.a(this);
    }

    public void hideBackTopButton() {
        stepos.support.v7.widget.j jVar = ((AppCompatDelegateImplV7) getDelegate()).f11990q;
        if (jVar != null) {
            jVar.r();
        }
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().d();
    }

    @Override // b.k, android.app.Activity
    public void onBackPressed() {
        int i10;
        if (this.mStateSaved) {
            StringBuilder sb2 = new StringBuilder("onBackPressed after onSaveInstanceState: mStateSaved = ");
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            a4.a.h(supportFragmentManager, Objects.nonNull(supportFragmentManager));
            try {
                i10 = (supportFragmentManager != null ? a4.a.f39k : a4.a.f38j).getBoolean(supportFragmentManager) ? 1 : 0;
            } catch (Exception e10) {
                e10.printStackTrace();
                i10 = -1;
            }
            sb2.append(i10);
            Log.d("AppCompatActivity", sb2.toString());
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            a4.a.h(supportFragmentManager2, Objects.nonNull(supportFragmentManager2));
            try {
                (supportFragmentManager2 != null ? a4.a.f39k : a4.a.f38j).setBoolean(supportFragmentManager2, false);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            android.app.FragmentManager fragmentManager = getFragmentManager();
            a4.a.h(fragmentManager, false);
            try {
                a4.a.f38j.setBoolean(fragmentManager, false);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.g
    public boolean onBottomItemSelected(ge.g gVar) {
        return false;
    }

    @Override // b.k, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        if (appCompatDelegateImplV7.h && appCompatDelegateImplV7.f11997y) {
            appCompatDelegateImplV7.l();
            a aVar = appCompatDelegateImplV7.f12130f;
            if (aVar != null) {
                aVar.f();
            }
        }
        appCompatDelegateImplV7.c();
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.o, b.k, androidx.core.app.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        h delegate = getDelegate();
        delegate.getClass();
        delegate.e(bundle);
        if (delegate.c() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.g
    public boolean onCreateBottomMenu(ge.f fVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(androidx.core.app.p pVar) {
        pVar.a(this);
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.f12138o = true;
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.g();
        }
    }

    @Override // androidx.fragment.app.o, b.k, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i10, MenuItem menuItem) {
        if (super.onMenuItemSelected(i10, menuItem)) {
            return true;
        }
        a supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.c() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i10, Menu menu) {
        return super.onMenuOpened(i10, menu);
    }

    @Override // b.k, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i10, Menu menu) {
        super.onPanelClosed(i10, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((AppCompatDelegateImplV7) getDelegate()).s();
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.l();
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.n(true);
        }
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // b.k, androidx.core.app.c, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().f(bundle);
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.o, android.app.Activity
    public void onStop() {
        super.onStop();
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.l();
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.n(false);
        }
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
        androidx.core.app.p pVar = new androidx.core.app.p(this);
        onCreateSupportNavigateUpTaskStack(pVar);
        onPrepareSupportNavigateUpTaskStack(pVar);
        pVar.b();
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i10) {
        super.onTitleChanged(charSequence, i10);
        i iVar = (i) getDelegate();
        iVar.f12137n = charSequence;
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) iVar;
        stepos.support.v7.widget.j jVar = appCompatDelegateImplV7.f11990q;
        if (jVar != null) {
            jVar.setWindowTitle(charSequence);
            return;
        }
        a aVar = appCompatDelegateImplV7.f12130f;
        if (aVar != null) {
            aVar.q(charSequence);
            return;
        }
        TextView textView = appCompatDelegateImplV7.A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.g
    public fe.b onWindowStartingSupportActionMode(b.InterfaceC0082b interfaceC0082b) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        stepos.support.v7.widget.j jVar = ((AppCompatDelegateImplV7) getDelegate()).f11990q;
        if (jVar != null) {
            jVar.setBackTopBackground(drawable);
        }
    }

    public void setBackTopEnable(boolean z) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        stepos.support.v7.widget.j jVar = appCompatDelegateImplV7.f11990q;
        if (jVar != null) {
            jVar.setBackTopEnable(z);
            appCompatDelegateImplV7.f11990q.setBackTopClickCallback(z ? appCompatDelegateImplV7.P : null);
        }
    }

    @Override // b.k, android.app.Activity
    public void setContentView(int i10) {
        getDelegate().h(i10);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        Window window = appCompatDelegateImplV7.f12126b;
        Window.Callback callback = appCompatDelegateImplV7.f12128d;
        if (appCompatDelegateImplV7.f12127c instanceof Activity) {
            appCompatDelegateImplV7.l();
            a aVar = appCompatDelegateImplV7.f12130f;
            if (aVar instanceof o0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            appCompatDelegateImplV7.f12131g = null;
            if (aVar != null) {
                aVar.g();
            }
            if (toolbar != null) {
                n0 n0Var = new n0(toolbar, ((Activity) appCompatDelegateImplV7.f12125a).getTitle(), callback);
                appCompatDelegateImplV7.f12130f = n0Var;
                window.setCallback(n0Var.f12160c);
            } else {
                appCompatDelegateImplV7.f12130f = null;
                window.setCallback(callback);
            }
            appCompatDelegateImplV7.d();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        super.setTheme(i10);
        this.mThemeId = i10;
    }

    public void setUiOptions(int i10) {
        ((i) getDelegate()).f12139p = i10;
    }

    public void showBackTopButton() {
        stepos.support.v7.widget.j jVar = ((AppCompatDelegateImplV7) getDelegate()).f11990q;
        if (jVar != null) {
            jVar.o();
        }
    }

    public fe.b startMultiChoiceActionMode(b.InterfaceC0082b interfaceC0082b) {
        return getDelegate().i(interfaceC0082b);
    }

    public fe.b startSupportActionMode(b.InterfaceC0082b interfaceC0082b) {
        return getDelegate().j(interfaceC0082b);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    @Override // androidx.fragment.app.o
    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.o
    public void supportInvalidateOptionsMenu() {
        getDelegate().d();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i10) {
        return getDelegate().g(i10);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // b.k, android.app.Activity
    public void setContentView(View view) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ViewGroup viewGroup = (ViewGroup) appCompatDelegateImplV7.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    @Override // stepos.support.v7.app.g
    public boolean onMenuItemSelected(int i10, ge.g gVar) {
        return false;
    }

    @Override // b.k, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AppCompatDelegateImplV7 appCompatDelegateImplV7 = (AppCompatDelegateImplV7) getDelegate();
        appCompatDelegateImplV7.s();
        ViewGroup viewGroup = (ViewGroup) appCompatDelegateImplV7.z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        appCompatDelegateImplV7.f12127c.onContentChanged();
    }

    @Override // stepos.support.v7.app.g
    public void onBackTopTouch() {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    @Override // stepos.support.v7.app.g
    public void onOptionsMenuCreated(ge.f fVar) {
    }

    public void onPrepareSupportNavigateUpTaskStack(androidx.core.app.p pVar) {
    }

    @Override // stepos.support.v7.app.g
    public void onSupportActionModeFinished(fe.b bVar) {
    }

    @Override // stepos.support.v7.app.g
    public void onSupportActionModeStarted(fe.b bVar) {
    }

    @Deprecated
    public void setSupportProgress(int i10) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }
}
