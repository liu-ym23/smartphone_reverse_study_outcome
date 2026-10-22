package com.android.server.powerstats;

import android.content.Context;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import com.android.internal.util.FileRotator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes3.dex */
public class PowerStatsDataStorage {
    private static final long DELETE_AGE_MILLIS = 172800000;
    private static final long MILLISECONDS_PER_HOUR = 3600000;
    private static final long ROTATE_AGE_MILLIS = 14400000;
    private static final String TAG = null;
    private final File mDataStorageDir;
    private final String mDataStorageFilename;
    private final FileRotator mFileRotator;
    private final ReentrantLock mLock;

    private static class DataElement {
        private static final int LENGTH_FIELD_WIDTH = 4;
        private static final int MAX_DATA_ELEMENT_SIZE = 32768;
        private byte[] mData;

        /* JADX INFO: renamed from: -$$Nest$mtoByteArray, reason: not valid java name */
        static /* bridge */ /* synthetic */ byte[] m7874$$Nest$mtoByteArray(DataElement r0) {
            return r0.toByteArray();
        }

        /* synthetic */ DataElement(InputStream r1, PowerStatsDataStorageIA r2) {
            this(r1);
        }

        /* synthetic */ DataElement(byte[] r1, PowerStatsDataStorageIA r2) {
            this(r1);
        }

        private byte[] toByteArray() throws IOException {
            ByteArrayOutputStream data = new ByteArrayOutputStream();
            data.write(ByteBuffer.allocate(4).putInt(this.mData.length).array());
            data.write(this.mData);
            return data.toByteArray();
        }

        protected byte[] getData() {
            return this.mData;
        }

        private DataElement(byte[] data) {
            this.mData = data;
        }

        private DataElement(InputStream in) throws IOException {
            byte[] lengthBytes = new byte[4];
            int bytesRead = in.read(lengthBytes);
            this.mData = new byte[0];
            if (bytesRead != 4) goto L16;
            int length = ByteBuffer.wrap(lengthBytes).getInt();
            if (length <= 0) goto L14;
            if (length >= 32768) goto L14;
            this.mData = new byte[length];
            int bytesRead2 = in.read(this.mData);
            if (bytesRead2 != length) goto L12;
            return;
        L12:
            throw new IOException("Invalid bytes read, expected: " + length + ", actual: " + bytesRead2);
        L14:
            throw new IOException("DataElement size is invalid: " + length);
        L16:
            throw new IOException("Did not read 4 bytes (" + bytesRead + ")");
        }
    }

    public interface DataElementReadCallback {
        void onReadDataElement(byte[] r1);
    }

    private static class DataReader implements FileRotator.Reader {
        private DataElementReadCallback mCallback;

        DataReader(DataElementReadCallback callback) {
            this.mCallback = callback;
        }

        public void read(InputStream in) throws IOException {
        L3:
            if (in.available() <= 0) goto L5;
            DataElement dataElement = new DataElement(in, null);
            this.mCallback.onReadDataElement(dataElement.getData());
            goto L3
        }
    }

    private static class DataRewriter implements FileRotator.Rewriter {
        byte[] mActiveFileData;
        byte[] mNewData;

        DataRewriter(byte[] data) {
            this.mActiveFileData = new byte[0];
            this.mNewData = data;
        }

        public void reset() {
        }

        public void read(InputStream in) throws IOException {
            this.mActiveFileData = new byte[in.available()];
            in.read(this.mActiveFileData);
        }

        public boolean shouldWrite() {
            return true;
        }

        public void write(OutputStream out) throws IOException {
            out.write(this.mActiveFileData);
            out.write(this.mNewData);
        }
    }

    static {
        TAG = PowerStatsDataStorage.class.getSimpleName();
    }

    public PowerStatsDataStorage(Context context, File dataStoragePath, String dataStorageFilename) {
        this.mLock = new ReentrantLock();
        this.mDataStorageDir = dataStoragePath;
        this.mDataStorageFilename = dataStorageFilename;
        if (this.mDataStorageDir.exists() == false) goto L5;
    L7:
        File[] files = this.mDataStorageDir.listFiles();
        int i = 0;
    L9:
        if (i >= files.length) goto L16;
        int versionDot = this.mDataStorageFilename.lastIndexOf(46);
        String beforeVersionDot = this.mDataStorageFilename.substring(0, versionDot);
        if (files[i].getName().startsWith(beforeVersionDot) == false) goto L15;
        if (files[i].getName().startsWith(this.mDataStorageFilename) == true) goto L15;
        files[i].delete();
    L15:
        i = i + 1;
        goto L9
    L16:
        this.mFileRotator = new FileRotator(this.mDataStorageDir, this.mDataStorageFilename, 14400000, DELETE_AGE_MILLIS);
        return;
    L5:
        if (this.mDataStorageDir.mkdirs() == true) goto L7;
        Slog.wtf(TAG, "mDataStorageDir does not exist: " + this.mDataStorageDir.getPath());
        this.mFileRotator = null;
    }

