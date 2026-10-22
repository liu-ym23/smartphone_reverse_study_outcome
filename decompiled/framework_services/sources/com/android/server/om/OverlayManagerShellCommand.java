package com.android.server.om;

import android.content.Context;
import android.content.om.FabricatedOverlay;
import android.content.om.IOverlayManager;
import android.content.om.OverlayIdentifier;
import android.content.om.OverlayInfo;
import android.content.om.OverlayManagerTransaction;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.os.ShellCommand;
import android.os.UserHandle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.server.pm.Settings;
import com.android.server.wm.ActivityTaskManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class OverlayManagerShellCommand extends ShellCommand {
    private static final Map<String, Integer> TYPE_MAP = null;
    private final Context mContext;
    private final IOverlayManager mInterface;

    static {
        TYPE_MAP = Map.of("color", 28, "string", 3, "drawable", -1);
    }

    OverlayManagerShellCommand(Context ctx, IOverlayManager iom) {
        this.mContext = ctx;
        this.mInterface = iom;
    }

    public int onCommand(String cmd) {
        if (cmd == null) goto L4;
        PrintWriter err = getErrPrintWriter();
    L12:
        e = move-exception;
        err.println("Remote exception: " + e);
    L59:
        return -1;
    L14:
        e = move-exception;
        err.println("Error: " + e.getMessage());
        goto L59
    L7:
        switch(cmd.hashCode()) {
            case -1361113425: goto L35;
            case -1298848381: goto L32;
            case -1097094790: goto L29;
            case -794624300: goto L26;
            case 3322014: goto L23;
            case 1135695531: goto L20;
            case 1671308008: goto L17;
            case 2016903117: goto L10;
            default: goto L37;
        };     // Catch: RemoteException -> L12 IllegalArgumentException -> L14
    L37:
        byte r2 = -1;
    L38:
        switch(r2) {
            case 0: goto L56;
            case 1: goto L54;
            case 2: goto L52;
            case 3: goto L50;
            case 4: goto L48;
            case 5: goto L46;
            case 6: goto L44;
            case 7: goto L42;
            default: goto L40;
        };     // Catch: RemoteException -> L12 IllegalArgumentException -> L14
    L40:
        return handleDefaultCommands(cmd);
    L42:
        return runPartitionOrder();
    L44:
        return runFabricate();
    L46:
        return runLookup();
    L48:
        return runSetPriority();
    L50:
        return runEnableExclusive();
    L52:
        return runEnableDisable(false);
    L54:
        return runEnableDisable(true);
    L56:
        return runList();
    L10:
        if (cmd.equals("fabricate") == false) goto L37;
        r2 = 6;
        goto L38
    L17:
        if (cmd.equals("disable") == false) goto L37;
        r2 = 2;
        goto L38
    L20:
        if (cmd.equals("partition-order") == false) goto L37;
        r2 = 7;
        goto L38
    L23:
        if (cmd.equals("list") == false) goto L37;
        r2 = 0;
        goto L38
    L26:
        if (cmd.equals("enable-exclusive") == false) goto L37;
        r2 = 3;
        goto L38
    L29:
        if (cmd.equals("lookup") == false) goto L37;
        r2 = 5;
        goto L38
    L32:
        if (cmd.equals("enable") == false) goto L37;
        r2 = 1;
        goto L38
    L35:
        if (cmd.equals("set-priority") == false) goto L37;
        r2 = 4;
        goto L38
    L4:
        return handleDefaultCommands(cmd);
    }

    public void onHelp() {
        PrintWriter out = getOutPrintWriter();
        out.println("Overlay manager (overlay) commands:");
        out.println("  help");
        out.println("    Print this help text.");
        out.println("  dump [--verbose] [--user USER_ID] [[FIELD] PACKAGE[:NAME]]");
        out.println("    Print debugging information about the overlay manager.");
        out.println("    With optional parameters PACKAGE and NAME, limit output to the specified");
        out.println("    overlay or target. With optional parameter FIELD, limit output to");
        out.println("    the corresponding SettingsItem field. Field names are all lower case");
        out.println("    and omit the m prefix, i.e. 'userid' for SettingsItem.mUserId.");
        out.println("  list [--user USER_ID] [PACKAGE[:NAME]]");
        out.println("    Print information about target and overlay packages.");
        out.println("    Overlay packages are printed in priority order. With optional");
        out.println("    parameters PACKAGE and NAME, limit output to the specified overlay or");
        out.println("    target.");
        out.println("  enable [--user USER_ID] PACKAGE[:NAME]");
        out.println("    Enable overlay within or owned by PACKAGE with optional unique NAME.");
        out.println("  disable [--user USER_ID] PACKAGE[:NAME]");
        out.println("    Disable overlay within or owned by PACKAGE with optional unique NAME.");
        out.println("  enable-exclusive [--user USER_ID] [--category] PACKAGE");
        out.println("    Enable overlay within or owned by PACKAGE and disable all other overlays");
        out.println("    for its target package. If the --category option is given, only disables");
        out.println("    other overlays in the same category.");
        out.println("  set-priority [--user USER_ID] PACKAGE PARENT|lowest|highest");
        out.println("    Change the priority of the overlay to be just higher than");
        out.println("    the priority of PARENT If PARENT is the special keyword");
        out.println("    'lowest', change priority of PACKAGE to the lowest priority.");
        out.println("    If PARENT is the special keyword 'highest', change priority of");
        out.println("    PACKAGE to the highest priority.");
        out.println("  lookup [--user USER_ID] [--verbose] PACKAGE-TO-LOAD PACKAGE:TYPE/NAME");
        out.println("    Load a package and print the value of a given resource");
        out.println("    applying the current configuration and enabled overlays.");
        out.println("    For a more fine-grained alternative, use 'idmap2 lookup'.");
        out.println("  fabricate [--target-name OVERLAYABLE] --target PACKAGE");
        out.println("            --name NAME [--file FILE] ");
        out.println("            PACKAGE:TYPE/NAME ENCODED-TYPE-ID|TYPE-NAME ENCODED-VALUE");
        out.println("    Create an overlay from a single resource. Caller must be root. Example:");
        out.println("      fabricate --target android --name LighterGray \\");
        out.println("                android:color/lighter_gray 0x1c 0xffeeeeee");
        out.println("  partition-order");
        out.println("    Print the partition order from overlay config and how this order");
        out.println("    got established, by default or by /product/overlay/partition_order.xml");
    }

    private int runList() throws RemoteException {
        PrintWriter out = getOutPrintWriter();
        PrintWriter err = getErrPrintWriter();
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r5 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        r5 = -1;
    L12:
        switch(r5) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L13:
        err.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
    L16:
        String packageName = getNextArg();
        if (packageName == null) goto L29;
        List<OverlayInfo> overlaysForTarget = this.mInterface.getOverlayInfosForTarget(packageName, userId);
        if (overlaysForTarget.isEmpty() == false) goto L24;
        OverlayInfo info = this.mInterface.getOverlayInfo(packageName, userId);
        if (info == null) goto L23;
        printListOverlay(out, info);
    L23:
        return 0;
    L24:
        out.println(packageName);
        int n = overlaysForTarget.size();
        int i = 0;
    L25:
        if (i >= n) goto L28;
        printListOverlay(out, overlaysForTarget.get(i));
        i = i + 1;
        goto L25
    L28:
        return 0;
    L29:
        Map<String, List<OverlayInfo>> allOverlays = this.mInterface.getAllOverlays(userId);
        Iterator<String> r7 = allOverlays.keySet().iterator();
    L31:
        if (r7.hasNext() == false) goto L36;
        String targetPackageName = r7.next();
        out.println(targetPackageName);
        List<OverlayInfo> overlaysForTarget2 = allOverlays.get(targetPackageName);
        int n2 = overlaysForTarget2.size();
        int i2 = 0;
    L33:
        if (i2 >= n2) goto L35;
        printListOverlay(out, overlaysForTarget2.get(i2));
        i2 = i2 + 1;
        goto L33
    L35:
        out.println();
        goto L31
    L36:
        return 0;
    }

    private void printListOverlay(PrintWriter out, OverlayInfo oi) {
        switch(oi.state) {
            case 2: goto L6;
            case 3: goto L5;
            case 4: goto L4;
            case 5: goto L4;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        String status = "---";
    L7:
        out.println(String.format("%s %s", new Object[]{status, oi.getOverlayIdentifier()}));
        return;
    L5:
        status = "[x]";
        goto L7
    L6:
        status = "[ ]";
        goto L7
    }

    private int runEnableDisable(boolean enable) throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r4 = 0;
        if (opt == null) goto L16;
        switch(opt.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        r4 = -1;
    L12:
        switch(r4) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        userId = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L13:
        err.println("Error: Unknown option: " + opt);
        return 1;
    L9:
        if (opt.equals("--user") == false) goto L11;
    L16:
        OverlayIdentifier overlay = OverlayIdentifier.fromString(getNextArgRequired());
        this.mInterface.commit(new OverlayManagerTransaction.Builder().setEnabled(overlay, enable, userId).build());
        return 0;
    }

    private int runPartitionOrder() throws RemoteException {
        PrintWriter out = getOutPrintWriter();
        out.println("Partition order (low to high priority): " + this.mInterface.getPartitionOrder());
        StringBuilder r1 = new StringBuilder();
        r1.append("Established by ");
        if (this.mInterface.isDefaultPartitionOrder() == false) goto L5;
        String r2 = "default";
    L6:
        r1.append(r2);
        out.println(r1.toString());
        return 0;
    L5:
        r2 = "/product/overlay/partition_order.xml";
        goto L6
    }

    private int runFabricate() throws RemoteException {
        PrintWriter err = getErrPrintWriter();
        if (Binder.getCallingUid() == 0) goto L6;
        err.println("Error: must be root to fabricate overlays through the shell");
        return 1;
    L6:
        String config = null;
        String targetPackage = "";
        String targetOverlayable = "";
        String name = "";
        String filename = null;
    L7:
        String opt = getNextOption();
        byte r13 = 0;
        if (opt == null) goto L38;
        switch(opt.hashCode()) {
            case -935414873: goto L25;
            case 1045221602: goto L22;
            case 1333013276: goto L19;
            case 1333243947: goto L16;
            case 1519107889: goto L13;
            default: goto L27;
        };
    L27:
        r13 = -1;
    L28:
        switch(r13) {
            case 0: goto L35;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            default: goto L29;
        };
    L29:
        err.println("Error: Unknown option: " + opt);
        return 1;
    L32:
        String filename2 = getNextArgRequired();
        filename = filename2;
        goto L7
    L33:
        String name2 = getNextArgRequired();
        name = name2;
        goto L7
    L34:
        String targetOverlayable2 = getNextArgRequired();
        targetOverlayable = targetOverlayable2;
        goto L7
    L35:
        String targetPackage2 = getNextArgRequired();
        targetPackage = targetPackage2;
        goto L7
    L31:
        String config2 = getNextArgRequired();
        config = config2;
        goto L7
    L13:
        if (opt.equals("--target") == false) goto L27;
    L16:
        if (opt.equals("--name") == false) goto L27;
        r13 = 2;
        goto L28
    L19:
        if (opt.equals("--file") == false) goto L27;
        r13 = 3;
        goto L28
    L22:
        if (opt.equals("--config") == false) goto L27;
        r13 = 4;
        goto L28
    L25:
        if (opt.equals("--target-name") == false) goto L27;
        r13 = 1;
        goto L28
    L38:
        if (name.isEmpty() == false) goto L42;
        err.println("Error: Missing required arg '--name'");
        return 1;
    L42:
        if (targetPackage.isEmpty() == false) goto L45;
        err.println("Error: Missing required arg '--target'");
        return 1;
    L45:
        if (filename != null) goto L47;
    L50:
        FabricatedOverlay overlay = new FabricatedOverlay(name, targetPackage);
        overlay.setTargetOverlayable(targetOverlayable);
        overlay.setOwningPackage("com.android.shell");
        if (filename == null) goto L56;
        int result = addOverlayValuesFromXml(overlay, targetPackage, filename);
        if (result == 0) goto L59;
        return result;
    L59:
        this.mInterface.commit(new OverlayManagerTransaction.Builder().registerFabricatedOverlay(overlay).build());
        return 0;
    L56:
        String resourceName = getNextArgRequired();
        String typeStr = getNextArgRequired();
        String strData = String.join(" ", peekRemainingArgs());
        if (addOverlayValue(overlay, resourceName, typeStr, strData, config) == 0) goto L59;
        return 1;
    L47:
        if (getRemainingArgsCount() <= 0) goto L50;
        err.println("Error: When passing --file don't pass resource name, type, and value as well");
        return 1;
    }

    private int addOverlayValuesFromXml(FabricatedOverlay overlay, String targetPackage, String filename) {
        PrintWriter err = getErrPrintWriter();
        File file = new File(filename);
        if (file.exists() == true) goto L7;
        err.println("Error: File does not exist");
        return 1;
    L7:
        if (file.canRead() == true) goto L70;
        err.println("Error: File is unreadable");
        return 1;
    L70:
        FileInputStream fis = new FileInputStream(file);     // Catch: XmlPullParserException -> L31 IOException -> L33
        TypedXmlPullParser parser = Xml.resolvePullParser(fis);     // Catch: Throwable -> L24
    L13:
        int type = parser.next();     // Catch: Throwable -> L24
        if (type == 2) goto L17;
        if (type != 1) goto L13;
    L17:
        parser.require(2, null, "overlay");     // Catch: Throwable -> L24
    L18:
        int type2 = parser.next();     // Catch: Throwable -> L24
        if (type2 == 1) goto L56;
        if (type2 != 2) goto L18;
        String tagName = parser.getName();     // Catch: Throwable -> L24
        if (tagName.equals(Settings.TAG_ITEM) == true) goto L27;
        err.println(TextUtils.formatSimple("Error: Unexpected tag: %s at line %d", new Object[]{tagName, Integer.valueOf(parser.getLineNumber())}));     // Catch: Throwable -> L24
        goto L18
    L27:
        if (parser.isEmptyElementTag() == false) goto L28;
        String target = parser.getAttributeValue(null, "target");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(target) == true) goto L37;
        int index = target.indexOf(47);     // Catch: Throwable -> L24
        if (index < 0) goto L43;
        String overlayType = target.substring(0, index);     // Catch: Throwable -> L24
        String value = parser.getAttributeValue(null, "value");     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(value) == true) goto L48;
        String config = parser.getAttributeValue(null, "config");     // Catch: Throwable -> L24
        if (addOverlayValue(overlay, targetPackage + ':' + target, overlayType, value, config) == 0) goto L18;
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 1;
    L48:
        err.println("Error: value missing at line " + parser.getLineNumber());     // Catch: Throwable -> L24
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 1;
    L43:
        err.println("Error: target malformed, missing '/' at line " + parser.getLineNumber());     // Catch: Throwable -> L24
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 1;
    L37:
        err.println("Error: target name missing at line " + parser.getLineNumber());     // Catch: Throwable -> L24
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 1;
    L28:
        err.println("Error: item tag must be empty");     // Catch: Throwable -> L24
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 1;
    L56:
        fis.close();     // Catch: XmlPullParserException -> L31 IOException -> L33
        return 0;
    L24:
        th = move-exception;
        fis.close();     // Catch: Throwable -> L60
        throw th;     // Catch: XmlPullParserException -> L31 IOException -> L33
    L60:
        th = move-exception;
        th.addSuppressed(th);     // Catch: XmlPullParserException -> L31 IOException -> L33
        throw th;     // Catch: XmlPullParserException -> L31 IOException -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        return 1;
    L31:
        e = move-exception;
        e.printStackTrace();
        return 1;
    }

    private int addOverlayValue(FabricatedOverlay overlay, String resourceName, String typeString, String valueString, String configuration) {
        String typeString2 = typeString.toLowerCase(Locale.getDefault());
        if (TYPE_MAP.containsKey(typeString2) == false) goto L6;
        int type = TYPE_MAP.get(typeString2).intValue();
    L10:
        if (type != 3) goto L12;
        overlay.setResourceValue(resourceName, type, valueString, configuration);
        return 0;
    L12:
        if (type >= 0) goto L19;
        ParcelFileDescriptor pfd = openFileForSystem(valueString, ActivityTaskManagerService.DUMP_RECENTS_SHORT_CMD);
        if (valueString.endsWith(".9.png") == false) goto L16;
        overlay.setNinePatchResourceValue(resourceName, pfd, configuration);
        return 0;
    L16:
        overlay.setResourceValue(resourceName, pfd, configuration);
        return 0;
    L19:
        if (valueString.startsWith("0x") == false) goto L21;
        int intData = Integer.parseUnsignedInt(valueString.substring(2), 16);
    L22:
        overlay.setResourceValue(resourceName, type, intData, configuration);
        return 0;
    L21:
        intData = Integer.parseUnsignedInt(valueString);
        goto L22
    L6:
        if (typeString2.startsWith("0x") == false) goto L8;
        type = Integer.parseUnsignedInt(typeString2.substring(2), 16);
        goto L10
    L8:
        type = Integer.parseUnsignedInt(typeString2);
        goto L10
    }

    private int runEnableExclusive() throws RemoteException {
        PrintWriter r0 = getErrPrintWriter();
        int r1 = -2;
        boolean r2 = false;
    L3:
        String r3 = getNextOption();
        if (r3 == null) goto L21;
        switch(r3.hashCode()) {
            case 66265758: goto L12;
            case 1333469547: goto L9;
            default: goto L14;
        };
    L14:
        byte r4 = -1;
    L15:
        switch(r4) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        r0.println("Error: Unknown option: " + r3);
        return 1;
    L19:
        r1 = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L18:
        r2 = true;
        goto L3
    L9:
        if (r3.equals("--user") == false) goto L14;
        r4 = 0;
        goto L15
    L12:
        if (r3.equals("--category") == false) goto L14;
        r4 = 1;
        goto L15
    L21:
        String r5 = getNextArgRequired();
        if (r2 == false) goto L26;
        return 1 ^ (this.mInterface.setEnabledExclusiveInCategory(r5, r1) ? 1 : 0);
    L26:
        return 1 ^ (this.mInterface.setEnabledExclusive(r5, true, r1) ? 1 : 0);
    }

    private int runSetPriority() throws RemoteException {
        PrintWriter r0 = getErrPrintWriter();
        int r1 = -2;
    L3:
        String r2 = getNextOption();
        if (r2 == null) goto L16;
        switch(r2.hashCode()) {
            case 1333469547: goto L9;
            default: goto L11;
        };
    L11:
        byte r3 = -1;
    L12:
        switch(r3) {
            case 0: goto L15;
            default: goto L13;
        };
    L15:
        r1 = UserHandle.parseUserArg(getNextArgRequired());
        goto L3
    L13:
        r0.println("Error: Unknown option: " + r2);
        return 1;
    L9:
        if (r2.equals("--user") == false) goto L11;
        r3 = 0;
        goto L12
    L16:
        String r4 = getNextArgRequired();
        String r5 = getNextArgRequired();
        if ("highest".equals(r5) == false) goto L21;
        return 1 ^ (this.mInterface.setHighestPriority(r4, r1) ? 1 : 0);
    L21:
        if ("lowest".equals(r5) == false) goto L25;
        return 1 ^ (this.mInterface.setLowestPriority(r4, r1) ? 1 : 0);
    L25:
        return 1 ^ (this.mInterface.setPriority(r4, r5, r1) ? 1 : 0);
    }

    private int runLookup() throws RemoteException {
        PrintWriter out = getOutPrintWriter();
        PrintWriter err = getErrPrintWriter();
        boolean verbose = false;
        int userId = -2;
    L3:
        String opt = getNextOption();
        byte r6 = 0;
        if (opt == null) goto L21;
        switch(opt.hashCode()) {
            case 1333469547: goto L12;
            case 1737088994: goto L9;
            default: goto L14;
        };
    L14:
        r6 = -1;
    L15:
        switch(r6) {
            case 0: goto L19;
            case 1: goto L18;
            default: goto L16;
        };
    L16:
        err.println("Error: Unknown option: " + opt);
        return 1;
    L19:
        int userId2 = UserHandle.parseUserArg(getNextArgRequired());
        userId = userId2;
        goto L3
    L18:
        verbose = true;
        goto L3
    L9:
        if (opt.equals("--verbose") == false) goto L14;
        r6 = 1;
        goto L15
    L12:
        if (opt.equals("--user") == false) goto L14;
    L21:
        String packageToLoad = getNextArgRequired();
        String fullyQualifiedResourceName = getNextArgRequired();
        Pattern regex = Pattern.compile("(.*?):(.*?)/(.*?)");
        Matcher matcher = regex.matcher(fullyQualifiedResourceName);
        if (matcher.matches() == true) goto L25;
        err.println("Error: bad resource name, doesn't match package:type/name");
        return 1;
    L25:
        int realUserId = OverlayManagerService.handleIncomingUser(userId, "runLookup");
        Resources res = this.mContext.createContextAsUser(UserHandle.of(realUserId), 0).getPackageManager().getResourcesForApplication(packageToLoad);     // Catch: PackageManager.NameNotFoundException -> L88
        AssetManager assets = res.getAssets();
        assets.setResourceResolutionLoggingEnabled(true);     // Catch: Throwable -> L59
        TypedValue value = new TypedValue();     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        res.getValue(fullyQualifiedResourceName, value, false);     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        CharSequence valueString = value.coerceToString();     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        String resolution = assets.getLastResourceResolution();     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        res.getValue(fullyQualifiedResourceName, value, true);     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        CharSequence resolvedString = value.coerceToString();     // Catch: Throwable -> L59 Resources.NotFoundException -> L61
        if (verbose == false) goto L41;
        out.println(resolution);     // Catch: Throwable -> L35 Resources.NotFoundException -> L37
    L35:
        e = th;
    L86:
        assets.setResourceResolutionLoggingEnabled(false);
        throw e;
    L41:
        if (valueString.equals(resolvedString) == false) goto L99;
        out.println(valueString);     // Catch: Throwable -> L35 Resources.NotFoundException -> L37
    L49:
        assets.setResourceResolutionLoggingEnabled(false);
        return 0;
    L99:
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L55 Resources.NotFoundException -> L57
        r3.append(valueString);     // Catch: Throwable -> L55 Resources.NotFoundException -> L57
        goto L94
    L97:
        r3.append(" -> ");     // Catch: Throwable -> L51 Resources.NotFoundException -> L53
        r3.append(resolvedString);     // Catch: Throwable -> L51 Resources.NotFoundException -> L53
        out.println(r3.toString());     // Catch: Throwable -> L51 Resources.NotFoundException -> L53
    L55:
        e = th;
        goto L86
    L94:
        String pkg = matcher.group(1);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        String type = matcher.group(2);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        String name = matcher.group(3);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        int resid = res.getIdentifier(name, type, pkg);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        if (resid == 0) goto L81;
        TypedArray array = res.obtainTypedArray(resid);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        if (verbose == false) goto L72;
        String pkg2 = assets.getLastResourceResolution();     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        out.println(pkg2);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
    L72:
        TypedValue tv = new TypedValue();     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        int i = 0;
    L73:
        String name2 = name;
        if (i >= array.length()) goto L76;
        array.getValue(i, tv);     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        out.println(tv.coerceToString());     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        i = i + 1;     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        name = name2;
        goto L73
    L76:
        array.recycle();     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
        assets.setResourceResolutionLoggingEnabled(false);
        return 0;
    L81:
        throw new Resources.NotFoundException();     // Catch: Throwable -> L51 Resources.NotFoundException -> L69
    L83:
        err.println("Error: failed to get the resource " + fullyQualifiedResourceName);     // Catch: Throwable -> L51
        assets.setResourceResolutionLoggingEnabled(false);
        return 1;
    L51:
        e = th;
    L59:
        e = th;
    L89:
        err.println(String.format("Error: failed to get resources for package %s for user %d", new Object[]{packageToLoad, Integer.valueOf(realUserId)}));
        return 1;
    }
}
