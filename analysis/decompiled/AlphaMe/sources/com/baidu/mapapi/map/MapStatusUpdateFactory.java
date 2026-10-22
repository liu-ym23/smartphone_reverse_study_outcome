package com.baidu.mapapi.map;

import android.graphics.Point;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;

/* loaded from: classes.dex */
public final class MapStatusUpdateFactory {
    public static MapStatusUpdate newLatLng(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(2);
        mapStatusUpdate.f6530d = latLng;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(3);
        mapStatusUpdate.f6531e = latLngBounds;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLng latLng, float f4) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(4);
        if (latLng == null) {
            return null;
        }
        mapStatusUpdate.f6530d = latLng;
        mapStatusUpdate.f6534h = f4;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newMapStatus(MapStatus mapStatus) {
        if (mapStatus == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(1);
        mapStatusUpdate.f6529c = mapStatus;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate scrollBy(int i4, int i5) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(5);
        mapStatusUpdate.f6535i = i4;
        mapStatusUpdate.f6536j = i5;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f4) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6537k = f4;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomIn() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6537k = 1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomOut() {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(6);
        mapStatusUpdate.f6537k = -1.0f;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomTo(float f4) {
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(8);
        mapStatusUpdate.f6534h = f4;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4, int i5) {
        if (latLngBounds == null || i4 <= 0 || i5 <= 0) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(9);
        mapStatusUpdate.f6531e = latLngBounds;
        mapStatusUpdate.f6532f = i4;
        mapStatusUpdate.f6533g = i5;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate zoomBy(float f4, Point point) {
        if (point == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(7);
        mapStatusUpdate.f6537k = f4;
        mapStatusUpdate.f6538l = point;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngZoom(LatLngBounds latLngBounds, int i4, int i5, int i6, int i7) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(11);
        mapStatusUpdate.f6531e = latLngBounds;
        mapStatusUpdate.f6539m = i4;
        mapStatusUpdate.f6540n = i5;
        mapStatusUpdate.f6541o = i6;
        mapStatusUpdate.f6542p = i7;
        return mapStatusUpdate;
    }

    public static MapStatusUpdate newLatLngBounds(LatLngBounds latLngBounds, int i4, int i5, int i6, int i7) {
        if (latLngBounds == null) {
            return null;
        }
        MapStatusUpdate mapStatusUpdate = new MapStatusUpdate(10);
        mapStatusUpdate.f6531e = latLngBounds;
        mapStatusUpdate.f6539m = i4;
        mapStatusUpdate.f6540n = i5;
        mapStatusUpdate.f6541o = i6;
        mapStatusUpdate.f6542p = i7;
        return mapStatusUpdate;
    }
}
