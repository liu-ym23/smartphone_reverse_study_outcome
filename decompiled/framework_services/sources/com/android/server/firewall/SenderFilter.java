package com.android.server.firewall;

import android.content.pm.PackageManagerInternal;
import android.os.Process;

/* JADX INFO: loaded from: classes2.dex */
class SenderFilter {
    private static final String ATTR_TYPE = "type";
    public static final FilterFactory FACTORY = null;
    private static final Filter SIGNATURE = null;
    private static final Filter SYSTEM = null;
    private static final Filter SYSTEM_OR_SIGNATURE = null;
    private static final Filter USER_ID = null;
    private static final String VAL_SIGNATURE = "signature";
    private static final String VAL_SYSTEM = "system";
    private static final String VAL_SYSTEM_OR_SIGNATURE = "system|signature";
    private static final String VAL_USER_ID = "userId";

    /* JADX INFO: renamed from: -$$Nest$sfgetSIGNATURE, reason: not valid java name */
    static /* bridge */ /* synthetic */ Filter m4230$$Nest$sfgetSIGNATURE() {
        return SIGNATURE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSYSTEM, reason: not valid java name */
    static /* bridge */ /* synthetic */ Filter m4231$$Nest$sfgetSYSTEM() {
        return SYSTEM;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetSYSTEM_OR_SIGNATURE, reason: not valid java name */
    static /* bridge */ /* synthetic */ Filter m4232$$Nest$sfgetSYSTEM_OR_SIGNATURE() {
        return SYSTEM_OR_SIGNATURE;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetUSER_ID, reason: not valid java name */
    static /* bridge */ /* synthetic */ Filter m4233$$Nest$sfgetUSER_ID() {
        return USER_ID;
    }

    SenderFilter() {
    }

    static boolean isPrivilegedApp(PackageManagerInternal pmi, int callerUid, int callerPid) {
        if (callerUid == 1000) goto L11;
        if (callerUid != 0) goto L6;
        return true;
    L6:
        if (callerPid == Process.myPid()) goto L14;
        if (callerPid != 0) goto L10;
        return true;
    L10:
        return pmi.isUidPrivileged(callerUid);
    L14:
        return true;
    L11:
        return true;
    }

    static {
        final String r1 = "sender";
        FACTORY = new AnonymousClass1(r1);
        SIGNATURE = new AnonymousClass2();
        SYSTEM = new AnonymousClass3();
        SYSTEM_OR_SIGNATURE = new AnonymousClass4();
        USER_ID = new AnonymousClass5();
    }
}
