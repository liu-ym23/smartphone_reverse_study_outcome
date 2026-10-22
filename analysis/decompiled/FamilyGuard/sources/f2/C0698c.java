package f2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.LauncherApps;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import android.os.UserHandle;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.limit.PackageChangedReceiver;
import com.stepos.digitalwellbeing.utils.PackageUtils;

/* renamed from: f2.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0698c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f16786a = false;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f16787b = false;

    /* renamed from: f2.c$a */
    class a extends LauncherApps.Callback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16788a;

        a(Context context) {
            this.f16788a = context;
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageAdded(String str, UserHandle userHandle) {
            if (C0698c.b(userHandle)) {
                PackageUtils.h(this.f16788a).A();
                DigitalWellbeingService.a0(this.f16788a, str);
            }
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageChanged(String str, UserHandle userHandle) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackageRemoved(String str, UserHandle userHandle) {
            if (C0698c.b(userHandle)) {
                R1.a.e("CPRU", "LauncherApps onPackageRemoved pkg=" + str);
                PackageUtils.h(this.f16788a).z(str);
                PackageUtils.h(this.f16788a).A();
                DigitalWellbeingService.b0(this.f16788a, str);
            }
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesAvailable(String[] strArr, UserHandle userHandle, boolean z5) {
        }

        @Override // android.content.pm.LauncherApps.Callback
        public void onPackagesUnavailable(String[] strArr, UserHandle userHandle, boolean z5) {
            if (z5 || !C0698c.b(userHandle) || strArr == null) {
                return;
            }
            for (String str : strArr) {
                PackageUtils.h(this.f16788a).z(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(UserHandle userHandle) {
        return userHandle == null || UserHandle.getUserHandleForUid(Process.myUid()).equals(userHandle);
    }

    public static final void c(Context context) {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addDataScheme("package");
            UserHandle userHandle = (UserHandle) N1.h.a(UserHandle.class).b("ALL").get(null);
            if (Build.VERSION.SDK_INT > 33) {
                N1.h.a(Context.class).a("registerReceiverAsUser", BroadcastReceiver.class, UserHandle.class, IntentFilter.class, String.class, Handler.class, Integer.TYPE).a(context, new Y1.b(), userHandle, intentFilter, null, null, 2);
            } else {
                N1.h.a(Context.class).a("registerReceiverAsUser", BroadcastReceiver.class, UserHandle.class, IntentFilter.class, String.class, Handler.class).a(context, new Y1.b(), userHandle, intentFilter, null, null);
            }
        } catch (Exception e6) {
            R1.a.l("CPRU", e6.getMessage());
        }
        e(context);
    }

    public static void d(Context context) {
        if (context == null || f16787b) {
            return;
        }
        try {
            Context applicationContext = context.getApplicationContext();
            LauncherApps launcherApps = (LauncherApps) applicationContext.getSystemService("launcherapps");
            if (launcherApps == null) {
                return;
            }
            HandlerThread handlerThread = new HandlerThread("FgLauncherApps");
            handlerThread.start();
            launcherApps.registerCallback(new a(applicationContext), new Handler(handlerThread.getLooper()));
            f16787b = true;
            R1.a.e("CPRU", "registerLauncherAppsCallback ok");
        } catch (Exception e6) {
            R1.a.l("CPRU", "registerLauncherAppsCallback failed: " + e6.getMessage());
        }
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        if (!f16786a) {
            try {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
                intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
                intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
                intentFilter.addDataScheme("package");
                context.getApplicationContext().registerReceiver(new PackageChangedReceiver(), intentFilter, 2);
                f16786a = true;
                R1.a.e("CPRU", "registerPackageChangedReceiver ok");
            } catch (Exception e6) {
                R1.a.l("CPRU", "registerPackageChangedReceiver failed: " + e6.getMessage());
            }
        }
        d(context);
    }
}
