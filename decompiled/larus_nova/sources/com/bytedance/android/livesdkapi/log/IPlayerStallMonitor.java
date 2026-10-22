package com.bytedance.android.livesdkapi.log;

import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdkapi/log/IPlayerStallMonitor;", "", EventVerify.TYPE_LAUNCH, "", "stallDetectFromStreamTrace", "event", "Lorg/json/JSONObject;", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlayerStallMonitor {
    void launch();

    void stallDetectFromStreamTrace(JSONObject r100);
}
