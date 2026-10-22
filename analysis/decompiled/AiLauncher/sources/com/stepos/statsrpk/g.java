package com.stepos.statsrpk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.statsapp.v3.utils.SharedPreferencesHelper;
import com.stepos.statsapp.v3.utils.log.Logger;
import io.ktor.sse.ServerSentEventKt;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g {
    public static void a(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        Logger.d("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences.Editor editorEdit = new SharedPreferencesHelper(context, "statsrpk_config_" + rpkInfo.f31011a).edit();
        if (!TextUtils.isEmpty(jSONObject.getString("key"))) {
            String string = jSONObject.getString("key");
            rpkInfo.f31015e = string;
            editorEdit.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            rpkInfo.f31014d = string2;
            editorEdit.putString("apkPkgName", string2);
        }
        editorEdit.commit();
    }

    public static void b(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        Logger.d("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences.Editor editorEdit = new SharedPreferencesHelper(context, "statsrpk_config_" + rpkInfo.f31011a).edit();
        editorEdit.putInt("version", jSONObject.getInt("version"));
        editorEdit.putBoolean("active", jSONObject.getBoolean("active"));
        editorEdit.putString(UxipConstants.f30686y, new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorEdit.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String str2 = "";
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            String string = jSONObject2.getString("name");
            boolean z10 = jSONObject2.getBoolean("active");
            boolean z11 = jSONObject2.getBoolean("realtime");
            boolean z12 = jSONObject2.getBoolean(UxipConstants.f30651O);
            map.put(string, new com.stepos.statsapp.v3.lib.plugin.tracker.a(string, z10, z11, z12));
            int i11 = !z10 ? 0 : (z11 || z12) ? 2 : 1;
            if (!string.contains(ServerSentEventKt.COLON) && !string.contains(Const.STR_MART_COMMA)) {
                str2 = str2 + string + ServerSentEventKt.COLON + i11;
                if (i10 < jSONArray.length() - 1) {
                    str2 = str2 + Const.STR_MART_COMMA;
                }
            }
        }
        editorEdit.putString("event_filters", str2);
        editorEdit.commit();
    }
}
