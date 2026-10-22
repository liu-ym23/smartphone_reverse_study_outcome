package com.amap.api.mapcore.util;

import android.util.Pair;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;

/* JADX INFO: loaded from: classes28.dex */
public class j0 extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage r100) {
    }

    public j0() {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState r110) {
        IMapConfig r100 = this.mapConfig;
        int r101 = w3.f28280b;
        LatLngBounds r102 = this.bounds;
        int r103 = this.width;
        int r104 = this.height;
        Pair<Float, LatLng> r105 = w3.a(r100, r110, Math.max(this.paddingLeft, 1), Math.max(this.paddingRight, 1), Math.max(this.paddingTop, 1), Math.max(this.paddingBottom, 1), r102, r103, r104);
        if (r105 != null) goto L5;
        return;
    L5:
        r110.setMapZoomer(((Float) r105.first).floatValue());
        LatLng r106 = (LatLng) r105.second;
        r110.setMapCenterByLonLat(r106.longitude, r106.latitude);
        r110.setCameraDegree(0.0f);
        r110.setMapAngle(0.0f);
    }
}
