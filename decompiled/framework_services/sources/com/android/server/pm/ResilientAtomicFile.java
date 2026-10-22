package com.android.server.pm;

import android.os.FileUtils;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.util.Slog;
import com.android.server.security.FileIntegrity;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes2.dex */
final class ResilientAtomicFile implements Closeable {
    private static final String LOG_TAG = "ResilientAtomicFile";
    private File mCurrentFile;
    private FileInputStream mCurrentInStream;
    private final String mDebugName;
    private final File mFile;
    private final int mFileMode;
    private FileInputStream mMainInStream;
    private FileOutputStream mMainOutStream;
    private final ReadEventLogger mReadEventLogger;
    private final File mReserveCopy;
    private FileInputStream mReserveInStream;
    private FileOutputStream mReserveOutStream;
    private final File mTemporaryBackup;

    interface ReadEventLogger {
        void logEvent(int r1, String r2);
    }

    private void finalizeOutStream(FileOutputStream str) throws IOException {
        str.flush();
        FileUtils.sync(str);
        FileUtils.setPermissions(str.getFD(), this.mFileMode, -1, -1);
    }

    ResilientAtomicFile(File file, File temporaryBackup, File reserveCopy, int fileMode, String debugName, ReadEventLogger readEventLogger) {
        this.mMainOutStream = null;
        this.mMainInStream = null;
        this.mReserveOutStream = null;
        this.mReserveInStream = null;
        this.mCurrentFile = null;
        this.mCurrentInStream = null;
        this.mFile = file;
        this.mTemporaryBackup = temporaryBackup;
        this.mReserveCopy = reserveCopy;
        this.mFileMode = fileMode;
        this.mDebugName = debugName;
        this.mReadEventLogger = readEventLogger;
    }

    public File getBaseFile() {
        return this.mFile;
    }

    public FileOutputStream startWrite() throws IOException {
        if (this.mMainOutStream != null) goto L22;
        new File(this.mFile.getParent()).mkdirs();
        if (this.mFile.exists() == true) goto L7;
    L14:
        this.mReserveCopy.delete();
        this.mMainOutStream = new FileOutputStream(this.mFile);     // Catch: IOException -> L18
        this.mMainInStream = new FileInputStream(this.mFile);     // Catch: IOException -> L18
        this.mReserveOutStream = new FileOutputStream(this.mReserveCopy);     // Catch: IOException -> L18
        this.mReserveInStream = new FileInputStream(this.mReserveCopy);     // Catch: IOException -> L18
        return this.mMainOutStream;
    L18:
        e = move-exception;
        close();
        throw e;
    L7:
        if (this.mTemporaryBackup.exists() == false) goto L9;
        this.mFile.delete();
        Slog.w(LOG_TAG, "Preserving older " + this.mDebugName + " backup");
        goto L14
    L9:
        if (this.mFile.renameTo(this.mTemporaryBackup) == true) goto L14;
        throw new IOException("Unable to backup " + this.mDebugName + " file, current changes will be lost at reboot");
    L22:
        throw new IllegalStateException("Duplicate startWrite call?");
    }

    public void finishWrite(FileOutputStream str) throws IOException {
        finishWrite(str, true);
    }

    public void finishWrite(FileOutputStream str, boolean doFsVerity) throws IOException {
        if (this.mMainOutStream != str) goto L91;
        FileOutputStream mainOutStream = this.mMainOutStream;
        this.mMainOutStream = null;     // Catch: Throwable -> L83
        finalizeOutStream(mainOutStream);     // Catch: Throwable -> L83
        if (mainOutStream == null) goto L8;
        mainOutStream.close();
    L8:
        this.mTemporaryBackup.delete();
        FileInputStream mainInStream = this.mMainInStream;     // Catch: IOException -> L57
        FileInputStream reserveInStream = this.mReserveInStream;     // Catch: Throwable -> L52
        this.mMainInStream = null;     // Catch: Throwable -> L16
        this.mReserveInStream = null;     // Catch: Throwable -> L16
        FileOutputStream reserveOutStream = this.mReserveOutStream;     // Catch: Throwable -> L16
        this.mReserveOutStream = null;     // Catch: Throwable -> L60
        FileUtils.copy(mainInStream, reserveOutStream);     // Catch: Throwable -> L60
        finalizeOutStream(reserveOutStream);     // Catch: Throwable -> L60
        if (reserveOutStream == null) goto L18;
        reserveOutStream.close();     // Catch: Throwable -> L16
    L18:
        if (doFsVerity == true) goto L92;
    L49:
        if (reserveInStream == null) goto L54;
        reserveInStream.close();     // Catch: Throwable -> L52
    L54:
        if (mainInStream == null) goto L115;
        mainInStream.close();     // Catch: IOException -> L57
        return;
    L115:
        return;
    L92:
        ParcelFileDescriptor mainPfd = ParcelFileDescriptor.dup(mainInStream.getFD());     // Catch: Throwable -> L16 IOException -> L30
        ParcelFileDescriptor copyPfd = ParcelFileDescriptor.dup(reserveInStream.getFD());     // Catch: Throwable -> L25
        FileIntegrity.setUpFsVerity(mainPfd);     // Catch: Throwable -> L33
        FileIntegrity.setUpFsVerity(copyPfd);     // Catch: Throwable -> L33
        if (copyPfd == null) goto L27;
        copyPfd.close();     // Catch: Throwable -> L25
    L27:
        if (mainPfd == null) goto L49;
        mainPfd.close();     // Catch: Throwable -> L16 IOException -> L30
        goto L49
    L33:
        th = move-exception;
        if (copyPfd != null) goto L98;
    L39:
        throw th;     // Catch: Throwable -> L25
    L98:
        copyPfd.close();     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        if (mainPfd != null) goto L102;
    L46:
        throw th;     // Catch: Throwable -> L16 IOException -> L30
    L102:
        mainPfd.close();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16 IOException -> L30
    L30:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to verity-protect " + this.mDebugName, e);     // Catch: Throwable -> L16
        goto L49
    L60:
        th = move-exception;
        if (reserveOutStream != null) goto L96;
    L67:
        throw th;     // Catch: Throwable -> L16
    L96:
        reserveOutStream.close();     // Catch: Throwable -> L64
    L64:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (reserveInStream != null) goto L104;
    L73:
        throw th;     // Catch: Throwable -> L52
    L104:
        reserveInStream.close();     // Catch: Throwable -> L71
    L71:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        if (mainInStream != null) goto L109;
    L80:
        throw th;     // Catch: IOException -> L57
    L109:
        mainInStream.close();     // Catch: Throwable -> L77
    L77:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L57
    L57:
        e = move-exception;
        Slog.e(LOG_TAG, "Failed to write reserve copy " + this.mDebugName + ": " + this.mReserveCopy, e);
        return;
    L83:
        th = move-exception;
        if (mainOutStream != null) goto L100;
    L89:
        throw th;
    L100:
        mainOutStream.close();     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        th.addSuppressed(th);
        goto L89
    L91:
        throw new IllegalStateException("Invalid incoming stream.");
    }

