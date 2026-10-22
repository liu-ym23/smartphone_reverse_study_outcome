package com.autonavi.amap.mapcore.camera;

import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* loaded from: classes.dex */
public class AbstractCameraZoomMessage extends AbstractCameraUpdateMessage {
    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage abstractCameraUpdateMessage) {
        abstractCameraUpdateMessage.zoom += this.amount;
    }
}
