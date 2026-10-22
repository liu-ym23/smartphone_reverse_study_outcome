package com.bytedance.android.live.status.api;

import com.bytedance.android.live.base.IService;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
public interface IAggregateService extends IService {
    String getPlayerStatsLog(String r100);

    JSONObject getPlayerStatsLog();
}
