package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import com.bytedance.android.live.browser.IBaseBrowserService;

/* JADX INFO: loaded from: classes10.dex */
public final class r implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m f143751a;

    public r(m r100) {
        this.f143751a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).provideRegisterWRDSMethod(this.f143751a.f143746b);
    }
}
