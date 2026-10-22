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
import androidx.annotation.CallSuper;
import androidx.annotation.IdRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import java.util.Objects;
import stepos.support.v7.widget.Toolbar;

/* renamed from: stepos.support.v7.app.k, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractActivityC1962k extends FragmentActivity implements InterfaceC1963l, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private AbstractC1964m mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // android.view.ComponentActivity, android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ((ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content)).addView(view, layoutParams);
        abstractC1975y.c.onContentChanged();
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @Nullable
    public <T extends View> T findViewById(@IdRes int i) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        return (T) abstractC1975y.b.findViewById(i);
    }

    @NonNull
    public AbstractC1964m getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new C1968q(this, getWindow(), this);
        }
        return this.mDelegate;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    @Nullable
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        abstractC1966o.getClass();
        return new C1965n(abstractC1966o);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        if (abstractC1966o.g == null) {
            abstractC1966o.m();
            AbstractC1955d abstractC1955d = abstractC1966o.f;
            abstractC1966o.g = new Ua.k(abstractC1955d != null ? abstractC1955d.d() : abstractC1966o.f6316a);
        }
        return abstractC1966o.g;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null && VectorEnabledTintResources.shouldBeUsed()) {
            this.mResources = new VectorEnabledTintResources(this, super.getResources());
        }
        Resources resources = this.mResources;
        return resources == null ? super.getResources() : resources;
    }

    @Nullable
    public AbstractC1955d getSupportActionBar() {
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        abstractC1966o.m();
        return abstractC1966o.f;
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    @Nullable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    public void hideBackTopButton() {
        stepos.support.v7.widget.H h = ((AbstractC1975y) getDelegate()).f6362q;
        if (h != null) {
            h.d();
        }
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().b();
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void onBackPressed() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int i;
        if (this.mStateSaved) {
            StringBuilder sb = new StringBuilder("onBackPressed after onSaveInstanceState: mStateSaved = ");
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Z6.k.m(supportFragmentManager, Objects.nonNull(supportFragmentManager));
            try {
                i = (supportFragmentManager != null ? Z6.k.e : Z6.k.d).getBoolean(supportFragmentManager) ? 1 : 0;
            } catch (Exception e) {
                e.printStackTrace();
                i = -1;
            }
            sb.append(i);
            Log.d("AppCompatActivity", sb.toString());
            FragmentManager supportFragmentManager2 = getSupportFragmentManager();
            Z6.k.m(supportFragmentManager2, Objects.nonNull(supportFragmentManager2));
            try {
                (supportFragmentManager2 != null ? Z6.k.e : Z6.k.d).setBoolean(supportFragmentManager2, false);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            android.app.FragmentManager fragmentManager = getFragmentManager();
            Z6.k.m(fragmentManager, false);
            try {
                Z6.k.d.setBoolean(fragmentManager, false);
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onBottomItemSelected(Va.i iVar) {
        return false;
    }

    @Override // android.view.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        if (abstractC1975y.h && abstractC1975y.y) {
            abstractC1975y.m();
            AbstractC1955d abstractC1955d = abstractC1975y.f;
            if (abstractC1955d != null) {
                abstractC1955d.f();
            }
        }
        abstractC1975y.a();
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC1964m delegate = getDelegate();
        delegate.getClass();
        delegate.c(bundle);
        if (delegate.a() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onCreateBottomMenu(Va.h hVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder taskStackBuilder) {
        taskStackBuilder.addParentStack(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.o = true;
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.g();
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.view.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        AbstractC1955d supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.c() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public void onOptionsMenuCreated(Va.h hVar) {
    }

    @Override // android.view.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        ((AbstractC1975y) getDelegate()).u();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.m();
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.p(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder taskStackBuilder) {
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // android.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().d(bundle);
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.m();
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.p(false);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    @CallSuper
    public void onSupportActionModeFinished(@NonNull Ua.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    @CallSuper
    public void onSupportActionModeStarted(@NonNull Ua.c cVar) {
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
        TaskStackBuilder taskStackBuilderCreate = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(taskStackBuilderCreate);
        onPrepareSupportNavigateUpTaskStack(taskStackBuilderCreate);
        taskStackBuilderCreate.startActivities();
        try {
            ActivityCompat.finishAffinity(this);
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        AbstractC1966o abstractC1966o = (AbstractC1966o) getDelegate();
        abstractC1966o.n = charSequence;
        AbstractC1975y abstractC1975y = (AbstractC1975y) abstractC1966o;
        stepos.support.v7.widget.H h = abstractC1975y.f6362q;
        if (h != null) {
            h.setWindowTitle(charSequence);
            return;
        }
        AbstractC1955d abstractC1955d = abstractC1975y.f;
        if (abstractC1955d != null) {
            abstractC1955d.s(charSequence);
            return;
        }
        TextView textView = abstractC1975y.f6346A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    @Nullable
    public Ua.c onWindowStartingSupportActionMode(@NonNull Ua.b bVar) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        stepos.support.v7.widget.H h = ((AbstractC1975y) getDelegate()).f6362q;
        if (h != null) {
            h.setBackTopBackground(drawable);
        }
    }

    public void setBackTopEnable(boolean z10) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        stepos.support.v7.widget.H h = abstractC1975y.f6362q;
        if (h != null) {
            h.setBackTopEnable(z10);
            abstractC1975y.f6362q.setBackTopClickCallback(z10 ? abstractC1975y.f6361U : null);
        }
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(@LayoutRes int i) {
        getDelegate().g(i);
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        Window window = abstractC1975y.b;
        Window.Callback callback = abstractC1975y.d;
        if (abstractC1975y.c instanceof Activity) {
            abstractC1975y.m();
            AbstractC1955d abstractC1955d = abstractC1975y.f;
            if (abstractC1955d instanceof e0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            abstractC1975y.g = null;
            if (abstractC1955d != null) {
                abstractC1955d.g();
            }
            if (toolbar != null) {
                b0 b0Var = new b0(toolbar, ((Activity) abstractC1975y.f6316a).getTitle(), callback);
                abstractC1975y.f = b0Var;
                window.setCallback(b0Var.c);
            } else {
                abstractC1975y.f = null;
                window.setCallback(callback);
            }
            abstractC1975y.b();
        }
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

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@StyleRes int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    public void setUiOptions(int i) {
        ((AbstractC1966o) getDelegate()).p = i;
    }

    public void showBackTopButton() {
        stepos.support.v7.widget.H h = ((AbstractC1975y) getDelegate()).f6362q;
        if (h != null) {
            h.b();
        }
    }

    public Ua.c startMultiChoiceActionMode(Ua.b bVar) {
        return getDelegate().h(bVar);
    }

    @Nullable
    public Ua.c startSupportActionMode(@NonNull Ua.b bVar) {
        return getDelegate().i(bVar);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        super.supportFinishAfterTransition();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().b();
    }

    public void supportNavigateUpTo(@NonNull Intent intent) {
        NavUtils.navigateUpTo(this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().f(i);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent intent) {
        return NavUtils.shouldUpRecreateTask(this, intent);
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(View view) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ViewGroup viewGroup = (ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        abstractC1975y.c.onContentChanged();
    }

    @Override // stepos.support.v7.app.InterfaceC1963l
    public boolean onMenuItemSelected(int i, Va.i iVar) {
        return false;
    }

    @Override // android.view.ComponentActivity, android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC1975y abstractC1975y = (AbstractC1975y) getDelegate();
        abstractC1975y.u();
        ViewGroup viewGroup = (ViewGroup) abstractC1975y.f6369z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        abstractC1975y.c.onContentChanged();
    }
}
