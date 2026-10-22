package com.baidu.lbsapi.auth;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
class e {

    /* renamed from: a, reason: collision with root package name */
    private Context f4922a;

    /* renamed from: b, reason: collision with root package name */
    private HashMap f4923b = null;

    /* renamed from: c, reason: collision with root package name */
    private a f4924c = null;

    public interface a {
        void a(Object obj);
    }

    public e(Context context) {
        this.f4922a = context;
    }

    private HashMap a(HashMap map) {
        HashMap map2 = new HashMap();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String string = ((String) it.next()).toString();
            map2.put(string, map.get(string));
        }
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) throws JSONException {
        JSONObject jSONObject;
        if (str == null) {
            str = "";
        }
        try {
            jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
            try {
                jSONObject.put("status", -1);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        a aVar = this.f4924c;
        if (aVar != null) {
            aVar.a(jSONObject.toString());
        }
    }

    public void a(HashMap map, String str, int i4, String str2, String str3, a aVar) {
        this.f4923b = a(map);
        this.f4924c = aVar;
        new Thread(new f(this, str, i4, str2, str3)).start();
    }
}
