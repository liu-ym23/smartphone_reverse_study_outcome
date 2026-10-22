package com.android.server.devicestate;

import android.hardware.devicestate.DeviceState;
import android.hardware.devicestate.DeviceStateManager;
import android.hardware.devicestate.DeviceStateRequest;
import android.os.Binder;
import android.os.ShellCommand;
import com.android.server.audio.ZAudioService$$ExternalSyntheticLambda2;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceStateManagerShellCommand extends ShellCommand {
    private static DeviceStateRequest sLastBaseStateRequest;
    private static DeviceStateRequest sLastRequest;
    private final DeviceStateManager mClient;
    private final DeviceStateManagerService mService;

    public DeviceStateManagerShellCommand(DeviceStateManagerService service) {
        this.mService = service;
        this.mClient = (DeviceStateManager) service.getContext().getSystemService(DeviceStateManager.class);
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1906524523: goto L21;
            case -1422060175: goto L18;
            case -1134192350: goto L15;
            case -295380803: goto L12;
            case 109757585: goto L9;
            default: goto L23;
        };
    L23:
        byte r1 = -1;
    L24:
        switch(r1) {
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
        return runPrintStatesSimple(pw);
    L30:
        return runPrintStates(pw);
    L32:
        return runPrintState(pw);
    L34:
        return runBaseState(pw);
    L36:
        return runState(pw);
    L9:
        if (cmd.equals("state") == false) goto L23;
        r1 = 0;
        goto L24
    L12:
        if (cmd.equals("print-states-simple") == false) goto L23;
        r1 = 4;
        goto L24
    L15:
        if (cmd.equals("print-states") == false) goto L23;
        r1 = 3;
        goto L24
    L18:
        if (cmd.equals("print-state") == false) goto L23;
        r1 = 2;
        goto L24
    L21:
        if (cmd.equals("base-state") == false) goto L23;
        r1 = 1;
        goto L24
    L4:
        return handleDefaultCommands(cmd);
    }

    private void printAllStates(PrintWriter pw) {
        Optional<DeviceState> committedState = this.mService.getCommittedState();
        Optional<DeviceState> baseState = this.mService.getBaseState();
        Optional<DeviceState> overrideState = this.mService.getOverrideState();
        pw.println("Committed state: " + toString(committedState));
        if (overrideState.isPresent() == false) goto L6;
        pw.println("----------------------");
        pw.println("Base state: " + toString(baseState));
        pw.println("Override state: " + overrideState.get());
        return;
    }

    private int runState(PrintWriter pw) {
        String nextArg = getNextArg();
        if (nextArg != null) goto L6;
        printAllStates(pw);
        return 0;
    L6:
        long callingIdentity = Binder.clearCallingIdentity();
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: " + e.getMessage());     // Catch: Throwable -> L12
        getErrPrintWriter().println("-------------------");     // Catch: Throwable -> L12
        getErrPrintWriter().println("Run:");     // Catch: Throwable -> L12
        getErrPrintWriter().println("");     // Catch: Throwable -> L12
        getErrPrintWriter().println("    print-states");     // Catch: Throwable -> L12
        getErrPrintWriter().println("");     // Catch: Throwable -> L12
        getErrPrintWriter().println("to get the list of currently supported device states");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingIdentity);
        return -1;
    L8:
        if ("reset".equals(nextArg) == true) goto L10;
        int requestedState = Integer.parseInt(nextArg);     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        DeviceStateRequest request = DeviceStateRequest.newBuilder(requestedState).build();     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        this.mClient.requestState(request, null, null);     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        sLastRequest = request;     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
    L19:
        Binder.restoreCallingIdentity(callingIdentity);
        return 0;
    L10:
        if (sLastRequest == null) goto L19;
        this.mClient.cancelStateRequest();     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        sLastRequest = null;     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        goto L19
    L26:
        getErrPrintWriter().println("Error: requested state should be an integer");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingIdentity);
        return -1;
    }

    private int runBaseState(PrintWriter pw) {
        String nextArg = getNextArg();
        if (nextArg != null) goto L6;
        printAllStates(pw);
        return 0;
    L6:
        long callingIdentity = Binder.clearCallingIdentity();
    L12:
        th = move-exception;
        Binder.restoreCallingIdentity(callingIdentity);
        throw th;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: " + e.getMessage());     // Catch: Throwable -> L12
        getErrPrintWriter().println("-------------------");     // Catch: Throwable -> L12
        getErrPrintWriter().println("Run:");     // Catch: Throwable -> L12
        getErrPrintWriter().println("");     // Catch: Throwable -> L12
        getErrPrintWriter().println("    print-states");     // Catch: Throwable -> L12
        getErrPrintWriter().println("");     // Catch: Throwable -> L12
        getErrPrintWriter().println("to get the list of currently supported device states");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingIdentity);
        return -1;
    L8:
        if ("reset".equals(nextArg) == true) goto L10;
        int requestedState = Integer.parseInt(nextArg);     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        DeviceStateRequest request = DeviceStateRequest.newBuilder(requestedState).build();     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        this.mClient.requestBaseStateOverride(request, null, null);     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        sLastBaseStateRequest = request;     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
    L19:
        Binder.restoreCallingIdentity(callingIdentity);
        return 0;
    L10:
        if (sLastBaseStateRequest == null) goto L19;
        this.mClient.cancelBaseStateOverride();     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        sLastBaseStateRequest = null;     // Catch: Throwable -> L12 IllegalArgumentException -> L14 NumberFormatException -> L16
        goto L19
    L26:
        getErrPrintWriter().println("Error: requested state should be an integer");     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(callingIdentity);
        return -1;
    }

    private int runPrintState(PrintWriter pw) {
        Optional<DeviceState> deviceState = this.mService.getCommittedState();
        if (deviceState.isPresent() == false) goto L6;
        pw.println(deviceState.get().getIdentifier());
        return 0;
    L6:
        getErrPrintWriter().println("Error: device state not available.");
        return 1;
    }

    private int runPrintStates(PrintWriter pw) {
        List<DeviceState> states = this.mService.getSupportedStates();
        pw.print("Supported states: [\n");
        int i = 0;
    L4:
        if (i >= states.size()) goto L6;
        pw.print("  " + states.get(i) + ",\n");
        i = i + 1;
        goto L4
    L6:
        pw.println("]");
        return 0;
    }

    private int runPrintStatesSimple(PrintWriter pw) {
        pw.print((String) this.mService.getSupportedStates().stream().map(new DeviceStateManagerShellCommand$$ExternalSyntheticLambda0()).map(new ZAudioService$$ExternalSyntheticLambda2()).collect(Collectors.joining(",")));
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Device state manager (device_state) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  state [reset|OVERRIDE_DEVICE_STATE]");
        pw.println("    Return or override device state.");
        pw.println("  print-state");
        pw.println("    Return the current device state.");
        pw.println("  print-states");
        pw.println("    Return list of currently supported device states.");
        pw.println("  print-states-simple");
        pw.println("    Return the currently supported device states in comma separated format.");
    }

    private static String toString(Optional<DeviceState> state) {
        if (state.isPresent() == true) goto L7;
        return "(none)";
    L7:
        return state.get().toString();
    }
}
