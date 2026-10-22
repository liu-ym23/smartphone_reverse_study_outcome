package com.android.server.pm.permission;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.pm.DumpState;
import com.android.server.pm.PackageManagerService;
import com.android.server.pm.PackageManagerTracedLock;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class LegacyPermissionSettings {
    private final PackageManagerTracedLock mLock;
    private final ArrayMap<String, LegacyPermission> mPermissionTrees;
    private final ArrayMap<String, LegacyPermission> mPermissions;

    public LegacyPermissionSettings() {
        this.mPermissions = new ArrayMap();
        this.mPermissionTrees = new ArrayMap();
        this.mLock = new PackageManagerTracedLock();
    }

    public List<LegacyPermission> getPermissions() {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mPermissions.values());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public List<LegacyPermission> getPermissionTrees() {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        ArrayList r1 = new ArrayList(this.mPermissionTrees.values());     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return r1;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void replacePermissions(List<LegacyPermission> permissions) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPermissions.clear();     // Catch: Throwable -> L7
        int permissionsSize = permissions.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= permissionsSize) goto L10;
        LegacyPermission permission = permissions.get(i);     // Catch: Throwable -> L7
        this.mPermissions.put(permission.getPermissionInfo().name, permission);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void replacePermissionTrees(List<LegacyPermission> permissionTrees) {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        this.mPermissionTrees.clear();     // Catch: Throwable -> L7
        int permissionsSize = permissionTrees.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= permissionsSize) goto L10;
        LegacyPermission permissionTree = permissionTrees.get(i);     // Catch: Throwable -> L7
        this.mPermissionTrees.put(permissionTree.getPermissionInfo().name, permissionTree);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L7:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void readPermissions(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        readPermissions(this.mPermissions, parser);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void readPermissionTrees(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        readPermissions(this.mPermissionTrees, parser);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public static void readPermissions(ArrayMap<String, LegacyPermission> out, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L3:
        int type = parser.next();
        if (type == 1) goto L18;
        if (type == 3) goto L8;
    L10:
        if (type == 3) goto L3;
        if (type == 4) goto L3;
        if (LegacyPermission.read(out, parser) == true) goto L17;
        PackageManagerService.reportSettingsProblem(5, "Unknown element reading permissions: " + parser.getName() + " at " + parser.getPositionDescription());
    L17:
        XmlUtils.skipCurrentTag(parser);
        goto L3
    L8:
        if (parser.getDepth() > outerDepth) goto L10;
        return;
    }

    public void writePermissions(TypedXmlSerializer serializer) throws IOException {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Iterator<LegacyPermission> r1 = this.mPermissions.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        LegacyPermission bp = r1.next();     // Catch: Throwable -> L8
        bp.write(serializer);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public void writePermissionTrees(TypedXmlSerializer serializer) throws IOException {
        PackageManagerTracedLock r0 = this.mLock;
        PackageManagerService.boostPriorityForPackageManagerTracedLockedSection();
        monitor-enter(r0);
        Iterator<LegacyPermission> r1 = this.mPermissionTrees.values().iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        LegacyPermission bp = r1.next();     // Catch: Throwable -> L8
        bp.write(serializer);     // Catch: Throwable -> L8
        goto L6
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        return;
    L8:
        th = move-exception;
        PackageManagerService.resetPriorityAfterPackageManagerTracedLockedSection();
        throw th;
    }

    public static void dumpPermissions(PrintWriter pw, String packageName, ArraySet<String> permissionNames, List<LegacyPermission> permissions, Map<String, Set<String>> appOpPermissionPackages, boolean externalStorageEnforced, DumpState dumpState) {
        int permissionsSize = permissions.size();
        boolean printedSomething = false;
        int i = 0;
    L3:
        if (i >= permissionsSize) goto L6;
        LegacyPermission permission = permissions.get(i);
        printedSomething = permission.dump(pw, packageName, permissionNames, externalStorageEnforced, printedSomething, dumpState);
        i = i + 1;
        goto L3
    L6:
        if (packageName != null) goto L22;
        if (permissionNames != null) goto L26;
        boolean firstEntry = true;
        Iterator<Map.Entry<String, Set<String>>> r2 = appOpPermissionPackages.entrySet().iterator();
    L10:
        if (r2.hasNext() == false) goto L27;
        Map.Entry<String, Set<String>> entry = r2.next();
        if (firstEntry == false) goto L17;
        firstEntry = false;
        if (dumpState.onTitlePrinted() == false) goto L16;
        pw.println();
    L16:
        pw.println("AppOp Permissions:");
    L17:
        pw.print("  AppOp Permission ");
        pw.print(entry.getKey());
        pw.println(":");
        Iterator<String> r4 = entry.getValue().iterator();
    L19:
        if (r4.hasNext() == false) goto L10;
        String appOpPackageName = r4.next();
        pw.print("    ");
        pw.println(appOpPackageName);
        goto L19
    L27:
        return;
    L26:
        return;
    }
}
