package com.amap.api.col.jmsl;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.IAMapWebView;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonFactory;

/* loaded from: classes.dex */
public class V0 {

    /* renamed from: a, reason: collision with root package name */
    public final IAMapWebView f16380a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f16381b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16382c = false;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16383d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16384e = false;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                if (message.what == 1) {
                    V0.this.f16380a.evaluateJavascript(message.getData().getString("js_call_key"), (ValueCallback) message.obj);
                } else {
                    if (V0.this.f16380a == null || message.obj == null) {
                        return;
                    }
                    V0.this.f16380a.loadUrl(message.obj.toString());
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public V0(IAMapWebView iAMapWebView, boolean z10) {
        this.f16381b = null;
        this.f16380a = iAMapWebView;
        this.f16381b = new a(Looper.getMainLooper());
        if (z10) {
            o();
        }
    }

    public void b() {
        if (!this.f16382c) {
            this.f16383d = true;
        } else {
            l("createMap", new Object[0]);
            this.f16383d = false;
        }
    }

    public void c(double d10, double d11, ValueCallback<String> valueCallback) {
        j("lngLatToScreen", valueCallback, new C1589o2(String.format("[%s,%s]", Double.valueOf(d11), Double.valueOf(d10))));
    }

    public void d(float f10, float f11) {
        l("setZooms", Float.valueOf(f10), Float.valueOf(f11));
    }

    public void e(float f10, float f11, ValueCallback<String> valueCallback) {
        j("screenToLngLat", valueCallback, new C1589o2(String.format("[%s,%s]", Float.valueOf(f10), Float.valueOf(f11))));
    }

    public void f(int i10, String str) {
        l("setMapStyle", Integer.valueOf(i10), "");
    }

    public void g(CameraUpdate cameraUpdate, boolean z10, float f10) {
        if (cameraUpdate == null || cameraUpdate.getCameraUpdateFactoryDelegate() == null) {
            return;
        }
        int iOrdinal = cameraUpdate.getCameraUpdateFactoryDelegate().nowType.ordinal();
        if (iOrdinal == 1 || iOrdinal == 7 || iOrdinal == 9) {
            cameraUpdate = CameraUpdateFactory.zoomTo(f10 + cameraUpdate.getCameraUpdateFactoryDelegate().amount);
            l("moveCamera", cameraUpdate.toString(), Boolean.valueOf(z10));
        } else if (iOrdinal == 12 || iOrdinal == 13) {
            l("setBounds", cameraUpdate.getCameraUpdateFactoryDelegate().bounds.northeast, cameraUpdate.getCameraUpdateFactoryDelegate().bounds.southwest, Boolean.valueOf(z10), new C1589o2(String.format("[%s,%s,%s,%s]", Float.valueOf(cameraUpdate.getCameraUpdateFactoryDelegate().paddingTop / G1.a()), Float.valueOf(cameraUpdate.getCameraUpdateFactoryDelegate().paddingBottom / G1.a()), Float.valueOf(cameraUpdate.getCameraUpdateFactoryDelegate().paddingLeft / G1.a()), Float.valueOf(cameraUpdate.getCameraUpdateFactoryDelegate().paddingRight / G1.a()))));
            return;
        }
        l("moveCamera", cameraUpdate.toString(), Boolean.valueOf(z10));
    }

    public void h(LatLng latLng, LatLng latLng2) {
        l("setLimitBounds", latLng, latLng2);
    }

    public final void i(String str) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f16380a.loadUrl(str);
            return;
        }
        Message messageObtainMessage = this.f16381b.obtainMessage();
        messageObtainMessage.obj = str;
        this.f16381b.sendMessage(messageObtainMessage);
    }

    public final void j(String str, ValueCallback<String> valueCallback, Object... objArr) {
        if (this.f16380a == null) {
            return;
        }
        String strN = n(str, objArr);
        if (C1623x1.f17030a) {
            r.f(111, V0.class.getSimpleName(), "callJsWithCallback", strN);
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.f16380a.evaluateJavascript(strN, valueCallback);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("js_call_key", strN);
        Message messageObtainMessage = this.f16381b.obtainMessage();
        messageObtainMessage.setData(bundle);
        messageObtainMessage.obj = valueCallback;
        this.f16381b.sendMessage(messageObtainMessage);
    }

    public void k(String str, String str2) {
        if (str2 == null) {
            return;
        }
        l("addOverlay", str, str2);
    }

    public final void l(String str, Object... objArr) {
        if (this.f16380a == null) {
            return;
        }
        String strN = n(str, objArr);
        if (C1623x1.f17030a) {
            r.f(111, V0.class.getSimpleName(), "callJS", strN);
        }
        i(strN);
    }

    public void m(boolean z10) {
        l("updateMapOptions", "{'touchZoomCenter' : " + z10 + " }");
    }

    public final String n(String str, Object... objArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (objArr != null) {
            int length = objArr.length;
            for (int i10 = 0; i10 < length; i10++) {
                Object obj = objArr[i10];
                if (obj != null) {
                    if (obj instanceof String) {
                        stringBuffer.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                        stringBuffer.append(obj.toString());
                        stringBuffer.append(JsonFactory.DEFAULT_QUOTE_CHAR);
                    } else {
                        stringBuffer.append(obj.toString());
                    }
                    if (i10 != length - 1) {
                        stringBuffer.append(Const.STR_MART_COMMA);
                    }
                }
            }
        }
        return String.format("javascript:%s(%s)", str, stringBuffer.toString());
    }

    public void o() {
        if (this.f16384e) {
            return;
        }
        this.f16384e = true;
        boolean zIsLoadWorldVectorMap = MapsInitializer.isLoadWorldVectorMap();
        String worldVectorMapStyle = MapsInitializer.getWorldVectorMapStyle();
        String mapLanguage = MapsInitializer.getMapLanguage();
        if (zIsLoadWorldVectorMap) {
            i(String.format("file:///android_asset/liteAmap.html?platform=Androidf&foreignStyle=%s&isDebug=%s&isPreLoadWorkerJs=%s&language=%s", worldVectorMapStyle, Boolean.valueOf(MapsInitializer.isDebugMode()), Boolean.valueOf(MapsInitializer.isPreLoadWorkerJS()), mapLanguage));
        } else {
            i(String.format("file:///android_asset/liteAmap.html?platform=Androidf&isDebug=%s&isPreLoadWorkerJs=%s&language=%s", Boolean.valueOf(MapsInitializer.isDebugMode()), Boolean.valueOf(MapsInitializer.isPreLoadWorkerJS()), mapLanguage));
        }
    }

    public void p(String str) {
        if (str == null) {
            return;
        }
        l("removeOverlay", str);
    }

    public void q(String str, String str2) {
        if (!"{}".equals(str2) && !TextUtils.isEmpty(str2)) {
            l("updateOverlay", str, str2);
        } else if (C1623x1.f17030a) {
            r.f(111, V0.class.getSimpleName(), "updateOverlay null json", str2);
        }
    }

    public void r(boolean z10) {
        l("showMapBuilding", Boolean.valueOf(z10));
    }

    public void s() {
        Handler handler = this.f16381b;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        l("destroyMap", new Object[0]);
    }

    public void t(boolean z10) {
        l("showMapLabel", Boolean.valueOf(z10));
    }

    public void u() {
        this.f16382c = true;
        if (this.f16383d) {
            b();
        }
    }

    public void v(boolean z10) {
        l("updateMapOptions", "{'rotateEnable' : " + z10 + " }");
    }

    public void w(boolean z10) {
        l("updateMapOptions", "{'dragEnable' : " + z10 + " }");
    }

    public void x(boolean z10) {
        l("updateMapOptions", "{'pitchEnable' : " + z10 + " }");
    }

    public void y(boolean z10) {
        l("showTraffic", Boolean.valueOf(z10));
    }

    public void z(boolean z10) {
        l("updateMapOptions", "{'zoomEnable' : " + z10 + " }");
    }
}
