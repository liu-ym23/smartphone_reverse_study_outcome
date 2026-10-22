package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;

/* renamed from: com.amap.api.col.jmsl.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1546e implements IRoutePOISearch {

    /* renamed from: a, reason: collision with root package name */
    public RoutePOISearchQuery f16589a;

    /* renamed from: b, reason: collision with root package name */
    public Context f16590b;

    /* renamed from: c, reason: collision with root package name */
    public RoutePOISearch.OnRoutePOISearchListener f16591c;

    /* renamed from: d, reason: collision with root package name */
    public Handler f16592d;

    /* renamed from: com.amap.api.col.jmsl.e$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = C1546e.this.f16592d.obtainMessage();
            messageObtainMessage.arg1 = 14;
            Bundle bundle = new Bundle();
            RoutePOISearchResult routePOISearchResultSearchRoutePOI = null;
            try {
                routePOISearchResultSearchRoutePOI = C1546e.this.searchRoutePOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.m mVar = new HandlerC1626y0.m();
                mVar.f17060b = C1546e.this.f16591c;
                mVar.f17059a = routePOISearchResultSearchRoutePOI;
                messageObtainMessage.obj = mVar;
                messageObtainMessage.setData(bundle);
                C1546e.this.f16592d.sendMessage(messageObtainMessage);
            }
        }
    }

    public C1546e(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        this.f16592d = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16590b = context;
        this.f16589a = routePOISearchQuery;
        this.f16592d = HandlerC1626y0.a();
        C1631z1.l(this.f16590b, "RoutePOISearchCore");
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public RoutePOISearchQuery getQuery() {
        return this.f16589a;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public RoutePOISearchResult searchRoutePOI() throws AMapException, CloneNotSupportedException {
        try {
            C1559h0.c(this.f16590b);
            RoutePOISearchQuery routePOISearchQuery = this.f16589a;
            if (routePOISearchQuery == null || routePOISearchQuery.getSearchType() == null || (this.f16589a.getFrom() == null && this.f16589a.getTo() == null && this.f16589a.getPolylines() == null)) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new K(this.f16590b, this.f16589a.m41clone()).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "RoutePOISearchCore", "searchRoutePOI");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void searchRoutePOIAsyn() {
        C1535b0.c().b(new a());
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        this.f16589a = routePOISearchQuery;
    }

    @Override // com.amap.api.services.interfaces.IRoutePOISearch
    public void setRoutePOISearchListener(RoutePOISearch.OnRoutePOISearchListener onRoutePOISearchListener) {
        this.f16591c = onRoutePOISearchListener;
    }
}
