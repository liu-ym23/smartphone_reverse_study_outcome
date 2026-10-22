package com.bytedance.android.live.network.impl.interceptor;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomService;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;

/* JADX INFO: loaded from: classes46.dex */
public final class r implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ILiveRoomService f83891a;

    public r() {
        this.f83891a = (ILiveRoomService) jc1.k.f(ILiveRoomService.class);
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse intercept(Interceptor.Chain r100) throws Exception {
        Request r101 = r100.request();
        this.f83891a.interceptLinkRequest(r101.getPath());
        return r100.proceed(r101);
    }
}
