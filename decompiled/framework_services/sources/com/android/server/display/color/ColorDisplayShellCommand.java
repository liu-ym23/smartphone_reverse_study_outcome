package com.android.server.display.color;

import android.content.pm.PackageManagerInternal;
import android.os.ShellCommand;
import com.android.server.LocalServices;

/* JADX INFO: loaded from: classes2.dex */
class ColorDisplayShellCommand extends ShellCommand {
    private static final int ERROR = -1;
    private static final int SUCCESS = 0;
    private static final String USAGE = "usage: cmd color_display SUBCOMMAND [ARGS]\n    help\n      Shows this message.\n    set-saturation LEVEL\n      Sets the device saturation to the given LEVEL, 0-100 inclusive.\n    set-layer-saturation LEVEL CALLER_PACKAGE TARGET_PACKAGE\n      Sets the saturation LEVEL for all layers of the TARGET_PACKAGE, attributed\n      to the CALLER_PACKAGE. The lowest LEVEL from any CALLER_PACKAGE is applied.\n";
    private final ColorDisplayService mService;

    ColorDisplayShellCommand(ColorDisplayService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case 245833689: goto L12;
            case 726170141: goto L9;
            default: goto L14;
        };
    L14:
        byte r0 = -1;
    L15:
        switch(r0) {
            case 0: goto L21;
            case 1: goto L19;
            default: goto L17;
        };
    L17:
        return handleDefaultCommands(cmd);
    L19:
        return setLayerSaturation();
    L21:
        return setSaturation();
    L9:
        if (cmd.equals("set-saturation") == false) goto L14;
        r0 = 0;
        goto L15
    L12:
        if (cmd.equals("set-layer-saturation") == false) goto L14;
        r0 = 1;
        goto L15
    }

    private int setSaturation() {
        int level = getLevel();
        if (level != (-1)) goto L5;
        return -1;
    L5:
        this.mService.setSaturationLevelInternal(level);
        return 0;
    }

    private int setLayerSaturation() {
        int level = getLevel();
        if (level != (-1)) goto L5;
        return -1;
    L5:
        String callerPackageName = getPackageName();
        if (callerPackageName != null) goto L9;
        getErrPrintWriter().println("Error: CALLER_PACKAGE must be an installed package name");
        return -1;
    L9:
        String targetPackageName = getPackageName();
        if (targetPackageName != null) goto L13;
        getErrPrintWriter().println("Error: TARGET_PACKAGE must be an installed package name");
        return -1;
    L13:
        this.mService.setAppSaturationLevelInternal(callerPackageName, targetPackageName, level);
        return 0;
    }

    private String getPackageName() {
        String packageNameArg = getNextArg();
        if (((PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class)).getPackage(packageNameArg) != null) goto L6;
        return null;
    L6:
        return packageNameArg;
    }

    private int getLevel() {
        String levelArg = getNextArg();
        if (levelArg != null) goto L17;
        getErrPrintWriter().println("Error: Required argument LEVEL is unspecified");
        return -1;
    L17:
        int level = Integer.parseInt(levelArg);     // Catch: NumberFormatException -> L14
        if (level >= 0) goto L9;
    L12:
        getErrPrintWriter().println("Error: LEVEL argument must be an integer between 0 and 100");
        return -1;
    L9:
        if (level > 100) goto L12;
        return level;
    L15:
        getErrPrintWriter().println("Error: LEVEL argument is not an integer");
        return -1;
    }

    public void onHelp() {
        getOutPrintWriter().print(USAGE);
    }
}
