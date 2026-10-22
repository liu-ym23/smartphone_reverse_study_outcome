package com.android.server.content;

import android.accounts.Account;
import android.app.job.JobParameters;
import android.os.Environment;
import android.os.FileUtils;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.IntPair;
import com.android.server.IoThread;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import libcore.io.IoUtils;

/* JADX INFO: loaded from: classes.dex */
public class SyncLogger {
    public static final int CALLING_UID_SELF = -1;
    private static final String TAG = "SyncLogger";
    private static SyncLogger sInstance;

    private static class RotatingFileLogger extends SyncLogger {
        private static final boolean DO_LOGCAT = false;
        private static final SimpleDateFormat sFilenameDateFormat = null;
        private static final SimpleDateFormat sTimestampFormat = null;
        private final Date mCachedDate;
        private long mCurrentLogFileDayTimestamp;
        private boolean mErrorShown;
        private final MyHandler mHandler;
        private final long mKeepAgeMs;
        private final Object mLock;
        private final File mLogPath;
        private Writer mLogWriter;
        private final StringBuilder mStringBuilder;

        private class MyHandler extends Handler {
            public static final int MSG_LOG_ID = 1;
            final /* synthetic */ RotatingFileLogger this$0;

            MyHandler(RotatingFileLogger r1, Looper looper) {
                this.this$0 = r1;
                super(looper);
            }

            public void log(long now, Object[] message) {
                obtainMessage(1, IntPair.first(now), IntPair.second(now), message).sendToTarget();
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch(msg.what) {
                    case 1: goto L5;
                    default: goto L7;
                };
            L5:
                this.this$0.logInner(IntPair.of(msg.arg1, msg.arg2), (Object[]) msg.obj);
                return;
            }
        }

        static {
            sTimestampFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            sFilenameDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            DO_LOGCAT = Log.isLoggable(SyncLogger.TAG, 3);
        }

        RotatingFileLogger() {
            this.mLock = new Object();
            this.mKeepAgeMs = TimeUnit.DAYS.toMillis(7);
            this.mCachedDate = new Date();
            this.mStringBuilder = new StringBuilder();
            this.mLogPath = new File(Environment.getDataSystemDirectory(), "syncmanager-log");
            this.mHandler = new MyHandler(this, IoThread.get().getLooper());
        }

        @Override // com.android.server.content.SyncLogger
        public boolean enabled() {
            return true;
        }

        private void handleException(String message, Exception e) {
            if (this.mErrorShown == true) goto L6;
            Slog.e(SyncLogger.TAG, message, e);
            this.mErrorShown = true;
            return;
        }

        @Override // com.android.server.content.SyncLogger
        public void log(Object... message) {
            if (message != null) goto L4;
            return;
        L4:
            long now = System.currentTimeMillis();
            this.mHandler.log(now, message);
        }

        void logInner(long now, Object[] message) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            openLogLocked(now);     // Catch: Throwable -> L8
            if (this.mLogWriter != null) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L10:
            int r2 = 0;
            this.mStringBuilder.setLength(0);     // Catch: Throwable -> L8
            this.mCachedDate.setTime(now);     // Catch: Throwable -> L8
            this.mStringBuilder.append(sTimestampFormat.format(this.mCachedDate));     // Catch: Throwable -> L8
            this.mStringBuilder.append(' ');     // Catch: Throwable -> L8
            this.mStringBuilder.append(Process.myTid());     // Catch: Throwable -> L8
            this.mStringBuilder.append(' ');     // Catch: Throwable -> L8
            int messageStart = this.mStringBuilder.length();     // Catch: Throwable -> L8
            int r3 = message.length;     // Catch: Throwable -> L8
        L11:
            if (r2 >= r3) goto L13;
            Object o = message[r2];     // Catch: Throwable -> L8
            this.mStringBuilder.append(o);     // Catch: Throwable -> L8
            r2 = r2 + 1;     // Catch: Throwable -> L8
            goto L11
        L13:
            this.mStringBuilder.append('\n');     // Catch: Throwable -> L8
            this.mLogWriter.append(this.mStringBuilder);     // Catch: Throwable -> L8 IOException -> L18
            this.mLogWriter.flush();     // Catch: Throwable -> L8 IOException -> L18
            if (DO_LOGCAT == false) goto L23;
            Log.d(SyncLogger.TAG, this.mStringBuilder.substring(messageStart));     // Catch: Throwable -> L8 IOException -> L18
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L18:
            e = move-exception;
            handleException("Failed to write log", e);     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        private void openLogLocked(long now) {
            long day = now % 86400000;
            if (this.mLogWriter != null) goto L5;
        L7:
            closeCurrentLogLocked();
            this.mCurrentLogFileDayTimestamp = day;
            this.mCachedDate.setTime(now);
            String filename = "synclog-" + sFilenameDateFormat.format(this.mCachedDate) + ".log";
            File file = new File(this.mLogPath, filename);
            file.getParentFile().mkdirs();
            this.mLogWriter = new FileWriter(file, true);     // Catch: IOException -> L10
            return;
        L10:
            e = move-exception;
            handleException("Failed to open log file: " + file, e);
            return;
        L5:
            if (day != this.mCurrentLogFileDayTimestamp) goto L7;
        }

