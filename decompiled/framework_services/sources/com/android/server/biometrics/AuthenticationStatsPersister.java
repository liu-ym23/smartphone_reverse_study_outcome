package com.android.server.biometrics;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Slog;
import com.android.server.am.ProcessList;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AuthenticationStatsPersister {
    private static final String ENROLLMENT_NOTIFICATIONS = "enrollment_notifications";
    private static final String FACE_ATTEMPTS = "face_attempts";
    private static final String FACE_LAST_ENROLL_TIME = "face_last_enroll_time";
    private static final String FACE_LAST_FRR_NOTIFICATION_TIME = "face_last_notification_time";
    private static final String FACE_REJECTIONS = "face_rejections";
    private static final String FILE_NAME = "authentication_stats";
    private static final String FINGERPRINT_ATTEMPTS = "fingerprint_attempts";
    private static final String FINGERPRINT_LAST_ENROLL_TIME = "fingerprint_last_enroll_time";
    private static final String FINGERPRINT_LAST_FRR_NOTIFICATION_TIME = "fingerprint_last_notification_time";
    private static final String FINGERPRINT_REJECTIONS = "fingerprint_rejections";
    private static final String KEY = "frr_stats";
    private static final String TAG = "AuthenticationStatsPersister";
    private static final String THRESHOLD_KEY = "frr_threshold";
    private static final String USER_ID = "user_id";
    private final SharedPreferences mSharedPreferences;

    AuthenticationStatsPersister(Context context) {
        File prefsFile = new File(Environment.getDataSystemDirectory(), FILE_NAME);
        this.mSharedPreferences = context.getSharedPreferences(prefsFile, 0);
    }

    public List<AuthenticationStats> getAllFrrStats(int modality) {
        List<AuthenticationStats> authenticationStatsList = new ArrayList();
        Iterator<String> r1 = readFrrStats().iterator();
    L4:
        if (r1.hasNext() == false) goto L17;
        String frrStats = r1.next();
        JSONObject frrStatsJson = new JSONObject(frrStats);     // Catch: JSONException -> L9
        if (modality == 4) goto L8;
        if (modality != 1) goto L4;
        authenticationStatsList.add(getFingerprintAuthenticationStatsFromJson(frrStatsJson));     // Catch: JSONException -> L9
        goto L4
    L8:
        authenticationStatsList.add(getFaceAuthenticationStatsFromJson(frrStatsJson));     // Catch: JSONException -> L9
    L15:
        Slog.w(TAG, String.format("Unable to resolve authentication stats JSON: %s", new Object[]{frrStats}));
        goto L4
    L17:
        return authenticationStatsList;
    }

    AuthenticationStats getFaceAuthenticationStatsFromJson(JSONObject json) throws JSONException {
        return new AuthenticationStats(getIntValue(json, USER_ID, ProcessList.INVALID_ADJ), getIntValue(json, FACE_ATTEMPTS), getIntValue(json, FACE_REJECTIONS), getIntValue(json, ENROLLMENT_NOTIFICATIONS), getLongValue(json, FACE_LAST_ENROLL_TIME), getLongValue(json, FACE_LAST_FRR_NOTIFICATION_TIME), 4);
    }

    AuthenticationStats getFingerprintAuthenticationStatsFromJson(JSONObject json) throws JSONException {
        return new AuthenticationStats(getIntValue(json, USER_ID, ProcessList.INVALID_ADJ), getIntValue(json, FINGERPRINT_ATTEMPTS), getIntValue(json, FINGERPRINT_REJECTIONS), getIntValue(json, ENROLLMENT_NOTIFICATIONS), getLongValue(json, FINGERPRINT_LAST_ENROLL_TIME), getLongValue(json, FINGERPRINT_LAST_FRR_NOTIFICATION_TIME), 1);
    }

    public void removeFrrStats(int userId) {
        Set<String> frrStatsSet = new HashSet(readFrrStats());     // Catch: JSONException -> L8
        Iterator<String> iterator = frrStatsSet.iterator();     // Catch: JSONException -> L8
    L4:
        if (iterator.hasNext() == false) goto L11;
        String frrStats = iterator.next();     // Catch: JSONException -> L8
        JSONObject frrStatJson = new JSONObject(frrStats);     // Catch: JSONException -> L8
        if (getValue(frrStatJson, USER_ID).equals(String.valueOf(userId)) == false) goto L4;
        iterator.remove();     // Catch: JSONException -> L8
    L11:
        this.mSharedPreferences.edit().putStringSet(KEY, frrStatsSet).apply();     // Catch: JSONException -> L8
        return;
    }

    public void persistFrrStats(int userId, int totalAttempts, int rejectedAttempts, int enrollmentNotifications, long lastEnrollmentTime, long lastFrrNotificationTime, int modality) {
        Set<String> frrStatsSet = new HashSet(readFrrStats());     // Catch: JSONException -> L10
        JSONObject frrStatJson = null;
        Iterator<String> iterator = frrStatsSet.iterator();     // Catch: JSONException -> L10
    L6:
        if (iterator.hasNext() == false) goto L13;
        String frrStats = iterator.next();     // Catch: JSONException -> L10
        frrStatJson = new JSONObject(frrStats);     // Catch: JSONException -> L10
        if (getValue(frrStatJson, USER_ID).equals(String.valueOf(userId)) == true) goto L9;
        frrStatJson = null;
        goto L6
    L9:
        iterator.remove();     // Catch: JSONException -> L10
    L13:
        if (frrStatJson != null) goto L15;
        JSONObject frrStatJson2 = new JSONObject().put(USER_ID, userId);     // Catch: JSONException -> L10
    L16:
        frrStatsSet.add(buildFrrStats(frrStatJson2, totalAttempts, rejectedAttempts, enrollmentNotifications, lastEnrollmentTime, lastFrrNotificationTime, modality));     // Catch: JSONException -> L10
        Slog.d(TAG, "frrStatsSet to persist: " + frrStatsSet);     // Catch: JSONException -> L10
        this.mSharedPreferences.edit().putStringSet(KEY, frrStatsSet).apply();     // Catch: JSONException -> L10
        return;
    L15:
        frrStatJson2 = frrStatJson;
    L18:
        Slog.e(TAG, "Unable to persist authentication stats");
    }

    public void persistFrrThreshold(float frrThreshold) {
        this.mSharedPreferences.edit().putFloat(THRESHOLD_KEY, frrThreshold).apply();
    }

    private Set<String> readFrrStats() {
        return this.mSharedPreferences.getStringSet(KEY, Set.of());
    }

    private String buildFrrStats(JSONObject frrStats, int totalAttempts, int rejectedAttempts, int enrollmentNotifications, long lastEnrollmentTime, long lastFrrNotificationTime, int modality) throws JSONException {
        if (modality != 4) goto L7;
        return frrStats.put(FACE_ATTEMPTS, totalAttempts).put(FACE_REJECTIONS, rejectedAttempts).put(ENROLLMENT_NOTIFICATIONS, enrollmentNotifications).put(FACE_LAST_ENROLL_TIME, lastEnrollmentTime).put(FACE_LAST_FRR_NOTIFICATION_TIME, lastFrrNotificationTime).toString();
    L7:
        if (modality != 1) goto L11;
        return frrStats.put(FINGERPRINT_ATTEMPTS, totalAttempts).put(FINGERPRINT_REJECTIONS, rejectedAttempts).put(ENROLLMENT_NOTIFICATIONS, enrollmentNotifications).put(FINGERPRINT_LAST_ENROLL_TIME, lastEnrollmentTime).put(FINGERPRINT_LAST_FRR_NOTIFICATION_TIME, lastFrrNotificationTime).toString();
    L11:
        return frrStats.toString();
    }

    private String getValue(JSONObject jsonObject, String key) throws JSONException {
        if (jsonObject.has(key) == true) goto L7;
        return "";
    L7:
        return jsonObject.getString(key);
    }

    private int getIntValue(JSONObject jsonObject, String key) throws JSONException {
        return getIntValue(jsonObject, key, 0);
    }

    private int getIntValue(JSONObject jsonObject, String key, int defaultValue) throws JSONException {
        if (jsonObject.has(key) == false) goto L6;
        return jsonObject.getInt(key);
    L6:
        return defaultValue;
    }

    private long getLongValue(JSONObject jsonObject, String key) throws JSONException {
        return getLongValue(jsonObject, key, 0);
    }

    private long getLongValue(JSONObject jsonObject, String key, long defaultValue) throws JSONException {
        if (jsonObject.has(key) == false) goto L6;
        return jsonObject.getLong(key);
    L6:
        return defaultValue;
    }
}
