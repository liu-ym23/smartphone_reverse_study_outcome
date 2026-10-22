package com.android.server.blob;

import android.content.Context;
import android.os.Environment;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DataUnit;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import android.util.TimeUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
class BlobStoreConfig {
    private static final String BLOBS_DIR_NAME = "blobs";
    private static final String BLOBS_INDEX_FILE_NAME = "blobs_index.xml";
    public static final int IDLE_JOB_ID = 191934935;
    public static final long INVALID_BLOB_ID = 0;
    public static final long INVALID_BLOB_SIZE = 0;
    public static final boolean LOGV = false;
    private static final String ROOT_DIR_NAME = "blobstore";
    private static final String SESSIONS_INDEX_FILE_NAME = "sessions_index.xml";
    public static final String TAG = "BlobStore";
    public static final int XML_VERSION_ADD_COMMIT_TIME = 4;
    public static final int XML_VERSION_ADD_DESC_RES_NAME = 3;
    public static final int XML_VERSION_ADD_SESSION_CREATION_TIME = 5;
    public static final int XML_VERSION_ADD_STRING_DESC = 2;
    public static final int XML_VERSION_ALLOW_ACCESS_ACROSS_USERS = 6;
    public static final int XML_VERSION_CURRENT = 6;
    public static final int XML_VERSION_INIT = 1;

    public static class DeviceConfigProperties {
        public static long COMMIT_COOL_OFF_DURATION_MS = 0;
        public static final long DEFAULT_COMMIT_COOL_OFF_DURATION_MS = 0;
        public static final long DEFAULT_DELETE_ON_LAST_LEASE_DELAY_MS = 0;
        public static final long DEFAULT_IDLE_JOB_PERIOD_MS = 0;
        public static final long DEFAULT_LEASE_ACQUISITION_WAIT_DURATION_MS = 0;
        public static int DEFAULT_LEASE_DESC_CHAR_LIMIT = 0;
        public static int DEFAULT_MAX_ACTIVE_SESSIONS = 0;
        public static int DEFAULT_MAX_BLOB_ACCESS_PERMITTED_PACKAGES = 0;
        public static int DEFAULT_MAX_COMMITTED_BLOBS = 0;
        public static int DEFAULT_MAX_LEASED_BLOBS = 0;
        public static final long DEFAULT_SESSION_EXPIRY_TIMEOUT_MS = 0;
        public static final long DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FLOOR = 0;
        public static final float DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FRACTION = 0.01f;
        public static final boolean DEFAULT_USE_REVOCABLE_FD_FOR_READS = false;
        public static long DELETE_ON_LAST_LEASE_DELAY_MS = 0;
        public static long IDLE_JOB_PERIOD_MS = 0;
        public static final String KEY_COMMIT_COOL_OFF_DURATION_MS = "commit_cool_off_duration_ms";
        public static final String KEY_DELETE_ON_LAST_LEASE_DELAY_MS = "delete_on_last_lease_delay_ms";
        public static final String KEY_IDLE_JOB_PERIOD_MS = "idle_job_period_ms";
        public static final String KEY_LEASE_ACQUISITION_WAIT_DURATION_MS = "lease_acquisition_wait_time_ms";
        public static final String KEY_LEASE_DESC_CHAR_LIMIT = "lease_desc_char_limit";
        public static final String KEY_MAX_ACTIVE_SESSIONS = "max_active_sessions";
        public static final String KEY_MAX_BLOB_ACCESS_PERMITTED_PACKAGES = "max_permitted_pks";
        public static final String KEY_MAX_COMMITTED_BLOBS = "max_committed_blobs";
        public static final String KEY_MAX_LEASED_BLOBS = "max_leased_blobs";
        public static final String KEY_SESSION_EXPIRY_TIMEOUT_MS = "session_expiry_timeout_ms";
        public static final String KEY_TOTAL_BYTES_PER_APP_LIMIT_FLOOR = "total_bytes_per_app_limit_floor";
        public static final String KEY_TOTAL_BYTES_PER_APP_LIMIT_FRACTION = "total_bytes_per_app_limit_fraction";
        public static final String KEY_USE_REVOCABLE_FD_FOR_READS = "use_revocable_fd_for_reads";
        public static long LEASE_ACQUISITION_WAIT_DURATION_MS;
        public static int LEASE_DESC_CHAR_LIMIT;
        public static int MAX_ACTIVE_SESSIONS;
        public static int MAX_BLOB_ACCESS_PERMITTED_PACKAGES;
        public static int MAX_COMMITTED_BLOBS;
        public static int MAX_LEASED_BLOBS;
        public static long SESSION_EXPIRY_TIMEOUT_MS;
        public static long TOTAL_BYTES_PER_APP_LIMIT_FLOOR;
        public static float TOTAL_BYTES_PER_APP_LIMIT_FRACTION;
        public static boolean USE_REVOCABLE_FD_FOR_READS;

