package com.android.server.statusbar;

import android.app.StatusBarManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.service.quicksettings.TileService;
import android.util.Pair;
import com.android.server.media.projection.IMediaProjectionManagerServiceExt;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.PrintWriter;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes3.dex */
public class StatusBarShellCommand extends ShellCommand {
    private static final IBinder sToken = null;
    private final Context mContext;
    private final StatusBarManagerService mInterface;

    private static final class StatusBarShellCommandToken extends Binder {
        /* synthetic */ StatusBarShellCommandToken(StatusBarShellCommandIA r1) {
            this();
        }

        private StatusBarShellCommandToken() {
        }
    }

    static {
        sToken = new StatusBarShellCommandToken(null);
    }

    public StatusBarShellCommand(StatusBarManagerService service, Context context) {
        this.mInterface = service;
        this.mContext = context;
    }

    public int onCommand(String cmd) {
        byte r0 = 1;
        if (cmd != null) goto L96;
        onHelp();
        return 1;
    L96:
    L13:
        e = move-exception;
        PrintWriter pw = getOutPrintWriter();
        pw.println("Remote exception: " + e);
        return -1;
    L8:
        switch(cmd.hashCode()) {
            case -1282000806: goto L58;
            case -1239176554: goto L55;
            case -1067396926: goto L52;
            case -1052548778: goto L49;
            case -919868578: goto L46;
            case -823073837: goto L43;
            case -632085587: goto L40;
            case -498761126: goto L37;
            case -339726761: goto L34;
            case 1499: goto L31;
            case 3095028: goto L28;
            case 3198785: goto L25;
            case 901899220: goto L22;
            case 1612300298: goto L19;
            case 1629310709: goto L16;
            case 1672031734: goto L11;
            default: goto L60;
        };     // Catch: RemoteException -> L13
    L60:
        r0 = -1;
    L61:
        switch(r0) {
            case 0: goto L93;
            case 1: goto L91;
            case 2: goto L89;
            case 3: goto L87;
            case 4: goto L85;
            case 5: goto L83;
            case 6: goto L81;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L75;
            case 10: goto L73;
            case 11: goto L71;
            case 12: goto L69;
            case 13: goto L66;
            case 14: goto L66;
            case 15: goto L65;
            default: goto L63;
        };     // Catch: RemoteException -> L13
    L66:
        onHelp();     // Catch: RemoteException -> L13
        return 0;
    L78:
        PrintWriter pw2 = getOutPrintWriter();     // Catch: RemoteException -> L13
        pw2.println(String.valueOf(TileService.isQuickSettingsSupported()));     // Catch: RemoteException -> L13
        return 0;
    L63:
        return runPassArgsToStatusBar();
    L65:
        return super.handleDefaultCommands(cmd);
    L69:
        return runGc();
    L71:
        return runTracing();
    L73:
        return runSendDisableFlag();
    L75:
        return runDisableForSetup();
    L77:
        return runGetStatusIcons();
    L81:
        return runClickTile();
    L83:
        return runSetTiles();
    L85:
        return runRemoveTile();
    L87:
        return runAddTile();
    L89:
        return runCollapse();
    L91:
        return runExpandSettings();
    L93:
        return runExpandNotifications();
    L11:
        if (cmd.equals("expand-settings") == false) goto L60;
    L16:
        if (cmd.equals("expand-notifications") == false) goto L60;
        r0 = 0;
        goto L61
    L19:
        if (cmd.equals("check-support") == false) goto L60;
        r0 = 7;
        goto L61
    L22:
        if (cmd.equals("disable-for-setup") == false) goto L60;
        r0 = 9;
        goto L61
    L25:
        if (cmd.equals("help") == false) goto L60;
        r0 = 14;
        goto L61
    L28:
        if (cmd.equals(ArchiveStreamFactory.DUMP) == false) goto L60;
        r0 = 15;
        goto L61
    L31:
        if (cmd.equals("-h") == false) goto L60;
        r0 = 13;
        goto L61
    L34:
        if (cmd.equals("remove-tile") == false) goto L60;
        r0 = 4;
        goto L61
    L37:
        if (cmd.equals("set-tiles") == false) goto L60;
        r0 = 5;
        goto L61
    L40:
        if (cmd.equals("collapse") == false) goto L60;
        r0 = 2;
        goto L61
    L43:
        if (cmd.equals("click-tile") == false) goto L60;
        r0 = 6;
        goto L61
    L46:
        if (cmd.equals("run-gc") == false) goto L60;
        r0 = 12;
        goto L61
    L49:
        if (cmd.equals("send-disable-flag") == false) goto L60;
        r0 = 10;
        goto L61
    L52:
        if (cmd.equals("tracing") == false) goto L60;
        r0 = 11;
        goto L61
    L55:
        if (cmd.equals("get-status-icons") == false) goto L60;
        r0 = 8;
        goto L61
    L58:
        if (cmd.equals("add-tile") == false) goto L60;
        r0 = 3;
        goto L61
    }

