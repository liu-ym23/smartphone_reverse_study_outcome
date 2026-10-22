package com.bytedance.android.livehostapi.foundation.depend;

import com.bytedance.android.live.base.IService;

/* JADX INFO: loaded from: classes7.dex */
public interface IPluginTypeFactoryService extends IService {
    IPluginType create(IPluginType r100, String r101, boolean r102, String r103);

    boolean isRegister(IPluginType r100);
}
