package com.android.server.timedetector;

import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class GnssTimeUpdateServiceShellCommand extends ShellCommand {
    private static final String SHELL_COMMAND_SERVICE_NAME = "gnss_time_update_service";
    private static final String SHELL_COMMAND_START_GNSS_LISTENING = "start_gnss_listening";
    private final GnssTimeUpdateService mGnssTimeUpdateService;

    GnssTimeUpdateServiceShellCommand(GnssTimeUpdateService gnssTimeUpdateService) {
        gnssTimeUpdateService.getClass();
        this.mGnssTimeUpdateService = gnssTimeUpdateService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case 1191671168: goto L9;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L16;
            default: goto L14;
        };
    L14:
        return handleDefaultCommands(cmd);
    L16:
        return runStartGnssListening();
    L9:
        if (cmd.equals(SHELL_COMMAND_START_GNSS_LISTENING) == false) goto L11;
        r0 = 0;
        goto L12
    }

    private int runStartGnssListening() {
        boolean success = this.mGnssTimeUpdateService.startGnssListening();
        getOutPrintWriter().println(success);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("Network Time Update Service (%s) commands:\n", new Object[]{SHELL_COMMAND_SERVICE_NAME});
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Print this help text.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{SHELL_COMMAND_START_GNSS_LISTENING});
        pw.printf("    Forces the service in to GNSS listening mode (if it isn't already).\n", new Object[0]);
        pw.printf("    Prints true if the service is listening after this command.\n", new Object[0]);
        pw.println();
    }
}
