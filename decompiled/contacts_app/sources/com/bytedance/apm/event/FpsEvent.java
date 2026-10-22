package com.bytedance.apm.event;

import com.bytedance.apm.util.FpsUtil;
import com.bytedance.apm6.perf.base.PerfFilterManager;
import com.bytedance.apm6.perf.base.model.PerfBaseEvent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class FpsEvent extends PerfBaseEvent {
    private static final String KEY_REFRESH_RATE = "refresh_rate";
    private static final String PERF_FPS_MEASURE_KEY = "fps";
    private static final String SERVICE_NAME = "fps";
    private float fpsValue;
    private boolean mNeedUploadDeviceFpsInfo;
    private int refreshRate;
    private String scene;

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected String getServiceName() {
        return "fps";
    }

    @Override // com.bytedance.apm6.monitor.Monitorable
    public boolean isValid() {
        return false;
    }

    public FpsEvent(float r1, String r2, int r3, boolean r4) {
        this.fpsValue = r1;
        this.scene = r2;
        this.refreshRate = r3;
        this.mNeedUploadDeviceFpsInfo = r4;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraValues() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("fps", this.fpsValue);     // Catch: Throwable -> L4
        return r0;
    L4:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getExtraStatus() {
        new JSONObject().put("scene", this.scene);     // Catch: Throwable -> L5
        return null;
    L8:
        return null;
    }

    @Override // com.bytedance.apm6.perf.base.model.PerfBaseEvent
    protected JSONObject getFilters() {
        JSONObject r0 = PerfFilterManager.getInstance().getPerfFiltersJson();     // Catch: Throwable -> L9
        r0.put("refresh_rate", this.refreshRate);     // Catch: Throwable -> L9
        if (this.mNeedUploadDeviceFpsInfo == false) goto L8;
        boolean r1 = false;
        this.mNeedUploadDeviceFpsInfo = false;     // Catch: Throwable -> L9
        r0.put("device_max_refresh_rate", FpsUtil.getDeviceMaxRefreshRate());     // Catch: Throwable -> L9
        if (FpsUtil.isUsingMaxRefreshRate() == true) goto L7;
        r1 = true;
    L7:
        r0.put("refresh_rate_restricted", r1);     // Catch: Throwable -> L9
    L8:
        return r0;
    L9:
        return null;
    }
}
