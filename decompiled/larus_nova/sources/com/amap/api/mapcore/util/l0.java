package com.amap.api.mapcore.util;

import android.graphics.Point;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX INFO: loaded from: classes28.dex */
public class l0 extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage r100) {
    }

    public l0() {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState r100) {
        float r101 = this.xPixel;
        float r102 = this.yPixel;
        float r103 = (this.width / 2.0f) + r101;
        float r104 = (this.height / 2.0f) + r102;
        Point r105 = new Point();
        r100.screenToP20Point((int) r103, (int) r104, r105);
        r100.setMapGeoCenter(r105.x, r105.y);
    }
}
