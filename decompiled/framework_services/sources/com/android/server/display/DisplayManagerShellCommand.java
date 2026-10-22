package com.android.server.display;

import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.ShellCommand;
import android.util.Slog;
import android.view.Display;
import com.android.server.display.feature.DisplayManagerFlags;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
class DisplayManagerShellCommand extends ShellCommand {
    private static final String NOTIFICATION_TYPES = "on-hotplug-error, on-link-training-failure, on-cable-dp-incapable";
    private static final String TAG = "DisplayManagerShellCommand";
    private final DisplayManagerFlags mFlags;
    private final DisplayManagerService mService;

    /* JADX INFO: renamed from: $r8$lambda$-37GxgNP6jzlvD6iZNMa89gzUxQ, reason: not valid java name */
    public static /* synthetic */ boolean m3737$r8$lambda$37GxgNP6jzlvD6iZNMa89gzUxQ(List r0, Display r1) {
        return lambda$getDisplays$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$34gjrjKSt888m5B1uB5H-6iA5SA, reason: not valid java name */
    public static /* synthetic */ Display[] m3738$r8$lambda$34gjrjKSt888m5B1uB5H6iA5SA(int r0) {
        return lambda$getDisplays$1(r0);
    }

    DisplayManagerShellCommand(DisplayManagerService service, DisplayManagerFlags flags) {
        this.mService = service;
        this.mFlags = flags;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1505467592: goto L90;
            case -1459563384: goto L87;
            case -1226903944: goto L84;
            case -1021080420: goto L81;
            case -918407384: goto L78;
            case -840680372: goto L75;
            case -731435249: goto L72;
            case -687141135: goto L69;
            case -648863097: goto L66;
            case -601773083: goto L63;
            case -464562757: goto L60;
            case 3088947: goto L57;
            case 10139357: goto L54;
            case 276125397: goto L51;
            case 483509981: goto L48;
            case 844013735: goto L45;
            case 847215243: goto L42;
            case 1089842382: goto L39;
            case 1265268983: goto L36;
            case 1428935945: goto L33;
            case 1604823708: goto L30;
            case 1863255293: goto L27;
            case 1873686952: goto L24;
            case 1894268611: goto L21;
            case 1928353192: goto L18;
            case 1976222800: goto L15;
            case 2076592732: goto L12;
            case 2081245916: goto L9;
            default: goto L92;
        };
    L92:
        byte r1 = -1;
    L93:
        switch(r1) {
            case 0: goto L151;
            case 1: goto L149;
            case 2: goto L147;
            case 3: goto L145;
            case 4: goto L143;
            case 5: goto L141;
            case 6: goto L139;
            case 7: goto L137;
            case 8: goto L135;
            case 9: goto L133;
            case 10: goto L131;
            case 11: goto L129;
            case 12: goto L127;
            case 13: goto L125;
            case 14: goto L123;
            case 15: goto L121;
            case 16: goto L119;
            case 17: goto L117;
            case 18: goto L115;
            case 19: goto L113;
            case 20: goto L111;
            case 21: goto L109;
            case 22: goto L107;
            case 23: goto L105;
            case 24: goto L103;
            case 25: goto L101;
            case 26: goto L99;
            case 27: goto L97;
            default: goto L95;
        };
    L95:
        return handleDefaultCommands(cmd);
    L97:
        return overrideMaxImportanceForRRCallbacks();
    L99:
        return requestDisplayPower(1);
    L101:
        return requestDisplayPower(0);
    L103:
        return setDisplayEnabled(false);
    L105:
        return setDisplayEnabled(true);
    L107:
        return unsetDockedAndIdle();
    L109:
        return setDockedAndIdle();
    L111:
        return getDisplays();
    L113:
        return getUserDisabledHdrTypes();
    L115:
        return setUserDisabledHdrTypes();
    L117:
        return getMatchContentFrameRateUserPreference();
    L119:
        return setMatchContentFrameRateUserPreference();
    L121:
        return getActiveDisplayModeAtStart();
    L123:
        return getUserPreferredDisplayMode();
    L125:
        return clearUserPreferredDisplayMode();
    L127:
        return setUserPreferredDisplayMode();
    L129:
        return setAmbientColorTemperatureOverride();
    L131:
        return setDisplayModeDirectorLoggingEnabled(false);
    L133:
        return setDisplayModeDirectorLoggingEnabled(true);
    L135:
        return setDisplayWhiteBalanceLoggingEnabled(false);
    L137:
        return setDisplayWhiteBalanceLoggingEnabled(true);
    L139:
        return setAutoBrightnessLoggingEnabled(false);
    L141:
        return setAutoBrightnessLoggingEnabled(true);
    L143:
        return resetBrightnessConfiguration();
    L145:
        return setBrightness();
    L147:
        return getBrightness();
    L149:
        return cancelNotifications();
    L151:
        return showNotification();
    L9:
        if (cmd.equals("dwb-logging-disable") == false) goto L92;
        r1 = 8;
        goto L93
    L12:
        if (cmd.equals("clear-user-preferred-display-mode") == false) goto L92;
        r1 = 13;
        goto L93
    L15:
        if (cmd.equals("override-max-importance-rr-callbacks") == false) goto L92;
        r1 = ParameterName.LEVEL_RANGE;
        goto L93
    L18:
        if (cmd.equals("set-user-disabled-hdr-types") == false) goto L92;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L93
    L21:
        if (cmd.equals("dmd-logging-enable") == false) goto L92;
        r1 = 9;
        goto L93
    L24:
        if (cmd.equals("dmd-logging-disable") == false) goto L92;
        r1 = 10;
        goto L93
    L27:
        if (cmd.equals("get-match-content-frame-rate-pref") == false) goto L92;
        r1 = ParameterName.DE_CONTOUR;
        goto L93
    L30:
        if (cmd.equals("set-brightness") == false) goto L92;
        r1 = 3;
        goto L93
    L33:
        if (cmd.equals("set-match-content-frame-rate-pref") == false) goto L92;
        r1 = 16;
        goto L93
    L36:
        if (cmd.equals("get-active-display-mode-at-start") == false) goto L92;
        r1 = 15;
        goto L93
    L39:
        if (cmd.equals("ab-logging-disable") == false) goto L92;
        r1 = 6;
        goto L93
    L42:
        if (cmd.equals("dwb-set-cct") == false) goto L92;
        r1 = 11;
        goto L93
    L45:
        if (cmd.equals("power-off") == false) goto L92;
        r1 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L93
    L48:
        if (cmd.equals("ab-logging-enable") == false) goto L92;
        r1 = 5;
        goto L93
    L51:
        if (cmd.equals("cancel-notifications") == false) goto L92;
        r1 = 1;
        goto L93
    L54:
        if (cmd.equals("disable-display") == false) goto L92;
        r1 = ParameterName.GLOBE_DIMMING;
        goto L93
    L57:
        if (cmd.equals("dock") == false) goto L92;
        r1 = ParameterName.BLUE_STRETCH;
        goto L93
    L60:
        if (cmd.equals("show-notification") == false) goto L92;
        r1 = 0;
        goto L93
    L63:
        if (cmd.equals("get-user-preferred-display-mode") == false) goto L92;
        r1 = 14;
        goto L93
    L66:
        if (cmd.equals("power-reset") == false) goto L92;
        r1 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L93
    L69:
        if (cmd.equals("set-user-preferred-display-mode") == false) goto L92;
        r1 = 12;
        goto L93
    L72:
        if (cmd.equals("dwb-logging-enable") == false) goto L92;
        r1 = 7;
        goto L93
    L75:
        if (cmd.equals("undock") == false) goto L92;
        r1 = ParameterName.COLOR_TUNE;
        goto L93
    L78:
        if (cmd.equals("get-brightness") == false) goto L92;
        r1 = 2;
        goto L93
    L81:
        if (cmd.equals("get-user-disabled-hdr-types") == false) goto L92;
        r1 = ParameterName.FILM_MODE;
        goto L93
    L84:
        if (cmd.equals("enable-display") == false) goto L92;
        r1 = ParameterName.COLOR_TEMPERATURE;
        goto L93
    L87:
        if (cmd.equals("get-displays") == false) goto L92;
        r1 = ParameterName.BLACK_STRETCH;
        goto L93
    L90:
        if (cmd.equals("reset-brightness-configuration") == false) goto L92;
        r1 = 4;
        goto L93
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Display manager commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  show-notification NOTIFICATION_TYPE");
        pw.println("    Show notification for one of the following types: on-hotplug-error, on-link-training-failure, on-cable-dp-incapable");
        pw.println("  cancel-notifications");
        pw.println("    Cancel notifications.");
        pw.println("  set-brightness BRIGHTNESS");
        pw.println("    Sets the current brightness to BRIGHTNESS (a number between 0 and 1).");
        pw.println("  reset-brightness-configuration");
        pw.println("    Reset the brightness to its default configuration.");
        pw.println("  ab-logging-enable");
        pw.println("    Enable auto-brightness logging.");
        pw.println("  ab-logging-disable");
        pw.println("    Disable auto-brightness logging.");
        pw.println("  dwb-logging-enable");
        pw.println("    Enable display white-balance logging.");
        pw.println("  dwb-logging-disable");
        pw.println("    Disable display white-balance logging.");
        pw.println("  dmd-logging-enable");
        pw.println("    Enable display mode director logging.");
        pw.println("  dmd-logging-disable");
        pw.println("    Disable display mode director logging.");
        pw.println("  dwb-set-cct CCT");
        pw.println("    Sets the ambient color temperature override to CCT (use -1 to disable).");
        pw.println("  set-user-preferred-display-mode WIDTH HEIGHT REFRESH-RATE DISPLAY_ID (optional)");
        pw.println("    Sets the user preferred display mode which has fields WIDTH, HEIGHT and REFRESH-RATE. If DISPLAY_ID is passed, the mode change is applied to displaywith id = DISPLAY_ID, else mode change is applied globally.");
        pw.println("  clear-user-preferred-display-mode DISPLAY_ID (optional)");
        pw.println("    Clears the user preferred display mode. If DISPLAY_ID is passed, the mode is cleared for  display with id = DISPLAY_ID, else mode is cleared globally.");
        pw.println("  get-user-preferred-display-mode DISPLAY_ID (optional)");
        pw.println("    Returns the user preferred display mode or null if no mode is set by user.If DISPLAY_ID is passed, the mode for display with id = DISPLAY_ID is returned, else global display mode is returned.");
        pw.println("  get-active-display-mode-at-start DISPLAY_ID");
        pw.println("    Returns the display mode which was found at boot time of display with id = DISPLAY_ID");
        pw.println("  set-match-content-frame-rate-pref PREFERENCE");
        pw.println("    Sets the match content frame rate preference as PREFERENCE ");
        pw.println("  get-match-content-frame-rate-pref");
        pw.println("    Returns the match content frame rate preference");
        pw.println("  set-user-disabled-hdr-types TYPES...");
        pw.println("    Sets the user disabled HDR types as TYPES");
        pw.println("  get-user-disabled-hdr-types");
        pw.println("    Returns the user disabled HDR types");
        pw.println("  get-displays [-c|--category CATEGORY] [-i|--ids-only] [-t|--type TYPE]");
        pw.println("    [CATEGORY]");
        pw.println("    Returns the current displays. Can specify string category among");
        pw.println("    DisplayManager.DISPLAY_CATEGORY_*; must use the actual string value.");
        pw.println("    Can choose to print only the ids of the displays. Can filter by");
        pw.println("    display types. For example, '--type external'");
        pw.println("  dock");
        pw.println("    Sets brightness to docked + idle screen brightness mode");
        pw.println("  undock");
        pw.println("    Sets brightness to active (normal) screen brightness mode");
        pw.println("  enable-display DISPLAY_ID");
        pw.println("    Enable the DISPLAY_ID. Only possible if this is a connected display.");
        pw.println("  disable-display DISPLAY_ID");
        pw.println("    Disable the DISPLAY_ID. Only possible if this is a connected display.");
        pw.println("  power-reset DISPLAY_ID");
        pw.println("    Turn the DISPLAY_ID power to a state the display supposed to have.");
        pw.println("  power-off DISPLAY_ID");
        pw.println("    Turn the display DISPLAY_ID power off.");
        pw.println();
        Intent.printIntentArgsHelp(pw, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private int getDisplays() {
        String r1 = null;
        PrintWriter r2 = getOutPrintWriter();
        final ArrayList r3 = new ArrayList();
        boolean r4 = false;
        boolean r5 = false;
    L3:
        String r6 = getNextOption();
        byte r7 = 0;
        if (r6 == null) goto L44;
        switch(r6.hashCode()) {
            case 0: goto L27;
            case 1494: goto L24;
            case 1500: goto L21;
            case 1511: goto L18;
            case 66265758: goto L15;
            case 220627777: goto L12;
            case 1333445850: goto L9;
            default: goto L29;
        };
    L29:
        r7 = -1;
    L30:
        switch(r7) {
            case 0: goto L42;
            case 1: goto L42;
            case 2: goto L38;
            case 3: goto L38;
            case 4: goto L34;
            case 5: goto L34;
            case 6: goto L3;
            default: goto L31;
        };
    L31:
        r2.println("Error: unknown option '" + r6 + "'");
        return 1;
    L34:
        if (r1 != null) goto L35;
        r1 = getNextArgRequired();
        goto L3
    L35:
        r2.println("Error: the category has been specified more than one time. Please select only one category.");
        return 1;
    L38:
        int r8 = getType(getNextArgRequired(), r2);
        if (r8 == (-1)) goto L40;
        r3.add(Integer.valueOf(r8));
        r5 = true;
        goto L3
    L40:
        return 1;
    L42:
        r4 = true;
        goto L3
    L9:
        if (r6.equals("--type") == false) goto L79;
        r7 = 3;
        goto L30
    L79:
        r7 = -1;
        goto L30
    L12:
        if (r6.equals("--ids-only") == false) goto L80;
        r7 = 1;
        goto L30
    L80:
        r7 = -1;
        goto L30
    L15:
        if (r6.equals("--category") == false) goto L81;
        r7 = 5;
        goto L30
    L81:
        r7 = -1;
        goto L30
    L18:
        if (r6.equals("-t") == false) goto L82;
        r7 = 2;
        goto L30
    L82:
        r7 = -1;
        goto L30
    L21:
        if (r6.equals("-i") == true) goto L30;
        r7 = -1;
        goto L30
    L24:
        if (r6.equals("-c") == false) goto L84;
        r7 = 4;
        goto L30
    L84:
        r7 = -1;
        goto L30
    L27:
        if (r6.equals("") == false) goto L85;
        r7 = 6;
        goto L30
    L85:
        r7 = -1;
        goto L30
    L44:
        String r9 = getNextArg();
        if (r9 == null) goto L50;
        if (r1 == null) goto L49;
        r2.println("Error: the category has been specified both with the -c option and the positional argument. Please select only one category.");
        return 1;
    L49:
        r1 = r9;
    L50:
        Display[] r10 = ((DisplayManager) this.mService.getContext().getSystemService(DisplayManager.class)).getDisplays(r1);
        Object[] r11 = r10;
        if (r5 == false) goto L53;
        r11 = (Display[]) Arrays.stream(r10).filter(new DisplayManagerShellCommand$$ExternalSyntheticLambda0(r3)).toArray(new DisplayManagerShellCommand$$ExternalSyntheticLambda1());
    L53:
        if (r4 == true) goto L55;
        r2.println("Displays:");
    L55:
        int r12 = 0;
    L57:
        if (r12 >= r11.length) goto L63;
        if (r4 == false) goto L60;
        Object r13 = Integer.valueOf(r11[r12].getDisplayId());
    L61:
        r2.println(r13);
        r12 = r12 + 1;
        goto L57
    L60:
        r13 = r11[r12];
        goto L61
    L63:
        return 0;
    }

    private static /* synthetic */ boolean lambda$getDisplays$0(List displayTypeList, Display d) {
        return displayTypeList.contains(Integer.valueOf(d.getType()));
    }

    private static /* synthetic */ Display[] lambda$getDisplays$1(int x$0) {
        return new Display[x$0];
    }

    private int getType(String type, PrintWriter out) {
        String type2 = type.toUpperCase(Locale.ENGLISH);
        switch(type2.hashCode()) {
            case -1038134325: goto L21;
            case -373305296: goto L18;
            case 2664213: goto L15;
            case 433141802: goto L12;
            case 1184148203: goto L9;
            case 1353037501: goto L6;
            default: goto L23;
        };
    L23:
        byte r0 = -1;
    L24:
        switch(r0) {
            case 0: goto L32;
            case 1: goto L31;
            case 2: goto L30;
            case 3: goto L29;
            case 4: goto L28;
            case 5: goto L27;
            default: goto L25;
        };
    L25:
        out.println("Error: argument for display type should be one of 'UNKNOWN', 'INTERNAL', 'EXTERNAL', 'WIFI', 'OVERLAY', 'VIRTUAL', but got '" + type2 + "' instead.");
        return -1;
    L27:
        return 5;
    L28:
        return 4;
    L29:
        return 3;
    L30:
        return 2;
    L31:
        return 1;
    L32:
        return 0;
    L6:
        if (type2.equals("INTERNAL") == false) goto L33;
        r0 = 1;
        goto L24
    L33:
        r0 = -1;
        goto L24
    L9:
        if (type2.equals("VIRTUAL") == false) goto L34;
        r0 = 5;
        goto L24
    L34:
        r0 = -1;
        goto L24
    L12:
        if (type2.equals("UNKNOWN") == false) goto L35;
        r0 = 0;
        goto L24
    L35:
        r0 = -1;
        goto L24
    L15:
        if (type2.equals("WIFI") == false) goto L36;
        r0 = 3;
        goto L24
    L36:
        r0 = -1;
        goto L24
    L18:
        if (type2.equals("OVERLAY") == false) goto L37;
        r0 = 4;
        goto L24
    L37:
        r0 = -1;
        goto L24
    L21:
        if (type2.equals("EXTERNAL") == false) goto L38;
        r0 = 2;
        goto L24
    L38:
        r0 = -1;
        goto L24
    }

    private int showNotification() {
        String notificationType = getNextArg();
        if (notificationType != null) goto L7;
        getErrPrintWriter().println("Error: no notificationType specified, use one of: on-hotplug-error, on-link-training-failure, on-cable-dp-incapable");
        return 1;
    L7:
        switch(notificationType.hashCode()) {
            case -1348657756: goto L16;
            case 1400911272: goto L13;
            case 1997686684: goto L10;
            default: goto L18;
        };
    L18:
        byte r2 = -1;
    L19:
        switch(r2) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            default: goto L20;
        };
    L20:
        getErrPrintWriter().println("Error: unexpected notification type=" + notificationType + ", use one of: " + NOTIFICATION_TYPES);
        return 1;
    L22:
        this.mService.getDisplayNotificationManager().onCableNotCapableDisplayPort();
    L25:
        return 0;
    L23:
        this.mService.getDisplayNotificationManager().onDisplayPortLinkTrainingFailure();
        goto L25
    L24:
        this.mService.getDisplayNotificationManager().onHotplugConnectionError();
        goto L25
    L10:
        if (notificationType.equals("on-link-training-failure") == false) goto L18;
        r2 = 1;
        goto L19
    L13:
        if (notificationType.equals("on-hotplug-error") == false) goto L18;
        r2 = 0;
        goto L19
    L16:
        if (notificationType.equals("on-cable-dp-incapable") == false) goto L18;
        r2 = 2;
        goto L19
    }

    private int cancelNotifications() {
        this.mService.getDisplayNotificationManager().cancelNotifications();
        return 0;
    }

    private int getBrightness() {
        String displayIdString = getNextArg();
        if (displayIdString != null) goto L12;
        getErrPrintWriter().println("Error: no display id specified");
        return 1;
    L12:
        int displayId = Integer.parseInt(displayIdString);     // Catch: NumberFormatException -> L9
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        getOutPrintWriter().println(dm.getBrightness(displayId));
        return 0;
    L10:
        getErrPrintWriter().println("Error: invalid displayId=" + displayIdString + " not int");
        return 1;
    }

    private int setBrightness() {
        String brightnessText = getNextArg();
        if (brightnessText != null) goto L6;
        getErrPrintWriter().println("Error: no brightness specified");
        return 1;
    L6:
        float brightness = -1.0f;
        brightness = Float.parseFloat(brightnessText);     // Catch: NumberFormatException -> L9
    L11:
        if (brightness >= 0.0f) goto L13;
    L17:
        getErrPrintWriter().println("Error: brightness should be a number between 0 and 1");
        return 1;
    L13:
        if (brightness > 1.0f) goto L17;
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        dm.setBrightness(0, brightness);
        return 0;
    }

    private int resetBrightnessConfiguration() {
        this.mService.resetBrightnessConfigurations();
        return 0;
    }

    private int setAutoBrightnessLoggingEnabled(boolean enabled) {
        this.mService.setAutoBrightnessLoggingEnabled(enabled);
        return 0;
    }

    private int setDisplayWhiteBalanceLoggingEnabled(boolean enabled) {
        this.mService.setDisplayWhiteBalanceLoggingEnabled(enabled);
        return 0;
    }

    private int setDisplayModeDirectorLoggingEnabled(boolean enabled) {
        this.mService.setDisplayModeDirectorLoggingEnabled(enabled);
        return 0;
    }

    private int setAmbientColorTemperatureOverride() {
        String cctText = getNextArg();
        if (cctText != null) goto L12;
        getErrPrintWriter().println("Error: no cct specified");
        return 1;
    L12:
        float cct = Float.parseFloat(cctText);     // Catch: NumberFormatException -> L9
        this.mService.setAmbientColorTemperatureOverride(cct);
        return 0;
    L10:
        getErrPrintWriter().println("Error: cct should be a number");
        return 1;
    }

    private int setUserPreferredDisplayMode() {
        String widthText = getNextArg();
        if (widthText != null) goto L6;
        getErrPrintWriter().println("Error: no width specified");
        return 1;
    L6:
        String heightText = getNextArg();
        if (heightText != null) goto L10;
        getErrPrintWriter().println("Error: no height specified");
        return 1;
    L10:
        String refreshRateText = getNextArg();
        if (refreshRateText != null) goto L33;
        getErrPrintWriter().println("Error: no refresh-rate specified");
        return 1;
    L33:
        int width = Integer.parseInt(widthText);     // Catch: NumberFormatException -> L30
        int height = Integer.parseInt(heightText);     // Catch: NumberFormatException -> L30
        float refreshRate = Float.parseFloat(refreshRateText);     // Catch: NumberFormatException -> L30
        if (width < 0) goto L18;
        if (height < 0) goto L18;
    L21:
        String displayIdText = getNextArg();
        int displayId = -1;
        if (displayIdText != null) goto L35;
    L28:
        this.mService.setUserPreferredDisplayModeInternal(displayId, new Display.Mode(width, height, refreshRate));
        return 0;
    L35:
        displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L25
    L26:
        getErrPrintWriter().println("Error: invalid format of display ID");
        return 1;
    L18:
        if (refreshRate > 0.0f) goto L21;
        getErrPrintWriter().println("Error: invalid value of resolution (width, height) and refresh rate");
        return 1;
    L31:
        getErrPrintWriter().println("Error: invalid format of width, height or refresh rate");
        return 1;
    }

    private int clearUserPreferredDisplayMode() {
        String displayIdText = getNextArg();
        int displayId = -1;
        if (displayIdText != null) goto L11;
    L9:
        this.mService.setUserPreferredDisplayModeInternal(displayId, null);
        return 0;
    L11:
        displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L6
    L7:
        getErrPrintWriter().println("Error: invalid format of display ID");
        return 1;
    }

    private int getUserPreferredDisplayMode() {
        String displayIdText = getNextArg();
        int displayId = -1;
        if (displayIdText != null) goto L15;
    L9:
        Display.Mode mode = this.mService.getUserPreferredDisplayModeInternal(displayId);
        if (mode != null) goto L13;
        getOutPrintWriter().println("User preferred display mode: null");
        return 0;
    L13:
        getOutPrintWriter().println("User preferred display mode: " + mode.getPhysicalWidth() + " " + mode.getPhysicalHeight() + " " + mode.getRefreshRate());
        return 0;
    L15:
        displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L6
    L7:
        getErrPrintWriter().println("Error: invalid format of display ID");
        return 1;
    }

    private int getActiveDisplayModeAtStart() {
        String displayIdText = getNextArg();
        if (displayIdText != null) goto L16;
        getErrPrintWriter().println("Error: no displayId specified");
        return 1;
    L16:
        int displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L13
        Display.Mode mode = this.mService.getActiveDisplayModeAtStart(displayId);
        if (mode != null) goto L11;
        getOutPrintWriter().println("Boot display mode: null");
        return 0;
    L11:
        getOutPrintWriter().println("Boot display mode: " + mode.getPhysicalWidth() + " " + mode.getPhysicalHeight() + " " + mode.getRefreshRate());
        return 0;
    L14:
        getErrPrintWriter().println("Error: invalid displayId");
        return 1;
    }

    private int setMatchContentFrameRateUserPreference() {
        String matchContentFrameRatePrefText = getNextArg();
        if (matchContentFrameRatePrefText != null) goto L15;
        getErrPrintWriter().println("Error: no matchContentFrameRatePref specified");
        return 1;
    L15:
        int matchContentFrameRatePreference = Integer.parseInt(matchContentFrameRatePrefText);     // Catch: NumberFormatException -> L12
        if (matchContentFrameRatePreference >= 0) goto L10;
        getErrPrintWriter().println("Error: invalid value of matchContentFrameRatePreference");
        return 1;
    L10:
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        int refreshRateSwitchingType = toRefreshRateSwitchingType(matchContentFrameRatePreference);
        dm.setRefreshRateSwitchingType(refreshRateSwitchingType);
        return 0;
    L13:
        getErrPrintWriter().println("Error: invalid format of matchContentFrameRatePreference");
        return 1;
    }

    private int getMatchContentFrameRateUserPreference() {
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        getOutPrintWriter().println("Match content frame rate type: " + dm.getMatchContentFrameRateUserPreference());
        return 0;
    }

    private int setUserDisabledHdrTypes() {
        String[] userDisabledHdrTypesText = peekRemainingArgs();
        if (userDisabledHdrTypesText != null) goto L6;
        getErrPrintWriter().println("Error: no userDisabledHdrTypes specified");
        return 1;
    L6:
        int[] userDisabledHdrTypes = new int[userDisabledHdrTypesText.length];
        int index = 0;
        int r4 = userDisabledHdrTypesText.length;     // Catch: NumberFormatException -> L11
        int r6 = 0;
    L8:
        if (r6 >= r4) goto L13;
        String userDisabledHdrType = userDisabledHdrTypesText[r6];     // Catch: NumberFormatException -> L11
        int index2 = index + 1;     // Catch: NumberFormatException -> L11
        userDisabledHdrTypes[index] = Integer.parseInt(userDisabledHdrType);     // Catch: NumberFormatException -> L11
        r6 = r6 + 1;
        index = index2;
        goto L8
    L13:
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        dm.setUserDisabledHdrTypes(userDisabledHdrTypes);
        return 0;
    L15:
        getErrPrintWriter().println("Error: invalid format of userDisabledHdrTypes");
        return 1;
    }

    private int getUserDisabledHdrTypes() {
        Context context = this.mService.getContext();
        DisplayManager dm = (DisplayManager) context.getSystemService(DisplayManager.class);
        int[] userDisabledHdrTypes = dm.getUserDisabledHdrTypes();
        getOutPrintWriter().println("User disabled HDR types: " + Arrays.toString(userDisabledHdrTypes));
        return 0;
    }

    private int toRefreshRateSwitchingType(int matchContentFrameRateType) {
        switch(matchContentFrameRateType) {
            case 0: goto L9;
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        Slog.e(TAG, matchContentFrameRateType + " is not a valid value of matchContentFrameRate type.");
        return -1;
    L5:
        return 2;
    L7:
        return 1;
    L9:
        return 0;
    }

    private int setDockedAndIdle() {
        this.mService.setDockedAndIdleEnabled(true, 0);
        return 0;
    }

    private int unsetDockedAndIdle() {
        this.mService.setDockedAndIdleEnabled(false, 0);
        return 0;
    }

    private int setDisplayEnabled(boolean enable) {
        String displayIdText = getNextArg();
        if (displayIdText != null) goto L12;
        getErrPrintWriter().println("Error: no displayId specified");
        return 1;
    L12:
        int displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L9
        this.mService.enableConnectedDisplay(displayId, enable);
        return 0;
    L10:
        getErrPrintWriter().println("Error: invalid displayId: '" + displayIdText + "'");
        return 1;
    }

    private int requestDisplayPower(int state) {
        String displayIdText = getNextArg();
        if (displayIdText != null) goto L12;
        getErrPrintWriter().println("Error: no displayId specified");
        return 1;
    L12:
        int displayId = Integer.parseInt(displayIdText);     // Catch: NumberFormatException -> L9
        this.mService.requestDisplayPower(displayId, state);
        return 0;
    L10:
        getErrPrintWriter().println("Error: invalid displayId: '" + displayIdText + "'");
        return 1;
    }

    private int overrideMaxImportanceForRRCallbacks() {
        String importanceString = getNextArg();
        if (importanceString != null) goto L12;
        getErrPrintWriter().println("Error: no importance specified");
        return 1;
    L12:
        int importance = Integer.parseInt(importanceString);     // Catch: NumberFormatException -> L9
        this.mService.overrideMaxImportanceForRRCallbacks(importance);
        return 0;
    L10:
        getErrPrintWriter().println("Error: invalid importance: '" + importanceString + "'");
        return 1;
    }
}
