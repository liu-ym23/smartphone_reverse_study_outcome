package com.bytedance.android.livehostapi;

import com.bytedance.android.livehostapi.business.IHostFeed;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livehostapi.platform.IHostLog;
import com.bytedance.android.livehostapi.platform.IHostPerformanceMonitor;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostAction;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostConfig;
import com.bytedance.android.livehostapi.platform.IMiddlewareHostUser;

/* JADX INFO: loaded from: classes7.dex */
public interface IMiddleHostService {
    IMiddlewareHostAction action();

    IMiddleWareHostContext appContext();

    IMiddlewareHostConfig config();

    IHostFeed hostFeed();

    IHostPerformanceMonitor hostPerformanceMonitor();

    IHostLog log();

    IMiddlewareHostUser user();
}
