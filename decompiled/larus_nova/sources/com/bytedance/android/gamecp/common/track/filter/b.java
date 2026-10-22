package com.bytedance.android.gamecp.common.track.filter;

import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.android.gamecp.host_api.util.gson.GsonHelper;
import com.bytedance.android.livesdk.schema.AudienceGamePromoteDetailActionHandler;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class b extends com.bytedance.android.gamecp.common.track.filter.a<zu.a> {

    public static final class a {
    }

    static {
    }

    public final String b() {
        JsonParser r100 = GsonHelper.a.f57436d;     // Catch: Exception -> L15
        Map<String, String> r101 = this.f56801a;     // Catch: Exception -> L15
        if (r101 == null) goto L6;
        String r102 = r101.get("ad_params");     // Catch: Exception -> L15
        if (r102 == null) goto L6;
    L7:
        JsonElement r103 = r100.parse(r102);     // Catch: Exception -> L15
        if (r103 == null) goto L12;
        JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        JsonElement r105 = r104.get("ad_id");     // Catch: Exception -> L15
    L13:
        return e(r105);
    L12:
        r105 = null;
    L6:
        r102 = SliceInitService.DEFAULT_SWITCH;
    L15:
        e = move-exception;
        yr.c.b("BizInfoFilter", e.toString());
        return "";
    }

    public final String c() {
        JsonParser r100 = GsonHelper.a.f57436d;     // Catch: Exception -> L15
        Map<String, String> r101 = this.f56801a;     // Catch: Exception -> L15
        if (r101 == null) goto L6;
        String r102 = r101.get("ad_params");     // Catch: Exception -> L15
        if (r102 == null) goto L6;
    L7:
        JsonElement r103 = r100.parse(r102);     // Catch: Exception -> L15
        if (r103 == null) goto L12;
        JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        JsonElement r105 = r104.get("creative_id");     // Catch: Exception -> L15
    L13:
        return e(r105);
    L12:
        r105 = null;
    L6:
        r102 = SliceInitService.DEFAULT_SWITCH;
    L15:
        e = move-exception;
        yr.c.b("BizInfoFilter", e.toString());
        return "";
    }

    public final String d() {
        JsonParser r100 = GsonHelper.a.f57436d;     // Catch: Exception -> L15
        Map<String, String> r101 = this.f56801a;     // Catch: Exception -> L15
        if (r101 == null) goto L6;
        String r102 = r101.get("ad_params");     // Catch: Exception -> L15
        if (r102 == null) goto L6;
    L7:
        JsonElement r103 = r100.parse(r102);     // Catch: Exception -> L15
        if (r103 == null) goto L12;
        JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        JsonElement r105 = r104.get("is_ad");     // Catch: Exception -> L15
    L13:
        return e(r105);
    L12:
        r105 = null;
    L6:
        r102 = SliceInitService.DEFAULT_SWITCH;
    L15:
        e = move-exception;
        yr.c.b("BizInfoFilter", e.toString());
        return "";
    }

    public final String f() {
        Map<String, String> r100 = this.f56801a;
        if (r100 == null) goto L6;
        String r101 = r100.get(AudienceGamePromoteDetailActionHandler.PARA_PROMOTER_SCENE);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "";
    }

    public final String g() {
        JsonParser r100 = GsonHelper.a.f57436d;     // Catch: Exception -> L15
        Map<String, String> r101 = this.f56801a;     // Catch: Exception -> L15
        if (r101 == null) goto L6;
        String r102 = r101.get("promote_scene_sub");     // Catch: Exception -> L15
        if (r102 == null) goto L6;
    L7:
        JsonElement r103 = r100.parse(r102);     // Catch: Exception -> L15
        if (r103 == null) goto L12;
        JsonObject r104 = r103.getAsJsonObject();     // Catch: Exception -> L15
        if (r104 == null) goto L12;
        JsonElement r105 = r104.get(BdpAppEventConstant.PARAMS_SUB_SCENE);     // Catch: Exception -> L15
    L13:
        return e(r105);
    L12:
        r105 = null;
    L6:
        r102 = SliceInitService.DEFAULT_SWITCH;
    L15:
        e = move-exception;
        yr.c.b("BizInfoFilter", e.toString());
        return "";
    }

    public b() {
    }

    public static String e(JsonElement r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if ((r100 instanceof JsonNull) == false) goto L7;
        return "";
    L7:
        if ((r100 instanceof JsonPrimitive) == false) goto L10;
        return ((JsonPrimitive) r100).getAsString();
    L10:
        if ((r100 instanceof JsonObject) == false) goto L13;
        return r100.toString();
    L13:
        if ((r100 instanceof JsonArray) == false) goto L16;
        return r100.toString();
    L16:
        return r100.toString();
    }
}
