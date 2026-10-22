package com.bytedance.android.livesdk.service;

import com.bytedance.android.live.platformplayer.LivePlatformPlayerManager;
import com.bytedance.android.live.status.api.IAggregateService;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import javax.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public class a implements IAggregateService {
    public a() {
    }

    @Override // com.bytedance.android.live.status.api.IAggregateService
    @Nullable
    public JSONObject getPlayerStatsLog() {
        ILivePlayerClient r100 = LivePlatformPlayerManager.f();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getStatsLog();
    }

    @Override // com.bytedance.android.live.status.api.IAggregateService
    @Nullable
    public String getPlayerStatsLog(String r100) {
        JSONObject r101 = getPlayerStatsLog();
        if (r101 != null) goto L5;
        return null;
    L5:
        if (r101.has(r100) == true) goto L7;
        return null;
    L7:
        return r101.optString(r100);
    }
}
