package com.android.server.power;

import android.app.IAlarmListener;
import android.app.IAlarmManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManagerInternal;
import android.os.Binder;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.ShellCommand;
import android.os.SystemClock;
import android.util.SparseArray;
import com.android.server.LocalServices;
import com.android.server.am.HostingRecord;
import com.android.server.pm.pkg.AndroidPackage;
import com.obric.cae.libs.BuildConfig;
import java.io.PrintWriter;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
class PowerManagerShellCommand extends ShellCommand {
    private static final int LOW_POWER_MODE_ON = 1;
    private final IAlarmListener mAlarmListener;
    private IAlarmManager mAlarmManager;
    private final Context mContext;
    private SparseArray<PowerManager.WakeLock> mProxWakelocks;
    private final PowerManagerService.BinderService mService;

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m7548$$Nest$fgetmContext(PowerManagerShellCommand r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmService, reason: not valid java name */
    static /* bridge */ /* synthetic */ PowerManagerService.BinderService m7549$$Nest$fgetmService(PowerManagerShellCommand r0) {
        return r0.mService;
    }

    PowerManagerShellCommand(Context context, PowerManagerService.BinderService service) {
        this.mProxWakelocks = new SparseArray();
        this.mContext = context;
        this.mService = service;
        this.mAlarmManager = IAlarmManager.Stub.asInterface(ServiceManager.getService(HostingRecord.TRIGGER_TYPE_ALARM));
        this.mAlarmListener = new AnonymousClass1(this);
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -977473428: goto L42;
            case -959859596: goto L39;
            case -795228353: goto L36;
            case -531688203: goto L33;
            case -261293458: goto L30;
            case 109522647: goto L27;
            case 584761923: goto L24;
            case 774730613: goto L21;
            case 1032507032: goto L18;
            case 1369181230: goto L15;
            case 1369273846: goto L10;
            default: goto L44;
        };     // Catch: RemoteException -> L12
    L44:
        byte r2 = -1;
    L45:
        switch(r2) {
            case 0: goto L69;
            case 1: goto L67;
            case 2: goto L65;
            case 3: goto L63;
            case 4: goto L61;
            case 5: goto L59;
            case 6: goto L57;
            case 7: goto L55;
            case 8: goto L53;
            case 9: goto L51;
            case 10: goto L49;
            default: goto L47;
        };     // Catch: RemoteException -> L12
    L47:
        return handleDefaultCommands(cmd);
    L49:
        return runExitFakeSleep();
    L51:
        return runEnterFakeSleep();
    L53:
        return runWakeUp();
    L55:
        return runSleep();
    L57:
        return runSetFaceDownDetector();
    L59:
        return runSetProx();
    L61:
        return runListAmbientDisplaySuppressionTokens();
    L63:
        return runSuppressAmbientDisplay();
    L65:
        return runSetFixedPerformanceModeEnabled();
    L67:
        return runSetMode();
    L69:
        return runSetAdaptiveEnabled();
    L10:
        if (cmd.equals("set-prox") == false) goto L44;
        r2 = 5;
        goto L45
    L15:
        if (cmd.equals("set-mode") == false) goto L44;
        r2 = 1;
        goto L45
    L18:
        if (cmd.equals("set-fixed-performance-mode-enabled") == false) goto L44;
        r2 = 2;
        goto L45
    L21:
        if (cmd.equals("suppress-ambient-display") == false) goto L44;
        r2 = 3;
        goto L45
    L24:
        if (cmd.equals("list-ambient-display-suppression-tokens") == false) goto L44;
        r2 = 4;
        goto L45
    L27:
        if (cmd.equals("sleep") == false) goto L44;
        r2 = 7;
        goto L45
    L30:
        if (cmd.equals("exit-fake-sleep") == false) goto L44;
        r2 = 10;
        goto L45
    L33:
        if (cmd.equals("set-adaptive-power-saver-enabled") == false) goto L44;
        r2 = 0;
        goto L45
    L36:
        if (cmd.equals("wakeup") == false) goto L44;
        r2 = 8;
        goto L45
    L39:
        if (cmd.equals("enter-fake-sleep") == false) goto L44;
        r2 = 9;
        goto L45
    L42:
        if (cmd.equals("set-face-down-detector") == false) goto L44;
        r2 = 6;
        goto L45
    L4:
        return handleDefaultCommands(cmd);
    }

    private int runEnterFakeSleep() {
        this.mService.enterFakeSleep();
        return 0;
    }

