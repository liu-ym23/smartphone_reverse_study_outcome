package com.amap.api.mapcore.util;

import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BaseOverlay;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes28.dex */
public class q4 extends BaseOverlay {
    public q4(IGlOverlayLayer r100, p4 r101, String r102) {
        super(r102);
        new WeakReference(r100);
    }
}
