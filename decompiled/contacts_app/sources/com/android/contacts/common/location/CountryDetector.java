package com.android.contacts.common.location;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.GlobalProxyLancet;
import com.android.contacts.common.util.PermissionsUtil;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class CountryDetector {
    private static final long DISTANCE_BETWEEN_UPDATES_METERS = 5000;
    public static final String KEY_PREFERENCE_CURRENT_COUNTRY = "preference_current_country";
    public static final String KEY_PREFERENCE_TIME_UPDATED = "preference_time_updated";
    private static final String TAG = "CountryDetector";
    private static final long TIME_BETWEEN_UPDATES_MS = 43200000;
    private static CountryDetector sInstance;
    private final String DEFAULT_COUNTRY_ISO;
    private final Context mContext;
    private final LocaleProvider mLocaleProvider;
    private final LocationManager mLocationManager;
    private final TelephonyManager mTelephonyManager;

    public static class LocaleProvider {
        public LocaleProvider() {
        }

        public Locale getDefaultLocale() {
            return Locale.getDefault();
        }
    }

    public static class LocationChangedReceiver extends BroadcastReceiver {
        public LocationChangedReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r2, Intent r3) {
            if (r3.hasExtra(BatteryTypeInf.BATTERY_LOC_API) == true) goto L5;
            return;
        L5:
            UpdateCountryService.updateCountry(r2, (Location) r3.getExtras().get(BatteryTypeInf.BATTERY_LOC_API));
        }
    }

    private CountryDetector(Context r4) {
        this(r4, (TelephonyManager) r4.getSystemService("phone"), (LocationManager) r4.getSystemService(BatteryTypeInf.BATTERY_LOC_API), new LocaleProvider());
    }

    private CountryDetector(Context r2, TelephonyManager r3, LocationManager r4, LocaleProvider r5) {
        this.DEFAULT_COUNTRY_ISO = "US";
        this.mTelephonyManager = r3;
        this.mLocationManager = r4;
        this.mLocaleProvider = r5;
        this.mContext = r2;
        registerForLocationUpdates(r2, r4);
    }

    public static void registerForLocationUpdates(Context r9, LocationManager r10) {
        if (PermissionsUtil.hasLocationPermissions(r9) == true) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No location permissions, not registering for location updates.");
        return;
    L7:
        if (Geocoder.isPresent() == true) goto L9;
        return;
    L9:
        r10.requestLocationUpdates("passive", TIME_BETWEEN_UPDATES_MS, 5000.0f, PendingIntent.getBroadcast(r9, 0, new Intent(r9, LocationChangedReceiver.class), 134217728));
    }

    public CountryDetector getInstanceForTest(Context r1, TelephonyManager r2, LocationManager r3, LocaleProvider r4, Geocoder r5) {
        return new CountryDetector(r1, r2, r3, r4);
    }

    public static synchronized CountryDetector getInstance(Context r2) {
        monitor-enter(CountryDetector.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CountryDetector(r2.getApplicationContext());     // Catch: Throwable -> L10
    L7:
        CountryDetector r3 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CountryDetector.class);
        return r3;
    }

    public String getCurrentCountryIso() {
        if (isNetworkCountryCodeAvailable() == false) goto L5;
        String r0 = getNetworkBasedCountryIso();
    L7:
        if (TextUtils.isEmpty(r0) == false) goto L10;
        r0 = getLocationBasedCountryIso();
    L10:
        if (TextUtils.isEmpty(r0) == false) goto L13;
        r0 = getSimBasedCountryIso();
    L13:
        if (TextUtils.isEmpty(r0) == false) goto L16;
        r0 = getLocaleBasedCountryIso();
    L16:
        if (TextUtils.isEmpty(r0) == false) goto L19;
        r0 = "US";
    L19:
        return r0.toUpperCase(Locale.US);
    L5:
        r0 = null;
        goto L7
    }

    private String getNetworkBasedCountryIso() {
        return this.mTelephonyManager.getNetworkCountryIso();
    }

    private String getLocationBasedCountryIso() {
        if (Geocoder.isPresent() == true) goto L5;
    L9:
        return null;
    L5:
        if (PermissionsUtil.hasLocationPermissions(this.mContext) == false) goto L9;
        return PreferenceManager.getDefaultSharedPreferences(this.mContext).getString(KEY_PREFERENCE_CURRENT_COUNTRY, null);
    }

    private String getSimBasedCountryIso() {
        return this.mTelephonyManager.getSimCountryIso();
    }

    private String getLocaleBasedCountryIso() {
        Locale r0 = this.mLocaleProvider.getDefaultLocale();
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getCountry();
    }

    private boolean isNetworkCountryCodeAvailable() {
        if (this.mTelephonyManager.getPhoneType() == 1) goto L7;
        return false;
    L7:
        return true;
    }
}
