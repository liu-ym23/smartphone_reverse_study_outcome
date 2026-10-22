package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "gamePromoteAutoDownload")
public final class y2 extends n<a3, GamePromoteAutoDownloadResultModel> {

    public static final class a {
    }

    static {
    }

    public y2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r110, CallContext r111) {
        a3 r100 = (a3) r110;
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        n1.a("gamePromoteAutoDownload", GsonProtectorUtils.toJson(new Gson(), r100));
        String r101 = r100.c();     // Catch: Exception -> L55
        String r102 = "";
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (r101.length() != 0) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        GamePromoteAutoDownloadResultModel r104 = new GamePromoteAutoDownloadResultModel();     // Catch: Exception -> L55
        r104.a(GamePromoteAutoDownloadResultModel.Code.Failed);     // Catch: Exception -> L55
        JSONObject r105 = new JSONObject();     // Catch: Exception -> L55
        r105.put("error_reason", "game id is null");     // Catch: Exception -> L55
        Unit r106 = Unit.INSTANCE;     // Catch: Exception -> L55
        r104.b(r105.toString());     // Catch: Exception -> L55
        finishWithResult(r104);     // Catch: Exception -> L55
        return;
    L13:
        String r107 = r100.d();     // Catch: Exception -> L55
        if (r107 != null) goto L16;
        r107 = "";
    L16:
        Integer r108 = r100.j();     // Catch: Exception -> L55
        if (r108 == null) goto L19;
        int r109 = r108.intValue();     // Catch: Exception -> L55
    L20:
        long r112 = r109;
        String r113 = r100.g();     // Catch: Exception -> L55
        if (r113 == null) goto L24;
        r102 = r113;
    L24:
        String r114 = r100.b();     // Catch: Exception -> L55
        if (r114 != null) goto L27;
    L29:
        boolean r115 = false;
    L30:
        if (r115 == false) goto L35;
        String r116 = r100.b();     // Catch: Exception -> L55
        if (r116 == null) goto L34;
        long r117 = CastLongProtector.parseLong(r116);     // Catch: Exception -> L55
    L40:
        Integer r118 = r100.h();     // Catch: Exception -> L55
        String r119 = r100.i();     // Catch: Exception -> L55
        List<String> r120 = r100.e();     // Catch: Exception -> L55
        String r121 = r100.f();     // Catch: Exception -> L55
        JSONObject r122 = new JSONObject();     // Catch: Exception -> L55
        r122.put("game_id", r101);     // Catch: Exception -> L55
        r122.put(EventConstants.ExtraJson.GAME_NAME, r107);     // Catch: Exception -> L55
        r122.put("scene", r112);     // Catch: Exception -> L55
        r122.put(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_ID, r102);     // Catch: Exception -> L55
        r122.put(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID, r117);     // Catch: Exception -> L55
        r122.put("reserve_type", r118);     // Catch: Exception -> L55
        r122.put("reserve_version_num", r119);     // Catch: Exception -> L55
        List<String> r123 = r120;     // Catch: Exception -> L55
        if (r123 != null) goto L43;
    L46:
        boolean r124 = true;
    L47:
        if (r124 == true) goto L49;
        r122.put("game_package_name", ListProtector.get(r120, 0));     // Catch: Exception -> L55
    L49:
        if (r121 == null) goto L51;
        r122.put("plan_id", r121);     // Catch: Exception -> L55
    L51:
        xr.f r125 = (xr.f) xr.s.a(xr.f.class);     // Catch: Exception -> L55
        if (r125 == null) goto L59;
        r125.W1(r111.getContext(), r122, new z2(this));     // Catch: Exception -> L55
        return;
    L59:
        return;
    L43:
        if (r123.isEmpty() == true) goto L46;
        r124 = false;
        goto L47
    L34:
        r117 = 0;
        goto L40
    L35:
        Integer r126 = r100.a();     // Catch: Exception -> L55
        if (r126 == null) goto L38;
        int r127 = r126.intValue();     // Catch: Exception -> L55
    L39:
        r117 = r127;
        goto L40
    L38:
        r127 = 0;
        goto L39
    L27:
        if (r114.length() <= 0) goto L29;
        r115 = true;
        goto L30
    L19:
        r109 = 0;
        goto L20
    L10:
        r103 = false;
    L55:
        GamePromoteAutoDownloadResultModel r128 = new GamePromoteAutoDownloadResultModel();
        r128.a(GamePromoteAutoDownloadResultModel.Code.Failed);
        JSONObject r129 = new JSONObject();
        r129.put("error_reason", "client crash");
        Unit r130 = Unit.INSTANCE;
        r128.b(r129.toString());
        finishWithResult(r128);
    }
}
