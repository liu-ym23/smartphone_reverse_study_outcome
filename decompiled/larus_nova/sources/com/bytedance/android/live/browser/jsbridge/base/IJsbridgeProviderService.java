package com.bytedance.android.live.browser.jsbridge.base;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/IJsbridgeProviderService;", "Lcom/bytedance/android/live/base/IService;", "provideRoomJsbridgeFactory", "Lcom/bytedance/android/livesdkapi/hybridapi/BaseJsBridgeMethodFactory;", "livehybrid-middleware-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsbridgeProviderService extends IService {
    BaseJsBridgeMethodFactory provideRoomJsbridgeFactory();
}
