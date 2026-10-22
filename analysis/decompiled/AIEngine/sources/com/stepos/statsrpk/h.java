package com.stepos.statsrpk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.stepos.core.download.ModelFlowMeta;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h {
    public static void a(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        ta.c.a("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f8050a;
        ta.c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        ta.c.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (!TextUtils.isEmpty(jSONObject.getString("key"))) {
            String string = jSONObject.getString("key");
            rpkInfo.f8054e = string;
            editorEdit.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            rpkInfo.f8053d = string2;
            editorEdit.putString("apkPkgName", string2);
        }
        editorEdit.commit();
    }

    public static void b(Context context, String str, RpkInfo rpkInfo) throws JSONException {
        ta.c.a("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        String str2 = "statsrpk_config_" + rpkInfo.f8050a;
        ta.c.d("SharedPreferencesHelper", "init SharedPreferences, name: " + str2);
        SharedPreferences sharedPreferences = context.getSharedPreferences(str2, 0);
        ta.c.a("SharedPreferencesHelper", str2 + " structure complete");
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putInt("version", jSONObject.getInt("version"));
        editorEdit.putBoolean(ModelFlowMeta.KEY_ACTIVE, jSONObject.getBoolean(ModelFlowMeta.KEY_ACTIVE));
        editorEdit.putString("getTime", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorEdit.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String strJ = "";
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            String string = jSONObject2.getString("name");
            boolean z = jSONObject2.getBoolean(ModelFlowMeta.KEY_ACTIVE);
            boolean z3 = jSONObject2.getBoolean("realtime");
            boolean z10 = jSONObject2.getBoolean("neartime");
            map.put(string, new oa.a(string, z, z3, z10));
            int i11 = !z ? 0 : (z3 || z10) ? 2 : 1;
            if (!string.contains(":") && !string.contains(",")) {
                strJ = strJ + string + ":" + i11;
                if (i10 < jSONArray.length() - 1) {
                    strJ = a0.a.j(strJ, ",");
                }
            }
        }
        editorEdit.putString("event_filters", strJ);
        editorEdit.commit();
    }
}
