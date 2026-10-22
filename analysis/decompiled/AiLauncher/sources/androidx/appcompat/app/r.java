package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.Calendar;

/* loaded from: classes.dex */
public class r {

    /* renamed from: d, reason: collision with root package name */
    public static r f8472d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f8473a;

    /* renamed from: b, reason: collision with root package name */
    public final LocationManager f8474b;

    /* renamed from: c, reason: collision with root package name */
    public final a f8475c = new a();

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public boolean f8476a;

        /* renamed from: b, reason: collision with root package name */
        public long f8477b;
    }

    public r(Context context, LocationManager locationManager) {
        this.f8473a = context;
        this.f8474b = locationManager;
    }

    public static r a(Context context) {
        if (f8472d == null) {
            Context applicationContext = context.getApplicationContext();
            f8472d = new r(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f8472d;
    }

    @SuppressLint({"MissingPermission"})
    public final Location b() {
        Location locationC = androidx.core.content.e.c(this.f8473a, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0 ? c("network") : null;
        Location locationC2 = androidx.core.content.e.c(this.f8473a, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0 ? c("gps") : null;
        return (locationC2 == null || locationC == null) ? locationC2 != null ? locationC2 : locationC : locationC2.getTime() > locationC.getTime() ? locationC2 : locationC;
    }

    public final Location c(String str) {
        try {
            if (this.f8474b.isProviderEnabled(str)) {
                return this.f8474b.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e10) {
            Log.d("TwilightManager", "Failed to get last known location", e10);
            return null;
        }
    }

    public boolean d() {
        a aVar = this.f8475c;
        if (e()) {
            return aVar.f8476a;
        }
        Location locationB = b();
        if (locationB != null) {
            f(locationB);
            return aVar.f8476a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i10 = Calendar.getInstance().get(11);
        return i10 < 6 || i10 >= 22;
    }

    public final boolean e() {
        return this.f8475c.f8477b > System.currentTimeMillis();
    }

    public final void f(Location location) {
        long j10;
        a aVar = this.f8475c;
        long jCurrentTimeMillis = System.currentTimeMillis();
        q qVarB = q.b();
        qVarB.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        qVarB.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z10 = qVarB.f8471c == 1;
        long j11 = qVarB.f8470b;
        long j12 = qVarB.f8469a;
        qVarB.a(jCurrentTimeMillis + 86400000, location.getLatitude(), location.getLongitude());
        long j13 = qVarB.f8470b;
        if (j11 == -1 || j12 == -1) {
            j10 = jCurrentTimeMillis + 43200000;
        } else {
            if (jCurrentTimeMillis > j12) {
                j11 = j13;
            } else if (jCurrentTimeMillis > j11) {
                j11 = j12;
            }
            j10 = j11 + 60000;
        }
        aVar.f8476a = z10;
        aVar.f8477b = j10;
    }
}
