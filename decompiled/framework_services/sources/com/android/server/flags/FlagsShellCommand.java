package com.android.server.flags;

import com.android.internal.util.FastPrintWriter;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class FlagsShellCommand {
    private final FlagOverrideStore mFlagStore;

    FlagsShellCommand(FlagOverrideStore flagStore) {
        this.mFlagStore = flagStore;
    }

    public int process(String[] args, OutputStream out, OutputStream err) {
        FastPrintWriter r0 = new FastPrintWriter(out);
        FastPrintWriter r1 = new FastPrintWriter(err);
        if (args.length == 0) goto L5;
        byte r2 = 0;
        String r3 = args[0].toLowerCase(Locale.ROOT);
        switch(r3.hashCode()) {
            case 102230: goto L22;
            case 113762: goto L19;
            case 3198785: goto L16;
            case 3322014: goto L13;
            case 96768678: goto L10;
            default: goto L24;
        };
    L24:
        r2 = -1;
    L25:
        switch(r2) {
            case 0: goto L37;
            case 1: goto L35;
            case 2: goto L33;
            case 3: goto L31;
            case 4: goto L29;
            default: goto L27;
        };
    L27:
        return unknownCmd(r0);
    L29:
        return eraseCmd(args, r0, r1);
    L31:
        return getCmd(args, r0, r1);
    L33:
        return setCmd(args, r0, r1);
    L35:
        return listCmd(args, r0, r1);
    L37:
        return printHelp(r0);
    L10:
        if (r3.equals("erase") == false) goto L24;
        r2 = 4;
        goto L25
    L13:
        if (r3.equals("list") == false) goto L24;
        r2 = 1;
        goto L25
    L16:
        if (r3.equals("help") == false) goto L24;
    L19:
        if (r3.equals("set") == false) goto L24;
        r2 = 2;
        goto L25
    L22:
        if (r3.equals("get") == false) goto L24;
        r2 = 3;
        goto L25
    L5:
        return printHelp(r0);
    }

    private int printHelp(PrintWriter outPw) {
        outPw.println("Feature Flags command, allowing listing, setting, getting, and erasing of");
        outPw.println("local flag overrides on a device.");
        outPw.println();
        outPw.println("Commands:");
        outPw.println("  list [namespace]");
        outPw.println("    List all flag overrides. Namespace is optional.");
        outPw.println();
        outPw.println("  get <namespace> <name>");
        outPw.println("    Return the string value of a specific flag, or <unset>");
        outPw.println();
        outPw.println("  set <namespace> <name> <value>");
        outPw.println("    Set a specific flag");
        outPw.println();
        outPw.println("  erase <namespace> <name>");
        outPw.println("    Unset a specific flag");
        outPw.flush();
        return 0;
    }

    private int listCmd(String[] args, PrintWriter outPw, PrintWriter errPw) {
        int r7 = 0;
        if (validateNumArguments(args, 0, 1, args[0], errPw) == true) goto L7;
        errPw.println("Expected `" + args[0] + " [namespace]`");
        errPw.flush();
        return -1;
    L7:
        if (args.length != 2) goto L9;
        Map<String, Map<String, String>> overrides = this.mFlagStore.getFlagsForNamespace(args[1]);
    L11:
        if (overrides.isEmpty() == false) goto L13;
        outPw.println("No overrides set");
        int r17 = 0;
    L39:
        outPw.flush();
        return r17;
    L13:
        int longestNamespaceLen = "namespace".length();
        int longestFlagLen = "flag".length();
        int longestValLen = "value".length();
        Iterator<Map.Entry<String, Map<String, String>>> r12 = overrides.entrySet().iterator();
    L15:
        if (r12.hasNext() == false) goto L21;
        Map.Entry<String, Map<String, String>> namespace = r12.next();
        longestNamespaceLen = Math.max(longestNamespaceLen, namespace.getKey().length());
        Iterator<Map.Entry<String, String>> r14 = namespace.getValue().entrySet().iterator();
    L18:
        if (r14.hasNext() == false) goto L15;
        Map.Entry<String, String> flag = r14.next();
        longestFlagLen = Math.max(longestFlagLen, flag.getKey().length());
        longestValLen = Math.max(longestValLen, flag.getValue().length());
        r7 = r7;
        goto L18
    L21:
        r17 = r7;
        outPw.print(String.format("%-" + longestNamespaceLen + "s", new Object[]{"namespace"}));
        outPw.print(' ');
        outPw.print(String.format("%-" + longestFlagLen + "s", new Object[]{"flag"}));
        outPw.print(' ');
        outPw.println("value");
        int i = 0;
    L23:
        if (i >= longestNamespaceLen) goto L25;
        outPw.print('=');
        i = i + 1;
        goto L23
    L25:
        outPw.print(' ');
        int i2 = 0;
    L26:
        if (i2 >= longestFlagLen) goto L28;
        outPw.print('=');
        i2 = i2 + 1;
        goto L26
    L28:
        outPw.print(' ');
        int i3 = 0;
    L29:
        if (i3 >= longestValLen) goto L31;
        outPw.print('=');
        i3 = i3 + 1;
        goto L29
    L31:
        outPw.println();
        Iterator<Map.Entry<String, Map<String, String>>> r8 = overrides.entrySet().iterator();
    L33:
        if (r8.hasNext() == false) goto L39;
        Map.Entry<String, Map<String, String>> namespace2 = r8.next();
        Iterator<Map.Entry<String, String>> r10 = namespace2.getValue().entrySet().iterator();
    L36:
        if (r10.hasNext() == false) goto L33;
        Map.Entry<String, String> flag2 = r10.next();
        outPw.print(String.format("%-" + longestNamespaceLen + "s", new Object[]{namespace2.getKey()}));
        outPw.print(' ');
        outPw.print(String.format("%-" + longestFlagLen + "s", new Object[]{flag2.getKey()}));
        outPw.print(' ');
        outPw.println(flag2.getValue());
        goto L36
    L9:
        overrides = this.mFlagStore.getFlags();
        goto L11
    }

    private int setCmd(String[] args, PrintWriter outPw, PrintWriter errPw) {
        if (validateNumArguments(args, 3, args[0], errPw) == true) goto L6;
        errPw.println("Expected `" + args[0] + " <namespace> <name> <value>`");
        errPw.flush();
        return -1;
    L6:
        this.mFlagStore.set(args[1], args[2], args[3]);
        outPw.println("Flag " + args[1] + "." + args[2] + " is now " + args[3]);
        outPw.flush();
        return 0;
    }

    private int getCmd(String[] args, PrintWriter outPw, PrintWriter errPw) {
        if (validateNumArguments(args, 2, args[0], errPw) == true) goto L6;
        errPw.println("Expected `" + args[0] + " <namespace> <name>`");
        errPw.flush();
        return -1;
    L6:
        String value = this.mFlagStore.get(args[1], args[2]);
        outPw.print(args[1] + "." + args[2] + " is ");
        if (value != null) goto L9;
    L12:
        outPw.println("<unset>");
    L13:
        outPw.flush();
        return 0;
    L9:
        if (value.isEmpty() == true) goto L12;
        outPw.println("\"" + value.translateEscapes() + "\"");
        goto L13
    }

    private int eraseCmd(String[] args, PrintWriter outPw, PrintWriter errPw) {
        if (validateNumArguments(args, 2, args[0], errPw) == true) goto L6;
        errPw.println("Expected `" + args[0] + " <namespace> <name>`");
        errPw.flush();
        return -1;
    L6:
        this.mFlagStore.erase(args[1], args[2]);
        outPw.println("Erased " + args[1] + "." + args[2]);
        return 0;
    }

    private int unknownCmd(PrintWriter outPw) {
        outPw.println("This command is unknown.");
        printHelp(outPw);
        outPw.flush();
        return -1;
    }

    private boolean validateNumArguments(String[] args, int exactly, String cmdName, PrintWriter errPw) {
        return validateNumArguments(args, exactly, exactly, cmdName, errPw);
    }

    private boolean validateNumArguments(String[] args, int min, int max, String cmdName, PrintWriter errPw) {
        int len = args.length - 1;
        if (len >= min) goto L6;
        errPw.println("Less than " + min + " arguments provided for \"" + cmdName + "\" command.");
        return false;
    L6:
        if (len <= max) goto L9;
        errPw.println("More than " + max + " arguments provided for \"" + cmdName + "\" command.");
        return false;
    L9:
        return true;
    }
}
