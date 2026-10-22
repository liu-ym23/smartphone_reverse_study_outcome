package com.bytedance.android.livehostapi.platform;

import com.bytedance.android.livehostapi.platform.depend.IHostAppConfig;
import com.bytedance.android.livehostapi.platform.depend.IMiddlewareHostAppConfig;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostConfig extends IMiddlewareHostConfig {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.platform.IHostConfig$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* bridge */ /* synthetic */ IMiddlewareHostAppConfig $default$appConfig(IHostConfig r100) {
            return r100.appConfig();
        }
    }

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig
    IHostAppConfig appConfig();

    @Override // com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig
    /* bridge */ /* synthetic */ IMiddlewareHostAppConfig appConfig();
}
