package W0;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.services.apm.api.IHttpService;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import g1.AbstractC1451a;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import k1.AbstractC1620b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class k {
    public static final HashMap g = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public String f1482a;
    public volatile boolean b;
    public int c;
    public String d;
    public Boolean e;
    public List f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v8, types: [java.util.Map] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static F0.d a(java.lang.String r7, byte[] r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 269
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W0.k.a(java.lang.String, byte[]):F0.d");
    }

    public static k b(n nVar) {
        HashMap map = g;
        if (map.containsKey(nVar)) {
            return (k) map.get(nVar);
        }
        k kVar = new k();
        kVar.d = null;
        kVar.f = nVar.b();
        map.put(nVar, kVar);
        return (k) map.get(nVar);
    }

    public static String d(String str, byte[] bArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(2, secretKeySpec);
            String str2 = new String(cipher.doFinal(Base64.decode(bArr, 0)));
            int iIndexOf = str2.indexOf("$");
            return iIndexOf != -1 ? str2.substring(0, iIndexOf) : str2;
        } catch (Throwable th) {
            if (!AbstractC1451a.f4467a) {
                return "";
            }
            H4.o.g(S0.a.f1163a, "decodeData", th);
            return "";
        }
    }

    public static JSONObject e(B.b bVar) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(new String(bVar.c));
            Map map = bVar.b;
            if (map == null || map.isEmpty()) {
                str = null;
            } else {
                str = (String) map.get("ran");
                if (TextUtils.isEmpty(str)) {
                    str = (String) map.get("Ran");
                }
            }
            try {
                String strOptString = jSONObject.optString(SettingsConfig.KEY_DATA);
                boolean zIsEmpty = true;
                if (!strOptString.isEmpty()) {
                    if (TextUtils.isEmpty(str)) {
                        jSONObject = new JSONObject(new String(strOptString.getBytes()));
                    } else {
                        String strD = d(str, strOptString.getBytes());
                        jSONObject = new JSONObject(strD);
                        zIsEmpty = true ^ TextUtils.isEmpty(strD);
                    }
                }
                if (!S0.b.E0(jSONObject)) {
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("configs");
                    if (!S0.b.E0(jSONObjectOptJSONObject) && ((M0.g) AbstractC1620b.a(M0.g.class)) != null && H.h.g()) {
                        L0.d.f925a.b(new H.f(1, jSONObjectOptJSONObject));
                    }
                }
                if (zIsEmpty) {
                    return jSONObject;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("message", "success");
                return jSONObject2;
            } catch (Throwable unused) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("message", "success");
                return jSONObject3;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public final String c() {
        List list = this.f;
        if (!TextUtils.isEmpty(this.f1482a)) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            try {
                return "https://" + this.f1482a + new URL((String) list.get(0)).getPath();
            } catch (Throwable unused) {
                return null;
            }
        }
        if (!TextUtils.isEmpty(this.d)) {
            return this.d;
        }
        if (this.b) {
            this.c++;
        }
        int size = list.size();
        int i = this.c;
        if (size > i && i >= 0) {
            return (String) list.get(i);
        }
        this.c = 0;
        return (String) list.get(0);
    }

    public final boolean f(byte[] bArr) {
        boolean zEquals;
        long j5;
        boolean z10;
        Object obj;
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        try {
            String strC = c();
            F0.d dVarA = a(strC, bArr);
            if (AbstractC1451a.f4467a) {
                H4.o.f(S0.a.f1163a, "sendLog createRequest: origin Bytes=" + bArr.length + " compressed Bytes=" + dVarA.c.length + " url=" + dVarA.f532a + " headers=" + dVarA.b + " body:" + new JSONObject(new String(bArr)).toString());
            }
            B.b bVarDoPost = ((IHttpService) AbstractC1620b.a(IHttpService.class)).doPost(dVarA.f532a, dVarA.c, dVarA.b);
            if (AbstractC1451a.f4467a) {
                String str = S0.a.f1163a;
                StringBuilder sb = new StringBuilder("http result:");
                if (bVarDoPost == null) {
                    obj = -1;
                } else {
                    obj = bVarDoPost.f171a + " header:" + bVarDoPost.b;
                }
                sb.append(obj);
                H4.o.f(str, sb.toString());
            }
            this.f1482a = null;
            this.d = null;
            if (bVarDoPost != null && bVarDoPost.f171a > 0) {
                this.b = false;
                int i = bVarDoPost.f171a;
                if (500 <= i && i <= 600) {
                    Boolean bool = this.e;
                    if (bool != null && bool.booleanValue()) {
                        f.f1476a.c();
                    }
                    this.e = Boolean.TRUE;
                    return false;
                }
                JSONObject jSONObjectE = e(bVarDoPost);
                if (jSONObjectE != null && bVarDoPost.f171a == 200) {
                    String strOptString = jSONObjectE.optString("message");
                    String strOptString2 = jSONObjectE.optString("redirect");
                    long jOptLong = jSONObjectE.optLong("delay");
                    if ("success".equals(strOptString)) {
                        g gVar = f.f1476a;
                        gVar.i = true;
                        gVar.m = false;
                        gVar.f1477a = 0;
                        gVar.b = 0;
                        gVar.c = 0;
                        gVar.d = 0;
                        gVar.e = 0;
                        gVar.k.set(0L);
                        gVar.f1478j.set(0L);
                        this.d = strC;
                        this.e = Boolean.FALSE;
                        z10 = true;
                        j5 = 0;
                        zEquals = false;
                    } else {
                        this.e = Boolean.TRUE;
                        zEquals = "drop data".equals(strOptString);
                        if (AbstractC1451a.f4467a) {
                            j5 = 0;
                            H4.o.f(S0.a.f1163a, "responseMessage:" + strOptString);
                        } else {
                            j5 = 0;
                        }
                        z10 = false;
                    }
                    try {
                        if (AbstractC1451a.f4467a) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("RESPONSE_DATA_URL", dVarA.f532a);
                            if (bVarDoPost.b != null) {
                                jSONObject.put("RESPONSE_DATA_HEADERS", new JSONObject((Map<?, ?>) bVarDoPost.b));
                            }
                            jSONObject.put("RESPONSE_DATA_BODY_TEXT", jSONObjectE);
                            Iterator it = k0.a.b(bArr).iterator();
                            while (it.hasNext()) {
                                JSONObject jSONObject2 = (JSONObject) it.next();
                                try {
                                    JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
                                    JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("DATA_DOCTOR");
                                    if (jSONObjectOptJSONObject != null) {
                                        jSONObject3.put("DATA_DOCTOR", jSONObjectOptJSONObject);
                                    }
                                    k0.a.c("DATA_SEND_RESPONSE", jSONObject3);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    JSONObject jSONObjectOptJSONObject2 = jSONObjectE.optJSONObject("downgrade_rule");
                    if (jSONObjectOptJSONObject2 != null) {
                        U7.a.f1277a.a(C5.b.a(jSONObjectOptJSONObject2), true);
                    }
                    this.f1482a = strOptString2;
                    if (jOptLong > j5) {
                        g gVar2 = f.f1476a;
                        gVar2.e = (int) (jOptLong * 1000);
                        gVar2.i = false;
                        gVar2.f1478j.set(System.currentTimeMillis());
                    }
                    if (zEquals) {
                        g gVar3 = f.f1476a;
                        gVar3.c();
                        gVar3.m = true;
                        gVar3.k.set(System.currentTimeMillis());
                        Map map = bVarDoPost.b;
                        if (map != null) {
                            d.f1474a.d = (String) map.get("x-tt-logid");
                        }
                        d.f1474a.e = System.currentTimeMillis();
                    } else {
                        f.f1476a.m = false;
                    }
                    return z10;
                }
                this.e = Boolean.TRUE;
                return false;
            }
            this.b = true;
            Boolean bool2 = this.e;
            if (bool2 != null && bool2.booleanValue()) {
                f.f1476a.d();
            }
            this.e = Boolean.TRUE;
            return false;
        } catch (Throwable th2) {
            H4.o.g(S0.a.f1163a, "sendLog failed.", th2);
            return false;
        }
    }
}
