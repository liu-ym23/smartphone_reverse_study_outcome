package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.TTLiveSDK;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "set_session_info")
public final class d4 extends s<e4, f4> {
    public d4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        e4 r102 = (e4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if ((r101.getContext() instanceof FragmentActivity) == false) goto L28;
        String r103 = r102.getIdentifier();
        if (r103 != null) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L13;
        finishWithFailure(new Throwable("no input key"));
        return;
    L13:
        HashMap<String, String> r105 = (HashMap) GsonProtectorUtils.fromJson(GsonHelper.get(), r102.a(), new c4().getType());
        if (r105 != null) goto L16;
        r105 = new HashMap();
    L16:
        IHostLiveLocalLife r106 = TTLiveSDK.hostService().hostLiveLocalLife();
        if (r106 != null) goto L19;
    L21:
        boolean r107 = false;
    L22:
        f4 r108 = new f4();
        r108.a(1);
        f4.a r109 = new f4.a();
        if (r107 == false) goto L25;
        int r110 = 1;
    L26:
        r109.a(r110);
        Unit r111 = Unit.INSTANCE;
        r108.b(r109);
        finishWithResult(r108);
        return;
    L25:
        r110 = 0;
        goto L26
    L19:
        if (r106.updateSessionInfo(r103, r105) != true) goto L21;
        r107 = true;
        goto L22
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    }
}
