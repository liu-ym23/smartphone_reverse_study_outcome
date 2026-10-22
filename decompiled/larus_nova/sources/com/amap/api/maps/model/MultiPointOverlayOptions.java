package com.amap.api.maps.model;

import java.util.List;

/* JADX INFO: loaded from: classes28.dex */
public class MultiPointOverlayOptions extends BaseOptions implements Cloneable {
    private float anchorU;
    private float anchorV;
    private BitmapDescriptor bitmapDescriptor;
    private boolean enable;
    private List<MultiPointItem> multiPointItems;
    private boolean multiPointItemsUpdated;

    public MultiPointOverlayOptions() {
        this.anchorU = 0.5f;
        this.anchorV = 0.5f;
        this.enable = true;
        this.type = "MultiPointOverlayOptions";
    }

    public MultiPointOverlayOptions clone() {
        super.clone();     // Catch: CloneNotSupportedException -> L4
    L6:
        MultiPointOverlayOptions r100 = new MultiPointOverlayOptions();
        r100.bitmapDescriptor = this.bitmapDescriptor;
        r100.anchorU = this.anchorU;
        r100.anchorV = this.anchorV;
        r100.multiPointItemsUpdated = this.multiPointItemsUpdated;
        r100.multiPointItems = this.multiPointItems;
        r100.enable = this.enable;
        return r100;
    L4:
        e = move-exception;
        e.printStackTrace();
        goto L6
    }

    public float getAnchorU() {
        return this.anchorU;
    }

    public float getAnchorV() {
        return this.anchorV;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDescriptor;
    }

    public List<MultiPointItem> getMultiPointItems() {
        return this.multiPointItems;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m8028clone() throws CloneNotSupportedException {
        return clone();
    }

    public MultiPointOverlayOptions icon(BitmapDescriptor r100) {
        this.bitmapDescriptor = r100;
        return this;
    }

    public void setEnable(boolean r100) {
        this.enable = r100;
    }

    public void setMultiPointItems(List<MultiPointItem> r100) {
        this.multiPointItems = r100;
        this.multiPointItemsUpdated = true;
    }

    public MultiPointOverlayOptions anchor(float r100, float r101) {
        this.anchorU = r100;
        this.anchorV = r101;
        return this;
    }
}
