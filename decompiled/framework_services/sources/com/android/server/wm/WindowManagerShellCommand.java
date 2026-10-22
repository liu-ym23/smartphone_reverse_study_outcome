package com.android.server.wm;

import android.R;
import android.app.WindowConfiguration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.tv.mediaquality.ParameterName;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.provider.Settings;
import android.util.Pair;
import android.util.TypedValue;
import android.view.CrossWindowBlurListeners;
import android.view.IWindow;
import android.view.IWindowManager;
import com.android.internal.os.ByteTransferPipe;
import com.android.internal.protolog.LegacyProtoLogImpl;
import com.android.internal.protolog.PerfettoProtoLogImpl;
import com.android.internal.protolog.ProtoLogImpl_798997914;
import com.android.server.IoThread;
import com.android.server.UiModeManagerService;
import com.android.server.companion.association.DisassociationProcessor;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* JADX INFO: loaded from: classes3.dex */
public class WindowManagerShellCommand extends ShellCommand {
    private final AppCompatConfiguration mAppCompatConfiguration;
    private final IWindowManager mInterface;
    private final WindowManagerService mInternal;

    public static /* synthetic */ void $r8$lambda$T3ugGYAx3t3aCVayEDwrhYnPYYQ(WindowManagerShellCommand r0, IWindow r1, ParcelFileDescriptor r2) {
        r0.lambda$dumpLocalWindowAsync$0(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$aS8nxT7ZSVg7suqFh6mOPqGsSSc(WindowManagerShellCommand r0, int r1, ArrayList r2, WindowState r3) {
        r0.lambda$runDumpVisibleWindowViews$1(r1, r2, r3);
    }

    public WindowManagerShellCommand(WindowManagerService service) {
        this.mInterface = service;
        this.mInternal = service;
        this.mAppCompatConfiguration = service.mAppCompatConfiguration;
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
            case -2001980078: goto L87;
            case -1959253708: goto L84;
            case -1829173266: goto L81;
            case -1693379742: goto L78;
            case -1067396926: goto L75;
            case -1032601556: goto L72;
            case -1014709755: goto L69;
            case -336752166: goto L66;
            case -244218528: goto L63;
            case -229462135: goto L60;
            case 3530753: goto L57;
            case 93018176: goto L54;
            case 108404047: goto L51;
            case 109403696: goto L48;
            case 128019156: goto L45;
            case 188660544: goto L42;
            case 342281055: goto L39;
            case 344144277: goto L36;
            case 670914375: goto L33;
            case 731885899: goto L30;
            case 749259358: goto L27;
            case 1336606893: goto L24;
            case 1469811604: goto L21;
            case 1552717032: goto L18;
            case 1583955111: goto L15;
            case 1910897543: goto L10;
            default: goto L89;
        };     // Catch: RemoteException -> L12
    L89:
        byte r2 = -1;
    L90:
        switch(r2) {
            case 0: goto L155;
            case 1: goto L153;
            case 2: goto L151;
            case 3: goto L149;
            case 4: goto L147;
            case 5: goto L145;
            case 6: goto L131;
            case 7: goto L130;
            case 8: goto L128;
            case 9: goto L126;
            case 10: goto L124;
            case 11: goto L122;
            case 12: goto L120;
            case 13: goto L118;
            case 14: goto L116;
            case 15: goto L114;
            case 16: goto L112;
            case 17: goto L110;
            case 18: goto L108;
            case 19: goto L106;
            case 20: goto L104;
            case 21: goto L102;
            case 22: goto L100;
            case 23: goto L98;
            case 24: goto L96;
            case 25: goto L94;
            default: goto L92;
        };     // Catch: RemoteException -> L12
    L131:
        LegacyProtoLogImpl r3 = ProtoLogImpl_798997914.getSingleInstance();     // Catch: RemoteException -> L12
        if ((r3 instanceof LegacyProtoLogImpl) == true) goto L138;
        if ((r3 instanceof PerfettoProtoLogImpl) == true) goto L138;
        pw.println("ProtoLog impl doesn't support handling commands");     // Catch: RemoteException -> L12
        return -1;
    L138:
        if ((r3 instanceof LegacyProtoLogImpl) == false) goto L140;
        int result = r3.onShellCommand(this);     // Catch: RemoteException -> L12
    L141:
        if (result == 0) goto L160;
        pw.println("Not handled, please use `adb shell dumpsys activity service SystemUIService WMShell` if you are looking for ProtoLog in WMShell");     // Catch: RemoteException -> L12
        return result;
    L160:
        return result;
    L140:
        result = ((PerfettoProtoLogImpl) r3).onShellCommand(this);     // Catch: RemoteException -> L12
        goto L141
    L92:
        return handleDefaultCommands(cmd);
    L94:
        return runDumpWmTrace();
    L96:
        return runWmShellCommand(pw);
    L98:
        return runGetDisplayWindowingMode(pw);
    L100:
        return runSetDisplayWindowingMode(pw);
    L102:
        return runResetFreezeRecentTaskListReordering(pw);
    L104:
        return runSetBlurDisabled(pw);
    L106:
        return runReset(pw);
    L108:
        return runResetMultiWindowConfig();
    L110:
        return runGetMultiWindowConfig(pw);
    L112:
        return runSetMultiWindowConfig();
    L114:
        return runSandboxDisplayApis(pw);
    L116:
        return runResetLetterboxStyle(pw);
    L118:
        return runGetLetterboxStyle(pw);
    L120:
        return runSetLetterboxStyle(pw);
    L122:
        return runDumpVisibleWindowViews(pw);
    L124:
        return runGetIgnoreOrientationRequest(pw);
    L126:
        return runSetIgnoreOrientationRequest(pw);
    L128:
        return runFixedToUserRotation(pw);
    L130:
        return runDisplayUserRotation(pw);
    L145:
        return this.mInternal.mWindowTracing.onShellCommand(this);
    L147:
        return runDismissKeyguard(pw);
    L149:
        return runDisplayScaling(pw);
    L151:
        return runDisplayFoldedArea(pw);
    L153:
        return runDisplayDensity(pw);
    L155:
        return runDisplaySize(pw);
    L10:
        if (cmd.equals("scaling") == false) goto L89;
        r2 = 3;
        goto L90
    L15:
        if (cmd.equals("fixed-to-user-rotation") == false) goto L89;
        r2 = 8;
        goto L90
    L18:
        if (cmd.equals("density") == false) goto L89;
        r2 = 1;
        goto L90
    L21:
        if (cmd.equals("reset-freeze-recent-tasks") == false) goto L89;
        r2 = ParameterName.BLUE_STRETCH;
        goto L90
    L24:
        if (cmd.equals("reset-multi-window-config") == false) goto L89;
        r2 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L90
    L27:
        if (cmd.equals("set-letterbox-style") == false) goto L89;
        r2 = 12;
        goto L90
    L30:
        if (cmd.equals("reset-letterbox-style") == false) goto L89;
        r2 = 14;
        goto L90
    L33:
        if (cmd.equals("dump-wm-trace") == false) goto L89;
        r2 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L90
    L36:
        if (cmd.equals("set-sandbox-display-apis") == false) goto L89;
        r2 = 15;
        goto L90
    L39:
        if (cmd.equals("logging") == false) goto L89;
        r2 = 6;
        goto L90
    L42:
        if (cmd.equals("user-rotation") == false) goto L89;
        r2 = 7;
        goto L90
    L45:
        if (cmd.equals("set-display-windowing-mode") == false) goto L89;
        r2 = ParameterName.COLOR_TUNE;
        goto L90
    L48:
        if (cmd.equals(DisassociationProcessor.REASON_SHELL) == false) goto L89;
        r2 = ParameterName.GLOBE_DIMMING;
        goto L90
    L51:
        if (cmd.equals("reset") == false) goto L89;
        r2 = ParameterName.FILM_MODE;
        goto L90
    L54:
        if (cmd.equals("set-multi-window-config") == false) goto L89;
        r2 = 16;
        goto L90
    L57:
        if (cmd.equals("size") == false) goto L89;
        r2 = 0;
        goto L90
    L60:
        if (cmd.equals("dismiss-keyguard") == false) goto L89;
        r2 = 4;
        goto L90
    L63:
        if (cmd.equals("get-display-windowing-mode") == false) goto L89;
        r2 = ParameterName.COLOR_TEMPERATURE;
        goto L90
    L66:
        if (cmd.equals("folded-area") == false) goto L89;
        r2 = 2;
        goto L90
    L69:
        if (cmd.equals("dump-visible-window-views") == false) goto L89;
        r2 = 11;
        goto L90
    L72:
        if (cmd.equals("disable-blur") == false) goto L89;
        r2 = ParameterName.BLACK_STRETCH;
        goto L90
    L75:
        if (cmd.equals("tracing") == false) goto L89;
        r2 = 5;
        goto L90
    L78:
        if (cmd.equals("set-ignore-orientation-request") == false) goto L89;
        r2 = 9;
        goto L90
    L81:
        if (cmd.equals("get-ignore-orientation-request") == false) goto L89;
        r2 = 10;
        goto L90
    L84:
        if (cmd.equals("get-multi-window-config") == false) goto L89;
        r2 = ParameterName.DE_CONTOUR;
        goto L90
    L87:
        if (cmd.equals("get-letterbox-style") == false) goto L89;
        r2 = 13;
        goto L90
    L4:
        return handleDefaultCommands(cmd);
    }

    private int getDisplayId(String opt) {
        if ("-d".equals(opt) == false) goto L5;
        String option = opt;
    L6:
        if (option != null) goto L8;
        return 0;
    L8:
        if ("-d".equals(option) == false) goto L21;
        int displayId = Integer.parseInt(getNextArgRequired());     // Catch: IllegalArgumentException -> L12 NumberFormatException -> L14
    L23:
        return displayId;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: bad number " + e);
        return 0;
    L12:
        e = move-exception;
        getErrPrintWriter().println("Error: " + e);
        return 0;
    L21:
        return 0;
    L5:
        option = getNextOption();
        goto L6
    }

    private void printInitialDisplaySize(PrintWriter pw, int displayId) {
        Point initialSize = new Point();
        Point baseSize = new Point();
        this.mInterface.getInitialDisplaySize(displayId, initialSize);     // Catch: RemoteException -> L7
        this.mInterface.getBaseDisplaySize(displayId, baseSize);     // Catch: RemoteException -> L7
        pw.println("Physical size: " + initialSize.x + "x" + initialSize.y);     // Catch: RemoteException -> L7
        if (initialSize.equals(baseSize) == true) goto L14;
        pw.println("Override size: " + baseSize.x + "x" + baseSize.y);     // Catch: RemoteException -> L7
        return;
    L14:
        return;
    L7:
        e = move-exception;
        pw.println("Remote exception: " + e);
    }

    private int runDisplaySize(PrintWriter pw) throws RemoteException {
        String size = getNextArg();
        int displayId = getDisplayId(size);
        if (size != null) goto L7;
        printInitialDisplaySize(pw, displayId);
        return 0;
    L7:
        if ("-d".equals(size) == false) goto L10;
        printInitialDisplaySize(pw, displayId);
        return 0;
    L10:
        int w = -1;
        if ("reset".equals(size) == false) goto L13;
        int div = -1;
    L21:
        if (w < 0) goto L24;
        if (div < 0) goto L24;
        this.mInterface.setForcedDisplaySize(displayId, w, div);
    L25:
        return 0;
    L24:
        this.mInterface.clearForcedDisplaySize(displayId);
        goto L25
    L13:
        int div2 = size.indexOf(120);
        if (div2 > 0) goto L16;
    L29:
        getErrPrintWriter().println("Error: bad size " + size);
        return -1;
    L16:
        if (div2 >= (size.length() - 1)) goto L29;
        String wstr = size.substring(0, div2);
        String hstr = size.substring(div2 + 1);
        int w2 = parseDimension(wstr, displayId);     // Catch: NumberFormatException -> L26
        int h = parseDimension(hstr, displayId);     // Catch: NumberFormatException -> L26
        div = h;
        w = w2;
    L26:
        e = move-exception;
        getErrPrintWriter().println("Error: bad number " + e);
        return -1;
    }

    private int runSetBlurDisabled(PrintWriter pw) throws RemoteException {
        String arg = getNextArg();
        if (arg != null) goto L7;
        pw.println("Blur supported on device: " + CrossWindowBlurListeners.CROSS_WINDOW_BLUR_SUPPORTED);
        pw.println("Blur enabled: " + this.mInternal.mBlurController.getBlurEnabled());
        return 0;
    L7:
        switch(arg.hashCode()) {
            case 48: goto L19;
            case 49: goto L16;
            case 3569038: goto L13;
            case 97196323: goto L10;
            default: goto L21;
        };
    L21:
        byte r2 = -1;
    L22:
        switch(r2) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        getErrPrintWriter().println("Error: expected true, 1, false, 0, but got " + arg);
        return -1;
    L25:
        int r3 = 0;
    L27:
        Settings.Global.putInt(this.mInternal.mContext.getContentResolver(), "disable_window_blurs", r3);
        return 0;
    L26:
        r3 = 1;
        goto L27
    L10:
        if (arg.equals("false") == false) goto L29;
        r2 = 2;
        goto L22
    L29:
        r2 = -1;
        goto L22
    L13:
        if (arg.equals("true") == false) goto L30;
        r2 = 0;
        goto L22
    L30:
        r2 = -1;
        goto L22
    L16:
        if (arg.equals("1") == false) goto L31;
        r2 = 1;
        goto L22
    L31:
        r2 = -1;
        goto L22
    L19:
        if (arg.equals("0") == false) goto L32;
        r2 = 3;
        goto L22
    L32:
        r2 = -1;
        goto L22
    }

    private int runResetFreezeRecentTaskListReordering(PrintWriter pw) throws RemoteException {
        this.mInternal.resetFreezeRecentTaskListReordering();
        return 0;
    }

    private void printInitialDisplayDensity(PrintWriter pw, int displayId) {
        int initialDensity = this.mInterface.getInitialDisplayDensity(displayId);     // Catch: RemoteException -> L6
        int baseDensity = this.mInterface.getBaseDisplayDensity(displayId);     // Catch: RemoteException -> L6
        pw.println("Physical density: " + initialDensity);     // Catch: RemoteException -> L6
        if (initialDensity == baseDensity) goto L13;
        pw.println("Override density: " + baseDensity);     // Catch: RemoteException -> L6
        return;
    L13:
        return;
    L6:
        e = move-exception;
        pw.println("Remote exception: " + e);
    }

    private int runDisplayDensity(PrintWriter pw) throws RemoteException {
        String densityStr = null;
        String arg = getNextArg();
        int displayId = 0;
        if ("-d".equals(arg) == true) goto L8;
        if ("-u".equals(arg) == true) goto L8;
        densityStr = arg;
        arg = getNextArg();
    L8:
        if ("-d".equals(arg) == false) goto L16;
        displayId = Integer.parseInt(getNextArg());     // Catch: NumberFormatException -> L13
    L22:
        if (densityStr != null) goto L26;
        printInitialDisplayDensity(pw, displayId);
        return 0;
    L26:
        if ("reset".equals(densityStr) == false) goto L41;
        int density = -1;
    L34:
        if (density <= 0) goto L36;
        this.mInterface.setForcedDisplayDensityForUser(displayId, density, -2);
    L37:
        return 0;
    L36:
        this.mInterface.clearForcedDisplayDensityForUser(displayId, -2);
        goto L37
    L41:
        density = Integer.parseInt(densityStr);     // Catch: NumberFormatException -> L38
        if (density >= 72) goto L34;
        getErrPrintWriter().println("Error: density must be >= 72");
        return -1;
    L38:
        e = move-exception;
        getErrPrintWriter().println("Error: bad number " + e);
        return -1;
    L13:
        e = move-exception;
        getErrPrintWriter().println("Error: bad number " + e);
        goto L22
    L16:
        if ("-u".equals(arg) == false) goto L22;
        displayId = this.mInterface.getDisplayIdByUniqueId(getNextArg());
        if (displayId != (-1)) goto L22;
        getErrPrintWriter().println("Error: the uniqueId is invalid ");
        return -1;
    }

    private void printFoldedArea(PrintWriter pw) {
        Rect foldedArea = this.mInternal.getFoldedArea();
        if (foldedArea.isEmpty() == false) goto L5;
        pw.println("Folded area: none");
        return;
    L5:
        pw.println("Folded area: " + foldedArea.left + "," + foldedArea.top + "," + foldedArea.right + "," + foldedArea.bottom);
    }

    private int runDisplayFoldedArea(PrintWriter pw) {
        String areaStr = getNextArg();
        Rect rect = new Rect();
        if (areaStr != null) goto L7;
        printFoldedArea(pw);
        return 0;
    L7:
        if ("reset".equals(areaStr) == false) goto L9;
        rect.setEmpty();
    L14:
        this.mInternal.setOverrideFoldedArea(rect);
        return 0;
    L9:
        Pattern flattenedPattern = Pattern.compile("(-?\\d+),(-?\\d+),(-?\\d+),(-?\\d+)");
        Matcher matcher = flattenedPattern.matcher(areaStr);
        if (matcher.matches() == true) goto L13;
        getErrPrintWriter().println("Error: area should be LEFT,TOP,RIGHT,BOTTOM");
        return -1;
    L13:
        rect.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)));
        goto L14
    }

    private int runDisplayScaling(PrintWriter pw) throws RemoteException {
        String scalingStr = getNextArgRequired();
        if (UiModeManagerService.Shell.NIGHT_MODE_STR_AUTO.equals(scalingStr) == false) goto L6;
        this.mInterface.setForcedDisplayScalingMode(getDisplayId(scalingStr), 0);
    L8:
        return 0;
    L6:
        if ("off".equals(scalingStr) == false) goto L9;
        this.mInterface.setForcedDisplayScalingMode(getDisplayId(scalingStr), 1);
        goto L8
    L9:
        getErrPrintWriter().println("Error: scaling must be 'auto' or 'off'");
        return -1;
    }

    private int runSandboxDisplayApis(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArgRequired();
        if ("-d".equals(arg) == false) goto L6;
        displayId = Integer.parseInt(getNextArgRequired());
        arg = getNextArgRequired();
    L6:
        switch(arg.hashCode()) {
            case 48: goto L18;
            case 49: goto L15;
            case 3569038: goto L12;
            case 97196323: goto L9;
            default: goto L20;
        };
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L25;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L24;
            default: goto L22;
        };
    L22:
        getErrPrintWriter().println("Error: expecting true, 1, false, 0, but we get " + arg);
        return -1;
    L24:
        boolean sandboxDisplayApis = false;
    L26:
        this.mInternal.setSandboxDisplayApis(displayId, sandboxDisplayApis);
        return 0;
    L25:
        sandboxDisplayApis = true;
        goto L26
    L9:
        if (arg.equals("false") == false) goto L28;
        r2 = 2;
        goto L21
    L28:
        r2 = -1;
        goto L21
    L12:
        if (arg.equals("true") == false) goto L29;
        r2 = 0;
        goto L21
    L29:
        r2 = -1;
        goto L21
    L15:
        if (arg.equals("1") == false) goto L30;
        r2 = 1;
        goto L21
    L30:
        r2 = -1;
        goto L21
    L18:
        if (arg.equals("0") == false) goto L31;
        r2 = 3;
        goto L21
    L31:
        r2 = -1;
        goto L21
    }

    private int runDismissKeyguard(PrintWriter pw) throws RemoteException {
        this.mInterface.dismissKeyguard(null, null);
        return 0;
    }

    private int parseDimension(String s, int displayId) throws NumberFormatException {
        if (s.endsWith("px") == false) goto L7;
        return Integer.parseInt(s.substring(0, s.length() - 2));
    L7:
        if (s.endsWith("dp") == true) goto L16;
        int density = Integer.parseInt(s);
        return density;
    L16:
        int density2 = this.mInterface.getBaseDisplayDensity(displayId);     // Catch: RemoteException -> L10
    L13:
        return (Integer.parseInt(s.substring(0, s.length() - 2)) * density2) / 160;
    L11:
        density2 = 160;
        goto L13
    }

    private int runDisplayUserRotation(PrintWriter pw) {
        int displayId = 0;
        String arg = getNextArg();
        if (arg != null) goto L7;
        return printDisplayUserRotation(pw, 0);
    L7:
        if ("-d".equals(arg) == false) goto L9;
        displayId = Integer.parseInt(getNextArgRequired());
        arg = getNextArg();
    L9:
        String lockMode = arg;
        if (lockMode != null) goto L14;
        return printDisplayUserRotation(pw, displayId);
    L14:
        if ("free".equals(lockMode) == false) goto L18;
        this.mInternal.thawDisplayRotation(displayId, "WindowManagerShellCommand#free");
        return 0;
    L18:
        if ("lock".equals(lockMode) == true) goto L21;
        getErrPrintWriter().println("Error: argument needs to be either -d, free or lock.");
        return -1;
    L21:
        String arg2 = getNextArg();
        if (arg2 != null) goto L31;
        int rotation = -1;
    L27:
        this.mInternal.freezeDisplayRotation(displayId, rotation, "WindowManagerShellCommand#lock");     // Catch: IllegalArgumentException -> L24
        return 0;
    L24:
        e = move-exception;
        getErrPrintWriter().println("Error: " + e.getMessage());
        return -1;
    L31:
        rotation = Integer.parseInt(arg2);     // Catch: IllegalArgumentException -> L24
        goto L27
    }

    private int printDisplayUserRotation(PrintWriter pw, int displayId) {
        int displayUserRotation = this.mInternal.getDisplayUserRotation(displayId);
        if (displayUserRotation >= 0) goto L7;
        getErrPrintWriter().println("Error: check logcat for more details.");
        return -1;
    L7:
        if (this.mInternal.isDisplayRotationFrozen(displayId) == true) goto L10;
        pw.println("free");
        return 0;
    L10:
        pw.print("lock ");
        pw.println(displayUserRotation);
        return 0;
    }

    private int runFixedToUserRotation(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArg();
        if (arg != null) goto L7;
        printFixedToUserRotation(pw, 0);
        return 0;
    L7:
        if ("-d".equals(arg) == false) goto L9;
        displayId = Integer.parseInt(getNextArgRequired());
        arg = getNextArg();
    L9:
        if (arg != null) goto L13;
        return printFixedToUserRotation(pw, displayId);
    L13:
        switch(arg.hashCode()) {
            case -1609594047: goto L25;
            case -768077068: goto L22;
            case 270940796: goto L19;
            case 1544803905: goto L16;
            default: goto L27;
        };
    L27:
        byte r3 = -1;
    L28:
        switch(r3) {
            case 0: goto L34;
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L31;
            default: goto L29;
        };
    L29:
        getErrPrintWriter().println("Error: expecting enabled, disabled or default, but we get " + arg);
        return -1;
    L31:
        int fixedToUserRotation = 3;
    L35:
        this.mInterface.setFixedToUserRotation(displayId, fixedToUserRotation);
        return 0;
    L32:
        fixedToUserRotation = 0;
        goto L35
    L33:
        fixedToUserRotation = 1;
        goto L35
    L34:
        fixedToUserRotation = 2;
        goto L35
    L16:
        if (arg.equals("default") == false) goto L37;
        r3 = 2;
        goto L28
    L37:
        r3 = -1;
        goto L28
    L19:
        if (arg.equals(ServiceConfigAccessor.PROVIDER_MODE_DISABLED) == false) goto L38;
        r3 = 1;
        goto L28
    L38:
        r3 = -1;
        goto L28
    L22:
        if (arg.equals("enabled_if_no_auto_rotation") == false) goto L39;
        r3 = 3;
        goto L28
    L39:
        r3 = -1;
        goto L28
    L25:
        if (arg.equals(ServiceConfigAccessor.PROVIDER_MODE_ENABLED) == false) goto L40;
        r3 = 0;
        goto L28
    L40:
        r3 = -1;
        goto L28
    }

    private int printFixedToUserRotation(PrintWriter pw, int displayId) {
        int fixedToUserRotationMode = this.mInternal.getFixedToUserRotation(displayId);
        switch(fixedToUserRotationMode) {
            case 0: goto L12;
            case 1: goto L10;
            case 2: goto L8;
            case 3: goto L6;
            default: goto L4;
        };
    L4:
        getErrPrintWriter().println("Error: check logcat for more details.");
        return -1;
    L6:
        pw.println("enabled_if_no_auto_rotation");
        return 0;
    L8:
        pw.println(ServiceConfigAccessor.PROVIDER_MODE_ENABLED);
        return 0;
    L10:
        pw.println(ServiceConfigAccessor.PROVIDER_MODE_DISABLED);
        return 0;
    L12:
        pw.println("default");
        return 0;
    }

    private int runSetIgnoreOrientationRequest(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArgRequired();
        if ("-d".equals(arg) == false) goto L6;
        displayId = Integer.parseInt(getNextArgRequired());
        arg = getNextArgRequired();
    L6:
        if ("reset".equals(arg) == false) goto L14;
        Boolean result = this.mInternal.resetIgnoreOrientationRequest(displayId);
        if (result == null) goto L11;
        pw.println("Reset ignoreOrientationRequest to " + result + " for displayId=" + displayId);
        return 0;
    L11:
        getErrPrintWriter().println("Unable to reset ignoreOrientationRequest for displayId=" + displayId);
        return -1;
    L14:
        switch(arg.hashCode()) {
            case 48: goto L26;
            case 49: goto L23;
            case 3569038: goto L20;
            case 97196323: goto L17;
            default: goto L28;
        };
    L28:
        byte r2 = -1;
    L29:
        switch(r2) {
            case 0: goto L33;
            case 1: goto L33;
            case 2: goto L32;
            case 3: goto L32;
            default: goto L30;
        };
    L30:
        getErrPrintWriter().println("Error: expecting true, 1, false, 0, reset, but we get " + arg);
        return -1;
    L32:
        boolean ignoreOrientationRequest = false;
    L34:
        this.mInterface.setIgnoreOrientationRequest(displayId, ignoreOrientationRequest);
        return 0;
    L33:
        ignoreOrientationRequest = true;
        goto L34
    L17:
        if (arg.equals("false") == false) goto L36;
        r2 = 2;
        goto L29
    L36:
        r2 = -1;
        goto L29
    L20:
        if (arg.equals("true") == false) goto L37;
        r2 = 0;
        goto L29
    L37:
        r2 = -1;
        goto L29
    L23:
        if (arg.equals("1") == false) goto L38;
        r2 = 1;
        goto L29
    L38:
        r2 = -1;
        goto L29
    L26:
        if (arg.equals("0") == false) goto L39;
        r2 = 3;
        goto L29
    L39:
        r2 = -1;
        goto L29
    }

    private int runGetIgnoreOrientationRequest(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArg();
        if ("-d".equals(arg) == false) goto L5;
        displayId = Integer.parseInt(getNextArgRequired());
    L5:
        boolean ignoreOrientationRequest = this.mInternal.getIgnoreOrientationRequest(displayId);
        pw.println("ignoreOrientationRequest " + ignoreOrientationRequest + " for displayId=" + displayId);
        return 0;
    }

    private void dumpLocalWindowAsync(final IWindow client, final ParcelFileDescriptor pfd) {
        IoThread.getExecutor().execute(new WindowManagerShellCommand$$ExternalSyntheticLambda1(this, client, pfd));
    }

    private /* synthetic */ void lambda$dumpLocalWindowAsync$0(IWindow client, ParcelFileDescriptor pfd) {
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        client.executeCommand("DUMP_ENCODED", null, pfd);     // Catch: Throwable -> L6 Exception -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L6
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private int runDumpVisibleWindowViews(PrintWriter pw) {
        if (this.mInternal.checkCallingPermission("android.permission.DUMP", "runDumpVisibleWindowViews()") == false) goto L43;
        ZipOutputStream out = new ZipOutputStream(getRawOutputStream());     // Catch: IOException -> L30
        final ArrayList<Pair<String, ByteTransferPipe>> requestList = new ArrayList();     // Catch: Throwable -> L23
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;     // Catch: Throwable -> L23
        WindowManagerService.boostPriorityForLockedSection();     // Catch: Throwable -> L23
        monitor-enter(r3);     // Catch: Throwable -> L23
        RecentTasks recentTasks = this.mInternal.mAtmService.getRecentTasks();     // Catch: Throwable -> L11
        if (recentTasks == null) goto L13;
        final int recentsComponentUid = recentTasks.getRecentsComponentUid();     // Catch: Throwable -> L11
    L14:
        this.mInternal.mRoot.forAllWindows(new WindowManagerShellCommand$$ExternalSyntheticLambda0(this, recentsComponentUid, requestList), false);     // Catch: Throwable -> L11
        monitor-exit(r3);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        Iterator<Pair<String, ByteTransferPipe>> r4 = requestList.iterator();     // Catch: Throwable -> L23
    L18:
        if (r4.hasNext() == false) goto L28;
        Pair<String, ByteTransferPipe> entry = r4.next();     // Catch: Throwable -> L23
        byte[] data = ((ByteTransferPipe) entry.second).get();     // Catch: Throwable -> L23 IOException -> L25
        out.putNextEntry(new ZipEntry((String) entry.first));     // Catch: Throwable -> L23
        out.write(data);     // Catch: Throwable -> L23
        goto L18
    L28:
        out.close();     // Catch: IOException -> L30
    L41:
        return 0;
    L13:
        recentsComponentUid = -1;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        out.close();     // Catch: Throwable -> L37
    L39:
        throw th;     // Catch: IOException -> L30
    L37:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L30
    L30:
        e = move-exception;
        pw.println("Error fetching dump " + e.getMessage());
        goto L41
    L43:
        throw new SecurityException("Requires DUMP permission");
    }

    private /* synthetic */ void lambda$runDumpVisibleWindowViews$1(int recentsComponentUid, ArrayList requestList, WindowState w) {
        if (w.getUid() != recentsComponentUid) goto L5;
        boolean isRecents = true;
    L7:
        if (w.isVisible() == true) goto L9;
        if (isRecents == true) goto L9;
        return;
    L9:
        ByteTransferPipe pipe = null;
        pipe = new ByteTransferPipe();     // Catch: Throwable -> L13
        ParcelFileDescriptor pfd = pipe.getWriteFd();     // Catch: Throwable -> L13
        if (w.isClientLocal() == false) goto L15;
        dumpLocalWindowAsync(w.mClient, pfd);     // Catch: Throwable -> L13
    L16:
        requestList.add(Pair.create(w.getName(), pipe));     // Catch: Throwable -> L13
        return;
    L15:
        w.mClient.executeCommand("DUMP_ENCODED", null, pfd);     // Catch: Throwable -> L13
    L19:
        if (pipe == null) goto L25;
        pipe.kill();
        return;
    L25:
        return;
    L5:
        isRecents = false;
        goto L7
    }

    private int runSetFixedOrientationLetterboxAspectRatio(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        float aspectRatio = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mAppCompatConfiguration.setFixedOrientationLetterboxAspectRatio(aspectRatio);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L16:
        e = move-exception;
        getErrPrintWriter().println("Error: bad aspect ratio format " + e);
        return -1;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: aspect ratio should be provided as an argument " + e);
        return -1;
    }

    private int runSetDefaultMinAspectRatioForUnresizableApps(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        float aspectRatio = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mAppCompatConfiguration.setDefaultMinAspectRatioForUnresizableApps(aspectRatio);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L16:
        e = move-exception;
        getErrPrintWriter().println("Error: bad aspect ratio format " + e);
        return -1;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: aspect ratio should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxActivityCornersRadius(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        int cornersRadius = Integer.parseInt(arg);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mAppCompatConfiguration.setLetterboxActivityCornersRadius(cornersRadius);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L16:
        e = move-exception;
        getErrPrintWriter().println("Error: bad corners radius format " + e);
        return -1;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: corners radius should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxBackgroundType(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L9
        switch(arg.hashCode()) {
            case -1700528003: goto L18;
            case -231186968: goto L15;
            case 1216433359: goto L12;
            case 1474694658: goto L7;
            default: goto L20;
        };     // Catch: IllegalArgumentException -> L9
    L20:
        byte r2 = -1;
    L21:
        switch(r2) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L24;
            default: goto L22;
        };     // Catch: IllegalArgumentException -> L9
    L22:
        getErrPrintWriter().println("Error: 'solid_color', 'app_color_background' or 'wallpaper' should be provided as an argument");     // Catch: IllegalArgumentException -> L9
        return -1;
    L24:
        int backgroundType = 3;
    L28:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAppCompatConfiguration.setLetterboxBackgroundTypeOverride(backgroundType);     // Catch: Throwable -> L34
        monitor-exit(r3);     // Catch: Throwable -> L34
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L34:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L25:
        backgroundType = 2;
        goto L28
    L26:
        backgroundType = 1;
        goto L28
    L27:
        backgroundType = 0;
        goto L28
    L7:
        if (arg.equals("wallpaper") == false) goto L20;
        r2 = 3;
        goto L21
    L12:
        if (arg.equals("solid_color") == false) goto L20;
        r2 = 0;
        goto L21
    L15:
        if (arg.equals("app_color_background") == false) goto L20;
        r2 = 1;
        goto L21
    L18:
        if (arg.equals("app_color_background_floating") == false) goto L20;
        r2 = 2;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: 'solid_color', 'app_color_background' or 'wallpaper' should be provided as an argument" + e);
        return -1;
    }

    private int runSetLetterboxBackgroundColorResource(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: Resources.NotFoundException -> L13
        int colorId = this.mInternal.mContext.getResources().getIdentifier(arg, "color", "com.android.internal");     // Catch: Resources.NotFoundException -> L13
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAppCompatConfiguration.setLetterboxBackgroundColorResourceId(colorId);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L13:
        e = move-exception;
        getErrPrintWriter().println("Error: color in '@android:color/resource_name' format should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxBackgroundColor(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L13
        Color color = Color.valueOf(Color.parseColor(arg));     // Catch: IllegalArgumentException -> L13
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAppCompatConfiguration.setLetterboxBackgroundColor(color);     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L9:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L13:
        e = move-exception;
        getErrPrintWriter().println("Error: color in #RRGGBB format should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxBackgroundWallpaperBlurRadius(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L15 NumberFormatException -> L17
        int radiusDp = Integer.parseInt(arg);     // Catch: IllegalArgumentException -> L15 NumberFormatException -> L17
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        int radiusPx = (int) TypedValue.applyDimension(1, radiusDp, this.mInternal.mContext.getResources().getDisplayMetrics());     // Catch: Throwable -> L11
        this.mAppCompatConfiguration.setLetterboxBackgroundWallpaperBlurRadiusPx(radiusPx);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L11:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L17:
        e = move-exception;
        getErrPrintWriter().println("Error: blur radius format " + e);
        return -1;
    L15:
        e = move-exception;
        getErrPrintWriter().println("Error: blur radius should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxBackgroundWallpaperDarkScrimAlpha(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        float alpha = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mAppCompatConfiguration.setLetterboxBackgroundWallpaperDarkScrimAlpha(alpha);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L16:
        e = move-exception;
        getErrPrintWriter().println("Error: bad alpha format " + e);
        return -1;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: alpha should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxHorizontalPositionMultiplier(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L20 NumberFormatException -> L22
        float multiplier = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L20 NumberFormatException -> L22
        WindowManagerGlobalLock r1 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mAppCompatConfiguration.setLetterboxHorizontalPositionMultiplier(multiplier);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        monitor-exit(r1);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L12:
        e = move-exception;
        getErrPrintWriter().println("Error: invalid multiplier value " + e);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        e = move-exception;
        getErrPrintWriter().println("Error: bad multiplier format " + e);
        return -1;
    L20:
        e = move-exception;
        getErrPrintWriter().println("Error: multiplier should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxVerticalPositionMultiplier(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L20 NumberFormatException -> L22
        float multiplier = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L20 NumberFormatException -> L22
        WindowManagerGlobalLock r1 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r1);
        this.mAppCompatConfiguration.setLetterboxVerticalPositionMultiplier(multiplier);     // Catch: Throwable -> L10 IllegalArgumentException -> L12
        monitor-exit(r1);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L12:
        e = move-exception;
        getErrPrintWriter().println("Error: invalid multiplier value " + e);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        e = move-exception;
        getErrPrintWriter().println("Error: bad multiplier format " + e);
        return -1;
    L20:
        e = move-exception;
        getErrPrintWriter().println("Error: multiplier should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxDefaultPositionForHorizontalReachability(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L9
        switch(arg.hashCode()) {
            case -1364013995: goto L15;
            case 3317767: goto L12;
            case 108511772: goto L7;
            default: goto L17;
        };     // Catch: IllegalArgumentException -> L9
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };     // Catch: IllegalArgumentException -> L9
    L19:
        getErrPrintWriter().println("Error: 'left', 'center' or 'right' are expected as an argument");     // Catch: IllegalArgumentException -> L9
        return -1;
    L21:
        int position = 2;
    L24:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAppCompatConfiguration.setDefaultPositionForHorizontalReachability(position);     // Catch: Throwable -> L30
        monitor-exit(r3);     // Catch: Throwable -> L30
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L30:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        position = 1;
        goto L24
    L23:
        position = 0;
        goto L24
    L7:
        if (arg.equals("right") == false) goto L17;
        r2 = 2;
        goto L18
    L12:
        if (arg.equals("left") == false) goto L17;
        r2 = 0;
        goto L18
    L15:
        if (arg.equals("center") == false) goto L17;
        r2 = 1;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: 'left', 'center' or 'right' are expected as an argument" + e);
        return -1;
    }

    private int runSetLetterboxDefaultPositionForVerticalReachability(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L9
        switch(arg.hashCode()) {
            case -1383228885: goto L15;
            case -1364013995: goto L12;
            case 115029: goto L7;
            default: goto L17;
        };     // Catch: IllegalArgumentException -> L9
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };     // Catch: IllegalArgumentException -> L9
    L19:
        getErrPrintWriter().println("Error: 'top', 'center' or 'bottom' are expected as an argument");     // Catch: IllegalArgumentException -> L9
        return -1;
    L21:
        int position = 2;
    L24:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAppCompatConfiguration.setDefaultPositionForVerticalReachability(position);     // Catch: Throwable -> L30
        monitor-exit(r3);     // Catch: Throwable -> L30
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L30:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        position = 1;
        goto L24
    L23:
        position = 0;
        goto L24
    L7:
        if (arg.equals("top") == false) goto L17;
        r2 = 0;
        goto L18
    L12:
        if (arg.equals("center") == false) goto L17;
        r2 = 1;
        goto L18
    L15:
        if (arg.equals("bottom") == false) goto L17;
        r2 = 2;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: 'top', 'center' or 'bottom' are expected as an argument" + e);
        return -1;
    }

    private int runSetPersistentLetterboxPositionForHorizontalReachability(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L9
        switch(arg.hashCode()) {
            case -1364013995: goto L15;
            case 3317767: goto L12;
            case 108511772: goto L7;
            default: goto L17;
        };     // Catch: IllegalArgumentException -> L9
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };     // Catch: IllegalArgumentException -> L9
    L19:
        getErrPrintWriter().println("Error: 'left', 'center' or 'right' are expected as an argument");     // Catch: IllegalArgumentException -> L9
        return -1;
    L21:
        int position = 2;
    L24:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAppCompatConfiguration.setPersistentLetterboxPositionForHorizontalReachability(false, position);     // Catch: Throwable -> L30
        monitor-exit(r3);     // Catch: Throwable -> L30
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L30:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        position = 1;
        goto L24
    L23:
        position = 0;
        goto L24
    L7:
        if (arg.equals("right") == false) goto L17;
        r2 = 2;
        goto L18
    L12:
        if (arg.equals("left") == false) goto L17;
        r2 = 0;
        goto L18
    L15:
        if (arg.equals("center") == false) goto L17;
        r2 = 1;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: 'left', 'center' or 'right' are expected as an argument" + e);
        return -1;
    }

    private int runSetPersistentLetterboxPositionForVerticalReachability(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L9
        switch(arg.hashCode()) {
            case -1383228885: goto L15;
            case -1364013995: goto L12;
            case 115029: goto L7;
            default: goto L17;
        };     // Catch: IllegalArgumentException -> L9
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            default: goto L19;
        };     // Catch: IllegalArgumentException -> L9
    L19:
        getErrPrintWriter().println("Error: 'top', 'center' or 'bottom' are expected as an argument");     // Catch: IllegalArgumentException -> L9
        return -1;
    L21:
        int position = 2;
    L24:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        this.mAppCompatConfiguration.setPersistentLetterboxPositionForVerticalReachability(false, position);     // Catch: Throwable -> L30
        monitor-exit(r3);     // Catch: Throwable -> L30
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L30:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L22:
        position = 1;
        goto L24
    L23:
        position = 0;
        goto L24
    L7:
        if (arg.equals("top") == false) goto L17;
        r2 = 0;
        goto L18
    L12:
        if (arg.equals("center") == false) goto L17;
        r2 = 1;
        goto L18
    L15:
        if (arg.equals("bottom") == false) goto L17;
        r2 = 2;
    L9:
        e = move-exception;
        getErrPrintWriter().println("Error: 'top', 'center' or 'bottom' are expected as an argument" + e);
        return -1;
    }

    private int runSetBooleanFlag(PrintWriter pw, Consumer<Boolean> setter) throws RemoteException {
        String arg = getNextArg();
        if (arg != null) goto L7;
        getErrPrintWriter().println("Error: expected true, 1, false, 0, but got empty input.");
        return -1;
    L7:
        switch(arg.hashCode()) {
            case 48: goto L19;
            case 49: goto L16;
            case 3569038: goto L13;
            case 97196323: goto L10;
            default: goto L21;
        };
    L21:
        byte r2 = -1;
    L22:
        switch(r2) {
            case 0: goto L26;
            case 1: goto L26;
            case 2: goto L25;
            case 3: goto L25;
            default: goto L23;
        };
    L23:
        getErrPrintWriter().println("Error: expected true, 1, false, 0, but got " + arg);
        return -1;
    L25:
        boolean enabled = false;
    L27:
        WindowManagerGlobalLock r3 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r3);
        setter.accept(Boolean.valueOf(enabled));     // Catch: Throwable -> L33
        monitor-exit(r3);     // Catch: Throwable -> L33
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L33:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L26:
        enabled = true;
        goto L27
    L10:
        if (arg.equals("false") == false) goto L39;
        r2 = 2;
        goto L22
    L39:
        r2 = -1;
        goto L22
    L13:
        if (arg.equals("true") == false) goto L40;
        r2 = 0;
        goto L22
    L40:
        r2 = -1;
        goto L22
    L16:
        if (arg.equals("1") == false) goto L41;
        r2 = 1;
        goto L22
    L41:
        r2 = -1;
        goto L22
    L19:
        if (arg.equals("0") == false) goto L42;
        r2 = 3;
        goto L22
    L42:
        r2 = -1;
        goto L22
    }

    private int runSetCameraCompatAspectRatio(PrintWriter pw) throws RemoteException {
        String arg = getNextArgRequired();     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        float aspectRatio = Float.parseFloat(arg);     // Catch: IllegalArgumentException -> L14 NumberFormatException -> L16
        WindowManagerGlobalLock r2 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mAppCompatConfiguration.setCameraCompatAspectRatio(aspectRatio);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L10:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L16:
        e = move-exception;
        getErrPrintWriter().println("Error: bad aspect ratio format " + e);
        return -1;
    L14:
        e = move-exception;
        getErrPrintWriter().println("Error: aspect ratio should be provided as an argument " + e);
        return -1;
    }

    private int runSetLetterboxStyle(PrintWriter pw) throws RemoteException {
        if (peekNextArg() != null) goto L5;
        getErrPrintWriter().println("Error: No arguments provided.");
    L5:
        byte r1 = 0;
        if (peekNextArg() == null) goto L123;
        String arg = getNextArg();
        switch(arg.hashCode()) {
            case -2104622228: goto L89;
            case -2007271181: goto L86;
            case -1688278685: goto L83;
            case -1440939136: goto L80;
            case -1310848756: goto L77;
            case -1294369338: goto L74;
            case -1264068297: goto L71;
            case -1052930822: goto L68;
            case -1031747914: goto L65;
            case -1009939225: goto L62;
            case -951337176: goto L59;
            case -911250737: goto L56;
            case -335739429: goto L53;
            case -302214401: goto L50;
            case -301215364: goto L47;
            case -69722518: goto L44;
            case 229853520: goto L41;
            case 304986101: goto L38;
            case 557317429: goto L35;
            case 875005988: goto L32;
            case 911401338: goto L29;
            case 935353942: goto L26;
            case 1033642083: goto L23;
            case 1066804362: goto L20;
            case 1070248110: goto L17;
            case 1416509399: goto L14;
            case 1739415288: goto L11;
            default: goto L91;
        };
    L91:
        r1 = -1;
    L92:
        switch(r1) {
            case 0: goto L121;
            case 1: goto L120;
            case 2: goto L119;
            case 3: goto L118;
            case 4: goto L117;
            case 5: goto L116;
            case 6: goto L115;
            case 7: goto L114;
            case 8: goto L113;
            case 9: goto L112;
            case 10: goto L111;
            case 11: goto L110;
            case 12: goto L109;
            case 13: goto L108;
            case 14: goto L107;
            case 15: goto L106;
            case 16: goto L105;
            case 17: goto L104;
            case 18: goto L103;
            case 19: goto L102;
            case 20: goto L101;
            case 21: goto L100;
            case 22: goto L99;
            case 23: goto L98;
            case 24: goto L97;
            case 25: goto L96;
            case 26: goto L95;
            default: goto L93;
        };
    L93:
        getErrPrintWriter().println("Error: Unrecognized letterbox style option: " + arg);
        return -1;
    L96:
        runSetCameraCompatAspectRatio(pw);
        goto L5
    L97:
        final AppCompatConfiguration r2 = this.mAppCompatConfiguration;
        r2.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda3(r2));
        goto L5
    L98:
        final AppCompatConfiguration r3 = this.mAppCompatConfiguration;
        r3.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda13(r3));
        goto L5
    L99:
        final AppCompatConfiguration r4 = this.mAppCompatConfiguration;
        r4.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda12(r4));
        goto L5
    L100:
        final AppCompatConfiguration r5 = this.mAppCompatConfiguration;
        r5.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda11(r5));
        goto L5
    L101:
        final AppCompatConfiguration r6 = this.mAppCompatConfiguration;
        r6.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda10(r6));
        goto L5
    L102:
        final AppCompatConfiguration r7 = this.mAppCompatConfiguration;
        r7.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda9(r7));
        goto L5
    L103:
        final AppCompatConfiguration r8 = this.mAppCompatConfiguration;
        r8.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda8(r8));
        goto L5
    L104:
        final AppCompatConfiguration r9 = this.mAppCompatConfiguration;
        r9.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda7(r9));
        goto L5
    L105:
        runSetPersistentLetterboxPositionForVerticalReachability(pw);
        goto L5
    L106:
        runSetPersistentLetterboxPositionForHorizontalReachability(pw);
        goto L5
    L107:
        runSetLetterboxDefaultPositionForVerticalReachability(pw);
        goto L5
    L108:
        runSetLetterboxDefaultPositionForHorizontalReachability(pw);
        goto L5
    L109:
        final AppCompatConfiguration r10 = this.mAppCompatConfiguration;
        r10.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda6(r10));
        goto L5
    L110:
        final AppCompatConfiguration r11 = this.mAppCompatConfiguration;
        r11.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda5(r11));
        goto L5
    L111:
        final AppCompatConfiguration r12 = this.mAppCompatConfiguration;
        r12.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda2(r12));
        goto L5
    L112:
        runSetLetterboxVerticalPositionMultiplier(pw);
        goto L5
    L113:
        runSetLetterboxHorizontalPositionMultiplier(pw);
        goto L5
    L114:
        runSetLetterboxBackgroundWallpaperDarkScrimAlpha(pw);
        goto L5
    L115:
        runSetLetterboxBackgroundWallpaperBlurRadius(pw);
        goto L5
    L116:
        runSetLetterboxBackgroundColorResource(pw);
        goto L5
    L117:
        runSetLetterboxBackgroundColor(pw);
        goto L5
    L118:
        runSetLetterboxBackgroundType(pw);
        goto L5
    L119:
        runSetLetterboxActivityCornersRadius(pw);
        goto L5
    L120:
        runSetDefaultMinAspectRatioForUnresizableApps(pw);
        goto L5
    L121:
        runSetFixedOrientationLetterboxAspectRatio(pw);
        goto L5
    L95:
        final AppCompatConfiguration r13 = this.mAppCompatConfiguration;
        r13.getClass();
        runSetBooleanFlag(pw, new WindowManagerShellCommand$$ExternalSyntheticLambda4(r13));
        goto L5
    L11:
        if (arg.equals("--isAutomaticReachabilityInBookModeEnabled") == false) goto L182;
        r1 = 12;
        goto L92
    L182:
        r1 = -1;
        goto L92
    L14:
        if (arg.equals("--isUserAppAspectRatioSettingsEnabled") == false) goto L183;
        r1 = ParameterName.BLUE_STRETCH;
        goto L92
    L183:
        r1 = -1;
        goto L92
    L17:
        if (arg.equals("--horizontalPositionMultiplier") == false) goto L184;
        r1 = 8;
        goto L92
    L184:
        r1 = -1;
        goto L92
    L20:
        if (arg.equals("--minAspectRatioForUnresizable") == false) goto L185;
        r1 = 1;
        goto L92
    L185:
        r1 = -1;
        goto L92
    L23:
        if (arg.equals("--backgroundColorResource") == false) goto L186;
        r1 = 5;
        goto L92
    L186:
        r1 = -1;
        goto L92
    L26:
        if (arg.equals("--isCameraCompatRefreshCycleThroughStopEnabled") == false) goto L187;
        r1 = ParameterName.GLOBE_DIMMING;
        goto L92
    L187:
        r1 = -1;
        goto L92
    L29:
        if (arg.equals("--isCameraCompatFreeformWindowingTreatmentEnabled") == false) goto L188;
        r1 = ParameterName.AUTO_SUPER_RESOLUTION_ENABLED;
        goto L92
    L188:
        r1 = -1;
        goto L92
    L32:
        if (arg.equals("--persistentPositionForHorizontalReachability") == false) goto L189;
        r1 = 15;
        goto L92
    L189:
        r1 = -1;
        goto L92
    L35:
        if (arg.equals("--backgroundColor") == false) goto L190;
        r1 = 4;
        goto L92
    L190:
        r1 = -1;
        goto L92
    L38:
        if (arg.equals("--isTranslucentLetterboxingEnabled") == false) goto L191;
        r1 = ParameterName.BLACK_STRETCH;
        goto L92
    L191:
        r1 = -1;
        goto L92
    L41:
        if (arg.equals("--wallpaperDarkScrimAlpha") == false) goto L192;
        r1 = 7;
        goto L92
    L192:
        r1 = -1;
        goto L92
    L44:
        if (arg.equals("--isVerticalReachabilityEnabled") == false) goto L193;
        r1 = 11;
        goto L92
    L193:
        r1 = -1;
        goto L92
    L47:
        if (arg.equals("--isHorizontalReachabilityEnabled") == false) goto L194;
        r1 = 10;
        goto L92
    L194:
        r1 = -1;
        goto L92
    L50:
        if (arg.equals("--isUserAppAspectRatioFullscreenEnabled") == false) goto L195;
        r1 = ParameterName.COLOR_TUNE;
        goto L92
    L195:
        r1 = -1;
        goto L92
    L53:
        if (arg.equals("--wallpaperBlurRadius") == false) goto L196;
        r1 = 6;
        goto L92
    L196:
        r1 = -1;
        goto L92
    L56:
        if (arg.equals("--isSplitScreenAspectRatioForUnresizableAppsEnabled") == false) goto L197;
        r1 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L92
    L197:
        r1 = -1;
        goto L92
    L59:
        if (arg.equals("--backgroundType") == false) goto L198;
        r1 = 3;
        goto L92
    L198:
        r1 = -1;
        goto L92
    L62:
        if (arg.equals("--cornerRadius") == false) goto L199;
        r1 = 2;
        goto L92
    L199:
        r1 = -1;
        goto L92
    L65:
        if (arg.equals("--persistentPositionForVerticalReachability") == false) goto L200;
        r1 = 16;
        goto L92
    L200:
        r1 = -1;
        goto L92
    L68:
        if (arg.equals("--defaultPositionForHorizontalReachability") == false) goto L201;
        r1 = 13;
        goto L92
    L201:
        r1 = -1;
        goto L92
    L71:
        if (arg.equals("--isCameraCompatRefreshEnabled") == false) goto L202;
        r1 = ParameterName.COLOR_TEMPERATURE;
        goto L92
    L202:
        r1 = -1;
        goto L92
    L74:
        if (arg.equals("--isDisplayAspectRatioEnabledForFixedOrientationLetterbox") == false) goto L203;
        r1 = ParameterName.FILM_MODE;
        goto L92
    L203:
        r1 = -1;
        goto L92
    L77:
        if (arg.equals("--defaultPositionForVerticalReachability") == false) goto L204;
        r1 = 14;
        goto L92
    L204:
        r1 = -1;
        goto L92
    L80:
        if (arg.equals("--verticalPositionMultiplier") == false) goto L205;
        r1 = 9;
        goto L92
    L205:
        r1 = -1;
        goto L92
    L83:
        if (arg.equals("--isEducationEnabled") == false) goto L206;
        r1 = ParameterName.DE_CONTOUR;
        goto L92
    L206:
        r1 = -1;
        goto L92
    L86:
        if (arg.equals("--aspectRatio") == true) goto L92;
        r1 = -1;
        goto L92
    L89:
        if (arg.equals("--cameraCompatAspectRatio") == false) goto L208;
        r1 = ParameterName.AUTO_PICTUREQUALITY_ENABLED;
        goto L92
    L208:
        r1 = -1;
        goto L92
    L123:
        return 0;
    }

    private int runResetLetterboxStyle(PrintWriter pw) throws RemoteException {
        if (peekNextArg() != null) goto L5;
        resetLetterboxStyle();
    L5:
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
    L127:
        byte r2 = 0;
        if (peekNextArg() == null) goto L121;
        String arg = getNextArg();     // Catch: Throwable -> L15
        switch(arg.hashCode()) {
            case -2064669968: goto L87;
            case -1229148346: goto L84;
            case -1135892646: goto L81;
            case -1124529213: goto L78;
            case -1034497596: goto L75;
            case -567226646: goto L72;
            case -563782898: goto L69;
            case -559641828: goto L66;
            case -104178420: goto L63;
            case -39374981: goto L60;
            case 208616300: goto L57;
            case 579099418: goto L54;
            case 583595847: goto L51;
            case 691402838: goto L48;
            case 814923786: goto L45;
            case 883700309: goto L42;
            case 1092174483: goto L39;
            case 1109312992: goto L36;
            case 1287124693: goto L33;
            case 1396867991: goto L30;
            case 1427509640: goto L27;
            case 1869151343: goto L24;
            case 1870284982: goto L21;
            case 1892753783: goto L18;
            case 2102105247: goto L13;
            default: goto L89;
        };     // Catch: Throwable -> L15
    L89:
        r2 = -1;
    L90:
        switch(r2) {
            case 0: goto L119;
            case 1: goto L118;
            case 2: goto L117;
            case 3: goto L116;
            case 4: goto L115;
            case 5: goto L114;
            case 6: goto L113;
            case 7: goto L112;
            case 8: goto L111;
            case 9: goto L110;
            case 10: goto L109;
            case 11: goto L108;
            case 12: goto L107;
            case 13: goto L106;
            case 14: goto L105;
            case 15: goto L104;
            case 16: goto L103;
            case 17: goto L102;
            case 18: goto L101;
            case 19: goto L100;
            case 20: goto L99;
            case 21: goto L98;
            case 22: goto L97;
            case 23: goto L96;
            case 24: goto L95;
            default: goto L91;
        };     // Catch: Throwable -> L15
    L95:
        this.mAppCompatConfiguration.resetIsCameraCompatFreeformWindowingTreatmentEnabled();     // Catch: Throwable -> L15
        goto L127
    L96:
        this.mAppCompatConfiguration.resetCameraCompatAspectRatio();     // Catch: Throwable -> L15
        goto L127
    L97:
        this.mAppCompatConfiguration.resetCameraCompatRefreshCycleThroughStopEnabled();     // Catch: Throwable -> L15
        goto L127
    L98:
        this.mAppCompatConfiguration.resetCameraCompatRefreshEnabled();     // Catch: Throwable -> L15
        goto L127
    L99:
        this.mAppCompatConfiguration.resetUserAppAspectRatioFullscreenEnabled();     // Catch: Throwable -> L15
        goto L127
    L100:
        this.mAppCompatConfiguration.resetUserAppAspectRatioSettingsEnabled();     // Catch: Throwable -> L15
        goto L127
    L101:
        this.mAppCompatConfiguration.resetTranslucentLetterboxingEnabled();     // Catch: Throwable -> L15
        goto L127
    L102:
        this.mAppCompatConfiguration.resetIsDisplayAspectRatioEnabledForFixedOrientationLetterbox();     // Catch: Throwable -> L15
        goto L127
    L103:
        this.mAppCompatConfiguration.resetIsSplitScreenAspectRatioForUnresizableAppsEnabled();     // Catch: Throwable -> L15
        goto L127
    L104:
        this.mAppCompatConfiguration.resetIsEducationEnabled();     // Catch: Throwable -> L15
        goto L127
    L105:
        this.mAppCompatConfiguration.resetPersistentLetterboxPositionForVerticalReachability();     // Catch: Throwable -> L15
        goto L127
    L106:
        this.mAppCompatConfiguration.resetPersistentLetterboxPositionForHorizontalReachability();     // Catch: Throwable -> L15
        goto L127
    L107:
        this.mAppCompatConfiguration.resetDefaultPositionForVerticalReachability();     // Catch: Throwable -> L15
        goto L127
    L108:
        this.mAppCompatConfiguration.resetDefaultPositionForHorizontalReachability();     // Catch: Throwable -> L15
        goto L127
    L109:
        this.mAppCompatConfiguration.resetIsVerticalReachabilityEnabled();     // Catch: Throwable -> L15
        goto L127
    L110:
        this.mAppCompatConfiguration.resetIsHorizontalReachabilityEnabled();     // Catch: Throwable -> L15
        goto L127
    L111:
        this.mAppCompatConfiguration.resetLetterboxVerticalPositionMultiplier();     // Catch: Throwable -> L15
        goto L127
    L112:
        this.mAppCompatConfiguration.resetLetterboxHorizontalPositionMultiplier();     // Catch: Throwable -> L15
        goto L127
    L113:
        this.mAppCompatConfiguration.resetLetterboxBackgroundWallpaperDarkScrimAlpha();     // Catch: Throwable -> L15
        goto L127
    L114:
        this.mAppCompatConfiguration.resetLetterboxBackgroundWallpaperBlurRadiusPx();     // Catch: Throwable -> L15
        goto L127
    L115:
        this.mAppCompatConfiguration.resetLetterboxBackgroundColor();     // Catch: Throwable -> L15
        goto L127
    L116:
        this.mAppCompatConfiguration.resetLetterboxBackgroundType();     // Catch: Throwable -> L15
        goto L127
    L117:
        this.mAppCompatConfiguration.resetLetterboxActivityCornersRadius();     // Catch: Throwable -> L15
        goto L127
    L118:
        this.mAppCompatConfiguration.resetDefaultMinAspectRatioForUnresizableApps();     // Catch: Throwable -> L15
        goto L127
    L119:
        this.mAppCompatConfiguration.resetFixedOrientationLetterboxAspectRatio();     // Catch: Throwable -> L15
        goto L127
    L91:
        getErrPrintWriter().println("Error: Unrecognized letterbox style option: " + arg);     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return -1;
    L13:
        if (arg.equals("isUserAppAspectRatioFullscreenEnabled") == false) goto L89;
        r2 = ParameterName.BLACK_STRETCH;
        goto L90
    L18:
        if (arg.equals("isUserAppAspectRatioSettingsEnabled") == false) goto L89;
        r2 = ParameterName.FILM_MODE;
        goto L90
    L21:
        if (arg.equals("isCameraCompatRefreshCycleThroughStopEnabled") == false) goto L89;
        r2 = ParameterName.COLOR_TUNE;
        goto L90
    L24:
        if (arg.equals("isSplitScreenAspectRatioForUnresizableAppsEnabled") == false) goto L89;
        r2 = 16;
        goto L90
    L27:
        if (arg.equals("backgroundType") == false) goto L89;
        r2 = 3;
        goto L90
    L30:
        if (arg.equals("isCameraCompatRefreshEnabled") == false) goto L89;
        r2 = ParameterName.BLUE_STRETCH;
        goto L90
    L33:
        if (arg.equals("backgroundColor") == false) goto L89;
        r2 = 4;
        goto L90
    L36:
        if (arg.equals("verticalPositionMultiplier") == false) goto L89;
        r2 = 8;
        goto L90
    L39:
        if (arg.equals("aspectRatio") == false) goto L89;
    L42:
        if (arg.equals("isTranslucentLetterboxingEnabled") == false) goto L89;
        r2 = ParameterName.DYNAMIC_LUMA_CONTROL;
        goto L90
    L45:
        if (arg.equals("isVerticalReachabilityEnabled") == false) goto L89;
        r2 = 10;
        goto L90
    L48:
        if (arg.equals("persistentPositionForVerticalReachability") == false) goto L89;
        r2 = 14;
        goto L90
    L51:
        if (arg.equals("cornerRadius") == false) goto L89;
        r2 = 2;
        goto L90
    L54:
        if (arg.equals("isCameraCompatFreeformWindowingTreatmentEnabled") == false) goto L89;
        r2 = ParameterName.GLOBE_DIMMING;
        goto L90
    L57:
        if (arg.equals("defaultPositionForVerticalReachability") == false) goto L89;
        r2 = 12;
        goto L90
    L60:
        if (arg.equals("wallpaperBlurRadius") == false) goto L89;
        r2 = 5;
        goto L90
    L63:
        if (arg.equals("cameraCompatAspectRatio") == false) goto L89;
        r2 = ParameterName.COLOR_TEMPERATURE;
        goto L90
    L66:
        if (arg.equals("isHorizontalReachabilityEnabled") == false) goto L89;
        r2 = 9;
        goto L90
    L69:
        if (arg.equals("horizontalPositionMultiplier") == false) goto L89;
        r2 = 7;
        goto L90
    L72:
        if (arg.equals("minAspectRatioForUnresizable") == false) goto L89;
        r2 = 1;
        goto L90
    L75:
        if (arg.equals("persistentPositionForHorizontalReachability") == false) goto L89;
        r2 = 13;
        goto L90
    L78:
        if (arg.equals("isEducationEnabled") == false) goto L89;
        r2 = 15;
        goto L90
    L81:
        if (arg.equals("defaultPositionForHorizontalReachability") == false) goto L89;
        r2 = 11;
        goto L90
    L84:
        if (arg.equals("IsDisplayAspectRatioEnabledForFixedOrientationLetterbox") == false) goto L89;
        r2 = ParameterName.DE_CONTOUR;
        goto L90
    L87:
        if (arg.equals("wallpaperDarkScrimAlpha") == false) goto L89;
        r2 = 6;
        goto L90
    L121:
        monitor-exit(r0);     // Catch: Throwable -> L15
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L15:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private int runSetMultiWindowConfig() {
        if (peekNextArg() != null) goto L5;
        getErrPrintWriter().println("Error: No arguments provided.");
    L5:
        int result = 0;
    L6:
        byte r2 = 0;
        if (peekNextArg() == null) goto L24;
        String arg = getNextArg();
        switch(arg.hashCode()) {
            case 1485032610: goto L15;
            case 1714039607: goto L12;
            default: goto L17;
        };
    L17:
        r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L22;
            case 1: goto L21;
            default: goto L19;
        };
    L19:
        getErrPrintWriter().println("Error: Unrecognized multi window option: " + arg);
        return -1;
    L22:
        result = result + runSetSupportsNonResizableMultiWindow();
        goto L6
    L21:
        result = result + runSetRespectsActivityMinWidthHeightMultiWindow();
        goto L6
    L12:
        if (arg.equals("--respectsActivityMinWidthHeight") == false) goto L35;
        r2 = 1;
        goto L18
    L35:
        r2 = -1;
        goto L18
    L15:
        if (arg.equals("--supportsNonResizable") == true) goto L18;
        r2 = -1;
        goto L18
    L24:
        if (result != 0) goto L27;
        return 0;
    L27:
        return -1;
    }

    private int runSetSupportsNonResizableMultiWindow() {
        String arg = getNextArg();
        if (arg.equals("-1") == false) goto L5;
    L10:
        int configValue = Integer.parseInt(arg);
        WindowManagerGlobalLock r2 = this.mInternal.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mInternal.mAtmService.mSupportsNonResizableMultiWindow = configValue;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (arg.equals("0") == true) goto L10;
        if (arg.equals("1") == true) goto L10;
        getErrPrintWriter().println("Error: a config value of [-1, 0, 1] must be provided as an argument for supportsNonResizableMultiWindow");
        return -1;
    }

    private int runSetRespectsActivityMinWidthHeightMultiWindow() {
        String arg = getNextArg();
        if (arg.equals("-1") == false) goto L5;
    L10:
        int configValue = Integer.parseInt(arg);
        WindowManagerGlobalLock r2 = this.mInternal.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mInternal.mAtmService.mRespectsActivityMinWidthHeightMultiWindow = configValue;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L16:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    L5:
        if (arg.equals("0") == true) goto L10;
        if (arg.equals("1") == true) goto L10;
        getErrPrintWriter().println("Error: a config value of [-1, 0, 1] must be provided as an argument for respectsActivityMinWidthHeightMultiWindow");
        return -1;
    }

    private int runGetMultiWindowConfig(PrintWriter pw) {
        WindowManagerGlobalLock r0 = this.mInternal.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        pw.println("Supports non-resizable in multi window: " + this.mInternal.mAtmService.mSupportsNonResizableMultiWindow);     // Catch: Throwable -> L8
        pw.println("Respects activity min width/height in multi window: " + this.mInternal.mAtmService.mRespectsActivityMinWidthHeightMultiWindow);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private int runResetMultiWindowConfig() {
        int supportsNonResizable = this.mInternal.mContext.getResources().getInteger(R.integer.config_vibratorControlServiceDumpSizeLimit);
        int respectsActivityMinWidthHeight = this.mInternal.mContext.getResources().getInteger(R.integer.config_screenBrightnessDim);
        WindowManagerGlobalLock r2 = this.mInternal.mAtmService.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r2);
        this.mInternal.mAtmService.mSupportsNonResizableMultiWindow = supportsNonResizable;     // Catch: Throwable -> L8
        this.mInternal.mAtmService.mRespectsActivityMinWidthHeightMultiWindow = respectsActivityMinWidthHeight;     // Catch: Throwable -> L8
        monitor-exit(r2);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private void resetLetterboxStyle() {
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        this.mAppCompatConfiguration.resetFixedOrientationLetterboxAspectRatio();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetDefaultMinAspectRatioForUnresizableApps();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxActivityCornersRadius();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxBackgroundType();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxBackgroundColor();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxBackgroundWallpaperBlurRadiusPx();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxBackgroundWallpaperDarkScrimAlpha();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxHorizontalPositionMultiplier();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetLetterboxVerticalPositionMultiplier();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsHorizontalReachabilityEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsVerticalReachabilityEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetEnabledAutomaticReachabilityInBookMode();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetDefaultPositionForHorizontalReachability();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetDefaultPositionForVerticalReachability();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetPersistentLetterboxPositionForHorizontalReachability();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetPersistentLetterboxPositionForVerticalReachability();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsEducationEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsSplitScreenAspectRatioForUnresizableAppsEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsDisplayAspectRatioEnabledForFixedOrientationLetterbox();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetTranslucentLetterboxingEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetUserAppAspectRatioSettingsEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetUserAppAspectRatioFullscreenEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetCameraCompatRefreshEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetCameraCompatRefreshCycleThroughStopEnabled();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetCameraCompatAspectRatio();     // Catch: Throwable -> L8
        this.mAppCompatConfiguration.resetIsCameraCompatFreeformWindowingTreatmentEnabled();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private int runGetLetterboxStyle(PrintWriter pw) throws RemoteException {
        WindowManagerGlobalLock r0 = this.mInternal.mGlobalLock;
        WindowManagerService.boostPriorityForLockedSection();
        monitor-enter(r0);
        pw.println("Corner radius: " + this.mAppCompatConfiguration.getLetterboxActivityCornersRadius());     // Catch: Throwable -> L8
        pw.println("Horizontal position multiplier: " + this.mAppCompatConfiguration.getLetterboxHorizontalPositionMultiplier(false));     // Catch: Throwable -> L8
        pw.println("Vertical position multiplier: " + this.mAppCompatConfiguration.getLetterboxVerticalPositionMultiplier(false));     // Catch: Throwable -> L8
        pw.println("Horizontal position multiplier (book mode): " + this.mAppCompatConfiguration.getLetterboxHorizontalPositionMultiplier(true));     // Catch: Throwable -> L8
        pw.println("Vertical position multiplier (tabletop mode): " + this.mAppCompatConfiguration.getLetterboxVerticalPositionMultiplier(true));     // Catch: Throwable -> L8
        pw.println("Horizontal position multiplier for reachability: " + this.mAppCompatConfiguration.getHorizontalMultiplierForReachability(false));     // Catch: Throwable -> L8
        pw.println("Vertical position multiplier for reachability: " + this.mAppCompatConfiguration.getVerticalMultiplierForReachability(false));     // Catch: Throwable -> L8
        pw.println("Aspect ratio: " + this.mAppCompatConfiguration.getFixedOrientationLetterboxAspectRatio());     // Catch: Throwable -> L8
        pw.println("Default min aspect ratio for unresizable apps: " + this.mAppCompatConfiguration.getDefaultMinAspectRatioForUnresizableApps());     // Catch: Throwable -> L8
        pw.println("Is horizontal reachability enabled: " + this.mAppCompatConfiguration.getIsHorizontalReachabilityEnabled());     // Catch: Throwable -> L8
        pw.println("Is vertical reachability enabled: " + this.mAppCompatConfiguration.getIsVerticalReachabilityEnabled());     // Catch: Throwable -> L8
        pw.println("Is automatic reachability in book mode enabled: " + this.mAppCompatConfiguration.getIsAutomaticReachabilityInBookModeEnabled());     // Catch: Throwable -> L8
        pw.println("Default position for horizontal reachability: " + AppCompatConfiguration.letterboxHorizontalReachabilityPositionToString(this.mAppCompatConfiguration.getDefaultPositionForHorizontalReachability()));     // Catch: Throwable -> L8
        pw.println("Default position for vertical reachability: " + AppCompatConfiguration.letterboxVerticalReachabilityPositionToString(this.mAppCompatConfiguration.getDefaultPositionForVerticalReachability()));     // Catch: Throwable -> L8
        pw.println("Current position for horizontal reachability:" + AppCompatConfiguration.letterboxHorizontalReachabilityPositionToString(this.mAppCompatConfiguration.getLetterboxPositionForHorizontalReachability(false)));     // Catch: Throwable -> L8
        pw.println("Current position for vertical reachability:" + AppCompatConfiguration.letterboxVerticalReachabilityPositionToString(this.mAppCompatConfiguration.getLetterboxPositionForVerticalReachability(false)));     // Catch: Throwable -> L8
        pw.println("Is education enabled: " + this.mAppCompatConfiguration.getIsEducationEnabled());     // Catch: Throwable -> L8
        pw.println("Is using split screen aspect ratio as aspect ratio for unresizable apps: " + this.mAppCompatConfiguration.getIsSplitScreenAspectRatioForUnresizableAppsEnabled());     // Catch: Throwable -> L8
        pw.println("Is using display aspect ratio as aspect ratio for all letterboxed apps: " + this.mAppCompatConfiguration.getIsDisplayAspectRatioEnabledForFixedOrientationLetterbox());     // Catch: Throwable -> L8
        pw.println("    Is activity \"refresh\" in camera compatibility treatment enabled: " + this.mAppCompatConfiguration.isCameraCompatRefreshEnabled());     // Catch: Throwable -> L8
        pw.println("    Refresh using \"stopped -> resumed\" cycle: " + this.mAppCompatConfiguration.isCameraCompatRefreshCycleThroughStopEnabled());     // Catch: Throwable -> L8
        pw.println("Background type: " + AppCompatConfiguration.letterboxBackgroundTypeToString(this.mAppCompatConfiguration.getLetterboxBackgroundType()));     // Catch: Throwable -> L8
        pw.println("    Background color: " + Integer.toHexString(this.mAppCompatConfiguration.getLetterboxBackgroundColor().toArgb()));     // Catch: Throwable -> L8
        pw.println("    Wallpaper blur radius: " + this.mAppCompatConfiguration.getLetterboxBackgroundWallpaperBlurRadiusPx());     // Catch: Throwable -> L8
        pw.println("    Wallpaper dark scrim alpha: " + this.mAppCompatConfiguration.getLetterboxBackgroundWallpaperDarkScrimAlpha());     // Catch: Throwable -> L8
        pw.println("Is letterboxing for translucent activities enabled: " + this.mAppCompatConfiguration.isTranslucentLetterboxingEnabled());     // Catch: Throwable -> L8
        pw.println("Is the user aspect ratio settings enabled: " + this.mAppCompatConfiguration.isUserAppAspectRatioSettingsEnabled());     // Catch: Throwable -> L8
        pw.println("Is the fullscreen option in user aspect ratio settings enabled: " + this.mAppCompatConfiguration.isUserAppAspectRatioFullscreenEnabled());     // Catch: Throwable -> L8
        pw.println("Default aspect ratio for camera compat freeform: " + this.mAppCompatConfiguration.getCameraCompatAspectRatio());     // Catch: Throwable -> L8
        pw.println("Is camera compatibility freeform treatment enabled for all apps: " + this.mAppCompatConfiguration.isCameraCompatFreeformWindowingTreatmentEnabled());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        WindowManagerService.resetPriorityAfterLockedSection();
        return 0;
    L8:
        th = move-exception;
        WindowManagerService.resetPriorityAfterLockedSection();
        throw th;
    }

    private int runSetDisplayWindowingMode(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArgRequired();
        if ("-d".equals(arg) == false) goto L5;
        displayId = Integer.parseInt(getNextArgRequired());
        arg = getNextArgRequired();
    L5:
        int windowingMode = Integer.parseInt(arg);
        this.mInterface.setWindowingMode(displayId, windowingMode);
        return 0;
    }

    private int runGetDisplayWindowingMode(PrintWriter pw) throws RemoteException {
        int displayId = 0;
        String arg = getNextArg();
        if ("-d".equals(arg) == false) goto L5;
        displayId = Integer.parseInt(getNextArgRequired());
    L5:
        int windowingMode = this.mInterface.getWindowingMode(displayId);
        pw.println("display windowing mode=" + WindowConfiguration.windowingModeToString(windowingMode) + " for displayId=" + displayId);
        return 0;
    }

    private int runWmShellCommand(PrintWriter pw) {
        String[] args = peekRemainingArgs();
        ArrayList<String> sbArgs = new ArrayList();
        sbArgs.add("wmshell-passthrough");
        sbArgs.addAll(Arrays.asList(args));
        this.mInternal.mAtmService.getStatusBarManagerInternal().passThroughShellCommand((String[]) sbArgs.toArray(new String[0]), getOutFileDescriptor());
        return 0;
    }

    private int runDumpWmTrace() {
        this.mInternal.getExt().dumpWmTrace();
        return 0;
    }

    private int runReset(PrintWriter pw) throws RemoteException {
        int displayId = getDisplayId(getNextArg());
        this.mInterface.clearForcedDisplaySize(displayId);
        this.mInterface.clearForcedDisplayDensityForUser(displayId, -2);
        this.mInternal.setOverrideFoldedArea(new Rect());
        this.mInterface.setForcedDisplayScalingMode(displayId, 0);
        this.mInternal.thawDisplayRotation(displayId, "WindowManagerShellCommand#runReset");
        this.mInterface.setFixedToUserRotation(displayId, 0);
        this.mInternal.resetIgnoreOrientationRequest(displayId);
        resetLetterboxStyle();
        this.mInternal.setSandboxDisplayApis(displayId, true);
        runResetMultiWindowConfig();
        this.mInternal.setWindowingMode(displayId, 0);
        pw.println("Reset all settings for displayId=" + displayId);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Window manager (window) commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  size [reset|WxH|WdpxHdp] [-d DISPLAY_ID]");
        pw.println("    Return or override display size.");
        pw.println("    width and height in pixels unless suffixed with 'dp'.");
        pw.println("  density [reset|DENSITY] [-d DISPLAY_ID] [-u UNIQUE_ID]");
        pw.println("    Return or override display density.");
        pw.println("  folded-area [reset|LEFT,TOP,RIGHT,BOTTOM]");
        pw.println("    Return or override folded area.");
        pw.println("  scaling [off|auto] [-d DISPLAY_ID]");
        pw.println("    Set display scaling mode.");
        pw.println("  dismiss-keyguard");
        pw.println("    Dismiss the keyguard, prompting user for auth if necessary.");
        pw.println("  disable-blur [true|1|false|0]");
        pw.println("  user-rotation [-d DISPLAY_ID] [free|lock] [rotation]");
        pw.println("    Print or set user rotation mode and user rotation.");
        pw.println("  dump-visible-window-views");
        pw.println("    Dumps the encoded view hierarchies of visible windows");
        pw.println("  fixed-to-user-rotation [-d DISPLAY_ID] [enabled|disabled|default");
        pw.println("      |enabled_if_no_auto_rotation]");
        pw.println("    Print or set rotating display for app requested orientation.");
        pw.println("  set-ignore-orientation-request [-d DISPLAY_ID] [reset|true|1|false|0]");
        pw.println("  get-ignore-orientation-request [-d DISPLAY_ID] ");
        pw.println("    If app requested orientation should be ignored.");
        pw.println("  set-sandbox-display-apis [true|1|false|0]");
        pw.println("    Sets override of Display APIs getRealSize / getRealMetrics to reflect ");
        pw.println("    DisplayArea of the activity, or the window bounds if in letterbox or");
        pw.println("    Size Compat Mode.");
        printLetterboxHelp(pw);
        printMultiWindowConfigHelp(pw);
        pw.println("  reset-freeze-recent-tasks");
        pw.println("    Resets the spatial ordering of the recent tasks list");
        pw.println("  set-display-windowing-mode [-d DISPLAY_ID] [mode_id]");
        pw.println("    As mode_id, use 0 for undefined, 5 for freeform, 1 for fullscreen");
        pw.println("  get-display-windowing-mode [-d DISPLAY_ID]");
        pw.println("  reset [-d DISPLAY_ID]");
        pw.println("    Reset all override settings.");
        pw.println("  shell <cmd> ...");
        pw.println("    Runs a WMShell command.  To see a full list of available wmshell commands run 'adb shell wm shell help'");
        if (Build.IS_USER == true) goto L6;
        pw.println("  tracing (start | stop)");
        pw.println("    Start or stop window tracing.");
        pw.println("  logging (start | stop | enable | disable | enable-text | disable-text)");
        pw.println("    Logging settings.");
        return;
    }

    private void printLetterboxHelp(PrintWriter pw) {
        pw.println("  set-letterbox-style");
        pw.println("    Sets letterbox style using the following options:");
        pw.println("      --aspectRatio aspectRatio");
        pw.println("        Aspect ratio of letterbox for fixed orientation. If aspectRatio <= 1.0");
        pw.println("        both it and R.dimen.config_fixedOrientationLetterboxAspectRatio will");
        pw.println("        be ignored and framework implementation will determine aspect ratio.");
        pw.println("      --minAspectRatioForUnresizable aspectRatio");
        pw.println("        Default min aspect ratio for unresizable apps which is used when an");
        pw.println("        app is eligible for the size compat mode.  If aspectRatio <= 1.0");
        pw.println("        both it and R.dimen.config_fixedOrientationLetterboxAspectRatio will");
        pw.println("        be ignored and framework implementation will determine aspect ratio.");
        pw.println("      --cornerRadius radius");
        pw.println("        Corners radius (in pixels) for activities in the letterbox mode.");
        pw.println("        If radius < 0, both R.integer.config_letterboxActivityCornersRadius");
        pw.println("        and it will be ignored and corners of the activity won't be rounded.");
        pw.println("      --backgroundType [reset|solid_color|app_color_background");
        pw.println("          |app_color_background_floating|wallpaper]");
        pw.println("        Type of background used in the letterbox mode.");
        pw.println("      --backgroundColor color");
        pw.println("        Color of letterbox which is be used when letterbox background type");
        pw.println("        is 'solid-color'. Use (set)get-letterbox-style to check and control");
        pw.println("        letterbox background type. See Color#parseColor for allowed color");
        pw.println("        formats (#RRGGBB and some colors by name, e.g. magenta or olive).");
        pw.println("      --backgroundColorResource resource_name");
        pw.println("        Color resource name of letterbox background which is used when");
        pw.println("        background type is 'solid-color'. Use (set)get-letterbox-style to");
        pw.println("        check and control background type. Parameter is a color resource");
        pw.println("        name, for example, @android:color/system_accent2_50.");
        pw.println("      --wallpaperBlurRadius radius");
        pw.println("        Blur radius for 'wallpaper' letterbox background. If radius <= 0");
        pw.println("        both it and R.dimen.config_letterboxBackgroundWallpaperBlurRadius");
        pw.println("        are ignored and 0 is used.");
        pw.println("      --wallpaperDarkScrimAlpha alpha");
        pw.println("        Alpha of a black translucent scrim shown over 'wallpaper'");
        pw.println("        letterbox background. If alpha < 0 or >= 1 both it and");
        pw.println("        R.dimen.config_letterboxBackgroundWallaperDarkScrimAlpha are ignored");
        pw.println("        and 0.0 (transparent) is used instead.");
        pw.println("      --horizontalPositionMultiplier multiplier");
        pw.println("        Horizontal position of app window center. If multiplier < 0 or > 1,");
        pw.println("        both it and R.dimen.config_letterboxHorizontalPositionMultiplier");
        pw.println("        are ignored and central position (0.5) is used.");
        pw.println("      --verticalPositionMultiplier multiplier");
        pw.println("        Vertical position of app window center. If multiplier < 0 or > 1,");
        pw.println("        both it and R.dimen.config_letterboxVerticalPositionMultiplier");
        pw.println("        are ignored and central position (0.5) is used.");
        pw.println("      --isHorizontalReachabilityEnabled [true|1|false|0]");
        pw.println("        Whether horizontal reachability repositioning is allowed for ");
        pw.println("        letterboxed fullscreen apps in landscape device orientation.");
        pw.println("      --isVerticalReachabilityEnabled [true|1|false|0]");
        pw.println("        Whether vertical reachability repositioning is allowed for ");
        pw.println("        letterboxed fullscreen apps in portrait device orientation.");
        pw.println("      --defaultPositionForHorizontalReachability [left|center|right]");
        pw.println("        Default position of app window when horizontal reachability is.");
        pw.println("        enabled.");
        pw.println("      --defaultPositionForVerticalReachability [top|center|bottom]");
        pw.println("        Default position of app window when vertical reachability is.");
        pw.println("        enabled.");
        pw.println("      --persistentPositionForHorizontalReachability [left|center|right]");
        pw.println("        Persistent position of app window when horizontal reachability is.");
        pw.println("        enabled.");
        pw.println("      --persistentPositionForVerticalReachability [top|center|bottom]");
        pw.println("        Persistent position of app window when vertical reachability is.");
        pw.println("        enabled.");
        pw.println("      --isEducationEnabled [true|1|false|0]");
        pw.println("        Whether education is allowed for letterboxed fullscreen apps.");
        pw.println("      --isSplitScreenAspectRatioForUnresizableAppsEnabled [true|1|false|0]");
        pw.println("        Whether using split screen aspect ratio as a default aspect ratio for");
        pw.println("        unresizable apps.");
        pw.println("      --isTranslucentLetterboxingEnabled [true|1|false|0]");
        pw.println("        Whether letterboxing for translucent activities is enabled.");
        pw.println("      --isUserAppAspectRatioSettingsEnabled [true|1|false|0]");
        pw.println("        Whether user aspect ratio settings are enabled.");
        pw.println("      --isUserAppAspectRatioFullscreenEnabled [true|1|false|0]");
        pw.println("        Whether user aspect ratio fullscreen option is enabled.");
        pw.println("      --isCameraCompatRefreshEnabled [true|1|false|0]");
        pw.println("        Whether camera compatibility refresh is enabled.");
        pw.println("      --isCameraCompatRefreshCycleThroughStopEnabled [true|1|false|0]");
        pw.println("        Whether activity \"refresh\" in camera compatibility treatment should");
        pw.println("        happen using the \"stopped -> resumed\" cycle rather than");
        pw.println("        \"paused -> resumed\" cycle.");
        pw.println("      --cameraCompatAspectRatio aspectRatio");
        pw.println("        Aspect ratio of letterbox for fixed-orientation camera apps, during");
        pw.println("        freeform camera compat mode. If aspectRatio <= 1.0");
        pw.println("        it will be ignored.");
        pw.println("      --isCameraCompatFreeformWindowingTreatmentEnabled [true|1|false|0]");
        pw.println("        Whether camera compat treatment is enabled in freeform mode for all");
        pw.println("        eligible apps.");
        pw.println("  reset-letterbox-style [aspectRatio|cornerRadius|backgroundType");
        pw.println("      |backgroundColor|wallpaperBlurRadius|wallpaperDarkScrimAlpha");
        pw.println("      |horizontalPositionMultiplier|verticalPositionMultiplier");
        pw.println("      |isHorizontalReachabilityEnabled|isVerticalReachabilityEnabled");
        pw.println("      |isEducationEnabled|defaultPositionMultiplierForHorizontalReachability");
        pw.println("      |isTranslucentLetterboxingEnabled|isUserAppAspectRatioSettingsEnabled");
        pw.println("      |persistentPositionMultiplierForHorizontalReachability");
        pw.println("      |persistentPositionMultiplierForVerticalReachability");
        pw.println("      |defaultPositionMultiplierForVerticalReachability");
        pw.println("      |cameraCompatAspectRatio");
        pw.println("      |isCameraCompatFreeformWindowingTreatmentEnabled]");
        pw.println("    Resets overrides to default values for specified properties separated");
        pw.println("    by space, e.g. 'reset-letterbox-style aspectRatio cornerRadius'.");
        pw.println("    If no arguments provided, all values will be reset.");
        pw.println("  get-letterbox-style");
        pw.println("    Prints letterbox style configuration.");
    }

    private void printMultiWindowConfigHelp(PrintWriter pw) {
        pw.println("  set-multi-window-config");
        pw.println("    Sets options to determine if activity should be shown in multi window:");
        pw.println("      --supportsNonResizable [configValue]");
        pw.println("        Whether the device supports non-resizable activity in multi window.");
        pw.println("        -1: The device doesn't support non-resizable in multi window.");
        pw.println("         0: The device supports non-resizable in multi window only if");
        pw.println("            this is a large screen device.");
        pw.println("         1: The device always supports non-resizable in multi window.");
        pw.println("      --respectsActivityMinWidthHeight [configValue]");
        pw.println("        Whether the device checks the activity min width/height to determine ");
        pw.println("        if it can be shown in multi window.");
        pw.println("        -1: The device ignores the activity min width/height when determining");
        pw.println("            if it can be shown in multi window.");
        pw.println("         0: If this is a small screen, the device compares the activity min");
        pw.println("            width/height with the min multi window modes dimensions");
        pw.println("            the device supports to determine if the activity can be shown in");
        pw.println("            multi window.");
        pw.println("         1: The device always compare the activity min width/height with the");
        pw.println("            min multi window dimensions the device supports to determine if");
        pw.println("            the activity can be shown in multi window.");
        pw.println("  get-multi-window-config");
        pw.println("    Prints values of the multi window config options.");
        pw.println("  reset-multi-window-config");
        pw.println("    Resets overrides to default values of the multi window config options.");
    }
}
