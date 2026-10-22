package com.bytedance.android.openlive.realtime;

import com.bytedance.android.live.base.IService;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalFeature;", "Lcom/bytedance/android/live/base/IService;", "center", "Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "getCenter", "()Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "dislikeInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getDislikeInterceptor", "()Lcom/bytedance/retrofit2/intercept/Interceptor;", "feedApiInterceptor", "getFeedApiInterceptor", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IUserRealtimeSignalFeature extends IService {
    IUserRealtimeSignalCenter getCenter();

    Interceptor getDislikeInterceptor();

    Interceptor getFeedApiInterceptor();
}
