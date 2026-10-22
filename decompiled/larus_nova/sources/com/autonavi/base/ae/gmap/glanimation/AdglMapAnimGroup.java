package com.autonavi.base.ae.gmap.glanimation;

import android.graphics.Point;
import android.os.SystemClock;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;

/* JADX INFO: loaded from: classes39.dex */
public class AdglMapAnimGroup extends AbstractAdglAnimation {
    public static final int CAMERA_MAX_DEGREE = 80;
    public static final int CAMERA_MIN_DEGREE = 0;
    public static final int MAXMAPLEVEL = 20;
    public static final int MINMAPLEVEL = 3;
    int endZoomDuration;
    boolean hasCheckParams;
    boolean hasMidZoom;
    int midZoomDuration;
    AbstractAdglAnimationParam2V moveParam;
    public boolean needMove;
    boolean needRotateCamera;
    boolean needRotateMap;
    boolean needZoom;
    AbstractAdglAnimationParam1V rotateCameraParam;
    AbstractAdglAnimationParam1V rotateMapParam;
    int startZoomDuration;
    AbstractAdglAnimationParam1V zoomEndParam;
    AbstractAdglAnimationParam1V zoomStartParam;

    public static boolean checkLevel(float r100) {
        if (r100 >= 3.0f) goto L5;
    L7:
        return false;
    L5:
        if (r100 > 20.0f) goto L7;
        return true;
    }

    public void reset() {
        this.isOver = false;
        this.hasCheckParams = false;
        this.needZoom = false;
        this.needMove = false;
        this.moveParam = null;
        this.needRotateMap = false;
        this.rotateMapParam = null;
        this.hasMidZoom = false;
        this.duration = 0;
        AbstractAdglAnimationParam1V r100 = this.zoomStartParam;
        if (r100 == null) goto L5;
        r100.reset();
    L5:
        AbstractAdglAnimationParam1V r101 = this.zoomEndParam;
        if (r101 == null) goto L8;
        r101.reset();
    L8:
        AbstractAdglAnimationParam1V r102 = this.rotateCameraParam;
        if (r102 == null) goto L12;
        r102.reset();
        return;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public boolean isValid() {
        if (this.needRotateCamera == false) goto L5;
        return true;
    L5:
        if (this.needRotateMap == false) goto L7;
        return true;
    L7:
        if (this.needMove == false) goto L9;
        return true;
    L9:
        if (this.needZoom == true) goto L17;
        return false;
    L17:
        return true;
    }

    public AdglMapAnimGroup(int r100) {
        this.zoomStartParam = null;
        this.zoomEndParam = null;
        this.moveParam = null;
        this.rotateMapParam = null;
        this.rotateCameraParam = null;
        reset();
        this.duration = r100;
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void applyFinalState(Object r100) {
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.needZoom == false) goto L18;
        if (this.hasMidZoom == false) goto L12;
        AbstractAdglAnimationParam1V r102 = this.zoomEndParam;
        if (r102 == null) goto L12;
        float r103 = r102.getToValue();
    L16:
        r101.setMapZoomer(r103);
    L12:
        AbstractAdglAnimationParam1V r104 = this.zoomStartParam;
        if (r104 == null) goto L15;
        r103 = r104.getToValue();
        goto L16
    L15:
        r103 = r101.getMapZoomer();
    L18:
        if (this.needMove == false) goto L23;
        AbstractAdglAnimationParam2V r105 = this.moveParam;
        if (r105 == null) goto L23;
        r101.setMapGeoCenter(r105.getToXValue(), this.moveParam.getToYValue());
    L23:
        if (this.needRotateMap == false) goto L28;
        AbstractAdglAnimationParam1V r106 = this.rotateMapParam;
        if (r106 == null) goto L28;
        r101.setMapAngle((int) r106.getToValue());
    L28:
        if (this.needRotateCamera == false) goto L33;
        AbstractAdglAnimationParam1V r107 = this.rotateCameraParam;
        if (r107 == null) goto L34;
        r101.setCameraDegree((int) r107.getToValue());
        return;
    L34:
        return;
    }

    public void commitAnimation(Object r100) {
        this.isOver = true;
        this.hasCheckParams = false;
        GLMapState r101 = (GLMapState) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.needZoom == false) goto L32;
        if (this.zoomStartParam != null) goto L11;
        this.hasCheckParams = true;
        return;
    L11:
        float r102 = r101.getMapZoomer();
        this.zoomStartParam.setFromValue(r102);
        if (this.hasMidZoom == false) goto L21;
        float r103 = this.zoomStartParam.getToValue() - r102;
        float r104 = this.zoomEndParam.getFromValue() - this.zoomEndParam.getToValue();
        if (Math.abs(r103) >= 1.0E-6d) goto L16;
    L19:
        this.hasMidZoom = false;
        this.zoomStartParam.setToValue(this.zoomEndParam.getToValue());
        this.zoomStartParam.needToCaculate();
        this.zoomEndParam = null;
        goto L21
    L16:
        if (Math.abs(r104) < 1.0E-6d) goto L19;
        this.zoomStartParam.needToCaculate();
        this.zoomEndParam.needToCaculate();
    L21:
        if (this.hasMidZoom == true) goto L26;
        if (Math.abs(this.zoomStartParam.getFromValue() - this.zoomStartParam.getToValue()) >= 1.0E-6d) goto L26;
        this.needZoom = false;
    L26:
        if (this.needZoom == false) goto L32;
        if (this.hasMidZoom == false) goto L30;
        int r105 = (this.duration - this.midZoomDuration) >> 1;
        this.startZoomDuration = r105;
        this.endZoomDuration = r105;
        goto L32
    L30:
        this.startZoomDuration = this.duration;
    L32:
        if (this.needMove == false) goto L37;
        if (this.moveParam == null) goto L37;
        IPoint r106 = IPoint.obtain();
        r101.getMapGeoCenter(r106);
        int r107 = ((Point) r106).x;
        int r108 = ((Point) r106).y;
        r106.recycle();
        this.moveParam.setFromValue(r107, r108);
        this.needMove = this.moveParam.needToCaculate();
    L37:
        if (this.needRotateMap == false) goto L53;
        if (this.rotateMapParam == null) goto L53;
        float r109 = r101.getMapAngle();
        float r110 = this.rotateMapParam.getToValue();
        if (r109 > 180.0f) goto L43;
    L45:
        float r111 = ((int) r110) - ((int) r109);
        if (r111 <= 180.0f) goto L49;
        r110 = r110 - 360.0f;
    L51:
        this.rotateMapParam.setFromValue(r109);
        this.rotateMapParam.setToValue(r110);
        this.needRotateMap = this.rotateMapParam.needToCaculate();
        goto L53
    L49:
        if (r111 >= (-180.0f)) goto L51;
        r110 = r110 + 360.0f;
        goto L51
    L43:
        if (r110 != 0.0f) goto L45;
        r110 = 360.0f;
    L53:
        if (this.needRotateCamera == false) goto L58;
        if (this.rotateCameraParam == null) goto L58;
        this.rotateCameraParam.setFromValue(r101.getCameraDegree());
        this.needRotateCamera = this.rotateCameraParam.needToCaculate();
    L58:
        if (this.needMove == false) goto L60;
    L66:
        this.isOver = false;
    L67:
        this.hasCheckParams = true;
        this.startTime = SystemClock.uptimeMillis();
        return;
    L60:
        if (this.needZoom == true) goto L66;
        if (this.needRotateMap == true) goto L66;
        if (this.needRotateCamera == true) goto L66;
        this.isOver = true;
        goto L67
    }

