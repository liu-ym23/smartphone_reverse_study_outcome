package com.bytedance.android.livehostapi.business;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCpLiveService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&¨\u0006\u0004À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/IMiddlewareHostGameCP;", "Lcom/bytedance/android/live/base/IService;", "getGameCpLiveService", "Lcom/bytedance/android/livehostapi/business/depend/gamecp/IGameCpLiveService;", "hostapp-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IMiddlewareHostGameCP extends IService {
    IGameCpLiveService getGameCpLiveService();
}
