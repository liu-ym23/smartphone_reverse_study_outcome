package com.android.server.pm.permission;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.PermissionInfo;
import android.os.ServiceManager;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import com.android.internal.util.ArrayUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultPermissionGrantPolicySmtEx {
    private static final String TAG = "DefaultPermGrantPolicy";
    private ArrayMap<String, Set<String>> mDefaultGrantSysAppPermissions;
    private DefaultPermissionGrantPolicy mPolicy;

    public DefaultPermissionGrantPolicySmtEx(DefaultPermissionGrantPolicy policy) {
        this.mPolicy = policy;
    }

    protected void grantSmtDefaultPermissions(PackageManagerInternal serviceInternal, Context context, DefaultPermissionGrantPolicy.PackageManagerWrapper pm, int userId) {
    }

    protected void grantDefaultPermissionsToGoogleGms(PackageManagerInternal serviceInternal, Context context, DefaultPermissionGrantPolicy.PackageManagerWrapper pm, int userId) {
        Log.i(TAG, "Granting default permissions to google gms for user " + userId);
        int r2 = 0;
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackagesAsUser(536915968, 0);
        Iterator<PackageInfo> r1 = packages.iterator();
    L4:
        if (r1.hasNext() == false) goto L28;
        PackageInfo pkg = r1.next();
        if (pkg == null) goto L4;
        if (DefaultPermissionGrantPolicy.doesPackageSupportRuntimePermissions(pkg) == false) goto L4;
        if (ArrayUtils.isEmpty(pkg.requestedPermissions) == true) goto L4;
        PermissionManagerService permissionService = (PermissionManagerService) ServiceManager.getService("permissionmgr");
        if (permissionService.getSmtEx().shouldGrantGoogleGmsPermissions(serviceInternal.getPackage(pkg.packageName), pkg.packageName) == false) goto L4;
        Set<String> permissions = new ArraySet();
        String[] r3 = pkg.requestedPermissions;
        int r4 = r3.length;
    L16:
        if (r2 >= r4) goto L24;
        String permission = r3[r2];
        PermissionInfo perm = pm.getPermissionInfo(permission);
        if (perm == null) goto L23;
        if (perm.isRuntime() == false) goto L23;
        permissions.add(permission);
    L23:
        r2 = r2 + 1;
        goto L16
    L24:
        this.mPolicy.grantRuntimePermissions(pm, pkg, permissions, false, userId);
        return;
    }
}
