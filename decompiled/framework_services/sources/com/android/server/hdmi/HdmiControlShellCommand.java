package com.android.server.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.hardware.hdmi.IHdmiControlService;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.util.Slog;
import com.android.server.ISmtResourceControl;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
final class HdmiControlShellCommand extends ShellCommand {
    private static final String TAG = "HdmiShellCommand";
    private final IHdmiControlService.Stub mBinderService;
    AtomicInteger mCecResult;
    IHdmiControlCallback.Stub mHdmiControlCallback;
    final CountDownLatch mLatch;

    /* JADX INFO: renamed from: -$$Nest$mgetResultString, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m4420$$Nest$mgetResultString(HdmiControlShellCommand r0, int r1) {
        return r0.getResultString(r1);
    }

    HdmiControlShellCommand(IHdmiControlService.Stub binderService) {
        this.mBinderService = binderService;
        this.mLatch = new CountDownLatch(1);
        this.mCecResult = new AtomicInteger();
        this.mHdmiControlCallback = new AnonymousClass1(this);
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        return handleShellCommand(cmd);
    L7:
        e = move-exception;
        getErrPrintWriter().println("Caught error for command '" + cmd + "': " + e.getMessage());
        StringBuilder r1 = new StringBuilder();
        r1.append("Error handling hdmi_control shell command: ");
        r1.append(cmd);
        Slog.e(TAG, r1.toString(), e);
        return 1;
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("HdmiControlManager (hdmi_control) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  onetouchplay, otp");
        pw.println("      Send the \"One Touch Play\" feature from a source to the TV");
        pw.println("  vendorcommand --device_type <originating device type>");
        pw.println("                --destination <destination device>");
        pw.println("                --args <vendor specific arguments>");
        pw.println("                [--id <true if vendor command should be sent with vendor id>]");
        pw.println("      Send a Vendor Command to the given target device");
        pw.println("  cec_setting get <setting name>");
        pw.println("      Get the current value of a CEC setting");
        pw.println("  cec_setting set <setting name> <value>");
        pw.println("      Set the value of a CEC setting");
        pw.println("  setsystemaudiomode, setsam [on|off]");
        pw.println("      Sets the System Audio Mode feature on or off on TV devices");
        pw.println("  setarc [on|off]");
        pw.println("      Sets the ARC feature on or off on TV devices");
        pw.println("  deviceselect <device id>");
        pw.println("      Switch to device with given id");
        pw.println("      The device's id is represented by its logical address.");
        pw.println("  history_size get");
        pw.println("      Gets the number of messages that can be stored in dumpsys history");
        pw.println("  history_size set <new_size>");
        pw.println("      Changes the number of messages that can be stored in dumpsys history to new_size");
    }

    private int handleShellCommand(String cmd) throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1962118964: goto L30;
            case -956246195: goto L27;
            case -905786704: goto L24;
            case -905769923: goto L21;
            case -467124088: goto L18;
            case -25969966: goto L15;
            case 110379: goto L12;
            case 621295875: goto L9;
            case 1322280018: goto L6;
            default: goto L32;
        };
    L32:
        byte r1 = -1;
    L33:
        switch(r1) {
            case 0: goto L49;
            case 1: goto L49;
            case 2: goto L47;
            case 3: goto L45;
            case 4: goto L43;
            case 5: goto L43;
            case 6: goto L41;
            case 7: goto L39;
            case 8: goto L37;
            default: goto L35;
        };
    L35:
        return handleDefaultCommands(cmd);
    L37:
        return historySize(pw);
    L39:
        return deviceSelect(pw);
    L41:
        return setArcMode(pw);
    L43:
        return setSystemAudioMode(pw);
    L45:
        return cecSetting(pw);
    L47:
        return vendorCommand(pw);
    L49:
        return oneTouchPlay(pw);
    L6:
        if (cmd.equals("cec_setting") == false) goto L32;
        r1 = 3;
        goto L33
    L9:
        if (cmd.equals("vendorcommand") == false) goto L32;
        r1 = 2;
        goto L33
    L12:
        if (cmd.equals("otp") == false) goto L32;
        r1 = 0;
        goto L33
    L15:
        if (cmd.equals("deviceselect") == false) goto L32;
        r1 = 7;
        goto L33
    L18:
        if (cmd.equals("setsystemaudiomode") == false) goto L32;
        r1 = 4;
        goto L33
    L21:
        if (cmd.equals("setsam") == false) goto L32;
        r1 = 5;
        goto L33
    L24:
        if (cmd.equals("setarc") == false) goto L32;
        r1 = 6;
        goto L33
    L27:
        if (cmd.equals("onetouchplay") == false) goto L32;
        r1 = 1;
        goto L33
    L30:
        if (cmd.equals("history_size") == false) goto L32;
        r1 = 8;
        goto L33
    }

    private int deviceSelect(PrintWriter pw) throws RemoteException {
        if (getRemainingArgsCount() != 1) goto L12;
        int deviceId = Integer.parseInt(getNextArg());
        pw.print("Sending Device Select...");
        this.mBinderService.deviceSelect(deviceId, this.mHdmiControlCallback);
        if (receiveCallback("Device Select") == true) goto L8;
        return 1;
    L8:
        if (this.mCecResult.get() != 0) goto L13;
        return 0;
    L13:
        return 1;
    L12:
        throw new IllegalArgumentException("Expected exactly 1 argument.");
    }

    private int oneTouchPlay(PrintWriter pw) throws RemoteException {
        pw.print("Sending One Touch Play...");
        this.mBinderService.oneTouchPlay(this.mHdmiControlCallback);
        if (receiveCallback("One Touch Play") == true) goto L6;
        return 1;
    L6:
        if (this.mCecResult.get() != 0) goto L9;
        return 0;
    L9:
        return 1;
    }

    private int vendorCommand(PrintWriter pw) throws RemoteException {
        if (6 > getRemainingArgsCount()) goto L50;
        int deviceType = -1;
        int destination = -1;
        String parameters = "";
        boolean hasVendorId = false;
        String arg = getNextOption();
    L5:
        byte r6 = 0;
        if (arg == null) goto L43;
        switch(arg.hashCode()) {
            case -347347485: goto L32;
            case -234325394: goto L29;
            case 1492: goto L26;
            case 1495: goto L23;
            case 1500: goto L20;
            case 1511: goto L17;
            case 1387195: goto L14;
            case 1332872829: goto L11;
            default: goto L34;
        };
    L34:
        r6 = -1;
    L35:
        switch(r6) {
            case 0: goto L41;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L39;
            case 6: goto L38;
            case 7: goto L38;
            default: goto L37;
        };
    L38:
        hasVendorId = Boolean.parseBoolean(getNextArgRequired());
    L42:
        arg = getNextArg();
        goto L5
    L39:
        parameters = getNextArgRequired();
        goto L42
    L40:
        destination = Integer.parseInt(getNextArgRequired());
        goto L42
    L41:
        deviceType = Integer.parseInt(getNextArgRequired());
        goto L42
    L37:
        throw new IllegalArgumentException("Unknown argument: " + arg);
    L11:
        if (arg.equals("--args") == false) goto L34;
        r6 = 5;
        goto L35
    L14:
        if (arg.equals("--id") == false) goto L34;
        r6 = 7;
        goto L35
    L17:
        if (arg.equals("-t") == false) goto L34;
    L20:
        if (arg.equals("-i") == false) goto L34;
        r6 = 6;
        goto L35
    L23:
        if (arg.equals("-d") == false) goto L34;
        r6 = 2;
        goto L35
    L26:
        if (arg.equals("-a") == false) goto L34;
        r6 = 4;
        goto L35
    L29:
        if (arg.equals("--destination") == false) goto L34;
        r6 = 3;
        goto L35
    L32:
        if (arg.equals("--device_type") == false) goto L34;
        r6 = 1;
        goto L35
    L43:
        String[] parts = parameters.split(":");
        byte[] params = new byte[parts.length];
        int i = 0;
    L45:
        if (i >= params.length) goto L47;
        params[i] = (byte) Integer.parseInt(parts[i], 16);
        i = i + 1;
        goto L45
    L47:
        pw.println("Sending <Vendor Command>");
        this.mBinderService.sendVendorCommand(deviceType, destination, params, hasVendorId);
        return 0;
    L50:
        throw new IllegalArgumentException("Expected 3 arguments.");
    }

    private int cecSetting(PrintWriter pw) throws RemoteException {
        byte r1 = 1;
        if (getRemainingArgsCount() < 1) goto L31;
        String operation = getNextArgRequired();
        switch(operation.hashCode()) {
            case 102230: goto L11;
            case 113762: goto L8;
            default: goto L13;
        };
    L13:
        r1 = -1;
    L15:
        switch(r1) {
            case 0: goto L24;
            case 1: goto L18;
            default: goto L17;
        };
    L18:
        String setting = getNextArgRequired();
        String value = getNextArgRequired();
        this.mBinderService.setCecSettingStringValue(setting, value);     // Catch: IllegalArgumentException -> L21
        pw.println(setting + " = " + value);     // Catch: IllegalArgumentException -> L21
    L23:
        return 0;
    L22:
        int intValue = Integer.parseInt(value);
        this.mBinderService.setCecSettingIntValue(setting, intValue);
        pw.println(setting + " = " + intValue);
        goto L23
    L24:
        String setting2 = getNextArgRequired();
        pw.println(setting2 + " = " + this.mBinderService.getCecSettingStringValue(setting2));     // Catch: IllegalArgumentException -> L27
    L29:
        return 0;
    L28:
        pw.println(setting2 + " = " + this.mBinderService.getCecSettingIntValue(setting2));
        goto L29
    L17:
        throw new IllegalArgumentException("Unknown operation: " + operation);
    L8:
        if (operation.equals("set") == false) goto L13;
    L11:
        if (operation.equals("get") == false) goto L13;
        r1 = 0;
        goto L15
    L31:
        throw new IllegalArgumentException("Expected at least 1 argument (operation).");
    }

    private int setSystemAudioMode(PrintWriter pw) throws RemoteException {
        if (1 > getRemainingArgsCount()) goto L20;
        String arg = getNextArg();
        if (arg.equals("on") == false) goto L8;
        pw.println("Setting System Audio Mode on");
        this.mBinderService.setSystemAudioMode(true, this.mHdmiControlCallback);
    L11:
        if (receiveCallback("Set System Audio Mode") == true) goto L14;
        return 1;
    L14:
        if (this.mCecResult.get() == 0) goto L16;
        return 1;
    L16:
        return 0;
    L8:
        if (arg.equals("off") == false) goto L18;
        pw.println("Setting System Audio Mode off");
        this.mBinderService.setSystemAudioMode(false, this.mHdmiControlCallback);
        goto L11
    L18:
        throw new IllegalArgumentException("Please indicate if System Audio Mode should be turned \"on\" or \"off\".");
    L20:
        throw new IllegalArgumentException("Please indicate if System Audio Mode should be turned \"on\" or \"off\".");
    }

    private int setArcMode(PrintWriter pw) throws RemoteException {
        if (1 > getRemainingArgsCount()) goto L14;
        String arg = getNextArg();
        if (arg.equals("on") == false) goto L8;
        pw.println("Setting ARC mode on");
        this.mBinderService.setArcMode(true);
    L10:
        return 0;
    L8:
        if (arg.equals("off") == false) goto L12;
        pw.println("Setting ARC mode off");
        this.mBinderService.setArcMode(false);
        goto L10
    L12:
        throw new IllegalArgumentException("Please indicate if ARC mode should be turned \"on\" or \"off\".");
    L14:
        throw new IllegalArgumentException("Please indicate if ARC mode should be turned \"on\" or \"off\".");
    }

    private int historySize(PrintWriter pw) throws RemoteException {
        if (1 > getRemainingArgsCount()) goto L30;
        String operation = getNextArgRequired();
        switch(operation.hashCode()) {
            case 102230: goto L11;
            case 113762: goto L8;
            default: goto L13;
        };
    L13:
        byte r2 = -1;
    L14:
        switch(r2) {
            case 0: goto L27;
            case 1: goto L17;
            default: goto L16;
        };
    L17:
        String arg = getNextArgRequired();
        int value = Integer.parseInt(arg);     // Catch: NumberFormatException -> L24
        if (this.mBinderService.setMessageHistorySize(value) == false) goto L22;
        pw.println("Setting CEC dumpsys message history size to " + value);
    L23:
        return 0;
    L22:
        pw.println("Message history size not changed, was it lower than the minimum size?");
    L25:
        pw.println("Cannot set CEC dumpsys message history size to " + arg);
        return 1;
    L27:
        pw.println("CEC dumpsys message history size = " + this.mBinderService.getMessageHistorySize());
        return 0;
    L16:
        throw new IllegalArgumentException("Unknown operation: " + operation);
    L8:
        if (operation.equals("set") == false) goto L13;
        r2 = 1;
        goto L14
    L11:
        if (operation.equals("get") == false) goto L13;
        r2 = 0;
        goto L14
    L30:
        throw new IllegalArgumentException("Use 'set' or 'get' for the command action");
    }

    private boolean receiveCallback(String command) {
        if (this.mLatch.await(ISmtResourceControl.LAUNCH_CPUSET_EFFECTIVE_TIME, TimeUnit.MILLISECONDS) == true) goto L15;
        getErrPrintWriter().println(command + " timed out.");     // Catch: InterruptedException -> L7
        return false;
    L15:
        return true;
    L10:
        getErrPrintWriter().println("Caught InterruptedException");
        Thread.currentThread().interrupt();
        return true;
    }

    private String getResultString(int result) {
        switch(result) {
            case 0: goto L17;
            case 1: goto L15;
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L4;
            case 5: goto L9;
            case 6: goto L7;
            case 7: goto L5;
            default: goto L4;
        };
    L5:
        return "Communication Failed";
    L7:
        return "Incorrect mode";
    L9:
        return "Exception";
    L11:
        return "Target not available";
    L13:
        return "Source not available";
    L15:
        return "Timeout";
    L17:
        return "Success";
    L4:
        return Integer.toString(result);
    }
}
