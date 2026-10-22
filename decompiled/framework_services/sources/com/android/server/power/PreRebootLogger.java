package com.android.server.power;

import android.content.Context;
import android.os.Environment;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.ServiceManager;
import android.util.Slog;
import com.android.internal.util.ArrayUtils;
import com.android.server.pm.Settings;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
final class PreRebootLogger {
    private static final String[] BUFFERS_TO_DUMP = null;
    private static final long MAX_DUMP_TIME = 0;
    private static final String PREREBOOT_DIR = "prereboot";
    private static final String[] SERVICES_TO_DUMP = null;
    private static final String TAG = "PreRebootLogger";
    private static final Object sLock = null;

    public static /* synthetic */ void $r8$lambda$KTfRNg5UZSGoClU9CO678RgS0VQ(File r0, AtomicBoolean r1) {
        lambda$dump$0(r0, r1);
    }

    PreRebootLogger() {
    }

    static {
        BUFFERS_TO_DUMP = new String[]{"system"};
        SERVICES_TO_DUMP = new String[]{"rollback", Settings.ATTR_PACKAGE};
        sLock = new Object();
        MAX_DUMP_TIME = TimeUnit.SECONDS.toMillis(20);
    }

    static void log(Context context) {
        log(context, getDumpDir());
    }

    static void log(Context context, File dumpDir) {
        if (needDump(context) == false) goto L5;
        dump(dumpDir, MAX_DUMP_TIME);
        return;
    L5:
        wipe(dumpDir);
    }

    private static boolean needDump(Context context) {
        if (android.provider.Settings.Global.getInt(context.getContentResolver(), "adb_enabled", 0) == 1) goto L5;
        return false;
    L5:
        if (context.getPackageManager().getPackageInstaller().getActiveStagedSessions().isEmpty() == false) goto L8;
        return false;
    L8:
        return true;
    }

    static void dump(final File dumpDir, long maxWaitTime) {
        Slog.d(TAG, "Dumping pre-reboot information...");
        final AtomicBoolean done = new AtomicBoolean(false);
        Thread t = new Thread(new PreRebootLogger$$ExternalSyntheticLambda0(dumpDir, done));
        t.start();
        t.join(maxWaitTime);     // Catch: InterruptedException -> L5
    L8:
        if (done.get() == true) goto L13;
        Slog.w(TAG, "Failed to dump pre-reboot information due to timeout");
        return;
    L13:
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Failed to dump pre-reboot information due to interrupted", e);
        goto L8
    }

    private static /* synthetic */ void lambda$dump$0(File dumpDir, AtomicBoolean done) {
        Object r0 = sLock;
        monitor-enter(r0);
        String[] r1 = BUFFERS_TO_DUMP;     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
        int r4 = 0;
    L5:
        if (r4 >= r2) goto L9;
        String buffer = r1[r4];     // Catch: Throwable -> L7
        dumpLogsLocked(dumpDir, buffer);     // Catch: Throwable -> L7
        r4 = r4 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        String[] r5 = SERVICES_TO_DUMP;     // Catch: Throwable -> L7
        int r6 = r5.length;     // Catch: Throwable -> L7
    L10:
        if (r3 >= r6) goto L12;
        String service = r5[r3];     // Catch: Throwable -> L7
        dumpServiceLocked(dumpDir, service);     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L10
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        done.set(true);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static void wipe(File dumpDir) {
        Slog.d(TAG, "Wiping pre-reboot information...");
        Object r0 = sLock;
        monitor-enter(r0);
        File[] r1 = dumpDir.listFiles();     // Catch: Throwable -> L7
        int r2 = r1.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L5:
        if (r3 >= r2) goto L9;
        File file = r1[r3];     // Catch: Throwable -> L7
        file.delete();     // Catch: Throwable -> L7
        r3 = r3 + 1;     // Catch: Throwable -> L7
        goto L5
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static File getDumpDir() {
        File dumpDir = new File(Environment.getDataMiscDirectory(), PREREBOOT_DIR);
        if (dumpDir.exists() == false) goto L8;
        if (dumpDir.isDirectory() == false) goto L8;
        return dumpDir;
    L8:
        throw new UnsupportedOperationException("Pre-reboot dump directory not found");
    }

    private static void dumpLogsLocked(File dumpDir, String buffer) {
        File dumpFile = new File(dumpDir, buffer);     // Catch: Throwable -> L16
        if (dumpFile.createNewFile() == true) goto L22;
        new FileWriter(dumpFile, false).flush();     // Catch: Throwable -> L16 Throwable -> L16
    L10:
        String[] cmdline = {"logcat", "-d", "-b", buffer, "-f", dumpFile.getAbsolutePath()};     // Catch: Throwable -> L14
        Runtime.getRuntime().exec(cmdline).waitFor();     // Catch: Throwable -> L14
        return;
    L14:
        e = e;
    L18:
        Slog.e(TAG, "Failed to dump system log buffer before reboot", e);
        return;
    L22:
        dumpFile.setWritable(true, true);     // Catch: Throwable -> L7
    L7:
        e = e;
    L16:
        e = e;
        goto L18
    }

    private static void dumpServiceLocked(File dumpDir, String serviceName) {
        IBinder binder = ServiceManager.checkService(serviceName);
        if (binder != null) goto L10;
        return;
    L10:
        File dumpFile = new File(dumpDir, serviceName);     // Catch: Throwable -> L7
        ParcelFileDescriptor fd = ParcelFileDescriptor.open(dumpFile, 738197504);     // Catch: Throwable -> L7
        binder.dump(fd.getFileDescriptor(), (String[]) ArrayUtils.emptyArray(String.class));     // Catch: Throwable -> L7
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, String.format("Failed to dump %s service before reboot", new Object[]{serviceName}), e);
    }
}
