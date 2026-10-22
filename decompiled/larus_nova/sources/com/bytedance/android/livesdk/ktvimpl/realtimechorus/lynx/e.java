package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f146716a;

    public e(DataCenter r100) {
        this.f146716a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).provideRegisterMessageLatchMethod(this.f146716a);
    }
}
