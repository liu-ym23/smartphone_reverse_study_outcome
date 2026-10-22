package com.bytedance.amap.model;

import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polygon;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolygon;
import com.bytedance.map.api.monitor.MapMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class AliPolygon implements IPolygon {
    private static final String TAG = "AliPolygon";
    private String mId;
    private Polygon mPolygon;

    @Override // com.bytedance.map.api.model.IPolygon
    public boolean isClickable() {
        return false;
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void setClickable(boolean r100) {
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public List<BDLatLng> getPoints() {
        ArrayList r100 = new ArrayList();
        Iterator<LatLng> r101 = this.mPolygon.getPoints().iterator();     // Catch: Exception -> L8
    L5:
        if (r101.hasNext() == false) goto L10;
        LatLng r102 = r101.next();     // Catch: Exception -> L8
        r100.add(new BDLatLng(r102.latitude, r102.longitude));     // Catch: Exception -> L8
    L10:
        return r100;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getPoints error:" + e.getMessage());
        goto L10
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void remove() {
        this.mPolygon.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public String getId() {
        return this.mId;
    }

    public Polygon getPolygon() {
        return this.mPolygon;
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void setFillColor(int r100) {
        this.mPolygon.setFillColor(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setFillColor error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void setLineWidth(float r100) {
        this.mPolygon.setStrokeWidth(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setLineWidth error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void setStrokeColor(int r100) {
        this.mPolygon.setStrokeColor(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setStrokeColor error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolygon
    public void updatePoints(List<BDLatLng> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.size() == 0) goto L19;
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L12
        Iterator<BDLatLng> r102 = r100.iterator();     // Catch: Exception -> L12
    L8:
        if (r102.hasNext() == false) goto L10;
        BDLatLng r103 = r102.next();     // Catch: Exception -> L12
        r101.add(new LatLng(r103.getLatitude(), r103.getLongitude()));     // Catch: Exception -> L12
        goto L8
    L10:
        this.mPolygon.setPoints(r101);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updatePoints error:" + e.getMessage());
        return;
    }

    public AliPolygon(Polygon r100, String r101) {
        this.mPolygon = r100;
        this.mId = r101;
    }
}
