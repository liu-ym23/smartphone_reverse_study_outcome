package com.bytedance.android.gamecp.hybrid_impl.jsb;

import android.text.TextUtils;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
@XBridgeMethod(biz = "webcast", name = "game.getClientSetting")
public final class n2 extends i<o2, GameGetClientSettingResultModel> {
    public n2() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r101) throws Exception {
        o2 r102 = (o2) r100;
        GameGetClientSettingResultModel r103 = new GameGetClientSettingResultModel();
        JsonObject r104 = new JsonObject();
        if (TextUtils.isEmpty(r102.a()) == false) goto L5;
        r103.a(GameGetClientSettingResultModel.Code.Failed);
        finishWithResult(r103);
        return;
    L5:
        String r105 = r102.a();
        Gson r106 = GsonHelper.get();
        Object r107 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r105);
        if (r107 != null) goto L8;
    L21:
        r103.b(r104);
        r103.a(GameGetClientSettingResultModel.Code.Success);
        finishWithResult(r103);
        return;
    L8:
        if ((r107 instanceof JSONObject) == false) goto L11;
        JsonElement r108 = GsonProtectorUtils.toJsonTree(r106, GsonProtectorUtils.fromJson(r106, ((JSONObject) r107).toString(), Object.class));
    L20:
        r104.add(r105, r108);
        goto L21
    L11:
        if ((r107 instanceof JSONArray) == false) goto L14;
        r108 = GsonProtectorUtils.toJsonTree(r106, GsonProtectorUtils.fromJson(r106, ((JSONArray) r107).toString(), new m2().getType()));
        goto L20
    L14:
        if ((r107 instanceof Boolean) == true) goto L16;
        r108 = GsonProtectorUtils.toJsonTree(r106, r107);
        goto L20
    L16:
        if (((Boolean) r107).booleanValue() == false) goto L18;
        r108 = GsonProtectorUtils.toJsonTree(r106, 1);
        goto L20
    L18:
        r108 = GsonProtectorUtils.toJsonTree(r106, 0);
        goto L20
    }
}
