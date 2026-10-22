package com.bytedance.bdtracker;

import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.applog.network.RangersHttpException;
import com.bytedance.applog.picker.DomSender;
import com.stepos.pps.data.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class r3 extends z3 {
    public r3(d dVar) {
        super(dVar);
    }

    public JSONObject a(String str, String str2, String str3, String str4, List<DomSender.a> list) {
        String str5;
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                if (i == 0) {
                    jSONObject3 = z3.a(str2, str3);
                    jSONObject.put("header", jSONObject3);
                    jSONObject.put("img", list.get(i).a);
                    jSONObject.put("pages", list.get(i).b);
                } else {
                    jSONObject2.put("header", jSONObject3);
                    jSONObject2.put("img", list.get(i).a);
                    jSONObject2.put("pages", list.get(i).b);
                    jSONArray.put(jSONObject2);
                }
                jSONObject3.put("width", list.get(i).c);
                jSONObject3.put("height", list.get(i).d);
            }
            jSONObject.put("extra", jSONArray);
        } catch (Throwable th) {
            LoggerImpl.global().error(Collections.singletonList("PickerApi"), "Request handle failed", th, new Object[0]);
        }
        HashMap<String, String> mapA = g5.a((HashMap<String, String>) new HashMap(2), this.b);
        mapA.put("Cookie", str4);
        try {
            str5 = new String(this.b.getNetClient().execute((byte) 1, str + "/simulator/mobile/layout", jSONObject, mapA, (byte) 0, true, Constants.LOGCAT_MAX_LINES));
        } catch (RangersHttpException unused) {
            str5 = null;
        }
        if (r.c(str5)) {
            return null;
        }
        try {
            return new JSONObject(str5);
        } catch (JSONException e) {
            LoggerImpl.global().error(Collections.singletonList("PickerApi"), "JSON handle failed", e, new Object[0]);
            return null;
        }
    }
}
