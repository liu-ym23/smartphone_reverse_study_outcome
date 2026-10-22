package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
class PortFilter implements Filter {
    private static final String ATTR_EQUALS = "equals";
    private static final String ATTR_MAX = "max";
    private static final String ATTR_MIN = "min";
    public static final FilterFactory FACTORY = null;
    private static final int NO_BOUND = -1;
    private final int mLowerBound;
    private final int mUpperBound;

    /* synthetic */ PortFilter(int r1, int r2, PortFilterIA r3) {
        this(r1, r2);
    }

    private PortFilter(int lowerBound, int upperBound) {
        this.mLowerBound = lowerBound;
        this.mUpperBound = upperBound;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        int port = -1;
        Uri uri = intent.getData();
        if (uri == null) goto L6;
        port = uri.getPort();
    L6:
        if (port != (-1)) goto L8;
    L16:
        return false;
    L8:
        if (this.mLowerBound == (-1)) goto L12;
        if (this.mLowerBound > port) goto L16;
    L12:
        if (this.mUpperBound != (-1)) goto L14;
    L15:
        return true;
    L14:
        if (this.mUpperBound < port) goto L16;
        goto L15
    }

    static {
        final String r1 = "port";
        FACTORY = new AnonymousClass1(r1);
    }
}
