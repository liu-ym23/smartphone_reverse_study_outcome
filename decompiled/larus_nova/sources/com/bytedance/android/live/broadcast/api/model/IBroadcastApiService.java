package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.api.BroadcastApiService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/IBroadcastApiService;", "Lcom/bytedance/android/live/base/IService;", "getCurrentResolutionKey", "", "livebroadcast-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastApiService extends IService {
    String getCurrentResolutionKey();
}
