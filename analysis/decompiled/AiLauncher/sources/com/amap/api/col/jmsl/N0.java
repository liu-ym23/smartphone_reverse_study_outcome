package com.amap.api.col.jmsl;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapCallback;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.IAMapWebView;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.MapsInitializer;
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
import com.autonavi.amap.mapcore.AMapJSCallBack;
import com.autonavi.amap.mapcore.AmapDelegateListenerManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class N0 implements InterfaceC1552f1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f16200a;

    /* renamed from: b, reason: collision with root package name */
    public final IAMapWebView f16201b;

    /* renamed from: c, reason: collision with root package name */
    public final V0 f16202c;

    /* renamed from: d, reason: collision with root package name */
    public final AMapJSCallBack f16203d;

    /* renamed from: e, reason: collision with root package name */
    public final C1548e1 f16204e;

    /* renamed from: f, reason: collision with root package name */
    public final W1 f16205f;

    /* renamed from: g, reason: collision with root package name */
    public final P1 f16206g;

    /* renamed from: h, reason: collision with root package name */
    public UiSettings f16207h;

    /* renamed from: i, reason: collision with root package name */
    public Projection f16208i;

    /* renamed from: k, reason: collision with root package name */
    public Thread f16210k;

    /* renamed from: n, reason: collision with root package name */
    public C1620w2 f16213n;

    /* renamed from: o, reason: collision with root package name */
    public X0 f16214o;

    /* renamed from: p, reason: collision with root package name */
    public P0 f16215p;

    /* renamed from: q, reason: collision with root package name */
    public E0 f16216q;

    /* renamed from: r, reason: collision with root package name */
    public F0 f16217r;

    /* renamed from: j, reason: collision with root package name */
    public AmapDelegateListenerManager f16209j = new AmapDelegateListenerManager();

    /* renamed from: l, reason: collision with root package name */
    public boolean f16211l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16212m = false;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f16218s = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (N0.this.f16212m) {
                return;
            }
            if (message.what == 1) {
                N0.this.d();
            }
            super.handleMessage(message);
        }
    }

    public class b implements AMapCallback<Boolean> {
        public b() {
        }

        @Override // com.amap.api.maps.AMapCallback
        public void onCallback(Boolean bool) {
            if (bool.booleanValue()) {
                N0.this.f16202c.o();
            }
        }
    }

    public N0(IAMapWebView iAMapWebView, Context context) {
        if (C1623x1.f17030a) {
            C1570k.i("JAVA对象初始化:");
        }
        Context applicationContext = context.getApplicationContext();
        this.f16200a = applicationContext;
        this.f16201b = iAMapWebView;
        G1.b(applicationContext.getResources().getDisplayMetrics().density);
        C1548e1 c1548e1 = new C1548e1(applicationContext);
        this.f16204e = c1548e1;
        U();
        V0 v02 = new V0(iAMapWebView, MapsInitializer.isContainsJsMapAssets());
        this.f16202c = v02;
        W1 w12 = new W1(this, v02, c1548e1.e());
        this.f16205f = w12;
        P1 p12 = new P1(this, w12);
        this.f16206g = p12;
        this.f16203d = new AMapJSCallBack(applicationContext, this.f16209j, w12, p12, v02);
        W();
        this.f16214o = new X0(applicationContext, this, w12);
        P0 p02 = new P0(applicationContext);
        this.f16215p = p02;
        p02.i(this.f16214o);
        w12.d(this.f16215p);
        V();
        if (C1623x1.f17030a) {
            C1570k.i("JAVA对象初始化完成:");
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void A(AMap.OnMapReadyListener onMapReadyListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMapReadyListener.class.hashCode(), onMapReadyListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void B(AMap.OnMapClickListener onMapClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMapClickListener.class.hashCode(), onMapClickListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void C(AMap.InfoWindowAdapter infoWindowAdapter) throws RemoteException {
        P0 p02;
        if (this.f16212m || (p02 = this.f16215p) == null) {
            return;
        }
        p02.j(infoWindowAdapter);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public ArrayList<Marker> D(ArrayList<MarkerOptions> arrayList, boolean z10) throws RemoteException {
        try {
            ArrayList<Marker> arrayList2 = new ArrayList<>();
            LatLngBounds.Builder builder = LatLngBounds.builder();
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                MarkerOptions markerOptions = arrayList.get(i10);
                if (arrayList.get(i10) != null) {
                    arrayList2.add(J(markerOptions));
                    if (markerOptions.getPosition() != null) {
                        builder.include(markerOptions.getPosition());
                    }
                }
            }
            if (z10 && arrayList2.size() > 0) {
                H(CameraUpdateFactory.newLatLngBounds(builder.build(), 50));
            }
            return arrayList2;
        } catch (Throwable th) {
            C1570k.j(th);
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void E(LocationSource locationSource) throws RemoteException {
        if (this.f16212m) {
            return;
        }
        this.f16213n.c(locationSource);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void F(CameraUpdate cameraUpdate) throws RemoteException {
        V0 v02 = this.f16202c;
        if (v02 != null) {
            v02.g(cameraUpdate, true, this.f16206g.d().f16607b);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Polyline G(PolylineOptions polylineOptions) throws RemoteException, CloneNotSupportedException {
        PolylineOptions polylineOptionsM16clone = polylineOptions.m16clone();
        this.f16205f.getClass();
        String strL = this.f16205f.l("POLYLINE");
        Polyline polyline = new Polyline(this.f16205f, polylineOptionsM16clone, strL);
        this.f16205f.h(strL, polyline, polylineOptionsM16clone);
        return polyline;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void H(CameraUpdate cameraUpdate) throws RemoteException {
        V0 v02 = this.f16202c;
        if (v02 != null) {
            v02.g(cameraUpdate, false, this.f16206g.d().f16607b);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void I(float f10) {
        this.f16206g.e(f10);
        this.f16202c.d(this.f16206g.g(), this.f16206g.f());
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Marker J(MarkerOptions markerOptions) throws RemoteException, CloneNotSupportedException {
        if (markerOptions == null) {
            return null;
        }
        MarkerOptions markerOptionsM14clone = markerOptions.m14clone();
        this.f16205f.e(markerOptions);
        String strL = this.f16205f.l("MARKER");
        Marker marker = new Marker(this.f16205f, markerOptionsM14clone, strL);
        this.f16205f.h(strL, marker, markerOptionsM14clone);
        return marker;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void K(float f10) {
        this.f16206g.c(f10);
        this.f16202c.d(this.f16206g.g(), this.f16206g.f());
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void L(int i10) {
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void M(AMap.OnMarkerDragListener onMarkerDragListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMarkerDragListener.class.hashCode(), onMarkerDragListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Circle N(CircleOptions circleOptions) throws CloneNotSupportedException {
        CircleOptions circleOptionsM12clone = circleOptions.m12clone();
        String strL = this.f16205f.l("CIRCLE");
        Circle circle = new Circle(this.f16205f, circleOptionsM12clone, strL);
        this.f16205f.h(strL, circle, circleOptionsM12clone);
        return circle;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void O() {
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void P(String str, String str2, int i10) throws Throwable {
        C1548e1 c1548e1 = this.f16204e;
        if (c1548e1 != null) {
            c1548e1.g(str, str2, i10, new b());
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public int Q() throws RemoteException {
        E0 e02 = this.f16216q;
        if (e02 != null) {
            return e02.a();
        }
        return 1;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void R(MyLocationStyle myLocationStyle) throws RemoteException {
        if (this.f16212m) {
            return;
        }
        this.f16213n.d(myLocationStyle);
    }

    public View T() {
        Object obj = this.f16201b;
        if (obj instanceof View) {
            return (View) obj;
        }
        return null;
    }

    public final void U() {
        if (this.f16210k == null) {
            C1584n1 c1584n1 = new C1584n1(this.f16200a, this);
            this.f16210k = c1584n1;
            if (this.f16211l) {
                return;
            }
            try {
                c1584n1.setName("AuthThread");
                this.f16210k.start();
                this.f16211l = true;
            } catch (Throwable th) {
                th.printStackTrace();
                C1570k.j(th);
            }
        }
    }

    public final void V() {
        this.f16207h = new UiSettings(new C1530a(this));
        this.f16208i = new Projection(new L2(this, this.f16202c));
        this.f16213n = new C1620w2(this, this.f16209j);
        Context context = this.f16200a;
        this.f16216q = new E0(this, context, this.f16202c);
        this.f16217r = new F0(this, context, this.f16209j, this.f16205f);
    }

    public final void W() {
        IAMapWebView iAMapWebView = this.f16201b;
        if (iAMapWebView == null) {
            return;
        }
        iAMapWebView.addAMapJavascriptInterface(this.f16203d, "amapjs");
        this.f16201b.setWebViewClient(this.f16204e);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void a(boolean z10) {
        this.f16202c.t(z10);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void b(boolean z10) throws RemoteException {
        this.f16202c.y(z10);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void clear() throws RemoteException {
        this.f16205f.j(null);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void d() {
        if (this.f16202c != null) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.f16202c.b();
            } else {
                this.f16218s.hasMessages(1);
            }
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void destroy() {
        this.f16212m = true;
        this.f16205f.j(null);
        this.f16202c.s();
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public float e() {
        return this.f16206g.g();
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void f() {
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public MyLocationStyle g() throws RemoteException {
        C1620w2 c1620w2 = this.f16213n;
        if (c1620w2 != null) {
            return c1620w2.f();
        }
        return null;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void h(String str) {
        this.f16205f.q(str);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void i() {
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void j(boolean z10) {
        this.f16202c.r(z10);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void k(boolean z10) throws RemoteException {
        C1620w2 c1620w2 = this.f16213n;
        if (c1620w2 != null) {
            this.f16205f.j(c1620w2.g());
        } else {
            this.f16205f.j(null);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void l(boolean z10) {
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Location m() throws RemoteException {
        C1620w2 c1620w2 = this.f16213n;
        if (c1620w2 != null) {
            return c1620w2.a();
        }
        return null;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public float n() {
        return this.f16206g.f();
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void o(AMap.OnCameraChangeListener onCameraChangeListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnCameraChangeListener.class.hashCode(), onCameraChangeListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public boolean p(MotionEvent motionEvent) {
        this.f16217r.d(motionEvent);
        return false;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void q(AMap.OnMyLocationChangeListener onMyLocationChangeListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMyLocationChangeListener.class.hashCode(), onMyLocationChangeListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void r(AMap.OnMapLongClickListener onMapLongClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMapLongClickListener.class.hashCode(), onMapLongClickListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Polygon s(PolygonOptions polygonOptions) throws RemoteException, CloneNotSupportedException {
        PolygonOptions polygonOptionsM15clone = polygonOptions.m15clone();
        String strL = this.f16205f.l("POLYGON");
        Polygon polygon = new Polygon(this.f16205f, polygonOptionsM15clone, strL);
        this.f16205f.h(strL, polygon, polygonOptionsM15clone);
        return polygon;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void t(AMap.OnPolylineClickListener onPolylineClickListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnPolylineClickListener.class.hashCode(), onPolylineClickListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void u(AMap.OnMapTouchListener onMapTouchListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMapTouchListener.class.hashCode(), onMapTouchListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public String v() {
        E0 e02 = this.f16216q;
        if (e02 == null || e02.c()) {
            return null;
        }
        Z2.b(this.f16200a);
        String str = (String) r.b(this.f16200a, "approval_number", "mc", "");
        return !TextUtils.isEmpty(str) ? str : "GS(2019)6379号";
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void w(AMap.OnMarkerClickListener onMarkerClickListener) {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnMarkerClickListener.class.hashCode(), onMarkerClickListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public View x() throws RemoteException {
        X0 x02 = this.f16214o;
        x02.getClass();
        return x02;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void y(LatLngBounds latLngBounds) {
        if (latLngBounds != null) {
            this.f16202c.h(latLngBounds.northeast, latLngBounds.southwest);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void z(AMap.OnInfoWindowClickListener onInfoWindowClickListener) throws RemoteException {
        AmapDelegateListenerManager amapDelegateListenerManager = this.f16209j;
        if (amapDelegateListenerManager != null) {
            amapDelegateListenerManager.setListener(AMap.OnInfoWindowClickListener.class.hashCode(), onInfoWindowClickListener);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public Projection a() throws RemoteException {
        return this.f16208i;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public String b() {
        Z2.f(this.f16200a);
        String str = (String) r.b(this.f16200a, "approval_number", "si", "");
        return !TextUtils.isEmpty(str) ? str : "GS(2020)617号";
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public CameraPosition c() throws RemoteException {
        return this.f16206g.a();
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void f(int i10) {
        E0 e02 = this.f16216q;
        if (e02 != null) {
            e02.b(i10);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void i(boolean z10) throws RemoteException {
        if (this.f16212m) {
            return;
        }
        this.f16213n.e(z10);
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public V0 l() {
        return this.f16202c;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public void m(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            this.f16218s.post(runnable);
        }
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1552f1
    public UiSettings k() throws RemoteException {
        return this.f16207h;
    }
}
