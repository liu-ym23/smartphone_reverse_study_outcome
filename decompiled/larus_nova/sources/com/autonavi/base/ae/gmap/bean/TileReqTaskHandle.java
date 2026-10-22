package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;

/* JADX INFO: loaded from: classes39.dex */
public class TileReqTaskHandle {
    long nativeObj;
    int status;
    Tile tile;

    public TileReqTaskHandle() {
    }

    public void finish(Tile r100) {
        this.tile = r100;
    }
}
