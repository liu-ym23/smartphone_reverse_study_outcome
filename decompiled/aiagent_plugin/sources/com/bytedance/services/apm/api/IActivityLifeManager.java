package com.bytedance.services.apm.api;

import com.bytedance.news.common.service.manager.IService;

/* JADX INFO: loaded from: classes.dex */
public interface IActivityLifeManager extends IService {
    boolean isForeground();

    void register(d r1);

    void unregister(d r1);
}
