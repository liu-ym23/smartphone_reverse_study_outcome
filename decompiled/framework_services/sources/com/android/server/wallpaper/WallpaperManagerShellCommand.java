package com.android.server.wallpaper;

import android.os.RemoteException;
import android.os.ShellCommand;
import android.util.Log;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperManagerShellCommand extends ShellCommand {
    private static final String TAG = "WallpaperManagerShellCommand";
    private final WallpaperManagerService mService;

    public WallpaperManagerShellCommand(WallpaperManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        byte r0 = 1;
        if (cmd != null) goto L7;
        onHelp();
        return 1;
    L7:
        switch(cmd.hashCode()) {
            case -1462105208: goto L25;
            case -296046994: goto L22;
            case 1499: goto L19;
            case 3198785: goto L16;
            case 191474821: goto L13;
            case 309630996: goto L10;
            default: goto L27;
        };
    L27:
        r0 = -1;
    L28:
        switch(r0) {
            case 0: goto L40;
            case 1: goto L38;
            case 2: goto L36;
            case 3: goto L34;
            case 4: goto L31;
            case 5: goto L31;
            default: goto L30;
        };
    L31:
        onHelp();
        return 0;
    L30:
        return handleDefaultCommands(cmd);
    L34:
        return this.mService.getExt().enableWPmsDebugConfig(this, getOutPrintWriter());
    L36:
        return getWallpaperDimAmount();
    L38:
        return setDimmingWithUid();
    L40:
        return setWallpaperDimAmount();
    L10:
        if (cmd.equals("get-dim-amount") == false) goto L27;
        r0 = 2;
        goto L28
    L13:
        if (cmd.equals("obric-wallpaper-log") == false) goto L27;
        r0 = 3;
        goto L28
    L16:
        if (cmd.equals("help") == false) goto L27;
        r0 = 5;
        goto L28
    L19:
        if (cmd.equals("-h") == false) goto L27;
        r0 = 4;
        goto L28
    L22:
        if (cmd.equals("dim-with-uid") == false) goto L27;
    L25:
        if (cmd.equals("set-dim-amount") == false) goto L27;
        r0 = 0;
        goto L28
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Wallpaper manager commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("  set-dim-amount DIMMING");
        pw.println("    Sets the current dimming value to DIMMING (a number between 0 and 1).");
        pw.println();
        pw.println("  dim-with-uid UID DIMMING");
        pw.println("    Sets the wallpaper dim amount to DIMMING as if an app with uid, UID, called it.");
        pw.println();
        pw.println("  get-dim-amount");
        pw.println("    Get the current wallpaper dim amount.");
    }

    private int setWallpaperDimAmount() {
        float dimAmount = Float.parseFloat(getNextArgRequired());
        this.mService.setWallpaperDimAmount(dimAmount);     // Catch: RemoteException -> L5
    L7:
        getOutPrintWriter().println("Dimming the wallpaper to: " + dimAmount);
        return 0;
    L6:
        Log.e(TAG, "Can't set wallpaper dim amount");
        goto L7
    }

    private int getWallpaperDimAmount() {
        float dimAmount = this.mService.getWallpaperDimAmount();
        getOutPrintWriter().println("The current wallpaper dim amount is: " + dimAmount);
        return 0;
    }

    private int setDimmingWithUid() {
        int mockUid = Integer.parseInt(getNextArgRequired());
        float mockDimAmount = Float.parseFloat(getNextArgRequired());
        this.mService.setWallpaperDimAmountForUid(mockUid, mockDimAmount);
        getOutPrintWriter().println("Dimming the wallpaper for UID: " + mockUid + " to: " + mockDimAmount);
        return 0;
    }
}
