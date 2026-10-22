package com.android.server.blob;

import android.app.ActivityManager;
import android.app.blob.BlobHandle;
import android.os.ShellCommand;
import java.io.PrintWriter;
import java.util.Base64;

/* JADX INFO: loaded from: classes.dex */
class BlobStoreManagerShellCommand extends ShellCommand {
    private final BlobStoreManagerService mService;

    private static class ParsedArgs {
        public String algorithm;
        public long blobId;
        public byte[] digest;
        public long expiryTimeMillis;
        public CharSequence label;
        public String tag;
        public int userId;

        /* synthetic */ ParsedArgs(BlobStoreManagerShellCommandIA r1) {
            this();
        }

        private ParsedArgs() {
            this.userId = -2;
            this.algorithm = "SHA-256";
        }

        public BlobHandle getBlobHandle() {
            return BlobHandle.create(this.algorithm, this.digest, this.label, this.expiryTimeMillis, this.tag);
        }
    }

    BlobStoreManagerShellCommand(BlobStoreManagerService blobStoreManagerService) {
        this.mService = blobStoreManagerService;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
        switch(cmd.hashCode()) {
            case -1168531841: goto L21;
            case -971115831: goto L18;
            case -258166326: goto L15;
            case 712607671: goto L12;
            case 1861559962: goto L9;
            default: goto L23;
        };
    L23:
        byte r1 = -1;
    L24:
        switch(r1) {
            case 0: goto L36;
            case 1: goto L34;
            case 2: goto L32;
            case 3: goto L30;
            case 4: goto L28;
            default: goto L26;
        };
    L26:
        return handleDefaultCommands(cmd);
    L28:
        return runQueryBlobExistence(pw);
    L30:
        return runIdleMaintenance(pw);
    L32:
        return runDeleteBlob(pw);
    L34:
        return runClearAllBlobs(pw);
    L36:
        return runClearAllSessions(pw);
    L9:
        if (cmd.equals("idle-maintenance") == false) goto L23;
        r1 = 3;
        goto L24
    L12:
        if (cmd.equals("query-blob-existence") == false) goto L23;
        r1 = 4;
        goto L24
    L15:
        if (cmd.equals("clear-all-blobs") == false) goto L23;
        r1 = 1;
        goto L24
    L18:
        if (cmd.equals("clear-all-sessions") == false) goto L23;
        r1 = 0;
        goto L24
    L21:
        if (cmd.equals("delete-blob") == false) goto L23;
        r1 = 2;
        goto L24
    L4:
        return handleDefaultCommands(null);
    }

    private int runClearAllSessions(PrintWriter pw) {
        ParsedArgs args = new ParsedArgs(null);
        args.userId = -1;
        if (parseOptions(pw, args) >= 0) goto L5;
        return -1;
    L5:
        this.mService.runClearAllSessions(args.userId);
        return 0;
    }

    private int runClearAllBlobs(PrintWriter pw) {
        ParsedArgs args = new ParsedArgs(null);
        args.userId = -1;
        if (parseOptions(pw, args) >= 0) goto L5;
        return -1;
    L5:
        this.mService.runClearAllBlobs(args.userId);
        return 0;
    }

    private int runDeleteBlob(PrintWriter pw) {
        ParsedArgs args = new ParsedArgs(null);
        if (parseOptions(pw, args) >= 0) goto L6;
        return -1;
    L6:
        this.mService.deleteBlob(args.getBlobHandle(), args.userId);
        return 0;
    }

    private int runIdleMaintenance(PrintWriter pw) {
        this.mService.runIdleMaintenance();
        return 0;
    }

