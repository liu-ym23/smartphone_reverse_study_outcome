package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String r1, String r2);

    void endTrace(int r1, String r2, long r3);

    void startSpan(String r1, String r2);

    void startTrace();
}
