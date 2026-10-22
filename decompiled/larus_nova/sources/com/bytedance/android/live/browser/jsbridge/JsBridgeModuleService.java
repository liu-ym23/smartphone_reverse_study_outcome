package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IMiddlewareJsBridgeManager;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/JsBridgeModuleService;", "Lcom/bytedance/android/live/browser/jsbridge/IJsBridgeModuleService;", "()V", "createJsbridgeManager", "Lcom/bytedance/android/livesdkapi/hybridapi/IMiddlewareJsBridgeManager;", "livehybrid-middleware-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class JsBridgeModuleService implements IJsBridgeModuleService {
    public JsBridgeModuleService() {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.IJsBridgeModuleService
    public IMiddlewareJsBridgeManager createJsbridgeManager() {
        return new q();
    }
}
