package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.browser.IBaseBrowserService;

/* JADX INFO: loaded from: classes10.dex */
public final class o implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f143748a;

    public o(m r100) {
        this.f143748a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).provideGetLiveNtpTimeMethod(this.f143748a.f143746b);
    }
}
