package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface TraceListener {
    void onFinished(int r100, List<LatLng> r101, int r102, int r103);

    void onRequestFailed(int r100, String r101);

    void onTraceProcessing(int r100, int r101, List<LatLng> r102);
}