    @Override // com.autonavi.base.ae.gmap.glanimation.AbstractAdglAnimation
    public void doAnimation(Object r110) {
        GLMapState r100 = (GLMapState) r110;
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.hasCheckParams == true) goto L9;
        commitAnimation(r110);
    L9:
        if (this.isOver == false) goto L11;
        return;
    L11:
        long r101 = SystemClock.uptimeMillis() - this.startTime;
        this.offsetTime = r101;
        float r111 = this.duration;
        if (r111 != 0.0f) goto L15;
        this.isOver = true;
        return;
    L15:
        float r102 = r101 / r111;
        if (r102 <= 1.0f) goto L19;
        this.isOver = true;
        r102 = 1.0f;
    L23:
        if (this.needZoom == false) goto L38;
        r100.getMapZoomer();
        if (this.hasMidZoom == false) goto L36;
        long r103 = this.offsetTime;
        int r112 = this.startZoomDuration;
        long r104 = r112;
        if (r103 > r104) goto L29;
        this.zoomStartParam.setNormalizedTime(r103 / r112);
        float r113 = this.zoomStartParam.getCurValue();
    L34:
        if (this.isOver == false) goto L37;
        r113 = this.zoomEndParam.getToValue();
    L37:
        r100.setMapZoomer(r113);
        goto L38
    L29:
        int r105 = this.midZoomDuration;
        if (r103 > (r112 + r105)) goto L32;
        r113 = this.zoomStartParam.getToValue();
        goto L34
    L32:
        this.zoomEndParam.setNormalizedTime(((r103 - r104) - ((long) r105)) / this.endZoomDuration);
        r113 = this.zoomEndParam.getCurValue();
        goto L34
    L36:
        this.zoomStartParam.setNormalizedTime(r102);
        r113 = this.zoomStartParam.getCurValue();
    L38:
        AbstractAdglAnimationParam2V r114 = this.moveParam;
        if (r114 != null) goto L41;
    L43:
        AbstractAdglAnimationParam1V r115 = this.rotateMapParam;
        if (r115 != null) goto L46;
    L48:
        AbstractAdglAnimationParam1V r116 = this.rotateCameraParam;
        if (r116 != null) goto L51;
        return;
    L51:
        if (this.needRotateCamera == false) goto L55;
        r116.setNormalizedTime(r102);
        r100.setCameraDegree((int) this.rotateCameraParam.getCurValue());
        return;
    L55:
        return;
    L46:
        if (this.needRotateMap == false) goto L48;
        r115.setNormalizedTime(r102);
        r100.setMapAngle((int) this.rotateMapParam.getCurValue());
        goto L48
    L41:
        if (this.needMove == false) goto L43;
        r114.setNormalizedTime(r102);
        int r117 = (int) this.moveParam.getFromXValue();
        int r106 = (int) this.moveParam.getFromYValue();
        int r107 = (int) this.moveParam.getToXValue();
        int r108 = (int) this.moveParam.getToYValue();
        float r109 = this.moveParam.getCurMult();
        r100.setMapGeoCenter(r117 + ((int) ((r107 - r117) * r109)), r106 + ((int) ((r108 - r106) * r109)));
        goto L43
    L19:
        if (r102 >= 0.0f) goto L23;
        this.isOver = true;
    }

    public void setDuration(int r100) {
        this.duration = r100;
    }

    public boolean typeEqueal(AdglMapAnimGroup r100) {
        if (this.needRotateCamera == r100.needRotateCamera) goto L5;
        return false;
    L5:
        if (this.needRotateMap == r100.needRotateMap) goto L7;
        return false;
    L7:
        if (this.needZoom == r100.needZoom) goto L9;
        return false;
    L9:
        if (this.needMove != r100.needMove) goto L16;
        return true;
    L16:
        return false;
    }

    private void initZoomStartParam(float r100, int r101) {
        if (this.zoomStartParam != null) goto L5;
        this.zoomStartParam = new AbstractAdglAnimationParam1V();
    L5:
        this.zoomStartParam.reset();
        this.zoomStartParam.setInterpolatorType(r101, 1.0f);
        this.zoomStartParam.setToValue(r100);
    }

    public void setToCameraDegree(float r100, int r101) {
        this.needRotateCamera = false;
        if (r100 <= 80.0f) goto L5;
        return;
    L5:
        if (r100 < 0.0f) goto L12;
        this.needRotateCamera = true;
        if (this.rotateCameraParam != null) goto L9;
        this.rotateCameraParam = new AbstractAdglAnimationParam1V();
    L9:
        this.rotateCameraParam.reset();
        this.rotateCameraParam.setInterpolatorType(r101, 1.0f);
        this.rotateCameraParam.setToValue(r100);
        return;
    }

    public void setToMapAngle(float r100, int r101) {
        float r102 = r100 % 360.0f;
        this.needRotateMap = true;
        if (this.rotateMapParam != null) goto L5;
        this.rotateMapParam = new AbstractAdglAnimationParam1V();
    L5:
        this.rotateMapParam.reset();
        this.rotateMapParam.setInterpolatorType(r101, 1.0f);
        this.rotateMapParam.setToValue(r102);
    }

    public void setToMapLevel(float r100, int r101) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (checkLevel(r100) == false) goto L5;
        initZoomStartParam(r100, r101);
        return;
    L5:
        this.needZoom = false;
    }

    private void initZoomEndParam(float r100, float r101, int r102) {
        if (this.zoomEndParam != null) goto L5;
        this.zoomEndParam = new AbstractAdglAnimationParam1V();
    L5:
        this.zoomEndParam.reset();
        this.zoomEndParam.setInterpolatorType(r102, 1.0f);
        this.zoomEndParam.setToValue(r101);
        this.zoomEndParam.setFromValue(r100);
    }

    public void setToMapCenterGeo(int r100, int r101, int r102) {
        if (r100 <= 0) goto L9;
        if (r101 <= 0) goto L10;
        this.needMove = true;
        if (this.moveParam != null) goto L7;
        this.moveParam = new AbstractAdglAnimationParam2V();
    L7:
        this.moveParam.reset();
        this.moveParam.setInterpolatorType(r102, 1.0f);
        this.moveParam.setToValue(r100, r101);
        return;
    L10:
        return;
    }

    public void setToMapLevel(float r100, float r101, int r102) {
        this.needZoom = true;
        this.midZoomDuration = 0;
        this.hasMidZoom = false;
        if (r102 <= 0) goto L8;
        if (r102 >= this.duration) goto L8;
        this.midZoomDuration = r102;
    L8:
        if (checkLevel(r100) == false) goto L13;
        if (checkLevel(r101) == false) goto L13;
        this.hasMidZoom = true;
        initZoomStartParam(r101, 0);
        initZoomEndParam(r101, r100, 0);
        return;
    L13:
        if (checkLevel(r100) == false) goto L16;
        this.hasMidZoom = false;
        initZoomStartParam(r100, 0);
        return;
    L16:
        if (checkLevel(r101) == false) goto L18;
        this.hasMidZoom = false;
        initZoomStartParam(r101, 0);
        return;
    L18:
        this.needZoom = false;
    }
}
