package com.android.server.pm.verify.domain;

import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.content.pm.verify.domain.DomainVerificationUserState;
import android.os.Binder;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import com.android.modules.utils.BasicShellCommandHandler;
import com.android.server.am.IZswContentProviderHelper;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class DomainVerificationShell {
    private final Callback mCallback;

    public interface Callback {
        void clearDomainVerificationState(List<String> r1);

        void clearUserStates(List<String> r1, int r2);

        DomainVerificationUserState getDomainVerificationUserState(String r1, int r2) throws PackageManager.NameNotFoundException;

        void printOwnersForDomains(IndentingPrintWriter r1, List<String> r2, Integer r3);

        void printOwnersForPackage(IndentingPrintWriter r1, String r2, Integer r3) throws PackageManager.NameNotFoundException;

        void printState(IndentingPrintWriter r1, String r2, Integer r3) throws PackageManager.NameNotFoundException;

        void setDomainVerificationLinkHandlingAllowedInternal(String r1, boolean r2, int r3) throws PackageManager.NameNotFoundException;

        void setDomainVerificationStatusInternal(String r1, int r2, ArraySet<String> r3) throws PackageManager.NameNotFoundException;

        void setDomainVerificationUserSelectionInternal(int r1, String r2, boolean r3, ArraySet<String> r4) throws PackageManager.NameNotFoundException;

        void verifyPackages(List<String> r1, boolean r2);
    }

    public DomainVerificationShell(Callback callback) {
        this.mCallback = callback;
    }

    public void printHelp(PrintWriter pw) {
        pw.println("  get-app-links [--user <USER_ID>] [<PACKAGE>]");
        pw.println("    Prints the domain verification state for the given package, or for all");
        pw.println("    packages if none is specified. State codes are defined as follows:");
        pw.println("        - none: nothing has been recorded for this domain");
        pw.println("        - verified: the domain has been successfully verified");
        pw.println("        - approved: force approved, usually through shell");
        pw.println("        - denied: force denied, usually through shell");
        pw.println("        - migrated: preserved verification from a legacy response");
        pw.println("        - restored: preserved verification from a user data restore");
        pw.println("        - legacy_failure: rejected by a legacy verifier, unknown reason");
        pw.println("        - system_configured: automatically approved by the device config");
        pw.println("        - pre_verified: the domain was pre-verified by the installer");
        pw.println("        - >= 1024: Custom error code which is specific to the device verifier");
        pw.println("      --user <USER_ID>: include user selections (includes all domains, not");
        pw.println("        just autoVerify ones)");
        pw.println("  reset-app-links [--user <USER_ID>] [<PACKAGE>]");
        pw.println("    Resets domain verification state for the given package, or for all");
        pw.println("    packages if none is specified.");
        pw.println("      --user <USER_ID>: clear user selection state instead; note this means");
        pw.println("        domain verification state will NOT be cleared");
        pw.println("      <PACKAGE>: the package to reset, or \"all\" to reset all packages");
        pw.println("  verify-app-links [--re-verify] [<PACKAGE>]");
        pw.println("    Broadcasts a verification request for the given package, or for all");
        pw.println("    packages if none is specified. Only sends if the package has previously");
        pw.println("    not recorded a response.");
        pw.println("      --re-verify: send even if the package has recorded a response");
        pw.println("  set-app-links [--package <PACKAGE>] <STATE> <DOMAINS>...");
        pw.println("    Manually set the state of a domain for a package. The domain must be");
        pw.println("    declared by the package as autoVerify for this to work. This command");
        pw.println("    will not report a failure for domains that could not be applied.");
        pw.println("      --package <PACKAGE>: the package to set, or \"all\" to set all packages");
        pw.println("      <STATE>: the code to set the domains to, valid values are:");
        pw.println("        STATE_NO_RESPONSE (0): reset as if no response was ever recorded.");
        pw.println("        STATE_SUCCESS (1): treat domain as successfully verified by domain.");
        pw.println("          verification agent. Note that the domain verification agent can");
        pw.println("          override this.");
        pw.println("        STATE_APPROVED (2): treat domain as always approved, preventing the");
        pw.println("           domain verification agent from changing it.");
        pw.println("        STATE_DENIED (3): treat domain as always denied, preveting the domain");
        pw.println("          verification agent from changing it.");
        pw.println("      <DOMAINS>: space separated list of domains to change, or \"all\" to");
        pw.println("        change every domain.");
        pw.println("  set-app-links-user-selection --user <USER_ID> [--package <PACKAGE>]");
        pw.println("      <ENABLED> <DOMAINS>...");
        pw.println("    Manually set the state of a host user selection for a package. The domain");
        pw.println("    must be declared by the package for this to work. This command will not");
        pw.println("    report a failure for domains that could not be applied.");
        pw.println("      --user <USER_ID>: the user to change selections for");
        pw.println("      --package <PACKAGE>: the package to set");
        pw.println("      <ENABLED>: whether or not to approve the domain");
        pw.println("      <DOMAINS>: space separated list of domains to change, or \"all\" to");
        pw.println("        change every domain.");
        pw.println("  set-app-links-allowed --user <USER_ID> [--package <PACKAGE>] <ALLOWED>");
        pw.println("    Toggle the auto verified link handling setting for a package.");
        pw.println("      --user <USER_ID>: the user to change selections for");
        pw.println("      --package <PACKAGE>: the package to set, or \"all\" to set all packages");
        pw.println("        packages will be reset if no one package is specified.");
        pw.println("      <ALLOWED>: true to allow the package to open auto verified links, false");
        pw.println("        to disable");
        pw.println("  get-app-link-owners [--user <USER_ID>] [--package <PACKAGE>] [<DOMAINS>]");
        pw.println("    Print the owners for a specific domain for a given user in low to high");
        pw.println("    priority order.");
        pw.println("      --user <USER_ID>: the user to query for");
        pw.println("      --package <PACKAGE>: optionally also print for all web domains declared");
        pw.println("        by a package, or \"all\" to print all packages");
        pw.println("      --<DOMAINS>: space separated list of domains to query for");
    }

    public Boolean runCommand(BasicShellCommandHandler commandHandler, String command) {
        switch(command.hashCode()) {
            case -2140094634: goto L24;
            case -2092945963: goto L21;
            case -1850904515: goto L18;
            case -1365963422: goto L15;
            case -825562609: goto L12;
            case 1161008944: goto L9;
            case 1328605369: goto L6;
            default: goto L26;
        };
    L26:
        byte r0 = -1;
    L27:
        switch(r0) {
            case 0: goto L43;
            case 1: goto L41;
            case 2: goto L39;
            case 3: goto L37;
            case 4: goto L35;
            case 5: goto L33;
            case 6: goto L31;
            default: goto L28;
        };
    L28:
        return null;
    L31:
        return Boolean.valueOf(runGetAppLinkOwners(commandHandler));
    L33:
        return Boolean.valueOf(runSetAppLinksAllowed(commandHandler));
    L35:
        return Boolean.valueOf(runSetAppLinksUserState(commandHandler));
    L37:
        return Boolean.valueOf(runSetAppLinks(commandHandler));
    L39:
        return Boolean.valueOf(runVerifyAppLinks(commandHandler));
    L41:
        return Boolean.valueOf(runResetAppLinks(commandHandler));
    L43:
        return Boolean.valueOf(runGetAppLinks(commandHandler));
    L6:
        if (command.equals("verify-app-links") == false) goto L26;
        r0 = 2;
        goto L27
    L9:
        if (command.equals("get-app-link-owners") == false) goto L26;
        r0 = 6;
        goto L27
    L12:
        if (command.equals("reset-app-links") == false) goto L26;
        r0 = 1;
        goto L27
    L15:
        if (command.equals("set-app-links") == false) goto L26;
        r0 = 3;
        goto L27
    L18:
        if (command.equals("set-app-links-allowed") == false) goto L26;
        r0 = 5;
        goto L27
    L21:
        if (command.equals("set-app-links-user-selection") == false) goto L26;
        r0 = 4;
        goto L27
    L24:
        if (command.equals("get-app-links") == false) goto L26;
        r0 = 0;
        goto L27
    }

    private boolean runSetAppLinks(BasicShellCommandHandler commandHandler) {
        String packageName = null;
    L3:
        String option = commandHandler.getNextOption();
        if (option == null) goto L11;
        if (option.equals("--package") == false) goto L8;
        packageName = commandHandler.getNextArgRequired();
        goto L3
    L8:
        commandHandler.getErrPrintWriter().println("Error: unknown option: " + option);
        return false;
    L11:
        if (TextUtils.isEmpty(packageName) == false) goto L15;
        commandHandler.getErrPrintWriter().println("Error: no package specified");
        return false;
    L15:
        if (packageName.equalsIgnoreCase(IZswContentProviderHelper.DUMP_ALL) == false) goto L17;
        packageName = null;
    L17:
        String state = commandHandler.getNextArgRequired();
        switch(state.hashCode()) {
            case -1618466107: goto L42;
            case 48: goto L39;
            case 49: goto L36;
            case 50: goto L33;
            case 51: goto L30;
            case 259145237: goto L27;
            case 482582065: goto L24;
            case 534310697: goto L21;
            default: goto L44;
        };
    L44:
        byte r5 = -1;
    L45:
        switch(r5) {
            case 0: goto L51;
            case 1: goto L51;
            case 2: goto L50;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L49;
            case 6: goto L48;
            case 7: goto L48;
            default: goto L46;
        };
    L46:
        commandHandler.getErrPrintWriter().println("Invalid state option: " + state);
        return false;
    L48:
        int stateInt = 3;
    L52:
        ArraySet<String> domains = new ArraySet(getRemainingArgs(commandHandler));
        if (domains.isEmpty() == false) goto L57;
        commandHandler.getErrPrintWriter().println("No domains specified");
        return false;
    L57:
        if (domains.size() == 1) goto L59;
    L66:
        this.mCallback.setDomainVerificationStatusInternal(packageName, stateInt, domains);     // Catch: PackageManager.NameNotFoundException -> L63
        return true;
    L64:
        commandHandler.getErrPrintWriter().println("Package not found: " + packageName);
        return false;
    L59:
        if (domains.contains(IZswContentProviderHelper.DUMP_ALL) == false) goto L66;
        domains = null;
        goto L66
    L49:
        stateInt = 2;
        goto L52
    L50:
        stateInt = 1;
        goto L52
    L51:
        stateInt = 0;
        goto L52
    L21:
        if (state.equals("STATE_DENIED") == false) goto L44;
        r5 = 6;
        goto L45
    L24:
        if (state.equals("STATE_NO_RESPONSE") == false) goto L44;
        r5 = 0;
        goto L45
    L27:
        if (state.equals("STATE_SUCCESS") == false) goto L44;
        r5 = 2;
        goto L45
    L30:
        if (state.equals("3") == false) goto L44;
        r5 = 7;
        goto L45
    L33:
        if (state.equals("2") == false) goto L44;
        r5 = 5;
        goto L45
    L36:
        if (state.equals("1") == false) goto L44;
        r5 = 3;
        goto L45
    L39:
        if (state.equals("0") == false) goto L44;
        r5 = 1;
        goto L45
    L42:
        if (state.equals("STATE_APPROVED") == false) goto L44;
        r5 = 4;
        goto L45
    }

    private boolean runSetAppLinksUserState(BasicShellCommandHandler commandHandler) {
        Integer userId = null;
        String packageName = null;
    L3:
        String option = commandHandler.getNextOption();
        byte r4 = 1;
        if (option == null) goto L22;
        switch(option.hashCode()) {
            case 578919078: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        commandHandler.getErrPrintWriter().println("Error: unknown option: " + option);
        return false;
    L19:
        userId = Integer.valueOf(UserHandle.parseUserArg(commandHandler.getNextArgRequired()));
        goto L3
    L18:
        packageName = commandHandler.getNextArgRequired();
        goto L3
    L9:
        if (option.equals("--user") == false) goto L14;
        r4 = 0;
        goto L15
    L12:
        if (option.equals("--package") == false) goto L14;
    L22:
        if (TextUtils.isEmpty(packageName) == false) goto L25;
        commandHandler.getErrPrintWriter().println("Error: no package specified");
        return false;
    L25:
        if (userId != null) goto L28;
        commandHandler.getErrPrintWriter().println("Error: User ID not specified");
        return false;
    L28:
        Integer userId2 = Integer.valueOf(translateUserId(userId.intValue(), "runSetAppLinksUserState"));
        String enabledArg = commandHandler.getNextArg();
        if (TextUtils.isEmpty(enabledArg) == false) goto L52;
        commandHandler.getErrPrintWriter().println("Error: enabled param not specified");
        return false;
    L52:
        boolean enabled = parseEnabled(enabledArg);     // Catch: IllegalArgumentException -> L47
        ArraySet<String> domains = new ArraySet(getRemainingArgs(commandHandler));
        if (domains.isEmpty() == false) goto L38;
        commandHandler.getErrPrintWriter().println("No domains specified");
        return false;
    L38:
        if (domains.size() == 1) goto L40;
    L50:
        this.mCallback.setDomainVerificationUserSelectionInternal(userId2.intValue(), packageName, enabled, domains);     // Catch: PackageManager.NameNotFoundException -> L44
        return true;
    L45:
        commandHandler.getErrPrintWriter().println("Package not found: " + packageName);
        return false;
    L40:
        if (domains.contains(IZswContentProviderHelper.DUMP_ALL) == false) goto L50;
        domains = null;
    L47:
        e = move-exception;
        commandHandler.getErrPrintWriter().println("Error: invalid enabled param: " + e.getMessage());
        return false;
    }

    private boolean runGetAppLinks(BasicShellCommandHandler commandHandler) {
        Integer userId = null;
    L3:
        String option = commandHandler.getNextOption();
        if (option == null) goto L10;
        if (option.equals("--user") == false) goto L8;
        userId = Integer.valueOf(UserHandle.parseUserArg(commandHandler.getNextArgRequired()));
        goto L3
    L8:
        commandHandler.getErrPrintWriter().println("Error: unknown option: " + option);
        return false;
    L10:
        if (userId != null) goto L12;
        Integer userId2 = null;
    L13:
        String packageName = commandHandler.getNextArg();
        IndentingPrintWriter writer = new IndentingPrintWriter(commandHandler.getOutPrintWriter(), "  ", 120);
        writer.increaseIndent();     // Catch: Throwable -> L19
        this.mCallback.printState(writer, packageName, userId2);     // Catch: Throwable -> L19 PackageManager.NameNotFoundException -> L21
        writer.decreaseIndent();     // Catch: Throwable -> L19
        writer.close();
        return true;
    L22:
        commandHandler.getErrPrintWriter().println("Error: package " + packageName + " unavailable");     // Catch: Throwable -> L19
        writer.close();
        return false;
    L19:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L27
    L29:
        throw th;
    L27:
        th = move-exception;
        th.addSuppressed(th);
        goto L29
    L12:
        userId2 = Integer.valueOf(translateUserId(userId.intValue(), "runGetAppLinks"));
        goto L13
    }

    private boolean runResetAppLinks(BasicShellCommandHandler commandHandler) {
        Integer userId = null;
    L3:
        String option = commandHandler.getNextOption();
        if (option == null) goto L10;
        if (option.equals("--user") == false) goto L8;
        userId = Integer.valueOf(UserHandle.parseUserArg(commandHandler.getNextArgRequired()));
        goto L3
    L8:
        commandHandler.getErrPrintWriter().println("Error: unknown option: " + option);
        return false;
    L10:
        if (userId != null) goto L12;
        Integer userId2 = null;
    L13:
        String pkgNameArg = commandHandler.peekNextArg();
        if (TextUtils.isEmpty(pkgNameArg) == false) goto L18;
        commandHandler.getErrPrintWriter().println("Error: no package specified");
        return false;
    L18:
        if (pkgNameArg.equalsIgnoreCase(IZswContentProviderHelper.DUMP_ALL) == false) goto L20;
        List<String> packageNames = null;
    L21:
        if (userId2 == null) goto L23;
        this.mCallback.clearUserStates(packageNames, userId2.intValue());
        return true;
    L23:
        this.mCallback.clearDomainVerificationState(packageNames);
        return true;
    L20:
        packageNames = Arrays.asList(commandHandler.peekRemainingArgs());
        goto L21
    L12:
        userId2 = Integer.valueOf(translateUserId(userId.intValue(), "runResetAppLinks"));
        goto L13
    }

    private boolean runVerifyAppLinks(BasicShellCommandHandler commandHandler) {
        boolean reVerify = false;
    L3:
        String option = commandHandler.getNextOption();
        if (option == null) goto L10;
        if (option.equals("--re-verify") == false) goto L8;
        reVerify = true;
        goto L3
    L8:
        commandHandler.getErrPrintWriter().println("Error: unknown option: " + option);
        return false;
    L10:
        List<String> packageNames = null;
        String pkgNameArg = commandHandler.getNextArg();
        if (TextUtils.isEmpty(pkgNameArg) == true) goto L13;
        packageNames = Collections.singletonList(pkgNameArg);
    L13:
        this.mCallback.verifyPackages(packageNames, reVerify);
        return true;
    }

    private boolean runSetAppLinksAllowed(BasicShellCommandHandler commandHandler) {
        String packageName = null;
        Integer userId = null;
    L3:
        String option = commandHandler.getNextOption();
        if (option == null) goto L14;
        if (option.equals("--package") == true) goto L7;
        if (option.equals("--user") == false) goto L11;
        userId = Integer.valueOf(UserHandle.parseUserArg(commandHandler.getNextArgRequired()));
        goto L3
    L11:
        commandHandler.getErrPrintWriter().println("Error: unexpected option: " + option);
        return false;
    L7:
        packageName = commandHandler.getNextArg();
        goto L3
    L14:
        if (TextUtils.isEmpty(packageName) == false) goto L18;
        commandHandler.getErrPrintWriter().println("Error: no package specified");
        return false;
    L18:
        if (packageName.equalsIgnoreCase(IZswContentProviderHelper.DUMP_ALL) == false) goto L20;
        packageName = null;
    L20:
        if (userId != null) goto L23;
        commandHandler.getErrPrintWriter().println("Error: user ID not specified");
        return false;
    L23:
        String allowedArg = commandHandler.getNextArg();
        if (TextUtils.isEmpty(allowedArg) == false) goto L40;
        commandHandler.getErrPrintWriter().println("Error: allowed setting not specified");
        return false;
    L40:
        boolean allowed = parseEnabled(allowedArg);     // Catch: IllegalArgumentException -> L35
        this.mCallback.setDomainVerificationLinkHandlingAllowedInternal(packageName, allowed, Integer.valueOf(translateUserId(userId.intValue(), "runSetAppLinksAllowed")).intValue());     // Catch: PackageManager.NameNotFoundException -> L32
        return true;
    L33:
        commandHandler.getErrPrintWriter().println("Package not found: " + packageName);
        return false;
    L35:
        e = move-exception;
        commandHandler.getErrPrintWriter().println("Error: invalid allowed setting: " + e.getMessage());
        return false;
    }

    private boolean runGetAppLinkOwners(BasicShellCommandHandler commandHandler) {
        String packageName = null;
        Integer userId = null;
    L3:
        String option = commandHandler.getNextOption();
        byte r4 = 1;
        if (option == null) goto L24;
        switch(option.hashCode()) {
            case 578919078: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L22;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        commandHandler.getErrPrintWriter().println("Error: unexpected option: " + option);
        return false;
    L22:
        userId = Integer.valueOf(UserHandle.parseUserArg(commandHandler.getNextArgRequired()));
        goto L3
    L18:
        packageName = commandHandler.getNextArgRequired();
        if (TextUtils.isEmpty(packageName) == false) goto L3;
        commandHandler.getErrPrintWriter().println("Error: no package specified");
        return false;
    L9:
        if (option.equals("--user") == false) goto L14;
        r4 = 0;
        goto L15
    L12:
        if (option.equals("--package") == false) goto L14;
    L24:
        ArrayList<String> domains = getRemainingArgs(commandHandler);
        if (domains.isEmpty() == true) goto L27;
    L30:
        if (userId == null) goto L32;
        userId = Integer.valueOf(translateUserId(userId.intValue(), "runSetAppLinksAllowed"));
    L32:
        IndentingPrintWriter writer = new IndentingPrintWriter(commandHandler.getOutPrintWriter(), "  ", 120);
        writer.increaseIndent();     // Catch: Throwable -> L40
        if (packageName == null) goto L47;
        if (packageName.equals(IZswContentProviderHelper.DUMP_ALL) == false) goto L58;
        packageName = null;
    L58:
        this.mCallback.printOwnersForPackage(writer, packageName, userId);     // Catch: Throwable -> L40 PackageManager.NameNotFoundException -> L42
    L43:
        commandHandler.getErrPrintWriter().println("Error: package not found: " + packageName);     // Catch: Throwable -> L40
        writer.close();
        return false;
    L47:
        if (domains.isEmpty() == true) goto L49;
        this.mCallback.printOwnersForDomains(writer, domains, userId);     // Catch: Throwable -> L40
    L49:
        writer.decreaseIndent();     // Catch: Throwable -> L40
        writer.close();
        return true;
    L40:
        th = move-exception;
        writer.close();     // Catch: Throwable -> L54
    L56:
        throw th;
    L54:
        th = move-exception;
        th.addSuppressed(th);
        goto L56
    L27:
        if (TextUtils.isEmpty(packageName) == false) goto L30;
        commandHandler.getErrPrintWriter().println("Error: no package name or domain specified");
        return false;
    }

    private ArrayList<String> getRemainingArgs(BasicShellCommandHandler commandHandler) {
        ArrayList<String> args = new ArrayList();
    L3:
        String arg = commandHandler.getNextArg();
        if (arg == null) goto L6;
        args.add(arg);
        goto L3
    L6:
        return args;
    }

    private int translateUserId(int userId, String logContext) {
        return ActivityManager.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, true, true, logContext, "pm command");
    }

    private boolean parseEnabled(String arg) throws IllegalArgumentException {
        String r0 = arg.toLowerCase(Locale.US);
        switch(r0.hashCode()) {
            case 3569038: goto L9;
            case 97196323: goto L6;
            default: goto L11;
        };
    L11:
        byte r1 = -1;
    L12:
        switch(r1) {
            case 0: goto L16;
            case 1: goto L15;
            default: goto L14;
        };
    L15:
        return false;
    L16:
        return true;
    L14:
        throw new IllegalArgumentException(arg + " is not a valid boolean");
    L6:
        if (r0.equals("false") == false) goto L11;
        r1 = 1;
        goto L12
    L9:
        if (r0.equals("true") == false) goto L11;
        r1 = 0;
        goto L12
    }
}
