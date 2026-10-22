package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class N2 extends AbstractC1628y2<CloudSearch.Query, CloudResult> {

    /* renamed from: E, reason: collision with root package name */
    public int f16225E;

    public N2(Context context, CloudSearch.Query query) {
        super(context, query);
        this.f16225E = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.I1
    public Object f(String str) throws AMapException {
        ArrayList<CloudItem> arrayListQ = null;
        if (str == null || str.equals("")) {
            CloudSearch.Query query = (CloudSearch.Query) this.f16103z;
            return CloudResult.createPagedResult(query, this.f16225E, query.getBound(), ((CloudSearch.Query) this.f16103z).getPageSize(), null);
        }
        try {
            arrayListQ = q(new JSONObject(str));
        } catch (JSONException e10) {
            e10.printStackTrace();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        CloudSearch.Query query2 = (CloudSearch.Query) this.f16103z;
        return CloudResult.createPagedResult(query2, this.f16225E, query2.getBound(), ((CloudSearch.Query) this.f16103z).getPageSize(), arrayListQ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.Q1, com.amap.api.col.jmsl.s7
    public Map<String, String> getParams() {
        Hashtable hashtable = new Hashtable(16);
        hashtable.put("key", C1567j0.n(this.f16099B));
        hashtable.put("output", "json");
        String str = "";
        if (((CloudSearch.Query) this.f16103z).getBound() != null) {
            if (((CloudSearch.Query) this.f16103z).getBound().getShape().equals("Bound")) {
                hashtable.put("center", C1631z1.a(((CloudSearch.Query) this.f16103z).getBound().getCenter().getLongitude()) + Const.STR_MART_COMMA + C1631z1.a(((CloudSearch.Query) this.f16103z).getBound().getCenter().getLatitude()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("");
                sb2.append(((CloudSearch.Query) this.f16103z).getBound().getRange());
                hashtable.put("radius", sb2.toString());
            } else if (((CloudSearch.Query) this.f16103z).getBound().getShape().equals("Rectangle")) {
                LatLonPoint lowerLeft = ((CloudSearch.Query) this.f16103z).getBound().getLowerLeft();
                LatLonPoint upperRight = ((CloudSearch.Query) this.f16103z).getBound().getUpperRight();
                double dA = C1631z1.a(lowerLeft.getLatitude());
                hashtable.put("polygon", C1631z1.a(lowerLeft.getLongitude()) + Const.STR_MART_COMMA + dA + Const.STR_MART_SEMICOLON + C1631z1.a(upperRight.getLongitude()) + Const.STR_MART_COMMA + C1631z1.a(upperRight.getLatitude()));
            } else if (((CloudSearch.Query) this.f16103z).getBound().getShape().equals("Polygon")) {
                List<LatLonPoint> polyGonList = ((CloudSearch.Query) this.f16103z).getBound().getPolyGonList();
                if (polyGonList != null && polyGonList.size() > 0) {
                    hashtable.put("polygon", C1631z1.i(polyGonList, Const.STR_MART_SEMICOLON));
                }
            } else if (((CloudSearch.Query) this.f16103z).getBound().getShape().equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
                hashtable.put("city", ((CloudSearch.Query) this.f16103z).getBound().getCity());
            }
        }
        hashtable.put("layerId", ((CloudSearch.Query) this.f16103z).getTableID());
        if (!C1631z1.p(r())) {
            hashtable.put("sortrule", r());
        }
        StringBuffer stringBuffer = new StringBuffer();
        String filterString = ((CloudSearch.Query) this.f16103z).getFilterString();
        String filterNumString = ((CloudSearch.Query) this.f16103z).getFilterNumString();
        stringBuffer.append(filterString);
        if (!C1631z1.p(filterString) && !C1631z1.p(filterNumString)) {
            stringBuffer.append("&&");
        }
        stringBuffer.append(filterNumString);
        String string = stringBuffer.toString();
        if (!C1631z1.p(string)) {
            hashtable.put("filter", string);
        }
        String queryString = ((CloudSearch.Query) this.f16103z).getQueryString();
        if (queryString == null || "".equals(queryString)) {
            hashtable.put("keywords", "");
        } else {
            hashtable.put("keywords", queryString);
        }
        hashtable.put("pageSize", "" + ((CloudSearch.Query) this.f16103z).getPageSize());
        hashtable.put("pageNum", "" + ((CloudSearch.Query) this.f16103z).getPageNum());
        String strB = J0.b();
        Context context = this.f16099B;
        StringBuilder sb3 = new StringBuilder();
        for (Map.Entry entry : hashtable.entrySet()) {
            if (sb3.length() > 0) {
                sb3.append(Const.STR_MART_ADD);
            }
            sb3.append((String) entry.getKey());
            sb3.append("=");
            sb3.append((String) entry.getValue());
        }
        String string2 = sb3.toString();
        try {
        } catch (Throwable th) {
            C1611u1.b(th, "ut", "sPa");
        }
        if (!TextUtils.isEmpty(string2)) {
            if (string2 != null) {
                string2 = string2.replace("&&", "%26%26");
            }
            String[] strArrSplit = string2.split(Const.STR_MART_ADD);
            Arrays.sort(strArrSplit);
            StringBuffer stringBuffer2 = new StringBuffer();
            for (String str2 : strArrSplit) {
                stringBuffer2.append(str2);
                stringBuffer2.append(Const.STR_MART_ADD);
            }
            String string3 = stringBuffer2.toString();
            if (string3 != null) {
                string3 = string3.replace("%26%26", "&&");
            }
            str = string3.length() > 1 ? (String) string3.subSequence(0, string3.length() - 1) : string2;
        }
        String strD = J0.d(context, strB, str);
        hashtable.put("ts", strB);
        hashtable.put("scode", strD);
        return hashtable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.amap.api.col.jmsl.s7
    public String getURL() {
        String str = T2.f(this.f16099B) + "/datasearch";
        String shape = ((CloudSearch.Query) this.f16103z).getBound().getShape();
        if (shape.equals("Bound")) {
            return str + "/around";
        }
        if (shape.equals("Polygon") || shape.equals("Rectangle")) {
            return str + "/polygon";
        }
        if (!shape.equals(CloudSearch.SearchBound.LOCAL_SHAPE)) {
            return str;
        }
        return str + "/local";
    }

    @Override // com.amap.api.col.jmsl.Q1
    public String n() {
        return null;
    }

    public final ArrayList<CloudItem> q(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject;
        ArrayList<CloudItem> arrayList = new ArrayList<>();
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optJSONArray("list") : null;
        if (jSONArrayOptJSONArray != null) {
            JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("data");
            this.f16225E = (jSONObjectOptJSONObject3 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject3.optJSONObject("info")) == null) ? 0 : jSONObjectOptJSONObject.optInt("count");
            for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
                JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i10);
                CloudItemDetail cloudItemDetailO = o(jSONObjectOptJSONObject4);
                p(cloudItemDetailO, jSONObjectOptJSONObject4);
                arrayList.add(cloudItemDetailO);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String r() {
        return ((CloudSearch.Query) this.f16103z).getSortingrules() != null ? ((CloudSearch.Query) this.f16103z).getSortingrules().toString() : "";
    }
}
