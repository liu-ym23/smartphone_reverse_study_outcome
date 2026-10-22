package com.obric.aiagent.trace;

import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: ITraceReport.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ITraceReport {
    String getFlowDid();

    void init();

    void whenFlowDidReady(b<? super String, x> r1);
}
