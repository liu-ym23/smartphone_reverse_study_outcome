package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;

/* JADX INFO: loaded from: classes2.dex */
class NotFilter implements Filter {
    public static final FilterFactory FACTORY = null;
    private final Filter mChild;

    /* synthetic */ NotFilter(Filter r1, NotFilterIA r2) {
        this(r1);
    }

    private NotFilter(Filter child) {
        this.mChild = child;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        return !this.mChild.matches(ifw, resolvedComponent, intent, callerUid, callerPid, resolvedType, receivingUid);
    }

    static {
        final String r1 = "not";
        FACTORY = new AnonymousClass1(r1);
    }
}
