package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusLineSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class K1 implements IBusLineSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f16154a;

    /* renamed from: b, reason: collision with root package name */
    public BusLineSearch.OnBusLineSearchListener f16155b;

    /* renamed from: c, reason: collision with root package name */
    public BusLineQuery f16156c;

    /* renamed from: d, reason: collision with root package name */
    public BusLineQuery f16157d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<BusLineResult> f16158e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public Handler f16159f;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.arg1 = 3;
                    messageObtainMessage.what = 1000;
                    HandlerC1626y0.b bVar = new HandlerC1626y0.b();
                    messageObtainMessage.obj = bVar;
                    bVar.f17038b = K1.this.f16155b;
                    bVar.f17037a = K1.this.searchBusLine();
                } catch (AMapException e10) {
                    messageObtainMessage.what = e10.getErrorCode();
                }
            } finally {
                K1.this.f16159f.sendMessage(messageObtainMessage);
            }
        }
    }

    public K1(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f16159f = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16154a = context.getApplicationContext();
        this.f16156c = busLineQuery;
        if (busLineQuery != null) {
            this.f16157d = busLineQuery.m19clone();
        }
        this.f16159f = HandlerC1626y0.a();
        C1631z1.l(this.f16154a, "BusLineSearchCore");
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineQuery getQuery() {
        return this.f16156c;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public BusLineResult searchBusLine() throws AMapException {
        try {
            C1559h0.c(this.f16154a);
            if (this.f16157d != null) {
                boolean z10 = true;
                if (this.f16156c == null ? false : !C1631z1.p(r0.getQueryString())) {
                    if (!this.f16156c.weakEquals(this.f16157d)) {
                        this.f16157d = this.f16156c.m19clone();
                        ArrayList<BusLineResult> arrayList = this.f16158e;
                        if (arrayList != null) {
                            arrayList.clear();
                        }
                    }
                    BusLineResult busLineResult = (BusLineResult) new C1593p2(this.f16154a, this.f16156c.m19clone()).g();
                    this.f16158e = new ArrayList<>();
                    int pageNumber = this.f16156c.getPageNumber();
                    if (pageNumber >= 0 || pageNumber < 0) {
                        z10 = false;
                    }
                    if (z10) {
                        this.f16158e.set(this.f16156c.getPageNumber(), busLineResult);
                    }
                    return busLineResult;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e10) {
            C1631z1.o(e10, "BusLineSearch", "searchBusLine");
            throw new AMapException(e10.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void searchBusLineAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setOnBusLineSearchListener(BusLineSearch.OnBusLineSearchListener onBusLineSearchListener) {
        this.f16155b = onBusLineSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusLineSearch
    public void setQuery(BusLineQuery busLineQuery) {
        if (this.f16156c.weakEquals(busLineQuery)) {
            return;
        }
        this.f16156c = busLineQuery;
        this.f16157d = busLineQuery.m19clone();
    }
}
