package com.amap.api.maps;

import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.col.jmsl.InterfaceC1552f1;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class AMap {
    private static final String CLASSNAME = "AMap";
    public static final int MAP_TYPE_NIGHT = 3;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    private final InterfaceC1552f1 mapDelegate;
    private Projection projection;
    private UiSettings uiSettings;

    public interface CommonInfoWindowAdapter {
        InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay);
    }

    public interface InfoWindowAdapter {
        View getInfoContents(Marker marker);

        View getInfoWindow(Marker marker);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(CameraPosition cameraPosition);

        void onCameraChangeFinish(CameraPosition cameraPosition);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(Marker marker);
    }

    public interface OnMapClickListener {
        void onMapClick(LatLng latLng);
    }

    public interface OnMapLongClickListener {
        void onMapLongClick(LatLng latLng);
    }

    public interface OnMapReadyListener {
        void onMapReady(AMap aMap);
    }

    public interface OnMapTouchListener {
        void onTouch(MotionEvent motionEvent);
    }

    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMarkerDragListener {
        void onMarkerDrag(Marker marker);

        void onMarkerDragEnd(Marker marker);

        void onMarkerDragStart(Marker marker);
    }

    public interface OnMyLocationChangeListener {
        void onMyLocationChange(Location location);
    }

    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public AMap(InterfaceC1552f1 interfaceC1552f1) {
        this.mapDelegate = interfaceC1552f1;
    }

    public final Circle addCircle(CircleOptions circleOptions) {
        try {
            return this.mapDelegate.N(circleOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Marker addMarker(MarkerOptions markerOptions) {
        try {
            return this.mapDelegate.J(markerOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ArrayList<Marker> addMarkers(ArrayList<MarkerOptions> arrayList, boolean z10) {
        try {
            return this.mapDelegate.D(arrayList, z10);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polygon addPolygon(PolygonOptions polygonOptions) {
        try {
            return this.mapDelegate.s(polygonOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Polyline addPolyline(PolylineOptions polylineOptions) {
        try {
            return this.mapDelegate.G(polylineOptions);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.F(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clear() {
        try {
            this.mapDelegate.clear();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final CameraPosition getCameraPosition() {
        try {
            return this.mapDelegate.c();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getMapContentApprovalNumber() {
        try {
            return this.mapDelegate.v();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final int getMapType() {
        try {
            return this.mapDelegate.Q();
        } catch (Throwable th) {
            th.printStackTrace();
            return 1;
        }
    }

    public final float getMaxZoomLevel() {
        return this.mapDelegate.n();
    }

    public final float getMinZoomLevel() {
        return this.mapDelegate.e();
    }

    public final Location getMyLocation() {
        try {
            return this.mapDelegate.m();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final MyLocationStyle getMyLocationStyle() {
        try {
            return this.mapDelegate.g();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final Projection getProjection() {
        try {
            if (this.projection == null) {
                this.projection = this.mapDelegate.a();
            }
            return this.projection;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public String getSatelliteImageApprovalNumber() {
        try {
            return this.mapDelegate.b();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final UiSettings getUiSettings() {
        try {
            if (this.uiSettings == null) {
                this.uiSettings = this.mapDelegate.k();
            }
            return this.uiSettings;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        try {
            this.mapDelegate.H(cameraUpdate);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            this.mapDelegate.C(infoWindowAdapter);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            this.mapDelegate.E(locationSource);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMapStatusLimits(LatLngBounds latLngBounds) {
        try {
            this.mapDelegate.y(latLngBounds);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMapType(int i10) {
        try {
            this.mapDelegate.f(i10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setMaxZoomLevel(float f10) {
        this.mapDelegate.K(f10);
    }

    public void setMinZoomLevel(float f10) {
        this.mapDelegate.I(f10);
    }

    public final void setMyLocationEnabled(boolean z10) {
        try {
            this.mapDelegate.i(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMyLocationStyle(MyLocationStyle myLocationStyle) {
        try {
            this.mapDelegate.R(myLocationStyle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            this.mapDelegate.o(onCameraChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            this.mapDelegate.z(onInfoWindowClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            this.mapDelegate.B(onMapClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            this.mapDelegate.r(onMapLongClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMapTouchListener(OnMapTouchListener onMapTouchListener) {
        try {
            this.mapDelegate.u(onMapTouchListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            this.mapDelegate.w(onMarkerClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            this.mapDelegate.M(onMarkerDragListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            this.mapDelegate.q(onMyLocationChangeListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            this.mapDelegate.t(onPolylineClickListener);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setTrafficEnabled(boolean z10) {
        try {
            this.mapDelegate.b(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showBuildings(boolean z10) {
        try {
            this.mapDelegate.j(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showMapText(boolean z10) {
        try {
            this.mapDelegate.a(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void clear(boolean z10) {
        try {
            this.mapDelegate.k(z10);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
