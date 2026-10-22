package com.bytedance.android.livesdk.jsbridge.methods;

import com.bytedance.android.live.base.model.user.IUser;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.browser.jsbridge.base.StartPrivateVIPLiveResultModel;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import w20.cf;
import w20.s6;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "startPrivateVIPLive")
public final class m4 extends s6<cf, StartPrivateVIPLiveResultModel> {
    public m4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        cf r102 = (cf) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        IUserService r103 = (IUserService) jc1.k.f(IUserService.class);
        if (r103 == null) goto L11;
        com.bytedance.android.livesdk.user.f r104 = r103.user();
        if (r104 == null) goto L11;
        IUser r105 = r104.b();
        if (r105 == null) goto L11;
        if (r105.getSecret() != 1) goto L11;
        com.bytedance.android.live.core.utils.f2.b(R.string.ttlive_only_non_secret_can_restart, 0);
        finishWithFailure();
        return;
    L11:
        ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).closeAndRestartBroadcast(r101.getContext(), !Intrinsics.areEqual(r102.a(), Boolean.TRUE));
        finishWithSuccess();
    }
}
