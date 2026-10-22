package com.bytedance.safetyguard.lxc.api;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import d.h.b.o;

/* JADX INFO: compiled from: ProxySessionReady.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProxyReadyUnsupportedException extends ProxyReadyException {
    public ProxyReadyUnsupportedException(String r9) {
        o.e(r9, ObricMemoryConstants.KEY_SESSION_ID);
        super(r9, ProxySessionErrorCode.READY_NOT_SUPPORTED, "ProxySession implementation does not support awaitReady()", null, 8, null);
    }
}
