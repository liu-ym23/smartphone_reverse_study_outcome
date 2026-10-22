package h;

import android.content.Context;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import com.stepos.policy.sdk.util.PolicySdkPermissionManifestUtils;
import java.util.Calendar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class z extends b0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4900c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ e0 f4901d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4902e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(e0 e0Var, Context context) {
        super(e0Var);
        this.f4901d = e0Var;
        this.f4902e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // h.b0
    public final IntentFilter d() {
        switch (this.f4900c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // h.b0
    public final int f() {
        Location location;
        boolean z10;
        long j10;
        switch (this.f4900c) {
            case 0:
                return v.a((PowerManager) this.f4902e) ? 2 : 1;
            default:
                p5.m mVar = (p5.m) this.f4902e;
                l0 l0Var = (l0) mVar.f9743h;
                LocationManager locationManager = (LocationManager) mVar.f9742g;
                if (l0Var.f4851b > System.currentTimeMillis()) {
                    z10 = l0Var.f4850a;
                } else {
                    Context context = (Context) mVar.f9741f;
                    Location lastKnownLocation = null;
                    if (ac.a.l(context, PolicySdkPermissionManifestUtils.ACCESS_COARSE_LOCATION) == 0) {
                        try {
                        } catch (Exception e10) {
                            Log.d("TwilightManager", "Failed to get last known location", e10);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (ac.a.l(context, PolicySdkPermissionManifestUtils.ACCESS_FINE_LOCATION) == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e11) {
                            Log.d("TwilightManager", "Failed to get last known location", e11);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (k0.f4846d == null) {
                            k0.f4846d = new k0();
                        }
                        k0 k0Var = k0.f4846d;
                        k0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - 86400000);
                        k0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                        z10 = k0Var.f4849c == 1;
                        long j11 = k0Var.f4848b;
                        long j12 = k0Var.f4847a;
                        k0Var.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + 86400000);
                        long j13 = k0Var.f4848b;
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
                        l0Var.f4850a = z10;
                        l0Var.f4851b = j10;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i = Calendar.getInstance().get(11);
                        if (i < 6 || i >= 22) {
                            z10 = true;
                        }
                    }
                }
                return z10 ? 2 : 1;
        }
    }

    @Override // h.b0
    public final void j() throws PackageManager.NameNotFoundException {
        switch (this.f4900c) {
            case 0:
                this.f4901d.m(true);
                break;
            default:
                this.f4901d.m(true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(e0 e0Var, p5.m mVar) {
        super(e0Var);
        this.f4901d = e0Var;
        this.f4902e = mVar;
    }
}
