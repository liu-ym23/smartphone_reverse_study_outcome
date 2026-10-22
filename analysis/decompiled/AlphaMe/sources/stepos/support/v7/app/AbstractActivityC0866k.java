package stepos.support.v7.app;

import android.R;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
import androidx.appcompat.app.InterfaceC0176b;
import androidx.appcompat.widget.i1;
import androidx.core.app.AbstractC0240a;
import f1.AbstractC0557a;
import java.util.ArrayList;
import stepos.support.v7.widget.Toolbar;

/* renamed from: stepos.support.v7.app.k, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractActivityC0866k extends androidx.fragment.app.G implements InterfaceC0867l, androidx.core.app.D {
    public static final int UIOPTION_BOTTOM_BAR_MENU = 2;
    public static final int UIOPTION_NAVIGATION_BAR = 2;
    private AbstractC0868m mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private boolean mStateSaved;
    private int mThemeId = 0;

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ((ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content)).addView(view, layoutParams);
        abstractC0880z.f14511c.onContentChanged();
    }

    @Override // androidx.core.app.k, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    @Nullable
    public <T extends View> T findViewById(@IdRes int i4) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        return (T) abstractC0880z.f14510b.findViewById(i4);
    }

    @NonNull
    public AbstractC0868m getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = new C0875u(this, getWindow(), this);
        }
        return this.mDelegate;
    }

    @Nullable
    public InterfaceC0176b getDrawerToggleDelegate() {
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        abstractC0870o.getClass();
        return new com.google.android.gms.common.api.internal.p(abstractC0870o);
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        if (abstractC0870o.f14515g == null) {
            abstractC0870o.l();
            AbstractC0860e abstractC0860e = abstractC0870o.f14514f;
            abstractC0870o.f14515g = new K3.k(abstractC0860e != null ? abstractC0860e.d() : abstractC0870o.f14509a);
        }
        return abstractC0870o.f14515g;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            int i4 = i1.f3104a;
        }
        return resources == null ? super.getResources() : resources;
    }

    @Nullable
    public AbstractC0860e getSupportActionBar() {
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        abstractC0870o.l();
        return abstractC0870o.f14514f;
    }

    @Override // androidx.core.app.D
    @Nullable
    public Intent getSupportParentActivityIntent() {
        return B0.f.G(this);
    }

    public void hideBackTopButton() {
        stepos.support.v7.widget.C c4 = ((AbstractC0880z) getDelegate()).f14628q;
        if (c4 != null) {
            c4.o();
        }
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().d();
    }

    @Override // androidx.activity.o, android.app.Activity
    public void onBackPressed() {
        int i4;
        if (this.mStateSaved) {
            StringBuilder sb = new StringBuilder("onBackPressed after onSaveInstanceState: mStateSaved = ");
            androidx.fragment.app.Y supportFragmentManager = getSupportFragmentManager();
            boolean z4 = supportFragmentManager instanceof androidx.fragment.app.Y;
            AbstractC0557a.k(supportFragmentManager, z4);
            try {
                i4 = (z4 ? AbstractC0557a.f12524h : AbstractC0557a.f12523g).getBoolean(supportFragmentManager) ? 1 : 0;
            } catch (Exception e4) {
                e4.printStackTrace();
                i4 = -1;
            }
            sb.append(i4);
            Log.d("AppCompatActivity", sb.toString());
            androidx.fragment.app.Y supportFragmentManager2 = getSupportFragmentManager();
            boolean z5 = supportFragmentManager2 instanceof androidx.fragment.app.Y;
            AbstractC0557a.k(supportFragmentManager2, z5);
            try {
                (z5 ? AbstractC0557a.f12524h : AbstractC0557a.f12523g).setBoolean(supportFragmentManager2, false);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
            FragmentManager fragmentManager = getFragmentManager();
            boolean z6 = fragmentManager instanceof androidx.fragment.app.Y;
            AbstractC0557a.k(fragmentManager, z6);
            try {
                (z6 ? AbstractC0557a.f12524h : AbstractC0557a.f12523g).setBoolean(fragmentManager, false);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        super.onBackPressed();
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onBackTopTouch() {
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onBottomItemSelected(L3.g gVar) {
        return false;
    }

    @Override // androidx.activity.o, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        if (abstractC0880z.f14516h && abstractC0880z.f14636y) {
            abstractC0880z.l();
            AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
            if (abstractC0860e != null) {
                abstractC0860e.g();
            }
        }
        abstractC0880z.a();
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    @Override // androidx.fragment.app.G, androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onCreate(Bundle bundle) {
        AbstractC0868m delegate = getDelegate();
        delegate.getClass();
        delegate.e(bundle);
        if (delegate.a() && this.mThemeId != 0) {
            onApplyThemeResource(getTheme(), this.mThemeId, false);
        }
        super.onCreate(bundle);
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onCreateBottomMenu(L3.f fVar) {
        return false;
    }

    public void onCreateSupportNavigateUpTaskStack(@NonNull androidx.core.app.E e4) {
        e4.getClass();
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            supportParentActivityIntent = B0.f.G(this);
        }
        if (supportParentActivityIntent != null) {
            ComponentName component = supportParentActivityIntent.getComponent();
            Context context = e4.f3274b;
            if (component == null) {
                component = supportParentActivityIntent.resolveActivity(context.getPackageManager());
            }
            ArrayList arrayList = e4.f3273a;
            int size = arrayList.size();
            try {
                for (Intent intentH = B0.f.H(context, component); intentH != null; intentH = B0.f.H(context, intentH.getComponent())) {
                    arrayList.add(size, intentH);
                }
                arrayList.add(supportParentActivityIntent);
            } catch (PackageManager.NameNotFoundException e5) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e5);
            }
        }
    }

    @Override // androidx.fragment.app.G, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.f14523o = true;
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.h();
        }
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public boolean onMenuItemSelected(int i4, L3.g gVar) {
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int i4, Menu menu) {
        return super.onMenuOpened(i4, menu);
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    public void onOptionsMenuCreated(L3.f fVar) {
    }

    @Override // androidx.activity.o, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i4, Menu menu) {
        super.onPanelClosed(i4, menu);
    }

    @Override // android.app.Activity
    public void onPostCreate(@Nullable Bundle bundle) {
        super.onPostCreate(bundle);
        ((AbstractC0880z) getDelegate()).t();
    }

    @Override // androidx.fragment.app.G, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.l();
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.p(true);
        }
    }

    public void onPrepareSupportNavigateUpTaskStack(@NonNull androidx.core.app.E e4) {
    }

    @Override // androidx.fragment.app.G, android.app.Activity
    public void onResume() {
        super.onResume();
        this.mStateSaved = false;
    }

    @Override // androidx.activity.o, androidx.core.app.k, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().f(bundle);
        this.mStateSaved = true;
    }

    @Override // androidx.fragment.app.G, android.app.Activity
    public void onStop() {
        super.onStop();
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.l();
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.p(false);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    @CallSuper
    public void onSupportActionModeFinished(@NonNull K3.c cVar) {
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    @CallSuper
    public void onSupportActionModeStarted(@NonNull K3.c cVar) {
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
        androidx.core.app.E e4 = new androidx.core.app.E(this);
        onCreateSupportNavigateUpTaskStack(e4);
        onPrepareSupportNavigateUpTaskStack(e4);
        ArrayList arrayList = e4.f3273a;
        if (arrayList.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        e4.f3274b.startActivities(intentArr, null);
        try {
            finishAffinity();
            return true;
        } catch (IllegalStateException unused) {
            finish();
            return true;
        }
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence charSequence, int i4) {
        super.onTitleChanged(charSequence, i4);
        AbstractC0870o abstractC0870o = (AbstractC0870o) getDelegate();
        abstractC0870o.f14522n = charSequence;
        AbstractC0880z abstractC0880z = (AbstractC0880z) abstractC0870o;
        stepos.support.v7.widget.C c4 = abstractC0880z.f14628q;
        if (c4 != null) {
            c4.setWindowTitle(charSequence);
            return;
        }
        AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
        if (abstractC0860e != null) {
            abstractC0860e.t(charSequence);
            return;
        }
        TextView textView = abstractC0880z.f14612A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // stepos.support.v7.app.InterfaceC0867l
    @Nullable
    public K3.c onWindowStartingSupportActionMode(@NonNull K3.b bVar) {
        return null;
    }

    public void setBackTopBackground(Drawable drawable) {
        stepos.support.v7.widget.C c4 = ((AbstractC0880z) getDelegate()).f14628q;
        if (c4 != null) {
            c4.setBackTopBackground(drawable);
        }
    }

    public void setBackTopEnable(boolean z4) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        stepos.support.v7.widget.C c4 = abstractC0880z.f14628q;
        if (c4 != null) {
            c4.setBackTopEnable(z4);
            abstractC0880z.f14628q.setBackTopClickCallback(z4 ? abstractC0880z.f14627P : null);
        }
    }

    @Override // androidx.activity.o, android.app.Activity
    public void setContentView(@LayoutRes int i4) {
        getDelegate().h(i4);
    }

    public void setSupportActionBar(@Nullable Toolbar toolbar) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        if (abstractC0880z.f14511c instanceof Activity) {
            abstractC0880z.l();
            AbstractC0860e abstractC0860e = abstractC0880z.f14514f;
            if (abstractC0860e instanceof g0) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            abstractC0880z.f14515g = null;
            if (abstractC0860e != null) {
                abstractC0860e.h();
            }
            Window window = abstractC0880z.f14510b;
            Window.Callback callback = abstractC0880z.f14512d;
            if (toolbar != null) {
                c0 c0Var = new c0(toolbar, ((Activity) abstractC0880z.f14509a).getTitle(), callback);
                abstractC0880z.f14514f = c0Var;
                window.setCallback(c0Var.f14440c);
            } else {
                abstractC0880z.f14514f = null;
                window.setCallback(callback);
            }
            abstractC0880z.d();
        }
    }

    @Deprecated
    public void setSupportProgress(int i4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z4) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z4) {
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(@StyleRes int i4) {
        super.setTheme(i4);
        this.mThemeId = i4;
    }

    public void setUiOptions(int i4) {
        ((AbstractC0870o) getDelegate()).f14524p = i4;
    }

    public void showBackTopButton() {
        stepos.support.v7.widget.C c4 = ((AbstractC0880z) getDelegate()).f14628q;
        if (c4 != null) {
            c4.j();
        }
    }

    public K3.c startMultiChoiceActionMode(K3.b bVar) {
        return getDelegate().i(bVar);
    }

    @Nullable
    public K3.c startSupportActionMode(@NonNull K3.b bVar) {
        return getDelegate().j(bVar);
    }

    public int stepOSNightModeUseOf() {
        return 0;
    }

    public void supportFinishAfterTransition() {
        if (getFragmentManager().popBackStackImmediate()) {
            return;
        }
        AbstractC0240a.a(this);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().d();
    }

    public void supportNavigateUpTo(@NonNull Intent intent) {
        navigateUpTo(intent);
    }

    public boolean supportRequestWindowFeature(int i4) {
        return getDelegate().g(i4);
    }

    public boolean supportShouldUpRecreateTask(@NonNull Intent intent) {
        return shouldUpRecreateTask(intent);
    }

    @Override // androidx.fragment.app.G, androidx.activity.o, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i4, MenuItem menuItem) {
        if (super.onMenuItemSelected(i4, menuItem)) {
            return true;
        }
        AbstractC0860e supportActionBar = getSupportActionBar();
        if (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.c() & 4) == 0) {
            return false;
        }
        return onSupportNavigateUp();
    }

    @Override // androidx.activity.o, android.app.Activity
    public void setContentView(View view) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ViewGroup viewGroup = (ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        abstractC0880z.f14511c.onContentChanged();
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC0880z abstractC0880z = (AbstractC0880z) getDelegate();
        abstractC0880z.t();
        ViewGroup viewGroup = (ViewGroup) abstractC0880z.f14637z.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        abstractC0880z.f14511c.onContentChanged();
    }
}
