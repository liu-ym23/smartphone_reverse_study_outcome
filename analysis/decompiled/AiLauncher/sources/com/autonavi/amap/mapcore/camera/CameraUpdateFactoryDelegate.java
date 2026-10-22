package com.autonavi.amap.mapcore.camera;

import android.graphics.Point;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.DPoint;

/* loaded from: classes.dex */
public class CameraUpdateFactoryDelegate {
    public static AbstractCameraUpdateMessage changeBearing(float f10) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.bearing = f10;
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage changeBearingGeoCenter(float f10, Point point) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(point.x, point.y);
        abstractCameraPositionMessage.bearing = f10;
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage changeGeoCenter(Point point) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(point.x, point.y);
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage changeGeoCenterZoom(Point point, float f10) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(point.x, point.y);
        abstractCameraPositionMessage.zoom = f10;
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage changeLatLng(LatLng latLng) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = new DPoint(latLng.latitude, latLng.longitude);
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage changeTilt(float f10) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.tilt = f10;
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage newCamera(LatLng latLng, float f10, float f11, float f12) {
        return newCameraPosition(CameraPosition.builder().target(latLng).zoom(f10).bearing(f11).tilt(f12).build());
    }

    public static AbstractCameraUpdateMessage newCameraPosition(CameraPosition cameraPosition) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        if (cameraPosition != null && cameraPosition.target != null) {
            LatLng latLng = cameraPosition.target;
            abstractCameraPositionMessage.geoPoint = new DPoint(latLng.latitude, latLng.longitude);
            abstractCameraPositionMessage.zoom = cameraPosition.zoom;
            abstractCameraPositionMessage.bearing = cameraPosition.bearing;
            abstractCameraPositionMessage.tilt = cameraPosition.tilt;
            abstractCameraPositionMessage.cameraPosition = cameraPosition;
        }
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage newInstance() {
        return new AbstractCameraPositionMessage();
    }

    public static AbstractCameraUpdateMessage newLatLng(LatLng latLng) {
        return newCameraPosition(CameraPosition.builder().target(latLng).zoom(Float.NaN).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage newLatLngBounds(LatLngBounds latLngBounds, int i10) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i10;
        abstractCameraBoundsMessage.paddingRight = i10;
        abstractCameraBoundsMessage.paddingTop = i10;
        abstractCameraBoundsMessage.paddingBottom = i10;
        return abstractCameraBoundsMessage;
    }

    public static AbstractCameraUpdateMessage newLatLngBoundsRect(LatLngBounds latLngBounds, int i10, int i11, int i12, int i13) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBounds;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i10;
        abstractCameraBoundsMessage.paddingRight = i11;
        abstractCameraBoundsMessage.paddingTop = i12;
        abstractCameraBoundsMessage.paddingBottom = i13;
        return abstractCameraBoundsMessage;
    }

    public static AbstractCameraUpdateMessage newLatLngBoundsWithSize(LatLngBounds latLngBounds, int i10, int i11, int i12) {
        AbstractCameraBoundsMessage abstractCameraBoundsMessage = new AbstractCameraBoundsMessage();
        abstractCameraBoundsMessage.nowType = AbstractCameraUpdateMessage.Type.newLatLngBoundsWithSize;
        abstractCameraBoundsMessage.bounds = latLngBounds;
        abstractCameraBoundsMessage.paddingLeft = i12;
        abstractCameraBoundsMessage.paddingRight = i12;
        abstractCameraBoundsMessage.paddingTop = i12;
        abstractCameraBoundsMessage.paddingBottom = i12;
        abstractCameraBoundsMessage.width = i10;
        abstractCameraBoundsMessage.height = i11;
        return abstractCameraBoundsMessage;
    }

    public static AbstractCameraUpdateMessage newLatLngZoom(LatLng latLng, float f10) {
        return newCameraPosition(CameraPosition.builder().target(latLng).zoom(f10).bearing(Float.NaN).tilt(Float.NaN).build());
    }

    public static AbstractCameraUpdateMessage scrollBy(float f10, float f11) {
        AbstractCameraScrollMessage abstractCameraScrollMessage = new AbstractCameraScrollMessage();
        abstractCameraScrollMessage.nowType = AbstractCameraUpdateMessage.Type.scrollBy;
        abstractCameraScrollMessage.xPixel = f10;
        abstractCameraScrollMessage.yPixel = f11;
        return abstractCameraScrollMessage;
    }

    public static AbstractCameraUpdateMessage zoomBy(float f10) {
        return zoomBy(f10, null);
    }

    public static AbstractCameraUpdateMessage zoomIn() {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = 1.0f;
        return abstractCameraZoomMessage;
    }

    public static AbstractCameraUpdateMessage zoomOut() {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = -1.0f;
        return abstractCameraZoomMessage;
    }

    public static AbstractCameraUpdateMessage zoomTo(float f10) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.zoom = f10;
        return abstractCameraPositionMessage;
    }

    public static AbstractCameraUpdateMessage zoomBy(float f10, Point point) {
        AbstractCameraZoomMessage abstractCameraZoomMessage = new AbstractCameraZoomMessage();
        abstractCameraZoomMessage.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
        abstractCameraZoomMessage.amount = f10;
        abstractCameraZoomMessage.focus = point;
        return abstractCameraZoomMessage;
    }

    public static AbstractCameraUpdateMessage newCamera(DPoint dPoint, float f10, float f11, float f12) {
        AbstractCameraPositionMessage abstractCameraPositionMessage = new AbstractCameraPositionMessage();
        abstractCameraPositionMessage.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
        abstractCameraPositionMessage.geoPoint = dPoint;
        abstractCameraPositionMessage.zoom = f10;
        abstractCameraPositionMessage.bearing = f11;
        abstractCameraPositionMessage.tilt = f12;
        return abstractCameraPositionMessage;
    }
}
