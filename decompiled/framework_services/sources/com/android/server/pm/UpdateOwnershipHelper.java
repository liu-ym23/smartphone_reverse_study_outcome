package com.android.server.pm;

import android.app.ResourcesManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Slog;
import com.android.internal.pm.parsing.pkg.AndroidPackageInternal;
import com.android.internal.pm.pkg.component.ParsedUsesPermission;
import com.android.server.pm.parsing.pkg.AndroidPackageUtils;
import com.android.server.pm.pkg.AndroidPackage;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateOwnershipHelper {
    private static final int MAX_DENYLIST_SIZE = 500;
    private static final String TAG_OWNERSHIP_OPT_OUT = "deny-ownership";
    private final Object mLock;
    private final ArrayMap<String, ArraySet<String>> mUpdateOwnerOptOutsToOwners;

    public UpdateOwnershipHelper() {
        this.mUpdateOwnerOptOutsToOwners = new ArrayMap(200);
        this.mLock = new Object();
    }

    static boolean hasValidOwnershipDenyList(PackageSetting pkgSetting) {
        AndroidPackageInternal r0 = pkgSetting.getPkg();
        if (r0 != null) goto L5;
    L13:
        return false;
    L5:
        if (pkgSetting.isSystem() == true) goto L9;
        if (pkgSetting.isUpdatedSystemApp() == false) goto L13;
    L9:
        if (r0.getProperties().containsKey("android.app.PROPERTY_LEGACY_UPDATE_OWNERSHIP_DENYLIST") == false) goto L13;
        if (usesAnyPermission(r0, new String[]{"android.permission.INSTALL_PACKAGES", "android.permission.INSTALL_PACKAGE_UPDATES"}) == false) goto L13;
        return true;
    }

    private static boolean usesAnyPermission(AndroidPackage pkgSetting, String... permissions) {
        List<ParsedUsesPermission> usesPermissions = pkgSetting.getUsesPermissions();
        int i = 0;
    L4:
        if (i >= usesPermissions.size()) goto L14;
        int j = 0;
    L7:
        if (j >= permissions.length) goto L13;
        if (permissions[j].equals(usesPermissions.get(i).getName()) == true) goto L10;
        j = j + 1;
        goto L7
    L10:
        return true;
    L13:
        i = i + 1;
        goto L4
    L14:
        return false;
    }

    public ArraySet<String> readUpdateOwnerDenyList(PackageSetting pkgSetting) {
        if (hasValidOwnershipDenyList(pkgSetting) == true) goto L5;
        return null;
    L5:
        AndroidPackageInternal r3 = pkgSetting.getPkg();
        if (r3 != null) goto L8;
        return null;
    L8:
        ArraySet<String> ownershipDenyList = new ArraySet(500);
        int resId = ((PackageManager.Property) r3.getProperties().get("android.app.PROPERTY_LEGACY_UPDATE_OWNERSHIP_DENYLIST")).getResourceId();     // Catch: Exception -> L30
        ApplicationInfo appInfo = AndroidPackageUtils.generateAppInfoWithoutState(r3);     // Catch: Exception -> L30
        Resources resources = ResourcesManager.getInstance().getResources(null, appInfo.sourceDir, appInfo.splitSourceDirs, appInfo.resourceDirs, appInfo.overlayPaths, appInfo.sharedLibraryFiles, null, Configuration.EMPTY, null, null, null);     // Catch: Exception -> L30
        XmlResourceParser parser = resources.getXml(resId);     // Catch: Exception -> L30
    L42:
    L25:
        th = move-exception;
        if (parser == null) goto L58;
        parser.close();     // Catch: Throwable -> L35
    L59:
        throw th;     // Catch: Exception -> L30
    L35:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L30
        throw th;     // Catch: Exception -> L30
    L58:
        throw th;     // Catch: Exception -> L30
    L12:
        if (parser.getEventType() == 1) goto L28;
        if (parser.next() != 2) goto L42;
        if (TAG_OWNERSHIP_OPT_OUT.equals(parser.getName()) == false) goto L42;
        parser.next();     // Catch: Throwable -> L25
        String packageName = parser.getText();     // Catch: Throwable -> L25
        if (packageName == null) goto L42;
        if (packageName.isBlank() == true) goto L42;
        ownershipDenyList.add(packageName);     // Catch: Throwable -> L25
        if (ownershipDenyList.size() <= 500) goto L42;
        Slog.w(PackageManagerServiceMonitorEx.TAG, "Deny list defined by " + r3.getPackageName() + " was trucated to maximum size of 500");     // Catch: Throwable -> L25
    L28:
        parser.close();     // Catch: Exception -> L30
        return ownershipDenyList;
    L30:
        e = move-exception;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to parse update owner list for " + pkgSetting.getPackageName(), e);
        return null;
    }

    public void addToUpdateOwnerDenyList(String listOwner, ArraySet<String> listContents) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = 0;
    L18:
    L10:
        th = move-exception;
        throw th;
    L6:
        if (i >= listContents.size()) goto L14;
        String packageName = listContents.valueAt(i);     // Catch: Throwable -> L10
        ArraySet<String> priorDenyListOwners = this.mUpdateOwnerOptOutsToOwners.putIfAbsent(packageName, new ArraySet(new String[]{listOwner}));     // Catch: Throwable -> L10
        if (priorDenyListOwners == null) goto L12;
        priorDenyListOwners.add(listOwner);     // Catch: Throwable -> L10
    L12:
        i = i + 1;     // Catch: Throwable -> L10
        goto L18
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    public void removeUpdateOwnerDenyList(String listOwner) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int i = this.mUpdateOwnerOptOutsToOwners.size() - 1;     // Catch: Throwable -> L11
    L5:
        if (i < 0) goto L15;
        ArraySet<String> packageDenyListContributors = this.mUpdateOwnerOptOutsToOwners.get(this.mUpdateOwnerOptOutsToOwners.keyAt(i));     // Catch: Throwable -> L11
        if (packageDenyListContributors.remove(listOwner) == false) goto L13;
        if (packageDenyListContributors.isEmpty() == false) goto L13;
        this.mUpdateOwnerOptOutsToOwners.removeAt(i);     // Catch: Throwable -> L11
    L13:
        i = i - 1;     // Catch: Throwable -> L11
        goto L5
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public boolean isUpdateOwnershipDenylisted(String packageName) {
        return this.mUpdateOwnerOptOutsToOwners.containsKey(packageName);
    }

    public boolean isUpdateOwnershipDenyListProvider(String packageName) {
        if (packageName != null) goto L5;
        return false;
    L5:
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = this.mUpdateOwnerOptOutsToOwners.size() - 1;     // Catch: Throwable -> L13
    L8:
        if (i < 0) goto L17;
        if (this.mUpdateOwnerOptOutsToOwners.valueAt(i).contains(packageName) == true) goto L11;
        i = i - 1;     // Catch: Throwable -> L13
        goto L8
    L11:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return true;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return false;
    L13:
        th = move-exception;
        throw th;
    }
}
