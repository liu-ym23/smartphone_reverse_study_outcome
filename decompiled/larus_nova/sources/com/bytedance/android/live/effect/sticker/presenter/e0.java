package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e0 implements com.bytedance.android.live.effect.api.k.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.b f68307a;

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void onFetchFailed() {
        com.bytedance.android.live.effect.api.k.b r100 = this.f68307a;
        if (r100 == null) goto L6;
        r100.onFetchFailed();
        return;
    }

    public e0(com.bytedance.android.live.effect.api.k.b r100) {
        this.f68307a = r100;
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void a(List<Effect> r100, EffectDataFetchCacheType r101) {
        Intrinsics.checkNotNullParameter(r100, "effectList");
        Intrinsics.checkNotNullParameter(r101, "cacheType");
        com.bytedance.android.live.effect.api.k.b r102 = this.f68307a;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
