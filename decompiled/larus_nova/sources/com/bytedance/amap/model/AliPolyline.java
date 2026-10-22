package com.bytedance.amap.model;

import android.graphics.Bitmap;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Polyline;
import com.bytedance.map.api.logger.MapLogger;
import com.bytedance.map.api.model.BDLatLng;
import com.bytedance.map.api.model.IPolyline;
import com.bytedance.map.api.monitor.MapMonitor;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public class AliPolyline implements IPolyline {
    private static final String TAG = "AliPolyline";
    private String mId;
    private Polyline mPolyline;

    @Override // com.bytedance.map.api.model.IPolyline
    public boolean isCollideWithPoi() {
        return false;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setCollideWithPoi(boolean r100) {
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void remove() {
        this.mPolyline.remove();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "remove error:" + e.getMessage());
    }

    private AliPolyline() {
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public String getId() {
        return this.mId;
    }

    public Polyline getPolyline() {
        return this.mPolyline;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setAlpha(float r100) {
        this.mPolyline.setTransparency(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setAlpha error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setColor(int r100) {
        this.mPolyline.setColor(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setColor error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setColorList(List<Integer> r100) {
    L29:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setColorList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L28;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == false) goto L9;
        return;
    L9:
        if (r100.size() != 1) goto L15;
        if (ListProtector.get(r100, 0) == null) goto L15;
        setColor(((Integer) ListProtector.get(r100, 0)).intValue());     // Catch: Exception -> L29
        return;
    L15:
        if (this.mPolyline.getOptions() != null) goto L17;
        return;
    L17:
        if (r100.isEmpty() == true) goto L39;
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L29
        Iterator<Integer> r102 = r100.iterator();     // Catch: Exception -> L29
    L20:
        if (r102.hasNext() == false) goto L26;
        Integer r103 = r102.next();     // Catch: Exception -> L29
        if (r103 == null) goto L24;
        int r104 = r103.intValue();     // Catch: Exception -> L29
    L25:
        r101.add(Integer.valueOf(r104));     // Catch: Exception -> L29
        goto L20
    L24:
        r104 = 0;
        goto L25
    L26:
        this.mPolyline.setOptions(this.mPolyline.getOptions().colorValues(r101));     // Catch: Exception -> L29
        return;
    L39:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setCustomTexture(Bitmap r100) {
        this.mPolyline.setCustomTexture(BitmapDescriptorFactory.fromBitmap(r100));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setCustomTexture error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setCustomTextureList(List<Bitmap> r100) {
    L19:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setCustomTextureList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L33;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L35;
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L19
        Iterator<Bitmap> r102 = r100.iterator();     // Catch: Exception -> L19
    L9:
        if (r102.hasNext() == false) goto L17;
        Bitmap r103 = r102.next();     // Catch: Exception -> L19
        if (r103 == null) goto L9;
        BitmapDescriptor r104 = BitmapDescriptorFactory.fromBitmap(r103);     // Catch: Exception -> L19
        if (r104 == null) goto L9;
        r101.add(r104);     // Catch: Exception -> L19
        goto L9
    L17:
        this.mPolyline.setCustomTextureList(r101);     // Catch: Exception -> L19
        return;
    L35:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setDottedLine(boolean r100) {
        this.mPolyline.setDottedLine(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setDottedLine error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setPoints(List<BDLatLng> r100) {
        ArrayList r101 = new ArrayList();     // Catch: Exception -> L8
        Iterator<BDLatLng> r102 = r100.iterator();     // Catch: Exception -> L8
    L4:
        if (r102.hasNext() == false) goto L6;
        BDLatLng r103 = r102.next();     // Catch: Exception -> L8
        r101.add(new LatLng(r103.getLatitude(), r103.getLongitude()));     // Catch: Exception -> L8
        goto L4
    L6:
        this.mPolyline.setPoints(r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setPoints error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setTextureIndexList(List<Integer> r100) {
    L9:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setTextureIndexList error:" + e.getMessage());
        return;
    L3:
        if (this.mPolyline == null) goto L14;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.isEmpty() == true) goto L16;
        this.mPolyline.setCustomTextureIndex(r100);     // Catch: Exception -> L9
        return;
    L16:
        return;
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setWidth(float r100) {
        this.mPolyline.setWidth(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setWidth error:" + e.getMessage());
    }

    @Override // com.bytedance.map.api.model.IPolyline
    public void setZIndex(float r100) {
        this.mPolyline.setZIndex(r100);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        MapMonitor.amapExceptionMonitor(e);
        MapLogger.i(TAG, "setZIndex error:" + e.getMessage());
    }

    public AliPolyline(Polyline r100, String r101) {
        this.mPolyline = r100;
        this.mId = r101;
    }
}
