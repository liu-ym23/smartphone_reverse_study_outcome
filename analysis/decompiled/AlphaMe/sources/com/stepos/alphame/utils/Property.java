package com.stepos.alphame.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import com.stepos.alphame.ApplicationImpl;
import com.stepos.alphame.perfbinder.PerfBinderHelper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class Property {
    public static final String BEHAVIOR_INIT_TIME = "behavior_init_time";
    public static final String CDN_PACK = "cdn_pack";
    public static final String CHOSEN_COMPANY_ADDR = "chosen_company_addr";
    public static final String CHOSEN_COMPANY_COORD = "chosen_company_coord";
    public static final String CHOSEN_HOME_ADDR = "chosen_home_addr";
    public static final String CHOSEN_HOME_COORD = "chosen_home_coord";
    public static final String CHOSEN_VEHICLE_BLUETOOTH = "chosen_vehicle_bluetooth";
    public static final String COUNTRY_INFOS = "country_infos";
    public static final String CUT_IMAGE_VERSION = "cut_image_version";
    public static final boolean DEFAULT_BOOL_VALUE = false;
    public static final float DEFAULT_FLOAT_VALUE = 0.0f;
    public static final int DEFAULT_INT_VALUE = 0;
    public static final long DEFAULT_LONG_VALUE = 0;
    public static final String DEFAULT_STRING_VALUE = "";
    public static final String KEY_LAST_CLEAR_INVALID_TIME = "last_clear_invalid_time";
    public static final String KEY_LAST_START_LOCATION_TIME = "last_start_location_time";
    public static final String KEY_SCENE_MODE = "key_scene_mode";
    public static final String KEY_SLEEP_MODE = "key_sleep_mode";
    public static final String KEY_SLEEP_START_TIME = "key_sleep_start_time";
    private static String LAST_ACTIVITY_UPDATE_VERSION = "last_activity_update_version";
    public static final String LAST_CITY = "last_city";
    private static String LAST_EXTRA_UPDATE_VERSION = "last_extra_update_version";
    public static final String LAST_FULL_TRAIN_TIME = "last_full_train_time";
    private static String LAST_FULL_UPDATE_TIME = "last_full_update_time";
    private static String LAST_FULL_UPDATE_VERSION = "last_full_update_version";
    private static String LAST_UNBOUNDED_UPDATE_VERSION = "last_unbounded_update_version";
    private static String LAST_UPDATE_GAME_MODE_TIME = "last_update_game_mode_time";
    public static final String LAST_UPLOAD_TIME = "last_upload_time";
    public static final String LOCATION_AUTO_DETECT = "location_auto_detect";
    private static String NEED_MODIFY_ALL_KEEY_BG_APP_2_RECMD = "need_modify_all_keep_bg_app_2_recmd";
    public static final String NOTI_VERSION = "noti_version";
    public static final String NOTI_WHITELIST_VERSION = "noti_whitelist_version";
    public static final String PICKER_VERSION = "pick_version";
    private static final String SEP_MAGIC_STR = " ,hzy_122191371, ";
    public static final String SHARED_PREFERENCES_NAME = "property";
    private static String UPDATE_GAME_MODE_TIME_DELTA = "update_game_mode_time_delta";
    private static long sBehaviorInitTime = 0;
    private static String sChosenCompanyAddr = null;
    private static String sChosenCompanyCoord = null;
    private static String sChosenHomeAddr = null;
    private static String sChosenHomeCoord = null;
    private static String sChosenVehicleBluetooth = null;
    private static String sCountryInfo = null;
    private static String sCutImageVersion = null;
    private static String sLastActivityUpdateVersion = null;
    private static String sLastCity = null;
    private static long sLastDailyUpdateTime = 0;
    private static String sLastExtraUpdateVersion = null;
    private static long sLastFullTrainTime = -1;
    private static long sLastFullUpdateTime = -1;
    private static String sLastFullUpdateVersion = null;
    private static String sLastUnboundedUpdateVersion = null;
    private static long sLastUploadTime = -1;
    private static Boolean sLocationAutoDetect = null;
    private static String sNotiVersion = null;
    private static String sNotiWhitelistVersion = null;
    private static String sPickerVersion = null;
    private static int sWifiScanAlwaysAvailableState = -1;

    public static synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public static String getCdnPack() {
        return getString(CDN_PACK, null);
    }

    public static String getChosenCompanyAddr() {
        if (sChosenCompanyAddr == null) {
            sChosenCompanyAddr = getString(CHOSEN_COMPANY_ADDR, "");
        }
        return sChosenCompanyAddr;
    }

    public static String getChosenCompanyCoord() {
        if (sChosenCompanyCoord == null) {
            sChosenCompanyCoord = getString(CHOSEN_COMPANY_COORD, "");
        }
        return sChosenCompanyCoord;
    }

    public static String getChosenHomeAddr() {
        if (sChosenHomeAddr == null) {
            sChosenHomeAddr = getString(CHOSEN_HOME_ADDR, "");
        }
        return sChosenHomeAddr;
    }

    public static String getChosenHomeCoord() {
        if (sChosenHomeCoord == null) {
            sChosenHomeCoord = getString(CHOSEN_HOME_COORD, "");
        }
        return sChosenHomeCoord;
    }

    public static String getChosenVehicleBluetooth(ContentResolver contentResolver) {
        if (sChosenVehicleBluetooth == null) {
            String string = getString(CHOSEN_VEHICLE_BLUETOOTH, "");
            sChosenVehicleBluetooth = string;
            if (TextUtils.isEmpty(string)) {
                try {
                    String string2 = Settings.Secure.getString(contentResolver, "stepos_drive_mode_bluetooth_device");
                    if (!TextUtils.isEmpty(string2)) {
                        setChosenVehicleBluetooth(string2);
                    }
                } catch (Exception e4) {
                    AlphaMeLogger.exceptionLog("getChosenVehicleBluetooth error", e4);
                }
            }
        }
        return sChosenVehicleBluetooth;
    }

    public static String getCountryInfo() {
        if (sCountryInfo == null) {
            sCountryInfo = getString(COUNTRY_INFOS);
        }
        return sCountryInfo;
    }

    public static String getCutImageVersion() {
        if (sCutImageVersion == null) {
            sCutImageVersion = getString(CUT_IMAGE_VERSION, "");
        }
        return sCutImageVersion;
    }

    public static long getDailyUpdateTimeDelta() {
        return getLong(UPDATE_GAME_MODE_TIME_DELTA, 0L);
    }

    public static synchronized float getFloat(String str) {
        return getSp().getFloat(str, DEFAULT_FLOAT_VALUE);
    }

    public static synchronized int getInt(String str) {
        return getSp().getInt(str, 0);
    }

    public static synchronized int[] getIntArray(String str, int[] iArr) {
        List<String> stringList = getStringList(str, null);
        if (stringList == null) {
            return iArr;
        }
        int[] iArr2 = new int[stringList.size()];
        for (int i4 = 0; i4 < stringList.size(); i4++) {
            try {
                iArr2[i4] = Integer.parseInt(stringList.get(i4));
            } catch (Exception e4) {
                AlphaMeLogger.eLog("getIntArray error: " + e4.getMessage());
            }
        }
        return iArr2;
    }

    public static String getLastActivityUpdateVersion() {
        if (sLastActivityUpdateVersion == null) {
            sLastActivityUpdateVersion = getString(LAST_ACTIVITY_UPDATE_VERSION, "");
        }
        return sLastActivityUpdateVersion;
    }

    public static String getLastCity() {
        if (sLastCity == null) {
            sLastCity = getString(LAST_CITY, "");
        }
        return sLastCity;
    }

    public static long getLastDailyUpdateTime() {
        return sLastDailyUpdateTime;
    }

    public static String getLastExtraUpdateVersion() {
        if (sLastExtraUpdateVersion == null) {
            sLastExtraUpdateVersion = getString(LAST_EXTRA_UPDATE_VERSION, "");
        }
        return sLastExtraUpdateVersion;
    }

    public static long getLastFullTrainTime() {
        if (sLastFullTrainTime == -1) {
            sLastFullTrainTime = getLong(LAST_FULL_TRAIN_TIME);
        }
        return sLastFullTrainTime;
    }

    public static String getLastUnboundedUpdateVersion() {
        if (sLastUnboundedUpdateVersion == null) {
            sLastUnboundedUpdateVersion = getString(LAST_UNBOUNDED_UPDATE_VERSION, "");
        }
        return sLastUnboundedUpdateVersion;
    }

    public static long getLastUploadTime() {
        if (sLastUploadTime == -1) {
            sLastUploadTime = getLong(LAST_UPLOAD_TIME);
        }
        return sLastUploadTime;
    }

    public static boolean getLocationAutoDetect() {
        if (sLocationAutoDetect == null) {
            sLocationAutoDetect = Boolean.valueOf(getBoolean(LOCATION_AUTO_DETECT, false));
        }
        return sLocationAutoDetect.booleanValue();
    }

    public static synchronized long getLong(String str) {
        return getSp().getLong(str, 0L);
    }

    public static String getNotiVersion() {
        if (sNotiVersion == null) {
            sNotiVersion = getString(NOTI_VERSION, "");
        }
        return sNotiVersion;
    }

    public static String getNotiWhitelistVersion() {
        if (sNotiWhitelistVersion == null) {
            sNotiWhitelistVersion = getString(NOTI_WHITELIST_VERSION, "");
        }
        return sNotiWhitelistVersion;
    }

    public static String getPickerVersion() {
        if (sPickerVersion == null) {
            sPickerVersion = getString(PICKER_VERSION, "");
        }
        return sPickerVersion;
    }

    private static SharedPreferences getSp() {
        return ApplicationImpl.getApplication().getSharedPreferences(SHARED_PREFERENCES_NAME, 0);
    }

    public static synchronized String getString(String str) {
        return getString(str, "");
    }

    public static synchronized List<String> getStringList(String str, List<String> list) {
        String string = getSp().getString(str, null);
        if (string == null) {
            return list;
        }
        return stringToList(string);
    }

    public static synchronized Set<String> getStringSet(String str, Set<String> set) {
        String string = getSp().getString(str, null);
        if (string == null) {
            return set;
        }
        return stringToSet(string);
    }

    public static long getlastFullUpdateTime() {
        if (sLastFullUpdateTime == -1) {
            sLastFullUpdateTime = getLong(LAST_FULL_UPDATE_TIME, 0L);
        }
        return sLastFullUpdateTime;
    }

    public static String getlastFullUpdateVersion() {
        if (sLastFullUpdateVersion == null) {
            sLastFullUpdateVersion = getString(LAST_FULL_UPDATE_VERSION, "0");
        }
        return sLastFullUpdateVersion;
    }

    public static void putDailyUpdateTimeDelta(long j4) {
        setLong(UPDATE_GAME_MODE_TIME_DELTA, j4);
    }

    public static void putLastDailyUpdateTime(long j4) {
        sLastDailyUpdateTime = j4;
    }

    public static void restoreWifiScanAlwaysAvailableState(Context context) {
        try {
            int i4 = sWifiScanAlwaysAvailableState;
            if (i4 < 0 || i4 == PerfBinderHelper.getWifiScanAlwaysAvailable(-1)) {
                return;
            }
            PerfBinderHelper.putWifiScanAlwaysAvailable(sWifiScanAlwaysAvailableState);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("restoreWifiScanAlwaysAvailableState", e4);
        }
    }

    public static void saveWifiScanAlwaysAvailableState(Context context) {
        try {
            sWifiScanAlwaysAvailableState = PerfBinderHelper.getWifiScanAlwaysAvailable(-1);
        } catch (Exception e4) {
            AlphaMeLogger.exceptionLog("saveWifiScanAlwaysAvailableState", e4);
        }
    }

    public static synchronized void setBoolean(String str, boolean z4) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putBoolean(str, z4);
        write(editorEdit);
    }

    public static void setCdnPack(String str) {
        setString(CDN_PACK, str);
    }

    public static void setChosenCompanyAddr(String str) {
        sChosenCompanyAddr = str;
        setString(CHOSEN_COMPANY_ADDR, str);
    }

    public static void setChosenCompanyCoord(String str) {
        sChosenCompanyCoord = str;
        setString(CHOSEN_COMPANY_COORD, str);
    }

    public static void setChosenHomeAddr(String str) {
        sChosenHomeAddr = str;
        setString(CHOSEN_HOME_ADDR, str);
    }

    public static void setChosenHomeCoord(String str) {
        sChosenHomeCoord = str;
        setString(CHOSEN_HOME_COORD, str);
    }

    public static void setChosenVehicleBluetooth(String str) {
        sChosenVehicleBluetooth = str;
        setString(CHOSEN_VEHICLE_BLUETOOTH, str);
    }

    public static void setCountryInfo(String str) {
        if (TextUtils.equals(sCountryInfo, str)) {
            return;
        }
        sCountryInfo = str;
        setString(COUNTRY_INFOS, str);
    }

    public static void setCutImageVersion(String str) {
        sCutImageVersion = str;
        setString(CUT_IMAGE_VERSION, str);
    }

    public static synchronized void setFloat(String str, float f4) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putFloat(str, f4);
        write(editorEdit);
    }

    public static synchronized void setInt(String str, int i4) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putInt(str, i4);
        write(editorEdit);
    }

    public static void setLastActivityUpdateVersion(String str) {
        if (TextUtils.equals(str, sLastActivityUpdateVersion)) {
            return;
        }
        sLastActivityUpdateVersion = str;
        setString(LAST_ACTIVITY_UPDATE_VERSION, str);
    }

    public static void setLastCity(String str) {
        sLastCity = str;
        setString(LAST_CITY, str);
    }

    public static void setLastExtraUpdateVersion(String str) {
        if (TextUtils.equals(str, sLastExtraUpdateVersion)) {
            return;
        }
        sLastExtraUpdateVersion = str;
        setString(LAST_EXTRA_UPDATE_VERSION, str);
    }

    public static void setLastFullTrainTime(long j4) {
        sLastFullTrainTime = j4;
        setLong(LAST_FULL_TRAIN_TIME, j4);
    }

    public static void setLastFullUpdateTime(String str, long j4) {
        if (!TextUtils.equals(str, sLastFullUpdateVersion)) {
            sLastFullUpdateVersion = str;
            setString(LAST_FULL_UPDATE_VERSION, str);
        }
        if (sLastFullUpdateTime != j4) {
            sLastFullUpdateTime = j4;
            setLong(LAST_FULL_UPDATE_TIME, j4);
        }
    }

    public static void setLastUnboundedUpdateVersion(String str) {
        if (TextUtils.equals(str, sLastUnboundedUpdateVersion)) {
            return;
        }
        sLastUnboundedUpdateVersion = str;
        setString(LAST_UNBOUNDED_UPDATE_VERSION, str);
    }

    public static void setLastUploadTime(long j4) {
        sLastUploadTime = j4;
        setLong(LAST_UPLOAD_TIME, sLastFullTrainTime);
    }

    public static void setLocationAutoDetect(boolean z4) {
        Boolean boolValueOf = Boolean.valueOf(z4);
        sLocationAutoDetect = boolValueOf;
        setBoolean(LOCATION_AUTO_DETECT, boolValueOf.booleanValue());
    }

    public static synchronized void setLong(String str, long j4) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putLong(str, j4);
        write(editorEdit);
    }

    public static void setNotiVersion(String str) {
        sNotiVersion = str;
        setString(NOTI_VERSION, str);
    }

    public static void setNotiWhitelistVersion(String str) {
        sNotiWhitelistVersion = str;
        setString(NOTI_WHITELIST_VERSION, str);
    }

    public static void setPickerVersion(String str) {
        sPickerVersion = str;
        setString(PICKER_VERSION, str);
    }

    public static synchronized void setString(String str, String str2) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putString(str, str2);
        write(editorEdit);
    }

    public static synchronized void setStringList(String str, List<String> list) {
        String strStringOfList = stringOfList(list);
        SharedPreferences.Editor editorEdit = getSp().edit();
        editorEdit.putString(str, strStringOfList);
        editorEdit.apply();
    }

    public static synchronized void setStringSet(String str, Set<String> set, String str2, Set<String> set2) {
        SharedPreferences.Editor editorEdit = getSp().edit();
        String strStringOfSet = null;
        editorEdit.putString(str, set == null ? null : stringOfSet(new HashSet(set)));
        if (set2 != null) {
            strStringOfSet = stringOfSet(new HashSet(set2));
        }
        editorEdit.putString(str2, strStringOfSet);
        editorEdit.apply();
    }

    private static String stringOfList(List<String> list) {
        if (list == null) {
            return null;
        }
        if (list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(SEP_MAGIC_STR);
        }
        sb.delete(sb.length() - 17, sb.length());
        return sb.toString();
    }

    private static String stringOfSet(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static List<String> stringToList(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 0) {
            return new ArrayList();
        }
        String[] strArrSplit = str.split(SEP_MAGIC_STR);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, strArrSplit);
        return arrayList;
    }

    private static Set<String> stringToSet(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() <= 0) {
            return new HashSet();
        }
        String[] strArrSplit = str.split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        Collections.addAll(hashSet, strArrSplit);
        return hashSet;
    }

    private static void write(SharedPreferences.Editor editor) {
        if (AppUtils.isMainThread()) {
            editor.apply();
        } else {
            if (editor.commit()) {
                return;
            }
            AlphaMeLogger.wLog("SharedPreferences commit failed");
        }
    }

    public static synchronized boolean getBoolean(String str, boolean z4) {
        return getSp().getBoolean(str, z4);
    }

    public static synchronized float getFloat(String str, float f4) {
        return getSp().getFloat(str, f4);
    }

    public static synchronized int getInt(String str, int i4) {
        return getSp().getInt(str, i4);
    }

    public static synchronized long getLong(String str, long j4) {
        return getSp().getLong(str, j4);
    }

    public static synchronized String getString(String str, String str2) {
        return getSp().getString(str, str2);
    }
}
