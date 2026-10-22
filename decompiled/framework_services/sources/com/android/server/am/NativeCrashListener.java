package com.android.server.am;

import android.app.ApplicationErrorReport;
import android.hardware.tv.hdmi.cec.CecDeviceType;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructTimeval;
import android.system.UnixSocketAddress;
import android.util.Slog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import org.apache.commons.compress.archivers.zip.UnixStat;
import org.apache.commons.compress.utils.CharsetNames;

/* JADX INFO: loaded from: classes.dex */
final class NativeCrashListener extends Thread {
    static final boolean DEBUG = false;
    static final String DEBUGGERD_SOCKET_PATH = "/data/system/ndebugsocket";
    static final boolean MORE_DEBUG = false;
    static final long SOCKET_TIMEOUT_MILLIS = 10000;
    static final String TAG = "NativeCrashListener";
    final ActivityManagerService mAm;

    class NativeCrashReporter extends Thread {
        ProcessRecord mApp;
        String mCrashReport;
        boolean mGwpAsanRecoverableCrash;
        int mSignal;
        final /* synthetic */ NativeCrashListener this$0;

        NativeCrashReporter(NativeCrashListener this$0, ProcessRecord app, int signal, boolean gwpAsanRecoverableCrash, String report) {
            this.this$0 = this$0;
            super("NativeCrashReport");
            this.mApp = app;
            this.mSignal = signal;
            this.mGwpAsanRecoverableCrash = gwpAsanRecoverableCrash;
            this.mCrashReport = report;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ApplicationErrorReport.CrashInfo ci = new ApplicationErrorReport.CrashInfo();     // Catch: Exception -> L6
            ci.exceptionClassName = "Native crash";     // Catch: Exception -> L6
            ci.exceptionMessage = Os.strsignal(this.mSignal);     // Catch: Exception -> L6
            ci.throwFileName = "unknown";     // Catch: Exception -> L6
            ci.throwClassName = "unknown";     // Catch: Exception -> L6
            ci.throwMethodName = "unknown";     // Catch: Exception -> L6
            ci.stackTrace = this.mCrashReport;     // Catch: Exception -> L6
            ActivityManagerService r0 = this.this$0.mAm;     // Catch: Exception -> L6
            if (this.mGwpAsanRecoverableCrash == false) goto L8;
            String r2 = "native_recoverable_crash";
        L9:
            r0.handleApplicationCrashInner(r2, this.mApp, this.mApp.processName, ci);     // Catch: Exception -> L6
            return;
        L8:
            r2 = "native_crash";
        L6:
            e = move-exception;
            Slog.e(NativeCrashListener.TAG, "Unable to report native crash", e);
        }
    }

    NativeCrashListener(ActivityManagerService am) {
        this.mAm = am;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        byte[] ackSignal = new byte[1];
        File socketFile = new File(DEBUGGERD_SOCKET_PATH);
        if (socketFile.exists() == false) goto L49;
        socketFile.delete();
    L49:
        FileDescriptor serverFd = Os.socket(OsConstants.AF_UNIX, OsConstants.SOCK_STREAM, 0);     // Catch: Exception -> L21
        UnixSocketAddress sockAddr = UnixSocketAddress.createFileSystem(DEBUGGERD_SOCKET_PATH);     // Catch: Exception -> L21
        Os.bind(serverFd, sockAddr);     // Catch: Exception -> L21
        Os.listen(serverFd, 1);     // Catch: Exception -> L21
        Os.chmod(DEBUGGERD_SOCKET_PATH, UnixStat.DEFAULT_LINK_PERM);     // Catch: Exception -> L21
    L6:
        FileDescriptor peerFd = null;
        peerFd = Os.accept(serverFd, null);     // Catch: Throwable -> L11 Exception -> L13
        if (peerFd == null) goto L15;
        consumeNativeCrashData(peerFd);     // Catch: Throwable -> L11 Exception -> L13
    L15:
        if (peerFd == null) goto L6;
        Os.write(peerFd, ackSignal, 0, 1);     // Catch: Exception -> L18
    L58:
        Os.close(peerFd);     // Catch: Exception -> L21 ErrnoException -> L23
        goto L6
    L13:
        e = move-exception;
        Slog.w(TAG, "Error handling connection", e);     // Catch: Throwable -> L11
        if (peerFd == null) goto L6;
        Os.write(peerFd, ackSignal, 0, 1);     // Catch: Exception -> L30
    L31:
        Os.close(peerFd);     // Catch: Exception -> L21 ErrnoException -> L23
    L11:
        th = move-exception;
        if (peerFd != null) goto L51;
    L42:
        throw th;     // Catch: Exception -> L21
    L51:
        Os.write(peerFd, ackSignal, 0, 1);     // Catch: Exception -> L37
    L56:
        Os.close(peerFd);     // Catch: Exception -> L21 ErrnoException -> L40
    L21:
        e = move-exception;
        Slog.e(TAG, "Unable to init native debug socket!", e);
    }

