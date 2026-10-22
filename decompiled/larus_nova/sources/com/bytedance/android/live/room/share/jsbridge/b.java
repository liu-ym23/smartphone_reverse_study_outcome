package com.bytedance.android.live.room.share.jsbridge;

import android.app.Activity;
import android.content.Context;
import com.bytedance.android.live.room.api.ILiveShareService;
import com.bytedance.android.live.room.api.share.model.LiveShareType;
import com.bytedance.android.livehostapi.business.depend.share.LiveWebShareParams;
import com.bytedance.android.livehostapi.business.depend.share.ShareParams;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@XBridgeMethod(biz = "webcast", name = "fullParamsSharePanel")
public final class b extends com.bytedance.ies.web.jsbridge2.f<LiveWebShareParams, Object> {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(LiveWebShareParams r210, CallContext r211) {
        LiveWebShareParams r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r211, "callContext");
        ShareParams.Builder r101 = ShareParams.builder();
        r101.setLiveWebShareParams(r100);
        ILiveShareService r102 = (ILiveShareService) jc1.k.n(ILiveShareService.class);
        ShareParams r103 = r101.build();
        Context r104 = r211.getContext();
        if (r104 == null) goto L7;
        r102.share(new i81.a(null, (Activity) r104, null, r103, null, null, null, null, null, null, null, Boolean.FALSE, null, null, null, null, false), "ShareFullParamsMethod", LiveShareType.SHARE_DIALOG, new c(this, r100));
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}
