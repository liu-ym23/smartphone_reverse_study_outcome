package com.bytedance.android.livesdkapi.roomplayer;

import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u001c\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\r\u001a\u00020\u0003H&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/roomplayer/ILivePlayerVqosLogger;", "", "asyncSendLiveLog", "", "object", "Lorg/json/JSONObject;", "asyncSendLiveLogV2", "tag", "", "markStart", "packLogParam", "jsonObject", "packUsedLogParam", "resetMark", "vqosMonitor", "msg", "extra", "live-player-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILivePlayerVqosLogger {

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static /* synthetic */ void vqosMonitor$default(ILivePlayerVqosLogger r100, String r101, JSONObject r102, JSONObject r103, int r104, Object r105) {
            if (r105 != null) goto L12;
            if ((r104 & 2) == 0) goto L7;
            r102 = null;
        L7:
            if ((r104 & 4) == 0) goto L9;
            r103 = null;
        L9:
            r100.vqosMonitor(r101, r102, r103);
            return;
        L12:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: vqosMonitor");
        }
    }

    void asyncSendLiveLog(JSONObject r100);

    void asyncSendLiveLogV2(JSONObject r100, String r101);

    void markStart();

    void packLogParam(JSONObject r100);

    void packUsedLogParam(JSONObject r100);

    void resetMark();

    void vqosMonitor(String r100, JSONObject r101, JSONObject r102);
}
