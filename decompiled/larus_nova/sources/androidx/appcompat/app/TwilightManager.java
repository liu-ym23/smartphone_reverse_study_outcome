package androidx.appcompat.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.core.content.PermissionChecker;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.heytap.mcssdk.constant.a;
import f06.b;
import f06.c;
import f06.d;
import java.util.Calendar;

/* JADX INFO: loaded from: classes2.dex */
class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState;

    public static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        public TwilightState() {
        }
    }

    private Location getLastKnownLocation() {
        Location r100 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") != 0) goto L5;
        Location r101 = getLastKnownLocationForProvider("network");
    L7:
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L9;
        r100 = getLastKnownLocationForProvider(GeocodeSearch.GPS);
    L9:
        if (r100 == null) goto L15;
        if (r101 == null) goto L15;
        if (r100.getTime() > r101.getTime()) goto L14;
        return r101;
    L14:
        return r100;
    L15:
        if (r100 != null) goto L17;
        return r101;
    L17:
        return r100;
    L5:
        r101 = null;
        goto L7
    }

    private boolean isStateValid() {
        if (this.mTwilightState.nextUpdate <= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isNight() {
        TwilightState r100 = this.mTwilightState;
        if (isStateValid() == true) goto L5;
        Location r101 = getLastKnownLocation();
        if (r101 == null) goto L10;
        updateState(r101);
        return r100.isNight;
    L10:
        int r102 = Calendar.getInstance().get(11);
        if (r102 >= 6) goto L13;
    L16:
        return true;
    L13:
        if (r102 >= 22) goto L16;
        return false;
    L5:
        return r100.isNight;
    }

    public static TwilightManager getInstance(Context r100) {
        if (sInstance != null) goto L6;
        Context r101 = r100.getApplicationContext();
        sInstance = new TwilightManager(r101, (LocationManager) r101.getSystemService("location"));
    L6:
        return sInstance;
    }

    private Location getLastKnownLocationForProvider(String r100) {
        if (this.mLocationManager.isProviderEnabled(r100) == false) goto L6;
        return androidx_appcompat_app_TwilightManager_android_location_LocationManager_getLastKnownLocation(this.mLocationManager, r100);
    L6:
        return null;
    L11:
        return null;
    }

    public static void setInstance(TwilightManager r100) {
        sInstance = r100;
    }

    private void updateState(Location r210) {
        TwilightState r100 = this.mTwilightState;
        long r101 = System.currentTimeMillis();
        TwilightCalculator r110 = TwilightCalculator.getInstance();
        r110.calculateTwilight(r101 - 86400000, r210.getLatitude(), r210.getLongitude());
        long r111 = r110.sunset;
        r110.calculateTwilight(r101, r210.getLatitude(), r210.getLongitude());
        if (r110.state != 1) goto L5;
        boolean r102 = true;
    L6:
        long r103 = r110.sunrise;
        long r104 = r110.sunset;
        boolean r105 = r102;
        r110.calculateTwilight(86400000 + r101, r210.getLatitude(), r210.getLongitude());
        long r106 = r110.sunrise;
        if (r103 != (-1)) goto L9;
    L19:
        long r107 = a.f276320g + r101;
    L20:
        r100.isNight = r105;
        r100.yesterdaySunset = r111;
        r100.todaySunrise = r103;
        r100.todaySunset = r104;
        r100.tomorrowSunrise = r106;
        r100.nextUpdate = r107;
        return;
    L9:
        if (r104 == (-1)) goto L19;
        if (r101 <= r104) goto L15;
        long r108 = 0 + r106;
    L18:
        r107 = r108 + 60000;
        goto L20
    L15:
        if (r101 <= r103) goto L17;
        r108 = 0 + r104;
        goto L18
    L17:
        r108 = 0 + r103;
        goto L18
    L5:
        r102 = false;
        goto L6
    }

    public TwilightManager(Context r100, LocationManager r101) {
        this.mTwilightState = new TwilightState();
        this.mContext = r100;
        this.mLocationManager = r101;
    }

    private static Location androidx_appcompat_app_TwilightManager_android_location_LocationManager_getLastKnownLocation(LocationManager r110, String r111) {
        c r100 = new c();
        Object[] r101 = {r111};
        b r112 = new b();
        d r113 = r100.b(100000, "android/location/LocationManager", "getLastKnownLocation", r110, r101, "android.location.Location", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(100000, "android/location/LocationManager", "getLastKnownLocation", r110, r101, null, r112, false);
        return (Location) r113.f474983b;
    L6:
        Location r114 = r110.getLastKnownLocation(r111);
        r100.a(100000, "android/location/LocationManager", "getLastKnownLocation", r110, r101, r114, r112, true);
        return r114;
    }
}
