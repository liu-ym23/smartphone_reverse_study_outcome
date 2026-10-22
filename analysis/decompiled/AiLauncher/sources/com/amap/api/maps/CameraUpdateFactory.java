package com.amap.api.maps;

import android.graphics.Point;
import android.util.Log;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.camera.CameraUpdateFactoryDelegate;

/* loaded from: classes.dex */
public final class CameraUpdateFactory {
    private static final String CLASSNAME = "CameraUpdateFactory";

    public static CameraUpdate changeBearing(float f10) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.changeBearing(f10 % 360.0f));
    }

    public static CameraUpdate changeLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.changeLatLng(latLng));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate changeTilt(float f10) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.changeTilt(f10));
    }

    public static CameraUpdate newCameraPosition(CameraPosition cameraPosition) {
        if (cameraPosition != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.newCameraPosition(cameraPosition));
        }
        Log.w(CLASSNAME, "cameraPosition is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate newLatLng(LatLng latLng) {
        if (latLng != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.newLatLng(latLng));
        }
        Log.w(CLASSNAME, "latLng is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i10) {
        if (latLngBounds != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.newLatLngBounds(latLngBounds, i10));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate newLatLngBoundsRect(LatLngBounds latLngBounds, int i10, int i11, int i12, int i13) {
        if (latLngBounds != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.newLatLngBoundsRect(latLngBounds, i10, i11, i12, i13));
        }
        Log.w(CLASSNAME, "bounds is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate newLatLngZoom(LatLng latLng, float f10) {
        if (latLng != null) {
            return new CameraUpdate(CameraUpdateFactoryDelegate.newLatLngZoom(latLng, f10));
        }
        Log.w(CLASSNAME, "target is null");
        return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
    }

    public static CameraUpdate zoomBy(float f10) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.zoomBy(f10));
    }

    public static CameraUpdate zoomIn() {
        return new CameraUpdate(CameraUpdateFactoryDelegate.zoomIn());
    }

    public static CameraUpdate zoomOut() {
        return new CameraUpdate(CameraUpdateFactoryDelegate.zoomOut());
    }

    public static CameraUpdate zoomTo(float f10) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.zoomTo(f10));
    }

    public static CameraUpdate zoomBy(float f10, Point point) {
        return new CameraUpdate(CameraUpdateFactoryDelegate.zoomBy(f10, point));
    }

    public static CameraUpdate newLatLngBounds(LatLngBounds latLngBounds, int i10, int i11, int i12) {
        if (latLngBounds == null) {
            Log.w(CLASSNAME, "bounds is null");
            return new CameraUpdate(CameraUpdateFactoryDelegate.newInstance());
        }
        return new CameraUpdate(CameraUpdateFactoryDelegate.newLatLngBoundsWithSize(latLngBounds, i10, i11, i12));
    }
}