    private int runExitFakeSleep() {
        PrintWriter pw = getOutPrintWriter();
        int flag = 0;
        String arg = getNextArg();     // Catch: RuntimeException -> L7
        if (arg == null) goto L9;
        flag = Integer.parseInt(arg);     // Catch: RuntimeException -> L7
    L9:
        this.mService.exitFakeSleep(flag);
        return 0;
    L7:
        ex = move-exception;
        pw.println("Error: " + ex.toString());
        return -1;
    }

    private int runSetAdaptiveEnabled() throws RemoteException {
        this.mService.setAdaptivePowerSaveEnabled(Boolean.parseBoolean(getNextArgRequired()));
        return 0;
    }

    private int runSetMode() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        int mode = Integer.parseInt(getNextArgRequired());     // Catch: RuntimeException -> L10
        PowerManagerService.BinderService r1 = this.mService;
        boolean r4 = true;
        if (mode == 1) goto L8;
        r4 = false;
    L8:
        r1.setPowerSaveModeEnabled(r4);
        return 0;
    L10:
        ex = move-exception;
        pw.println("Error: " + ex.toString());
        return -1;
    }

    private int runSetFixedPerformanceModeEnabled() throws RemoteException {
        boolean success = this.mService.setPowerModeChecked(3, Boolean.parseBoolean(getNextArgRequired()));
        if (success == true) goto L5;
        PrintWriter ew = getErrPrintWriter();
        ew.println("Failed to set FIXED_PERFORMANCE mode");
        ew.println("This is likely because Power HAL AIDL is not implemented on this device");
    L5:
        if (success == false) goto L7;
        return 0;
    L7:
        return -1;
    }

    private int runSuppressAmbientDisplay() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String token = getNextArgRequired();     // Catch: RuntimeException -> L6
        boolean enabled = Boolean.parseBoolean(getNextArgRequired());     // Catch: RuntimeException -> L6
        this.mService.suppressAmbientDisplay(token, enabled);     // Catch: RuntimeException -> L6
        return 0;
    L6:
        ex = move-exception;
        pw.println("Error: " + ex.toString());
        return -1;
    }

    private int runListAmbientDisplaySuppressionTokens() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        List<String> tokens = this.mService.getAmbientDisplaySuppressionTokens();
        if (tokens.isEmpty() == false) goto L5;
        pw.println("none");
        return 0;
    L5:
        pw.println(String.format("[%s]", new Object[]{String.join(", ", tokens)}));
        return 0;
    }

    private int runSetProx() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String r1 = getNextArgRequired().toLowerCase();
        switch(r1.hashCode()) {
            case -1164222250: goto L12;
            case 3322014: goto L9;
            case 1090594823: goto L6;
            default: goto L14;
        };
    L14:
        byte r2 = -1;
    L15:
        switch(r2) {
            case 0: goto L34;
            case 1: goto L19;
            case 2: goto L18;
            default: goto L16;
        };
    L16:
        pw.println("Error: Allowed options are 'list' 'enable' and 'disable'.");
        return -1;
    L18:
        boolean acquire = false;
    L20:
        int displayId = -1;
        String displayOption = getNextArg();
        if ("-d".equals(displayOption) == false) goto L26;
        String idStr = getNextArg();
        displayId = Integer.parseInt(idStr);
        if (displayId >= 0) goto L26;
        pw.println("Error: Specified displayId (" + idStr + ") must a non-negative int.");
        return -1;
    L26:
        int wakelockIndex = displayId + 1;
        PowerManager.WakeLock wakelock = this.mProxWakelocks.get(wakelockIndex);
        if (wakelock != null) goto L29;
        PowerManager pm = (PowerManager) this.mContext.getSystemService(PowerManager.class);
        wakelock = pm.newWakeLock(32, "PowerManagerShellCommand[" + displayId + "]", displayId);
        this.mProxWakelocks.put(wakelockIndex, wakelock);
    L29:
        if (acquire == false) goto L31;
        wakelock.acquire();
    L32:
        pw.println(wakelock);
        return 0;
    L31:
        wakelock.release();
        goto L32
    L19:
        acquire = true;
        goto L20
    L34:
        pw.println("Wakelocks:");
        pw.println(this.mProxWakelocks);
        return 0;
    L6:
        if (r1.equals(BuildConfig.BUILD_TYPE) == false) goto L36;
        r2 = 2;
        goto L15
    L36:
        r2 = -1;
        goto L15
    L9:
        if (r1.equals("list") == false) goto L37;
        r2 = 0;
        goto L15
    L37:
        r2 = -1;
        goto L15
    L12:
        if (r1.equals("acquire") == false) goto L38;
        r2 = 1;
        goto L15
    L38:
        r2 = -1;
        goto L15
    }

    private int runSetFaceDownDetector() {
        this.mService.setUseFaceDownDetector(Boolean.parseBoolean(getNextArgRequired()));     // Catch: Exception -> L5
        return 0;
    L5:
        e = move-exception;
        PrintWriter pw = getOutPrintWriter();
        pw.println("Error: " + e);
        return -1;
    }

    private int runSleep() {
        this.mService.goToSleep(SystemClock.uptimeMillis(), 0, 1);     // Catch: Exception -> L4
        return 0;
    L4:
        e = move-exception;
        PrintWriter pw = getOutPrintWriter();
        pw.println("Error: " + e);
        return -1;
    }

    private int runWakeUp() {
        PrintWriter pw = getOutPrintWriter();
        String delay = getNextArg();
        if (delay == null) goto L34;
        long delayMillis = Long.parseLong(delay);     // Catch: NumberFormatException -> L28
        if (delayMillis >= 0) goto L14;
        pw.println("Error: Can't set a negative delay: " + delayMillis);
        return -1;
    L14:
        long wakeUpTime = System.currentTimeMillis() + delayMillis;
        if (this.mAlarmManager != null) goto L31;
        this.mAlarmManager = IAlarmManager.Stub.asInterface(ServiceManager.getService(HostingRecord.TRIGGER_TYPE_ALARM));
    L31:
        PackageManagerInternal packageManagerInternal = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);     // Catch: Exception -> L21
        AndroidPackage callingPackage = packageManagerInternal.getPackage(Binder.getCallingUid());     // Catch: Exception -> L21
        if (callingPackage != null) goto L23;
        pw.println("Calling uid " + Binder.getCallingUid() + " is not an android package. Cannot schedule a delayed wakeup on behalf of it.");     // Catch: Exception -> L21
        return -1;
    L23:
        pw.println("Schedule an alarm to wakeup in " + delayMillis + " ms, on behalf of " + callingPackage.getPackageName());     // Catch: Exception -> L21
        this.mAlarmManager.set(callingPackage.getPackageName(), 0, wakeUpTime, 0, 0, 64, null, this.mAlarmListener, "PowerManagerShellCommand", null, null);     // Catch: Exception -> L21
        return 0;
    L21:
        e = move-exception;
        pw.println("Error: " + e);
        return -1;
    L28:
        e = move-exception;
        pw.println("Error: Can't parse arg " + delay + " as a long: " + e);
        return -1;
    L34:
        this.mService.wakeUp(SystemClock.uptimeMillis(), 2, "PowerManagerShellCommand", this.mContext.getOpPackageName());     // Catch: Exception -> L6
        return 0;
    L6:
        e = move-exception;
        pw.println("Error: " + e);
        return -1;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Power manager (power) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  set-adaptive-power-saver-enabled [true|false]");
        pw.println("    enables or disables adaptive power saver.");
        pw.println("  set-mode MODE");
        pw.println("    sets the power mode of the device to MODE.");
        pw.println("    1 turns low power mode on and 0 turns low power mode off.");
        pw.println("  set-fixed-performance-mode-enabled [true|false]");
        pw.println("    enables or disables fixed performance mode");
        pw.println("    note: this will affect system performance and should only be used");
        pw.println("          during development");
        pw.println("  suppress-ambient-display <token> [true|false]");
        pw.println("    suppresses the current ambient display configuration and disables");
        pw.println("    ambient display");
        pw.println("  list-ambient-display-suppression-tokens");
        pw.println("    prints the tokens used to suppress ambient display");
        pw.println("  set-prox [list|acquire|release] (-d <display_id>)");
        pw.println("    Acquires the proximity sensor wakelock. Wakelock is associated with");
        pw.println("    a specific display if specified. 'list' lists wakelocks previously");
        pw.println("    created by set-prox including their held status.");
        pw.println("  set-face-down-detector [true|false]");
        pw.println("    sets whether we use face down detector timeouts or not");
        pw.println("  sleep");
        pw.println("    requests to sleep the device");
        pw.println("  wakeup <delay>");
        pw.println("    requests to wake up the device. If a delay of milliseconds is specified,");
        pw.println("    alarm manager will schedule a wake up after the delay.");
        pw.println();
        Intent.printIntentArgsHelp(pw, "");
    }
}
