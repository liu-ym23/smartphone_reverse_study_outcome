package com.amap.api.col.jmsl;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.jmsl.r5;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearch;
import com.amap.api.services.district.DistrictSearchQuery;
import com.amap.api.services.interfaces.IDistrictSearch;
import java.util.HashMap;

/* renamed from: com.amap.api.col.jmsl.r2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1600r2 implements IDistrictSearch {

    /* renamed from: g, reason: collision with root package name */
    public static HashMap<Integer, DistrictResult> f16810g;

    /* renamed from: a, reason: collision with root package name */
    public Context f16811a;

    /* renamed from: b, reason: collision with root package name */
    public DistrictSearchQuery f16812b;

    /* renamed from: c, reason: collision with root package name */
    public DistrictSearch.OnDistrictSearchListener f16813c;

    /* renamed from: d, reason: collision with root package name */
    public DistrictSearchQuery f16814d;

    /* renamed from: e, reason: collision with root package name */
    public int f16815e;

    /* renamed from: f, reason: collision with root package name */
    public Handler f16816f;

    /* renamed from: com.amap.api.col.jmsl.r2$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Message messageObtainMessage = HandlerC1626y0.a().obtainMessage();
            DistrictResult districtResult = new DistrictResult();
            districtResult.setQuery(C1600r2.this.f16812b);
            try {
                try {
                    try {
                        districtResult = C1600r2.this.searchDistrict();
                        if (districtResult != null) {
                            districtResult.setAMapException(new AMapException());
                        }
                        messageObtainMessage.arg1 = 4;
                        messageObtainMessage.obj = C1600r2.this.f16813c;
                        Bundle bundle = new Bundle();
                        bundle.putParcelable("result", districtResult);
                        messageObtainMessage.setData(bundle);
                        if (C1600r2.this.f16816f == null) {
                            return;
                        }
                    } catch (AMapException e10) {
                        districtResult.setAMapException(e10);
                        messageObtainMessage.arg1 = 4;
                        messageObtainMessage.obj = C1600r2.this.f16813c;
                        Bundle bundle2 = new Bundle();
                        bundle2.putParcelable("result", districtResult);
                        messageObtainMessage.setData(bundle2);
                        if (C1600r2.this.f16816f == null) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    C1631z1.o(th, "DistrictSearch", "searchDistrictAnsyThrowable");
                    messageObtainMessage.arg1 = 4;
                    messageObtainMessage.obj = C1600r2.this.f16813c;
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("result", districtResult);
                    messageObtainMessage.setData(bundle3);
                    if (C1600r2.this.f16816f == null) {
                        return;
                    }
                }
                C1600r2.this.f16816f.sendMessage(messageObtainMessage);
            } catch (Throwable th2) {
                messageObtainMessage.arg1 = 4;
                messageObtainMessage.obj = C1600r2.this.f16813c;
                Bundle bundle4 = new Bundle();
                bundle4.putParcelable("result", districtResult);
                messageObtainMessage.setData(bundle4);
                if (C1600r2.this.f16816f != null) {
                    C1600r2.this.f16816f.sendMessage(messageObtainMessage);
                }
                throw th2;
            }
        }
    }

    public C1600r2(Context context) throws AMapException {
        C1537b2 c1537b2A = r5.a(context, T2.a(false));
        if (c1537b2A.f16534a != r5.e.SuccessCode) {
            String str = c1537b2A.f16535b;
            throw new AMapException(str, 1, str, c1537b2A.f16534a.f());
        }
        this.f16811a = context.getApplicationContext();
        this.f16816f = HandlerC1626y0.a();
        C1631z1.l(this.f16811a, "DistrictSearchCore");
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictSearchQuery getQuery() {
        return this.f16812b;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public DistrictResult searchDistrict() throws AMapException {
        int i10;
        int i11;
        try {
            DistrictResult districtResult = new DistrictResult();
            C1559h0.c(this.f16811a);
            if (this.f16812b == null) {
                this.f16812b = new DistrictSearchQuery();
            }
            districtResult.setQuery(this.f16812b.m23clone());
            if (!this.f16812b.weakEquals(this.f16814d)) {
                this.f16815e = 0;
                this.f16814d = this.f16812b.m23clone();
                HashMap<Integer, DistrictResult> map = f16810g;
                if (map != null) {
                    map.clear();
                }
            }
            if (this.f16815e == 0) {
                DistrictResult districtResultG = new C1538c(this.f16811a, this.f16812b.m23clone()).g();
                if (districtResultG == null) {
                    return districtResultG;
                }
                this.f16815e = districtResultG.getPageCount();
                f16810g = new HashMap<>();
                DistrictSearchQuery districtSearchQuery = this.f16812b;
                if (districtSearchQuery != null && (i11 = this.f16815e) > 0 && i11 > districtSearchQuery.getPageNum()) {
                    f16810g.put(Integer.valueOf(this.f16812b.getPageNum()), districtResultG);
                }
                return districtResultG;
            }
            int pageNum = this.f16812b.getPageNum();
            if (pageNum >= this.f16815e || pageNum < 0) {
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            DistrictResult districtResultG2 = f16810g.get(Integer.valueOf(pageNum));
            if (districtResultG2 == null) {
                districtResultG2 = new C1538c(this.f16811a, this.f16812b.m23clone()).g();
                DistrictSearchQuery districtSearchQuery2 = this.f16812b;
                if (districtSearchQuery2 != null && districtResultG2 != null && (i10 = this.f16815e) > 0 && i10 > districtSearchQuery2.getPageNum()) {
                    f16810g.put(Integer.valueOf(this.f16812b.getPageNum()), districtResultG2);
                }
            }
            return districtResultG2;
        } catch (AMapException e10) {
            C1631z1.o(e10, "DistrictSearch", "searchDistrict");
            throw e10;
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAnsy() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void searchDistrictAsyn() {
        try {
            C1535b0.c().b(new a());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setOnDistrictSearchListener(DistrictSearch.OnDistrictSearchListener onDistrictSearchListener) {
        this.f16813c = onDistrictSearchListener;
    }

    @Override // com.amap.api.services.interfaces.IDistrictSearch
    public void setQuery(DistrictSearchQuery districtSearchQuery) {
        this.f16812b = districtSearchQuery;
    }
}
