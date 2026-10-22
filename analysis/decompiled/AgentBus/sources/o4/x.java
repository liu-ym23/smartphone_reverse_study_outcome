package o4;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class x {
    public static JSONObject a(c cVar, String str, long j2, String str2, y yVar, String str3, String str4, Map map, a5.a aVar) throws JSONException, IOException {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        q7.k.e(cVar, "identity");
        String str5 = cVar.f7301a;
        q7.k.e(str, "publicKeyBase64Url");
        q7.k.e(str2, "nonce");
        Map map2 = yVar.f7692e;
        List list = yVar.f7691d;
        List list2 = yVar.f7690c;
        String str6 = yVar.f7688a;
        List list3 = yVar.f7689b;
        v vVar = yVar.f7693f;
        JSONObject jSONObject3 = new JSONObject();
        String str7 = vVar.f7657a;
        String str8 = vVar.f7659c;
        String str9 = vVar.f7660d;
        jSONObject3.put("id", str7);
        String str10 = vVar.f7658b;
        if (str10 != null) {
            jSONObject3.put("displayName", str10);
        }
        jSONObject3.put("version", "1.0.1");
        jSONObject3.put("platform", str9);
        jSONObject3.put("mode", str8);
        String str11 = vVar.f7657a;
        String str12 = (str3 == null || ga.k.t0(str3)) ? null : str3;
        q7.k.e(str5, "deviceId");
        q7.k.e(str11, "clientId");
        q7.k.e(str6, "role");
        q7.k.e(list3, "scopes");
        String strU0 = d7.r.U0(list3, ",", null, null, null, 62);
        if (str12 == null) {
            str12 = "";
        }
        byte[] bytes = d7.r.U0(d7.s.u0("v3", str5, str11, str8, str6, strU0, String.valueOf(j2), str12, str2, a.i(str9), a.i(null)), "|", null, null, null, 62).getBytes(ga.a.f4005a);
        q7.k.d(bytes, "getBytes(...)");
        String str13 = (String) aVar.invoke(bytes);
        if (str13 == null || ga.k.t0(str13)) {
            jSONObject = null;
        } else {
            jSONObject = new JSONObject();
            jSONObject.put("id", str5);
            jSONObject.put("publicKey", str);
            jSONObject.put("signature", str13);
            jSONObject.put("signedAt", j2);
            jSONObject.put("nonce", str2);
        }
        if (str3 == null || ga.k.t0(str3)) {
            jSONObject2 = null;
        } else {
            jSONObject2 = new JSONObject();
            jSONObject2.put("token", str3);
        }
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.put("minProtocol", 3);
        jSONObject4.put("maxProtocol", 3);
        jSONObject4.put("client", jSONObject3);
        if (!list2.isEmpty()) {
            jSONObject4.put("caps", new JSONArray((Collection) list2));
        }
        if (!list.isEmpty()) {
            jSONObject4.put("commands", new JSONArray((Collection) list));
        }
        if (!map2.isEmpty()) {
            JSONObject jSONObject5 = new JSONObject();
            for (Map.Entry entry : map2.entrySet()) {
                jSONObject5.put((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
            jSONObject4.put("permissions", jSONObject5);
        }
        jSONObject4.put("role", str6);
        if (!list3.isEmpty()) {
            jSONObject4.put("scopes", new JSONArray((Collection) list3));
        }
        if (jSONObject2 != null) {
            jSONObject4.put("auth", jSONObject2);
        }
        if (jSONObject != null) {
            jSONObject4.put("device", jSONObject);
        }
        JSONObject jSONObject6 = new JSONObject();
        if (str4 != null) {
            String str14 = !ga.k.t0(str4) ? str4 : null;
            if (str14 != null) {
                jSONObject6.put("deviceId", str14);
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            String str15 = (String) entry2.getKey();
            String str16 = (String) entry2.getValue();
            if (!ga.k.t0(str16)) {
                jSONObject6.put(str15, str16);
            }
        }
        if (jSONObject6.length() <= 0) {
            jSONObject6 = null;
        }
        if (jSONObject6 != null) {
            jSONObject4.put("stepclaw", jSONObject6);
        }
        Object obj = yVar.f7695h;
        if (obj != null) {
            jSONObject4.put("locale", obj);
        }
        String str17 = yVar.f7694g;
        if (str17 != null) {
            if (ga.k.t0(str17)) {
                str17 = null;
            }
            if (str17 != null) {
                jSONObject4.put("userAgent", str17);
            }
        }
        JSONObject jSONObject7 = new JSONObject();
        jSONObject7.put("type", "req");
        jSONObject7.put("id", "conn-" + j2);
        jSONObject7.put("method", "connect");
        jSONObject7.put("params", jSONObject4);
        return jSONObject7;
    }
}
