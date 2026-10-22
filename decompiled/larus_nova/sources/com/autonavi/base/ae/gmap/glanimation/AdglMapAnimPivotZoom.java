package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: classes39.dex */
public class AdglMapAnimPivotZoom extends AbstractAdglAnimation {
    private int beginCenterGeoX;
    private int beginCenterGeoY;
    private boolean hasCheckParams;
    private float mapLevelTo;
    private int pivotGeoX;
    private int pivotGeoY;
    private float winPivotX;
    private float winPivotY;
    private boolean zoomCenter;
    AbstractAdglAnimationParam1V zoomParam;

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.zoomCenter = true;
        this.mapLevelTo = 0.0f;
        this.beginCenterGeoX = 0;
        this.beginCenterGeoY = 0;
        this.pivotGeoX = 0;
        this.pivotGeoY = 0;
        this.winPivotX = 0.0f;
        this.winPivotY = 0.0f;
        AbstractAdglAnimationParam1V r100 = this.zoomParam;
        if (r100 == null) goto L6;
        r100.reset();
        return;
    }

    public AdglMapAnimPivotZoom(int r100) {
        this.zoomParam = null;
        reset();
        this.duration = r100;
    }

    public void commitAnimation(Object r100) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        float r102 = r101.getMapZoomer();
        if (Math.abs(this.mapLevelTo - r102) >= 1.0E-6d) goto L9;
        this.isOver = true;
        this.hasCheckParams = true;
        return;
    L9:
        this.zoomParam.setFromValue(r102);
        this.zoomParam.setToValue(this.mapLevelTo);
        if (this.zoomCenter == true) goto L12;
        IPoint r103 = IPoint.obtain();
        r101.getMapGeoCenter(r103);
        this.beginCenterGeoX = ((Point) r103).x;
        this.beginCenterGeoY = ((Point) r103).y;
        IPoint r104 = IPoint.obtain();
        r101.screenToP20Point((int) this.winPivotX, (int) this.winPivotY, r104);
        this.pivotGeoX = ((Point) r104).x;
        this.pivotGeoY = ((Point) r104).y;
        r103.recycle();
        r104.recycle();
    L12:
        this.hasCheckParams = true;
        this.isOver = false;
        this.startTime = SystemClock.uptimeMillis();
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object r100) {
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.hasCheckParams == true) goto L9;
        commitAnimation(r100);
    L9:
        if (this.isOver == false) goto L11;
        return;
    L11:
        long r102 = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = r102;
        float r103 = r102 / this.duration;
        if (r103 <= 1.0f) goto L15;
        this.isOver = true;
        r103 = 1.0f;
    L15:
        if (r103 >= 0.0f) goto L17;
        return;
    L17:
        if (r103 > 1.0f) goto L30;
        this.zoomParam.setNormalizedTime(r103);
        float r104 = this.zoomParam.getCurValue();
        if (r104 <= 20.0f) goto L22;
        this.isOver = true;
        r104 = 20.0f;
    L22:
        if (r104 >= 3.0f) goto L25;
        this.isOver = true;
        r104 = 3.0f;
    L25:
        if (this.zoomCenter == true) goto L27;
        float r105 = (float) Math.pow(2.0d, r104 - this.zoomParam.getFromValue());
        int r106 = this.pivotGeoX;
        int r107 = this.beginCenterGeoX;
        float r108 = 1.0f - (1.0f / r105);
        int r109 = (int) ((r106 - r107) * r108);
        int r110 = this.pivotGeoY;
        int r111 = this.beginCenterGeoY;
        r101.setMapGeoCenter(r107 + r109, r111 + ((int) ((r110 - r111) * r108)));
    L27:
        r101.setMapZoomer(r104);
        return;
    }

    public void setToMapZoomAndPivot(float r100, int r101, Point r102) {
        AbstractAdglAnimationParam1V r103 = new AbstractAdglAnimationParam1V();
        this.zoomParam = r103;
        r103.setInterpolatorType(r101, 1.0f);
        if (r100 <= 20.0f) goto L6;
        r100 = 20.0f;
    L6:
        if (r100 >= 3.0f) goto L8;
        r100 = 3.0f;
    L8:
        this.mapLevelTo = r100;
        if (r102 == null) goto L12;
        this.winPivotX = r102.x;
        this.winPivotY = r102.y;
        this.zoomCenter = false;
        return;
    }
}
