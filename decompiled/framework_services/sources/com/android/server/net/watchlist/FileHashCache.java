package com.android.server.net.watchlist;

import android.os.Handler;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Slog;
import com.android.internal.util.HexDump;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class FileHashCache {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private static final boolean VERIFY = false;
    private static boolean sLoggedWtf;
    static String sPersistFileName;
    static long sSaveDeferredDelayMillis;
    private final Map<File, Entry> mEntries;
    private Handler mHandler;
    private final Runnable mLoadTask;
    private final Runnable mSaveTask;

    private static class Entry {
        public final long mLastModified;
        public final byte[] mSha256Hash;

        Entry(long lastModified, byte[] sha256Hash) {
            this.mLastModified = lastModified;
            this.mSha256Hash = sha256Hash;
        }
    }

    public static /* synthetic */ void $r8$lambda$7iqHSDy1kezFFyodG_K8GRxW5WY(FileHashCache r0) {
        r0.lambda$new$1();
    }

    public static /* synthetic */ void $r8$lambda$XmzG5s8BLMJYmEt7B99IAGifpm8(FileHashCache r0, String r1) {
        r0.lambda$load$2(r1);
    }

    public static /* synthetic */ void $r8$lambda$hsCGipkBAfL3pR1io9UD6GCAG9w(FileHashCache r0) {
        r0.lambda$new$0();
    }

    static {
        TAG = FileHashCache.class.getSimpleName();
        sLoggedWtf = false;
        sPersistFileName = "/data/system/file_hash_cache";
        sSaveDeferredDelayMillis = TimeUnit.SECONDS.toMillis(5);
    }

    private /* synthetic */ void lambda$new$0() {
        load();
    }

    private /* synthetic */ void lambda$new$1() {
        save();
    }

    public FileHashCache(Handler handler) {
        this.mEntries = new HashMap();
        this.mLoadTask = new FileHashCache$$ExternalSyntheticLambda0(this);
        this.mSaveTask = new FileHashCache$$ExternalSyntheticLambda1(this);
        this.mHandler = handler;
        this.mHandler.post(this.mLoadTask);
    }

    byte[] getSha256HashFromCache(File file) {
        if (this.mHandler.getLooper().isCurrentThread() == true) goto L6;
        Slog.wtf(TAG, "Request from invalid thread", new Exception());
        return null;
    L6:
        Entry entry = this.mEntries.get(file);
        if (entry != null) goto L16;
        return null;
    L16:
        if (entry.mLastModified != Os.stat(file.getAbsolutePath()).st_ctime) goto L14;
        return entry.mSha256Hash;
    L14:
        this.mEntries.remove(file);
        return null;
    }

    public byte[] getSha256Hash(File file) throws NoSuchAlgorithmException, IOException {
        byte[] sha256Hash = getSha256HashFromCache(file);
        if (sha256Hash == null) goto L10;
        return sha256Hash;
    L10:
        byte[] sha256Hash2 = DigestUtils.getSha256Hash(file);     // Catch: ErrnoException -> L7
        this.mEntries.put(file, new Entry(Os.stat(file.getAbsolutePath()).st_ctime, sha256Hash2));     // Catch: ErrnoException -> L7
        scheduleSave();     // Catch: ErrnoException -> L7
        return sha256Hash2;
    L7:
        e = move-exception;
        throw new IOException(e);
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable == null) goto L10;
        closeable.close();     // Catch: IOException -> L5
        return;
    L7:
        return;
    }

    private static void logWtfOnce(String s, Exception e) {
        if (sLoggedWtf == true) goto L5;
        Slog.wtf(TAG, s, e);
        sLoggedWtf = true;
        return;
    L5:
        Slog.w(TAG, s, e);
    }

    private void load() {
        this.mEntries.clear();
        SystemClock.currentTimeMicro();
        File file = new File(sPersistFileName);
        if (file.exists() == true) goto L5;
        return;
    L5:
        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(file));     // Catch: Throwable -> L8 Throwable -> L10
        reader.lines().forEach(new FileHashCache$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L8 Throwable -> L10
    L7:
        closeQuietly(reader);
        return;
    L8:
        th = move-exception;
        closeQuietly(reader);
        throw th;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to read storage file", e);     // Catch: Throwable -> L8
        goto L7
    }

    private /* synthetic */ void lambda$load$2(String fileEntry) {
        StringTokenizer tokenizer = new StringTokenizer(fileEntry, ",");     // Catch: RuntimeException -> L4
        File testFile = new File(tokenizer.nextToken());     // Catch: RuntimeException -> L4
        long lastModified = Long.parseLong(tokenizer.nextToken());     // Catch: RuntimeException -> L4
        byte[] sha256 = HexDump.hexStringToByteArray(tokenizer.nextToken());     // Catch: RuntimeException -> L4
        this.mEntries.put(testFile, new Entry(lastModified, sha256));     // Catch: RuntimeException -> L4
        return;
    L4:
        e = move-exception;
        logWtfOnce("Invalid entry for " + fileEntry, e);
    }

    private void scheduleSave() {
        this.mHandler.removeCallbacks(this.mSaveTask);
        this.mHandler.postDelayed(this.mSaveTask, sSaveDeferredDelayMillis);
    }

    private void save() {
        BufferedWriter writer = null;
        SystemClock.currentTimeMicro();
        writer = new BufferedWriter(new FileWriter(sPersistFileName));     // Catch: Throwable -> L8 IOException -> L10
        Iterator<Map.Entry<File, Entry>> r4 = this.mEntries.entrySet().iterator();     // Catch: Throwable -> L8 IOException -> L10
    L5:
        if (r4.hasNext() == false) goto L13;
        Map.Entry<File, Entry> entry = r4.next();     // Catch: Throwable -> L8 IOException -> L10
        writer.write(entry.getKey() + "," + entry.getValue().mLastModified + "," + HexDump.toHexString(entry.getValue().mSha256Hash) + "\n");     // Catch: Throwable -> L8 IOException -> L10
    L13:
        closeQuietly(writer);
        return;
    L8:
        th = move-exception;
        closeQuietly(writer);
        throw th;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to save.", e);     // Catch: Throwable -> L8
        goto L13
    }
}
