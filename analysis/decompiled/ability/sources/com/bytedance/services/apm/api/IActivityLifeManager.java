package com.bytedance.services.apm.api;

import B.c;
import com.bytedance.news.common.service.manager.IService;

/* loaded from: classes2.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(c cVar);

    void unregister(c cVar);
}
