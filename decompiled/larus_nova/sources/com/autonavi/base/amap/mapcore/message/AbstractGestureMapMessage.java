package com.autonavi.base.amap.mapcore.message;

import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.AbstractMapMessage;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbstractGestureMapMessage extends AbstractMapMessage {
    public int anchorX;
    public int anchorY;
    public int height;
    public boolean isGestureScaleByMapCenter;
    public boolean isUseAnchor;
    private int state;
    public int width;

    @Override // com.autonavi.base.ae.gmap.AbstractMapMessage
    public abstract int getType();

    public void reset() {
        this.width = 0;
        this.height = 0;
        this.state = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.anchorX = 0;
        this.anchorY = 0;
    }

    public abstract void runCameraUpdate(GLMapState r100);

    public int getMapGestureState() {
        return this.state;
    }

    public AbstractGestureMapMessage(int r100) {
        this.width = 0;
        this.height = 0;
        this.isGestureScaleByMapCenter = false;
        this.isUseAnchor = false;
        this.state = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }

    public IPoint getAnchorGeoPoint(GLMapState r100, int r101, int r102) {
        IPoint r103 = IPoint.obtain();
        r100.screenToP20Point(r101, r102, r103);
        return r103;
    }

    public void win2geo(GLMapState r100, int r101, int r102, IPoint r103) {
        r100.screenToP20Point(r101, r102, r103);
    }
}