    private int runAddTile() throws RemoteException {
        this.mInterface.addTile(ComponentName.unflattenFromString(getNextArgRequired()));
        return 0;
    }

    private int runRemoveTile() throws RemoteException {
        this.mInterface.remTile(ComponentName.unflattenFromString(getNextArgRequired()));
        return 0;
    }

    private int runSetTiles() throws RemoteException {
        this.mInterface.setTiles(getNextArgRequired());
        return 0;
    }

    private int runClickTile() throws RemoteException {
        this.mInterface.clickTile(ComponentName.unflattenFromString(getNextArgRequired()));
        return 0;
    }

    private int runCollapse() throws RemoteException {
        this.mInterface.collapsePanels();
        return 0;
    }

    private int runExpandSettings() throws RemoteException {
        this.mInterface.expandSettingsPanel(null);
        return 0;
    }

    private int runExpandNotifications() throws RemoteException {
        this.mInterface.expandNotificationsPanel();
        return 0;
    }

    private int runGetStatusIcons() {
        PrintWriter pw = getOutPrintWriter();
        String[] r1 = this.mInterface.getStatusBarIcons();
        int r2 = r1.length;
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L5;
        String icon = r1[r4];
        pw.println(icon);
        r4 = r4 + 1;
        goto L3
    L5:
        return 0;
    }

    private int runDisableForSetup() {
        String arg = getNextArgRequired();
        String pkg = this.mContext.getPackageName();
        boolean disable = Boolean.parseBoolean(arg);
        if (disable == false) goto L5;
        this.mInterface.disable(61145088, sToken, pkg);
        this.mInterface.disable2(0, sToken, pkg);
    L6:
        return 0;
    L5:
        this.mInterface.disable(0, sToken, pkg);
        this.mInterface.disable2(0, sToken, pkg);
        goto L6
    }

    private int runSendDisableFlag() {
        String pkg = this.mContext.getPackageName();
        StatusBarManager.DisableInfo info = new StatusBarManager.DisableInfo();
        String arg = getNextArg();
    L3:
        byte r5 = 0;
        if (arg == null) goto L48;
        switch(arg.hashCode()) {
            case -1786496516: goto L33;
            case -906336856: goto L30;
            case -755976775: goto L27;
            case -246254589: goto L24;
            case 3208415: goto L21;
            case 94755854: goto L18;
            case 1011652819: goto L15;
            case 1082295672: goto L12;
            case 1368216504: goto L9;
            default: goto L35;
        };
    L35:
        r5 = -1;
    L36:
        switch(r5) {
            case 0: goto L46;
            case 1: goto L45;
            case 2: goto L44;
            case 3: goto L43;
            case 4: goto L42;
            case 5: goto L41;
            case 6: goto L40;
            case 7: goto L39;
            case 8: goto L38;
            default: goto L47;
        };
    L38:
        info.setQuickSettingsDisabled(true);
        goto L47
    L39:
        info.setNotificationIconsDisabled(true);
        goto L47
    L40:
        info.setClockDisabled(true);
        goto L47
    L41:
        info.setSystemIconsDisabled(true);
        goto L47
    L42:
        info.setStatusBarExpansionDisabled(true);
        goto L47
    L43:
        info.setNotificationPeekingDisabled(true);
        goto L47
    L44:
        info.setRecentsDisabled(true);
        goto L47
    L45:
        info.setNagivationHomeDisabled(true);
        goto L47
    L46:
        info.setSearchDisabled(true);
    L47:
        arg = getNextArg();
        goto L3
    L9:
        if (arg.equals("notification-icons") == false) goto L35;
        r5 = 7;
        goto L36
    L12:
        if (arg.equals(ActivityTaskManagerService.DUMP_RECENTS_CMD) == false) goto L35;
        r5 = 2;
        goto L36
    L15:
        if (arg.equals("statusbar-expansion") == false) goto L35;
        r5 = 4;
        goto L36
    L18:
        if (arg.equals("clock") == false) goto L35;
        r5 = 6;
        goto L36
    L21:
        if (arg.equals("home") == false) goto L35;
        r5 = 1;
        goto L36
    L24:
        if (arg.equals("quick-settings") == false) goto L35;
        r5 = 8;
        goto L36
    L27:
        if (arg.equals("notification-alerts") == false) goto L35;
        r5 = 3;
        goto L36
    L30:
        if (arg.equals("search") == false) goto L35;
    L33:
        if (arg.equals("system-icons") == false) goto L35;
        r5 = 5;
        goto L36
    L48:
        Pair<Integer, Integer> flagPair = info.toFlags();
        this.mInterface.disable(((Integer) flagPair.first).intValue(), sToken, pkg);
        this.mInterface.disable2(((Integer) flagPair.second).intValue(), sToken, pkg);
        return 0;
    }

