package com.baidu.mapapi.map;

import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class ItemizedOverlay extends Overlay {

    /* renamed from: g, reason: collision with root package name */
    MapView f6491g;

    public ItemizedOverlay(Drawable drawable, MapView mapView) {
        this.type = com.baidu.mapsdkplatform.comapi.map.d.marker;
        this.f6491g = mapView;
    }

    public void addItem(OverlayOptions overlayOptions) {
        if (overlayOptions != null) {
            this.f6491g.getMap().addOverlay(overlayOptions);
        }
    }

    public void reAddAll() {
    }

    public void removeAll() {
        this.f6491g.getMap().clear();
    }
}
