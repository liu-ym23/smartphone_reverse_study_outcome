package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.LocaleManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.LocaleList;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.VectorEnabledTintResources;
import androidx.collection.ArraySet;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import com.android.common.speech.LoggingEvents;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class AppCompatDelegate {
    static final boolean DEBUG = false;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;
    public static final int FEATURE_SUPPORT_ACTION_BAR = 108;
    public static final int FEATURE_SUPPORT_ACTION_BAR_OVERLAY = 109;

    @Deprecated
    public static final int MODE_NIGHT_AUTO = 0;
    public static final int MODE_NIGHT_AUTO_BATTERY = 3;

    @Deprecated
    public static final int MODE_NIGHT_AUTO_TIME = 0;
    public static final int MODE_NIGHT_FOLLOW_SYSTEM = -1;
    public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_UNSPECIFIED = -100;
    public static final int MODE_NIGHT_YES = 2;
    static final String TAG = "AppCompatDelegate";
    private static final ArraySet<WeakReference<AppCompatDelegate>> sActivityDelegates = null;
    private static final Object sActivityDelegatesLock = null;
    private static final Object sAppLocalesStorageSyncLock = null;
    private static int sDefaultNightMode;
    private static Boolean sIsAutoStoreLocalesOptedIn;
    private static boolean sIsFrameworkSyncChecked;
    private static LocaleListCompat sRequestedAppLocales;
    static AppLocalesStorageHelper.SerialExecutor sSerialExecutorForLocalesStorage;
    private static LocaleListCompat sStoredAppLocales;

    static class Api24Impl {
        private Api24Impl() {
        }

        static LocaleList localeListForLanguageTags(String r0) {
            return LocaleList.forLanguageTags(r0);
        }
    }

    static class Api33Impl {
        private Api33Impl() {
        }

        static void localeManagerSetApplicationLocales(Object r0, LocaleList r1) {
            ((LocaleManager) r0).setApplicationLocales(r1);
        }

        static LocaleList localeManagerGetApplicationLocales(Object r0) {
            return ((LocaleManager) r0).getApplicationLocales();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NightMode {
    }

    public abstract void addContentView(View r1, ViewGroup.LayoutParams r2);

    boolean applyAppLocales() {
        return false;
    }

    public abstract boolean applyDayNight();

    @Deprecated
    public void attachBaseContext(Context r1) {
    }

    public abstract View createView(View r1, String r2, Context r3, AttributeSet r4);

    public abstract <T extends View> T findViewById(int r1);

    public Context getContextForDelegate() {
        return null;
    }

    public abstract ActionBarDrawerToggle.Delegate getDrawerToggleDelegate();

    public int getLocalNightMode() {
        return -100;
    }

    public abstract MenuInflater getMenuInflater();

    public abstract ActionBar getSupportActionBar();

    public abstract boolean hasWindowFeature(int r1);

    public abstract void installViewFactory();

    public abstract void invalidateOptionsMenu();

    public abstract boolean isHandleNativeActionModesEnabled();

    public abstract void onConfigurationChanged(Configuration r1);

    public abstract void onCreate(Bundle r1);

    public abstract void onDestroy();

    public abstract void onPostCreate(Bundle r1);

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle r1);

    public abstract void onStart();

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int r1);

    public abstract void setContentView(int r1);

    public abstract void setContentView(View r1);

    public abstract void setContentView(View r1, ViewGroup.LayoutParams r2);

    public abstract void setHandleNativeActionModesEnabled(boolean r1);

    public abstract void setLocalNightMode(int r1);

    public void setOnBackInvokedDispatcher(OnBackInvokedDispatcher r1) {
    }

    public abstract void setSupportActionBar(Toolbar r1);

    public void setTheme(int r1) {
    }

    public abstract void setTitle(CharSequence r1);

    public abstract ActionMode startSupportActionMode(ActionMode.Callback r1);

    static {
        sSerialExecutorForLocalesStorage = new AppLocalesStorageHelper.SerialExecutor(new AppLocalesStorageHelper.ThreadPerTaskExecutor());
        sDefaultNightMode = -100;
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
        sIsAutoStoreLocalesOptedIn = null;
        sIsFrameworkSyncChecked = false;
        sActivityDelegates = new ArraySet();
        sActivityDelegatesLock = new Object();
        sAppLocalesStorageSyncLock = new Object();
    }

    public static AppCompatDelegate create(Activity r1, AppCompatCallback r2) {
        return new AppCompatDelegateImpl(r1, r2);
    }

    public static AppCompatDelegate create(Dialog r1, AppCompatCallback r2) {
        return new AppCompatDelegateImpl(r1, r2);
    }

    public static AppCompatDelegate create(Context r1, Window r2, AppCompatCallback r3) {
        return new AppCompatDelegateImpl(r1, r2, r3);
    }

    public static AppCompatDelegate create(Context r1, Activity r2, AppCompatCallback r3) {
        return new AppCompatDelegateImpl(r1, r2, r3);
    }

    AppCompatDelegate() {
    }

    public Context attachBaseContext2(Context r1) {
        attachBaseContext(r1);
        return r1;
    }

    public static void setDefaultNightMode(int r1) {
        if (r1 == (-1)) goto L13;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L13;
        if (r1 == 3) goto L13;
        Log.d(TAG, "setDefaultNightMode() called with an unknown mode");
        return;
    L13:
        if (sDefaultNightMode == r1) goto L17;
        sDefaultNightMode = r1;
        applyDayNightToActiveDelegates();
        return;
    }

    public static void setApplicationLocales(LocaleListCompat r1) {
        Objects.requireNonNull(r1);
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r0 = getLocaleManagerForApplication();
        if (r0 == null) goto L17;
        Api33Impl.localeManagerSetApplicationLocales(r0, Api24Impl.localeListForLanguageTags(r1.toLanguageTags()));
        return;
    L17:
        return;
    L8:
        if (r1.equals(sRequestedAppLocales) == true) goto L21;
        Object r2 = sActivityDelegatesLock;
        monitor-enter(r2);
        sRequestedAppLocales = r1;     // Catch: Throwable -> L14
        applyLocalesToActiveDelegates();     // Catch: Throwable -> L14
        monitor-exit(r2);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public static LocaleListCompat getApplicationLocales() {
        if (BuildCompat.isAtLeastT() == false) goto L8;
        Object r0 = getLocaleManagerForApplication();
        if (r0 == null) goto L12;
        return LocaleListCompat.wrap(Api33Impl.localeManagerGetApplicationLocales(r0));
    L12:
        return LocaleListCompat.getEmptyLocaleList();
    L8:
        LocaleListCompat r1 = sRequestedAppLocales;
        if (r1 == null) goto L12;
        return r1;
    }

    public static int getDefaultNightMode() {
        return sDefaultNightMode;
    }

    static LocaleListCompat getRequestedAppLocales() {
        return sRequestedAppLocales;
    }

    static LocaleListCompat getStoredAppLocales() {
        return sStoredAppLocales;
    }

    static void resetStaticRequestedAndStoredLocales() {
        sRequestedAppLocales = null;
        sStoredAppLocales = null;
    }

    static void setIsAutoStoreLocalesOptedIn(boolean r0) {
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r0);
    }

    static Object getLocaleManagerForApplication() {
        Iterator<WeakReference<AppCompatDelegate>> r0 = sActivityDelegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        AppCompatDelegate r1 = r0.next().get();
        if (r1 == null) goto L4;
        Context r2 = r1.getContextForDelegate();
        if (r2 == null) goto L4;
        return r2.getSystemService(LoggingEvents.VoiceIme.EXTRA_START_LOCALE);
    L11:
        return null;
    }

    static boolean isAutoStorageOptedIn(Context r1) {
        if (sIsAutoStoreLocalesOptedIn != null) goto L10;
        ServiceInfo r2 = AppLocalesMetadataHolderService.getServiceInfo(r1);     // Catch: PackageManager.NameNotFoundException -> L8
        if (r2.metaData == null) goto L10;
        sIsAutoStoreLocalesOptedIn = Boolean.valueOf(r2.metaData.getBoolean("autoStoreLocales"));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        Log.d(TAG, "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
        sIsAutoStoreLocalesOptedIn = false;
    L10:
        return sIsAutoStoreLocalesOptedIn.booleanValue();
    }

    static /* synthetic */ void lambda$asyncExecuteSyncRequestedAndStoredLocales$0(Context r0) {
        syncRequestedAndStoredLocales(r0);
    }

    void asyncExecuteSyncRequestedAndStoredLocales(final Context r2) {
        sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda0(r2));
    }

    static void syncRequestedAndStoredLocales(final Context r3) {
        if (isAutoStorageOptedIn(r3) == true) goto L6;
        return;
    L6:
        if (BuildCompat.isAtLeastT() == true) goto L8;
        Object r0 = sAppLocalesStorageSyncLock;
        monitor-enter(r0);
        LocaleListCompat r1 = sRequestedAppLocales;     // Catch: Throwable -> L27
        if (r1 != null) goto L23;
        if (sStoredAppLocales != null) goto L18;
        sStoredAppLocales = LocaleListCompat.forLanguageTags(AppLocalesStorageHelper.readLocales(r3));     // Catch: Throwable -> L27
    L18:
        if (sStoredAppLocales.isEmpty() == false) goto L21;
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L21:
        sRequestedAppLocales = sStoredAppLocales;     // Catch: Throwable -> L27
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L27
        return;
    L23:
        if (r1.equals(sStoredAppLocales) == true) goto L25;
        LocaleListCompat r2 = sRequestedAppLocales;     // Catch: Throwable -> L27
        sStoredAppLocales = r2;     // Catch: Throwable -> L27
        AppLocalesStorageHelper.persistLocales(r3, r2.toLanguageTags());     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L8:
        if (sIsFrameworkSyncChecked == true) goto L31;
        sSerialExecutorForLocalesStorage.execute(new AppCompatDelegate$$ExternalSyntheticLambda1(r3));
        return;
    }

    static /* synthetic */ void lambda$syncRequestedAndStoredLocales$1(Context r0) {
        AppLocalesStorageHelper.syncLocalesToFramework(r0);
        sIsFrameworkSyncChecked = true;
    }

    public static void setCompatVectorFromResourcesEnabled(boolean r0) {
        VectorEnabledTintResources.setCompatVectorFromResourcesEnabled(r0);
    }

    public static boolean isCompatVectorFromResourcesEnabled() {
        return VectorEnabledTintResources.isCompatVectorFromResourcesEnabled();
    }

    static void addActiveDelegate(AppCompatDelegate r3) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        removeDelegateFromActives(r3);     // Catch: Throwable -> L7
        sActivityDelegates.add(new WeakReference(r3));     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    static void removeActivityDelegate(AppCompatDelegate r1) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        removeDelegateFromActives(r1);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void removeDelegateFromActives(AppCompatDelegate r3) {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        Iterator<WeakReference<AppCompatDelegate>> r1 = sActivityDelegates.iterator();     // Catch: Throwable -> L13
    L6:
        if (r1.hasNext() == false) goto L11;
        AppCompatDelegate r2 = r1.next().get();     // Catch: Throwable -> L13
        if (r2 == r3) goto L10;
        if (r2 != null) goto L6;
    L10:
        r1.remove();     // Catch: Throwable -> L13
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private static void applyDayNightToActiveDelegates() {
        Object r0 = sActivityDelegatesLock;
        monitor-enter(r0);
        Iterator<WeakReference<AppCompatDelegate>> r1 = sActivityDelegates.iterator();     // Catch: Throwable -> L12
    L6:
        if (r1.hasNext() == false) goto L10;
        AppCompatDelegate r2 = r1.next().get();     // Catch: Throwable -> L12
        if (r2 == null) goto L6;
        r2.applyDayNight();     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    private static void applyLocalesToActiveDelegates() {
        Iterator<WeakReference<AppCompatDelegate>> r0 = sActivityDelegates.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        AppCompatDelegate r1 = r0.next().get();
        if (r1 == null) goto L4;
        r1.applyAppLocales();
        goto L4
    }
}
