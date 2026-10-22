package com.amap.api.mapcore.util;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;

/* JADX INFO: loaded from: classes28.dex */
public class k0 extends AbstractCameraUpdateMessage {
    public k0() {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage r100) {
        DPoint r101 = this.geoPoint;
        if (r101 != null) goto L5;
        r101 = r100.geoPoint;
    L5:
        r100.geoPoint = r101;
        if (Float.isNaN(this.zoom) == false) goto L8;
        float r102 = r100.zoom;
    L9:
        r100.zoom = r102;
        if (Float.isNaN(this.bearing) == false) goto L12;
        float r103 = r100.bearing;
    L13:
        r100.bearing = r103;
        if (Float.isNaN(this.tilt) == false) goto L16;
        float r104 = r100.tilt;
    L17:
        r100.tilt = r104;
        return;
    L16:
        r104 = this.tilt;
        goto L17
    L12:
        r103 = this.bearing;
        goto L13
    L8:
        r102 = this.zoom;
        goto L9
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState r100) {
        normalChange(r100);
    }
}
