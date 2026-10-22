package com.android.server.webkit;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.webkit.UserPackage;
import android.webkit.WebViewProviderInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SystemInterface {
    void enablePackageForAllUsers(String r1, boolean r2);

    void ensureZygoteStarted();

    long getFactoryPackageVersion(String r1) throws PackageManager.NameNotFoundException;

    PackageInfo getPackageInfoForProvider(WebViewProviderInfo r1) throws PackageManager.NameNotFoundException;

    List<UserPackage> getPackageInfoForProviderAllUsers(WebViewProviderInfo r1);

    String getUserChosenWebViewProvider();

    WebViewProviderInfo[] getWebViewPackages();

    void installExistingPackageForAllUsers(String r1);

    boolean isCompatibleImplementationPackage(PackageInfo r1);

    void killPackageDependents(String r1);

    int onWebViewProviderChanged(PackageInfo r1);

    void pinWebviewIfRequired(ApplicationInfo r1);

    boolean systemIsDebuggable();

    void updateUserSetting(String r1);
}
