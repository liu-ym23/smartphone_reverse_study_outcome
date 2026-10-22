package com.android.server.firewall;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes2.dex */
class ExtraKeyValueFilter implements Filter {
    private static final String ATTR_NAME = "name";
    public static final FilterFactory FACTORY = null;
    private final String mKeyFilter;
    private final StringFilter mValueFilter;

    /* synthetic */ ExtraKeyValueFilter(String r1, StringFilter r2, ExtraKeyValueFilterIA r3) {
        this(r1, r2);
    }

    private ExtraKeyValueFilter(String keyFilter, StringFilter valueFilter) {
        this.mKeyFilter = keyFilter;
        this.mValueFilter = valueFilter;
    }

    @Override // com.android.server.firewall.Filter
    public boolean matches(IntentFirewall ifw, ComponentName resolvedComponent, Intent intent, int callerUid, int callerPid, String resolvedType, int receivingUid) {
        Bundle extras = intent.getExtras();
        if (extras != null) goto L7;
        return false;
    L7:
        return this.mValueFilter.matchesValue(extras.getString(this.mKeyFilter));
    }

    static {
        final String r1 = "extra";
        FACTORY = new AnonymousClass1(r1);
    }
}
