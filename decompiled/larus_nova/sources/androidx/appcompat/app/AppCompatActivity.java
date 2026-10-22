package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NavUtils;
import androidx.core.app.TaskStackBuilder;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import dc9.d;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatActivity extends FragmentActivity implements AppCompatCallback, TaskStackBuilder.SupportParentable, ActionBarDrawerToggle.DelegateProvider {
    private static final String DELEGATE_TAG = "androidx:appcompat";
    private AppCompatDelegate mDelegate;
    private Resources mResources;

    public static /* synthetic */ void access$000(FragmentActivity r100, Configuration r101) {
        super.onConfigurationChanged(r101);
    }

    public void androidx_appcompat_app_AppCompatActivity__finish$___twin___() {
        super.finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void finish() {
        androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(this);
    }

    public void onNightModeChanged(int r100) {
    }

    public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder r100) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeFinished(ActionMode r100) {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public void onSupportActionModeStarted(ActionMode r100) {
    }

    public void onSupportContentChanged() {
    }

    @Override // androidx.appcompat.app.AppCompatCallback
    public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback r100) {
        return null;
    }

    public void setSupportProgress(int r100) {
    }

    public void setSupportProgressBarIndeterminate(boolean r100) {
    }

    public void setSupportProgressBarIndeterminateVisibility(boolean r100) {
    }

    public void setSupportProgressBarVisibility(boolean r100) {
    }

    public AppCompatDelegate getDelegate() {
        if (this.mDelegate != null) goto L6;
        this.mDelegate = AppCompatDelegate.create(this, this);
    L6:
        return this.mDelegate;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.mResources == null) goto L5;
    L7:
        Resources r100 = this.mResources;
        if (r100 == null) goto L10;
        return r100;
    L10:
        return super.getResources();
    L5:
        if (VectorEnabledTintResources.shouldBeUsed() == false) goto L7;
        this.mResources = new VectorEnabledTintResources(this, super.getResources());
        goto L7
    }

    public AppCompatActivity() {
        initDelegate();
    }

    private void initDelegate() {
        getSavedStateRegistry().registerSavedStateProvider(DELEGATE_TAG, new AnonymousClass1(this));
        addOnContextAvailableListener(new AnonymousClass2(this));
    }

    private void initViewTreeOwners() {
        ViewTreeLifecycleOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeViewModelStoreOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
        ViewTreeSavedStateRegistryOwner.set(INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(getWindow()), this);
    }

    public void androidx_appcompat_app_AppCompatActivity__onDestroy$___twin___() {
        super.onDestroy();
        getDelegate().onDestroy();
    }

    @Override // android.app.Activity
    public void closeOptionsMenu() {
        ActionBar r100 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r100 != null) goto L6;
    L7:
        super.closeOptionsMenu();
        return;
    L6:
        if (r100.closeOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.DelegateProvider
    public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
        return getDelegate().getDrawerToggleDelegate();
    }

    @Override // android.app.Activity
    public MenuInflater getMenuInflater() {
        return getDelegate().getMenuInflater();
    }

    public ActionBar getSupportActionBar() {
        return getDelegate().getSupportActionBar();
    }

    @Override // androidx.core.app.TaskStackBuilder.SupportParentable
    public Intent getSupportParentActivityIntent() {
        return NavUtils.getParentActivityIntent(this);
    }

    @Override // android.app.Activity
    public void invalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        getDelegate().onPostResume();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        getDelegate().onStart();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        getDelegate().onStop();
    }

    public boolean onSupportNavigateUp() {
        Intent r100 = getSupportParentActivityIntent();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (supportShouldUpRecreateTask(r100) == false) goto L10;
        TaskStackBuilder r101 = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack(r101);
        onPrepareSupportNavigateUpTaskStack(r101);
        r101.startActivities();
        ActivityCompat.finishAffinity(this);     // Catch: IllegalStateException -> L9
        return true;
    L9:
        finish();
        return true;
    L10:
        supportNavigateUpTo(r100);
        return true;
    }

    @Override // android.app.Activity
    public void openOptionsMenu() {
        ActionBar r100 = getSupportActionBar();
        if (getWindow().hasFeature(0) == false) goto L9;
        if (r100 != null) goto L6;
    L7:
        super.openOptionsMenu();
        return;
    L6:
        if (r100.openOptionsMenu() == false) goto L7;
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void supportInvalidateOptionsMenu() {
        getDelegate().invalidateOptionsMenu();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onContentChanged() {
        onSupportContentChanged();
    }

    public AppCompatActivity(int r100) {
        super(r100);
        initDelegate();
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == c.f346341a) goto L7;
        c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static void androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_finish(AppCompatActivity r110) {
        r110.androidx_appcompat_app_AppCompatActivity__finish$___twin___();
        if ((r110 instanceof ChatWindowActivity) == false) goto L5;
        return;
    L5:
        FLogger r100 = FLogger.f375446a;
        r100.i("ActivityLancet", "finish ".concat(r110.getClass().getName()));
        long r101 = SystemClock.uptimeMillis();
        Map<Activity, Long> r102 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r102);
        Long r103 = r102.get(r110);     // Catch: Throwable -> L50
        if (r103 != null) goto L10;
    L13:
        r102.put(r110, Long.valueOf(r101));     // Catch: Throwable -> L50
        monitor-exit(r102);     // Catch: Throwable -> L50
    L47:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
        return;
    L16:
        if (r110.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L20;
        r100.i("ActivityLancet", "quit !resume, current state = " + r110.getLifecycle().getCurrentState());     // Catch: Throwable -> L47
        return;
    L20:
        if (r110.isFinishing() == true) goto L24;
        r100.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L47
        return;
    L24:
        if (ActivityStartBehavior.isInternalActivityConsumed(r110) == true) goto L28;
        r100.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L47
        return;
    L28:
        if (ActivityLancet.isOnlyActivityInTask(r110) == true) goto L32;
        r100.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L47
        return;
    L32:
        if (ActivityLancet.isExcludedActivity(r110) == false) goto L36;
        r100.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L47
        return;
    L36:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L38;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L47
        return;
    L38:
        Intent r104 = r110.getPackageManager().getLaunchIntentForPackage(r110.getPackageName());     // Catch: Throwable -> L47
        if (r104 != null) goto L41;
        return;
    L41:
        r104.addFlags(268435456);     // Catch: Throwable -> L47
        r104.addFlags(2097152);     // Catch: Throwable -> L47
        r100.i("ActivityLancet", "start launcher intent after backPressed, activity=" + r110);     // Catch: Throwable -> L47
        r110.startActivity(r104);     // Catch: Throwable -> L44
        r110.overridePendingTransition(R.anim.fade_in, R.anim.slide_out_right);     // Catch: Throwable -> L44
    L58:
        return;
    L44:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L47
        return;
    L10:
        if ((r101 - r103.longValue()) >= 800) goto L13;
        monitor-exit(r102);     // Catch: Throwable -> L50
        return;
    L50:
        th = move-exception;
        throw th;
    }

    public static void androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ActivityLancet_onDestroy(AppCompatActivity r100) {
        if ((r100 instanceof FragmentActivity) == true) goto L5;
    L7:
        r100.androidx_appcompat_app_AppCompatActivity__onDestroy$___twin___();
        return;
    L5:
        if (WindowUtils.INSTANCE.isMainBotActivity(r100) == false) goto L7;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(r100);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(r100.getClass().getName()));
        goto L7
    }

    private boolean performMenuItemShortcut(KeyEvent r100) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        return false;
    L5:
        if (r100.isCtrlPressed() == false) goto L7;
        return false;
    L7:
        if (KeyEvent.metaStateHasNoModifiers(r100.getMetaState()) == false) goto L9;
        return false;
    L9:
        if (r100.getRepeatCount() == 0) goto L11;
        return false;
    L11:
        if (KeyEvent.isModifierKey(r100.getKeyCode()) == true) goto L25;
        Window r101 = getWindow();
        if (r101 != null) goto L15;
        return false;
    L15:
        if (INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101) != null) goto L17;
        return false;
    L17:
        if (INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r101).dispatchKeyShortcutEvent(r100) == false) goto L28;
        return true;
    L28:
        return false;
    L25:
        return false;
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context r100) {
        super.attachBaseContext(getDelegate().attachBaseContext2(r100));
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent r100) {
        int r101 = r100.getKeyCode();
        ActionBar r102 = getSupportActionBar();
        if (r101 != 82) goto L10;
        if (r102 == null) goto L10;
        if (r102.onMenuKeyEvent(r100) == false) goto L10;
        return true;
    L10:
        return super.dispatchKeyEvent(r100);
    }

    @Override // android.app.Activity
    public <T extends View> T findViewById(int r100) {
        return (T) getDelegate().findViewById(r100);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration r100) {
        INVOKESPECIAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(this, r100);
        if (this.mResources == null) goto L5;
        DisplayMetrics r101 = INVOKEVIRTUAL_androidx_appcompat_app_AppCompatActivity_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(super.getResources());
        this.mResources.updateConfiguration(r100, r101);
    L5:
        getDelegate().onConfigurationChanged(r100);
    }

    public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder r100) {
        r100.addParentStack(this);
    }

    @Override // android.app.Activity
    public void onPostCreate(Bundle r100) {
        super.onPostCreate(r100);
        getDelegate().onPostCreate(r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int r100) {
        initViewTreeOwners();
        getDelegate().setContentView(r100);
    }

    public void setSupportActionBar(Toolbar r100) {
        getDelegate().setSupportActionBar(r100);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public void setTheme(int r100) {
        super.setTheme(r100);
        getDelegate().setTheme(r100);
    }

    public ActionMode startSupportActionMode(ActionMode.Callback r100) {
        return getDelegate().startSupportActionMode(r100);
    }

    public void supportNavigateUpTo(Intent r100) {
        NavUtils.navigateUpTo(this, r100);
    }

    public boolean supportRequestWindowFeature(int r100) {
        return getDelegate().requestWindowFeature(r100);
    }

    public boolean supportShouldUpRecreateTask(Intent r100) {
        return NavUtils.shouldUpRecreateTask(this, r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r100) {
        initViewTreeOwners();
        getDelegate().setContentView(r100);
    }

    public static void INVOKESPECIAL_androidx_appcompat_app_AppCompatActivity_com_larus_home_impl_pad_PadLancet_onConfigurationChanged(FragmentActivity r100, Configuration r101) {
        access$000(r100, r101);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.Activity");     // Catch: Throwable -> L17
        if (d.a() == true) goto L22;
        int r102 = r100.getRequestedOrientation();     // Catch: Throwable -> L17
        if (r101 == null) goto L8;
        Integer r103 = Integer.valueOf(r101.orientation);     // Catch: Throwable -> L17
    L9:
        if (r103 != null) goto L12;
    L14:
        if (r102 != 3) goto L24;
        r100.setRequestedOrientation(1);     // Catch: Throwable -> L17
        FLogger.f375446a.i("PadLancet", "onConfigurationChanged, phone reset page:" + r100.getClass().getSimpleName() + " portrait");     // Catch: Throwable -> L17
        return;
    L24:
        return;
    L12:
        if (r103.intValue() != r102) goto L14;
        return;
    L8:
        r103 = null;
        goto L9
    L22:
        return;
    L17:
        th = move-exception;
        FLogger.f375446a.e("PadLancet", "hook onConfigurationChanged error:" + th, th);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void addContentView(View r100, ViewGroup.LayoutParams r101) {
        initViewTreeOwners();
        getDelegate().addContentView(r100, r101);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r100, KeyEvent r101) {
        if (performMenuItemShortcut(r101) == false) goto L7;
        return true;
    L7:
        return super.onKeyDown(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int r100, MenuItem r101) {
        if (super.onMenuItemSelected(r100, r101) == false) goto L6;
        return true;
    L6:
        ActionBar r102 = getSupportActionBar();
        if (r101.getItemId() != 16908332) goto L13;
        if (r102 != null) goto L10;
        return false;
    L10:
        if ((r102.getDisplayOptions() & 4) != 0) goto L12;
        return false;
    L12:
        return onSupportNavigateUp();
    L13:
        return false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuOpened(int r100, Menu r101) {
        return super.onMenuOpened(r100, r101);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int r100, Menu r101) {
        super.onPanelClosed(r100, r101);
    }

    @Override // android.app.Activity
    public void onTitleChanged(CharSequence r100, int r101) {
        super.onTitleChanged(r100, r101);
        getDelegate().setTitle(r100);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(View r100, ViewGroup.LayoutParams r101) {
        initViewTreeOwners();
        getDelegate().setContentView(r100, r101);
    }
}
