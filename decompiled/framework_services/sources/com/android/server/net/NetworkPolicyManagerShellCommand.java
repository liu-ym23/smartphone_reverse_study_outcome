package com.android.server.net;

import android.content.Context;
import android.net.NetworkPolicyManager;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.RemoteException;
import android.os.ShellCommand;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class NetworkPolicyManagerShellCommand extends ShellCommand {
    private final NetworkPolicyManagerService mInterface;
    private final WifiManager mWifiManager;

    NetworkPolicyManagerShellCommand(Context context, NetworkPolicyManagerService service) {
        this.mInterface = service;
        this.mWifiManager = (WifiManager) context.getSystemService("wifi");
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter pw = getOutPrintWriter();
    L12:
        e = move-exception;
        pw.println("Remote exception: " + e);
        return -1;
    L7:
        switch(cmd.hashCode()) {
            case -1544226370: goto L30;
            case -934610812: goto L27;
            case 96417: goto L24;
            case 102230: goto L21;
            case 113762: goto L18;
            case 3322014: goto L15;
            case 1093388830: goto L10;
            default: goto L32;
        };     // Catch: RemoteException -> L12
    L32:
        byte r2 = -1;
    L33:
        switch(r2) {
            case 0: goto L49;
            case 1: goto L47;
            case 2: goto L45;
            case 3: goto L43;
            case 4: goto L41;
            case 5: goto L39;
            case 6: goto L37;
            default: goto L35;
        };     // Catch: RemoteException -> L12
    L35:
        return handleDefaultCommands(cmd);
    L37:
        return runStopWatching();
    L39:
        return runStartWatching();
    L41:
        return runRemove();
    L43:
        return runAdd();
    L45:
        return runList();
    L47:
        return runSet();
    L49:
        return runGet();
    L10:
        if (cmd.equals("stop-watching") == false) goto L32;
        r2 = 6;
        goto L33
    L15:
        if (cmd.equals("list") == false) goto L32;
        r2 = 2;
        goto L33
    L18:
        if (cmd.equals("set") == false) goto L32;
        r2 = 1;
        goto L33
    L21:
        if (cmd.equals("get") == false) goto L32;
        r2 = 0;
        goto L33
    L24:
        if (cmd.equals("add") == false) goto L32;
        r2 = 3;
        goto L33
    L27:
        if (cmd.equals("remove") == false) goto L32;
        r2 = 4;
        goto L33
    L30:
        if (cmd.equals("start-watching") == false) goto L32;
        r2 = 5;
        goto L33
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter pw = getOutPrintWriter();
        pw.println("Network policy manager (netpolicy) commands:");
        pw.println("  help");
        pw.println("    Print this help text.");
        pw.println("");
        pw.println("  add restrict-background-whitelist UID");
        pw.println("    Adds a UID to the whitelist for restrict background usage.");
        pw.println("  add restrict-background-blacklist UID");
        pw.println("    Adds a UID to the blacklist for restrict background usage.");
        pw.println("  add app-idle-whitelist UID");
        pw.println("    Adds a UID to the temporary app idle whitelist.");
        pw.println("  get restrict-background");
        pw.println("    Gets the global restrict background usage status.");
        pw.println("  list wifi-networks [true|false]");
        pw.println("    Lists all saved wifi networks and whether they are metered or not.");
        pw.println("    If a boolean argument is passed, filters just the metered (or unmetered)");
        pw.println("    networks.");
        pw.println("  list restrict-background-whitelist");
        pw.println("    Lists UIDs that are whitelisted for restrict background usage.");
        pw.println("  list restrict-background-blacklist");
        pw.println("    Lists UIDs that are blacklisted for restrict background usage.");
        pw.println("  remove restrict-background-whitelist UID");
        pw.println("    Removes a UID from the whitelist for restrict background usage.");
        pw.println("  remove restrict-background-blacklist UID");
        pw.println("    Removes a UID from the blacklist for restrict background usage.");
        pw.println("  remove app-idle-whitelist UID");
        pw.println("    Removes a UID from the temporary app idle whitelist.");
        pw.println("  set metered-network ID [undefined|true|false]");
        pw.println("    Toggles whether the given wi-fi network is metered.");
        pw.println("  set restrict-background BOOLEAN");
        pw.println("    Sets the global restrict background usage status.");
        pw.println("  set sub-plan-owner subId [packageName]");
        pw.println("    Sets the data plan owner package for subId.");
    }

    private int runGet() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to get");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -747095841: goto L13;
            case 909005781: goto L10;
            default: goto L15;
        };
    L15:
        byte r3 = -1;
    L16:
        switch(r3) {
            case 0: goto L22;
            case 1: goto L20;
            default: goto L17;
        };
    L17:
        pw.println("Error: unknown get type '" + type + "'");
        return -1;
    L20:
        return getRestrictedModeState();
    L22:
        return getRestrictBackground();
    L10:
        if (type.equals("restricted-mode") == false) goto L23;
        r3 = 1;
        goto L16
    L23:
        r3 = -1;
        goto L16
    L13:
        if (type.equals("restrict-background") == false) goto L24;
        r3 = 0;
        goto L16
    L24:
        r3 = -1;
        goto L16
    }

    private int runSet() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to set");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -983249079: goto L16;
            case -747095841: goto L13;
            case 1846940860: goto L10;
            default: goto L18;
        };
    L18:
        byte r3 = -1;
    L19:
        switch(r3) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            default: goto L20;
        };
    L20:
        pw.println("Error: unknown set type '" + type + "'");
        return -1;
    L23:
        return setSubPlanOwner();
    L25:
        return setRestrictBackground();
    L27:
        return setMeteredWifiNetwork();
    L10:
        if (type.equals("sub-plan-owner") == false) goto L28;
        r3 = 2;
        goto L19
    L28:
        r3 = -1;
        goto L19
    L13:
        if (type.equals("restrict-background") == false) goto L29;
        r3 = 1;
        goto L19
    L29:
        r3 = -1;
        goto L19
    L16:
        if (type.equals("metered-network") == false) goto L30;
        r3 = 0;
        goto L19
    L30:
        r3 = -1;
        goto L19
    }

    private int runList() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to list");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -1683867974: goto L19;
            case -668534353: goto L16;
            case -363534403: goto L13;
            case 639570137: goto L10;
            default: goto L21;
        };
    L21:
        byte r3 = -1;
    L22:
        switch(r3) {
            case 0: goto L32;
            case 1: goto L30;
            case 2: goto L28;
            case 3: goto L26;
            default: goto L23;
        };
    L23:
        pw.println("Error: unknown list type '" + type + "'");
        return -1;
    L26:
        return listRestrictBackgroundDenylist();
    L28:
        return listRestrictBackgroundAllowlist();
    L30:
        return listWifiNetworks();
    L32:
        return listAppIdleAllowlist();
    L10:
        if (type.equals("restrict-background-whitelist") == false) goto L33;
        r3 = 2;
        goto L22
    L33:
        r3 = -1;
        goto L22
    L13:
        if (type.equals("wifi-networks") == false) goto L34;
        r3 = 1;
        goto L22
    L34:
        r3 = -1;
        goto L22
    L16:
        if (type.equals("restrict-background-blacklist") == false) goto L35;
        r3 = 3;
        goto L22
    L35:
        r3 = -1;
        goto L22
    L19:
        if (type.equals("app-idle-whitelist") == false) goto L36;
        r3 = 0;
        goto L22
    L36:
        r3 = -1;
        goto L22
    }

    private int runAdd() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to add");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -1683867974: goto L16;
            case -668534353: goto L13;
            case 639570137: goto L10;
            default: goto L18;
        };
    L18:
        byte r3 = -1;
    L19:
        switch(r3) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            default: goto L20;
        };
    L20:
        pw.println("Error: unknown add type '" + type + "'");
        return -1;
    L23:
        return addAppIdleAllowlist();
    L25:
        return addRestrictBackgroundDenylist();
    L27:
        return addRestrictBackgroundAllowlist();
    L10:
        if (type.equals("restrict-background-whitelist") == false) goto L28;
        r3 = 0;
        goto L19
    L28:
        r3 = -1;
        goto L19
    L13:
        if (type.equals("restrict-background-blacklist") == false) goto L29;
        r3 = 1;
        goto L19
    L29:
        r3 = -1;
        goto L19
    L16:
        if (type.equals("app-idle-whitelist") == false) goto L30;
        r3 = 2;
        goto L19
    L30:
        r3 = -1;
        goto L19
    }

    private int runRemove() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String type = getNextArg();
        if (type != null) goto L7;
        pw.println("Error: didn't specify type of data to remove");
        return -1;
    L7:
        switch(type.hashCode()) {
            case -1683867974: goto L16;
            case -668534353: goto L13;
            case 639570137: goto L10;
            default: goto L18;
        };
    L18:
        byte r3 = -1;
    L19:
        switch(r3) {
            case 0: goto L27;
            case 1: goto L25;
            case 2: goto L23;
            default: goto L20;
        };
    L20:
        pw.println("Error: unknown remove type '" + type + "'");
        return -1;
    L23:
        return removeAppIdleAllowlist();
    L25:
        return removeRestrictBackgroundDenylist();
    L27:
        return removeRestrictBackgroundAllowlist();
    L10:
        if (type.equals("restrict-background-whitelist") == false) goto L28;
        r3 = 0;
        goto L19
    L28:
        r3 = -1;
        goto L19
    L13:
        if (type.equals("restrict-background-blacklist") == false) goto L29;
        r3 = 1;
        goto L19
    L29:
        r3 = -1;
        goto L19
    L16:
        if (type.equals("app-idle-whitelist") == false) goto L30;
        r3 = 2;
        goto L19
    L30:
        r3 = -1;
        goto L19
    }

    private int runStartWatching() {
        int uid = Integer.parseInt(getNextArgRequired());
        if (uid >= 0) goto L6;
        PrintWriter pw = getOutPrintWriter();
        pw.print("Invalid UID: ");
        pw.println(uid);
        return -1;
    L6:
        this.mInterface.setDebugUid(uid);
        return 0;
    }

    private int runStopWatching() {
        this.mInterface.setDebugUid(-1);
        return 0;
    }

    private int listUidPolicies(String msg, int policy) throws RemoteException {
        int[] uids = this.mInterface.getUidsWithPolicy(policy);
        return listUidList(msg, uids);
    }

    private int listUidList(String msg, int[] uids) {
        PrintWriter pw = getOutPrintWriter();
        pw.print(msg);
        pw.print(": ");
        if (uids.length != 0) goto L5;
        pw.println("none");
    L9:
        pw.println();
        return 0;
    L5:
        int i = 0;
    L7:
        if (i >= uids.length) goto L9;
        int uid = uids[i];
        pw.print(uid);
        pw.print(' ');
        i = i + 1;
        goto L7
    }

    private int listRestrictBackgroundAllowlist() throws RemoteException {
        return listUidPolicies("Restrict background whitelisted UIDs", 4);
    }

    private int listRestrictBackgroundDenylist() throws RemoteException {
        return listUidPolicies("Restrict background blacklisted UIDs", 1);
    }

    private int listAppIdleAllowlist() throws RemoteException {
        getOutPrintWriter();
        int[] uids = this.mInterface.getAppIdleWhitelist();
        return listUidList("App Idle whitelisted UIDs", uids);
    }

    private int getRestrictedModeState() {
        PrintWriter pw = getOutPrintWriter();
        pw.print("Restricted mode status: ");
        if (this.mInterface.isRestrictedModeEnabled() == false) goto L5;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L6:
        pw.println(r1);
        return 0;
    L5:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L6
    }

    private int getRestrictBackground() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        pw.print("Restrict background status: ");
        if (this.mInterface.getRestrictBackground() == false) goto L5;
        String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
    L6:
        pw.println(r1);
        return 0;
    L5:
        r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
        goto L6
    }

    private int setRestrictBackground() throws RemoteException {
        int enabled = getNextBooleanArg();
        if (enabled >= 0) goto L5;
        return enabled;
    L5:
        NetworkPolicyManagerService r1 = this.mInterface;
        if (enabled <= 0) goto L8;
        boolean r3 = true;
    L9:
        r1.setRestrictBackground(r3);
        return 0;
    L8:
        r3 = false;
        goto L9
    }

    private int setSubPlanOwner() throws RemoteException {
        int subId = Integer.parseInt(getNextArgRequired());
        String packageName = getNextArg();
        this.mInterface.setSubscriptionPlansOwner(subId, packageName);
        return 0;
    }

    private int setUidPolicy(int policy) throws RemoteException {
        int uid = getUidFromNextArg();
        if (uid >= 0) goto L5;
        return uid;
    L5:
        this.mInterface.setUidPolicy(uid, policy);
        return 0;
    }

    private int resetUidPolicy(String errorMessage, int expectedPolicy) throws RemoteException {
        int uid = getUidFromNextArg();
        if (uid >= 0) goto L5;
        return uid;
    L5:
        int actualPolicy = this.mInterface.getUidPolicy(uid);
        if (actualPolicy == expectedPolicy) goto L9;
        PrintWriter pw = getOutPrintWriter();
        pw.print("Error: UID ");
        pw.print(uid);
        pw.print(' ');
        pw.println(errorMessage);
        return -1;
    L9:
        this.mInterface.setUidPolicy(uid, 0);
        return 0;
    }

    private int addRestrictBackgroundAllowlist() throws RemoteException {
        return setUidPolicy(4);
    }

    private int removeRestrictBackgroundAllowlist() throws RemoteException {
        return resetUidPolicy("not whitelisted", 4);
    }

    private int addRestrictBackgroundDenylist() throws RemoteException {
        return setUidPolicy(1);
    }

    private int removeRestrictBackgroundDenylist() throws RemoteException {
        return resetUidPolicy("not blacklisted", 1);
    }

    private int setAppIdleAllowlist(boolean isWhitelisted) {
        int uid = getUidFromNextArg();
        if (uid >= 0) goto L5;
        return uid;
    L5:
        this.mInterface.setAppIdleWhitelist(uid, isWhitelisted);
        return 0;
    }

    private int addAppIdleAllowlist() throws RemoteException {
        return setAppIdleAllowlist(true);
    }

    private int removeAppIdleAllowlist() throws RemoteException {
        return setAppIdleAllowlist(false);
    }

    private int listWifiNetworks() {
        PrintWriter pw = getOutPrintWriter();
        String arg = getNextArg();
        if (arg != null) goto L6;
        int match = 0;
    L9:
        List<WifiConfiguration> configs = this.mWifiManager.getConfiguredNetworks();
        Iterator<WifiConfiguration> r4 = configs.iterator();
    L11:
        if (r4.hasNext() == false) goto L18;
        WifiConfiguration config = r4.next();
        if (arg == null) goto L16;
        if (config.meteredOverride != match) goto L11;
    L16:
        pw.print(NetworkPolicyManager.resolveNetworkId(config));
        pw.print(';');
        pw.println(overrideToString(config.meteredOverride));
        goto L11
    L18:
        return 0;
    L6:
        if (Boolean.parseBoolean(arg) == false) goto L8;
        match = 1;
        goto L9
    L8:
        match = 2;
        goto L9
    }

    private int setMeteredWifiNetwork() throws RemoteException {
        PrintWriter pw = getOutPrintWriter();
        String networkId = getNextArg();
        if (networkId != null) goto L6;
        pw.println("Error: didn't specify networkId");
        return -1;
    L6:
        String arg = getNextArg();
        if (arg != null) goto L10;
        pw.println("Error: didn't specify meteredOverride");
        return -1;
    L10:
        this.mInterface.setWifiMeteredOverride(NetworkPolicyManager.resolveNetworkId(networkId), stringToOverride(arg));
        return -1;
    }

    private static String overrideToString(int override) {
        switch(override) {
            case 1: goto L7;
            case 2: goto L5;
            default: goto L3;
        };
    L3:
        return "none";
    L5:
        return "false";
    L7:
        return "true";
    }

    private static int stringToOverride(String override) {
        switch(override.hashCode()) {
            case 3569038: goto L9;
            case 97196323: goto L6;
            default: goto L11;
        };
    L11:
        byte r0 = -1;
    L12:
        switch(r0) {
            case 0: goto L16;
            case 1: goto L14;
            default: goto L13;
        };
    L13:
        return 0;
    L14:
        return 2;
    L16:
        return 1;
    L6:
        if (override.equals("false") == false) goto L11;
        r0 = 1;
        goto L12
    L9:
        if (override.equals("true") == false) goto L11;
        r0 = 0;
        goto L12
    }

    private int getNextBooleanArg() {
        PrintWriter r0 = getOutPrintWriter();
        String r1 = getNextArg();
        if (r1 != null) goto L7;
        r0.println("Error: didn't specify BOOLEAN");
        return -1;
    L7:
        return Boolean.valueOf(r1).booleanValue() ? 1 : 0;
    }

    private int getUidFromNextArg() {
        PrintWriter pw = getOutPrintWriter();
        String arg = getNextArg();
        if (arg != null) goto L11;
        pw.println("Error: didn't specify UID");
        return -1;
    L11:
        return Integer.parseInt(arg);
    L9:
        pw.println("Error: UID (" + arg + ") should be a number");
        return -2;
    }
}
