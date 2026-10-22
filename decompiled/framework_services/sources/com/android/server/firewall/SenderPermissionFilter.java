package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
class SenderPermissionFilter implements Filter {
    private static final String ATTR_NAME = "name";
    public static final FilterFactory FACTORY = null;
    private final String mPermission;

    /* synthetic */ SenderPermissionFilter(String r1, SenderPermissionFilterIA r2) {
        this(r1);
    }

    private SenderPermissionFilter(String permission) {
        this.mPermission = permission;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        return ifw.checkComponentPermission(this.mPermission, callerPid, callerUid, receivingUid, true);
    }

    static {
        final String r1 = "sender-permission";
        FACTORY = new AnonymousClass1(r1);
    }
}
