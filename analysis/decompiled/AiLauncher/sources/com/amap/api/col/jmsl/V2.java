package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IPoiSearch;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class V2 implements IPoiSearch {

    /* renamed from: i, reason: collision with root package name */
    public static HashMap<Integer, PoiResult> f16393i;

    /* renamed from: a, reason: collision with root package name */
    public PoiSearch.SearchBound f16394a;

    /* renamed from: b, reason: collision with root package name */
    public PoiSearch.Query f16395b;

    /* renamed from: c, reason: collision with root package name */
    public Context f16396c;

    /* renamed from: d, reason: collision with root package name */
    public PoiSearch.OnPoiSearchListener f16397d;

    /* renamed from: e, reason: collision with root package name */
    public String f16398e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    public PoiSearch.Query f16399f;

    /* renamed from: g, reason: collision with root package name */
    public PoiSearch.SearchBound f16400g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f16401h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = V2.this.f16401h.obtainMessage();
            messageObtainMessage.arg1 = 6;
            messageObtainMessage.what = 600;
            Bundle bundle = new Bundle();
            PoiResult poiResultSearchPOI = null;
            try {
                poiResultSearchPOI = V2.this.searchPOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.j jVar = new HandlerC1626y0.j();
                jVar.f17054b = V2.this.f16397d;
                jVar.f17053a = poiResultSearchPOI;
                messageObtainMessage.obj = jVar;
                messageObtainMessage.setData(bundle);
                V2.this.f16401h.sendMessage(messageObtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16403a;

        public b(String str) {
            this.f16403a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 6;
            messageObtainMessage.what = 602;
            Bundle bundle = new Bundle();
            PoiItem poiItemSearchPOIId = null;
            try {
                poiItemSearchPOIId = V2.this.searchPOIId(this.f16403a);
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                C1631z1.o(e10, "PoiSearch", "searchPOIIdAsyn");
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.h hVar = new HandlerC1626y0.h();
                hVar.f17050b = V2.this.f16397d;
                hVar.f17049a = poiItemSearchPOIId;
                messageObtainMessage.obj = hVar;
                messageObtainMessage.setData(bundle);
                V2.this.f16401h.sendMessage(messageObtainMessage);
            }
        }
    }

    public V2(Context context, PoiSearch.Query query) throws AMapException {
        this.f16401h = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16396c = context.getApplicationContext();
        setQuery(query);
        this.f16401h = HandlerC1626y0.a();
        C1631z1.l(this.f16396c, "PoiSearchCore");
    }

    public final boolean b() {
        PoiSearch.SearchBound searchBound = this.f16394a;
        if (searchBound == null) {
            return true;
        }
        if (searchBound.getShape().equals("Bound")) {
            return searchBound.getCenter() != null;
        }
        if (!searchBound.getShape().equals("Polygon")) {
            if (!searchBound.getShape().equals("Rectangle")) {
                return true;
            }
            LatLonPoint lowerLeft = searchBound.getLowerLeft();
            LatLonPoint upperRight = searchBound.getUpperRight();
            return lowerLeft != null && upperRight != null && lowerLeft.getLatitude() < upperRight.getLatitude() && lowerLeft.getLongitude() < upperRight.getLongitude();
        }
        List<LatLonPoint> polyGonList = searchBound.getPolyGonList();
        if (polyGonList == null || polyGonList.size() == 0) {
            return false;
        }
        for (int i10 = 0; i10 < polyGonList.size(); i10++) {
            if (polyGonList.get(i10) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.SearchBound getBound() {
        return this.f16394a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public String getLanguage() {
        return this.f16398e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiSearch.Query getQuery() {
        return this.f16395b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiResult searchPOI() throws AMapException {
        PoiSearch.Query query;
        try {
            C1559h0.c(this.f16396c);
            PoiSearch.SearchBound searchBound = this.f16394a;
            if ((searchBound == null || !searchBound.getShape().equals("Bound")) && ((query = this.f16395b) == null || (C1631z1.p(query.getQueryString()) && C1631z1.p(this.f16395b.getCategory())))) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearch.Query query2 = this.f16395b;
            if (query2 == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query2.queryEquals(this.f16399f) && this.f16394a == null) || (!this.f16395b.queryEquals(this.f16399f) && !this.f16394a.equals(this.f16400g))) {
                this.f16399f = this.f16395b.m24clone();
                PoiSearch.SearchBound searchBound2 = this.f16394a;
                if (searchBound2 != null) {
                    this.f16400g = searchBound2.m25clone();
                }
                HashMap<Integer, PoiResult> map = f16393i;
                if (map != null) {
                    map.clear();
                }
            }
            PoiSearch.SearchBound searchBound3 = this.f16394a;
            PoiSearch.SearchBound searchBoundClone = searchBound3 != null ? searchBound3.m25clone() : null;
            C1542d.b().f(this.f16395b.getQueryString());
            this.f16395b.setPageNum(C1542d.b().a(this.f16395b.getPageNum()));
            this.f16395b.setPageSize(C1542d.b().h(this.f16395b.getPageSize()));
            PoiResult poiResultG = new J1(this.f16396c, new C1597q2(this.f16395b.m24clone(), searchBoundClone)).g();
            f16393i = new HashMap<>();
            return poiResultG;
        } catch (AMapException e10) {
            C1631z1.o(e10, "PoiSearch", "searchPOI");
            throw new AMapException(e10.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public PoiItem searchPOIId(String str) throws AMapException {
        C1559h0.c(this.f16396c);
        PoiSearch.Query query = this.f16395b;
        return new C1596q1(this.f16396c, str, query != null ? query.m24clone() : null).g();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void searchPOIIdAsyn(String str) {
        C1535b0.c().b(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setBound(PoiSearch.SearchBound searchBound) {
        this.f16394a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f16398e = "en";
        } else {
            this.f16398e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setOnPoiSearchListener(PoiSearch.OnPoiSearchListener onPoiSearchListener) {
        this.f16397d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearch
    public void setQuery(PoiSearch.Query query) {
        this.f16395b = query;
    }
}
