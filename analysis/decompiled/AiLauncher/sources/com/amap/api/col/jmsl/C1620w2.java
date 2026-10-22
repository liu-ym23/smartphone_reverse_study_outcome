package com.amap.api.col.jmsl;

import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.LocationSource;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.AmapDelegateListenerManager;
import java.util.List;

/* renamed from: com.amap.api.col.jmsl.w2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1620w2 {

    /* renamed from: a, reason: collision with root package name */
    public E2 f17019a;

    /* renamed from: b, reason: collision with root package name */
    public LocationSource f17020b;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1552f1 f17022d;

    /* renamed from: e, reason: collision with root package name */
    public final AmapDelegateListenerManager f17023e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17021c = false;

    /* renamed from: g, reason: collision with root package name */
    public String[] f17025g = {null, null};

    /* renamed from: f, reason: collision with root package name */
    public a f17024f = new a();

    /* renamed from: com.amap.api.col.jmsl.w2$a */
    public class a implements LocationSource.OnLocationChangedListener {

        /* renamed from: a, reason: collision with root package name */
        public Location f17026a;

        public a() {
        }

        @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
        public void onLocationChanged(Location location) {
            this.f17026a = location;
            try {
                if (C1620w2.this.h()) {
                    C1620w2.this.b(location);
                }
            } catch (Throwable th) {
                C1541c2.b(th, "AMapOnLocationChangedListener", "onLocationChanged");
                th.printStackTrace();
            }
        }
    }

    public C1620w2(InterfaceC1552f1 interfaceC1552f1, AmapDelegateListenerManager amapDelegateListenerManager) {
        this.f17022d = interfaceC1552f1;
        this.f17023e = amapDelegateListenerManager;
    }

    public Location a() throws RemoteException {
        if (this.f17020b != null) {
            return this.f17024f.f17026a;
        }
        return null;
    }

    public void b(Location location) throws RemoteException {
        if (location == null) {
            return;
        }
        try {
            if (this.f17021c && this.f17020b != null) {
                if (this.f17019a == null) {
                    this.f17019a = new E2(this.f17022d, C1585n2.f16776f);
                }
                if (location.getLongitude() != 0.0d && location.getLatitude() != 0.0d) {
                    this.f17019a.c(location);
                }
                List listenerList = this.f17023e.getListenerList(AMap.OnMyLocationChangeListener.class.hashCode());
                if (listenerList == null || listenerList.size() <= 0) {
                    return;
                }
                synchronized (listenerList) {
                    for (int i10 = 0; i10 < listenerList.size(); i10++) {
                        try {
                            ((AMap.OnMyLocationChangeListener) listenerList.get(i10)).onMyLocationChange(location);
                        } finally {
                        }
                    }
                }
                return;
            }
            E2 e22 = this.f17019a;
            if (e22 != null) {
                e22.k();
            }
            this.f17019a = null;
        } catch (Throwable th) {
            C1541c2.b(th, "MyLocationLayer", "showMyLocationOverlay");
            th.printStackTrace();
        }
    }

    public void c(LocationSource locationSource) {
        try {
            LocationSource locationSource2 = this.f17020b;
            if (locationSource2 != null) {
                locationSource2.deactivate();
            }
            this.f17020b = locationSource;
        } catch (Throwable th) {
            C1541c2.b(th, "MyLocationLayer", "setLocationSource");
            th.printStackTrace();
            C1570k.j(th);
        }
    }

    public void d(MyLocationStyle myLocationStyle) {
        try {
            if (this.f17019a == null) {
                this.f17019a = new E2(this.f17022d, C1585n2.f16776f);
            }
            E2 e22 = this.f17019a;
            if (e22 != null) {
                e22.e(myLocationStyle);
            }
        } catch (Throwable th) {
            C1570k.j(th);
        }
    }

    public void e(boolean z10) {
        try {
            LocationSource locationSource = this.f17020b;
            if (locationSource != null) {
                if (z10) {
                    locationSource.activate(this.f17024f);
                    if (this.f17019a == null) {
                        this.f17019a = new E2(this.f17022d, C1585n2.f16776f);
                    }
                } else {
                    E2 e22 = this.f17019a;
                    if (e22 != null) {
                        e22.k();
                        this.f17019a = null;
                    }
                    this.f17020b.deactivate();
                }
            }
            this.f17021c = z10;
        } catch (Throwable th) {
            C1541c2.b(th, "MyLocationLayer", "setMyLocationEnabled");
            th.printStackTrace();
            C1570k.j(th);
        }
    }

    public MyLocationStyle f() {
        E2 e22 = this.f17019a;
        if (e22 == null) {
            return null;
        }
        return e22.h();
    }

    public String[] g() {
        String[] strArr = this.f17025g;
        if (strArr[0] == null && strArr[1] == null) {
            return null;
        }
        return strArr;
    }

    public boolean h() throws RemoteException {
        return this.f17021c;
    }
}
