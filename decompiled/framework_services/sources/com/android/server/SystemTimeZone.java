package com.android.server;

import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.LocalLog;
import android.util.Slog;
import com.android.i18n.timezone.ZoneInfoDb;
import java.io.PrintWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes.dex */
public final class SystemTimeZone {
    private static final boolean DEBUG = false;
    private static final String DEFAULT_TIME_ZONE_ID = "GMT";
    private static final String TAG = "SystemTimeZone";
    public static final int TIME_ZONE_CONFIDENCE_HIGH = 100;
    public static final int TIME_ZONE_CONFIDENCE_LOW = 0;
    private static final String TIME_ZONE_CONFIDENCE_SYSTEM_PROPERTY = "persist.sys.timezone_confidence";
    private static final String TIME_ZONE_SYSTEM_PROPERTY = "persist.sys.timezone";
    private static final LocalLog sTimeZoneDebugLog = null;

    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeZoneConfidence {
    }

    static {
        sTimeZoneDebugLog = new LocalLog(30, false);
    }

    private SystemTimeZone() {
    }

    public static void initializeTimeZoneSettingsIfRequired() {
        String timezoneProperty = SystemProperties.get(TIME_ZONE_SYSTEM_PROPERTY);
        if (isValidTimeZoneId(timezoneProperty) == true) goto L6;
        String logInfo = "initializeTimeZoneSettingsIfRequired():persist.sys.timezone is not valid (" + timezoneProperty + "); setting to " + DEFAULT_TIME_ZONE_ID;
        Slog.w(TAG, logInfo);
        setTimeZoneId(DEFAULT_TIME_ZONE_ID, 0, logInfo);
        return;
    }

    public static void addDebugLogEntry(String logMsg) {
        sTimeZoneDebugLog.log(logMsg);
    }

    public static boolean setTimeZoneId(String timeZoneId, int confidence, String logInfo) {
        if (TextUtils.isEmpty(timeZoneId) == false) goto L5;
    L25:
        addDebugLogEntry("setTimeZoneId: Invalid time zone ID. timeZoneId=" + timeZoneId + ", confidence=" + confidence + ", logInfo=" + logInfo);
        return false;
    L5:
        if (isValidTimeZoneId(timeZoneId) == false) goto L25;
        boolean timeZoneChanged = false;
        monitor-enter(SystemTimeZone.class);
        String currentTimeZoneId = getTimeZoneId();     // Catch: Throwable -> L14
        int currentConfidence = getTimeZoneConfidence();     // Catch: Throwable -> L14
        if (currentTimeZoneId == null) goto L16;
        if (currentTimeZoneId.equals(timeZoneId) == false) goto L16;
    L17:
        boolean timeZoneConfidenceChanged = setTimeZoneConfidence(confidence);     // Catch: Throwable -> L14
        if (timeZoneChanged == true) goto L20;
        if (timeZoneConfidenceChanged == true) goto L20;
    L21:
        monitor-exit(SystemTimeZone.class);     // Catch: Throwable -> L14
        return timeZoneChanged;
    L20:
        String logMsg = "Time zone or confidence set:  (new) timeZoneId=" + timeZoneId + ", (new) confidence=" + confidence + ", (old) timeZoneId=" + currentTimeZoneId + ", (old) confidence=" + currentConfidence + ", logInfo=" + logInfo;     // Catch: Throwable -> L14
        addDebugLogEntry(logMsg);     // Catch: Throwable -> L14
    L16:
        SystemProperties.set(TIME_ZONE_SYSTEM_PROPERTY, timeZoneId);     // Catch: Throwable -> L14
        timeZoneChanged = true;
    L14:
        th = move-exception;
        throw th;
    }

    private static boolean setTimeZoneConfidence(int newConfidence) {
        int currentConfidence = getTimeZoneConfidence();
        if (currentConfidence == newConfidence) goto L6;
        SystemProperties.set(TIME_ZONE_CONFIDENCE_SYSTEM_PROPERTY, Integer.toString(newConfidence));
        return true;
    L6:
        return false;
    }

    public static int getTimeZoneConfidence() {
        int confidence = SystemProperties.getInt(TIME_ZONE_CONFIDENCE_SYSTEM_PROPERTY, 0);
        if (isValidTimeZoneConfidence(confidence) == true) goto L6;
        return 0;
    L6:
        return confidence;
    }

    public static String getTimeZoneId() {
        return SystemProperties.get(TIME_ZONE_SYSTEM_PROPERTY);
    }

    public static void dump(PrintWriter writer) {
        sTimeZoneDebugLog.dump(writer);
    }

    private static boolean isValidTimeZoneConfidence(int confidence) {
        if (confidence >= 0) goto L4;
    L6:
        return false;
    L4:
        if (confidence > 100) goto L6;
        return true;
    }

    private static boolean isValidTimeZoneId(String timeZoneId) {
        if (timeZoneId != null) goto L4;
    L8:
        return false;
    L4:
        if (timeZoneId.isEmpty() == true) goto L8;
        if (ZoneInfoDb.getInstance().hasTimeZone(timeZoneId) == false) goto L8;
        return true;
    }
}
