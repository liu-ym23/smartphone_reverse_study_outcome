package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.amap.api.services.interfaces.IGeocodeSearch;
import java.util.List;

/* loaded from: classes.dex */
public final class A2 implements IGeocodeSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f15923a;

    /* renamed from: b, reason: collision with root package name */
    public GeocodeSearch.OnGeocodeSearchListener f15924b;

    /* renamed from: c, reason: collision with root package name */
    public Handler f15925c;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RegeocodeQuery f15926a;

        public a(RegeocodeQuery regeocodeQuery) {
            this.f15926a = regeocodeQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.arg1 = 2;
                    messageObtainMessage.what = 201;
                    HandlerC1626y0.l lVar = new HandlerC1626y0.l();
                    lVar.f17058b = A2.this.f15924b;
                    messageObtainMessage.obj = lVar;
                    lVar.f17057a = new RegeocodeResult(this.f15926a, A2.this.getFromLocation(this.f15926a));
                    messageObtainMessage.arg2 = 1000;
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                A2.this.f15925c.sendMessage(messageObtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GeocodeQuery f15928a;

        public b(GeocodeQuery geocodeQuery) {
            this.f15928a = geocodeQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.what = 200;
                    messageObtainMessage.arg1 = 2;
                    messageObtainMessage.arg2 = 1000;
                    HandlerC1626y0.f fVar = new HandlerC1626y0.f();
                    fVar.f17046b = A2.this.f15924b;
                    messageObtainMessage.obj = fVar;
                    fVar.f17045a = new GeocodeResult(this.f15928a, A2.this.getFromLocationName(this.f15928a));
                } catch (AMapException e10) {
                    messageObtainMessage.arg2 = e10.getErrorCode();
                }
            } finally {
                A2.this.f15925c.sendMessage(messageObtainMessage);
            }
        }
    }

    public A2(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f15923a = context.getApplicationContext();
        this.f15925c = HandlerC1626y0.a();
        C1631z1.l(this.f15923a, "GeocodeSearchCore");
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public RegeocodeAddress getFromLocation(RegeocodeQuery regeocodeQuery) throws AMapException {
        try {
            C1559h0.c(this.f15923a);
            if (regeocodeQuery == null || regeocodeQuery.getPoint() == null || regeocodeQuery.getLatLonType() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new C1578m(this.f15923a, regeocodeQuery).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "GeocodeSearch", "getFromLocationAsyn");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void getFromLocationAsyn(RegeocodeQuery regeocodeQuery) {
        try {
            C1535b0.c().b(new a(regeocodeQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "GeocodeSearch", "getFromLocationAsyn_threadcreate");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public List<GeocodeAddress> getFromLocationName(GeocodeQuery geocodeQuery) throws AMapException {
        try {
            C1559h0.c(this.f15923a);
            if (geocodeQuery != null) {
                return new J(this.f15923a, geocodeQuery).g();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e10) {
            C1631z1.o(e10, "GeocodeSearch", "getFromLocationName");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void getFromLocationNameAsyn(GeocodeQuery geocodeQuery) {
        try {
            C1535b0.c().b(new b(geocodeQuery));
        } catch (Throwable th) {
            C1631z1.o(th, "GeocodeSearch", "getFromLocationNameAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.IGeocodeSearch
    public void setOnGeocodeSearchListener(GeocodeSearch.OnGeocodeSearchListener onGeocodeSearchListener) {
        this.f15924b = onGeocodeSearchListener;
    }
}
