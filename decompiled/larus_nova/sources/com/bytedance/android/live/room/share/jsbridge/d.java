package com.bytedance.android.live.room.share.jsbridge;

import com.bytedance.android.annie.bridge.JSBridgeManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "shareInfo")
public final class d extends com.bytedance.ies.web.jsbridge2.f<i81.c, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public y6.d f100292a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f100292a = null;
    }

    public d(m16.b r100) {
        JSBridgeManager r101 = (JSBridgeManager) r100.c(JSBridgeManager.class);
        if (r101 == null) goto L6;
        this.f100292a = r101.f38447t;
        return;
    }

    public d(y6.d r100) {
        this.f100292a = r100;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(i81.c r100, CallContext r101) throws Exception {
        i81.c r102 = r100;
        this.f100292a.DY(new y6.e(r102.title, r102.desc, r102.image, r102.url));
        finishWithSuccess();
    }
}
