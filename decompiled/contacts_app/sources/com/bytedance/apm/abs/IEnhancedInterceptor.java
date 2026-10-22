package com.bytedance.apm.abs;

import com.bytedance.apm6.commonevent.model.CommonEvent;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.monitor.MonitorableInterceptor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class IEnhancedInterceptor implements MonitorableInterceptor {
    public abstract boolean shouldIntercept(String r1, String r2, Monitorable r3);

    public IEnhancedInterceptor() {
    }

    @Override // com.bytedance.apm6.monitor.MonitorableInterceptor
    public boolean shouldIntercept(Monitorable r3) {
        String r0 = r3.getLogType();
        if ((r3 instanceof CommonEvent) == false) goto L5;
        String r1 = ((CommonEvent) r3).getServiceName();
    L7:
        return shouldIntercept(r0, r1, r3);
    L5:
        r1 = null;
        goto L7
    }
}
