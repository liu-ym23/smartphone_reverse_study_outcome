package com.amap.api.col.jmsl;

import android.location.Location;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.Projection;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.maps.model.Polygon;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.Polyline;
import com.amap.api.maps.model.PolylineOptions;
import java.util.ArrayList;

/* renamed from: com.amap.api.col.jmsl.f1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public interface InterfaceC1552f1 {
    void A(AMap.OnMapReadyListener onMapReadyListener) throws RemoteException;

    void B(AMap.OnMapClickListener onMapClickListener) throws RemoteException;

    void C(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException;

    ArrayList<Marker> D(ArrayList<MarkerOptions> arrayList, boolean z10) throws RemoteException;

    void E(LocationSource locationSource) throws RemoteException;

    void F(CameraUpdate cameraUpdate) throws RemoteException;

    Polyline G(PolylineOptions polylineOptions) throws RemoteException;

    void H(CameraUpdate cameraUpdate) throws RemoteException;

    void I(float f10);

    Marker J(MarkerOptions markerOptions) throws RemoteException;

    void K(float f10);

    void L(int i10);

    void M(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException;

    Circle N(CircleOptions circleOptions);

    void O();

    void P(String str, String str2, int i10);

    int Q() throws RemoteException;

    void R(MyLocationStyle myLocationStyle) throws RemoteException;

    Projection a() throws RemoteException;

    void a(boolean z10);

    String b();

    void b(boolean z10) throws RemoteException;

    CameraPosition c() throws RemoteException;

    void clear() throws RemoteException;

    void d();

    void destroy();

    float e();

    void f();

    void f(int i10);

    MyLocationStyle g() throws RemoteException;

    void h(String str);

    void i();

    void i(boolean z10) throws RemoteException;

    void j(boolean z10);

    UiSettings k() throws RemoteException;

    void k(boolean z10) throws RemoteException;

    V0 l();

    void l(boolean z10);

    Location m() throws RemoteException;

    void m(Runnable runnable);

    float n();

    void o(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException;

    boolean p(MotionEvent motionEvent);

    void q(AMap.OnMyLocationChangeListener onMyLocationChangeListener) throws RemoteException;

    void r(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException;

    Polygon s(PolygonOptions polygonOptions) throws RemoteException;

    void t(AMap.OnPolylineClickListener onPolylineClickListener);

    void u(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException;

    String v();

    void w(AMap.OnMarkerClickListener onMarkerClickListener);

    View x() throws RemoteException;

    void y(LatLngBounds latLngBounds);

    void z(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException;
}
