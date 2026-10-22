package com.bytedance.apm.impl;

import com.bytedance.apm.trace.a;
import com.bytedance.services.apm.api.ILaunchTrace;

/* JADX INFO: loaded from: classes.dex */
public class LaunchTraceImpl implements ILaunchTrace {
    public LaunchTraceImpl() {
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void cancelTrace() {
        a.a();
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endSpan(String r10, String r11) {
        a.b(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void endTrace(int r10, String r11, long r12) {
        a.c(r10, r11, r12);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startSpan(String r10, String r11) {
        a.h(r10, r11);
    }

    @Override // com.bytedance.services.apm.api.ILaunchTrace
    public void startTrace() {
        a.i();
    }
}
