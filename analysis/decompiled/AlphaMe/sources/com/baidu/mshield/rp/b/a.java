package com.baidu.mshield.rp.b;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f8293a;

    /* renamed from: b, reason: collision with root package name */
    public String f8294b;

    /* renamed from: c, reason: collision with root package name */
    public String f8295c;

    /* renamed from: d, reason: collision with root package name */
    public String f8296d;

    /* renamed from: e, reason: collision with root package name */
    public String f8297e;

    public static String a(a aVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0", aVar.f8293a);
            jSONObject.put("1", aVar.f8295c);
            jSONObject.put("2", aVar.f8296d);
            jSONObject.put("3", aVar.f8297e);
            jSONObject.put("4", aVar.f8294b);
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        return jSONObject.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f8296d;
        if (str == null) {
            if (aVar.f8296d != null) {
                return false;
            }
        } else if (!str.equals(aVar.f8296d)) {
            return false;
        }
        String str2 = this.f8297e;
        if (str2 == null) {
            if (aVar.f8297e != null) {
                return false;
            }
        } else if (!str2.equals(aVar.f8297e)) {
            return false;
        }
        String str3 = this.f8294b;
        if (str3 == null) {
            if (aVar.f8294b != null) {
                return false;
            }
        } else if (!str3.equals(aVar.f8294b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 0;
        try {
            String str = this.f8296d;
            int iHashCode2 = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f8297e;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.f8294b;
            if (str3 != null) {
                iHashCode = str3.hashCode();
            }
            return iHashCode3 + iHashCode;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return 0;
        }
    }

    public static a a(String str) {
        a aVar = new a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar.f8293a = jSONObject.optString("0");
            aVar.f8295c = jSONObject.optString("1");
            aVar.f8296d = jSONObject.optString("2");
            aVar.f8297e = jSONObject.optString("3");
            aVar.f8294b = jSONObject.optString("4");
            return aVar;
        } catch (Throwable th) {
            com.baidu.mshield.utility.a.a(th);
            return null;
        }
    }
}
