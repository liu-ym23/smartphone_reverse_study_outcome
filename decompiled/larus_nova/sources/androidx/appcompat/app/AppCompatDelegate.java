package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = null;
    private static final Object sActivityDelegatesLock = null;
    private static int sDefaultNightMode = -100;

    /* JADX INFO: loaded from: classes2.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    public AppCompatDelegate() {
    }

    public abstract void addContentView(View r100, ViewGroup.LayoutParams r101);

    public abstract boolean applyDayNight();

    public void attachBaseContext(Context r100) {
    }

    public abstract View createView(View r100, String r101, Context r102, AttributeSet r103);

    public abstract <T extends View> T findViewById(int r100);

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int r100);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration r100);

    public abstract void onCreate(Bundle r100);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle r100);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle r100);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int r100);

    public abstract void setContentView(int r100);

    public abstract void setContentView(View r100);

    public abstract void setContentView(View r100, ViewGroup.LayoutParams r101);

    public abstract void setHandleNativeActionModesEnabled(boolean r100);

    public abstract void setLocalNightMode(int r100);

    public abstract void setSupportActionBar(Toolbar r100);

    public void setTheme(int r100) {
    }

    public abstract void setTitle(CharSequence r100);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback r100);

    static {
        sActivityDelegates = new ArraySet();
        sActivityDelegatesLock = new Object();
    }

    private static void applyDayNightToActiveDelegates() {
        Object r100 = sActivityDelegatesLock;
        monitor-enter(r100);
        Iterator<WeakReference<AppCompatDelegate>> r101 = sActivityDelegates.iterator();     // Catch: Throwable -> L12
    L6:
        if (r101.hasNext() == false) goto L10;
        AppCompatDelegate r102 = r101.next().get();     // Catch: Throwable -> L12
        if (r102 == null) goto L6;
        r102.applyDayNight();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    public static void addActiveDelegate(AppCompatDelegate r100) {
        Object r101 = sActivityDelegatesLock;
        monitor-enter(r101);
        removeDelegateFromActives(r100);     // Catch: Throwable -> L7
        sActivityDelegates.add(new WeakReference(r100));     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static void removeActivityDelegate(AppCompatDelegate r100) {
        Object r101 = sActivityDelegatesLock;
        monitor-enter(r101);
        removeDelegateFromActives(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void removeDelegateFromActives(AppCompatDelegate r100) {
        Object r101 = sActivityDelegatesLock;
        monitor-enter(r101);
        Iterator<WeakReference<AppCompatDelegate>> r102 = sActivityDelegates.iterator();     // Catch: Throwable -> L13
    L6:
        if (r102.hasNext() == false) goto L11;
        AppCompatDelegate r103 = r102.next().get();     // Catch: Throwable -> L13
        if (r103 == r100) goto L10;
        if (r103 != null) goto L6;
    L10:
        r102.remove();     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r100) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(r100);
    }

    public static void setDefaultNightMode(int r100) {
        if (r100 == (-1)) goto L13;
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L13;
        if (r100 == 3) goto L13;
        return;
    L13:
        if (sDefaultNightMode == r100) goto L16;
        sDefaultNightMode = r100;
        applyDayNightToActiveDelegates();
        return;
    }

    public Context attachBaseContext2(Context r100) {
        attachBaseContext(r100);
        return r100;
    }

    public static AppCompatDelegate create(Activity r100, AppCompatCallback r101) {
        return new AppCompatDelegateImpl(r100, r101);
    }

    public static AppCompatDelegate create(Dialog r100, AppCompatCallback r101) {
        return new AppCompatDelegateImpl(r100, r101);
    }

    public static AppCompatDelegate create(Context r100, Activity r101, AppCompatCallback r102) {
        return new AppCompatDelegateImpl(r100, r101, r102);
    }

    public static AppCompatDelegate create(Context r100, Window r101, AppCompatCallback r102) {
        return new AppCompatDelegateImpl(r100, r101, r102);
    }
}
