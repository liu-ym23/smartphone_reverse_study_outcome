package com.stepos.statsapp.v3.lib.plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class RequestFreqRestrict {
    private static final int MAX_CURRENT_REQUEST = 10;
    private static final String PREFERENCES_KEY_CURRENT_REQUEST = "current_request";
    private static final String PREFERENCES_KEY_DATE = "date";
    private static final String PREFERENCES_MOBILE_TRAFFIC_NAME = "com.stepos.statsapp.v3.request_feq_restrict";
    private static final String TAG = "RequestFreqRestrict";

    public static boolean isAllow(Context context) {
        SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(context, PREFERENCES_MOBILE_TRAFFIC_NAME);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        String config = sharedPreferencesHelper.getConfig(PREFERENCES_KEY_DATE, "");
        String str = simpleDateFormat.format(new Date());
        if (!config.equals(str)) {
            SharedPreferences.Editor editorEdit = sharedPreferencesHelper.edit();
            editorEdit.putString(PREFERENCES_KEY_DATE, str);
            editorEdit.putLong(PREFERENCES_KEY_CURRENT_REQUEST, 1L);
            editorEdit.commit();
            Logger.d(TAG, "isAllow true");
            return true;
        }
        long config2 = sharedPreferencesHelper.getConfig(PREFERENCES_KEY_CURRENT_REQUEST, 0L);
        if (config2 > 10) {
            Logger.d(TAG, "isAllow false");
            return false;
        }
        sharedPreferencesHelper.commitConfig(PREFERENCES_KEY_CURRENT_REQUEST, config2 + 1);
        Logger.d(TAG, "isAllow true");
        return true;
    }
}
