package com.android.server.timedetector;

import android.app.time.ExternalTimeSuggestion;
import android.app.time.TimeConfiguration;
import android.app.time.TimeState;
import android.app.time.UnixEpochTime;
import android.app.timedetector.ManualTimeSuggestion;
import android.app.timedetector.TelephonyTimeSuggestion;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class TimeDetectorShellCommand extends ShellCommand {
    private final TimeDetectorService mInterface;

    /* JADX INFO: renamed from: $r8$lambda$8DEBDy3-6JYN5kcOKXe8FB7LQrw, reason: not valid java name */
    public static /* synthetic */ ManualTimeSuggestion m8561$r8$lambda$8DEBDy36JYN5kcOKXe8FB7LQrw(TimeDetectorShellCommand r0) {
        return r0.lambda$runSuggestManualTime$0();
    }

    public static /* synthetic */ NetworkTimeSuggestion $r8$lambda$cCKkowC4lpXdFT6pP0eQrRV7Mus(TimeDetectorShellCommand r0) {
        return r0.lambda$runSuggestNetworkTime$2();
    }

    /* JADX INFO: renamed from: $r8$lambda$lUW-bxeYR8hA-VP4Ybgq1xVGNO4, reason: not valid java name */
    public static /* synthetic */ GnssTimeSuggestion m8562$r8$lambda$lUWbxeYR8hAVP4Ybgq1xVGNO4(TimeDetectorShellCommand r0) {
        return r0.lambda$runSuggestGnssTime$3();
    }

    public static /* synthetic */ TelephonyTimeSuggestion $r8$lambda$nhDdtdZF5081mKjA1eyvtG6aaCo(TimeDetectorShellCommand r0) {
        return r0.lambda$runSuggestTelephonyTime$1();
    }

    public static /* synthetic */ ExternalTimeSuggestion $r8$lambda$uJ0sJyRUY_56IIzsnrbBUsCGRms(TimeDetectorShellCommand r0) {
        return r0.lambda$runSuggestExternalTime$4();
    }

    TimeDetectorShellCommand(TimeDetectorService timeDetectorService) {
        this.mInterface = timeDetectorService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -1630622545: goto L48;
            case -1316904020: goto L45;
            case -844157159: goto L42;
            case -532496502: goto L39;
            case -219775160: goto L36;
            case -83861208: goto L33;
            case 200743238: goto L30;
            case 255251591: goto L27;
            case 754841328: goto L24;
            case 909817707: goto L21;
            case 1433926509: goto L18;
            case 1860100418: goto L15;
            case 1902269812: goto L12;
            case 2097306860: goto L9;
            default: goto L50;
        };
    L50:
        byte r0 = -1;
    L51:
        switch(r0) {
            case 0: goto L81;
            case 1: goto L79;
            case 2: goto L77;
            case 3: goto L75;
            case 4: goto L73;
            case 5: goto L71;
            case 6: goto L69;
            case 7: goto L67;
            case 8: goto L65;
            case 9: goto L63;
            case 10: goto L61;
            case 11: goto L59;
            case 12: goto L57;
            case 13: goto L55;
            default: goto L53;
        };
    L53:
        return handleDefaultCommands(cmd);
    L55:
        return runSetSystemClockNetworkTime();
    L57:
        return runClearSystemClockNetworkTime();
    L59:
        return runConfirmTime();
    L61:
        return runSetTimeState();
    L63:
        return runGetTimeState();
    L65:
        return runSuggestExternalTime();
    L67:
        return runSuggestGnssTime();
    L69:
        return runClearLatestNetworkTime();
    L71:
        return runGetLatestNetworkTime();
    L73:
        return runSuggestNetworkTime();
    L75:
        return runSuggestTelephonyTime();
    L77:
        return runSuggestManualTime();
    L79:
        return runSetAutoDetectionEnabled();
    L81:
        return runIsAutoDetectionEnabled();
    L9:
        if (cmd.equals("confirm_time") == false) goto L50;
        r0 = 11;
        goto L51
    L12:
        if (cmd.equals("set_auto_detection_enabled") == false) goto L50;
        r0 = 1;
        goto L51
    L15:
        if (cmd.equals("set_system_clock_network_time") == false) goto L50;
        r0 = 13;
        goto L51
    L18:
        if (cmd.equals("clear_system_clock_network_time") == false) goto L50;
        r0 = 12;
        goto L51
    L21:
        if (cmd.equals("suggest_manual_time") == false) goto L50;
        r0 = 2;
        goto L51
    L24:
        if (cmd.equals("clear_network_time") == false) goto L50;
        r0 = 6;
        goto L51
    L27:
        if (cmd.equals("get_network_time") == false) goto L50;
        r0 = 5;
        goto L51
    L30:
        if (cmd.equals("suggest_external_time") == false) goto L50;
        r0 = 8;
        goto L51
    L33:
        if (cmd.equals("get_time_state") == false) goto L50;
        r0 = 9;
        goto L51
    L36:
        if (cmd.equals("set_time_state_for_tests") == false) goto L50;
        r0 = 10;
        goto L51
    L39:
        if (cmd.equals("suggest_gnss_time") == false) goto L50;
        r0 = 7;
        goto L51
    L42:
        if (cmd.equals("suggest_network_time") == false) goto L50;
        r0 = 4;
        goto L51
    L45:
        if (cmd.equals("is_auto_detection_enabled") == false) goto L50;
        r0 = 0;
        goto L51
    L48:
        if (cmd.equals("suggest_telephony_time") == false) goto L50;
        r0 = 3;
        goto L51
    }

    private int runIsAutoDetectionEnabled() {
        PrintWriter pw = getOutPrintWriter();
        boolean enabled = this.mInterface.getCapabilitiesAndConfig().getConfiguration().isAutoDetectionEnabled();
        pw.println(enabled);
        return 0;
    }

    private int runSetAutoDetectionEnabled() {
        boolean r0 = Boolean.parseBoolean(getNextArgRequired());
        TimeConfiguration r2 = new TimeConfiguration.Builder().setAutoDetectionEnabled(r0).build();
        return !this.mInterface.updateConfiguration(-2, r2) ? 1 : 0;
    }

    private int runSuggestManualTime() {
        Supplier r0 = new TimeDetectorShellCommand$$ExternalSyntheticLambda8(this);
        final TimeDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSuggestTime(r0, new TimeDetectorShellCommand$$ExternalSyntheticLambda9(r1));
    }

    private /* synthetic */ ManualTimeSuggestion lambda$runSuggestManualTime$0() {
        return ManualTimeSuggestion.parseCommandLineArg(this);
    }

    private int runSuggestTelephonyTime() {
        Supplier r0 = new TimeDetectorShellCommand$$ExternalSyntheticLambda2(this);
        final TimeDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSuggestTime(r0, new TimeDetectorShellCommand$$ExternalSyntheticLambda3(r1));
    }

    private /* synthetic */ TelephonyTimeSuggestion lambda$runSuggestTelephonyTime$1() {
        return TelephonyTimeSuggestion.parseCommandLineArg(this);
    }

    private int runSuggestNetworkTime() {
        Supplier r0 = new TimeDetectorShellCommand$$ExternalSyntheticLambda0(this);
        final TimeDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSuggestTime(r0, new TimeDetectorShellCommand$$ExternalSyntheticLambda1(r1));
    }

    private /* synthetic */ NetworkTimeSuggestion lambda$runSuggestNetworkTime$2() {
        return NetworkTimeSuggestion.parseCommandLineArg(this);
    }

    private int runGetLatestNetworkTime() {
        NetworkTimeSuggestion networkTimeSuggestion = this.mInterface.getLatestNetworkSuggestion();
        PrintWriter pw = getOutPrintWriter();
        pw.println(networkTimeSuggestion);
        return 0;
    }

    private int runClearLatestNetworkTime() {
        this.mInterface.clearLatestNetworkTime();
        return 0;
    }

    private int runSuggestGnssTime() {
        Supplier r0 = new TimeDetectorShellCommand$$ExternalSyntheticLambda4(this);
        final TimeDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSuggestTime(r0, new TimeDetectorShellCommand$$ExternalSyntheticLambda5(r1));
    }

    private /* synthetic */ GnssTimeSuggestion lambda$runSuggestGnssTime$3() {
        return GnssTimeSuggestion.parseCommandLineArg(this);
    }

    private int runSuggestExternalTime() {
        Supplier r0 = new TimeDetectorShellCommand$$ExternalSyntheticLambda6(this);
        final TimeDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSuggestTime(r0, new TimeDetectorShellCommand$$ExternalSyntheticLambda7(r1));
    }

    private /* synthetic */ ExternalTimeSuggestion lambda$runSuggestExternalTime$4() {
        return ExternalTimeSuggestion.parseCommandLineArg(this);
    }

    private <T> int runSuggestTime(Supplier<T> suggestionParser, Consumer<T> invoker) {
        PrintWriter pw = getOutPrintWriter();
        T suggestion = suggestionParser.get();     // Catch: RuntimeException -> L7
        if (suggestion != null) goto L9;
        pw.println("Error: suggestion not specified");     // Catch: RuntimeException -> L7
        return 1;
    L9:
        invoker.accept(suggestion);     // Catch: RuntimeException -> L7
        pw.println("Suggestion " + suggestion + " injected.");     // Catch: RuntimeException -> L7
        return 0;
    L7:
        e = move-exception;
        pw.println(e);
        return 1;
    }

    private int runGetTimeState() {
        TimeState timeState = this.mInterface.getTimeState();
        getOutPrintWriter().println(timeState);
        return 0;
    }

    private int runSetTimeState() {
        TimeState timeState = TimeState.parseCommandLineArgs(this);
        this.mInterface.setTimeState(timeState);
        return 0;
    }

    private int runConfirmTime() {
        UnixEpochTime unixEpochTime = UnixEpochTime.parseCommandLineArgs(this);
        getOutPrintWriter().println(this.mInterface.confirmTime(unixEpochTime));
        return 0;
    }

    private int runClearSystemClockNetworkTime() {
        this.mInterface.clearNetworkTimeForSystemClockForTests();
        return 0;
    }

    private int runSetSystemClockNetworkTime() {
        NetworkTimeSuggestion networkTimeSuggestion = NetworkTimeSuggestion.parseCommandLineArg(this);
        this.mInterface.setNetworkTimeForSystemClockForTests(networkTimeSuggestion.getUnixEpochTime(), networkTimeSuggestion.getUncertaintyMillis());
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("Time Detector (%s) commands:\n", new Object[]{"time_detector"});
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Print this help text.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"is_auto_detection_enabled"});
        pw.printf("    Prints true/false according to the automatic time detection setting.\n", new Object[0]);
        pw.printf("  %s true|false\n", new Object[]{"set_auto_detection_enabled"});
        pw.printf("    Sets the automatic time detection setting.\n", new Object[0]);
        pw.println();
        pw.printf("  %s <manual suggestion opts>\n", new Object[]{"suggest_manual_time"});
        pw.printf("    Suggests a time as if via the \"manual\" origin.\n", new Object[0]);
        pw.printf("  %s <telephony suggestion opts>\n", new Object[]{"suggest_telephony_time"});
        pw.printf("    Suggests a time as if via the \"telephony\" origin.\n", new Object[0]);
        pw.printf("  %s <network suggestion opts>\n", new Object[]{"suggest_network_time"});
        pw.printf("    Suggests a time as if via the \"network\" origin.\n", new Object[0]);
        pw.printf("  %s <gnss suggestion opts>\n", new Object[]{"suggest_gnss_time"});
        pw.printf("    Suggests a time as if via the \"gnss\" origin.\n", new Object[0]);
        pw.printf("  %s <external suggestion opts>\n", new Object[]{"suggest_external_time"});
        pw.printf("    Suggests a time as if via the \"external\" origin.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"get_time_state"});
        pw.printf("    Returns the current time setting state.\n", new Object[0]);
        pw.printf("  %s <time state options>\n", new Object[]{"set_time_state_for_tests"});
        pw.printf("    Sets the current time state for tests.\n", new Object[0]);
        pw.printf("  %s <unix epoch time options>\n", new Object[]{"confirm_time"});
        pw.printf("    Tries to confirms the time, raising the confidence.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"get_network_time"});
        pw.printf("    Prints the network time information held by the detector.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"clear_network_time"});
        pw.printf("    Clears the network time information held by the detector.\n", new Object[0]);
        pw.printf("  %s <network suggestion opts>\n", new Object[]{"set_system_clock_network_time"});
        pw.printf("    Sets the network time information used for SystemClock.currentNetworkTimeClock().\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"clear_system_clock_network_time"});
        pw.printf("    Clears the network time information used for SystemClock.currentNetworkTimeClock().\n", new Object[0]);
        pw.println();
        ManualTimeSuggestion.printCommandLineOpts(pw);
        pw.println();
        TelephonyTimeSuggestion.printCommandLineOpts(pw);
        pw.println();
        NetworkTimeSuggestion.printCommandLineOpts(pw);
        pw.println();
        GnssTimeSuggestion.printCommandLineOpts(pw);
        pw.println();
        ExternalTimeSuggestion.printCommandLineOpts(pw);
        pw.println();
        TimeState.printCommandLineOpts(pw);
        pw.println();
        UnixEpochTime.printCommandLineOpts(pw);
        pw.println();
        pw.printf("This service is also affected by the following device_config flags in the %s namespace:\n", new Object[]{"system_time"});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_TIME_DETECTOR_LOWER_BOUND_MILLIS_OVERRIDE});
        pw.printf("    The lower bound used to validate time suggestions when they are received.\n", new Object[0]);
        pw.printf("    Specified in milliseconds since the start of the Unix epoch.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_TIME_DETECTOR_ORIGIN_PRIORITIES_OVERRIDE});
        pw.printf("    A comma separated list of origins. See TimeDetectorStrategy for details.\n", new Object[0]);
        pw.println();
        pw.printf("See \"adb shell cmd device_config\" for more information on setting flags.\n", new Object[0]);
        pw.println();
    }
}
