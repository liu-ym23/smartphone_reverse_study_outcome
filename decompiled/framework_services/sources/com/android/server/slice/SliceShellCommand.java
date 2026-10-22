package com.android.server.slice;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.ShellCommand;
import android.util.ArraySet;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.obric.server.memorydata.MemoryManagerService;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class SliceShellCommand extends ShellCommand {
    private final SliceManagerService mService;

    public SliceShellCommand(SliceManagerService service) {
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -185318259: goto L9;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L15;
            default: goto L13;
        };
    L13:
        return 0;
    L15:
        return runGetPermissions(getNextArgRequired());
    L9:
        if (cmd.equals("get-permissions") == false) goto L11;
        r0 = 0;
        goto L12
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Status bar commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  get-permissions <authority>");
        pw.println("    List the pkgs that have permission to an authority.");
        pw.println("");
    }

    private int runGetPermissions(String authority) {
        if (Binder.getCallingUid() != 2000) goto L5;
    L8:
        Context context = this.mService.getContext();
        long ident = Binder.clearCallingIdentity();
        Uri uri = new Uri.Builder().scheme(ActivityTaskManagerInternal.ASSIST_KEY_CONTENT).authority(authority).build();     // Catch: Throwable -> L14
        if ("vnd.android.slice".equals(context.getContentResolver().getType(uri)) == true) goto L16;
        getOutPrintWriter().println(authority + " is not a slice provider");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return -1;
    L16:
        Bundle b = context.getContentResolver().call(uri, "get_permissions", null, null);     // Catch: Throwable -> L14
        if (b != null) goto L21;
        getOutPrintWriter().println("An error occurred getting permissions");     // Catch: Throwable -> L14
        Binder.restoreCallingIdentity(ident);
        return -1;
    L21:
        String[] permissions = b.getStringArray(MemoryManagerService.RESULT_KEY);     // Catch: Throwable -> L14
        PrintWriter pw = getOutPrintWriter();     // Catch: Throwable -> L14
        Set<String> listedPackages = new ArraySet();     // Catch: Throwable -> L14
        if (permissions != null) goto L24;
    L29:
        String[] r9 = this.mService.getAllPackagesGranted(authority);     // Catch: Throwable -> L14
        int r10 = r9.length;     // Catch: Throwable -> L14
        int r11 = 0;
    L30:
        if (r11 >= r10) goto L35;
        String pkg = r9[r11];     // Catch: Throwable -> L14
        if (listedPackages.contains(pkg) == true) goto L34;
        pw.println(pkg);     // Catch: Throwable -> L14
        listedPackages.add(pkg);     // Catch: Throwable -> L14
    L34:
        r11 = r11 + 1;
        goto L30
    L35:
        Binder.restoreCallingIdentity(ident);
        return 0;
    L24:
        if (permissions.length == 0) goto L29;
        List<PackageInfo> apps = context.getPackageManager().getPackagesHoldingPermissions(permissions, 0);     // Catch: Throwable -> L14
        Iterator<PackageInfo> r12 = apps.iterator();     // Catch: Throwable -> L14
    L27:
        if (r12.hasNext() == false) goto L29;
        PackageInfo app = r12.next();     // Catch: Throwable -> L14
        pw.println(app.packageName);     // Catch: Throwable -> L14
        listedPackages.add(app.packageName);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L5:
        if (Binder.getCallingUid() == 0) goto L8;
        getOutPrintWriter().println("Only shell can get permissions");
        return -1;
    }
}
