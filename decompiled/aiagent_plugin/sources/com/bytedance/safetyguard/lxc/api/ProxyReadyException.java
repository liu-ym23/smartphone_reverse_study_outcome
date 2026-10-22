package com.bytedance.safetyguard.lxc.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: ProxySessionReady.kt */
/* JADX INFO: loaded from: classes.dex */
public class ProxyReadyException extends Exception {
    private final ProxySessionErrorCode errorCode;
    private final String sessionId;

    public ProxyReadyException(String r9, ProxySessionErrorCode r10, String r11) {
        o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r10, "errorCode");
        o.e(r11, "message");
        this(r9, r10, r11, null, 8, null);
    }

    public /* synthetic */ ProxyReadyException(String r1, ProxySessionErrorCode r2, String r3, Throwable r4, int r5, h r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final ProxySessionErrorCode getErrorCode() {
        return this.errorCode;
    }

    public ProxyReadyException(String r2, ProxySessionErrorCode r3, String r4, Throwable r5) {
        o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
        o.e(r3, "errorCode");
        o.e(r4, "message");
        super(r4, r5);
        this.sessionId = r2;
        this.errorCode = r3;
    }
}
