package com.bytedance.android.live.platformplayer.init;

import com.bytedance.android.livesdk.config.w51;
import com.bytedance.android.livesdkapi.host.ILivePlayerNetwork;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerApi;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements ILivePlayerNetwork {
    public d() {
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerNetwork
    public final String apiHost() {
        return "aweme.snssdk.com";
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerNetwork
    public final ILivePlayerApi createLivePlayerAPI() {
        int r100 = w51.f121499a;
        um0.a r101 = om0.c.i();
        if (r101 == null) goto L7;
        ILivePlayerApi r102 = (ILivePlayerApi) r101.getService(ILivePlayerApi.class);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return (ILivePlayerApi) com.bytedance.android.live.network.c.b().e(ILivePlayerApi.class);
    }

    @Override // com.bytedance.android.livesdkapi.host.ILivePlayerNetwork
    public final <T> T createAPIByClass(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "cls");
        int r101 = w51.f121499a;
        um0.a r102 = om0.c.i();
        if (r102 == null) goto L7;
        T r103 = (T) r102.getService(r100);
        if (r103 == null) goto L7;
        return r103;
    L7:
        return (T) com.bytedance.android.live.network.c.b().e(r100);
    }
}
