package com.android.server.net.watchlist;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.provider.Settings;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.InputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class NetworkWatchlistShellCommand extends ShellCommand {
    final Context mContext;
    final NetworkWatchlistService mService;

    NetworkWatchlistShellCommand(NetworkWatchlistService service, Context context) {
        this.mContext = context;
        this.mService = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case 1757613042: goto L15;
            case 1854202282: goto L10;
            default: goto L17;
        };     // Catch: Exception -> L12
    L17:
        byte r2 = -1;
    L18:
        switch(r2) {
            case 0: goto L24;
            case 1: goto L22;
            default: goto L20;
        };     // Catch: Exception -> L12
    L20:
        return handleDefaultCommands(cmd);
    L22:
        return runForceGenerateReport();
    L24:
        return runSetTestConfig();
    L10:
        if (cmd.equals("force-generate-report") == false) goto L17;
        r2 = 1;
        goto L18
    L15:
        if (cmd.equals("set-test-config") == false) goto L17;
        r2 = 0;
        goto L18
    L4:
        return handleDefaultCommands(cmd);
    }

    private int runSetTestConfig() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String configXmlPath = getNextArgRequired();     // Catch: Exception -> L7
        ParcelFileDescriptor pfd = openFileForSystem(configXmlPath, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);     // Catch: Exception -> L7
        if (pfd != null) goto L9;
        pw.println("Error: can't open input file " + configXmlPath);     // Catch: Exception -> L7
        return -1;
    L9:
        InputStream inputStream = new ParcelFileDescriptor.AutoCloseInputStream(pfd);     // Catch: Exception -> L7
        WatchlistConfig.getInstance().setTestMode(inputStream);     // Catch: Throwable -> L14
        inputStream.close();     // Catch: Exception -> L7
        pw.println("Success!");     // Catch: Exception -> L7
        return 0;
    L14:
        th = move-exception;
        inputStream.close();     // Catch: Throwable -> L17
    L19:
        throw th;     // Catch: Exception -> L7
    L17:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L7
    L7:
        ex = move-exception;
        pw.println("Error: " + ex.toString());
        return -1;
    }

    private int runForceGenerateReport() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        long ident = Binder.clearCallingIdentity();
    L10:
        ex = move-exception;
        pw.println("Error: " + ex);     // Catch: Throwable -> L8
        Binder.restoreCallingIdentity(ident);
        return -1;
    L4:
        if (WatchlistConfig.getInstance().isConfigSecure() == false) goto L12;
        pw.println("Error: Cannot force generate report under production config");     // Catch: Throwable -> L8 Exception -> L10
        Binder.restoreCallingIdentity(ident);
        return -1;
    L12:
        Settings.Global.putLong(this.mContext.getContentResolver(), "network_watchlist_last_report_time", 0);     // Catch: Throwable -> L8 Exception -> L10
        this.mService.forceReportWatchlistForTest(System.currentTimeMillis());     // Catch: Throwable -> L8 Exception -> L10
        pw.println("Success!");     // Catch: Throwable -> L8 Exception -> L10
        Binder.restoreCallingIdentity(ident);
        return 0;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Network watchlist manager commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("  set-test-config your_watchlist_config.xml");
        pw.println("    Set network watchlist test config file.");
        pw.println("  force-generate-report");
        pw.println("    Force generate watchlist test report.");
    }
}
