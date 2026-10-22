package com.amap.api.mapcore.util;

import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;

/* JADX INFO: loaded from: classes28.dex */
public class m0 extends AbstractCameraUpdateMessage {
    public m0() {
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage r100) {
        r100.zoom += this.amount;
    }

    @Override // com.autonavi.amap.mapcore.AbstractCameraUpdateMessage
    public void runCameraUpdate(IGLMapState r100) {
        float r101 = r100.getMapZoomer() + this.amount;
        this.zoom = r101;
        this.zoom = w3.a(this.mapConfig, r101);
        normalChange(r100);
    }
}
