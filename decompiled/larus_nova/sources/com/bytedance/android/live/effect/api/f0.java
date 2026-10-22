package com.bytedance.android.live.effect.api;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 implements ILiveEffectComposerManager.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.a f66765a;

    public f0(kh0.a.d r100) {
        this.f66765a = r100;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r100, Sticker r101) {
        this.f66765a.a(r100, r101);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r100, String r101, Sticker r102) {
        this.f66765a.b(r100, r101, r102);
    }
}
