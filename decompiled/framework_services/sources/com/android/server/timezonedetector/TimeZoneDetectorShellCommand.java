package com.android.server.timezonedetector;

import android.app.time.TimeZoneConfiguration;
import android.app.time.TimeZoneState;
import android.app.timezonedetector.ManualTimeZoneSuggestion;
import android.app.timezonedetector.TelephonyTimeZoneSuggestion;
import android.os.ShellCommand;
import com.android.server.timedetector.ServerFlags;
import java.io.PrintWriter;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
class TimeZoneDetectorShellCommand extends ShellCommand {
    private final TimeZoneDetectorService mInterface;

    public static /* synthetic */ TelephonyTimeZoneSuggestion $r8$lambda$CF7XnN3MJqK8G5U49oP5XUmOEA8(TimeZoneDetectorShellCommand r0) {
        return r0.lambda$runSuggestTelephonyTimeZone$2();
    }

    public static /* synthetic */ ManualTimeZoneSuggestion $r8$lambda$nfuxiWPQ6NioQ4CXo4rUmtmVQo8(TimeZoneDetectorShellCommand r0) {
        return r0.lambda$runSuggestManualTimeZone$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$zLI6f49IVNNAe-dQfAH_dCCNtz4, reason: not valid java name */
    public static /* synthetic */ LocationAlgorithmEvent m8598$r8$lambda$zLI6f49IVNNAedQfAH_dCCNtz4(TimeZoneDetectorShellCommand r0) {
        return r0.lambda$runHandleLocationEvent$0();
    }

    TimeZoneDetectorShellCommand(TimeZoneDetectorService timeZoneDetectorService) {
        this.mInterface = timeZoneDetectorService;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -1908861832: goto L48;
            case -1595273216: goto L45;
            case -1589541881: goto L42;
            case -1366762753: goto L39;
            case -1316904020: goto L36;
            case -1264030344: goto L33;
            case -646187524: goto L30;
            case -364727521: goto L27;
            case 496894148: goto L24;
            case 596690236: goto L21;
            case 1133835109: goto L18;
            case 1385756017: goto L15;
            case 1830029431: goto L12;
            case 1902269812: goto L9;
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
        return runDumpMetrics();
    L57:
        return runConfirmTimeZone();
    L59:
        return runSetTimeZoneState();
    L61:
        return runGetTimeZoneState();
    L63:
        return runEnableTelephonyFallback();
    L65:
        return runSuggestTelephonyTimeZone();
    L67:
        return runSuggestManualTimeZone();
    L69:
        return runHandleLocationEvent();
    L71:
        return runSetGeoDetectionEnabled();
    L73:
        return runIsGeoDetectionEnabled();
    L75:
        return runIsGeoDetectionSupported();
    L77:
        return runIsTelephonyDetectionSupported();
    L79:
        return runSetAutoDetectionEnabled();
    L81:
        return runIsAutoDetectionEnabled();
    L9:
        if (cmd.equals("set_auto_detection_enabled") == false) goto L50;
        r0 = 1;
        goto L51
    L12:
        if (cmd.equals("handle_location_algorithm_event") == false) goto L50;
        r0 = 6;
        goto L51
    L15:
        if (cmd.equals("is_geo_detection_supported") == false) goto L50;
        r0 = 3;
        goto L51
    L18:
        if (cmd.equals("enable_telephony_fallback") == false) goto L50;
        r0 = 9;
        goto L51
    L21:
        if (cmd.equals("suggest_telephony_time_zone") == false) goto L50;
        r0 = 8;
        goto L51
    L24:
        if (cmd.equals("is_geo_detection_enabled") == false) goto L50;
        r0 = 4;
        goto L51
    L27:
        if (cmd.equals("confirm_time_zone") == false) goto L50;
        r0 = 12;
        goto L51
    L30:
        if (cmd.equals("set_geo_detection_enabled") == false) goto L50;
        r0 = 5;
        goto L51
    L33:
        if (cmd.equals("dump_metrics") == false) goto L50;
        r0 = 13;
        goto L51
    L36:
        if (cmd.equals("is_auto_detection_enabled") == false) goto L50;
        r0 = 0;
        goto L51
    L39:
        if (cmd.equals("set_time_zone_state_for_tests") == false) goto L50;
        r0 = 11;
        goto L51
    L42:
        if (cmd.equals("get_time_zone_state") == false) goto L50;
        r0 = 10;
        goto L51
    L45:
        if (cmd.equals("suggest_manual_time_zone") == false) goto L50;
        r0 = 7;
        goto L51
    L48:
        if (cmd.equals("is_telephony_detection_supported") == false) goto L50;
        r0 = 2;
        goto L51
    }

    private int runIsAutoDetectionEnabled() {
        PrintWriter pw = getOutPrintWriter();
        boolean enabled = this.mInterface.getCapabilitiesAndConfig(-2).getConfiguration().isAutoDetectionEnabled();
        pw.println(enabled);
        return 0;
    }

    private int runIsTelephonyDetectionSupported() {
        PrintWriter pw = getOutPrintWriter();
        boolean enabled = this.mInterface.isTelephonyTimeZoneDetectionSupported();
        pw.println(enabled);
        return 0;
    }

    private int runIsGeoDetectionSupported() {
        PrintWriter pw = getOutPrintWriter();
        boolean enabled = this.mInterface.isGeoTimeZoneDetectionSupported();
        pw.println(enabled);
        return 0;
    }

    private int runIsGeoDetectionEnabled() {
        PrintWriter pw = getOutPrintWriter();
        boolean enabled = this.mInterface.getCapabilitiesAndConfig(-2).getConfiguration().isGeoDetectionEnabled();
        pw.println(enabled);
        return 0;
    }

    private int runSetAutoDetectionEnabled() {
        boolean r0 = Boolean.parseBoolean(getNextArgRequired());
        TimeZoneConfiguration r2 = new TimeZoneConfiguration.Builder().setAutoDetectionEnabled(r0).build();
        return !this.mInterface.updateConfiguration(-2, r2) ? 1 : 0;
    }

    private int runSetGeoDetectionEnabled() {
        boolean r0 = Boolean.parseBoolean(getNextArgRequired());
        TimeZoneConfiguration r2 = new TimeZoneConfiguration.Builder().setGeoDetectionEnabled(r0).build();
        return !this.mInterface.updateConfiguration(-2, r2) ? 1 : 0;
    }

    private int runHandleLocationEvent() {
        Supplier r0 = new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda0(this);
        final TimeZoneDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSingleArgMethod(r0, new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda1(r1));
    }

    private /* synthetic */ LocationAlgorithmEvent lambda$runHandleLocationEvent$0() {
        return LocationAlgorithmEvent.parseCommandLineArg(this);
    }

    private int runSuggestManualTimeZone() {
        Supplier r0 = new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda4(this);
        final TimeZoneDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSingleArgMethod(r0, new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda5(r1));
    }

    private /* synthetic */ ManualTimeZoneSuggestion lambda$runSuggestManualTimeZone$1() {
        return ManualTimeZoneSuggestion.parseCommandLineArg(this);
    }

    private int runSuggestTelephonyTimeZone() {
        Supplier r0 = new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda2(this);
        final TimeZoneDetectorService r1 = this.mInterface;
        r1.getClass();
        return runSingleArgMethod(r0, new TimeZoneDetectorShellCommand$$ExternalSyntheticLambda3(r1));
    }

    private /* synthetic */ TelephonyTimeZoneSuggestion lambda$runSuggestTelephonyTimeZone$2() {
        return TelephonyTimeZoneSuggestion.parseCommandLineArg(this);
    }

    private <T> int runSingleArgMethod(Supplier<T> argParser, Consumer<T> invoker) {
        PrintWriter pw = getOutPrintWriter();
        T arg = argParser.get();     // Catch: RuntimeException -> L7
        if (arg != null) goto L9;
        pw.println("Error: arg not specified");     // Catch: RuntimeException -> L7
        return 1;
    L9:
        invoker.accept(arg);     // Catch: RuntimeException -> L7
        pw.println("Arg " + arg + " injected.");     // Catch: RuntimeException -> L7
        return 0;
    L7:
        e = move-exception;
        pw.println(e);
        return 1;
    }

    private int runEnableTelephonyFallback() {
        this.mInterface.enableTelephonyFallback("Command line");
        return 0;
    }

    private int runGetTimeZoneState() {
        TimeZoneState timeZoneState = this.mInterface.getTimeZoneState();
        getOutPrintWriter().println(timeZoneState);
        return 0;
    }

    private int runSetTimeZoneState() {
        TimeZoneState timeZoneState = TimeZoneState.parseCommandLineArgs(this);
        this.mInterface.setTimeZoneState(timeZoneState);
        return 0;
    }

    private int runConfirmTimeZone() {
        String timeZoneId = parseTimeZoneIdArg(this);
        getOutPrintWriter().println(this.mInterface.confirmTimeZone(timeZoneId));
        return 0;
    }

    private static String parseTimeZoneIdArg(ShellCommand cmd) {
        String zoneId = null;
    L3:
        String opt = cmd.getNextArg();
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1274807534: goto L9;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            default: goto L14;
        };
    L15:
        zoneId = cmd.getNextArgRequired();
        goto L3
    L14:
        throw new IllegalArgumentException("Unknown option: " + opt);
    L9:
        if (opt.equals("--zone_id") == false) goto L11;
        r1 = 0;
        goto L12
    L16:
        if (zoneId == null) goto L19;
        return zoneId;
    L19:
        throw new IllegalArgumentException("No zoneId specified.");
    }

