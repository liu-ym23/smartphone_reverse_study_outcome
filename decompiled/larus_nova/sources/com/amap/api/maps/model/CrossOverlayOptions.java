package com.amap.api.maps.model;

import android.graphics.Bitmap;
import com.autonavi.base.ae.gmap.gloverlay.AVectorCrossAttr;

/* JADX INFO: loaded from: classes28.dex */
public class CrossOverlayOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AVectorCrossAttr f28649a;
    private Bitmap bitmapDescriptor;

    public CrossOverlayOptions() {
        this.f28649a = null;
        this.bitmapDescriptor = null;
    }

    public AVectorCrossAttr getAttribute() {
        return this.f28649a;
    }

    public Bitmap getRes() {
        return this.bitmapDescriptor;
    }

    public CrossOverlayOptions setAttribute(AVectorCrossAttr r100) {
        this.f28649a = r100;
        return this;
    }

    public CrossOverlayOptions setRes(Bitmap r100) {
        this.bitmapDescriptor = r100;
        return this;
    }
}
