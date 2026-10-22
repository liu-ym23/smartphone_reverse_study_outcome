package com.android.ttcjpaysdk.thirdparty.front.counter.activity;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class CJPayReportData {
    public static JSONObject createOrderResponseJSON;
    public static long orderCreateEnd;
    public static long orderCreateJSBEnd;
    public static long orderCreateJSBStart;
    public static long orderCreateNetEnd;
    public static long orderCreateNetStart;
    public static long orderCreateStart;
    public static long orderTTPayCallStart;

    public CJPayReportData() {
    }

    public static void releaseCreateOrderData() {
        createOrderResponseJSON = null;
        orderCreateStart = 0;
        orderCreateJSBStart = 0;
        orderCreateJSBEnd = 0;
        orderCreateNetStart = 0;
        orderCreateNetEnd = 0;
        orderCreateEnd = 0;
        orderTTPayCallStart = 0;
    }

    public static void setOrderCreateEnd() {
        orderCreateEnd = System.currentTimeMillis();
    }

    public static void setOrderCreateJSBEnd() {
        orderCreateJSBEnd = System.currentTimeMillis();
    }

    public static void setOrderCreateJSBStart() {
        orderCreateJSBStart = System.currentTimeMillis();
    }

    public static long setOrderCreateNetEnd() {
        long r100 = System.currentTimeMillis();
        orderCreateNetEnd = r100;
        return r100;
    }

    public static long setOrderCreateNetStart() {
        long r100 = System.currentTimeMillis();
        orderCreateNetStart = r100;
        return r100;
    }

    public static long setOrderCreateStart() {
        long r100 = System.currentTimeMillis();
        orderCreateStart = r100;
        return r100;
    }

    public static void setOrderTTPayCallStart() {
        orderTTPayCallStart = System.currentTimeMillis();
    }

    public static void setCreateOrderResponseJSON(JSONObject r100) {
        createOrderResponseJSON = r100;
    }
}
