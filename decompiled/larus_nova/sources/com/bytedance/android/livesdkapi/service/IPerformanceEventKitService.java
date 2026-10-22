package com.bytedance.android.livesdkapi.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@ServiceLookup("com.bytedance.android.livesdkapi.service.IPerformanceEventKitService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/IPerformanceEventKitService;", "Lcom/bytedance/android/live/base/IService;", "trigger", "", "event", "", WsConstants.KEY_PAYLOAD, "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPerformanceEventKitService extends IService {
    void trigger(String r100, Object r101);
}
