package C2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.os.Build;
import com.stepos.familyguard.R;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import f2.C0702g;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f608a;

    private static boolean a(Context context) {
        boolean z5 = context.checkSelfPermission("android.permission.FOREGROUND_SERVICE_LOCATION") == 0;
        boolean z6 = context.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0;
        boolean z7 = context.checkSelfPermission(PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0;
        C0702g.y("StartForegroundUtils", "foregroundServiceLocationPermission = " + z5);
        C0702g.y("StartForegroundUtils", "accessFineLocationPermission = " + z6);
        C0702g.y("StartForegroundUtils", "accessCoarseLocationPermission = " + z7);
        return z5 && (z6 || z7);
    }

    private static void b(Service service, NotificationManager notificationManager) {
        if (f608a) {
            return;
        }
        synchronized (l.class) {
            try {
                if (f608a) {
                    return;
                }
                notificationManager.createNotificationChannel(new NotificationChannel("channel_id", service.getString(R.string.fg_app_name), 1));
                f608a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static long c(Service service, int i5) {
        try {
            int i6 = Build.VERSION.SDK_INT;
            if (i5 == 8 && !a(service)) {
                C0702g.p("StartForegroundUtils", "no location permission");
            }
            b(service, (NotificationManager) service.getSystemService("notification"));
            Notification notificationBuild = new Notification.Builder(service.getApplicationContext(), "channel_id").setSmallIcon(R.drawable.fg_status_icon).build();
            notificationBuild.flags |= 268435456;
            C0702g.y("StartForegroundUtils", "startForeground() called with: service = [" + service + "], serviceType = [" + i5 + "]");
            if (i6 > 33) {
                service.startForeground(1, notificationBuild, i5);
            } else {
                service.startForeground(1, notificationBuild);
            }
            return System.currentTimeMillis();
        } catch (Exception e6) {
            e6.printStackTrace();
            return System.currentTimeMillis();
        }
    }
}
