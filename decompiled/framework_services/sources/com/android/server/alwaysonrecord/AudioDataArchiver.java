package com.android.server.alwaysonrecord;

import android.media.MediaMetrics;
import android.os.FileUtils;
import android.util.Log;
import android.util.Slog;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.utils.EventLogger;
import com.bytedance.security.file_encrypt.FileEncrypt;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class AudioDataArchiver implements AlwaysOnRecordHwWrapper.AudioDataListener {
    private static final String AUDIO_FILE_POSTFIX = ".wav";
    private static final String AUDIO_FILE_PREFIX = "alwaysonrecorddata_";
    private static final String DATA_FORMAT_MATCH_PATTERN = "alwaysonrecorddata_([^_]+_[^_]+_[^_]+)_.*\\.wav";
    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd_HHmmss_SSS";
    private static final String LEGACY_DATA_FORMAT_MATCH_PATTERN = "alwaysonrecorddata_([^_]+_[^_]+)_.*\\.wav";
    private static final String LEGACY_DATE_FORMAT_PATTERN = "yyyy-MM-dd_HHmmss";
    static final int LOG_NB_EVENTS_RECYCLE_DATA = 100;
    private static final String SECRET_DATA_FOLDER = "/data/misc/alwaysonrecord";
    private static final String SECRET_DATA_PATH = "/data/misc/alwaysonrecord/secret_data";
    private static final String TAG = null;
    private static final long TIMESTAMP_GAP_FROM_NOW_IN_MS = 259200000;
    private static final String mMetricsId = "audio.alwaysOnRecord.achive.";
    private ArrayList<ArchiverListener> mArchiveListeners;
    private final Object mArchiveListenersLock;
    private int mBitsPerSample;
    final EventLogger mDataRecycleEventLogger;
    private final HashMap<String, String> mDatePatterns;
    private String mEncryptDirRoot;
    private String mEncryptPassword;
    private FileEncrypt mFileEncrypt;
    private int mNumChannels;
    private int mSampleRate;
    private int mServiceId;

    public interface ArchiverListener {
        void onAudioDataSavedToFile(long r1, long r3, String r5);
    }

    public static /* synthetic */ void $r8$lambda$Fdk_nLNAlnMxIAE4R7BOB_pYWnI(long r0, long r2, String r4, ArchiverListener r5) {
        lambda$onAudioDataReady$0(r0, r2, r4, r5);
    }

    static {
        TAG = AudioDataArchiver.class.getSimpleName();
    }

    public AudioDataArchiver() {
        this.mDatePatterns = new AnonymousClass1(this);
        this.mFileEncrypt = FileEncrypt.getInstance();
        this.mServiceId = FileEncrypt.audioServiceId;
        this.mEncryptPassword = TAG;
        this.mDataRecycleEventLogger = new EventLogger(100, "Recyle data file");
        this.mArchiveListenersLock = new Object();
        this.mArchiveListeners = new ArrayList();
        this.mEncryptDirRoot = initializeEncryptDirectory();
    }

    private byte[] getSecretData() {
        File secretDataFile = new File(SECRET_DATA_PATH);
        if (secretDataFile.exists() == true) goto L10;
        return null;
    L10:
        return IoUtils.readFileAsByteArray(SECRET_DATA_PATH);
    L7:
        e = move-exception;
        Log.v(TAG, "Failed to read secret data: " + e.getMessage());
        return null;
    }

    private void saveSecretData(byte[] secret) {
        Log.v(TAG, "saveSecretData: /data/misc/alwaysonrecord/secret_data");
        File secretDataFolder = new File(SECRET_DATA_FOLDER);     // Catch: IOException -> L11
        if (secretDataFolder.exists() == false) goto L14;
        if (secretDataFolder.isDirectory() == false) goto L14;
        File secretDataFile = new File(SECRET_DATA_PATH);     // Catch: IOException -> L11
        if (secretDataFile.exists() == false) goto L13;
        Log.w(TAG, "Secret data file already exists, force to delete");     // Catch: IOException -> L11
        secretDataFile.delete();     // Catch: IOException -> L11
    L13:
        secretDataFile.createNewFile();     // Catch: IOException -> L11
        FileOutputStream fos = new FileOutputStream(secretDataFile);     // Catch: IOException -> L11
        fos.write(secret);     // Catch: IOException -> L11
        FileUtils.sync(fos);     // Catch: IOException -> L11
        fos.close();     // Catch: IOException -> L11
        return;
    L14:
        Log.e(TAG, "/data/misc/alwaysonrecord is not a directory");     // Catch: IOException -> L11
        return;
    L11:
        e = move-exception;
        Log.w(TAG, "Failed to save secret data: " + e.getMessage());
    }

    private byte[] generateSecretData() {
        Log.v(TAG, "generateSecretData");
        byte[] salt = new byte[32];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(salt);
        byte[] secret = this.mFileEncrypt.genSecret(this.mEncryptPassword, salt);     // Catch: Exception -> L6
        saveSecretData(secret);
        return secret;
    L6:
        e = move-exception;
        e.printStackTrace();
        Log.w(TAG, "Failed to generate secret data: " + e.getMessage());
        return null;
    }

    private String initializeEncryptDirectory() {
        byte[] secret = getSecretData();
        if (secret != null) goto L5;
    L6:
        Log.w(TAG, "No available secret data, delete the encrypt directory");
        this.mFileEncrypt.serviceKeyDelete(this.mServiceId);
        secret = generateSecretData();
        if (secret != null) goto L9;
    L13:
        Log.e(TAG, "Failed to create secret data or store to file");
        return null;
    L9:
        if (secret.length == 0) goto L13;
    L11:
        this.mFileEncrypt.serviceKeyInit(this.mServiceId, secret);
        return this.mFileEncrypt.getStorageDir(this.mServiceId);
    L5:
        if (secret.length != 0) goto L11;
        goto L6
    }

    private void clearEncryptDirectory() {
        this.mFileEncrypt.serviceKeyDelete(this.mServiceId);
    }

    private boolean shouldClearEncryptDirectory() {
        return false;
    }

    private String getAudioRecordFilePath() {
        return getAudioRecordFilePath(0, 0);
    }

    private String getAudioRecordFilePath(long timestampInMs, long durationInMs) {
        if (timestampInMs != 0) goto L5;
        Date date = new Date();
    L12:
        String fileName = new SimpleDateFormat(DATE_FORMAT_PATTERN, Locale.getDefault()).format(date);
        SecureRandom random = new SecureRandom();
        int randomInt = random.nextInt(10000);
        return this.mEncryptDirRoot + SliceClientPermissions.SliceAuthority.DELIMITER + AUDIO_FILE_PREFIX + (fileName + "_" + randomInt + AUDIO_FILE_POSTFIX);
    L5:
        long now = System.currentTimeMillis();
        if (now > timestampInMs) goto L9;
        Log.e(TAG, "Invalid timestampInMs: " + timestampInMs + " vs now " + now);
        timestampInMs = now - durationInMs;
    L11:
        date = new Date(timestampInMs);
        goto L12
    L9:
        if ((now - timestampInMs) <= TIMESTAMP_GAP_FROM_NOW_IN_MS) goto L11;
        Slog.w(TAG, "Too old audio segment is received: " + ((((now - timestampInMs) / 1000) / 60) / 60) + " hours before");
        goto L11
    }

    private Date extractDateFromFileName(String fileName) {
        Iterator<Map.Entry<String, String>> r0 = this.mDatePatterns.entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        Map.Entry<String, String> entry = r0.next();
        String format = entry.getKey();
        String formatMatchPattern = entry.getValue();
        Pattern pattern = Pattern.compile(formatMatchPattern);
        Matcher matcher = pattern.matcher(fileName);
        if (matcher.matches() == false) goto L4;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.parse(matcher.group(1));
    L11:
        e = move-exception;
        Log.e(TAG, "Invalid date format: " + e.getMessage());
        goto L4
    L13:
        return null;
    }

    public void deleteOlderFiles(int periodInMinute) {
        int days = (periodInMinute / 60) / 24;
        int hours = (periodInMinute / 60) % 24;
        int minites = periodInMinute % 60;
        Log.v(TAG, "deleteOlderFiles: days " + days + " hours " + hours + " minites " + minites);
        if (this.mEncryptDirRoot != null) goto L6;
        Log.v(TAG, "Encrypt dir is not intialized:" + this.mEncryptDirRoot);
        this.mDataRecycleEventLogger.enqueue(new AlwaysOnRecordEvents.DataFileRecycleEvent(0, "Encrypt root null"));
        return;
    L6:
        File directory = new File(this.mEncryptDirRoot);
        if (directory.exists() == true) goto L10;
        Log.v(TAG, "No encrypt dir: " + this.mEncryptDirRoot);
        this.mDataRecycleEventLogger.enqueue(new AlwaysOnRecordEvents.DataFileRecycleEvent(0, "No encrypt dir"));
        return;
    L10:
        File[] files = directory.listFiles();
        if (files != null) goto L14;
        Log.v(TAG, "No files found in directory: " + this.mEncryptDirRoot);
        this.mDataRecycleEventLogger.enqueue(new AlwaysOnRecordEvents.DataFileRecycleEvent(0, "No files found"));
        return;
    L14:
        Calendar targetDay = Calendar.getInstance();
        targetDay.add(6, days * (-1));
        targetDay.add(11, hours * (-1));
        targetDay.add(12, minites * (-1));
        int r10 = files.length;
        int r11 = 0;
        int count = 0;
    L15:
        if (r11 >= r10) goto L36;
        File file = files[r11];
        if (file.isFile() == true) goto L19;
        Log.v(TAG, "file is not a regular file: " + file.getAbsolutePath());
    L35:
        r11 = r11 + 1;
        days = days;
        goto L15
    L19:
        Date date = extractDateFromFileName(file.getName());
        if (date != null) goto L22;
        Log.w(TAG, "Failed to parse date: " + file.getAbsolutePath());
        goto L35
    L22:
        Calendar day = Calendar.getInstance();
        day.setTime(date);
        if (day.after(targetDay) == true) goto L35;
        Log.v(TAG, "file is ready to delete " + file.getAbsolutePath());
    L30:
        e = move-exception;
        Log.w(TAG, "Failed to delete file: " + file.getAbsolutePath() + " " + e.getMessage());
    L34:
        count = count + 1;
        goto L35
    L27:
        if (file.delete() == true) goto L34;
        Log.w(TAG, "Failed to delete file: " + file.getAbsolutePath());     // Catch: SecurityException -> L30
        goto L34
    L36:
        logAutoCleanMetrics(count);
        this.mDataRecycleEventLogger.enqueue(new AlwaysOnRecordEvents.DataFileRecycleEvent(count, "Success"));
    }

    private boolean saveAudioData(String filePath, int dataSize, int sampleRate, int numChannels, int bitsPerSample, ByteBuffer data) {
        Log.v(TAG, "saveAudioData: " + filePath + " dataSize " + data.remaining());
        File file = new File(filePath);
        if (file.exists() == false) goto L19;
        Log.w(TAG, "File already exists: " + filePath);
        return false;
    L19:
        WavFileWritter writter = new WavFileWritter(file, dataSize, sampleRate, numChannels, bitsPerSample);     // Catch: IOException -> L13
        writter.write(data);     // Catch: IOException -> L13
        writter.close();     // Catch: IOException -> L13
        if (file.setReadable(true, false) == true) goto L12;
        Log.w(TAG, "Failed to set file readable");
    L12:
        return true;
    L17:
        Log.w(TAG, "Failed to write file");
        return false;
    }

    @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.AudioDataListener
    public void onAudioConfigUpated(int sampleRate, int numChannels, int bitsPerSample) {
        this.mSampleRate = sampleRate;
        this.mNumChannels = numChannels;
        this.mBitsPerSample = bitsPerSample;
    }

    @Override // com.android.server.alwaysonrecord.AlwaysOnRecordHwWrapper.AudioDataListener
    public boolean onAudioDataReady(final long timestampInMs, long durationInMs, ByteBuffer data) {
        if (this.mEncryptDirRoot != null) goto L6;
        Log.w(TAG, "Encrypt directory is not initialized");
        return false;
    L6:
        if (data != null) goto L8;
    L49:
        Log.e(TAG, "No data is ready to write");
        return false;
    L8:
        if (data.remaining() == 0) goto L49;
        if (this.mSampleRate != 0) goto L13;
    L47:
        Log.e(TAG, "Audio config is not initialized:  sampleRate " + this.mSampleRate + ", numChannels " + this.mNumChannels + ", bitsPerSample " + this.mBitsPerSample);
        return false;
    L13:
        if (this.mNumChannels == 0) goto L47;
        if (this.mBitsPerSample == 0) goto L47;
        long actualDurationInMs = (((((long) data.remaining()) * 1000) / ((long) this.mNumChannels)) / ((long) this.mSampleRate)) / ((long) (this.mBitsPerSample / 8));
        if (durationInMs == actualDurationInMs) goto L20;
        Log.w(TAG, "Invalid duration: " + durationInMs + " vs actual duration " + actualDurationInMs + " with data size " + data.remaining());
        long durationInMs2 = actualDurationInMs;
    L21:
        final String path = getAudioRecordFilePath(timestampInMs, durationInMs2);
        if (saveAudioData(path, data.remaining(), this.mSampleRate, this.mNumChannels, this.mBitsPerSample, data) == true) goto L25;
        Log.e(TAG, "Failed to save audio data");
        return false;
    L25:
        Object r7 = this.mArchiveListenersLock;
        monitor-enter(r7);
    L41:
        th = th;
    L45:
        monitor-exit(r7);     // Catch: Throwable -> L41
        throw th;
    L43:
        th = th;
        goto L45
    L28:
        if (this.mArchiveListeners.isEmpty() == true) goto L51;
        final long duration = durationInMs2;
        this.mArchiveListeners.forEach(new AudioDataArchiver$$ExternalSyntheticLambda0(timestampInMs, duration, path));     // Catch: Throwable -> L41
        monitor-exit(r7);     // Catch: Throwable -> L41
        return true;
    L51:
        Log.w(TAG, "No listener is registered");     // Catch: Throwable -> L32
        monitor-exit(r7);     // Catch: Throwable -> L32
        return false;
    L32:
        th = th;
        goto L45
    L20:
        durationInMs2 = durationInMs;
        goto L21
    }

    private static /* synthetic */ void lambda$onAudioDataReady$0(long timestampInMs, long duration, String path, ArchiverListener listener) {
        listener.onAudioDataSavedToFile(timestampInMs, duration, path);
    }

    public void registArchiveListener(ArchiverListener listener) {
        Object r0 = this.mArchiveListenersLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mArchiveListeners.contains(listener) == false) goto L11;
        Log.w(TAG, "Listener is registered before");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mArchiveListeners.add(listener);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void unregistArchiveListener(ArchiverListener listener) {
        Object r0 = this.mArchiveListenersLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mArchiveListeners.contains(listener) == true) goto L11;
        Log.w(TAG, "Listener is not registered before");     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L11:
        this.mArchiveListeners.remove(listener);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    public void logAutoCleanMetrics(int count) {
        MediaMetrics.Item mmi = new MediaMetrics.Item(mMetricsId).set(MediaMetrics.Property.EVENT, "autoClean").set(MediaMetrics.Property.FILE_COUNT, Integer.valueOf(count));
        mmi.record();
    }

    public void dump(PrintWriter pw) {
        File secretDataFile = new File(SECRET_DATA_PATH);
        File directory = null;
        File[] files = null;
        if (this.mEncryptDirRoot == null) goto L5;
        directory = new File(this.mEncryptDirRoot);
        files = directory.listFiles();
    L5:
        StringBuilder r3 = new StringBuilder();
        r3.append("- Secret file status = ");
        String r5 = "Ready";
        if (secretDataFile.exists() == false) goto L8;
        String r4 = "Ready";
    L9:
        r3.append(r4);
        pw.println(r3.toString());
        StringBuilder r6 = new StringBuilder();
        r6.append("- FBE folder status = ");
        if (this.mEncryptDirRoot != null) goto L13;
        r5 = "Not Initialized";
    L16:
        r6.append(r5);
        pw.println(r6.toString());
        StringBuilder r7 = new StringBuilder();
        r7.append("- Audio record file count = ");
        if (files != null) goto L19;
        Object r8 = "0";
    L20:
        r7.append(r8);
        pw.println(r7.toString());
        return;
    L19:
        r8 = Integer.valueOf(files.length);
        goto L20
    L13:
        if (directory.exists() == true) goto L16;
        r5 = "No encrypt dir";
        goto L16
    L8:
        r4 = "Not Exist";
        goto L9
    }
}
