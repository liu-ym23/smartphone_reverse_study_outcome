package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "showShortTouchBubble")
public final class k4 extends com.bytedance.ies.web.jsbridge2.f<com.bytedance.android.live.base.model.n, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f142149a;

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public k4() {
        this.f142149a = "ShowShortTouchBubbleMethod";
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(com.bytedance.android.live.base.model.n r100, CallContext r101) {
        com.bytedance.android.live.base.model.n r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "shortTouchArea");
        Intrinsics.checkNotNullParameter(r101, "callContext");
        ALogger.d(this.f142149a, "short touch info is " + GsonProtectorUtils.toJson(new Gson(), r102));
        xs2.b.a().post(new zg1.v(3, r102.type, r102));
        finishWithSuccess();
    }
}
