package com.autonavi.base.ae.gmap;

import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.base.amap.mapcore.FPoint;
import tb2.c;

/* JADX INFO: loaded from: classes39.dex */
public class GLMapState implements IGLMapState {
    private int engineID;
    private boolean isNewInstance;
    private long nativeEngineInstance;
    private long nativeStateInstance;

    public static native float nativeCalMapZoomScalefactor(long r100, int r101, int r102, float r103);

    public static native float nativeCalculateMapZoomer(long r100, int r101, int r102, int r103, int r104, int r105);

    public static native float nativeGetCameraDegree(long r100);

    public static native float nativeGetGLUnitWithWin(long r100, int r101);

    public static native float nativeGetMapAngle(long r100);

    public static native void nativeGetMapCenter(long r100, Point r101);

    public static native double nativeGetMapCenterXDouble(long r100);

    public static native double nativeGetMapCenterYDouble(long r100);

    public static native float nativeGetMapZoomer(long r100);

    public static native void nativeGetPixel20Bound(long r100, Rect r101, int r102, int r103);

    public static native void nativeGetProjectionMatrix(long r100, float[] r101);

    public static native float nativeGetSkyHeight(long r100);

    public static native void nativeGetViewMatrix(long r100, float[] r101);

    public static native boolean nativeGetZoomCenterInRect(long r100, int r101, int r102, int r103, int r104, int r105, int r106, double r107, double r110, double r111, double r112, double[] r113);

    public static native float nativeGetZoomInRect(long r100, int r101, int r102, double r103, double r104, double r105, double r110);

    public static native long nativeNewInstance(int r100, long r101);

    public static native void nativeP20ToScreenPoint(long r100, int r101, int r102, int r103, PointF r104);

    public static native void nativeRecalculate(long r100);

    public static native void nativeScreenToP20Point(long r100, float r101, float r102, Point r103);

    public static native void nativeSetCameraDegree(long r100, float r101);

    public static native void nativeSetMapAngle(long r100, float r101);

    public static native void nativeSetMapCenter(long r100, double r101, double r102);

    public static native void nativeSetMapCenterByLonLat(long r100, double r101, double r102);

    private static native void nativeSetMapState(int r100, long r101, long r102);

    public static native void nativeSetMapZoomer(long r100, float r101);

