package android.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.StepOSCtsUtils;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public final class CtaPackageLists {
    private static final String TAG = "CtaPackageLists";
    private static final boolean DEBUG = Log.isLoggable(TAG, 3);
    private static final String[] CONTROLLER_APPS = {"com.stepos.bys", "com.android.bips", "com.unionpay.tsmservice", "com.stepos.feedback", "com.stepos.find", "com.stepos.scanner", "com.stepos.bxcamera", "com.stepos.net.pedometer", "com.stepos.todolist", "com.stepos.account.pay", "com.android.alarmclock", "com.android.providers.downloads", "com.stepos.filemanager", "com.android.browser", "com.stepos.directservice", "com.android.soundrecorder", "com.stepos.media.camera", "com.stepos.mstore", "com.stepos.net.search", "com.stepos.picker", "com.stepos.familyguard", "com.stepos.notepaper", "com.stepos.calculator", "com.android.calendar", "com.stepos.toolbox", "com.stepos.gamecenter.service", "com.stepos.media.music", "com.stepos.media.video", "com.stepos.media.gallery", "com.stepos.mcare", "com.stepos.share", "com.stepos.store", "com.stepos.datamigration", "com.android.email", "com.stepos.customizecenter", "com.stepos.lab", "com.stepos.gamecenter", "com.sohu.inputmethod.sogou.oem", "com.stepos.weather", "com.stepos.measure", "com.android.mms", "com.stepos.media.reader", "com.stepos.videoclips", "com.stepos.smarthome", "com.upuphone.star.launcher", "com.stepos.aod", "com.stepos.safe", "com.stepos.smartcard", "com.stepos.callagent", "com.stepos.agentruntime", "com.stepos.earphone", "com.stepos.ailauncher", "com.stepos.agentsafetycenter", "com.stepos.common.ability.proxy", "com.stepos.xmscore"};
    private static final String[] GMS_APPS = {"com.android.vending", "com.android.chrome", "com.google.android.apps.messaging", "com.google.android.googlequicksearchbox", "com.google.android.gm", "com.google.android.apps.maps", "com.google.android.youtube", "com.google.android.apps.docs", "com.google.android.apps.youtube.music", "com.google.android.videos", "com.google.android.apps.tachyon", "com.google.android.apps.photos", "com.google.android.apps.safetyhub", "com.google.android.calendar", "com.google.android.apps.chromecast.app", "com.google.android.apps.subscriptions.red", "com.google.android.apps.nbu.paisa.user", "com.google.android.projection.gearhead", "com.google.android.apps.wellbeing", "com.google.android.documentsui", "com.google.android.inputmethod.latin", "com.google.android.cellbroadcastreceiver"};
    private static final String[] NEED_SETTINGS_SHOW_PERMISSION_APPS = {"com.android.dialer"};
    private static final List<String> EXPOSE_INSTALL_PKG_PERMISSION_PKGS = Collections.unmodifiableList(Arrays.asList("com.stepos.media.reader", "com.stepos.videoclips"));
    private static final Set<String> FAMILY_GUARD_APPS_SET = Collections.unmodifiableSet(new HashSet(Arrays.asList("com.stepos.familyguard")));
    private static final Set<String> CONTROLLER_APPS_SET = new HashSet(Arrays.asList(CONTROLLER_APPS));
    private static final Set<String> GMS_APPS_SET = new HashSet(Arrays.asList(GMS_APPS));
    private static final Set<String> NEED_SETTINGS_SHOW_PERMISSION_APPS_SET = new HashSet(Arrays.asList(NEED_SETTINGS_SHOW_PERMISSION_APPS));
    private static final Set<String> HAS_LAUNCH_SYSTEM_APPS = Collections.synchronizedSet(new HashSet());

    private CtaPackageLists() {
    }

    public static void registerLaunchSystemAppCollector() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BOOT_COMPLETED");
        Context context = ActivityThread.currentApplication().getApplicationContext();
        context.registerReceiver(new BroadcastReceiver() { // from class: android.app.CtaPackageLists.1
            /* JADX WARN: Type inference failed for: r0v0, types: [android.app.CtaPackageLists$1$1] */
            @Override // android.content.BroadcastReceiver
            public void onReceive(final Context ctx, Intent intent) {
                new Thread(this, "launch-systemapp") { // from class: android.app.CtaPackageLists.1.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() throws PackageManager.NameNotFoundException {
                        try {
                            Intent probe = new Intent();
                            probe.addCategory("android.intent.category.LAUNCHER");
                            probe.setAction("android.intent.action.MAIN");
                            PackageManager pm = ctx.getPackageManager();
                            List<ResolveInfo> infos = pm.queryIntentActivities(probe, 0);
                            for (ResolveInfo ri : infos) {
                                try {
                                    ApplicationInfo ai = pm.getApplicationInfo(ri.activityInfo.packageName, 0);
                                    if ((ai.flags & 129) != 0) {
                                        CtaPackageLists.HAS_LAUNCH_SYSTEM_APPS.add(ri.activityInfo.packageName);
                                    }
                                } catch (PackageManager.NameNotFoundException e) {
                                }
                            }
                        } catch (Exception e2) {
                        }
                    }
                }.start();
            }
        }, filter);
    }

    public static boolean hasLaunchSystemApp(String pkg) {
        if ("android".equals(pkg)) {
            return false;
        }
        return HAS_LAUNCH_SYSTEM_APPS.contains(pkg);
    }

    public static boolean isSystemSignatures(String packageName) {
        PackageManager pm = ActivityThread.currentApplication().getPackageManager();
        return pm.checkSignatures(packageName, "android") == 0;
    }

    public static boolean isSystemApp(String packageName) throws PackageManager.NameNotFoundException {
        if (StepOSCtsUtils.isCtsRunning() || "android".equals(packageName)) {
            return true;
        }
        try {
            ApplicationInfo info = ActivityThread.currentApplication().getPackageManager().getApplicationInfo(packageName, 0);
            return (info.flags & 129) != 0;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isSystemAppByUid(int uid) throws PackageManager.NameNotFoundException {
        ApplicationInfo info;
        PackageManager pm = ActivityThread.currentApplication().getPackageManager();
        String[] pkgs = pm.getPackagesForUid(uid);
        if (pkgs == null) {
            return false;
        }
        for (String pkg : pkgs) {
            try {
                info = pm.getApplicationInfo(pkg, 0);
            } catch (PackageManager.NameNotFoundException e) {
            }
            if ((info.flags & 129) != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLegacyApp(String packageName) throws PackageManager.NameNotFoundException {
        Context context = ActivityThread.currentApplication().getApplicationContext();
        try {
            ApplicationInfo info = context.getPackageManager().getApplicationInfo(packageName, 0);
            AppOpsManager aom = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            if (info.targetSdkVersion >= 29 && aom.checkOpNoThrow(87, info.uid, packageName) != 0) {
                return false;
            }
            if (DEBUG) {
                Log.d(TAG, "isLegacyApp: " + packageName);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.d(TAG, "isLegacyApp lookup failed: " + packageName, e);
            }
            return true;
        }
    }

    public static boolean isLegacyAppRequestMedia(String packageName) throws PackageManager.NameNotFoundException {
        Context context = ActivityThread.currentApplication().getApplicationContext();
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 4096);
            AppOpsManager aom = (AppOpsManager) context.getSystemService(AppOpsManager.class);
            if (info.applicationInfo.targetSdkVersion >= 29 && aom.checkOpNoThrow(87, info.applicationInfo.uid, packageName) == 0 && info.requestedPermissions != null) {
                for (String perm : info.requestedPermissions) {
                    if ("android.permission.ACCESS_MEDIA_LOCATION".equals(perm)) {
                        if (DEBUG) {
                            Log.d(TAG, "targetSdk>=Q and Legacy Media: " + packageName);
                            return true;
                        }
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (DEBUG) {
                Log.d(TAG, "isLegacyAppRequestMedia lookup failed: " + packageName, e);
            }
        }
        return false;
    }

    public static boolean needShowSensitiveNotice(String pkg) {
        return CONTROLLER_APPS_SET.contains(pkg);
    }

    public static boolean isControlApps(String pkg) {
        if (CONTROLLER_APPS_SET.contains(pkg)) {
            return true;
        }
        Context context = ActivityThread.currentApplication().getApplicationContext();
        return context.getPackageManager().getLaunchIntentForPackage(pkg) != null;
    }

    public static boolean isGMSApps(String pkg) {
        return GMS_APPS_SET.contains(pkg);
    }

    public static boolean isFamilyGuardPackage(String packageName) {
        return packageName != null && FAMILY_GUARD_APPS_SET.contains(packageName);
    }

    public static boolean isNeedShowPermissionManagementApps(String pkg) {
        return NEED_SETTINGS_SHOW_PERMISSION_APPS_SET.contains(pkg);
    }

    public static List<String> getExposeInstallPkgPermissionPkgsList() {
        return new ArrayList(EXPOSE_INSTALL_PKG_PERMISSION_PKGS);
    }

    public static boolean isExposeSystemAppAppListPermission(String packageName, int privilege) {
        if (privilege == 56 || privilege == 107) {
            return EXPOSE_INSTALL_PKG_PERMISSION_PKGS.contains(packageName);
        }
        return false;
    }

    public static boolean isSysAppSpecificPerm(String packageName, int op) {
        if (TextUtils.equals(packageName, "com.android.email") && op == 4) {
            return true;
        }
        if (TextUtils.equals(packageName, "com.android.dialer") && (op == 4 || op == 5 || op == 6)) {
            return true;
        }
        if (TextUtils.equals(packageName, "com.android.calendar") && (op == 8 || op == 9)) {
            return true;
        }
        if (TextUtils.equals(packageName, "com.stepos.filemanager") && (op == 59 || op == 60)) {
            return true;
        }
        if (TextUtils.equals(packageName, "com.android.mms")) {
            return op == 4 || op == 20 || op == 14 || op == 15;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean sysAppConfigPerm(java.lang.String r17, int r18) {
        /*
            Method dump skipped, instructions count: 652
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.app.CtaPackageLists.sysAppConfigPerm(java.lang.String, int):boolean");
    }
}