    static int unpackInt(byte[] buf, int offset) {
        int b0 = buf[offset] & CecDeviceType.INACTIVE;
        int b1 = buf[offset + 1] & CecDeviceType.INACTIVE;
        int b2 = buf[offset + 2] & CecDeviceType.INACTIVE;
        int b3 = buf[offset + 3] & CecDeviceType.INACTIVE;
        return (((b0 << 24) | (b1 << 16)) | (b2 << 8)) | b3;
    }

    static int readExactly(FileDescriptor fd, byte[] buffer, int offset, int numBytes) throws ErrnoException, InterruptedIOException {
        int totalRead = 0;
    L3:
        if (numBytes <= 0) goto L9;
        int n = Os.read(fd, buffer, offset + totalRead, numBytes);
        if (n <= 0) goto L6;
        numBytes = numBytes - n;
        totalRead = totalRead + n;
        goto L3
    L6:
        return -1;
    L9:
        return totalRead;
    }

    void consumeNativeCrashData(FileDescriptor fd) {
        byte[] buf = new byte[4096];
        ByteArrayOutputStream os = new ByteArrayOutputStream(4096);
        StructTimeval timeout = StructTimeval.fromMillis(10000);     // Catch: Exception -> L7
        Os.setsockoptTimeval(fd, OsConstants.SOL_SOCKET, OsConstants.SO_RCVTIMEO, timeout);     // Catch: Exception -> L7
        Os.setsockoptTimeval(fd, OsConstants.SOL_SOCKET, OsConstants.SO_SNDTIMEO, timeout);     // Catch: Exception -> L7
        int headerBytes = readExactly(fd, buf, 0, 9);     // Catch: Exception -> L7
        if (headerBytes == 9) goto L9;
        Slog.e(TAG, "Unable to read from debuggerd");     // Catch: Exception -> L7
        return;
    L9:
        int pid = unpackInt(buf, 0);     // Catch: Exception -> L7
        int signal = unpackInt(buf, 4);     // Catch: Exception -> L7
        if (buf[8] == 0) goto L12;
        boolean gwpAsanRecoverableCrash = true;
    L13:
        if (pid >= 0) goto L16;
        Slog.e(TAG, "Bogus pid!");     // Catch: Exception -> L7
        return;
    L16:
        ActivityManagerService.PidMap r8 = this.mAm.mPidsSelfLocked;     // Catch: Exception -> L7
        monitor-enter(r8);     // Catch: Exception -> L7
        ProcessRecord pr = this.mAm.mPidsSelfLocked.get(pid);     // Catch: Throwable -> L62
        monitor-exit(r8);     // Catch: Throwable -> L62
        if (pr != null) goto L23;
        Slog.w(TAG, "Couldn't find ProcessRecord for pid " + pid);     // Catch: Exception -> L7
        return;
    L23:
        int bytes = Os.read(fd, buf, 0, buf.length);     // Catch: Exception -> L7
        if (bytes <= 0) goto L30;
        if (buf[bytes - 1] == 0) goto L27;
        os.write(buf, 0, bytes);     // Catch: Exception -> L7
        goto L30
    L27:
        os.write(buf, 0, bytes - 1);     // Catch: Exception -> L7
    L31:
        String reportString = new String(os.toByteArray(), CharsetNames.UTF_8);     // Catch: Exception -> L7
        if ("prenotify".equals(reportString) == false) goto L38;
        if (pr.getThread() == null) goto L78;
        pr.getThread().notifyAppException("native crash");     // Catch: Exception -> L7
        return;
    L78:
        return;
    L38:
        if (pr.isPersistent() == false) goto L40;
        return;
    L40:
        if (gwpAsanRecoverableCrash == true) goto L60;
        ActivityManagerService r4 = this.mAm;     // Catch: Exception -> L7
        ActivityManagerService.boostPriorityForLockedSection();     // Catch: Exception -> L7
        monitor-enter(r4);     // Catch: Exception -> L7
        ActivityManagerGlobalLock r9 = this.mAm.mProcLock;     // Catch: Throwable -> L51
        ActivityManagerService.boostPriorityForProcLockedSection();     // Catch: Throwable -> L51
        monitor-enter(r9);     // Catch: Throwable -> L51
        pr.mErrorState.setCrashing(true);     // Catch: Throwable -> L53
        pr.mErrorState.setForceCrashReport(true);     // Catch: Throwable -> L53
        monitor-exit(r9);     // Catch: Throwable -> L53
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L51
        monitor-exit(r4);     // Catch: Throwable -> L51
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L7
        goto L60
    L53:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterProcLockedSection();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        ActivityManagerService.resetPriorityAfterLockedSection();     // Catch: Exception -> L7
        throw th;     // Catch: Exception -> L7
    L60:
        new NativeCrashReporter(this, pr, signal, gwpAsanRecoverableCrash, reportString).start();     // Catch: Exception -> L7
        return;
    L30:
        if (bytes > 0) goto L23;
    L62:
        th = move-exception;
        throw th;     // Catch: Exception -> L7
    L12:
        gwpAsanRecoverableCrash = false;
    L7:
        e = move-exception;
        Slog.e(TAG, "Exception dealing with report", e);
    }
}
