package com.bytedance.amap.model;

import com.amap.api.maps.model.TileOverlay;
import com.bytedance.map.api.model.IHeatMap;

/* JADX INFO: loaded from: classes43.dex */
public class AliHeatMap implements IHeatMap {
    private static final String TAG = "AliHeatMap";
    private final String mId;
    private final TileOverlay tileOverlay;

    @Override // com.bytedance.map.api.model.IHeatMap
    public void clearTileCache() {
        TileOverlay r100 = this.tileOverlay;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.clearTileCache();
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public float getZIndex() {
        TileOverlay r100 = this.tileOverlay;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return r100.getZIndex();
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public boolean isVisible() {
        TileOverlay r100 = this.tileOverlay;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isVisible();
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public void remove() {
        TileOverlay r100 = this.tileOverlay;
        if (r100 != null) goto L5;
        return;
    L5:
        r100.remove();
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public String getId() {
        return this.mId;
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public void setVisible(boolean r100) {
        TileOverlay r101 = this.tileOverlay;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setVisible(r100);
    }

    @Override // com.bytedance.map.api.model.IHeatMap
    public void setZIndex(float r100) {
        TileOverlay r101 = this.tileOverlay;
        if (r101 != null) goto L5;
        return;
    L5:
        r101.setZIndex(r100);
    }

    public AliHeatMap(TileOverlay r100, String r101) {
        this.tileOverlay = r100;
        this.mId = r101;
    }
}
