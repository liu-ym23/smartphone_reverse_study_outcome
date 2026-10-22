package com.android.server.pm.permission;

import android.pico.utils.IExtBase;
import com.android.server.pm.pkg.AndroidPackage;

/* JADX INFO: loaded from: classes2.dex */
public interface IExtPermissionManagerService extends IExtBase {
    boolean checkDefaultPKGPermissionGrant(String r1, String r2, int r3);

    void initPermissionWhiteList();

    default boolean checkUidPermission(String permissionName, AndroidPackage aPackage) {
        return false;
    }
}