    private int runQueryBlobExistence(PrintWriter r6) {
        ParsedArgs r0 = new ParsedArgs(null);
        if (parseOptions(r6, r0) >= 0) goto L6;
        return -1;
    L6:
        r6.println(this.mService.isBlobAvailable(r0.blobId, r0.userId) ? 1 : 0);
        return 0;
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("BlobStore service (blob_store) commands:");
        pw.println("help");
        pw.println("    Print this help text.");
        pw.println();
        pw.println("clear-all-sessions [-u | --user USER_ID]");
        pw.println("    Remove all sessions.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's sessions to be removed.");
        pw.println("                    If not specified, sessions in all users are removed.");
        pw.println();
        pw.println("clear-all-blobs [-u | --user USER_ID]");
        pw.println("    Remove all blobs.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's blobs to be removed.");
        pw.println("                    If not specified, blobs in all users are removed.");
        pw.println("delete-blob [-u | --user USER_ID] [--digest DIGEST] [--expiry EXPIRY_TIME] [--label LABEL] [--tag TAG]");
        pw.println("    Delete a blob.");
        pw.println("    Options:");
        pw.println("      -u or --user: specify which user's blobs to be removed;");
        pw.println("                    If not specified, blobs in all users are removed.");
        pw.println("      --digest: Base64 encoded digest of the blob to delete.");
        pw.println("      --expiry: Expiry time of the blob to delete, in milliseconds.");
        pw.println("      --label: Label of the blob to delete.");
        pw.println("      --tag: Tag of the blob to delete.");
        pw.println("idle-maintenance");
        pw.println("    Run idle maintenance which takes care of removing stale data.");
        pw.println("query-blob-existence [-b BLOB_ID] [-u | --user USER_ID]");
        pw.println("    Prints 1 if blob exists, otherwise 0.");
        pw.println();
    }

    private int parseOptions(PrintWriter pw, ParsedArgs args) {
    L2:
        String opt = getNextOption();
        byte r2 = 0;
        if (opt == null) goto L44;
        switch(opt.hashCode()) {
            case -1620968108: goto L29;
            case 1493: goto L26;
            case 1512: goto L23;
            case 43013626: goto L20;
            case 1068100452: goto L17;
            case 1110854355: goto L14;
            case 1332867059: goto L11;
            case 1333469547: goto L8;
            default: goto L31;
        };
    L31:
        r2 = -1;
    L32:
        switch(r2) {
            case 0: goto L41;
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L35;
            default: goto L33;
        };
    L33:
        pw.println("Error: unknown option '" + opt + "'");
        return -1;
    L36:
        args.tag = getNextArgRequired();
        goto L2
    L37:
        args.expiryTimeMillis = Long.parseLong(getNextArgRequired());
        goto L2
    L38:
        args.label = getNextArgRequired();
        goto L2
    L39:
        args.digest = Base64.getDecoder().decode(getNextArgRequired());
        goto L2
    L40:
        args.algorithm = getNextArgRequired();
        goto L2
    L41:
        args.userId = Integer.parseInt(getNextArgRequired());
        goto L2
    L35:
        args.blobId = Long.parseLong(getNextArgRequired());
        goto L2
    L8:
        if (opt.equals("--user") == false) goto L64;
        r2 = 1;
        goto L32
    L64:
        r2 = -1;
        goto L32
    L11:
        if (opt.equals("--algo") == false) goto L65;
        r2 = 2;
        goto L32
    L65:
        r2 = -1;
        goto L32
    L14:
        if (opt.equals("--expiry") == false) goto L66;
        r2 = 5;
        goto L32
    L66:
        r2 = -1;
        goto L32
    L17:
        if (opt.equals("--digest") == false) goto L67;
        r2 = 3;
        goto L32
    L67:
        r2 = -1;
        goto L32
    L20:
        if (opt.equals("--tag") == false) goto L68;
        r2 = 6;
        goto L32
    L68:
        r2 = -1;
        goto L32
    L23:
        if (opt.equals("-u") == true) goto L32;
        r2 = -1;
        goto L32
    L26:
        if (opt.equals("-b") == false) goto L70;
        r2 = 7;
        goto L32
    L70:
        r2 = -1;
        goto L32
    L29:
        if (opt.equals("--label") == false) goto L71;
        r2 = 4;
        goto L32
    L71:
        r2 = -1;
        goto L32
    L44:
        if (args.userId != (-2)) goto L46;
        args.userId = ActivityManager.getCurrentUser();
    L46:
        return 0;
    }
}
