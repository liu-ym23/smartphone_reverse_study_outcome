package com.obric.agent.trace;

/* JADX INFO: compiled from: IntentMetricsServiceImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class IntentMetricsServiceImpl implements IIntentMetricsService {
    public IntentMetricsServiceImpl() {
    }

    @Override // com.obric.agent.trace.IIntentMetricsService
    public void record(k r1) {
        d.h.b.o.e(r1, "event");
        m.f15526a.a(r1);
    }
}
