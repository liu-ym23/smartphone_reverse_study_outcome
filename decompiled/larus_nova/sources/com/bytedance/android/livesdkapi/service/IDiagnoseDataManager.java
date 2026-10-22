package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IDiagnoseDataManager extends IService {
    public static final String TAG = "IDiagnoseDataManager";
    public static final int TYPE_BUSINESS_DIAGNOSE = 3;
    public static final String TYPE_DATA_DIAGNOSE_KEY = "diagnoseDataType";
    public static final String TYPE_DATA_DIAGNOSE_KEY_BASIC_PERFORMANCE = "diagnoseDataBasicPerformance";
    public static final int TYPE_PERFORMANCE_DIAGNOSE = 0;
    public static final int TYPE_STREAM_PULL_DIAGNOSE = 2;
    public static final int TYPE_STREAM_PUSH_DIAGNOSE = 1;

    public interface BusinessData {
        public static final String BUSINESS_KEY_IS_PK = "isPK";
    }

    public @interface DiagnoseDataType {
    }

    void addDiagnoseData(JSONObject r100);

    boolean isInit();
}
