package com.android.server.backup.utils;

import android.app.backup.BackupRestoreEventLogger;
import android.os.Bundle;
import android.os.Environment;
import android.util.Slog;
import com.android.internal.util.FastPrintWriter;
import com.android.server.slice.SliceClientPermissions;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class BackupManagerMonitorDumpsysUtils {
    private static final String BACKUP_PERSISTENT_DIR = "backup";
    private static final long BMM_FILE_SIZE_LIMIT_BYTES = 25600000;
    private static final String INITIAL_SETUP_TIMESTAMP_KEY = "initialSetupTimestamp";
    private static final long LOGS_RETENTION_PERIOD_MILLISEC = 0;
    private static final String TAG = "BackupManagerMonitorDumpsysUtils";
    private boolean mIsAfterRetentionPeriod;
    private boolean mIsAfterRetentionPeriodCached;
    private boolean mIsFileLargerThanSizeLimit;

    public BackupManagerMonitorDumpsysUtils() {
        this.mIsAfterRetentionPeriodCached = false;
        this.mIsFileLargerThanSizeLimit = false;
    }

    static {
        LOGS_RETENTION_PERIOD_MILLISEC = TimeUnit.DAYS.toMillis(1) * 60;
    }

    public void parseBackupManagerMonitorRestoreEventForDumpsys(Bundle eventBundle) {
        if (isAfterRetentionPeriod() == false) goto L5;
        return;
    L5:
        if (eventBundle != null) goto L8;
        return;
    L8:
        if (isOpTypeRestore(eventBundle) == true) goto L11;
        return;
    L11:
        if (eventBundle.containsKey("android.app.backup.extra.LOG_EVENT_ID") == true) goto L13;
    L55:
        Slog.w(TAG, "Event id and category are not optional fields.");
        return;
    L13:
        if (eventBundle.containsKey("android.app.backup.extra.LOG_EVENT_CATEGORY") == false) goto L55;
        File bmmEvents = getBMMEventsFile();
        if (bmmEvents.length() != 0) goto L19;
        recordSetUpTimestamp();
    L19:
        if (isFileLargerThanSizeLimit(bmmEvents) == false) goto L60;
        return;
    L60:
        FileOutputStream out = new FileOutputStream(bmmEvents, true);     // Catch: IOException -> L30
        FastPrintWriter r6 = new FastPrintWriter(out);     // Catch: Throwable -> L32
        eventBundle.getInt("android.app.backup.extra.LOG_EVENT_CATEGORY");     // Catch: Throwable -> L34
        int eventId = eventBundle.getInt("android.app.backup.extra.LOG_EVENT_ID");     // Catch: Throwable -> L34
        if (eventId == 52) goto L26;
    L36:
        r6.println("[" + timestamp() + "] - " + getId(eventId));     // Catch: Throwable -> L34
        if (eventBundle.containsKey("android.app.backup.extra.LOG_EVENT_PACKAGE_NAME") == false) goto L39;
        r6.println("\tPackage: " + eventBundle.getString("android.app.backup.extra.LOG_EVENT_PACKAGE_NAME"));     // Catch: Throwable -> L34
    L39:
        addAgentLogsIfAvailable(eventBundle, r6);     // Catch: Throwable -> L34
        addExtrasIfAvailable(eventBundle, r6);     // Catch: Throwable -> L34
        r6.close();     // Catch: Throwable -> L32
        out.close();     // Catch: IOException -> L30
        return;
    L26:
        if (hasAgentLogging(eventBundle) == true) goto L36;
        r6.close();     // Catch: Throwable -> L32
        out.close();     // Catch: IOException -> L30
        return;
    L34:
        th = move-exception;
        r6.close();     // Catch: Throwable -> L45
    L47:
        throw th;     // Catch: Throwable -> L32
    L45:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        out.close();     // Catch: Throwable -> L50
    L52:
        throw th;     // Catch: IOException -> L30
    L50:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
    L30:
        e = move-exception;
        Slog.e(TAG, "IO Exception when writing BMM events to file: " + e);
    }

    private boolean hasAgentLogging(Bundle eventBundle) {
        if (eventBundle.containsKey("android.app.backup.extra.LOG_AGENT_LOGGING_RESULTS") == false) goto L6;
        ArrayList<BackupRestoreEventLogger.DataTypeResult> agentLogs = eventBundle.getParcelableArrayList("android.app.backup.extra.LOG_AGENT_LOGGING_RESULTS");
        return !agentLogs.isEmpty();
    L6:
        return false;
    }

    private void addAgentLogsIfAvailable(Bundle eventBundle, PrintWriter pw) {
        if (hasAgentLogging(eventBundle) == false) goto L12;
        pw.println("\tAgent Logs:");
        ArrayList<BackupRestoreEventLogger.DataTypeResult> agentLogs = eventBundle.getParcelableArrayList("android.app.backup.extra.LOG_AGENT_LOGGING_RESULTS");
        Iterator<BackupRestoreEventLogger.DataTypeResult> r1 = agentLogs.iterator();
    L6:
        if (r1.hasNext() == false) goto L15;
        BackupRestoreEventLogger.DataTypeResult result = r1.next();
        int totalItems = result.getFailCount() + result.getSuccessCount();
        pw.println("\t\tData Type: " + result.getDataType());
        pw.println("\t\t\tItem restored: " + result.getSuccessCount() + SliceClientPermissions.SliceAuthority.DELIMITER + totalItems);
        Iterator r4 = result.getErrors().entrySet().iterator();
    L9:
        if (r4.hasNext() == false) goto L6;
        Map.Entry<String, Integer> entry = (Map.Entry) r4.next();
        pw.println("\t\t\tAgent Error - Category: " + entry.getKey() + ", Count: " + entry.getValue());
        goto L9
    L15:
        return;
    }

    private void addExtrasIfAvailable(Bundle eventBundle, PrintWriter pw) {
        if (eventBundle.getInt("android.app.backup.extra.LOG_EVENT_ID") != 27) goto L14;
        if (eventBundle.containsKey("android.app.backup.extra.LOG_RESTORE_ANYWAY") == false) goto L8;
        pw.println("\t\tPackage supports RestoreAnyVersion: " + eventBundle.getBoolean("android.app.backup.extra.LOG_RESTORE_ANYWAY"));
    L8:
        if (eventBundle.containsKey("android.app.backup.extra.LOG_RESTORE_VERSION") == false) goto L11;
        pw.println("\t\tPackage version on source: " + eventBundle.getLong("android.app.backup.extra.LOG_RESTORE_VERSION"));
    L11:
        if (eventBundle.containsKey("android.app.backup.extra.LOG_EVENT_PACKAGE_FULL_VERSION") == false) goto L14;
        pw.println("\t\tPackage version on target: " + eventBundle.getLong("android.app.backup.extra.LOG_EVENT_PACKAGE_FULL_VERSION"));
    L14:
        if (eventBundle.getInt("android.app.backup.extra.LOG_EVENT_ID") == 72) goto L16;
        return;
    L16:
        if (eventBundle.containsKey("android.app.backup.extra.V_TO_U_DENYLIST") == false) goto L19;
        pw.println("\t\tV to U Denylist : " + eventBundle.getString("android.app.backup.extra.V_TO_U_DENYLIST"));
    L19:
        if (eventBundle.containsKey("android.app.backup.extra.V_TO_U_ALLOWLIST") == false) goto L23;
        pw.println("\t\tV to U Allowllist : " + eventBundle.getString("android.app.backup.extra.V_TO_U_ALLOWLIST"));
        return;
    }

    public File getBMMEventsFile() {
        File dataDir = new File(Environment.getDataDirectory(), "backup");
        File fname = new File(dataDir, "bmmevents.txt");
        return fname;
    }

    public boolean isFileLargerThanSizeLimit(File events) {
        if (this.mIsFileLargerThanSizeLimit == true) goto L10;
        if (events.length() <= getBMMEventsFileSizeLimit()) goto L7;
        boolean r0 = true;
    L8:
        this.mIsFileLargerThanSizeLimit = r0;
        goto L10
    L7:
        r0 = false;
    L10:
        return this.mIsFileLargerThanSizeLimit;
    }

    private String timestamp() {
        long currentTime = System.currentTimeMillis();
        Date date = new Date(currentTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return dateFormat.format(date);
    }

    private String getCategory(int code) {
        switch(code) {
            case 1: goto L6;
            case 2: goto L5;
            case 3: goto L4;
            default: goto L3;
        };
    L3:
        String category = "Unknown category code: " + code;
        return category;
    L4:
        return "Backup Manager Policy";
    L5:
        return "Agent";
    L6:
        return "Transport";
    }

    private String getId(int code) {
        switch(code) {
            case 4: goto L76;
            case 5: goto L75;
            case 6: goto L3;
            case 7: goto L74;
            case 8: goto L3;
            case 9: goto L73;
            case 10: goto L72;
            case 11: goto L71;
            case 12: goto L70;
            case 13: goto L69;
            case 14: goto L68;
            case 15: goto L67;
            case 16: goto L66;
            case 17: goto L3;
            case 18: goto L65;
            case 19: goto L64;
            case 20: goto L3;
            case 21: goto L63;
            case 22: goto L62;
            case 23: goto L61;
            case 24: goto L60;
            case 25: goto L59;
            case 26: goto L58;
            case 27: goto L57;
            case 28: goto L56;
            case 29: goto L55;
            case 30: goto L54;
            case 31: goto L53;
            case 32: goto L3;
            case 33: goto L3;
            case 34: goto L52;
            case 35: goto L51;
            case 36: goto L50;
            case 37: goto L49;
            case 38: goto L48;
            case 39: goto L47;
            case 40: goto L46;
            case 41: goto L45;
            case 42: goto L44;
            case 43: goto L43;
            case 44: goto L42;
            case 45: goto L41;
            case 46: goto L40;
            case 47: goto L39;
            case 48: goto L38;
            case 49: goto L37;
            case 50: goto L36;
            case 51: goto L35;
            case 52: goto L34;
            case 53: goto L33;
            case 54: goto L32;
            case 55: goto L31;
            case 56: goto L30;
            case 57: goto L29;
            case 58: goto L28;
            case 59: goto L27;
            case 60: goto L26;
            case 61: goto L25;
            case 62: goto L24;
            case 63: goto L23;
            case 64: goto L22;
            case 65: goto L21;
            case 66: goto L20;
            case 67: goto L19;
            case 68: goto L18;
            case 69: goto L17;
            case 70: goto L16;
            case 71: goto L15;
            case 72: goto L14;
            case 73: goto L13;
            case 74: goto L12;
            case 75: goto L11;
            case 76: goto L10;
            case 77: goto L9;
            case 78: goto L8;
            case 79: goto L7;
            case 80: goto L6;
            case 81: goto L5;
            case 82: goto L4;
            default: goto L3;
        };
    L3:
        String id = "Unknown log event ID: " + code;
        return id;
    L4:
        return "LOG_EVENT_ID_FULL_BACKUP_AGENT_PIPE_BROKEN";
    L5:
        return "Failed to read data from Transport";
    L6:
        return "Agent failure during restore";
    L7:
        return "Failed to send data to agent";
    L8:
        return "Agent crashed before restore data is streamed";
    L9:
        return "Unable to create Agent";
    L10:
        return "Restore data does not belong to package";
    L11:
        return "Pkg accepted for restore";
    L12:
        return "Skip restore at install";
    L13:
        return "Invoked restore at install";
    L14:
        return "V to U restore lists";
    L15:
        return "V to U restore pkg not eligible";
    L16:
        return "V to U restore pkg eligible";
    L17:
        return "Agent failure";
    L18:
        return "Restore complete";
    L19:
        return "Start package restore";
    L20:
        return "Transport error full restore";
    L21:
        return "Full agent error";
    L22:
        return "No feeder thread";
    L23:
        return "Transport error KV restore";
    L24:
        return "Package restore finished";
    L25:
        return "KV agent error";
    L26:
        return "No next restore target";
    L27:
        return "Full restore";
    L28:
        return "KV restore";
    L29:
        return "Unknown restore type";
    L30:
        return "Cannot get next package name";
    L31:
        return "Transport error during start restore";
    L32:
        return "Start restore at install";
    L33:
        return "Start system restore";
    L34:
        return "Agent logging results";
    L35:
        return "Transport non-incremental backup required";
    L36:
        return "Transport is null";
    L37:
        return "No packages";
    L38:
        return "Widget unknown version";
    L39:
        return "Widget metadata mismatch";
    L40:
        return "Corrupt manifest";
    L41:
        return "Full restore timeout";
    L42:
        return "Unknown version";
    L43:
        return "Expected different package";
    L44:
        return "Missing signature";
    L45:
        return "Cannot restore without APK";
    L46:
        return "APK not installed";
    L47:
        return "Full restore allow backup false";
    L48:
        return "System app no agent";
    L49:
        return "Full restore signature mismatch";
    L50:
        return "Version of backup older";
    L51:
        return "Versions match";
    L52:
        return "Restore any version";
    L53:
        return "Key-value restore timeout";
    L54:
        return "Can't find agent";
    L55:
        return "Signature mismatch";
    L56:
        return "App has no agent";
    L57:
        return "Restore version higher";
    L58:
        return "Package not present";
    L59:
        return "Lost transport";
    L60:
        return "PM agent has no metadata";
    L61:
        return "No PM metadata received";
    L62:
        return "No restore metadata available";
    L63:
        return "Key-value backup cancel";
    L64:
        return "Exception full backup";
    L65:
        return "Quota hit preflight";
    L66:
        return "Error preflight";
    L67:
        return "Package transport not present";
    L68:
        return "Device not provisioned";
    L69:
        return "Backup disabled";
    L70:
        return "Package not found";
    L71:
        return "Package stopped";
    L72:
        return "Package key-value participant";
    L73:
        return "Package ineligible";
    L74:
        return "No data to send";
    L75:
        return "Illegal key";
    L76:
        return "Full backup cancel";
    }

    private boolean isOpTypeRestore(Bundle eventBundle) {
        switch(eventBundle.getInt("android.app.backup.extra.OPERATION_TYPE", -1)) {
            case 1: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        return true;
    }

    void recordSetUpTimestamp() {
        File setupDateFile = getSetUpDateFile();
        if (setupDateFile.length() != 0) goto L35;
        FileOutputStream out = new FileOutputStream(setupDateFile, true);     // Catch: IOException -> L10
        FastPrintWriter r2 = new FastPrintWriter(out);     // Catch: Throwable -> L12
        long currentDate = System.currentTimeMillis();     // Catch: Throwable -> L14
        r2.println(currentDate);     // Catch: Throwable -> L14
        r2.close();     // Catch: Throwable -> L12
        out.close();     // Catch: IOException -> L10
        return;
    L14:
        th = move-exception;
        r2.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Throwable -> L12
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        out.close();     // Catch: Throwable -> L22
    L24:
        throw th;     // Catch: IOException -> L10
    L22:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.w(TAG, "An error occurred while recording the setup date: " + e.getMessage());
        return;
    }

    String getSetUpDate() {
        File fname = getSetUpDateFile();
        FileInputStream inputStream = new FileInputStream(fname);     // Catch: Exception -> L11
        InputStreamReader reader = new InputStreamReader(inputStream);     // Catch: Throwable -> L13
        BufferedReader bufferedReader = new BufferedReader(reader);     // Catch: Throwable -> L15
        String r4 = bufferedReader.readLine();     // Catch: Throwable -> L17
        bufferedReader.close();     // Catch: Throwable -> L15
        reader.close();     // Catch: Throwable -> L13
        inputStream.close();     // Catch: Exception -> L11
        return r4;
    L17:
        th = move-exception;
        bufferedReader.close();     // Catch: Throwable -> L20
    L22:
        throw th;     // Catch: Throwable -> L15
    L20:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L25
    L27:
        throw th;     // Catch: Throwable -> L13
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L30
    L32:
        throw th;     // Catch: Exception -> L11
    L30:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        Slog.w(TAG, "An error occurred while reading the date: " + e.getMessage());
        return "Could not retrieve setup date";
    }

    static boolean isDateAfterNMillisec(long startTimeStamp, long endTimeStamp, long millisec) {
        if (startTimeStamp <= endTimeStamp) goto L5;
        return true;
    L5:
        long timeDifferenceMillis = endTimeStamp - startTimeStamp;
        if (timeDifferenceMillis >= millisec) goto L10;
        return false;
    L10:
        return true;
    }

    boolean isAfterRetentionPeriod() {
        if (this.mIsAfterRetentionPeriodCached == true) goto L5;
        File setUpDateFile = getSetUpDateFile();
        if (setUpDateFile.length() != 0) goto L15;
        this.mIsAfterRetentionPeriod = false;
        this.mIsAfterRetentionPeriodCached = true;
        return false;
    L15:
        long setupTimestamp = Long.parseLong(getSetUpDate());     // Catch: NumberFormatException -> L12
        long currentTimestamp = System.currentTimeMillis();     // Catch: NumberFormatException -> L12
        this.mIsAfterRetentionPeriod = isDateAfterNMillisec(setupTimestamp, currentTimestamp, getRetentionPeriodInMillisec());     // Catch: NumberFormatException -> L12
        this.mIsAfterRetentionPeriodCached = true;     // Catch: NumberFormatException -> L12
        return this.mIsAfterRetentionPeriod;
    L13:
        this.mIsAfterRetentionPeriod = true;
        this.mIsAfterRetentionPeriodCached = true;
        return true;
    L5:
        return this.mIsAfterRetentionPeriod;
    }

    File getSetUpDateFile() {
        File dataDir = new File(Environment.getDataDirectory(), "backup");
        File setupDateFile = new File(dataDir, "initialSetupTimestamp.txt");
        return setupDateFile;
    }

    long getRetentionPeriodInMillisec() {
        return LOGS_RETENTION_PERIOD_MILLISEC;
    }

    long getBMMEventsFileSizeLimit() {
        return BMM_FILE_SIZE_LIMIT_BYTES;
    }

    public boolean deleteExpiredBMMEvents() {
        if (isAfterRetentionPeriod() == false) goto L15;
        File bmmEvents = getBMMEventsFile();     // Catch: Exception -> L11
        if (bmmEvents.exists() == true) goto L9;
    L14:
        return true;
    L9:
        if (bmmEvents.delete() == false) goto L13;
        Slog.i(TAG, "Deleted expired BMM Events");     // Catch: Exception -> L11
        goto L14
    L13:
        Slog.e(TAG, "Unable to delete expired BMM Events");     // Catch: Exception -> L11
        goto L14
    L15:
        return false;
    L18:
        return true;
    }
}
