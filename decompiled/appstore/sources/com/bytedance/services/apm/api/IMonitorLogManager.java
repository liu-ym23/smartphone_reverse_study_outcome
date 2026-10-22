package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String r10, String r11);

    void getLegacyLog(long r10, long r11, String r12, IMonitorLogQueryCallback r13);

    List<JSONObject> getRecentUiActionRecords();
}
