package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "destroyRoomInfoBanner")
public final class m2 extends com.bytedance.ies.web.jsbridge2.g<Object, Object> {
    public m2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Object invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        Intrinsics.checkNotNullParameter(r101, "p1");
        xs2.b.a().post(new com.bytedance.android.livesdk.event.h());
        return null;
    }
}
