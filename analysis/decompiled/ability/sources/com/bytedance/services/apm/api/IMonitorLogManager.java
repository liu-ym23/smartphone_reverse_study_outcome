package com.bytedance.services.apm.api;

import B.d;
import com.bytedance.news.common.service.manager.IService;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface IMonitorLogManager extends IService {
    void deleteLegacyLogByIds(String str, String str2);

    void getLegacyLog(long j5, long j6, String str, d dVar);

    List<JSONObject> getRecentUiActionRecords();
}
