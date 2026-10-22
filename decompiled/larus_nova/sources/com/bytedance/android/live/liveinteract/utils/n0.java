package com.bytedance.android.live.liveinteract.utils;

import com.bytedance.android.live.browser.IBaseBrowserService;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes46.dex */
public final class n0 implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f78809a;

    public n0(DataCenter r100) {
        this.f78809a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return ((IBaseBrowserService) jc1.k.n(IBaseBrowserService.class)).provideRegisterMessageLatchMethod(this.f78809a);
    }
}
