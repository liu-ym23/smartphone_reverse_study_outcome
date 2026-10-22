package com.bytedance.android.livesdk.diagnose;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public class DiagnoseResult {
    public static final String DIAGNOSE_LEVEL_P0 = "P0";
    public static final String DIAGNOSE_LEVEL_P1 = "P1";
    public static final String DIAGNOSE_LEVEL_P2 = "P2";
    public static final int DIAGNOSE_REASON_INTERNET = 1;
    public static final int DIAGNOSE_REASON_OTHER = 99;
    public static final int DIAGNOSE_REASON_POWER = 2;
    public static final String DIAGNOSE_TYPE_HOT = "发热";
    public static final String DIAGNOSE_TYPE_STREAM_STALL = "流卡顿";
    public static final String DIAGNOSE_TYPE_UI_STALL = "UI卡顿";
    public static final String KEY_DIAGNOSE_ASSISTANT_INFO = "assistant_performance_info";
    public static final String KEY_DIAGNOSE_LEVEL = "diagnose_level";
    public static final String KEY_DIAGNOSE_REASON = "diagnose_reason";
    public static final String KEY_DIAGNOSE_TYPE = "diagnose_type";
    public JSONObject monitorInfo;

    public DiagnoseResult() {
        this.monitorInfo = new JSONObject();
    }
}