    private int runPassArgsToStatusBar() {
        this.mInterface.passThroughShellCommand(getAllArgs(), getOutFileDescriptor());
        return 0;
    }

    private int runTracing() {
        String r0 = getNextArg();
        switch(r0.hashCode()) {
            case 3540994: goto L9;
            case 109757538: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L15;
            case 1: goto L14;
            default: goto L16;
        };
    L14:
        this.mInterface.stopTracing();
        goto L16
    L15:
        this.mInterface.startTracing();
    L16:
        return 0;
    L6:
        if (r0.equals(IMediaProjectionManagerServiceExt.NODE_START) == false) goto L11;
        r1 = 0;
        goto L12
    L9:
        if (r0.equals(IMediaProjectionManagerServiceExt.NODE_STOP) == false) goto L11;
        r1 = 1;
        goto L12
    }

    private int runGc() {
        this.mInterface.runGcForTest();
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Status bar commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  expand-notifications");
        pw.println("    Open the notifications panel.");
        pw.println("");
        pw.println("  expand-settings");
        pw.println("    Open the notifications panel and expand quick settings if present.");
        pw.println("");
        pw.println("  collapse");
        pw.println("    Collapse the notifications and settings panel.");
        pw.println("");
        pw.println("  add-tile COMPONENT");
        pw.println("    Add a TileService of the specified component");
        pw.println("");
        pw.println("  remove-tile COMPONENT");
        pw.println("    Remove a TileService of the specified component");
        pw.println("");
        pw.println("  set-tiles LIST-OF-TILES");
        pw.println("    Sets the list of tiles as the current Quick Settings tiles");
        pw.println("");
        pw.println("  click-tile COMPONENT");
        pw.println("    Click on a TileService of the specified component");
        pw.println("");
        pw.println("  check-support");
        pw.println("    Check if this device supports QS + APIs");
        pw.println("");
        pw.println("  get-status-icons");
        pw.println("    Print the list of status bar icons and the order they appear in");
        pw.println("");
        pw.println("  disable-for-setup DISABLE");
        pw.println("    If true, disable status bar components unsuitable for device setup");
        pw.println("");
        pw.println("  send-disable-flag FLAG...");
        pw.println("    Send zero or more disable flags (parsed individually) to StatusBarManager");
        pw.println("    Valid options:");
        pw.println("        <blank>             - equivalent to \"none\"");
        pw.println("        none                - re-enables all components");
        pw.println("        search              - disable search");
        pw.println("        home                - disable naviagation home");
        pw.println("        recents             - disable recents/overview");
        pw.println("        notification-peek   - disable notification peeking");
        pw.println("        statusbar-expansion - disable status bar expansion");
        pw.println("        system-icons        - disable system icons appearing in status bar");
        pw.println("        clock               - disable clock appearing in status bar");
        pw.println("        notification-icons  - disable notification icons from status bar");
        pw.println("        quick-settings      - disable Quick Settings");
        pw.println("");
        pw.println("  tracing (start | stop)");
        pw.println("    Start or stop SystemUI tracing");
        pw.println("");
        pw.println("  NOTE: any command not listed here will be passed through to IStatusBar");
        pw.println("");
        pw.println("  Commands implemented in SystemUI:");
        pw.flush();
        this.mInterface.passThroughShellCommand(new String[0], getOutFileDescriptor());
    }
}
