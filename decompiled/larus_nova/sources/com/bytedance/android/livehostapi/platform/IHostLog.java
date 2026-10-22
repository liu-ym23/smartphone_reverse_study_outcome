package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostLog;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostLog extends IService, IBaseHostLog {
    void flush();

    void logV3(String r100, Map<String, String> r101);
}
