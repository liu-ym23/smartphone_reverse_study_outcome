package com.bytedance.android.live.broadcast.api.scope.global;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.utility.ServiceLookup;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ServiceLookup("com.bytedance.android.live.broadcast.BroadcastInitService")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/scope/global/IBroadcastInitService;", "Lcom/bytedance/android/live/base/IService;", "start", "", "source", "", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBroadcastInitService extends IService {
    void start(String r100);
}
