package com.android.server.timezonedetector.location;

import android.app.time.LocationTimeZoneAlgorithmStatus;
import android.os.ShellCommand;
import android.util.IndentingPrintWriter;
import android.util.proto.ProtoOutputStream;
import com.android.internal.util.dump.DualDumpOutputStream;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.timedetector.ServerFlags;
import com.android.server.timezonedetector.GeolocationTimeZoneSuggestion;
import com.android.server.timezonedetector.LocationAlgorithmEvent;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
class LocationTimeZoneManagerShellCommand extends ShellCommand {
    private final LocationTimeZoneManagerService mService;

    LocationTimeZoneManagerShellCommand(LocationTimeZoneManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -385184143: goto L21;
            case 3540994: goto L18;
            case 109757538: goto L15;
            case 248094771: goto L12;
            case 943200902: goto L9;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return handleDefaultCommands(cmd);
    L28:
        return runDumpControllerState();
    L30:
        return runClearRecordedProviderStates();
    L32:
        return runStop();
    L34:
        return runStartWithTestProviders();
    L36:
        return runStart();
    L9:
        if (cmd.equals("dump_state") == false) goto L23;
        r0 = 4;
        goto L24
    L12:
        if (cmd.equals("clear_recorded_provider_states") == false) goto L23;
        r0 = 3;
        goto L24
    L15:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L23;
        r0 = 0;
        goto L24
    L18:
        if (cmd.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L23;
        r0 = 2;
        goto L24
    L21:
        if (cmd.equals("start_with_test_providers") == false) goto L23;
        r0 = 1;
        goto L24
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.printf("Location Time Zone Manager (%s) commands for tests:\n", new Object[]{"location_time_zone_manager"});
        pw.printf("  help\n", new Object[0]);
        pw.printf("    Print this help text.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{IMediaProjectionManagerServiceExt.NODE_START});
        pw.printf("    Starts the service, creating location time zone providers.\n", new Object[0]);
        pw.printf("  %s <primary package name|%2$s> <secondary package name|%2$s> <record states>\n", new Object[]{"start_with_test_providers", "@null"});
        pw.printf("    Starts the service with test provider packages configured / provider permission checks disabled.\n", new Object[0]);
        pw.printf("    <record states> - true|false, determines whether state recording is enabled.\n", new Object[0]);
        pw.printf("    See %s and %s.\n", new Object[]{"dump_state", "clear_recorded_provider_states"});
        pw.printf("  %s\n", new Object[]{IMediaProjectionManagerServiceExt.NODE_STOP});
        pw.printf("    Stops the service, destroying location time zone providers.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{"clear_recorded_provider_states"});
        pw.printf("    Clears recorded provider state. See also %s and %s.\n", new Object[]{"start_with_test_providers", "dump_state"});
        pw.printf("    Note: This is only intended for use during testing.\n", new Object[0]);
        pw.printf("  %s [%s]\n", new Object[]{"dump_state", "--proto"});
        pw.printf("    Dumps service state for tests as text or binary proto form.\n", new Object[0]);
        pw.printf("    See the LocationTimeZoneManagerServiceStateProto definition for details.\n", new Object[0]);
        pw.println();
        pw.printf("This service is also affected by the following device_config flags in the %s namespace:\n", new Object[]{"system_time"});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_PRIMARY_LTZP_MODE_OVERRIDE});
        pw.printf("    Overrides the mode of the primary provider. Values=%s|%s\n", new Object[]{ServiceConfigAccessor.PROVIDER_MODE_DISABLED, ServiceConfigAccessor.PROVIDER_MODE_ENABLED});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_SECONDARY_LTZP_MODE_OVERRIDE});
        pw.printf("    Overrides the mode of the secondary provider. Values=%s|%s\n", new Object[]{ServiceConfigAccessor.PROVIDER_MODE_DISABLED, ServiceConfigAccessor.PROVIDER_MODE_ENABLED});
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LOCATION_TIME_ZONE_DETECTION_UNCERTAINTY_DELAY_MILLIS});
        pw.printf("    Sets the amount of time the service waits when uncertain before making an 'uncertain' suggestion to the time zone detector.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_MILLIS});
        pw.printf("    Sets the initialization time passed to the providers.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LTZP_INITIALIZATION_TIMEOUT_FUZZ_MILLIS});
        pw.printf("    Sets the amount of extra time added to the providers' initialization time.\n", new Object[0]);
        pw.printf("  %s\n", new Object[]{ServerFlags.KEY_LTZP_EVENT_FILTERING_AGE_THRESHOLD_MILLIS});
        pw.printf("    Sets the amount of time that must pass between equivalent LTZP events before they will be reported to the system server.\n", new Object[0]);
        pw.println();
        pw.printf("Typically, use '%s' to stop the service before setting individual flags and '%s' after to restart it.\n", new Object[]{IMediaProjectionManagerServiceExt.NODE_STOP, IMediaProjectionManagerServiceExt.NODE_START});
        pw.println();
        pw.printf("See \"adb shell cmd device_config\" for more information on setting flags.\n", new Object[0]);
        pw.println();
        pw.printf("Also see \"adb shell cmd %s help\" for higher-level location time zone commands / settings.\n", new Object[]{"time_zone_detector"});
        pw.println();
    }

    private int runStart() {
        this.mService.start();     // Catch: RuntimeException -> L5
        PrintWriter outPrintWriter = getOutPrintWriter();
        outPrintWriter.println("Service started");
        return 0;
    L5:
        e = move-exception;
        reportError(e);
        return 1;
    }

    private int runStartWithTestProviders() {
        String testPrimaryProviderPackageName = parseProviderPackageName(getNextArgRequired());
        String testSecondaryProviderPackageName = parseProviderPackageName(getNextArgRequired());
        boolean recordProviderStateChanges = Boolean.parseBoolean(getNextArgRequired());
        this.mService.startWithTestProviders(testPrimaryProviderPackageName, testSecondaryProviderPackageName, recordProviderStateChanges);     // Catch: RuntimeException -> L6
        PrintWriter outPrintWriter = getOutPrintWriter();
        outPrintWriter.println("Service started (test mode)");
        return 0;
    L6:
        e = move-exception;
        reportError(e);
        return 1;
    }

    private int runStop() {
        this.mService.stop();     // Catch: RuntimeException -> L5
        PrintWriter outPrintWriter = getOutPrintWriter();
        outPrintWriter.println("Service stopped");
        return 0;
    L5:
        e = move-exception;
        reportError(e);
        return 1;
    }

    private int runClearRecordedProviderStates() {
        this.mService.clearRecordedProviderStates();     // Catch: IllegalStateException -> L5
        return 0;
    L5:
        e = move-exception;
        reportError(e);
        return 2;
    }

    private int runDumpControllerState() {
        LocationTimeZoneManagerServiceState state = this.mService.getStateForTests();     // Catch: RuntimeException -> L29
        if (state != null) goto L7;
        return 0;
    L7:
        boolean useProto = Objects.equals("--proto", getNextOption());
        if (useProto == false) goto L10;
        FileDescriptor outFd = getOutFileDescriptor();
        DualDumpOutputStream outputStream = new DualDumpOutputStream(new ProtoOutputStream(outFd));
    L12:
        if (state.getLastEvent() == null) goto L27;
        LocationAlgorithmEvent lastEvent = state.getLastEvent();
        long lastEventToken = outputStream.start("last_event", 1146756268033L);
        LocationTimeZoneAlgorithmStatus algorithmStatus = lastEvent.getAlgorithmStatus();
        long algorithmStatusToken = outputStream.start("algorithm_status", 1146756268035L);
        outputStream.write("status", 1159641169921L, convertDetectionAlgorithmStatusToEnumToProtoEnum(algorithmStatus.getStatus()));
        outputStream.end(algorithmStatusToken);
        if (lastEvent.getSuggestion() == null) goto L21;
        long suggestionToken = outputStream.start("suggestion", 1146756268033L);
        GeolocationTimeZoneSuggestion lastSuggestion = lastEvent.getSuggestion();
        Iterator<String> r8 = lastSuggestion.getZoneIds().iterator();
    L17:
        if (r8.hasNext() == false) goto L19;
        String zoneId = r8.next();
        outputStream.write("zone_ids", 2237677961217L, zoneId);
        algorithmStatus = algorithmStatus;
        lastSuggestion = lastSuggestion;
        goto L17
    L19:
        outputStream.end(suggestionToken);
    L21:
        Iterator<String> r2 = lastEvent.getDebugInfo().iterator();
    L23:
        if (r2.hasNext() == false) goto L25;
        String debugInfo = r2.next();
        outputStream.write("debug_info", 2237677961218L, debugInfo);
        goto L23
    L25:
        outputStream.end(lastEventToken);
    L27:
        writeControllerStates(outputStream, state.getControllerStates());
        writeProviderStates(outputStream, state.getPrimaryProviderStates(), "primary_provider_states", 2246267895810L);
        writeProviderStates(outputStream, state.getSecondaryProviderStates(), "secondary_provider_states", 2246267895811L);
        outputStream.flush();
        return 0;
    L10:
        outputStream = new DualDumpOutputStream(new IndentingPrintWriter(getOutPrintWriter(), "  "));
    L29:
        e = move-exception;
        reportError(e);
        return 1;
    }

    private static void writeControllerStates(DualDumpOutputStream outputStream, List<String> states) {
        Iterator<String> r0 = states.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String state = r0.next();
        outputStream.write("controller_states", 2259152797700L, convertControllerStateToProtoEnum(state));
        goto L4
    }

    private static int convertControllerStateToProtoEnum(String state) {
        switch(state.hashCode()) {
            case -1166336595: goto L27;
            case -468307734: goto L24;
            case 433141802: goto L21;
            case 478389753: goto L18;
            case 872357833: goto L15;
            case 1386911874: goto L12;
            case 1917201485: goto L9;
            case 2066319421: goto L6;
            default: goto L29;
        };
    L29:
        byte r0 = -1;
    L30:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L31;
        };
    L31:
        return 0;
    L32:
        return 7;
    L33:
        return 6;
    L34:
        return 5;
    L35:
        return 4;
    L36:
        return 3;
    L37:
        return 2;
    L38:
        return 1;
    L6:
        if (state.equals("FAILED") == false) goto L29;
        r0 = 5;
        goto L30
    L9:
        if (state.equals("INITIALIZING") == false) goto L29;
        r0 = 2;
        goto L30
    L12:
        if (state.equals("CERTAIN") == false) goto L29;
        r0 = 4;
        goto L30
    L15:
        if (state.equals("UNCERTAIN") == false) goto L29;
        r0 = 3;
        goto L30
    L18:
        if (state.equals("DESTROYED") == false) goto L29;
        r0 = 6;
        goto L30
    L21:
        if (state.equals("UNKNOWN") == false) goto L29;
        r0 = 7;
        goto L30
    L24:
        if (state.equals("PROVIDERS_INITIALIZING") == false) goto L29;
        r0 = 0;
        goto L30
    L27:
        if (state.equals("STOPPED") == false) goto L29;
        r0 = 1;
        goto L30
    }

    private static void writeProviderStates(DualDumpOutputStream outputStream, List<LocationTimeZoneProvider.ProviderState> providerStates, String fieldName, long fieldId) {
        Iterator<LocationTimeZoneProvider.ProviderState> r0 = providerStates.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        LocationTimeZoneProvider.ProviderState providerState = r0.next();
        long providerStateToken = outputStream.start(fieldName, fieldId);
        outputStream.write("state", 1159641169921L, convertProviderStateEnumToProtoEnum(providerState.stateEnum));
        outputStream.end(providerStateToken);
        goto L4
    }

    private static int convertProviderStateEnumToProtoEnum(int stateEnum) {
        switch(stateEnum) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L5:
        return 6;
    L7:
        return 5;
    L9:
        return 4;
    L11:
        return 3;
    L13:
        return 2;
    L15:
        return 1;
    L17:
        return 0;
    L4:
        throw new IllegalArgumentException("Unknown stateEnum=" + stateEnum);
    }

    private static int convertDetectionAlgorithmStatusToEnumToProtoEnum(int statusEnum) {
        switch(statusEnum) {
            case 0: goto L11;
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L5:
        return 3;
    L7:
        return 2;
    L9:
        return 1;
    L11:
        return 0;
    L4:
        throw new IllegalArgumentException("Unknown statusEnum=" + statusEnum);
    }

    private void reportError(Throwable e) {
        PrintWriter errPrintWriter = getErrPrintWriter();
        errPrintWriter.println("Error: ");
        e.printStackTrace(errPrintWriter);
    }

    private static String parseProviderPackageName(String providerPackageNameString) {
        if (providerPackageNameString.equals("@null") == false) goto L6;
        return null;
    L6:
        return providerPackageNameString;
    }
}
