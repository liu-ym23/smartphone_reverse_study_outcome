package com.stepos.statsrpk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b3.C0563a;
import com.stepos.minor.Minor;
import f3.C0720b;
import g3.C0742e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class i {
    public static void a(Context context, String str, b bVar) throws JSONException {
        C0742e.c("RpkUxipConfig", "parseAppInfo");
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences.Editor editorH = new C0720b(context, "statsrpk_config_" + bVar.f15938a).h();
        if (!TextUtils.isEmpty(jSONObject.getString("key"))) {
            String string = jSONObject.getString("key");
            bVar.f15942e = string;
            editorH.putString("appKey", string);
        }
        if (!TextUtils.isEmpty(jSONObject.getString("primaryPackageName"))) {
            String string2 = jSONObject.getString("primaryPackageName");
            bVar.f15941d = string2;
            editorH.putString("apkPkgName", string2);
        }
        editorH.commit();
    }

    public static void b(Context context, String str, b bVar) throws JSONException {
        C0742e.c("RpkUxipConfig", "parseConfig");
        JSONObject jSONObject = new JSONObject(str);
        SharedPreferences.Editor editorH = new C0720b(context, "statsrpk_config_" + bVar.f15938a).h();
        editorH.putInt("version", jSONObject.getInt("version"));
        editorH.putBoolean("active", jSONObject.getBoolean("active"));
        editorH.putString("getTime", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        editorH.commit();
        HashMap map = new HashMap();
        JSONArray jSONArray = jSONObject.getJSONArray("events");
        String str2 = BuildConfig.FLAVOR;
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
            String string = jSONObject2.getString(Minor.COLUMN_NAME);
            boolean z5 = jSONObject2.getBoolean("active");
            boolean z6 = jSONObject2.getBoolean("realtime");
            boolean z7 = jSONObject2.getBoolean("neartime");
            map.put(string, new C0563a(string, z5, z6, z7));
            int i6 = !z5 ? 0 : (z6 || z7) ? 2 : 1;
            if (!string.contains(":") && !string.contains(",")) {
                str2 = str2 + string + ":" + i6;
                if (i5 < jSONArray.length() - 1) {
                    str2 = str2 + ",";
                }
            }
        }
        editorH.putString("event_filters", str2);
        editorH.commit();
    }
}
