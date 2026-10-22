package com.bytedance.android.livesdkapi.log;

import com.ss.android.common.applog.EventVerify;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H&J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J.\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H&J\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/ILivePlayerExceptionLogger;", "", "assembleExceptionParams", "", "", "blackMonitor", "Lcom/bytedance/android/livesdkapi/log/IPlayerBlackScreenMonitor;", "handleDataFromStreamTraceEvent", "", "event", "Lorg/json/JSONObject;", EventVerify.TYPE_LAUNCH, "logException", "exceptionName", "exceptionReason", "exceptionExtraParams", "stallMonitor", "Lcom/bytedance/android/livesdkapi/log/IPlayerStallMonitor;", "trafficMonitor", "Lcom/bytedance/android/livesdkapi/log/IPlayerTrafficMonitor;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerExceptionLogger {
    Map<String, String> assembleExceptionParams();

    IPlayerBlackScreenMonitor blackMonitor();

    void handleDataFromStreamTraceEvent(JSONObject r100);

    void launch();

    void logException(String r100, String r101, Map<String, String> r102);

    IPlayerStallMonitor stallMonitor();

    IPlayerTrafficMonitor trafficMonitor();
}
