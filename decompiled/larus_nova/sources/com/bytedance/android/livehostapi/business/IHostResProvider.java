package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.base.IBaseHostResProvider;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostResProvider extends IService, IBaseHostResProvider {
    int getPauseIconResIdForNotify();

    int getPlayIconResIdForNotify();
}
