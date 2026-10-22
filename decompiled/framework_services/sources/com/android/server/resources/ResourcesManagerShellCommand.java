package com.android.server.resources;

import android.content.res.IResourcesManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.ParcelFileDescriptor;
import android.os.RemoteCallback;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.util.Slog;
import java.io.IOException;
import java.io.PrintWriter;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;

/* JADX INFO: loaded from: classes3.dex */
public class ResourcesManagerShellCommand extends ShellCommand {
    private static final String TAG = "ResourcesManagerShellCommand";
    private final IResourcesManager mInterface;

    /* JADX INFO: renamed from: $r8$lambda$HgcnhoJS-PDsmq4uPgNTt1weDjM, reason: not valid java name */
    public static /* synthetic */ void m7973$r8$lambda$HgcnhoJSPDsmq4uPgNTt1weDjM(ConditionVariable r0, Bundle r1) {
        lambda$dumpResources$0(r0, r1);
    }

    public ResourcesManagerShellCommand(IResourcesManager anInterface) {
        this.mInterface = anInterface;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter err = getErrPrintWriter();
    L16:
        e = move-exception;
        err.println("Remote exception: " + e);
    L24:
        return -1;
    L18:
        e = move-exception;
        err.println("Error: " + e.getMessage());
        goto L24
    L7:
        switch(cmd.hashCode()) {
            case 3095028: goto L10;
            default: goto L12;
        };     // Catch: RemoteException -> L16 IllegalArgumentException -> L18
    L12:
        byte r2 = -1;
    L13:
        switch(r2) {
            case 0: goto L21;
            default: goto L15;
        };     // Catch: RemoteException -> L16 IllegalArgumentException -> L18
    L15:
        return handleDefaultCommands(cmd);
    L21:
        return dumpResources();
    L10:
        if (cmd.equals(ArchiveStreamFactory.DUMP) == false) goto L12;
        r2 = 0;
        goto L13
    L4:
        return handleDefaultCommands(cmd);
    }

    private int dumpResources() throws RemoteException {
        String processId = getNextArgRequired();
        ParcelFileDescriptor pfd = ParcelFileDescriptor.dup(getOutFileDescriptor());     // Catch: IOException -> L10
        final ConditionVariable lock = new ConditionVariable();     // Catch: Throwable -> L13
        RemoteCallback finishCallback = new RemoteCallback(new ResourcesManagerShellCommand$$ExternalSyntheticLambda0(lock), null);     // Catch: Throwable -> L13
        if (this.mInterface.dumpResources(processId, pfd, finishCallback) == true) goto L16;
        getErrPrintWriter().println("RESOURCES DUMP FAILED on process " + processId);     // Catch: Throwable -> L13
        if (pfd == null) goto L12;
        pfd.close();     // Catch: IOException -> L10
    L12:
        return -1;
    L16:
        lock.block(5000);     // Catch: Throwable -> L13
        if (pfd == null) goto L34;
        pfd.close();     // Catch: IOException -> L10
        return 0;
    L34:
        return 0;
    L13:
        th = move-exception;
        if (pfd != null) goto L32;
    L27:
        throw th;     // Catch: IOException -> L10
    L32:
        pfd.close();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.addSuppressed(th);     // Catch: IOException -> L10
    L10:
        e = move-exception;
        Slog.e(TAG, "Exception while dumping resources", e);
        getErrPrintWriter().println("Exception while dumping resources: " + e.getMessage());
        return -1;
    }

    private static /* synthetic */ void lambda$dumpResources$0(ConditionVariable lock, Bundle result) {
        lock.open();
    }

    public void onHelp() {
        PrintWriter out = getOutPrintWriter();
        out.println("Resources manager commands:");
        out.println("  help");
        out.println("    Print this help text.");
        out.println("  dump <PROCESS>");
        out.println("    Dump the Resources objects in use as well as the history of Resources");
    }
}
