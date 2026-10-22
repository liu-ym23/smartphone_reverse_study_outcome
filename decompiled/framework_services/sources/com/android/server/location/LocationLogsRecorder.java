package com.android.server.location;

import android.os.Environment;
import android.util.IndentingPrintWriter;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public class LocationLogsRecorder {
    private static final int BUFFER_SIZE = 8192;
    private static final String CUR_DIR_NAME = "cur";
    private static final ConcurrentHashMap<String, ReentrantReadWriteLock> FILE_LOCKS = null;
    private static final ConcurrentHashMap<String, File> FILE_MAP = null;
    public static final String KEY_FILE_GNSS = "gnss";
    public static final String KEY_FILE_LOCATION = "location";
    public static final String KEY_FILE_NMEA = "nmea";
    private static final String LAST_DIR_NAME = "last";
    private static final String LOGS_DIR_NAME = "logs";
    private static final ExecutorService LOG_WRITER_EXECUTOR = null;
    private static final String STR_GNSS_FILE = "gnss.log";
    private static final String STR_LOCATION_FILE = "location.log";
    private static final String STR_LOGFILE_SUFFIX = ".log";
    private static final String STR_NMEA_FILE = "nmea.log";
    private static final String TAG = null;
    private static File mGnssFile;
    private static File mLocationFile;
    private static File mNmeaFile;
    private static LocationLogsRecorder sInstance;
    private StarLocation mStarLocation;

    public static /* synthetic */ ReentrantReadWriteLock $r8$lambda$CSdfa7Kv7Bpg6chFiOGjLQjZS4I(String r0) {
        return lambda$write2FileWithBuffer$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$RyAZDz-ZeIzEKr1-eiZbLd-z8_E, reason: not valid java name */
    public static /* synthetic */ void m5140$r8$lambda$RyAZDzZeIzEKr1eiZbLdz8_E(LocationLogsRecorder r0, String r1, String r2, boolean r3) {
        r0.lambda$writeLocationLogsAsyncWithoutTime$1(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$neHDVKwkP5Bfk89-KJ3D4DZ_h2Y, reason: not valid java name */
    public static /* synthetic */ Thread m5141$r8$lambda$neHDVKwkP5Bfk89KJ3D4DZ_h2Y(Runnable r0) {
        return lambda$static$0(r0);
    }

    public static /* synthetic */ ReentrantReadWriteLock $r8$lambda$nkZdZboBp1OvQVkTnNomDSDYG3w(String r0) {
        return lambda$dumpFileContent$3(r0);
    }

    static {
        TAG = LocationLogsRecorder.class.getSimpleName();
        FILE_LOCKS = new ConcurrentHashMap();
        FILE_MAP = new ConcurrentHashMap();
        LOG_WRITER_EXECUTOR = Executors.newSingleThreadExecutor(new LocationLogsRecorder$$ExternalSyntheticLambda0());
    }

    private static /* synthetic */ Thread lambda$static$0(Runnable r) {
        return new Thread(r, "LocationLogWriter");
    }

    public static synchronized LocationLogsRecorder getInstance() {
        monitor-enter(LocationLogsRecorder.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new LocationLogsRecorder();     // Catch: Throwable -> L7
    L9:
        LocationLogsRecorder r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(LocationLogsRecorder.class);
        return r1;
    }

    private LocationLogsRecorder() {
    }

    public void initOnce() {
        this.mStarLocation = StarLocation.getInstance();
        File logsDir = new File(new File(Environment.getDataDirectory(), KEY_FILE_LOCATION), LOGS_DIR_NAME);
        File lastDir = new File(logsDir, LAST_DIR_NAME);
        File curDir = new File(logsDir, CUR_DIR_NAME);
        if (lastDir.exists() == false) goto L6;
        deleteDirectory(lastDir);
    L6:
        if (curDir.exists() == false) goto L9;
        curDir.renameTo(lastDir);
    L9:
        if (curDir.mkdirs() == false) goto L17;
        mLocationFile = createNewFile(curDir, STR_LOCATION_FILE);     // Catch: IOException -> L12
        mGnssFile = createNewFile(curDir, STR_GNSS_FILE);     // Catch: IOException -> L12
        mNmeaFile = createNewFile(curDir, STR_NMEA_FILE);     // Catch: IOException -> L12
        recordFileWithKey(KEY_FILE_LOCATION, mLocationFile);     // Catch: IOException -> L12
        recordFileWithKey(KEY_FILE_GNSS, mGnssFile);     // Catch: IOException -> L12
        recordFileWithKey(KEY_FILE_NMEA, mNmeaFile);     // Catch: IOException -> L12
        writeLocationLogsNoEncrypt(KEY_FILE_LOCATION, "init LMS on " + this.mStarLocation.getEncryptedKey());     // Catch: IOException -> L12
        return;
    L13:
        this.mStarLocation.loge(TAG, "Create log files failed");
        return;
    }

    private static File createNewFile(File parent, String fileName) throws IOException {
        File file = new File(parent, fileName);
        file.createNewFile();
        return file;
    }

    private static boolean deleteDirectory(File directory) {
        if (directory.exists() == false) goto L11;
        File[] files = directory.listFiles();
        if (files == null) goto L11;
        int r1 = files.length;
        int r2 = 0;
    L8:
        if (r2 >= r1) goto L11;
        File file = files[r2];
        deleteDirectory(file);
        r2 = r2 + 1;
    L11:
        return directory.delete();
    }

    private static void recordFileWithKey(String key, File file) {
        File ret = FILE_MAP.putIfAbsent(key, file);
        if (ret != null) goto L6;
        FILE_MAP.put(key, file);
        return;
    }

    private static File getRecordFile(String key) {
        if (FILE_MAP.containsKey(key) == true) goto L5;
        return null;
    L5:
        return FILE_MAP.get(key);
    }

    public void writeLocationLogsAsync(String key, String content) {
        this.mStarLocation.logd(TAG, content);
        writeLocationLogsAsyncWithoutTime(key, this.mStarLocation.getCurrentTime() + ": " + content, true);
    }

    public void writeLocationLogsNoEncrypt(String key, String content) {
        this.mStarLocation.logd(TAG, content);
        writeLocationLogsAsyncWithoutTime(key, this.mStarLocation.getCurrentTime() + ": " + content, false);
    }

    public void writeLocationLogsAsyncWithoutTime(final String key, final String content, final boolean needEncrypt) {
        LOG_WRITER_EXECUTOR.execute(new LocationLogsRecorder$$ExternalSyntheticLambda1(this, key, content, needEncrypt));
    }

    private /* synthetic */ void lambda$writeLocationLogsAsyncWithoutTime$1(String key, String content, boolean needEncrypt) {
        File recordFile = getRecordFile(key);     // Catch: Exception -> L6
        if (recordFile == null) goto L13;
        write2FileWithBuffer(recordFile, content, needEncrypt);     // Catch: Exception -> L6
        return;
    L13:
        return;
    L9:
        this.mStarLocation.loge(TAG, "Async write failed");
    }

    private void write2FileWithBuffer(File file, String content, boolean needEncrypt) {
        ReentrantReadWriteLock lock = FILE_LOCKS.computeIfAbsent(file.getAbsolutePath(), new LocationLogsRecorder$$ExternalSyntheticLambda2());
        lock.writeLock().lock();
        if (content != null) goto L33;
        return;
    L33:
        if (content.isEmpty() == true) goto L39;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true), 8192);     // Catch: Throwable -> L17 IOException -> L19
        StringBuilder r2 = new StringBuilder();     // Catch: Throwable -> L11
        if (needEncrypt == false) goto L13;
        String r3 = this.mStarLocation.encryptLogs(content);     // Catch: Throwable -> L11
    L14:
        r2.append(r3);     // Catch: Throwable -> L11
        r2.append("\n");     // Catch: Throwable -> L11
        bos.write(r2.toString().getBytes(StandardCharsets.UTF_8));     // Catch: Throwable -> L11
        bos.close();     // Catch: Throwable -> L17 IOException -> L19
    L16:
        lock.writeLock().unlock();
        return;
    L13:
        r3 = content;
    L11:
        th = move-exception;
        bos.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Throwable -> L17 IOException -> L19
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L17 IOException -> L19
        goto L25
    L27:
        this.mStarLocation.loge(TAG, "writeWithBuffer failed: " + content);     // Catch: Throwable -> L17
        goto L16
    L39:
        return;
    L17:
        th = move-exception;
        lock.writeLock().unlock();
        throw th;
    }

    private static /* synthetic */ ReentrantReadWriteLock lambda$write2FileWithBuffer$2(String k) {
        return new ReentrantReadWriteLock();
    }

    public void dumpFileContent(String key, boolean needDecrypt, IndentingPrintWriter writer) {
        File file = getRecordFile(key);
        if (file != null) goto L5;
        return;
    L5:
        if (file.exists() == false) goto L45;
        ReentrantReadWriteLock lock = FILE_LOCKS.computeIfAbsent(file.getAbsolutePath(), new LocationLogsRecorder$$ExternalSyntheticLambda3());
        lock.readLock().lock();
        BufferedReader reader = new BufferedReader(Files.newBufferedReader(file.toPath()));     // Catch: Throwable -> L20 IOException -> L22
    L37:
        String r3 = reader.readLine();     // Catch: Throwable -> L13
        String line = r3;
        if (r3 == null) goto L18;
        if (needDecrypt == false) goto L15;
        line = this.mStarLocation.decryptLogs(line);     // Catch: Throwable -> L13
    L15:
        writer.println(line);     // Catch: Throwable -> L13
        goto L37
    L18:
        reader.close();     // Catch: Throwable -> L20 IOException -> L22
    L19:
        lock.readLock().unlock();
        return;
    L13:
        th = move-exception;
        reader.close();     // Catch: Throwable -> L26
    L28:
        throw th;     // Catch: Throwable -> L20 IOException -> L22
    L26:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L20 IOException -> L22
    L22:
        e = move-exception;
        writer.println("Error reading log file: " + e.getMessage());     // Catch: Throwable -> L20
        this.mStarLocation.loge(TAG, "dumpFileContent failed: " + e.getMessage());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        lock.readLock().unlock();
        throw th;
    }

    private static /* synthetic */ ReentrantReadWriteLock lambda$dumpFileContent$3(String k) {
        return new ReentrantReadWriteLock();
    }
}
