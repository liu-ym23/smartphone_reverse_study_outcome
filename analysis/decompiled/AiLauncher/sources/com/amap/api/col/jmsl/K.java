package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class K extends Q1<RoutePOISearchQuery, RoutePOISearchResult> {
    public K(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = C1531a0.f0(new JSONObject(str));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.f16103z);
    }

    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        return T2.c(this.f16099B) + "/place/route?";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C1567j0.n(this.f16099B));
        stringBuffer.append("&range=");
        stringBuffer.append("" + ((RoutePOISearchQuery) this.f16103z).getRange());
        switch (((RoutePOISearchQuery) this.f16103z).getSearchType()) {
            case TypeGasStation:
                str = "010100";
                break;
            case TypeMaintenanceStation:
                str = "030000";
                break;
            case TypeATM:
                str = "160300";
                break;
            case TypeToilet:
                str = "200300";
                break;
            case TypeFillingStation:
                str = "010300";
                break;
            case TypeServiceArea:
                str = "180300";
                break;
            case TypeChargeStation:
                str = "011100";
                break;
            case TypeFood:
                str = "050000";
                break;
            case TypeHotel:
                str = "100000";
                break;
            default:
                str = "";
                break;
        }
        if (((RoutePOISearchQuery) this.f16103z).getPolylines() == null || ((RoutePOISearchQuery) this.f16103z).getPolylines().size() <= 0) {
            stringBuffer.append("&origin=");
            stringBuffer.append(C1631z1.e(((RoutePOISearchQuery) this.f16103z).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(C1631z1.e(((RoutePOISearchQuery) this.f16103z).getTo()));
            stringBuffer.append("&strategy=");
            stringBuffer.append("" + ((RoutePOISearchQuery) this.f16103z).getMode());
        } else {
            stringBuffer.append("&polyline=");
            stringBuffer.append(C1631z1.i(((RoutePOISearchQuery) this.f16103z).getPolylines(), Const.STR_MART_SEMICOLON));
        }
        String channel = ((RoutePOISearchQuery) this.f16103z).getChannel();
        if (!TextUtils.isEmpty(channel)) {
            stringBuffer.append("&channel=");
            stringBuffer.append(channel);
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }
}
