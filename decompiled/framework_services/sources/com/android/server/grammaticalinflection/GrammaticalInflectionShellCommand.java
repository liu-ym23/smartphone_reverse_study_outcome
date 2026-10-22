package com.android.server.grammaticalinflection;

import android.app.ActivityManager;
import android.app.GrammaticalInflectionManager;
import android.app.IGrammaticalInflectionManager;
import android.content.AttributionSource;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.util.SparseArray;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
class GrammaticalInflectionShellCommand extends ShellCommand {
    private static final SparseArray<String> GRAMMATICAL_GENDER_MAP = null;
    private AttributionSource mAttributionSource;
    private final IGrammaticalInflectionManager mBinderService;

    static {
        GRAMMATICAL_GENDER_MAP = new SparseArray();
        GRAMMATICAL_GENDER_MAP.put(0, "Not specified (0)");
        GRAMMATICAL_GENDER_MAP.put(1, "Neuter (1)");
        GRAMMATICAL_GENDER_MAP.put(2, "Feminine (2)");
        GRAMMATICAL_GENDER_MAP.put(3, "Masculine (3)");
    }

    GrammaticalInflectionShellCommand(IGrammaticalInflectionManager grammaticalInflectionManager, AttributionSource attributionSource) {
        this.mBinderService = grammaticalInflectionManager;
        this.mAttributionSource = attributionSource;
    }

    public int onCommand(String cmd) {
        if (cmd != null) goto L6;
        return handleDefaultCommands(cmd);
    L6:
        switch(cmd.hashCode()) {
            case -1249285581: goto L12;
            case -976571353: goto L9;
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
        return runGetSystemGrammaticalGender();
    L21:
        return runSetSystemWideGrammaticalGender();
    L9:
        if (cmd.equals("get-system-grammatical-gender") == false) goto L14;
        r0 = 1;
        goto L15
    L12:
        if (cmd.equals("set-system-grammatical-gender") == false) goto L14;
        r0 = 0;
        goto L15
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Grammatical inflection manager (grammatical_inflection) shell commands:");
        pw.println("  help");
        pw.println("      Print this help text.");
        pw.println("  set-system-grammatical-gender [--user <USER_ID>] [--grammaticalGender <GRAMMATICAL_GENDER>]");
        pw.println("      Set the system grammatical gender for system.");
        pw.println("      --user <USER_ID>: apply for the given user, the current user is used when unspecified.");
        pw.println("      --grammaticalGender <GRAMMATICAL_GENDER>: The terms of address the user preferred in system, not specified (0) is used when unspecified.");
        pw.println("                 eg. 0 = not_specified, 1 = neuter, 2 = feminine, 3 = masculine.");
        pw.println("  get-system-grammatical-gender [--user <USER_ID>]");
        pw.println("      Get the system grammatical gender for system.");
        pw.println("      --user <USER_ID>: apply for the given user, the current user is used when unspecified.");
    }

    private int runSetSystemWideGrammaticalGender() {
        int userId = ActivityManager.getCurrentUser();
        int grammaticalGender = 0;
    L3:
        String option = getNextOption();
        byte r3 = 0;
        if (option != null) goto L11;
        this.mBinderService.setSystemWideGrammaticalGender(grammaticalGender, userId);     // Catch: RemoteException -> L7
    L9:
        return 0;
    L7:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
        goto L9
    L11:
        switch(option.hashCode()) {
            case 1498: goto L20;
            case 1333469547: goto L17;
            case 2015742127: goto L14;
            default: goto L22;
        };
    L22:
        r3 = -1;
    L23:
        switch(r3) {
            case 0: goto L27;
            case 1: goto L26;
            case 2: goto L26;
            default: goto L25;
        };
    L25:
        throw new IllegalArgumentException("Unknown option: " + option);
    L27:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L26:
        grammaticalGender = parseGrammaticalGender();
        goto L3
    L14:
        if (option.equals("--grammaticalGender") == false) goto L22;
        r3 = 2;
        goto L23
    L17:
        if (option.equals("--user") == false) goto L22;
    L20:
        if (option.equals("-g") == false) goto L22;
        r3 = 1;
        goto L23
    }

    private int runGetSystemGrammaticalGender() {
        int userId = ActivityManager.getCurrentUser();
    L3:
        String option = getNextOption();
        byte r2 = 0;
        if (option != null) goto L11;
        int grammaticalGender = this.mBinderService.getSystemGrammaticalGender(this.mAttributionSource, userId);     // Catch: RemoteException -> L7
        getOutPrintWriter().println(GRAMMATICAL_GENDER_MAP.get(grammaticalGender));     // Catch: RemoteException -> L7
    L9:
        return 0;
    L7:
        e = move-exception;
        getOutPrintWriter().println("Remote Exception: " + e);
        goto L9
    L11:
        switch(option.hashCode()) {
            case 1333469547: goto L14;
            default: goto L16;
        };
    L16:
        r2 = -1;
    L17:
        switch(r2) {
            case 0: goto L20;
            default: goto L19;
        };
    L20:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L19:
        throw new IllegalArgumentException("Unknown option: " + option);
    L14:
        if (option.equals("--user") == false) goto L16;
        goto L16
    }

    private int parseGrammaticalGender() {
        String arg = getNextArg();
        if (arg != null) goto L5;
        return 0;
    L5:
        int grammaticalGender = Integer.parseInt(arg);
        if (GrammaticalInflectionManager.VALID_GRAMMATICAL_GENDER_VALUES.contains(Integer.valueOf(grammaticalGender)) == false) goto L8;
        return grammaticalGender;
    L8:
        return 0;
    }
}
