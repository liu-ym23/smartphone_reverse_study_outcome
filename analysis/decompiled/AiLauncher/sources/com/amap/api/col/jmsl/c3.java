package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.HandlerC1626y0;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItemV2;
import com.amap.api.services.interfaces.IPoiSearchV2;
import com.amap.api.services.poisearch.PoiResultV2;
import com.amap.api.services.poisearch.PoiSearchV2;
import com.amap.api.services.poisearch.VisualSearchResult;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public class c3 implements IPoiSearchV2 {

    /* renamed from: i, reason: collision with root package name */
    public static HashMap<Integer, PoiResultV2> f16550i;

    /* renamed from: a, reason: collision with root package name */
    public PoiSearchV2.SearchBound f16551a;

    /* renamed from: b, reason: collision with root package name */
    public PoiSearchV2.Query f16552b;

    /* renamed from: c, reason: collision with root package name */
    public Context f16553c;

    /* renamed from: d, reason: collision with root package name */
    public PoiSearchV2.OnPoiSearchListener f16554d;

    /* renamed from: e, reason: collision with root package name */
    public String f16555e = "zh-CN";

    /* renamed from: f, reason: collision with root package name */
    public PoiSearchV2.Query f16556f;

    /* renamed from: g, reason: collision with root package name */
    public PoiSearchV2.SearchBound f16557g;

    /* renamed from: h, reason: collision with root package name */
    public Handler f16558h;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = c3.this.f16558h.obtainMessage();
            messageObtainMessage.arg1 = 19;
            messageObtainMessage.what = 603;
            Bundle bundle = new Bundle();
            PoiResultV2 poiResultV2SearchPOI = null;
            try {
                poiResultV2SearchPOI = c3.this.searchPOI();
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.k kVar = new HandlerC1626y0.k();
                kVar.f17056b = c3.this.f16554d;
                kVar.f17055a = poiResultV2SearchPOI;
                messageObtainMessage.obj = kVar;
                messageObtainMessage.setData(bundle);
                c3.this.f16558h.sendMessage(messageObtainMessage);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f16560a;

        public b(String str) {
            this.f16560a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            messageObtainMessage.arg1 = 19;
            messageObtainMessage.what = 604;
            Bundle bundle = new Bundle();
            PoiItemV2 poiItemV2SearchPOIId = null;
            try {
                poiItemV2SearchPOIId = c3.this.searchPOIId(this.f16560a);
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                C1631z1.o(e10, "PoiSearch", "searchPOIIdAsyn");
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.i iVar = new HandlerC1626y0.i();
                iVar.f17052b = c3.this.f16554d;
                iVar.f17051a = poiItemV2SearchPOIId;
                messageObtainMessage.obj = iVar;
                messageObtainMessage.setData(bundle);
                c3.this.f16558h.sendMessage(messageObtainMessage);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PoiSearchV2.VisualQuery f16562a;

        public c(PoiSearchV2.VisualQuery visualQuery) {
            this.f16562a = visualQuery;
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = c3.this.f16558h.obtainMessage();
            messageObtainMessage.arg1 = 19;
            messageObtainMessage.what = 605;
            Bundle bundle = new Bundle();
            VisualSearchResult visualSearchResultSearchPOIByVisual = null;
            try {
                visualSearchResultSearchPOIByVisual = c3.this.searchPOIByVisual(this.f16562a);
                bundle.putInt("errorCode", 1000);
            } catch (AMapException e10) {
                C1631z1.o(e10, "PoiSearch", "searchPOIByVisualAsyn");
                bundle.putInt("errorCode", e10.getErrorCode());
            } finally {
                HandlerC1626y0.n nVar = new HandlerC1626y0.n();
                nVar.f17062b = c3.this.f16554d;
                nVar.f17061a = visualSearchResultSearchPOIByVisual;
                messageObtainMessage.obj = nVar;
                messageObtainMessage.setData(bundle);
                c3.this.f16558h.sendMessage(messageObtainMessage);
            }
        }
    }

    public c3(Context context, PoiSearchV2.Query query) throws AMapException {
        this.f16558h = null;
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16553c = context.getApplicationContext();
        setQuery(query);
        this.f16558h = HandlerC1626y0.a();
        C1631z1.l(this.f16553c, "PoiSearchCoreV2");
    }

    public final boolean b() {
        PoiSearchV2.SearchBound searchBound = this.f16551a;
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

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiSearchV2.SearchBound getBound() {
        return this.f16551a;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public String getLanguage() {
        return this.f16555e;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiSearchV2.Query getQuery() {
        return this.f16552b;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiResultV2 searchPOI() throws AMapException {
        PoiSearchV2.Query query;
        try {
            C1559h0.c(this.f16553c);
            PoiSearchV2.SearchBound searchBound = this.f16551a;
            if ((searchBound == null || !searchBound.getShape().equals("Bound")) && ((query = this.f16552b) == null || (C1631z1.p(query.getQueryString()) && C1631z1.p(this.f16552b.getCategory())))) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (!b()) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            PoiSearchV2.Query query2 = this.f16552b;
            if (query2 == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if ((!query2.queryEquals(this.f16556f) && this.f16551a == null) || (!this.f16552b.queryEquals(this.f16556f) && !this.f16551a.equals(this.f16557g))) {
                this.f16556f = this.f16552b.m26clone();
                PoiSearchV2.SearchBound searchBound2 = this.f16551a;
                if (searchBound2 != null) {
                    this.f16557g = searchBound2.m27clone();
                }
                HashMap<Integer, PoiResultV2> map = f16550i;
                if (map != null) {
                    map.clear();
                }
            }
            PoiSearchV2.SearchBound searchBound3 = this.f16551a;
            PoiSearchV2.SearchBound searchBoundClone = searchBound3 != null ? searchBound3.m27clone() : null;
            C1542d.b().f(this.f16552b.getQueryString());
            this.f16552b.setPageNum(C1542d.b().a(this.f16552b.getPageNum()));
            this.f16552b.setPageSize(C1542d.b().h(this.f16552b.getPageSize()));
            PoiResultV2 poiResultV2G = new R1(this.f16553c, new C1632z2(this.f16552b.m26clone(), searchBoundClone)).g();
            f16550i = new HashMap<>();
            return poiResultV2G;
        } catch (AMapException e10) {
            C1631z1.o(e10, "PoiSearch", "searchPOI");
            throw new AMapException(e10.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void searchPOIAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public VisualSearchResult searchPOIByVisual(PoiSearchV2.VisualQuery visualQuery) throws AMapException {
        try {
            C1559h0.c(this.f16553c);
            if (visualQuery == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (C1631z1.p(visualQuery.getPicUrl())) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (visualQuery.getLocation() == null) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            if (visualQuery.getAngle() < 0.0f || visualQuery.getAngle() > 360.0f) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            return new C1598r0(this.f16553c, visualQuery).g();
        } catch (AMapException e10) {
            C1631z1.o(e10, "PoiSearch", "searchPOIByVisual");
            throw new AMapException(e10.getErrorMessage());
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void searchPOIByVisualAsyn(PoiSearchV2.VisualQuery visualQuery) {
        try {
            C1535b0.c().b(new c(visualQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public PoiItemV2 searchPOIId(String str) throws AMapException {
        C1559h0.c(this.f16553c);
        PoiSearchV2.Query query = this.f16552b;
        return new A1(this.f16553c, str, query != null ? query.m26clone() : null).g();
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void searchPOIIdAsyn(String str) {
        C1535b0.c().b(new b(str));
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setBound(PoiSearchV2.SearchBound searchBound) {
        this.f16551a = searchBound;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setLanguage(String str) {
        if ("en".equals(str)) {
            this.f16555e = "en";
        } else {
            this.f16555e = "zh-CN";
        }
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setOnPoiSearchListener(PoiSearchV2.OnPoiSearchListener onPoiSearchListener) {
        this.f16554d = onPoiSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IPoiSearchV2
    public void setQuery(PoiSearchV2.Query query) {
        this.f16552b = query;
    }
}
