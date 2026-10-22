package com.android.server;

import android.R;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.ISecurityStateManager;
import android.os.SystemProperties;
import android.os.VintfRuntimeInfo;
import android.text.TextUtils;
import android.util.Slog;
import android.webkit.WebViewProviderInfo;
import android.webkit.WebViewUpdateService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class SecurityStateManagerService extends ISecurityStateManager.Stub {
    static final Pattern KERNEL_RELEASE_PATTERN = null;
    private static final String TAG = "SecurityStateManagerService";
    static final String VENDOR_SECURITY_PATCH_PROPERTY_KEY = "ro.vendor.build.security_patch";
    private final Context mContext;
    private final PackageManager mPackageManager;

    static {
        KERNEL_RELEASE_PATTERN = Pattern.compile("(\\d+\\.\\d+\\.\\d+)(.*)");
    }

    public SecurityStateManagerService(Context context) {
        this.mContext = context;
        this.mPackageManager = context.getPackageManager();
    }

    public Bundle getGlobalSecurityState() {
        long token = Binder.clearCallingIdentity();
        Bundle r2 = getGlobalSecurityStateInternal();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private Bundle getGlobalSecurityStateInternal() {
        Bundle globalSecurityState = new Bundle();
        globalSecurityState.putString("system_spl", Build.VERSION.SECURITY_PATCH);
        globalSecurityState.putString("vendor_spl", SystemProperties.get(VENDOR_SECURITY_PATCH_PROPERTY_KEY, ""));
        String moduleMetadataProviderPackageName = this.mContext.getString(R.string.config_factoryResetPackage);
        if (moduleMetadataProviderPackageName.isEmpty() == true) goto L5;
        globalSecurityState.putString(moduleMetadataProviderPackageName, getSpl(moduleMetadataProviderPackageName));
    L5:
        globalSecurityState.putString("kernel_version", getKernelVersion());
        addWebViewPackages(globalSecurityState);
        addSecurityStatePackages(globalSecurityState);
        return globalSecurityState;
    }

    private String getSpl(String packageName) {
        if (TextUtils.isEmpty(packageName) == true) goto L12;
        return this.mPackageManager.getPackageInfo(packageName, 0).versionName;
    L6:
        e = move-exception;
        Slog.e(TAG, TextUtils.formatSimple("Failed to get SPL for package %s.", new Object[]{packageName}), e);
        return "";
    L12:
        return "";
    }

    private String getKernelVersion() {
        Matcher matcher = KERNEL_RELEASE_PATTERN.matcher(VintfRuntimeInfo.getKernelVersion());
        if (matcher.matches() == true) goto L5;
        return "";
    L5:
        return matcher.group(1);
    }

    private void addWebViewPackages(Bundle bundle) {
        WebViewProviderInfo[] r0 = WebViewUpdateService.getAllWebViewPackages();
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        WebViewProviderInfo info = r0[r2];
        String packageName = info.packageName;
        bundle.putString(packageName, getSpl(packageName));
        r2 = r2 + 1;
        goto L3
    }

    private void addSecurityStatePackages(Bundle bundle) {
        String[] packageNames = this.mContext.getResources().getStringArray(R.array.config_toastCrossUserPackages);
        int r1 = packageNames.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L5;
        String packageName = packageNames[r2];
        bundle.putString(packageName, getSpl(packageName));
        r2 = r2 + 1;
        goto L3
    }
}
