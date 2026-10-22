package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IWeatherSearch;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

/* loaded from: classes.dex */
public class L implements IWeatherSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f16170a;

    /* renamed from: b, reason: collision with root package name */
    public WeatherSearchQuery f16171b;

    /* renamed from: c, reason: collision with root package name */
    public WeatherSearch.OnWeatherSearchListener f16172c;

    /* renamed from: d, reason: collision with root package name */
    public LocalWeatherLiveResult f16173d;

    /* renamed from: e, reason: collision with root package name */
    public LocalWeatherForecastResult f16174e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f16175f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws AMapException {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 13;
            Bundle bundle = new Bundle();
            if (L.this.f16171b == null) {
                try {
                    throw new AMapException("无效的参数 - IllegalArgumentException");
                } catch (AMapException e10) {
                    C1631z1.o(e10, "WeatherSearch", "searchWeatherAsyn");
                    return;
                }
            }
            if (L.this.f16171b.getType() == 1) {
                try {
                    L l10 = L.this;
                    l10.f16173d = L.e(l10);
                    bundle.putInt("errorCode", 1000);
                    return;
                } catch (AMapException e11) {
                    bundle.putInt("errorCode", e11.getErrorCode());
                    C1631z1.o(e11, "WeatherSearch", "searchWeatherAsyn");
                    return;
                } catch (Throwable th) {
                    C1631z1.o(th, "WeatherSearch", "searchWeatherAnsyThrowable");
                    return;
                } finally {
                    HandlerC1626y0.p pVar = new HandlerC1626y0.p();
                    messageObtainMessage.what = 1301;
                    pVar.f17066b = L.this.f16172c;
                    pVar.f17065a = L.this.f16173d;
                    messageObtainMessage.obj = pVar;
                    messageObtainMessage.setData(bundle);
                    L.this.f16175f.sendMessage(messageObtainMessage);
                }
            }
            if (L.this.f16171b.getType() == 2) {
                try {
                    L l11 = L.this;
                    l11.f16174e = L.i(l11);
                    bundle.putInt("errorCode", 1000);
                } catch (AMapException e12) {
                    bundle.putInt("errorCode", e12.getErrorCode());
                    C1631z1.o(e12, "WeatherSearch", "searchWeatherAsyn");
                } catch (Throwable th2) {
                    C1631z1.o(th2, "WeatherSearch", "searchWeatherAnsyThrowable");
                } finally {
                    HandlerC1626y0.o oVar = new HandlerC1626y0.o();
                    messageObtainMessage.what = 1302;
                    oVar.f17064b = L.this.f16172c;
                    oVar.f17063a = L.this.f16174e;
                    messageObtainMessage.obj = oVar;
                    messageObtainMessage.setData(bundle);
                    L.this.f16175f.sendMessage(messageObtainMessage);
                }
            }
        }
    }

    public L(Context context) throws AMapException {
        this.f16175f = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16170a = context.getApplicationContext();
        this.f16175f = HandlerC1626y0.a();
        C1631z1.l(this.f16170a, "WeatherSearchCore");
    }

    public static LocalWeatherLiveResult e(L l10) throws AMapException {
        C1559h0.c(l10.f16170a);
        WeatherSearchQuery weatherSearchQuery = l10.f16171b;
        if (weatherSearchQuery == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        Z0 z02 = new Z0(l10.f16170a, weatherSearchQuery);
        return LocalWeatherLiveResult.createPagedResult((WeatherSearchQuery) z02.o(), z02.g());
    }

    public static LocalWeatherForecastResult i(L l10) throws AMapException {
        C1559h0.c(l10.f16170a);
        WeatherSearchQuery weatherSearchQuery = l10.f16171b;
        if (weatherSearchQuery == null) {
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        R0 r02 = new R0(l10.f16170a, weatherSearchQuery);
        return LocalWeatherForecastResult.createPagedResult((WeatherSearchQuery) r02.o(), r02.g());
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public WeatherSearchQuery getQuery() {
        return this.f16171b;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void searchWeatherAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setOnWeatherSearchListener(WeatherSearch.OnWeatherSearchListener onWeatherSearchListener) {
        this.f16172c = onWeatherSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IWeatherSearch
    public void setQuery(WeatherSearchQuery weatherSearchQuery) {
        this.f16171b = weatherSearchQuery;
    }
}
