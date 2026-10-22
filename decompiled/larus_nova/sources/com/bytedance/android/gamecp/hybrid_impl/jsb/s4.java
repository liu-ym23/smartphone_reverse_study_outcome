package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "openAudienceGamePromoteDetail")
public final class s4 extends j0<t4, OpenAudienceGamePromoteDetailResultModel> {

    public static final class a {
    }

    static {
    }

    public s4() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        t4 r102 = (t4) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("openAudienceGamePromoteDetail", GsonProtectorUtils.toJson(new Gson(), r102));
        Context r103 = r101.getContext();
        FragmentActivity r104 = com.bytedance.android.gamecp.common.utils.g.b(r103);
        FragmentManager r105 = null;
        if (r104 == null) goto L5;
        FragmentManager r106 = r104.getSupportFragmentManager();
    L6:
        if (r106 != null) goto L8;
    L14:
        OpenAudienceGamePromoteDetailResultModel r107 = new OpenAudienceGamePromoteDetailResultModel();
        r107.a(OpenAudienceGamePromoteDetailResultModel.Code.Success);
        Unit r108 = Unit.INSTANCE;
        finishWithResult(r107);
        return;
    L8:
        if ((!r106.isStateSaved()) == false) goto L10;
        r105 = r106;
    L10:
        if (r105 == null) goto L14;
        Bundle r109 = new Bundle();
        r109.putString("game_id", r102.d());
        r109.putString("room_id", r102.e());
        r109.putString("anchor_id", r102.a());
        r109.putString("enter_from", r102.c());
        r109.putString("start_page", r102.f());
        r109.putString(com.bytedance.android.ec.core.event.a.KEY_COUPON_TYPE, r102.b());
        xr.f r110 = (xr.f) xr.s.a(xr.f.class);
        if (r110 == null) goto L14;
        r110.showGamePromoteDetailDialog(r103, r109, Boolean.FALSE);
        goto L14
    L5:
        r106 = null;
        goto L6
    }
}
