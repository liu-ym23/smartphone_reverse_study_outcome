package com.android.server.pm;

import android.content.pm.PackageInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.UserPackage;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import android.util.Xml;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
class ShortcutLauncher extends ShortcutPackageItem {
    private static final String ATTR_LAUNCHER_USER_ID = "launcher-user";
    private static final String ATTR_PACKAGE_NAME = "package-name";
    private static final String ATTR_PACKAGE_USER_ID = "package-user";
    private static final String ATTR_VALUE = "value";
    private static final String TAG = "ShortcutService";
    private static final String TAG_PACKAGE = "package";
    private static final String TAG_PIN = "pin";
    static final String TAG_ROOT = "launcher-pins";
    private final int mOwnerUserId;
    private final ArrayMap<UserPackage, ArraySet<String>> mPinnedShortcuts;

    private ShortcutLauncher(ShortcutUser shortcutUser, int ownerUserId, String packageName, int launcherUserId, ShortcutPackageInfo spi) {
        if (spi == null) goto L4;
        ShortcutPackageInfo r0 = spi;
    L5:
        super(shortcutUser, launcherUserId, packageName, r0);
        this.mPinnedShortcuts = new ArrayMap();
        this.mOwnerUserId = ownerUserId;
        return;
    L4:
        r0 = ShortcutPackageInfo.newEmpty();
        goto L5
    }

