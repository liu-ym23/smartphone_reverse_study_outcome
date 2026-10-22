package com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx;

import com.bytedance.android.live.liveinteract.jsbridge.method.DynamicRegisterMessageMethod;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: classes10.dex */
public final class f implements com.bytedance.ies.web.jsbridge2.f.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DataCenter f146717a;

    public f(DataCenter r100) {
        this.f146717a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f.b
    public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
        return new DynamicRegisterMessageMethod(this.f146717a);
    }
}
