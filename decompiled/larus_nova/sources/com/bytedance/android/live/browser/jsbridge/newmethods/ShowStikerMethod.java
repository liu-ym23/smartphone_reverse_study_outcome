package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "openFaceStickerPanel")
public final class ShowStikerMethod extends com.bytedance.ies.web.jsbridge2.g<Params, Object> {

    public static final class Params {
        public Params() {
        }
    }

    public ShowStikerMethod() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(Params r100, CallContext r101) throws Exception {
        xs2.b.a().post(new zg1.c2());
        return null;
    }
}
