package com.amap.api.col.jmsl;

import android.graphics.Point;
import android.os.RemoteException;
import android.webkit.ValueCallback;
import com.amap.api.maps.AMapCallback;
import com.amap.api.maps.model.LatLng;
import com.autonavi.aps.amapapi.config.Const;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class L2 implements InterfaceC1627y1 {

    /* renamed from: a, reason: collision with root package name */
    public final V0 f16184a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC1552f1 f16185b;

    public class a implements ValueCallback<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AMapCallback f16186a;

        public a(L2 l22, AMapCallback aMapCallback) {
            this.f16186a = aMapCallback;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            LatLng latLng;
            String str2 = str;
            try {
                AMapCallback aMapCallback = this.f16186a;
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    latLng = new LatLng(jSONObject.optDouble(Const.JSON_KEY_LAT), jSONObject.optDouble("lng"));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                    latLng = null;
                }
                aMapCallback.onCallback(latLng);
            } catch (Exception e11) {
                e11.printStackTrace();
                this.f16186a.onCallback(null);
            }
        }
    }

    public class b implements ValueCallback<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AMapCallback f16187a;

        public b(L2 l22, AMapCallback aMapCallback) {
            this.f16187a = aMapCallback;
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(String str) {
            Point point;
            try {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    point = new Point((int) jSONObject.optDouble("x"), (int) jSONObject.optDouble("y"));
                } catch (JSONException e10) {
                    e10.printStackTrace();
                    point = null;
                }
                point.x = (int) (point.x * G1.a());
                point.y = (int) (point.y * G1.a());
                this.f16187a.onCallback(point);
            } catch (Exception e11) {
                e11.printStackTrace();
                this.f16187a.onCallback(null);
            }
        }
    }

    public L2(InterfaceC1552f1 interfaceC1552f1, V0 v02) {
        this.f16185b = interfaceC1552f1;
        this.f16184a = v02;
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1627y1
    public void a(LatLng latLng, AMapCallback<Point> aMapCallback) throws RemoteException {
        this.f16184a.c(latLng.latitude, latLng.longitude, new b(this, aMapCallback));
    }

    @Override // com.amap.api.col.jmsl.InterfaceC1627y1
    public void b(Point point, AMapCallback<LatLng> aMapCallback) throws RemoteException {
        if (point == null) {
            return;
        }
        this.f16184a.e(point.x / G1.a(), point.y / G1.a(), new a(this, aMapCallback));
    }
}
