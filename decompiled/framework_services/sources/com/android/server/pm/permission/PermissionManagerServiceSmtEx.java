package com.android.server.pm.permission;

import android.app.ActivityManagerInternal;
import android.app.SmtOpsManager;
import android.content.Context;
import android.os.Handler;
import android.os.UserHandle;
import bytedanceos.api.PackageManagerSmt;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.AndroidPackage;

/* JADX INFO: loaded from: classes2.dex */
public class PermissionManagerServiceSmtEx {
    private PermissionManagerService mService;

    public PermissionManagerServiceSmtEx(PermissionManagerService service) {
        this.mService = service;
    }

    protected boolean checkPermissionDisabled() {
        return true ^ ((ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class)).getSmtOpsService().getEnabled();
    L6:
        e = move-exception;
        e.printStackTrace();
        return true;
    }

    protected boolean shouldGrantGooglePermissions(AndroidPackage pkg, String pkgName) {
        if (pkg == null) goto L8;
        if (pkgName != null) goto L5;
        return false;
    L5:
        if (pkg.getPackageName().equals(pkgName) == true) goto L7;
        return false;
    L7:
        return PackageManagerSmt.isGMSApp(pkgName, pkg.getSigningDetails().getSignatures());
    L8:
        return false;
    }

    public boolean shouldGrantGoogleGmsPermissions(AndroidPackage pkg, String pkgName) {
        String[] defaultGrantGMSAppList = {"com.google.android.gms", "com.android.vending", "com.google.android.syncadapters.contacts", "com.google.android.syncadapters.calendar"};
        int r1 = defaultGrantGMSAppList.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String name = defaultGrantGMSAppList[r3];
        if (name.equals(pkgName) == true) goto L7;
        r3 = r3 + 1;
        goto L3
    L7:
        return shouldGrantGooglePermissions(pkg, pkgName);
    L9:
        return false;
    }

    protected void setOpsMode(final Context r8, Handler r9, String r10, final String r11, int r12, int r13, boolean r14) {
        final int r4 = UserHandle.getUid(r12, r13);
        final int r6 = !r14 ? 1 : 0;
        final int r2 = SmtOpsManager.runtimePermissionToOp(r10);
        r9.post(new AnonymousClass1(this, r2, r8, r4, r11, r6));
    }
}
