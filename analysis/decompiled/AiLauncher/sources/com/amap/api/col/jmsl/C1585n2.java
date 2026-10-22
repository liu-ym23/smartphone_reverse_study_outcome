package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amap.api.maps.AMapOptions;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.IAMapWebView;
import com.amap.api.maps.UiSettings;
import com.amap.api.maps.model.CameraPosition;

/* renamed from: com.amap.api.col.jmsl.n2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1585n2 implements InterfaceC1588o1 {

    /* renamed from: f, reason: collision with root package name */
    public static volatile Context f16776f;

    /* renamed from: g, reason: collision with root package name */
    public static String f16777g;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16778a;

    /* renamed from: b, reason: collision with root package name */
    public C1601s f16779b;

    /* renamed from: c, reason: collision with root package name */
    public int f16780c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f16781d;

    /* renamed from: e, reason: collision with root package name */
    public AMapOptions f16782e;

    public C1585n2(int i10) {
        this.f16781d = 0;
        C1570k.r();
        this.f16781d = i10 % 5;
        c();
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws RemoteException {
        byte[] byteArray;
        try {
            InterfaceC1552f1 interfaceC1552f1B = b(null);
            this.f16778a = interfaceC1552f1B;
            if (interfaceC1552f1B != null) {
                interfaceC1552f1B.d();
            }
            this.f16778a.L(this.f16780c);
            if (this.f16782e == null && bundle != null && (byteArray = bundle.getByteArray("MAP_OPTIONS")) != null) {
                Parcel parcelObtain = Parcel.obtain();
                parcelObtain.unmarshall(byteArray, 0, byteArray.length);
                parcelObtain.setDataPosition(0);
                this.f16782e = AMapOptions.CREATOR.createFromParcel(parcelObtain);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.f16778a.x();
    }

    public InterfaceC1552f1 b(IAMapWebView iAMapWebView) throws RemoteException {
        C1601s c1601s = this.f16779b;
        if (c1601s == null && c1601s == null) {
            if (f16776f == null) {
                Log.w("MapFragmentDelegateImp", "Context 为 null 请在地图调用之前 使用 MapsInitializer.initialize(Context paramContext) 来设置Context");
            } else if (this.f16781d == 3) {
                C1566j c1566j = new C1566j(f16776f, null);
                C1601s c1601s2 = new C1601s(f16776f, c1566j);
                this.f16779b = c1601s2;
                c1566j.f16668a = c1601s2.f16862a;
            } else {
                this.f16779b = new C1601s(f16776f, iAMapWebView);
            }
        }
        if (this.f16778a == null) {
            this.f16778a = this.f16779b.f16862a;
        }
        return this.f16778a;
    }

    public final void c() {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (int i10 = 0; i10 < 80; i10++) {
                sb2.append("=");
            }
            f16777g = sb2.toString();
        } catch (Throwable unused) {
        }
    }

    public void d(int i10) {
        this.f16780c = i10;
        InterfaceC1552f1 interfaceC1552f1 = this.f16778a;
        if (interfaceC1552f1 != null) {
            interfaceC1552f1.L(i10);
        }
    }

    public void e(Context context) {
        if (context != null) {
            f16776f = context.getApplicationContext();
        }
    }

    public void f(Bundle bundle) throws RemoteException {
        InterfaceC1552f1 interfaceC1552f1 = this.f16778a;
        if (interfaceC1552f1 != null) {
            interfaceC1552f1.d();
        }
    }

    public void g(AMapOptions aMapOptions) throws RemoteException {
        if (aMapOptions == null || this.f16778a == null) {
            return;
        }
        CameraPosition camera = aMapOptions.getCamera();
        if (camera != null) {
            this.f16778a.H(CameraUpdateFactory.newCameraPosition(camera));
        }
        UiSettings uiSettingsK = this.f16778a.k();
        uiSettingsK.setRotateGesturesEnabled(aMapOptions.getRotateGesturesEnabled());
        uiSettingsK.setScrollGesturesEnabled(aMapOptions.getScrollGesturesEnabled());
        uiSettingsK.setTiltGesturesEnabled(aMapOptions.getTiltGesturesEnabled());
        uiSettingsK.setZoomGesturesEnabled(aMapOptions.getZoomGesturesEnabled());
        this.f16778a.f(aMapOptions.getMapType());
    }

    public void h() {
        try {
            g(this.f16782e);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void i(Bundle bundle) throws RemoteException {
        if (this.f16778a != null) {
            if (this.f16782e == null) {
                this.f16782e = new AMapOptions();
            }
            try {
                Parcel parcelObtain = Parcel.obtain();
                AMapOptions aMapOptionsCamera = this.f16782e.camera(b(null).c());
                this.f16782e = aMapOptionsCamera;
                aMapOptionsCamera.writeToParcel(parcelObtain, 0);
                bundle.putByteArray("MAP_OPTIONS", parcelObtain.marshall());
            } catch (Throwable unused) {
            }
        }
    }

    public void j(AMapOptions aMapOptions) {
        this.f16782e = aMapOptions;
    }

    public void k() throws RemoteException {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            for (int i10 = 0; i10 < stackTrace.length; i10++) {
                if (stackTrace[i10].getClassName() != null && stackTrace[i10].getClassName().endsWith("TextureMapView")) {
                    z11 = true;
                }
                if (stackTrace[i10].getClassName() != null && stackTrace[i10].getClassName().endsWith("Fragment")) {
                    z10 = true;
                }
                if ("OnDestroyView".equalsIgnoreCase(stackTrace[i10].getMethodName())) {
                    z12 = true;
                }
            }
            if (z10 && z11 && !z12) {
                Log.i("errorLog", f16777g);
                Log.i("errorLog", "OnDestroy 方法需要在OnDestroyView中调用");
                Log.i("errorLog", f16777g);
            }
        } catch (Throwable unused) {
        }
        InterfaceC1552f1 interfaceC1552f1 = this.f16778a;
        if (interfaceC1552f1 != null) {
            interfaceC1552f1.clear();
            this.f16778a.destroy();
            this.f16778a = null;
        }
    }

    public void l() throws RemoteException {
        InterfaceC1552f1 interfaceC1552f1 = this.f16778a;
        if (interfaceC1552f1 != null) {
            interfaceC1552f1.f();
        }
    }

    public void m() throws RemoteException {
        InterfaceC1552f1 interfaceC1552f1 = this.f16778a;
        if (interfaceC1552f1 != null) {
            interfaceC1552f1.i();
        }
    }
}
