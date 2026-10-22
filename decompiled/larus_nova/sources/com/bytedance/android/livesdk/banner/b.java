package com.bytedance.android.livesdk.banner;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InRoomBannerManager f104270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f104271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f104272c;

    public b(InRoomBannerManager r100, int r101, long r102) {
        this.f104270a = r100;
        this.f104271b = r101;
        this.f104272c = r102;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        int r102 = InRoomBannerManager.f104248g;
        ALogger.e("InRoomBannerManager", r101);
        InRoomBannerManager.b(this.f104270a, this.f104271b, this.f104272c, r101);
    }
}
