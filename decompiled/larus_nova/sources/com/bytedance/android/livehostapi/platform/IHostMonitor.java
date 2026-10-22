package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostMonitor;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostMonitor extends IService, IBaseHostMonitor {
    public static final String BUSINESS_TAG = "business_tt_live";

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostMonitor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$uploadALog(IHostMonitor r100, long r101, long r102, String r103) {
        }
    }

    void ensureNotReachHere(Throwable r100, String r101);

    boolean isNotHitSampled(String r100);

    void monitorApiError(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106);

    void monitorCommonLog(String r100, String r101, JSONObject r102);

    void monitorCommonLog(String r100, JSONObject r101);

    void monitorDebugReal(String r100);

    void monitorDebugReal(String r100, String r101);

    void monitorDirectOnCount(String r100, String r101, float r102);

    void monitorDirectOnTimer(String r100, String r101, float r102);

    void monitorDuration(String r100, JSONObject r101, JSONObject r102);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void monitorOnCount(String r100, String r101);

    void monitorOnCount(String r100, String r101, float r102);

    void monitorOnStore(String r100, String r101, float r102);

    void monitorOnTimer(String r100, String r101, float r102);

    void monitorOppoOptScene(String r100);

    void monitorSLA(long r100, long r101, String r102, String r103, String r104, int r105, JSONObject r106);

    void monitorStatusAndDuration(String r100, int r101, JSONObject r102, JSONObject r103);

    void monitorStatusRate(String r100, int r101, JSONObject r102);

    void setBusiness();

    void setCpuSceneInfo(String r100);

    void uploadALog(long r100, long r101, String r102);
}
