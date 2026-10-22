package com.android.server.am;

import android.R;
import android.app.BroadcastOptions;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Binder;
import android.os.BugreportManager;
import android.os.BugreportParams;
import android.os.UserHandle;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.Slog;
import com.android.server.SystemConfig;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class BugReportHandlerUtil {
    private static final String INTENT_BUGREPORT_REQUESTED = "com.android.internal.intent.action.BUGREPORT_REQUESTED";
    private static final String INTENT_GET_BUGREPORT_HANDLER_RESPONSE = "com.android.internal.intent.action.GET_BUGREPORT_HANDLER_RESPONSE";
    private static final String SHELL_APP_PACKAGE = "com.android.shell";
    private static final String TAG = "ActivityManager";

    private static class BugreportHandlerResponseBroadcastReceiver extends BroadcastReceiver {
        private final String handlerApp;
        private final int handlerUser;

        BugreportHandlerResponseBroadcastReceiver(String handlerApp, int handlerUser) {
            this.handlerApp = handlerApp;
            this.handlerUser = handlerUser;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (getResultCode() != (-1)) goto L6;
            BugReportHandlerUtil.m1443$$Nest$smlaunchBugReportHandlerApp(context, this.handlerApp, this.handlerUser);
            return;
        L6:
            Slog.w(BugReportHandlerUtil.TAG, "Request bug report because no response from handler app.");
            BugreportManager bugreportManager = (BugreportManager) context.getSystemService(BugreportManager.class);
            bugreportManager.requestBugreport(new BugreportParams(1), null, null);
        }
    }

    /* JADX INFO: renamed from: -$$Nest$smlaunchBugReportHandlerApp, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m1443$$Nest$smlaunchBugReportHandlerApp(Context r0, String r1, int r2) {
        launchBugReportHandlerApp(r0, r1, r2);
    }

    public BugReportHandlerUtil() {
    }

    static boolean isBugReportHandlerEnabled(Context context) {
        return context.getResources().getBoolean(R.bool.config_callNotificationActionColorsRequireColorized);
    }

    static boolean launchBugReportHandlerApp(Context userContext) {
        if (isBugReportHandlerEnabled(userContext) == true) goto L5;
        return false;
    L5:
        String handlerApp = getCustomBugReportHandlerApp(userContext);
        if (isShellApp(handlerApp) == false) goto L8;
        return false;
    L8:
        int handlerUser = getCustomBugReportHandlerUser(userContext);
        if (isValidBugReportHandlerApp(handlerApp) == true) goto L12;
        String handlerApp2 = getDefaultBugReportHandlerApp(userContext);
        int handlerUser2 = userContext.getUserId();
    L16:
        if (isShellApp(handlerApp2) == true) goto L49;
        if (isValidBugReportHandlerApp(handlerApp2) == false) goto L49;
        if (getBugReportHandlerAppReceivers(userContext, handlerApp2, handlerUser2).isEmpty() == false) goto L23;
        return false;
    L23:
        if (getBugReportHandlerAppResponseReceivers(userContext, handlerApp2, handlerUser2).isEmpty() == false) goto L26;
        launchBugReportHandlerApp(userContext, handlerApp2, handlerUser2);
        return true;
    L26:
        Slog.i(TAG, "Getting response from bug report handler app: " + handlerApp2);
        Intent intent = new Intent(INTENT_GET_BUGREPORT_HANDLER_RESPONSE);
        intent.setPackage(handlerApp2);
        intent.addFlags(268435456);
        intent.addFlags(16777216);
        long identity = Binder.clearCallingIdentity();
        UserHandle r3 = UserHandle.of(handlerUser2);     // Catch: Throwable -> L34 RuntimeException -> L40
        BugreportHandlerResponseBroadcastReceiver r7 = new BugreportHandlerResponseBroadcastReceiver(handlerApp2, handlerUser2);     // Catch: Throwable -> L34 RuntimeException -> L38
        String r12 = TAG;
        userContext.sendOrderedBroadcastAsUser(intent, r3, "android.permission.DUMP", -1, null, r7, null, 0, null, null);     // Catch: Throwable -> L34 RuntimeException -> L36
        Binder.restoreCallingIdentity(identity);
        return true;
    L36:
        e = e;
    L43:
        Slog.e(r12, "Error while trying to get response from bug report handler app.", e);     // Catch: Throwable -> L34
        Binder.restoreCallingIdentity(identity);
        return 0;
    L38:
        e = e;
        r12 = TAG;
    L34:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L40:
        e = e;
        r12 = TAG;
    L49:
        return false;
    L12:
        if (getBugReportHandlerAppReceivers(userContext, handlerApp, handlerUser).isEmpty() == false) goto L14;
        String handlerApp3 = getDefaultBugReportHandlerApp(userContext);
        int handlerUser3 = userContext.getUserId();
        resetCustomBugreportHandlerAppAndUser(userContext);
        handlerApp2 = handlerApp3;
        handlerUser2 = handlerUser3;
        goto L16
    L14:
        handlerApp2 = handlerApp;
        handlerUser2 = handlerUser;
        goto L16
    }

    private static void launchBugReportHandlerApp(Context context, String handlerApp, int handlerUser) {
        Slog.i(TAG, "Launching bug report handler app: " + handlerApp);
        Intent intent = new Intent(INTENT_BUGREPORT_REQUESTED);
        intent.setPackage(handlerApp);
        intent.addFlags(268435456);
        intent.addFlags(16777216);
        BroadcastOptions options = BroadcastOptions.makeBasic();
        options.setBackgroundActivityStartsAllowed(true);
        long identity = Binder.clearCallingIdentity();
        context.sendBroadcastAsUser(intent, UserHandle.of(handlerUser), "android.permission.DUMP", options.toBundle());     // Catch: Throwable -> L5 RuntimeException -> L7
    L4:
        Binder.restoreCallingIdentity(identity);
        return;
    L5:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error while trying to launch bugreport handler app.", e);     // Catch: Throwable -> L5
        goto L4
    }

    private static String getCustomBugReportHandlerApp(Context context) {
        return Settings.Secure.getStringForUser(context.getContentResolver(), "custom_bugreport_handler_app", context.getUserId());
    }

    private static int getCustomBugReportHandlerUser(Context context) {
        return Settings.Secure.getIntForUser(context.getContentResolver(), "custom_bugreport_handler_user", ProcessList.INVALID_ADJ, context.getUserId());
    }

    private static boolean isShellApp(String app) {
        return "com.android.shell".equals(app);
    }

    private static boolean isValidBugReportHandlerApp(String app) {
        if (TextUtils.isEmpty(app) == false) goto L5;
    L7:
        return false;
    L5:
        if (isBugreportWhitelistedApp(app) == false) goto L7;
        return true;
    }

    private static boolean isBugreportWhitelistedApp(String app) {
        ArraySet<String> whitelistedApps = SystemConfig.getInstance().getBugreportWhitelistedPackages();
        return whitelistedApps.contains(app);
    }

    private static List<ResolveInfo> getBugReportHandlerAppReceivers(Context context, String handlerApp, int handlerUser) {
        Intent intent = new Intent(INTENT_BUGREPORT_REQUESTED);
        intent.setPackage(handlerApp);
        return context.getPackageManager().queryBroadcastReceiversAsUser(intent, 1048576, handlerUser);
    }

    private static List<ResolveInfo> getBugReportHandlerAppResponseReceivers(Context context, String handlerApp, int handlerUser) {
        Intent intent = new Intent(INTENT_GET_BUGREPORT_HANDLER_RESPONSE);
        intent.setPackage(handlerApp);
        return context.getPackageManager().queryBroadcastReceiversAsUser(intent, 1048576, handlerUser);
    }

    private static String getDefaultBugReportHandlerApp(Context context) {
        return context.getResources().getString(R.string.config_deviceSpecificDisplayAreaPolicyProvider);
    }

    private static void resetCustomBugreportHandlerAppAndUser(Context context) {
        long identity = Binder.clearCallingIdentity();
        Settings.Secure.putString(context.getContentResolver(), "custom_bugreport_handler_app", getDefaultBugReportHandlerApp(context));     // Catch: Throwable -> L6
        Settings.Secure.putInt(context.getContentResolver(), "custom_bugreport_handler_user", context.getUserId());     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
