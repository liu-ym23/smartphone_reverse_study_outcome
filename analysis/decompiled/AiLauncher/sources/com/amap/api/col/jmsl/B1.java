package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.auto.AutoTChargeStationResult;
import com.amap.api.services.auto.AutoTSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IAutoTSearch;

/* loaded from: classes.dex */
public class B1 implements IAutoTSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f15932a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f15933b;

    /* renamed from: c, reason: collision with root package name */
    public AutoTSearch.Query f15934c;

    /* renamed from: d, reason: collision with root package name */
    public AutoTSearch.OnChargeStationListener f15935d;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = B1.this.f15933b.obtainMessage();
            messageObtainMessage.arg1 = 20;
            messageObtainMessage.what = 600;
            Bundle bundle = new Bundle();
            AutoTChargeStationResult autoTChargeStationResultSearchChargeStation = null;
            try {
                autoTChargeStationResultSearchChargeStation = B1.this.searchChargeStation();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.a aVar = new HandlerC1626y0.a();
                aVar.f17036b = B1.this.f15935d;
                aVar.f17035a = autoTChargeStationResultSearchChargeStation;
                messageObtainMessage.obj = aVar;
                messageObtainMessage.setData(bundle);
                B1.this.f15933b.sendMessage(messageObtainMessage);
            }
        }
    }

    public B1(Context context) throws AMapException {
        this.f15933b = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f15932a = context.getApplicationContext();
        this.f15933b = HandlerC1626y0.a();
        C1631z1.l(this.f15932a, "AutoTSearchCore");
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public AutoTChargeStationResult searchChargeStation() throws AMapException {
        try {
            C1559h0.c(this.f15932a);
            AutoTSearch.Query query = this.f15934c;
            if (query != null) {
                return new C1592p1(this.f15932a, query.m18clone()).g();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e10) {
            throw new AMapException(e10.getMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void searchChargeStationAsync() {
        try {
            C1535b0.c().b(new a());
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void setChargeStationListener(AutoTSearch.OnChargeStationListener onChargeStationListener) {
        this.f15935d = onChargeStationListener;
    }

    @Override // com.amap.api.services.interfaces.IAutoTSearch
    public void setQuery(AutoTSearch.Query query) {
        this.f15934c = query;
    }
}
