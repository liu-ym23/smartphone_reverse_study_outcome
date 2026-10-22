package com.bytedance.android.openlive.realtime;

import com.bytedance.android.openlive.realtime.interceptor.DislikeInterceptor;
import com.bytedance.android.openlive.realtime.interceptor.FeedApiRecommendParamsInterceptor;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/openlive/realtime/UserRealtimeSignalFeature;", "Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalFeature;", "()V", "center", "Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "getCenter", "()Lcom/bytedance/android/openlive/realtime/IUserRealtimeSignalCenter;", "center$delegate", "Lkotlin/Lazy;", "dislikeInterceptor", "Lcom/bytedance/retrofit2/intercept/Interceptor;", "getDislikeInterceptor", "()Lcom/bytedance/retrofit2/intercept/Interceptor;", "feedApiInterceptor", "getFeedApiInterceptor", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public class UserRealtimeSignalFeature implements IUserRealtimeSignalFeature {
    private final Lazy center$delegate;
    private final Interceptor dislikeInterceptor;
    private final Interceptor feedApiInterceptor;

    @Override // com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature
    public IUserRealtimeSignalCenter getCenter() {
        return (IUserRealtimeSignalCenter) this.center$delegate.getValue();
    }

    public UserRealtimeSignalFeature() {
        this.center$delegate = LazyKt.lazy(UserRealtimeSignalFeature$center$2.INSTANCE);
        this.feedApiInterceptor = FeedApiRecommendParamsInterceptor.INSTANCE;
        this.dislikeInterceptor = DislikeInterceptor.INSTANCE;
    }

    @Override // com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature
    public Interceptor getDislikeInterceptor() {
        return this.dislikeInterceptor;
    }

    @Override // com.bytedance.android.openlive.realtime.IUserRealtimeSignalFeature
    public Interceptor getFeedApiInterceptor() {
        return this.feedApiInterceptor;
    }
}
