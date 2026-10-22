package com.autonavi.amap.mapcore.camera;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;

/* loaded from: classes.dex */
public class AbstractCameraPositionMessage extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        DPoint dPoint = this.geoPoint;
        if (dPoint == null) {
            dPoint = abstractCameraUpdateMessage.geoPoint;
        }
        abstractCameraUpdateMessage.geoPoint = dPoint;
        abstractCameraUpdateMessage.zoom = Float.isNaN(this.zoom) ? abstractCameraUpdateMessage.zoom : this.zoom;
        abstractCameraUpdateMessage.bearing = Float.isNaN(this.bearing) ? abstractCameraUpdateMessage.bearing : this.bearing;
        abstractCameraUpdateMessage.tilt = Float.isNaN(this.tilt) ? abstractCameraUpdateMessage.tilt : this.tilt;
    }
}