        private void closeCurrentLogLocked() {
            IoUtils.closeQuietly(this.mLogWriter);
            this.mLogWriter = null;
        }

        @Override // com.android.server.content.SyncLogger
        public void purgeOldLogs() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            FileUtils.deleteOlderFiles(this.mLogPath, 1, this.mKeepAgeMs);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.content.SyncLogger
        public String jobParametersToString(JobParameters params) {
            return SyncJobService.jobParametersToString(params);
        }

        @Override // com.android.server.content.SyncLogger
        public void dumpAll(PrintWriter pw) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            String[] files = this.mLogPath.list();     // Catch: Throwable -> L13
            if (files == null) goto L17;
            if (files.length == 0) goto L17;
            Arrays.sort(files);     // Catch: Throwable -> L13
            int r2 = files.length;     // Catch: Throwable -> L13
            int r3 = 0;
        L11:
            if (r3 >= r2) goto L15;
            String file = files[r3];     // Catch: Throwable -> L13
            dumpFile(pw, new File(this.mLogPath, file));     // Catch: Throwable -> L13
            r3 = r3 + 1;     // Catch: Throwable -> L13
            goto L11
        L15:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L17:
            monitor-exit(r0);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        }

        private void dumpFile(PrintWriter pw, File file) {
            Slog.w(SyncLogger.TAG, "Dumping " + file);
            char[] buffer = new char[32768];
            Reader in = new BufferedReader(new FileReader(file));     // Catch: IOException -> L14
        L25:
            int read = in.read(buffer);     // Catch: Throwable -> L9
            if (read < 0) goto L12;
            if (read <= 0) goto L25;
            pw.write(buffer, 0, read);     // Catch: Throwable -> L9
            goto L32
        L12:
            in.close();     // Catch: IOException -> L14
            return;
        L9:
            th = move-exception;
            in.close();     // Catch: Throwable -> L18
        L20:
            throw th;     // Catch: IOException -> L14
        L18:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L14
        }
    }

    SyncLogger() {
    }

    public static synchronized SyncLogger getInstance() {
        monitor-enter(SyncLogger.class);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L9;
        sInstance = new SyncLogger();     // Catch: Throwable -> L7
    L9:
        SyncLogger r1 = sInstance;     // Catch: Throwable -> L7
        monitor-exit(SyncLogger.class);
        return r1;
    }

    public void log(Object... message) {
    }

    public void purgeOldLogs() {
    }

    public String jobParametersToString(JobParameters params) {
        return "";
    }

    public void dumpAll(PrintWriter pw) {
    }

    public boolean enabled() {
        return false;
    }

    static String logSafe(Account account) {
        if (account != null) goto L5;
        return "[null]";
    L5:
        return account.toSafeString();
    }

    static String logSafe(SyncStorageEngine.EndPoint endPoint) {
        if (endPoint != null) goto L5;
        return "[null]";
    L5:
        return endPoint.toSafeString();
    }

    static String logSafe(SyncOperation operation) {
        if (operation != null) goto L5;
        return "[null]";
    L5:
        return operation.toSafeString();
    }

    static String logSafe(SyncManager.ActiveSyncContext asc) {
        if (asc != null) goto L5;
        return "[null]";
    L5:
        return asc.toSafeString();
    }
}
