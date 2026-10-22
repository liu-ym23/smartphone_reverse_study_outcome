package androidx.core.content;

import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.AlarmManager;
import android.app.AppOpsManager;
import android.app.DownloadManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.app.SearchManager;
import android.app.UiModeManager;
import android.app.WallpaperManager;
import android.app.admin.DevicePolicyManager;
import android.app.job.JobScheduler;
import android.app.usage.UsageStatsManager;
import android.appwidget.AppWidgetManager;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.content.pm.LauncherApps;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.hardware.ConsumerIrManager;
import android.hardware.SensorManager;
import android.hardware.camera2.CameraManager;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.hardware.usb.UsbManager;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.MediaRouter;
import android.media.projection.MediaProjectionManager;
import android.media.session.MediaSessionManager;
import android.media.tv.TvInputManager;
import android.net.ConnectivityManager;
import android.net.nsd.NsdManager;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.nfc.NfcManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.DropBoxManager;
import android.os.Handler;
import android.os.PowerManager;
import android.os.Process;
import android.os.UserManager;
import android.os.Vibrator;
import android.os.storage.StorageManager;
import android.print.PrintManager;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.annotation.ReplaceWith;
import androidx.core.app.LocaleManagerCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.ConfigurationCompat;
import androidx.core.os.ExecutorCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.core.opt.res.NewMiraResourcesManager;
import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import java.io.File;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Executor;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    public static final int RECEIVER_EXPORTED = 2;
    public static final int RECEIVER_NOT_EXPORTED = 4;
    public static final int RECEIVER_VISIBLE_TO_INSTANT_APPS = 1;
    private static final String TAG = "ContextCompat";
    private static final Object sSync = null;

    public static class Api21Impl {
        private Api21Impl() {
        }

        public static File getCodeCacheDir(Context r100) {
            return r100.getCodeCacheDir();
        }

        public static File getNoBackupFilesDir(Context r100) {
            return r100.getNoBackupFilesDir();
        }

        public static Drawable getDrawable(Context r100, int r101) {
            return r100.getDrawable(r101);
        }
    }

    public static class Api23Impl {
        private Api23Impl() {
        }

        public static int getColor(Context r100, int r101) {
            return r100.getColor(r101);
        }

        public static <T> T getSystemService(Context r100, Class<T> r101) {
            return (T) r100.getSystemService(r101);
        }

        public static String getSystemServiceName(Context r100, Class<?> r101) {
            return r100.getSystemServiceName(r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static Context createDeviceProtectedStorageContext(Context r100) {
            return r100.createDeviceProtectedStorageContext();
        }

        public static File getDataDir(Context r100) {
            return r100.getDataDir();
        }

        public static boolean isDeviceProtectedStorage(Context r100) {
            return r100.isDeviceProtectedStorage();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static ComponentName startForegroundService(Context r100, Intent r101) {
            return r100.startForegroundService(r101);
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L32:
        L26:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
            throw e;
        L30:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
            int r103 = r102.result;     // Catch: Exception -> L26
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110, r111, r112);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110, r111, r112);
        L25:
            return r100.registerReceiver(r101, r110, r111, r112);
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, int r113) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L32:
        L26:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
            throw e;
        L30:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112, r113);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r113, r111, r112, 5, r100);     // Catch: Exception -> L26
            int r103 = r102.result;     // Catch: Exception -> L26
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        L25:
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        }

        public static Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r110, int r111) {
            if ((r111 & 4) == 0) goto L8;
            if (r103 != null) goto L8;
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, ContextCompat.obtainAndCheckReceiverPermission(r100), r110);
        L8:
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api26Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r110, r111 & 1);
        }
    }

    public static class Api28Impl {
        private Api28Impl() {
        }

        public static Executor getMainExecutor(Context r100) {
            return r100.getMainExecutor();
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class Api30Impl {
        private Api30Impl() {
        }

        public static String getAttributionTag(Context r100) {
            return r100.getAttributionTag();
        }

        public static Display getDisplayOrDefault(Context r100) {
            return r100.getDisplay();
        L4:
            Objects.toString(r100);
            return ((DisplayManager) r100.getSystemService(DisplayManager.class)).getDisplay(0);
        }

        public static Context createAttributionContext(Context r100, String r101) {
            return r100.createAttributionContext(r101);
        }
    }

    public static class Api33Impl {
        private Api33Impl() {
        }

        @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
        public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api33Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112, int r113) {
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
            ReceiverRegisterCrashOptimizer.doHWReceiverFix();
        L32:
        L26:
            e = move-exception;
            e.toString();
            e.printStackTrace();
            if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
            throw e;
        L30:
            return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112, r113);
        L6:
            if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
            if (r110 == null) goto L25;
            if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
            ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, r113, r111, r112, 5, r100);     // Catch: Exception -> L26
            int r103 = r102.result;     // Catch: Exception -> L26
            if (r103 == 1) goto L23;
            if (r103 == 2) goto L21;
            if (r103 == 3) goto L19;
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        L19:
            return r102.intent;
        L21:
            return new Intent();
        L23:
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        L25:
            return r100.registerReceiver(r101, r110, r111, r112, r113);
        }

        public static Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r104, int r105) {
            return INVOKEVIRTUAL_androidx_core_content_ContextCompat$Api33Impl_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r104, r105);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class LegacyServiceMapHolder {
        static final HashMap<Class<?>, String> SERVICES = null;

        private LegacyServiceMapHolder() {
        }

        static {
            HashMap<Class<?>, String> r100 = new HashMap();
            SERVICES = r100;
            if (Build.VERSION.SDK_INT < 22) goto L5;
            r100.put(SubscriptionManager.class, "telephony_subscription_service");
            r100.put(UsageStatsManager.class, "usagestats");
        L5:
            r100.put(AppWidgetManager.class, "appwidget");
            r100.put(BatteryManager.class, "batterymanager");
            r100.put(CameraManager.class, "camera");
            r100.put(JobScheduler.class, "jobscheduler");
            r100.put(LauncherApps.class, "launcherapps");
            r100.put(MediaProjectionManager.class, "media_projection");
            r100.put(MediaSessionManager.class, "media_session");
            r100.put(RestrictionsManager.class, "restrictions");
            r100.put(TelecomManager.class, OnekeyLoginConstants.TELECOM);
            r100.put(TvInputManager.class, "tv_input");
            r100.put(AppOpsManager.class, "appops");
            r100.put(CaptioningManager.class, "captioning");
            r100.put(ConsumerIrManager.class, "consumer_ir");
            r100.put(PrintManager.class, "print");
            r100.put(BluetoothManager.class, "bluetooth");
            r100.put(DisplayManager.class, "display");
            r100.put(UserManager.class, "user");
            r100.put(InputManager.class, "input");
            r100.put(MediaRouter.class, "media_router");
            r100.put(NsdManager.class, "servicediscovery");
            r100.put(AccessibilityManager.class, "accessibility");
            r100.put(AccountManager.class, "account");
            r100.put(ActivityManager.class, "activity");
            r100.put(AlarmManager.class, "alarm");
            r100.put(AudioManager.class, "audio");
            r100.put(ClipboardManager.class, DataType.CLIPBOARD);
            r100.put(ConnectivityManager.class, "connectivity");
            r100.put(DevicePolicyManager.class, "device_policy");
            r100.put(DownloadManager.class, "download");
            r100.put(DropBoxManager.class, "dropbox");
            r100.put(InputMethodManager.class, "input_method");
            r100.put(KeyguardManager.class, "keyguard");
            r100.put(LayoutInflater.class, "layout_inflater");
            r100.put(LocationManager.class, "location");
            r100.put(NfcManager.class, "nfc");
            r100.put(NotificationManager.class, "notification");
            r100.put(PowerManager.class, BatteryTypeInf.BATTERY_POWER_LOCK);
            r100.put(SearchManager.class, "search");
            r100.put(SensorManager.class, faceverify.w.BLOB_ELEM_TYPE_SENSOR);
            r100.put(StorageManager.class, "storage");
            r100.put(TelephonyManager.class, "phone");
            r100.put(TextServicesManager.class, "textservices");
            r100.put(UiModeManager.class, "uimode");
            r100.put(UsbManager.class, "usb");
            r100.put(Vibrator.class, "vibrator");
            r100.put(WallpaperManager.class, "wallpaper");
            r100.put(WifiP2pManager.class, "wifip2p");
            r100.put(WifiManager.class, "wifi");
            r100.put(WindowManager.class, LiveEndPageData.TAG_WINDOW);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterReceiverFlags {
    }

    static {
        sSync = new Object();
    }

    public ContextCompat() {
    }

    public static Context createDeviceProtectedStorageContext(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return null;
    L5:
        return Api24Impl.createDeviceProtectedStorageContext(r100);
    }

    private static File createFilesDir(File r100) {
        Object r101 = sSync;
        monitor-enter(r101);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (r100.exists() == false) goto L7;
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r100;
    L7:
        if (r100.mkdirs() == false) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L13
        return r100;
    L10:
        r100.getPath();     // Catch: Throwable -> L13
        goto L11
    }

    public static String getAttributionTag(Context r100) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return null;
    L5:
        return Api30Impl.getAttributionTag(r100);
    }

    public static File getCodeCacheDir(Context r100) {
        return Api21Impl.getCodeCacheDir(r100);
    }

    public static Context getContextForLanguage(Context r100) {
        LocaleListCompat r101 = LocaleManagerCompat.getApplicationLocales(r100);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r100;
    L5:
        if (r101.isEmpty() == true) goto L9;
        Configuration r102 = new Configuration(r100.getResources().getConfiguration());
        ConfigurationCompat.setLocales(r102, r101);
        Context r103 = r100.createConfigurationContext(r102);
        NewMiraResourcesManager.getInstance().install(r103);
        return r103;
    L9:
        return r100;
    }

    public static File getDataDir(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        String r101 = r100.getApplicationInfo().dataDir;
        if (r101 != null) goto L11;
        return null;
    L11:
        return new File(r101);
    L5:
        return Api24Impl.getDataDir(r100);
    }

    public static Display getDisplayOrDefault(Context r100) {
        if (Build.VERSION.SDK_INT < 30) goto L7;
        return Api30Impl.getDisplayOrDefault(r100);
    L7:
        return ((WindowManager) r100.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay();
    }

    @ReplaceWith(expression = "context.getExternalCacheDirs()")
    public static File[] getExternalCacheDirs(Context r100) {
        return r100.getExternalCacheDirs();
    }

    public static Executor getMainExecutor(Context r100) {
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return Api28Impl.getMainExecutor(r100);
    L7:
        return ExecutorCompat.create(new Handler(r100.getMainLooper()));
    }

    public static File getNoBackupFilesDir(Context r100) {
        return Api21Impl.getNoBackupFilesDir(r100);
    }

    @ReplaceWith(expression = "context.getObbDirs()")
    public static File[] getObbDirs(Context r100) {
        return r100.getObbDirs();
    }

    public static boolean isDeviceProtectedStorage(Context r100) {
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        return false;
    L5:
        return Api24Impl.isDeviceProtectedStorage(r100);
    }

    public static String obtainAndCheckReceiverPermission(Context r100) {
        String r101 = r100.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(r100, r101) != 0) goto L6;
        return r101;
    L6:
        throw new RuntimeException("Permission " + r101 + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static int checkSelfPermission(Context r100, String r101) {
        ObjectsCompat.requireNonNull(r101, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r101) == false) goto L12;
        if (NotificationManagerCompat.from(r100).areNotificationsEnabled() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return androidx_core_content_ContextCompat_android_content_Context_checkPermission(r100, r101, Process.myPid(), Process.myUid());
    }

    public static Context createAttributionContext(Context r100, String r101) {
        if (Build.VERSION.SDK_INT >= 30) goto L5;
        return r100;
    L5:
        return Api30Impl.createAttributionContext(r100, r101);
    }

    public static int getColor(Context r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getColor(r100, r101);
    L7:
        return r100.getResources().getColor(r101);
    }

    public static ColorStateList getColorStateList(Context r100, int r101) {
        return ResourcesCompat.getColorStateList(r100.getResources(), r101, r100.getTheme());
    }

    public static Drawable getDrawable(Context r100, int r101) {
        return Api21Impl.getDrawable(r100, r101);
    }

    @ReplaceWith(expression = "context.getExternalFilesDirs(type)")
    public static File[] getExternalFilesDirs(Context r100, String r101) {
        return r100.getExternalFilesDirs(r101);
    }

    public static String getString(Context r100, int r101) {
        return getContextForLanguage(r100).getString(r101);
    }

    public static <T> T getSystemService(Context r100, Class<T> r101) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r102 = getSystemServiceName(r100, r101);
        if (r102 != null) goto L11;
        return null;
    L11:
        return (T) r100.getSystemService(r102);
    L5:
        return (T) Api23Impl.getSystemService(r100, r101);
    }

    public static String getSystemServiceName(Context r100, Class<?> r101) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return Api23Impl.getSystemServiceName(r100, r101);
    L7:
        return LegacyServiceMapHolder.SERVICES.get(r101);
    }

    public static boolean startActivities(Context r100, Intent[] r101) {
        return startActivities(r100, r101, null);
    }

    public static void startForegroundService(Context r100, Intent r101) {
        if (Build.VERSION.SDK_INT < 26) goto L5;
        Api26Impl.startForegroundService(r100, r101);
        return;
    L5:
        r100.startService(r101);
    }

    public static boolean startActivities(Context r100, Intent[] r101, Bundle r102) {
        r100.startActivities(r101, r102);
        return true;
    }

    @ReplaceWith(expression = "context.startActivity(intent, options)")
    public static void startActivity(Context r100, Intent r101, Bundle r102) {
        r100.startActivity(r101, r102);
    }

    private static int androidx_core_content_ContextCompat_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_androidx_core_content_ContextCompat_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, int r103) {
        return registerReceiver(r100, r101, r102, null, null, r103);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110, String r111, Handler r112) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L32;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L32:
    L26:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L30;
        throw e;
    L30:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110, r111, r112);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, r111, r112, 4, r100);     // Catch: Exception -> L26
        int r103 = r102.result;     // Catch: Exception -> L26
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110, r111, r112);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110, r111, r112);
    L25:
        return r100.registerReceiver(r101, r110, r111, r112);
    }

    public static Intent registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r102, String r103, Handler r110, int r111) {
        int r104 = r111 & 1;
        if (r104 != 0) goto L5;
    L9:
        if (r104 == 0) goto L11;
        r111 = r111 | 2;
    L11:
        int r105 = r111;
        int r112 = r105 & 2;
        if (r112 == 0) goto L14;
    L18:
        if (r112 != 0) goto L20;
    L24:
        int r113 = Build.VERSION.SDK_INT;
        if (r113 < 33) goto L29;
        return Api33Impl.registerReceiver(r100, r101, r102, r103, r110, r105);
    L29:
        if (r113 < 26) goto L33;
        return Api26Impl.registerReceiver(r100, r101, r102, r103, r110, r105);
    L33:
        if ((r105 & 4) == 0) goto L38;
        if (r103 != null) goto L38;
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, obtainAndCheckReceiverPermission(r100), r110);
    L38:
        return INVOKEVIRTUAL_androidx_core_content_ContextCompat_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r100, r101, r102, r103, r110);
    L20:
        if ((r105 & 4) == 0) goto L24;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L14:
        if ((r105 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r111 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }
}