    public void failWrite(FileOutputStream str) {
        if (this.mMainOutStream != str) goto L11;
        close();
        if (this.mFile.exists() == true) goto L7;
        return;
    L7:
        if (this.mFile.delete() == true) goto L13;
        Slog.i(LOG_TAG, "Failed to clean up mangled file: " + this.mFile);
        return;
    L13:
        return;
    L11:
        throw new IllegalStateException("Invalid incoming stream.");
    }

    public FileInputStream openRead() throws IOException {
        if (this.mTemporaryBackup.exists() == false) goto L14;
        this.mCurrentFile = this.mTemporaryBackup;     // Catch: IOException -> L7
        this.mCurrentInStream = new FileInputStream(this.mCurrentFile);     // Catch: IOException -> L7
        if (this.mReadEventLogger == null) goto L10;
        this.mReadEventLogger.logEvent(4, "Need to read from backup " + this.mDebugName + " file");     // Catch: IOException -> L7
    L10:
        if (this.mFile.exists() == false) goto L12;
        Slog.w(LOG_TAG, "Cleaning up " + this.mDebugName + " file " + this.mFile);     // Catch: IOException -> L7
        this.mFile.delete();     // Catch: IOException -> L7
    L12:
        this.mReserveCopy.delete();     // Catch: IOException -> L7
    L14:
        if (this.mCurrentInStream == null) goto L18;
        return this.mCurrentInStream;
    L18:
        if (this.mFile.exists() == false) goto L21;
        this.mCurrentFile = this.mFile;
        this.mCurrentInStream = new FileInputStream(this.mCurrentFile);
    L26:
        if (this.mCurrentInStream != null) goto L31;
        if (this.mReadEventLogger == null) goto L31;
        this.mReadEventLogger.logEvent(4, "No " + this.mDebugName + " file");
    L31:
        return this.mCurrentInStream;
    L21:
        if (this.mReserveCopy.exists() == false) goto L26;
        this.mCurrentFile = this.mReserveCopy;
        this.mCurrentInStream = new FileInputStream(this.mCurrentFile);
        if (this.mReadEventLogger == null) goto L26;
        this.mReadEventLogger.logEvent(4, "Need to read from reserve copy " + this.mDebugName + " file");
        goto L26
    }

    public void failRead(FileInputStream str, Exception e) {
        if (this.mCurrentInStream != str) goto L14;
        this.mCurrentInStream = null;
        IoUtils.closeQuietly(str);
        if (this.mReadEventLogger == null) goto L8;
        this.mReadEventLogger.logEvent(6, "Error reading " + this.mDebugName + ", removing " + this.mCurrentFile + '\n' + Log.getStackTraceString(e));
    L8:
        if (this.mCurrentFile.delete() == false) goto L12;
        this.mCurrentFile = null;
        return;
    L12:
        throw new IllegalStateException("Failed to remove " + this.mCurrentFile);
    L14:
        throw new IllegalStateException("Invalid incoming stream.");
    }

    public void delete() {
        this.mFile.delete();
        this.mTemporaryBackup.delete();
        this.mReserveCopy.delete();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IoUtils.closeQuietly(this.mMainOutStream);
        IoUtils.closeQuietly(this.mMainInStream);
        IoUtils.closeQuietly(this.mReserveOutStream);
        IoUtils.closeQuietly(this.mReserveInStream);
        IoUtils.closeQuietly(this.mCurrentInStream);
        this.mMainOutStream = null;
        this.mMainInStream = null;
        this.mReserveOutStream = null;
        this.mReserveInStream = null;
        this.mCurrentInStream = null;
        this.mCurrentFile = null;
    }

    public String toString() {
        return this.mFile.getPath();
    }
}
