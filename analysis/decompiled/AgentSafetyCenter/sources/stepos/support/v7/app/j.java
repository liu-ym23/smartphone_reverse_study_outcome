package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.FragmentManager;
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
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Objects;
import m.x2;
import stepos.support.v7.widget.Toolbar;
import stepos.support.v7.widget.v1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public abstract class j extends androidx.fragment.app.j implements k, d3.h {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private l mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // androidx.activity.p, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o oVar = (o) getDelegate();
        oVar.q();
        ((ViewGroup) oVar.D.findViewById(R.id.content)).addView(view, layoutParams);
        oVar.f12389g.onContentChanged();
    }

    @Override // d3.c, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int i) {
        o oVar = (o) getDelegate();
        oVar.q();
        return (T) oVar.f12388f.findViewById(i);
    }

    public l getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = l.b(this, getWindow(), this);
        }
        return this.mDelegate;
    }

    public h.a getDrawerToggleDelegate() {
        ((o) getDelegate()).getClass();
        return new r2.i(2);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        o oVar = (o) getDelegate();
        if (oVar.f12392k == null) {
            oVar.s();
            c cVar = oVar.f12391j;
            oVar.f12392k = new se.j(cVar != null ? cVar.d() : oVar.f12387c);
        }
        return oVar.f12392k;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i = x2.f8138a;
        }
        return resources == null ? super.getResources() : resources;
    }

    public c getSupportActionBar() {
        o oVar = (o) getDelegate();
        oVar.s();
        return oVar.f12391j;
    }

    @Override // d3.h
    public Intent getSupportParentActivityIntent() {
        return d3.a.b(this);
    }

    public void hideBackTopButton() {
        stepos.support.v7.widget.b0 b0Var = ((o) getDelegate()).f12402u;
        if (b0Var != null) {
            b0Var.r();
        }
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().e();
    }

    @Override // androidx.activity.p, android.app.Activity
    public void onBackPressed() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i;
        if (this.mStateSaved) {
            StringBuilder sb2 = new StringBuilder("onBackPressed after onSaveInstanceState: mStateSaved = ");
            androidx.fragment.app.u supportFragmentManager = getSupportFragmentManager();
            h5.t.p(supportFragmentManager, Objects.nonNull(supportFragmentManager));
            try {
                i = (supportFragmentManager != null ? h5.t.f5383d : h5.t.f5382c).getBoolean(supportFragmentManager) ? 1 : 0;
            } catch (Exception e10) {
                e10.printStackTrace();
                i = -1;
            }
            sb2.append(i);
            Log.d("AppCompatActivity", sb2.toString());
            androidx.fragment.app.u supportFragmentManager2 = getSupportFragmentManager();
            h5.t.p(supportFragmentManager2, Objects.nonNull(supportFragmentManager2));
            try {
                (supportFragmentManager2 != null ? h5.t.f5383d : h5.t.f5382c).setBoolean(supportFragmentManager2, false);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            h5.t.p(fragmentManager, false);
            try {
                h5.t.f5382c.setBoolean(fragmentManager, false);
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.k
    public boolean onBottomItemSelected(te.h hVar) {
        return false;
    }

    @Override // androidx.activity.p, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        o oVar = (o) getDelegate();
        if (oVar.f12393l && oVar.C) {
            oVar.s();
            c cVar = oVar.f12391j;
            if (cVar != null) {
                cVar.f();
            }
        }
        oVar.a();
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, d3.c, android.app.Activity
    public void onCreate(Bundle bundle) {
        l delegate = getDelegate();
        delegate.getClass();
        delegate.f(bundle);
        if (delegate.a() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.k
    public boolean onCreateBottomMenu(te.g gVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(d3.i iVar) {
        iVar.a(this);
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        o oVar = (o) getDelegate();
        oVar.f12400s = true;
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.g();
        }
    }

    @Override // androidx.fragment.app.j, androidx.activity.p, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        c supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.c() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // androidx.activity.p, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((o) getDelegate()).q();
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        o oVar = (o) getDelegate();
        oVar.s();
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.n(true);
        }
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // androidx.activity.p, d3.c, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        int i = ((o) getDelegate()).U;
        if (i != -100) {
            bundle.putInt("appcompat:local_night_mode", i);
        }
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.j, android.app.Activity
    public void onStop() {
        super.onStop();
        o oVar = (o) getDelegate();
        oVar.s();
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.n(false);
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
        d3.i iVar = new d3.i();
        iVar.f3187c = new ArrayList();
        iVar.f3188f = this;
        VarHandle.storeStoreFence();
        onCreateSupportNavigateUpTaskStack(iVar);
        onPrepareSupportNavigateUpTaskStack(iVar);
        iVar.b();
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        o oVar = (o) getDelegate();
        oVar.f12399r = charSequence;
        stepos.support.v7.widget.b0 b0Var = oVar.f12402u;
        if (b0Var != null) {
            b0Var.setWindowTitle(charSequence);
            return;
        }
        c cVar = oVar.f12391j;
        if (cVar != null) {
            cVar.q(charSequence);
            return;
        }
        TextView textView = oVar.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.k
    public se.b onWindowStartingSupportActionMode(se.a aVar) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        stepos.support.v7.widget.b0 b0Var = ((o) getDelegate()).f12402u;
        if (b0Var != null) {
            b0Var.setBackTopBackground(drawable);
        }
    }

    public void setBackTopEnable(boolean z10) {
        o oVar = (o) getDelegate();
        stepos.support.v7.widget.b0 b0Var = oVar.f12402u;
        if (b0Var != null) {
            b0Var.setBackTopEnable(z10);
            oVar.f12402u.setBackTopClickCallback(z10 ? oVar.T : null);
        }
    }

    @Override // androidx.activity.p, android.app.Activity
    public void setContentView(View view) {
        o oVar = (o) getDelegate();
        oVar.q();
        ViewGroup viewGroup = (ViewGroup) oVar.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        oVar.f12389g.onContentChanged();
    }

    public void setSupportActionBar(Toolbar toolbar) {
        o oVar = (o) getDelegate();
        Window window = oVar.f12388f;
        n nVar = oVar.f12390h;
        if (oVar.f12389g instanceof Activity) {
            oVar.s();
            c cVar = oVar.f12391j;
            if (cVar instanceof t0) {
                od.f.e("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                return;
            }
            oVar.f12392k = null;
            if (cVar != null) {
                cVar.g();
            }
            if (toolbar != null) {
                CharSequence title = ((Activity) oVar.f12387c).getTitle();
                q0 q0Var = new q0();
                q0Var.f12457f = new ArrayList();
                androidx.fragment.app.r rVar = new androidx.fragment.app.r(13);
                rVar.f1301f = q0Var;
                VarHandle.storeStoreFence();
                q0Var.f12459h = rVar;
                o0 o0Var = new o0();
                o0Var.f12408c = q0Var;
                VarHandle.storeStoreFence();
                v1 v1Var = new v1(toolbar, false);
                q0Var.f12452a = v1Var;
                r2.i iVar = new r2.i(7);
                VarHandle.storeStoreFence();
                v1Var.f12889t = iVar;
                p0 p0Var = new p0();
                p0Var.f12412f = q0Var;
                if (nVar == null) {
                    g5.f.s("Window callback may not be null");
                    return;
                }
                p0Var.f12411c = nVar;
                VarHandle.storeStoreFence();
                q0Var.f12454c = p0Var;
                v1Var.f12880k = p0Var;
                toolbar.setOnMenuItemClickListener(o0Var);
                v1Var.setWindowTitle(title);
                VarHandle.storeStoreFence();
                oVar.f12391j = q0Var;
                window.setCallback(p0Var);
            } else {
                oVar.f12391j = null;
                window.setCallback(nVar);
            }
            oVar.e();
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    public void setUiOptions(int i) {
        ((o) getDelegate()).f12401t = i;
    }

    public void showBackTopButton() {
        stepos.support.v7.widget.b0 b0Var = ((o) getDelegate()).f12402u;
        if (b0Var != null) {
            b0Var.o();
        }
    }

    public se.b startMultiChoiceActionMode(se.a aVar) {
        return getDelegate().i(aVar);
    }

    public se.b startSupportActionMode(se.a aVar) {
        return getDelegate().j(aVar);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        finishAfterTransition();
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().e();
    }

    public void supportNavigateUpTo(Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().g(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // androidx.activity.p, android.app.Activity
    public void setContentView(int i) {
        getDelegate().h(i);
    }

    @Override // androidx.activity.p, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        o oVar = (o) getDelegate();
        oVar.q();
        ViewGroup viewGroup = (ViewGroup) oVar.D.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        oVar.f12389g.onContentChanged();
    }

    @Override // stepos.support.v7.app.k
    public boolean onMenuItemSelected(int i, te.h hVar) {
        return false;
    }

    @Override // stepos.support.v7.app.k
    public void onOptionsMenuCreated(te.g gVar) {
    }

    public void onPrepareSupportNavigateUpTaskStack(d3.i iVar) {
    }

    @Override // stepos.support.v7.app.k
    public void onSupportActionModeFinished(se.b bVar) {
    }

    @Override // stepos.support.v7.app.k
    public void onSupportActionModeStarted(se.b bVar) {
    }

    @Deprecated
    public void setSupportProgress(int i) {
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

    @Override // stepos.support.v7.app.k
    public void onBackTopTouch() {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }
}
