package com.android.server.timedetector;

import android.os.ShellCommand;
import android.util.NtpTrustedTime;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class NetworkTimeUpdateServiceShellCommand extends ShellCommand {
    private static final String SET_SERVER_CONFIG_SERVER_ARG = "--server";
    private static final String SET_SERVER_CONFIG_TIMEOUT_ARG = "--timeout_millis";
    private static final String SHELL_COMMAND_FORCE_REFRESH = "force_refresh";
    private static final String SHELL_COMMAND_RESET_SERVER_CONFIG = "reset_server_config_for_tests";
    private static final String SHELL_COMMAND_SERVICE_NAME = "network_time_update_service";
    private static final String SHELL_COMMAND_SET_SERVER_CONFIG = "set_server_config_for_tests";
    private final NetworkTimeUpdateService mNetworkTimeUpdateService;

    NetworkTimeUpdateServiceShellCommand(NetworkTimeUpdateService networkTimeUpdateService) {
        networkTimeUpdateService.getClass();
        this.mNetworkTimeUpdateService = networkTimeUpdateService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -1679617267: goto L15;
            case 65977594: goto L12;
            case 1891346823: goto L9;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L26;
            case 1: goto L24;
            case 2: goto L22;
            default: goto L20;
        };
    L20:
        return handleDefaultCommands(cmd);
    L22:
        return runResetServerConfig();
    L24:
        return runSetServerConfig();
    L26:
        return runForceRefresh();
    L9:
        if (cmd.equals(SHELL_COMMAND_FORCE_REFRESH) == false) goto L17;
        r0 = 0;
        goto L18
    L12:
        if (cmd.equals(SHELL_COMMAND_RESET_SERVER_CONFIG) == false) goto L17;
        r0 = 2;
        goto L18
    L15:
        if (cmd.equals(SHELL_COMMAND_SET_SERVER_CONFIG) == false) goto L17;
        r0 = 1;
        goto L18
    }

    private int runForceRefresh() {
        boolean success = this.mNetworkTimeUpdateService.forceRefreshForTests();
        getOutPrintWriter().println(success);
        return 0;
    }

    private int runSetServerConfig() {
        List<URI> serverUris = new ArrayList();
        Duration timeout = null;
    L3:
        String opt = getNextArg();
        byte r4 = 0;
        if (opt == null) goto L25;
        switch(opt.hashCode()) {
            case -975021948: goto L12;
            case 1494187235: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L33;
            case 1: goto L18;
            default: goto L17;
        };
    L33:
        serverUris.add(NtpTrustedTime.parseNtpUriStrict(getNextArgRequired()));     // Catch: URISyntaxException -> L21
    L21:
        e = move-exception;
        throw new IllegalArgumentException("Bad NTP server value", e);
    L17:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L18:
        timeout = Duration.ofMillis(Integer.parseInt(getNextArgRequired()));
        goto L3
    L9:
        if (opt.equals(SET_SERVER_CONFIG_SERVER_ARG) == false) goto L14;
    L12:
        if (opt.equals(SET_SERVER_CONFIG_TIMEOUT_ARG) == false) goto L14;
        r4 = 1;
        goto L15
    L25:
        if (serverUris.isEmpty() == true) goto L32;
        if (timeout == null) goto L30;
        NtpTrustedTime.NtpConfig ntpConfig = new NtpTrustedTime.NtpConfig(serverUris, timeout);
        this.mNetworkTimeUpdateService.setServerConfigForTests(ntpConfig);
        return 0;
    L30:
        throw new IllegalArgumentException("Missing required option: ----timeout_millis");
    L32:
        throw new IllegalArgumentException("Missing required option: ----server");
    }

    private int runResetServerConfig() {
        this.mNetworkTimeUpdateService.setServerConfigForTests(null);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("Network Time Update Service (%s) commands:\n", new Object[]{SHELL_COMMAND_SERVICE_NAME});
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Print this help text.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{SHELL_COMMAND_FORCE_REFRESH});
        pw.printf("    Refreshes the latest time. Prints whether it was successful.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{SHELL_COMMAND_SET_SERVER_CONFIG});
        pw.printf("    Sets the NTP server config for tests. The config is not persisted.\n", new Object[0]);
        pw.printf("      Options: %s <uri> [%s <additional uris>]+ %s <millis>\n", new Object[]{SET_SERVER_CONFIG_SERVER_ARG, SET_SERVER_CONFIG_SERVER_ARG, SET_SERVER_CONFIG_TIMEOUT_ARG});
        pw.printf("      NTP server URIs must be in the form \"ntp://hostname\" or \"ntp://hostname:port\"\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{SHELL_COMMAND_RESET_SERVER_CONFIG});
        pw.printf("    Resets/clears the NTP server config set via %s.\n", new Object[]{SHELL_COMMAND_SET_SERVER_CONFIG});
        pw.println();
    }
}
