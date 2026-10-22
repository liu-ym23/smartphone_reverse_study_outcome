package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: classes9.dex */
public class o implements f {
    public o() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void a(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void b(boolean r100) {
    }

    public String d() {
        return "SimpleGetResourceResult";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void onFailed(Throwable r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void onProgress(int r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void c(long r100, String r101) {
        boolean r102 = com.bytedance.android.live.revenue.core.util.h.f91037a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).mo8235getAssetsManager().cb(r101);
        ALogger.d("SimpleGetResourceResult", "file " + r101 + " update in env: " + d());
    }
}
