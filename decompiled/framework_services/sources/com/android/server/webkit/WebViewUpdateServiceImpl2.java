package com.android.server.webkit;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.AsyncTask;
import android.os.Trace;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Slog;
import android.webkit.UserPackage;
import android.webkit.WebViewFactory;
import android.webkit.WebViewFactoryProvider;
import android.webkit.WebViewProviderInfo;
import android.webkit.WebViewProviderResponse;
import com.android.modules.expresslog.Counter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class WebViewUpdateServiceImpl2 {
    private static final long NS_PER_MS = 1000000;
    private static final int NUMBER_OF_RELROS_UNKNOWN = Integer.MAX_VALUE;
    private static final String TAG = null;
    private static final int VALIDITY_INCORRECT_SIGNATURE = 3;
    private static final int VALIDITY_INCORRECT_VERSION_CODE = 2;
    private static final int VALIDITY_NO_LIBRARY_FLAG = 4;
    private static final int VALIDITY_OK = 0;
    private static final int VALIDITY_OS_INCOMPATIBLE = 1;
    private static final int WAIT_TIMEOUT_MS = 1000;
    private boolean mAnyWebViewInstalled;
    private boolean mAttemptedToRepairBefore;
    private PackageInfo mCurrentWebViewPackage;
    private final WebViewProviderInfo mDefaultProvider;
    private final Object mLock;
    private long mMinimumVersionCode;
    private int mNumRelroCreationsFinished;
    private int mNumRelroCreationsStarted;
    private final SystemInterface mSystemInterface;
    private boolean mWebViewPackageDirty;

    private static class ProviderAndPackageInfo {
        public final PackageInfo packageInfo;
        public final WebViewProviderInfo provider;

        ProviderAndPackageInfo(WebViewProviderInfo provider, PackageInfo packageInfo) {
            this.provider = provider;
            this.packageInfo = packageInfo;
        }
    }

    private static class WebViewPackageMissingException extends Exception {
        WebViewPackageMissingException(String message) {
            super(message);
        }
    }

    public static /* synthetic */ void $r8$lambda$XXuU2jy5ieCy09in8MCscEXoIck(WebViewUpdateServiceImpl2 r0) {
        r0.startZygoteWhenReady();
    }

    static {
        TAG = WebViewUpdateServiceImpl2.class.getSimpleName();
    }

    WebViewUpdateServiceImpl2(SystemInterface systemInterface) {
        this.mMinimumVersionCode = -1;
        int r0 = 0;
        this.mNumRelroCreationsStarted = 0;
        this.mNumRelroCreationsFinished = 0;
        this.mWebViewPackageDirty = false;
        this.mAnyWebViewInstalled = false;
        this.mAttemptedToRepairBefore = false;
        this.mCurrentWebViewPackage = null;
        this.mLock = new Object();
        this.mSystemInterface = systemInterface;
        WebViewProviderInfo[] webviewProviders = getWebViewPackages();
        WebViewProviderInfo defaultProvider = null;
        int r3 = webviewProviders.length;
    L4:
        if (r0 >= r3) goto L9;
        WebViewProviderInfo provider = webviewProviders[r0];
        if (provider.availableByDefault == true) goto L7;
        r0 = r0 + 1;
        goto L4
    L7:
        defaultProvider = provider;
    L9:
        if (defaultProvider == null) goto L13;
        this.mDefaultProvider = defaultProvider;
        return;
    L13:
        throw new AndroidRuntimeException("No available by default WebView Provider.");
    }

    public void packageStateChanged(String packageName, int changedState, int userId) {
        WebViewProviderInfo[] r0 = this.mSystemInterface.getWebViewPackages();
        int r1 = r0.length;
        boolean r2 = false;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L40;
        WebViewProviderInfo provider = r0[r3];
        String webviewPackage = provider.packageName;
        if (webviewPackage.equals(packageName) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        boolean updateWebView = false;
        boolean removedOrChangedOldPackage = false;
        String oldProviderName = null;
        Object r8 = this.mLock;
        monitor-enter(r8);
        PackageInfo newPackage = findPreferredWebViewPackage();     // Catch: Throwable -> L11 WebViewPackageMissingException -> L13
        if (this.mCurrentWebViewPackage == null) goto L16;
        oldProviderName = this.mCurrentWebViewPackage.packageName;     // Catch: Throwable -> L11 WebViewPackageMissingException -> L13
    L16:
        if (provider.packageName.equals(newPackage.packageName) == false) goto L18;
    L21:
        r2 = true;
    L22:
        updateWebView = r2;
        removedOrChangedOldPackage = provider.packageName.equals(oldProviderName);     // Catch: Throwable -> L11 WebViewPackageMissingException -> L13
        if (updateWebView == false) goto L28;
        onWebViewProviderChanged(newPackage);     // Catch: Throwable -> L11 WebViewPackageMissingException -> L13
    L28:
        boolean repairNeeded = shouldTriggerRepairLocked();     // Catch: Throwable -> L11
        monitor-exit(r8);     // Catch: Throwable -> L11
        if (updateWebView == false) goto L34;
        if (removedOrChangedOldPackage == true) goto L34;
        if (oldProviderName == null) goto L34;
        this.mSystemInterface.killPackageDependents(oldProviderName);
    L34:
        if (repairNeeded == false) goto L46;
        attemptRepair();
        return;
    L46:
        return;
    L18:
        if (provider.packageName.equals(oldProviderName) == true) goto L21;
        if (this.mCurrentWebViewPackage != null) goto L22;
    L13:
        e = move-exception;
        this.mCurrentWebViewPackage = null;     // Catch: Throwable -> L11
        Slog.e(TAG, "Could not find valid WebView package to create relro with " + e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    private boolean shouldTriggerRepairLocked() {
        if (this.mAttemptedToRepairBefore == false) goto L6;
        return false;
    L6:
        if (this.mCurrentWebViewPackage != null) goto L9;
        return true;
    L9:
        if (this.mCurrentWebViewPackage.packageName.equals(this.mDefaultProvider.packageName) == false) goto L12;
        List<UserPackage> userPackages = this.mSystemInterface.getPackageInfoForProviderAllUsers(this.mDefaultProvider);
        return !isInstalledAndEnabledForAllUsers(userPackages);
    L12:
        return false;
    }

    private void attemptRepair() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mAttemptedToRepairBefore == false) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mAttemptedToRepairBefore = true;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        Slog.w(TAG, "No provider available for all users, trying to install and enable " + this.mDefaultProvider.packageName);
        this.mSystemInterface.installExistingPackageForAllUsers(this.mDefaultProvider.packageName);
        this.mSystemInterface.enablePackageForAllUsers(this.mDefaultProvider.packageName, true);
    }

    public void prepareWebViewInSystemServer() {
        Object r1 = this.mLock;     // Catch: Throwable -> L17 WebViewPackageMissingException -> L19
        monitor-enter(r1);     // Catch: Throwable -> L17 WebViewPackageMissingException -> L19
        this.mCurrentWebViewPackage = findPreferredWebViewPackage();     // Catch: Throwable -> L10
        boolean repairNeeded = shouldTriggerRepairLocked();     // Catch: Throwable -> L10
        String userSetting = this.mSystemInterface.getUserChosenWebViewProvider();     // Catch: Throwable -> L10
        if (userSetting != null) goto L8;
    L12:
        onWebViewProviderChanged(this.mCurrentWebViewPackage);     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        if (repairNeeded == false) goto L30;
        attemptRepair();     // Catch: Throwable -> L17 WebViewPackageMissingException -> L19
        return;
    L30:
        return;
    L8:
        if (userSetting.equals(this.mCurrentWebViewPackage.packageName) == true) goto L12;
        this.mSystemInterface.updateUserSetting(this.mCurrentWebViewPackage.packageName);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17 WebViewPackageMissingException -> L19
    L19:
        e = move-exception;
        Slog.e(TAG, "Could not find valid WebView package to create relro with", e);
        return;
    L17:
        t = move-exception;
        Slog.wtf(TAG, "error preparing webview provider from system server", t);
    }

    private void startZygoteWhenReady() {
        waitForAndGetProvider();
        this.mSystemInterface.ensureZygoteStarted();
    }

    public void handleNewUser(int userId) {
        if (userId != 0) goto L4;
        return;
    L4:
        handleUserChange();
    }

    public void handleUserRemoved(int userId) {
        handleUserChange();
    }

    private void handleUserChange() {
        updateCurrentWebViewPackage(null);
    }

    public void notifyRelroCreationCompleted() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mNumRelroCreationsFinished++;     // Catch: Throwable -> L7
        checkIfRelrosDoneLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public WebViewProviderResponse waitForAndGetProvider() {
        long timeoutTimeMs = (System.nanoTime() / NS_PER_MS) + 1000;
        int webViewStatus = 0;
        Object r7 = this.mLock;
        monitor-enter(r7);
        boolean webViewReady = webViewIsReadyLocked();     // Catch: Throwable -> L12
    L5:
        if (webViewReady == true) goto L16;
        long timeNowMs = System.nanoTime() / NS_PER_MS;     // Catch: Throwable -> L12
        if (timeNowMs >= timeoutTimeMs) goto L16;
        this.mLock.wait(timeoutTimeMs - timeNowMs);     // Catch: Throwable -> L12 InterruptedException -> L14
    L15:
        webViewReady = webViewIsReadyLocked();     // Catch: Throwable -> L12
    L16:
        PackageInfo webViewPackage = this.mCurrentWebViewPackage;     // Catch: Throwable -> L12
        if (webViewReady == false) goto L20;
    L23:
        monitor-exit(r7);     // Catch: Throwable -> L12
        if (webViewReady == true) goto L27;
        Slog.w(TAG, "creating relro file timed out");
    L27:
        return new WebViewProviderResponse(webViewPackage, webViewStatus);
    L20:
        if (this.mAnyWebViewInstalled == true) goto L22;
        webViewStatus = 4;
        goto L23
    L22:
        webViewStatus = 3;
        String timeoutError = "Timed out waiting for relro creation, relros started " + this.mNumRelroCreationsStarted + " relros finished " + this.mNumRelroCreationsFinished + " package dirty? " + this.mWebViewPackageDirty;     // Catch: Throwable -> L12
        Slog.e(TAG, timeoutError);     // Catch: Throwable -> L12
        Trace.instant(64, timeoutError);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        throw th;
    }

    public String changeProviderAndSetting(String newProviderName) {
        PackageInfo newPackage = updateCurrentWebViewPackage(newProviderName);
        if (newPackage != null) goto L7;
        return "";
    L7:
        return newPackage.packageName;
    }

    private PackageInfo updateCurrentWebViewPackage(String newProviderName) {
        boolean repairNeeded = false;
        Object r4 = this.mLock;
        monitor-enter(r4);
        PackageInfo oldPackage = this.mCurrentWebViewPackage;     // Catch: Throwable -> L8
        if (newProviderName == null) goto L38;
        this.mSystemInterface.updateUserSetting(newProviderName);     // Catch: Throwable -> L8
    L38:
        PackageInfo newPackage = findPreferredWebViewPackage();     // Catch: Throwable -> L8 WebViewPackageMissingException -> L16
        if (oldPackage == null) goto L18;
        if (newPackage.packageName.equals(oldPackage.packageName) == false) goto L18;
        boolean r5 = false;
    L19:
        boolean providerChanged = r5;
        if (providerChanged == false) goto L22;
        onWebViewProviderChanged(newPackage);     // Catch: Throwable -> L8
    L22:
        if (newProviderName != null) goto L24;
        repairNeeded = shouldTriggerRepairLocked();     // Catch: Throwable -> L8
    L24:
        monitor-exit(r4);     // Catch: Throwable -> L8
        if (providerChanged == false) goto L28;
        if (oldPackage == null) goto L28;
        this.mSystemInterface.killPackageDependents(oldPackage.packageName);
    L28:
        if (repairNeeded == false) goto L30;
        attemptRepair();
    L30:
        return newPackage;
    L18:
        r5 = true;
    L16:
        e = move-exception;
        this.mCurrentWebViewPackage = null;     // Catch: Throwable -> L8
        Slog.e(TAG, "Couldn't find WebView package to use " + e);     // Catch: Throwable -> L8
        return null;
    L8:
        th = move-exception;
        throw th;
    }

    private void onWebViewProviderChanged(PackageInfo newPackage) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAnyWebViewInstalled = true;     // Catch: Throwable -> L10
        if (this.mNumRelroCreationsStarted != this.mNumRelroCreationsFinished) goto L13;
        this.mSystemInterface.pinWebviewIfRequired(newPackage.applicationInfo);     // Catch: Throwable -> L10
        this.mCurrentWebViewPackage = newPackage;     // Catch: Throwable -> L10
        this.mNumRelroCreationsStarted = Integer.MAX_VALUE;     // Catch: Throwable -> L10
        this.mNumRelroCreationsFinished = 0;     // Catch: Throwable -> L10
        this.mNumRelroCreationsStarted = this.mSystemInterface.onWebViewProviderChanged(newPackage);     // Catch: Throwable -> L10
        Counter.logIncrement("webview.value_on_webview_provider_changed_counter");     // Catch: Throwable -> L10
        if (newPackage.packageName.equals(getDefaultWebViewPackage().packageName) == false) goto L12;
        Counter.logIncrement("webview.value_on_webview_provider_changed_with_default_package_counter");     // Catch: Throwable -> L10
    L12:
        checkIfRelrosDoneLocked();     // Catch: Throwable -> L10
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
        AsyncTask.THREAD_POOL_EXECUTOR.execute(new WebViewUpdateServiceImpl2$$ExternalSyntheticLambda0(this));
        return;
    L13:
        this.mWebViewPackageDirty = true;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public WebViewProviderInfo[] getValidWebViewPackages() {
        ProviderAndPackageInfo[] providersAndPackageInfos = getValidWebViewPackagesAndInfos();
        WebViewProviderInfo[] providers = new WebViewProviderInfo[providersAndPackageInfos.length];
        int n = 0;
    L4:
        if (n >= providersAndPackageInfos.length) goto L7;
        providers[n] = providersAndPackageInfos[n].provider;
        n = n + 1;
        goto L4
    L7:
        return providers;
    }

    public WebViewProviderInfo getDefaultWebViewPackage() {
        return this.mDefaultProvider;
    }

    private ProviderAndPackageInfo[] getValidWebViewPackagesAndInfos() {
        WebViewProviderInfo[] allProviders = this.mSystemInterface.getWebViewPackages();
        List<ProviderAndPackageInfo> providers = new ArrayList();
        int n = 0;
    L4:
        if (n >= allProviders.length) goto L13;
        PackageInfo packageInfo = this.mSystemInterface.getPackageInfoForProvider(allProviders[n]);     // Catch: PackageManager.NameNotFoundException -> L9
        if (validityResult(allProviders[n], packageInfo) != 0) goto L12;
        providers.add(new ProviderAndPackageInfo(allProviders[n], packageInfo));     // Catch: PackageManager.NameNotFoundException -> L9
    L12:
        n = n + 1;
        goto L4
    L13:
        int n2 = providers.size();
        return (ProviderAndPackageInfo[]) providers.toArray(new ProviderAndPackageInfo[n2]);
    }

    private PackageInfo findPreferredWebViewPackage() throws WebViewPackageMissingException {
        Counter.logIncrement("webview.value_find_preferred_webview_package_counter");
        String userChosenPackageName = this.mSystemInterface.getUserChosenWebViewProvider();
        WebViewProviderInfo userChosenProvider = getWebViewProviderForPackage(userChosenPackageName);
        if (userChosenProvider != null) goto L24;
    L22:
        PackageInfo packageInfo = this.mSystemInterface.getPackageInfoForProvider(this.mDefaultProvider);     // Catch: PackageManager.NameNotFoundException -> L18
        if (validityResult(this.mDefaultProvider, packageInfo) != 0) goto L16;
        return packageInfo;
    L16:
        Counter.logIncrement("webview.value_default_webview_package_invalid_counter");     // Catch: PackageManager.NameNotFoundException -> L18
    L20:
        Counter.logIncrement("webview.value_webview_not_usable_for_all_users_counter");
        this.mAnyWebViewInstalled = false;
        throw new WebViewPackageMissingException("Could not find a loadable WebView package");
    L19:
        Slog.w(TAG, "Default WebView package (" + this.mDefaultProvider.packageName + ") not found");
        goto L20
    L24:
        PackageInfo packageInfo2 = this.mSystemInterface.getPackageInfoForProvider(userChosenProvider);     // Catch: PackageManager.NameNotFoundException -> L9
        if (validityResult(userChosenProvider, packageInfo2) != 0) goto L22;
        List<UserPackage> userPackages = this.mSystemInterface.getPackageInfoForProviderAllUsers(userChosenProvider);     // Catch: PackageManager.NameNotFoundException -> L9
        if (isInstalledAndEnabledForAllUsers(userPackages) == false) goto L22;
        return packageInfo2;
    L12:
        Slog.w(TAG, "User chosen WebView package (" + userChosenPackageName + ") not found");
        goto L22
    }

    private WebViewProviderInfo getWebViewProviderForPackage(String packageName) {
        WebViewProviderInfo[] allProviders = getWebViewPackages();
        int n = 0;
    L4:
        if (n >= allProviders.length) goto L10;
        if (allProviders[n].packageName.equals(packageName) == true) goto L8;
        n = n + 1;
        goto L4
    L8:
        return allProviders[n];
    L10:
        return null;
    }

    private static boolean isInstalledAndEnabledForAllUsers(List<UserPackage> userPackages) {
        Iterator<UserPackage> r0 = userPackages.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        UserPackage userPackage = r0.next();
        if (userPackage.isInstalledPackage() == false) goto L11;
        if (userPackage.isEnabledPackage() == true) goto L4;
        return false;
    L11:
        return false;
    L13:
        return true;
    }

    public WebViewProviderInfo[] getWebViewPackages() {
        return this.mSystemInterface.getWebViewPackages();
    }

    public PackageInfo getCurrentWebViewPackage() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        PackageInfo r1 = this.mCurrentWebViewPackage;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean webViewIsReadyLocked() {
        if (this.mWebViewPackageDirty == false) goto L5;
    L9:
        return false;
    L5:
        if (this.mNumRelroCreationsStarted != this.mNumRelroCreationsFinished) goto L9;
        if (this.mAnyWebViewInstalled == false) goto L9;
        return true;
    }

    private void checkIfRelrosDoneLocked() {
        if (this.mNumRelroCreationsStarted == this.mNumRelroCreationsFinished) goto L5;
        return;
    L5:
        if (this.mWebViewPackageDirty == false) goto L11;
        this.mWebViewPackageDirty = false;
        PackageInfo newPackage = findPreferredWebViewPackage();     // Catch: WebViewPackageMissingException -> L9
        onWebViewProviderChanged(newPackage);     // Catch: WebViewPackageMissingException -> L9
        return;
    L10:
        this.mCurrentWebViewPackage = null;
        return;
    L11:
        this.mLock.notifyAll();
    }

    private int validityResult(WebViewProviderInfo configInfo, PackageInfo packageInfo) {
        if (this.mSystemInterface.isCompatibleImplementationPackage(packageInfo) == true) goto L7;
        return 1;
    L7:
        if (versionCodeGE(packageInfo.getLongVersionCode(), getMinimumVersionCode()) == true) goto L13;
        if (this.mSystemInterface.systemIsDebuggable() == true) goto L13;
        return 2;
    L13:
        if (providerHasValidSignature(configInfo, packageInfo, this.mSystemInterface) == true) goto L17;
        return 3;
    L17:
        if (WebViewFactory.getWebViewLibrary(packageInfo.applicationInfo) != null) goto L20;
        return 4;
    L20:
        return 0;
    }

    private static boolean versionCodeGE(long versionCode1, long versionCode2) {
        long v1 = versionCode1 / 100000;
        long v2 = versionCode2 / 100000;
        if (v1 < v2) goto L5;
        return true;
    L5:
        return false;
    }

    private long getMinimumVersionCode() {
        if (this.mMinimumVersionCode > 0) goto L5;
        long minimumVersionCode = -1;
        WebViewProviderInfo[] r4 = this.mSystemInterface.getWebViewPackages();
        int r5 = r4.length;
        int r6 = 0;
    L7:
        if (r6 >= r5) goto L19;
        WebViewProviderInfo provider = r4[r6];
        if (provider.availableByDefault == false) goto L18;
        long versionCode = this.mSystemInterface.getFactoryPackageVersion(provider.packageName);     // Catch: PackageManager.NameNotFoundException -> L17
        if (minimumVersionCode >= 0) goto L14;
    L15:
        minimumVersionCode = versionCode;
        goto L18
    L14:
        if (versionCode < minimumVersionCode) goto L15;
    L18:
        r6 = r6 + 1;
        goto L7
    L19:
        this.mMinimumVersionCode = minimumVersionCode;
        return this.mMinimumVersionCode;
    L5:
        return this.mMinimumVersionCode;
    }

    private static boolean providerHasValidSignature(WebViewProviderInfo provider, PackageInfo packageInfo, SystemInterface systemInterface) {
        if (systemInterface.systemIsDebuggable() == false) goto L6;
        return true;
    L6:
        if (packageInfo.applicationInfo.isSystemApp() == false) goto L9;
        return true;
    L9:
        if (packageInfo.signatures.length == 1) goto L11;
        return false;
    L11:
        Signature[] r0 = provider.signatures;
        int r3 = r0.length;
        int r4 = 0;
    L12:
        if (r4 >= r3) goto L17;
        Signature signature = r0[r4];
        if (signature.equals(packageInfo.signatures[0]) == true) goto L15;
        r4 = r4 + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    private static WebViewProviderInfo getFallbackProvider(WebViewProviderInfo[] webviewPackages) {
        int r0 = webviewPackages.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L8;
        WebViewProviderInfo provider = webviewPackages[r1];
        if (provider.isFallback == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return provider;
    L8:
        return null;
    }

    public void dumpState(PrintWriter pw) {
        pw.println("Current WebView Update Service state");
        Object r0 = this.mLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mCurrentWebViewPackage != null) goto L9;
        pw.println("  Current WebView package is null");     // Catch: Throwable -> L7
    L10:
        pw.println(TextUtils.formatSimple("  %s", new Object[]{WebViewFactoryProvider.describeCompatibleImplementationPackage()}));     // Catch: Throwable -> L7
        pw.println(TextUtils.formatSimple("  Minimum WebView version code: %d", new Object[]{Long.valueOf(this.mMinimumVersionCode)}));     // Catch: Throwable -> L7
        pw.println(TextUtils.formatSimple("  Number of relros started: %d", new Object[]{Integer.valueOf(this.mNumRelroCreationsStarted)}));     // Catch: Throwable -> L7
        pw.println(TextUtils.formatSimple("  Number of relros finished: %d", new Object[]{Integer.valueOf(this.mNumRelroCreationsFinished)}));     // Catch: Throwable -> L7
        pw.println(TextUtils.formatSimple("  WebView package dirty: %b", new Object[]{Boolean.valueOf(this.mWebViewPackageDirty)}));     // Catch: Throwable -> L7
        pw.println(TextUtils.formatSimple("  Any WebView package installed: %b", new Object[]{Boolean.valueOf(this.mAnyWebViewInstalled)}));     // Catch: Throwable -> L7
        PackageInfo preferredWebViewPackage = findPreferredWebViewPackage();     // Catch: Throwable -> L7 WebViewPackageMissingException -> L13
        pw.println(TextUtils.formatSimple("  Preferred WebView package (name, version): (%s, %s)", new Object[]{preferredWebViewPackage.packageName, preferredWebViewPackage.versionName}));     // Catch: Throwable -> L7 WebViewPackageMissingException -> L13
    L15:
        dumpAllPackageInformationLocked(pw);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L14:
        pw.println("  Preferred WebView package: none");     // Catch: Throwable -> L7
        goto L15
    L9:
        pw.println(TextUtils.formatSimple("  Current WebView package (name, version): (%s, %s)", new Object[]{this.mCurrentWebViewPackage.packageName, this.mCurrentWebViewPackage.versionName}));     // Catch: Throwable -> L7
        goto L10
    }

    private void dumpAllPackageInformationLocked(PrintWriter pw) {
        WebViewProviderInfo[] allProviders = this.mSystemInterface.getWebViewPackages();
        pw.println("  WebView packages:");
        int r1 = allProviders.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L16;
        WebViewProviderInfo provider = allProviders[r3];
        List<UserPackage> userPackages = this.mSystemInterface.getPackageInfoForProviderAllUsers(provider);
        PackageInfo systemUserPackageInfo = userPackages.get(0).getPackageInfo();
        if (systemUserPackageInfo != null) goto L7;
        pw.println(TextUtils.formatSimple("    %s is NOT installed.", new Object[]{provider.packageName}));
    L15:
        r3 = r3 + 1;
        goto L3
    L7:
        int validity = validityResult(provider, systemUserPackageInfo);
        String packageDetails = TextUtils.formatSimple("versionName: %s, versionCode: %d, targetSdkVersion: %d", new Object[]{systemUserPackageInfo.versionName, Long.valueOf(systemUserPackageInfo.getLongVersionCode()), Integer.valueOf(systemUserPackageInfo.applicationInfo.targetSdkVersion)});
        if (validity != 0) goto L14;
        boolean installedForAllUsers = isInstalledAndEnabledForAllUsers(this.mSystemInterface.getPackageInfoForProviderAllUsers(provider));
        String r10 = systemUserPackageInfo.packageName;
        if (installedForAllUsers == false) goto L12;
        String r11 = "";
    L13:
        pw.println(TextUtils.formatSimple("    Valid package %s (%s) is %s installed/enabled for all users", new Object[]{r10, packageDetails, r11}));
        goto L15
    L12:
        r11 = "NOT";
        goto L13
    L14:
        pw.println(TextUtils.formatSimple("    Invalid package %s (%s), reason: %s", new Object[]{systemUserPackageInfo.packageName, packageDetails, getInvalidityReason(validity)}));
        goto L15
    }

    private static String getInvalidityReason(int invalidityReason) {
        switch(invalidityReason) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L3;
        };
    L3:
        return "Unexcepted validity-reason";
    L5:
        return "No WebView-library manifest flag";
    L7:
        return "Incorrect signature";
    L9:
        return "Version code too low";
    L11:
        return "Not compatible with this OS version";
    }
}
