package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: classes39.dex */
public class AdglMapAnimFlingP20 extends AbstractAdglAnimation {
    private boolean hasCheckParams;
    private AbstractAdglAnimationParam2V moveParam;
    private boolean needMove;
    private float velocityScreenX;
    private float velocityScreenY;

    public void reset() {
        AbstractAdglAnimationParam2V r100 = this.moveParam;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        this.velocityScreenX = 0.0f;
        this.velocityScreenY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public AdglMapAnimFlingP20(int r100) {
        this.moveParam = null;
        reset();
        this.duration = r100;
    }

    public void commitAnimation(Object r110) {
        GLMapState r100 = (GLMapState) r110;
        if (r100 != null) goto L5;
        return;
    L5:
        this.hasCheckParams = false;
        this.isOver = true;
        float r101 = this.velocityScreenX;
        float r102 = this.duration;
        float r103 = (r101 * r102) / 2000.0f;
        float r104 = (this.velocityScreenY * r102) / 2000.0f;
        if (Math.abs(r103) != 0.0f) goto L8;
    L10:
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
        return;
    L8:
        if (Math.abs(r104) == 0.0f) goto L10;
        this.isOver = false;
        IPoint r105 = IPoint.obtain();
        r100.getMapGeoCenter(r105);
        this.moveParam.setFromValue(((Point) r105).x, ((Point) r105).y);
        float r106 = r100.getMapLenWithWin(1);
        double r107 = (((double) r100.getMapAngle()) * 3.141592653589793d) / 180.0d;
        double r108 = r106;
        double r111 = r103;
        double r109 = r104;
        this.moveParam.setToValue(((double) ((Point) r105).x) - (((Math.cos(r107) * r111) - (Math.sin(r107) * r109)) * r108), ((double) ((Point) r105).y) - (r108 * ((r111 * Math.sin(r107)) + (r109 * Math.cos(r107)))));
        this.needMove = this.moveParam.needToCaculate();
        r105.recycle();
        goto L10
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
        if (r103 <= 1.0f) goto L19;
        return;
    L19:
        if (this.needMove == false) goto L24;
        this.moveParam.setNormalizedTime(r103);
        r101.setMapGeoCenter(this.moveParam.getCurXValue(), this.moveParam.getCurYValue());
        return;
    }

    public void setPositionAndVelocity(float r100, float r101) {
        this.moveParam = null;
        this.velocityScreenX = r100;
        this.velocityScreenY = r101;
        AbstractAdglAnimationParam2V r102 = new AbstractAdglAnimationParam2V();
        this.moveParam = r102;
        r102.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }
}
