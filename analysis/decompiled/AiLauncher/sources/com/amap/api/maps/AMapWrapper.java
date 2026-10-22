package com.amap.api.maps;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.amap.api.col.jmsl.C1585n2;
import com.amap.api.col.jmsl.InterfaceC1552f1;
import com.amap.api.col.jmsl.InterfaceC1588o1;
import com.amap.api.maps.AMap;

/* loaded from: classes.dex */
public class AMapWrapper {
    private AMap aMap;
    private InterfaceC1552f1 localAMapDelegate;
    private InterfaceC1588o1 mapFragmentDelegate;

    public class a implements AMap.OnMapReadyListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AMap.OnMapReadyListener f17214a;

        public a(AMap.OnMapReadyListener onMapReadyListener) {
            this.f17214a = onMapReadyListener;
        }

        @Override // com.amap.api.maps.AMap.OnMapReadyListener
        public void onMapReady(AMap aMap) {
            AMap.OnMapReadyListener onMapReadyListener = this.f17214a;
            if (onMapReadyListener != null) {
                onMapReadyListener.onMapReady(AMapWrapper.this.aMap);
            }
        }
    }

    public AMapWrapper(Context context, IAMapWebView iAMapWebView) {
        C1585n2 c1585n2 = (C1585n2) getMapFragmentDelegate();
        c1585n2.e(context);
        try {
            InterfaceC1552f1 interfaceC1552f1B = c1585n2.b(iAMapWebView);
            this.localAMapDelegate = interfaceC1552f1B;
            this.aMap = new AMap(interfaceC1552f1B);
            iAMapWebView.addView(this.localAMapDelegate.x(), new ViewGroup.LayoutParams(-1, -1));
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public void getMapAsyn(AMap.OnMapReadyListener onMapReadyListener) {
        try {
            this.localAMapDelegate.A(new a(onMapReadyListener));
        } catch (Throwable unused) {
        }
    }

    public InterfaceC1588o1 getMapFragmentDelegate() {
        if (this.mapFragmentDelegate == null) {
            this.mapFragmentDelegate = new C1585n2(4);
        }
        return this.mapFragmentDelegate;
    }

    public final void onCreate() {
        try {
            ((C1585n2) getMapFragmentDelegate()).f(null);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
    }

    public final void onDestroy() {
        try {
            ((C1585n2) getMapFragmentDelegate()).k();
            this.aMap = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onLowMemory() {
        try {
            ((C1585n2) getMapFragmentDelegate()).getClass();
            Log.d("onLowMemory", "onLowMemory run");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onPause() {
        try {
            ((C1585n2) getMapFragmentDelegate()).l();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onResume() {
        try {
            ((C1585n2) getMapFragmentDelegate()).m();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        try {
            ((C1585n2) getMapFragmentDelegate()).i(bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1552f1 interfaceC1552f1 = this.localAMapDelegate;
        if (interfaceC1552f1 != null) {
            return interfaceC1552f1.p(motionEvent);
        }
        return false;
    }
}
