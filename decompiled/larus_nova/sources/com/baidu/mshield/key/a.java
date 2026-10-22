package com.baidu.mshield.key;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mshield.b.f.b;
import com.baidu.mshield.b.f.e;
import com.baidu.mshield.utility.d;
import java.security.PublicKey;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public class a {
    public static boolean a(Context r110) {
        JSONObject r100 = new JSONObject();     // Catch: Throwable -> L40
        String r101 = r110.getPackageName();     // Catch: Throwable -> L40
        r100.put("pkg", r101);     // Catch: Throwable -> L40
        PackageInfo r102 = r110.getPackageManager().getPackageInfo(r101, 64);     // Catch: Throwable -> L6
    L10:
        if (r102 == null) goto L29;
        PublicKey r103 = b.a(r102.applicationInfo.sourceDir);     // Catch: Throwable -> L40
        if (r103 != null) goto L23;
        Signature[] r104 = r102.signatures;     // Catch: Throwable -> L40
        if (r104 == null) goto L23;
        if (r104.length <= 0) goto L23;
        Signature r105 = r104[0];     // Catch: Throwable -> L40
        if (r105 == null) goto L23;
        r103 = b.a(r105);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L40
    L23:
        if (r103 == null) goto L27;
        byte[] r106 = r103.getEncoded();     // Catch: Throwable -> L40
        if (r106 == null) goto L28;
        com.baidu.mshield.utility.a.a(r110, r106);     // Catch: Throwable -> L40
        r100.put("sign", e.a(Base64.encodeToString(r106, 0).replace("\n", "").replace("\r", "")));     // Catch: Throwable -> L40
    L28:
        r100.put("app", r101);     // Catch: Throwable -> L40
    L30:
        String r107 = d.a(r110, com.baidu.mshield.utility.a.f(r110) + "p/1/auh", r100.toString(), false, true);     // Catch: Throwable -> L40
        StringBuilder r108 = new StringBuilder("auh res:");     // Catch: Throwable -> L40
        r108.append(r107);     // Catch: Throwable -> L40
        com.baidu.mshield.b.c.a.b(r108.toString());     // Catch: Throwable -> L40
        JSONObject r109 = new JSONObject(r107);     // Catch: Throwable -> L40
        if (r109.length() > 0) goto L33;
        return false;
    L33:
        if (r109.optInt("code") != 200) goto L50;
        String r111 = r109.optString("ak");     // Catch: Throwable -> L40
        String r112 = r109.optString("sk");     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r111) == false) goto L37;
        return false;
    L37:
        if (TextUtils.isEmpty(r112) == true) goto L52;
        com.baidu.mshield.utility.a.a(r111, r112);     // Catch: Throwable -> L40
        com.baidu.mshield.sharedpreferences.a.a(r110).d(r111, r112);     // Catch: Throwable -> L40
        return true;
    L52:
        return false;
    L50:
        return false;
    L27:
        r100.put("sign", "");     // Catch: Throwable -> L40
        goto L28
    L29:
        r100.put("sign", "");     // Catch: Throwable -> L40
        r100.put("app", "");     // Catch: Throwable -> L40
    L6:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);     // Catch: Throwable -> L40
        r102 = null;
    L40:
        th = move-exception;
        com.baidu.mshield.utility.a.a(th);
        return false;
    }
}
