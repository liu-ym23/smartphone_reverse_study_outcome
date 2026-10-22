package com.android.server.webkit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.Process;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.os.UserHandle;
import android.util.Slog;
import android.webkit.IWebViewUpdateService;
import android.webkit.WebViewProviderInfo;
import android.webkit.WebViewProviderResponse;
import com.android.internal.util.DumpUtils;
import com.android.modules.expresslog.Histogram;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.pm.Settings;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class WebViewUpdateService extends SystemService {
    static final int PACKAGE_ADDED = 1;
    static final int PACKAGE_ADDED_REPLACED = 2;
    static final int PACKAGE_CHANGED = 0;
    static final int PACKAGE_REMOVED = 3;
    private static final String TAG = "WebViewUpdateService";
    private static final Histogram sAppWaitingForRelroCompletionDelay = null;
    private static final Histogram sPrepareWebViewInSystemServerLatency = null;
    private WebViewUpdateServiceImpl2 mImpl;
    private BroadcastReceiver mWebViewUpdatedReceiver;

    private class BinderService extends IWebViewUpdateService.Stub {
        final /* synthetic */ WebViewUpdateService this$0;

        /* synthetic */ BinderService(WebViewUpdateService r1, WebViewUpdateServiceIA r2) {
            this(r1);
        }

        private BinderService(WebViewUpdateService r1) {
            this.this$0 = r1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
            new WebViewUpdateServiceShellCommand2(this).exec(this, in, out, err, args, callback, resultReceiver);
        }

        public void notifyRelroCreationCompleted() {
            if (Binder.getCallingUid() != 1037) goto L5;
        L7:
            long callingId = Binder.clearCallingIdentity();
            WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).notifyRelroCreationCompleted();     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(callingId);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L5:
            if (Binder.getCallingUid() == 1000) goto L7;
        }

        public WebViewProviderResponse waitForAndGetProvider() {
            if (Binder.getCallingPid() == Process.myPid()) goto L9;
            long startTimeMs = SystemClock.uptimeMillis();
            WebViewProviderResponse webViewProviderResponse = WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).waitForAndGetProvider();
            long endTimeMs = SystemClock.uptimeMillis();
            WebViewUpdateService.m9583$$Nest$sfgetsAppWaitingForRelroCompletionDelay().logSample(endTimeMs - startTimeMs);
            if (webViewProviderResponse.packageInfo == null) goto L7;
            grantVisibilityToCaller(webViewProviderResponse.packageInfo.packageName, Binder.getCallingUid());
        L7:
            return webViewProviderResponse;
        L9:
            throw new IllegalStateException("Cannot create a WebView from the SystemServer");
        }

        private void grantVisibilityToCaller(String webViewPackageName, int callingUid) {
            PackageManagerInternal pmInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
            int webviewUid = pmInternal.getPackageUid(webViewPackageName, 0, UserHandle.getUserId(callingUid));
            pmInternal.grantImplicitAccess(UserHandle.getUserId(callingUid), null, UserHandle.getAppId(callingUid), webviewUid, true);
        }

        public String changeProviderAndSetting(String newProvider) {
            if (this.this$0.getContext().checkCallingPermission("android.permission.WRITE_SECURE_SETTINGS") != 0) goto L11;
            long callingId = Binder.clearCallingIdentity();
            String r2 = WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).changeProviderAndSetting(newProvider);     // Catch: Throwable -> L8
            Binder.restoreCallingIdentity(callingId);
            return r2;
        L8:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L11:
            String msg = "Permission Denial: changeProviderAndSetting() from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid() + " requires android.permission.WRITE_SECURE_SETTINGS";
            Slog.w(WebViewUpdateService.TAG, msg);
            throw new SecurityException(msg);
        }

        public WebViewProviderInfo[] getValidWebViewPackages() {
            return WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).getValidWebViewPackages();
        }

        public WebViewProviderInfo getDefaultWebViewPackage() {
            return WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).getDefaultWebViewPackage();
        }

        public WebViewProviderInfo[] getAllWebViewPackages() {
            return WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).getWebViewPackages();
        }

        public String getCurrentWebViewPackageName() {
            PackageInfo pi = getCurrentWebViewPackage();
            if (pi != null) goto L6;
            return null;
        L6:
            return pi.packageName;
        }

        public PackageInfo getCurrentWebViewPackage() {
            PackageInfo currentWebViewPackage = WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).getCurrentWebViewPackage();
            if (currentWebViewPackage == null) goto L5;
            grantVisibilityToCaller(currentWebViewPackage.packageName, Binder.getCallingUid());
        L5:
            return currentWebViewPackage;
        }

        protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
            if (DumpUtils.checkDumpPermission(this.this$0.getContext(), WebViewUpdateService.TAG, pw) == true) goto L5;
            return;
        L5:
            WebViewUpdateService.m9582$$Nest$fgetmImpl(this.this$0).dumpState(pw);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmImpl, reason: not valid java name */
    static /* bridge */ /* synthetic */ WebViewUpdateServiceImpl2 m9582$$Nest$fgetmImpl(WebViewUpdateService r0) {
        return r0.mImpl;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsAppWaitingForRelroCompletionDelay, reason: not valid java name */
    static /* bridge */ /* synthetic */ Histogram m9583$$Nest$sfgetsAppWaitingForRelroCompletionDelay() {
        return sAppWaitingForRelroCompletionDelay;
    }

    /* JADX INFO: renamed from: -$$Nest$smpackageNameFromIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m9584$$Nest$smpackageNameFromIntent(Intent r0) {
        return packageNameFromIntent(r0);
    }

    static {
        sPrepareWebViewInSystemServerLatency = new Histogram("webview.value_prepare_webview_in_system_server_latency", new Histogram.ScaledRangeOptions(20, 0, 1.0f, 1.5f));
        sAppWaitingForRelroCompletionDelay = new Histogram("webview.value_app_waiting_for_relro_completion_delay", new Histogram.ScaledRangeOptions(20, 0, 1.0f, 1.4f));
    }

    public WebViewUpdateService(Context context) {
        super(context);
        this.mImpl = new WebViewUpdateServiceImpl2(new SystemImpl(context));
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        this.mWebViewUpdatedReceiver = new AnonymousClass1(this);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        WebViewProviderInfo[] r0 = this.mImpl.getWebViewPackages();
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        WebViewProviderInfo provider = r0[r3];
        filter.addDataSchemeSpecificPart(provider.packageName, 0);
        r3 = r3 + 1;
        goto L3
    L5:
        getContext().registerReceiverAsUser(this.mWebViewUpdatedReceiver, UserHandle.ALL, filter, null, null);
        IntentFilter userAddedFilter = new IntentFilter();
        userAddedFilter.addAction("android.intent.action.USER_STARTED");
        userAddedFilter.addAction("android.intent.action.USER_REMOVED");
        getContext().registerReceiverAsUser(this.mWebViewUpdatedReceiver, UserHandle.ALL, userAddedFilter, null, null);
        publishBinderService("webviewupdate", new BinderService(this, null), true);
    }

    public void prepareWebViewInSystemServer() {
        long currentTimeMs = SystemClock.uptimeMillis();
        this.mImpl.prepareWebViewInSystemServer();
        sPrepareWebViewInSystemServerLatency.logSample(SystemClock.uptimeMillis() - currentTimeMs);
    }

    private static String packageNameFromIntent(Intent intent) {
        return intent.getDataString().substring("package:".length());
    }

    public static boolean entirePackageChanged(Intent intent) {
        String[] componentList = intent.getStringArrayExtra("android.intent.extra.changed_component_name_list");
        return Arrays.asList(componentList).contains(intent.getDataString().substring("package:".length()));
    }
}
