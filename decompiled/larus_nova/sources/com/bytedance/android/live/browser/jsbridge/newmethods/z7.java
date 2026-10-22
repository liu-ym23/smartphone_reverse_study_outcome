package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostDouyinIm;
import com.bytedance.android.livesdk.config.LiveConfigSettingKeys;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "updateUnreadCount")
public final class z7 extends com.bytedance.ies.web.jsbridge2.g<JSONObject, Unit> {
    public z7() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.g
    public final Unit invoke(JSONObject r100, CallContext r101) {
        JSONObject r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, "callCtx");
        int r103 = JSONObjectProtectorUtils.getInt(r102, "count");
        Disposable r104 = om2.a.f524238b;
        IHostDouyinIm r105 = TTLiveSDK.hostService().hostDouyinIm();
        if (r105 != null) goto L5;
    L9:
        om2.a.b(r103);
    L11:
        return Unit.INSTANCE;
    L5:
        if (r105.isAuthSuccess() != true) goto L9;
        if (LiveConfigSettingKeys.SHOW_DOUYIN_IM_ENTRANCE.getValue().booleanValue() == false) goto L9;
        goto L9
    }
}
