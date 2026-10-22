package com.bytedance.safetyguard.lxc.internal.client;

import com.bytedance.safetyguard.lxc.api.ProxySessionCloseReason;
import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.bytedance.safetyguard.lxc.api.ProxySessionResult;

/* JADX INFO: compiled from: ProxyServiceConnector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    private static final String TAG = "ProxyServiceConnector";

    public static final /* synthetic */ ProxySessionResult a(String r0, ProxySessionErrorCode r1, String r2) {
        return b(r0, r1, r2);
    }

    public static final /* synthetic */ String a(int r0) {
        return b(r0);
    }

    private static final String b(int r0) {
        switch(r0) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            case 8: goto L5;
            case 9: goto L3;
            case 10: goto L4;
            default: goto L3;
        };
    L3:
        return "SERVICE_UNAVAILABLE";
    L4:
        return "SERVICE_PROTOCOL_MISMATCH";
    L5:
        return "ACTION_OWNER_MISMATCH";
    L6:
        return "TOKEN_MISMATCH";
    L7:
        return "NO_ACTIVE_ACTION";
    L8:
        return "ACTION_ALREADY_ACTIVE";
    L9:
        return "ATTACHMENT_NOT_FOUND";
    L10:
        return "SESSION_CLOSED";
    L11:
        return "SESSION_NOT_READY";
    L12:
        return "INVALID_PAYLOAD";
    }

    private static final ProxySessionResult b(String r14, ProxySessionErrorCode r15, String r16) {
        return new ProxySessionResult(r14, ProxySessionCloseReason.INTERNAL_ERROR, r15, r16, 0, 0, 0, 0, 240, null);
    }
}
