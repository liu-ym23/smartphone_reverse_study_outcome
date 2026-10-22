package com.android.server.power;

import android.app.ActivityManager;
import android.app.IActivityManager;
import android.os.Process;
import android.os.RemoteException;
import android.util.AtomicFile;
import android.util.Log;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class ShutdownCheckPoints {
    private static final SimpleDateFormat DATE_FORMAT = null;
    private static final File[] EMPTY_FILE_ARRAY = null;
    private static final ShutdownCheckPoints INSTANCE = null;
    private static final int MAX_CHECK_POINTS = 100;
    private static final int MAX_DUMP_FILES = 20;
    private static final String TAG = "ShutdownCheckPoints";
    private final ArrayList<CheckPoint> mCheckPoints;
    private final Injector mInjector;

    private static class BinderCheckPoint extends SystemServerCheckPoint {
        private final int mCallerProcessId;

        BinderCheckPoint(long timestamp, int callerProcessId, String reason) {
            super(timestamp, reason);
            this.mCallerProcessId = callerProcessId;
        }

        @Override // com.android.server.power.ShutdownCheckPoints.SystemServerCheckPoint, com.android.server.power.ShutdownCheckPoints.CheckPoint
        String getOrigin() {
            return "BINDER";
        }

        @Override // com.android.server.power.ShutdownCheckPoints.SystemServerCheckPoint, com.android.server.power.ShutdownCheckPoints.CheckPoint
        void dumpDetails(Injector injector, PrintWriter printWriter) {
            String methodName = findMethodName();
            if (methodName != null) goto L5;
            String r1 = "Failed to get method name";
        L6:
            printWriter.println(r1);
            String processName = findProcessName(injector.activityManager());
            printWriter.print("From process ");
            if (processName != null) goto L9;
            String r2 = "?";
        L10:
            printWriter.print(r2);
            printWriter.println(" (pid=" + this.mCallerProcessId + ")");
            return;
        L9:
            r2 = processName;
            goto L10
        L5:
            r1 = methodName;
            goto L6
        }

        private String findProcessName(IActivityManager activityManager) {
            List<ActivityManager.RunningAppProcessInfo> runningProcesses = null;
            if (activityManager == null) goto L7;
            runningProcesses = activityManager.getRunningAppProcesses();     // Catch: RemoteException -> L5
        L8:
            if (runningProcesses == null) goto L26;
            Iterator<ActivityManager.RunningAppProcessInfo> r2 = runningProcesses.iterator();     // Catch: RemoteException -> L5
        L11:
            if (r2.hasNext() == false) goto L27;
            ActivityManager.RunningAppProcessInfo processInfo = r2.next();     // Catch: RemoteException -> L5
            if (processInfo.pid != this.mCallerProcessId) goto L11;
            return processInfo.processName;
        L27:
            return null;
        L26:
            return null;
        L7:
            Slog.v(ShutdownCheckPoints.TAG, "No ActivityManager to find name of process with pid=" + this.mCallerProcessId);     // Catch: RemoteException -> L5
        L5:
            e = move-exception;
            Slog.e(ShutdownCheckPoints.TAG, "Failed to get running app processes from ActivityManager", e);
            return null;
        }
    }

    private static abstract class CheckPoint {
        private final String mReason;
        private final long mTimestamp;

        abstract void dumpDetails(Injector r1, PrintWriter r2);

        abstract String getOrigin();

        CheckPoint(long timestamp, String reason) {
            this.mTimestamp = timestamp;
            this.mReason = reason;
        }

        final void dump(Injector injector, PrintWriter printWriter) {
            printWriter.print("Shutdown request from ");
            printWriter.print(getOrigin());
            if (this.mReason == null) goto L5;
            printWriter.print(" for reason ");
            printWriter.print(this.mReason);
        L5:
            printWriter.print(" at ");
            printWriter.print(ShutdownCheckPoints.m7552$$Nest$sfgetDATE_FORMAT().format(new Date(this.mTimestamp)));
            printWriter.println(" (epoch=" + this.mTimestamp + ")");
            dumpDetails(injector, printWriter);
        }
    }

    private static final class FileDumperThread extends Thread {
        private final File mBaseDir;
        private final File mBaseFile;
        private final int mFileCountLimit;
        private final ShutdownCheckPoints mInstance;

        FileDumperThread(ShutdownCheckPoints instance, File baseFile, int fileCountLimit) {
            this.mInstance = instance;
            this.mBaseFile = baseFile;
            this.mBaseDir = baseFile.getParentFile();
            this.mFileCountLimit = fileCountLimit;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mBaseDir.exists() == true) goto L5;
            this.mBaseDir.mkdirs();
            this.mBaseDir.setExecutable(true, false);
            this.mBaseDir.setReadable(true, false);
        L5:
            File[] checkPointFiles = listCheckPointsFiles();
            int filesToDelete = (checkPointFiles.length - this.mFileCountLimit) + 1;
            int i = 0;
        L6:
            if (i >= filesToDelete) goto L8;
            checkPointFiles[i].delete();
            i = i + 1;
            goto L6
        L8:
            File nextCheckPointsFile = new File(String.format("%s-%d", new Object[]{this.mBaseFile.getAbsolutePath(), Long.valueOf(System.currentTimeMillis())}));
            writeCheckpoints(nextCheckPointsFile);
        }

        private File[] listCheckPointsFiles() {
            final String filePrefix = this.mBaseFile.getName() + "-";
            File[] files = this.mBaseDir.listFiles(new AnonymousClass1(this, filePrefix));
            if (files == null) goto L5;
            Arrays.sort(files);
            return files;
        L5:
            return ShutdownCheckPoints.m7553$$Nest$sfgetEMPTY_FILE_ARRAY();
        }

        private void writeCheckpoints(File file) {
            AtomicFile tmpFile = new AtomicFile(this.mBaseFile);
            FileOutputStream fos = null;
            fos = tmpFile.startWrite();     // Catch: IOException -> L5
            PrintWriter pw = new PrintWriter(fos);     // Catch: IOException -> L5
            this.mInstance.dumpInternal(pw);     // Catch: IOException -> L5
            pw.flush();     // Catch: IOException -> L5
            tmpFile.finishWrite(fos);     // Catch: IOException -> L5
        L9:
            this.mBaseFile.renameTo(file);
            file.setReadable(true, false);
            return;
        L5:
            e = move-exception;
            Log.e(ShutdownCheckPoints.TAG, "Failed to write shutdown checkpoints", e);
            if (fos == null) goto L9;
            tmpFile.failWrite(fos);
            goto L9
        }
    }

    interface Injector {
        IActivityManager activityManager();

        long currentTimeMillis();

        int maxCheckPoints();

        int maxDumpFiles();
    }

    private static class IntentCheckPoint extends CheckPoint {
        private final String mIntentName;
        private final String mPackageName;

        IntentCheckPoint(long timestamp, String intentName, String packageName, String reason) {
            super(timestamp, reason);
            this.mIntentName = intentName;
            this.mPackageName = packageName;
        }

        @Override // com.android.server.power.ShutdownCheckPoints.CheckPoint
        String getOrigin() {
            return "INTENT";
        }

        @Override // com.android.server.power.ShutdownCheckPoints.CheckPoint
        void dumpDetails(Injector injector, PrintWriter printWriter) {
            printWriter.print("Intent: ");
            printWriter.println(this.mIntentName);
            printWriter.print("Package: ");
            printWriter.println(this.mPackageName);
        }
    }

    private static class SystemServerCheckPoint extends CheckPoint {
        private final StackTraceElement[] mStackTraceElements;

        SystemServerCheckPoint(long timestamp, String reason) {
            super(timestamp, reason);
            this.mStackTraceElements = Thread.currentThread().getStackTrace();
        }

        @Override // com.android.server.power.ShutdownCheckPoints.CheckPoint
        String getOrigin() {
            return "SYSTEM";
        }

        @Override // com.android.server.power.ShutdownCheckPoints.CheckPoint
        void dumpDetails(Injector injector, PrintWriter printWriter) {
            String methodName = findMethodName();
            if (methodName != null) goto L5;
            String r1 = "Failed to get method name";
        L6:
            printWriter.println(r1);
            printStackTrace(printWriter);
            return;
        L5:
            r1 = methodName;
            goto L6
        }

        String findMethodName() {
            int idx = findCallSiteIndex();
            if (idx >= this.mStackTraceElements.length) goto L6;
            StackTraceElement element = this.mStackTraceElements[idx];
            return String.format("%s.%s", new Object[]{element.getClassName(), element.getMethodName()});
        L6:
            return null;
        }

        void printStackTrace(PrintWriter printWriter) {
            int i = findCallSiteIndex();
        L3:
            i = i + 1;
            if (i >= this.mStackTraceElements.length) goto L7;
            printWriter.print(" at ");
            printWriter.println(this.mStackTraceElements[i]);
            goto L3
        }

        private int findCallSiteIndex() {
            String className = ShutdownCheckPoints.class.getCanonicalName();
            int idx = 0;
        L4:
            if (idx >= this.mStackTraceElements.length) goto L9;
            if (this.mStackTraceElements[idx].getClassName().equals(className) == true) goto L9;
            idx = idx + 1;
        L9:
            if (idx >= this.mStackTraceElements.length) goto L13;
            if (this.mStackTraceElements[idx].getClassName().equals(className) == false) goto L13;
            idx = idx + 1;
        L13:
            return idx;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDATE_FORMAT, reason: not valid java name */
    static /* bridge */ /* synthetic */ SimpleDateFormat m7552$$Nest$sfgetDATE_FORMAT() {
        return DATE_FORMAT;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetEMPTY_FILE_ARRAY, reason: not valid java name */
    static /* bridge */ /* synthetic */ File[] m7553$$Nest$sfgetEMPTY_FILE_ARRAY() {
        return EMPTY_FILE_ARRAY;
    }

    static {
        INSTANCE = new ShutdownCheckPoints();
        DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z");
        EMPTY_FILE_ARRAY = new File[0];
    }

    private ShutdownCheckPoints() {
        this(new AnonymousClass1());
    }

    ShutdownCheckPoints(Injector injector) {
        this.mCheckPoints = new ArrayList();
        this.mInjector = injector;
    }

    public static void recordCheckPoint(String reason) {
        INSTANCE.recordCheckPointInternal(reason);
    }

    public static void recordCheckPoint(int callerProcessId, String reason) {
        INSTANCE.recordCheckPointInternal(callerProcessId, reason);
    }

    public static void recordCheckPoint(String intentName, String packageName, String reason) {
        INSTANCE.recordCheckPointInternal(intentName, packageName, reason);
    }

    public static void dump(PrintWriter printWriter) {
        INSTANCE.dumpInternal(printWriter);
    }

    public static Thread newDumpThread(File baseFile) {
        return INSTANCE.newDumpThreadInternal(baseFile);
    }

    void recordCheckPointInternal(String reason) {
        recordCheckPointInternal(new SystemServerCheckPoint(this.mInjector.currentTimeMillis(), reason));
        Slog.v(TAG, "System server shutdown checkpoint recorded");
    }

    void recordCheckPointInternal(int callerProcessId, String reason) {
        long timestamp = this.mInjector.currentTimeMillis();
        if (callerProcessId != Process.myPid()) goto L5;
        CheckPoint r2 = new SystemServerCheckPoint(timestamp, reason);
    L6:
        recordCheckPointInternal(r2);
        Slog.v(TAG, "Binder shutdown checkpoint recorded with pid=" + callerProcessId);
        return;
    L5:
        r2 = new BinderCheckPoint(timestamp, callerProcessId, reason);
        goto L6
    }

    void recordCheckPointInternal(String intentName, String packageName, String reason) {
        long timestamp = this.mInjector.currentTimeMillis();
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(packageName) == false) goto L5;
        CheckPoint r0 = new SystemServerCheckPoint(timestamp, reason);
        String intentName2 = intentName;
        String packageName2 = packageName;
    L6:
        recordCheckPointInternal(r0);
        Slog.v(TAG, String.format("Shutdown intent checkpoint recorded intent=%s from package=%s", new Object[]{intentName2, packageName2}));
        return;
    L5:
        intentName2 = intentName;
        packageName2 = packageName;
        r0 = new IntentCheckPoint(timestamp, intentName2, packageName2, reason);
        goto L6
    }

    private void recordCheckPointInternal(CheckPoint checkPoint) {
        ArrayList<CheckPoint> r0 = this.mCheckPoints;
        monitor-enter(r0);
        this.mCheckPoints.add(checkPoint);     // Catch: Throwable -> L7
        if (this.mCheckPoints.size() <= this.mInjector.maxCheckPoints()) goto L9;
        this.mCheckPoints.remove(0);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void dumpInternal(PrintWriter printWriter) {
        ArrayList<CheckPoint> r0 = this.mCheckPoints;
        monitor-enter(r0);
        List<CheckPoint> records = new ArrayList(this.mCheckPoints);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        Iterator<CheckPoint> r1 = records.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        CheckPoint record = r1.next();
        record.dump(this.mInjector, printWriter);
        printWriter.println();
        goto L8
    L10:
        return;
    L11:
        th = move-exception;
        throw th;
    }

    Thread newDumpThreadInternal(File baseFile) {
        return new FileDumperThread(this, baseFile, this.mInjector.maxDumpFiles());
    }
}
