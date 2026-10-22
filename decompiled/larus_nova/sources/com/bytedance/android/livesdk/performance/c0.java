package com.bytedance.android.livesdk.performance;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.LiveSmallItemBeautyHelper;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes11.dex */
public final class c0 implements LiveSmallItemBeautyHelper.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f154478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LiveSmallItemBeautyHelper f154479b;

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
    public final void onError() {
        ALogger.e("LivePerformanceDefence", "sync effect error for " + this.f154478a);
    }

    @Override // com.bytedance.android.live.effect.LiveSmallItemBeautyHelper.b
    public final void a(Sticker r100) {
        this.f154479b.h(r100, LiveEffectSettings.LIVE_EFFECT_BEAUTY_PANEL_UPGRADE_CONFIG.getValue().a());
    }

    public c0(String r100, LiveSmallItemBeautyHelper r101) {
        this.f154478a = r100;
        this.f154479b = r101;
    }
}
