package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.hybridapi.IMiddlewareJsBridgeManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeModuleService;", "Lcom/bytedance/android/live/base/IService;", "createJsbridgeManager", "Lcom/bytedance/android/livesdkapi/hybridapi/IMiddlewareJsBridgeManager;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsBridgeModuleService extends IService {
    IMiddlewareJsBridgeManager createJsbridgeManager();
}
