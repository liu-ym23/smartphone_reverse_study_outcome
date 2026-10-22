package com.amap.api.col.jmsl;

import android.text.TextUtils;
import com.autonavi.aps.amapapi.security.Encrypt;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.jmsl.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1606t0 {

    /* renamed from: b, reason: collision with root package name */
    public static final String f16954b = C1604s2.m("SRFZHZUVZT3BOa0ZiemZRQQ");

    /* renamed from: c, reason: collision with root package name */
    public static final String f16955c = C1604s2.m("FbGJzX3Nkaw");

    /* renamed from: d, reason: collision with root package name */
    public static final String f16956d = C1604s2.m("SWjJuYVh2eEMwSzVmNklFSmh0UXpVb2xtOVM4eU9Ua3E");

    /* renamed from: e, reason: collision with root package name */
    public static final String f16957e = C1604s2.m("FQU5EU0RLMTA");

    /* renamed from: f, reason: collision with root package name */
    public static final String f16958f = C1604s2.m("FMTAw");

    /* renamed from: g, reason: collision with root package name */
    public static boolean f16959g = false;

    /* renamed from: a, reason: collision with root package name */
    public String f16960a = "";

    public final String a(String str, String str2, String str3, String str4) {
        String strA;
        byte[] bArrDoFinal;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(C1604s2.m("LdGlk"), str);
            jSONObject.put(C1604s2.m("FZGl1"), str2);
            jSONObject.put(C1604s2.m("AZGl1Mg"), str3);
            jSONObject.put(C1604s2.m("EZGl1Mw"), str4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        String string = jSONObject.toString();
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        SecureRandom secureRandom = new SecureRandom();
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(C1604s2.m("EQUVT"));
            keyGenerator.init(128, secureRandom);
            strA = V.a(keyGenerator.generateKey().getEncoded());
        } catch (Throwable unused) {
            strA = null;
        }
        if (!TextUtils.isEmpty(strA)) {
            String strA2 = V.a(C1610u0.a((string + "\u0000").getBytes(), strA.getBytes()));
            if (!TextUtils.isEmpty(strA2)) {
                try {
                    PublicKey publicKeyE = r.e(c());
                    byte[] bytes = strA.getBytes("utf-8");
                    try {
                        Cipher cipher = Cipher.getInstance(C1604s2.m(Encrypt.KEY_TRANSFORMATION));
                        cipher.init(1, publicKeyE);
                        bArrDoFinal = cipher.doFinal(bytes);
                    } catch (Throwable unused2) {
                        bArrDoFinal = null;
                    }
                    return C1604s2.m("Fa2V5PQ") + URLEncoder.encode(V.a(bArrDoFinal)) + C1604s2.m("SJmRhdGE9") + URLEncoder.encode(strA2);
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }

    public final synchronized Map<String, String> b() {
        if (f16959g) {
            return null;
        }
        f16959g = true;
        HashMap map = new HashMap();
        map.put(C1604s2.m("FZW50"), C1604s2.m("FMg"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append(C1604s2.m("SY2hhbm5lbD0"));
        String str = f16955c;
        sb2.append(str);
        sb2.append(C1604s2.m("SJmRpdj0"));
        String str2 = f16957e;
        sb2.append(str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(str2);
        stringBuffer.append(C1604s2.m("FQA"));
        stringBuffer.append(f16956d);
        String strC = L1.c(stringBuffer.toString());
        sb2.append(C1604s2.m("FJnNpZ249"));
        sb2.append(strC.toUpperCase(Locale.US));
        sb2.append(C1604s2.m("SJm91dHB1dD1qc29u") + "\u0000");
        map.put(C1604s2.m("FaW4"), V.a(C1610u0.a(sb2.toString().getBytes(), f16954b.getBytes())));
        map.put(C1604s2.m("Sa2V5dA"), f16958f);
        return map;
    }

    public final String c() {
        if (!TextUtils.isEmpty(this.f16960a)) {
            return this.f16960a;
        }
        String strN = C1604s2.n(C1568j1.b("TUpJaVFGNk5LXHtSX1ZwQlRiV1VVZmtYWU1haV1hYWHCiXJtZcKLdmp8wpFewo1/wphwwoFzZmR8aWp6X2k6XsKDwoF+WGbChGdAScKLwoVXfmNxYEvCjcKLSG7CjGNvwoZtVFZ7WMKXYMKfwo5dZcKHfzZXUG85X0hNOVJrb2U8ZlJGW8KCe8KOV8KQWllrcGrCjcKIT25lUHPCicKGVsKKeG5fwp56XsKbc8KJbUVYR0pqU09gfE5/WT5YeHNAwoDCh1Z4V8KQT3JQYmxQbcKYwpFxdG/Ci3rCmMKQwop+YVbCmWFxwpxBdW07Zjp/ODlAbcKEY1pQwoJowohbV1VmV1laWmtcYGbClXfCk2NvesKdwohdWFnCol/CjWTCmMKicG1ENnAvPFtpcXtfclhfXsKAwolgRWNbS29OwpFafV3CkMKLTcKCwolrU3DCmGnCmX9wdsKPcXDCg3LCnFpGcDVTeTxNWW07bXJePVRfQn3ChGNraFhbwpNcwpXChMKNaFVjeVF8wojChm9YbmvChGDCmHvChGVQWjo0Z3o9djleOztWcVxSfWE9woLChkZdcGTCgVzCjMKUVE12wpV5bcKVwprCnntZworCgsKfwpHCksKnwpHClURURW9YaDtwXU1bck5YX3hSVFZUYlxKWFlua1xeYm9jU8KDa3ZrwpZ5am9Za3jCknR3fA"));
        StringBuffer stringBuffer = new StringBuffer();
        for (int i10 = 0; i10 < strN.length(); i10++) {
            stringBuffer.append((char) (strN.charAt(i10) - (i10 % 48)));
        }
        String string = stringBuffer.toString();
        StringBuffer stringBuffer2 = new StringBuffer();
        for (int i11 = 0; i11 < string.length() / 2; i11++) {
            stringBuffer2.append((char) ((string.charAt(i11) + string.charAt((string.length() - 1) - i11)) / 2));
        }
        String string2 = stringBuffer2.toString();
        this.f16960a = string2;
        return string2;
    }
}