    public ShortcutLauncher(ShortcutUser shortcutUser, int ownerUserId, String packageName, int launcherUserId) {
        this(shortcutUser, ownerUserId, packageName, launcherUserId, null);
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public int getOwnerUserId() {
        return this.mOwnerUserId;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected boolean canRestoreAnyVersion() {
        return true;
    }

    private void onRestoreBlocked() {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArrayList<UserPackage> pinnedPackages = new ArrayList(this.mPinnedShortcuts.keySet());     // Catch: Throwable -> L14
        this.mPinnedShortcuts.clear();     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        int i = pinnedPackages.size() - 1;
    L7:
        if (i < 0) goto L13;
        UserPackage up = pinnedPackages.get(i);
        ShortcutPackage p = this.mShortcutUser.getPackageShortcutsIfExists(up.packageName);
        if (p == null) goto L11;
        p.refreshPinnedFlags();
    L11:
        i = i - 1;
        goto L7
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected void onRestored(int restoreBlockReason) {
        if (restoreBlockReason == 0) goto L5;
        onRestoreBlocked();
        return;
    }

    public void pinShortcuts(int packageUserId, String packageName, List<String> ids, boolean forPinRequest) {
        ShortcutPackage packageShortcuts = this.mShortcutUser.getPackageShortcutsIfExists(packageName);
        if (packageShortcuts != null) goto L5;
        return;
    L5:
        UserPackage up = UserPackage.of(packageUserId, packageName);
        int idSize = ids.size();
        if (idSize != 0) goto L15;
        Object r3 = this.mPackageItemLock;
        monitor-enter(r3);
        this.mPinnedShortcuts.remove(up);     // Catch: Throwable -> L12
        monitor-exit(r3);     // Catch: Throwable -> L12
    L46:
        packageShortcuts.refreshPinnedFlags();
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        ArraySet<String> floatingSet = new ArraySet();
        ArraySet<String> newSet = new ArraySet();
        int i = 0;
    L16:
        if (i >= idSize) goto L31;
        String id = ids.get(i);
        ShortcutInfo si = packageShortcuts.findShortcutById(id);
        if (si == null) goto L30;
        if (si.isDynamic() == false) goto L23;
    L29:
        newSet.add(id);
        goto L30
    L23:
        if (si.isLongLived() == true) goto L29;
        if (si.isManifestShortcut() == true) goto L29;
        if (forPinRequest == true) goto L29;
        floatingSet.add(id);
    L30:
        i = i + 1;
        goto L16
    L31:
        Object r5 = this.mPackageItemLock;
        monitor-enter(r5);
        ArraySet<String> prevSet = this.mPinnedShortcuts.get(up);     // Catch: Throwable -> L41
        if (prevSet == null) goto L44;
        Iterator<String> r7 = floatingSet.iterator();     // Catch: Throwable -> L41
    L37:
        if (r7.hasNext() == false) goto L44;
        String id2 = r7.next();     // Catch: Throwable -> L41
        if (prevSet.contains(id2) == false) goto L37;
        newSet.add(id2);     // Catch: Throwable -> L41
    L44:
        this.mPinnedShortcuts.put(up, newSet);     // Catch: Throwable -> L41
        monitor-exit(r5);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    }

    public ArraySet<String> getPinnedShortcutIds(String packageName, int packageUserId) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArraySet<String> pinnedShortcuts = this.mPinnedShortcuts.get(UserPackage.of(packageUserId, packageName));     // Catch: Throwable -> L10
        if (pinnedShortcuts != null) goto L7;
        ArraySet<String> r2 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r2;
    L7:
        r2 = new ArraySet(pinnedShortcuts);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public boolean hasPinned(ShortcutInfo shortcut) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArraySet<String> pinned = this.mPinnedShortcuts.get(UserPackage.of(shortcut.getUserId(), shortcut.getPackage()));     // Catch: Throwable -> L9
        if (pinned != null) goto L7;
    L11:
        boolean r2 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r2;
    L7:
        if (pinned.contains(shortcut.getId()) == false) goto L11;
        r2 = true;
    L9:
        th = move-exception;
        throw th;
    }

    public void addPinnedShortcut(String packageName, int packageUserId, String id, boolean forPinRequest) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArraySet<String> pinnedSet = this.mPinnedShortcuts.get(UserPackage.of(packageUserId, packageName));     // Catch: Throwable -> L7
        if (pinnedSet == null) goto L9;
        ArrayList<String> pinnedList = new ArrayList(pinnedSet.size() + 1);     // Catch: Throwable -> L7
        pinnedList.addAll(pinnedSet);     // Catch: Throwable -> L7
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        pinnedList.add(id);
        pinShortcuts(packageUserId, packageName, pinnedList, forPinRequest);
        return;
    L9:
        pinnedList = new ArrayList(1);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    boolean cleanUpPackage(String packageName, int packageUserId) {
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mPinnedShortcuts.remove(UserPackage.of(packageUserId, packageName)) == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public void ensurePackageInfo() {
        PackageInfo pi = this.mShortcutUser.mService.getPackageInfoWithSignatures(getPackageName(), getPackageUserId());
        if (pi != null) goto L6;
        Slog.w(TAG, "Package not found: " + getPackageName());
        return;
    L6:
        getPackageInfo().updateFromPackageInfo(pi);
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public void saveToXml(TypedXmlSerializer out, boolean forBackup) throws IOException {
        if (forBackup == true) goto L4;
    L6:
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArrayMap<UserPackage, ArraySet<String>> pinnedShortcuts = new ArrayMap(this.mPinnedShortcuts);     // Catch: Throwable -> L27
        monitor-exit(r0);     // Catch: Throwable -> L27
        int size = pinnedShortcuts.size();
        if (size != 0) goto L13;
        return;
    L13:
        out.startTag(null, TAG_ROOT);
        ShortcutService.writeAttr(out, ATTR_PACKAGE_NAME, getPackageName());
        ShortcutService.writeAttr(out, ATTR_LAUNCHER_USER_ID, getPackageUserId());
        getPackageInfo().saveToXml(this.mShortcutUser.mService, out, forBackup);
        int i = 0;
    L14:
        if (i >= size) goto L25;
        UserPackage up = pinnedShortcuts.keyAt(i);
        if (forBackup == true) goto L18;
    L20:
        out.startTag(null, "package");
        ShortcutService.writeAttr(out, ATTR_PACKAGE_NAME, up.packageName);
        ShortcutService.writeAttr(out, ATTR_PACKAGE_USER_ID, up.userId);
        ArraySet<String> ids = pinnedShortcuts.valueAt(i);
        int idSize = ids.size();
        int j = 0;
    L21:
        if (j >= idSize) goto L23;
        ShortcutService.writeTagValue(out, TAG_PIN, ids.valueAt(j));
        j = j + 1;
        goto L21
    L23:
        out.endTag(null, "package");
    L24:
        i = i + 1;
        goto L14
    L18:
        if (up.userId == getOwnerUserId()) goto L20;
    L25:
        out.endTag(null, TAG_ROOT);
        return;
    L27:
        th = move-exception;
        throw th;
    L4:
        if (getPackageInfo().isBackupAllowed() == true) goto L6;
    }

    public static ShortcutLauncher loadFromFile(File path, ShortcutUser shortcutUser, int ownerUserId, boolean fromBackup) {
        ResilientAtomicFile file = ShortcutPackageItem.getResilientFile(path);
        FileInputStream in = file.openRead();     // Catch: Throwable -> L8 Exception -> L10
        if (in != null) goto L12;
        Slog.d(TAG, "Not found " + path);     // Catch: Throwable -> L8 Exception -> L10
        file.close();
        return null;
    L12:
        ShortcutLauncher ret = null;
        TypedXmlPullParser parser = Xml.resolvePullParser(in);     // Catch: Throwable -> L8 Exception -> L10
    L14:
        int type = parser.next();     // Catch: Throwable -> L8 Exception -> L10
        if (type == 1) goto L26;
        if (type != 2) goto L14;
        int depth = parser.getDepth();     // Catch: Throwable -> L8 Exception -> L10
        String tag = parser.getName();     // Catch: Throwable -> L8 Exception -> L10
        if (depth != 1) goto L24;
        if (TAG_ROOT.equals(tag) == false) goto L24;
        ret = loadFromXml(parser, shortcutUser, ownerUserId, fromBackup);     // Catch: Throwable -> L8 Exception -> L10
    L24:
        ShortcutService.throwForInvalidTag(depth, tag);     // Catch: Throwable -> L8 Exception -> L10
        goto L14
    L26:
        file.close();
        return ret;
    L10:
        e = move-exception;
        Slog.e(TAG, "Failed to read file " + file.getBaseFile(), e);     // Catch: Throwable -> L8
        file.failRead(null, e);     // Catch: Throwable -> L8
        ShortcutLauncher r0 = loadFromFile(path, shortcutUser, ownerUserId, fromBackup);     // Catch: Throwable -> L8
        file.close();
        return r0;
    L8:
        th = move-exception;
        if (file != null) goto L40;
    L37:
        throw th;
    L40:
        file.close();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        th.addSuppressed(th);
        goto L37
    }

    public static ShortcutLauncher loadFromXml(TypedXmlPullParser parser, ShortcutUser shortcutUser, int ownerUserId, boolean fromBackup) throws IOException, XmlPullParserException {
        ownerUserId = ownerUserId;
        String launcherPackageName = ShortcutService.parseStringAttribute(parser, ATTR_PACKAGE_NAME);
        if (fromBackup == false) goto L5;
        int r0 = ownerUserId;
    L6:
        int launcherUserId = r0;
        ShortcutLauncher ret = new ShortcutLauncher(shortcutUser, ownerUserId, launcherPackageName, launcherUserId);
        ArraySet<String> ids = null;
        int outerDepth = parser.getDepth();
    L7:
        int type = parser.next();
        byte r11 = 1;
        if (type == 1) goto L59;
        if (type != 3) goto L14;
        if (parser.getDepth() <= outerDepth) goto L59;
    L14:
        if (type != 2) goto L7;
        int depth = parser.getDepth();
        String tag = parser.getName();
        byte r14 = 0;
        if (depth != (outerDepth + 1)) goto L44;
        switch(tag.hashCode()) {
            case -1923478059: goto L25;
            case -807062458: goto L22;
            default: goto L27;
        };
    L27:
        r11 = -1;
    L28:
        switch(r11) {
            case 0: goto L42;
            case 1: goto L30;
            default: goto L44;
        };
    L42:
        ret.getPackageInfo().loadFromXml(parser, fromBackup);
        goto L7
    L30:
        String packageName = ShortcutService.parseStringAttribute(parser, ATTR_PACKAGE_NAME);
        if (fromBackup == false) goto L33;
        int packageUserId = ownerUserId;
    L34:
        ArraySet<String> ids2 = new ArraySet();
        Object r15 = ret.mPackageItemLock;
        monitor-enter(r15);
        ret.mPinnedShortcuts.put(UserPackage.of(packageUserId, packageName), ids2);     // Catch: Throwable -> L39
        monitor-exit(r15);     // Catch: Throwable -> L39
        ids = ids2;
    L39:
        th = move-exception;
        throw th;
    L33:
        packageUserId = ShortcutService.parseIntAttribute(parser, ATTR_PACKAGE_USER_ID, ownerUserId);
        goto L34
    L22:
        if (tag.equals("package") == true) goto L28;
        r11 = -1;
        goto L28
    L25:
        if (tag.equals("package-info") == false) goto L73;
        r11 = 0;
        goto L28
    L73:
        r11 = -1;
    L44:
        if (depth == (outerDepth + 2)) goto L46;
    L57:
        ShortcutService.warnForInvalidTag(depth, tag);
        goto L7
    L46:
        switch(tag.hashCode()) {
            case 110997: goto L49;
            default: goto L51;
        };
    L51:
        r14 = -1;
    L52:
        switch(r14) {
            case 0: goto L54;
            default: goto L57;
        };
    L54:
        if (ids != null) goto L56;
        Slog.w(TAG, "pin in invalid place");
        goto L7
    L56:
        ids.add(ShortcutService.parseStringAttribute(parser, ATTR_VALUE));
        goto L7
    L49:
        if (tag.equals(TAG_PIN) == false) goto L51;
    L59:
        return ret;
    L5:
        r0 = ShortcutService.parseIntAttribute(parser, ATTR_LAUNCHER_USER_ID, ownerUserId);
        goto L6
    }

    public void dump(PrintWriter pw, String prefix, ShortcutService.DumpFilter filter) {
        pw.println();
        pw.print(prefix);
        pw.print("Launcher: ");
        pw.print(getPackageName());
        pw.print("  Package user: ");
        pw.print(getPackageUserId());
        pw.print("  Owner user: ");
        pw.print(getOwnerUserId());
        pw.println();
        getPackageInfo().dump(pw, prefix + "  ");
        pw.println();
        Object r0 = this.mPackageItemLock;
        monitor-enter(r0);
        ArrayMap<UserPackage, ArraySet<String>> pinnedShortcuts = new ArrayMap(this.mPinnedShortcuts);     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        int size = pinnedShortcuts.size();
        int i = 0;
    L7:
        if (i >= size) goto L13;
        pw.println();
        UserPackage up = pinnedShortcuts.keyAt(i);
        pw.print(prefix);
        pw.print("  ");
        pw.print("Package: ");
        pw.print(up.packageName);
        pw.print("  User: ");
        pw.println(up.userId);
        ArraySet<String> ids = pinnedShortcuts.valueAt(i);
        int idSize = ids.size();
        int j = 0;
    L9:
        if (j >= idSize) goto L11;
        pw.print(prefix);
        pw.print("    Pinned: ");
        pw.print(ids.valueAt(j));
        pw.println();
        j = j + 1;
        goto L9
    L11:
        i = i + 1;
        goto L7
    L13:
        return;
    L14:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    public JSONObject dumpCheckin(boolean clear) throws JSONException {
        JSONObject result = super.dumpCheckin(clear);
        return result;
    }

    @Override // com.android.server.pm.ShortcutPackageItem
    protected File getShortcutPackageItemFile() {
        File path = new File(this.mShortcutUser.mService.injectUserDataPath(this.mShortcutUser.getUserId()), "launchers");
        String fileName = getPackageName() + getPackageUserId() + ".xml";
        return new File(path, fileName);
    }
}
