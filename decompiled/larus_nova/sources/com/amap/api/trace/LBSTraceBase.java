package com.amap.api.trace;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface LBSTraceBase {
    void destroy();

    void queryProcessedTrace(int r100, List<TraceLocation> r101, int r102, TraceListener r103);

    void setLocationInterval(long r100);

    void setTraceStatusInterval(int r100);

    void startTrace(TraceStatusListener r100);

    void stopTrace();
}
