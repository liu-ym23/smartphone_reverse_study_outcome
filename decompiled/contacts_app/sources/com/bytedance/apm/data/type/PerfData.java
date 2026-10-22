package com.bytedance.apm.data.type;

import android.text.TextUtils;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.CommonServiceName;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.data.ITypeData;
import com.bytedance.apm.launch.LaunchCommon;
import com.bytedance.apm.samplers.SamplerHelper;
import com.bytedance.apm.util.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class PerfData implements ITypeData {
    public JSONObject extraStatus;
    public JSONObject extraValues;
    public JSONObject filters;
    public boolean forceReport;
    public boolean isSaveImmediately;
    public JSONObject logExtr;
    public String metricName;
    public String serviceName;

    @Override // com.bytedance.apm.data.ITypeData
    public String getTypeLabel() {
        return "performance_monitor";
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isUploadImmediately() {
        return false;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean supportFetch() {
        return true;
    }

    public PerfData() {
    }

    public PerfData serviceName(String r1) {
        this.serviceName = r1;
        return this;
    }

    public PerfData metricName(String r1) {
        this.metricName = r1;
        return this;
    }

    public PerfData forceReport(boolean r1) {
        this.forceReport = r1;
        return this;
    }

    public PerfData extraValues(JSONObject r1) {
        this.extraValues = r1;
        return this;
    }

    public PerfData extraStatus(JSONObject r1) {
        this.extraStatus = r1;
        return this;
    }

    public PerfData appendFilters(JSONObject r1) {
        this.filters = r1;
        return this;
    }

    public PerfData extraLog(JSONObject r1) {
        this.logExtr = r1;
        return this;
    }

    public PerfData(String r1, String r2, boolean r3, JSONObject r4, JSONObject r5, JSONObject r6) {
        this.serviceName = r1;
        this.metricName = r2;
        this.forceReport = r3;
        this.extraValues = r4;
        this.extraStatus = r5;
        this.logExtr = r6;
    }

    public PerfData(String r8, String r9, JSONObject r10, JSONObject r11, JSONObject r12) {
        this(r8, r9, false, r10, r11, r12);
    }

    public PerfData(String r8, JSONObject r9, JSONObject r10, JSONObject r11) {
        this(r8, "", false, r9, r10, r11);
    }

    @Override // com.bytedance.apm.data.ITypeData
    public JSONObject packLog() {
    L24:
        return null;
    L3:
        if (this.logExtr != null) goto L5;
        this.logExtr = new JSONObject();     // Catch: JSONException -> L24
    L5:
        this.logExtr.put("log_type", "performance_monitor");     // Catch: JSONException -> L24
        this.logExtr.put("service", this.serviceName);     // Catch: JSONException -> L24
        if (JsonUtils.isEmpty(this.extraValues) == true) goto L9;
        this.logExtr.put(CommonKey.KEY_EXTRA_VALUES, this.extraValues);     // Catch: JSONException -> L24
    L9:
        if (TextUtils.equals("start", this.serviceName) == false) goto L17;
        if (TextUtils.equals("from", this.logExtr.optString("monitor-plugin")) == false) goto L17;
        if (this.extraStatus != null) goto L15;
        this.extraStatus = new JSONObject();     // Catch: JSONException -> L24
    L15:
        this.extraStatus.put("start_mode", ApmContext.getLaunchMode());     // Catch: JSONException -> L24
    L17:
        if (JsonUtils.isEmpty(this.extraStatus) == true) goto L20;
        this.logExtr.put(CommonKey.KEY_EXTRA_STATUS, this.extraStatus);     // Catch: JSONException -> L24
    L20:
        if (JsonUtils.isEmpty(this.filters) == true) goto L22;
        this.logExtr.put("filters", this.filters);     // Catch: JSONException -> L24
    L22:
        return this.logExtr;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSampled(JSONObject r5) {
        if ("fps".equals(this.serviceName) == false) goto L5;
    L34:
        boolean r6 = SamplerHelper.getPerfFpsAllowSwitch(this.serviceName, this.metricName);
    L36:
        if (this.forceReport == true) goto L39;
        if (r6 == true) goto L39;
        return false;
    L39:
        return true;
    L5:
        if ("fps_drop".equals(this.serviceName) == true) goto L34;
        if (CommonServiceName.MONITOR_TYPE_TEMPERATURE.equals(this.serviceName) == false) goto L11;
        r6 = SamplerHelper.getPerfSecondStageSwitch(this.serviceName);
        goto L36
    L11:
        if ("battery".equals(this.serviceName) == false) goto L14;
    L12:
        r6 = true;
        goto L36
    L14:
        if ("start".equals(this.serviceName) == false) goto L22;
        if (SamplerHelper.getPerfAllowSwitch(this.serviceName) == true) goto L12;
        if (SamplerHelper.getMetricSwitch(this.metricName) == true) goto L12;
        r6 = false;
        goto L36
    L22:
        if ("start_trace".equals(this.serviceName) == false) goto L33;
        if (r5 != null) goto L25;
    L32:
        r6 = SamplerHelper.getPerfAllowSwitch(this.serviceName);
        goto L36
    L25:
        if (SamplerHelper.getPerfSecondStageSwitch(SlardarSettingsConsts.PERF_KEY_PERF_DATA_COLLECT) == true) goto L28;
        r5.remove(LaunchCommon.LAUNCH_DATA_PERF_DATA);
    L28:
        if (SamplerHelper.getPerfAllowSwitch(this.serviceName) == true) goto L32;
        JSONObject r7 = r5.optJSONObject(TraceStatsConsts.STATS_KEY_TRACE);
        if (r7 == null) goto L32;
        r7.remove(TraceStatsConsts.STATS_KEY_SPANS);
        goto L32
    L33:
        r6 = SamplerHelper.getPerfAllowSwitch(this.serviceName);
        goto L36
    }

    @Override // com.bytedance.apm.data.ITypeData
    public String getSubTypeLabel() {
        return this.serviceName;
    }

    @Override // com.bytedance.apm.data.ITypeData
    public boolean isSaveImmediately() {
        return this.isSaveImmediately;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public String getMetricName() {
        return this.metricName;
    }

    public boolean isAddDeviceInfo() {
        return TextUtils.equals(this.serviceName, "memory");
    }
}
