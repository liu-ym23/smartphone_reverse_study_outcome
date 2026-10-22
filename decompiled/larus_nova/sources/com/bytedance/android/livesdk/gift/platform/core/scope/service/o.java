package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class o implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f131658a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r100) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r100) {
        Intrinsics.checkNotNullParameter(r100, "t");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r100) {
    }

    public o(p r100) {
        this.f131658a = r100;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "path");
        Map<Long, Integer> r102 = this.f131658a.f131681a;
        HashMap r103 = (HashMap) r102;
        r103.remove(Long.valueOf(r100));
    }
}
