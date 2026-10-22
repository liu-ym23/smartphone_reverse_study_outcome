package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* loaded from: classes2.dex */
public interface ILaunchTrace extends IService {
    void cancelTrace();

    void endSpan(String str, String str2);

    void endTrace(int i, String str, long j5);

    void startSpan(String str, String str2);

    void startTrace();
}
