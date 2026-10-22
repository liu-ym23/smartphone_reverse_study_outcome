package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

/* JADX INFO: loaded from: classes39.dex */
public class c extends InnerOverlay {
    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public boolean getDefaultShowStatus() {
        return true;
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public String getLayerTag() {
        return MapController.COMPASS_LAYER_TAG;
    }

    public c(AppBaseMap r100) {
        super(20, r100);
    }

    @Override // com.baidu.platform.comapi.map.InnerOverlay
    public void setData(String r100) {
        super.setData(r100);
    }
}
