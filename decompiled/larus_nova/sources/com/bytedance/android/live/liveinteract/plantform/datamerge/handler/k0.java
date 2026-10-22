package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class k0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j0 f76458a;

    public k0(j0 r100) {
        this.f76458a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        dh0.a r101 = (dh0.a) r100;
        j0 r102 = this.f76458a;
        r102.getClass();
        gh0.b.a("AudioAnchorGuide", "onMultiLinkAudioAnchorGuideAnimEvent", false);
        r102.a().k1(new ch0.l(0, null));
    }
}