        public static /* synthetic */ void $r8$lambda$unYz3hyV5nejxKvtymKhcBV8QJ4(DeviceConfig.Properties r0, String r1) {
            lambda$refresh$0(r0, r1);
        }

        public DeviceConfigProperties() {
        }

        static {
            DEFAULT_IDLE_JOB_PERIOD_MS = TimeUnit.DAYS.toMillis(1);
            IDLE_JOB_PERIOD_MS = DEFAULT_IDLE_JOB_PERIOD_MS;
            DEFAULT_SESSION_EXPIRY_TIMEOUT_MS = TimeUnit.DAYS.toMillis(7);
            SESSION_EXPIRY_TIMEOUT_MS = DEFAULT_SESSION_EXPIRY_TIMEOUT_MS;
            DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FLOOR = DataUnit.MEBIBYTES.toBytes(300);
            TOTAL_BYTES_PER_APP_LIMIT_FLOOR = DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FLOOR;
            TOTAL_BYTES_PER_APP_LIMIT_FRACTION = 0.01f;
            DEFAULT_LEASE_ACQUISITION_WAIT_DURATION_MS = TimeUnit.HOURS.toMillis(6);
            LEASE_ACQUISITION_WAIT_DURATION_MS = DEFAULT_LEASE_ACQUISITION_WAIT_DURATION_MS;
            DEFAULT_COMMIT_COOL_OFF_DURATION_MS = TimeUnit.HOURS.toMillis(48);
            COMMIT_COOL_OFF_DURATION_MS = DEFAULT_COMMIT_COOL_OFF_DURATION_MS;
            USE_REVOCABLE_FD_FOR_READS = false;
            DEFAULT_DELETE_ON_LAST_LEASE_DELAY_MS = TimeUnit.HOURS.toMillis(6);
            DELETE_ON_LAST_LEASE_DELAY_MS = DEFAULT_DELETE_ON_LAST_LEASE_DELAY_MS;
            DEFAULT_MAX_ACTIVE_SESSIONS = 250;
            MAX_ACTIVE_SESSIONS = DEFAULT_MAX_ACTIVE_SESSIONS;
            DEFAULT_MAX_COMMITTED_BLOBS = 1000;
            MAX_COMMITTED_BLOBS = DEFAULT_MAX_COMMITTED_BLOBS;
            DEFAULT_MAX_LEASED_BLOBS = 500;
            MAX_LEASED_BLOBS = DEFAULT_MAX_LEASED_BLOBS;
            DEFAULT_MAX_BLOB_ACCESS_PERMITTED_PACKAGES = 300;
            MAX_BLOB_ACCESS_PERMITTED_PACKAGES = DEFAULT_MAX_BLOB_ACCESS_PERMITTED_PACKAGES;
            DEFAULT_LEASE_DESC_CHAR_LIMIT = 300;
            LEASE_DESC_CHAR_LIMIT = DEFAULT_LEASE_DESC_CHAR_LIMIT;
        }

