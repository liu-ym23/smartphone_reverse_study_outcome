package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.busline.BusLineQuery;
import com.amap.api.services.busline.BusLineResult;
import com.amap.api.services.busline.BusStationQuery;
import com.amap.api.services.busline.BusStationResult;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.p2, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1593p2<T> extends Q1<T, Object> {

    /* renamed from: E, reason: collision with root package name */
    public int f16796E;

    /* renamed from: F, reason: collision with root package name */
    public List<String> f16797F;

    /* renamed from: G, reason: collision with root package name */
    public List<SuggestionCity> f16798G;

    public C1593p2(Context context, T t10) {
        super(context, t10);
        this.f16796E = 0;
        this.f16797F = new ArrayList();
        this.f16798G = new ArrayList();
    }

    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("suggestion");
            if (jSONObjectOptJSONObject != null) {
                this.f16798G = C1531a0.p(jSONObjectOptJSONObject);
                this.f16797F = C1531a0.w(jSONObjectOptJSONObject);
            }
            this.f16796E = jSONObject.optInt("count");
            if (this.f16103z instanceof BusLineQuery) {
                return BusLineResult.createPagedResult((BusLineQuery) this.f16103z, this.f16796E, this.f16798G, this.f16797F, C1531a0.i0(jSONObject));
            }
            return BusStationResult.createPagedResult((BusStationQuery) this.f16103z, this.f16796E, this.f16798G, this.f16797F, C1531a0.k0(jSONObject));
        } catch (Exception e10) {
            C1631z1.o(e10, "BusSearchServerHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        T t10 = this.f16103z;
        return T2.c(this.f16099B) + "/bus/" + (t10 instanceof BusLineQuery ? ((BusLineQuery) t10).getCategory() == BusLineQuery.SearchType.BY_LINE_ID ? "lineid" : ((BusLineQuery) this.f16103z).getCategory() == BusLineQuery.SearchType.BY_LINE_NAME ? "linename" : "" : "stopname") + "?";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("output=json");
        T t10 = this.f16103z;
        if (t10 instanceof BusLineQuery) {
            BusLineQuery busLineQuery = (BusLineQuery) t10;
            if (TextUtils.isEmpty(busLineQuery.getExtensions())) {
                sb2.append("&extensions=base");
            } else {
                sb2.append("&extensions=");
                sb2.append(busLineQuery.getExtensions());
            }
            if (busLineQuery.getCategory() == BusLineQuery.SearchType.BY_LINE_ID) {
                sb2.append("&id=");
                sb2.append(m(((BusLineQuery) this.f16103z).getQueryString()));
            } else {
                String city = busLineQuery.getCity();
                if (!C1531a0.m(city)) {
                    String strM = m(city);
                    sb2.append("&city=");
                    sb2.append(strM);
                }
                sb2.append("&keywords=" + m(busLineQuery.getQueryString()));
                sb2.append("&offset=" + busLineQuery.getPageSize());
                sb2.append("&page=" + busLineQuery.getPageNumber());
            }
        } else {
            BusStationQuery busStationQuery = (BusStationQuery) t10;
            String city2 = busStationQuery.getCity();
            if (!C1531a0.m(city2)) {
                String strM2 = m(city2);
                sb2.append("&city=");
                sb2.append(strM2);
            }
            sb2.append("&keywords=" + m(busStationQuery.getQueryString()));
            sb2.append("&offset=" + busStationQuery.getPageSize());
            sb2.append("&page=" + busStationQuery.getPageNumber());
        }
        sb2.append("&key=" + C1567j0.n(this.f16099B));
        return sb2.toString();
    }
}
