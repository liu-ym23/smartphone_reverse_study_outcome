package com.android.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.DropBoxManager;
import android.os.Environment;
import android.os.FileUtils;
import android.os.MessageQueue;
import android.os.ParcelFileDescriptor;
import android.os.RecoverySystem;
import android.os.SystemProperties;
import android.provider.Downloads;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import android.util.AtomicFile;
import android.util.EventLog;
import android.util.Slog;
import android.util.Xml;
import android.util.proto.ProtoFieldFilter;
import android.util.proto.ProtoOutputStream;
import com.android.internal.logging.MetricsLogger;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.DropboxRateLimiter;
import com.android.server.am.SysMonitorSvcBridge;
import com.android.server.policy.PhoneWindowManager;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.tukaani.xz.LZMA2Options;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public class BootReceiver extends BroadcastReceiver {
    private static final String E2FSCK_FS_MODIFIED = "FILE SYSTEM WAS MODIFIED";
    private static final String ERROR_REPORT_TRACE_PIPE = "/sys/kernel/tracing/instances/bootreceiver/trace_pipe";
    private static final String F2FS_FSCK_FS_MODIFIED = "[FSCK] Unreachable";
    private static final String FSCK_PASS_PATTERN = "Pass ([1-9]E?):";
    private static final String FSCK_TREE_OPTIMIZATION_PATTERN = "Inode [0-9]+ extent tree.*could be shorter";
    private static final int FS_STAT_FSCK_FS_FIXED = 1024;
    private static final String FS_STAT_PATTERN = "fs_stat,[^,]*/([^/,]+),(0x[0-9a-fA-F]+)";
    private static final int GMSCORE_LASTK_LOG_SIZE = 196608;
    private static final int LASTK_LOG_SIZE = 0;
    private static final String LAST_HEADER_FILE = "last-header.txt";
    private static final String[] LAST_KMSG_FILES = null;
    private static final String LAST_SHUTDOWN_TIME_PATTERN = "powerctl_shutdown_time_ms:([0-9]+):([0-9]+)";
    private static final String LOG_FILES_FILE = "log-files.xml";
    private static final int LOG_SIZE = 0;
    private static final int MAX_ERROR_REPORTS = 8;
    private static final long MAX_TOMBSTONE_SIZE_BYTES = 0;
    private static final String METRIC_SHUTDOWN_TIME_START = "begin_shutdown";
    private static final String METRIC_SYSTEM_SERVER = "shutdown_system_server";
    private static final String[] MOUNT_DURATION_PROPS_POSTFIX = null;
    private static final String OLD_UPDATER_CLASS = "com.google.android.systemupdater.SystemUpdateReceiver";
    private static final String OLD_UPDATER_PACKAGE = "com.google.android.systemupdater";
    private static final String PROP_ART_LAST_FINGERPRINT = "persist.sys.art.last_fingerprint";
    private static final String SHUTDOWN_METRICS_FILE = "/data/system/shutdown-metrics.txt";
    private static final String SHUTDOWN_TRON_METRICS_PREFIX = "shutdown_";
    private static final String TAG = "BootReceiver";
    private static final String TAG_TOMBSTONE = "SYSTEM_TOMBSTONE";
    private static final String TAG_TOMBSTONE_PROTO = "SYSTEM_TOMBSTONE_PROTO";
    private static final String TAG_TOMBSTONE_PROTO_WITH_HEADERS = "SYSTEM_TOMBSTONE_PROTO_WITH_HEADERS";
    private static final String TAG_TRUNCATED = "[[TRUNCATED]]\n";
    private static final File TOMBSTONE_TMP_DIR = null;
    private static final int UMOUNT_STATUS_NOT_AVAILABLE = 4;
    private static final File lastHeaderFile = null;
    private static IBootReceiverSmtEx mSmtEx;
    private static final DropboxRateLimiter sDropboxRateLimiter = null;
    private static final AtomicFile sFile = null;
    private static int sSentReports;

    public static /* synthetic */ boolean $r8$lambda$Zri2IuICrAGgYshGpGnJP6dYFvU(Integer r0) {
        return lambda$createTempTombstoneWithoutMemory$0(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$mlogBootEvents, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m140$$Nest$mlogBootEvents(BootReceiver r0, Context r1) {
        r0.logBootEvents(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$mremoveOldUpdatePackages, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m141$$Nest$mremoveOldUpdatePackages(BootReceiver r0, Context r1) {
        r0.removeOldUpdatePackages(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsSentReports, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m142$$Nest$sfgetsSentReports() {
        return sSentReports;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputmSmtEx, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m143$$Nest$sfputmSmtEx(IBootReceiverSmtEx r0) {
        mSmtEx = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsSentReports, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m144$$Nest$sfputsSentReports(int r0) {
        sSentReports = r0;
    }

    public BootReceiver() {
    }

    static {
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L5;
        int r2 = 0;
    L6:
        LOG_SIZE = r2;
        if (SystemProperties.getInt("ro.debuggable", 0) != 1) goto L9;
        int r0 = GMSCORE_LASTK_LOG_SIZE;
    L10:
        LASTK_LOG_SIZE = r0;
        TOMBSTONE_TMP_DIR = new File("/data/tombstones");
        sFile = new AtomicFile(new File(Environment.getDataSystemDirectory(), LOG_FILES_FILE), "log-files");
        lastHeaderFile = new File(Environment.getDataSystemDirectory(), LAST_HEADER_FILE);
        MOUNT_DURATION_PROPS_POSTFIX = new String[]{"early", "default", "late"};
        LAST_KMSG_FILES = new String[]{"/sys/fs/pstore/console-ramoops", "/proc/last_kmsg"};
        sSentReports = 0;
        MAX_TOMBSTONE_SIZE_BYTES = DropBoxManagerService.DEFAULT_QUOTA_KB * 1024;
        sDropboxRateLimiter = new DropboxRateLimiter();
        mSmtEx = null;
        return;
    L9:
        r0 = 65536;
        goto L10
    L5:
        r2 = 6553600;
        goto L6
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if ("android.intent.action.BOOT_COMPLETED".equals(intent.getAction()) == true) goto L5;
        return;
    L5:
        new AnonymousClass1(this, context).start();
        FileDescriptor tracefd = Os.open(ERROR_REPORT_TRACE_PIPE, OsConstants.O_RDONLY, FrameworkStatsLog.NON_A11Y_TOOL_SERVICE_WARNING_REPORT);     // Catch: ErrnoException -> L9
        MessageQueue.OnFileDescriptorEventListener traceCallback = new AnonymousClass2(this);
        IoThread.get().getLooper().getQueue().addOnFileDescriptorEventListener(tracefd, 1, traceCallback);
        return;
    L9:
        e = move-exception;
        Slog.wtf(TAG, "Could not open /sys/kernel/tracing/instances/bootreceiver/trace_pipe", e);
    }

    private void removeOldUpdatePackages(Context context) {
        Downloads.removeAllDownloadsByPackage(context, OLD_UPDATER_PACKAGE, OLD_UPDATER_CLASS);
    }

    private static String getPreviousBootHeaders() {
        return FileUtils.readTextFile(lastHeaderFile, 0, null);
    L6:
        return null;
    }

    private static String getCurrentBootHeaders() throws IOException {
        StringBuilder r0 = new StringBuilder(512);
        r0.append("Build: ");
        r0.append(Build.FINGERPRINT);
        r0.append("\n");
        r0.append("Hardware: ");
        r0.append(Build.BOARD);
        r0.append("\n");
        r0.append("Revision: ");
        r0.append(SystemProperties.get("ro.revision", ""));
        r0.append("\n");
        r0.append("Bootloader: ");
        r0.append(Build.BOOTLOADER);
        r0.append("\n");
        r0.append("Radio: ");
        r0.append(Build.getRadioVersion());
        r0.append("\n");
        r0.append("Kernel: ");
        StringBuilder builder = r0.append(FileUtils.readTextFile(new File("/proc/version"), 1024, "...\n"));
        long pageSize = Os.sysconf(OsConstants._SC_PAGESIZE);
        if (pageSize == 4096) goto L5;
        builder.append("PageSize: ");
        builder.append(pageSize);
        builder.append("\n");
    L5:
        builder.append("\n");
        return builder.toString();
    }

    private static String getBootHeadersToLogAndUpdate() throws IOException {
        String oldHeaders = getPreviousBootHeaders();
        String newHeaders = getCurrentBootHeaders();
        FileUtils.stringToFile(lastHeaderFile, newHeaders);     // Catch: IOException -> L5
    L7:
        if (oldHeaders != null) goto L11;
        return "isPrevious: false\n" + newHeaders;
    L11:
        return "isPrevious: true\n" + oldHeaders;
    L5:
        e = move-exception;
        Slog.e(TAG, "Error writing " + lastHeaderFile, e);
        goto L7
    }

    private void logBootEvents(Context ctx) throws IOException {
        DropBoxManager db = (DropBoxManager) ctx.getSystemService("dropbox");
        String headers = getBootHeadersToLogAndUpdate();
        String bootReason = SystemProperties.get("ro.boot.bootreason", null);
        String currentFingerprint = SystemProperties.get("ro.build.fingerprint", "");
        if (currentFingerprint.isEmpty() == true) goto L5;
        SystemProperties.set(PROP_ART_LAST_FINGERPRINT, currentFingerprint);
    L5:
        String recovery = RecoverySystem.handleAftermath(ctx);
        if (recovery == null) goto L10;
        if (db == null) goto L10;
        db.addText("SYSTEM_RECOVERY_LOG", headers + recovery);
    L10:
        if (bootReason == null) goto L12;
        StringBuilder r4 = new StringBuilder(512);
        r4.append("\n");
        r4.append("Boot info:\n");
        r4.append("Last boot reason: ");
        r4.append(bootReason);
        r4.append("\n");
        String lastKmsgFooter = r4.toString();
        String lastKmsgFooter2 = lastKmsgFooter;
    L13:
        HashMap<String, Long> timestamps = readTimestamps();
        mSmtEx.logBootEvents(ctx, timestamps, headers);
        if (SystemProperties.getLong("ro.runtime.firstboot", 0) != 0) goto L20;
        String now = Long.toString(System.currentTimeMillis());
        SystemProperties.set("ro.runtime.firstboot", now);
        if (db == null) goto L18;
        db.addText("SYSTEM_BOOT", headers);
    L18:
        addLastkToDropBox(db, timestamps, headers, lastKmsgFooter2, "/proc/last_kmsg", -LASTK_LOG_SIZE, "SYSTEM_LAST_KMSG");
        addLastkToDropBox(db, timestamps, headers, lastKmsgFooter2, "/sys/fs/pstore/console-ramoops", -LASTK_LOG_SIZE, "SYSTEM_LAST_KMSG");
        addLastkToDropBox(db, timestamps, headers, lastKmsgFooter2, "/sys/fs/pstore/console-ramoops-0", -LASTK_LOG_SIZE, "SYSTEM_LAST_KMSG");
        addFileToDropBox(db, timestamps, headers, "/cache/recovery/log", -LOG_SIZE, "SYSTEM_RECOVERY_LOG");
        addFileToDropBox(db, timestamps, headers, "/cache/recovery/last_kmsg", -LOG_SIZE, "SYSTEM_RECOVERY_KMSG");
        addAuditErrorsToDropBox(db, timestamps, headers, -LOG_SIZE, "SYSTEM_AUDIT");
    L29:
        logFsShutdownTime();
        logFsMountTime();
        addFsckErrorsToDropBoxAndLogFsStat(db, timestamps, headers, -LOG_SIZE, "SYSTEM_FSCK");
        logSystemServerShutdownTimeMetrics();
        writeTimestamps(timestamps);
        return;
    L20:
        if (db == null) goto L23;
        db.addText("SYSTEM_RESTART", headers);
    L23:
        if (SystemProperties.getInt("debug.system.server.crash", 0) == 0) goto L25;
        SystemProperties.set("debug.system.server.crash", "0");
        goto L29
    L25:
        if (db == null) goto L29;
        db.addText("system_restart_unknown", headers);
        goto L29
    L12:
        lastKmsgFooter2 = "";
        goto L13
    }

    public static void initDropboxRateLimiter() {
        sDropboxRateLimiter.init();
    }

    public static void resetDropboxRateLimiter() {
        sDropboxRateLimiter.reset();
    }

    public static void addTombstoneToDropBox(Context ctx, File tombstone, boolean proto, String processName, ReentrantLock tmpFileLock) {
        DropBoxManager db = (DropBoxManager) ctx.getSystemService(DropBoxManager.class);
        if (db != null) goto L6;
        Slog.e(TAG, "Can't log tombstone: DropBoxManager not available");
        return;
    L6:
        DropboxRateLimiter r0 = sDropboxRateLimiter;
        if (proto == false) goto L9;
        String r2 = TAG_TOMBSTONE_PROTO_WITH_HEADERS;
    L10:
        DropboxRateLimiter.RateLimitResult rateLimitResult = r0.shouldRateLimit(r2, processName);
        if (rateLimitResult.shouldRateLimit() == false) goto L13;
        return;
    L13:
        HashMap<String, Long> timestamps = readTimestamps();
        if (proto == true) goto L16;
        String headers = getBootHeadersToLogAndUpdate() + rateLimitResult.createHeader();     // Catch: IOException -> L20
        addFileToDropBox(db, timestamps, headers, tombstone.getPath(), LOG_SIZE, TAG_TOMBSTONE);     // Catch: IOException -> L20
    L28:
        writeTimestamps(timestamps);
        return;
    L16:
        if (recordFileTimestamp(tombstone, timestamps) == false) goto L28;
        tmpFileLock.lock();     // Catch: IOException -> L20
        addAugmentedProtoToDropbox(tombstone, db, rateLimitResult);     // Catch: Throwable -> L22
        tmpFileLock.unlock();     // Catch: IOException -> L20
        goto L28
    L22:
        th = move-exception;
        tmpFileLock.unlock();     // Catch: IOException -> L20
        throw th;     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Slog.e(TAG, "Can't log tombstone", e);
        goto L28
    L9:
        r2 = TAG_TOMBSTONE;
        goto L10
    }

    public static void filterAndAddTombstoneToDropBox(Context ctx, File tombstone, String processName, ReentrantLock tmpFileLock) {
        DropBoxManager db = (DropBoxManager) ctx.getSystemService(DropBoxManager.class);
        if (db != null) goto L6;
        Slog.e(TAG, "Can't log tombstone: DropBoxManager not available");
        return;
    L6:
        File filteredProto = null;
        DropboxRateLimiter.RateLimitResult rateLimitResult = sDropboxRateLimiter.shouldRateLimit(TAG_TOMBSTONE_PROTO_WITH_HEADERS, processName);
        if (rateLimitResult.shouldRateLimit() == false) goto L9;
        return;
    L9:
        HashMap<String, Long> timestamps = readTimestamps();
        tmpFileLock.lock();     // Catch: Throwable -> L14 Throwable -> L16
        Slog.i(TAG, "Filtering tombstone file: " + tombstone.getName());     // Catch: Throwable -> L14 Throwable -> L16
        filteredProto = createTempTombstoneWithoutMemory(tombstone);     // Catch: Throwable -> L14 Throwable -> L16
        Slog.i(TAG, "Generated tombstone file: " + filteredProto.getName());     // Catch: Throwable -> L14 Throwable -> L16
        if (recordFileTimestamp(tombstone, timestamps) == false) goto L18;
        Slog.i(TAG, "Adding tombstone " + filteredProto.getName() + " to dropbox");     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16
        addAugmentedProtoToDropbox(filteredProto, db, rateLimitResult);     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16
    L18:
        Slog.i(TAG, "Adding text tombstone version of " + filteredProto.getName() + " to dropbox");     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16
        addTextTombstoneFromProtoToDropbox(filteredProto, db, timestamps, rateLimitResult);     // Catch: Throwable -> L14 Throwable -> L16 Throwable -> L16
    L19:
        filteredProto.delete();
    L20:
        tmpFileLock.unlock();
        writeTimestamps(timestamps);
        return;
    L14:
        th = move-exception;
        if (filteredProto == null) goto L29;
        filteredProto.delete();
    L29:
        tmpFileLock.unlock();
        throw th;
    L16:
        e = move-exception;
        Slog.e(TAG, "Failed to log tombstone '" + tombstone.getName() + "' to DropBox. Error during processing or writing: " + e.getMessage(), e);     // Catch: Throwable -> L14
        if (filteredProto == null) goto L20;
        goto L20
    }

    private static File createTempTombstoneWithoutMemory(File tombstone) throws IOException {
        File tombstoneProto = File.createTempFile(tombstone.getName(), ".pb.tmp", TOMBSTONE_TMP_DIR);
        ProtoFieldFilter protoFilter = new ProtoFieldFilter(new BootReceiver$$ExternalSyntheticLambda0());
        FileInputStream fis = new FileInputStream(tombstone);
        BufferedInputStream bis = new BufferedInputStream(fis);     // Catch: Throwable -> L12
        FileOutputStream fos = new FileOutputStream(tombstoneProto);     // Catch: Throwable -> L14
        BufferedOutputStream bos = new BufferedOutputStream(fos);     // Catch: Throwable -> L16
        protoFilter.filter(bis, bos);     // Catch: Throwable -> L18
        bos.close();     // Catch: Throwable -> L16
        fos.close();     // Catch: Throwable -> L14
        bis.close();     // Catch: Throwable -> L12
        fis.close();
        return tombstoneProto;
    L18:
        th = move-exception;
        bos.close();     // Catch: Throwable -> L21
    L23:
        throw th;     // Catch: Throwable -> L16
    L21:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        fos.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L14
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        bis.close();     // Catch: Throwable -> L31
    L33:
        throw th;     // Catch: Throwable -> L12
    L31:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L36
    L38:
        throw th;
    L36:
        th = move-exception;
        th.addSuppressed(th);
        goto L38
    }

    private static /* synthetic */ boolean lambda$createTempTombstoneWithoutMemory$0(Integer fieldNumber) {
        if (fieldNumber.intValue() == 17) goto L5;
        return true;
    L5:
        return false;
    }

    private static void addTextTombstoneFromProtoToDropbox(File tombstone, DropBoxManager db, HashMap<String, Long> timestamps, DropboxRateLimiter.RateLimitResult rateLimitResult) {
        File tombstoneTextFile = null;
        tombstoneTextFile = File.createTempFile(tombstone.getName(), ".pb.txt.tmp", TOMBSTONE_TMP_DIR);     // Catch: Throwable -> L26 Throwable -> L28
        ProcessBuilder pb = new ProcessBuilder(new String[]{"/system/bin/pbtombstone", tombstone.getPath()});     // Catch: Throwable -> L26 Throwable -> L28
        pb.redirectOutput(tombstoneTextFile);     // Catch: Throwable -> L26 Throwable -> L28
        Process process = pb.start();     // Catch: Throwable -> L26 Throwable -> L28
        if (process.waitFor(10, TimeUnit.SECONDS) == true) goto L13;
        Slog.e(TAG, "pbtombstone timed out");     // Catch: Throwable -> L9 Throwable -> L11
        process.destroyForcibly();     // Catch: Throwable -> L9 Throwable -> L11
        if (tombstoneTextFile == null) goto L43;
        tombstoneTextFile.delete();
        return;
    L43:
        return;
    L13:
        int exitCode = process.exitValue();     // Catch: Throwable -> L26 Throwable -> L28 Throwable -> L28
        if (exitCode == 0) goto L17;
        Slog.e(TAG, "pbtombstone failed with exit code " + exitCode);     // Catch: Throwable -> L9 Throwable -> L11 Throwable -> L11
    L20:
        if (tombstoneTextFile == null) goto L34;
    L21:
        tombstoneTextFile.delete();
        return;
    L34:
        return;
    L17:
        String headers = getBootHeadersToLogAndUpdate() + rateLimitResult.createHeader();     // Catch: Throwable -> L26 Throwable -> L28 Throwable -> L28
    L39:
        addFileToDropBox(db, timestamps, headers, tombstoneTextFile.getPath(), LOG_SIZE, TAG_TOMBSTONE);     // Catch: Throwable -> L22 Throwable -> L24
    L24:
        e = e;
    L31:
        Slog.e(TAG, "Failed to process tombstone with pbtombstone", e);     // Catch: Throwable -> L22
        if (tombstoneTextFile != null) goto L21;
        return;
    L11:
        e = e;
    L9:
        th = th;
    L35:
        if (tombstoneTextFile == null) goto L37;
        tombstoneTextFile.delete();
    L37:
        throw th;
    L22:
        th = th;
    L26:
        th = th;
    L28:
        e = e;
        goto L31
    }

    private static void addAugmentedProtoToDropbox(File tombstone, DropBoxManager db, DropboxRateLimiter.RateLimitResult rateLimitResult) throws IOException {
        if (tombstone.length() <= MAX_TOMBSTONE_SIZE_BYTES) goto L6;
        Slog.w(TAG, "Tombstone too large to add to DropBox: " + tombstone.toPath());
        return;
    L6:
        FileInputStream fis = new FileInputStream(tombstone);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();     // Catch: Throwable -> L36
        fis.transferTo(baos);     // Catch: Throwable -> L38
        byte[] tombstoneBytes = baos.toByteArray();     // Catch: Throwable -> L38
        baos.close();     // Catch: Throwable -> L36
        fis.close();
        File tombstoneProtoWithHeaders = File.createTempFile(tombstone.getName(), ".tmp", TOMBSTONE_TMP_DIR);
        Files.setPosixFilePermissions(tombstoneProtoWithHeaders.toPath(), PosixFilePermissions.fromString("rw-rw----"));
        ParcelFileDescriptor pfd = ParcelFileDescriptor.open(tombstoneProtoWithHeaders, LZMA2Options.DICT_SIZE_MAX);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
        ProtoOutputStream protoStream = new ProtoOutputStream(pfd.getFileDescriptor());     // Catch: Throwable -> L21
        protoStream.write(1151051235329L, tombstoneBytes);     // Catch: Throwable -> L21
        protoStream.write(1120986464258L, rateLimitResult.droppedCountSinceRateLimitActivated());     // Catch: Throwable -> L21
        protoStream.flush();     // Catch: Throwable -> L21
        db.addFile(TAG_TOMBSTONE_PROTO_WITH_HEADERS, tombstoneProtoWithHeaders, 0);     // Catch: Throwable -> L21
        pfd.close();     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
    L14:
        tombstoneProtoWithHeaders.delete();
        return;
    L21:
        th = move-exception;
        if (pfd != null) goto L58;
    L28:
        throw th;     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
    L58:
        pfd.close();     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L15 IOException -> L17 FileNotFoundException -> L19
    L15:
        th = move-exception;
        tombstoneProtoWithHeaders.delete();
        throw th;
    L19:
        ex = move-exception;
        Slog.e(TAG, "failed to open for write: " + tombstoneProtoWithHeaders, ex);     // Catch: Throwable -> L15
        throw ex;     // Catch: Throwable -> L15
    L17:
        ex = move-exception;
        Slog.e(TAG, "IO exception during write: " + tombstoneProtoWithHeaders, ex);     // Catch: Throwable -> L15
        goto L14
    L38:
        th = move-exception;
        baos.close();     // Catch: Throwable -> L41
    L43:
        throw th;     // Catch: Throwable -> L36
    L41:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L46
    L48:
        throw th;
    L46:
        th = move-exception;
        th.addSuppressed(th);
        goto L48
    }

    private static void addLastkToDropBox(DropBoxManager db, HashMap<String, Long> timestamps, String headers, String footers, String filename, int maxSize, String tag) throws IOException {
        int extraSize = (headers.length() + TAG_TRUNCATED.length()) + footers.length();
        if ((LASTK_LOG_SIZE + extraSize) <= GMSCORE_LASTK_LOG_SIZE) goto L7;
        if (GMSCORE_LASTK_LOG_SIZE <= extraSize) goto L6;
        int maxSize2 = -(GMSCORE_LASTK_LOG_SIZE - extraSize);
        int maxSize3 = maxSize2;
    L8:
        addFileWithFootersToDropBox(db, timestamps, headers, footers, filename, maxSize3, tag);
        return;
    L6:
        maxSize3 = 0;
        goto L8
    L7:
        maxSize3 = maxSize;
        goto L8
    }

    private static void addFileToDropBox(DropBoxManager db, HashMap<String, Long> timestamps, String headers, String filename, int maxSize, String tag) throws IOException {
        addFileWithFootersToDropBox(db, timestamps, headers, "", filename, maxSize, tag);
    }

    private static void addFileWithFootersToDropBox(DropBoxManager db, HashMap<String, Long> timestamps, String headers, String footers, String filename, int maxSize, String tag) throws IOException {
        if (db != null) goto L5;
        return;
    L5:
        if (db.isTagEnabled(tag) == false) goto L29;
        File file = new File(filename);
        if (recordFileTimestamp(file, timestamps) == true) goto L10;
        return;
    L10:
        String fileContents = FileUtils.readTextFile(file, maxSize, TAG_TRUNCATED);
        if (mSmtEx != null) goto L14;
        Slog.e(TAG, "mSmtEx is null, need to init mSmtEx");
        mSmtEx = SysMonitorSvcBridge.getFactory().getBootReceiver();
    L14:
        if (mSmtEx != null) goto L16;
    L18:
        String text = headers + fileContents + footers;
        if (tag.equals(TAG_TOMBSTONE) == false) goto L24;
        if (fileContents.contains(">>> system_server <<<") == false) goto L24;
        addTextToDropBox(db, "system_server_native_crash", text, filename, maxSize);
        SystemProperties.set("debug.system.server.crash", "1");
    L24:
        if (tag.equals(TAG_TOMBSTONE) == false) goto L26;
        FrameworkStatsLog.write(186);
    L26:
        addTextToDropBox(db, tag, text, filename, maxSize);
        return;
    L16:
        if (mSmtEx.addMoreInfoToNativeCrash(db, tag, headers, fileContents, filename, maxSize, footers) == false) goto L18;
        return;
    }

    private static boolean recordFileTimestamp(File file, HashMap<String, Long> timestamps) {
        long fileTime = file.lastModified();
        if (fileTime > 0) goto L5;
        return false;
    L5:
        String filename = file.getPath();
        if (timestamps.containsKey(filename) == true) goto L8;
    L10:
        timestamps.put(filename, Long.valueOf(fileTime));
        return true;
    L8:
        if (timestamps.get(filename).longValue() != fileTime) goto L10;
        return false;
    }

    private static void addTextToDropBox(DropBoxManager db, String tag, String text, String filename, int maxSize) {
        Slog.i(TAG, "Copying " + filename + " to DropBox (" + tag + ")");
        db.addText(tag, text);
        EventLog.writeEvent(81002, new Object[]{filename, Integer.valueOf(maxSize), tag});
    }

    private static void addAuditErrorsToDropBox(DropBoxManager db, HashMap<String, Long> timestamps, String headers, int maxSize, String tag) throws IOException {
        if (db == null) goto L29;
        if (db.isTagEnabled(tag) == false) goto L33;
        Slog.i(TAG, "Copying audit failures to DropBox");
        File file = new File("/proc/last_kmsg");
        long fileTime = file.lastModified();
        if (fileTime > 0) goto L13;
        file = new File("/sys/fs/pstore/console-ramoops");
        fileTime = file.lastModified();
        if (fileTime > 0) goto L13;
        file = new File("/sys/fs/pstore/console-ramoops-0");
        fileTime = file.lastModified();
    L13:
        if (fileTime > 0) goto L16;
        return;
    L16:
        if (timestamps.containsKey(tag) == true) goto L18;
    L20:
        timestamps.put(tag, Long.valueOf(fileTime));
        String log = FileUtils.readTextFile(file, maxSize, TAG_TRUNCATED);
        StringBuilder sb = new StringBuilder();
        String[] r11 = log.split("\n");
        int r12 = r11.length;
        int r13 = 0;
    L21:
        if (r13 >= r12) goto L26;
        String line = r11[r13];
        if (line.contains("audit") == false) goto L25;
        sb.append(line + "\n");
    L25:
        r13 = r13 + 1;
        goto L21
    L26:
        Slog.i(TAG, "Copied " + sb.toString().length() + " worth of audits to DropBox");
        StringBuilder r4 = new StringBuilder();
        r4.append(headers);
        r4.append(sb.toString());
        db.addText(tag, r4.toString());
        return;
    L18:
        if (timestamps.get(tag).longValue() != fileTime) goto L20;
        return;
    L33:
        return;
    }

    private static void addFsckErrorsToDropBoxAndLogFsStat(DropBoxManager db, HashMap<String, Long> timestamps, String headers, int maxSize, String tag) throws IOException {
        if (db == null) goto L8;
        String r5 = tag;
        if (db.isTagEnabled(r5) == false) goto L9;
        boolean uploadEnabled = true;
    L10:
        Slog.i(TAG, "Checking for fsck errors");
        File file = new File("/dev/fscklogs/log");
        long fileTime = file.lastModified();
        if (fileTime > 0) goto L13;
        return;
    L13:
        String log = FileUtils.readTextFile(file, maxSize, TAG_TRUNCATED);
        Pattern pattern = Pattern.compile(FS_STAT_PATTERN);
        String[] lines = log.split("\n");
        int r14 = lines.length;
        int lastFsStatLineNumber = 0;
        int lastFsStatLineNumber2 = 0;
        int lineNumber = 0;
        int lineNumber2 = 0;
    L14:
        if (lineNumber2 >= r14) goto L32;
        String line = lines[lineNumber2];
        int r16 = lineNumber2;
        if (line.contains(E2FSCK_FS_MODIFIED) == true) goto L29;
        if (line.contains(F2FS_FSCK_FS_MODIFIED) == true) goto L29;
        if (line.contains("fs_stat") == false) goto L27;
        Matcher matcher = pattern.matcher(line);
        if (matcher.find() == false) goto L25;
        handleFsckFsStat(matcher, lines, lastFsStatLineNumber2, lineNumber);
        lastFsStatLineNumber2 = lineNumber;
    L30:
        lineNumber = lineNumber + 1;
        lineNumber2 = r16 + 1;
        goto L14
    L25:
        Slog.w(TAG, "cannot parse fs_stat:" + line);
    L27:
        lastFsStatLineNumber2 = lastFsStatLineNumber2;
    L29:
        lastFsStatLineNumber = 1;
        lastFsStatLineNumber2 = lastFsStatLineNumber2;
        goto L30
    L32:
        if (uploadEnabled == false) goto L35;
        if (lastFsStatLineNumber == 0) goto L35;
        addFileToDropBox(db, timestamps, headers, "/dev/fscklogs/log", maxSize, r5);
    L35:
        File pfile = new File("/dev/fscklogs/fsck");
        file.renameTo(pfile);
        return;
    L9:
        uploadEnabled = false;
        goto L10
    L8:
        r5 = tag;
        goto L9
    }

    private static void logFsMountTime() {
        String[] r0 = MOUNT_DURATION_PROPS_POSTFIX;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L26;
        String propPostfix = r0[r3];
        int duration = SystemProperties.getInt("ro.boottime.init.mount_all." + propPostfix, 0);
        if (duration == 0) goto L25;
        switch(propPostfix.hashCode()) {
            case 3314342: goto L16;
            case 96278371: goto L13;
            case 1544803905: goto L10;
            default: goto L18;
        };
    L18:
        byte r6 = -1;
    L19:
        switch(r6) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L25;
        };
    L21:
        int eventType = 12;
    L24:
        FrameworkStatsLog.write(239, eventType, duration);
        goto L25
    L22:
        eventType = 10;
        goto L24
    L23:
        eventType = 11;
        goto L24
    L10:
        if (propPostfix.equals("default") == false) goto L18;
        r6 = 1;
        goto L19
    L13:
        if (propPostfix.equals("early") == false) goto L18;
        r6 = 0;
        goto L19
    L16:
        if (propPostfix.equals("late") == false) goto L18;
        r6 = 2;
    L25:
        r3 = r3 + 1;
        goto L3
    }

    private static void logSystemServerShutdownTimeMetrics() {
        File metricsFile = new File(SHUTDOWN_METRICS_FILE);
        String metricsStr = null;
        if (metricsFile.exists() == false) goto L10;
        metricsStr = FileUtils.readTextFile(metricsFile, 0, null);     // Catch: IOException -> L7
    L7:
        e = move-exception;
        Slog.e(TAG, "Problem reading " + metricsFile, e);
    L10:
        if (TextUtils.isEmpty(metricsStr) == true) goto L32;
        String reboot = null;
        String reason = null;
        String start_time = null;
        String duration = null;
        String[] array = metricsStr.split(",");
        int r9 = array.length;
        int r10 = 0;
    L12:
        if (r10 >= r9) goto L31;
        String keyValueStr = array[r10];
        String[] keyValue = keyValueStr.split(":");
        if (keyValue.length == 2) goto L17;
        Slog.e(TAG, "Wrong format of shutdown metrics - " + metricsStr);
    L30:
        r10 = r10 + 1;
        goto L12
    L17:
        if (keyValue[0].startsWith(SHUTDOWN_TRON_METRICS_PREFIX) == false) goto L22;
        logTronShutdownMetric(keyValue[0], keyValue[1]);
        if (keyValue[0].equals(METRIC_SYSTEM_SERVER) == false) goto L22;
        duration = keyValue[1];
    L22:
        if (keyValue[0].equals("reboot") == false) goto L25;
        reboot = keyValue[1];
        goto L30
    L25:
        if (keyValue[0].equals(PhoneWindowManager.SYSTEM_DIALOG_REASON_KEY) == false) goto L28;
        reason = keyValue[1];
        goto L30
    L28:
        if (keyValue[0].equals(METRIC_SHUTDOWN_TIME_START) == false) goto L30;
        start_time = keyValue[1];
        goto L30
    L31:
        logStatsdShutdownAtom(reboot, reason, start_time, duration);
    L32:
        metricsFile.delete();
    }

    private static void logTronShutdownMetric(String metricName, String valueStr) {
        int value = Integer.parseInt(valueStr);     // Catch: NumberFormatException -> L6
        if (value < 0) goto L11;
        MetricsLogger.histogram(null, metricName, value);
        return;
    L11:
        return;
    L7:
        Slog.e(TAG, "Cannot parse metric " + metricName + " int value - " + valueStr);
    }

    private static void logStatsdShutdownAtom(String rebootStr, String reasonStr, String startStr, String durationStr) {
        if (rebootStr != null) goto L5;
        Slog.e(TAG, "No value received for reboot");
    L11:
        boolean reboot = false;
    L12:
        if (reasonStr == null) goto L14;
        String reason = reasonStr;
    L15:
        if (startStr != null) goto L31;
        Slog.e(TAG, "No value received for shutdown start time");
    L21:
        long start = 0;
    L22:
        if (durationStr != null) goto L33;
        Slog.e(TAG, "No value received for shutdown duration");
    L28:
        long duration = 0;
    L29:
        FrameworkStatsLog.write(56, reboot, reason, start, duration);
        return;
    L33:
        long duration2 = Long.parseLong(durationStr);     // Catch: NumberFormatException -> L25
        duration = duration2;
    L26:
        Slog.e(TAG, "Cannot parse shutdown duration: " + startStr);
        goto L28
    L31:
        long start2 = Long.parseLong(startStr);     // Catch: NumberFormatException -> L18
        start = start2;
    L19:
        Slog.e(TAG, "Cannot parse shutdown start time: " + startStr);
        goto L21
    L14:
        Slog.e(TAG, "No value received for shutdown reason");
        reason = "<EMPTY>";
        goto L15
    L5:
        if (rebootStr.equals("y") == false) goto L8;
        reboot = true;
        goto L12
    L8:
        if (rebootStr.equals("n") == true) goto L11;
        Slog.e(TAG, "Unexpected value for reboot : " + rebootStr);
        goto L11
    }

    private static void logFsShutdownTime() {
        File f = null;
        String[] r2 = LAST_KMSG_FILES;
        int r3 = r2.length;
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L9;
        String fileName = r2[r4];
        File file = new File(fileName);
        if (file.exists() == true) goto L8;
        r4 = r4 + 1;
        goto L4
    L8:
        f = file;
    L9:
        if (f != null) goto L21;
        return;
    L21:
        String lines = FileUtils.readTextFile(f, -16384, null);     // Catch: IOException -> L18
        Pattern pattern = Pattern.compile(LAST_SHUTDOWN_TIME_PATTERN, 8);
        Matcher matcher = pattern.matcher(lines);
        if (matcher.find() == false) goto L16;
        FrameworkStatsLog.write(239, 9, Integer.parseInt(matcher.group(1)));
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ERROR_CODE_REPORTED, 2, Integer.parseInt(matcher.group(2)));
        Slog.i(TAG, "boot_fs_shutdown," + matcher.group(1) + "," + matcher.group(2));
        return;
    L16:
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ERROR_CODE_REPORTED, 2, 4);
        Slog.w(TAG, "boot_fs_shutdown, string not found");
        return;
    L18:
        e = move-exception;
        Slog.w(TAG, "cannot read last msg", e);
    }

    public static int fixFsckFsStat(String partition, int statOrg, String[] lines, int startLineNumber, int endLineNumber) {
        if ((statOrg & 1024) == 0) goto L69;
        Pattern passPattern = Pattern.compile(FSCK_PASS_PATTERN);
        Pattern treeOptPattern = Pattern.compile(FSCK_TREE_OPTIMIZATION_PATTERN);
        String currentPass = "";
        boolean foundTreeOptimization = false;
        boolean foundQuotaFix = false;
        boolean foundTimestampAdjustment = false;
        boolean foundOtherFix = false;
        String otherFixLine = null;
        int i = startLineNumber;
    L6:
        if (i >= endLineNumber) goto L57;
        String line = lines[i];
        if (line.contains(E2FSCK_FS_MODIFIED) == true) goto L56;
        if (line.contains(F2FS_FSCK_FS_MODIFIED) == true) goto L11;
        boolean foundTreeOptimization2 = foundTreeOptimization;
        if (line.startsWith("Pass ") == false) goto L19;
        Matcher matcher = passPattern.matcher(line);
        if (matcher.find() == false) goto L17;
        currentPass = matcher.group(1);
    L17:
        Pattern passPattern2 = passPattern;
        foundTreeOptimization = foundTreeOptimization2;
    L55:
        i = i + 1;
        passPattern = passPattern2;
        goto L6
    L19:
        if (line.startsWith("Inode ") == true) goto L21;
        passPattern2 = passPattern;
        if (line.startsWith("[QUOTA WARNING]") == false) goto L35;
        if (currentPass.equals("5") == false) goto L35;
        Slog.i(TAG, "fs_stat, partition:" + partition + " found quota warning:" + line);
        foundQuotaFix = true;
        if (foundTreeOptimization2 == false) goto L32;
        foundTreeOptimization = foundTreeOptimization2;
        goto L55
    L32:
        otherFixLine = line;
    L58:
        if (foundOtherFix == false) goto L61;
        if (otherFixLine == null) goto L82;
        Slog.i(TAG, "fs_stat, partition:" + partition + " fix:" + otherFixLine);
        return statOrg;
    L82:
        return statOrg;
    L61:
        if (foundQuotaFix == false) goto L64;
        if (foundTreeOptimization2 == true) goto L64;
        Slog.i(TAG, "fs_stat, got quota fix without tree optimization, partition:" + partition);
        return statOrg;
    L64:
        if (foundTreeOptimization2 == false) goto L66;
        if (foundQuotaFix == false) goto L66;
    L67:
        Slog.i(TAG, "fs_stat, partition:" + partition + " fix ignored");
        int stat = statOrg & (-1025);
        return stat;
    L66:
        if (foundTimestampAdjustment == true) goto L67;
        return statOrg;
    L35:
        if (line.startsWith("Update quota info") == false) goto L40;
        if (currentPass.equals("5") == false) goto L40;
    L54:
        foundTreeOptimization = foundTreeOptimization2;
    L40:
        if (line.startsWith("Timestamp(s) on inode") == true) goto L42;
    L49:
        String line2 = line.trim();
        if (line2.isEmpty() == true) goto L54;
        if (currentPass.isEmpty() == true) goto L54;
        foundOtherFix = true;
        otherFixLine = line2;
        goto L58
    L42:
        if (line.contains("beyond 2310-04-04 are likely pre-1970") == false) goto L49;
        if (currentPass.equals("1") == false) goto L49;
        Slog.i(TAG, "fs_stat, partition:" + partition + " found timestamp adjustment:" + line);
        if (lines[i + 1].contains("Fix? yes") == false) goto L48;
        i = i + 1;
    L48:
        foundTimestampAdjustment = true;
        foundTreeOptimization = foundTreeOptimization2;
        goto L55
    L21:
        if (treeOptPattern.matcher(line).find() == false) goto L25;
        if (currentPass.equals("1") == false) goto L25;
        foundTreeOptimization = true;
        passPattern2 = passPattern;
        Slog.i(TAG, "fs_stat, partition:" + partition + " found tree optimization:" + line);
    L25:
        foundOtherFix = true;
        otherFixLine = line;
        goto L58
    L11:
        foundTreeOptimization2 = foundTreeOptimization;
        goto L58
    L56:
        foundTreeOptimization2 = foundTreeOptimization;
        goto L58
    L57:
        foundTreeOptimization2 = foundTreeOptimization;
        goto L58
    L69:
        return statOrg;
    }

    private static void handleFsckFsStat(Matcher match, String[] lines, int startLineNumber, int endLineNumber) {
        String partition = match.group(1);
        int stat = fixFsckFsStat(partition, Integer.decode(match.group(2)).intValue(), lines, startLineNumber, endLineNumber);
        if ("userdata".equals(partition) == false) goto L7;
    L8:
        FrameworkStatsLog.write(FrameworkStatsLog.BOOT_TIME_EVENT_ERROR_CODE_REPORTED, 3, stat);
    L9:
        Slog.i(TAG, "fs_stat, partition:" + partition + " stat:0x" + Integer.toHexString(stat));
        return;
    L7:
        if ("data".equals(partition) == false) goto L9;
    L12:
        Slog.w(TAG, "cannot parse fs_stat: partition:" + partition + " stat:" + match.group(2));
    }

    private static HashMap<String, Long> readTimestamps() {
        AtomicFile r0 = sFile;
        monitor-enter(r0);
        HashMap<String, Long> timestamps = new HashMap();     // Catch: Throwable -> L52
        FileInputStream stream = sFile.openRead();     // Catch: Throwable -> L37 XmlPullParserException -> L39 NullPointerException -> L41 IllegalStateException -> L43 IOException -> L45 FileNotFoundException -> L47
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L21
    L8:
        int type = parser.next();     // Catch: Throwable -> L21
        if (type == 2) goto L12;
        if (type != 1) goto L8;
    L12:
        if (type != 2) goto L55;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L21
    L14:
        int type2 = parser.next();     // Catch: Throwable -> L21
        if (type2 == 1) goto L34;
        if (type2 == 3) goto L19;
    L24:
        if (type2 == 3) goto L14;
        if (type2 == 4) goto L14;
        String tagName = parser.getName();     // Catch: Throwable -> L21
        if (tagName.equals("log") == true) goto L30;
        Slog.w(TAG, "Unknown tag: " + parser.getName());     // Catch: Throwable -> L21
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L21
        goto L14
    L30:
        String filename = parser.getAttributeValue(null, "filename");     // Catch: Throwable -> L21
        long timestamp = parser.getAttributeLong(null, "timestamp");     // Catch: Throwable -> L21
        timestamps.put(filename, Long.valueOf(timestamp));     // Catch: Throwable -> L21
        goto L14
    L19:
        if (parser.getDepth() > outerDepth) goto L24;
    L34:
        if (stream == null) goto L49;
        stream.close();     // Catch: Throwable -> L37 XmlPullParserException -> L39 NullPointerException -> L41 IllegalStateException -> L43 IOException -> L45 FileNotFoundException -> L47
    L49:
        if (1 != 0) goto L79;
    L50:
        timestamps.clear();     // Catch: Throwable -> L52
    L79:
        monitor-exit(r0);     // Catch: Throwable -> L52
        return timestamps;
    L55:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        if (stream != null) goto L87;
    L62:
        throw th;     // Catch: Throwable -> L37 XmlPullParserException -> L39 NullPointerException -> L41 IllegalStateException -> L43 IOException -> L45 FileNotFoundException -> L47
    L87:
        stream.close();     // Catch: Throwable -> L59
    L59:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L37 XmlPullParserException -> L39 NullPointerException -> L41 IllegalStateException -> L43 IOException -> L45 FileNotFoundException -> L47
    L37:
        th = move-exception;
        if (0 != 0) goto L83;
        timestamps.clear();     // Catch: Throwable -> L52
    L83:
        throw th;     // Catch: Throwable -> L52
    L45:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L37
        if (0 != 0) goto L79;
    L41:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L37
        if (0 != 0) goto L79;
    L43:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L37
        if (0 != 0) goto L79;
    L39:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L37
        if (0 != 0) goto L79;
    L76:
        Slog.i(TAG, "No existing last log timestamp file " + sFile.getBaseFile() + "; starting empty");     // Catch: Throwable -> L37
        if (0 != 0) goto L79;
    L52:
        th = move-exception;
        throw th;
    }

    private static void writeTimestamps(HashMap<String, Long> timestamps) {
        AtomicFile r0 = sFile;
        monitor-enter(r0);
        FileOutputStream stream = sFile.startWrite();     // Catch: Throwable -> L9 IOException -> L19
    L27:
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L9 IOException -> L11
        out.startDocument(null, true);     // Catch: Throwable -> L9 IOException -> L11
        out.startTag(null, "log-files");     // Catch: Throwable -> L9 IOException -> L11
        Iterator<String> itor = timestamps.keySet().iterator();     // Catch: Throwable -> L9 IOException -> L11
    L7:
        if (itor.hasNext() == false) goto L13;
        String filename = itor.next();     // Catch: Throwable -> L9 IOException -> L11
        out.startTag(null, "log");     // Catch: Throwable -> L9 IOException -> L11
        out.attribute(null, "filename", filename);     // Catch: Throwable -> L9 IOException -> L11
        out.attributeLong(null, "timestamp", timestamps.get(filename).longValue());     // Catch: Throwable -> L9 IOException -> L11
        out.endTag(null, "log");     // Catch: Throwable -> L9 IOException -> L11
        goto L7
    L13:
        out.endTag(null, "log-files");     // Catch: Throwable -> L9 IOException -> L11
        out.endDocument();     // Catch: Throwable -> L9 IOException -> L11
        sFile.finishWrite(stream);     // Catch: Throwable -> L9 IOException -> L11
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        e = move-exception;
        Slog.w(TAG, "Failed to write timestamp file, using the backup: " + e);     // Catch: Throwable -> L9
        sFile.failWrite(stream);     // Catch: Throwable -> L9
    L19:
        e = move-exception;
        Slog.w(TAG, "Failed to write timestamp file: " + e);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
