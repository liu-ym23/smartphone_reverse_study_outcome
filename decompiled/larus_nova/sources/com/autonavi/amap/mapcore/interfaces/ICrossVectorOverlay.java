package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX INFO: loaded from: classes39.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr r100);

    int setData(byte[] r100);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener r100);

    void setImageMode(boolean r100);

    void setOnCrossVectorUpdateListener(CrossOverlay.OnCrossVectorUpdateListener r100);

    void setVisible(boolean r100);
}