        static void refresh(final DeviceConfig.Properties properties) {
            if (BlobStoreConfig.ROOT_DIR_NAME.equals(properties.getNamespace()) == true) goto L5;
            return;
        L5:
            properties.getKeyset().forEach(new BlobStoreConfig$DeviceConfigProperties$$ExternalSyntheticLambda0(properties));
        }

        private static /* synthetic */ void lambda$refresh$0(DeviceConfig.Properties properties, String key) {
            switch(key.hashCode()) {
                case -1925137189: goto L42;
                case -1390984180: goto L39;
                case -409761467: goto L36;
                case -284382148: goto L33;
                case 12210070: goto L30;
                case 271099507: goto L27;
                case 964101945: goto L24;
                case 1401805851: goto L21;
                case 1419134232: goto L18;
                case 1733063605: goto L15;
                case 1838729636: goto L12;
                case 1903375799: goto L9;
                case 2022996583: goto L6;
                default: goto L44;
            };
        L44:
            byte r0 = -1;
        L45:
            switch(r0) {
                case 0: goto L59;
                case 1: goto L58;
                case 2: goto L57;
                case 3: goto L56;
                case 4: goto L55;
                case 5: goto L54;
                case 6: goto L53;
                case 7: goto L52;
                case 8: goto L51;
                case 9: goto L50;
                case 10: goto L49;
                case 11: goto L48;
                case 12: goto L47;
                default: goto L46;
            };
        L46:
            Slog.wtf(BlobStoreConfig.TAG, "Unknown key in device config properties: " + key);
            return;
        L47:
            LEASE_DESC_CHAR_LIMIT = properties.getInt(key, DEFAULT_LEASE_DESC_CHAR_LIMIT);
            return;
        L48:
            MAX_BLOB_ACCESS_PERMITTED_PACKAGES = properties.getInt(key, DEFAULT_MAX_BLOB_ACCESS_PERMITTED_PACKAGES);
            return;
        L49:
            MAX_LEASED_BLOBS = properties.getInt(key, DEFAULT_MAX_LEASED_BLOBS);
            return;
        L50:
            MAX_COMMITTED_BLOBS = properties.getInt(key, DEFAULT_MAX_COMMITTED_BLOBS);
            return;
        L51:
            MAX_ACTIVE_SESSIONS = properties.getInt(key, DEFAULT_MAX_ACTIVE_SESSIONS);
            return;
        L52:
            DELETE_ON_LAST_LEASE_DELAY_MS = properties.getLong(key, DEFAULT_DELETE_ON_LAST_LEASE_DELAY_MS);
            return;
        L53:
            USE_REVOCABLE_FD_FOR_READS = properties.getBoolean(key, false);
            return;
        L54:
            COMMIT_COOL_OFF_DURATION_MS = properties.getLong(key, DEFAULT_COMMIT_COOL_OFF_DURATION_MS);
            return;
        L55:
            LEASE_ACQUISITION_WAIT_DURATION_MS = properties.getLong(key, DEFAULT_LEASE_ACQUISITION_WAIT_DURATION_MS);
            return;
        L56:
            TOTAL_BYTES_PER_APP_LIMIT_FRACTION = properties.getFloat(key, 0.01f);
            return;
        L57:
            TOTAL_BYTES_PER_APP_LIMIT_FLOOR = properties.getLong(key, DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FLOOR);
            return;
        L58:
            SESSION_EXPIRY_TIMEOUT_MS = properties.getLong(key, DEFAULT_SESSION_EXPIRY_TIMEOUT_MS);
            return;
        L59:
            IDLE_JOB_PERIOD_MS = properties.getLong(key, DEFAULT_IDLE_JOB_PERIOD_MS);
            return;
        L6:
            if (key.equals(KEY_SESSION_EXPIRY_TIMEOUT_MS) == false) goto L44;
            r0 = 1;
            goto L45
        L9:
            if (key.equals(KEY_IDLE_JOB_PERIOD_MS) == false) goto L44;
            r0 = 0;
            goto L45
        L12:
            if (key.equals(KEY_DELETE_ON_LAST_LEASE_DELAY_MS) == false) goto L44;
            r0 = 7;
            goto L45
        L15:
            if (key.equals(KEY_TOTAL_BYTES_PER_APP_LIMIT_FRACTION) == false) goto L44;
            r0 = 3;
            goto L45
        L18:
            if (key.equals(KEY_MAX_COMMITTED_BLOBS) == false) goto L44;
            r0 = 9;
            goto L45
        L21:
            if (key.equals(KEY_LEASE_DESC_CHAR_LIMIT) == false) goto L44;
            r0 = 12;
            goto L45
        L24:
            if (key.equals(KEY_TOTAL_BYTES_PER_APP_LIMIT_FLOOR) == false) goto L44;
            r0 = 2;
            goto L45
        L27:
            if (key.equals(KEY_COMMIT_COOL_OFF_DURATION_MS) == false) goto L44;
            r0 = 5;
            goto L45
        L30:
            if (key.equals(KEY_MAX_BLOB_ACCESS_PERMITTED_PACKAGES) == false) goto L44;
            r0 = 11;
            goto L45
        L33:
            if (key.equals(KEY_MAX_LEASED_BLOBS) == false) goto L44;
            r0 = 10;
            goto L45
        L36:
            if (key.equals(KEY_LEASE_ACQUISITION_WAIT_DURATION_MS) == false) goto L44;
            r0 = 4;
            goto L45
        L39:
            if (key.equals(KEY_USE_REVOCABLE_FD_FOR_READS) == false) goto L44;
            r0 = 6;
            goto L45
        L42:
            if (key.equals(KEY_MAX_ACTIVE_SESSIONS) == false) goto L44;
            r0 = 8;
            goto L45
        }

