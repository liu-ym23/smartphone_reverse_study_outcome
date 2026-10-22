package com.bytedance.android.live.browser;

import com.bytedance.android.annie.api.bridge.RegisterPolicy;
import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/browser/ISaaSBrowserService;", "Lcom/bytedance/android/live/base/IService;", "Lcom/bytedance/ies/web/jsbridge2/d0;", "jsBridge2", "Lcom/bytedance/android/annie/api/bridge/RegisterPolicy;", "registerPolicy", "", "", "Lcom/bytedance/ies/web/jsbridge2/f$b;", "provideDefaultStatefulMethods", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "getExternalMethodFactory", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISaaSBrowserService extends IService {
    BaseJsBridgeMethodFactory getExternalMethodFactory();

    Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideDefaultStatefulMethods(com.bytedance.ies.web.jsbridge2.d0 r100, RegisterPolicy r101);
}
