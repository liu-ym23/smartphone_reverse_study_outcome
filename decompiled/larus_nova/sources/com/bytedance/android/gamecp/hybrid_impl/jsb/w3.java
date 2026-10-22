package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "getGameCPDetailPageNodeData")
public final class w3 extends b0<x3, GetGameCPDetailPageNodeDataResultModel> {

    public static final class a {
    }

    static {
    }

    public w3() {
    }

    public static JSONObject j(JSONObject r100, Regex r101) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length() != 0) goto L7;
        return null;
    L7:
        if (r101.matches(r100.optString("id")) == false) goto L9;
        return r100;
    L9:
        JSONArray r102 = r100.optJSONArray("children");
        if (r102 != null) goto L12;
        return null;
    L12:
        if (r102.length() == 0) goto L30;
        int r103 = r102.length();
        int r104 = 0;
    L15:
        if (r104 >= r103) goto L31;
        if ((r102.get(r104) instanceof JSONObject) == false) goto L21;
        JSONObject r105 = j((JSONObject) r102.get(r104), r101);
        if (r105 == null) goto L21;
        return r105;
    L21:
        r104 = r104 + 1;
        goto L15
    L31:
        return null;
    L30:
        return null;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) {
        x3 r102 = (x3) r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        GetGameCPDetailPageNodeDataResultModel.a r103 = new GetGameCPDetailPageNodeDataResultModel.a();
        ArrayList r104 = new ArrayList();
        xr.f r105 = (xr.f) xr.s.a(xr.f.class);
        String r106 = null;
        if (r105 == null) goto L5;
        JSONObject r107 = r105.Q1();
    L6:
        List<String> r108 = r102.a();
        if (r108 == null) goto L21;
        Iterator<T> r109 = r108.iterator();
    L10:
        if (r109.hasNext() == false) goto L21;
        JSONObject r110 = j(r107, new Regex((String) r109.next()));     // Catch: Throwable -> L19
        if (r110 == null) goto L16;
        String r111 = r110.toString();     // Catch: Throwable -> L19
        if (r111 == null) goto L16;
    L17:
        r104.add(r111);     // Catch: Throwable -> L19
    L16:
        r111 = "";
    L19:
        th = move-exception;
        yr.b.b(6, "GetGameCPDetailPageNodeDataMethod", "[getNodeFromRegex] error " + th.getMessage() + '.');
    L21:
        xr.f r112 = (xr.f) xr.s.a(xr.f.class);
        if (r112 == null) goto L24;
        r106 = r112.L0();
    L24:
        r103.a(r106);
        r103.b(r104);
        GetGameCPDetailPageNodeDataResultModel r113 = new GetGameCPDetailPageNodeDataResultModel();
        r113.a(GetGameCPDetailPageNodeDataResultModel.Code.Success);
        r113.b(r103);
        Unit r114 = Unit.INSTANCE;
        finishWithResult(r113);
        return;
    L5:
        r107 = null;
        goto L6
    }
}
