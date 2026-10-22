package com.baidu.mshield.x0.l;

import com.baidu.mshield.x0.d.d;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public String f8441a;

    /* renamed from: b, reason: collision with root package name */
    public String f8442b;

    /* renamed from: c, reason: collision with root package name */
    public String f8443c;

    /* renamed from: d, reason: collision with root package name */
    public String f8444d;

    /* renamed from: e, reason: collision with root package name */
    public String f8445e;

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.f8441a = jSONObject.optString("0");
            bVar.f8443c = jSONObject.optString("1");
            bVar.f8444d = jSONObject.optString("2");
            bVar.f8445e = jSONObject.optString("3");
            bVar.f8442b = jSONObject.optString("4");
            return bVar;
        } catch (Throwable th) {
            d.a(th);
            return null;
        }
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
            d.a(th);
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        String str = this.f8444d;
        if (str == null) {
            if (bVar.f8444d != null) {
                return false;
            }
        } else if (!str.equals(bVar.f8444d)) {
            return false;
        }
        String str2 = this.f8445e;
        if (str2 == null) {
            if (bVar.f8445e != null) {
                return false;
            }
        } else if (!str2.equals(bVar.f8445e)) {
            return false;
        }
        String str3 = this.f8442b;
        if (str3 == null) {
            if (bVar.f8442b != null) {
                return false;
            }
        } else if (!str3.equals(bVar.f8442b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int iHashCode = 1;
        try {
            String str = this.f8444d;
            int iHashCode2 = 0;
            int iHashCode3 = ((str == null ? 0 : str.hashCode()) + 31) * 31;
            String str2 = this.f8445e;
            iHashCode = (str2 == null ? 0 : str2.hashCode()) + iHashCode3;
            int i4 = iHashCode * 31;
            String str3 = this.f8442b;
            if (str3 != null) {
                iHashCode2 = str3.hashCode();
            }
            return i4 + iHashCode2;
        } catch (Throwable th) {
            d.a(th);
            return iHashCode;
        }
    }
}
