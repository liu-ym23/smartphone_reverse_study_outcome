package com.bytedance.android.livesdk.chatroom.resolution.newresolution.interceptor;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IQuality;
import com.bytedance.android.livesdkapi.depend.model.live.StreamUrl;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a implements ResolutionInterceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f110483a;

    public a() {
        this.f110483a = 4;
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final int getInterceptLevel() {
        return this.f110483a;
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final void setInterceptLevel(int r100) {
        this.f110483a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final int getResolutionLevelBySdkKey(IBaseStreamUrl r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "streamUrl");
        Intrinsics.checkNotNullParameter(r101, "resolutionSdkKey");
        return ResolutionInterceptor.DefaultImpls.getResolutionLevelBySdkKey(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final IQuality getResolutionQualityByLevel(StreamUrl r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "streamUrl");
        return ResolutionInterceptor.DefaultImpls.getResolutionQualityByLevel(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final String getResolutionSdkKeyByLevel(IBaseStreamUrl r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "streamUrl");
        return ResolutionInterceptor.DefaultImpls.getResolutionSdkKeyByLevel(this, r100, r101);
    }

    @Override // com.bytedance.android.livesdkapi.resolution.ResolutionInterceptor
    public final PlayerResolution.PickResult intercept(long r110, IBaseStreamUrl r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r111, "streamUrl");
        Intrinsics.checkNotNullParameter(r112, "defaultResolutionKey");
        Intrinsics.checkNotNullParameter(r113, "resolutionScene");
        String r100 = r111.getDefaultQualityStrategy();
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        PlayerResolution.PickResult r114 = new PlayerResolution.PickResult(r112, "4", r100, null, null, null, 56, null);
        if (r112.length() != 0) goto L8;
        boolean r115 = true;
    L9:
        if (r115 == false) goto L11;
        r114.setPickStrategy("-1");
    L11:
        com.bytedance.android.livesdk.chatroom.resolution.newresolution.processor.a.a(r110, r114);
        ALogger.i("ResolutionInterceptor", "roomId:" + r110 + " Intercept by RoomDefaultInterceptor,sdkKey:" + r114.getResultSdkKey() + ",roomDefault:" + r111.getMultiStreamDefaultQualitySdkKey());
        return r114;
    L8:
        r115 = false;
        goto L9
    }
}
