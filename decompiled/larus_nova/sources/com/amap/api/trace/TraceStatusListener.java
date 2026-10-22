package com.amap.api.trace;

import com.amap.api.maps.model.LatLng;
import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public interface TraceStatusListener {
    void onTraceStatus(List<TraceLocation> r100, List<LatLng> r101, String r102);
}
