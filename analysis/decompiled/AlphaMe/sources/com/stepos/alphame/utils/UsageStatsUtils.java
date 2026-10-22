package com.stepos.alphame.utils;

import C.d;
import L2.c;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes.dex */
public class UsageStatsUtils {
    public static final String EVENT_APP_HIT_RATE = "app_hit_rate";
    public static final String EVENT_APP_SUGGESTION = "app_suggestion_hit_rate";
    public static final String EVENT_FAVORITE_SUGGESTION = "most_favorite_hit_rate";
    public static final String EVENT_ONEMIND_LOCATION = "onemind_location";
    public static final String EVENT_PICKER_SMALL_WINDOW = "picker_small_window";
    public static final String EVENT_PICKER_SWITCH = "picker_switch";
    public static final String EVENT_PICKER_WAY = "picker_way";
    public static final String KEY_APP_OPEN_TIMES = "app_open_times";
    public static final String KEY_EIGHT_RESULT = "eight_results_rate";
    public static final String KEY_FOUR_RESULT = "four_results_rate";
    public static final String KEY_HIT_TIMES = "hit_times";
    public static final String KEY_LOCATION_ACC_0_20 = "location_acc_0_20";
    public static final String KEY_LOCATION_ACC_101_200 = "location_acc_101_200";
    public static final String KEY_LOCATION_ACC_201_500 = "location_acc_201_500";
    public static final String KEY_LOCATION_ACC_21_50 = "location_acc_21_50";
    public static final String KEY_LOCATION_ACC_501_MORE = "location_acc_501_more";
    public static final String KEY_LOCATION_ACC_51_100 = "location_acc_51_100";
    public static final String KEY_LOCATION_FAIL = "location_fail";
    public static final String KEY_LOCATION_INTERVAL_AVG = "location_interval_avg";
    public static final String KEY_LOCATION_INTERVAL_MAX = "location_interval_max";
    public static final String KEY_LOCATION_NUM = "location_num";
    public static final String KEY_MISS_TIMES = "miss_times";
    public static final String KEY_ONE_RESULT = "one_result_rate";
    public static final String KEY_OPEN_TIMES = "open_times";
    public static final String KEY_PACKAGE_NAME = "package_name";
    public static final String KEY_SWITCH = "switch";
    public static final String KEY_WAY = "way";
    public static final String KEY_WRONG_TIMES = "wrong_times";

    public static void onEvent(String str, String str2, Map<String, String> map) {
        try {
            if (!d.f250d) {
                throw new IllegalStateException("UsageStatsProxy3 is not initialised - invoke at least once with parameterised init");
            }
            if (!TextUtils.isEmpty(str)) {
                c cVar = L2.b.f1231a;
                cVar.f1239h.a(cVar.f1232a, str, str2, map, 1);
            }
            if (Utils.DEBUG.get()) {
                AlphaMeLogger.dLog("onEvent eventName = " + str);
                if (map != null) {
                    for (String str3 : map.keySet()) {
                        AlphaMeLogger.dLog("onEvent key = " + str3 + ", value = " + map.get(str3));
                    }
                }
            }
        } catch (Exception unused) {
            AlphaMeLogger.eLog("onEvent error, maybe not initialized");
        }
    }
}
