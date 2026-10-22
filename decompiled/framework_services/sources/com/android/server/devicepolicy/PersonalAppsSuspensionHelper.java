package com.android.server.devicepolicy;

import android.R;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.IAccessibilityManager;
import android.view.inputmethod.InputMethodInfo;
import com.android.internal.telephony.SmsApplication;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.utils.Slogf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class PersonalAppsSuspensionHelper {
    private static final String LOG_TAG = "DevicePolicyManager";
    private static final int PACKAGE_QUERY_FLAGS = 786432;
    private final Context mContext;
    private final PackageManager mPackageManager;

    public static PersonalAppsSuspensionHelper forUser(Context context, int userId) {
        return new PersonalAppsSuspensionHelper(context.createContextAsUser(UserHandle.of(userId), 0));
    }

    private PersonalAppsSuspensionHelper(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
    }

    String[] getPersonalAppsForSuspension() {
        List<PackageInfo> installedPackageInfos = this.mPackageManager.getInstalledPackages(PACKAGE_QUERY_FLAGS);
        Set<String> result = new ArraySet();
        Iterator<PackageInfo> r2 = installedPackageInfos.iterator();
    L4:
        if (r2.hasNext() == false) goto L13;
        PackageInfo packageInfo = r2.next();
        ApplicationInfo info = packageInfo.applicationInfo;
        if (info.isSystemApp() == true) goto L10;
        if (info.isUpdatedSystemApp() == true) goto L10;
    L11:
        result.add(packageInfo.packageName);
    L10:
        if (hasLauncherIntent(packageInfo.packageName) == false) goto L4;
    L13:
        result.removeAll(getCriticalPackages());
        result.removeAll(getSystemLauncherPackages());
        result.removeAll(getAccessibilityServices());
        result.removeAll(getInputMethodPackages());
        result.remove(getDefaultSmsPackage());
        result.remove(getSettingsPackageName());
        String[] unsuspendablePackages = this.mPackageManager.getUnsuspendablePackages((String[]) result.toArray(new String[0]));
        int r4 = unsuspendablePackages.length;
        int r5 = 0;
    L14:
        if (r5 >= r4) goto L17;
        String pkg = unsuspendablePackages[r5];
        result.remove(pkg);
        r5 = r5 + 1;
        goto L14
    L17:
        return (String[]) result.toArray(new String[0]);
    }

    private List<String> getSystemLauncherPackages() {
        List<String> result = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        List<ResolveInfo> matchingActivities = this.mPackageManager.queryIntentActivities(intent, PACKAGE_QUERY_FLAGS);
        Iterator<ResolveInfo> r4 = matchingActivities.iterator();
    L4:
        if (r4.hasNext() == false) goto L23;
        ResolveInfo resolveInfo = r4.next();
        if (resolveInfo.activityInfo == null) goto L22;
        if (TextUtils.isEmpty(resolveInfo.activityInfo.packageName) == true) goto L22;
        String packageName = resolveInfo.activityInfo.packageName;
        ApplicationInfo applicationInfo = this.mPackageManager.getApplicationInfo(packageName, PACKAGE_QUERY_FLAGS);     // Catch: PackageManager.NameNotFoundException -> L16
        if (applicationInfo.isSystemApp() == true) goto L18;
        if (applicationInfo.isUpdatedSystemApp() == false) goto L4;
    L18:
        result.add(packageName);     // Catch: PackageManager.NameNotFoundException -> L16
    L20:
        Slogf.e(LOG_TAG, "Could not find application info for launcher app: %s", new Object[]{packageName});
    L22:
        Slogf.wtf(LOG_TAG, "Could not find package name for launcher app %s", new Object[]{resolveInfo});
        goto L4
    L23:
        return result;
    }

    private List<String> getAccessibilityServices() {
        IBinder iBinder = ServiceManager.getService("accessibility");
        if (iBinder != null) goto L5;
        IAccessibilityManager service = null;
    L6:
        AccessibilityManager am = new AccessibilityManager(this.mContext, service, this.mContext.getUserId());
        List<AccessibilityServiceInfo> accessibilityServiceInfos = am.getEnabledAccessibilityServiceList(-1);     // Catch: Throwable -> L16
        am.removeClient();
        List<String> result = new ArrayList();
        Iterator<AccessibilityServiceInfo> r5 = accessibilityServiceInfos.iterator();
    L10:
        if (r5.hasNext() == false) goto L15;
        AccessibilityServiceInfo serviceInfo = r5.next();
        ComponentName componentName = ComponentName.unflattenFromString(serviceInfo.getId());
        if (componentName == null) goto L10;
        result.add(componentName.getPackageName());
        goto L10
    L15:
        return result;
    L16:
        th = move-exception;
        am.removeClient();
        throw th;
    L5:
        service = IAccessibilityManager.Stub.asInterface(iBinder);
        goto L6
    }

    private List<String> getInputMethodPackages() {
        List<InputMethodInfo> enabledImes = InputMethodManagerInternal.get().getEnabledInputMethodListAsUser(this.mContext.getUserId());
        List<String> result = new ArrayList();
        Iterator<InputMethodInfo> r2 = enabledImes.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        InputMethodInfo info = r2.next();
        result.add(info.getPackageName());
        goto L4
    L6:
        return result;
    }

    private String getSettingsPackageName() {
        Intent intent = new Intent("android.settings.SETTINGS");
        intent.addCategory("android.intent.category.DEFAULT");
        ResolveInfo resolveInfo = this.mPackageManager.resolveActivity(intent, PACKAGE_QUERY_FLAGS);
        if (resolveInfo != null) goto L5;
        return null;
    L5:
        return resolveInfo.activityInfo.packageName;
    }

    private List<String> getCriticalPackages() {
        return Arrays.asList(this.mContext.getResources().getStringArray(R.array.config_screenBrighteningThresholds));
    }

    private boolean hasLauncherIntent(String packageName) {
        Intent intentToResolve = new Intent("android.intent.action.MAIN");
        intentToResolve.addCategory("android.intent.category.LAUNCHER");
        intentToResolve.setPackage(packageName);
        List<ResolveInfo> resolveInfos = this.mPackageManager.queryIntentActivities(intentToResolve, PACKAGE_QUERY_FLAGS);
        if (resolveInfos != null) goto L5;
    L7:
        return false;
    L5:
        if (resolveInfos.isEmpty() == true) goto L7;
        return true;
    }

    private String getDefaultSmsPackage() {
        ComponentName defaultSmsApp = SmsApplication.getDefaultSmsApplicationAsUser(this.mContext, false, this.mContext.getUser());
        if (defaultSmsApp != null) goto L7;
        return null;
    L7:
        return defaultSmsApp.getPackageName();
    }

    void dump(IndentingPrintWriter pw) {
        pw.println("PersonalAppsSuspensionHelper");
        pw.increaseIndent();
        DevicePolicyManagerService.dumpApps(pw, "critical packages", getCriticalPackages());
        DevicePolicyManagerService.dumpApps(pw, "launcher packages", getSystemLauncherPackages());
        DevicePolicyManagerService.dumpApps(pw, "accessibility services", getAccessibilityServices());
        DevicePolicyManagerService.dumpApps(pw, "input method packages", getInputMethodPackages());
        pw.printf("SMS package: %s\n", new Object[]{getDefaultSmsPackage()});
        pw.printf("Settings package: %s\n", new Object[]{getSettingsPackageName()});
        DevicePolicyManagerService.dumpApps(pw, "Packages subject to suspension", getPersonalAppsForSuspension());
        pw.decreaseIndent();
    }
}
