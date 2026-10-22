package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamecpDataConnection")
public final class z1 extends t<l3, GamecpDataConnectionResultModel> {

    public static final class a {
    }

    static {
    }

    public z1() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        l3 r102 = (l3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamecpDataConnection", GsonProtectorUtils.toJson(new Gson(), r102));
        HashMap r103 = new HashMap();
        String r104 = r102.f();
        String r105 = "";
        if (r104 != null) goto L5;
        r104 = "";
    L5:
        r103.put("game_id", r104);
        String r106 = r102.a();
        if (r106 != null) goto L8;
        r106 = "";
    L8:
        r103.put("action_type", r106);
        Integer r107 = r102.g();
        String r108 = "0";
        if (r107 == null) goto L12;
        String r109 = String.valueOf(r107.intValue());
        if (r109 == null) goto L12;
    L13:
        r103.put("is_ads", r109);
        String r110 = r102.b();
        if (r110 != null) goto L16;
        r110 = "";
    L16:
        r103.put("host_id", r110);
        String r111 = r102.d();
        if (r111 != null) goto L19;
        r111 = "";
    L19:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r111);
        String r112 = r102.e();
        if (r112 != null) goto L22;
        r112 = "";
    L22:
        r103.put("scene", r112);
        String r113 = r102.c();
        if (r113 == null) goto L26;
        r105 = r113;
    L26:
        r103.put("req_id", r105);
        Integer r114 = r102.h();
        if (r114 == null) goto L32;
        String r115 = String.valueOf(r114.intValue());
        if (r115 == null) goto L32;
        r108 = r115;
    L32:
        r103.put("if_promote_icon", r108);
        xr.f r116 = (xr.f) xr.s.a(xr.f.class);
        if (r116 == null) goto L35;
        r116.dataChannelLinkEvent("douyin_game_content_consume_click_monitor", r103);
    L35:
        GamecpDataConnectionResultModel r117 = new GamecpDataConnectionResultModel();
        r117.a(GamecpDataConnectionResultModel.Code.Success);
        Unit r118 = Unit.INSTANCE;
        finishWithResult(r117);
        return;
    L12:
        r109 = "0";
        goto L13
    }
}
