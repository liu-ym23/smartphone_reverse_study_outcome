package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamePromoteSendAdEvent")
public final class f3 extends p<g3, GamePromoteSendAdEventResultModel> {

    public static final class a {
    }

    static {
    }

    public f3() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        g3 r102 = (g3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamePromoteSendAdEvent", GsonProtectorUtils.toJson(new Gson(), r102));
        String r103 = r102.b();
        if (r103 != null) goto L5;
        String r104 = "";
    L6:
        String r105 = r102.c();
        if (r105 != null) goto L9;
        String r106 = "";
    L10:
        g3.a r107 = r102.a();
        JSONObject r108 = new JSONObject();
        Integer r109 = null;
        if (r107 == null) goto L13;
        String r110 = r107.a();
    L14:
        r108.put("anchor_id", r110);
        if (r107 == null) goto L17;
        String r111 = r107.e();
    L18:
        r108.put("room_id", r111);
        if (r107 == null) goto L21;
        String r112 = r107.b();
    L22:
        r108.put("game_id", r112);
        if (r107 == null) goto L25;
        String r113 = r107.c();
    L26:
        r108.put(EventConstants.ExtraJson.GAME_NAME, r113);
        if (r107 == null) goto L29;
        r109 = r107.d();
    L29:
        r108.put("game_status", r109);
        if (r107 == null) goto L36;
        String r114 = r107.e();
        if (r114 == null) goto L36;
        Long r115 = StringsKt.toLongOrNull(r114);
        if (r115 == null) goto L36;
        long r116 = r115.longValue();
    L37:
        long r117 = r116;
        xr.f r118 = (xr.f) xr.s.a(xr.f.class);
        if (r118 == null) goto L41;
        r118.sendAdLog(r104, r106, r117, r108);
        return;
    L41:
        return;
    L36:
        r116 = 0;
        goto L37
    L25:
        r113 = null;
        goto L26
    L21:
        r112 = null;
        goto L22
    L17:
        r111 = null;
        goto L18
    L13:
        r110 = null;
        goto L14
    L9:
        r106 = r105;
        goto L10
    L5:
        r104 = r103;
        goto L6
    }
}
