package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes10.dex */
public final class g implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f146718a;

    public g(DataCenter r100) {
        this.f146718a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        IBaseBrowserService r100 = (IBaseBrowserService) jc1.k.f(IBaseBrowserService.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.provideRegisterWRDSMethod(this.f146718a);
    }
}
