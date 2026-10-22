package com.android.server.power.stats;

import android.hardware.tv.mediaquality.ParameterName;
import android.os.SystemClock;
import android.os.Trace;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import com.android.internal.os.BackgroundThread;
import com.android.internal.os.BatteryStatsHistory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryHistoryDirectory implements BatteryStatsHistory.BatteryHistoryStore {
    private static final boolean DEBUG = false;
    static final Compressor DEFAULT_COMPRESSOR = null;
    private static final int FILE_FORMAT_BYTES = 4;
    private static final byte[] FILE_FORMAT_COMPRESSED_PARCEL = null;
    private static final byte[] FILE_FORMAT_PARCEL = null;
    private static final String FILE_SUFFIX = ".bh";
    public static final String TAG = "BatteryHistoryDirectory";
    private final Compressor mCompressor;
    private final File mDirectory;
    private boolean mFileCompressionEnabled;
    private final List<BatteryHistoryFile> mHistoryFiles;
    private boolean mInitialized;
    private final ReentrantLock mLock;
    private int mMaxHistorySize;
    private boolean mWaitForDirectoryLock;

    static class BatteryHistoryFile extends BatteryStatsHistory.BatteryHistoryFragment {
        public final AtomicFile atomicFile;

        BatteryHistoryFile(File directory, long monotonicTimeMs) {
            super(monotonicTimeMs);
            this.atomicFile = new AtomicFile(new File(directory, monotonicTimeMs + BatteryHistoryDirectory.FILE_SUFFIX));
        }

        public String toString() {
            return this.atomicFile.getBaseFile().toString();
        }
    }

    interface Compressor {
        void compress(OutputStream r1, byte[] r2) throws IOException;

        void uncompress(byte[] r1, InputStream r2) throws IOException;

        default void readFully(byte[] data, InputStream stream) throws IOException {
            int pos = 0;
        L4:
            if (pos >= data.length) goto L10;
            int count = stream.read(data, pos, data.length - pos);
            if (count == (-1)) goto L9;
            pos = pos + count;
            goto L4
        L9:
            throw new IOException("Invalid battery history file format");
        }
    }

    public static /* synthetic */ boolean $r8$lambda$4_IaI9G7_lCfmgCS4OX1O0RYuI8(BatteryHistoryDirectory r0, List r1, Set r2, File r3, String r4) {
        return r0.lambda$ensureInitialized$2(r1, r2, r3, r4);
    }

    public static /* synthetic */ void $r8$lambda$GNciJzgYSSxlT7k25HNe9uFcdo8(BatteryHistoryDirectory r0, AtomicFile r1, byte[] r2) {
        r0.lambda$writeFragment$0(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$HJcDn7BYV6qYFdm9J-T1ZR61QyE, reason: not valid java name */
    public static /* synthetic */ void m7706$r8$lambda$HJcDn7BYV6qYFdm9JT1ZR61QyE(BatteryHistoryDirectory r0) {
        r0.lambda$writeFragment$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$t-NcGBV2AhPe8Gl0d2zXWSPrsEM, reason: not valid java name */
    public static /* synthetic */ void m7707$r8$lambda$tNcGBV2AhPe8Gl0d2zXWSPrsEM(BatteryHistoryDirectory r0, List r1) {
        r0.lambda$ensureInitialized$3(r1);
    }

    static {
        FILE_FORMAT_PARCEL = new byte[]{ParameterName.BASS, ParameterName.SURROUND_SOUND_ENABLED, ParameterName.COLOR_TUNER_SATURATION_BLUE, 76};
        FILE_FORMAT_COMPRESSED_PARCEL = new byte[]{ParameterName.COLOR_TUNER_SATURATION_FLESH, ParameterName.DOLBY_AUDIO_PROCESSING, ParameterName.COLOR_TUNER_LUMINANCE_GREEN, ParameterName.BASS};
        DEFAULT_COMPRESSOR = new AnonymousClass1();
    }

    public BatteryHistoryDirectory(File directory, int maxHistorySize) {
        this(directory, maxHistorySize, DEFAULT_COMPRESSOR);
    }

    public BatteryHistoryDirectory(File directory, int maxHistorySize, Compressor compressor) {
        this.mHistoryFiles = new ArrayList();
        this.mLock = new ReentrantLock();
        this.mWaitForDirectoryLock = false;
        this.mDirectory = directory;
        this.mMaxHistorySize = maxHistorySize;
        if (this.mMaxHistorySize != 0) goto L5;
        Slog.w(TAG, "maxHistorySize should not be zero");
    L5:
        this.mCompressor = compressor;
    }

    public void setFileCompressionEnabled(boolean enabled) {
        this.mFileCompressionEnabled = enabled;
    }

    void setMaxHistorySize(int maxHistorySize) {
        this.mMaxHistorySize = maxHistorySize;
        trim();
    }

    public int getMaxHistorySize() {
        return this.mMaxHistorySize;
    }

    public void lock() {
        this.mLock.lock();
    }

    void makeDirectoryLockUnconditional() {
        this.mWaitForDirectoryLock = true;
    }

    public boolean tryLock() {
        if (this.mWaitForDirectoryLock == false) goto L7;
        this.mLock.lock();
        return true;
    L7:
        return this.mLock.tryLock();
    }

    public void writeFragment(BatteryStatsHistory.BatteryHistoryFragment fragment, final byte[] data, boolean fragmentComplete) {
        final AtomicFile file = ((BatteryHistoryFile) fragment).atomicFile;
        FileOutputStream fos = null;
        SystemClock.uptimeMillis();     // Catch: IOException -> L8
        fos = file.startWrite();     // Catch: IOException -> L8
        fos.write(FILE_FORMAT_PARCEL);     // Catch: IOException -> L8
        writeInt(fos, data.length);     // Catch: IOException -> L8
        fos.write(data);     // Catch: IOException -> L8
        fos.flush();     // Catch: IOException -> L8
        file.finishWrite(fos);     // Catch: IOException -> L8
        if (fragmentComplete == true) goto L6;
        return;
    L6:
        if (this.mFileCompressionEnabled == false) goto L10;
        BackgroundThread.getHandler().post(new BatteryHistoryDirectory$$ExternalSyntheticLambda2(this, file, data));     // Catch: IOException -> L8
    L10:
        BackgroundThread.getHandler().post(new BatteryHistoryDirectory$$ExternalSyntheticLambda3(this));     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        Slog.w(TAG, "Error writing battery history fragment", e);
        file.failWrite(fos);
    }

    private /* synthetic */ void lambda$writeFragment$0(AtomicFile file, byte[] data) {
        writeHistoryFragmentCompressed(file, data);
    }

    private /* synthetic */ void lambda$writeFragment$1() {
        trim();
    }

    private void writeHistoryFragmentCompressed(AtomicFile file, byte[] data) {
        long uncompressedSize = data.length;
        if (uncompressedSize != 0) goto L5;
        return;
    L5:
        Trace.traceBegin(524288, "BatteryStatsHistory.compressHistoryFile");
        lock();
        FileOutputStream fos = null;
        System.nanoTime();     // Catch: Throwable -> L8 Exception -> L10
        fos = file.startWrite();     // Catch: Throwable -> L8 Exception -> L10
        fos.write(FILE_FORMAT_COMPRESSED_PARCEL);     // Catch: Throwable -> L8 Exception -> L10
        writeInt(fos, data.length);     // Catch: Throwable -> L8 Exception -> L10
        this.mCompressor.compress(fos, data);     // Catch: Throwable -> L8 Exception -> L10
        file.finishWrite(fos);     // Catch: Throwable -> L8 Exception -> L10
    L7:
        unlock();
        Trace.traceEnd(524288);
        return;
    L8:
        th = move-exception;
        unlock();
        Trace.traceEnd(524288);
        throw th;
    L10:
        e = move-exception;
        Slog.w(TAG, "Error compressing battery history chunk " + file, e);     // Catch: Throwable -> L8
        file.failWrite(fos);     // Catch: Throwable -> L8
        goto L7
    }

    public byte[] readFragment(BatteryStatsHistory.BatteryHistoryFragment fragment) {
        AtomicFile file = ((BatteryHistoryFile) fragment).atomicFile;
        if (file.exists() == true) goto L6;
        deleteFragment(fragment);
        return null;
    L6:
        SystemClock.uptimeMillis();
        Trace.traceBegin(524288, "BatteryStatsHistory.read");
        FileInputStream stream = file.openRead();     // Catch: Throwable -> L18 Exception -> L20
        byte[] header = new byte[4];     // Catch: Throwable -> L22
        if (stream.read(header, 0, 4) != (-1)) goto L94;
        if (file.getBaseFile().length() != 0) goto L26;
        byte[] r0 = new byte[0];     // Catch: Throwable -> L22
        stream.close();     // Catch: Throwable -> L18 Exception -> L20
        Trace.traceEnd(524288);
        return r0;
    L26:
        Slog.e(TAG, "Invalid battery history file format " + file.getBaseFile());     // Catch: Throwable -> L22
        deleteFragment(fragment);     // Catch: Throwable -> L22
        stream.close();     // Catch: Throwable -> L18 Exception -> L20
        Trace.traceEnd(524288);
        return null;
    L94:
        if (Arrays.equals(header, FILE_FORMAT_COMPRESSED_PARCEL) == false) goto L34;
        boolean isCompressed = true;
    L36:
        int size = readInt(stream);     // Catch: Throwable -> L22
        if (size < 0) goto L69;
        if (size > 10000000) goto L69;
        byte[] data = new byte[size];     // Catch: Throwable -> L22
        if (isCompressed == true) goto L44;
        int pos = 0;
    L49:
        if (pos >= data.length) goto L61;
        int count = stream.read(data, pos, data.length - pos);     // Catch: Throwable -> L45
        if (count == (-1)) goto L56;
        pos = pos + count;     // Catch: Throwable -> L45
        goto L49
    L56:
        throw new IOException("Invalid battery history file format");     // Catch: Throwable -> L57
    L61:
        stream.close();     // Catch: Throwable -> L64 Exception -> L66
        Trace.traceEnd(524288);
        return data;
    L44:
        this.mCompressor.uncompress(data, stream);     // Catch: Throwable -> L45
    L45:
        th = th;
    L25:
        Throwable r3 = th;
        if (stream == null) goto L100;
        stream.close();     // Catch: Throwable -> L81
        throw r3;     // Catch: Throwable -> L64 Exception -> L66
    L81:
        th = move-exception;
        r3.addSuppressed(th);     // Catch: Throwable -> L64 Exception -> L66
        throw r3;     // Catch: Throwable -> L64 Exception -> L66
    L100:
        throw r3;     // Catch: Throwable -> L64 Exception -> L66
    L69:
        Slog.e(TAG, "Invalid battery history file format " + file.getBaseFile());     // Catch: Throwable -> L57
        deleteFragment(fragment);     // Catch: Throwable -> L57
        stream.close();     // Catch: Throwable -> L64 Exception -> L66
        Trace.traceEnd(524288);
        return 0;
    L34:
        if (Arrays.equals(header, FILE_FORMAT_PARCEL) == false) goto L74;
        isCompressed = false;
        goto L36
    L74:
        Slog.e(TAG, "Invalid battery history file format " + file.getBaseFile());     // Catch: Throwable -> L57
        deleteFragment(fragment);     // Catch: Throwable -> L57
        stream.close();     // Catch: Throwable -> L64 Exception -> L66
        Trace.traceEnd(524288);
        return null;
    L57:
        th = th;
    L22:
        th = th;
    L66:
        e = e;
    L86:
        Slog.e(TAG, "Error reading file " + file.getBaseFile().getPath(), e);     // Catch: Throwable -> L64
        deleteFragment(fragment);     // Catch: Throwable -> L64
        Trace.traceEnd(524288);
        return null;
    L64:
        e = th;
    L89:
        Trace.traceEnd(524288);
        throw e;
    L20:
        e = e;
    L18:
        e = th;
        goto L89
    }

    private void deleteFragment(BatteryStatsHistory.BatteryHistoryFragment fragment) {
        this.mHistoryFiles.remove(fragment);
        ((BatteryHistoryFile) fragment).atomicFile.delete();
    }

    public void unlock() {
        this.mLock.unlock();
    }

    public boolean isLocked() {
        return this.mLock.isLocked();
    }

    private void ensureInitialized() {
        if (this.mInitialized == false) goto L5;
        return;
    L5:
        Trace.asyncTraceBegin(524288, "BatteryStatsHistory.load", 0);
        this.mDirectory.mkdirs();
        if (this.mDirectory.exists() == true) goto L8;
        Slog.wtf(TAG, "HistoryDir does not exist:" + this.mDirectory.getPath());
    L8:
        final List<File> toRemove = new ArrayList();
        final Set<BatteryHistoryFile> dedup = new ArraySet();
        this.mDirectory.listFiles(new BatteryHistoryDirectory$$ExternalSyntheticLambda0(this, toRemove, dedup));
        if (dedup.isEmpty() == true) goto L11;
        this.mHistoryFiles.addAll(dedup);
        Collections.sort(this.mHistoryFiles);
    L11:
        this.mInitialized = true;
        if (toRemove.isEmpty() == true) goto L14;
        BackgroundThread.getHandler().post(new BatteryHistoryDirectory$$ExternalSyntheticLambda1(this, toRemove));
        return;
    L14:
        Trace.asyncTraceEnd(524288, "BatteryStatsHistory.load", 0);
    }

    private /* synthetic */ boolean lambda$ensureInitialized$2(List toRemove, Set dedup, File dir, String name) {
        int b = name.lastIndexOf(FILE_SUFFIX);
        if (b > 0) goto L12;
        toRemove.add(new File(dir, name));
        return false;
    L12:
        long monotonicTime = Long.parseLong(name.substring(0, b));     // Catch: NumberFormatException -> L9
        dedup.add(new BatteryHistoryFile(this.mDirectory, monotonicTime));     // Catch: NumberFormatException -> L9
        return true;
    L10:
        toRemove.add(new File(dir, name));
        return false;
    }

    private /* synthetic */ void lambda$ensureInitialized$3(List toRemove) {
        lock();
        Iterator r4 = toRemove.iterator();     // Catch: Throwable -> L8
    L5:
        if (r4.hasNext() == false) goto L10;
        File file = (File) r4.next();     // Catch: Throwable -> L8
        file.delete();     // Catch: Throwable -> L8
        goto L5
    L10:
        unlock();
        Trace.asyncTraceEnd(524288, "BatteryStatsHistory.load", 0);
        return;
    L8:
        th = move-exception;
        unlock();
        Trace.asyncTraceEnd(524288, "BatteryStatsHistory.load", 0);
        throw th;
    }

    public List<BatteryStatsHistory.BatteryHistoryFragment> getFragments() {
        if (this.mLock.isHeldByCurrentThread() == false) goto L7;
        ensureInitialized();
        return this.mHistoryFiles;
    L7:
        throw new IllegalStateException("Reading battery history without a lock");
    }

    List<String> getFileNames() {
        ensureInitialized();
        lock();
        List<String> names = new ArrayList();     // Catch: Throwable -> L8
        Iterator<BatteryHistoryFile> r1 = this.mHistoryFiles.iterator();     // Catch: Throwable -> L8
    L5:
        if (r1.hasNext() == false) goto L10;
        BatteryHistoryFile historyFile = r1.next();     // Catch: Throwable -> L8
        names.add(historyFile.atomicFile.getBaseFile().getName());     // Catch: Throwable -> L8
        goto L5
    L10:
        unlock();
        return names;
    L8:
        th = move-exception;
        unlock();
        throw th;
    }

    public BatteryStatsHistory.BatteryHistoryFragment getEarliestFragment() {
        ensureInitialized();
        lock();
    L8:
        th = move-exception;
        unlock();
        throw th;
    L4:
        if (this.mHistoryFiles.isEmpty() == true) goto L10;
        BatteryHistoryFile r0 = this.mHistoryFiles.get(0);     // Catch: Throwable -> L8
        unlock();
        return r0;
    L10:
        unlock();
        return null;
    }

    public BatteryStatsHistory.BatteryHistoryFragment getLatestFragment() {
        ensureInitialized();
        lock();
    L8:
        th = move-exception;
        unlock();
        throw th;
    L4:
        if (this.mHistoryFiles.isEmpty() == true) goto L10;
        BatteryHistoryFile r0 = this.mHistoryFiles.get(this.mHistoryFiles.size() - 1);     // Catch: Throwable -> L8
        unlock();
        return r0;
    L10:
        unlock();
        return null;
    }

    public BatteryStatsHistory.BatteryHistoryFragment createFragment(long monotonicStartTime) {
        ensureInitialized();
        BatteryHistoryFile file = new BatteryHistoryFile(this.mDirectory, monotonicStartTime);
        lock();
        file.atomicFile.getBaseFile().createNewFile();     // Catch: Throwable -> L5 IOException -> L7
    L9:
        this.mHistoryFiles.add(file);     // Catch: Throwable -> L5
        unlock();
        return file;
    L5:
        th = move-exception;
        unlock();
        throw th;
    L8:
        Slog.e(TAG, "Could not create history file: " + file);     // Catch: Throwable -> L5
        goto L9
    }

    public boolean hasCompletedFragments() {
        ensureInitialized();
        lock();
        boolean r1 = true;
        if (this.mHistoryFiles.size() > 1) goto L8;
        r1 = false;
    L8:
        unlock();
        return r1;
    L10:
        th = move-exception;
        unlock();
        throw th;
    }

    public int getSize() {
        ensureInitialized();
        lock();
        int ret = 0;
        int i = 0;
    L13:
    L7:
        th = move-exception;
        unlock();
        throw th;
    L4:
        if (i >= (this.mHistoryFiles.size() - 1)) goto L9;
        ret = ret + ((int) this.mHistoryFiles.get(i).atomicFile.getBaseFile().length());
        i = i + 1;
        goto L13
    L9:
        unlock();
        return ret;
    }

    public void reset() {
        ensureInitialized();
        lock();
        Iterator<BatteryHistoryFile> r0 = this.mHistoryFiles.iterator();     // Catch: Throwable -> L7
    L5:
        if (r0.hasNext() == false) goto L9;
        BatteryHistoryFile file = r0.next();     // Catch: Throwable -> L7
        file.atomicFile.delete();     // Catch: Throwable -> L7
        goto L5
    L9:
        this.mHistoryFiles.clear();     // Catch: Throwable -> L7
        unlock();
        return;
    L7:
        th = move-exception;
        unlock();
        throw th;
    }

    private void trim() {
        ensureInitialized();
        Trace.traceBegin(524288, "BatteryStatsHistory.trim");
        lock();     // Catch: Throwable -> L19
        int size = 0;
        int i = 0;
    L26:
    L8:
        th = move-exception;
        unlock();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L6:
        if (i >= this.mHistoryFiles.size()) goto L10;
        size = size + ((int) this.mHistoryFiles.get(i).atomicFile.getBaseFile().length());     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
    L10:
        if (size <= this.mMaxHistorySize) goto L16;
        if (this.mHistoryFiles.size() <= 1) goto L16;
        BatteryHistoryFile oldest = this.mHistoryFiles.get(0);     // Catch: Throwable -> L8
        int length = (int) oldest.atomicFile.getBaseFile().length();     // Catch: Throwable -> L8
        oldest.atomicFile.delete();     // Catch: Throwable -> L8
        this.mHistoryFiles.remove(0);     // Catch: Throwable -> L8
        size = size - length;
    L16:
        unlock();     // Catch: Throwable -> L19
        Trace.traceEnd(524288);
        return;
    L19:
        th = move-exception;
        Trace.traceEnd(524288);
        throw th;
    }

    private static void writeInt(OutputStream stream, int value) throws IOException {
        stream.write(value >> 24);
        stream.write(value >> 16);
        stream.write(value >> 8);
        stream.write(value >> 0);
    }

    private static int readInt(InputStream stream) throws IOException {
        return (((readByte(stream) << 24) | (readByte(stream) << 16)) | (readByte(stream) << 8)) | (readByte(stream) << 0);
    }

    private static int readByte(InputStream stream) throws IOException {
        int out = stream.read();
        if (out == (-1)) goto L6;
        return out;
    L6:
        throw new IOException();
    }
}
