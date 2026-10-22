package com.android.server.ondeviceintelligence;

import android.os.Binder;
import android.os.ShellCommand;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
final class OnDeviceIntelligenceShellCommand extends ShellCommand {
    private static final String TAG = null;
    private final OnDeviceIntelligenceManagerService mService;

    static {
        TAG = OnDeviceIntelligenceShellCommand.class.getSimpleName();
    }

    OnDeviceIntelligenceShellCommand(OnDeviceIntelligenceManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -2091542783: goto L18;
            case -365435659: goto L15;
            case -108354651: goto L12;
            case 1159014577: goto L9;
            default: goto L20;
        };
    L20:
        byte r0 = -1;
    L21:
        switch(r0) {
            case 0: goto L31;
            case 1: goto L29;
            case 2: goto L27;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        return handleDefaultCommands(cmd);
    L25:
        return setDeviceConfigNamespace();
    L27:
        return setBroadcastKeys();
    L29:
        return getConfiguredServices();
    L31:
        return setTemporaryServices();
    L9:
        if (cmd.equals("set-deviceconfig-namespace") == false) goto L20;
        r0 = 3;
        goto L21
    L12:
        if (cmd.equals("set-temporary-services") == false) goto L20;
        r0 = 0;
        goto L21
    L15:
        if (cmd.equals("get-services") == false) goto L20;
        r0 = 1;
        goto L21
    L18:
        if (cmd.equals("set-model-broadcasts") == false) goto L20;
        r0 = 2;
        goto L21
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("OnDeviceIntelligenceShellCommand commands: ");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  set-temporary-services [IntelligenceServiceComponentName] [InferenceServiceComponentName] [DURATION]");
        pw.println("    Temporarily (for DURATION ms) changes the service implementations.");
        pw.println("    To reset, call without any arguments.");
        pw.println("  get-services To get the names of services that are currently being used.");
        pw.println("  set-model-broadcasts [ModelLoadedBroadcastKey] [ModelUnloadedBroadcastKey] [ReceiverPackageName] [DURATION] To set the names of broadcast intent keys that are to be emitted for cts tests.");
        pw.println("  set-deviceconfig-namespace [DeviceConfigNamespace] [DURATION] To set the device config namespace to use for cts tests.");
    }

    private int setTemporaryServices() {
        PrintWriter out = getOutPrintWriter();
        String intelligenceServiceName = getNextArg();
        String inferenceServiceName = getNextArg();
        if (getRemainingArgsCount() != 0) goto L8;
        if (intelligenceServiceName != null) goto L8;
        if (inferenceServiceName != null) goto L8;
        OnDeviceIntelligenceManagerService.enforceShellOnly(Binder.getCallingUid(), "resetTemporaryServices");
        this.mService.resetTemporaryServices();
        out.println("OnDeviceIntelligenceManagerService temporary reset. ");
        return 0;
    L8:
        intelligenceServiceName.getClass();
        inferenceServiceName.getClass();
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryServices(new String[]{intelligenceServiceName, inferenceServiceName}, duration);
        out.println("OnDeviceIntelligenceService temporarily set to " + intelligenceServiceName + " \n and \n OnDeviceTrustedInferenceService set to " + inferenceServiceName + " for " + duration + "ms");
        return 0;
    }

    private int getConfiguredServices() {
        PrintWriter out = getOutPrintWriter();
        String[] services = this.mService.getServiceNames();
        out.println("OnDeviceIntelligenceService set to :  " + services[0] + " \n and \n OnDeviceTrustedInferenceService set to : " + services[1]);
        return 0;
    }

    private int setBroadcastKeys() {
        PrintWriter out = getOutPrintWriter();
        String modelLoadedKey = getNextArgRequired();
        String modelUnloadedKey = getNextArgRequired();
        String receiverPackageName = getNextArg();
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setModelBroadcastKeys(new String[]{modelLoadedKey, modelUnloadedKey}, receiverPackageName, duration);
        out.println("OnDeviceIntelligence Model Loading broadcast keys temporarily set to " + modelLoadedKey + " \n and \n OnDeviceTrustedInferenceService set to " + modelUnloadedKey + "\n and Package name set to : " + receiverPackageName + " for " + duration + "ms");
        return 0;
    }

    private int setDeviceConfigNamespace() {
        PrintWriter out = getOutPrintWriter();
        String configNamespace = getNextArg();
        int duration = Integer.parseInt(getNextArgRequired());
        this.mService.setTemporaryDeviceConfigNamespace(configNamespace, duration);
        out.println("OnDeviceIntelligence DeviceConfig Namespace temporarily set to " + configNamespace + " for " + duration + "ms");
        return 0;
    }
}
