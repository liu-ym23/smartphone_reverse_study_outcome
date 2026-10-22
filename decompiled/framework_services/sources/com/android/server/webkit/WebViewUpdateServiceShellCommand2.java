package com.android.server.webkit;

import android.os.RemoteException;
import android.os.ShellCommand;
import android.text.TextUtils;
import android.webkit.IWebViewUpdateService;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
class WebViewUpdateServiceShellCommand2 extends ShellCommand {
    final IWebViewUpdateService mInterface;

    WebViewUpdateServiceShellCommand2(IWebViewUpdateService service) {
        this.mInterface = service;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L16:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1381305903: goto L10;
            default: goto L12;
        };     // Catch: RemoteException -> L16
    L12:
        byte r2 = -1;
    L13:
        switch(r2) {
            case 0: goto L19;
            default: goto L15;
        };     // Catch: RemoteException -> L16
    L15:
        return handleDefaultCommands(cmd);
    L19:
        return setWebViewImplementation();
    L10:
        if (cmd.equals("set-webview-implementation") == false) goto L12;
        r2 = 0;
        goto L13
    L4:
        return handleDefaultCommands(cmd);
    }

    private int setWebViewImplementation() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String shellChosenPackage = getNextArg();
        if (shellChosenPackage != null) goto L6;
        pw.println("Failed to switch, no PACKAGE provided.");
        pw.println("");
        helpSetWebViewImplementation();
        return 1;
    L6:
        String newPackage = this.mInterface.changeProviderAndSetting(shellChosenPackage);
        if (shellChosenPackage.equals(newPackage) == false) goto L10;
        pw.println("Success");
        return 0;
    L10:
        pw.println(TextUtils.formatSimple("Failed to switch to %s, the WebView implementation is now provided by %s.", new Object[]{shellChosenPackage, newPackage}));
        return 1;
    }

    public void helpSetWebViewImplementation() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("  set-webview-implementation PACKAGE");
        pw.println("    Set the WebView implementation to the specified package.");
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("WebView updater commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        helpSetWebViewImplementation();
        pw.println();
    }
}
