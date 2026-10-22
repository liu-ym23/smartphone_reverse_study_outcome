package com.bytedance.android.live.browser.jsbridge.newmethods;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.browser.AnnieParamUtil;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.core.verify.utils.IIdentityVerifyService;
import com.bytedance.android.livesdk.config.tj;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.miui.easygo.constant.EasyGoConstant;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getClientSetting")
public final class ca extends com.bytedance.ies.web.jsbridge2.f<c, JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f63340a = false;

    public class a extends TypeToken<List<Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<List<Object>> {
        public b() {
        }
    }

    public static final class c {

        @SerializedName("key")
        public String key;

        @SerializedName("path")
        public String path;

        @SerializedName("type")
        public String type;

        public c() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    static {
        f63340a = com.bytedance.android.livesdk.config.d4.f119998a.getValue().booleanValue();
    }

    public ca() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final /* bridge */ /* synthetic */ void invoke(c r100, CallContext r101) throws Exception {
        j(r100, r101);
    }

    public final void j(c r110, CallContext r111) throws Exception {
        JsonObject r100 = new JsonObject();
        JsonObject r101 = new JsonObject();
        if (TextUtils.isEmpty(r110.key) == true) goto L5;
    L8:
        String r102 = r110.key;
        String r103 = r110.path;
        int r104 = 0;
        if (TextUtils.isEmpty(r103) == true) goto L69;
        if (TextUtils.isEmpty(r110.key) == true) goto L69;
        Object r112 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r102);
        String[] r113 = r103.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);
        Gson r105 = GsonHelper.get();
        int r106 = 0;
    L14:
        if (r106 >= r113.length) goto L53;
        String r107 = r113[r106];
        if ((r112 instanceof JSONObject) == false) goto L21;
        JSONObject r114 = (JSONObject) r112;
        if (r114.has(r107) == false) goto L51;
        r112 = r114.get(r107);
    L52:
        r106 = r106 + 1;
    L51:
        r112 = null;
        goto L53
    L21:
        if ((r112 instanceof JSONArray) == false) goto L27;
        JSONArray r115 = (JSONArray) r112;
        int r108 = r115.length();
        int r109 = CastIntegerProtector.parseInt(r107);
        if (r109 < 0) goto L51;
        if (r109 >= r108) goto L51;
        r112 = r115.get(r109);
        goto L52
    L27:
        if ((r112 instanceof String) == false) goto L52;
        String r116 = (String) r112;
        if (TextUtils.isEmpty(r116) == false) goto L110;
    L34:
        boolean r117 = false;
    L35:
        if (r117 == false) goto L40;
        JSONObject r118 = new JSONObject(r116);
        if (r118.has(r107) == false) goto L51;
        r112 = r118.get(r107);
        goto L52
    L40:
        if (TextUtils.isEmpty(r116) == false) goto L108;
    L45:
        boolean r119 = false;
    L46:
        if (r119 == false) goto L52;
        JSONArray r120 = new JSONArray(r116);
        int r121 = r120.length();
        int r122 = CastIntegerProtector.parseInt(r107);
        if (r122 < 0) goto L51;
        if (r122 >= r121) goto L51;
        r112 = r120.get(r122);
        goto L52
    L108:
        new JSONArray(r116);     // Catch: Exception -> L44
        r119 = true;
        goto L46
    L110:
        JsonUtil.parseObject(r116);     // Catch: Exception -> L33
        r117 = true;
    L53:
        if (r112 != null) goto L55;
    L106:
        r100.add("data", r101);
        finishWithResult(r100);
        return;
    L55:
        if ((r112 instanceof JSONObject) == false) goto L58;
        JsonElement r123 = GsonProtectorUtils.toJsonTree(r105, GsonProtectorUtils.fromJson(r105, ((JSONObject) r112).toString(), Object.class));
    L67:
        r101.add(r102 + "." + r103, r123);
        goto L106
    L58:
        if ((r112 instanceof JSONArray) == false) goto L61;
        r123 = GsonProtectorUtils.toJsonTree(r105, GsonProtectorUtils.fromJson(r105, ((JSONArray) r112).toString(), new a().getType()));
        goto L67
    L61:
        if ((r112 instanceof Boolean) == true) goto L63;
        r123 = GsonProtectorUtils.toJsonTree(r105, r112);
        goto L67
    L63:
        if (((Boolean) r112).booleanValue() == false) goto L65;
        r123 = GsonProtectorUtils.toJsonTree(r105, 1);
        goto L67
    L65:
        r123 = GsonProtectorUtils.toJsonTree(r105, 0);
    L69:
        if ("live_certification_setting_dic".equals(r102) == false) goto L87;
        IIdentityVerifyService r124 = (IIdentityVerifyService) jc1.k.f(IIdentityVerifyService.class);
        if (r124 != null) goto L73;
    L76:
        if (r124 == null) goto L106;
        JsonObject r125 = new JsonObject();
        String r126 = r124.getRealFaceIdentify();
        com.bytedance.android.livesdk.model.n r127 = tj.f121303a.getValue();
        if (r127 == null) goto L106;
        boolean r128 = r124.hostOCRSdkReady();
        r125.addProperty("live_certification_setting_face_identify", r126);
        if (r128 == false) goto L82;
        String r129 = r127.b();
    L83:
        r125.addProperty("live_certification_setting_info_input", r129);
        r125.addProperty("live_certification_setting_show_artificial_entrance", Boolean.valueOf(r127.a()));
        if (r128 == false) goto L86;
        r104 = r127.c();
    L86:
        r125.addProperty("live_certification_setting_manual_use_ocr", Integer.valueOf(r104));
        r101.add(r102, r125);
        goto L106
    L82:
        r129 = "default";
        goto L83
    L73:
        if (r124.supportTryPreload() == false) goto L76;
        r124.getRealFaceIdentifySync(r111.getContext(), true, new ba(this, r124, r101, r102, r100));
        return;
    L87:
        Gson r130 = GsonHelper.get();
        if (f63340a == false) goto L90;
        Object r131 = AnnieParamUtil.h(r102);
    L91:
        if (r131 == null) goto L106;
        if ((r131 instanceof JSONObject) == false) goto L96;
        JsonElement r132 = GsonProtectorUtils.toJsonTree(r130, GsonProtectorUtils.fromJson(r130, ((JSONObject) r131).toString(), Object.class));
    L105:
        r101.add(r102, r132);
        goto L106
    L96:
        if ((r131 instanceof JSONArray) == false) goto L99;
        r132 = GsonProtectorUtils.toJsonTree(r130, GsonProtectorUtils.fromJson(r130, ((JSONArray) r131).toString(), new b().getType()));
        goto L105
    L99:
        if ((r131 instanceof Boolean) == true) goto L101;
        r132 = GsonProtectorUtils.toJsonTree(r130, r131);
        goto L105
    L101:
        if (((Boolean) r131).booleanValue() == false) goto L103;
        r132 = GsonProtectorUtils.toJsonTree(r130, 1);
        goto L105
    L103:
        r132 = GsonProtectorUtils.toJsonTree(r130, 0);
        goto L105
    L90:
        r131 = SettingUtil.getRawValue("key_ttlive_sdk_setting", r102);
        goto L91
    L5:
        if (TextUtils.isEmpty(r110.path) == false) goto L8;
        finishWithResult(r100);
    }
}
