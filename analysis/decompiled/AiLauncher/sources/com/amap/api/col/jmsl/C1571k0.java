package com.amap.api.col.jmsl;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.jmsl.S0;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1571k0 implements S0.d {

    /* renamed from: a, reason: collision with root package name */
    public C1606t0 f16701a = new C1606t0();

    @Override // com.amap.api.col.jmsl.S0.d
    public final String a() {
        String str = C1606t0.f16954b;
        return null;
    }

    @Override // com.amap.api.col.jmsl.S0.d
    public final Map<String, String> b() {
        return this.f16701a.b();
    }

    @Override // com.amap.api.col.jmsl.S0.d
    public final s7 c(byte[] bArr, Map<String, String> map) {
        return new T0(bArr, map);
    }

    @Override // com.amap.api.col.jmsl.S0.d
    public final String a(String str, String str2, String str3, String str4) {
        return this.f16701a.a(str, str2, str3, str4);
    }

    @Override // com.amap.api.col.jmsl.S0.d
    public final String b(Context context, String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt(C1604s2.m("UY29kZQ")) != 1) {
                return "";
            }
            String strOptString = new JSONObject(jSONObject.optString(C1604s2.m("FZGF0YQ"))).optString(C1604s2.m("FYWRpdQ"));
            if (TextUtils.isEmpty(strOptString)) {
                return "";
            }
            E.a(context).c(strOptString);
            return strOptString;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}