    private int runDumpMetrics() {
        PrintWriter pw = getOutPrintWriter();
        MetricsTimeZoneDetectorState metricsState = this.mInterface.generateMetricsState();
        pw.println("MetricsTimeZoneDetectorState:");
        pw.println(metricsState.toString());
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("Time Zone Detector (%s) commands:\n", new Object[]{"time_zone_detector"});
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Print this help text.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"is_auto_detection_enabled"});
        pw.printf("    Prints true/false according to the automatic time zone detection setting\n", new Object[0]);
        pw.printf("  %s true|false\n", new Object[]{"set_auto_detection_enabled"});
        pw.printf("    Sets the automatic time zone detection setting.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"is_telephony_detection_supported"});
        pw.printf("    Prints true/false according to whether telephony time zone detection is supported on this device.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"is_geo_detection_supported"});
        pw.printf("    Prints true/false according to whether geolocation time zone detection is supported on this device.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"is_geo_detection_enabled"});
        pw.printf("    Prints true/false according to the geolocation time zone detection setting.\n", new Object[0]);
        pw.printf("  %s true|false\n", new Object[]{"set_geo_detection_enabled"});
        pw.printf("    Sets the geolocation time zone detection enabled setting.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"enable_telephony_fallback"});
        pw.printf("    Signals that telephony time zone detection fall back can be used if geolocation detection is supported and enabled.\n)", new Object[0]);
        pw.printf("    This is a temporary state until geolocation detection becomes \"certain\".\n", new Object[0]);
        pw.printf("    To have an effect this requires that the telephony fallback feature is supported on the device, see below for device_config flags.\n", new Object[0]);
        pw.printf("  %s <location event opts>\n", new Object[]{"handle_location_algorithm_event"});
        pw.printf("    Simulates an event from the location time zone detection algorithm.\n", new Object[0]);
        pw.printf("  %s <manual suggestion opts>\n", new Object[]{"suggest_manual_time_zone"});
        pw.printf("    Suggests a time zone as if supplied by a user manually.\n", new Object[0]);
        pw.printf("  %s <telephony suggestion opts>\n", new Object[]{"suggest_telephony_time_zone"});
        pw.printf("    Simulates a time zone suggestion from the telephony time zone detection algorithm.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"get_time_zone_state"});
        pw.printf("    Returns the current time zone setting state.\n", new Object[0]);
        pw.printf("  %s <time zone state options>\n", new Object[]{"set_time_zone_state_for_tests"});
        pw.printf("    Sets the current time zone state for tests.\n", new Object[0]);
        pw.printf("  %s <--zone_id Olson ID>\n", new Object[]{"confirm_time_zone"});
        pw.printf("    Tries to confirms the time zone, raising the confidence.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"dump_metrics"});
        pw.printf("    Dumps the service metrics to stdout for inspection.\n", new Object[0]);
        pw.println();
        LocationAlgorithmEvent.printCommandLineOpts(pw);
        pw.println();
        ManualTimeZoneSuggestion.printCommandLineOpts(pw);
        pw.println();
        TelephonyTimeZoneSuggestion.printCommandLineOpts(pw);
        pw.println();
        TimeZoneState.printCommandLineOpts(pw);
        pw.println();
        pw.printf("This service is also affected by the following device_config flags in the %s namespace:\n", new Object[]{"system_time"});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_FEATURE_SUPPORTED});
        pw.printf("    Only observed if the geolocation time zone detection feature is enabled in config.\n", new Object[0]);
        pw.printf("    Set this to false to disable the feature.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_RUN_IN_BACKGROUND_ENABLED});
        pw.printf("    Runs geolocation time zone detection even when it not enabled by the user. The result is not used to set the device's time zone [*]\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_DEFAULT});
        pw.printf("    Only used if the device does not have an explicit 'geolocation time zone detection enabled' setting stored [*].\n", new Object[0]);
        pw.printf("    The default is when unset is false.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_SETTING_ENABLED_OVERRIDE});
        pw.printf("    Used to override the device's 'geolocation time zone detection enabled' setting [*].\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_TIME_ZONE_DETECTOR_AUTO_DETECTION_ENABLED_DEFAULT});
        pw.printf("    Used to set the automatic time zone detection enabled default, i.e. when the device's automatic time zone detection enabled setting hasn't been set explicitly. Intended for internal testers.", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_TIME_ZONE_DETECTOR_TELEPHONY_FALLBACK_SUPPORTED});
        pw.printf("    Used to enable / disable support for telephony detection fallback. Also see the %s command.\n", new Object[]{"enable_telephony_fallback"});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_ENHANCED_METRICS_COLLECTION_ENABLED});
        pw.printf("    Used to increase the detail of metrics collected / reported.\n", new Object[0]);
        pw.println();
        pw.printf("[*] To be enabled, the user must still have location = on / auto time zone detection = on.\n", new Object[0]);
        pw.println();
        pw.printf("See \"adb shell cmd device_config\" for more information on setting flags.\n", new Object[0]);
        pw.println();
        pw.printf("Also see \"adb shell cmd %s help\" for lower-level location time zone commands / settings.\n", new Object[]{"location_time_zone_manager"});
        pw.println();
    }
}