    public void write(byte[] data) {
        if (data != null) goto L4;
        return;
    L4:
        if (data.length <= 0) goto L19;
        this.mLock.lock();
        long currentTimeMillis = System.currentTimeMillis();     // Catch: Throwable -> L8 IOException -> L10
        DataElement dataElement = new DataElement(data, null);     // Catch: Throwable -> L8 IOException -> L10
        this.mFileRotator.rewriteActive(new DataRewriter(DataElement.m7874$$Nest$mtoByteArray(dataElement)), currentTimeMillis);     // Catch: Throwable -> L8 IOException -> L10
        this.mFileRotator.maybeRotate(currentTimeMillis);     // Catch: Throwable -> L8 IOException -> L10
    L7:
        this.mLock.unlock();
        return;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to write to on-device storage: " + e);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void read(DataElementReadCallback callback) throws IOException {
        this.mLock.lock();
        this.mFileRotator.readMatching(new DataReader(callback), Long.MIN_VALUE, Long.MAX_VALUE);     // Catch: Throwable -> L6
        this.mLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void deleteLogs() {
        this.mLock.lock();
        File[] files = this.mDataStorageDir.listFiles();     // Catch: Throwable -> L10
        int i = 0;
    L5:
        if (i >= files.length) goto L13;
        int versionDot = this.mDataStorageFilename.lastIndexOf(46);     // Catch: Throwable -> L10
        String beforeVersionDot = this.mDataStorageFilename.substring(0, versionDot);     // Catch: Throwable -> L10
        if (files[i].getName().startsWith(beforeVersionDot) == false) goto L12;
        files[i].delete();     // Catch: Throwable -> L10
    L12:
        i = i + 1;
        goto L5
    L13:
        this.mLock.unlock();
        return;
    L10:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }

    public void dump(IndentingPrintWriter ipw) {
        this.mLock.lock();
        int r3 = 46;
        int versionDot = this.mDataStorageFilename.lastIndexOf(46);     // Catch: Throwable -> L14
        String beforeVersionDot = this.mDataStorageFilename.substring(0, versionDot);     // Catch: Throwable -> L14
        File[] files = this.mDataStorageDir.listFiles();     // Catch: Throwable -> L14
        int number = 0;
        int dataSize = 0;
        long earliestLogEpochTime = Long.MAX_VALUE;
        int i = 0;
    L5:
        if (i >= files.length) goto L24;
        File file = files[i];     // Catch: Throwable -> L14
        String fileName = file.getName();     // Catch: Throwable -> L14
        if (files[i].getName().startsWith(beforeVersionDot) == false) goto L22;
        int number2 = number + 1;     // Catch: Throwable -> L14
        dataSize = (int) (((long) dataSize) + file.length());     // Catch: Throwable -> L14
        int firstTimeChar = fileName.lastIndexOf(r3) + 1;     // Catch: Throwable -> L14
        int endChar = fileName.lastIndexOf(45);     // Catch: Throwable -> L14
        Long startTime = Long.valueOf(Long.parseLong(fileName.substring(firstTimeChar, endChar)));     // Catch: Throwable -> L14 NumberFormatException -> L16
        if (startTime.longValue() >= earliestLogEpochTime) goto L18;
        earliestLogEpochTime = startTime.longValue();     // Catch: Throwable -> L14 NumberFormatException -> L16
        goto L18
    L18:
        number = number2;
    L16:
        nfe = move-exception;
        Slog.e(TAG, "Failed to extract start time from file : " + fileName, nfe);     // Catch: Throwable -> L14
        number = number2;
    L22:
        i = i + 1;     // Catch: Throwable -> L14
        versionDot = versionDot;
        beforeVersionDot = beforeVersionDot;
        r3 = 46;
        goto L5
    L24:
        if (earliestLogEpochTime == Long.MAX_VALUE) goto L26;
        ipw.println("Earliest data time : " + new Date(earliestLogEpochTime));     // Catch: Throwable -> L14
    L27:
        ipw.println("# files : " + number);     // Catch: Throwable -> L14
        ipw.println("Total data size (B) : " + dataSize);     // Catch: Throwable -> L14
        this.mLock.unlock();
        return;
    L26:
        ipw.println("Failed to parse earliest data time!!!");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        this.mLock.unlock();
        throw th;
    }
}
