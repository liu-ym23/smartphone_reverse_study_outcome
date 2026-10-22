package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostOCRPreloadApiProxy extends IService {
    void mobReadSetting(String r100, String r101);

    boolean supportTryPreload();
}
