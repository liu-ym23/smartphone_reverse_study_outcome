package com.android.server.webkit;

import android.R;
import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.os.RemoteException;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.Settings;
import android.util.AndroidRuntimeException;
import android.util.Log;
import android.util.Slog;
import android.webkit.UserPackage;
import android.webkit.WebViewFactory;
import android.webkit.WebViewFactoryProvider;
import android.webkit.WebViewProviderInfo;
import android.webkit.WebViewZygote;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import com.android.server.pinner.PinnedFile;
import com.android.server.pinner.PinnerService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class SystemImpl implements SystemInterface {
    private static final int PACKAGE_FLAGS = 4195520;
    private static final String PIN_GROUP = "webview";
    private static final String TAG = null;
    private static final String TAG_AVAILABILITY = "availableByDefault";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_FALLBACK = "isFallback";
    private static final String TAG_PACKAGE_NAME = "packageName";
    private static final String TAG_SIGNATURE = "signature";
    private static final String TAG_START = "webviewproviders";
    private static final String TAG_WEBVIEW_PROVIDER = "webviewprovider";
    private final Context mContext;
    private final WebViewProviderInfo[] mWebViewProviderPackages;

    static {
        TAG = SystemImpl.class.getSimpleName();
    }

    SystemImpl(Context context) {
        this.mContext = context;
        int numFallbackPackages = 0;
        int numAvailableByDefaultPackages = 0;
        XmlResourceParser parser = null;
        List<WebViewProviderInfo> webViewProviders = new ArrayList();
        XmlResourceParser parser2 = this.mContext.getResources().getXml(R.xml.config_webview_packages);     // Catch: Throwable -> L27 Throwable -> L29
        XmlUtils.beginDocument(parser2, TAG_START);     // Catch: Throwable -> L27 Throwable -> L29
    L4:
        XmlUtils.nextElement(parser2);     // Catch: Throwable -> L27 Throwable -> L29
        String element = parser2.getName();     // Catch: Throwable -> L27 Throwable -> L29
        if (element == null) goto L6;
        if (element.equals(TAG_WEBVIEW_PROVIDER) == true) goto L14;
        Log.e(TAG, "Found an element that is not a WebView provider");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        goto L4
    L14:
        String packageName = parser2.getAttributeValue(null, "packageName");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        if (packageName == null) goto L40;
        String description = parser2.getAttributeValue(null, TAG_DESCRIPTION);     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        if (description == null) goto L38;
        boolean availableByDefault = "true".equals(parser2.getAttributeValue(null, TAG_AVAILABILITY));     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        boolean isFallback = "true".equals(parser2.getAttributeValue(null, TAG_FALLBACK));     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        WebViewProviderInfo currentProvider = new WebViewProviderInfo(packageName, description, availableByDefault, isFallback, readSignatures(parser2));     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        if (currentProvider.isFallback == false) goto L34;
        numFallbackPackages = numFallbackPackages + 1;     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        if (currentProvider.availableByDefault == false) goto L32;
        if (numFallbackPackages <= 1) goto L34;
        throw new AndroidRuntimeException("There can be at most one WebView fallback package.");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
    L32:
        throw new AndroidRuntimeException("Each WebView fallback package must be available by default.");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
    L34:
        if (currentProvider.availableByDefault == false) goto L36;
        numAvailableByDefaultPackages = numAvailableByDefaultPackages + 1;     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
    L36:
        webViewProviders.add(currentProvider);     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
        goto L4
    L38:
        throw new AndroidRuntimeException("WebView provider in framework resources missing description");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
    L40:
        throw new AndroidRuntimeException("WebView provider in framework resources missing package name");     // Catch: Throwable -> L27 Throwable -> L29 Throwable -> L29
    L6:
        parser2.close();
        if (numAvailableByDefaultPackages == 0) goto L11;
        this.mWebViewProviderPackages = (WebViewProviderInfo[]) webViewProviders.toArray(new WebViewProviderInfo[webViewProviders.size()]);
        return;
    L11:
        throw new AndroidRuntimeException("There must be at least one WebView package that is available by default");
    L27:
        th = move-exception;
        if (0 == 0) goto L48;
        parser.close();
    L48:
        throw th;
    L29:
        e = move-exception;
        throw new AndroidRuntimeException("Error when parsing WebView config " + e);     // Catch: Throwable -> L27
    }

    @Override // com.android.server.webkit.SystemInterface
    public WebViewProviderInfo[] getWebViewPackages() {
        return this.mWebViewProviderPackages;
    }

    @Override // com.android.server.webkit.SystemInterface
    public long getFactoryPackageVersion(String packageName) throws PackageManager.NameNotFoundException {
        PackageManager pm = this.mContext.getPackageManager();
        return pm.getPackageInfo(packageName, 2097152).getLongVersionCode();
    }

    private static String[] readSignatures(XmlResourceParser parser) throws IOException, XmlPullParserException {
        List<String> signatures = new ArrayList();
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L10;
        if (parser.getName().equals(TAG_SIGNATURE) == true) goto L7;
        Log.e(TAG, "Found an element in a webview provider that is not a signature");
        goto L4
    L7:
        String signature = parser.nextText();
        signatures.add(signature);
        goto L4
    L10:
        return (String[]) signatures.toArray(new String[signatures.size()]);
    }

    @Override // com.android.server.webkit.SystemInterface
    public int onWebViewProviderChanged(PackageInfo packageInfo) {
        return WebViewFactory.onWebViewProviderChanged(packageInfo);
    }

    @Override // com.android.server.webkit.SystemInterface
    public String getUserChosenWebViewProvider() {
        return Settings.Global.getString(this.mContext.getContentResolver(), "webview_provider");
    }

    @Override // com.android.server.webkit.SystemInterface
    public void updateUserSetting(String newProviderName) {
        ContentResolver r0 = this.mContext.getContentResolver();
        if (newProviderName != null) goto L5;
        String r1 = "";
    L6:
        Settings.Global.putString(r0, "webview_provider", r1);
        return;
    L5:
        r1 = newProviderName;
        goto L6
    }

    @Override // com.android.server.webkit.SystemInterface
    public void killPackageDependents(String packageName) {
        ActivityManager.getService().killPackageDependents(packageName, -1);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        Slog.wtf(TAG, "failed to call killPackageDependents for " + packageName, e);
    }

    @Override // com.android.server.webkit.SystemInterface
    public void enablePackageForAllUsers(String packageName, boolean enable) {
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        Iterator r1 = userManager.getUserHandles(false).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserHandle user = (UserHandle) r1.next();
        enablePackageForUser(packageName, enable, user);
        goto L4
    }

    private void enablePackageForUser(String packageName, boolean enable, UserHandle user) {
        Context contextAsUser = this.mContext.createContextAsUser(user, 0);
        PackageManager pm = contextAsUser.getPackageManager();
        if (enable == false) goto L5;
        int r3 = 0;
    L16:
        pm.setApplicationEnabledSetting(packageName, r3, 0);     // Catch: IllegalArgumentException -> L9
        return;
    L9:
        e = move-exception;
        String r4 = TAG;
        StringBuilder r5 = new StringBuilder();
        r5.append("Tried to ");
        if (enable == false) goto L13;
        String r6 = "enable ";
    L14:
        r5.append(r6);
        r5.append(packageName);
        r5.append(" for user ");
        r5.append(user);
        r5.append(": ");
        r5.append(e);
        Log.w(r4, r5.toString());
        return;
    L13:
        r6 = "disable ";
        goto L14
    L5:
        r3 = 3;
        goto L16
    }

    @Override // com.android.server.webkit.SystemInterface
    public void installExistingPackageForAllUsers(String packageName) {
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        Iterator r1 = userManager.getUserHandles(false).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        UserHandle user = (UserHandle) r1.next();
        installPackageForUser(packageName, user);
        goto L4
    }

    private void installPackageForUser(String packageName, UserHandle user) {
        Context contextAsUser = this.mContext.createContextAsUser(user, 0);
        PackageInstaller installer = contextAsUser.getPackageManager().getPackageInstaller();
        installer.installExistingPackage(packageName, 0, null);
    }

    @Override // com.android.server.webkit.SystemInterface
    public boolean systemIsDebuggable() {
        return Build.isDebuggable();
    }

    @Override // com.android.server.webkit.SystemInterface
    public PackageInfo getPackageInfoForProvider(WebViewProviderInfo configInfo) throws PackageManager.NameNotFoundException {
        PackageManager pm = this.mContext.getPackageManager();
        return pm.getPackageInfo(configInfo.packageName, PACKAGE_FLAGS);
    }

    @Override // com.android.server.webkit.SystemInterface
    public boolean isCompatibleImplementationPackage(PackageInfo packageInfo) {
        return WebViewFactoryProvider.isCompatibleImplementationPackage(packageInfo);
    }

    @Override // com.android.server.webkit.SystemInterface
    public List<UserPackage> getPackageInfoForProviderAllUsers(WebViewProviderInfo configInfo) {
        return UserPackage.getPackageInfosAllUsers(this.mContext, configInfo.packageName, PACKAGE_FLAGS);
    }

    @Override // com.android.server.webkit.SystemInterface
    public void ensureZygoteStarted() {
        WebViewZygote.getProcess();
    }

    @Override // com.android.server.webkit.SystemInterface
    public void pinWebviewIfRequired(ApplicationInfo appInfo) {
        PinnerService pinnerService = (PinnerService) LocalServices.getService(PinnerService.class);
        int webviewPinQuota = pinnerService.getWebviewPinQuota();
        if (webviewPinQuota > 0) goto L5;
        return;
    L5:
        pinnerService.unpinGroup(PIN_GROUP);
        ArrayList<String> apksToPin = new ArrayList();
        boolean pinSharedFirst = appInfo.metaData.getBoolean("PIN_SHARED_LIBS_FIRST", true);
        if (appInfo.sharedLibraryFiles == null) goto L11;
        String[] r2 = appInfo.sharedLibraryFiles;
        int r3 = r2.length;
        int r4 = 0;
    L9:
        if (r4 >= r3) goto L11;
        String sharedLib = r2[r4];
        apksToPin.add(sharedLib);
        r4 = r4 + 1;
    L11:
        apksToPin.add(appInfo.sourceDir);
        if (pinSharedFirst == true) goto L14;
        Collections.reverse(apksToPin);
    L14:
        Iterator<String> r10 = apksToPin.iterator();
    L16:
        if (r10.hasNext() == false) goto L22;
        String apk = r10.next();
        if (webviewPinQuota <= 0) goto L26;
        ApplicationInfo appInfo2 = appInfo;
        PinnedFile pf = pinnerService.pinFile(apk, webviewPinQuota, appInfo2, PIN_GROUP, true);
        webviewPinQuota = (int) (((long) webviewPinQuota) - pf.bytesPinned);
        appInfo = appInfo2;
        goto L16
    L26:
        return;
    }
}