        static void dump(IndentingPrintWriter fout, Context context) {
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_IDLE_JOB_PERIOD_MS, TimeUtils.formatDuration(IDLE_JOB_PERIOD_MS), TimeUtils.formatDuration(DEFAULT_IDLE_JOB_PERIOD_MS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_SESSION_EXPIRY_TIMEOUT_MS, TimeUtils.formatDuration(SESSION_EXPIRY_TIMEOUT_MS), TimeUtils.formatDuration(DEFAULT_SESSION_EXPIRY_TIMEOUT_MS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_TOTAL_BYTES_PER_APP_LIMIT_FLOOR, Formatter.formatFileSize(context, TOTAL_BYTES_PER_APP_LIMIT_FLOOR, 8), Formatter.formatFileSize(context, DEFAULT_TOTAL_BYTES_PER_APP_LIMIT_FLOOR, 8)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_TOTAL_BYTES_PER_APP_LIMIT_FRACTION, Float.valueOf(TOTAL_BYTES_PER_APP_LIMIT_FRACTION), Float.valueOf(0.01f)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_LEASE_ACQUISITION_WAIT_DURATION_MS, TimeUtils.formatDuration(LEASE_ACQUISITION_WAIT_DURATION_MS), TimeUtils.formatDuration(DEFAULT_LEASE_ACQUISITION_WAIT_DURATION_MS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_COMMIT_COOL_OFF_DURATION_MS, TimeUtils.formatDuration(COMMIT_COOL_OFF_DURATION_MS), TimeUtils.formatDuration(DEFAULT_COMMIT_COOL_OFF_DURATION_MS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_USE_REVOCABLE_FD_FOR_READS, Boolean.valueOf(USE_REVOCABLE_FD_FOR_READS), false}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_DELETE_ON_LAST_LEASE_DELAY_MS, TimeUtils.formatDuration(DELETE_ON_LAST_LEASE_DELAY_MS), TimeUtils.formatDuration(DEFAULT_DELETE_ON_LAST_LEASE_DELAY_MS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_MAX_ACTIVE_SESSIONS, Integer.valueOf(MAX_ACTIVE_SESSIONS), Integer.valueOf(DEFAULT_MAX_ACTIVE_SESSIONS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_MAX_COMMITTED_BLOBS, Integer.valueOf(MAX_COMMITTED_BLOBS), Integer.valueOf(DEFAULT_MAX_COMMITTED_BLOBS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_MAX_LEASED_BLOBS, Integer.valueOf(MAX_LEASED_BLOBS), Integer.valueOf(DEFAULT_MAX_LEASED_BLOBS)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_MAX_BLOB_ACCESS_PERMITTED_PACKAGES, Integer.valueOf(MAX_BLOB_ACCESS_PERMITTED_PACKAGES), Integer.valueOf(DEFAULT_MAX_BLOB_ACCESS_PERMITTED_PACKAGES)}));
            fout.println(String.format("%s: [cur: %s, def: %s]", new Object[]{KEY_LEASE_DESC_CHAR_LIMIT, Integer.valueOf(LEASE_DESC_CHAR_LIMIT), Integer.valueOf(DEFAULT_LEASE_DESC_CHAR_LIMIT)}));
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$r6TZApuZXpXDzy6YJZ-MqvXnpq8, reason: not valid java name */
    public static /* synthetic */ void m2762$r8$lambda$r6TZApuZXpXDzy6YJZMqvXnpq8(DeviceConfig.Properties r0) {
        lambda$initialize$0(r0);
    }

    BlobStoreConfig() {
    }

    static {
        LOGV = Log.isLoggable(TAG, 2);
    }

    public static void initialize(Context context) {
        DeviceConfig.addOnPropertiesChangedListener(ROOT_DIR_NAME, context.getMainExecutor(), new BlobStoreConfig$$ExternalSyntheticLambda0());
        DeviceConfigProperties.refresh(DeviceConfig.getProperties(ROOT_DIR_NAME, new String[0]));
    }

    private static /* synthetic */ void lambda$initialize$0(DeviceConfig.Properties properties) {
        DeviceConfigProperties.refresh(properties);
    }

    public static long getIdleJobPeriodMs() {
        return DeviceConfigProperties.IDLE_JOB_PERIOD_MS;
    }

    public static boolean hasSessionExpired(long sessionLastModifiedMs) {
        if (sessionLastModifiedMs >= (System.currentTimeMillis() - DeviceConfigProperties.SESSION_EXPIRY_TIMEOUT_MS)) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getAppDataBytesLimit() {
        long totalBytesLimit = (long) (Environment.getDataSystemDirectory().getTotalSpace() * DeviceConfigProperties.TOTAL_BYTES_PER_APP_LIMIT_FRACTION);
        return Math.max(DeviceConfigProperties.TOTAL_BYTES_PER_APP_LIMIT_FLOOR, totalBytesLimit);
    }

    public static boolean hasLeaseWaitTimeElapsed(long commitTimeMs) {
        if ((DeviceConfigProperties.LEASE_ACQUISITION_WAIT_DURATION_MS + commitTimeMs) >= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getAdjustedCommitTimeMs(long oldCommitTimeMs, long newCommitTimeMs) {
        if (oldCommitTimeMs != 0) goto L5;
    L8:
        return newCommitTimeMs;
    L5:
        if (hasCommitCoolOffPeriodElapsed(oldCommitTimeMs) == true) goto L8;
        return oldCommitTimeMs;
    }

    private static boolean hasCommitCoolOffPeriodElapsed(long commitTimeMs) {
        if ((DeviceConfigProperties.COMMIT_COOL_OFF_DURATION_MS + commitTimeMs) >= System.currentTimeMillis()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean shouldUseRevocableFdForReads() {
        return DeviceConfigProperties.USE_REVOCABLE_FD_FOR_READS;
    }

    public static long getDeletionOnLastLeaseDelayMs() {
        return DeviceConfigProperties.DELETE_ON_LAST_LEASE_DELAY_MS;
    }

    public static int getMaxActiveSessions() {
        return DeviceConfigProperties.MAX_ACTIVE_SESSIONS;
    }

    public static int getMaxCommittedBlobs() {
        return DeviceConfigProperties.MAX_COMMITTED_BLOBS;
    }

    public static int getMaxLeasedBlobs() {
        return DeviceConfigProperties.MAX_LEASED_BLOBS;
    }

    public static int getMaxPermittedPackages() {
        return DeviceConfigProperties.MAX_BLOB_ACCESS_PERMITTED_PACKAGES;
    }

    public static CharSequence getTruncatedLeaseDescription(CharSequence description) {
        if (TextUtils.isEmpty(description) == false) goto L6;
        return description;
    L6:
        return TextUtils.trimToLengthWithEllipsis(description, DeviceConfigProperties.LEASE_DESC_CHAR_LIMIT);
    }

    public static File prepareBlobFile(long sessionId) {
        File blobsDir = prepareBlobsDir();
        if (blobsDir != null) goto L6;
        return null;
    L6:
        return getBlobFile(blobsDir, sessionId);
    }

    public static File getBlobFile(long sessionId) {
        return getBlobFile(getBlobsDir(), sessionId);
    }

    private static File getBlobFile(File blobsDir, long sessionId) {
        return new File(blobsDir, String.valueOf(sessionId));
    }

    public static File prepareBlobsDir() {
        File blobsDir = getBlobsDir(prepareBlobStoreRootDir());
        if (blobsDir.exists() == false) goto L5;
    L8:
        return blobsDir;
    L5:
        if (blobsDir.mkdir() == true) goto L8;
        Slog.e(TAG, "Failed to mkdir(): " + blobsDir);
        return null;
    }

    public static File getBlobsDir() {
        return getBlobsDir(getBlobStoreRootDir());
    }

    private static File getBlobsDir(File blobsRootDir) {
        return new File(blobsRootDir, BLOBS_DIR_NAME);
    }

    public static File prepareSessionIndexFile() {
        File blobStoreRootDir = prepareBlobStoreRootDir();
        if (blobStoreRootDir != null) goto L7;
        return null;
    L7:
        return new File(blobStoreRootDir, SESSIONS_INDEX_FILE_NAME);
    }

    public static File prepareBlobsIndexFile() {
        File blobsStoreRootDir = prepareBlobStoreRootDir();
        if (blobsStoreRootDir != null) goto L7;
        return null;
    L7:
        return new File(blobsStoreRootDir, BLOBS_INDEX_FILE_NAME);
    }

    public static File prepareBlobStoreRootDir() {
        File blobStoreRootDir = getBlobStoreRootDir();
        if (blobStoreRootDir.exists() == false) goto L5;
    L8:
        return blobStoreRootDir;
    L5:
        if (blobStoreRootDir.mkdir() == true) goto L8;
        Slog.e(TAG, "Failed to mkdir(): " + blobStoreRootDir);
        return null;
    }

    public static File getBlobStoreRootDir() {
        return new File(Environment.getDataSystemDirectory(), ROOT_DIR_NAME);
    }

    public static void dump(IndentingPrintWriter fout, Context context) {
        fout.println("XML current version: 6");
        fout.println("Idle job ID: 191934935");
        fout.println("Total bytes per app limit: " + Formatter.formatFileSize(context, getAppDataBytesLimit(), 8));
        fout.println("Device config properties:");
        fout.increaseIndent();
        DeviceConfigProperties.dump(fout, context);
        fout.decreaseIndent();
    }
}
