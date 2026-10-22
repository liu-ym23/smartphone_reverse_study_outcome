package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

/* JADX INFO: loaded from: classes39.dex */
public interface TileSourceProvider extends TileProvider {
    void cancel(TileSourceReq r100);

    Tile getTile(TileSourceReq r100);
}
