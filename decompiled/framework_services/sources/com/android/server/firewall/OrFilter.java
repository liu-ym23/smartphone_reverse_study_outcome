package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
class OrFilter extends FilterList {
    public static final FilterFactory FACTORY = null;

    OrFilter() {
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        int i = 0;
    L4:
        if (i >= this.children.size()) goto L10;
        if (this.children.get(i).matches(ifw, resolvedComponent, intent, callerUid, callerPid, resolvedType, receivingUid) == true) goto L7;
        i = i + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    static {
        final String r1 = "or";
        FACTORY = new AnonymousClass1(r1);
    }
}
