package com.android.contacts.common.location;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes.dex */
public class UpdateCountryService extends IntentService {
    private static final String ACTION_UPDATE_COUNTRY = "saveCountry";
    private static final String KEY_INTENT_LOCATION = "location";
    private static final String TAG = "UpdateCountryService";

    static {
    }

    public UpdateCountryService() {
        super(TAG);
    }

    public static void updateCountry(Context r2, Location r3) {
        Intent r0 = new Intent(r2, UpdateCountryService.class);
        r0.setAction(ACTION_UPDATE_COUNTRY);
        r0.putExtra("location", r3);
        r2.startService(r0);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent r4) {
        if (r4 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onHandleIntent: could not handle null intent");
        return;
    L6:
        if (ACTION_UPDATE_COUNTRY.equals(r4.getAction()) == false) goto L12;
        Location r5 = (Location) r4.getParcelableExtra("location");
        String r6 = getCountryFromLocation(getApplicationContext(), r5);
        if (r6 != null) goto L10;
        return;
    L10:
        SharedPreferences.Editor r3 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).edit();
        r3.putLong(CountryDetector.KEY_PREFERENCE_TIME_UPDATED, System.currentTimeMillis());
        r3.putString(CountryDetector.KEY_PREFERENCE_CURRENT_COUNTRY, r6);
        r3.commit();
        return;
    }

    private String getCountryFromLocation(Context r2, Location r3) {
        String r1 = ((TelephonyManager) r2.getSystemService("phone")).getNetworkCountryIso().toUpperCase();
        if (r1 != null) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "No CountryDetector; falling back to countryIso based on locale: " + r1);
    L5:
        return r1;
    }
}
