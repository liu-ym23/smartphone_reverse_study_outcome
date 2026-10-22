package com.android.server.firewall;

import android.app.AppGlobals;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.IPackageManager;
import android.os.RemoteException;
import android.os.UserHandle;

/* JADX INFO: loaded from: classes2.dex */
public class SenderPackageFilter implements Filter {
    private static final String ATTR_NAME = "name";
    public static final FilterFactory FACTORY = null;
    public final String mPackageName;

    public SenderPackageFilter(String packageName) {
        this.mPackageName = packageName;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        IPackageManager pm = AppGlobals.getPackageManager();
        int packageUid = -1;
        packageUid = pm.getPackageUid(this.mPackageName, 4194304, 0);     // Catch: RemoteException -> L5
    L7:
        if (packageUid != (-1)) goto L10;
        return false;
    L10:
        return UserHandle.isSameApp(packageUid, callerUid);
    }

    static {
        final String r1 = "sender-package";
        FACTORY = new AnonymousClass1(r1);
    }
}
