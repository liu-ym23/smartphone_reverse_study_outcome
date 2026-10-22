package com.byted.mgl.merge.service.model;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import java.util.List;

/* JADX INFO: loaded from: classes43.dex */
public interface BdpMap {

    public interface GeocoderSearchedListener {
        void onGeocoderSearchedListener(boolean r100, BdpLatLng r101);
    }

    public interface OnCameraChangeListener {
        void onCameraChange(BdpCameraPosition r100);

        void onCameraChangeFinish(BdpCameraPosition r100);
    }

    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(BdpMarkerOptions r100);
    }

    public interface OnLocateChangeListener {
        void onLocationChanged(Location r100, String r101);
    }

    public interface OnMapClickListener {
        void onMapClick(BdpLatLng r100);
    }

    public interface OnMarkerClickListener {
        void onMarkerClick(BdpMarkerOptions r100);
    }

    public interface RegeocodeSearchedListener {
        void onRegeocodeSearchedListener(boolean r100, String r101, String r102);
    }

    public interface SearchRouteCompleteListener {
        void onSearchRouteComplete();
    }

    void addCircle(BdpCircleOptions r100);

    void addMarker(BdpMarkerOptions r100);

    void addPolyline(BdpPolylineOptions r100);

    void cleanCircles();

    void cleanMarkers();

    void cleanPolyLines();

    View createMapView(Activity r100);

    BdpLatLng getCenterLocation();

    BdpVisibleRegion getRegion();

    double getRotate();

    double getScale();

    double getSkew();

    void includePoints(List<BdpLatLng> r100);

    boolean isMyLocationShowing();

    boolean isRouteOverlayShowing();

    void moveCameraToLatLng(BdpLatLng r100);

    void onActivityCreated(Bundle r100);

    void onDestroy();

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle r100);

    void queryAddressNameByLatLng(BdpLatLng r100, RegeocodeSearchedListener r101);

    void queryLatLngByAddressName(String r100, GeocoderSearchedListener r101);

    void removeRouteOverlay();

    void searchRouteAndShowOverlay(BdpLatLng r100, BdpLatLng r101, SearchRouteCompleteListener r102);

    void setHasGrantLocatingPermission(boolean r100);

    void setMyLocatePointStyle(BdpLocatePointStyle r100);

    void setOnCameraChangeListener(OnCameraChangeListener r100);

    void setOnInfoWindowClickListener(OnInfoWindowClickListener r100);

    void setOnLocationChangedListener(OnLocateChangeListener r100);

    void setOnMapClickListener(OnMapClickListener r100);

    void setOnMarkerClickListener(OnMarkerClickListener r100);

    void setScale(double r100);

    void showLocateBluePoint(Location r100);

    void startLocation();

    void stopLocation();
}
