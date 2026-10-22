package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "checkGameCPPropConsentPrivacy")
public final class e1 extends c<JsonObject, CheckGameCPPropConsentPrivacyResultModel> {

    public static final class a {
    }

    static {
    }

    public e1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        Intrinsics.checkNotNullParameter((JsonObject) r100, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (com.bytedance.android.gamecp.common.utils.a1.b().getBoolean("live.pref.PREF_SHOW_GAME_PROMOTE_PROP_USAGE", false) == false) goto L5;
        CheckGameCPPropConsentPrivacyResultModel r102 = new CheckGameCPPropConsentPrivacyResultModel();
        r102.a(CheckGameCPPropConsentPrivacyResultModel.Code.Success);
        CheckGameCPPropConsentPrivacyResultModel.a r103 = new CheckGameCPPropConsentPrivacyResultModel.a();
        r103.a(1);
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        finishWithResult(r102);
        return;
    L5:
        xr.f r105 = (xr.f) xr.s.a(xr.f.class);
        if (r105 == null) goto L10;
        r105.k0(r101.getContext(), new LinkedHashMap(), new f1(this));
        return;
    }
}
