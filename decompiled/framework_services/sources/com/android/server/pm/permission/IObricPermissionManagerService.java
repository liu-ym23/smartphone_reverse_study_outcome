package com.android.server.pm.permission;

import com.android.server.pm.pkg.AndroidPackage;
import com.obric.utils.IObricBase;

/* JADX INFO: loaded from: classes2.dex */
public interface IObricPermissionManagerService extends IObricBase {
    default boolean checkObricAssistPermission(String permissionName, String packageName) {
        return false;
    }

    default boolean checkObricAssistPermission(AndroidPackage pkg, String permissionName) {
        return false;
    }
}
