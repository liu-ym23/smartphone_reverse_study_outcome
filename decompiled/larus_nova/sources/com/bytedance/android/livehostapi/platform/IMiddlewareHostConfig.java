package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.platform.base.IBaseHostConfig;
import com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig;
import com.bytedance.android.livehostapi.platform.depend.IPropertyCache;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddlewareHostConfig extends IService, IBaseHostConfig {
    IMiddlewareHostAppConfig appConfig();

    IPropertyCache pref();
}
