package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.busline.BusStationSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusStationSearch;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class S1 implements IBusStationSearch {

    /* renamed from: a, reason: collision with root package name */
    public Context f16344a;

    /* renamed from: b, reason: collision with root package name */
    public BusStationSearch.OnBusStationSearchListener f16345b;

    /* renamed from: c, reason: collision with root package name */
    public BusStationQuery f16346c;

    /* renamed from: d, reason: collision with root package name */
    public BusStationQuery f16347d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<BusStationResult> f16348e = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    public int f16349f;

    /* renamed from: g, reason: collision with root package name */
    public Handler f16350g;

    public class a implements Runnable {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v5, types: [android.os.Handler] */
        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            try {
                try {
                    messageObtainMessage.arg1 = 7;
                    HandlerC1626y0.c cVar = new HandlerC1626y0.c();
                    cVar.f17040b = S1.this.f16345b;
                    messageObtainMessage.obj = cVar;
                    BusStationResult busStationResultSearchBusStation = S1.this.searchBusStation();
                    messageObtainMessage.what = 1000;
                    cVar.f17039a = busStationResultSearchBusStation;
                } catch (AMapException e10) {
                    messageObtainMessage.what = e10.getErrorCode();
                }
            } finally {
                S1.this.f16350g.sendMessage(messageObtainMessage);
            }
        }
    }

    public S1(Context context, BusStationQuery busStationQuery) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16344a = context.getApplicationContext();
        this.f16346c = busStationQuery;
        this.f16350g = HandlerC1626y0.a();
        C1631z1.l(this.f16344a, "BusStationSearchCore");
    }

    public final void b(BusStationResult busStationResult) {
        int i10;
        this.f16348e = new ArrayList<>();
        int i11 = 0;
        while (true) {
            i10 = this.f16349f;
            if (i11 > i10) {
                break;
            }
            this.f16348e.add(null);
            i11++;
        }
        if (i10 > 0) {
            this.f16348e.set(this.f16346c.getPageNumber(), busStationResult);
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationQuery getQuery() {
        return this.f16346c;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public BusStationResult searchBusStation() throws AMapException {
        try {
            C1559h0.c(this.f16344a);
            boolean z10 = true;
            if (!(this.f16346c == null ? false : !C1631z1.p(r2.getQueryString()))) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!this.f16346c.weakEquals(this.f16347d)) {
                this.f16347d = this.f16346c.m20clone();
                this.f16349f = 0;
                ArrayList<BusStationResult> arrayList = this.f16348e;
                if (arrayList != null) {
                    arrayList.clear();
                }
            }
            if (this.f16349f == 0) {
                BusStationResult busStationResult = (BusStationResult) new C1593p2(this.f16344a, this.f16346c).g();
                this.f16349f = busStationResult.getPageCount();
                b(busStationResult);
                return busStationResult;
            }
            int pageNumber = this.f16346c.getPageNumber();
            if (pageNumber > this.f16349f || pageNumber < 0) {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalArgumentException("page out of range");
            }
            BusStationResult busStationResult2 = this.f16348e.get(pageNumber);
            if (busStationResult2 != null) {
                return busStationResult2;
            }
            BusStationResult busStationResult3 = (BusStationResult) new C1593p2(this.f16344a, this.f16346c).g();
            this.f16348e.set(this.f16346c.getPageNumber(), busStationResult3);
            return busStationResult3;
        } catch (AMapException e10) {
            C1631z1.o(e10, "BusStationSearch", "searchBusStation");
            throw new AMapException(e10.getErrorMessage());
        } catch (Throwable th) {
            C1631z1.o(th, "BusStationSearch", "searchBusStation");
            return null;
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void searchBusStationAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setOnBusStationSearchListener(BusStationSearch.OnBusStationSearchListener onBusStationSearchListener) {
        this.f16345b = onBusStationSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IBusStationSearch
    public void setQuery(BusStationQuery busStationQuery) {
        if (busStationQuery.weakEquals(this.f16346c)) {
            return;
        }
        this.f16346c = busStationQuery;
    }
}
