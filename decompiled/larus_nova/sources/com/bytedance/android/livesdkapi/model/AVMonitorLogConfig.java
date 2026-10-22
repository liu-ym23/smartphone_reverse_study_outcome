package com.bytedance.android.livesdkapi.model;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/AVMonitorLogConfig;", "", "()V", "enable", "", "eventMap", "", "", "rtcLogType", "", "stackTrace", "stackTraceDepth", "", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AVMonitorLogConfig {

    @SerializedName("enable")
    public boolean enable;

    @SerializedName("event_map")
    public Map<String, String> eventMap;

    @SerializedName("rtc_log_type")
    public List<String> rtcLogType;

    @SerializedName("stack_trace")
    public boolean stackTrace;

    @SerializedName("stack_trace_depth")
    public int stackTraceDepth;

    public AVMonitorLogConfig() {
        this.enable = true;
        this.rtcLogType = CollectionsKt.listOf("live_client_monitor_log");
        this.stackTrace = true;
        this.stackTraceDepth = 18;
        this.eventMap = MapsKt.mapOf(new Pair[]{TuplesKt.to("rtc_engine_api_call", "sdk_interface_call"), TuplesKt.to(LiveCommonConstants.LOG_EVENT_KEY_LIVECORE_API, "sdk_interface_call")});
    }
}
