package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.y;
import com.bytedance.android.livesdkapi.service.MessageHub;

/* JADX INFO: loaded from: classes10.dex */
public final class n implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f146729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MessageHub f146730b;

    public n(c r100, MessageHub r101) {
        this.f146729a = r100;
        this.f146730b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new y(this.f146729a.f146709l, this.f146730b);
    }
}
