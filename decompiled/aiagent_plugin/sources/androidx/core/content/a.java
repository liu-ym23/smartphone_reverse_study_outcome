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
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.CaptioningManager;
import android.view.inputmethod.InputMethodManager;
import android.view.textservice.TextServicesManager;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.crash.dumper.Scraps;
import com.obric.aiagent.assistant.idl.IFlowAppIntentIDL;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: ContextCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String TAG = "ContextCompat";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f1145a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f1146b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static TypedValue f1147c;

    /* JADX INFO: renamed from: androidx.core.content.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ContextCompat.java */
    static class C0024a {
        static void a(Context r2, Intent[] r3, Bundle r4) {
            ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).startActivities(r3, r4);
        }

        static void startActivity(Context r2, Intent r3, Bundle r4) {
            ZeusTransformUtils.startActivity((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, r4, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class b {
        static Context a(Context r2, Configuration r3) {
            return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).createConfigurationContext(r3), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class c {
        static File[] a(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getExternalCacheDirs();
        }

        static File[] a(Context r2, String r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getExternalFilesDirs(r3);
        }

        static File[] b(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getObbDirs();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class d {
        static Drawable a(Context r2, int r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getDrawable(r3);
        }

        static File a(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getNoBackupFilesDir();
        }

        static File b(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getCodeCacheDir();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class e {
        static int a(Context r2, int r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getColor(r3);
        }

        static <T> T a(Context r2, Class<T> r3) {
            return (T) ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemService(r3);
        }

        static String b(Context r2, Class<?> r3) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getSystemServiceName(r3);
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class f {
        static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
            Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
            if ((r12 & 4) == 0) goto L8;
            if (r10 != null) goto L8;
            return ZeusTransformUtils.registerReceiver(r0, r8, r9, a.d(r0), r11, "com.obric.aiagent.plugin");
        L8:
            return ZeusTransformUtils.registerReceiver(r0, r8, r9, r10, r11, r12 & 1, "com.obric.aiagent.plugin");
        }

        static ComponentName a(Context r2, Intent r3) {
            return ZeusTransformUtils.startService((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class g {
        static Executor a(Context r2) {
            return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getMainExecutor();
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    static class h {
        static Intent registerReceiver(Context r7, PluginBroadcastReceiver r8, IntentFilter r9, String r10, Handler r11, int r12) {
            return ZeusTransformUtils.registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin"), r8, r9, r10, r11, r12, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: ContextCompat.java */
    private static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<Class<?>, String> f1148a = null;

        static {
            HashMap<Class<?>, String> r0 = new HashMap();
            f1148a = r0;
            if (Build.VERSION.SDK_INT < 22) goto L6;
            r0.put(SubscriptionManager.class, "telephony_subscription_service");
            r0.put(UsageStatsManager.class, "usagestats");
        L6:
            if (Build.VERSION.SDK_INT < 21) goto L9;
            r0.put(AppWidgetManager.class, "appwidget");
            r0.put(BatteryManager.class, "batterymanager");
            r0.put(CameraManager.class, "camera");
            r0.put(JobScheduler.class, "jobscheduler");
            r0.put(LauncherApps.class, "launcherapps");
            r0.put(MediaProjectionManager.class, "media_projection");
            r0.put(MediaSessionManager.class, "media_session");
            r0.put(RestrictionsManager.class, "restrictions");
            r0.put(TelecomManager.class, "telecom");
            r0.put(TvInputManager.class, "tv_input");
        L9:
            if (Build.VERSION.SDK_INT < 19) goto L12;
            r0.put(AppOpsManager.class, "appops");
            r0.put(CaptioningManager.class, "captioning");
            r0.put(ConsumerIrManager.class, "consumer_ir");
            r0.put(PrintManager.class, "print");
        L12:
            if (Build.VERSION.SDK_INT < 18) goto L15;
            r0.put(BluetoothManager.class, "bluetooth");
        L15:
            if (Build.VERSION.SDK_INT < 17) goto L18;
            r0.put(DisplayManager.class, "display");
            r0.put(UserManager.class, "user");
        L18:
            if (Build.VERSION.SDK_INT < 16) goto L20;
            r0.put(InputManager.class, "input");
            r0.put(MediaRouter.class, "media_router");
            r0.put(NsdManager.class, "servicediscovery");
        L20:
            r0.put(AccessibilityManager.class, "accessibility");
            r0.put(AccountManager.class, "account");
            r0.put(ActivityManager.class, "activity");
            r0.put(AlarmManager.class, "alarm");
            r0.put(AudioManager.class, "audio");
            r0.put(ClipboardManager.class, "clipboard");
            r0.put(ConnectivityManager.class, "connectivity");
            r0.put(DevicePolicyManager.class, "device_policy");
            r0.put(DownloadManager.class, "download");
            r0.put(DropBoxManager.class, "dropbox");
            r0.put(InputMethodManager.class, "input_method");
            r0.put(KeyguardManager.class, "keyguard");
            r0.put(LayoutInflater.class, "layout_inflater");
            r0.put(LocationManager.class, "location");
            r0.put(NfcManager.class, "nfc");
            r0.put(NotificationManager.class, IFlowAppIntentIDL.PERMISSION_NOTIFICATION);
            r0.put(PowerManager.class, "power");
            r0.put(SearchManager.class, "search");
            r0.put(SensorManager.class, "sensor");
            r0.put(StorageManager.class, Scraps.STORAGE);
            r0.put(TelephonyManager.class, "phone");
            r0.put(TextServicesManager.class, "textservices");
            r0.put(UiModeManager.class, "uimode");
            r0.put(UsbManager.class, "usb");
            r0.put(Vibrator.class, "vibrator");
            r0.put(WallpaperManager.class, "wallpaper");
            r0.put(WifiP2pManager.class, "wifip2p");
            r0.put(WifiManager.class, "wifi");
            r0.put(WindowManager.class, "window");
        }
    }

    static {
        f1145a = new Object();
        f1146b = new Object();
    }

    public static boolean a(Context r2, Intent[] r3, Bundle r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        C0024a.a(r5, r3, r4);
        return true;
    L5:
        r5.startActivities(r3);
        return true;
    }

    public static void startActivity(Context r3, Intent r4, Bundle r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 16) goto L5;
        C0024a.startActivity(r6, r4, r5);
        return;
    L5:
        ZeusTransformUtils.startActivity(r6, r4, "com.obric.aiagent.plugin");
    }

    public static File[] a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return c.a(r4, r3);
    L7:
        return new File[]{r4.getExternalFilesDir(r3)};
    }

    public static File[] a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 19) goto L7;
        return c.a(r3);
    L7:
        return new File[]{r3.getExternalCacheDir()};
    }

    public static Drawable a(Context r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return d.a(r6, r5);
    L7:
        if (Build.VERSION.SDK_INT >= 16) goto L9;
        Object r0 = f1145a;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L13:
        if (f1147c != null) goto L15;
        f1147c = new TypedValue();     // Catch: Throwable -> L19
    L15:
        ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getValue(r5, f1147c, true);     // Catch: Throwable -> L19
        int r7 = f1147c.resourceId;     // Catch: Throwable -> L19
        monitor-exit(r0);     // Catch: Throwable -> L19
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDrawable(r7);
    L9:
        return ZeusTransformUtils.getResources(r6, "com.obric.aiagent.plugin").getDrawable(r5);
    }

    public static ColorStateList b(Context r2, int r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        return androidx.core.content.b.h.c(ZeusTransformUtils.getResources(r4, "com.obric.aiagent.plugin"), r3, r4.getTheme());
    }

    public static int c(Context r3, int r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return e.a(r5, r4);
    L7:
        return ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getColor(r4);
    }

    public static int b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        androidx.core.util.d.a(r3, "permission must be non-null");
        if (Build.VERSION.SDK_INT >= 33) goto L12;
        if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", r3) == false) goto L12;
        if (NotificationManagerCompat.a(r4).b() == false) goto L9;
        return 0;
    L9:
        return -1;
    L12:
        return r4.checkPermission(r3, Process.myPid(), Process.myUid());
    }

    public static Executor b(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 28) goto L7;
        return g.a(r3);
    L7:
        return androidx.core.os.h.a(new Handler(r3.getMainLooper()));
    }

    public static <T> T a(Context r2, Class<T> r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        String r5 = b(r4, r3);
        if (r5 != null) goto L11;
        return null;
    L11:
        return (T) r4.getSystemService(r5);
    L5:
        return (T) e.a(r4, r3);
    }

    public static Intent registerReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, int r9) {
        return registerReceiver((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin"), r7, r8, null, null, r9);
    }

    public static Intent registerReceiver(Context r6, PluginBroadcastReceiver r7, IntentFilter r8, String r9, Handler r10, int r11) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        int r12 = r11 & 1;
        if (r12 != 0) goto L5;
    L9:
        if (r12 == 0) goto L11;
        r11 = r11 | 2;
    L11:
        int r5 = r11;
        int r13 = r5 & 2;
        if (r13 == 0) goto L14;
    L18:
        if (r13 == 0) goto L25;
        if ((r5 & 4) == 0) goto L25;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
    L25:
        if (Build.VERSION.SDK_INT < 33) goto L29;
        return h.registerReceiver(r0, r7, r8, r9, r10, r5);
    L29:
        if (Build.VERSION.SDK_INT < 26) goto L33;
        return f.registerReceiver(r0, r7, r8, r9, r10, r5);
    L33:
        if ((r5 & 4) == 0) goto L38;
        if (r9 != null) goto L38;
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, d(r0), r10, "com.obric.aiagent.plugin");
    L38:
        return ZeusTransformUtils.registerReceiver(r0, r7, r8, r9, r10, "com.obric.aiagent.plugin");
    L14:
        if ((r5 & 4) != 0) goto L18;
        throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
    L5:
        if ((r11 & 4) == 0) goto L9;
        throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
    }

    public static String b(Context r3, Class<?> r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return e.b(r5, r4);
    L7:
        return (String) ZeusTransformUtils.preCheckCast(i.f1148a.get(r4), String.class, "com.obric.aiagent.plugin");
    }

    public static String d(Context r2, int r3) {
        return ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(c((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getString(r3);
    }

    public static Context c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        androidx.core.os.i r0 = androidx.core.app.f.a(r5);
        if (Build.VERSION.SDK_INT <= 32) goto L5;
        return r5;
    L5:
        if (Build.VERSION.SDK_INT >= 17) goto L7;
        return r5;
    L7:
        if (r0.b() == true) goto L12;
        Configuration r2 = new Configuration(ZeusTransformUtils.getResources(r5, "com.obric.aiagent.plugin").getConfiguration());
        androidx.core.os.g.a(r2, r0);
        return (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(b.a(r5, r2), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L12:
        return r5;
    }

    static String d(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        String r0 = r4.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (androidx.core.content.d.a(r4, r0) != 0) goto L6;
        return r0;
    L6:
        throw new RuntimeException("Permission " + r0 + " is required by your application to receive broadcasts, please add it to your manifest");
    }
}
