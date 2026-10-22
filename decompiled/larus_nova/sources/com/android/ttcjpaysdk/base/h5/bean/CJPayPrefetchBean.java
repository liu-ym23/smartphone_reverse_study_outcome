package com.android.ttcjpaysdk.base.h5.bean;

import com.alipay.sdk.m.p.e;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public class CJPayPrefetchBean {
    public String api;
    public String data;
    public JSONObject dataJson;
    public JSONObject data_fields;
    public JSONArray data_json_str;
    public String data_type;
    public JSONArray host;
    public ArrayList<String> hostList;
    public String method;
    public ArrayList<String> needJsonList;
    public ArrayList<TTCJPayNeedReplace> needReplacedList;
    public String path;

    public static class TTCJPayNeedReplace {
        public String key;
        public String path;

        public TTCJPayNeedReplace(String r100, String r101) {
            this.key = r100;
            this.path = r101;
        }
    }

    public CJPayPrefetchBean() {
        this.needReplacedList = new ArrayList();
        this.needJsonList = new ArrayList();
        this.hostList = new ArrayList();
    }

    public static CJPayPrefetchBean transformJson(JSONObject r100) {
        CJPayPrefetchBean r101 = new CJPayPrefetchBean();
        if (r100 == null) goto L21;
        r101.host = r100.optJSONArray("host");
        r101.path = r100.optString("path");
        r101.api = r100.optString("api");
        r101.method = r100.optString(e.f25671s);
        r101.data_type = r100.optString("data_type");
        r101.data = r100.optString("data");
        r101.data_json_str = r100.optJSONArray("data_json_str");
        JSONObject r102 = r100.optJSONObject("data_fields");
        r101.data_fields = r102;
        if (r102 == null) goto L10;
        Iterator<String> r103 = r102.keys();
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = r103.next();
        String r105 = r101.data_fields.optString(r104);
        r101.needReplacedList.add(new TTCJPayNeedReplace(r104, r105));
    L10:
        int r106 = 0;
        int r107 = 0;
    L12:
        if (r107 >= r101.data_json_str.length()) goto L15;
        r101.needJsonList.add(r101.data_json_str.optString(r107));
        r107 = r107 + 1;
    L15:
        if (r106 >= r101.host.length()) goto L22;
        r101.hostList.add(r101.host.optString(r106));
        r106 = r106 + 1;
        goto L15
    L22:
        r101.dataJson = new JSONObject(r101.data);     // Catch: JSONException -> L19
    L19:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("CJPayPrefetchBean#transformJson", e);
        CJBasicCommonUtils.logCatch("CJCatch", "CJPayPrefetchBean#transformJson", e);
        e.printStackTrace();
    L21:
        return r101;
    }
}