    public static native void nativeStateDestroy(long r100, long r101);

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getCameraDegree() {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetCameraDegree(r100);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapAngle() {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetMapAngle(r100);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public DPoint getMapGeoCenter() {
        DPoint r100 = new DPoint();
        r100.f30021x = nativeGetMapCenterXDouble(this.nativeStateInstance);
        r100.f30022y = nativeGetMapCenterYDouble(this.nativeStateInstance);
        return r100;
    }

    public double getMapGeoCenterX() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    public double getMapGeoCenterY() {
        return nativeGetMapCenterXDouble(this.nativeStateInstance);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float getMapZoomer() {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetMapZoomer(r100);
    }

    public float getSkyHeight() {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetSkyHeight(r100);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recalculate() {
        long r100 = this.nativeStateInstance;
        if (r100 == 0) goto L6;
        nativeRecalculate(r100);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void recycle() {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
    L7:
        this.nativeStateInstance = 0;
        return;
    L5:
        if (this.isNewInstance == false) goto L7;
        nativeStateDestroy(r100, this.nativeEngineInstance);
        goto L7
    }

    public void reset() {
        if (this.nativeStateInstance == 0) goto L5;
        recycle();
    L5:
        long r100 = this.nativeEngineInstance;
        if (r100 == 0) goto L9;
        this.nativeStateInstance = nativeNewInstance(this.engineID, r100);
        return;
    }

    public String toString() {
        return "instance: " + this.nativeStateInstance + " center: " + getMapGeoCenter().f30021x + " , " + getMapGeoCenter().f30022y + " bearing:" + getCameraDegree() + "  tilt:" + getMapAngle() + "  zoom:" + getMapZoomer() + c.DEFAULT_TEXT;
    }

    public long getNativeInstance() {
        return this.nativeStateInstance;
    }

    public float getGLUnitWithWin(int r100) {
        long r101 = this.nativeStateInstance;
        if (r101 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetGLUnitWithWin(r101, r100);
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void getMapGeoCenter(IPoint r100) {
        nativeGetMapCenter(this.nativeStateInstance, r100);
    }

    public float getMapLenWithWin(int r100) {
        return getGLUnitWithWin(r100);
    }

    public void getProjectionMatrix(float[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length != 16) goto L8;
        nativeGetProjectionMatrix(this.nativeStateInstance, r100);
        return;
    }

    public void getViewMatrix(float[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length != 16) goto L8;
        nativeGetViewMatrix(this.nativeStateInstance, r100);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setCameraDegree(float r100) {
        long r101 = this.nativeStateInstance;
        if (r101 == 0) goto L6;
        nativeSetCameraDegree(r101, r100);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapAngle(float r100) {
        long r101 = this.nativeStateInstance;
        if (r101 == 0) goto L6;
        nativeSetMapAngle(r101, r100);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapZoomer(float r100) {
        long r101 = this.nativeStateInstance;
        if (r101 == 0) goto L6;
        nativeSetMapZoomer(r101, r100);
        return;
    }

    public GLMapState(int r100, long r101) {
        this.nativeStateInstance = 0;
        this.nativeEngineInstance = 0;
        this.isNewInstance = false;
        if (r101 == 0) goto L6;
        this.engineID = r100;
        this.nativeEngineInstance = r101;
        this.nativeStateInstance = nativeNewInstance(r100, r101);
        this.isNewInstance = true;
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapCenterByLonLat(double r100, double r101) {
        long r102 = this.nativeStateInstance;
        if (r102 == 0) goto L6;
        nativeSetMapCenterByLonLat(r102, r100, r101);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void setMapGeoCenter(double r100, double r101) {
        long r102 = this.nativeStateInstance;
        if (r102 == 0) goto L6;
        nativeSetMapCenter(r102, r100, r101);
        return;
    }

    public void setNativeMapengineState(int r100, long r101) {
        if (r101 == 0) goto L9;
        long r102 = this.nativeStateInstance;
        if (r102 == 0) goto L10;
        this.nativeEngineInstance = r101;
        nativeSetMapState(r100, r101, r102);
        return;
    L10:
        return;
    }

    public GLMapState(int r100, long r101, long r102) {
        this.nativeStateInstance = 0;
        this.nativeEngineInstance = 0;
        this.isNewInstance = false;
        if (r101 == 0) goto L6;
        this.engineID = r100;
        this.nativeEngineInstance = r101;
        this.nativeStateInstance = r102;
        this.isNewInstance = true;
        return;
    }

    public static void geo2LonLat(long r100, long r101, DPoint r102) {
        DPoint r103 = VirtualEarthProjection.pixelsToLatLong(r100, r101, 20);
        r102.f30021x = r103.f30021x;
        r102.f30022y = r103.f30022y;
        r103.recycle();
    }

    public static void lonlat2Geo(double r100, double r101, IPoint r102) {
        Point r103 = VirtualEarthProjection.latLongToPixels(r101, r100, 20);
        ((Point) r102).x = r103.x;
        ((Point) r102).y = r103.y;
    }

    public float calMapZoomScalefactor(int r100, int r101, int r102) {
        return nativeCalMapZoomScalefactor(this.nativeStateInstance, r100, r101, r102);
    }

    public void getPixel20Bound(Rect r100, int r101, int r102) {
        long r103 = this.nativeStateInstance;
        if (r103 == 0) goto L6;
        nativeGetPixel20Bound(r103, r100, r101, r102);
        return;
    }

    public void p20ToScreenPoint(int r100, int r101, FPoint r102) {
        long r103 = this.nativeStateInstance;
        if (r103 == 0) goto L6;
        nativeP20ToScreenPoint(r103, r100, r101, 0, r102);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public void screenToP20Point(int r100, int r101, Point r102) {
        long r103 = this.nativeStateInstance;
        if (r103 == 0) goto L6;
        nativeScreenToP20Point(r103, r100, r101, r102);
        return;
    }

    @Override // com.autonavi.amap.api.mapcore.IGLMapState
    public float calculateMapZoomer(int r100, int r101, int r110, int r111, int r112) {
        long r102 = this.nativeStateInstance;
        if (r102 != 0) goto L5;
        return 3.0f;
    L5:
        return nativeCalculateMapZoomer(r102, r100, r101, r110, r111, r112);
    }

    public float getZoomInRect(int r110, int r111, double r112, double r113, double r210, double r211) {
        long r100 = this.nativeStateInstance;
        if (r100 != 0) goto L5;
        return 0.0f;
    L5:
        return nativeGetZoomInRect(r100, r110, r111, r112, r113, r210, r211);
    }

    public boolean getZoomCenterInRect(int r110, int r210, int r211, int r212, int r213, int r214, double r215, double r216, double r217, double r310, double[] r311) {
        long r100 = this.nativeStateInstance;
        if (r100 == 0) goto L9;
        if (r311 != null) goto L6;
        return false;
    L6:
        if (r311.length >= 3) goto L8;
        return false;
    L8:
        return nativeGetZoomCenterInRect(r100, r110, r210, r211, r212, r213, r214, r215, r216, r217, r310, r311);
    L9:
        return false;
    }
}
