package com.bytedance.amap.model;

import androidx.camera.video.AudioStats;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.ICircle;
import com.bytedance.map.api.monitor.MapMonitor;

/* JADX INFO: loaded from: classes43.dex */
public class AliCircle implements ICircle {
    private static final String TAG = "AliCircle";
    private Circle mCircle;
    private String mId;

    @Override // com.bytedance.map.api.model.ICircle
    public double getRadius() {
        return this.mCircle.getRadius();
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "getRadius error:" + e.getMessage());
        return AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void remove() {
        this.mCircle.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    private AliCircle() {
    }

    @Override // com.bytedance.map.api.model.ICircle
    public String getId() {
        return this.mId;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public boolean contains(BDLatLng r100) {
        return this.mCircle.contains(new LatLng(r100.getLatitude(), r100.getLongitude()));
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "contains error:" + e.getMessage());
        return false;
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void setFillColor(int r100) {
        this.mCircle.setFillColor(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setFillColor error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void setLineWidth(float r100) {
        this.mCircle.setStrokeWidth(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setLineWidth error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void setStrokeColor(int r100) {
        this.mCircle.setStrokeColor(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setStrokeColor error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void updateCenter(BDLatLng r100) {
        this.mCircle.setCenter(new LatLng(r100.getLatitude(), r100.getLongitude()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateCenter error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.ICircle
    public void updateRadius(double r100) {
        this.mCircle.setRadius(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "updateRadius error:" + e.getMessage());
    }

    public AliCircle(Circle r100, String r101) {
        this.mId = r101;
        this.mCircle = r100;
    }
}
