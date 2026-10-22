package com.bytedance.android.livesdk.revenue.service.performance;

import com.bytedance.android.live.pushstream.IEffectPerfToolsHelper;
import com.bytedance.android.livesdk.live.extension.plugin.api.effectsdk.ILiveWrappedEffectSDKService;
import jc1.k;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements b {
    public g() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.b
    public final void W7() {
        if (((IEffectPerfToolsHelper) k.n(IEffectPerfToolsHelper.class)).checkDebug() == false) goto L11;
        IEffectPerfToolsHelper r100 = (IEffectPerfToolsHelper) k.n(IEffectPerfToolsHelper.class);
        ILiveWrappedEffectSDKService.Companion.getClass();
        ILiveWrappedEffectSDKService r101 = ILiveWrappedEffectSDKService.a.a();
        if (r101 == null) goto L8;
        String r102 = r101.getSdkVersion();
        if (r102 == null) goto L8;
    L9:
        r100.setPerfToolsNormalData("data_effect_sdk_version", r102);
        return;
    L8:
        r102 = "";
        goto L9
    }

    @Override // com.bytedance.android.livesdk.revenue.service.performance.b
    public final void requestBlockGc(int r100) {
        cu2.b.f465422c.getClass();
        cu2.b.a.a(r100);
    }
}
