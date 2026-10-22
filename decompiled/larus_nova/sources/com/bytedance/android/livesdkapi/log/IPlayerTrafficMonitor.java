package com.bytedance.android.livesdkapi.log;

import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IPlayerTrafficMonitor;", "", "getTrafficId", "", "insertDataForTrafficEvent", "", "data", "Lorg/json/JSONObject;", EventVerify.TYPE_LAUNCH, "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerTrafficMonitor {
    String getTrafficId();

    void insertDataForTrafficEvent(JSONObject r100);

    void launch();
}
