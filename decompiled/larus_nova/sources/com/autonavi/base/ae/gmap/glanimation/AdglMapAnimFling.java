package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: classes39.dex */
public class AdglMapAnimFling extends AbstractAdglAnimation {
    private IPoint fromCenter;
    private boolean hasCheckParams;
    private int lastMoveX;
    private int lastMoveY;
    private AbstractAdglAnimationParam2V moveParam;
    private boolean needMove;
    private int screenCenterX;
    private int screenCenterY;
    private float velocityX;
    private float velocityY;

    public void reset() {
        AbstractAdglAnimationParam2V r100 = this.moveParam;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        this.velocityX = 0.0f;
        this.velocityY = 0.0f;
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public void commitAnimation(Object r100) {
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        this.hasCheckParams = false;
        this.isOver = true;
        float r102 = this.velocityX;
        float r103 = this.duration;
        int r104 = (int) ((r102 * r103) / 2000.0f);
        int r105 = (int) ((this.velocityY * r103) / 2000.0f);
        if (Math.abs(r104) != 0) goto L8;
    L13:
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
        return;
    L8:
        if (Math.abs(r105) == 0) goto L13;
        if (this.fromCenter != null) goto L12;
        this.fromCenter = IPoint.obtain();
    L12:
        r101.getMapGeoCenter(this.fromCenter);
        this.isOver = false;
        this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
        this.moveParam.setToValue(this.screenCenterX - r104, this.screenCenterY - r105);
        this.needMove = this.moveParam.needToCaculate();
        goto L13
    }

    public void commitAnimationold(Object r100) {
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        this.hasCheckParams = false;
        this.isOver = true;
        float r102 = this.velocityX;
        float r103 = this.velocityY;
        float r104 = ((float) Math.sqrt((r102 * r102) + (r103 * r103))) / 1000.0f;
        if (r104 < 0.1f) goto L11;
        float r105 = r104 * 0.02f;
        if (this.fromCenter != null) goto L10;
        this.fromCenter = IPoint.obtain();
    L10:
        r101.getMapGeoCenter(this.fromCenter);
        this.isOver = false;
        this.moveParam.setFromValue(this.screenCenterX, this.screenCenterY);
        this.moveParam.setToValue(this.screenCenterX - (this.velocityX * r105), this.screenCenterY - (this.velocityY * r105));
        this.needMove = this.moveParam.needToCaculate();
    L11:
        this.hasCheckParams = true;
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
        if (r103 <= 1.0f) goto L19;
        return;
    L19:
        if (this.needMove == false) goto L24;
        this.moveParam.setNormalizedTime(r103);
        int r104 = (int) this.moveParam.getCurXValue();
        int r105 = (int) this.moveParam.getCurYValue();
        IPoint r106 = IPoint.obtain();
        r101.screenToP20Point((this.screenCenterX + r104) - this.lastMoveX, (this.screenCenterY + r105) - this.lastMoveY, r106);
        r101.setMapGeoCenter(((Point) r106).x, ((Point) r106).y);
        this.lastMoveX = r104;
        this.lastMoveY = r105;
        r106.recycle();
        return;
    }

    public void setPositionAndVelocity(float r100, float r101) {
        this.moveParam = null;
        this.velocityX = r100;
        this.velocityY = r101;
        AbstractAdglAnimationParam2V r102 = new AbstractAdglAnimationParam2V();
        this.moveParam = r102;
        r102.setInterpolatorType(2, 1.2f);
        this.needMove = false;
        this.hasCheckParams = false;
    }

    public AdglMapAnimFling(int r100, int r101, int r102) {
        this.screenCenterX = r101;
        this.screenCenterY = r102;
        this.lastMoveX = r101;
        this.lastMoveY = r102;
        this.moveParam = null;
        reset();
        this.duration = r100;
    }
}
