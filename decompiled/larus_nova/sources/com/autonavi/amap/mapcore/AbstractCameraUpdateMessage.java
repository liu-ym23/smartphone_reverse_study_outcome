package com.autonavi.amap.mapcore;

import android.graphics.Point;
import androidx.camera.video.AudioStats;
import com.amap.api.mapcore.util.w3;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.api.mapcore.IGLMapEngine;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.base.ae.gmap.GLMapEngine;
import r27.a;

/* JADX INFO: loaded from: classes39.dex */
public abstract class AbstractCameraUpdateMessage {
    public float amount;
    public int anchorX;
    public int anchorY;
    public float bearing;
    public LatLngBounds bounds;
    public CameraPosition cameraPosition;
    public float curZoolScale;
    public Point focus;
    public DPoint geoPoint;
    public int height;
    public boolean isChangeFinished;
    public boolean isUseAnchor;
    public AMap.CancelableCallback mCallback;
    public long mDuration;
    public IMapConfig mapConfig;
    public float maxZoomLevel;
    public float minZoomLevel;
    public Type nowType;
    public int paddingBottom;
    public int paddingLeft;
    public int paddingRight;
    public int paddingTop;
    public float tilt;
    public int width;
    public float xPixel;
    public float yPixel;
    public float zoom;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type changeBearing = null;
        public static final Type changeBearingGeoCenter = null;
        public static final Type changeCenter = null;
        public static final Type changeGeoCenterZoom = null;
        public static final Type changeGeoCenterZoomTiltBearing = null;
        public static final Type changeTilt = null;
        public static final Type newCameraPosition = null;
        public static final Type newLatLngBounds = null;
        public static final Type newLatLngBoundsWithSize = null;
        public static final Type none = null;
        public static final Type scrollBy = null;
        public static final Type zoomBy = null;
        public static final Type zoomIn = null;
        public static final Type zoomOut = null;
        public static final Type zoomTo = null;

        static {
            Type r100 = new Type("none", 0);
            none = r100;
            Type r101 = new Type("zoomIn", 1);
            zoomIn = r101;
            Type r102 = new Type("changeCenter", 2);
            changeCenter = r102;
            Type r103 = new Type("changeTilt", 3);
            changeTilt = r103;
            Type r104 = new Type("changeBearing", 4);
            changeBearing = r104;
            Type r105 = new Type("changeBearingGeoCenter", 5);
            changeBearingGeoCenter = r105;
            Type r110 = new Type("changeGeoCenterZoom", 6);
            changeGeoCenterZoom = r110;
            Type r111 = new Type("zoomOut", 7);
            zoomOut = r111;
            Type r112 = new Type("zoomTo", 8);
            zoomTo = r112;
            Type r113 = new Type("zoomBy", 9);
            zoomBy = r113;
            Type r114 = new Type("scrollBy", 10);
            scrollBy = r114;
            Type r115 = new Type("newCameraPosition", 11);
            newCameraPosition = r115;
            Type r106 = new Type("newLatLngBounds", 12);
            newLatLngBounds = r106;
            Type r107 = new Type("newLatLngBoundsWithSize", 13);
            newLatLngBoundsWithSize = r107;
            Type r108 = new Type("changeGeoCenterZoomTiltBearing", 14);
            changeGeoCenterZoomTiltBearing = r108;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108};
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101) {
            super(r100, r101);
        }
    }

    public abstract void mergeCameraUpdateDelegate(AbstractCameraUpdateMessage r100);

    public abstract void runCameraUpdate(IGLMapState r100);

    public AbstractCameraUpdateMessage() {
        this.nowType = Type.none;
        this.focus = null;
        this.zoom = Float.NaN;
        this.tilt = Float.NaN;
        this.bearing = Float.NaN;
        this.isUseAnchor = false;
        this.mDuration = 250;
        this.maxZoomLevel = 0.0f;
        this.minZoomLevel = 0.0f;
        this.curZoolScale = 0.0f;
    }

    public void generateMapAnimation(IGLMapEngine r110) {
        int r100 = ((GLMapEngine) r110).getEngineIDWithType(1);
        IGLMapState r101 = r110.getNewMapState(r100);
        runCameraUpdate(r101);
        DPoint r102 = r101.getMapGeoCenter();
        r110.addGroupAnimation(r100, (int) this.mDuration, r101.getMapZoomer(), (int) r101.getMapAngle(), (int) r101.getCameraDegree(), (int) r102.f30021x, (int) r102.f30022y, this.mCallback);
        r101.recycle();
    }

    public void normalChange(IGLMapState r100) {
        if (Float.isNaN(this.zoom) == false) goto L5;
        float r101 = r100.getMapZoomer();
    L6:
        this.zoom = r101;
        if (Float.isNaN(this.bearing) == false) goto L9;
        float r102 = r100.getMapAngle();
    L10:
        this.bearing = r102;
        if (Float.isNaN(this.tilt) == false) goto L13;
        float r103 = r100.getCameraDegree();
    L14:
        this.tilt = r103;
        float r104 = w3.a(this.mapConfig, this.zoom);
        this.zoom = r104;
        this.tilt = w3.a(this.mapConfig, this.tilt, r104);
        this.bearing = (float) (((((double) this.bearing) % 360.0d) + 360.0d) % 360.0d);
        Point r105 = this.focus;
        if (r105 == null) goto L20;
        if (this.geoPoint != null) goto L20;
        Point r106 = getAnchorGeoPoint(r100, r105.x, r105.y);
        this.geoPoint = new DPoint(r106.x, r106.y);
    L20:
        if (Float.isNaN(this.zoom) == true) goto L23;
        r100.setMapZoomer(this.zoom);
    L23:
        if (Float.isNaN(this.bearing) == true) goto L26;
        r100.setMapAngle(this.bearing);
    L26:
        if (Float.isNaN(this.tilt) == true) goto L28;
        r100.setCameraDegree(this.tilt);
    L28:
        Point r107 = this.focus;
        if (r107 == null) goto L31;
        changeCenterByAnchor(r100, this.geoPoint, r107.x, r107.y);
        return;
    L31:
        DPoint r108 = this.geoPoint;
        if (r108 != null) goto L34;
    L38:
        boolean r109 = false;
    L39:
        if (r109 == false) goto L43;
        r100.setMapGeoCenter(r108.f30021x, r108.f30022y);
        return;
    L43:
        return;
    L34:
        if (r108.f30021x == AudioStats.AUDIO_AMPLITUDE_NONE) goto L36;
    L37:
        r109 = true;
        goto L39
    L36:
        if (r108.f30022y == AudioStats.AUDIO_AMPLITUDE_NONE) goto L38;
    L13:
        r103 = this.tilt;
        goto L14
    L9:
        r102 = this.bearing;
        goto L10
    L5:
        r101 = this.zoom;
        goto L6
    }

    public void changeCenterByAnchor(IGLMapState r100, DPoint r101) {
        changeCenterByAnchor(r100, r101, this.anchorX, this.anchorY);
    }

    public Point getAnchorGeoPoint(IGLMapState r100, int r101, int r102) {
        Point r103 = new Point();
        r100.screenToP20Point(r101, r102, r103);
        return r103;
    }

    public void changeCenterByAnchor(IGLMapState r100, DPoint r101, int r102, int r110) {
        r100.recalculate();
        Point r103 = getAnchorGeoPoint(r100, r102, r110);
        DPoint r111 = r100.getMapGeoCenter();
        r100.setMapGeoCenter((r111.f30021x + r101.f30021x) - ((double) r103.x), (r111.f30022y + r101.f30022y) - ((double) r103.y));
    }
}
