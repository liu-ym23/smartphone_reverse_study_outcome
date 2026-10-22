package com.bytedance.android.livesdk.jsbridge.methods;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livehostapi.business.IHostLiveLocalLife;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
@XBridgeMethod(biz = "webcast", name = "fetch_session_info")
public final class s0 extends c<t0, FetchSessionInfoResultModel> {
    public s0() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        t0 r102 = (t0) r100;
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
        JSONObject r105 = ((IHostLiveLocalLife) jc1.k.n(IHostLiveLocalLife.class)).fetchSessionInfo(r103);
        if (r105 == null) goto L24;
        FetchSessionInfoResultModel r106 = new FetchSessionInfoResultModel();
        r106.a(FetchSessionInfoResultModel.Code.Success);
        FetchSessionInfoResultModel.a r107 = new FetchSessionInfoResultModel.a();
        JsonElement r108 = GsonHelper.parser().parse(r105.toString());     // Catch: Exception -> L22
        if (r108 == null) goto L19;
        JsonObject r109 = r108.getAsJsonObject();     // Catch: Exception -> L22
    L20:
        r107.a(r109);     // Catch: Exception -> L22
    L23:
        Unit r110 = Unit.INSTANCE;
        r106.b(r107);
        finishWithResult(r106);
        return;
    L19:
        r109 = null;
    L22:
        finishWithFailure(new Throwable("no session info"));
        goto L23
    L24:
        new FetchSessionInfoMethod$invoke$2(this);
        return;
    L7:
        if (r103.length() == 0) goto L10;
        r104 = false;
        goto L11
    }
}
