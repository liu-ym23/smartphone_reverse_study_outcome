package com.android.server.coverage;

import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.ShellCommand;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.jacoco.agent.rt.RT;

/* JADX INFO: loaded from: classes.dex */
public class CoverageService extends Binder {
    public static final String COVERAGE_SERVICE = "coverage";
    public static final boolean ENABLED = false;

    private static class CoverageCommand extends ShellCommand {
        /* synthetic */ CoverageCommand(CoverageServiceIA r1) {
            this();
        }

        private CoverageCommand() {
        }

        public int onCommand(String cmd) {
            if (ArchiveStreamFactory.DUMP.equals(cmd) == false) goto L7;
            return onDump();
        L7:
            if ("reset".equals(cmd) == false) goto L11;
            return onReset();
        L11:
            return handleDefaultCommands(cmd);
        }

        public void onHelp() {
            PrintWriter pw = getOutPrintWriter();
            pw.println("Coverage commands:");
            pw.println("  help");
            pw.println("    Print this help text.");
            pw.println("  dump [FILE]");
            pw.println("    Dump code coverage to FILE.");
            pw.println("  reset");
            pw.println("    Reset coverage information.");
        }

        private int onDump() {
            String dest = getNextArg();
            if (dest != null) goto L5;
            dest = "/data/local/tmp/coverage.ec";
        L8:
            ParcelFileDescriptor fd = openFileForSystem(dest, "w");
            if (fd != null) goto L27;
            return -1;
        L27:
            BufferedOutputStream output = new BufferedOutputStream(new ParcelFileDescriptor.AutoCloseOutputStream(fd));     // Catch: IOException -> L15
            output.write(RT.getAgent().getExecutionData(false));     // Catch: Throwable -> L17
            output.flush();     // Catch: Throwable -> L17
            getOutPrintWriter().println(String.format("Dumped coverage data to %s", new Object[]{dest}));     // Catch: Throwable -> L17
            output.close();     // Catch: IOException -> L15
            return 0;
        L17:
            th = move-exception;
            output.close();     // Catch: Throwable -> L20
        L22:
            throw th;     // Catch: IOException -> L15
        L20:
            th = move-exception;
            th.addSuppressed(th);     // Catch: IOException -> L15
        L15:
            e = move-exception;
            getErrPrintWriter().println("Failed to dump coverage data: " + e.getMessage());
            return -1;
        L5:
            File f = new File(dest);
            if (f.isDirectory() == false) goto L8;
            dest = new File(f, "coverage.ec").getAbsolutePath();
            goto L8
        }

        private int onReset() {
            RT.getAgent().reset();
            getOutPrintWriter().println("Reset coverage data");
            return 0;
        }
    }

    public CoverageService() {
    }

    static {
        boolean shouldEnable = true;
        Class.forName("org.jacoco.agent.rt.RT");     // Catch: ClassNotFoundException -> L5
    L7:
        ENABLED = shouldEnable;
        return;
    L6:
        shouldEnable = false;
        goto L7
    }

    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new CoverageCommand(null).exec(this, in, out, err, args, callback, resultReceiver);
    }
}
