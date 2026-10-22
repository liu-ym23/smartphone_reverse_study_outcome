package com.android.server.pm.permission;

import android.content.pm.PermissionInfo;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.DumpState;
import com.android.server.pm.PackageManagerService;
import com.android.server.voiceinteraction.DatabaseHelper;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import libcore.util.EmptyArray;

/* JADX INFO: loaded from: classes2.dex */
public final class LegacyPermission {
    private static final String ATTR_NAME = "name";
    private static final String ATTR_PACKAGE = "package";
    private static final String TAG_ITEM = "item";
    public static final int TYPE_CONFIG = 1;
    public static final int TYPE_DYNAMIC = 2;
    public static final int TYPE_MANIFEST = 0;
    private final int[] mGids;
    private final PermissionInfo mPermissionInfo;
    private final int mType;
    private final int mUid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionType {
    }

    public LegacyPermission(PermissionInfo permissionInfo, int type, int uid, int[] gids) {
        this.mPermissionInfo = permissionInfo;
        this.mType = type;
        this.mUid = uid;
        this.mGids = gids;
    }

    private LegacyPermission(String name, String packageName, int type) {
        this.mPermissionInfo = new PermissionInfo();
        this.mPermissionInfo.name = name;
        this.mPermissionInfo.packageName = packageName;
        this.mPermissionInfo.protectionLevel = 2;
        this.mType = type;
        this.mUid = 0;
        this.mGids = EmptyArray.INT;
    }

    public PermissionInfo getPermissionInfo() {
        return this.mPermissionInfo;
    }

    public int getType() {
        return this.mType;
    }

    public static boolean read(Map<String, LegacyPermission> out, TypedXmlPullParser parser) {
        String tagName = parser.getName();
        if (tagName.equals("item") == true) goto L5;
        return false;
    L5:
        String name = parser.getAttributeValue(null, "name");
        String packageName = parser.getAttributeValue(null, "package");
        String ptype = parser.getAttributeValue(null, DatabaseHelper.SoundModelContract.KEY_TYPE);
        if (name == null) goto L23;
        if (packageName == null) goto L23;
        boolean dynamic = "dynamic".equals(ptype);
        LegacyPermission bp = out.get(name);
        if (bp != null) goto L12;
    L13:
        String r10 = name.intern();
        if (dynamic == false) goto L16;
        int r11 = 2;
    L17:
        bp = new LegacyPermission(r10, packageName, r11);
    L18:
        bp.mPermissionInfo.protectionLevel = readInt(parser, null, "protection", 0);
        bp.mPermissionInfo.protectionLevel = PermissionInfo.fixProtectionLevel(bp.mPermissionInfo.protectionLevel);
        if (dynamic == false) goto L21;
        bp.mPermissionInfo.icon = readInt(parser, null, "icon", 0);
        bp.mPermissionInfo.nonLocalizedLabel = parser.getAttributeValue(null, "label");
    L21:
        out.put(bp.mPermissionInfo.name, bp);
        return true;
    L16:
        r11 = 0;
        goto L17
    L12:
        if (bp.mType == 1) goto L18;
    L23:
        PackageManagerService.reportSettingsProblem(5, "Error in package manager settings: permissions has no name at " + parser.getPositionDescription());
        return false;
    }

    private static int readInt(TypedXmlPullParser parser, String namespace, String name, int defaultValue) {
        return parser.getAttributeInt(namespace, name, defaultValue);
    }

    public void write(TypedXmlSerializer serializer) throws IOException {
        if (this.mPermissionInfo.packageName != null) goto L5;
        return;
    L5:
        serializer.startTag(null, "item");
        serializer.attribute(null, "name", this.mPermissionInfo.name);
        serializer.attribute(null, "package", this.mPermissionInfo.packageName);
        if (this.mPermissionInfo.protectionLevel == 0) goto L9;
        serializer.attributeInt(null, "protection", this.mPermissionInfo.protectionLevel);
    L9:
        if (this.mType != 2) goto L16;
        serializer.attribute(null, DatabaseHelper.SoundModelContract.KEY_TYPE, "dynamic");
        if (this.mPermissionInfo.icon == 0) goto L14;
        serializer.attributeInt(null, "icon", this.mPermissionInfo.icon);
    L14:
        if (this.mPermissionInfo.nonLocalizedLabel == null) goto L16;
        serializer.attribute(null, "label", this.mPermissionInfo.nonLocalizedLabel.toString());
    L16:
        serializer.endTag(null, "item");
    }

    public boolean dump(PrintWriter pw, String packageName, Set<String> permissionNames, boolean readEnforced, boolean printedSomething, DumpState dumpState) {
        if (packageName != null) goto L5;
    L7:
        if (permissionNames != null) goto L9;
    L11:
        if (printedSomething == false) goto L13;
    L16:
        pw.print("  Permission [");
        pw.print(this.mPermissionInfo.name);
        pw.print("] (");
        pw.print(Integer.toHexString(System.identityHashCode(this)));
        pw.println("):");
        pw.print("    sourcePackage=");
        pw.println(this.mPermissionInfo.packageName);
        pw.print("    uid=");
        pw.print(this.mUid);
        pw.print(" gids=");
        pw.print(Arrays.toString(this.mGids));
        pw.print(" type=");
        pw.print(this.mType);
        pw.print(" prot=");
        pw.println(PermissionInfo.protectionToString(this.mPermissionInfo.protectionLevel));
        if (this.mPermissionInfo == null) goto L24;
        pw.print("    perm=");
        pw.println(this.mPermissionInfo);
        if ((this.mPermissionInfo.flags & 1073741824) != 0) goto L21;
    L22:
        pw.print("    flags=0x");
        pw.println(Integer.toHexString(this.mPermissionInfo.flags));
        goto L24
    L21:
        if ((this.mPermissionInfo.flags & 2) != 0) goto L22;
    L24:
        if (Objects.equals(this.mPermissionInfo.name, "android.permission.READ_EXTERNAL_STORAGE") == false) goto L28;
        pw.print("    enforced=");
        pw.println(readEnforced);
        return true;
    L28:
        return true;
    L13:
        if (dumpState.onTitlePrinted() == false) goto L15;
        pw.println();
    L15:
        pw.println("Permissions:");
        goto L16
    L9:
        if (permissionNames.contains(this.mPermissionInfo.name) == true) goto L11;
        return false;
    L5:
        if (packageName.equals(this.mPermissionInfo.packageName) == true) goto L7;
        return false;
    }
}
