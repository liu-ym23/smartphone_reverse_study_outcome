package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.Calendar;

/* loaded from: classes.dex */
class q {

    /* renamed from: d, reason: collision with root package name */
    private static q f7660d;

    /* renamed from: a, reason: collision with root package name */
    private final Context f7661a;

    /* renamed from: b, reason: collision with root package name */
    private final LocationManager f7662b;

    /* renamed from: c, reason: collision with root package name */
    private final a f7663c = new a();

    private static class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f7664a;

        /* renamed from: b, reason: collision with root package name */
        long f7665b;

        a() {
        }
    }

    q(Context context, LocationManager locationManager) {
        this.f7661a = context;
        this.f7662b = locationManager;
    }

    static q a(Context context) {
        if (f7660d == null) {
            Context applicationContext = context.getApplicationContext();
            f7660d = new q(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f7660d;
    }

    private Location b() {
        Location locationC = androidx.core.content.d.c(this.f7661a, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.d.c(this.f7661a, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    private Location c(String str) {
        try {
            if (this.f7662b.isProviderEnabled(str)) {
                return this.f7662b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e6) {
            Log.d("TwilightManager", "Failed to get last known location", e6);
            return null;
        }
    }

    private boolean e() {
        return this.f7663c.f7665b > System.currentTimeMillis();
    }

    private void f(Location location) {
        long j5;
        a aVar = this.f7663c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        p pVarB = p.b();
        pVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        pVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z5 = pVarB.f7659c == 1;
        long j6 = pVarB.f7658b;
        long j7 = pVarB.f7657a;
        pVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j8 = pVarB.f7658b;
        if (j6 == -1 || j7 == -1) {
            j5 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j7) {
                j6 = j8;
            } else if (jCurrentTimeMillis > j6) {
                j6 = j7;
            }
            j5 = j6 + 60000;
        }
        aVar.f7664a = z5;
        aVar.f7665b = j5;
    }

    boolean d() {
        a aVar = this.f7663c;
        if (e()) {
            return aVar.f7664a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f7664a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i5 = Calendar.getInstance().get(11);
        return i5 < 6 || i5 >= 22;
    }
}
