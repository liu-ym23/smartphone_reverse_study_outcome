package androidx.appcompat.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.r;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.aq;
import androidx.lifecycle.ar;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements b, r.a {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private c mDelegate;
    private Resources mResources;

    public void onLocalesChanged(androidx.core.os.i r1) {
    }

    public void onNightModeChanged(int r1) {
    }

    public void onPrepareSupportNavigateUpTaskStack(r r1) {
    }

    @Override // androidx.appcompat.app.b
    public void onSupportActionModeFinished(androidx.appcompat.view.b r1) {
    }

    @Override // androidx.appcompat.app.b
    public void onSupportActionModeStarted(androidx.appcompat.view.b r1) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    @Override // androidx.appcompat.app.b
    public androidx.appcompat.view.b onWindowStartingSupportActionMode(androidx.appcompat.view.b.a r2) {
        androidx.appcompat.view.b.a r1 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r2, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        return null;
    }

    @Deprecated
    public void setSupportProgress(int r1) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean r1) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean r1) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean r1) {
    }

    public AppCompatActivity() {
        initDelegate();
    }

    public AppCompatActivity(int r1) {
        super(r1);
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().a(DELEGATE_TAG, new AnonymousClass1(this));
        addOnContextAvailableListener(new AnonymousClass2(this));
    }

    public void attachBaseContext(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        super.attachBaseContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getDelegate().attachBaseContext2(r4), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public void setTheme(int r1) {
        super.setTheme(r1);
        getDelegate().setTheme(r1);
    }

    public void onPostCreate(Bundle r1) {
        super.onPostCreate(r1);
        getDelegate().onPostCreate(r1);
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    public void setSupportActionBar(Toolbar r1) {
        getDelegate().setSupportActionBar(r1);
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(int r1) {
        initViewTreeOwners();
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View r1) {
        initViewTreeOwners();
        getDelegate().setContentView(r1);
    }

    @Override // androidx.activity.ComponentActivity
    public void setContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        getDelegate().setContentView(r1, r2);
    }

    @Override // androidx.activity.ComponentActivity
    public void addContentView(View r1, ViewGroup.LayoutParams r2) {
        initViewTreeOwners();
        getDelegate().addContentView(r1, r2);
    }

    private void initViewTreeOwners() {
        aq.a(getWindow().getDecorView(), this);
        ar.a(getWindow().getDecorView(), this);
        androidx.savedstate.d.a(getWindow().getDecorView(), this);
        androidx.activity.f.a(getWindow().getDecorView(), this);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onConfigurationChanged(Configuration r2) {
        super.onConfigurationChanged(r2);
        getDelegate().onConfigurationChanged(r2);
        if (this.mResources == null) goto L6;
        Configuration r3 = super.getResources().getConfiguration();
        DisplayMetrics r0 = super.getResources().getDisplayMetrics();
        this.mResources.updateConfiguration(r3, r0);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public <T extends View> T findViewById(int r1) {
        return (T) getDelegate().findViewById(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public final boolean onMenuItemSelected(int r3, MenuItem r4) {
        MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
        if (super.onMenuItemSelected(r3, r5) == false) goto L6;
        return true;
    L6:
        ActionBar r6 = getSupportActionBar();
        if (r5.getItemId() != 16908332) goto L13;
        if (r6 != null) goto L10;
        return false;
    L10:
        if ((r6.a() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onDestroy() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    public void onTitleChanged(CharSequence r3, int r4) {
        CharSequence r5 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r3, CharSequence.class, "com.obric.aiagent.plugin");
        super.onTitleChanged(r5, r4);
        getDelegate().setTitle(r5);
    }

    public boolean supportRequestWindowFeature(int r1) {
        return getDelegate().requestWindowFeature(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    public androidx.appcompat.view.b startSupportActionMode(androidx.appcompat.view.b.a r3) {
        androidx.appcompat.view.b.a r4 = (androidx.appcompat.view.b.a) ZeusTransformUtils.wrapperContextForParams(r3, androidx.appcompat.view.b.a.class, "com.obric.aiagent.plugin");
        return getDelegate().startSupportActionMode(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreateSupportNavigateUpTaskStack(r r1) {
        r1.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean onSupportNavigateUp() {
        Intent r0 = getSupportParentActivityIntent();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r0) == false) goto L10;
        r r1 = r.a(this);
        onCreateSupportNavigateUpTaskStack(r1);
        onPrepareSupportNavigateUpTaskStack(r1);
        r1.a();
        ActivityCompat.a(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r0);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.core.app.r.a
    public Intent getSupportParentActivityIntent() {
        return androidx.core.app.h.a(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean supportShouldUpRecreateTask(Intent r1) {
        return androidx.core.app.h.a(this, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void supportNavigateUpTo(Intent r1) {
        androidx.core.app.h.b(this, r1);
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    public a.InterfaceC0008a getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    public boolean onMenuOpened(int r3, Menu r4) {
        return super.onMenuOpened(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin"));
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity
    public void onPanelClosed(int r3, Menu r4) {
        super.onPanelClosed(r3, (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = c.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // androidx.core.app.ComponentActivity
    public boolean dispatchKeyEvent(KeyEvent r4) {
        int r0 = r4.getKeyCode();
        ActionBar r1 = getSupportActionBar();
        if (r0 != 82) goto L10;
        if (r1 == null) goto L10;
        if (r1.a(r4) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Resources getResources() {
        if (this.mResources == null) goto L5;
    L7:
        Resources r0 = this.mResources;
        if (r0 == null) goto L10;
        return r0;
    L10:
        return super.getResources();
    L5:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L7;
        this.mResources = new VectorEnabledTintResources(this, super.getResources());
        goto L7
    }

    private boolean performMenuItemShortcut(KeyEvent r3) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return false;
    L5:
        if (r3.isCtrlPressed() == false) goto L7;
        return false;
    L7:
        if (KeyEvent.metaStateHasNoModifiers(r3.getMetaState()) == false) goto L9;
        return false;
    L9:
        if (r3.getRepeatCount() == 0) goto L11;
        return false;
    L11:
        if (KeyEvent.isModifierKey(r3.getKeyCode()) == true) goto L25;
        Window r2 = getWindow();
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r2.getDecorView() != null) goto L17;
        return false;
    L17:
        if (r2.getDecorView().dispatchKeyShortcutEvent(r3) == false) goto L28;
        return true;
    L28:
        return false;
    L25:
        return false;
    }

    public boolean onKeyDown(int r2, KeyEvent r3) {
        if (performMenuItemShortcut(r3) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r2, r3);
    }

    public void openOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r0.c() == false) goto L7;
        return;
    }

    public void closeOptionsMenu() {
        ActionBar r0 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r0 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r0.d() == false) goto L7;
        return;
    }
}
